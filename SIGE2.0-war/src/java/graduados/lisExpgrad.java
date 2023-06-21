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
 * @author Luis Alberto Salas
 */
public class lisExpgrad extends HttpServlet {
   
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
            out.println("<title>Servlet lisExpgrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisExpgrad at " + request.getContextPath () + "</h1>");
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
            response.setContentType("text/html;charset=UTF-8");
            String res = "";
            String docgrad;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.graduadoRemote bd= conEjb.lookupgraduadoRemote();
            bd.inicializar("75107740");
            docgrad = request.getParameter("docgrad");
            HashMap[] items = bd.getListaExplaboralgrad(docgrad);
            HashMap item;
            int t = items.length;
            int i;
            res = "<listaexperiencias>";
            for (i = 0; i < t; i++) {
                item = items[i];
                res +=  "<experiencia>" +
                            "<id_exp>" + escapeXML((String) item.get("id_exp")) + "</id_exp>" +
                            "<validate>" + escapeXML((String) item.get("validate")) + "</validate>" +
                            "<principal>" + escapeXML((String) item.get("principal")) + "</principal>" +
                            "<nom_empresaegre>" + escapeXML((String) item.get("nom_empresa")) + "</nom_empresaegre>" +
                            "<cargoegre>" + escapeXML((String) item.get("cargo")) + "</cargoegre>" +
                            "<estado>" + escapeXML((String) item.get("estado_cargo")) + "</estado>" +
                            "<docgrad>" + escapeXML((String) docgrad) + "</docgrad>" +
                        "</experiencia>";
            }
            res += "</listaexperiencias>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisExpgrad.class.getName()).log(Level.SEVERE, null, ex);
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
        if (result.equals("")) result = "_";
        result = result.replaceAll("&", "&amp;");
        result = result.replaceAll("<", "&lt;");
        result = result.replaceAll(">", "&gt;");
        result = result.replaceAll("\"", "&quot;");
        result = result.replaceAll("'", "&apos;");
        return result;
    }
}
