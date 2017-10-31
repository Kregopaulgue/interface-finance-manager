package ExpenceEntries;

import java.util.GregorianCalendar;
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
        time: GregorianCalendar,
        GregorianCalendar: GregorianCalendar,
        entryType: ExpenceEntryType
    }
 */

public class OtherExpenceEntry extends ExpenceEntry {

    protected Double moneySpent;
    protected Integer importance;
    protected String comment;
    protected GregorianCalendar GregorianCalendar;
    protected ExpenceEntryType entryType;
    private String expenceDescription;

    public OtherExpenceEntry() {}

    public OtherExpenceEntry(Double moneySpent, Integer importance, String comment) {
        this.moneySpent = moneySpent;
        this.importance = importance;
        this.comment = comment;
        this.entryType = ExpenceEntryType.OTHER;
    }

    public OtherExpenceEntry(Double moneySpent, Integer importance,
                             String comment, GregorianCalendar GregorianCalendar, String expenceDescription) {
        this.entryType = ExpenceEntryType.OTHER;
        this.moneySpent = moneySpent;
        this.importance = importance;
        this.comment = comment;
        this.GregorianCalendar = GregorianCalendar;
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
    public GregorianCalendar getCalendar() {
        return GregorianCalendar;
    }

    @Override
    public void setCalendar(GregorianCalendar GregorianCalendar) {
        this.GregorianCalendar = GregorianCalendar;
    }

    @Override
    public ExpenceEntryType getEntryType() {
        return entryType;
    }

    @Override
    public String toString() {
        String stringToReturn = "Money spent: " + moneySpent.toString() +
                              "\nImportance: " + importance.toString() +
                              "\nDate: " + GregorianCalendar.getTime().toString() +
                              "\nEntry type: " + entryType.toString() +
                              "\nEntry description: " + expenceDescription;
        return stringToReturn;
    }
    public void setEntryType(ExpenceEntryType entryType) {
        this.entryType = entryType;
    }
}
