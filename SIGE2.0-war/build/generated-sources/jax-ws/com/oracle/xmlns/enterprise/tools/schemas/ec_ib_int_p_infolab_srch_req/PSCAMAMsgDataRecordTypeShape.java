
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_infolab_srch_req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PSCAMAMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PSCAMAMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LANGUAGE_CD" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFOLAB_SRCH_REQ.V1}LANGUAGE_CD_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="AUDIT_ACTN" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFOLAB_SRCH_REQ.V1}AUDIT_ACTN_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="BASE_LANGUAGE_CD" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFOLAB_SRCH_REQ.V1}BASE_LANGUAGE_CD_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="MSG_SEQ_FLG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFOLAB_SRCH_REQ.V1}MSG_SEQ_FLG_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PROCESS_INSTANCE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFOLAB_SRCH_REQ.V1}PROCESS_INSTANCE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PUBLISH_RULE_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFOLAB_SRCH_REQ.V1}PUBLISH_RULE_ID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="MSGNODENAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFOLAB_SRCH_REQ.V1}MSGNODENAME_TypeShape" minOccurs="0"/&gt;
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
@XmlType(name = "PSCAMAMsgDataRecord_TypeShape", propOrder = {
    "languagecd",
    "auditactn",
    "baselanguagecd",
    "msgseqflg",
    "processinstance",
    "publishruleid",
    "msgnodename"
})
public class PSCAMAMsgDataRecordTypeShape {

    @XmlElement(name = "LANGUAGE_CD")
    protected LANGUAGECDTypeShape languagecd;
    @XmlElement(name = "AUDIT_ACTN")
    protected AUDITACTNTypeShape auditactn;
    @XmlElement(name = "BASE_LANGUAGE_CD")
    protected BASELANGUAGECDTypeShape baselanguagecd;
    @XmlElement(name = "MSG_SEQ_FLG")
    protected MSGSEQFLGTypeShape msgseqflg;
    @XmlElement(name = "PROCESS_INSTANCE")
    protected PROCESSINSTANCETypeShape processinstance;
    @XmlElement(name = "PUBLISH_RULE_ID")
    protected PUBLISHRULEIDTypeShape publishruleid;
    @XmlElement(name = "MSGNODENAME")
    protected MSGNODENAMETypeShape msgnodename;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad languagecd.
     * 
     * @return
     *     possible object is
     *     {@link LANGUAGECDTypeShape }
     *     
     */
    public LANGUAGECDTypeShape getLANGUAGECD() {
        return languagecd;
    }

    /**
     * Define el valor de la propiedad languagecd.
     * 
     * @param value
     *     allowed object is
     *     {@link LANGUAGECDTypeShape }
     *     
     */
    public void setLANGUAGECD(LANGUAGECDTypeShape value) {
        this.languagecd = value;
    }

    /**
     * Obtiene el valor de la propiedad auditactn.
     * 
     * @return
     *     possible object is
     *     {@link AUDITACTNTypeShape }
     *     
     */
    public AUDITACTNTypeShape getAUDITACTN() {
        return auditactn;
    }

    /**
     * Define el valor de la propiedad auditactn.
     * 
     * @param value
     *     allowed object is
     *     {@link AUDITACTNTypeShape }
     *     
     */
    public void setAUDITACTN(AUDITACTNTypeShape value) {
        this.auditactn = value;
    }

    /**
     * Obtiene el valor de la propiedad baselanguagecd.
     * 
     * @return
     *     possible object is
     *     {@link BASELANGUAGECDTypeShape }
     *     
     */
    public BASELANGUAGECDTypeShape getBASELANGUAGECD() {
        return baselanguagecd;
    }

    /**
     * Define el valor de la propiedad baselanguagecd.
     * 
     * @param value
     *     allowed object is
     *     {@link BASELANGUAGECDTypeShape }
     *     
     */
    public void setBASELANGUAGECD(BASELANGUAGECDTypeShape value) {
        this.baselanguagecd = value;
    }

    /**
     * Obtiene el valor de la propiedad msgseqflg.
     * 
     * @return
     *     possible object is
     *     {@link MSGSEQFLGTypeShape }
     *     
     */
    public MSGSEQFLGTypeShape getMSGSEQFLG() {
        return msgseqflg;
    }

    /**
     * Define el valor de la propiedad msgseqflg.
     * 
     * @param value
     *     allowed object is
     *     {@link MSGSEQFLGTypeShape }
     *     
     */
    public void setMSGSEQFLG(MSGSEQFLGTypeShape value) {
        this.msgseqflg = value;
    }

    /**
     * Obtiene el valor de la propiedad processinstance.
     * 
     * @return
     *     possible object is
     *     {@link PROCESSINSTANCETypeShape }
     *     
     */
    public PROCESSINSTANCETypeShape getPROCESSINSTANCE() {
        return processinstance;
    }

    /**
     * Define el valor de la propiedad processinstance.
     * 
     * @param value
     *     allowed object is
     *     {@link PROCESSINSTANCETypeShape }
     *     
     */
    public void setPROCESSINSTANCE(PROCESSINSTANCETypeShape value) {
        this.processinstance = value;
    }

    /**
     * Obtiene el valor de la propiedad publishruleid.
     * 
     * @return
     *     possible object is
     *     {@link PUBLISHRULEIDTypeShape }
     *     
     */
    public PUBLISHRULEIDTypeShape getPUBLISHRULEID() {
        return publishruleid;
    }

    /**
     * Define el valor de la propiedad publishruleid.
     * 
     * @param value
     *     allowed object is
     *     {@link PUBLISHRULEIDTypeShape }
     *     
     */
    public void setPUBLISHRULEID(PUBLISHRULEIDTypeShape value) {
        this.publishruleid = value;
    }

    /**
     * Obtiene el valor de la propiedad msgnodename.
     * 
     * @return
     *     possible object is
     *     {@link MSGNODENAMETypeShape }
     *     
     */
    public MSGNODENAMETypeShape getMSGNODENAME() {
        return msgnodename;
    }

    /**
     * Define el valor de la propiedad msgnodename.
     * 
     * @param value
     *     allowed object is
     *     {@link MSGNODENAMETypeShape }
     *     
     */
    public void setMSGNODENAME(MSGNODENAMETypeShape value) {
        this.msgnodename = value;
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
