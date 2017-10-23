
package Generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TotalTimeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TotalTimeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalMonth" type="{}TotalMonthType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalTimeType", propOrder = {
    "totalMonth"
})
public class TotalTimeType {

    @XmlElement(name = "TotalMonth", required = true)
    protected TotalMonthType totalMonth;

    /**
     * Gets the value of the totalMonth property.
     * 
     * @return
     *     possible object is
     *     {@link TotalMonthType }
     *     
     */
    public TotalMonthType getTotalMonth() {
        return totalMonth;
    }

    /**
     * Sets the value of the totalMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalMonthType }
     *     
     */
    public void setTotalMonth(TotalMonthType value) {
        this.totalMonth = value;
    }

}
