package TotalTimeEntries;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import HelperInterfaces.GeneralTotalEntryOperations;

import java.util.ArrayList;
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

        Calendar dayDate,

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

    private LinkedList<OtherExpenceEntry> simpleEntries;
    private LinkedList<CombinedOtherExpenceEntry> combinedEntries;

    private Integer simpleEntriesAmount;
    private Integer combinedEntriesAmount;

    private Double allMoneySpent;
    private Double allMoneySpentSimpleEntries;
    private Double allMoneySpentCombinedEntries;

    private Double wishedMoneyLimit;


    public TotalMonthEntries(ArrayList<TotalWeekEntries> weekEntries) {
        this.allWeekEntriesInMonth = weekEntries;
        for(TotalWeekEntries tempWeek : weekEntries) {
            for(int i = 0; i < weekEntries.size(); i++) {
                allDayEntriesInMonth.add(tempWeek.getCertainDay(i));
            }
        }
        this.simpleEntriesAmount = this.getSimpleEntries().size();
        this.combinedEntriesAmount = this.getCombinedEntries().size();
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
}
