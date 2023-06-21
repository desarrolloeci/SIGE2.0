/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graduados;

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
public class lisEstgrad extends HttpServlet {
   
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
            out.println("<title>Servlet lisEstgrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisEstgrad at " + request.getContextPath () + "</h1>");
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
           String docgrad;
           PrintWriter pw = response.getWriter();
           
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.graduadoRemote bd= conEjb.lookupgraduadoRemote();
           bd.inicializar("75107740");
           
           docgrad = request.getParameter("docgrad");
           
           HashMap[] items = bd.getListaEstgrad(docgrad);
           HashMap item;

            int t = items.length;
            int i;
            res = "<lisaestudios>";
            
            for (i = 0; i < t; i++) {
                item = items[i];
                //id_estudio, nivel_formacion, nom_estudio,nom_inst
                res +=  "<estudio>" +
                            "<id_estudio>" + item.get("id_estudio") + "</id_estudio>" +
                            "<nivel_formacion>" + item.get("nivel_formacion") + "</nivel_formacion>" +
                            "<nom_estudio>" + item.get("nom_estudio") + "</nom_estudio>" +
                            "<nom_inst>" + item.get("nom_inst") + "</nom_inst>" +
                            "<tipo_est>" + item.get("nom_tipo") + "</tipo_est>" +
                            "<docgrad>" + docgrad + "</docgrad>" +
                        "</estudio>";
            }
            res = res + "</lisaestudios>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisEstgrad.class.getName()).log(Level.SEVERE, null, ex);
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
