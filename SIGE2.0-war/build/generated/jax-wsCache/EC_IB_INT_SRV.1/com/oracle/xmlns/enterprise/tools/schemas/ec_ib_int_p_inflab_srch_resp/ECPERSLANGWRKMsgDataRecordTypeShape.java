
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_PERSLANG_WRKMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_PERSLANG_WRKMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EMPLID_TypeShape"/&gt;
 *         &lt;element name="ACCOMPLISHMENT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}ACCOMPLISHMENT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="NATIVE_LANGUAGE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}NATIVE_LANGUAGE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="TRANSLATOR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}TRANSLATOR_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="SPEAK_PROFICIENCY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}SPEAK_PROFICIENCY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="READ_PROFICIENCY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}READ_PROFICIENCY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="WRITE_PROFICIENCY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}WRITE_PROFICIENCY_TypeShape" minOccurs="0"/&gt;
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
@XmlType(name = "EC_PERSLANG_WRKMsgDataRecord_TypeShape", propOrder = {
    "emplid",
    "accomplishment",
    "nativelanguage",
    "translator",
    "speakproficiency",
    "readproficiency",
    "writeproficiency"
})
public class ECPERSLANGWRKMsgDataRecordTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected EMPLIDTypeShape emplid;
    @XmlElement(name = "ACCOMPLISHMENT")
    protected ACCOMPLISHMENTTypeShape accomplishment;
    @XmlElement(name = "NATIVE_LANGUAGE")
    protected NATIVELANGUAGETypeShape nativelanguage;
    @XmlElement(name = "TRANSLATOR")
    protected TRANSLATORTypeShape translator;
    @XmlElement(name = "SPEAK_PROFICIENCY")
    protected SPEAKPROFICIENCYTypeShape speakproficiency;
    @XmlElement(name = "READ_PROFICIENCY")
    protected READPROFICIENCYTypeShape readproficiency;
    @XmlElement(name = "WRITE_PROFICIENCY")
    protected WRITEPROFICIENCYTypeShape writeproficiency;
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
     * Obtiene el valor de la propiedad nativelanguage.
     * 
     * @return
     *     possible object is
     *     {@link NATIVELANGUAGETypeShape }
     *     
     */
    public NATIVELANGUAGETypeShape getNATIVELANGUAGE() {
        return nativelanguage;
    }

    /**
     * Define el valor de la propiedad nativelanguage.
     * 
     * @param value
     *     allowed object is
     *     {@link NATIVELANGUAGETypeShape }
     *     
     */
    public void setNATIVELANGUAGE(NATIVELANGUAGETypeShape value) {
        this.nativelanguage = value;
    }

    /**
     * Obtiene el valor de la propiedad translator.
     * 
     * @return
     *     possible object is
     *     {@link TRANSLATORTypeShape }
     *     
     */
    public TRANSLATORTypeShape getTRANSLATOR() {
        return translator;
    }

    /**
     * Define el valor de la propiedad translator.
     * 
     * @param value
     *     allowed object is
     *     {@link TRANSLATORTypeShape }
     *     
     */
    public void setTRANSLATOR(TRANSLATORTypeShape value) {
        this.translator = value;
    }

    /**
     * Obtiene el valor de la propiedad speakproficiency.
     * 
     * @return
     *     possible object is
     *     {@link SPEAKPROFICIENCYTypeShape }
     *     
     */
    public SPEAKPROFICIENCYTypeShape getSPEAKPROFICIENCY() {
        return speakproficiency;
    }

    /**
     * Define el valor de la propiedad speakproficiency.
     * 
     * @param value
     *     allowed object is
     *     {@link SPEAKPROFICIENCYTypeShape }
     *     
     */
    public void setSPEAKPROFICIENCY(SPEAKPROFICIENCYTypeShape value) {
        this.speakproficiency = value;
    }

    /**
     * Obtiene el valor de la propiedad readproficiency.
     * 
     * @return
     *     possible object is
     *     {@link READPROFICIENCYTypeShape }
     *     
     */
    public READPROFICIENCYTypeShape getREADPROFICIENCY() {
        return readproficiency;
    }

    /**
     * Define el valor de la propiedad readproficiency.
     * 
     * @param value
     *     allowed object is
     *     {@link READPROFICIENCYTypeShape }
     *     
     */
    public void setREADPROFICIENCY(READPROFICIENCYTypeShape value) {
        this.readproficiency = value;
    }

    /**
     * Obtiene el valor de la propiedad writeproficiency.
     * 
     * @return
     *     possible object is
     *     {@link WRITEPROFICIENCYTypeShape }
     *     
     */
    public WRITEPROFICIENCYTypeShape getWRITEPROFICIENCY() {
        return writeproficiency;
    }

    /**
     * Define el valor de la propiedad writeproficiency.
     * 
     * @param value
     *     allowed object is
     *     {@link WRITEPROFICIENCYTypeShape }
     *     
     */
    public void setWRITEPROFICIENCY(WRITEPROFICIENCYTypeShape value) {
        this.writeproficiency = value;
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
