package ExpenceEntries;

import java.time.LocalDate;
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

    abstract String getSpecialDescription();

    abstract Double getMoneySpent();
    abstract void setMoneySpent(Double moneySpent);

    abstract Integer getImportance();
    abstract void setImportance(Integer importance);

    abstract String getComment();
    abstract void setComment(String comment);

    abstract LocalDate getCalendar();
    abstract void setCalendar(LocalDate GregorianCalendar);

    //should
    abstract ExpenceEntryType getEntryType();
    abstract void setEntryType(ExpenceEntryType entryType);
}
