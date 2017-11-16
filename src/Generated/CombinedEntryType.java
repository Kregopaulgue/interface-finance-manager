
package Generated;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for CombinedEntryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CombinedEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OtherExpenceEntries" type="{}OtherExpenceEntriesType"/>
 *         &lt;element name="amountOfEntries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="allMoneySpent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="averageMoneySpent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date" type="{}dateType"/>
 *         &lt;element name="combinedEntryType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CombinedEntryType", propOrder = {
    "otherExpenceEntries",
    "amountOfEntries",
    "allMoneySpent",
    "averageMoneySpent",
    "date",
    "combinedEntryType"
})
public class CombinedEntryType {

    @XmlElement(name = "OtherExpenceEntries", required = true)
    protected OtherExpenceEntriesType otherExpenceEntries;
    @XmlElement(required = true)
    protected String amountOfEntries;
    @XmlElement(required = true)
    protected String allMoneySpent;
    @XmlElement(required = true)
    protected String averageMoneySpent;
    @XmlElement(required = true)
    protected DateType date;
    @XmlElement(required = true)
    protected String combinedEntryType;

    /**
     * Gets the value of the otherExpenceEntries property.
     * 
     * @return
     *     possible object is
     *     {@link OtherExpenceEntriesType }
     *     
     */
    public OtherExpenceEntriesType getOtherExpenceEntries() {
        return otherExpenceEntries;
    }

    /**
     * Sets the value of the otherExpenceEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherExpenceEntriesType }
     *     
     */
    public void setOtherExpenceEntries(OtherExpenceEntriesType value) {
        this.otherExpenceEntries = value;
    }

    /**
     * Gets the value of the amountOfEntries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountOfEntries() {
        return amountOfEntries;
    }

    /**
     * Sets the value of the amountOfEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountOfEntries(String value) {
        this.amountOfEntries = value;
    }

    /**
     * Gets the value of the allMoneySpent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllMoneySpent() {
        return allMoneySpent;
    }

    /**
     * Sets the value of the allMoneySpent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllMoneySpent(String value) {
        this.allMoneySpent = value;
    }

    /**
     * Gets the value of the averageMoneySpent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAverageMoneySpent() {
        return averageMoneySpent;
    }

    /**
     * Sets the value of the averageMoneySpent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAverageMoneySpent(String value) {
        this.averageMoneySpent = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDate(DateType value) {
        this.date = value;
    }

    /**
     * Gets the value of the combinedEntryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCombinedEntryType() {
        return combinedEntryType;
    }

    /**
     * Sets the value of the combinedEntryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCombinedEntryType(String value) {
        this.combinedEntryType = value;
    }

}
