/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

import graduados.ActualizaOferta;
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
public class ActualizaFechasOfPrac extends HttpServlet {

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
            out.println("<title>Servlet ActualizaFechasOfPrac</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizaFechasOfPrac at " + request.getContextPath() + "</h1>");
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
        
        String fecini, fecfin, fecven, idoferta, ofex;
        
        idoferta=request.getParameter("idoferta");
        fecini=request.getParameter("fecini");
        fecfin=request.getParameter("fecfin");
        fecven=request.getParameter("fecven");
        ofex=request.getParameter("ofex");

            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();
            bd.inicializar("75107740");
            
        try {            
              bd.ActualizaFechasOfPrac(idoferta, fecini, fecfin, fecven);
              
              if(!ofex.equals(null)){
                  try {
                      bd.IngresaOfertaExclusiva(idoferta, ofex);
                  } catch (Exception e) {
                      Logger.getLogger(ActualizaOferta.class.getName()).log(Level.SEVERE, null, e);
                      response.sendRedirect("ErrorOfertaEx");
                  }
               }
            //bd.ActualizaOferta("1012972", "cargo", "desc", "requis", "idiomas", "pais", "ciudad", "area");
            response.sendRedirect("VerOfertaEmpAdminP?idofer="+idoferta);
            
       // processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ActualizaOferta.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("ErrorFechas");
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
}
