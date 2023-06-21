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
 * @author Mario Martínez
 */
public class newExpPrincipal extends HttpServlet {

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
            out.println("<title>Servlet newExpPrincipal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet newExpPrincipal at " + request.getContextPath() + "</h1>");
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
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        int msg = 1;
        
        try {
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.graduadoRemote bd = conEjb.lookupgraduadoRemote();
            bd.inicializar("75107740");
            
            String docgrad = request.getParameter("doc");
            String nom_emp = request.getParameter("nomemp");
            String emp_propia = request.getParameter("emppropia");
            String cargo = request.getParameter("cargo");
            String tel_emp = request.getParameter("telemp");
            
            int regExp = bd.RegistrarExpgrad(docgrad, emp_propia, nom_emp, cargo, "", tel_emp, "", "COL", "Bogotá", "", "Actual", "01/1900", "", "", "", "", "");
            
            if (regExp == 0) throw new Exception("2");
            
            bd.resetExpPrincipal(docgrad);
            
            String idexp = (String) bd.IdultimaExpgrad(docgrad).get("id");
            int setExp = bd.setExpPrincipal(idexp);
            
            if (setExp > 0) msg = 3;
        }
         catch (Exception e) {
            Logger.getLogger(newExpPrincipal.class.getName()).log(Level.SEVERE, null, e);
            msg = Integer.parseInt((e.getMessage().length() > 1)?"1":e.getMessage());
        }
        
        String res = "<docAnswer>";
        
        if (msg == 0) {
            res += "<msg>El usuario no está autenticado o su sesión ha finalizado.</msg>";
        } else if (msg == 1) {
            res += "<msg>Ha ocurrido un error mientras se realizaba la operación. Por favor intente de nuevo más tarde.</msg>";
        } else if (msg == 2) {
            res += "<msg>No se ha podido registrar la nueva experiencia laboral. Por favor intente de nuevo más tarde.</msg>";
        } else if (msg == 3) {
            res += "<msg>Operación exitosa</msg>";
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
