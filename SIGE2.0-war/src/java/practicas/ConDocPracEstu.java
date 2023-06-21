/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crystian.ospina
 */
public class ConDocPracEstu extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConDocPracEstu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConDocPracEstu at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try{
           response.setContentType("text/html;charset=UTF-8");
           String res = "";
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();
           bd.inicializar("75107740");
           
           HashMap[] items = bd.getListaEstDocPrac();           
           HashMap item;

            int t = items.length;
            int i;
            res = "<lisaplicantesprac>";
            for (i = 0; i < t; i++) {
                item = items[i];
                res = res + "<aplicante>" +"<idsolicitud>" + item.get("id_sol")+ "</idsolicitud>" + "<nombre>" + item.get("nom_est") + "</nombre>" + "<id_sol>" + item.get("id_sol") + "</id_sol>" +  "</aplicante>";
            }
            res = res + "</lisaplicantesprac>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
        catch (Exception ex) {
            Logger.getLogger(ConDocPracEstu.class.getName()).log(Level.SEVERE, null, ex);
        }
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
