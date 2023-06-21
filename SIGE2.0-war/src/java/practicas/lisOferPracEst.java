/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas;

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
 * @author Luis Alberto Salas
 */
public class lisOferPracEst extends HttpServlet {
   
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
            out.println("<title>Servlet lisOferPracEst</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisOferPracEst at " + request.getContextPath () + "</h1>");
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
       try
         {
           response.setContentType("text/html;charset=UTF-8");
           String res = "";
           String iddpto,idest, TipoOferPracEst,TipoOferPracEst2;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.EstudiantesRemote bd= conEjb.lookupEstudiantesRemote();
           bd.inicializar("75107740");

           iddpto = request.getParameter("iddpto");
           idest = request.getParameter("idest");
           TipoOferPracEst = request.getParameter("TipoOferPracEst");
           TipoOferPracEst2 = request.getParameter("TipoOferPracEst2");
           iddpto=bd.getIdDpto(iddpto);
           HashMap[] items = bd.getListaOfertaPracEst(iddpto,idest, TipoOferPracEst, TipoOferPracEst2);
           //id_req,id_oferta, cargo, fecha_limite, horario_oferta,id_empresa, nit, razon_social
           HashMap item;
            int t = items.length;
            int i;
            res = "<lisOfertas>";
            for (i = 0; i < t; i++) {
                item = items[i];
                res = res + "<oferta>" +
                        "<id_req>" + escapeXML((String) item.get("id_req")) + "</id_req>" +
                        "<id_oferta>" + escapeXML((String) item.get("id_oferta")) + "</id_oferta>" +
                        "<cargo>" + escapeXML((String) item.get("cargo")) + "</cargo>" +
                        "<fecha_limite>" + escapeXML((String) item.get("fecha_limite")) + "</fecha_limite>" +
                        "<horario_oferta>" + escapeXML((String) item.get("horario_oferta")) + "</horario_oferta>" +
                        "<id_empresa>" + escapeXML((String) item.get("id_empresa")) + "</id_empresa>" +
                        "<nit>" + escapeXML((String) item.get("nit")) + "</nit>" +
                        "<razon_social>" + escapeXML((String) item.get("razon_social")) + "</razon_social>" +
                        "</oferta>";
            }
            res = res + "</lisOfertas>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisOferPracEst.class.getName()).log(Level.SEVERE, null, ex);
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
