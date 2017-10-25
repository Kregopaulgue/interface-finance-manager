package ExpenceEntries;

import java.util.Calendar;
import HelperTypes.ExpenceEntryType;

/**
 * Created by Master on 18.10.2017.
 */

/*
    OtherExpenceEntry:
    {
        moneySpent: Double,
        importance: Integer,
        comment: String,
        time: Calendar,
        Calendar: Calendar,
        entryType: ExpenceEntryType
    }
 */

public class OtherExpenceEntry extends ExpenceEntry {

    protected Double moneySpent;
    protected Integer importance;
    protected String comment;
    protected Calendar Calendar;
    protected ExpenceEntryType entryType;
    private String expenceDescription;

    public OtherExpenceEntry(Double moneySpent, Integer importance, String comment) {
        this.moneySpent = moneySpent;
        this.importance = importance;
        this.comment = comment;
        this.entryType = ExpenceEntryType.OTHER;
    }

    public OtherExpenceEntry(Double moneySpent, Integer importance,
                             String comment, Calendar Calendar, String expenceDescription) {
        this.entryType = ExpenceEntryType.OTHER;
        this.moneySpent = moneySpent;
        this.importance = importance;
        this.comment = comment;
        this.Calendar = Calendar;
        this.entryType = ExpenceEntryType.OTHER;
        this.expenceDescription = expenceDescription;
    }

    @Override
    public Double getMoneySpent() {
        return this.moneySpent;
    }

    @Override
    public void setMoneySpent(Double moneySpent) {
        this.moneySpent = moneySpent;
    }

    @Override
    public Integer getImportance() {
        return importance;
    }

    @Override
    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public Calendar getCalendar() {
        return Calendar;
    }

    @Override
    public void setCalendar(Calendar Calendar) {
        this.Calendar = Calendar;
    }

    @Override
    public ExpenceEntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(ExpenceEntryType entryType) {
        this.entryType = entryType;
    }
}
