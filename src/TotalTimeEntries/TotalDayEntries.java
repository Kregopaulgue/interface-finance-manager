package TotalTimeEntries;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import HelperInterfaces.GeneralTotalEntryOperations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Created by Master on 20.10.2017.
 */

/*

    TotalDayEntries
    {
        LinkedList<OtherExpenceEntry>: simpleEntries,
        LinkedList<CombinedExpenceEntry>: combinedEntries,

        GregorianCalendar dayDate,

        Integer: simpleEntriesAmount,
        Integer: combinedEntriesAmount,

        Double: allMoneySpent,
        Double: allMoneySpentSimpleEntries,
        Double: allMoneySpentCombinedEntries,

        Double: wishedMoneyLimit
    }

 */

public class TotalDayEntries implements GeneralTotalEntryOperations{

    private LinkedList<OtherExpenceEntry> simpleEntries = new LinkedList<OtherExpenceEntry>();
    private LinkedList<CombinedOtherExpenceEntry> combinedEntries = new LinkedList<CombinedOtherExpenceEntry>();
    private GregorianCalendar dayDate;

    Double averageMoneySpent;

    private Integer simpleEntriesAmount;
    private Integer combinedEntriesAmount;

    private Double allMoneySpent;
    private Double allMoneySpentSimpleEntries;
    private Double allMoneySpentCombinedEntries;

    private Double wishedMoneyLimit;

    public TotalDayEntries() {}

    public TotalDayEntries(LinkedList<OtherExpenceEntry> simpleEntries,
                           LinkedList<CombinedOtherExpenceEntry> combinedEntries) {
        this.simpleEntries = simpleEntries;
        this.combinedEntries = combinedEntries;
        this.dayDate = new GregorianCalendar();

        this.simpleEntriesAmount = simpleEntries.size();
        this.combinedEntriesAmount = combinedEntries.size();

        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public TotalDayEntries(LinkedList<OtherExpenceEntry> simpleEntries,
                           LinkedList<CombinedOtherExpenceEntry> combinedEntries, GregorianCalendar dayDate) {
        this.simpleEntries = simpleEntries;
        this.combinedEntries = combinedEntries;
        this.dayDate = dayDate;

        this.simpleEntriesAmount = simpleEntries.size();
        this.combinedEntriesAmount = combinedEntries.size();

        countAllMoneySpent();
        countAverageMoneySpent();
    }

    @Override
    public void countAllMoneySpent() {
        countAllMoneySpentSimpleEntries();
        countAllMoneySpentCombinedEntries();
        this.allMoneySpent = this.allMoneySpentCombinedEntries + this.allMoneySpentSimpleEntries;
    }

    @Override
    public void countAllMoneySpentSimpleEntries() {
        this.allMoneySpentSimpleEntries = 0.0;
        for(OtherExpenceEntry tempEntry : this.simpleEntries) {
            this.allMoneySpentSimpleEntries += tempEntry.getMoneySpent();
        }
    }

    @Override
    public void countAllMoneySpentCombinedEntries() {
        this.allMoneySpentCombinedEntries = 0.0;
        for(CombinedOtherExpenceEntry tempCombinedEntry : this.combinedEntries) {
            this.allMoneySpentSimpleEntries += tempCombinedEntry.getAllMoneySpent();
        }
    }

    public void countAverageMoneySpent() {
        this.averageMoneySpent = this.allMoneySpent / (simpleEntriesAmount + combinedEntriesAmount);
    }

    @Override
    public Double getWishedMoneyLimit() {
        return wishedMoneyLimit;
    }

    public void setWishedMoneyLimit(Double wishedMoneyLimit) {
        this.wishedMoneyLimit = wishedMoneyLimit;
    }

    @Override
    public LinkedList<OtherExpenceEntry> getSimpleEntries() {
        return simpleEntries;
    }

    public void setSimpleEntries(LinkedList<OtherExpenceEntry> simpleEntries) {
        this.simpleEntries = simpleEntries;
    }

    @Override
    public LinkedList<CombinedOtherExpenceEntry> getCombinedEntries() {
        return combinedEntries;
    }

    public void setCombinedEntries(LinkedList<CombinedOtherExpenceEntry> combinedEntries) {
        this.combinedEntries = combinedEntries;
    }

    public GregorianCalendar getDayDate() {
        return dayDate;
    }

    public void setDayDate(GregorianCalendar dayDate) {
        this.dayDate = dayDate;
    }

    public Integer getSimpleEntriesAmount() {
        return simpleEntriesAmount;
    }

    public Integer getCombinedEntriesAmount() {
        return combinedEntriesAmount;
    }

    public OtherExpenceEntry getMostExpenciveSimpleEntry() {
        OtherExpenceEntry entryToReturn = this.simpleEntries.get(0);
        for(int i = 1; i < this.simpleEntriesAmount; i++) {
            if(this.simpleEntries.get(i).getMoneySpent() < entryToReturn.getMoneySpent()) {
                entryToReturn = this.simpleEntries.get(i);
            }
        }
        return entryToReturn;
    }

    public OtherExpenceEntry getLessExpenciveSimpleEntry() {
        OtherExpenceEntry entryToReturn = this.simpleEntries.get(0);
        for(int i = 1; i < this.simpleEntriesAmount; i++) {
            if(this.simpleEntries.get(i).getMoneySpent() > entryToReturn.getMoneySpent()) {
                entryToReturn = this.simpleEntries.get(i);
            }
        }
        return entryToReturn;
    }

    public CombinedOtherExpenceEntry getMostExpenciveCombinedEntry() {
        CombinedOtherExpenceEntry entryToReturn = this.combinedEntries.get(0);
        for(int i = 1; i < this.simpleEntriesAmount; i++) {
            if(this.simpleEntries.get(i).getMoneySpent() < entryToReturn.getAllMoneySpent()) {
                entryToReturn = this.combinedEntries.get(i);
            }
        }
        return entryToReturn;
    }

    public CombinedOtherExpenceEntry getLessExpenciveCombinedEntry() {
        CombinedOtherExpenceEntry entryToReturn = this.combinedEntries.get(0);
        for(int i = 1; i < this.simpleEntriesAmount; i++) {
            if(this.simpleEntries.get(i).getMoneySpent() > entryToReturn.getAllMoneySpent()) {
                entryToReturn = this.combinedEntries.get(i);
            }
        }
        return entryToReturn;
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

    public void addSimpleEntry(OtherExpenceEntry entryToAdd) {
        this.simpleEntries.add(entryToAdd);
        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public void deleteSimpleEntry(OtherExpenceEntry entryToDelete) {
        this.simpleEntries.remove(entryToDelete);
        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public void deleteSimpleEntry(int entryIndex) {
        this.simpleEntries.remove(entryIndex);
        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public void addCombinedEntry(CombinedOtherExpenceEntry entryToAdd) {
        this.combinedEntries.add(entryToAdd);
        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public void deleteCombinedEntry(CombinedOtherExpenceEntry entryToDelete) {
        this.combinedEntries.remove(entryToDelete);
        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public void deleteCombinedEntry(int index) {
        this.combinedEntries.remove(index);
        countAllMoneySpent();
        countAverageMoneySpent();
    }
}
