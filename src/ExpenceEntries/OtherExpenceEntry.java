package ExpenceEntries;

import java.util.GregorianCalendar;

import Exceptions.WrongImportanceInputException;
import Exceptions.WrongMoneyInputException;
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

        try {
            this.moneySpent = moneySpent;
            if(moneySpent <= 0) {
                throw new WrongMoneyInputException();
            }
        } catch(WrongMoneyInputException ex) {
            System.out.println("Wrong money input");
            System.out.println("Its set to 0");
            this.moneySpent = 1.0;
        }

        try {
            this.importance = importance;
            if(importance < 0) {
                throw new WrongImportanceInputException();
            }
        } catch (WrongImportanceInputException ex) {
            System.out.println("Wrong importance input");
            System.out.println("Its set to 0");
            this.importance = 0;
        }

        this.comment = comment;
        this.entryType = ExpenceEntryType.OTHER;
    }

    public OtherExpenceEntry(Double moneySpent, Integer importance,
                             String comment, GregorianCalendar GregorianCalendar, String expenceDescription) {
        this.entryType = ExpenceEntryType.OTHER;
        this.moneySpent = moneySpent;
        try {
            if(moneySpent <= 0) {
                throw new WrongMoneyInputException();
            }
        } catch(WrongMoneyInputException ex) {
            System.out.println("!WARNING !WARNING\nWrong money input\n");
            System.out.println("Its set to 1");
            this.moneySpent = 1.0;
        }

        this.importance = importance;
        try {
            if(importance < 0) {
                throw new WrongImportanceInputException();
            }
        } catch (WrongImportanceInputException ex) {
            System.out.println("Wrong importance input");
            System.out.println("Its set to 0");
            this.importance = 0;
        }
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
                              "\nEntry description: " + expenceDescription + "\n";
        return stringToReturn;
    }

    public void setEntryType(ExpenceEntryType entryType) {
        this.entryType = entryType;
    }
}
