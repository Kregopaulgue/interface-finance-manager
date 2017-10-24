package TotalTimeEntries;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import HelperInterfaces.GeneralTotalEntryOperations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Created by Master on 23.10.2017.
 */

/*
        TotalDayEntries
        {

        ArrayList<TotalDayEntries>: allDayEntriesInMonth,


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

public class TotalWeekEntries implements GeneralTotalEntryOperations {

    private ArrayList<TotalDayEntries> allDayEntriesInWeek;

    private LinkedList<OtherExpenceEntry> simpleEntries;
    private LinkedList<CombinedOtherExpenceEntry> combinedEntries;

    private Calendar beggingDate;
    private Calendar endDate;

    private Integer simpleEntriesAmount;
    private Integer combinedEntriesAmount;

    Double averageMoneySpent;

    private Double allMoneySpent;
    private Double allMoneySpentSimpleEntries;
    private Double allMoneySpentCombinedEntries;

    private Double wishedMoneyLimit;

    public TotalWeekEntries(ArrayList<TotalDayEntries> allDayEntriesInWeek, Calendar beggingDate, Calendar endDate) {
        this.allDayEntriesInWeek = allDayEntriesInWeek;
        this.simpleEntriesAmount = 0;
        for(TotalDayEntries tempDay : allDayEntriesInWeek) {
            this.simpleEntriesAmount += tempDay.getSimpleEntriesAmount();
        }
        this.combinedEntriesAmount = 0;
        for(TotalDayEntries tempDay : allDayEntriesInWeek) {
            this.combinedEntriesAmount += tempDay.getCombinedEntriesAmount();
        }
        this.beggingDate = beggingDate;
        this.endDate = endDate;
    }

    @Override
    public void countAllMoneySpent() {
        this.allMoneySpent = 0.0;
        for(int i = 0; i < 7; i++) {
            this.allMoneySpent += this.allDayEntriesInWeek.get(i).getAllMoneySpent();
        }
    }

    @Override
    public void countAllMoneySpentSimpleEntries() {
        this.allMoneySpentSimpleEntries = 0.0;
        for(int i = 0; i < 7; i++) {
            this.allMoneySpentSimpleEntries += this.allDayEntriesInWeek.get(i).getAllMoneySpentSimpleEntries();
        }
    }

    @Override
    public void countAllMoneySpentCombinedEntries() {
        this.allMoneySpentCombinedEntries = 0.0;
        for(int i = 0; i < 7; i++) {
            this.allMoneySpentSimpleEntries += this.allDayEntriesInWeek.get(i).getAllMoneySpentCombinedEntries();
        }
    }

    public ArrayList<TotalDayEntries> getAllDayEntriesInWeek() {
        return allDayEntriesInWeek;
    }

    public void setAllDayEntriesInWeek(ArrayList<TotalDayEntries> allDayEntriesInWeek) {
        this.allDayEntriesInWeek = allDayEntriesInWeek;
    }

    @Override
    public LinkedList<OtherExpenceEntry> getSimpleEntries() {
        this.setSimpleEntries();
        return this.simpleEntries;
    }

    public void setSimpleEntries() {
        for(TotalDayEntries tempDay : this.allDayEntriesInWeek) {
            this.simpleEntries.addAll(tempDay.getSimpleEntries());
        }
    }

    @Override
    public LinkedList<CombinedOtherExpenceEntry> getCombinedEntries() {
        this.setCombinedEntries();
        return this.combinedEntries;
    }

    public void setCombinedEntries() {
        for(TotalDayEntries tempDay : this.allDayEntriesInWeek) {
            this.combinedEntries.addAll(tempDay.getCombinedEntries());
        }
    }

    public Integer getSimpleEntriesAmount() {
        this.setSimpleEntriesAmount();
        return simpleEntriesAmount;
    }

    public void setSimpleEntriesAmount() {
        this.simpleEntriesAmount = this.simpleEntries.size();
    }

    public Integer getCombinedEntriesAmount() {
        this.setCombinedEntriesAmount();
        return combinedEntriesAmount;
    }

    public void setCombinedEntriesAmount() {
        this.combinedEntriesAmount = this.combinedEntries.size();
    }

    @Override
    public Double getAllMoneySpent() {
        return allMoneySpent;
    }

    public void setAllMoneySpent(Double allMoneySpent) {
        this.allMoneySpent = allMoneySpent;
    }

    @Override
    public Double getAllMoneySpentSimpleEntries() {
        return allMoneySpentSimpleEntries;
    }

    public void setAllMoneySpentSimpleEntries(Double allMoneySpentSimpleEntries) {
        this.allMoneySpentSimpleEntries = allMoneySpentSimpleEntries;
    }

    @Override
    public Double getAllMoneySpentCombinedEntries() {
        return allMoneySpentCombinedEntries;
    }

    public void setAllMoneySpentCombinedEntries(Double allMoneySpentCombinedEntries) {
        this.allMoneySpentCombinedEntries = allMoneySpentCombinedEntries;
    }

    @Override
    public Double getWishedMoneyLimit() {
        return wishedMoneyLimit;
    }

    public void setWishedMoneyLimit(Double wishedMoneyLimit) {
        this.wishedMoneyLimit = wishedMoneyLimit;
    }

    public void setCertainDay(TotalDayEntries totalDayEntry, int index) {
        this.allDayEntriesInWeek.set(index, totalDayEntry);
    }

    public TotalDayEntries getCertainDay(int index) {
        return this.allDayEntriesInWeek.get(index);
    }

    public void addDay(TotalDayEntries dayEntry) {
        this.allDayEntriesInWeek.add(dayEntry);
    }

    public Calendar getBeggingDate() {
        return beggingDate;
    }

    public void setBeggingDate(Calendar beggingDate) {
        this.beggingDate = beggingDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
}
