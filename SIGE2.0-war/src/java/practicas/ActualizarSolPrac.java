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

/**
 *
 * @author Luis Alberto Salas
 */
public class ActualizarSolPrac extends HttpServlet {
   
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
            out.println("<title>Servlet ActualizarSolPrac</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarSolPrac at " + request.getContextPath () + "</h1>");
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

            String ProgramaSolicitado,ExvPrac,ElcvPrac,idest, asigConj;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EstudiantesRemote bd= conEjb.lookupEstudiantesRemote();
            idest=request.getParameter("idest");
            bd.inicializar(idest);
            
            ProgramaSolicitado = request.getParameter("ProgramaSolicitado");
            
            ExvPrac = request.getParameter("exvprac");
            ElcvPrac = request.getParameter("electivasprac");
            asigConj = request.getParameter("asigconj");

            res = "<resultado>";
            ret= bd.ActSolicitudPrac(ProgramaSolicitado,ExvPrac,ElcvPrac,idest, asigConj);
            //Enviar Respuesta
            res = res + "<dato>" + String.valueOf(ret) + "</dato>";
            
            if (ret > 0 ) {
                //Enviar correo informando al Decano respectivo sobre la actualización de la solicitud de Práctica Profesional
                utiles.EnviarEmailRemote em = conEjb.lookupEnviarEmailRemote();
                em.inicializar(idest);
                em.enviarSolDecPrac(idest, true);
                
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
            Logger.getLogger( ActualizarSolPrac.class.getName()).log(Level.SEVERE, null, ex);
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
