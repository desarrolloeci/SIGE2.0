
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypesEC_PERSLANG_WRK_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypesEC_PERSLANG_WRK_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="ACCOMPLISHMENT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="NATIVE_LANGUAGE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="TRANSLATOR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="SPEAK_PROFICIENCY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="READ_PROFICIENCY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="WRITE_PROFICIENCY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
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
@XmlType(name = "FieldTypesEC_PERSLANG_WRK_TypeShape", propOrder = {
    "emplid",
    "accomplishment",
    "nativelanguage",
    "translator",
    "speakproficiency",
    "readproficiency",
    "writeproficiency"
})
public class FieldTypesECPERSLANGWRKTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected FieldTypesCharFieldType emplid;
    @XmlElement(name = "ACCOMPLISHMENT")
    protected FieldTypesCharFieldType accomplishment;
    @XmlElement(name = "NATIVE_LANGUAGE")
    protected FieldTypesCharFieldType nativelanguage;
    @XmlElement(name = "TRANSLATOR")
    protected FieldTypesCharFieldType translator;
    @XmlElement(name = "SPEAK_PROFICIENCY")
    protected FieldTypesCharFieldType speakproficiency;
    @XmlElement(name = "READ_PROFICIENCY")
    protected FieldTypesCharFieldType readproficiency;
    @XmlElement(name = "WRITE_PROFICIENCY")
    protected FieldTypesCharFieldType writeproficiency;
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
     * Obtiene el valor de la propiedad nativelanguage.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getNATIVELANGUAGE() {
        return nativelanguage;
    }

    /**
     * Define el valor de la propiedad nativelanguage.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setNATIVELANGUAGE(FieldTypesCharFieldType value) {
        this.nativelanguage = value;
    }

    /**
     * Obtiene el valor de la propiedad translator.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getTRANSLATOR() {
        return translator;
    }

    /**
     * Define el valor de la propiedad translator.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setTRANSLATOR(FieldTypesCharFieldType value) {
        this.translator = value;
    }

    /**
     * Obtiene el valor de la propiedad speakproficiency.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getSPEAKPROFICIENCY() {
        return speakproficiency;
    }

    /**
     * Define el valor de la propiedad speakproficiency.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setSPEAKPROFICIENCY(FieldTypesCharFieldType value) {
        this.speakproficiency = value;
    }

    /**
     * Obtiene el valor de la propiedad readproficiency.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getREADPROFICIENCY() {
        return readproficiency;
    }

    /**
     * Define el valor de la propiedad readproficiency.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setREADPROFICIENCY(FieldTypesCharFieldType value) {
        this.readproficiency = value;
    }

    /**
     * Obtiene el valor de la propiedad writeproficiency.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getWRITEPROFICIENCY() {
        return writeproficiency;
    }

    /**
     * Define el valor de la propiedad writeproficiency.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setWRITEPROFICIENCY(FieldTypesCharFieldType value) {
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
