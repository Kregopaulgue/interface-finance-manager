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
public class TotalWeekEntries implements GeneralTotalEntryOperations {

    private ArrayList<TotalDayEntries> allDayEntriesInWeek;

    private LinkedList<OtherExpenceEntry> simpleEntries;
    private LinkedList<CombinedOtherExpenceEntry> combinedEntries;

    private Integer simpleEntriesAmount;
    private Integer combinedEntriesAmount;

    private Double allMoneySpent;
    private Double allMoneySpentSimpleEntries;
    private Double allMoneySpentCombinedEntries;

    private Double wishedMoneyLimit;

    public TotalWeekEntries(ArrayList<TotalDayEntries> allDayEntriesInWeek) {
        this.allDayEntriesInWeek = allDayEntriesInWeek;
        this.simpleEntriesAmount = 0;
        for(TotalDayEntries tempDay : allDayEntriesInWeek) {
            this.simpleEntriesAmount += tempDay.getSimpleEntriesAmount();
        }
        this.combinedEntriesAmount = 0;
        for(TotalDayEntries tempDay : allDayEntriesInWeek) {
            this.combinedEntriesAmount += tempDay.getCombinedEntriesAmount();
        }
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
        LinkedList<OtherExpenceEntry> weekSimpleEntries = new LinkedList<OtherExpenceEntry>();
        for(int i = 0; i < this.allDayEntriesInWeek.size(); i++) {
            weekSimpleEntries.addAll(this.allDayEntriesInWeek.get(i).getSimpleEntries());
        }
        return simpleEntries;
    }

    public void setSimpleEntries(LinkedList<OtherExpenceEntry> simpleEntries) {
        this.simpleEntries = simpleEntries;
    }

    @Override
    public LinkedList<CombinedOtherExpenceEntry> getCombinedEntries() {
        LinkedList<CombinedOtherExpenceEntry> weekCombinedEntries = new LinkedList<CombinedOtherExpenceEntry>();
        for(int i = 0; i < this.allDayEntriesInWeek.size(); i++) {
            weekCombinedEntries.addAll(this.allDayEntriesInWeek.get(i).getCombinedEntries());
        }
        return weekCombinedEntries;
    }

    public void setCombinedEntries(LinkedList<CombinedOtherExpenceEntry> combinedEntries) {
        this.combinedEntries = combinedEntries;
    }

    public Integer getSimpleEntriesAmount() {
        return simpleEntriesAmount;
    }

    public void setSimpleEntriesAmount(Integer simpleEntriesAmount) {
        this.simpleEntriesAmount = simpleEntriesAmount;
    }

    public Integer getCombinedEntriesAmount() {
        return combinedEntriesAmount;
    }

    public void setCombinedEntriesAmount(Integer combinedEntriesAmount) {
        this.combinedEntriesAmount = combinedEntriesAmount;
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
}
