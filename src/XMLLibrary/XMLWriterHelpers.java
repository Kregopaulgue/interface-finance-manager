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
import java.time.LocalDate;
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

    final static Integer[] FIRST_LAST_DAY_MONTHS = {4, 6, 9, 11};
    final static Integer[] SECOND_LAST_DAY_MONTHS = {1, 3, 5, 7, 8, 10, 12};
    final static Integer FEBRUARY_INDEX = 2;

    final static Integer[] WEEK_BEGIN_AND_END_DAYS = {1, 7, 8, 14, 15, 21, 22, 28};

    final static Integer AMOUNT_OF_WEEKS = 5;
    final static Integer AMOUNT_OF_WEEKS_IN_FEBRUARY = 4;

    public static void addFullYearToXml() throws JAXBException, IOException{

        addEmptyMonthToXml(LocalDate.of(2017, 1, 1));
    }

    public static void addEmptyMonthToXml(LocalDate date) throws JAXBException, FileNotFoundException{

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

    public static TotalMonthType createEmptyMonth(LocalDate date) {
        TotalMonthType newMonth = new TotalMonthType();
        Integer year = date.getYear();
        Integer month = date.getMonth().getValue();

        DateBeginType dateBegin = new DateBeginType();
        dateBegin.setDay(FIRST_DAY);
        dateBegin.setMonth(month);
        dateBegin.setYear(year);

        newMonth.setDateBegin(dateBegin);

        DateEndType dateEnd = new DateEndType();

        if(Arrays.asList(FIRST_LAST_DAY_MONTHS).contains(month)) {
            dateEnd.setDay(FIRST_LAST_DAY);
        }
        else if(month.equals(FEBRUARY_INDEX)) {
            dateEnd.setDay(FEBRUARY_LAST_DAY);
        }
        else {
            dateEnd.setDay(SECOND_LAST_DAY);
        }
        dateEnd.setMonth(month);
        dateEnd.setYear(year);

        newMonth.setDateEnd(dateEnd);

        if(month.equals(FEBRUARY_INDEX)) {
            for(int i = 0; i < AMOUNT_OF_WEEKS_IN_FEBRUARY; i++) {
                LocalDate firstWeekDay = LocalDate.of(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2]);
                LocalDate secondWeekDay = LocalDate.of(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2 + 1]);
                newMonth.getTotalWeek().add(createEmptyWeek(firstWeekDay, secondWeekDay));
            }
        }
        else {
            addWeeksToMonth(newMonth, year, month);
        }

        return newMonth;
    }

    public static TotalWeekType createEmptyWeek(LocalDate firstDate, LocalDate secondDate) {
        TotalWeekType newWeek = new TotalWeekType();
        Integer beginYear = firstDate.getYear();
        Integer beginMonth = firstDate.getMonth().getValue();
        Integer beginDay = firstDate.getDayOfMonth();

        DateBeginType dateBegin = new DateBeginType();
        dateBegin.setDay(beginDay);
        dateBegin.setMonth(beginMonth);
        dateBegin.setYear(beginYear);

        newWeek.setDateBegin(dateBegin);

        DateEndType dateEnd = new DateEndType();

        Integer endYear = secondDate.getYear();
        Integer endMonth = secondDate.getMonth().getValue();
        Integer endDay = secondDate.getDayOfMonth();

        dateEnd.setMonth(endMonth);
        dateEnd.setYear(endYear);
        dateEnd.setDay(endDay);

        newWeek.setDateEnd(dateEnd);

        for(int loopDay = beginDay; loopDay <= endDay; loopDay++) {
            newWeek.getTotalDay().add(createEmptyDay(LocalDate.of(beginYear, beginMonth, loopDay)));
        }

        return newWeek;
    }

    public static TotalDayType createEmptyDay(LocalDate date) {

        TotalDayType newDay = new TotalDayType();

        DateDayType dateDay = new DateDayType();

        Integer year = date.getYear();
        Integer month = date.getMonth().getValue();
        Integer day = date.getDayOfMonth();

        dateDay.setYear(year);
        dateDay.setMonth(month);
        dateDay.setDay(day);

        newDay.setDateDay(dateDay);
        return newDay;
    }

    public static void addWeeksToMonth(TotalMonthType totalMonth, Integer year, Integer month) {
        for(int i = 0; i < AMOUNT_OF_WEEKS - 1; i++) {
            LocalDate firstWeekDay = LocalDate.of(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2]);
            LocalDate secondWeekDay = LocalDate.of(year, month, WEEK_BEGIN_AND_END_DAYS[i * 2 + 1]);
            totalMonth.getTotalWeek().add(createEmptyWeek(firstWeekDay, secondWeekDay));
        }
        LocalDate firstWeekDay = LocalDate.of(year, month, 29);
        LocalDate secondWeekDay;
        if(totalMonth.getDateEnd().getDay() == 30) {
            secondWeekDay = LocalDate.of(year, month, 30);
        }
        else {
            secondWeekDay = LocalDate.of(year, month, 31);
        }
        totalMonth.getTotalWeek().add(createEmptyWeek(firstWeekDay, secondWeekDay));
    }
}
