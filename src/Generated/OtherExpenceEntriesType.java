
package Generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OtherExpenceEntriesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OtherExpenceEntriesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FoodExpence" type="{}FoodExpenceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherExpenceEntriesType", propOrder = {
    "foodExpence"
})
public class OtherExpenceEntriesType {

    @XmlElement(name = "FoodExpence")
    protected List<FoodExpenceType> foodExpence;

    /**
     * Gets the value of the foodExpence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the foodExpence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFoodExpence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FoodExpenceType }
     * 
     * 
     */
    public List<FoodExpenceType> getFoodExpence() {
        if (foodExpence == null) {
            foodExpence = new ArrayList<FoodExpenceType>();
        }
        return this.foodExpence;
    }

}
