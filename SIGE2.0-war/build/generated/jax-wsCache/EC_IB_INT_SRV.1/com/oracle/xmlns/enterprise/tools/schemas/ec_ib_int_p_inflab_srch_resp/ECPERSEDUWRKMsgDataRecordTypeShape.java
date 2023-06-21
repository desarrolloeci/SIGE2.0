
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_PERS_EDU_WRKMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_PERS_EDU_WRKMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EMPLID_TypeShape"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}EFFDT_TypeShape"/&gt;
 *         &lt;element name="ACCOMPLISHMENT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}ACCOMPLISHMENT_TypeShape"/&gt;
 *         &lt;element name="DT_ISSUED" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}DT_ISSUED_TypeShape"/&gt;
 *         &lt;element name="COUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}COUNTRY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="BEGIN_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}BEGIN_DT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="END_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}END_DT_TypeShape" minOccurs="0"/&gt;
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
@XmlType(name = "EC_PERS_EDU_WRKMsgDataRecord_TypeShape", propOrder = {
    "emplid",
    "effdt",
    "accomplishment",
    "dtissued",
    "country",
    "begindt",
    "enddt"
})
public class ECPERSEDUWRKMsgDataRecordTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected EMPLIDTypeShape emplid;
    @XmlElement(name = "EFFDT", required = true)
    protected EFFDTTypeShape effdt;
    @XmlElement(name = "ACCOMPLISHMENT", required = true)
    protected ACCOMPLISHMENTTypeShape accomplishment;
    @XmlElement(name = "DT_ISSUED", required = true)
    protected DTISSUEDTypeShape dtissued;
    @XmlElement(name = "COUNTRY")
    protected COUNTRYTypeShape country;
    @XmlElement(name = "BEGIN_DT")
    protected BEGINDTTypeShape begindt;
    @XmlElement(name = "END_DT")
    protected ENDDTTypeShape enddt;
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
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link COUNTRYTypeShape }
     *     
     */
    public COUNTRYTypeShape getCOUNTRY() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link COUNTRYTypeShape }
     *     
     */
    public void setCOUNTRY(COUNTRYTypeShape value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad begindt.
     * 
     * @return
     *     possible object is
     *     {@link BEGINDTTypeShape }
     *     
     */
    public BEGINDTTypeShape getBEGINDT() {
        return begindt;
    }

    /**
     * Define el valor de la propiedad begindt.
     * 
     * @param value
     *     allowed object is
     *     {@link BEGINDTTypeShape }
     *     
     */
    public void setBEGINDT(BEGINDTTypeShape value) {
        this.begindt = value;
    }

    /**
     * Obtiene el valor de la propiedad enddt.
     * 
     * @return
     *     possible object is
     *     {@link ENDDTTypeShape }
     *     
     */
    public ENDDTTypeShape getENDDT() {
        return enddt;
    }

    /**
     * Define el valor de la propiedad enddt.
     * 
     * @param value
     *     allowed object is
     *     {@link ENDDTTypeShape }
     *     
     */
    public void setENDDT(ENDDTTypeShape value) {
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
