package ExpenceEntries;

import HelperTypes.ExpenceEntryType;
import HelperTypes.TechnicType;

import java.util.Calendar;

/**
 * Created by Master on 20.10.2017.
 */
public class TechnicExpenceEntry extends OtherExpenceEntry {

    private TechnicType technicType;
    private String textTechnicType = new String("");
    private Double durability;

    public TechnicExpenceEntry(Double moneySpent, Integer importance,
                               String comment, TechnicType technicType, String textTechnicType, Double durability) {
        super(moneySpent, importance, comment);

        this.entryType = ExpenceEntryType.TECHNIC;

        if(technicType == TechnicType.OTHER) {
            this.technicType = TechnicType.OTHER;
            this.textTechnicType= textTechnicType;
        }
        else
        {
            this.technicType = technicType;
        }
        this.textTechnicType = textTechnicType;
        this.durability = durability;
    }

    public TechnicExpenceEntry(Double moneySpent, Integer importance, String comment,
                               Calendar time, Calendar Calendar, ExpenceEntryType entryType,
                               TechnicType technicType, String textTechnicType, Double durability) {
        super(moneySpent, importance, comment, time, Calendar, entryType);

        this.entryType = ExpenceEntryType.TECHNIC;

        if(technicType == TechnicType.OTHER) {
            this.technicType = TechnicType.OTHER;
            this.textTechnicType= textTechnicType;
        }
        else
        {
            this.technicType = technicType;
        }
        this.textTechnicType = textTechnicType;
        this.durability = durability;
    }

    public void checkForImportance(TechnicType technicType, Double durability) {

        if(technicType == TechnicType.GAMING_HARDWARE) {

            System.out.println("Importance is too high for this technic");
            System.out.println("By default it is set to 0");
            this.importance = 0;
        }

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

    public Double getDurability() {
        return durability;
    }

    public void setDurability(Double durability) {
        this.durability = durability;
    }
}
