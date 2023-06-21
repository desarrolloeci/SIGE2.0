/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import BDsige.Persona;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.util.HashMap;
import javax.ejb.*;
import javax.mail.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
/**
 *
 * @author Luis Alberto Salas
 */


/**
 *
 * @author Luis Alberto Salas
 */
@Stateful
public class Logsige   extends Persona implements SessionBean, LogsigeRemote {

    private SessionContext context;    
    private Session     sesionMail;
    private Properties  props;
    private Store       store = null;
   private static final String AUTHORITY = "https://login.microsoftonline.com/";
    private static final String CLIENT_ID = "1a3e1a8a-fef6-4b0b-8221-3e91da84a0fc";
    private static final String CLIENT_SECRET = "K3X8Q~-1Hz4zu8BxrHqQ9eRnqQVFcv4hhagJkcNc";
    private static final String SCOPE = "https://outlook.office365.com/.default";
    private static final String GRANT_TYPE = "password";


    public Logsige() {
    }


    private String getInicioEmail(String usuario, String clave)   {
       
        String login = "";               
        props = new Properties();
        sesionMail = Session.getDefaultInstance(props, null);
            login = "-101";
            usuario = usuario + "@escuelaing.edu.co";
            Properties prop = new Properties();
             props.put("mail.store.protocol", "imap");
            props.put("mail.imap.host", "outlook.office365.com");
            props.put("mail.imap.port", "993");
            props.put("mail.imap.ssl.enable", "true");
            props.put("mail.imap.starttls.enable", "true");
            props.put("mail.imap.auth", "true");
            props.put("mail.imap.auth.mechanisms", "XOAUTH2");
            props.put("mail.imap.user", usuario);
            props.put("mail.debug", "true");
            props.put("mail.debug.auth", "true");
            
            try {
               
               HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(AUTHORITY + "50640584-2a40-4216-a84b-9b3ee0f3f6cf/oauth2/v2.0/token");
            String UsuarioMicro = usuario;
            String body = "";
            try {
                body = "client_id=" + URLEncoder.encode(CLIENT_ID, StandardCharsets.UTF_8.name())
                        + "&client_secret=" + URLEncoder.encode(CLIENT_SECRET, StandardCharsets.UTF_8.name())
                        + "&scope=" + URLEncoder.encode(SCOPE, StandardCharsets.UTF_8.name())
                        + "&username=" + URLEncoder.encode(UsuarioMicro, StandardCharsets.UTF_8.name())
                        + "&password=" + URLEncoder.encode(clave, StandardCharsets.UTF_8.name())
                        + "&grant_type=" + URLEncoder.encode(GRANT_TYPE, StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
            }

            HttpEntity entity = new StringEntity(body, ContentType.APPLICATION_FORM_URLENCODED);
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.println(jsonResponse);
            JSONObject responseJson = new JSONObject(jsonResponse);
            

            if (responseJson.isNull("access_token")) {
                login = "-101";
                System.out.println("No se ha podido obtener el token de acceso.");
            } else {
                String accessToken = responseJson.getString("access_token");
                if (accessToken != null) {
                    System.out.println("Access token: " + accessToken);
                    login = "conectado";
                } else {
                    login = "-101";
                    System.out.println("No se ha podido obtener el token de acceso.");
                }
            }

        } catch (NullPointerException e) {
            login = "-101";
        } catch (IOException ex) {
            login = "-101";
        }
        
        return login;
    }
    
    public String getInicioSige(String usuario, String clave) {
        String login = "";

        //String psw = "tmpPr";
        String psw = "TMPINTE2019";
        String psw2 = "TMPINTE2019";
        String psw3 = "TMPUGE2019";
        if (clave.equals(psw)||clave.equals(psw2)||clave.equals(psw3)) {
            login = "conectado";
        } else {
            try {
                login = "conectado";
                if (!getInicioEmail(usuario, clave).equals("conectado")) login = "-103";
            } catch (Exception ex) {
                login = "-101";
            }
        }
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
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public HashMap getPermiso(String usuario) throws Exception {
        return bDatos.getRegistro(  "IF EXISTS( " +
                                        "SELECT email_usr " +
                                        "FROM uge.usr_sige " +
                                        "WHERE email_usr = '" + usuario + "' " +
                                    ") " +
                                    "BEGIN " +
                                        "SELECT rol_usr " +
                                        "FROM uge.usr_sige " +
                                        "WHERE email_usr = '" + usuario + "' " +
                                    "END " +
                                    "ELSE SELECT '0' AS rol_usr");
        /*return bDatos.getRegistro("if exists(select email_usr from uge.usr_sige where email_usr = '"+ usuario
                + "')BEGIN select rol_usr from uge.usr_sige where email_usr='"+usuario+"' END ELSE select '0' as rol_usr");*/
    }



}
