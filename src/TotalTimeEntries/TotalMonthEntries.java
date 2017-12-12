package TotalTimeEntries;

import Exceptions.WeekNotFoundException;
import ExpenceEntries.OtherExpenceEntry;
import WorkWithData.WorkWithEntryData;
import WorkWithData.WorkWithTimeData;
import XMLLibrary.DateHelper;
import XMLLibrary.XMLReaderHelpers;
import XMLLibrary.XMLWriterHelpers;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;

import static XMLLibrary.XMLWriterHelpers.*;

/**
 * Created by Master on 23.10.2017.
 */

public class TotalMonthEntries extends TotalTimeEntry {

    private ArrayList<TotalDayEntries> allDayEntriesInMonth = new ArrayList<TotalDayEntries>();
    private ArrayList<TotalWeekEntries> allWeekEntriesInMonth = new ArrayList<TotalWeekEntries>();

    private LocalDate beggingDate;
    private LocalDate endDate;

    private Double averageMoneySpent;


    public TotalMonthEntries() {}

    public TotalMonthEntries(LocalDate date) {
        Integer year = date.getYear();
        Integer month = date.getMonth().getValue();

        this.beggingDate = LocalDate.of(year, month, XMLWriterHelpers.FIRST_DAY);

        LocalDate dateEnd;

        if(Arrays.asList(XMLWriterHelpers.FIRST_LAST_DAY_MONTHS).contains(month)) {
            dateEnd = LocalDate.of(year, month, XMLWriterHelpers.FIRST_DAY);
        }
        else if(month.equals(FEBRUARY_INDEX)) {
            try {
                dateEnd = LocalDate.of(year, month, XMLWriterHelpers.FEBRUARY_LAST_DAY);
            } catch (DateTimeException e) {
                dateEnd = LocalDate.of(year, month, XMLWriterHelpers.FEBRUARY_LAST_DAY + 1);
            }
        }
        else {
            dateEnd = LocalDate.of(year, month, XMLWriterHelpers.SECOND_LAST_DAY);
        }

        this.endDate = dateEnd;

        if(month.equals(FEBRUARY_INDEX)) {
            for(int i = 0; i < AMOUNT_OF_WEEKS_IN_FEBRUARY; i++) {
                LocalDate firstWeekDay = LocalDate.of(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2]);
                LocalDate secondWeekDay = LocalDate.of(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2 + 1]);
                this.addWeek(XMLReaderHelpers.converFromXMLWeek(createEmptyWeek(firstWeekDay, secondWeekDay)));
            }
        }
        else {
            for(int i = 0; i < AMOUNT_OF_WEEKS - 1; i++) {
                LocalDate firstWeekDay = LocalDate.of(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2]);
                LocalDate secondWeekDay = LocalDate.of(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2 + 1]);
                this.addWeek(XMLReaderHelpers.converFromXMLWeek(createEmptyWeek(firstWeekDay, secondWeekDay)));
            }
            LocalDate firstWeekDay = LocalDate.of(year, month, 29);
            LocalDate secondWeekDay;
            if(getEndDate().getDayOfMonth() == 30) {
                secondWeekDay = LocalDate.of(year, month, 30);
            }
            else {
                secondWeekDay = getEndDate();
            }
            this.addWeek(XMLReaderHelpers.converFromXMLWeek(createEmptyWeek(firstWeekDay, secondWeekDay)));

            for(TotalWeekEntries tempWeek : this.allWeekEntriesInMonth) {
                for(int i = 0; i < tempWeek.getAllDayEntriesInWeek().size(); i++) {
                    allDayEntriesInMonth.add(tempWeek.getCertainDay(i));
                }
            }
        }
    }

    public TotalMonthEntries(ArrayList<TotalWeekEntries> weekEntries, LocalDate beggingDate, LocalDate endDate) {
        boolean worthAddingEntries = WorkWithTimeData.getAllMoneySpentTotalTime(weekEntries) != 0.0;

        this.allWeekEntriesInMonth = weekEntries;
        for(TotalWeekEntries tempWeek : weekEntries) {
            for(int i = 0; i < weekEntries.size(); i++) {
                allDayEntriesInMonth.add(tempWeek.getCertainDay(i));
            }
        }

        if(worthAddingEntries) {
            countAllMoneySpent();
            setSimpleEntries();
        }

        this.entriesAmount = this.simpleEntries.size();
        this.beggingDate = beggingDate;
        this.endDate = endDate;

        if(worthAddingEntries) {
            countAverageMoneySpent();
        }
    }

    @Override
    public void countAllMoneySpent() {
        this.allMoneySpent = 0.0;
        for(int i = 0; i < allDayEntriesInMonth.size(); i++) {
            this.allMoneySpent += this.allDayEntriesInMonth.get(i).getAllMoneySpent();
        }
    }

    public void countAverageMoneySpent(){
        this.averageMoneySpent = this.allMoneySpent / this.entriesAmount;
    }

    public ArrayList<TotalDayEntries> getAllDayEntriesInMonth() {
        return allDayEntriesInMonth;
    }

    public ArrayList<TotalWeekEntries> getAllWeekEntriesInMonth() {
        return allWeekEntriesInMonth;
    }

    private void setSimpleEntries() {
        for(int i = 0; i < this.allWeekEntriesInMonth.size(); i++) {
            this.simpleEntries.addAll(this.allWeekEntriesInMonth.get(i).getSimpleEntries());
        }
    }

    @Override
    public ArrayList<OtherExpenceEntry> getSimpleEntries() {
        this.setSimpleEntries();
        return this.simpleEntries;
    }

    @Override
    public Double getAllMoneySpent() {
        return allMoneySpent;
    }

    public LocalDate getBeggingDate() {
        return beggingDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void addWeek(TotalWeekEntries weekToAdd) {
        this.allWeekEntriesInMonth.add(weekToAdd);
        if(weekToAdd.getAllMoneySpent() != 0) {
            countAllMoneySpent();
            countAverageMoneySpent();
            setSimpleEntries();
        }
    }

    public TotalWeekEntries getCertainWeek(LocalDate date) {
        TotalWeekEntries neededWeek = new TotalWeekEntries();
        try {
            for(TotalWeekEntries tempWeek : this.allWeekEntriesInMonth) {
                if(DateHelper.betweenCompareDates(tempWeek.getBeggingDate(), date, tempWeek.getEndDate())) {
                    neededWeek = tempWeek;
                }
            }
            if(neededWeek.equals(new TotalWeekEntries())) {
                throw new WeekNotFoundException();
            }
        }
        catch(WeekNotFoundException wnfe) {
            System.out.println(wnfe);
            System.out.println("Null week is returned");
        }
        return neededWeek;
    }

    public TotalWeekEntries getCertainWeek(int index) {

        TotalWeekEntries returnedTotalWeek = new TotalWeekEntries();
        try {
            return this.allWeekEntriesInMonth.get(index);
        } catch (IndexOutOfBoundsException iofb) {
            System.out.println("You entered wrong week index");
            System.out.println("Return null week");
        }

        return returnedTotalWeek;
    }

    public void setCertainWeek(TotalWeekEntries weekToSet, int index) {
        try {
            this.allWeekEntriesInMonth.set(index, weekToSet);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("You entered wrong index");
        }
    }

    public Double getAverageMoneySpent() {
        return averageMoneySpent;
    }

    public String getInfo() {
        String informationToReturn = new String();
        informationToReturn += "All money spent: " + this.allMoneySpent.toString() +
                "\nAverage money spent: " + this.averageMoneySpent.toString() +
                "\nDate: " + this.beggingDate.toString() + " -- " + this.endDate.toString() +
                "\nWeeks amount: " + this.getAllWeekEntriesInMonth().size() +
                "\nWeeks list: ";
        for(TotalWeekEntries tempWeek : this.getAllWeekEntriesInMonth()) {
            informationToReturn += "   " + tempWeek.toString();
        }
        informationToReturn += "\n";
        return informationToReturn;
    }

    @Override
    public String toString() {
        return this.endDate.getMonth().toString();
    }

    public TotalWeekEntries getMostExpenciveWeek() {
        TotalWeekEntries entryToReturn = this.allWeekEntriesInMonth.get(0);
        for(int i = 1; i < this.allWeekEntriesInMonth.size(); i++) {
            if(this.allWeekEntriesInMonth.get(i).getAllMoneySpent() > entryToReturn.getAllMoneySpent()) {
                entryToReturn = this.allWeekEntriesInMonth.get(i);
            }
        }
        return entryToReturn;
    }

    public TotalWeekEntries getLessExpenciveWeek() {
        TotalWeekEntries entryToReturn = this.allWeekEntriesInMonth.get(0);
        for(int i = 1; i < this.allWeekEntriesInMonth.size(); i++) {
            if(this.allWeekEntriesInMonth.get(i).getAllMoneySpent() < entryToReturn.getAllMoneySpent()) {
                entryToReturn = this.allWeekEntriesInMonth.get(i);
            }
        }
        return entryToReturn;
    }
}
