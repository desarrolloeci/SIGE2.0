
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypesEC_SSR_RS_THESI_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypesEC_SSR_RS_THESI_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CAMPUS_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="INSTITUTION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_CAREER" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="SSR_DESCR100" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PROJECT_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="SSR_RS_THESIS_TITL" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="LC_ID_SOL_SERVICIO" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_PROG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_PLAN" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
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
@XmlType(name = "FieldTypesEC_SSR_RS_THESI_TypeShape", propOrder = {
    "campusid",
    "emplid",
    "institution",
    "acadcareer",
    "ssrdescr100",
    "projecttype",
    "ssrrsthesistitl",
    "lcidsolservicio",
    "acadprog",
    "acadplan"
})
public class FieldTypesECSSRRSTHESITypeShape {

    @XmlElement(name = "CAMPUS_ID")
    protected FieldTypesCharFieldType campusid;
    @XmlElement(name = "EMPLID")
    protected FieldTypesCharFieldType emplid;
    @XmlElement(name = "INSTITUTION")
    protected FieldTypesCharFieldType institution;
    @XmlElement(name = "ACAD_CAREER")
    protected FieldTypesCharFieldType acadcareer;
    @XmlElement(name = "SSR_DESCR100")
    protected FieldTypesCharFieldType ssrdescr100;
    @XmlElement(name = "PROJECT_TYPE")
    protected FieldTypesCharFieldType projecttype;
    @XmlElement(name = "SSR_RS_THESIS_TITL")
    protected FieldTypesCharFieldType ssrrsthesistitl;
    @XmlElement(name = "LC_ID_SOL_SERVICIO")
    protected FieldTypesCharFieldType lcidsolservicio;
    @XmlElement(name = "ACAD_PROG")
    protected FieldTypesCharFieldType acadprog;
    @XmlElement(name = "ACAD_PLAN")
    protected FieldTypesCharFieldType acadplan;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad campusid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCAMPUSID() {
        return campusid;
    }

    /**
     * Define el valor de la propiedad campusid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCAMPUSID(FieldTypesCharFieldType value) {
        this.campusid = value;
    }

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
     * Obtiene el valor de la propiedad institution.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getINSTITUTION() {
        return institution;
    }

    /**
     * Define el valor de la propiedad institution.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setINSTITUTION(FieldTypesCharFieldType value) {
        this.institution = value;
    }

    /**
     * Obtiene el valor de la propiedad acadcareer.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getACADCAREER() {
        return acadcareer;
    }

    /**
     * Define el valor de la propiedad acadcareer.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setACADCAREER(FieldTypesCharFieldType value) {
        this.acadcareer = value;
    }

    /**
     * Obtiene el valor de la propiedad ssrdescr100.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getSSRDESCR100() {
        return ssrdescr100;
    }

    /**
     * Define el valor de la propiedad ssrdescr100.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setSSRDESCR100(FieldTypesCharFieldType value) {
        this.ssrdescr100 = value;
    }

    /**
     * Obtiene el valor de la propiedad projecttype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPROJECTTYPE() {
        return projecttype;
    }

    /**
     * Define el valor de la propiedad projecttype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPROJECTTYPE(FieldTypesCharFieldType value) {
        this.projecttype = value;
    }

    /**
     * Obtiene el valor de la propiedad ssrrsthesistitl.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getSSRRSTHESISTITL() {
        return ssrrsthesistitl;
    }

    /**
     * Define el valor de la propiedad ssrrsthesistitl.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setSSRRSTHESISTITL(FieldTypesCharFieldType value) {
        this.ssrrsthesistitl = value;
    }

    /**
     * Obtiene el valor de la propiedad lcidsolservicio.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getLCIDSOLSERVICIO() {
        return lcidsolservicio;
    }

    /**
     * Define el valor de la propiedad lcidsolservicio.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setLCIDSOLSERVICIO(FieldTypesCharFieldType value) {
        this.lcidsolservicio = value;
    }

    /**
     * Obtiene el valor de la propiedad acadprog.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getACADPROG() {
        return acadprog;
    }

    /**
     * Define el valor de la propiedad acadprog.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setACADPROG(FieldTypesCharFieldType value) {
        this.acadprog = value;
    }

    /**
     * Obtiene el valor de la propiedad acadplan.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getACADPLAN() {
        return acadplan;
    }

    /**
     * Define el valor de la propiedad acadplan.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setACADPLAN(FieldTypesCharFieldType value) {
        this.acadplan = value;
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
