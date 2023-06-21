/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

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
 * @author Luis Salas
 */
public class RechazarOfertaPracUge extends HttpServlet {

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
            out.println("<title>Servlet RechazarOfertaPracUge</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RechazarOfertaPracUge at " + request.getContextPath() + "</h1>");
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
           response.setContentType("text/html;charset=UTF-8");
           String res = "";
           int ret = 0;
           int re = 0;
           int numprog;
           String  ban,num,id_oferta,nomcargonop,descripcionnop,Requisitosnop,paisnop,cont;
           String ciudadnop,areanop,salarionop,fechaoutnop,fechainprac,fechaoutprac,horarionop,contratonop;
           String seguros_arp,nom_jefe,cargo_jefe,tel_jefe,email_jefe;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();           
           bd.inicializar("75107740");
           //'nomcargonop','descripcionnop','Requisitosnop','paisnop',
           //'ciudadnop','areanop','salarionop','fechaoutnop','fechainprac','fechaoutprac','horarionop','contratonop',
           //'seguros_arp','nom_jefe','cargo_jefe','tel_jefe','email_jefe'
           id_oferta = request.getParameter("idofer");      
                   


            res = "<resultado>";
            ret= bd.RechazarOfertaPracUge(id_oferta);
            //Enviar Respuesta
            res = res + "<dato>" + String.valueOf(ret) + "</dato>";
        if (ret > 0) {
            res = res + "<valor>Operación Exitosa</valor>";
        } else
            {
              res = res + "<valor>Fallo en la Operación</valor>";
            }
        res = res + "</resultado>";
        //Enviar Respuesta
           response.sendRedirect("TramitarOfertaAdminPrac?idofer="+id_oferta+"&mensaje=La oferta ha sido rechazada por la UGE");
       
        }
         catch (Exception ex) {
            String res = "";
             PrintWriter pw = response.getWriter();
            Logger.getLogger(RechazarOfertaPracUge.class.getName()).log(Level.SEVERE, null, ex);
             
             res = "<resultado>";
                   res = res + "<dato>" + String.valueOf(ex.getCause()) + "</dato>";
                   res = res + "<valor>Fallo en la Operación"+String.valueOf(ex)+"</valor>";
                   res = res + "</resultado>";
                    response.setContentType("text/xml");
                    pw.write(res);
                    pw.flush();
                    pw.close();
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
