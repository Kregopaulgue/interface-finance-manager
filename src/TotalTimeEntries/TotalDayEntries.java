package TotalTimeEntries;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import HelperInterfaces.GeneralTotalEntryOperations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Created by Master on 20.10.2017.
 */

/*

    TotalDayEntries
    {
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

public class TotalDayEntries implements GeneralTotalEntryOperations{

    private LinkedList<OtherExpenceEntry> simpleEntries = new LinkedList<OtherExpenceEntry>();
    private LinkedList<CombinedOtherExpenceEntry> combinedEntries = new LinkedList<CombinedOtherExpenceEntry>();
    private Calendar dayDate;

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
        this.dayDate = Calendar.getInstance();

        countAllMoneySpent();
    }

    public TotalDayEntries(LinkedList<OtherExpenceEntry> simpleEntries,
                           LinkedList<CombinedOtherExpenceEntry> combinedEntries, Calendar dayDate) {
        this.simpleEntries = simpleEntries;
        this.combinedEntries = combinedEntries;
        this.dayDate = dayDate;

        countAllMoneySpent();
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

    public Calendar getDayDate() {
        return dayDate;
    }

    public void setDayDate(Calendar dayDate) {
        this.dayDate = dayDate;
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
}
