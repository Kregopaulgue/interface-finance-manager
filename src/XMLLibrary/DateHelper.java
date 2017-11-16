package XMLLibrary;

import Generated.TotalDayType;
import Generated.TotalMonthType;
import Generated.TotalWeekType;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Created by Master on 31.10.2017.
 */
public class DateHelper {

    public static boolean lessCompareDates(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isBefore(secondDate);
    }

    public static boolean biggerCompareDates(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isAfter(secondDate);
    }

    public static boolean betweenCompareDates(LocalDate beginDate, LocalDate midDate,
                                              LocalDate endDate) {
        boolean midDateAfterBegin = beginDate.isBefore(midDate) || beginDate.isEqual(midDate);
        boolean midDateBeforeEnd = endDate.isAfter(midDate) || endDate.isEqual(midDate);

        return midDateAfterBegin && midDateBeforeEnd;
    }

    public static LocalDate dateFromStringYearMonthDay(String year, String month, String day) {

        Integer argumentYear, argumentMonth, argumentDay;
        argumentYear = Integer.valueOf(year);
        argumentMonth = Integer.valueOf(month);
        argumentDay = Integer.valueOf(day);

        return LocalDate.of(argumentYear, argumentMonth, argumentDay);

    }

    public static LocalDate beginDateFromXMLMonth(TotalMonthType xmlMonth) {
        int year = xmlMonth.getDateBegin().getYear();
        int month = xmlMonth.getDateBegin().getMonth();
        int day = xmlMonth.getDateBegin().getDay();
        return LocalDate.of(year, month, day);
    }

    public static LocalDate endDateFromXMLMonth(TotalMonthType xmlMonth) {
        int year = xmlMonth.getDateEnd().getYear();
        int month = xmlMonth.getDateEnd().getMonth();
        int day = xmlMonth.getDateEnd().getDay();
        return LocalDate.of(year, month, day);
    }

    public static LocalDate beginDateFromXMLWeek(TotalWeekType xmlWeek) {
        int year = xmlWeek.getDateBegin().getYear();
        int month = xmlWeek.getDateBegin().getMonth();
        int day = xmlWeek.getDateBegin().getDay();
        return LocalDate.of(year, month, day);
    }

    public static LocalDate endDateFromXMLWeek(TotalWeekType xmlWeek) {
        int year = xmlWeek.getDateEnd().getYear();
        int month = xmlWeek.getDateEnd().getMonth();
        int day = xmlWeek.getDateEnd().getDay();
        return LocalDate.of(year, month, day);
    }

    public static LocalDate dateFromXMLDay(TotalDayType xmlDay) {
        int year = xmlDay.getDateDay().getYear();
        int month = xmlDay.getDateDay().getMonth();
        int day = xmlDay.getDateDay().getDay();
        return LocalDate.of(year, month, day);
    }
}
