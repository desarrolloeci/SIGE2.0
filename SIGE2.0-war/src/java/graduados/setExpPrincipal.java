/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graduados;

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
 * @author Mario Martínez
 */
public class setExpPrincipal extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet setExpPrincipal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet setExpPrincipal at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int msg = 1;
        
        try {

            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.graduadoRemote bd = conEjb.lookupgraduadoRemote();
            bd.inicializar("75107740");
            
            String idexp = request.getParameter("id");
            String docgrad = request.getParameter("doc");
            
            if (!bd.checkExpGrad(docgrad, idexp)) throw new Exception("2");
                
            bd.resetExpPrincipal(docgrad);
            int ret = bd.setExpPrincipal(idexp);
            
            if (ret > 0) msg = 3;
        }
         catch (Exception e) {
            Logger.getLogger(setExpPrincipal.class.getName()).log(Level.SEVERE, null, e);
            msg = Integer.parseInt((e.getMessage().length() > 1)?"1":e.getMessage());  
        }
        
        String res = "<docAnswer>";
        
        if (msg == 3) {
            res += "<result>1</result>";
        } else {
            res += "<result>0</result>";
            if (msg == 0) {
                res += "<msg>El usuario no está autenticado o su sesión ha finalizado.</msg>";
            } else if (msg == 1) {
                res += "<msg>Ha ocurrido un error mientras se realizaba la operación. Por favor intente de nuevo más tarde.</msg>";
            } else if (msg == 2) {
                res += "<msg>No se ha encontrado la experiencia laboral registrada para el graduado.</msg>";
            }
        }
        
        res += "</docAnswer>";
        
        PrintWriter pw = response.getWriter();
        
        //Enviar Respuesta
        response.setContentType("text/xml");
        pw.write(res);
        pw.flush();
        pw.close();
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
    
    private String escapeXML(String escapeText) {
        String result = escapeText;
        if (result.equals("")) result = "_";
        result = result.replaceAll("&", "&amp;");
        result = result.replaceAll("<", "&lt;");
        result = result.replaceAll(">", "&gt;");
        result = result.replaceAll("\"", "&quot;");
        result = result.replaceAll("'", "&apos;");
        return result;
    }
}
