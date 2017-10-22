package TotalTimeEntries;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Created by Master on 20.10.2017.
 */
public class TotalDayEntries {

    private LinkedList<OtherExpenceEntry> simpleEntries;
    private LinkedList<CombinedOtherExpenceEntry> combinedEntries;
    private Calendar dayDate;

    private Integer simpleEntriesAmount;
    private Integer combinedEntriesAmount;

    private Double allMoneySpent;
    private Double allMoneySpentSimpleEntries;
    private Double allMoneySpentCombinedEntries;

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

    public void countAllMoneySpent() {
        countAllMoneySpentSimpleEntries();
        countAllMoneySpentCombinedEntries();
        this.allMoneySpent = this.allMoneySpentCombinedEntries + this.allMoneySpentSimpleEntries;
    }

    public void countAllMoneySpentSimpleEntries() {
        this.allMoneySpentSimpleEntries = 0.0;
        for(OtherExpenceEntry tempEntry : this.simpleEntries) {
            this.allMoneySpentSimpleEntries += tempEntry.getMoneySpent();
        }
    }

    public void countAllMoneySpentCombinedEntries() {
        this.allMoneySpentCombinedEntries = 0.0;
        for(CombinedOtherExpenceEntry tempCombinedEntry : this.combinedEntries) {
            this.allMoneySpentSimpleEntries += tempCombinedEntry.getAllMoneySpent();
        }
    }

    public LinkedList<OtherExpenceEntry> getSimpleEntries() {
        return simpleEntries;
    }

    public void setSimpleEntries(LinkedList<OtherExpenceEntry> simpleEntries) {
        this.simpleEntries = simpleEntries;
    }

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
}
