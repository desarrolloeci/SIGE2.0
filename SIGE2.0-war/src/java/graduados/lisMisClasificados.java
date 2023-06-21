/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graduados;

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
public class lisMisClasificados extends HttpServlet {
   
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
            out.println("<title>Servlet lisMisClasificados</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisMisClasificados at " + request.getContextPath () + "</h1>");
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
           String docgrad;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.graduadoRemote bd= conEjb.lookupgraduadoRemote();
           bd.inicializar("75107740");
           docgrad = request.getParameter("docgrad");
           HashMap[] items = bd.getMiscalsificados(docgrad);
           HashMap item;
           //id_exp, nom_empresa, cargo
/*res ="<><>" +"<id_exp>" + item.get("id")+ "</id_exp>" + "<nom_empresaegre>" + nom_empresaegre+
"</nom_empresaegre>"  + "<cargoegre>" + cargoegre +
"</cargoegre>"+ "<docgrad>" + docgrad + "</docgrad>" +"</experiencia></listaexperiencias>";*/
            int t = items.length;
            int i;
            res = "<listaclasificados>";
            for (i = 0; i < t; i++) {
                item = items[i];
                //id_estudio, nivel_formacion, nom_estudio,nom_inst
                /*</listaAfiliaciones>";*/
                res = res +"<clasificado>"+"<id>" + item.get("id")+ "</id>"+"<titulo>" + item.get("titulo")+ "</titulo>" + "<id_documento>"
                     + item.get("id_documento")+"</id_documento>"  + "<cuerpoclas>" + item.get("clasificado") +
                    "</cuerpoclas>"+ "<estado_clas>" + item.get("estado_clas") + "</estado_clas>"+
                    "<tel_clas>" + item.get("tel_clas") + "</tel_clas>"+"<email_clas>" + item.get("email_clas") + "</email_clas>"
                    +"</clasificado>";
            }
            res = res + "</listaclasificados>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisMisClasificados.class.getName()).log(Level.SEVERE, null, ex);
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
