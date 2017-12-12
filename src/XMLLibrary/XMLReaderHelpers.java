package XMLLibrary;

import ExpenceEntries.*;
import Generated.*;
import HelperTypes.ExpenceEntryType;
import HelperTypes.FoodType;
import HelperTypes.TechnicType;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalWeekEntries;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 * Created by Master on 25.10.2017.
 */
public class XMLReaderHelpers {

    public static OtherExpenceEntry convertFromXMLSimpleEntry(ExpenceType expenceEntry) {

        Double allMoneySpent = expenceEntry.getMoneySpent();
        String comment = expenceEntry.getComment();
        Integer importance = expenceEntry.getImportance();

        Integer year, month, day;
        year = expenceEntry.getDate().getYear();
        month = expenceEntry.getDate().getMonth();
        day = expenceEntry.getDate().getDay();

        LocalDate date = LocalDate.of(year, month, day);
        ExpenceEntryType currentExpenceType = ExpenceEntryType.valueOf(expenceEntry.getExpenceType());

        String specialTypeDescription = expenceEntry.getExpenceDescription();

        OtherExpenceEntry returnedEntry = new OtherExpenceEntry();
        switch(currentExpenceType.name()) {
            case "FOOD":
                returnedEntry = new FoodExpenceEntry(allMoneySpent, importance,
                        comment, date, FoodType.valueOf(specialTypeDescription), specialTypeDescription);
                break;
            case "TECHNIC":
                returnedEntry = new TechnicExpenceEntry(allMoneySpent, importance,
                        comment, date, TechnicType.valueOf(specialTypeDescription), specialTypeDescription);
                break;
            case "CLOTH":
                returnedEntry = new ClothExpenceEntry(allMoneySpent, importance,
                        comment, date, specialTypeDescription);
                break;
            case "ENTERTAINMENT":
                returnedEntry = new EntertainmentExpenceEntry(allMoneySpent, importance,
                        comment, date, specialTypeDescription);
            case "BILL":
                returnedEntry = new BillExpenceEntry(allMoneySpent, importance,
                        comment, date, specialTypeDescription);
            case "SERVICE":
                returnedEntry = new ServiceExpenceEntry(allMoneySpent, importance,
                        comment, date, specialTypeDescription);
            case "OTHER":
                returnedEntry = new OtherExpenceEntry(allMoneySpent, importance,
                        comment, date, specialTypeDescription);
        }

        return returnedEntry;
    }

    public static TotalDayEntries convertFromXMLDay(TotalDayType totalDay) {

        Integer year, month, day;
        year = totalDay.getDateDay().getYear();
        month = totalDay.getDateDay().getMonth();
        day = totalDay.getDateDay().getDay();

        LocalDate date = LocalDate.of(year, month, day);

        ArrayList<OtherExpenceEntry> convertedSimpleExpences = new ArrayList<>();

        ArrayList<ExpenceType> xmlDayExpences = new ArrayList<>(totalDay.getExpence());

        for(ExpenceType tempExpence : xmlDayExpences) {
            convertedSimpleExpences.add(convertFromXMLSimpleEntry(tempExpence));
        }


        return new TotalDayEntries(convertedSimpleExpences, date);
    }

    public static TotalWeekEntries converFromXMLWeek(TotalWeekType totalWeek) {
        Integer beginingYear, beginingMonth, beginingDay;
        beginingYear = totalWeek.getDateBegin().getYear();
        beginingMonth = totalWeek.getDateBegin().getMonth();
        beginingDay = totalWeek.getDateBegin().getDay();

        LocalDate beginingDate = LocalDate.of(beginingYear, beginingMonth, beginingDay);

        Integer endYear, endMonth, endDay;
        endYear = totalWeek.getDateEnd().getYear();
        endMonth = totalWeek.getDateEnd().getMonth();
        endDay = totalWeek.getDateEnd().getDay();

        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        ArrayList<TotalDayEntries> entriesInWeek = new ArrayList<>();
        ArrayList<TotalDayType> xmlDaysInWeek = new ArrayList<>(totalWeek.getTotalDay());

        for(TotalDayType tempXmlDay : xmlDaysInWeek) {
            TotalDayEntries dayToAdd = convertFromXMLDay(tempXmlDay);
            entriesInWeek.add(dayToAdd);
        }

        TotalWeekEntries weekToReturn = new TotalWeekEntries(entriesInWeek, beginingDate, endDate);
        return weekToReturn;
    }

    public static TotalMonthEntries convertFromXMLMonth(TotalMonthType totalMonth) {
        Integer beginingYear, beginingMonth, beginingDay;
        beginingYear = totalMonth.getDateBegin().getYear();
        beginingMonth = totalMonth.getDateBegin().getMonth();
        beginingDay = totalMonth.getDateBegin().getDay();

        LocalDate beginingDate = LocalDate.of(beginingYear, beginingMonth, beginingDay);

        Integer endYear, endMonth, endDay;
        endYear = totalMonth.getDateEnd().getYear();
        endMonth = totalMonth.getDateEnd().getMonth();
        endDay = totalMonth.getDateEnd().getDay();

        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        ArrayList<TotalWeekEntries> weekEntries = new ArrayList<>();
        ArrayList<TotalWeekType> weekXmlEntries = new ArrayList<>(totalMonth.getTotalWeek());

        for(TotalWeekType tempXmlWeek : weekXmlEntries) {
            weekEntries.add(converFromXMLWeek(tempXmlWeek));
        }

        return new TotalMonthEntries(weekEntries, beginingDate, endDate);
    }
}
