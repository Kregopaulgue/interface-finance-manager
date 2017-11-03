package WorkWithEntryData;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalWeekEntries;

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

    public static CombinedOtherExpenceEntry findTheMostExpensiveCombinedEntry(ArrayList<CombinedOtherExpenceEntry> entries) {
        CombinedOtherExpenceEntry neededEntry = entries.get(0);

        for(CombinedOtherExpenceEntry tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() > neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static CombinedOtherExpenceEntry findTheLessExpensiveCombinedEntry(ArrayList<CombinedOtherExpenceEntry> entries) {
        CombinedOtherExpenceEntry neededEntry = entries.get(0);

        for(CombinedOtherExpenceEntry tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() < neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static TotalDayEntries findTheMostExpensiveDay(ArrayList<TotalDayEntries> entries) {
        TotalDayEntries neededEntry = entries.get(0);

        for(TotalDayEntries tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() > neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static TotalDayEntries findTheLessExpensiveDay(ArrayList<TotalDayEntries> entries) {
        TotalDayEntries neededEntry = entries.get(0);

        for(TotalDayEntries tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() < neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static TotalWeekEntries findTheMostExpensiveWeek(ArrayList<TotalWeekEntries> entries) {
        TotalWeekEntries neededEntry = entries.get(0);

        for(TotalWeekEntries tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() > neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static TotalWeekEntries findTheLessExpensiveWeek(ArrayList<TotalWeekEntries> entries) {
        TotalWeekEntries neededEntry = entries.get(0);

        for(TotalWeekEntries tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() < neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static TotalMonthEntries findTheMostExpensiveMonth(ArrayList<TotalMonthEntries> entries) {
        TotalMonthEntries neededEntry = entries.get(0);

        for(TotalMonthEntries tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() > neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static TotalMonthEntries findTheLessExpensiveMonth(ArrayList<TotalMonthEntries> entries) {
        TotalMonthEntries neededEntry = entries.get(0);

        for(TotalMonthEntries tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() < neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static Double findAverageMoneyCombined(ArrayList<CombinedOtherExpenceEntry> entries) {
        Double averageMoney = 0.0;
        Double sumMoney = 0.0;

        for(CombinedOtherExpenceEntry tempExpence : entries) {
            sumMoney += tempExpence.getAllMoneySpent();
        }

        averageMoney = sumMoney / entries.size();
        return averageMoney;
    }

    public static Double findAverageMoneyEntrys(ArrayList<OtherExpenceEntry> entries) {
        return getAllMoneySpentEntries(entries) / entries.size();
    }

    public static Double findAverageMoneyCombinedEntrys(ArrayList<CombinedOtherExpenceEntry> entries) {
        return getAllMoneySpentCombinedEntries(entries) / entries.size();
    }

    public static Double findAverageMoneyDays(ArrayList<TotalDayEntries> entries) {
        return getAllMoneySpentDays(entries) / entries.size();
    }


    public static Double findAverageMoneyWeeks(ArrayList<TotalWeekEntries> entries) {
        return getAllMoneySpentWeeks(entries) / entries.size();
    }

    public static Double findAverageMoneyMonths(ArrayList<TotalMonthEntries> entries) {
        return getAllMoneySpentMonths(entries) / entries.size();
    }

    public static Double getAllMoneySpentEntries(ArrayList<OtherExpenceEntry> entries) {
        Double sumMoney = 0.0;
        for(OtherExpenceEntry tempExpence : entries) {
            sumMoney += tempExpence.getMoneySpent();
        }
        return sumMoney;
    }

    public static Double getAllMoneySpentCombinedEntries(ArrayList<CombinedOtherExpenceEntry> entries) {
        Double sumMoney = 0.0;
        for(CombinedOtherExpenceEntry tempExpence : entries) {
            sumMoney += tempExpence.getAllMoneySpent();
        }
        return sumMoney;
    }

    public static Double getAllMoneySpentDays(ArrayList<TotalDayEntries> entries) {
        Double sumMoney = 0.0;
        for(TotalDayEntries tempExpence : entries) {
            sumMoney += tempExpence.getAllMoneySpent();
        }
        return sumMoney;
    }

    public static Double getAllMoneySpentWeeks(ArrayList<TotalWeekEntries> entries) {
        Double sumMoney = 0.0;
        for(TotalWeekEntries tempExpence : entries) {
            sumMoney += tempExpence.getAllMoneySpent();
        }
        return sumMoney;
    }

    public static Double getAllMoneySpentMonths(ArrayList<TotalMonthEntries> entries) {
        Double sumMoney = 0.0;
        for(TotalMonthEntries tempExpence : entries) {
            sumMoney += tempExpence.getAllMoneySpent();
        }
        return sumMoney;
    }
}
