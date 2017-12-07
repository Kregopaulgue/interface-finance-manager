package XMLLibrary;

import ExpenceEntries.OtherExpenceEntry;
import Generated.*;
import HelperTypes.ExpenceEntryType;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalWeekEntries;

import javax.xml.bind.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.jar.JarException;

/**
 * Created by Master on 23.10.2017.
 */
public class XMLWriter {

    public static void writeFullTimeToXML(TotalTimeType totalTime, String filePath) throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        try {
            javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(totalTime, new FileWriter(filePath));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }


    }

    public static ExpenceType convertFromEntryToXML(OtherExpenceEntry entry) {
        ExpenceType entryToWrite = new ExpenceType();

        entryToWrite.setComment(entry.getComment());

        entryToWrite.setDate(new DateType());

        entryToWrite.getDate().setDay(entry.getCalendar().getDayOfMonth());
        entryToWrite.getDate().setMonth(entry.getCalendar().getMonth().getValue());
        entryToWrite.getDate().setYear(entry.getCalendar().getYear());

        entryToWrite.setExpenceDescription(entry.getSpecialDescription());
        entryToWrite.setExpenceType(entry.getEntryType().toString());
        entryToWrite.setImportance(entry.getImportance());
        entryToWrite.setMoneySpent(entry.getMoneySpent());

        return entryToWrite;
    }

    public static TotalDayType convertFromDayEntryToXML(TotalDayEntries dayEntry) {
        TotalDayType dayToWrite = new TotalDayType();

        dayToWrite.setDateDay(new DateDayType());

        for(int i = 0; i < dayEntry.getSimpleEntriesAmount(); i++) {
            dayToWrite.getExpence().add(convertFromEntryToXML(dayEntry.getCertainSimpleEntry(i)));
        }

        dayToWrite.getDateDay().setDay(dayEntry.getDayDate().getDayOfMonth());
        dayToWrite.getDateDay().setMonth(dayEntry.getDayDate().getMonth().getValue());
        dayToWrite.getDateDay().setYear(dayEntry.getDayDate().getYear());

        return dayToWrite;
    }

    public static TotalWeekType convertFromWeekEntryToXML(TotalWeekEntries weekEntry) {
        TotalWeekType weekToWrite = new TotalWeekType();

        weekToWrite.setDateBegin(new DateBeginType());
        weekToWrite.setDateEnd(new DateEndType());

        for(int i = 0; i < weekEntry.getAllDayEntriesInWeek().size(); i++) {
            weekToWrite.getTotalDay().add(convertFromDayEntryToXML(weekEntry.getCertainDay(i)));
        }

        weekToWrite.getDateBegin().setDay(weekEntry.getBeggingDate().getDayOfMonth());
        weekToWrite.getDateBegin().setMonth(weekEntry.getBeggingDate().getMonth().getValue());
        weekToWrite.getDateBegin().setYear(weekEntry.getBeggingDate().getYear());

        weekToWrite.getDateEnd().setDay(weekEntry.getEndDate().getDayOfMonth());
        weekToWrite.getDateEnd().setMonth(weekEntry.getEndDate().getMonth().getValue());
        weekToWrite.getDateEnd().setYear(weekEntry.getEndDate().getYear());

        return weekToWrite;
    }

    public static TotalMonthType convertFromMonthEntryToXML(TotalMonthEntries monthEntry) {
        TotalMonthType monthToWrite = new TotalMonthType();

        monthToWrite.setDateEnd(new DateEndType());
        monthToWrite.setDateBegin(new DateBeginType());

        for(int i = 0; i < monthEntry.getAllWeekEntriesInMonth().size(); i++) {
            monthToWrite.getTotalWeek().add(convertFromWeekEntryToXML(monthEntry.getCertainWeek(i)));
        }

        monthToWrite.getDateBegin().setDay(monthEntry.getBeggingDate().getDayOfMonth());
        monthToWrite.getDateBegin().setMonth(monthEntry.getBeggingDate().getMonth().getValue());
        monthToWrite.getDateBegin().setYear(monthEntry.getBeggingDate().getYear());

        monthToWrite.getDateEnd().setDay(monthEntry.getEndDate().getDayOfMonth());
        monthToWrite.getDateEnd().setMonth(monthEntry.getEndDate().getMonth().getValue());
        monthToWrite.getDateEnd().setYear(monthEntry.getEndDate().getYear());

        return monthToWrite;
    }

    public static TotalTimeType convertFullTimeToXML(ArrayList<TotalMonthEntries> monthes) {
        TotalTimeType totalTime = new TotalTimeType();

        for(TotalMonthEntries tempMonth : monthes) {
            totalTime.getTotalMonth().add(convertFromMonthEntryToXML(tempMonth));
        }

        return totalTime;
    }
}


