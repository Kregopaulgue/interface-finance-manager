
package Generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TotalDayType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TotalDayType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateDay" type="{}dateDayType"/>
 *         &lt;element name="Expence" type="{}ExpenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CombinedEntry" type="{}CombinedEntryType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalDayType", propOrder = {
    "dateDay",
    "expence",
    "combinedEntry"
})
public class TotalDayType {

    @XmlElement(required = true)
    protected DateDayType dateDay;
    @XmlElement(name = "Expence")
    protected List<ExpenceType> expence;
    @XmlElement(name = "CombinedEntry", required = true)
    protected CombinedEntryType combinedEntry;

    /**
     * Gets the value of the dateDay property.
     * 
     * @return
     *     possible object is
     *     {@link DateDayType }
     *     
     */
    public DateDayType getDateDay() {
        return dateDay;
    }

    /**
     * Sets the value of the dateDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateDayType }
     *     
     */
    public void setDateDay(DateDayType value) {
        this.dateDay = value;
    }

    /**
     * Gets the value of the expence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExpenceType }
     * 
     * 
     */
    public List<ExpenceType> getExpence() {
        if (expence == null) {
            expence = new ArrayList<ExpenceType>();
        }
        return this.expence;
    }

    /**
     * Gets the value of the combinedEntry property.
     * 
     * @return
     *     possible object is
     *     {@link CombinedEntryType }
     *     
     */
    public CombinedEntryType getCombinedEntry() {
        return combinedEntry;
    }

    /**
     * Sets the value of the combinedEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CombinedEntryType }
     *     
     */
    public void setCombinedEntry(CombinedEntryType value) {
        this.combinedEntry = value;
    }

}
