package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.util.Calendar;

/**
 * Created by Master on 20.10.2017.
 */

/*
    EntertainmentExpenceEntry:
    {
        moneySpent: Double,
        importance: Integer,
        comment: String,
        time: Calendar,
        Calendar: Calendar,
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
    }

    public EntertainmentExpenceEntry(Double moneySpent, Integer importance,
                                     String comment, Calendar time, Calendar Calendar,
                                     ExpenceEntryType entryType, String entertainmentDescription) {
        super(moneySpent, 0, comment, time, Calendar, entryType);
        this.entryType = ExpenceEntryType.ENTERTAINMENT;
        this.entertainmentDescription = entertainmentDescription;
    }

    public String getEntertainmentDescription() {
        return entertainmentDescription;
    }

    public void setEntertainmentDescription(String entertainmentDescription) {
        this.entertainmentDescription = entertainmentDescription;
    }
}
