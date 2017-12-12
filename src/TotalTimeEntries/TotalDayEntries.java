package TotalTimeEntries;

import ExpenceEntries.OtherExpenceEntry;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 * Created by Master on 20.10.2017.
 */

public class TotalDayEntries extends TotalTimeEntry{

    private LocalDate dayDate;

    public TotalDayEntries() {super();}

    public TotalDayEntries(ArrayList<OtherExpenceEntry> simpleEntries, LocalDate dayDate) {
        super(simpleEntries);
        this.dayDate = dayDate;
    }

    public LocalDate getDayDate() {
        return dayDate;
    }

    public void setDayDate(LocalDate dayDate) {
        this.dayDate = dayDate;
    }

    public String getInfo() {
        String informationToReturn = new String();
        informationToReturn += "All money spent: " + this.allMoneySpent.toString() +
                "\nAverage money spent: " + this.averageMoneySpent.toString() +
                "\nDate: " + getDayDate().toString() +
                "\nSimple entries amount: " + this.entriesAmount.toString() +
                "\nSimple entries: \n";
        for(OtherExpenceEntry tempExpence : this.simpleEntries) {
            informationToReturn += "   " + tempExpence.toString();
        }
        return informationToReturn;
    }

    @Override
    public String toString() {
        return this.dayDate.toString();
    }
}
