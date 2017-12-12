package ExpenceEntries;

import HelperTypes.ExpenceEntryType;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Created by Master on 20.10.2017.
 */

public class ServiceExpenceEntry extends OtherExpenceEntry {

    //it isnt different ot OtherExpenceEntry, but made for comfort

    String serviceDescription;

    public ServiceExpenceEntry(Double moneySpent, Integer importance,
                               String comment, String serviceDescription) {
        super(moneySpent, importance, comment);
        this.entryType = ExpenceEntryType.SERVICE;
        this.serviceDescription = serviceDescription;
        this.expenceDescription = serviceDescription;
    }

    public ServiceExpenceEntry(Double moneySpent, Integer importance,
                               String comment, LocalDate GregorianCalendar, String serviceDescription) {

        super(moneySpent, importance, comment, GregorianCalendar, serviceDescription);
        this.entryType = ExpenceEntryType.SERVICE;
        this.serviceDescription = serviceDescription;
        this.expenceDescription = serviceDescription;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}
