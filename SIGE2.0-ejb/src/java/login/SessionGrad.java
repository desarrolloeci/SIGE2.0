/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.rmi.RemoteException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

/**
 *
 * @author Luis Alberto Salas
 */
@Stateful
public class SessionGrad implements SessionGradRemote , SessionBean{
    
  String usuario;
    private SessionContext context;

    public SessionGrad() {
    }
    public SessionGrad(String user) {
        this.usuario=user;
    }

     public String getUser() {
        return usuario;
    }

     public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }

    public void ejbRemove() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ejbActivate() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ejbPassivate() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
