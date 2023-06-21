
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MsgData_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MsgData_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Transaction" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_REQ_MSG.V1}Transaction_TypeShape" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsgData_TypeShape", propOrder = {
    "transaction"
})
public class MsgDataTypeShape {

    @XmlElement(name = "Transaction")
    protected TransactionTypeShape transaction;

    /**
     * Obtiene el valor de la propiedad transaction.
     * 
     * @return
     *     possible object is
     *     {@link TransactionTypeShape }
     *     
     */
    public TransactionTypeShape getTransaction() {
        return transaction;
    }

    /**
     * Define el valor de la propiedad transaction.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionTypeShape }
     *     
     */
    public void setTransaction(TransactionTypeShape value) {
        this.transaction = value;
    }

}
