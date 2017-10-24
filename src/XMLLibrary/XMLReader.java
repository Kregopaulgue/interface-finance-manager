package XMLLibrary;

import ExpenceEntries.OtherExpenceEntry;
import Generated.TotalMonthType;
import Generated.TotalTimeType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

/**
 * Created by Master on 23.10.2017.
 */
public class XMLReader {

    public static OtherExpenceEntry readEntryFromXml(Calendar date, int index)
            throws JAXBException, FileNotFoundException {

        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        JAXBElement<TotalTimeType> totalTimeTypeJAXBElement =
                (JAXBElement<TotalTimeType>) unmarshaller.unmarshal(new FileInputStream("main_entry_history.xml"));

        TotalTimeType totalTime = totalTimeTypeJAXBElement.getValue();

        OtherExpenceEntry neededEntry;







    }

}
