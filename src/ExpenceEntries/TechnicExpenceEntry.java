package ExpenceEntries;

import HelperTypes.ExpenceEntryType;
import HelperTypes.TechnicType;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Created by Master on 20.10.2017.
 */

/*
    TechnicExpenceEntry:
    {
        moneySpent: Double,
        importance: Integer,
        comment: String,
        time: GregorianCalendar,
        GregorianCalendar: GregorianCalendar,
        entryType: ExpenceEntryType,
        String: textTechnicType
    }
 */

public class TechnicExpenceEntry extends OtherExpenceEntry {

    private TechnicType technicType;
    private String textTechnicType = new String("");

    public TechnicExpenceEntry(Double moneySpent, Integer importance, String comment,
                               LocalDate GregorianCalendar, TechnicType technicType, String textTechnicType) {
        super(moneySpent, importance, comment, GregorianCalendar, textTechnicType);

        this.entryType = ExpenceEntryType.TECHNIC;

        if(technicType == TechnicType.OTHER) {
            this.technicType = TechnicType.OTHER;
            this.textTechnicType = textTechnicType;
            this.expenceDescription = TechnicType.OTHER.toString();
        }
        else
        {
            this.technicType = technicType;
            this.expenceDescription = technicType.toString();
        }
        this.textTechnicType = textTechnicType;
    }

    public TechnicType getTechnicType() {
        return technicType;
    }

    public void setTechnicType(TechnicType technicType) {
        this.technicType = technicType;
    }

    public String getTextTechnicType() {
        return textTechnicType;
    }

    public void setTextTechnicType(String textTechnicType) {
        this.textTechnicType = textTechnicType;
    }
}
