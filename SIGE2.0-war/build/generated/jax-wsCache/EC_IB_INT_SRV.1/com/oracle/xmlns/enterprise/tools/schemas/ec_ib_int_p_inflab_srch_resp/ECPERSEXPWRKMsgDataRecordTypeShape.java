
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_PERS_EXP_WRKMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_PERS_EXP_WRKMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EMPLID_TypeShape"/&gt;
 *         &lt;element name="EMPLOYER" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EMPLOYER_TypeShape"/&gt;
 *         &lt;element name="COUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}COUNTRY_TypeShape"/&gt;
 *         &lt;element name="STATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}STATE_TypeShape"/&gt;
 *         &lt;element name="CITY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}CITY_TypeShape"/&gt;
 *         &lt;element name="START_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}START_DT_TypeShape"/&gt;
 *         &lt;element name="END_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}END_DT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PHONE_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}PHONE_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY_CODE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}COUNTRY_CODE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PHONE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}PHONE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ENDING_TITLE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}ENDING_TITLE_TypeShape" minOccurs="0"/&gt;
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
@XmlType(name = "EC_PERS_EXP_WRKMsgDataRecord_TypeShape", propOrder = {
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
public class ECPERSEXPWRKMsgDataRecordTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected EMPLIDTypeShape emplid;
    @XmlElement(name = "EMPLOYER", required = true)
    protected EMPLOYERTypeShape employer;
    @XmlElement(name = "COUNTRY", required = true)
    protected COUNTRYTypeShape country;
    @XmlElement(name = "STATE", required = true)
    protected STATETypeShape state;
    @XmlElement(name = "CITY", required = true)
    protected CITYTypeShape city;
    @XmlElement(name = "START_DT", required = true)
    protected STARTDTTypeShape startdt;
    @XmlElement(name = "END_DT")
    protected ENDDTTypeShape enddt;
    @XmlElement(name = "PHONE_TYPE")
    protected PHONETYPETypeShape phonetype;
    @XmlElement(name = "COUNTRY_CODE")
    protected COUNTRYCODETypeShape countrycode;
    @XmlElement(name = "PHONE")
    protected PHONETypeShape phone;
    @XmlElement(name = "ENDING_TITLE")
    protected ENDINGTITLETypeShape endingtitle;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad emplid.
     * 
     * @return
     *     possible object is
     *     {@link EMPLIDTypeShape }
     *     
     */
    public EMPLIDTypeShape getEMPLID() {
        return emplid;
    }

    /**
     * Define el valor de la propiedad emplid.
     * 
     * @param value
     *     allowed object is
     *     {@link EMPLIDTypeShape }
     *     
     */
    public void setEMPLID(EMPLIDTypeShape value) {
        this.emplid = value;
    }

    /**
     * Obtiene el valor de la propiedad employer.
     * 
     * @return
     *     possible object is
     *     {@link EMPLOYERTypeShape }
     *     
     */
    public EMPLOYERTypeShape getEMPLOYER() {
        return employer;
    }

    /**
     * Define el valor de la propiedad employer.
     * 
     * @param value
     *     allowed object is
     *     {@link EMPLOYERTypeShape }
     *     
     */
    public void setEMPLOYER(EMPLOYERTypeShape value) {
        this.employer = value;
    }

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link COUNTRYTypeShape }
     *     
     */
    public COUNTRYTypeShape getCOUNTRY() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link COUNTRYTypeShape }
     *     
     */
    public void setCOUNTRY(COUNTRYTypeShape value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link STATETypeShape }
     *     
     */
    public STATETypeShape getSTATE() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link STATETypeShape }
     *     
     */
    public void setSTATE(STATETypeShape value) {
        this.state = value;
    }

    /**
     * Obtiene el valor de la propiedad city.
     * 
     * @return
     *     possible object is
     *     {@link CITYTypeShape }
     *     
     */
    public CITYTypeShape getCITY() {
        return city;
    }

    /**
     * Define el valor de la propiedad city.
     * 
     * @param value
     *     allowed object is
     *     {@link CITYTypeShape }
     *     
     */
    public void setCITY(CITYTypeShape value) {
        this.city = value;
    }

    /**
     * Obtiene el valor de la propiedad startdt.
     * 
     * @return
     *     possible object is
     *     {@link STARTDTTypeShape }
     *     
     */
    public STARTDTTypeShape getSTARTDT() {
        return startdt;
    }

    /**
     * Define el valor de la propiedad startdt.
     * 
     * @param value
     *     allowed object is
     *     {@link STARTDTTypeShape }
     *     
     */
    public void setSTARTDT(STARTDTTypeShape value) {
        this.startdt = value;
    }

    /**
     * Obtiene el valor de la propiedad enddt.
     * 
     * @return
     *     possible object is
     *     {@link ENDDTTypeShape }
     *     
     */
    public ENDDTTypeShape getENDDT() {
        return enddt;
    }

    /**
     * Define el valor de la propiedad enddt.
     * 
     * @param value
     *     allowed object is
     *     {@link ENDDTTypeShape }
     *     
     */
    public void setENDDT(ENDDTTypeShape value) {
        this.enddt = value;
    }

    /**
     * Obtiene el valor de la propiedad phonetype.
     * 
     * @return
     *     possible object is
     *     {@link PHONETYPETypeShape }
     *     
     */
    public PHONETYPETypeShape getPHONETYPE() {
        return phonetype;
    }

    /**
     * Define el valor de la propiedad phonetype.
     * 
     * @param value
     *     allowed object is
     *     {@link PHONETYPETypeShape }
     *     
     */
    public void setPHONETYPE(PHONETYPETypeShape value) {
        this.phonetype = value;
    }

    /**
     * Obtiene el valor de la propiedad countrycode.
     * 
     * @return
     *     possible object is
     *     {@link COUNTRYCODETypeShape }
     *     
     */
    public COUNTRYCODETypeShape getCOUNTRYCODE() {
        return countrycode;
    }

    /**
     * Define el valor de la propiedad countrycode.
     * 
     * @param value
     *     allowed object is
     *     {@link COUNTRYCODETypeShape }
     *     
     */
    public void setCOUNTRYCODE(COUNTRYCODETypeShape value) {
        this.countrycode = value;
    }

    /**
     * Obtiene el valor de la propiedad phone.
     * 
     * @return
     *     possible object is
     *     {@link PHONETypeShape }
     *     
     */
    public PHONETypeShape getPHONE() {
        return phone;
    }

    /**
     * Define el valor de la propiedad phone.
     * 
     * @param value
     *     allowed object is
     *     {@link PHONETypeShape }
     *     
     */
    public void setPHONE(PHONETypeShape value) {
        this.phone = value;
    }

    /**
     * Obtiene el valor de la propiedad endingtitle.
     * 
     * @return
     *     possible object is
     *     {@link ENDINGTITLETypeShape }
     *     
     */
    public ENDINGTITLETypeShape getENDINGTITLE() {
        return endingtitle;
    }

    /**
     * Define el valor de la propiedad endingtitle.
     * 
     * @param value
     *     allowed object is
     *     {@link ENDINGTITLETypeShape }
     *     
     */
    public void setENDINGTITLE(ENDINGTITLETypeShape value) {
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
