package CombinedExpenceEntries;

import ExpenceEntries.OtherExpenceEntry;
import HelperTypes.CombinedEntryType;
import HelperTypes.ExpenceEntryType;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.time.*;

/**
 * Created by Master on 20.10.2017.
 */

/*

    CombinedOtherExpenceEntry
    {
        LinkedList<OtherExpenceEntry>: otherExpenceEntries,
        Integer: amountOfEntries,
        Double: allMoneySpent,
        Double averageMoneySpent,
        GregorianCalendar combinedExpenceEntryCalendar,
        CombinedEntryType combinedEntryType
    }

 */
public class CombinedOtherExpenceEntry{

    private LinkedList<OtherExpenceEntry> otherExpenceEntries;

    protected Integer amountOfEntries;

    protected Double allMoneySpent;
    protected Double averageMoneySpent;
    protected LocalDate combinedExpenceEntryCalendar;
    protected CombinedEntryType combinedEntryType;

    public CombinedOtherExpenceEntry(LinkedList<OtherExpenceEntry> otherExpenceEntries) {
        this.otherExpenceEntries = otherExpenceEntries;
        this.amountOfEntries = otherExpenceEntries.size();

        this.combinedExpenceEntryCalendar = LocalDate.now();

        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public CombinedOtherExpenceEntry(LinkedList<OtherExpenceEntry> otherExpenceEntries, LocalDate date) {
        this.otherExpenceEntries = otherExpenceEntries;
        this.amountOfEntries = otherExpenceEntries.size();

        this.combinedExpenceEntryCalendar = date;
        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public CombinedOtherExpenceEntry() {}

    public CombinedOtherExpenceEntry(LinkedList<OtherExpenceEntry> otherExpenceEntries, Integer amountOfEntries,
                                     Double averageMoneySpent, LocalDate combinedExpenceEntryCalendar,
                                     CombinedEntryType combinedEntryType) {
        this.otherExpenceEntries = otherExpenceEntries;
        this.amountOfEntries = amountOfEntries;
        this.averageMoneySpent = averageMoneySpent;
        this.combinedExpenceEntryCalendar = combinedExpenceEntryCalendar;
        this.combinedEntryType = combinedEntryType;

        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public Double getAverageMoneySpent() {
        return this.averageMoneySpent;
    }

    public Double getAllMoneySpent() {
        return this.allMoneySpent;
    }


    public Integer getAmountOfEntries() {
        return this.amountOfEntries;
    }

    public void countAverageMoneySpent() {
        this.averageMoneySpent = this.allMoneySpent / this.amountOfEntries;
    }

    public void countAllMoneySpent() {
        this.allMoneySpent = 0.0;
        for(OtherExpenceEntry tempEntry : otherExpenceEntries) {
            this.allMoneySpent += tempEntry.getMoneySpent();
        }
    }

    public List<OtherExpenceEntry> getExpenceEntriesList() {
        return this.otherExpenceEntries;
    }

    public void setExpenceEntriesList(List<OtherExpenceEntry> expenceEntryList){
        this.otherExpenceEntries = (LinkedList) expenceEntryList;
    }

    public void addEntry(OtherExpenceEntry expenceEntry){
        this.otherExpenceEntries.add(expenceEntry);
    }

    public void removeEntry(OtherExpenceEntry expenceEntry) {
        this.otherExpenceEntries.remove(expenceEntry);
    }

    public void removeEntryByIndex(Integer index) {
        this.otherExpenceEntries.remove((int)index);
    }

    //this may cause problems
    public void removeEntryByComment(String comment) {

        for(OtherExpenceEntry expenceEntry : otherExpenceEntries) {
            if(comment.equals(expenceEntry.getComment())) {
                this.otherExpenceEntries.remove(expenceEntry);
            }
        }

    }

    public void removeAllEntriesOfType(ExpenceEntryType expenceEntryType) {

        for(OtherExpenceEntry expenceEntry : otherExpenceEntries) {
            if(expenceEntry.getEntryType()== expenceEntryType) {
                this.otherExpenceEntries.remove(expenceEntry);
            }
        }

    }

    public OtherExpenceEntry getExpenceEntryByIndex(Integer index) {
        return this.otherExpenceEntries.get(index);
    }

    public void setExpenceEntryByIndex(OtherExpenceEntry expenceEntry, Integer index) {
        this.otherExpenceEntries.set(index, expenceEntry);
    }

    public OtherExpenceEntry getExpenceEntryByComment(String comment) {

        for(OtherExpenceEntry expenceEntry : otherExpenceEntries) {
            if(comment.equals(expenceEntry.getComment())) {
                return expenceEntry;
            }
        }

        //fix return statement
        //make own exceptions
        return this.otherExpenceEntries.get(0);
    }

    public void setExpenceEntryByComment(String comment, OtherExpenceEntry expenceEntry) {

        for(int i = 0; i < this.amountOfEntries; i++) {
            OtherExpenceEntry checkExpenceEntry = this.otherExpenceEntries.get(i);
            if(comment.equals(checkExpenceEntry.getComment())) {
                this.otherExpenceEntries.set(i, expenceEntry);
            }
        }

    }

    public LocalDate getExpenceEntriesListCalendar() {
        return this.combinedExpenceEntryCalendar;
    }

    public void setExpenceEntriesListCalendar(LocalDate expenceEntriesListCalendar) {
        this.combinedExpenceEntryCalendar = expenceEntriesListCalendar;
    }

    public String toString() {
        String informationToReturn = new String();
        informationToReturn +=
                "\nAll money spent: " + this.allMoneySpent.toString() +
                "\nAverage money spent: " + this.averageMoneySpent.toString() +
                "\nDate: " + this.combinedExpenceEntryCalendar.toString() +
                "\nEntries amount: " + this.amountOfEntries.toString() +
                "\n Entries list: ";
        for(OtherExpenceEntry tempEntry : this.otherExpenceEntries) {
            informationToReturn += "  " + tempEntry.toString() + "\n";
        }
        return informationToReturn;
    }
}
