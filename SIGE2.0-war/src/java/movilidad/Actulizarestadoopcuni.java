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
public class Actulizarestadoopcuni extends HttpServlet {
   
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
            out.println("<title>Servlet Actulizarestadoopcuni</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Actulizarestadoopcuni at " + request.getContextPath () + "</h1>");
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
       // url = 'Actualizarestadoopcuni?idsol='+idsol+'&idopc='+idopc+'clave=rechazado_por_est';
         response.setContentType("text/html;charset=UTF-8");
         String res = "";
         int ret = 0;
         int re = 0;
         PrintWriter pw = response.getWriter();
         inicio.conectaEJB conEjb = new inicio.conectaEJB();
         BDsige.EstudiantesRemote bd= conEjb.lookupEstudiantesRemote();
         bd.inicializar("75107740");
         PrintWriter out = response.getWriter();
         String idsol = request.getParameter("idsol");
         String clave=request.getParameter("clave");
         String idopc=request.getParameter("idopc");
         String clave2="f";
        try{


        ret=bd.ActualizarEstOpcUni(idsol, clave, idopc);
        if (ret > 0 && clave.equals("aceptado")) {
           re=bd.ActualizarEstado(idsol, clave2);
        }




        res = "<resultado>";
            //Enviar Respuesta
        res = res + "<dato>" + idsol + "</dato>";
        if (re > 0) {
            res = res + "<valor>Operación Exitosa</valor>";
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

         catch (Exception ex){
             Logger.getLogger(AceptarDocumento.class.getName()).log(Level.SEVERE, null, ex);
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
