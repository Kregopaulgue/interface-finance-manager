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

        checkForImportance(isClothImportant, doYouWantToBeFashion, doYouNeedIt);
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

        checkForImportance(isClothImportant, doYouWantToBeFashion, doYouNeedIt);
    }

    public void checkForImportance(boolean isClothImportant,
                                   boolean doYouWantToBeFashion, boolean doYouNeedIt) {
        if(isClothImportant == false) {
            this.doYouNeedIt = false;
            this.doYouWantToBeFashion = false;

            System.out.println("Importance is too high for this cloth");
            System.out.println("By default it is set to 0");

            this.importance = 0;
        }
        else if(isClothImportant && doYouNeedIt && doYouWantToBeFashion) {
            this.importance = 0;
        }
    }

    public String getClothType() {
        return clothType;
    }

    public void setClothType(String clothType) {
        this.clothType = clothType;
    }

    public boolean isClothImportant() {
        return isClothImportant;
    }

    public void setClothImportant(boolean clothImportant) {
        isClothImportant = clothImportant;
    }

    public boolean isDoYouWantToBeFashion() {
        return doYouWantToBeFashion;
    }

    public void setDoYouWantToBeFashion(boolean doYouWantToBeFashion) {
        this.doYouWantToBeFashion = doYouWantToBeFashion;
    }

    public boolean isDoYouNeedIt() {
        return doYouNeedIt;
    }

    public void setDoYouNeedIt(boolean doYouNeedIt) {
        this.doYouNeedIt = doYouNeedIt;
    }
}
