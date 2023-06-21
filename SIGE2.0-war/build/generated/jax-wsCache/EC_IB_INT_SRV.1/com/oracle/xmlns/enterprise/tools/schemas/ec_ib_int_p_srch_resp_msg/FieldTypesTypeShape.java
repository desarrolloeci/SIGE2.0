
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_resp_msg;

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
 *         &lt;element name="EC_IB_INTP_TBL" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_SRCH_RESP_MSG.V1}FieldTypesEC_IB_INTP_TBL_TypeShape"/&gt;
 *         &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_SRCH_RESP_MSG.V1}FieldTypesPSCAMA_TypeShape"/&gt;
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
