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
public class lisContEmp extends HttpServlet {
   
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
            out.println("<title>Servlet lisContEmp</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisContEmp at " + request.getContextPath () + "</h1>");
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
           String idemp;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.EmpresaRemote bd= conEjb.lookupEmpresaRemote();
           idemp = request.getParameter("nit");
           bd.inicializar(idemp);
           HashMap[] items = bd.getListaContEmp(idemp);
           HashMap item;


            int t = items.length;
            int i;
            res = "<listacontactos>";
            for (i = 0; i < t; i++) {
                item = items[i];
                //id_contacto,nom_contacto, cargo_contacto
                /*</listaAfiliaciones>";*/
                res = res +"<contacto>" +
                        "<id_contacto>" + item.get("id_contacto")+ "</id_contacto>" +
                        "<nom_contacto>" + item.get("nom_contacto")+"</nom_contacto>"  +
                        "<cargo_contacto>" +item.get("cargo_contacto") +"</cargo_contacto>"+
                        "<nit>" + idemp +"</nit>"+
                        "</contacto>";
            }
            res = res + "</listacontactos>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisContEmp.class.getName()).log(Level.SEVERE, null, ex);
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
