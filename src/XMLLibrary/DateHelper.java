package XMLLibrary;

import Generated.TotalDayType;
import Generated.TotalMonthType;
import Generated.TotalWeekType;

import java.util.GregorianCalendar;

/**
 * Created by Master on 31.10.2017.
 */
public class DateHelper {

    public static boolean lessCompareDates(GregorianCalendar firstDate, GregorianCalendar secondDate) {
        return firstDate.getTimeInMillis() < secondDate.getTimeInMillis();
    }

    public static boolean biggerCompareDates(GregorianCalendar firstDate, GregorianCalendar secondDate) {
        return firstDate.getTimeInMillis() > secondDate.getTimeInMillis();
    }

    public static boolean betweenCompareDates(GregorianCalendar beginDate, GregorianCalendar midDate,
                                              GregorianCalendar endDate) {
        boolean midDateAfterBegin = beginDate.getTimeInMillis() <= midDate.getTimeInMillis();
        boolean midDateBeforeEnd = endDate.getTimeInMillis() >= midDate.getTimeInMillis();

        return midDateAfterBegin && midDateBeforeEnd;
    }

    public static GregorianCalendar dateFromStringYearMonthDay(String year, String month, String day) {

        Integer argumentYear, argumentMonth, argumentDay;
        argumentYear = Integer.valueOf(year);
        argumentMonth = Integer.valueOf(month);
        argumentDay = Integer.valueOf(day);

        return new GregorianCalendar(argumentYear, argumentMonth, argumentDay);

    }

    public static GregorianCalendar beginDateFromXMLMonth(TotalMonthType xmlMonth) {
        String year = xmlMonth.getDateBegin().getYear();
        String month = xmlMonth.getDateBegin().getMonth();
        String day = xmlMonth.getDateBegin().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }

    public static GregorianCalendar endDateFromXMLMonth(TotalMonthType xmlMonth) {
        String year = xmlMonth.getDateEnd().getYear();
        String month = xmlMonth.getDateEnd().getMonth();
        String day = xmlMonth.getDateEnd().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }

    public static GregorianCalendar beginDateFromXMLWeek(TotalWeekType xmlWeek) {
        String year = xmlWeek.getDateBegin().getYear();
        String month = xmlWeek.getDateBegin().getMonth();
        String day = xmlWeek.getDateBegin().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }

    public static GregorianCalendar endDateFromXMLWeek(TotalWeekType xmlWeek) {
        String year = xmlWeek.getDateEnd().getYear();
        String month = xmlWeek.getDateEnd().getMonth();
        String day = xmlWeek.getDateEnd().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }

    public static GregorianCalendar dateFromXMLDay(TotalDayType xmlDay) {
        String year = xmlDay.getDateDay().getYear();
        String month = xmlDay.getDateDay().getMonth();
        String day = xmlDay.getDateDay().getDay();
        return dateFromStringYearMonthDay(year, month, day);
    }
}
