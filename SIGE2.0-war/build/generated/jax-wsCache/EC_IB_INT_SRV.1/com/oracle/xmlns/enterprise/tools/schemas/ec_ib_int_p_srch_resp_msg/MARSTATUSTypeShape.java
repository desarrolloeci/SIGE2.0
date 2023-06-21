
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_resp_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Clase Java para MAR_STATUS_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MAR_STATUS_TypeShape"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_SRCH_RESP_MSG.V1&gt;MAR_STATUS_TypeDef"&gt;
 *       &lt;attribute name="IsChanged" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MAR_STATUS_TypeShape", propOrder = {
    "value"
})
public class MARSTATUSTypeShape {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "IsChanged")
    protected String isChanged;

    /**
     * MAR_STATUS is a character of length 1. Allows Uppercase characters including numbers
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad isChanged.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsChanged() {
        return isChanged;
    }

    /**
     * Define el valor de la propiedad isChanged.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsChanged(String value) {
        this.isChanged = value;
    }

}
