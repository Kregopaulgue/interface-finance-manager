
package Generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TotalWeekType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TotalWeekType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalDay" type="{}TotalDayType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalWeekType", propOrder = {
    "totalDay"
})
public class TotalWeekType {

    @XmlElement(name = "TotalDay", required = true)
    protected TotalDayType totalDay;

    /**
     * Gets the value of the totalDay property.
     * 
     * @return
     *     possible object is
     *     {@link TotalDayType }
     *     
     */
    public TotalDayType getTotalDay() {
        return totalDay;
    }

    /**
     * Sets the value of the totalDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalDayType }
     *     
     */
    public void setTotalDay(TotalDayType value) {
        this.totalDay = value;
    }

}
