package XMLLibrary;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import Exceptions.DayNotFoundException;
import Exceptions.ExpenceNotFoundException;
import Exceptions.MonthNotFoundException;
import Exceptions.WeekNotFoundException;
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
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Master on 23.10.2017.
 */



public class XMLReader {

    public static ArrayList<TotalMonthEntries> readAllFromXml(String fileWay) throws JAXBException, IOException{
        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        TotalTimeType totalTime = (TotalTimeType) unmarshaller.unmarshal(new FileInputStream(fileWay));

        ArrayList<TotalMonthType> allXMLMonths = new ArrayList<>(totalTime.getTotalMonth());
        ArrayList<TotalMonthEntries> resultMonths = new ArrayList<>();

        for(int i = 0; i < allXMLMonths.size(); i++) {
            resultMonths.add(XMLReaderHelpers.convertFromXMLMonth(allXMLMonths.get(i)));
        }

        return resultMonths;
    }

    public static TotalMonthEntries readMonthFromXML(LocalDate date) throws JAXBException, IOException{

        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        JAXBElement<TotalTimeType> totalTimeTypeJAXBElement =
                (JAXBElement<TotalTimeType>) unmarshaller.unmarshal(new FileInputStream("main_entry_history.xml"));

        TotalTimeType totalTime = totalTimeTypeJAXBElement.getValue();

        TotalMonthEntries resultMonth = new TotalMonthEntries();

        ArrayList<TotalMonthType> totalXMLMonths = new ArrayList<>(totalTime.getTotalMonth());

        try {
            for(TotalMonthType tempXMLMonth : totalXMLMonths) {
                Integer beginYear = tempXMLMonth.getDateBegin().getYear();
                Integer beginMonth = tempXMLMonth.getDateBegin().getMonth();
                Integer beginDay = tempXMLMonth.getDateBegin().getDay();

                LocalDate beginingDate = LocalDate.of(beginYear, beginMonth, beginDay);

                Integer endYear = tempXMLMonth.getDateEnd().getYear();
                Integer endMonth = tempXMLMonth.getDateEnd().getMonth();
                Integer endDay = tempXMLMonth.getDateEnd().getDay();

                LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

                if(DateHelper.betweenCompareDates(beginingDate, date, endDate)) {
                    resultMonth = XMLReaderHelpers.convertFromXMLMonth(tempXMLMonth);
                }
            }
            if(resultMonth.equals(new TotalMonthEntries())) {
                throw new MonthNotFoundException();
            }
        } catch(MonthNotFoundException ex) {
            System.out.println("Can't find month u're looking for");
            System.out.println("Return null month");
        }

        return resultMonth;
    }

    public static TotalWeekEntries readWeekFromXml(LocalDate date) throws JAXBException, IOException{
        TotalMonthEntries monthToSeekIn = readMonthFromXML(date);
        TotalWeekEntries neededWeek = new TotalWeekEntries();

        try {
            for(TotalWeekEntries tempWeek : monthToSeekIn.getAllWeekEntriesInMonth()) {
                if(DateHelper.betweenCompareDates(tempWeek.getBeggingDate(), date, tempWeek.getEndDate())) {
                    neededWeek = tempWeek;
                }
            }
            if(neededWeek.equals(new TotalWeekEntries())) {
                throw new WeekNotFoundException();
            }
        } catch (WeekNotFoundException ex) {
            System.out.println("Can't find week you need");
            System.out.println("Return null week");
        }

        LocalDate sdate;
        return neededWeek;
    }

    public static TotalDayEntries readDayFromXml(LocalDate date) throws JAXBException, IOException {
        TotalWeekEntries weekToSeekIn = readWeekFromXml(date);
        TotalDayEntries neededDay = new TotalDayEntries();

        try {
            for(TotalDayEntries tempDay : weekToSeekIn.getAllDayEntriesInWeek()) {
                if(tempDay.getDayDate().equals(date)) {
                    neededDay = tempDay;
                }
            }
            if(neededDay.equals(new TotalDayEntries())) {
                throw new DayNotFoundException();
            }
        } catch (DayNotFoundException ex) {
            System.out.println("Can't find day you need");
            System.out.println("Return null day");
        }

        return neededDay;
    }

    public static OtherExpenceEntry readEntryFromXml(LocalDate date, int index)
            throws JAXBException, IOException{

        OtherExpenceEntry neededEntry = new OtherExpenceEntry();

        try {
            TotalDayEntries dayToSeekIn = readDayFromXml(date);
            neededEntry = dayToSeekIn.getSimpleEntries().get(index);
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("Expence entry you need is not found or index is wrong");
            System.out.println("Return null entry");
        }

        return neededEntry;
    }

    public static CombinedOtherExpenceEntry readCombinedEntryFromXml(LocalDate date, int index)
            throws JAXBException, IOException{
        TotalDayEntries dayToSeekIn = readDayFromXml(date);
        CombinedOtherExpenceEntry neededCombinedEntry = new CombinedOtherExpenceEntry();

        try {
            neededCombinedEntry = dayToSeekIn.getCombinedEntries().get(index);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Combined entry you need not found");
            System.out.println("Returned null entry");
        }

        return neededCombinedEntry;
    }

}
