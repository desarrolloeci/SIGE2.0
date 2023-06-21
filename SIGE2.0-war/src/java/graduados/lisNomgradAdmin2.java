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
public class lisNomgradAdmin2 extends HttpServlet {
   
    
   
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
            out.println("<title>Servlet lisNomgradAdmin</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisNomgradAdmin at " + request.getContextPath () + "</h1>");
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
//'nombregrad','apellidograd','DocGrad'
           response.setContentType("text/html;charset=UTF-8");
           String res = "";
           String nombre,apellido,doc,usuario;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();
           bd.inicializar("75107740");
          nombre = request.getParameter("nombregrad");
          usuario = request.getParameter("usuario");
           apellido = request.getParameter("apellidograd");
            doc = request.getParameter("DocGrad");
            
            String rol="";
           
           HashMap[] perfs = bd.getLisAccesoConsulGrad(usuario);
           HashMap perf;
           for(int m = 0; m < perfs.length; m++){
               perf = perfs[m];
               rol=perf.get("dpto_ac").toString();
           }
           
           HashMap[] items = bd.getLisNombreGradAdmin2(nombre,apellido,doc,rol);
           HashMap item;


            int t = items.length;
            int i;
            res = "<Nombres>";
            for (i = 0; i < t; i++) {
                item = items[i];
                res = res + "<Nombre>" +"<id_est>" + item.get("id_est")+ "</id_est>" + "<nom_est>" + item.get("nom_est") + "</nom_est>" + "<nom_prog>" + item.get("nom_prog") + "</nom_prog>" +"</Nombre>";
            }
            res = res + "</Nombres>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisNomgradAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
