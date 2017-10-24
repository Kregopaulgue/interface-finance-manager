
package Generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TotalMonthType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TotalMonthType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateBegin" type="{}dateBeginType"/>
 *         &lt;element name="dateEnd" type="{}dateEndType"/>
 *         &lt;element name="TotalWeek" type="{}TotalWeekType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalMonthType", propOrder = {
    "dateBegin",
    "dateEnd",
    "totalWeek"
})
public class TotalMonthType {

    @XmlElement(required = true)
    protected DateBeginType dateBegin;
    @XmlElement(required = true)
    protected DateEndType dateEnd;
    @XmlElement(name = "TotalWeek", required = true)
    protected TotalWeekType totalWeek;

    /**
     * Gets the value of the dateBegin property.
     * 
     * @return
     *     possible object is
     *     {@link DateBeginType }
     *     
     */
    public DateBeginType getDateBegin() {
        return dateBegin;
    }

    /**
     * Sets the value of the dateBegin property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateBeginType }
     *     
     */
    public void setDateBegin(DateBeginType value) {
        this.dateBegin = value;
    }

    /**
     * Gets the value of the dateEnd property.
     * 
     * @return
     *     possible object is
     *     {@link DateEndType }
     *     
     */
    public DateEndType getDateEnd() {
        return dateEnd;
    }

    /**
     * Sets the value of the dateEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateEndType }
     *     
     */
    public void setDateEnd(DateEndType value) {
        this.dateEnd = value;
    }

    /**
     * Gets the value of the totalWeek property.
     * 
     * @return
     *     possible object is
     *     {@link TotalWeekType }
     *     
     */
    public TotalWeekType getTotalWeek() {
        return totalWeek;
    }

    /**
     * Sets the value of the totalWeek property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalWeekType }
     *     
     */
    public void setTotalWeek(TotalWeekType value) {
        this.totalWeek = value;
    }

}
