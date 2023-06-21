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
public class SessionUsr implements SessionUsrRemote , SessionBean {
    
    String usuario,rol;
    private SessionContext context;

    public SessionUsr() {
    }
    public SessionUsr(String user, String rol) {
        this.usuario = user;
        this.rol = rol;
    }
     public String getUser() {
        return usuario;
    }
     public String getRol() {
        return rol;
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
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
