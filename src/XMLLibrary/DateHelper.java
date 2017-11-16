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
        String year = xmlMonth.getDateBegin().getYear();
        String month = xmlMonth.getDateBegin().getMonth();
        String day = xmlMonth.getDateBegin().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }

    public static LocalDate endDateFromXMLMonth(TotalMonthType xmlMonth) {
        String year = xmlMonth.getDateEnd().getYear();
        String month = xmlMonth.getDateEnd().getMonth();
        String day = xmlMonth.getDateEnd().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }

    public static LocalDate beginDateFromXMLWeek(TotalWeekType xmlWeek) {
        String year = xmlWeek.getDateBegin().getYear();
        String month = xmlWeek.getDateBegin().getMonth();
        String day = xmlWeek.getDateBegin().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }

    public static LocalDate endDateFromXMLWeek(TotalWeekType xmlWeek) {
        String year = xmlWeek.getDateEnd().getYear();
        String month = xmlWeek.getDateEnd().getMonth();
        String day = xmlWeek.getDateEnd().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }

    public static LocalDate dateFromXMLDay(TotalDayType xmlDay) {
        String year = xmlDay.getDateDay().getYear();
        String month = xmlDay.getDateDay().getMonth();
        String day = xmlDay.getDateDay().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }
}
