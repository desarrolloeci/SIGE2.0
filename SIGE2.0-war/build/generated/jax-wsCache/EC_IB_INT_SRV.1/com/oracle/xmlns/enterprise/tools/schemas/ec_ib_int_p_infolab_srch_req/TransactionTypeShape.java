
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_infolab_srch_req;

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
 *         &lt;element name="EC_IB_INTP_SRCH" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFOLAB_SRCH_REQ.V1}EC_IB_INTP_SRCHMsgDataRecord_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFOLAB_SRCH_REQ.V1}PSCAMAMsgDataRecord_TypeShape"/&gt;
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

    @XmlElement(name = "EC_IB_INTP_SRCH")
    protected ECIBINTPSRCHMsgDataRecordTypeShape ecibintpsrch;
    @XmlElement(name = "PSCAMA", required = true)
    protected PSCAMAMsgDataRecordTypeShape pscama;

    /**
     * Obtiene el valor de la propiedad ecibintpsrch.
     * 
     * @return
     *     possible object is
     *     {@link ECIBINTPSRCHMsgDataRecordTypeShape }
     *     
     */
    public ECIBINTPSRCHMsgDataRecordTypeShape getECIBINTPSRCH() {
        return ecibintpsrch;
    }

    /**
     * Define el valor de la propiedad ecibintpsrch.
     * 
     * @param value
     *     allowed object is
     *     {@link ECIBINTPSRCHMsgDataRecordTypeShape }
     *     
     */
    public void setECIBINTPSRCH(ECIBINTPSRCHMsgDataRecordTypeShape value) {
        this.ecibintpsrch = value;
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
