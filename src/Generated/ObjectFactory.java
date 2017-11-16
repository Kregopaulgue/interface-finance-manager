
package Generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRootElement
@XmlRegistry
public class ObjectFactory {

    private final static QName _TotalTime_QNAME = new QName("", "TotalTime");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TotalTimeType }
     * 
     */
    public TotalTimeType createTotalTimeType() {
        return new TotalTimeType();
    }

    /**
     * Create an instance of {@link DateType }
     * 
     */
    public DateType createDateType() {
        return new DateType();
    }

    /**
     * Create an instance of {@link CombinedEntryType }
     * 
     */
    public CombinedEntryType createCombinedEntryType() {
        return new CombinedEntryType();
    }

    /**
     * Create an instance of {@link TotalDayType }
     * 
     */
    public TotalDayType createTotalDayType() {
        return new TotalDayType();
    }

    /**
     * Create an instance of {@link OtherExpenceEntriesType }
     * 
     */
    public OtherExpenceEntriesType createOtherExpenceEntriesType() {
        return new OtherExpenceEntriesType();
    }

    /**
     * Create an instance of {@link TotalMonthType }
     * 
     */
    public TotalMonthType createTotalMonthType() {
        return new TotalMonthType();
    }

    /**
     * Create an instance of {@link DateEndType }
     * 
     */
    public DateEndType createDateEndType() {
        return new DateEndType();
    }

    /**
     * Create an instance of {@link DateDayType }
     * 
     */
    public DateDayType createDateDayType() {
        return new DateDayType();
    }

    /**
     * Create an instance of {@link TotalWeekType }
     * 
     */
    public TotalWeekType createTotalWeekType() {
        return new TotalWeekType();
    }

    /**
     * Create an instance of {@link DateBeginType }
     * 
     */
    public DateBeginType createDateBeginType() {
        return new DateBeginType();
    }

    /**
     * Create an instance of {@link ExpenceType }
     * 
     */
    public ExpenceType createExpenceType() {
        return new ExpenceType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TotalTimeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TotalTime")
    public JAXBElement<TotalTimeType> createTotalTime(TotalTimeType value) {
        return new JAXBElement<TotalTimeType>(_TotalTime_QNAME, TotalTimeType.class, null, value);
    }

}
