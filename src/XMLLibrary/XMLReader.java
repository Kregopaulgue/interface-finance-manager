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
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Master on 23.10.2017.
 */



public class XMLReader {

    public static TotalMonthEntries readMonthFromXML(GregorianCalendar date) throws JAXBException, IOException{

        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        JAXBElement<TotalTimeType> totalTimeTypeJAXBElement =
                (JAXBElement<TotalTimeType>) unmarshaller.unmarshal(new FileInputStream("main_entry_history.xml"));

        TotalTimeType totalTime = totalTimeTypeJAXBElement.getValue();

        TotalMonthEntries resultMonth = new TotalMonthEntries();

        ArrayList<TotalMonthType> totalXMLMonths = new ArrayList<>(totalTime.getTotalMonth());

        for(TotalMonthType tempXMLMonth : totalXMLMonths) {
            Integer beginYear = Integer.valueOf(tempXMLMonth.getDateBegin().getYear());
            Integer beginMonth = Integer.valueOf(tempXMLMonth.getDateBegin().getMonth());
            Integer beginDay = Integer.valueOf(tempXMLMonth.getDateBegin().getDay());

            GregorianCalendar beginingDate = new GregorianCalendar(beginYear, beginMonth, beginDay);

            Integer endYear = Integer.valueOf(tempXMLMonth.getDateEnd().getYear());
            Integer endMonth = Integer.valueOf(tempXMLMonth.getDateEnd().getMonth());
            Integer endDay = Integer.valueOf(tempXMLMonth.getDateEnd().getDay());

            GregorianCalendar endDate = new GregorianCalendar(endYear, endMonth, endDay);

            if(DateHelper.betweenCompareDates(beginingDate, date, endDate)) {
                resultMonth = XMLReaderHelpers.convertFromXMLMonth(tempXMLMonth);
            }
        }

        return resultMonth;
    }

    public static TotalWeekEntries readWeekFromXml(GregorianCalendar date) throws JAXBException, IOException{
        TotalMonthEntries monthToSeekIn = readMonthFromXML(date);
        TotalWeekEntries neededWeek = new TotalWeekEntries();

        for(TotalWeekEntries tempWeek : monthToSeekIn.getAllWeekEntriesInMonth()) {
            if(DateHelper.betweenCompareDates(tempWeek.getBeggingDate(), date, tempWeek.getEndDate())) {
                neededWeek = tempWeek;
            }
        }
        return neededWeek;
    }

    public static TotalDayEntries readDayFromXml(GregorianCalendar date) throws JAXBException, IOException {
        TotalWeekEntries weekToSeekIn = readWeekFromXml(date);
        TotalDayEntries neededDay = new TotalDayEntries();

        for(TotalDayEntries tempDay : weekToSeekIn.getAllDayEntriesInWeek()) {
            if(tempDay.getDayDate().equals(date)) {
                neededDay = tempDay;
            }
        }
        return neededDay;
    }

    public static OtherExpenceEntry readEntryFromXml(GregorianCalendar date, int index)
            throws JAXBException, IOException{
        TotalDayEntries dayToSeekIn = readDayFromXml(date);
        OtherExpenceEntry neededEntry = dayToSeekIn.getSimpleEntries().get(index);
        return neededEntry;
    }

}
