
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_IB_INTO_SRCHMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_IB_INTO_SRCHMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EXT_ORG_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}EXT_ORG_ID_TypeShape"/&gt;
 *         &lt;element name="EXT_ORG_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}EXT_ORG_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="LC_NATIONAL_ID_TYP" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}LC_NATIONAL_ID_TYP_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="NATIONAL_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}NATIONAL_ID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}NAME_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}EFFDT_TypeShape"/&gt;
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
@XmlType(name = "EC_IB_INTO_SRCHMsgDataRecord_TypeShape", propOrder = {
    "extorgid",
    "extorgtype",
    "lcnationalidtyp",
    "nationalid",
    "name",
    "effdt"
})
public class ECIBINTOSRCHMsgDataRecordTypeShape {

    @XmlElement(name = "EXT_ORG_ID", required = true)
    protected EXTORGIDTypeShape extorgid;
    @XmlElement(name = "EXT_ORG_TYPE")
    protected EXTORGTYPETypeShape extorgtype;
    @XmlElement(name = "LC_NATIONAL_ID_TYP")
    protected LCNATIONALIDTYPTypeShape lcnationalidtyp;
    @XmlElement(name = "NATIONAL_ID")
    protected NATIONALIDTypeShape nationalid;
    @XmlElement(name = "NAME")
    protected NAMETypeShape name;
    @XmlElement(name = "EFFDT", required = true)
    protected EFFDTTypeShape effdt;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

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
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link NAMETypeShape }
     *     
     */
    public NAMETypeShape getNAME() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link NAMETypeShape }
     *     
     */
    public void setNAME(NAMETypeShape value) {
        this.name = value;
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
