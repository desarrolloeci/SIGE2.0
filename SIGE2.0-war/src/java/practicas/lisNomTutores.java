/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas;

import BDsige.PersistenciaMIM;
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
public class lisNomTutores extends HttpServlet {
   
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
            out.println("<title>Servlet lisNomTutores</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisNomTutores at " + request.getContextPath () + "</h1>");
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
           String nombretutor, apellidotutor,id_apli;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.DecanoRemote bd= conEjb.lookupDecanoRemote();
           bd.inicializar("75107740");
           id_apli= request.getParameter("id_apli");
           nombretutor = request.getParameter("nombretutor");
           apellidotutor = request.getParameter("apellidotutor");
            
           HashMap[] items = bd.getListaProfesores(nombretutor,apellidotutor);
           //id_req,uge.requerimientos_prac.id_oferta, cargo, fecha_limite, uge.ofertas_prac.id_empresa,nit, razon_social
           HashMap item;
            int t = items.length;
            int i;
            res = "<lisTutores>";
            for (i = 0; i < t; i++) {
                item = items[i];
                res = res + "<tutor>" +"<nom_prof>" + item.get("nom_prof")+ "</nom_prof>" + "<id_prof>" + item.get("id_prof")
                            + "</id_prof>"+"<id_apli>" +id_apli+ "</id_apli>"+"</tutor>";
            }
            res = res + "</lisTutores>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger( lisNomTutores.class.getName()).log(Level.SEVERE, null, ex);
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
