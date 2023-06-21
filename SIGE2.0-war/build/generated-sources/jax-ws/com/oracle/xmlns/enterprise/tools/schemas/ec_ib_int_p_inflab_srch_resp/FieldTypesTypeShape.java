
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypes_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypes_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="EC_IB_INTP_TBL" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesEC_IB_INTP_TBL_TypeShape"/&gt;
 *         &lt;element name="EC_PERSWORK_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesEC_PERSWORK_WRK_TypeShape"/&gt;
 *         &lt;element name="EC_PERS_EXP_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesEC_PERS_EXP_WRK_TypeShape"/&gt;
 *         &lt;element name="EC_PERS_EDU_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesEC_PERS_EDU_WRK_TypeShape"/&gt;
 *         &lt;element name="EC_PERSLANG_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesEC_PERSLANG_WRK_TypeShape"/&gt;
 *         &lt;element name="EC_PERS_MEM_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesEC_PERS_MEM_WRK_TypeShape"/&gt;
 *         &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesPSCAMA_TypeShape"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FieldTypes_TypeShape", propOrder = {

})
public class FieldTypesTypeShape {

    @XmlElement(name = "EC_IB_INTP_TBL", required = true)
    protected FieldTypesECIBINTPTBLTypeShape ecibintptbl;
    @XmlElement(name = "EC_PERSWORK_WRK", required = true)
    protected FieldTypesECPERSWORKWRKTypeShape ecpersworkwrk;
    @XmlElement(name = "EC_PERS_EXP_WRK", required = true)
    protected FieldTypesECPERSEXPWRKTypeShape ecpersexpwrk;
    @XmlElement(name = "EC_PERS_EDU_WRK", required = true)
    protected FieldTypesECPERSEDUWRKTypeShape ecperseduwrk;
    @XmlElement(name = "EC_PERSLANG_WRK", required = true)
    protected FieldTypesECPERSLANGWRKTypeShape ecperslangwrk;
    @XmlElement(name = "EC_PERS_MEM_WRK", required = true)
    protected FieldTypesECPERSMEMWRKTypeShape ecpersmemwrk;
    @XmlElement(name = "PSCAMA", required = true)
    protected FieldTypesPSCAMATypeShape pscama;

    /**
     * Obtiene el valor de la propiedad ecibintptbl.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesECIBINTPTBLTypeShape }
     *     
     */
    public FieldTypesECIBINTPTBLTypeShape getECIBINTPTBL() {
        return ecibintptbl;
    }

    /**
     * Define el valor de la propiedad ecibintptbl.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesECIBINTPTBLTypeShape }
     *     
     */
    public void setECIBINTPTBL(FieldTypesECIBINTPTBLTypeShape value) {
        this.ecibintptbl = value;
    }

    /**
     * Obtiene el valor de la propiedad ecpersworkwrk.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesECPERSWORKWRKTypeShape }
     *     
     */
    public FieldTypesECPERSWORKWRKTypeShape getECPERSWORKWRK() {
        return ecpersworkwrk;
    }

    /**
     * Define el valor de la propiedad ecpersworkwrk.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesECPERSWORKWRKTypeShape }
     *     
     */
    public void setECPERSWORKWRK(FieldTypesECPERSWORKWRKTypeShape value) {
        this.ecpersworkwrk = value;
    }

    /**
     * Obtiene el valor de la propiedad ecpersexpwrk.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesECPERSEXPWRKTypeShape }
     *     
     */
    public FieldTypesECPERSEXPWRKTypeShape getECPERSEXPWRK() {
        return ecpersexpwrk;
    }

    /**
     * Define el valor de la propiedad ecpersexpwrk.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesECPERSEXPWRKTypeShape }
     *     
     */
    public void setECPERSEXPWRK(FieldTypesECPERSEXPWRKTypeShape value) {
        this.ecpersexpwrk = value;
    }

    /**
     * Obtiene el valor de la propiedad ecperseduwrk.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesECPERSEDUWRKTypeShape }
     *     
     */
    public FieldTypesECPERSEDUWRKTypeShape getECPERSEDUWRK() {
        return ecperseduwrk;
    }

    /**
     * Define el valor de la propiedad ecperseduwrk.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesECPERSEDUWRKTypeShape }
     *     
     */
    public void setECPERSEDUWRK(FieldTypesECPERSEDUWRKTypeShape value) {
        this.ecperseduwrk = value;
    }

    /**
     * Obtiene el valor de la propiedad ecperslangwrk.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesECPERSLANGWRKTypeShape }
     *     
     */
    public FieldTypesECPERSLANGWRKTypeShape getECPERSLANGWRK() {
        return ecperslangwrk;
    }

    /**
     * Define el valor de la propiedad ecperslangwrk.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesECPERSLANGWRKTypeShape }
     *     
     */
    public void setECPERSLANGWRK(FieldTypesECPERSLANGWRKTypeShape value) {
        this.ecperslangwrk = value;
    }

    /**
     * Obtiene el valor de la propiedad ecpersmemwrk.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesECPERSMEMWRKTypeShape }
     *     
     */
    public FieldTypesECPERSMEMWRKTypeShape getECPERSMEMWRK() {
        return ecpersmemwrk;
    }

    /**
     * Define el valor de la propiedad ecpersmemwrk.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesECPERSMEMWRKTypeShape }
     *     
     */
    public void setECPERSMEMWRK(FieldTypesECPERSMEMWRKTypeShape value) {
        this.ecpersmemwrk = value;
    }

    /**
     * Obtiene el valor de la propiedad pscama.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesPSCAMATypeShape }
     *     
     */
    public FieldTypesPSCAMATypeShape getPSCAMA() {
        return pscama;
    }

    /**
     * Define el valor de la propiedad pscama.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesPSCAMATypeShape }
     *     
     */
    public void setPSCAMA(FieldTypesPSCAMATypeShape value) {
        this.pscama = value;
    }

}
