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
public class RegistrarClasGrad extends HttpServlet {
   
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
            out.println("<title>Servlet RegistrarClasGrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarClasGrad at " + request.getContextPath () + "</h1>");
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
        try
         {
           response.setContentType("text/html;charset=UTF-8");
           String res = "";
           int ret = 0;
           HashMap item;
           String Tituloclas,Teloclas,emailclas,cuerpoclas,docgrad;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.graduadoRemote bd= conEjb.lookupgraduadoRemote();

           bd.inicializar("75107740");
           //session.setAttribute("emp", bd ) ;


           docgrad=request.getParameter("docgrad");
           Tituloclas=request.getParameter("Tituloclas");
           Teloclas=request.getParameter("Teloclas");
           emailclas=request.getParameter("emailclas");
           cuerpoclas=request.getParameter("cuerpoclas");



           ret= bd.RegistrarClasificado(Tituloclas, Teloclas, emailclas, cuerpoclas, docgrad);
           item = bd.IdultimoClasificado(docgrad);
            //Enviar Respuesta
            /*res = res +"<clasificado>"+"<id>" + item.get("id")+ "</id>"+"<titulo>" + item.get("titulo")+ "</titulo>" + "<id_documento>"
                     + item.get("id_documento")+"</id_documento>"  + "<clasificado>" + item.get("clasificado") +
                    "</clasificado>"+ "<estado_clas>" + item.get("estado_clas") + "</estado_clas>"+
                    "<tel_clas>" + item.get("tel_clas") + "</tel_clas>"+"<email_clas>" + item.get("email_clas") + "</email_clas>"
                    +"</clasificado>";*/
        if (ret > 0 ) {
                //id_estudio, nivel_formacion, nom_estudio,nom_inst
                res ="<listaclasificados><clasificado>"+"<id>" + item.get("id")+ "</id>"+"<titulo>" + Tituloclas+ "</titulo>" + "<id_documento>"
                     + docgrad+"</id_documento>"  + "<cuerpoclas>" + cuerpoclas +
                    "</cuerpoclas>"+ "<estado_clas>a</estado_clas>"+
                    "<tel_clas>" + Teloclas + "</tel_clas>"+"<email_clas>" + emailclas + "</email_clas>"
                    + "</clasificado></listaclasificados>";


        } else {
            res = res + "<valor>Fallo en la Operación</valor>";
        }

        //Enviar Respuesta

            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(RegistrarClasGrad.class.getName()).log(Level.SEVERE, null, ex);
        }
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
