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
 * @author Luis Salas
 */
public class lisEliminarOfertaGrad extends HttpServlet {

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
            out.println("<title>Servlet lisEliminarOfertaGrad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisEliminarOfertaGrad at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
         {
//docgrad + getValores(['tipoconsultaofergrad'
           response.setContentType("text/html;charset=UTF-8");
           String res = "";
           String nit_elm;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();
           bd.inicializar("75107740");
           nit_elm= request.getParameter("nit_elm");
           HashMap[] items = bd.getListaoferxnit(nit_elm);
           HashMap item;
//razon_social, nit, cargo, id_oferta, fecha_limite
            int t = items.length;
            int i;
            res = "<listaofertas>";
            for (i = 0; i < t; i++) {
                item = items[i];

                 res += "<oferta>" +
                            "<id_oferta>" + escapeXML((String) item.get("id_oferta")) + "</id_oferta>" +
                            "<cargo>" + escapeXML((String) item.get("cargo")) + "</cargo>"  +
                            "<razon_social>" + escapeXML((String) item.get("razon_social")) + "</razon_social>" +
                            "<nit>" + escapeXML((String) item.get("nit")) + "</nit>" +
                            "<fecha_limite>" + escapeXML((String) item.get("fecha_limite")) + "</fecha_limite>" +
                         "</oferta>";
            }
            res = res + "</listaofertas>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisEliminarOfertaGrad.class.getName()).log(Level.SEVERE, null, ex);
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
            result = result.replaceAll("&", "&amp;");
            result = result.replaceAll("<", "&lt;");
            result = result.replaceAll(">", "&gt;");
            result = result.replaceAll("\"", "&quot;");
            result = result.replaceAll("'", "&apos;");
        return result;
    }
}
