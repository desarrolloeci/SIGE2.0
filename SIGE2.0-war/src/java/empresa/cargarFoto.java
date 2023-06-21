/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import BDsige.Estudiantes;
import BDsige.EstudiantesRemote;
import BDsige.graduadoRemote;
import clientecampus.ConsultaPersonas;
import documentos.RutaDoc;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mario Martínez
 */
public class cargarFoto extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cargarFoto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cargarFoto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String msg = "Su foto no ha podido ser borrada. Por favor inténtelo más tarde.";
        String redir = null;
        
        try {
            
            //Obtenemos la sesión activa
            HttpSession session = request.getSession(false);
        
            if (session == null) throw new Exception("Redir:logingraduado;ErrMsg:El usuario no está autenticado o su sesión ha finalizado;");
            
            login.SessionGradRemote graduado = (login.SessionGradRemote) session.getAttribute("usuario");
            
            if (graduado == null) throw new Exception("Redir:logingraduado;ErrMsg:El usuario no está autenticado o su sesión ha finalizado;");
            
            graduadoRemote emp = (graduadoRemote) session.getAttribute("emp");
            
            if (emp == null) throw new Exception("Redir:logingraduado;ErrMsg:El usuario no está autenticado o su sesión ha finalizado;");
            
            
            
            //Obtenemos el documento del graduado
            String doc_grad = (String) emp.docgrad(graduado.getUser()).get("id_documento");
            
            //Se consulta la persona en campus
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote est = conEjb.lookupEstudiantesRemote();
            est.inicializar("75107740");
            
            est.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "ESTUDIANTE"));
            
            
            
            RutaDoc docPath = new RutaDoc("Doc_Graduado_SIGE");
            
            //Definimos ubicación del archivo en el servidor
            String fileName = "ph-" + doc_grad + ".jpg";
            File file = new File(docPath.getRuta(), fileName);

            if (file.exists()) file.delete();
            
            msg = "Su foto ha sido borrada de nuestro sistema.";
            redir = "ActualizarInfoGrad";
            
        } catch (Exception ex) {
            if (ex.getMessage().contains("ErrMsg")) {
                msg = ex.getMessage().split("ErrMsg:")[1].split(";")[0];
            } else {
                msg = "Su foto no ha podido ser borrada. Por favor inténtelo más tarde.";
            }
            
            if (ex.getMessage().contains("Redir")) {
                redir = ex.getMessage().split("Redir:")[1].split(";")[0];
            }
            
            Logger.getLogger(cargarFoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Enviar Respuesta
        response.setContentType("text/xml");
        out.write(  "<docAnswer>" +
                        "<msg>" + msg + "</msg>" +
                        (redir != null?"<redir>" + redir + "</redir>":"") +
                    "</docAnswer>");
        out.flush();
        out.close();
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String msg = "Su foto no ha sido cargada. Por favor inténtelo nuevamente";
        String redir = null;
        
        try {
            
            //Obtenemos la sesión activa
            HttpSession session = request.getSession(false);
        
            if (session == null) throw new Exception("Redir:logingraduado;ErrMsg:El usuario no está autenticado o su sesión ha finalizado;");
            
            login.SessionGradRemote graduado = (login.SessionGradRemote) session.getAttribute("usuario");
            
            if (graduado == null) throw new Exception("Redir:logingraduado;ErrMsg:El usuario no está autenticado o su sesión ha finalizado;");
            
            graduadoRemote emp = (graduadoRemote) session.getAttribute("emp");
            
            if (emp == null) throw new Exception("Redir:logingraduado;ErrMsg:El usuario no está autenticado o su sesión ha finalizado;");
            
            //Obtenemos el documento del graduado
            String doc_grad = (String) emp.docgrad(graduado.getUser()).get("id_documento");
            
            //Se consulta la persona en campus
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote est = conEjb.lookupEstudiantesRemote();
            est.inicializar("75107740");
            
            est.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "ESTUDIANTE"));
            
            RutaDoc docPath = new RutaDoc("Doc_Graduado_SIGE");
            
            //Definimos ubicación del archivo en el servidor
            String ubicacionArchivo = docPath.getRuta();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            //Definimos a partir de qué tamaño el sistema empieza a guardar un archivo temporal para la subida
            //En este caso 1 MB.
            factory.setSizeThreshold(1*1024*1024);

            //Definimos el directorio para guardar este archivo temporal
            File repDir = new File(docPath.getRutaTemp());
            factory.setRepository(repDir);

            ServletFileUpload upload = new ServletFileUpload(factory);

            //Obtenemos la lista de campos del formulario
            List<FileItem> items = upload.parseRequest(request);

            //Creamos un ciclo para cada INPUT del formulario
            for (FileItem item: items) {

                //Identificamos si el INPUT es un archivo o un campo de formulario normal
                if (!item.isFormField()) {
                    
                    //Si es un archivo nos aseguramos de que el nombre sea el que buscamos
                    if (item.getFieldName().equals("photoFile")) {

                        //Obtenemos el nombre del archivo
                        String fName = item.getName();

                        //Revisamos que exista el archivo, y que no pese más de 2 MB
                        if (fName.equals("") || fName == null) throw new Exception("ErrMsg:No ha seleccionado ningun archivo;");
                        if (item.getSize() > (2*1024*1024)) throw new Exception ("ErrMsg:El peso del archivo debe ser inferior a 2 MB;");

                        //Definimos el nombre del archivo
                        String fileName = "ph-" + doc_grad + ".jpg";

                        //Guardamos el archivo en el servidor
                        File file = new File(ubicacionArchivo, fileName);
                        item.write(file);
                        
                        msg = "Su foto ha sido cargado exitosamente.";
                        redir = "ActualizarInfoGrad";
                        
                        //Buscamos los archivos temporales y los borramos
                        for(File fileDel: repDir.listFiles()) fileDel.delete();
                    }
                }
            }
        } catch (Exception ex) {
            if (ex.getMessage().contains("ErrMsg")) {
                msg = ex.getMessage().split("ErrMsg:")[1].split(";")[0];
            } else {
                msg = "Su foto no ha sido cargada. Por favor inténtelo nuevamente.";
            }
            
            if (ex.getMessage().contains("Redir")) {
                redir = ex.getMessage().split("Redir:")[1].split(";")[0];
            }
            
            Logger.getLogger(cargarFoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Enviar Respuesta
        response.setContentType("text/xml");
        out.write(  "<docAnswer>" +
                        "<msg>" + msg + "</msg>" +
                        (redir != null?"<redir>" + redir + "</redir>":"") +
                    "</docAnswer>");
        out.flush();
        out.close();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
