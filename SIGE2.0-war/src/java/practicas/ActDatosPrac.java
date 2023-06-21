/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas;

import clientecampus.CrearPersona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import login.SessionEstRemote;

/**
 *
 * @author Luis Alberto Salas
 */
public class ActDatosPrac extends HttpServlet {
   
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
            out.println("<title>Servlet ActDatosPrac</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActDatosPrac at " + request.getContextPath () + "</h1>");
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
            
            HttpSession session = request.getSession(false);
            
            if (session == null) {
                response.sendRedirect("ActualizarHVest?mensaje=0");
            }
            
            login.SessionEstRemote estudiante = (login.SessionEstRemote) session.getAttribute("usuario");
            
            if (estudiante == null) {
                response.sendRedirect("ActualizarHVest?mensaje=0");
            }
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EstudiantesRemote bd = conEjb.lookupEstudiantesRemote();
            bd.inicializar("0");
            
            String idest = (String) session.getAttribute("id_est");
            
            String tel2prac, celprac, email2prac, perfilprac, refprac, exvprac, electivasprac;
            tel2prac = request.getParameter("tel2prac");
            celprac = request.getParameter("celprac");
            email2prac = request.getParameter("email2prac");
            perfilprac = request.getParameter("perfilprac");
            refprac = request.getParameter("refprac");
            exvprac = request.getParameter("exvprac");
            electivasprac = request.getParameter("electivasprac");
            String tel_campus=request.getParameter("tel_campus");

            res = "<resultado>";
            HashMap datosAdicionales = bd.getDatosPracticante(idest);
            CrearPersona.modificaPersona(idest, (String) datosAdicionales.get("ciudad"), (String) datosAdicionales.get("pais"), (String) datosAdicionales.get("direccion"), email2prac, tel_campus, (String) datosAdicionales.get("cedula"));
            ret = bd.ActDatosPrac(tel2prac, celprac, email2prac, perfilprac, refprac, exvprac, idest, electivasprac);
            
            if (ret <= 0) {
                response.sendRedirect("ActualizarHVest?mensaje=0");
            }

            response.sendRedirect("ActualizarHVest?mensaje=1");
        } catch (Exception ex) {
            Logger.getLogger(ActDatosPrac.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("ActualizarHVest?mensaje=0");
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
