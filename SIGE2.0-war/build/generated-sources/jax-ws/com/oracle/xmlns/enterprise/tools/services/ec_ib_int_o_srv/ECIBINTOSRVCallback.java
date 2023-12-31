
package com.oracle.xmlns.enterprise.tools.services.ec_ib_int_o_srv;

import java.net.MalformedURLException;
import java.net.URL;
import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Servicio para Conectarse al IB - Callback
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "EC_IB_INT_O_SRV_Callback", targetNamespace = "http://xmlns.oracle.com/Enterprise/Tools/services/EC_IB_INT_O_SRV.1", wsdlLocation = "https://enlace-broker.escuelaing.edu.co:49343/PSIGW/PeopleSoftServiceListeningConnector/EC_IB_INT_O_SRV.1.wsdl")
@HandlerChain(file = "ECIBINTOSRVCallback_handler.xml")
public class ECIBINTOSRVCallback
    extends Service
{

    private final static URL ECIBINTOSRVCALLBACK_WSDL_LOCATION;
    private final static WebServiceException ECIBINTOSRVCALLBACK_EXCEPTION;
    private final static QName ECIBINTOSRVCALLBACK_QNAME = new QName("http://xmlns.oracle.com/Enterprise/Tools/services/EC_IB_INT_O_SRV.1", "EC_IB_INT_O_SRV_Callback");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://enlace-broker.escuelaing.edu.co:49343/PSIGW/PeopleSoftServiceListeningConnector/EC_IB_INT_O_SRV.1.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ECIBINTOSRVCALLBACK_WSDL_LOCATION = url;
        ECIBINTOSRVCALLBACK_EXCEPTION = e;
    }

    public ECIBINTOSRVCallback() {
        super(__getWsdlLocation(), ECIBINTOSRVCALLBACK_QNAME);
    }

    public ECIBINTOSRVCallback(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns ECIBINTOSRVCallbackPortType
     */
    @WebEndpoint(name = "EC_IB_INT_O_SRV_CallbackPort")
    public ECIBINTOSRVCallbackPortType getECIBINTOSRVCallbackPort() {
        return super.getPort(new QName("http://xmlns.oracle.com/Enterprise/Tools/services/EC_IB_INT_O_SRV.1", "EC_IB_INT_O_SRV_CallbackPort"), ECIBINTOSRVCallbackPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ECIBINTOSRVCallbackPortType
     */
    @WebEndpoint(name = "EC_IB_INT_O_SRV_CallbackPort")
    public ECIBINTOSRVCallbackPortType getECIBINTOSRVCallbackPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://xmlns.oracle.com/Enterprise/Tools/services/EC_IB_INT_O_SRV.1", "EC_IB_INT_O_SRV_CallbackPort"), ECIBINTOSRVCallbackPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ECIBINTOSRVCALLBACK_EXCEPTION!= null) {
            throw ECIBINTOSRVCALLBACK_EXCEPTION;
        }
        return ECIBINTOSRVCALLBACK_WSDL_LOCATION;
    }

}
