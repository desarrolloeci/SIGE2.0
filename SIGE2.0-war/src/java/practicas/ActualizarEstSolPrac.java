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
import java.util.HashMap;

/**
 *
 * @author Luis Alberto Salas
 */
public class ActualizarEstSolPrac extends HttpServlet {
   
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
            out.println("<title>Servlet ActualizarEstSolPrac</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarEstSolPrac at " + request.getContextPath () + "</h1>");
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
        
        try {
            response.setContentType("text/xml");
            String res = "";
            int ret = 0;
            int re = 0;
            int ban = 0;
            String idsol, idest, clave,est, comentario;
            
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.DecanoRemote bd= conEjb.lookupDecanoRemote();
            bd.inicializar("75107740");
            idsol = request.getParameter("idsol");
            clave = request.getParameter("clave");
            comentario= tildes(request.getParameter("comentarioDecSolPrac"));
            HashMap estado = bd.estadoSolPracDec(idsol);
            est = (String) estado.get("estado");
            
            if(est.equals("b         ")) {
                 ret= bd.ActualizarEstSolPrac(idsol, clave, comentario);
            }
            
            res = "<resultado>";
            
            //Enviar Respuesta
            res = res + "<dato>" + String.valueOf(ret) + "</dato>";
            
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
            
            if (ret > 0 && (clave.equals("r") || clave.equals("d"))) {
                idest = (String) bd.carnetEstPracDec(idsol).get("id_documento");
                utiles.EnviarEmailRemote em=conEjb.lookupEnviarEmailRemote();
                em.inicializar(idsol);
                em.enviarDevolucionSolPrac(idest, idsol, clave.equals("r")?true:false);
            }
        } catch (Exception ex) {
            Logger.getLogger(ActualizarEstSolPrac.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private String tildes(String dato) {
            String result=dato;
           result=result.replace("Ã¡","á");
           result=result.replace("Ã©","é");
           result=result.replace("Ã­","í");
           result=result.replace("Ã³","ó");
           result=result.replace("Ãº","ú");             
           result=result.replace("Ã±","ñ"); 
           return result;
    }

}
