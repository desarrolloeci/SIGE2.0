/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inicio;

import BDsige.Empresa;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



/**
 *
 * @author Luis Alberto Salas
 */
public class Verificardatosemp extends HttpServlet {
   
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
            out.println("<title>Servlet Verificardatosemp</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Verificardatosemp at " + request.getContextPath () + "</h1>");
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
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            String nit;
            HttpSession sesion;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EmpresaRemote bd = conEjb.lookupEmpresaRemote();
            bd.inicializar("75107740");
            nit = request.getParameter("nit");
            HashMap item = bd.getRegistroemp(nit);
            
            if(item.get("existe").equals("0")) {
                pw.write("<root>Este ID ya se encuenta registrado en el sistema.</root>");
            } else {
                Empresa usr = new Empresa(nit);
                sesion = request.getSession(true);
                sesion.setAttribute("empreg", usr);
                pw.write("<root>OK</root>");
            }
            
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.flush();
            pw.close();
        }
            catch (Exception ex) {
            Logger.getLogger(Verificardatosemp.class.getName()).log(Level.SEVERE, null, ex);
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
