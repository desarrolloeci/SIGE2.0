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
import java.util.HashMap;

/**
 *
 * @author Luis Alberto Salas
 */
public class RegistrarMatMov extends HttpServlet {
   
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
            out.println("<title>Servlet RegistrarMatMov</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarMatMov at " + request.getContextPath () + "</h1>");
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
           HashMap item;
           String periodomat,Mateci,Matext,idsol,prog_mov;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.EstudiantesRemote bd= conEjb.lookupEstudiantesRemote();
           bd.inicializar("75107740");
           //session.setAttribute("emp", bd ) ;
           //'periodomat','Mateci','Matext'
           periodomat = request.getParameter("periodomat");
           Mateci = tildes(request.getParameter("Mateci"));
           Matext = tildes(request.getParameter("Matext"));
           idsol = request.getParameter("idsol");
           prog_mov= request.getParameter("prog_mov");
           ret= bd.registrarmat(Matext, Mateci, periodomat, idsol);
           item = bd.Idultimateria(idsol);



           
            
            //response.sendRedirect("PlanestudioMov" );
            //re = bd.ActualizarOpcuni(uni1, prog1, uni2, prog2, fechain, fechaout);
            //Enviar Respuesta
           
       if (ret > 0) {
             res = "<lismaterias>" + "<materia>" +"<est_plan>" + "cargado   "+ "</est_plan>" +
                     "<materia_eci>" + Mateci + "</materia_eci>" + "<semestre>" + periodomat +
                     "</semestre>" +  "<id_plan>" + item.get("id") + "</id_plan>"+ "<materia_ud>" +
                     Matext + "</materia_ud>" +"<idsolicitud>" + idsol + "</idsolicitud>" +"<prog_mov>" +
                     prog_mov + "</prog_mov>" + "</materia>"+"</lismaterias>";
        } else {
            res =  "<valor>Fallo en la Operación</valor>";
        }
       
        //Enviar Respuesta








            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(RegistrarMatMov.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  public String tildes(String dato) {
            String result=dato;
           result=result.replace("Ã¡","á");
           result=result.replace("Ã©","é");
           result=result.replace("Ã­","í");
           result=result.replace("Ã³","ó");
           result=result.replace("Ãº","ú");             
           result=result.replace("Ã±","ñ"); 
           return result;
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
