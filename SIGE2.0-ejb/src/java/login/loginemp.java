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
public class loginemp extends Persona implements SessionBean, loginempRemote {

     private SessionContext context;
    public String getInicio(String usuario, String clave) {
        String login = "", consulta, consulta2;
        String ban= "";
        HashMap dato;
        //Vector retorno = new Vector();
        //Vector retorno2 = new Vector();
        //Vector usr = new Vector();

            try {

            login = "-101";
            /*"if  exists(select email_usr from uge.usr_sige where  email_usr ='"+ usuario
                + "')BEGIN select rol_usr from uge.usr_sige where email_usr='"+usuario+"' END ELSE select '0' as rol_usr"*/
               dato = bDatos.getRegistro("if  exists(select id_empresa from uge.empresa_egre where  nit ='"+ usuario
                + "'and pass_empresa='"+clave+"')BEGIN select '1' as id END ELSE select '0' as id");
               ban = (String) dato.get("id");
                /*}else*/
                if (ban.equals("1")) {
                   login = "conectado1";
                } else {
                   dato = bDatos.getRegistro("if  exists(select id_contacto from uge.contactos_emp_sige where  nit ='"+ usuario
                   + "'and doc_contacto='"+clave+"')BEGIN select '1' as id END ELSE select '0' as id");
                     ban = (String) dato.get("id");
                      if (ban.equals("1")) {
                          login = "conectado2";
                    }
                    else{
                            login = "-103";
                      }
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
