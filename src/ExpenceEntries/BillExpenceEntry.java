package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.util.Calendar;

/**
 * Created by Master on 20.10.2017.
 */

/*
    BillExpenceEntry:
    {
        moneySpent: Double,
        importance: Integer,
        comment: String,
        time: Calendar,
        Calendar: Calendar,
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
    }

    public BillExpenceEntry(Double moneySpent, Integer importance,
                            String comment, Calendar time, Calendar Calendar,
                            ExpenceEntryType entryType, String billDescription) {
        super(moneySpent, 10, comment, time, Calendar, entryType);
        this.entryType = ExpenceEntryType.BILL;
        this.billDescription = billDescription;
    }

    public String getBillDescription() {
        return billDescription;
    }

    public void setBillDescription(String billDescription) {
        this.billDescription = billDescription;
    }
}
