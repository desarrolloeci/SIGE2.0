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
public class lisDisgrad extends HttpServlet {
   
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
            out.println("<title>Servlet lisDisgrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisDisgrad at " + request.getContextPath () + "</h1>");
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
           HashMap[] items = bd.getListaDisgrad(docgrad);
           HashMap item;
           //id_distincion, nom_distincion, lugar_distincion, tipo_distincion

            int t = items.length;
            int i;
            res = "<listadistinciones>";
            for (i = 0; i < t; i++) {
                item = items[i];
                //id_estudio, nivel_formacion, nom_estudio,nom_inst
                res = res +"<distincion>" +"<id_distincion>" + item.get("id_distincion")+ "</id_distincion>" + "<nom_disgrad>" + item.get("nom_distincion")+
                        "</nom_disgrad>"  + "<inst_disgrad>" + item.get("lugar_distincion") +
                        "</inst_disgrad>"+  "<Tipo_disgrad>" + item.get("tipo_distincion")+ "</Tipo_disgrad>"+  "<docgrad>" + docgrad + "</docgrad>" +"</distincion>";            }
            res = res + "</listadistinciones>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisDisgrad .class.getName()).log(Level.SEVERE, null, ex);
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
