
package Generated;

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
 *         &lt;element name="BillExpence" type="{}BillExpenceType"/>
 *         &lt;element name="ClothExpence" type="{}ClothExpenceType"/>
 *         &lt;element name="EntertainmnetExpence" type="{}EntertainmnetExpenceType"/>
 *         &lt;element name="FoodExpence" type="{}FoodExpenceType"/>
 *         &lt;element name="OtherExpence" type="{}OtherExpenceType"/>
 *         &lt;element name="ServiceExpence" type="{}ServiceExpenceType"/>
 *         &lt;element name="TechnicExpence" type="{}TechnicExpenceType"/>
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
    "billExpence",
    "clothExpence",
    "entertainmnetExpence",
    "foodExpence",
    "otherExpence",
    "serviceExpence",
    "technicExpence",
    "combinedEntry"
})
public class TotalDayType {

    @XmlElement(name = "BillExpence", required = true)
    protected BillExpenceType billExpence;
    @XmlElement(name = "ClothExpence", required = true)
    protected ClothExpenceType clothExpence;
    @XmlElement(name = "EntertainmnetExpence", required = true)
    protected EntertainmnetExpenceType entertainmnetExpence;
    @XmlElement(name = "FoodExpence", required = true)
    protected FoodExpenceType foodExpence;
    @XmlElement(name = "OtherExpence", required = true)
    protected OtherExpenceType otherExpence;
    @XmlElement(name = "ServiceExpence", required = true)
    protected ServiceExpenceType serviceExpence;
    @XmlElement(name = "TechnicExpence", required = true)
    protected TechnicExpenceType technicExpence;
    @XmlElement(name = "CombinedEntry", required = true)
    protected CombinedEntryType combinedEntry;

    /**
     * Gets the value of the billExpence property.
     * 
     * @return
     *     possible object is
     *     {@link BillExpenceType }
     *     
     */
    public BillExpenceType getBillExpence() {
        return billExpence;
    }

    /**
     * Sets the value of the billExpence property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillExpenceType }
     *     
     */
    public void setBillExpence(BillExpenceType value) {
        this.billExpence = value;
    }

    /**
     * Gets the value of the clothExpence property.
     * 
     * @return
     *     possible object is
     *     {@link ClothExpenceType }
     *     
     */
    public ClothExpenceType getClothExpence() {
        return clothExpence;
    }

    /**
     * Sets the value of the clothExpence property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClothExpenceType }
     *     
     */
    public void setClothExpence(ClothExpenceType value) {
        this.clothExpence = value;
    }

    /**
     * Gets the value of the entertainmnetExpence property.
     * 
     * @return
     *     possible object is
     *     {@link EntertainmnetExpenceType }
     *     
     */
    public EntertainmnetExpenceType getEntertainmnetExpence() {
        return entertainmnetExpence;
    }

    /**
     * Sets the value of the entertainmnetExpence property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntertainmnetExpenceType }
     *     
     */
    public void setEntertainmnetExpence(EntertainmnetExpenceType value) {
        this.entertainmnetExpence = value;
    }

    /**
     * Gets the value of the foodExpence property.
     * 
     * @return
     *     possible object is
     *     {@link FoodExpenceType }
     *     
     */
    public FoodExpenceType getFoodExpence() {
        return foodExpence;
    }

    /**
     * Sets the value of the foodExpence property.
     * 
     * @param value
     *     allowed object is
     *     {@link FoodExpenceType }
     *     
     */
    public void setFoodExpence(FoodExpenceType value) {
        this.foodExpence = value;
    }

    /**
     * Gets the value of the otherExpence property.
     * 
     * @return
     *     possible object is
     *     {@link OtherExpenceType }
     *     
     */
    public OtherExpenceType getOtherExpence() {
        return otherExpence;
    }

    /**
     * Sets the value of the otherExpence property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherExpenceType }
     *     
     */
    public void setOtherExpence(OtherExpenceType value) {
        this.otherExpence = value;
    }

    /**
     * Gets the value of the serviceExpence property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceExpenceType }
     *     
     */
    public ServiceExpenceType getServiceExpence() {
        return serviceExpence;
    }

    /**
     * Sets the value of the serviceExpence property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceExpenceType }
     *     
     */
    public void setServiceExpence(ServiceExpenceType value) {
        this.serviceExpence = value;
    }

    /**
     * Gets the value of the technicExpence property.
     * 
     * @return
     *     possible object is
     *     {@link TechnicExpenceType }
     *     
     */
    public TechnicExpenceType getTechnicExpence() {
        return technicExpence;
    }

    /**
     * Sets the value of the technicExpence property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicExpenceType }
     *     
     */
    public void setTechnicExpence(TechnicExpenceType value) {
        this.technicExpence = value;
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
