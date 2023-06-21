/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import login.LoginUsrGrad;
import login.SessionEst;

/**
 *
 * @author Luis Alberto Salas
 */
public class LoginEst extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet LoginEst</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginEst at " + request.getContextPath () + "</h1>");
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
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String conectado = new String("");
        String usuario, clave, sistema;
        sistema = request.getParameter("sistemaest");
        usuario = request.getParameter("usuario");
        usuario = usuario.replace("@escuelaing.edu.co", "");
        usuario = usuario.replace("@mail.escuelaing.edu.co", "");
        clave = "NA";
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter pw = response.getWriter();
        inicio.conectaEJB conEjb = new inicio.conectaEJB();
        login.loginEstRemote loginest = null;

        //Valida si existe la sesión, de ser así la borra para reinicializar los datos
        HttpSession sesion;

        if (usuario == null || clave == null || usuario.equals("") || clave.equals("")) {
            pw.write("<root>Debe ingresar su Usuario y su Clave para poder conectarse al sistema.</root>");
        } else {
            loginest = conEjb.lookuploginEstRemote();
            conectado = "conectado";

            if (conectado.equals("conectado")) {
                SessionEst usr = new SessionEst(usuario);
                sesion = request.getSession(true);
                sesion.setAttribute("usuario", usr);
                if (sistema.equals("movilidad")) {
                    response.sendRedirect("EstMov");
                   
                } else {
                    response.sendRedirect("MenuEstPracticas");
                    
                }
               
            } else {
                pw.write("<root>El Usuario no se autentico correctamente</root>");
            }
        }
        pw.flush();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
