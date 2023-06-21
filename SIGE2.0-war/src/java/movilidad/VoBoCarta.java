/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movilidad;

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
 * @author Luis Alberto Salas
 */
public class VoBoCarta extends HttpServlet {
   
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
            out.println("<title>Servlet VoBoCarta</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VoBoCarta at " + request.getContextPath () + "</h1>");
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
           String nom;
           int ret = 0;
           int re = 0;
           String idsolicitud, clave,usr;
           int ban;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.DecanoRemote bd= conEjb.lookupDecanoRemote();
           usr= request.getParameter("usr");
           bd.inicializar(usr);
           idsolicitud = request.getParameter("idsolicitud");
           
           String id_est=bd.carnetEstPracDec(idsolicitud).get("id_documento").toString();
           clave = request.getParameter("clave");
           nom= request.getParameter("nom");
           //session.setAttribute("emp", bd ) ;
        res = "<resultado>";
        //ret= bd.ActualizarEstado(idsolicitud, clave );
        ret= bd.ActualizarVoBo(idsolicitud, clave, nom);
            //Enviar Respuesta
        res = res + "<dato>" + idsolicitud + "</dato>";
        if (ret > 0) {
            utiles.EnviarEmailRemote em=conEjb.lookupEnviarEmailRemote();
            em.inicializar(id_est);
            
            if(clave.equals("False")){
                ban=em.enviarEst(idsolicitud,"rechazo_carta");
                if(ban==1){
                  res = res + "<valor>La Solicitud ha sido rechazada</valor>";
                }
               else{
                    res = res + "<valor>La Solicitud ha sido rechazada pero no se ha podido enviar el email de notificacion al estudiante</valor>";
               }
            } else {
                if(clave.equals("True"))
                {
                    ban=em.enviarEst(idsolicitud,"VoBo_carta");
                    if(ban==1){
                      res = res + "<valor>La Solicitud ha sido aceptada</valor>";
                    }
                   else{
                        res = res + "<valor>La Solicitud ha sido aceptada pero no se ha podido enviar el email de notificacion al estudiante</valor>";
                   }
                } else {
                   ban=em.enviarEst(idsolicitud, "entrevista");
                   if(ban==1){
                      res = res + "<valor>La fecha se ha registrado con exito</valor>";
                    }
                   else{
                        res = res + "<valor>La fecha se ha registrado pero no se ha podido enviar el email de notificacion al estudiante</valor>";
                   }
                }
            }
        } else {
            res = res + "<valor>Fallo en la Operación</valor>";
        }
        res = res + "</resultado>";
        //Enviar Respuesta

            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(VoBoCarta.class.getName()).log(Level.SEVERE, null, ex);
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
