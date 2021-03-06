package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Created by Master on 20.10.2017.
 */

public class BillExpenceEntry extends OtherExpenceEntry{

    //importance by default set to 10
    //and made almost for comfort too

    public BillExpenceEntry(Double moneySpent, Integer importance,
                            String comment, String billDescription) {
        super(moneySpent, 10, comment);
        this.entryType = ExpenceEntryType.BILL;
        this.expenceDescription = billDescription;
    }

    public BillExpenceEntry(Double moneySpent, Integer importance,
                            String comment, LocalDate GregorianCalendar, String billDescription) {
        super(moneySpent, 10, comment, GregorianCalendar, billDescription);
        this.entryType = ExpenceEntryType.BILL;
        this.expenceDescription = billDescription;
    }
}
