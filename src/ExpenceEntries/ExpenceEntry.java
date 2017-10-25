package ExpenceEntries;

import java.util.Calendar;
import HelperTypes.ExpenceEntryType;

/**
 * Created by Master on 11.10.2017.
 */

/*
    Abstract ExpenceEntry:
    {
        moneySpent: Double,
        importance: Integer,
        comment: String,
        time: Calendar,
        Calendar: Calendar,
        entryType: ExpenceEntryType
    }
 */


abstract public class ExpenceEntry {

    abstract Double getMoneySpent();
    abstract void setMoneySpent(Double moneySpent);

    abstract Integer getImportance();
    abstract void setImportance(Integer importance);

    abstract String getComment();
    abstract void setComment(String comment);

    abstract Calendar getCalendar();
    abstract void setCalendar(Calendar Calendar);

    //should
    abstract ExpenceEntryType getEntryType();
    abstract void setEntryType(ExpenceEntryType entryType);
}
