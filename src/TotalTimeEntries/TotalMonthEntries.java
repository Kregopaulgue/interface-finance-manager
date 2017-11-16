package TotalTimeEntries;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import Exceptions.WeekNotFoundException;
import ExpenceEntries.OtherExpenceEntry;
import HelperInterfaces.GeneralTotalEntryOperations;
import XMLLibrary.DateHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Created by Master on 23.10.2017.
 */

/*

    TotalDayEntries
    {

        ArrayList<TotalDayEntries>: allDayEntriesInMonth,
        ArrayList<TotalWeekEntries>: allWeekEntriesInMonth,

        LinkedList<OtherExpenceEntry>: simpleEntries,
        LinkedList<CombinedExpenceEntry>: combinedEntries,

        Integer: simpleEntriesAmount,
        Integer: combinedEntriesAmount,

        Double: allMoneySpent,
        Double: allMoneySpentSimpleEntries,
        Double: allMoneySpentCombinedEntries,

        Double: wishedMoneyLimit
    }

 */

public class TotalMonthEntries implements GeneralTotalEntryOperations {

    private ArrayList<TotalDayEntries> allDayEntriesInMonth = new ArrayList<TotalDayEntries>();
    private ArrayList<TotalWeekEntries> allWeekEntriesInMonth = new ArrayList<TotalWeekEntries>();

    private LinkedList<OtherExpenceEntry> simpleEntries = new LinkedList<>();
    private LinkedList<CombinedOtherExpenceEntry> combinedEntries = new LinkedList<>();

    private LocalDate beggingDate;
    private LocalDate endDate;

    private Integer simpleEntriesAmount;
    private Integer combinedEntriesAmount;

    private Double averageMoneySpent;

    private Double allMoneySpent;
    private Double allMoneySpentSimpleEntries;
    private Double allMoneySpentCombinedEntries;

    private Double wishedMoneyLimit;


    public TotalMonthEntries() {}

    public TotalMonthEntries(ArrayList<TotalWeekEntries> weekEntries, LocalDate beggingDate, LocalDate endDate) {
        this.allWeekEntriesInMonth = weekEntries;
        for(TotalWeekEntries tempWeek : weekEntries) {
            for(int i = 0; i < weekEntries.size(); i++) {
                allDayEntriesInMonth.add(tempWeek.getCertainDay(i));
            }
        }
        countAllMoneySpent();
        setSimpleEntries();
        setCombinedEntries();
        this.simpleEntriesAmount = this.getSimpleEntries().size();
        this.combinedEntriesAmount = this.getCombinedEntries().size();
        this.beggingDate = beggingDate;
        this.endDate = endDate;
        countAverageMoneySpent();
    }

    //to write constructor for dayEntries array

    @Override
    public void countAllMoneySpent() {
        this.allMoneySpent = 0.0;
        for(int i = 0; i < allDayEntriesInMonth.size(); i++) {
            this.allMoneySpent += this.allDayEntriesInMonth.get(i).getAllMoneySpent();
        }
    }

    @Override
    public void countAllMoneySpentSimpleEntries() {
        this.allMoneySpentSimpleEntries = 0.0;
        for(int i = 0; i < allDayEntriesInMonth.size(); i++) {
            this.allMoneySpentSimpleEntries += this.allDayEntriesInMonth.get(i).getAllMoneySpentSimpleEntries();
        }
    }

    @Override
    public void countAllMoneySpentCombinedEntries() {
        this.allMoneySpentCombinedEntries = 0.0;
        for(int i = 0; i < allDayEntriesInMonth.size(); i++) {
            this.allMoneySpentSimpleEntries += this.allDayEntriesInMonth.get(i).getAllMoneySpentCombinedEntries();
        }
    }

    public void countAverageMoneySpent(){
        this.averageMoneySpent = this.allMoneySpent / (this.combinedEntriesAmount + this.simpleEntriesAmount);
    }

    public ArrayList<TotalDayEntries> getAllDayEntriesInMonth() {
        return allDayEntriesInMonth;
    }

    public void setAllDayEntriesInMonth(ArrayList<TotalDayEntries> allDayEntriesInMonth) {
        this.allDayEntriesInMonth = allDayEntriesInMonth;
    }

    public ArrayList<TotalWeekEntries> getAllWeekEntriesInMonth() {
        return allWeekEntriesInMonth;
    }

    public void setAllWeekEntriesInMonth(ArrayList<TotalWeekEntries> allWeekEntriesInMonth) {
        this.allWeekEntriesInMonth = allWeekEntriesInMonth;
    }

    public void setSimpleEntries() {
        for(int i = 0; i < this.allWeekEntriesInMonth.size(); i++) {
            this.simpleEntries.addAll(this.allWeekEntriesInMonth.get(i).getSimpleEntries());
        }
    }

    public void setCombinedEntries() {
        for(int i = 0; i < this.allWeekEntriesInMonth.size(); i++) {
            this.combinedEntries.addAll(this.allWeekEntriesInMonth.get(i).getCombinedEntries());
        }
    }

    @Override
    public LinkedList<OtherExpenceEntry> getSimpleEntries() {
        this.setSimpleEntries();
        return this.simpleEntries;
    }

    @Override
    public LinkedList<CombinedOtherExpenceEntry> getCombinedEntries() {
        this.setCombinedEntries();
        return this.combinedEntries;
    }

    public Integer getSimpleEntriesAmount() {
        return simpleEntriesAmount;
    }

    public Integer getCombinedEntriesAmount() {
        return combinedEntriesAmount;
    }

    @Override
    public Double getAllMoneySpent() {
        return allMoneySpent;
    }

    @Override
    public Double getAllMoneySpentSimpleEntries() {
        return allMoneySpentSimpleEntries;
    }

    @Override
    public Double getAllMoneySpentCombinedEntries() {
        return allMoneySpentCombinedEntries;
    }

    @Override
    public Double getWishedMoneyLimit() {
        return wishedMoneyLimit;
    }

    public void setWishedMoneyLimit(Double wishedMoneyLimit) {
        this.wishedMoneyLimit = wishedMoneyLimit;
    }

    public void setBeggingDate(LocalDate beggingDate) {
        this.beggingDate = beggingDate;
    }

    public LocalDate getBeggingDate() {
        return beggingDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void addWeek(TotalWeekEntries weekToAdd) {
        this.allWeekEntriesInMonth.add(weekToAdd);
        countAllMoneySpent();
        countAverageMoneySpent();
        setSimpleEntries();
        setCombinedEntries();
    }

    public void removeWeek(TotalWeekEntries weekToRemove) {
        this.allWeekEntriesInMonth.remove(weekToRemove);
        countAllMoneySpent();
        countAverageMoneySpent();
        setSimpleEntries();
        setCombinedEntries();
    }

    public void removeWeek(int index) {
        this.allWeekEntriesInMonth.remove(index);
        countAllMoneySpent();
        countAverageMoneySpent();
        setSimpleEntries();
        setCombinedEntries();
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

    @Override
    public String toString() {
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
