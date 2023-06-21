/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graduados;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Alberto Salas
 */
public class RegistrarDisGrad extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarDisGrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarDisGrad at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String res = "";
        PrintWriter pw = response.getWriter();
        
         try {
           int ret = 0;
           HashMap item;
           String docgrad,nom_disgrad,inst_disgrad,amb_disgrad,Tipo_disgrad,fecha_disgrad;
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.graduadoRemote bd= conEjb.lookupgraduadoRemote();

           bd.inicializar("75107740");
           //session.setAttribute("emp", bd ) ;
           //'nom_disgrad','inst_disgrad','amb_disgrad','Tipo_disgrad','fecha_disgrad'
           docgrad=request.getParameter("docgrad");
           nom_disgrad=tildes(request.getParameter("nom_disgrad"));
           inst_disgrad=tildes(request.getParameter("inst_disgrad"));
           amb_disgrad=tildes(request.getParameter("amb_disgrad"));
           Tipo_disgrad=tildes(request.getParameter("Tipo_disgrad"));
           fecha_disgrad=request.getParameter("fecha_disgrad");
           ret= bd.Registrardisgrad(docgrad,nom_disgrad,inst_disgrad,amb_disgrad,Tipo_disgrad,fecha_disgrad);
           item = bd.Idultimadisgrad(docgrad);
            //Enviar Respuesta

        if (ret > 0 ) {
                //id_estudio, nivel_formacion, nom_estudio,nom_inst
                res ="<listadistinciones><distincion>" +"<id_distincion>" + item.get("id")+ "</id_distincion>" + "<nom_disgrad>" + nom_disgrad+
                        "</nom_disgrad>"  + "<inst_disgrad>" +inst_disgrad +
                        "</inst_disgrad>"+  "<Tipo_disgrad>" + Tipo_disgrad + "</Tipo_disgrad>"+  "<docgrad>" + docgrad + "</docgrad>" +"</distincion></listadistinciones>";

        } else {
            res = res + "<valor>Fallo en la Operación</valor>";
        }

        }
         catch (Exception ex) {
            Logger.getLogger(RegistrarEstGrad.class.getName()).log(Level.SEVERE, null, ex);
            res = "<valor>Fallo en la Operación</valor>";
        }
        //Enviar Respuesta

        response.setContentType("text/xml");
        pw.write(res);
        pw.flush();
        pw.close();
    }
      public String tildes(String dato) {
            String result=dato;
           result=result.replace("Ã¡","á");
           result=result.replace("Ã©","é");
           result=result.replace("Ã­","í");
           result=result.replace("Ã³","ó");
           result=result.replace("Ãº","ú");             
           result=result.replace("Ã±","ñ"); 
           return result;
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
