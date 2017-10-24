
package Generated;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="TotalMonth" type="{}TotalMonthType" maxOccurs="unbounded" minOccurs="0"/>
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

    @XmlElement(name = "TotalMonth")
    protected List<TotalMonthType> totalMonth;

    /**
     * Gets the value of the totalMonth property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalMonth property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalMonth().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotalMonthType }
     * 
     * 
     */
    public List<TotalMonthType> getTotalMonth() {
        if (totalMonth == null) {
            totalMonth = new ArrayList<TotalMonthType>();
        }
        return this.totalMonth;
    }

}
