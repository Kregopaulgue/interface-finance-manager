package CombinedExpenceEntries;

import ExpenceEntries.ExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import HelperTypes.ExpenceEntryType;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Master on 20.10.2017.
 */
abstract public class CombinedExpenceEntry {

    abstract List<OtherExpenceEntry> getExpenceEntriesList();
    abstract void setExpenceEntriesList(List<OtherExpenceEntry> expenceEntryList);

    abstract void addEntry(OtherExpenceEntry expenceEntry);

    abstract void removeEntry(OtherExpenceEntry expenceEntry);
    abstract void removeEntryByIndex(Integer index);
    abstract void removeEntryByComment(String comment);

    abstract void removeAllEntriesOfType(ExpenceEntryType expenceEntryType);

    abstract OtherExpenceEntry getExpenceEntryByIndex(Integer index);
    abstract void setExpenceEntryByIndex(OtherExpenceEntry expenceEntry, Integer index);

    abstract OtherExpenceEntry getExpenceEntryByComment(String comment);
    abstract void setExpenceEntryByComment(String comment, OtherExpenceEntry expenceEntry);

    abstract Calendar getExpenceEntriesListCalendar();
    abstract void setExpenceEntriesListCalendar(Calendar expenceEntriesListCalendar);

    abstract Double getAllMoneySpent();
    abstract void countAllMoneySpent();

    abstract Double getAverageMoneySpent();
    abstract void countAverageMoneySpent();

    abstract Integer getAmountOfEntries();
}
