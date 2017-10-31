package XMLLibrary;

import ExpenceEntries.ExpenceEntry;
import ExpenceEntries.FoodExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import Generated.*;
import HelperTypes.ExpenceEntryType;
import HelperTypes.FoodType;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalWeekEntries;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Master on 23.10.2017.
 */
public class XMLReader {

    public static List<TotalMonthEntries> readMonthFromXML(Calendar date) throws JAXBException, IOException{

        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        JAXBElement<TotalTimeType> totalTimeTypeJAXBElement =
                (JAXBElement<TotalTimeType>) unmarshaller.unmarshal(new FileInputStream("main_entry_history.xml"));

        TotalTimeType totalTime = totalTimeTypeJAXBElement.getValue();

        TotalMonthType neededMonth = new TotalMonthType();
        TotalMonthEntries neededMonthEntry;

        ArrayList<TotalMonthType> totalMonthsXMLEntry = new ArrayList<TotalMonthType>(totalTime.getTotalMonth());

        for(TotalMonthType tempMonth : totalMonthsXMLEntry) {
            DateBeginType currentBeginType = tempMonth.getDateBegin();

            Integer beginYears = Integer.valueOf(currentBeginType.getYear());
            Integer beginMonth = Integer.valueOf(currentBeginType.getMonth());
            Integer beginDay = Integer.valueOf(currentBeginType.getDay());

            GregorianCalendar currentBeginDate = new GregorianCalendar(beginYears, beginMonth, beginDay);

            DateEndType currentEndType = tempMonth.getDateEnd();

            Integer endYears = Integer.valueOf(currentEndType.getDay());
            Integer endMonth = Integer.valueOf(currentEndType.getMonth());
            Integer endDay = Integer.valueOf(currentEndType.getDay());

            GregorianCalendar currentEndDate = new GregorianCalendar(endYears, endMonth, endDay);

            if(currentBeginDate.getTimeInMillis() <= date.getTimeInMillis()
                    && currentEndDate.getTimeInMillis() >= date.getTimeInMillis()) {
                neededMonth = tempMonth;
            }

            ArrayList<TotalWeekType> totalWeeks = new ArrayList<>(neededMonth.getTotalWeek());
            ArrayList<ArrayList<TotalDayType>> totalDaysByWeeks = new ArrayList<>();
            for(TotalWeekType tempTotalWeek : totalWeeks) {
                totalDaysByWeeks.add(new ArrayList<>(tempTotalWeek.getTotalDay()));
            }

            ArrayList<ArrayList<TotalDayEntries>> totalDayEntriesByWeeks = new ArrayList<>();
            for(ArrayList<TotalDayType> tempTotalDays : totalDaysByWeeks) {
                ArrayList<TotalDayEntries> currentTotalDayEntires = new ArrayList<>();
                for(TotalDayType tempTotalDay : tempTotalDays) {
                    ArrayList<ExpenceType> currentSimpleExpences = new ArrayList<>(tempTotalDay.getExpence());
                    ArrayList<OtherExpenceEntry> currentExpenceEntries = new ArrayList<>()();
                    currentTotalDayEntires.add(new TotalDayEntries());
                }
            }
            ArrayList<TotalWeekEntries> totalWeekEntries = new ArrayList<>(totalWeeks.size());
            for(int i = 0; i < totalWeeks.size(); i++) {
                totalWeekEntries.get(i) = new TotalWeekEntries()
            }

            neededMonthEntry = new TotalMonthEntries()
        }
    }
}
