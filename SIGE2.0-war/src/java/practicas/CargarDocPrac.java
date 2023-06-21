/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

import documentos.RutaDoc;
import graduados.CargarDoc;
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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author crystian.ospina
 */
public class CargarDocPrac extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CargarDocPrac</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CargarDocPrac at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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

        inicio.conectaEJB conEjb = new inicio.conectaEJB();
        BDsige.EstudiantesRemote bd= conEjb.lookupEstudiantesRemote();
        bd.inicializar("75107740");
        
        String ccEstu = "";
        String idSolPract = "";
        String TipoForm = "";
        
        int noDoc = 0;        
        int revisionDocCar = 0;
        int ret = 0;
      
        try {
            RutaDoc docPath = new RutaDoc("doc_practica");
            //Definimos ubicación del archivo en el servidor
            String ubicacionArchivo = docPath.getRuta();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            //Definimos a partir de qué tamaño el sistema empieza a guardar un archivo temporal para la subida
            //En este caso 15 MB.
            factory.setSizeThreshold(15*1024*1024);

            //Definimos el directorio para guardar este archivo temporal
            File repDir = new File(docPath.getRutaTemp());
            factory.setRepository(repDir);

            ServletFileUpload upload = new ServletFileUpload(factory);

            //Obtenemos la lista de campos del formulario
            List<FileItem> items = upload.parseRequest(request);

            //Creamos un ciclo para cada INPUT del formulario
            for (FileItem item: items) {

                //Identificamos si el INPUT es un archivo o un campo de formulario normal
                if(item.isFormField()) {
                    //Si es un campo de formulario lo obtenemos en su respectiva variable
                    if (item.getFieldName().equals("ccEstPra")) ccEstu = item.getString();
                    if (item.getFieldName().equals("idSolPrac")) idSolPract = item.getString();
                    if (item.getFieldName().equals("tipoForm")) TipoForm = item.getString();

                } else {
                    
                    //Si es un archivo nos aseguramos de que el nombre sea el que buscamos
                    if (item.getFieldName().equals("ComPraPro") && TipoForm.equals("formaliza")) {

                        //Obtenemos el nombre del archivo
                        String fName = item.getName();

                        //Revisamos que exista el archivo, que sea tipo PDF, y que no pese más de 15 MB
                        if (fName == null || fName.equals("")) {
                            noDoc++;
                            if (noDoc >= 1) throw new Exception("-3");
                            continue;
                        }
                        if (!fName.substring(fName.lastIndexOf('.'), fName.length()).equals(".pdf")) throw new Exception("-1");
                        if (item.getSize() > (15*1024*1024)) throw new Exception("-2");

                        //Definimos el nombre del archivo
                        String fileName = ccEstu + "-" + item.getFieldName() + "-" + idSolPract + "-CM.pdf";

                        //Guardamos el archivo en el servidor
                        File file = new File(ubicacionArchivo, fileName);
                        item.write(file);
                        
                        //Buscamos los archivos temporales y los borramos
                        for(File fileDel: repDir.listFiles()) fileDel.delete();
                        
                        //Guarnamos en la base de datos que el archivo fue almacenado exitosamente 
                        ret= bd.ActDocPrac(idSolPract,item.getFieldName());
                        
                         response.sendRedirect("solicitarDocPrac?msg=-4");

                    }else if (TipoForm.equals("pracApro") && (item.getFieldName().equals("CarAce") || item.getFieldName().equals("ConPra") || item.getFieldName().equals("AutAsi"))) {

                        //Obtenemos el nombre del archivo
                        String fName = item.getName();

                        //Revisamos que exista el archivo, que sea tipo PDF, y que no pese más de 15 MB
                        if (fName == null || fName.equals("")) {
                            if (noDoc >= 2) throw new Exception("-3");
                            noDoc++;
                            revisionDocCar++;
                            continue;
                        }
                        if (!fName.substring(fName.lastIndexOf('.'), fName.length()).equals(".pdf")) throw new Exception("-1");
                        if (item.getSize() > (15*1024*1024)) throw new Exception("-2");

                        //Definimos el nombre del archivo
                        String fileName = ccEstu + "-" + item.getFieldName() + "-" + idSolPract + "-CM.pdf";

                        //Guardamos el archivo en el servidor
                        File file = new File(ubicacionArchivo, fileName);
                        item.write(file);
                        
                        //Buscamos los archivos temporales y los borramos
                        for(File fileDel: repDir.listFiles()) fileDel.delete();
                        
                        //Guarnamos en la base de datos que el archivo fue almacenado exitosamente 
                        ret= bd.ActDocPrac(idSolPract,item.getFieldName());
                        
                        revisionDocCar++;
                    }
                }
            }
            
            if(revisionDocCar == 3){
                revisionDocCar = 0;
                response.sendRedirect("solicitarDocPrac?msg=-4");
            }
            
        } catch (Exception e){
            if (e.getMessage().length() <= 2) {
                response.sendRedirect("solicitarDocPrac?msg=" + e.getMessage());
            } else {
                response.sendRedirect("solicitarDocPrac?msg=-1");
            }
            Logger.getLogger(CargarDoc.class.getName()).log(Level.INFO, null, e);
        }
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
