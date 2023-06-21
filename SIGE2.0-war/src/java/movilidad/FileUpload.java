/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movilidad;

import documentos.RutaDoc;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


        

/**
 *
 * @author Luis Alberto Salas
 */
public class FileUpload extends HttpServlet {
  String val;

   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected boolean create() throws java.lang.Exception
    {

        return true;
    }

    public FileUpload()
    {   // Constructor.
    }
    private void unhandledEvent( String listenerName, String methodName, java.lang.Object event )
    {

    }
    /**
     * destroy Method
     */

    public void destroy()
    {
        super.destroy();
        // TODO: implement
    }
    /**
     * doGet Method
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //doPost(request,response);
    }
    /**
     * doPost Method
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int ret = 0;
        
        //Definimos las variables
        String idest = "";
        String tipo = "";
        String idsol = "";
        String clave = "";
        String nom = "";
        
        String msg = "Error al subir el archivo.";
        String fName = "";

        inicio.conectaEJB conEjb = new inicio.conectaEJB();
        BDsige.EstudiantesRemote bd = conEjb.lookupEstudiantesRemote();
        
        try {
            
            RutaDoc docPath = new RutaDoc("doc_movilidad");
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
            for(FileItem item: items) {
                
                //Identificamos si el INPUT es un archivo o un campo de formulario normal
                if(item.isFormField()) {
                    //Si es un campo de formulario lo obtenemos en su respectiva variable
                    if (item.getFieldName().equals("clave")) clave = item.getString();
                    if (item.getFieldName().equals("tipo")) tipo = item.getString();
                    if (item.getFieldName().equals("nom")) nom = item.getString();
                    if (item.getFieldName().equals("idsol")) idsol = item.getString();
                    if (item.getFieldName().equals("idest")) {
                        idest = item.getString();
                        bd.inicializar(idest);
                    }
                } else {
                    
                    //Si es un archivo nos aseguramos de que el nombre sea el que buscamos
                    if (item.getFieldName().equals(tipo+"upload")) {
                        
                        //Obtenemos el nombre del archivo
                        fName = item.getName();
                        
                        //Revisamos que exista el archivo, que sea tipo PDF, y que no pese más de 10 MB
                        if (fName.equals("") || fName == null) throw new Exception("No ha seleccionado ningun archivo.");
                        if (!fName.substring(fName.lastIndexOf('.'), fName.length()).equals(".pdf")) throw new Exception("El tipo de archivo seleccionado debe ser PDF.");
                        //if (item.getSize()>(10*1024*1024)) throw new Exception ("El peso del archivo debe ser inferior a 10 MB.");
                        
                        //Definimos el nombre del archivo
                        String fileName = idest + "-" + tipo + "-" + idsol + ".pdf";
                        
                        //Guardamos el archivo en el servidor
                        File file = new File(ubicacionArchivo, fileName);
                        item.write(file);

                        //Buscamos los archivos temporales y los borramos
                        for(File fileDel: repDir.listFiles()) fileDel.delete();
                        
                        if (tipo.equals("FormatoU1") || tipo.equals("FormatoU2") ||  tipo.equals("CartaU1") || tipo.equals("CartaU2")) {
                            ret=bd.ActualizarVobosOpcUni(idsol, clave, nom, tipo);
                        } else {
                            ret=bd.ActualizarVobosSolicitud(idsol, clave, nom,tipo);
                        }
                    }
                }
            }
            
            msg = "Su archivo ha sido cargado exitosamente.";

        } catch (Exception err) {
            //Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
            msg=err.getMessage();
        }
            
        response.sendRedirect("EstMov?uploadStatus=" + msg);
    }

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    
}
