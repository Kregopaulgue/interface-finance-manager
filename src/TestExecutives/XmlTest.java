package TestExecutives;

import ExpenceEntries.OtherExpenceEntry;
import Generated.TotalMonthType;
import Generated.TotalTimeType;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalWeekEntries;
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
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by Master on 23.10.2017.
 */
public class XmlTest {

    public static void main(String[] args) throws JAXBException, IOException {
        TotalMonthEntries firstMonth = XMLReader.readMonthFromXML(new GregorianCalendar(2017, 9, 10));
        ArrayList<TotalDayEntries> firstMonthDays = firstMonth.getAllDayEntriesInMonth();

        for(TotalDayEntries tempDayEntry : firstMonthDays) {
            for(OtherExpenceEntry tempExpence : tempDayEntry.getSimpleEntries()) {
                System.out.println(tempExpence);
            }
        }

        OtherExpenceEntry expence = XMLReader.readEntryFromXml(new GregorianCalendar(2017, 9, 10), 0);
        System.out.println("\n---------------------\n");
        System.out.println(expence);
        System.out.println("\n---------------------\n");

        XMLWriterHelpers.addEmptyMonthToXml(new GregorianCalendar());
    }

}
