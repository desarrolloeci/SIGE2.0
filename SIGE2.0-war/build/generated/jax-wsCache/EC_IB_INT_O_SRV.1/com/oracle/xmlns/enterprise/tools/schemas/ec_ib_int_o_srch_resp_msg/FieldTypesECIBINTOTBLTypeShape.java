
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_resp_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypesEC_IB_INTO_TBL_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypesEC_IB_INTO_TBL_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NATIONAL_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="LC_NATIONAL_ID_TYP" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="EXT_ORG_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesDateFieldType"/&gt;
 *         &lt;element name="EFF_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EXT_ORG_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="DESCR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="DESCR50" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="DESCRLONG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ORG_CONTACT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesNumberFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ORG_LOCATION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesNumberFieldType" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS1" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="STATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="CITY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="LC_ESTRATO_SOCIAL" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="COUNTY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="URL_ADDRESS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EMAILID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EDI_ADDRESS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PHONE_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY_CODE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PHONE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EXTENSION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PREF_PHONE_FLAG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_IND_CLI" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_DOM_LOC" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_REGIMEN" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_IND_AUTO" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_AGEN_RET" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_ACCOUNT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_ACCOUNT2" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
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
@XmlType(name = "FieldTypesEC_IB_INTO_TBL_TypeShape", propOrder = {
    "nationalid",
    "lcnationalidtyp",
    "extorgid",
    "effdt",
    "effstatus",
    "extorgtype",
    "descr",
    "descr50",
    "descrlong",
    "orgcontact",
    "orglocation",
    "country",
    "address1",
    "state",
    "city",
    "lcestratosocial",
    "county",
    "urladdress",
    "emailid",
    "ediaddress",
    "phonetype",
    "countrycode",
    "phone",
    "extension",
    "prefphoneflag",
    "ecindcli",
    "ecdomloc",
    "ecregimen",
    "ecindauto",
    "ecagenret",
    "ecaccount",
    "ecaccount2"
})
public class FieldTypesECIBINTOTBLTypeShape {

    @XmlElement(name = "NATIONAL_ID", required = true)
    protected FieldTypesCharFieldType nationalid;
    @XmlElement(name = "LC_NATIONAL_ID_TYP", required = true)
    protected FieldTypesCharFieldType lcnationalidtyp;
    @XmlElement(name = "EXT_ORG_ID", required = true)
    protected FieldTypesCharFieldType extorgid;
    @XmlElement(name = "EFFDT", required = true)
    protected FieldTypesDateFieldType effdt;
    @XmlElement(name = "EFF_STATUS")
    protected FieldTypesCharFieldType effstatus;
    @XmlElement(name = "EXT_ORG_TYPE")
    protected FieldTypesCharFieldType extorgtype;
    @XmlElement(name = "DESCR")
    protected FieldTypesCharFieldType descr;
    @XmlElement(name = "DESCR50")
    protected FieldTypesCharFieldType descr50;
    @XmlElement(name = "DESCRLONG")
    protected FieldTypesCharFieldType descrlong;
    @XmlElement(name = "ORG_CONTACT")
    protected FieldTypesNumberFieldType orgcontact;
    @XmlElement(name = "ORG_LOCATION")
    protected FieldTypesNumberFieldType orglocation;
    @XmlElement(name = "COUNTRY")
    protected FieldTypesCharFieldType country;
    @XmlElement(name = "ADDRESS1")
    protected FieldTypesCharFieldType address1;
    @XmlElement(name = "STATE")
    protected FieldTypesCharFieldType state;
    @XmlElement(name = "CITY")
    protected FieldTypesCharFieldType city;
    @XmlElement(name = "LC_ESTRATO_SOCIAL")
    protected FieldTypesCharFieldType lcestratosocial;
    @XmlElement(name = "COUNTY")
    protected FieldTypesCharFieldType county;
    @XmlElement(name = "URL_ADDRESS")
    protected FieldTypesCharFieldType urladdress;
    @XmlElement(name = "EMAILID")
    protected FieldTypesCharFieldType emailid;
    @XmlElement(name = "EDI_ADDRESS")
    protected FieldTypesCharFieldType ediaddress;
    @XmlElement(name = "PHONE_TYPE")
    protected FieldTypesCharFieldType phonetype;
    @XmlElement(name = "COUNTRY_CODE")
    protected FieldTypesCharFieldType countrycode;
    @XmlElement(name = "PHONE")
    protected FieldTypesCharFieldType phone;
    @XmlElement(name = "EXTENSION")
    protected FieldTypesCharFieldType extension;
    @XmlElement(name = "PREF_PHONE_FLAG")
    protected FieldTypesCharFieldType prefphoneflag;
    @XmlElement(name = "EC_IND_CLI")
    protected FieldTypesCharFieldType ecindcli;
    @XmlElement(name = "EC_DOM_LOC")
    protected FieldTypesCharFieldType ecdomloc;
    @XmlElement(name = "EC_REGIMEN")
    protected FieldTypesCharFieldType ecregimen;
    @XmlElement(name = "EC_IND_AUTO")
    protected FieldTypesCharFieldType ecindauto;
    @XmlElement(name = "EC_AGEN_RET")
    protected FieldTypesCharFieldType ecagenret;
    @XmlElement(name = "EC_ACCOUNT")
    protected FieldTypesCharFieldType ecaccount;
    @XmlElement(name = "EC_ACCOUNT2")
    protected FieldTypesCharFieldType ecaccount2;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad nationalid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getNATIONALID() {
        return nationalid;
    }

    /**
     * Define el valor de la propiedad nationalid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setNATIONALID(FieldTypesCharFieldType value) {
        this.nationalid = value;
    }

    /**
     * Obtiene el valor de la propiedad lcnationalidtyp.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getLCNATIONALIDTYP() {
        return lcnationalidtyp;
    }

    /**
     * Define el valor de la propiedad lcnationalidtyp.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setLCNATIONALIDTYP(FieldTypesCharFieldType value) {
        this.lcnationalidtyp = value;
    }

    /**
     * Obtiene el valor de la propiedad extorgid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEXTORGID() {
        return extorgid;
    }

    /**
     * Define el valor de la propiedad extorgid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEXTORGID(FieldTypesCharFieldType value) {
        this.extorgid = value;
    }

    /**
     * Obtiene el valor de la propiedad effdt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getEFFDT() {
        return effdt;
    }

    /**
     * Define el valor de la propiedad effdt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setEFFDT(FieldTypesDateFieldType value) {
        this.effdt = value;
    }

    /**
     * Obtiene el valor de la propiedad effstatus.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEFFSTATUS() {
        return effstatus;
    }

    /**
     * Define el valor de la propiedad effstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEFFSTATUS(FieldTypesCharFieldType value) {
        this.effstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad extorgtype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEXTORGTYPE() {
        return extorgtype;
    }

    /**
     * Define el valor de la propiedad extorgtype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEXTORGTYPE(FieldTypesCharFieldType value) {
        this.extorgtype = value;
    }

    /**
     * Obtiene el valor de la propiedad descr.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getDESCR() {
        return descr;
    }

    /**
     * Define el valor de la propiedad descr.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setDESCR(FieldTypesCharFieldType value) {
        this.descr = value;
    }

    /**
     * Obtiene el valor de la propiedad descr50.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getDESCR50() {
        return descr50;
    }

    /**
     * Define el valor de la propiedad descr50.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setDESCR50(FieldTypesCharFieldType value) {
        this.descr50 = value;
    }

    /**
     * Obtiene el valor de la propiedad descrlong.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getDESCRLONG() {
        return descrlong;
    }

    /**
     * Define el valor de la propiedad descrlong.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setDESCRLONG(FieldTypesCharFieldType value) {
        this.descrlong = value;
    }

    /**
     * Obtiene el valor de la propiedad orgcontact.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public FieldTypesNumberFieldType getORGCONTACT() {
        return orgcontact;
    }

    /**
     * Define el valor de la propiedad orgcontact.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public void setORGCONTACT(FieldTypesNumberFieldType value) {
        this.orgcontact = value;
    }

    /**
     * Obtiene el valor de la propiedad orglocation.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public FieldTypesNumberFieldType getORGLOCATION() {
        return orglocation;
    }

    /**
     * Define el valor de la propiedad orglocation.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public void setORGLOCATION(FieldTypesNumberFieldType value) {
        this.orglocation = value;
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
     * Obtiene el valor de la propiedad address1.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getADDRESS1() {
        return address1;
    }

    /**
     * Define el valor de la propiedad address1.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setADDRESS1(FieldTypesCharFieldType value) {
        this.address1 = value;
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
     * Obtiene el valor de la propiedad lcestratosocial.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getLCESTRATOSOCIAL() {
        return lcestratosocial;
    }

    /**
     * Define el valor de la propiedad lcestratosocial.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setLCESTRATOSOCIAL(FieldTypesCharFieldType value) {
        this.lcestratosocial = value;
    }

    /**
     * Obtiene el valor de la propiedad county.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCOUNTY() {
        return county;
    }

    /**
     * Define el valor de la propiedad county.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCOUNTY(FieldTypesCharFieldType value) {
        this.county = value;
    }

    /**
     * Obtiene el valor de la propiedad urladdress.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getURLADDRESS() {
        return urladdress;
    }

    /**
     * Define el valor de la propiedad urladdress.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setURLADDRESS(FieldTypesCharFieldType value) {
        this.urladdress = value;
    }

    /**
     * Obtiene el valor de la propiedad emailid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEMAILID() {
        return emailid;
    }

    /**
     * Define el valor de la propiedad emailid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEMAILID(FieldTypesCharFieldType value) {
        this.emailid = value;
    }

    /**
     * Obtiene el valor de la propiedad ediaddress.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEDIADDRESS() {
        return ediaddress;
    }

    /**
     * Define el valor de la propiedad ediaddress.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEDIADDRESS(FieldTypesCharFieldType value) {
        this.ediaddress = value;
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
     * Obtiene el valor de la propiedad extension.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEXTENSION() {
        return extension;
    }

    /**
     * Define el valor de la propiedad extension.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEXTENSION(FieldTypesCharFieldType value) {
        this.extension = value;
    }

    /**
     * Obtiene el valor de la propiedad prefphoneflag.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPREFPHONEFLAG() {
        return prefphoneflag;
    }

    /**
     * Define el valor de la propiedad prefphoneflag.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPREFPHONEFLAG(FieldTypesCharFieldType value) {
        this.prefphoneflag = value;
    }

    /**
     * Obtiene el valor de la propiedad ecindcli.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECINDCLI() {
        return ecindcli;
    }

    /**
     * Define el valor de la propiedad ecindcli.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECINDCLI(FieldTypesCharFieldType value) {
        this.ecindcli = value;
    }

    /**
     * Obtiene el valor de la propiedad ecdomloc.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECDOMLOC() {
        return ecdomloc;
    }

    /**
     * Define el valor de la propiedad ecdomloc.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECDOMLOC(FieldTypesCharFieldType value) {
        this.ecdomloc = value;
    }

    /**
     * Obtiene el valor de la propiedad ecregimen.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECREGIMEN() {
        return ecregimen;
    }

    /**
     * Define el valor de la propiedad ecregimen.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECREGIMEN(FieldTypesCharFieldType value) {
        this.ecregimen = value;
    }

    /**
     * Obtiene el valor de la propiedad ecindauto.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECINDAUTO() {
        return ecindauto;
    }

    /**
     * Define el valor de la propiedad ecindauto.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECINDAUTO(FieldTypesCharFieldType value) {
        this.ecindauto = value;
    }

    /**
     * Obtiene el valor de la propiedad ecagenret.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECAGENRET() {
        return ecagenret;
    }

    /**
     * Define el valor de la propiedad ecagenret.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECAGENRET(FieldTypesCharFieldType value) {
        this.ecagenret = value;
    }

    /**
     * Obtiene el valor de la propiedad ecaccount.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECACCOUNT() {
        return ecaccount;
    }

    /**
     * Define el valor de la propiedad ecaccount.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECACCOUNT(FieldTypesCharFieldType value) {
        this.ecaccount = value;
    }

    /**
     * Obtiene el valor de la propiedad ecaccount2.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECACCOUNT2() {
        return ecaccount2;
    }

    /**
     * Define el valor de la propiedad ecaccount2.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECACCOUNT2(FieldTypesCharFieldType value) {
        this.ecaccount2 = value;
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
