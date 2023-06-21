
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_res_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_IB_INTR_TBLMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_IB_INTR_TBLMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RESPONSE_VALUE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_RES_MSG.V1}RESPONSE_VALUE_TypeShape" minOccurs="0"/&gt;
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
@XmlType(name = "EC_IB_INTR_TBLMsgDataRecord_TypeShape", propOrder = {
    "responsevalue"
})
public class ECIBINTRTBLMsgDataRecordTypeShape {

    @XmlElement(name = "RESPONSE_VALUE")
    protected RESPONSEVALUETypeShape responsevalue;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad responsevalue.
     * 
     * @return
     *     possible object is
     *     {@link RESPONSEVALUETypeShape }
     *     
     */
    public RESPONSEVALUETypeShape getRESPONSEVALUE() {
        return responsevalue;
    }

    /**
     * Define el valor de la propiedad responsevalue.
     * 
     * @param value
     *     allowed object is
     *     {@link RESPONSEVALUETypeShape }
     *     
     */
    public void setRESPONSEVALUE(RESPONSEVALUETypeShape value) {
        this.responsevalue = value;
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
