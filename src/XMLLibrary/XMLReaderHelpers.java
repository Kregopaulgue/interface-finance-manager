package XMLLibrary;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
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
import java.util.GregorianCalendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Created by Master on 25.10.2017.
 */
public class XMLReaderHelpers {

    public static OtherExpenceEntry convertFromXMLSimpleEntry(ExpenceType expenceEntry) {

        Double allMoneySpent = Double.valueOf(expenceEntry.getMoneySpent());
        String comment = expenceEntry.getComment();
        Integer importance = Integer.valueOf(expenceEntry.getImportance());

        Integer year, month, day;
        year = Integer.valueOf(expenceEntry.getDate().getYear());
        month = Integer.valueOf(expenceEntry.getDate().getMonth());
        day = Integer.valueOf(expenceEntry.getDate().getDay());

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

    public static CombinedOtherExpenceEntry convertFromXMLCombinedEntry(CombinedEntryType combinedEntry) {
        ArrayList<ExpenceType> xmlExpencesList = new ArrayList<>(combinedEntry.getOtherExpenceEntries().getExpence());
        LinkedList<OtherExpenceEntry> expencesList = new LinkedList<>();

        for(ExpenceType xmlExpence : xmlExpencesList) {
            OtherExpenceEntry entryToAdd = convertFromXMLSimpleEntry(xmlExpence);
            expencesList.add(entryToAdd);
        }

        CombinedOtherExpenceEntry combinedEntryToReturn = new CombinedOtherExpenceEntry(expencesList);
        return combinedEntryToReturn;
    }

    public static TotalDayEntries convertFromXMLDay(TotalDayType totalDay) {

        Integer year, month, day;
        year = Integer.valueOf(totalDay.getDateDay().getYear());
        month = Integer.valueOf(totalDay.getDateDay().getMonth());
        day = Integer.valueOf(totalDay.getDateDay().getDay());

        LocalDate date = LocalDate.of(year, month, day);

        LinkedList<OtherExpenceEntry> convertedSimpleExpences = new LinkedList<>();
        LinkedList<CombinedOtherExpenceEntry> convertedCombinedExpences = new LinkedList<>();

        ArrayList<ExpenceType> xmlDayExpences = new ArrayList<>(totalDay.getExpence());
        ArrayList<CombinedEntryType> xmlDayCombinedEntry = new ArrayList<>(totalDay.getCombinedEntry());

        for(ExpenceType tempExpence : xmlDayExpences) {
            convertedSimpleExpences.add(convertFromXMLSimpleEntry(tempExpence));
        }

        for(CombinedEntryType tempCombinedExpence : xmlDayCombinedEntry) {
            convertedCombinedExpences.add(convertFromXMLCombinedEntry(tempCombinedExpence));
        }

        TotalDayEntries totalDayEntryToReturn = new TotalDayEntries(convertedSimpleExpences,
                convertedCombinedExpences, date);
        return totalDayEntryToReturn;
    }

    public static TotalWeekEntries converFromXMLWeek(TotalWeekType totalWeek) {
        Integer beginingYear, beginingMonth, beginingDay;
        beginingYear = Integer.valueOf(totalWeek.getDateBegin().getYear());
        beginingMonth = Integer.valueOf(totalWeek.getDateBegin().getMonth());
        beginingDay = Integer.valueOf(totalWeek.getDateBegin().getDay());

        LocalDate beginingDate = LocalDate.of(beginingYear, beginingMonth, beginingDay);

        Integer endYear, endMonth, endDay;
        endYear = Integer.valueOf(totalWeek.getDateEnd().getYear());
        endMonth = Integer.valueOf(totalWeek.getDateEnd().getMonth());
        endDay = Integer.valueOf(totalWeek.getDateEnd().getDay());

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
        beginingYear = Integer.valueOf(totalMonth.getDateBegin().getYear());
        beginingMonth = Integer.valueOf(totalMonth.getDateBegin().getMonth());
        beginingDay = Integer.valueOf(totalMonth.getDateBegin().getDay());

        LocalDate beginingDate = LocalDate.of(beginingYear, beginingMonth, beginingDay);

        Integer endYear, endMonth, endDay;
        endYear = Integer.valueOf(totalMonth.getDateEnd().getYear());
        endMonth = Integer.valueOf(totalMonth.getDateEnd().getMonth());
        endDay = Integer.valueOf(totalMonth.getDateEnd().getDay());

        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        ArrayList<TotalWeekEntries> weekEntries = new ArrayList<>();
        ArrayList<TotalWeekType> weekXmlEntries = new ArrayList<>(totalMonth.getTotalWeek());

        for(TotalWeekType tempXmlWeek : weekXmlEntries) {
            weekEntries.add(converFromXMLWeek(tempXmlWeek));
        }

        TotalMonthEntries totalMonthToReturn = new TotalMonthEntries(weekEntries, beginingDate, endDate);
        return totalMonthToReturn;
    }
}
