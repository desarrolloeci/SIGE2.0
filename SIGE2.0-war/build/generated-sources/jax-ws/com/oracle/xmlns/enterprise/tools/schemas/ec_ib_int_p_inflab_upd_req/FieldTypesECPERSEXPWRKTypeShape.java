
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_upd_req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypesEC_PERS_EXP_WRK_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypesEC_PERS_EXP_WRK_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="EMPLOYER" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="COUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="STATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="CITY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="START_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType"/&gt;
 *         &lt;element name="END_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PHONE_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY_CODE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PHONE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ENDING_TITLE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="class" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="R" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FieldTypesEC_PERS_EXP_WRK_TypeShape", propOrder = {
    "emplid",
    "employer",
    "country",
    "state",
    "city",
    "startdt",
    "enddt",
    "phonetype",
    "countrycode",
    "phone",
    "endingtitle"
})
public class FieldTypesECPERSEXPWRKTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected FieldTypesCharFieldType emplid;
    @XmlElement(name = "EMPLOYER", required = true)
    protected FieldTypesCharFieldType employer;
    @XmlElement(name = "COUNTRY", required = true)
    protected FieldTypesCharFieldType country;
    @XmlElement(name = "STATE", required = true)
    protected FieldTypesCharFieldType state;
    @XmlElement(name = "CITY", required = true)
    protected FieldTypesCharFieldType city;
    @XmlElement(name = "START_DT", required = true)
    protected FieldTypesDateFieldType startdt;
    @XmlElement(name = "END_DT")
    protected FieldTypesDateFieldType enddt;
    @XmlElement(name = "PHONE_TYPE")
    protected FieldTypesCharFieldType phonetype;
    @XmlElement(name = "COUNTRY_CODE")
    protected FieldTypesCharFieldType countrycode;
    @XmlElement(name = "PHONE")
    protected FieldTypesCharFieldType phone;
    @XmlElement(name = "ENDING_TITLE")
    protected FieldTypesCharFieldType endingtitle;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad emplid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEMPLID() {
        return emplid;
    }

    /**
     * Define el valor de la propiedad emplid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEMPLID(FieldTypesCharFieldType value) {
        this.emplid = value;
    }

    /**
     * Obtiene el valor de la propiedad employer.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEMPLOYER() {
        return employer;
    }

    /**
     * Define el valor de la propiedad employer.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEMPLOYER(FieldTypesCharFieldType value) {
        this.employer = value;
    }

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCOUNTRY() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCOUNTRY(FieldTypesCharFieldType value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getSTATE() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setSTATE(FieldTypesCharFieldType value) {
        this.state = value;
    }

    /**
     * Obtiene el valor de la propiedad city.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCITY() {
        return city;
    }

    /**
     * Define el valor de la propiedad city.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCITY(FieldTypesCharFieldType value) {
        this.city = value;
    }

    /**
     * Obtiene el valor de la propiedad startdt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getSTARTDT() {
        return startdt;
    }

    /**
     * Define el valor de la propiedad startdt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setSTARTDT(FieldTypesDateFieldType value) {
        this.startdt = value;
    }

    /**
     * Obtiene el valor de la propiedad enddt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getENDDT() {
        return enddt;
    }

    /**
     * Define el valor de la propiedad enddt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setENDDT(FieldTypesDateFieldType value) {
        this.enddt = value;
    }

    /**
     * Obtiene el valor de la propiedad phonetype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPHONETYPE() {
        return phonetype;
    }

    /**
     * Define el valor de la propiedad phonetype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPHONETYPE(FieldTypesCharFieldType value) {
        this.phonetype = value;
    }

    /**
     * Obtiene el valor de la propiedad countrycode.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCOUNTRYCODE() {
        return countrycode;
    }

    /**
     * Define el valor de la propiedad countrycode.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCOUNTRYCODE(FieldTypesCharFieldType value) {
        this.countrycode = value;
    }

    /**
     * Obtiene el valor de la propiedad phone.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPHONE() {
        return phone;
    }

    /**
     * Define el valor de la propiedad phone.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPHONE(FieldTypesCharFieldType value) {
        this.phone = value;
    }

    /**
     * Obtiene el valor de la propiedad endingtitle.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getENDINGTITLE() {
        return endingtitle;
    }

    /**
     * Define el valor de la propiedad endingtitle.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setENDINGTITLE(FieldTypesCharFieldType value) {
        this.endingtitle = value;
    }

    /**
     * Obtiene el valor de la propiedad clazz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        if (clazz == null) {
            return "R";
        } else {
            return clazz;
        }
    }

    /**
     * Define el valor de la propiedad clazz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

}
