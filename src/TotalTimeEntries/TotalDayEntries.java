package TotalTimeEntries;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import HelperInterfaces.GeneralTotalEntryOperations;

import java.time.LocalDate;
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

public class TotalDayEntries extends TotalTimeEntry{

    private LocalDate dayDate;

    public TotalDayEntries() {super();}

    public TotalDayEntries(LinkedList<OtherExpenceEntry> simpleEntries,
                           LinkedList<CombinedOtherExpenceEntry> combinedEntries) {
        super(simpleEntries, combinedEntries);
        this.dayDate = LocalDate.now();
    }

    public TotalDayEntries(LinkedList<OtherExpenceEntry> simpleEntries,
                           LinkedList<CombinedOtherExpenceEntry> combinedEntries, LocalDate dayDate) {
        super(simpleEntries, combinedEntries);
        this.dayDate = dayDate;
    }

    public LocalDate getDayDate() {
        return dayDate;
    }

    public void setDayDate(LocalDate dayDate) {
        this.dayDate = dayDate;
    }

    public String getInfo() {
        String informationToReturn = new String();
        informationToReturn += "All money spent: " + this.allMoneySpent.toString() +
                "\nAverage money spent: " + this.averageMoneySpent.toString() +
                "\nDate: " + getDayDate().toString() +
                "\nSimple entries amount: " + this.simpleEntriesAmount.toString() +
                "\nSimple entries: \n";
        for(OtherExpenceEntry tempExpence : this.simpleEntries) {
            informationToReturn += "   " + tempExpence.toString();
        }
        informationToReturn += "\nCombined entries amount: " + this.combinedEntriesAmount.toString() +
                "\nCombined entries: ";
        for(CombinedOtherExpenceEntry tempEntry : this.combinedEntries) {
            informationToReturn += "   " + tempEntry.toString();
        }
        return informationToReturn;
    }

    @Override
    public String toString() {
        return this.dayDate.toString();
    }
}
