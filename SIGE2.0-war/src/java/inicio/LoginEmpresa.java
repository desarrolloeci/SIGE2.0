/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inicio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import login.SessionEmp;

/**
 *
 * @author Luis Alberto Salas
 */
public class LoginEmpresa extends HttpServlet {
   
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
            out.println("<title>Servlet LoginEmpresa</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginEmpresa at " + request.getContextPath () + "</h1>");
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

        HttpSession sesion;
        sesion = request.getSession();
        String conectado = new String("");
        String usuario, clave;
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        
        usuario = request.getParameter("usuario");
        clave = request.getParameter("clave");

        PrintWriter pw = response.getWriter();
        inicio.conectaEJB conEjb = new inicio.conectaEJB();
        login.loginempRemote loginemp = null;
        
        if (sesion != null) {
            sesion.invalidate();
        }
        
        if (usuario == null || clave == null || usuario.equals("") || clave.equals("")){
            pw.write("<root>Debe ingresar los campos de usuario y clave.</root>");
        } else {
            try {
                loginemp = conEjb.lookuploginempRemote();
                loginemp.inicializar(usuario);
                conectado = loginemp.getInicio(usuario, clave);

                if (conectado.equals("conectado1")) {
                    SessionEmp usr = new SessionEmp(usuario,clave,"0");
                    sesion = request.getSession(true);
                    sesion.setAttribute("usuario", usr);
                    pw.write("<root>OK1</root>");
                } else if (conectado.equals("conectado2")) {
                    SessionEmp usr = new SessionEmp(usuario,clave,clave);
                    sesion = request.getSession(true);
                    sesion.setAttribute("usuario", usr);
                    pw.write("<root>OK2</root>");
                } else {
                    pw.write("<root>Su usuario o clave son incorrectos</root>");
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                pw.write("<root>Ha ocurrido un error al intentar ingresar al sistema. Por favor intentelo de nuevo.</root>");
            }
        }
        pw.flush();
        pw.close();
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
