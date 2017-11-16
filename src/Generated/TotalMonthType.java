
package Generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


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
 *         &lt;element name="TotalWeek" type="{}TotalWeekType" maxOccurs="unbounded" minOccurs="0"/>
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
    @XmlElement(name = "TotalWeek")
    protected List<TotalWeekType> totalWeek;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalWeek property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalWeek().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotalWeekType }
     * 
     * 
     */
    public List<TotalWeekType> getTotalWeek() {
        if (totalWeek == null) {
            totalWeek = new ArrayList<TotalWeekType>();
        }
        return this.totalWeek;
    }

}
