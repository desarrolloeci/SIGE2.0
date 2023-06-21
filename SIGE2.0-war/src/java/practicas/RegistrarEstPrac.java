/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practicas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis Alberto Salas
 */
public class RegistrarEstPrac extends HttpServlet {
   
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
            out.println("<title>Servlet RegistrarEstPrac</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarEstPrac at " + request.getContextPath () + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;");
        String res = "";
        PrintWriter pw = response.getWriter();
        
        try {
            int ret = 0;
            HashMap item;
            String prog_estprac,titulo_prac,sector_estprac,nom_instprac,pais_estprac,ciudad_estprac,fecha_estprac, tipo_estudio, nom_tipo;
            
            HttpSession session = request.getSession(false);
            
            if (session == null) {
                response.sendRedirect("ActualizarHVest?mensaje=0");
            }
            
            login.SessionEstRemote estudiante = (login.SessionEstRemote) session.getAttribute("usuario");
            
            if (estudiante == null) {
                response.sendRedirect("ActualizarHVest?mensaje=0");
            }
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EstudiantesRemote bd = conEjb.lookupEstudiantesRemote();
            bd.inicializar("0");
            
            String id_documento = (String) session.getAttribute("id_est");

            prog_estprac = request.getParameter("prog_estprac");
            titulo_prac = request.getParameter("titulo_prac");
            sector_estprac = request.getParameter("sector_estprac");
            nom_instprac = request.getParameter("nom_instprac");
            pais_estprac = request.getParameter("pais_estprac");
            ciudad_estprac = request.getParameter("ciudad_estprac");
            fecha_estprac = request.getParameter("fecha_estprac");
            tipo_estudio = request.getParameter("tipo_estudio");
            nom_tipo = request.getParameter("nom_tipo");

            ret = bd.RegistrarestPrac(id_documento,prog_estprac,titulo_prac,sector_estprac,nom_instprac,pais_estprac,ciudad_estprac,fecha_estprac, tipo_estudio);
            item = bd.Idultimoestprac(id_documento);

            //Enviar Respuesta
            if (ret > 0 ) {
                    //id_estudio, nivel_formacion, nom_estudio, nom_inst, nom_tipo
                    res =   "<lisaestudios>" +
                                "<estudio>" +
                                    "<id_estudio>" + item.get("id")+ "</id_estudio>" +
                                    "<nom_inst>" + nom_instprac + "</nom_inst>" +
                                    "<nom_estudio>" + prog_estprac + "</nom_estudio>" +
                                    "<tipo_est>" + nom_tipo + "</tipo_est>" +
                                    "<docgrad>" + id_documento + "</docgrad>" +
                                "</estudio>" +
                            "</lisaestudios>";
            } else {
                res = "<valor>Fallo en la Operación</valor>";
            }
        }
         catch (Exception ex) {
            Logger.getLogger(RegistrarEstPrac.class.getName()).log(Level.SEVERE, null, ex);
            res="<valor>Fallo en la Operación</valor>";
        }
               
        //Enviar Respuesta

        response.setContentType("text/xml");
        pw.write(res);
        pw.flush();
        pw.close();
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
