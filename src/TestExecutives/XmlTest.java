package TestExecutives;

import Generated.TotalMonthType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Master on 23.10.2017.
 */
public class XmlTest {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance("Generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<TotalMonthType> totalMonth =
                (JAXBElement<TotalMonthType>) unmarshaller.unmarshal(new FileInputStream("main_entry_history.xml"));

    }

}
