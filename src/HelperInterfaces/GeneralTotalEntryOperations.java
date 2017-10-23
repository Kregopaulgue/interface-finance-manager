package HelperInterfaces;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;

import java.util.LinkedList;

/**
 * Created by Master on 23.10.2017.
 */
public interface GeneralTotalEntryOperations {

    void countAllMoneySpent();

    void countAllMoneySpentSimpleEntries();

    void countAllMoneySpentCombinedEntries();

    Double getAllMoneySpent();

    Double getAllMoneySpentSimpleEntries();

    Double getAllMoneySpentCombinedEntries();

    Double getWishedMoneyLimit();

    default void wishedMoneyLimitWarning() {
        if(this.getAllMoneySpent() >= this.getWishedMoneyLimit()) {
            System.out.println("YOU OVERHELMED YOUR MONEY LIMIT");
        }
    }

    LinkedList<OtherExpenceEntry> getSimpleEntries();

    LinkedList<CombinedOtherExpenceEntry> getCombinedEntries();

}
