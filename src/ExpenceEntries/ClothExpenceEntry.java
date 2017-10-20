package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.util.Date;

/**
 * Created by Master on 18.10.2017.
 */
public class ClothExpenceEntry extends OtherExpenceEntry {

    private String clothType;
    private boolean isClothImportant;
    private boolean doYouWantToBeFashion;
    private boolean doYouNeedIt;

    public ClothExpenceEntry(Double moneySpent, Integer importance, String comment, String clothType,
                             boolean isClothImportant, boolean doYouWantToBeFashion, boolean doYouNeedIt) {
        super(moneySpent, importance, comment);
        this.clothType = clothType;
        this.isClothImportant = isClothImportant;
        this.doYouWantToBeFashion = doYouWantToBeFashion;
        this.doYouNeedIt = doYouNeedIt;
    }

    public ClothExpenceEntry(Double moneySpent, Integer importance, String comment,
                            Date time, Date date, ExpenceEntryType entryType, String clothType,
                             boolean isClothImportant, boolean doYouWantToBeFashion, boolean doYouNeedIt) {
        super(moneySpent, importance, comment, time, date, entryType);
        this.clothType = clothType;

        this.isClothImportant = isClothImportant;

        if(isClothImportant == true) {
            this.doYouNeedIt = false;
            this.doYouWantToBeFashion = false;
            this.importance = 0;
        }
        this.doYouWantToBeFashion = doYouWantToBeFashion;
        this.doYouNeedIt = doYouNeedIt;
    }
}
