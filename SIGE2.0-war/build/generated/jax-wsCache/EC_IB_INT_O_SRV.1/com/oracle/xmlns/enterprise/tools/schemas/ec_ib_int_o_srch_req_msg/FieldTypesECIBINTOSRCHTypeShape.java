
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypesEC_IB_INTO_SRCH_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypesEC_IB_INTO_SRCH_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EXT_ORG_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="EXT_ORG_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="LC_NATIONAL_ID_TYP" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="NATIONAL_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}FieldTypesDateFieldType"/&gt;
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
@XmlType(name = "FieldTypesEC_IB_INTO_SRCH_TypeShape", propOrder = {
    "extorgid",
    "extorgtype",
    "lcnationalidtyp",
    "nationalid",
    "name",
    "effdt"
})
public class FieldTypesECIBINTOSRCHTypeShape {

    @XmlElement(name = "EXT_ORG_ID", required = true)
    protected FieldTypesCharFieldType extorgid;
    @XmlElement(name = "EXT_ORG_TYPE")
    protected FieldTypesCharFieldType extorgtype;
    @XmlElement(name = "LC_NATIONAL_ID_TYP")
    protected FieldTypesCharFieldType lcnationalidtyp;
    @XmlElement(name = "NATIONAL_ID")
    protected FieldTypesCharFieldType nationalid;
    @XmlElement(name = "NAME")
    protected FieldTypesCharFieldType name;
    @XmlElement(name = "EFFDT", required = true)
    protected FieldTypesDateFieldType effdt;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

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
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getNAME() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setNAME(FieldTypesCharFieldType value) {
        this.name = value;
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
