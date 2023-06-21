/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecampus;

//
//import BDatos.BDLogin;
//import BDatos.ConsumoWS;
//import enviacorreo.Correo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import static javafx.scene.input.KeyCode.L;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import clientecampus.ConsultaPersonas;

/**
 *
 * @author andres.rojas
 */
@WebServlet(name = "ActualizarPersona", urlPatterns = {"/Registra"})
public class ActualizarPersona {

    private final String UPLOAD_DIRECTORY = "C:/notificaciones_juridicas_pdf";
    public static String entidad, persona, correo, celular, pdf;
    public static int atdatos;
    private static final long serialVersionUID = 1L;

    public ActualizarPersona() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List< FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                        pdf = name;

                    } else {

                        String fieldName = item.getFieldName();
                        String value = item.getString();
                        if (fieldName.equals("empresa")) {
                            entidad = value;
                        } else if (fieldName.equals("persona")) {
                            persona = value;
                        } else if (fieldName.equals("correo")) {
                            correo = value;
                        } else if (fieldName.equals("celular")) {
                            celular = value;
                        } else if (fieldName.equals("habeas")) {
                            atdatos = 1;
                        }

                    }
                }

                request.setAttribute("message", "Solicitud enviada exitosamente.");
            } catch (Exception ex) {
                request.setAttribute("message", "El archivo no cargó : " + ex);
            }
        } else {

            request.setAttribute("message", "Solo se puede subir un archivo pdf.");
        }

        ConsultaPersonas co = new ConsultaPersonas();
        co.consultaPersonaId("19332067", "3002201978");
//          cliente.consultaPersona();
//        BDLogin cons = new BDLogin();
//        cons.SetNotificacionJuridica(entidad, persona, correo, celular, atdatos, pdf);      
//        
//        
//        String cuerpo= "Usted ha recibido una Notificación Jurídica, a continuación se detalla la información:"  + "<br/><br/>"  + " Entidad: " + entidad + "<br/>" + "  Persona: " + persona + "<br/>" + " Correo: " + correo + "<br/>" + " Celular: " + celular + "<br/><br/>" + "Atentamente," + "<br/><br/>" + persona;
//        Correo email = new Correo("bpms@escuelaing.edu.co", "");
//        try {
//            email.enviar("Notificación Jurídica", cuerpo, pdf);
//        } catch (ConsultaException ex) {
//            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //email. asunto, cuerpo, adjunto
        response.sendRedirect("enviada.jsp");

    }
}
