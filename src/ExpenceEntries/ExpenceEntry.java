package ExpenceEntries;

import java.util.Date;
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
        time: Date,
        date: Date,
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

    //should search for time and date implementations in java
    abstract Date getTime();
    abstract void setTime(Date time);

    abstract Date getDate();
    abstract void setDate(Date date);

    //should
    abstract ExpenceEntryType getEntryType();
    abstract void setEntryType(ExpenceEntryType entryType);
}
