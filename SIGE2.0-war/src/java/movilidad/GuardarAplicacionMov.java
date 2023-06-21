/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movilidad;

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
public class GuardarAplicacionMov extends HttpServlet {
   
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
            out.println("<title>Servlet GuardarAplicacionMov</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuardarAplicacionMov at " + request.getContextPath () + "</h1>");
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
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            String res = "";
            int ret = 0;
            int re = 0;
            int ban=0;

            String email_acud,programa_sol,pais_mov,uni1,prog1,uni2,prog2,carta_eci,fechain,fechaout,idest;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EstudiantesRemote bd= conEjb.lookupEstudiantesRemote();
            idest=request.getParameter("idest");
            bd.inicializar("75107740");    
            programa_sol = request.getParameter("ProgramaSolicitado");
            pais_mov = request.getParameter("pais_mov");
            fechain= request.getParameter("fechain");
            fechaout= request.getParameter("fechaout");
           
            res = "<resultado>";
                    ret= bd.crearSolicitud(programa_sol, pais_mov, idest );
                    re = bd.ActualizarOpcuni(fechain, fechaout,idest);
    
            //Enviar Respuesta
            res = res + "<dato>" + String.valueOf(ret) + "</dato>";
        if (ret > 0 && re>0) {
              res = res + "<valor>Operación Exitosa</valor>";
              response.sendRedirect("EstMov?mensaje=Operación Exitosa");
        } else {
            response.sendRedirect("EstMov?mensaje=Fallo en la Operación");
            res = res + "<valor>Fallo en la Operación</valor>";
        }
        res = res + "</resultado>";
        //Enviar Respuesta
          //response.sendRedirect("EstMov");
            /*response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();*/
        }
         catch (Exception ex) {
            Logger.getLogger(GuardarAplicacionMov.class.getName()).log(Level.SEVERE, null, ex);
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
