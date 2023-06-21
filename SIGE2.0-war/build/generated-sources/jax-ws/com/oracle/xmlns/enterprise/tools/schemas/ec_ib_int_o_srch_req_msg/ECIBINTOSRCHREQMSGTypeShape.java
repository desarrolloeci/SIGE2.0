
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_IB_INT_O_SRCH_REQ_MSG_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_IB_INT_O_SRCH_REQ_MSG_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FieldTypes" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}FieldTypes_TypeShape"/&gt;
 *         &lt;element name="MsgData" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}MsgData_TypeShape"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EC_IB_INT_O_SRCH_REQ_MSG_TypeShape", propOrder = {
    "fieldTypes",
    "msgData"
})
public class ECIBINTOSRCHREQMSGTypeShape {

    @XmlElement(name = "FieldTypes", required = true)
    protected FieldTypesTypeShape fieldTypes;
    @XmlElement(name = "MsgData", required = true)
    protected MsgDataTypeShape msgData;

    /**
     * Obtiene el valor de la propiedad fieldTypes.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesTypeShape }
     *     
     */
    public FieldTypesTypeShape getFieldTypes() {
        return fieldTypes;
    }

    /**
     * Define el valor de la propiedad fieldTypes.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesTypeShape }
     *     
     */
    public void setFieldTypes(FieldTypesTypeShape value) {
        this.fieldTypes = value;
    }

    /**
     * Obtiene el valor de la propiedad msgData.
     * 
     * @return
     *     possible object is
     *     {@link MsgDataTypeShape }
     *     
     */
    public MsgDataTypeShape getMsgData() {
        return msgData;
    }

    /**
     * Define el valor de la propiedad msgData.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgDataTypeShape }
     *     
     */
    public void setMsgData(MsgDataTypeShape value) {
        this.msgData = value;
    }

}
