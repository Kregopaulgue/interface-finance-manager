package ExpenceEntries;

import java.util.GregorianCalendar;
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
        time: GregorianCalendar,
        GregorianCalendar: GregorianCalendar,
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

    abstract GregorianCalendar getCalendar();
    abstract void setCalendar(GregorianCalendar GregorianCalendar);

    //should
    abstract ExpenceEntryType getEntryType();
    abstract void setEntryType(ExpenceEntryType entryType);
}
