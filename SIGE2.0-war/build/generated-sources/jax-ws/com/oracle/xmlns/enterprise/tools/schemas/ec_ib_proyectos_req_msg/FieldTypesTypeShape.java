
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg;

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
 *         &lt;element name="EC_SSR_RS_THESI" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesEC_SSR_RS_THESI_TypeShape"/&gt;
 *         &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_PROYECTOS_REQ_MSG.V1}FieldTypesPSCAMA_TypeShape"/&gt;
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

    @XmlElement(name = "EC_SSR_RS_THESI", required = true)
    protected FieldTypesECSSRRSTHESITypeShape ecssrrsthesi;
    @XmlElement(name = "PSCAMA", required = true)
    protected FieldTypesPSCAMATypeShape pscama;

    /**
     * Obtiene el valor de la propiedad ecssrrsthesi.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesECSSRRSTHESITypeShape }
     *     
     */
    public FieldTypesECSSRRSTHESITypeShape getECSSRRSTHESI() {
        return ecssrrsthesi;
    }

    /**
     * Define el valor de la propiedad ecssrrsthesi.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesECSSRRSTHESITypeShape }
     *     
     */
    public void setECSSRRSTHESI(FieldTypesECSSRRSTHESITypeShape value) {
        this.ecssrrsthesi = value;
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
