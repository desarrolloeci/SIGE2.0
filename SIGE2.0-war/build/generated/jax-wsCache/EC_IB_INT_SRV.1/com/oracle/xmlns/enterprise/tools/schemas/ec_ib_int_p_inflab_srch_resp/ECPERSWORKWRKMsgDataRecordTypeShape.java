
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_PERSWORK_WRKMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_PERSWORK_WRKMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EMPLID_TypeShape"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EFFDT_TypeShape"/&gt;
 *         &lt;element name="SEQ_NBR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}SEQ_NBR_TypeShape"/&gt;
 *         &lt;element name="ROLENAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}ROLENAME_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EFF_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EFF_STATUS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="HIRE_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}HIRE_DT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="CMPNY_SENIORITY_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}CMPNY_SENIORITY_DT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="SERVICE_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}SERVICE_DT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="BUSINESS_TITLE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}BUSINESS_TITLE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="DEPTID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}DEPTID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="BUSINESS_UNIT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}BUSINESS_UNIT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="HOURLY_RT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}HOURLY_RT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EMPL_CLASS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EMPL_CLASS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="LAST_DATE_WORKED" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}LAST_DATE_WORKED_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EXPECTED_RETURN_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EXPECTED_RETURN_DT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="LAST_VERIFICATN_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}LAST_VERIFICATN_DT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ACCOMPLISHMENT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}ACCOMPLISHMENT_TypeShape"/&gt;
 *         &lt;element name="LC_CNT_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}LC_CNT_TYPE_TypeShape" minOccurs="0"/&gt;
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
@XmlType(name = "EC_PERSWORK_WRKMsgDataRecord_TypeShape", propOrder = {
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
public class ECPERSWORKWRKMsgDataRecordTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected EMPLIDTypeShape emplid;
    @XmlElement(name = "EFFDT", required = true)
    protected EFFDTTypeShape effdt;
    @XmlElement(name = "SEQ_NBR", required = true)
    protected SEQNBRTypeShape seqnbr;
    @XmlElement(name = "ROLENAME")
    protected ROLENAMETypeShape rolename;
    @XmlElement(name = "EFF_STATUS")
    protected EFFSTATUSTypeShape effstatus;
    @XmlElement(name = "HIRE_DT")
    protected HIREDTTypeShape hiredt;
    @XmlElement(name = "CMPNY_SENIORITY_DT")
    protected CMPNYSENIORITYDTTypeShape cmpnysenioritydt;
    @XmlElement(name = "SERVICE_DT")
    protected SERVICEDTTypeShape servicedt;
    @XmlElement(name = "BUSINESS_TITLE")
    protected BUSINESSTITLETypeShape businesstitle;
    @XmlElement(name = "DEPTID")
    protected DEPTIDTypeShape deptid;
    @XmlElement(name = "BUSINESS_UNIT")
    protected BUSINESSUNITTypeShape businessunit;
    @XmlElement(name = "HOURLY_RT")
    protected HOURLYRTTypeShape hourlyrt;
    @XmlElement(name = "EMPL_CLASS")
    protected EMPLCLASSTypeShape emplclass;
    @XmlElement(name = "LAST_DATE_WORKED")
    protected LASTDATEWORKEDTypeShape lastdateworked;
    @XmlElement(name = "EXPECTED_RETURN_DT")
    protected EXPECTEDRETURNDTTypeShape expectedreturndt;
    @XmlElement(name = "LAST_VERIFICATN_DT")
    protected LASTVERIFICATNDTTypeShape lastverificatndt;
    @XmlElement(name = "ACCOMPLISHMENT", required = true)
    protected ACCOMPLISHMENTTypeShape accomplishment;
    @XmlElement(name = "LC_CNT_TYPE")
    protected LCCNTTYPETypeShape lccnttype;
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
     * Obtiene el valor de la propiedad seqnbr.
     * 
     * @return
     *     possible object is
     *     {@link SEQNBRTypeShape }
     *     
     */
    public SEQNBRTypeShape getSEQNBR() {
        return seqnbr;
    }

    /**
     * Define el valor de la propiedad seqnbr.
     * 
     * @param value
     *     allowed object is
     *     {@link SEQNBRTypeShape }
     *     
     */
    public void setSEQNBR(SEQNBRTypeShape value) {
        this.seqnbr = value;
    }

    /**
     * Obtiene el valor de la propiedad rolename.
     * 
     * @return
     *     possible object is
     *     {@link ROLENAMETypeShape }
     *     
     */
    public ROLENAMETypeShape getROLENAME() {
        return rolename;
    }

    /**
     * Define el valor de la propiedad rolename.
     * 
     * @param value
     *     allowed object is
     *     {@link ROLENAMETypeShape }
     *     
     */
    public void setROLENAME(ROLENAMETypeShape value) {
        this.rolename = value;
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
     * Obtiene el valor de la propiedad hiredt.
     * 
     * @return
     *     possible object is
     *     {@link HIREDTTypeShape }
     *     
     */
    public HIREDTTypeShape getHIREDT() {
        return hiredt;
    }

    /**
     * Define el valor de la propiedad hiredt.
     * 
     * @param value
     *     allowed object is
     *     {@link HIREDTTypeShape }
     *     
     */
    public void setHIREDT(HIREDTTypeShape value) {
        this.hiredt = value;
    }

    /**
     * Obtiene el valor de la propiedad cmpnysenioritydt.
     * 
     * @return
     *     possible object is
     *     {@link CMPNYSENIORITYDTTypeShape }
     *     
     */
    public CMPNYSENIORITYDTTypeShape getCMPNYSENIORITYDT() {
        return cmpnysenioritydt;
    }

    /**
     * Define el valor de la propiedad cmpnysenioritydt.
     * 
     * @param value
     *     allowed object is
     *     {@link CMPNYSENIORITYDTTypeShape }
     *     
     */
    public void setCMPNYSENIORITYDT(CMPNYSENIORITYDTTypeShape value) {
        this.cmpnysenioritydt = value;
    }

    /**
     * Obtiene el valor de la propiedad servicedt.
     * 
     * @return
     *     possible object is
     *     {@link SERVICEDTTypeShape }
     *     
     */
    public SERVICEDTTypeShape getSERVICEDT() {
        return servicedt;
    }

    /**
     * Define el valor de la propiedad servicedt.
     * 
     * @param value
     *     allowed object is
     *     {@link SERVICEDTTypeShape }
     *     
     */
    public void setSERVICEDT(SERVICEDTTypeShape value) {
        this.servicedt = value;
    }

    /**
     * Obtiene el valor de la propiedad businesstitle.
     * 
     * @return
     *     possible object is
     *     {@link BUSINESSTITLETypeShape }
     *     
     */
    public BUSINESSTITLETypeShape getBUSINESSTITLE() {
        return businesstitle;
    }

    /**
     * Define el valor de la propiedad businesstitle.
     * 
     * @param value
     *     allowed object is
     *     {@link BUSINESSTITLETypeShape }
     *     
     */
    public void setBUSINESSTITLE(BUSINESSTITLETypeShape value) {
        this.businesstitle = value;
    }

    /**
     * Obtiene el valor de la propiedad deptid.
     * 
     * @return
     *     possible object is
     *     {@link DEPTIDTypeShape }
     *     
     */
    public DEPTIDTypeShape getDEPTID() {
        return deptid;
    }

    /**
     * Define el valor de la propiedad deptid.
     * 
     * @param value
     *     allowed object is
     *     {@link DEPTIDTypeShape }
     *     
     */
    public void setDEPTID(DEPTIDTypeShape value) {
        this.deptid = value;
    }

    /**
     * Obtiene el valor de la propiedad businessunit.
     * 
     * @return
     *     possible object is
     *     {@link BUSINESSUNITTypeShape }
     *     
     */
    public BUSINESSUNITTypeShape getBUSINESSUNIT() {
        return businessunit;
    }

    /**
     * Define el valor de la propiedad businessunit.
     * 
     * @param value
     *     allowed object is
     *     {@link BUSINESSUNITTypeShape }
     *     
     */
    public void setBUSINESSUNIT(BUSINESSUNITTypeShape value) {
        this.businessunit = value;
    }

    /**
     * Obtiene el valor de la propiedad hourlyrt.
     * 
     * @return
     *     possible object is
     *     {@link HOURLYRTTypeShape }
     *     
     */
    public HOURLYRTTypeShape getHOURLYRT() {
        return hourlyrt;
    }

    /**
     * Define el valor de la propiedad hourlyrt.
     * 
     * @param value
     *     allowed object is
     *     {@link HOURLYRTTypeShape }
     *     
     */
    public void setHOURLYRT(HOURLYRTTypeShape value) {
        this.hourlyrt = value;
    }

    /**
     * Obtiene el valor de la propiedad emplclass.
     * 
     * @return
     *     possible object is
     *     {@link EMPLCLASSTypeShape }
     *     
     */
    public EMPLCLASSTypeShape getEMPLCLASS() {
        return emplclass;
    }

    /**
     * Define el valor de la propiedad emplclass.
     * 
     * @param value
     *     allowed object is
     *     {@link EMPLCLASSTypeShape }
     *     
     */
    public void setEMPLCLASS(EMPLCLASSTypeShape value) {
        this.emplclass = value;
    }

    /**
     * Obtiene el valor de la propiedad lastdateworked.
     * 
     * @return
     *     possible object is
     *     {@link LASTDATEWORKEDTypeShape }
     *     
     */
    public LASTDATEWORKEDTypeShape getLASTDATEWORKED() {
        return lastdateworked;
    }

    /**
     * Define el valor de la propiedad lastdateworked.
     * 
     * @param value
     *     allowed object is
     *     {@link LASTDATEWORKEDTypeShape }
     *     
     */
    public void setLASTDATEWORKED(LASTDATEWORKEDTypeShape value) {
        this.lastdateworked = value;
    }

    /**
     * Obtiene el valor de la propiedad expectedreturndt.
     * 
     * @return
     *     possible object is
     *     {@link EXPECTEDRETURNDTTypeShape }
     *     
     */
    public EXPECTEDRETURNDTTypeShape getEXPECTEDRETURNDT() {
        return expectedreturndt;
    }

    /**
     * Define el valor de la propiedad expectedreturndt.
     * 
     * @param value
     *     allowed object is
     *     {@link EXPECTEDRETURNDTTypeShape }
     *     
     */
    public void setEXPECTEDRETURNDT(EXPECTEDRETURNDTTypeShape value) {
        this.expectedreturndt = value;
    }

    /**
     * Obtiene el valor de la propiedad lastverificatndt.
     * 
     * @return
     *     possible object is
     *     {@link LASTVERIFICATNDTTypeShape }
     *     
     */
    public LASTVERIFICATNDTTypeShape getLASTVERIFICATNDT() {
        return lastverificatndt;
    }

    /**
     * Define el valor de la propiedad lastverificatndt.
     * 
     * @param value
     *     allowed object is
     *     {@link LASTVERIFICATNDTTypeShape }
     *     
     */
    public void setLASTVERIFICATNDT(LASTVERIFICATNDTTypeShape value) {
        this.lastverificatndt = value;
    }

    /**
     * Obtiene el valor de la propiedad accomplishment.
     * 
     * @return
     *     possible object is
     *     {@link ACCOMPLISHMENTTypeShape }
     *     
     */
    public ACCOMPLISHMENTTypeShape getACCOMPLISHMENT() {
        return accomplishment;
    }

    /**
     * Define el valor de la propiedad accomplishment.
     * 
     * @param value
     *     allowed object is
     *     {@link ACCOMPLISHMENTTypeShape }
     *     
     */
    public void setACCOMPLISHMENT(ACCOMPLISHMENTTypeShape value) {
        this.accomplishment = value;
    }

    /**
     * Obtiene el valor de la propiedad lccnttype.
     * 
     * @return
     *     possible object is
     *     {@link LCCNTTYPETypeShape }
     *     
     */
    public LCCNTTYPETypeShape getLCCNTTYPE() {
        return lccnttype;
    }

    /**
     * Define el valor de la propiedad lccnttype.
     * 
     * @param value
     *     allowed object is
     *     {@link LCCNTTYPETypeShape }
     *     
     */
    public void setLCCNTTYPE(LCCNTTYPETypeShape value) {
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
