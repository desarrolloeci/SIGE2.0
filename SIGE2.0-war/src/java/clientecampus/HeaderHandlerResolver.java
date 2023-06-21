/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecampus;

import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;

/**
 *
 * @author andres.rojas
 */
public class HeaderHandlerResolver implements HandlerResolver {

    @Override
    public List<Handler> getHandlerChain(PortInfo pi) {
        List<Handler> handlerChain = new ArrayList<Handler>();

        SecurityHandlerClient hh = new SecurityHandlerClient();

        handlerChain.add(hh);
        

        return handlerChain;
    }
     

}
