package WorkWithData;

import ExpenceEntries.OtherExpenceEntry;

import java.util.ArrayList;

/**
 * Created by Master on 02.11.2017.
 */
public class WorkWithEntryData {

    public static OtherExpenceEntry findTheMostImportantEntry(ArrayList<OtherExpenceEntry> entries) {

        OtherExpenceEntry neededEntry = entries.get(0);

        for(OtherExpenceEntry tempExpence : entries) {
            if(tempExpence.getImportance() > neededEntry.getImportance()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static OtherExpenceEntry findTheLessImportantEntry(ArrayList<OtherExpenceEntry> entries) {

        OtherExpenceEntry neededEntry = entries.get(0);

        for(OtherExpenceEntry tempExpence : entries) {
            if(tempExpence.getImportance() < neededEntry.getImportance()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    //to write importance for combined

    public static OtherExpenceEntry findTheMostExpensiveEntry(ArrayList<OtherExpenceEntry> entries) {
        OtherExpenceEntry neededEntry = entries.get(0);

        for(OtherExpenceEntry tempExpence : entries) {
            if(tempExpence.getMoneySpent() > neededEntry.getMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static OtherExpenceEntry findTheLessExpensiveEntry(ArrayList<OtherExpenceEntry> entries) {
        OtherExpenceEntry neededEntry = entries.get(0);

        for(OtherExpenceEntry tempExpence : entries) {
            if(tempExpence.getMoneySpent() < neededEntry.getMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static Double findAverageMoneyEntries(ArrayList<OtherExpenceEntry> entries) {
        return getAllMoneySpentEntries(entries) / entries.size();
    }


    public static Double getAllMoneySpentEntries(ArrayList<OtherExpenceEntry> entries) {
        Double sumMoney = 0.0;
        for(OtherExpenceEntry tempExpence : entries) {
            sumMoney += tempExpence.getMoneySpent();
        }
        return sumMoney;
    }
}
