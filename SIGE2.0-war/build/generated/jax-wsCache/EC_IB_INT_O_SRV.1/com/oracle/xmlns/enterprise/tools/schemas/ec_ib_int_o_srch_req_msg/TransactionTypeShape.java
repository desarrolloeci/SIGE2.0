
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Transaction_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Transaction_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="EC_IB_INTO_SRCH" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}EC_IB_INTO_SRCHMsgDataRecord_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1}PSCAMAMsgDataRecord_TypeShape"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction_TypeShape", propOrder = {

})
public class TransactionTypeShape {

    @XmlElement(name = "EC_IB_INTO_SRCH")
    protected ECIBINTOSRCHMsgDataRecordTypeShape ecibintosrch;
    @XmlElement(name = "PSCAMA", required = true)
    protected PSCAMAMsgDataRecordTypeShape pscama;

    /**
     * Obtiene el valor de la propiedad ecibintosrch.
     * 
     * @return
     *     possible object is
     *     {@link ECIBINTOSRCHMsgDataRecordTypeShape }
     *     
     */
    public ECIBINTOSRCHMsgDataRecordTypeShape getECIBINTOSRCH() {
        return ecibintosrch;
    }

    /**
     * Define el valor de la propiedad ecibintosrch.
     * 
     * @param value
     *     allowed object is
     *     {@link ECIBINTOSRCHMsgDataRecordTypeShape }
     *     
     */
    public void setECIBINTOSRCH(ECIBINTOSRCHMsgDataRecordTypeShape value) {
        this.ecibintosrch = value;
    }

    /**
     * Obtiene el valor de la propiedad pscama.
     * 
     * @return
     *     possible object is
     *     {@link PSCAMAMsgDataRecordTypeShape }
     *     
     */
    public PSCAMAMsgDataRecordTypeShape getPSCAMA() {
        return pscama;
    }

    /**
     * Define el valor de la propiedad pscama.
     * 
     * @param value
     *     allowed object is
     *     {@link PSCAMAMsgDataRecordTypeShape }
     *     
     */
    public void setPSCAMA(PSCAMAMsgDataRecordTypeShape value) {
        this.pscama = value;
    }

}
