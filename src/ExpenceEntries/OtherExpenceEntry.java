package ExpenceEntries;

import java.util.Date;
import HelperTypes.ExpenceEntryType;

/**
 * Created by Master on 18.10.2017.
 */
public class OtherExpenceEntry extends ExpenceEntry {

    protected Double moneySpent;
    protected Integer importance;
    protected String comment;
    protected Date time;
    protected Date date;
    protected ExpenceEntryType entryType;

    public OtherExpenceEntry(Double moneySpent, Integer importance, String comment) {
        this.moneySpent = moneySpent;
        this.importance = importance;
        this.comment = comment;
    }

    public OtherExpenceEntry(Double moneySpent, Integer importance,
                             String comment, Date time, Date date, ExpenceEntryType entryType) {
        this.moneySpent = moneySpent;
        this.importance = importance;
        this.comment = comment;
        this.time = time;
        this.date = date;
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
    public Date getTime() {
        return time;
    }

    @Override
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public ExpenceEntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(ExpenceEntryType entryType) {
        this.entryType = entryType;
    }
}
