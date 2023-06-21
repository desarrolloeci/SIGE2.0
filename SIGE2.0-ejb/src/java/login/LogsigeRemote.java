/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.util.HashMap;
import javax.ejb.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Luis Alberto Salas
 */
@Remote
public interface LogsigeRemote {
   void inicializar(String idDoc) throws RemoteException;
   public HashMap  getPermiso(String usuario) throws Exception;
   public java.lang.String getInicioSige(java.lang.String usuario, java.lang.String clave);
}
