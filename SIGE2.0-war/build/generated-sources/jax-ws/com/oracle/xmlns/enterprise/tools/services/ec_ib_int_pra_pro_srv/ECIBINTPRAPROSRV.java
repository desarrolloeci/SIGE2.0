
package com.oracle.xmlns.enterprise.tools.services.ec_ib_int_pra_pro_srv;

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
 * Servicio Practica Profesional
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "EC_IB_INT_PRA_PRO_SRV", targetNamespace = "http://xmlns.oracle.com/Enterprise/Tools/services/EC_IB_INT_PRA_PRO_SRV.1", wsdlLocation = "https://enlace-broker.escuelaing.edu.co:49343/PSIGW/PeopleSoftServiceListeningConnector/EC_IB_INT_PRA_PRO_SRV.1.wsdl")
@HandlerChain(file = "ECIBINTPRAPROSRV_handler.xml")
public class ECIBINTPRAPROSRV
    extends Service
{

    private final static URL ECIBINTPRAPROSRV_WSDL_LOCATION;
    private final static WebServiceException ECIBINTPRAPROSRV_EXCEPTION;
    private final static QName ECIBINTPRAPROSRV_QNAME = new QName("http://xmlns.oracle.com/Enterprise/Tools/services/EC_IB_INT_PRA_PRO_SRV.1", "EC_IB_INT_PRA_PRO_SRV");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://enlace-broker.escuelaing.edu.co:49343/PSIGW/PeopleSoftServiceListeningConnector/EC_IB_INT_PRA_PRO_SRV.1.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ECIBINTPRAPROSRV_WSDL_LOCATION = url;
        ECIBINTPRAPROSRV_EXCEPTION = e;
    }

    public ECIBINTPRAPROSRV() {
        super(__getWsdlLocation(), ECIBINTPRAPROSRV_QNAME);
    }

    public ECIBINTPRAPROSRV(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns ECIBINTPRAPROSRVPortType
     */
    @WebEndpoint(name = "EC_IB_INT_PRA_PRO_SRV_Port")
    public ECIBINTPRAPROSRVPortType getECIBINTPRAPROSRVPort() {
        return super.getPort(new QName("http://xmlns.oracle.com/Enterprise/Tools/services/EC_IB_INT_PRA_PRO_SRV.1", "EC_IB_INT_PRA_PRO_SRV_Port"), ECIBINTPRAPROSRVPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ECIBINTPRAPROSRVPortType
     */
    @WebEndpoint(name = "EC_IB_INT_PRA_PRO_SRV_Port")
    public ECIBINTPRAPROSRVPortType getECIBINTPRAPROSRVPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://xmlns.oracle.com/Enterprise/Tools/services/EC_IB_INT_PRA_PRO_SRV.1", "EC_IB_INT_PRA_PRO_SRV_Port"), ECIBINTPRAPROSRVPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ECIBINTPRAPROSRV_EXCEPTION!= null) {
            throw ECIBINTPRAPROSRV_EXCEPTION;
        }
        return ECIBINTPRAPROSRV_WSDL_LOCATION;
    }

}
