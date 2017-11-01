package XMLLibrary;

import Generated.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
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


    public static void addEmptyMonthToXml(GregorianCalendar date) throws JAXBException, FileNotFoundException{

        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        TotalTimeType totalTime = new TotalTimeType();

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

        totalTime.getTotalMonth().add(newMonth);

        try {
            javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(totalTime, new FileWriter("test_output.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

}
