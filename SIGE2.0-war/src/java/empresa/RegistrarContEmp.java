/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package empresa;

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
public class RegistrarContEmp extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarContEmp</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarContEmp at " + request.getContextPath () + "</h1>");
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
            HashMap item;
            String nit,rasocial,nomconte,cargoconte,areaconte,porfconte,telconte,emailconte,celconte,doc,SistemaSolicitado;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EmpresaRemote bd= conEjb.lookupEmpresaRemote();

            //'nit','rasocial','paisemp','ciudademp','diremp','webemp','emailemp','telemp','nomconte','cargoconte','areaconte','porfconte','telconte','faxconte','emailconte','celconte','passemp','passemp2'
            nit = request.getParameter("nit");
            bd.inicializar(nit);
            rasocial = request.getParameter("rasocial");
            nomconte = request.getParameter("nomconte");
            cargoconte = request.getParameter("cargoconte");
            areaconte = request.getParameter("areaconte");
            porfconte = request.getParameter("porfconte");
            telconte = request.getParameter("telconte");
            emailconte = request.getParameter("emailconte");
            celconte= request.getParameter("celconte");
            doc=request.getParameter("doccont");
            SistemaSolicitado=request.getParameter("SistemaSolicitado");

           //'nomrrhh','telrrhh','emailrrhh'

            ret= bd.RegistrarContEmp(nit,rasocial,nomconte,cargoconte,areaconte,
                    porfconte,telconte,emailconte,celconte,SistemaSolicitado,doc);
            item = bd.IdultimoContEmp(nit);
            //Enviar Respuesta

       if (ret > 0 ) {
                //id_estudio, nivel_formacion, nom_estudio,nom_inst
                res ="<listacontactos><contacto>"
                        +"<id_contacto>" + item.get("id")+ "</id_contacto>" +
                        "<nom_contacto>" + nomconte+  "</nom_contacto>"  +
                        "<cargo_contacto>" + cargoconte +"</cargo_contacto>"+
                        "<nit>" + nit +"</nit>"+
                        "</contacto></listacontactos>";

        } else {
            res = res + "<valor>Fallo en la Operación</valor>";
        }

        //Enviar Respuesta

            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(RegistrarContEmp.class.getName()).log(Level.SEVERE, null, ex);
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
