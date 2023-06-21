/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movilidad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Alberto Salas
 */
public class lisDocumentosMov extends HttpServlet {
   
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
            out.println("<title>Servlet lisDocumentosMov</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisDocumentosMov at " + request.getContextPath () + "</h1>");
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
           String idsolicitud, progmov;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();
           bd.inicializar("75107740");
           idsolicitud = request.getParameter("id");
           progmov = request.getParameter("progmov");
           HashMap[] items = bd.estadodocumentos(idsolicitud);
           HashMap item;

            int t = items.length;
            int i;
            res = "<lisdocumetosest>";
            for (i = 0; i < t; i++) {
                item = items[i];
                res = res + "<estadosdocu>" +"<idsolicitud>" + idsolicitud + "</idsolicitud>" +"<id_est>" + item.get("id_est")+ "</id_est>"+"<estado>" + item.get("estado")+ "</estado>" + "<estado_HV>" + item.get("estado_HV") + "</estado_HV>" + "<estado_notas>" + item.get("estado_notas") + "</estado_notas>"
                        + "<estado_idiomas>" + item.get("estado_idiomas") + "</estado_idiomas>" + "<estado_cpadres>" + item.get("estado_cpadres") + "</estado_cpadres>" 
                        + "<vobo_foresp>" + item.get("vobo_foresp") + "</vobo_foresp>"+ "<carta_ud>" + item.get("carta_ud") + "</carta_ud>" +  "</estadosdocu>";
            }
            res = res + "</lisdocumetosest>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisDocumentosMov.class.getName()).log(Level.SEVERE, null, ex);
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
