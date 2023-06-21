/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecampus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;



/**
 *
 * @author andres.rojas
 */
public class SecurityHandlerClient implements SOAPHandler<SOAPMessageContext> {
    
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("Client : handleMessage()......");
        SOAPMessage soapMessage = context.getMessage();
        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        System.out.println("isRequest="+isRequest);
        if(isRequest)
        {

                String prefixUri = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-";
                String uri = prefixUri + "wssecurity-secext-1.0.xsd";
                String uta = prefixUri + "wssecurity-utility-1.0.xsd";
                String ta = prefixUri + "username-token-profile-1.0#PasswordText";
                SOAPEnvelope envelope;
                try {
                        envelope = context.getMessage().getSOAPPart().getEnvelope();
                        
                        SOAPHeader header = envelope.getHeader();

                        // Attach a new header if there is none...
                        if (header == null) {
                            header = envelope.addHeader();
                        }
                        
                        SOAPFactory factory = SOAPFactory.newInstance();
                        String prefix = "wsse";
                        SOAPElement securityElem = factory.createElement("Security",prefix,uri);
                        securityElem.addAttribute(QName.valueOf("SOAP-ENV:mustUnderstand"), "1");
                        SOAPElement tokenElem = factory.createElement("UsernameToken",prefix,uri);
                        tokenElem.addAttribute(QName.valueOf("wsu:Id"),"UsernameToken-04F439E73A65D6D78715659681302021");
                        tokenElem.addAttribute(QName.valueOf("xmlns:wsu"), uta);
                        SOAPElement userElem = factory.createElement("Username",prefix,uri);
                        userElem.addTextNode("EC_INTSGEXTWWS");
                        SOAPElement pwdElem = factory.createElement("Password",prefix,uri);
                        pwdElem.addTextNode("3Nxva36WIVxN");
                        pwdElem.addAttribute(QName.valueOf("Type"), ta);
                        tokenElem.addChildElement(userElem);
                        tokenElem.addChildElement(pwdElem);
                        securityElem.addChildElement(tokenElem);
                        //securityElem.addAttribute(securityElem.createQName("soapenv", "mustUnderstand"), "1");
                        
                        
                        header.addChildElement(securityElem);
                        
                    
                        context.getMessage().saveChanges();
                        
                        try {
                            context.getMessage().writeTo(System.out);
                        } catch (IOException ex) {
                            Logger.getLogger(SecurityHandlerClient.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                        //Mostrar y loggear mensajes
                        System.out.println(this.soapMessageToString(context.getMessage()));
                }
        catch (SOAPException e) {
                        e.printStackTrace();
                }
        }
        return true;
    }
    
    public String soapMessageToString(SOAPMessage message) 
    {
        String result = null;

        if (message != null) 
        {
            ByteArrayOutputStream baos = null;
            try 
            {
                baos = new ByteArrayOutputStream();
                message.writeTo(baos); 
                result = baos.toString();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            } 
            finally 
            {
                if (baos != null) 
                {
                    try 
                    {
                        baos.close();
                    } 
                    catch (IOException ioe) 
                    {
                    }
                }
            }
        }
        return result;
    }  
    
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }
    
    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
}
