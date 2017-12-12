package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Created by Master on 18.10.2017.
 */

public class ClothExpenceEntry extends OtherExpenceEntry {

    private String clothType;

    public ClothExpenceEntry(Double moneySpent, Integer importance, String comment,
                             LocalDate GregorianCalendar, String clothType) {
        super(moneySpent, importance, comment, GregorianCalendar, clothType);

        this.entryType = ExpenceEntryType.CLOTH;
        this.clothType = clothType;
        this.expenceDescription = clothType;
    }
}
