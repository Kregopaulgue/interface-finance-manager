package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Created by Master on 20.10.2017.
 */

/*
    EntertainmentExpenceEntry:
    {
        moneySpent: Double,
        importance: Integer,
        comment: String,
        time: GregorianCalendar,
        GregorianCalendar: GregorianCalendar,
        entryType: ExpenceEntryType,
        String: entertainmentDescription
    }
 */

public class EntertainmentExpenceEntry extends OtherExpenceEntry {

    //as its entertainment importance by default set 0

    String entertainmentDescription;

    public EntertainmentExpenceEntry(Double moneySpent, Integer importance,
                                     String comment, String entertainmentDescription) {
        super(moneySpent, 0, comment);
        this.entryType = ExpenceEntryType.ENTERTAINMENT;
        this.entertainmentDescription = entertainmentDescription;
        this.expenceDescription = entertainmentDescription;
    }

    public EntertainmentExpenceEntry(Double moneySpent, Integer importance,
                                     String comment, LocalDate GregorianCalendar, String entertainmentDescription) {
        super(moneySpent, 0, comment, GregorianCalendar, entertainmentDescription);
        this.entryType = ExpenceEntryType.ENTERTAINMENT;
        this.entertainmentDescription = entertainmentDescription;
        this.expenceDescription = entertainmentDescription;
    }

    public String getEntertainmentDescription() {
        return entertainmentDescription;
    }

    public void setEntertainmentDescription(String entertainmentDescription) {
        this.entertainmentDescription = entertainmentDescription;
    }
}
