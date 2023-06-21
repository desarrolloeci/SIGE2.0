/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDsige;

import javax.ejb.CreateException;
import javax.ejb.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;


/**
 *
 * @author Luis Alberto Salas
 */
@Remote
public interface EmpleadoRemote   {

   public HashMap datosGenerales() throws Exception;

    void inicializar(String idDoc) throws RemoteException;

    EmpleadoRemote create() throws CreateException, RemoteException;

    //public void setSessionContext(javax.ejb.SessionContext aContext);
}
