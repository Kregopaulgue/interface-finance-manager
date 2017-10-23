package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.util.Calendar;

/**
 * Created by Master on 20.10.2017.
 */

/*
    Abstract ExpenceEntry:
    {
        moneySpent: Double,
        importance: Integer,
        comment: String,
        time: Calendar,
        Calendar: Calendar,
        entryType: ExpenceEntryType,
        String: serviceDescription
    }
 */

public class ServiceExpenceEntry extends OtherExpenceEntry {

    //it isnt different ot OtherExpenceEntry, but made for comfort

    String serviceDescription;

    public ServiceExpenceEntry(Double moneySpent, Integer importance,
                               String comment, String serviceDescription) {
        super(moneySpent, importance, comment);
        this.entryType = ExpenceEntryType.SERVICE;
        this.serviceDescription = serviceDescription;
    }

    public ServiceExpenceEntry(Double moneySpent, Integer importance,
                               String comment, Calendar time, Calendar Calendar,
                               ExpenceEntryType entryType, String serviceDescription) {
        super(moneySpent, importance, comment, time, Calendar, entryType);
        this.entryType = ExpenceEntryType.SERVICE;
        this.serviceDescription = serviceDescription;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}
