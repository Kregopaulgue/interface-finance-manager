package TotalTimeEntries;

import ExpenceEntries.OtherExpenceEntry;
import WorkWithData.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 * Created by Master on 23.10.2017.
 */

public class TotalWeekEntries extends TotalTimeEntry {

    private ArrayList<TotalDayEntries> allDayEntriesInWeek;

    private LocalDate beggingDate;
    private LocalDate endDate;

    public TotalWeekEntries() {

    }

    public TotalWeekEntries(ArrayList<TotalDayEntries> allDayEntriesInWeek, LocalDate beggingDate, LocalDate endDate) {
        boolean worthAddingEntries =
                WorkWithTimeData.getAllMoneySpentTotalTime(allDayEntriesInWeek) != 0;
        this.allDayEntriesInWeek = allDayEntriesInWeek;
        this.entriesAmount = 0;
        for(TotalDayEntries tempDay : allDayEntriesInWeek) {
            this.entriesAmount += tempDay.getSimpleEntriesAmount();
        }
        if(worthAddingEntries) {
            this.setSimpleEntries();
        }
        this.beggingDate = beggingDate;
        this.endDate = endDate;
        if(worthAddingEntries) {
            countAllMoneySpent();
            countAverageMoneySpentByEntries();
        }
    }

    @Override
    public void countAllMoneySpent() {
        this.allMoneySpent = 0.0;
        for(int i = 0; i < this.allDayEntriesInWeek.size(); i++) {
            this.allMoneySpent += this.allDayEntriesInWeek.get(i).getAllMoneySpent();
        }
    }

    public void countAverageMoneySpentByEntries() {
        this.averageMoneySpent = this.allMoneySpent / entriesAmount;
    }

    public ArrayList<TotalDayEntries> getAllDayEntriesInWeek() {
        return allDayEntriesInWeek;
    }

    public void setAllDayEntriesInWeek(ArrayList<TotalDayEntries> allDayEntriesInWeek) {
        this.allDayEntriesInWeek = allDayEntriesInWeek;
    }

    @Override
    public ArrayList<OtherExpenceEntry> getSimpleEntries() {
        return this.simpleEntries;
    }

    public void setSimpleEntries() {
        for(TotalDayEntries tempDay : this.allDayEntriesInWeek) {
            this.simpleEntries.addAll(tempDay.getSimpleEntries());
        }
    }

    public Integer getSimpleEntriesAmount() {
        this.setEntriesAmount();
        return entriesAmount;
    }

    public void setEntriesAmount() {
        this.entriesAmount = this.simpleEntries.size();
    }

    @Override
    public Double getAllMoneySpent() {
        return allMoneySpent;
    }

    public void setAllMoneySpent(Double allMoneySpent) {
        this.allMoneySpent = allMoneySpent;
    }

    public void setCertainDay(TotalDayEntries totalDayEntry, int index) {
        this.allDayEntriesInWeek.set(index, totalDayEntry);
    }

    public void addDay(TotalDayEntries dayEntry) {
        this.allDayEntriesInWeek.add(dayEntry);
        countAllMoneySpent();
        countAverageMoneySpentByEntries();
        setSimpleEntries();
    }

    public void deleteDay(TotalDayEntries dayEntry) {
        this.allDayEntriesInWeek.remove(dayEntry);
        countAllMoneySpent();
        countAverageMoneySpentByEntries();
        setSimpleEntries();
    }

    public void deleteDay(int index) {
        this.allDayEntriesInWeek.remove(index);
        countAllMoneySpent();
        countAverageMoneySpentByEntries();
        setSimpleEntries();
    }

    public LocalDate getBeggingDate() {
        return beggingDate;
    }

    public void setBeggingDate(LocalDate beggingDate) {
        this.beggingDate = beggingDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public TotalDayEntries getCertainDay(int index) {
        TotalDayEntries dayToReturn = new TotalDayEntries();
        try {
            dayToReturn = this.allDayEntriesInWeek.get(index);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("You entered wrong index");
            System.out.println("Return null day");
        }
        return dayToReturn;
    }

    public Double getAverageMoneySpent() {
        return averageMoneySpent;
    }

    public String getInfo() {
        String informationToReturn = new String();
        informationToReturn += "All money spent: " + this.allMoneySpent.toString() +
                "\nAverage money spent: " + this.averageMoneySpent.toString() +
                "\nDate: " + this.beggingDate.toString() + " -- " + this.endDate.toString() +
                "\nDays amount: " + this.getAllDayEntriesInWeek().size() +
                "\nDays list: ";
        for(TotalDayEntries tempDay : this.getAllDayEntriesInWeek()) {
            informationToReturn += "   " + tempDay.toString();
        }
        informationToReturn += "\n";
        return informationToReturn;
    }

    @Override
    public String toString() {
        return this.beggingDate.toString() + " - " + this.endDate.toString();
    }

    public TotalDayEntries getMostExpenciveDay() {
        TotalDayEntries entryToReturn = this.allDayEntriesInWeek.get(0);
        for(int i = 1; i < this.allDayEntriesInWeek.size(); i++) {
            if(this.allDayEntriesInWeek.get(i).getAllMoneySpent() > entryToReturn.getAllMoneySpent()) {
                entryToReturn = this.allDayEntriesInWeek.get(i);
            }
        }
        return entryToReturn;
    }

    public TotalDayEntries getLessExpenciveDay() {
        TotalDayEntries entryToReturn = this.allDayEntriesInWeek.get(0);
        for(int i = 1; i < this.allDayEntriesInWeek.size(); i++) {
            if(this.allDayEntriesInWeek.get(i).getAllMoneySpent() < entryToReturn.getAllMoneySpent()) {
                entryToReturn = this.allDayEntriesInWeek.get(i);
            }
        }
        return entryToReturn;
    }
}
