package WorkWithData;

import TotalTimeEntries.TotalTimeEntry;

import java.util.ArrayList;

/**
 * Created by Master on 11.12.2017.
 */
public class WorkWithTimeData {

    public static <TimeType extends TotalTimeEntry> Double getAllMoneySpentTotalTime(ArrayList<TimeType> entries) {
        Double sumMoney = 0.0;
        for(TotalTimeEntry tempExpence : entries) {
            sumMoney += tempExpence.getAllMoneySpent();
        }
        return sumMoney;
    }

    public static <TimeType extends TotalTimeEntry> Double findAverageMoneyTimeEntries(ArrayList<TimeType> entries) {
        return getAllMoneySpentTotalTime(entries) / entries.size();
    }

    public static <TimeType extends TotalTimeEntry> TimeType findTheMostExpensiveTimeEntry(ArrayList<TimeType> entries) {
        TimeType neededEntry = entries.get(0);

        for(TimeType tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() > neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

    public static <TimeType extends TotalTimeEntry> TimeType findTheLessExpensiveTimeEntry(ArrayList<TimeType> entries)
    {
        TimeType neededEntry = entries.get(0);

        for(TimeType tempExpence : entries) {
            if(tempExpence.getAllMoneySpent() < neededEntry.getAllMoneySpent()) {
                neededEntry = tempExpence;
            }
        }

        return neededEntry;
    }

}
