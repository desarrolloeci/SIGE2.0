
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_upd_req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypesEC_PERS_EDU_WRK_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypesEC_PERS_EDU_WRK_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType"/&gt;
 *         &lt;element name="ACCOMPLISHMENT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="DT_ISSUED" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType"/&gt;
 *         &lt;element name="COUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="BEGIN_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="END_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
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
@XmlType(name = "FieldTypesEC_PERS_EDU_WRK_TypeShape", propOrder = {
    "emplid",
    "effdt",
    "accomplishment",
    "dtissued",
    "country",
    "begindt",
    "enddt"
})
public class FieldTypesECPERSEDUWRKTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected FieldTypesCharFieldType emplid;
    @XmlElement(name = "EFFDT", required = true)
    protected FieldTypesDateFieldType effdt;
    @XmlElement(name = "ACCOMPLISHMENT", required = true)
    protected FieldTypesCharFieldType accomplishment;
    @XmlElement(name = "DT_ISSUED", required = true)
    protected FieldTypesDateFieldType dtissued;
    @XmlElement(name = "COUNTRY")
    protected FieldTypesCharFieldType country;
    @XmlElement(name = "BEGIN_DT")
    protected FieldTypesDateFieldType begindt;
    @XmlElement(name = "END_DT")
    protected FieldTypesDateFieldType enddt;
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
     * Obtiene el valor de la propiedad dtissued.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getDTISSUED() {
        return dtissued;
    }

    /**
     * Define el valor de la propiedad dtissued.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setDTISSUED(FieldTypesDateFieldType value) {
        this.dtissued = value;
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
     * Obtiene el valor de la propiedad begindt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getBEGINDT() {
        return begindt;
    }

    /**
     * Define el valor de la propiedad begindt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setBEGINDT(FieldTypesDateFieldType value) {
        this.begindt = value;
    }

    /**
     * Obtiene el valor de la propiedad enddt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getENDDT() {
        return enddt;
    }

    /**
     * Define el valor de la propiedad enddt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setENDDT(FieldTypesDateFieldType value) {
        this.enddt = value;
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
