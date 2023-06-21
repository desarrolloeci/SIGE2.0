
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_PERS_MEM_WRKMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_PERS_MEM_WRKMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EMPLID_TypeShape"/&gt;
 *         &lt;element name="ACCOMPLISHMENT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}ACCOMPLISHMENT_TypeShape"/&gt;
 *         &lt;element name="DT_ISSUED" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}DT_ISSUED_TypeShape"/&gt;
 *         &lt;element name="MANDATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}MANDATE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="MANDATE_FUNCTION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}MANDATE_FUNCTION_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="MANDATE_BEGIN_DATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}MANDATE_BEGIN_DATE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="MANDATE_END_DATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}MANDATE_END_DATE_TypeShape" minOccurs="0"/&gt;
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
@XmlType(name = "EC_PERS_MEM_WRKMsgDataRecord_TypeShape", propOrder = {
    "emplid",
    "accomplishment",
    "dtissued",
    "mandate",
    "mandatefunction",
    "mandatebegindate",
    "mandateenddate"
})
public class ECPERSMEMWRKMsgDataRecordTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected EMPLIDTypeShape emplid;
    @XmlElement(name = "ACCOMPLISHMENT", required = true)
    protected ACCOMPLISHMENTTypeShape accomplishment;
    @XmlElement(name = "DT_ISSUED", required = true)
    protected DTISSUEDTypeShape dtissued;
    @XmlElement(name = "MANDATE")
    protected MANDATETypeShape mandate;
    @XmlElement(name = "MANDATE_FUNCTION")
    protected MANDATEFUNCTIONTypeShape mandatefunction;
    @XmlElement(name = "MANDATE_BEGIN_DATE")
    protected MANDATEBEGINDATETypeShape mandatebegindate;
    @XmlElement(name = "MANDATE_END_DATE")
    protected MANDATEENDDATETypeShape mandateenddate;
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
     * Obtiene el valor de la propiedad dtissued.
     * 
     * @return
     *     possible object is
     *     {@link DTISSUEDTypeShape }
     *     
     */
    public DTISSUEDTypeShape getDTISSUED() {
        return dtissued;
    }

    /**
     * Define el valor de la propiedad dtissued.
     * 
     * @param value
     *     allowed object is
     *     {@link DTISSUEDTypeShape }
     *     
     */
    public void setDTISSUED(DTISSUEDTypeShape value) {
        this.dtissued = value;
    }

    /**
     * Obtiene el valor de la propiedad mandate.
     * 
     * @return
     *     possible object is
     *     {@link MANDATETypeShape }
     *     
     */
    public MANDATETypeShape getMANDATE() {
        return mandate;
    }

    /**
     * Define el valor de la propiedad mandate.
     * 
     * @param value
     *     allowed object is
     *     {@link MANDATETypeShape }
     *     
     */
    public void setMANDATE(MANDATETypeShape value) {
        this.mandate = value;
    }

    /**
     * Obtiene el valor de la propiedad mandatefunction.
     * 
     * @return
     *     possible object is
     *     {@link MANDATEFUNCTIONTypeShape }
     *     
     */
    public MANDATEFUNCTIONTypeShape getMANDATEFUNCTION() {
        return mandatefunction;
    }

    /**
     * Define el valor de la propiedad mandatefunction.
     * 
     * @param value
     *     allowed object is
     *     {@link MANDATEFUNCTIONTypeShape }
     *     
     */
    public void setMANDATEFUNCTION(MANDATEFUNCTIONTypeShape value) {
        this.mandatefunction = value;
    }

    /**
     * Obtiene el valor de la propiedad mandatebegindate.
     * 
     * @return
     *     possible object is
     *     {@link MANDATEBEGINDATETypeShape }
     *     
     */
    public MANDATEBEGINDATETypeShape getMANDATEBEGINDATE() {
        return mandatebegindate;
    }

    /**
     * Define el valor de la propiedad mandatebegindate.
     * 
     * @param value
     *     allowed object is
     *     {@link MANDATEBEGINDATETypeShape }
     *     
     */
    public void setMANDATEBEGINDATE(MANDATEBEGINDATETypeShape value) {
        this.mandatebegindate = value;
    }

    /**
     * Obtiene el valor de la propiedad mandateenddate.
     * 
     * @return
     *     possible object is
     *     {@link MANDATEENDDATETypeShape }
     *     
     */
    public MANDATEENDDATETypeShape getMANDATEENDDATE() {
        return mandateenddate;
    }

    /**
     * Define el valor de la propiedad mandateenddate.
     * 
     * @param value
     *     allowed object is
     *     {@link MANDATEENDDATETypeShape }
     *     
     */
    public void setMANDATEENDDATE(MANDATEENDDATETypeShape value) {
        this.mandateenddate = value;
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
