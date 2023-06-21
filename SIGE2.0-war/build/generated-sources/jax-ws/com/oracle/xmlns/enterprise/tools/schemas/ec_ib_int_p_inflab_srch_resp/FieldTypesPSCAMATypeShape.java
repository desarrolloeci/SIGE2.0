
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypesPSCAMA_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypesPSCAMA_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LANGUAGE_CD" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="AUDIT_ACTN" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="BASE_LANGUAGE_CD" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="MSG_SEQ_FLG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PROCESS_INSTANCE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesNumberFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PUBLISH_RULE_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="MSGNODENAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
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
@XmlType(name = "FieldTypesPSCAMA_TypeShape", propOrder = {
    "languagecd",
    "auditactn",
    "baselanguagecd",
    "msgseqflg",
    "processinstance",
    "publishruleid",
    "msgnodename"
})
public class FieldTypesPSCAMATypeShape {

    @XmlElement(name = "LANGUAGE_CD")
    protected FieldTypesCharFieldType languagecd;
    @XmlElement(name = "AUDIT_ACTN")
    protected FieldTypesCharFieldType auditactn;
    @XmlElement(name = "BASE_LANGUAGE_CD")
    protected FieldTypesCharFieldType baselanguagecd;
    @XmlElement(name = "MSG_SEQ_FLG")
    protected FieldTypesCharFieldType msgseqflg;
    @XmlElement(name = "PROCESS_INSTANCE")
    protected FieldTypesNumberFieldType processinstance;
    @XmlElement(name = "PUBLISH_RULE_ID")
    protected FieldTypesCharFieldType publishruleid;
    @XmlElement(name = "MSGNODENAME")
    protected FieldTypesCharFieldType msgnodename;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad languagecd.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getLANGUAGECD() {
        return languagecd;
    }

    /**
     * Define el valor de la propiedad languagecd.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setLANGUAGECD(FieldTypesCharFieldType value) {
        this.languagecd = value;
    }

    /**
     * Obtiene el valor de la propiedad auditactn.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getAUDITACTN() {
        return auditactn;
    }

    /**
     * Define el valor de la propiedad auditactn.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setAUDITACTN(FieldTypesCharFieldType value) {
        this.auditactn = value;
    }

    /**
     * Obtiene el valor de la propiedad baselanguagecd.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getBASELANGUAGECD() {
        return baselanguagecd;
    }

    /**
     * Define el valor de la propiedad baselanguagecd.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setBASELANGUAGECD(FieldTypesCharFieldType value) {
        this.baselanguagecd = value;
    }

    /**
     * Obtiene el valor de la propiedad msgseqflg.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getMSGSEQFLG() {
        return msgseqflg;
    }

    /**
     * Define el valor de la propiedad msgseqflg.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setMSGSEQFLG(FieldTypesCharFieldType value) {
        this.msgseqflg = value;
    }

    /**
     * Obtiene el valor de la propiedad processinstance.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public FieldTypesNumberFieldType getPROCESSINSTANCE() {
        return processinstance;
    }

    /**
     * Define el valor de la propiedad processinstance.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public void setPROCESSINSTANCE(FieldTypesNumberFieldType value) {
        this.processinstance = value;
    }

    /**
     * Obtiene el valor de la propiedad publishruleid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPUBLISHRULEID() {
        return publishruleid;
    }

    /**
     * Define el valor de la propiedad publishruleid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPUBLISHRULEID(FieldTypesCharFieldType value) {
        this.publishruleid = value;
    }

    /**
     * Obtiene el valor de la propiedad msgnodename.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getMSGNODENAME() {
        return msgnodename;
    }

    /**
     * Define el valor de la propiedad msgnodename.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setMSGNODENAME(FieldTypesCharFieldType value) {
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
