/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graduados;

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
public class EmailMasivoGrad extends HttpServlet {
   
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
            out.println("<title>Servlet EmailMasivoGrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmailMasivoGrad at " + request.getContextPath () + "</h1>");
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
            //response.setContentType("text/html;charset=ISO-8859-1");
            String res = "";
            int ret = 0;
            int ban = 0;
            String programaEmailAdmin,fechainemailG,fechaoutemailG,asuntoemailmas,mensajeAdminG;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();
            bd.inicializar("75107740");
            programaEmailAdmin = request.getParameter("programaEmailAdmin");
            fechainemailG = request.getParameter("fechainemailG");
            fechaoutemailG = request.getParameter("fechaoutemailG");
            asuntoemailmas = request.getParameter("asuntoemailmas");
            mensajeAdminG = request.getParameter("mensajeAdminG");
            res = "<resultado>";
            //ret= bd.ActualizarEstado(idsolicitud, clave );

             //Enviar Respuesta
            res = res + "<dato>" + String.valueOf(ret) + "</dato>";

            utiles.EnviarEmailRemote em=conEjb.lookupEnviarEmailRemote();
            em.inicializar("1075655849");
            ban=em.enviarmasivoGrad(programaEmailAdmin,fechainemailG,fechaoutemailG,asuntoemailmas,mensajeAdminG);

            if (ban==1) {
                response.sendRedirect("AdminGrad" );
            } else {
                response.sendRedirect("AdminGrad" );
                /*res = res + "<valor>El mesaje NO ha sido enviado</valor>";
                res = res + "</resultado>";
                //Enviar Respuesta
                response.setContentType("text/xml");
                pw.write(res);
                pw.flush();
                pw.close();*/
            }
        }
        catch (Exception ex) {
            String res = "";
            res ="no se ha enviado el mensaje";
            PrintWriter pw = response.getWriter();
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
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
