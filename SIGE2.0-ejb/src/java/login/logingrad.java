/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import BDsige.Persona;
import java.rmi.RemoteException;
import java.util.HashMap;
import javax.ejb.*;
import javax.mail.*;
import java.util.Properties;

/**
 *
 * @author Luis Alberto Salas
 */
@Stateful
public class logingrad extends Persona implements SessionBean, logingradRemote {
    private SessionContext context;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

     public logingrad() {
    }
    public String getInicio(String usuario, String clave) {
        String login = "", consulta, consulta2;
        String ban= "";
        HashMap dato;
        HashMap politica;
        //Vector retorno = new Vector();
        //Vector retorno2 = new Vector();
        //Vector usr = new Vector();
        
            try {

            login = "conectado";
            /*"if  exists(select email_usr from uge.usr_sige where  email_usr ='"+ usuario
                + "')BEGIN select rol_usr from uge.usr_sige where email_usr='"+usuario+"' END ELSE select '0' as rol_usr"*/
               dato = bDatos.getRegistro("if  exists(select id_documento from uge.datos_egre where  documento ='"+ usuario
                + "'and pass='"+clave+"')BEGIN select '1' as id END ELSE select '0' as id");
               ban = (String) dato.get("id");
                /*}else*/
                if (ban.equals("1")) {           
                    
                    politica=bDatos.getRegistro("select vobopoliticadatos from uge.datos_egre where documento='"+usuario+"'");
                    if(politica.get("vobopoliticadatos")== null || politica.get("vobopoliticadatos").equals("False")){
                      login = "faltapolitica";
                    }
                    /* consulta=new String(" update apolo.rechum.empleados " +
                    " set passwd = '" + clave + "' where usrname = '" + usuario + "' or usrexchange = '" + usuario + "' ");
                    if(actualizar(consulta)>0){
                    login = new String("conectado");
                    }else{
                    login = "-102";
                    }*/
                } else {
                    login = "-103";
                }
            } catch (Exception ex) {
                login = "-101";
            }
        
        //desconectarBD();
        return login;
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
