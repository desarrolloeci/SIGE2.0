/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.rmi.RemoteException;
import javax.ejb.Remote;

/**
 *
 * @author Luis Alberto Salas
 */
@Remote
public interface logingradRemote {
    void inicializar(String idDoc) throws RemoteException;
   java.lang.String getInicio(String usuario, String clave) throws java.rmi.RemoteException;
    
}
