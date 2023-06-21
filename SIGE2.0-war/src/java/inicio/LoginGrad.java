/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inicio;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import login.LoginUsrGrad;
import login.SessionGrad;

/**
 *
 * @author Luis Alberto Salas
 */
public class LoginGrad extends HttpServlet {
   
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
            out.println("<title>Servlet LoginGrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginGrad at " + request.getContextPath () + "</h1>");
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
        
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        
        String conectado;
        String usuario, clave;
        
        usuario = request.getParameter("usuario");
        clave = request.getParameter("clave");       
        
        PrintWriter pw = response.getWriter();
        inicio.conectaEJB conEjb = new inicio.conectaEJB();
        login.logingradRemote logingrad = null;
        
        HttpSession sesion = request.getSession(false);
        
        if (sesion != null) {
            sesion.invalidate();
        }
        
        if (usuario == null || clave == null || usuario.equals("") || clave.equals("")) {
                pw.write("<root>Debe ingresar los campos de usuario y clave.</root>");
        } else {

            logingrad = conEjb.lookuplogingradRemote();
            logingrad.inicializar(usuario);
            
            conectado = logingrad.getInicio(usuario, clave);
            
            if(conectado.equals("conectado")) {
                SessionGrad usr = new SessionGrad(usuario);
                sesion = request.getSession(true);
                
                sesion.setAttribute("usuario", usr);
                
                pw.write("<root>OK</root>");
            } else if(conectado.equals("faltapolitica")) {
                SessionGrad usr = new SessionGrad(usuario);
                sesion = request.getSession(true);

                sesion.setAttribute("usuario", usr);

                pw.write("<root>OK</root>");
            } else {
                pw.write("<root>Su usuario o clave son incorrectos, o el usuario no se encuentra autorizado para ingresar a éste sistema</root>");
            }
        }
        pw.flush();
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
