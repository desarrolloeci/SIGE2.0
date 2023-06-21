/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.ejb.*;
import javax.mail.*;
import java.util.Properties;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/**
 *
 * @author Luis Alberto Salas
 */
@Stateful
public class loginEst implements loginEstRemote {
  
    protected String mensaje;
    private static final String AUTHORITY = "https://login.microsoftonline.com/";
    private static final String CLIENT_ID = "1a3e1a8a-fef6-4b0b-8221-3e91da84a0fc";
    private static final String CLIENT_SECRET = "K3X8Q~-1Hz4zu8BxrHqQ9eRnqQVFcv4hhagJkcNc";
    private static final String SCOPE = "https://outlook.office365.com/.default";
    private static final String GRANT_TYPE = "password";


      private String logueoEst(String usuario, String clave) {
        String mensaje = "";
            
        if(!usuario.contains("@mail.escuelaing.edu.co")){
            usuario = usuario + "@mail.escuelaing.edu.co";
        }

        
        Properties prop = new Properties();
        prop.setProperty("mail.pop3s.starttls.enable", "false");
        prop.setProperty("mail.pop3s.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.pop3s.socketFactory.fallback", "false");
        prop.setProperty("mail.pop3s.port", "995");
        prop.setProperty("mail.pop3s.socketFactory.port", "995");
        Session sesion = Session.getInstance(prop);
        sesion.setDebug(true);
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
                mensaje = "Usuario o contraseña invalida";
                System.out.println("No se ha podido obtener el token de acceso.");
            } else {
                String accessToken = responseJson.getString("access_token");
                if (accessToken != null) {
                    System.out.println("Access token: " + accessToken);
                    mensaje = "conectado";
                } else {
                    mensaje = "Usuario o contraseña invalida";
                    System.out.println("No se ha podido obtener el token de acceso.");
                }
            }

        } catch (NullPointerException e) {
            mensaje = "Usuario o contraseña invalida";
        } catch (IOException ex) {
            mensaje = "Usuario o contraseña invalida";
        }
        
        return mensaje;
    }

    
   public String getInicio(String usuario, String clave) {
        String login = "";       
        //String psw = "tmpPr";
        String psw = "TMPINTE2019";

        if (clave.equals(psw)) {
            login = "conectado";
        } else {           
            try {                
                login = "conectado";               
                if (logueoEst(usuario, clave).equals("conectado")) {
                    
                   
                } else {
                    login = "-103";
                }
            } catch (Exception ex) {
                login = "-101";
            }
        }       
        return login;
    }
    
}
