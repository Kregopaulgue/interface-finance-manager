package ExpenceEntries;

import java.util.Calendar;
import HelperTypes.ExpenceEntryType;

/**
 * Created by Master on 18.10.2017.
 */
public class OtherExpenceEntry extends ExpenceEntry {

    protected Double moneySpent;
    protected Integer importance;
    protected String comment;
    protected Calendar time;
    protected Calendar Calendar;
    protected ExpenceEntryType entryType;

    public OtherExpenceEntry(Double moneySpent, Integer importance, String comment) {
        this.moneySpent = moneySpent;
        this.importance = importance;
        this.comment = comment;
        this.entryType = ExpenceEntryType.OTHER;
    }

    public OtherExpenceEntry(Double moneySpent, Integer importance,
                             String comment, Calendar time, Calendar Calendar, ExpenceEntryType entryType) {
        this.entryType = ExpenceEntryType.OTHER;
        this.moneySpent = moneySpent;
        this.importance = importance;
        this.comment = comment;
        this.time = time;
        this.Calendar = Calendar;
        this.entryType = entryType;
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
    public Calendar getTime() {
        return time;
    }

    @Override
    public void setTime(Calendar time) {
        this.time = time;
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
