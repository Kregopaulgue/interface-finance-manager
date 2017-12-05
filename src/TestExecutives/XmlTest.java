package TestExecutives;

import ExpenceEntries.OtherExpenceEntry;
import Generated.TotalMonthType;
import Generated.TotalTimeType;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalWeekEntries;
import WorkWithEntryData.WorkWithEntryData;
import XMLLibrary.XMLReader;
import XMLLibrary.XMLReaderHelpers;
import XMLLibrary.XMLWriter;
import XMLLibrary.XMLWriterHelpers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Master on 23.10.2017.
 */
public class XmlTest {

    public static void print(String stringToPrint) {
        System.out.println(stringToPrint);
    }

    public static void main(String[] args) throws JAXBException, IOException {
        TotalMonthEntries firstMonth = XMLReader.readMonthFromXML(LocalDate.of(2017, 9, 10));
        ArrayList<TotalDayEntries> firstMonthDays = firstMonth.getAllDayEntriesInMonth();

        for(TotalDayEntries tempDayEntry : firstMonthDays) {
            for(OtherExpenceEntry tempExpence : tempDayEntry.getSimpleEntries()) {
                print(tempExpence.toString());
            }
        }

        OtherExpenceEntry expence = XMLReader.readEntryFromXml(LocalDate.of(2017, 9, 10), 0);
        print("\n---------------------\n");
        print(expence.toString());
        print("\n---------------------\n");

        ArrayList<TotalMonthEntries> allMonths = XMLReader.readAllFromXml("main_entry_history.xml");

        for(TotalMonthEntries tempMonth : allMonths) {
            print("\nMonth: ...");
            print(tempMonth.toString());
            for(TotalWeekEntries tempWeek : tempMonth.getAllWeekEntriesInMonth()) {
                print("\nWeek: ...");
                print(tempWeek.toString());
                for(TotalDayEntries tempDay : tempWeek.getAllDayEntriesInWeek()) {
                    print("\nDay: ...");
                    print(tempDay.toString());
                    print("Most expencive entry: " + tempDay.getMostExpenciveSimpleEntry());
                    for(OtherExpenceEntry tempExpence : tempDay.getSimpleEntries()) {
                        print(tempExpence.toString());
                    }
                }
            }
        }

        print("\n-------------------\n");
        print("    Most important entry of all:");
        print(WorkWithEntryData.findTheMostImportantEntry(new ArrayList<>(allMonths.get(0).getSimpleEntries())).toString());
        print("    Less important entry of all:");
        print(WorkWithEntryData.findTheLessImportantEntry(new ArrayList<>(allMonths.get(0).getSimpleEntries())).toString());
        print("\n-------------------\n");
        print("    Most expensive entry of all:");
        print(WorkWithEntryData.findTheMostExpensiveEntry(new ArrayList<>(allMonths.get(0).getSimpleEntries())).toString());
        print("    Most expensive combined entry of all:");
        print(WorkWithEntryData.findTheMostExpensiveCombinedEntry(new ArrayList<>(allMonths.get(0).getCombinedEntries())).toString());
        print("    Most expensive day of all:");
        print(WorkWithEntryData.findTheMostExpensiveDay(new ArrayList<>(allMonths.get(0).getAllDayEntriesInMonth())).toString());
        print("    Most expensive week of all:");
        print(WorkWithEntryData.findTheMostExpensiveWeek(new ArrayList<>(allMonths.get(0).getAllWeekEntriesInMonth())).toString());
        print("    Most expensive month of all:");
        print(WorkWithEntryData.findTheMostExpensiveMonth(new ArrayList<>(allMonths)).toString());
        print("\n--------------------\n");
        print("    Less expensive entry of all:");
        print(WorkWithEntryData.findTheLessExpensiveEntry(new ArrayList<>(allMonths.get(0).getSimpleEntries())).toString());
        print("    Less expensive combined entry of all:");
        print(WorkWithEntryData.findTheLessExpensiveCombinedEntry(new ArrayList<>(allMonths.get(0).getCombinedEntries())).toString());
        print("    Less expensive day of all:");
        print(WorkWithEntryData.findTheLessExpensiveDay(new ArrayList<>(allMonths.get(0).getAllDayEntriesInMonth())).toString());
        print("    Less expensive week of all:");
        print(WorkWithEntryData.findTheLessExpensiveWeek(new ArrayList<>(allMonths.get(0).getAllWeekEntriesInMonth())).toString());
        print("    Less expensive month of all:");
        print(WorkWithEntryData.findTheLessExpensiveMonth(new ArrayList<>(allMonths)).toString());
        print("\n--------------------\n");
        print("    Sum money spent entry of all:");
        print(WorkWithEntryData.getAllMoneySpentEntries(new ArrayList<>(allMonths.get(0).getSimpleEntries())).toString());
        print("    Sum money spent combined entry of all:");
        print(WorkWithEntryData.getAllMoneySpentCombinedEntries(new ArrayList<>(allMonths.get(0).getCombinedEntries())).toString());
        print("    Sum money spent day of all:");
        print(WorkWithEntryData.getAllMoneySpentDays(new ArrayList<>(allMonths.get(0).getAllDayEntriesInMonth())).toString());
        print("    Sum money spent week of all:");
        print(WorkWithEntryData.getAllMoneySpentWeeks(new ArrayList<>(allMonths.get(0).getAllWeekEntriesInMonth())).toString());
        print("    Sum money spent month of all:");
        print(WorkWithEntryData.getAllMoneySpentMonths(new ArrayList<>(allMonths)).toString());
        print("\n--------------------\n");
        print("    Average money spent entry of all:");
        print(WorkWithEntryData.findAverageMoneyEntrys(new ArrayList<>(allMonths.get(0).getSimpleEntries())).toString());
        print("    Average money spent combined entry of all:");
        print(WorkWithEntryData.findAverageMoneyCombined(new ArrayList<>(allMonths.get(0).getCombinedEntries())).toString());
        print("    Average money spent day of all:");
        print(WorkWithEntryData.findAverageMoneyDays(new ArrayList<>(allMonths.get(0).getAllDayEntriesInMonth())).toString());
        print("    Average money spent week of all:");
        print(WorkWithEntryData.findAverageMoneyWeeks(new ArrayList<>(allMonths.get(0).getAllWeekEntriesInMonth())).toString());
        print("    Average money spent month of all:");
        print(WorkWithEntryData.findAverageMoneyMonths(new ArrayList<>(allMonths)).toString());

        print("#########################");

        Scanner sc = new Scanner(System.in);

        for(;;) {
            print("Enter year, month (from zero), and day:");
            print("Year: \n   ");
            String year = sc.nextLine();
            print("Month: \n   ");
            String month = sc.nextLine();
            print("Day: \n   ");
            String day = sc.nextLine();
            if(year.equals("exit") || month.equals("exit") || day.equals("exit")) {
                print("exiting...");
                break;
            }
            LocalDate dateToFind = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month),
                    Integer.valueOf(day));

            print("Reading certain month...");
            print(XMLReader.readMonthFromXML(dateToFind).toString());
            print("############################");
            print("Reading certain week");
            print(XMLReader.readWeekFromXml(dateToFind).toString());
            print("############################");
            print("Reading certain day");
            print(XMLReader.readDayFromXml(dateToFind).toString());
            print("############################");
            print("Reading certain entry");
            print(XMLReader.readEntryFromXml(dateToFind, 0).toString());
        }

        XMLWriterHelpers.addFullYearToXml();
    }

}
