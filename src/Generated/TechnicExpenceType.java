
package Generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TechnicExpenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TechnicExpenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="moneySpent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="importance" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date" type="{}dateType"/>
 *         &lt;element name="expenceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="textTechnicType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TechnicExpenceType", propOrder = {
    "moneySpent",
    "importance",
    "comment",
    "date",
    "expenceType",
    "textTechnicType"
})
public class TechnicExpenceType {

    @XmlElement(required = true)
    protected String moneySpent;
    @XmlElement(required = true)
    protected String importance;
    @XmlElement(required = true)
    protected String comment;
    @XmlElement(required = true)
    protected DateType date;
    @XmlElement(required = true)
    protected String expenceType;
    @XmlElement(required = true)
    protected String textTechnicType;

    /**
     * Gets the value of the moneySpent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoneySpent() {
        return moneySpent;
    }

    /**
     * Sets the value of the moneySpent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoneySpent(String value) {
        this.moneySpent = value;
    }

    /**
     * Gets the value of the importance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportance() {
        return importance;
    }

    /**
     * Sets the value of the importance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportance(String value) {
        this.importance = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
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
     * Gets the value of the expenceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpenceType() {
        return expenceType;
    }

    /**
     * Sets the value of the expenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpenceType(String value) {
        this.expenceType = value;
    }

    /**
     * Gets the value of the textTechnicType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextTechnicType() {
        return textTechnicType;
    }

    /**
     * Sets the value of the textTechnicType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextTechnicType(String value) {
        this.textTechnicType = value;
    }

}
