
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_SSR_RS_THESIMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_SSR_RS_THESIMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CAMPUS_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}CAMPUS_ID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}EMPLID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="INSTITUTION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}INSTITUTION_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_CAREER" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}ACAD_CAREER_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="SSR_DESCR100" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}SSR_DESCR100_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PROJECT_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}PROJECT_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="SSR_RS_THESIS_TITL" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}SSR_RS_THESIS_TITL_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="LC_ID_SOL_SERVICIO" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}LC_ID_SOL_SERVICIO_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_PROG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}ACAD_PROG_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_PLAN" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}ACAD_PLAN_TypeShape" minOccurs="0"/&gt;
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
@XmlType(name = "EC_SSR_RS_THESIMsgDataRecord_TypeShape", propOrder = {
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
public class ECSSRRSTHESIMsgDataRecordTypeShape {

    @XmlElement(name = "CAMPUS_ID")
    protected CAMPUSIDTypeShape campusid;
    @XmlElement(name = "EMPLID")
    protected EMPLIDTypeShape emplid;
    @XmlElement(name = "INSTITUTION")
    protected INSTITUTIONTypeShape institution;
    @XmlElement(name = "ACAD_CAREER")
    protected ACADCAREERTypeShape acadcareer;
    @XmlElement(name = "SSR_DESCR100")
    protected SSRDESCR100TypeShape ssrdescr100;
    @XmlElement(name = "PROJECT_TYPE")
    protected PROJECTTYPETypeShape projecttype;
    @XmlElement(name = "SSR_RS_THESIS_TITL")
    protected SSRRSTHESISTITLTypeShape ssrrsthesistitl;
    @XmlElement(name = "LC_ID_SOL_SERVICIO")
    protected LCIDSOLSERVICIOTypeShape lcidsolservicio;
    @XmlElement(name = "ACAD_PROG")
    protected ACADPROGTypeShape acadprog;
    @XmlElement(name = "ACAD_PLAN")
    protected ACADPLANTypeShape acadplan;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad campusid.
     * 
     * @return
     *     possible object is
     *     {@link CAMPUSIDTypeShape }
     *     
     */
    public CAMPUSIDTypeShape getCAMPUSID() {
        return campusid;
    }

    /**
     * Define el valor de la propiedad campusid.
     * 
     * @param value
     *     allowed object is
     *     {@link CAMPUSIDTypeShape }
     *     
     */
    public void setCAMPUSID(CAMPUSIDTypeShape value) {
        this.campusid = value;
    }

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
     * Obtiene el valor de la propiedad institution.
     * 
     * @return
     *     possible object is
     *     {@link INSTITUTIONTypeShape }
     *     
     */
    public INSTITUTIONTypeShape getINSTITUTION() {
        return institution;
    }

    /**
     * Define el valor de la propiedad institution.
     * 
     * @param value
     *     allowed object is
     *     {@link INSTITUTIONTypeShape }
     *     
     */
    public void setINSTITUTION(INSTITUTIONTypeShape value) {
        this.institution = value;
    }

    /**
     * Obtiene el valor de la propiedad acadcareer.
     * 
     * @return
     *     possible object is
     *     {@link ACADCAREERTypeShape }
     *     
     */
    public ACADCAREERTypeShape getACADCAREER() {
        return acadcareer;
    }

    /**
     * Define el valor de la propiedad acadcareer.
     * 
     * @param value
     *     allowed object is
     *     {@link ACADCAREERTypeShape }
     *     
     */
    public void setACADCAREER(ACADCAREERTypeShape value) {
        this.acadcareer = value;
    }

    /**
     * Obtiene el valor de la propiedad ssrdescr100.
     * 
     * @return
     *     possible object is
     *     {@link SSRDESCR100TypeShape }
     *     
     */
    public SSRDESCR100TypeShape getSSRDESCR100() {
        return ssrdescr100;
    }

    /**
     * Define el valor de la propiedad ssrdescr100.
     * 
     * @param value
     *     allowed object is
     *     {@link SSRDESCR100TypeShape }
     *     
     */
    public void setSSRDESCR100(SSRDESCR100TypeShape value) {
        this.ssrdescr100 = value;
    }

    /**
     * Obtiene el valor de la propiedad projecttype.
     * 
     * @return
     *     possible object is
     *     {@link PROJECTTYPETypeShape }
     *     
     */
    public PROJECTTYPETypeShape getPROJECTTYPE() {
        return projecttype;
    }

    /**
     * Define el valor de la propiedad projecttype.
     * 
     * @param value
     *     allowed object is
     *     {@link PROJECTTYPETypeShape }
     *     
     */
    public void setPROJECTTYPE(PROJECTTYPETypeShape value) {
        this.projecttype = value;
    }

    /**
     * Obtiene el valor de la propiedad ssrrsthesistitl.
     * 
     * @return
     *     possible object is
     *     {@link SSRRSTHESISTITLTypeShape }
     *     
     */
    public SSRRSTHESISTITLTypeShape getSSRRSTHESISTITL() {
        return ssrrsthesistitl;
    }

    /**
     * Define el valor de la propiedad ssrrsthesistitl.
     * 
     * @param value
     *     allowed object is
     *     {@link SSRRSTHESISTITLTypeShape }
     *     
     */
    public void setSSRRSTHESISTITL(SSRRSTHESISTITLTypeShape value) {
        this.ssrrsthesistitl = value;
    }

    /**
     * Obtiene el valor de la propiedad lcidsolservicio.
     * 
     * @return
     *     possible object is
     *     {@link LCIDSOLSERVICIOTypeShape }
     *     
     */
    public LCIDSOLSERVICIOTypeShape getLCIDSOLSERVICIO() {
        return lcidsolservicio;
    }

    /**
     * Define el valor de la propiedad lcidsolservicio.
     * 
     * @param value
     *     allowed object is
     *     {@link LCIDSOLSERVICIOTypeShape }
     *     
     */
    public void setLCIDSOLSERVICIO(LCIDSOLSERVICIOTypeShape value) {
        this.lcidsolservicio = value;
    }

    /**
     * Obtiene el valor de la propiedad acadprog.
     * 
     * @return
     *     possible object is
     *     {@link ACADPROGTypeShape }
     *     
     */
    public ACADPROGTypeShape getACADPROG() {
        return acadprog;
    }

    /**
     * Define el valor de la propiedad acadprog.
     * 
     * @param value
     *     allowed object is
     *     {@link ACADPROGTypeShape }
     *     
     */
    public void setACADPROG(ACADPROGTypeShape value) {
        this.acadprog = value;
    }

    /**
     * Obtiene el valor de la propiedad acadplan.
     * 
     * @return
     *     possible object is
     *     {@link ACADPLANTypeShape }
     *     
     */
    public ACADPLANTypeShape getACADPLAN() {
        return acadplan;
    }

    /**
     * Define el valor de la propiedad acadplan.
     * 
     * @param value
     *     allowed object is
     *     {@link ACADPLANTypeShape }
     *     
     */
    public void setACADPLAN(ACADPLANTypeShape value) {
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
