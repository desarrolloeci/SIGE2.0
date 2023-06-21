
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_upd_req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypesEC_PERSWORK_WRK_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypesEC_PERSWORK_WRK_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType"/&gt;
 *         &lt;element name="SEQ_NBR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesNumberFieldType"/&gt;
 *         &lt;element name="ROLENAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EFF_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="HIRE_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="CMPNY_SENIORITY_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="SERVICE_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="BUSINESS_TITLE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="DEPTID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="BUSINESS_UNIT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="HOURLY_RT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesNumberFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EMPL_CLASS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="LAST_DATE_WORKED" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EXPECTED_RETURN_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="LAST_VERIFICATN_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ACCOMPLISHMENT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="LC_CNT_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
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
@XmlType(name = "FieldTypesEC_PERSWORK_WRK_TypeShape", propOrder = {
    "emplid",
    "effdt",
    "seqnbr",
    "rolename",
    "effstatus",
    "hiredt",
    "cmpnysenioritydt",
    "servicedt",
    "businesstitle",
    "deptid",
    "businessunit",
    "hourlyrt",
    "emplclass",
    "lastdateworked",
    "expectedreturndt",
    "lastverificatndt",
    "accomplishment",
    "lccnttype"
})
public class FieldTypesECPERSWORKWRKTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected FieldTypesCharFieldType emplid;
    @XmlElement(name = "EFFDT", required = true)
    protected FieldTypesDateFieldType effdt;
    @XmlElement(name = "SEQ_NBR", required = true)
    protected FieldTypesNumberFieldType seqnbr;
    @XmlElement(name = "ROLENAME")
    protected FieldTypesCharFieldType rolename;
    @XmlElement(name = "EFF_STATUS")
    protected FieldTypesCharFieldType effstatus;
    @XmlElement(name = "HIRE_DT")
    protected FieldTypesDateFieldType hiredt;
    @XmlElement(name = "CMPNY_SENIORITY_DT")
    protected FieldTypesDateFieldType cmpnysenioritydt;
    @XmlElement(name = "SERVICE_DT")
    protected FieldTypesDateFieldType servicedt;
    @XmlElement(name = "BUSINESS_TITLE")
    protected FieldTypesCharFieldType businesstitle;
    @XmlElement(name = "DEPTID")
    protected FieldTypesCharFieldType deptid;
    @XmlElement(name = "BUSINESS_UNIT")
    protected FieldTypesCharFieldType businessunit;
    @XmlElement(name = "HOURLY_RT")
    protected FieldTypesNumberFieldType hourlyrt;
    @XmlElement(name = "EMPL_CLASS")
    protected FieldTypesCharFieldType emplclass;
    @XmlElement(name = "LAST_DATE_WORKED")
    protected FieldTypesDateFieldType lastdateworked;
    @XmlElement(name = "EXPECTED_RETURN_DT")
    protected FieldTypesDateFieldType expectedreturndt;
    @XmlElement(name = "LAST_VERIFICATN_DT")
    protected FieldTypesDateFieldType lastverificatndt;
    @XmlElement(name = "ACCOMPLISHMENT", required = true)
    protected FieldTypesCharFieldType accomplishment;
    @XmlElement(name = "LC_CNT_TYPE")
    protected FieldTypesCharFieldType lccnttype;
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
     * Obtiene el valor de la propiedad seqnbr.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public FieldTypesNumberFieldType getSEQNBR() {
        return seqnbr;
    }

    /**
     * Define el valor de la propiedad seqnbr.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public void setSEQNBR(FieldTypesNumberFieldType value) {
        this.seqnbr = value;
    }

    /**
     * Obtiene el valor de la propiedad rolename.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getROLENAME() {
        return rolename;
    }

    /**
     * Define el valor de la propiedad rolename.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setROLENAME(FieldTypesCharFieldType value) {
        this.rolename = value;
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
     * Obtiene el valor de la propiedad hiredt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getHIREDT() {
        return hiredt;
    }

    /**
     * Define el valor de la propiedad hiredt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setHIREDT(FieldTypesDateFieldType value) {
        this.hiredt = value;
    }

    /**
     * Obtiene el valor de la propiedad cmpnysenioritydt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getCMPNYSENIORITYDT() {
        return cmpnysenioritydt;
    }

    /**
     * Define el valor de la propiedad cmpnysenioritydt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setCMPNYSENIORITYDT(FieldTypesDateFieldType value) {
        this.cmpnysenioritydt = value;
    }

    /**
     * Obtiene el valor de la propiedad servicedt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getSERVICEDT() {
        return servicedt;
    }

    /**
     * Define el valor de la propiedad servicedt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setSERVICEDT(FieldTypesDateFieldType value) {
        this.servicedt = value;
    }

    /**
     * Obtiene el valor de la propiedad businesstitle.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getBUSINESSTITLE() {
        return businesstitle;
    }

    /**
     * Define el valor de la propiedad businesstitle.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setBUSINESSTITLE(FieldTypesCharFieldType value) {
        this.businesstitle = value;
    }

    /**
     * Obtiene el valor de la propiedad deptid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getDEPTID() {
        return deptid;
    }

    /**
     * Define el valor de la propiedad deptid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setDEPTID(FieldTypesCharFieldType value) {
        this.deptid = value;
    }

    /**
     * Obtiene el valor de la propiedad businessunit.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getBUSINESSUNIT() {
        return businessunit;
    }

    /**
     * Define el valor de la propiedad businessunit.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setBUSINESSUNIT(FieldTypesCharFieldType value) {
        this.businessunit = value;
    }

    /**
     * Obtiene el valor de la propiedad hourlyrt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public FieldTypesNumberFieldType getHOURLYRT() {
        return hourlyrt;
    }

    /**
     * Define el valor de la propiedad hourlyrt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public void setHOURLYRT(FieldTypesNumberFieldType value) {
        this.hourlyrt = value;
    }

    /**
     * Obtiene el valor de la propiedad emplclass.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEMPLCLASS() {
        return emplclass;
    }

    /**
     * Define el valor de la propiedad emplclass.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEMPLCLASS(FieldTypesCharFieldType value) {
        this.emplclass = value;
    }

    /**
     * Obtiene el valor de la propiedad lastdateworked.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getLASTDATEWORKED() {
        return lastdateworked;
    }

    /**
     * Define el valor de la propiedad lastdateworked.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setLASTDATEWORKED(FieldTypesDateFieldType value) {
        this.lastdateworked = value;
    }

    /**
     * Obtiene el valor de la propiedad expectedreturndt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getEXPECTEDRETURNDT() {
        return expectedreturndt;
    }

    /**
     * Define el valor de la propiedad expectedreturndt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setEXPECTEDRETURNDT(FieldTypesDateFieldType value) {
        this.expectedreturndt = value;
    }

    /**
     * Obtiene el valor de la propiedad lastverificatndt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getLASTVERIFICATNDT() {
        return lastverificatndt;
    }

    /**
     * Define el valor de la propiedad lastverificatndt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setLASTVERIFICATNDT(FieldTypesDateFieldType value) {
        this.lastverificatndt = value;
    }

    /**
     * Obtiene el valor de la propiedad accomplishment.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getACCOMPLISHMENT() {
        return accomplishment;
    }

    /**
     * Define el valor de la propiedad accomplishment.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setACCOMPLISHMENT(FieldTypesCharFieldType value) {
        this.accomplishment = value;
    }

    /**
     * Obtiene el valor de la propiedad lccnttype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getLCCNTTYPE() {
        return lccnttype;
    }

    /**
     * Define el valor de la propiedad lccnttype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setLCCNTTYPE(FieldTypesCharFieldType value) {
        this.lccnttype = value;
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
