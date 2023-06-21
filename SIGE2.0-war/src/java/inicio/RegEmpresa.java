/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inicio;

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
public class RegEmpresa extends HttpServlet {
   
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
            out.println("<title>Servlet RegEmpresa</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegEmpresa at " + request.getContextPath () + "</h1>");
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
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            
            response.setContentType("text/html");
            String res = "";
            int ret = 0;
            int re = 0;
            String nit,rasocial,paisemp,ciudademp,diremp,webemp,emailemp,telemp,nomconte,cargoconte,areaconte,porfconte,telconte,faxconte,emailconte,celconte,passemp,passemp2,nomrrhh,telrrhh,emailrrhh,tipoid;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EmpresaRemote bd= conEjb.lookupEmpresaRemote();
            bd.inicializar("75107740");
            //'nit','rasocial','paisemp','ciudademp','diremp','webemp','emailemp','telemp','nomconte','cargoconte','areaconte','porfconte','telconte','faxconte','emailconte','celconte','passemp','passemp2'
            nit = request.getParameter("nit");
            rasocial = request.getParameter("rasocial");
            paisemp = request.getParameter("paisemp");
            ciudademp = request.getParameter("ciudademp");
            diremp = request.getParameter("diremp");
            webemp = request.getParameter("webemp");
            emailemp = request.getParameter("emailemp");
            telemp = request.getParameter("telemp");
            nomconte= request.getParameter("nomconte");
            cargoconte= request.getParameter("cargoconte");
            areaconte=request.getParameter("areaconte");
            porfconte=request.getParameter("porfconte");
            telconte=request.getParameter("telconte");
            faxconte=request.getParameter("faxconte");
            emailconte=request.getParameter("emailconte");
            celconte=request.getParameter("celconte");
            passemp=request.getParameter("passemp"); 
            nomrrhh=request.getParameter("nomrrhh");
            telrrhh=request.getParameter("telrrhh");
            emailrrhh=request.getParameter("emailrrhh");
            tipoid=request.getParameter("tipoid");
            //'nomrrhh','telrrhh','emailrrhh'
            res = "<resultado>";
            ret= bd.Registrarempresa(nit,rasocial,paisemp,ciudademp,diremp,webemp,emailemp,telemp,nomconte,cargoconte,areaconte,
                    porfconte,telconte,faxconte,emailconte,celconte,passemp,nomrrhh,telrrhh,emailrrhh,tipoid);
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
        }
         catch (Exception ex) {
            Logger.getLogger(RegEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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
