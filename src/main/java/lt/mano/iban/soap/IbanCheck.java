//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.18 at 12:07:28 PM EEST 
//

package lt.mano.iban.soap;

import lt.mano.iban.IBANValidator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IbanCheck complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IbanCheck">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberIBAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusIBAN" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IbanCheck", propOrder = {
    "numberIBAN",
    "statusIBAN"
})
public class IbanCheck {

    @XmlElement(required = true)
    protected String numberIBAN;
    protected boolean statusIBAN;

    /**
     * Gets the value of the numberIBAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberIBAN() {
        return numberIBAN;
    }

    /**
     * Sets the value of the numberIBAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberIBAN(String value) {
        this.numberIBAN = value;
    }

    /**
     * Gets the value of the statusIBAN property.
     * 
     */
    public boolean isStatusIBAN() {
        return statusIBAN = new IBANValidator().isValid(numberIBAN);
    }

    /**
     * Sets the value of the statusIBAN property.
     * 
     */
    public void setStatusIBAN(boolean value) {
        this.statusIBAN = value;
    }

}
