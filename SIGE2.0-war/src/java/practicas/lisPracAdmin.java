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
public class lisPracAdmin extends HttpServlet {
   
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
            out.println("<title>Servlet lisPracAdmin</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisPracAdmin at " + request.getContextPath () + "</h1>");
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
           String iddpto, TipoConsultaPracFor;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();
           bd.inicializar("75107740");
           iddpto = request.getParameter("iddpto");
           TipoConsultaPracFor = request.getParameter("estado");
           HashMap[] items = bd.getListaPracAdmin(iddpto,TipoConsultaPracFor);
           HashMap[] pendientes_envio_campus_matricula=bd.getProyectosPendientesEnvioCampus();
           //id_req,uge.requerimientos_prac.id_oferta, cargo, fecha_limite, uge.ofertas_prac.id_empresa,nit, razon_social
           HashMap item;
            int t = items.length;
            int i;
            res = "<lisRegistros>";
            for (i = 0; i < t; i++) {
                item = items[i];
                String pendiente_envio="No";
                for (HashMap pend : pendientes_envio_campus_matricula) {
                    if(pend.get("id_est").equals(item.get("id_documento"))){
                        pendiente_envio="Si";
                    }
                }
                
                res +=  "<Registro>" +
                            "<id_documento>" + item.get("id_documento") + "</id_documento>" +
                            "<nom_est>" + item.get("nom_est") + "</nom_est>" +
                            "<estado>" + item.get("estado") + "</estado>" +
                            "<pendiente_campus>" + pendiente_envio + "</pendiente_campus>" +
                        "</Registro>";            
            }
            
            res += "</lisRegistros>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger( lisPracAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
