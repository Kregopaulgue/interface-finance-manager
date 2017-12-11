package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Created by Master on 18.10.2017.
 */

/*
    ClothExpenceEntry:
    {
        moneySpent: Double,
        importance: Integer,
        comment: String,
        time: GregorianCalendar,
        GregorianCalendar: GregorianCalendar,
        entryType: ExpenceEntryType,
        String: clothType
    }
 */

public class ClothExpenceEntry extends OtherExpenceEntry {

    private String clothType;
    private boolean isClothImportant;
    private boolean doYouWantToBeFashion;
    private boolean doYouNeedIt;

    public ClothExpenceEntry(Double moneySpent, Integer importance, String comment,
                             LocalDate GregorianCalendar, String clothType) {
        super(moneySpent, importance, comment, GregorianCalendar, clothType);

        this.entryType = ExpenceEntryType.CLOTH;
        this.clothType = clothType;
        this.isClothImportant = true;
        this.doYouWantToBeFashion = true;
        this.doYouNeedIt = true;
        this.expenceDescription = clothType;
    }

    public ClothExpenceEntry(Double moneySpent, Integer importance, String comment,
                             LocalDate GregorianCalendar, String clothType,
                             boolean isClothImportant, boolean doYouWantToBeFashion, boolean doYouNeedIt) {
        super(moneySpent, importance, comment, GregorianCalendar, clothType);

        this.entryType = ExpenceEntryType.CLOTH;
        this.clothType = clothType;
        this.isClothImportant = isClothImportant;
        this.doYouWantToBeFashion = doYouWantToBeFashion;
        this.doYouNeedIt = doYouNeedIt;
    }
}
