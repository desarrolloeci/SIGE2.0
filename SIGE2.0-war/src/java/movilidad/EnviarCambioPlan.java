/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movilidad;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Luis Alberto Salas
 */
public class EnviarCambioPlan extends HttpServlet {
   
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
            out.println("<title>Servlet EnviarCambioPlan</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EnviarCambioPlan at " + request.getContextPath () + "</h1>");
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
           int ret = 0;
           int re = 0;
           int ban = 0;
           String periodomat,clave,idsol,usr;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           PrintWriter out = response.getWriter();
           BDsige.EstudiantesRemote bd= conEjb.lookupEstudiantesRemote();
           bd.inicializar("75107740");
           //session.setAttribute("emp", bd ) ;
           //'periodomat','Mateci','Matext'
           idsol = request.getParameter("idsol");
           usr = request.getParameter("usr");
           clave = "enviado";
            res = "<resultado>";
            ret= bd.Actualizarestadocambioplan(idsol, clave,usr);
            //response.sendRedirect("PlanestudioMov" );
            //re = bd.ActualizarOpcuni(uni1, prog1, uni2, prog2, fechain, fechaout);
            //Enviar Respuesta
            res = res + "<dato>" + String.valueOf(ret) + "</dato>";
       if (ret > 0) {
            utiles.EnviarEmailRemote em=conEjb.lookupEnviarEmailRemote();
            em.inicializar(idsol);
            ban=em.enviar(idsol,"cambioplan_dec");
            if(ban==1){
              res = res + "<valor>Operación Exitosa</valor>";
            }
           else{
                res = res + "<valor>El cambio en el plan de estudio ha sido registrado pero no se ha podido enviar el email de notificacion al decano</valor>";
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
        //response.sendRedirect("EstMov" );
        }
         catch (Exception ex) {
            Logger.getLogger(EnviarCambioPlan.class.getName()).log(Level.SEVERE, null, ex);
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
