
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_resp_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_IB_INTO_TBLMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_IB_INTO_TBLMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NATIONAL_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}NATIONAL_ID_TypeShape"/&gt;
 *         &lt;element name="LC_NATIONAL_ID_TYP" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}LC_NATIONAL_ID_TYP_TypeShape"/&gt;
 *         &lt;element name="EXT_ORG_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EXT_ORG_ID_TypeShape"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EFFDT_TypeShape"/&gt;
 *         &lt;element name="EFF_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EFF_STATUS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EXT_ORG_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EXT_ORG_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="DESCR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}DESCR_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="DESCR50" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}DESCR50_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="DESCRLONG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}DESCRLONG_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ORG_CONTACT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}ORG_CONTACT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ORG_LOCATION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}ORG_LOCATION_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}COUNTRY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS1" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}ADDRESS1_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="STATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}STATE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="CITY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}CITY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="LC_ESTRATO_SOCIAL" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}LC_ESTRATO_SOCIAL_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="COUNTY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}COUNTY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="URL_ADDRESS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}URL_ADDRESS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EMAILID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EMAILID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EDI_ADDRESS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EDI_ADDRESS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PHONE_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}PHONE_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY_CODE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}COUNTRY_CODE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PHONE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}PHONE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EXTENSION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EXTENSION_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PREF_PHONE_FLAG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}PREF_PHONE_FLAG_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_IND_CLI" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EC_IND_CLI_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_DOM_LOC" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EC_DOM_LOC_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_REGIMEN" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EC_REGIMEN_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_IND_AUTO" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EC_IND_AUTO_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_AGEN_RET" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EC_AGEN_RET_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_ACCOUNT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EC_ACCOUNT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_ACCOUNT2" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1}EC_ACCOUNT2_TypeShape" minOccurs="0"/&gt;
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
@XmlType(name = "EC_IB_INTO_TBLMsgDataRecord_TypeShape", propOrder = {
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
public class ECIBINTOTBLMsgDataRecordTypeShape {

    @XmlElement(name = "NATIONAL_ID", required = true)
    protected NATIONALIDTypeShape nationalid;
    @XmlElement(name = "LC_NATIONAL_ID_TYP", required = true)
    protected LCNATIONALIDTYPTypeShape lcnationalidtyp;
    @XmlElement(name = "EXT_ORG_ID", required = true)
    protected EXTORGIDTypeShape extorgid;
    @XmlElement(name = "EFFDT", required = true)
    protected EFFDTTypeShape effdt;
    @XmlElement(name = "EFF_STATUS")
    protected EFFSTATUSTypeShape effstatus;
    @XmlElement(name = "EXT_ORG_TYPE")
    protected EXTORGTYPETypeShape extorgtype;
    @XmlElement(name = "DESCR")
    protected DESCRTypeShape descr;
    @XmlElement(name = "DESCR50")
    protected DESCR50TypeShape descr50;
    @XmlElement(name = "DESCRLONG")
    protected DESCRLONGTypeShape descrlong;
    @XmlElement(name = "ORG_CONTACT")
    protected ORGCONTACTTypeShape orgcontact;
    @XmlElement(name = "ORG_LOCATION")
    protected ORGLOCATIONTypeShape orglocation;
    @XmlElement(name = "COUNTRY")
    protected COUNTRYTypeShape country;
    @XmlElement(name = "ADDRESS1")
    protected ADDRESS1TypeShape address1;
    @XmlElement(name = "STATE")
    protected STATETypeShape state;
    @XmlElement(name = "CITY")
    protected CITYTypeShape city;
    @XmlElement(name = "LC_ESTRATO_SOCIAL")
    protected LCESTRATOSOCIALTypeShape lcestratosocial;
    @XmlElement(name = "COUNTY")
    protected COUNTYTypeShape county;
    @XmlElement(name = "URL_ADDRESS")
    protected URLADDRESSTypeShape urladdress;
    @XmlElement(name = "EMAILID")
    protected EMAILIDTypeShape emailid;
    @XmlElement(name = "EDI_ADDRESS")
    protected EDIADDRESSTypeShape ediaddress;
    @XmlElement(name = "PHONE_TYPE")
    protected PHONETYPETypeShape phonetype;
    @XmlElement(name = "COUNTRY_CODE")
    protected COUNTRYCODETypeShape countrycode;
    @XmlElement(name = "PHONE")
    protected PHONETypeShape phone;
    @XmlElement(name = "EXTENSION")
    protected EXTENSIONTypeShape extension;
    @XmlElement(name = "PREF_PHONE_FLAG")
    protected PREFPHONEFLAGTypeShape prefphoneflag;
    @XmlElement(name = "EC_IND_CLI")
    protected ECINDCLITypeShape ecindcli;
    @XmlElement(name = "EC_DOM_LOC")
    protected ECDOMLOCTypeShape ecdomloc;
    @XmlElement(name = "EC_REGIMEN")
    protected ECREGIMENTypeShape ecregimen;
    @XmlElement(name = "EC_IND_AUTO")
    protected ECINDAUTOTypeShape ecindauto;
    @XmlElement(name = "EC_AGEN_RET")
    protected ECAGENRETTypeShape ecagenret;
    @XmlElement(name = "EC_ACCOUNT")
    protected ECACCOUNTTypeShape ecaccount;
    @XmlElement(name = "EC_ACCOUNT2")
    protected ECACCOUNT2TypeShape ecaccount2;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad nationalid.
     * 
     * @return
     *     possible object is
     *     {@link NATIONALIDTypeShape }
     *     
     */
    public NATIONALIDTypeShape getNATIONALID() {
        return nationalid;
    }

    /**
     * Define el valor de la propiedad nationalid.
     * 
     * @param value
     *     allowed object is
     *     {@link NATIONALIDTypeShape }
     *     
     */
    public void setNATIONALID(NATIONALIDTypeShape value) {
        this.nationalid = value;
    }

    /**
     * Obtiene el valor de la propiedad lcnationalidtyp.
     * 
     * @return
     *     possible object is
     *     {@link LCNATIONALIDTYPTypeShape }
     *     
     */
    public LCNATIONALIDTYPTypeShape getLCNATIONALIDTYP() {
        return lcnationalidtyp;
    }

    /**
     * Define el valor de la propiedad lcnationalidtyp.
     * 
     * @param value
     *     allowed object is
     *     {@link LCNATIONALIDTYPTypeShape }
     *     
     */
    public void setLCNATIONALIDTYP(LCNATIONALIDTYPTypeShape value) {
        this.lcnationalidtyp = value;
    }

    /**
     * Obtiene el valor de la propiedad extorgid.
     * 
     * @return
     *     possible object is
     *     {@link EXTORGIDTypeShape }
     *     
     */
    public EXTORGIDTypeShape getEXTORGID() {
        return extorgid;
    }

    /**
     * Define el valor de la propiedad extorgid.
     * 
     * @param value
     *     allowed object is
     *     {@link EXTORGIDTypeShape }
     *     
     */
    public void setEXTORGID(EXTORGIDTypeShape value) {
        this.extorgid = value;
    }

    /**
     * Obtiene el valor de la propiedad effdt.
     * 
     * @return
     *     possible object is
     *     {@link EFFDTTypeShape }
     *     
     */
    public EFFDTTypeShape getEFFDT() {
        return effdt;
    }

    /**
     * Define el valor de la propiedad effdt.
     * 
     * @param value
     *     allowed object is
     *     {@link EFFDTTypeShape }
     *     
     */
    public void setEFFDT(EFFDTTypeShape value) {
        this.effdt = value;
    }

    /**
     * Obtiene el valor de la propiedad effstatus.
     * 
     * @return
     *     possible object is
     *     {@link EFFSTATUSTypeShape }
     *     
     */
    public EFFSTATUSTypeShape getEFFSTATUS() {
        return effstatus;
    }

    /**
     * Define el valor de la propiedad effstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link EFFSTATUSTypeShape }
     *     
     */
    public void setEFFSTATUS(EFFSTATUSTypeShape value) {
        this.effstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad extorgtype.
     * 
     * @return
     *     possible object is
     *     {@link EXTORGTYPETypeShape }
     *     
     */
    public EXTORGTYPETypeShape getEXTORGTYPE() {
        return extorgtype;
    }

    /**
     * Define el valor de la propiedad extorgtype.
     * 
     * @param value
     *     allowed object is
     *     {@link EXTORGTYPETypeShape }
     *     
     */
    public void setEXTORGTYPE(EXTORGTYPETypeShape value) {
        this.extorgtype = value;
    }

    /**
     * Obtiene el valor de la propiedad descr.
     * 
     * @return
     *     possible object is
     *     {@link DESCRTypeShape }
     *     
     */
    public DESCRTypeShape getDESCR() {
        return descr;
    }

    /**
     * Define el valor de la propiedad descr.
     * 
     * @param value
     *     allowed object is
     *     {@link DESCRTypeShape }
     *     
     */
    public void setDESCR(DESCRTypeShape value) {
        this.descr = value;
    }

    /**
     * Obtiene el valor de la propiedad descr50.
     * 
     * @return
     *     possible object is
     *     {@link DESCR50TypeShape }
     *     
     */
    public DESCR50TypeShape getDESCR50() {
        return descr50;
    }

    /**
     * Define el valor de la propiedad descr50.
     * 
     * @param value
     *     allowed object is
     *     {@link DESCR50TypeShape }
     *     
     */
    public void setDESCR50(DESCR50TypeShape value) {
        this.descr50 = value;
    }

    /**
     * Obtiene el valor de la propiedad descrlong.
     * 
     * @return
     *     possible object is
     *     {@link DESCRLONGTypeShape }
     *     
     */
    public DESCRLONGTypeShape getDESCRLONG() {
        return descrlong;
    }

    /**
     * Define el valor de la propiedad descrlong.
     * 
     * @param value
     *     allowed object is
     *     {@link DESCRLONGTypeShape }
     *     
     */
    public void setDESCRLONG(DESCRLONGTypeShape value) {
        this.descrlong = value;
    }

    /**
     * Obtiene el valor de la propiedad orgcontact.
     * 
     * @return
     *     possible object is
     *     {@link ORGCONTACTTypeShape }
     *     
     */
    public ORGCONTACTTypeShape getORGCONTACT() {
        return orgcontact;
    }

    /**
     * Define el valor de la propiedad orgcontact.
     * 
     * @param value
     *     allowed object is
     *     {@link ORGCONTACTTypeShape }
     *     
     */
    public void setORGCONTACT(ORGCONTACTTypeShape value) {
        this.orgcontact = value;
    }

    /**
     * Obtiene el valor de la propiedad orglocation.
     * 
     * @return
     *     possible object is
     *     {@link ORGLOCATIONTypeShape }
     *     
     */
    public ORGLOCATIONTypeShape getORGLOCATION() {
        return orglocation;
    }

    /**
     * Define el valor de la propiedad orglocation.
     * 
     * @param value
     *     allowed object is
     *     {@link ORGLOCATIONTypeShape }
     *     
     */
    public void setORGLOCATION(ORGLOCATIONTypeShape value) {
        this.orglocation = value;
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
     * Obtiene el valor de la propiedad address1.
     * 
     * @return
     *     possible object is
     *     {@link ADDRESS1TypeShape }
     *     
     */
    public ADDRESS1TypeShape getADDRESS1() {
        return address1;
    }

    /**
     * Define el valor de la propiedad address1.
     * 
     * @param value
     *     allowed object is
     *     {@link ADDRESS1TypeShape }
     *     
     */
    public void setADDRESS1(ADDRESS1TypeShape value) {
        this.address1 = value;
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
     * Obtiene el valor de la propiedad lcestratosocial.
     * 
     * @return
     *     possible object is
     *     {@link LCESTRATOSOCIALTypeShape }
     *     
     */
    public LCESTRATOSOCIALTypeShape getLCESTRATOSOCIAL() {
        return lcestratosocial;
    }

    /**
     * Define el valor de la propiedad lcestratosocial.
     * 
     * @param value
     *     allowed object is
     *     {@link LCESTRATOSOCIALTypeShape }
     *     
     */
    public void setLCESTRATOSOCIAL(LCESTRATOSOCIALTypeShape value) {
        this.lcestratosocial = value;
    }

    /**
     * Obtiene el valor de la propiedad county.
     * 
     * @return
     *     possible object is
     *     {@link COUNTYTypeShape }
     *     
     */
    public COUNTYTypeShape getCOUNTY() {
        return county;
    }

    /**
     * Define el valor de la propiedad county.
     * 
     * @param value
     *     allowed object is
     *     {@link COUNTYTypeShape }
     *     
     */
    public void setCOUNTY(COUNTYTypeShape value) {
        this.county = value;
    }

    /**
     * Obtiene el valor de la propiedad urladdress.
     * 
     * @return
     *     possible object is
     *     {@link URLADDRESSTypeShape }
     *     
     */
    public URLADDRESSTypeShape getURLADDRESS() {
        return urladdress;
    }

    /**
     * Define el valor de la propiedad urladdress.
     * 
     * @param value
     *     allowed object is
     *     {@link URLADDRESSTypeShape }
     *     
     */
    public void setURLADDRESS(URLADDRESSTypeShape value) {
        this.urladdress = value;
    }

    /**
     * Obtiene el valor de la propiedad emailid.
     * 
     * @return
     *     possible object is
     *     {@link EMAILIDTypeShape }
     *     
     */
    public EMAILIDTypeShape getEMAILID() {
        return emailid;
    }

    /**
     * Define el valor de la propiedad emailid.
     * 
     * @param value
     *     allowed object is
     *     {@link EMAILIDTypeShape }
     *     
     */
    public void setEMAILID(EMAILIDTypeShape value) {
        this.emailid = value;
    }

    /**
     * Obtiene el valor de la propiedad ediaddress.
     * 
     * @return
     *     possible object is
     *     {@link EDIADDRESSTypeShape }
     *     
     */
    public EDIADDRESSTypeShape getEDIADDRESS() {
        return ediaddress;
    }

    /**
     * Define el valor de la propiedad ediaddress.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIADDRESSTypeShape }
     *     
     */
    public void setEDIADDRESS(EDIADDRESSTypeShape value) {
        this.ediaddress = value;
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
     * Obtiene el valor de la propiedad extension.
     * 
     * @return
     *     possible object is
     *     {@link EXTENSIONTypeShape }
     *     
     */
    public EXTENSIONTypeShape getEXTENSION() {
        return extension;
    }

    /**
     * Define el valor de la propiedad extension.
     * 
     * @param value
     *     allowed object is
     *     {@link EXTENSIONTypeShape }
     *     
     */
    public void setEXTENSION(EXTENSIONTypeShape value) {
        this.extension = value;
    }

    /**
     * Obtiene el valor de la propiedad prefphoneflag.
     * 
     * @return
     *     possible object is
     *     {@link PREFPHONEFLAGTypeShape }
     *     
     */
    public PREFPHONEFLAGTypeShape getPREFPHONEFLAG() {
        return prefphoneflag;
    }

    /**
     * Define el valor de la propiedad prefphoneflag.
     * 
     * @param value
     *     allowed object is
     *     {@link PREFPHONEFLAGTypeShape }
     *     
     */
    public void setPREFPHONEFLAG(PREFPHONEFLAGTypeShape value) {
        this.prefphoneflag = value;
    }

    /**
     * Obtiene el valor de la propiedad ecindcli.
     * 
     * @return
     *     possible object is
     *     {@link ECINDCLITypeShape }
     *     
     */
    public ECINDCLITypeShape getECINDCLI() {
        return ecindcli;
    }

    /**
     * Define el valor de la propiedad ecindcli.
     * 
     * @param value
     *     allowed object is
     *     {@link ECINDCLITypeShape }
     *     
     */
    public void setECINDCLI(ECINDCLITypeShape value) {
        this.ecindcli = value;
    }

    /**
     * Obtiene el valor de la propiedad ecdomloc.
     * 
     * @return
     *     possible object is
     *     {@link ECDOMLOCTypeShape }
     *     
     */
    public ECDOMLOCTypeShape getECDOMLOC() {
        return ecdomloc;
    }

    /**
     * Define el valor de la propiedad ecdomloc.
     * 
     * @param value
     *     allowed object is
     *     {@link ECDOMLOCTypeShape }
     *     
     */
    public void setECDOMLOC(ECDOMLOCTypeShape value) {
        this.ecdomloc = value;
    }

    /**
     * Obtiene el valor de la propiedad ecregimen.
     * 
     * @return
     *     possible object is
     *     {@link ECREGIMENTypeShape }
     *     
     */
    public ECREGIMENTypeShape getECREGIMEN() {
        return ecregimen;
    }

    /**
     * Define el valor de la propiedad ecregimen.
     * 
     * @param value
     *     allowed object is
     *     {@link ECREGIMENTypeShape }
     *     
     */
    public void setECREGIMEN(ECREGIMENTypeShape value) {
        this.ecregimen = value;
    }

    /**
     * Obtiene el valor de la propiedad ecindauto.
     * 
     * @return
     *     possible object is
     *     {@link ECINDAUTOTypeShape }
     *     
     */
    public ECINDAUTOTypeShape getECINDAUTO() {
        return ecindauto;
    }

    /**
     * Define el valor de la propiedad ecindauto.
     * 
     * @param value
     *     allowed object is
     *     {@link ECINDAUTOTypeShape }
     *     
     */
    public void setECINDAUTO(ECINDAUTOTypeShape value) {
        this.ecindauto = value;
    }

    /**
     * Obtiene el valor de la propiedad ecagenret.
     * 
     * @return
     *     possible object is
     *     {@link ECAGENRETTypeShape }
     *     
     */
    public ECAGENRETTypeShape getECAGENRET() {
        return ecagenret;
    }

    /**
     * Define el valor de la propiedad ecagenret.
     * 
     * @param value
     *     allowed object is
     *     {@link ECAGENRETTypeShape }
     *     
     */
    public void setECAGENRET(ECAGENRETTypeShape value) {
        this.ecagenret = value;
    }

    /**
     * Obtiene el valor de la propiedad ecaccount.
     * 
     * @return
     *     possible object is
     *     {@link ECACCOUNTTypeShape }
     *     
     */
    public ECACCOUNTTypeShape getECACCOUNT() {
        return ecaccount;
    }

    /**
     * Define el valor de la propiedad ecaccount.
     * 
     * @param value
     *     allowed object is
     *     {@link ECACCOUNTTypeShape }
     *     
     */
    public void setECACCOUNT(ECACCOUNTTypeShape value) {
        this.ecaccount = value;
    }

    /**
     * Obtiene el valor de la propiedad ecaccount2.
     * 
     * @return
     *     possible object is
     *     {@link ECACCOUNT2TypeShape }
     *     
     */
    public ECACCOUNT2TypeShape getECACCOUNT2() {
        return ecaccount2;
    }

    /**
     * Define el valor de la propiedad ecaccount2.
     * 
     * @param value
     *     allowed object is
     *     {@link ECACCOUNT2TypeShape }
     *     
     */
    public void setECACCOUNT2(ECACCOUNT2TypeShape value) {
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
