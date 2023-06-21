
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Clase Java para SEQ_NBR_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SEQ_NBR_TypeShape"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1&gt;SEQ_NBR_TypeDef"&gt;
 *       &lt;attribute name="IsChanged" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SEQ_NBR_TypeShape", propOrder = {
    "value"
})
public class SEQNBRTypeShape {

    @XmlValue
    protected BigInteger value;
    @XmlAttribute(name = "IsChanged")
    protected String isChanged;

    /**
     * SEQ_NBR is a number of length 15 with a decimal position of 0
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
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
