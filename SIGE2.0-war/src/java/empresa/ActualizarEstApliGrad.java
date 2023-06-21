/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package empresa;

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
public class ActualizarEstApliGrad extends HttpServlet {
   
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
            out.println("<title>Servlet ActualizarEstApliGrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarEstApliGrad at " + request.getContextPath () + "</h1>");
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
           int numprog;
           String estadoapligrad,id_apli;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.EmpresaRemote bd= conEjb.lookupEmpresaRemote();
           bd.inicializar("75107740");
           //'nomcargonog','descripcionnog','Requisitosnog','paisnog','ciudadnog','areanog','salarionog','fechaoutnog','horarionog','contratonog','añosexpnog'
           estadoapligrad = request.getParameter("estadoapligrad");
           id_apli = request.getParameter("id_apli");
            res = "<resultado>";
            res = res + "<dato>" + String.valueOf(ret) + "</dato>";
            ret= bd.ActEstApliGrad(estadoapligrad,id_apli);
            //Enviar Respuesta
            
        if (ret > 0) {
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
         catch (Exception ex) {
                if(ex.getMessage().equals("Error no Definido. Cero filas afectadas.")){
                     int ret = 0;
                     String res = "";
                     PrintWriter pw = response.getWriter();
                     res = "<resultado>";
                     res = res + "<dato>" + String.valueOf(ret) + "</dato>";
                     res = res + "<valor>Fallo en la Operación</valor>";
                     res = res + "</resultado>";
                     response.setContentType("text/xml");
                    pw.write(res);
                    pw.flush();
                    pw.close();
                 }
                else{
                     int ret = 0;
                     String res = "";
                     PrintWriter pw = response.getWriter();
                     res = "<resultado>";
                     res = res + "<dato>" + String.valueOf(ret) + "</dato>";
                     res = res + "<valor>Fallo en la Operación</valor>";
                     res = res + "</resultado>";
                     response.setContentType("text/xml");
                    pw.write(res);
                    pw.flush();
                    pw.close();
                }

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
