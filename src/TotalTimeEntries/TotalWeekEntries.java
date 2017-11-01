package TotalTimeEntries;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import HelperInterfaces.GeneralTotalEntryOperations;

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

    private LinkedList<OtherExpenceEntry> simpleEntries = new LinkedList<>();
    private LinkedList<CombinedOtherExpenceEntry> combinedEntries = new LinkedList<>();

    private GregorianCalendar beggingDate;
    private GregorianCalendar endDate;

    private Integer simpleEntriesAmount;
    private Integer combinedEntriesAmount;

    Double averageMoneySpent;

    private Double allMoneySpent;
    private Double allMoneySpentSimpleEntries;
    private Double allMoneySpentCombinedEntries;

    private Double wishedMoneyLimit;

    public TotalWeekEntries() {

    }

    public TotalWeekEntries(ArrayList<TotalDayEntries> allDayEntriesInWeek, GregorianCalendar beggingDate, GregorianCalendar endDate) {
        this.allDayEntriesInWeek = allDayEntriesInWeek;
        this.simpleEntriesAmount = 0;
        for(TotalDayEntries tempDay : allDayEntriesInWeek) {
            this.simpleEntriesAmount += tempDay.getSimpleEntriesAmount();
        }
        this.setSimpleEntries();
        this.combinedEntriesAmount = 0;
        for(TotalDayEntries tempDay : allDayEntriesInWeek) {
            this.combinedEntriesAmount += tempDay.getCombinedEntriesAmount();
        }
        this.setCombinedEntries();
        this.beggingDate = beggingDate;
        this.endDate = endDate;
        countAllMoneySpent();
        countAverageMoneySpentByEntries();
    }

    @Override
    public void countAllMoneySpent() {
        this.allMoneySpent = 0.0;
        for(int i = 0; i < this.allDayEntriesInWeek.size(); i++) {
            this.allMoneySpent += this.allDayEntriesInWeek.get(i).getAllMoneySpent();
        }
    }

    @Override
    public void countAllMoneySpentSimpleEntries() {
        this.allMoneySpentSimpleEntries = 0.0;
        for(int i = 0; i < this.allDayEntriesInWeek.size(); i++) {
            this.allMoneySpentSimpleEntries += this.allDayEntriesInWeek.get(i).getAllMoneySpentSimpleEntries();
        }
    }

    @Override
    public void countAllMoneySpentCombinedEntries() {
        this.allMoneySpentCombinedEntries = 0.0;
        for(int i = 0; i < this.allDayEntriesInWeek.size(); i++) {
            this.allMoneySpentSimpleEntries += this.allDayEntriesInWeek.get(i).getAllMoneySpentCombinedEntries();
        }
    }

    public void countAverageMoneySpentByEntries() {
        this.averageMoneySpent = this.allMoneySpent / (this.simpleEntriesAmount + this.combinedEntriesAmount);
    }

    public ArrayList<TotalDayEntries> getAllDayEntriesInWeek() {
        return allDayEntriesInWeek;
    }

    public void setAllDayEntriesInWeek(ArrayList<TotalDayEntries> allDayEntriesInWeek) {
        this.allDayEntriesInWeek = allDayEntriesInWeek;
    }

    @Override
    public LinkedList<OtherExpenceEntry> getSimpleEntries() {
        return this.simpleEntries;
    }

    public void setSimpleEntries() {
        for(TotalDayEntries tempDay : this.allDayEntriesInWeek) {
            for(OtherExpenceEntry tempSimpleEntry : tempDay.getSimpleEntries()) {
                this.simpleEntries.add(tempSimpleEntry);
            }
        }
    }

    @Override
    public LinkedList<CombinedOtherExpenceEntry> getCombinedEntries() {
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
        countAllMoneySpent();
        countAverageMoneySpentByEntries();
        setSimpleEntries();
        setCombinedEntries();
    }

    public void deleteDay(TotalDayEntries dayEntry) {
        this.allDayEntriesInWeek.remove(dayEntry);
        countAllMoneySpent();
        countAverageMoneySpentByEntries();
        setSimpleEntries();
        setCombinedEntries();
    }

    public void deleteDay(int index) {
        this.allDayEntriesInWeek.remove(index);
        countAllMoneySpent();
        countAverageMoneySpentByEntries();
        setSimpleEntries();
        setCombinedEntries();
    }

    public GregorianCalendar getBeggingDate() {
        return beggingDate;
    }

    public void setBeggingDate(GregorianCalendar beggingDate) {
        this.beggingDate = beggingDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }
}
