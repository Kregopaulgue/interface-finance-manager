package CombinedExpenceEntries;

import ExpenceEntries.OtherExpenceEntry;
import HelperTypes.CombinedEntryType;
import HelperTypes.ExpenceEntryType;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

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
public class CombinedOtherExpenceEntry extends CombinedExpenceEntry{

    private LinkedList<OtherExpenceEntry> otherExpenceEntries;

    protected Integer amountOfEntries;

    protected Double allMoneySpent;
    protected Double averageMoneySpent;
    protected GregorianCalendar combinedExpenceEntryCalendar;
    protected CombinedEntryType combinedEntryType;

    public CombinedOtherExpenceEntry(LinkedList<OtherExpenceEntry> otherExpenceEntries) {
        this.otherExpenceEntries = otherExpenceEntries;
        this.amountOfEntries = otherExpenceEntries.size();

        this.combinedExpenceEntryCalendar = new GregorianCalendar();

        countAllMoneySpent();
    }

    public CombinedOtherExpenceEntry(LinkedList<OtherExpenceEntry> otherExpenceEntries, GregorianCalendar date) {
        this.otherExpenceEntries = otherExpenceEntries;
        this.amountOfEntries = otherExpenceEntries.size();

        this.combinedExpenceEntryCalendar = date;
        countAllMoneySpent();
    }

    public CombinedOtherExpenceEntry() {}

    public CombinedOtherExpenceEntry(LinkedList<OtherExpenceEntry> otherExpenceEntries, Integer amountOfEntries,
                                     Double averageMoneySpent, GregorianCalendar combinedExpenceEntryCalendar,
                                     CombinedEntryType combinedEntryType) {
        this.otherExpenceEntries = otherExpenceEntries;
        this.amountOfEntries = amountOfEntries;
        this.averageMoneySpent = averageMoneySpent;
        this.combinedExpenceEntryCalendar = combinedExpenceEntryCalendar;
        this.combinedEntryType = combinedEntryType;

        countAllMoneySpent();
    }

    @Override
    public Double getAverageMoneySpent() {
        return this.averageMoneySpent;
    }

    @Override
    public Double getAllMoneySpent() {
        return this.allMoneySpent;
    }

    @Override
    public Integer getAmountOfEntries() {
        return this.amountOfEntries;
    }

    @Override
    public void countAverageMoneySpent() {
        this.averageMoneySpent = this.allMoneySpent / this.amountOfEntries;
    }

    @Override
    public void countAllMoneySpent() {
        this.allMoneySpent = 0.0;
        for(OtherExpenceEntry tempEntry : otherExpenceEntries) {
            this.allMoneySpent += tempEntry.getMoneySpent();
        }
    }

    @Override
    public List<OtherExpenceEntry> getExpenceEntriesList() {
        return this.otherExpenceEntries;
    }
    
    @Override
    public void setExpenceEntriesList(List<OtherExpenceEntry> expenceEntryList){
        this.otherExpenceEntries = (LinkedList) expenceEntryList;
    }

    @Override
    public void addEntry(OtherExpenceEntry expenceEntry){
        this.otherExpenceEntries.add(expenceEntry);
    }

    @Override
    public void removeEntry(OtherExpenceEntry expenceEntry) {
        this.otherExpenceEntries.remove(expenceEntry);
    }

    @Override
    public void removeEntryByIndex(Integer index) {
        this.otherExpenceEntries.remove((int)index);
    }

    //this may cause problems
    @Override
    public void removeEntryByComment(String comment) {

        for(OtherExpenceEntry expenceEntry : otherExpenceEntries) {
            if(comment.equals(expenceEntry.getComment())) {
                this.otherExpenceEntries.remove(expenceEntry);
            }
        }

    }

    @Override
    public void removeAllEntriesOfType(ExpenceEntryType expenceEntryType) {

        for(OtherExpenceEntry expenceEntry : otherExpenceEntries) {
            if(expenceEntry.getEntryType()== expenceEntryType) {
                this.otherExpenceEntries.remove(expenceEntry);
            }
        }

    }

    @Override
    public OtherExpenceEntry getExpenceEntryByIndex(Integer index) {
        return this.otherExpenceEntries.get(index);
    }

    @Override
    public void setExpenceEntryByIndex(OtherExpenceEntry expenceEntry, Integer index) {
        this.otherExpenceEntries.set(index, expenceEntry);
    }

    @Override
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

    @Override
    public void setExpenceEntryByComment(String comment, OtherExpenceEntry expenceEntry) {

        for(int i = 0; i < this.amountOfEntries; i++) {
            OtherExpenceEntry checkExpenceEntry = this.otherExpenceEntries.get(i);
            if(comment.equals(checkExpenceEntry.getComment())) {
                this.otherExpenceEntries.set(i, expenceEntry);
            }
        }

    }

    @Override
    public GregorianCalendar getExpenceEntriesListCalendar() {
        return this.combinedExpenceEntryCalendar;
    }

    @Override
    public void setExpenceEntriesListCalendar(GregorianCalendar expenceEntriesListCalendar) {
        this.combinedExpenceEntryCalendar = expenceEntriesListCalendar;
    }
}
