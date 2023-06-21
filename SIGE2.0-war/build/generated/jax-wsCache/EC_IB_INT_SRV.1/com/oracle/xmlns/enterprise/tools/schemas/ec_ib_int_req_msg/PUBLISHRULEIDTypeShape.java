
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_req_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Clase Java para PUBLISH_RULE_ID_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PUBLISH_RULE_ID_TypeShape"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_REQ_MSG.V1&gt;PUBLISH_RULE_ID_TypeDef"&gt;
 *       &lt;attribute name="IsChanged" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PUBLISH_RULE_ID_TypeShape", propOrder = {
    "value"
})
public class PUBLISHRULEIDTypeShape {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "IsChanged")
    protected String isChanged;

    /**
     * PUBLISH_RULE_ID is a character of length 30. Allows Uppercase characters including numbers
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
