
package com.oracle.xmlns.enterprise.tools.services.ec_ib_int_o_srv;

import javax.jws.HandlerChain;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOREQMSGTypeShape;
import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHREQMSGTypeShape;
import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_resp_msg.ECIBINTOSRCHRESPMSGTypeShape;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.1
 * 
 */
@WebService(name = "EC_IB_INT_O_SRV_PortType", targetNamespace = "http://xmlns.oracle.com/Enterprise/Tools/services/EC_IB_INT_O_SRV.1")
@HandlerChain(file = "ECIBINTOSRVPortType_handler.xml")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ObjectFactory.class,
    com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ObjectFactory.class,
    com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_resp_msg.ObjectFactory.class,
    com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_res_msg.ObjectFactory.class,
    org.xmlsoap.schemas.ws._2003._03.addressing.ObjectFactory.class
})
public interface ECIBINTOSRVPortType {


    /**
     * Operación de Servicio IB. This is the Request Operation in a Asynchronous Request/Response pair. Callback Operation : EC_IB_INT_O_OPR_SRV_CALLBACK
     * 
     * @param parameter
     */
    @WebMethod(operationName = "EC_IB_INT_O_OPR_SRV", action = "EC_IB_INT_O_OPR_SRV.v1")
    @Oneway
    public void ecIBINTOOPRSRV(
        @WebParam(name = "EC_IB_INT_O_REQ_MSG", targetNamespace = "http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_REQ_MSG.V1", partName = "parameter")
        ECIBINTOREQMSGTypeShape parameter);

    /**
     * Busqueda Organizaciones
     * 
     * @param parameter
     * @return
     *     returns com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_resp_msg.ECIBINTOSRCHRESPMSGTypeShape
     */
    @WebMethod(operationName = "EC_IB_INT_O_SRCH_OPR_SRV", action = "EC_IB_INT_O_SRCH_OPR_SRV.v1")
    @WebResult(name = "EC_IB_INT_O_SRCH_RESP_MSG", targetNamespace = "http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_RESP_MSG.V1", partName = "parameter")
    public ECIBINTOSRCHRESPMSGTypeShape ecIBINTOSRCHOPRSRV(
        @WebParam(name = "EC_IB_INT_O_SRCH_REQ_MSG", targetNamespace = "http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_O_SRCH_REQ_MSG.V1", partName = "parameter")
        ECIBINTOSRCHREQMSGTypeShape parameter);

}
