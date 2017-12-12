package TotalTimeEntries;

import ExpenceEntries.OtherExpenceEntry;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 * Created by Master on 06.12.2017.
 */
public class TotalTimeEntry {

    protected ArrayList<OtherExpenceEntry> simpleEntries = new ArrayList<>();
    protected Double averageMoneySpent = 0.0;
    protected Integer entriesAmount = 0;
    protected Double allMoneySpent = 0.0;

    public TotalTimeEntry(){}

    public TotalTimeEntry(ArrayList<OtherExpenceEntry> simpleEntries) {
        this.simpleEntries = simpleEntries;

        this.entriesAmount = simpleEntries.size();

        if(simpleEntries.size() != 0) {
            countAllMoneySpent();
            countAverageMoneySpent();
        }
    }

    public void countAllMoneySpent() {
        for(OtherExpenceEntry tempEntry : this.simpleEntries) {
            this.allMoneySpent += tempEntry.getMoneySpent();
        }
    }

    public void countAverageMoneySpent() {
        this.averageMoneySpent = this.allMoneySpent / entriesAmount;
    }

    public ArrayList<OtherExpenceEntry> getSimpleEntries() {
        return simpleEntries;
    }

    public void setSimpleEntries(ArrayList<OtherExpenceEntry> simpleEntries) {
        this.simpleEntries = simpleEntries;
    }

    public Integer getSimpleEntriesAmount() {
        return entriesAmount;
    }

    public int getCertainCimpleEntryIndexByObject(OtherExpenceEntry entry) {
        return this.simpleEntries.indexOf(entry);
    }

    public OtherExpenceEntry getMostExpenciveSimpleEntry() {
        OtherExpenceEntry entryToReturn = this.simpleEntries.get(0);
        for(int i = 1; i < this.entriesAmount; i++) {
            if(this.simpleEntries.get(i).getMoneySpent() > entryToReturn.getMoneySpent()) {
                entryToReturn = this.simpleEntries.get(i);
            }
        }
        return entryToReturn;
    }

    public OtherExpenceEntry getLessExpenciveSimpleEntry() {
        OtherExpenceEntry entryToReturn = this.simpleEntries.get(0);
        for(int i = 1; i < this.entriesAmount; i++) {
            if(this.simpleEntries.get(i).getMoneySpent() < entryToReturn.getMoneySpent()) {
                entryToReturn = this.simpleEntries.get(i);
            }
        }
        return entryToReturn;
    }

    public OtherExpenceEntry getMostImportantSimpleEntry() {
        OtherExpenceEntry entryToReturn = this.simpleEntries.get(0);
        for(int i = 1; i < this.entriesAmount; i++) {
            if(this.simpleEntries.get(i).getImportance() > entryToReturn.getImportance()) {
                entryToReturn = this.simpleEntries.get(i);
            }
        }
        return entryToReturn;
    }

    public OtherExpenceEntry getLessImportantSimpleEntry() {
        OtherExpenceEntry entryToReturn = this.simpleEntries.get(0);
        for(int i = 1; i < this.entriesAmount; i++) {
            if(this.simpleEntries.get(i).getImportance() < entryToReturn.getImportance()) {
                entryToReturn = this.simpleEntries.get(i);
            }
        }
        return entryToReturn;
    }

    public Double getAllMoneySpent() {
        return allMoneySpent;
    }

    public void addSimpleEntry(OtherExpenceEntry entryToAdd) {
        this.simpleEntries.add(entryToAdd);
        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public void deleteSimpleEntry(OtherExpenceEntry entryToDelete) {
        this.simpleEntries.remove(entryToDelete);
        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public void deleteSimpleEntry(int entryIndex) {
        this.simpleEntries.remove(entryIndex);
        countAllMoneySpent();
        countAverageMoneySpent();
    }

    public OtherExpenceEntry getCertainSimpleEntry(int index) {
        OtherExpenceEntry entryToReturn = new OtherExpenceEntry();
        try {
            entryToReturn = this.simpleEntries.get(index);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("You entered wrong index");
            System.out.println("Returning null expence entry");
        }
        return entryToReturn;
    }

    public void setCertainSimpleEntry(int index, OtherExpenceEntry entryToSet) {
        try {
            this.simpleEntries.set(index, entryToSet);
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("You entered wrong index");
            System.out.println("Nothing changed");
        }
    }

    public Double getAverageMoneySpent() {
        return averageMoneySpent;
    }

    public String getInfo() {
        String informationToReturn = new String();
        informationToReturn += "All money spent: " + this.allMoneySpent.toString() +
                "\nAverage money spent: " + this.averageMoneySpent.toString() +
                "\nEntries amount: " + this.entriesAmount.toString() +
                "\nEntries: \n";
        for(OtherExpenceEntry tempExpence : this.simpleEntries) {
            informationToReturn += "   " + tempExpence.toString();
        }
        return informationToReturn;
    }

    public String toString() {
        return "Total Time:";
    }
}
