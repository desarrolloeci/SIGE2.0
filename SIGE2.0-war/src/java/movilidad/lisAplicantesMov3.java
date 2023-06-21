/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movilidad;

import BDsige.EstudiantesRemote;
import clientecampus.ConsultaPersonas;
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
public class lisAplicantesMov3 extends HttpServlet {
   
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
            out.println("<title>Servlet lisAplicantesMov3</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisAplicantesMov3 at " + request.getContextPath () + "</h1>");
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
           String iddpto, progmov;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();
           bd.inicializar("75107740");
           iddpto = request.getParameter("iddpto");
           progmov = request.getParameter("progmov");
           
           //se actualizan datos de las solicitudes de campus
             EstudiantesRemote est = conEjb.lookupEstudiantesRemote();
             est.inicializar("75107740");
            HashMap[] sols= bd.getSolicitudesMov();
            for (HashMap sol : sols) {
                //Solo se consulta a enlace cuando no existe la informacion del estudiante en las tablas de siempreg
                if(!bd.getInfoEstCache(sol.get("id_est").toString())){      
                    est.getPersona(sol.get("id_est").toString(), null, "ESTUDIANTE", ConsultaPersonas.consultaPersona(sol.get("id_est").toString(), "ESTUDIANTE"));
                }
            }
           
           
           HashMap[] items = bd.getListaApliMov3(res,iddpto,progmov);
           HashMap item;

            int t = items.length;
            int i;
            res = "<lisaplicantesmov>";
            for (i = 0; i < t; i++) {
                item = items[i];
                res = res + "<aplicante>"  + "<nombre>" + item.get("nom_est") + "</nombre>" + "<progmov>" + item.get("prog_mov") + "</progmov>" + "<estado>" + item.get("men_admin") + "</estado>" + "<id_solicitud>" + item.get("id_solicitud") + "</id_solicitud>"+ "</aplicante>";
            }
            res = res + "</lisaplicantesmov>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisAplicantesMov3.class.getName()).log(Level.SEVERE, null, ex);
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
