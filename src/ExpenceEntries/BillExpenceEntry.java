package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Created by Master on 20.10.2017.
 */

/*
    BillExpenceEntry:
    {
        moneySpent: Double,
        importance: Integer,
        comment: String,
        time: GregorianCalendar,
        GregorianCalendar: GregorianCalendar,
        entryType: ExpenceEntryType,
        String: billDescription
    }
 */

public class BillExpenceEntry extends OtherExpenceEntry{

    //importance by default set to 10
    //and made almost for comfort too

    String billDescription;

    public BillExpenceEntry(Double moneySpent, Integer importance,
                            String comment, String billDescription) {
        super(moneySpent, 10, comment);
        this.entryType = ExpenceEntryType.BILL;
        this.billDescription = billDescription;
        this.expenceDescription = billDescription;
    }

    public BillExpenceEntry(Double moneySpent, Integer importance,
                            String comment, LocalDate GregorianCalendar, String billDescription) {
        super(moneySpent, 10, comment, GregorianCalendar, billDescription);
        this.entryType = ExpenceEntryType.BILL;
        this.billDescription = billDescription;
        this.expenceDescription = billDescription;
    }

    public String getBillDescription() {
        return billDescription;
    }

    public void setBillDescription(String billDescription) {
        this.billDescription = billDescription;
    }
}
