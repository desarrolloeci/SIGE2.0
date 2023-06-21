/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


/**
 *
 * @author Luis Alberto Salas
 */
public class FormalizarPrac extends HttpServlet {
   
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
            out.println("<title>Servlet FormalizarPrac</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormalizarPrac at " + request.getContextPath () + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
               response.setContentType("text/html;charset=UTF-8");
               String res = "";
               int ret = 0;
               int re = 0;
                int ban = 0;
               String id_apli, clave,est, id_prof;
               PrintWriter pw = response.getWriter();
               inicio.conectaEJB conEjb = new inicio.conectaEJB();
               BDsige.DecanoRemote bd= conEjb.lookupDecanoRemote();
               bd.inicializar("75107740");
               id_apli = request.getParameter("id_apli");
               clave = request.getParameter("clave");
               id_prof = request.getParameter("id_prof");

               HashMap estado = bd. estadoApliPracDec(id_apli);
               est = (String) estado.get("estado_apli");
               if(est.equals("h"))
               {
                   ret= bd.FormalizarApliPrac(id_apli, clave, id_prof);
                   
                   if(ret == 1){
                       
                       utiles.EnviarEmailRemote em = conEjb.lookupEnviarEmailRemote();
                        em.inicializar(id_apli);
                        em.enviarEstFormalizaTutor(id_apli);
                   
                   }
                   
               }
                res = "<resultado>";
            //ret=bd.
            //Enviar Respuesta
                res = res + "<dato>" + String.valueOf(ret) + "</dato>";
                if (ret > 0){
                    res = res + "<valor>Operación Exitosa</valor>";
                } else {
                    res = res + "<valor>Fallo en la Operación</valor>";
                }
                res = res + "</resultado>";
        //Enviar Respuesta

                response.setContentType("text/xml");
                pw.write(res);
                pw.flush();
                pw.close();
          }
          catch (Exception ex) {
            Logger.getLogger(FormalizarPrac.class.getName()).log(Level.SEVERE, null, ex);
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
