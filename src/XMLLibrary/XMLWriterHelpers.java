package XMLLibrary;

import Generated.*;
import TotalTimeEntries.TotalMonthEntries;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.GregorianCalendar;

/**
 * Created by Master on 31.10.2017.
 */
public class XMLWriterHelpers {

    final static Integer FIRST_DAY = 1;
    final static Integer FIRST_LAST_DAY = 30;
    final static Integer SECOND_LAST_DAY = 31;
    final static Integer FEBRUARY_LAST_DAY = 28;

    final static Integer[] FIRST_LAST_DAY_MONTHS = {3, 5, 8, 10};
    final static Integer[] SECOND_LAST_DAY_MONTHS = {0, 2, 4, 6, 7, 9, 11};
    final static Integer FEBRUARY_INDEX = 1;

    final static Integer[] WEEK_BEGIN_AND_END_DAYS = {1, 7, 8, 14, 15, 21, 22, 28};

    final static Integer AMOUNT_OF_WEEKS = 5;
    final static Integer AMOUNT_OF_WEEKS_IN_FEBRUARY = 4;

    public static void addFullYearToXml() throws JAXBException, IOException{

        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        TotalTimeType totalTime = new TotalTimeType();
        Date curr = new Date();
        GregorianCalendar current = new GregorianCalendar(2017, 10, 30);
        //fix current date getting

        Integer currentYear = current.getTime().getYear();
        Integer currentMonth = current.getTime().getMonth();
        Integer currentDay = current.getTime().getDay();

        TotalMonthType[] totalMonths = new TotalMonthType[12];
        for(int i = 0; i < totalMonths.length; i++) {
            totalMonths[i] = createEmptyMonth(new GregorianCalendar(currentYear, i, currentDay));
            totalTime.getTotalMonth().add(totalMonths[i]);
        }

        try {
            javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(totalTime, new FileWriter("test_output.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void addEmptyMonthToXml(GregorianCalendar date) throws JAXBException, FileNotFoundException{

        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        TotalTimeType totalTime = new TotalTimeType();

        totalTime.getTotalMonth().add(createEmptyMonth(date));

        try {
            javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(totalTime, new FileWriter("test_output.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public static TotalMonthType createEmptyMonth(GregorianCalendar date) {
        TotalMonthType newMonth = new TotalMonthType();
        Integer year = date.getTime().getYear();
        Integer month = date.getTime().getMonth();

        DateBeginType dateBegin = new DateBeginType();
        dateBegin.setDay(FIRST_DAY.toString());
        dateBegin.setMonth(month.toString());
        dateBegin.setYear(year.toString());

        newMonth.setDateBegin(dateBegin);

        DateEndType dateEnd = new DateEndType();

        if(Arrays.asList(FIRST_LAST_DAY_MONTHS).contains(month)) {
            dateEnd.setDay(FIRST_LAST_DAY.toString());
        }
        else if(month.equals(FEBRUARY_INDEX)) {
            dateEnd.setDay(FEBRUARY_LAST_DAY.toString());
        }
        else {
            dateEnd.setDay(SECOND_LAST_DAY.toString());
        }
        dateEnd.setMonth(month.toString());
        dateEnd.setYear(year.toString());

        newMonth.setDateEnd(dateEnd);

        if(month.equals(FEBRUARY_INDEX)) {
            for(int i = 0; i < AMOUNT_OF_WEEKS_IN_FEBRUARY; i++) {
                GregorianCalendar firstWeekDay = new GregorianCalendar(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2]);
                GregorianCalendar secondWeekDay = new GregorianCalendar(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2 + 1]);
                newMonth.getTotalWeek().add(createEmptyWeek(firstWeekDay, secondWeekDay));
            }
        }
        else {
            addWeeksToMonth(newMonth, year, month);
        }

        return newMonth;
    }

    public static TotalWeekType createEmptyWeek(GregorianCalendar firstDate, GregorianCalendar secondDate) {
        TotalWeekType newWeek = new TotalWeekType();
        Integer beginYear = firstDate.getTime().getYear();
        Integer beginMonth = firstDate.getTime().getMonth();
        Integer beginDay = firstDate.getTime().getDay();

        DateBeginType dateBegin = new DateBeginType();
        dateBegin.setDay(beginDay.toString());
        dateBegin.setMonth(beginMonth.toString());
        dateBegin.setYear(beginYear.toString());

        newWeek.setDateBegin(dateBegin);

        DateEndType dateEnd = new DateEndType();

        Integer endYear = secondDate.getTime().getYear();
        Integer endMonth = secondDate.getTime().getMonth();
        Integer endDay = secondDate.getTime().getDay();

        dateEnd.setMonth(endMonth.toString());
        dateEnd.setYear(endYear.toString());
        dateEnd.setDay(endDay.toString());

        newWeek.setDateEnd(dateEnd);

        for(int loopDay = beginDay; loopDay <= endDay; loopDay++) {
            newWeek.getTotalDay().add(createEmptyDay(new GregorianCalendar(beginYear, beginMonth, loopDay)));
        }

        return newWeek;
    }

    public static TotalDayType createEmptyDay(GregorianCalendar date) {

        TotalDayType newDay = new TotalDayType();

        DateDayType dateDay = new DateDayType();

        Integer year = date.getTime().getYear();
        Integer month = date.getTime().getMonth();
        Integer day = date.getTime().getDay();

        dateDay.setYear(year.toString());
        dateDay.setMonth(month.toString());
        dateDay.setDay(day.toString());

        return newDay;
    }

    public static void addWeeksToMonth(TotalMonthType totalMonth, Integer year, Integer month) {
        for(int i = 0; i < AMOUNT_OF_WEEKS - 1; i++) {
            GregorianCalendar firstWeekDay = new GregorianCalendar(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2]);
            GregorianCalendar secondWeekDay = new GregorianCalendar(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2 + 1]);
            totalMonth.getTotalWeek().add(createEmptyWeek(firstWeekDay, secondWeekDay));
        }
        GregorianCalendar firstWeekDay = new GregorianCalendar(year, month, 29);
        GregorianCalendar secondWeekDay;
        if(totalMonth.getDateEnd().getDay().equals("30")) {
            secondWeekDay = new GregorianCalendar(year, month, 30);
        }
        else {
            secondWeekDay = new GregorianCalendar(year, month, 31);
        }
        totalMonth.getTotalWeek().add(createEmptyWeek(firstWeekDay, secondWeekDay));
    }
}
