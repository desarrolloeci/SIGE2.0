/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BDsige;

import java.rmi.RemoteException;
import java.util.HashMap;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

/**
 *
 * @author Luis Alberto Salas
 */
@Stateful
public class Empleado extends Persona implements EmpleadoRemote, SessionBean {

    private SessionContext context;

    @Override
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }

    @Override
    public void ejbRemove() {
    }

    @Override
    public void ejbActivate() {
    }

    @Override
    public void ejbPassivate() {
    }

    @Override
    public HashMap datosGenerales() throws Exception {
        return bDatos.getRegistro("select id_est,carta_eci, "
                + " prom_ant "
                + " from uge.solicitud_mov"
                + " where  id_est = '2069658'");

    }

    @Override
    public EmpleadoRemote create() throws CreateException, RemoteException {
        return null;
    }

    public void ejbCreate() throws CreateException {
    }
}
