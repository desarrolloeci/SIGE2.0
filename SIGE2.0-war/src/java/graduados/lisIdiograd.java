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
public class lisIdiograd extends HttpServlet {
   
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
            out.println("<title>Servlet lisIdiograd</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisIdiograd at " + request.getContextPath () + "</h1>");
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
           HashMap[] items = bd.getListaidiomasgrad(docgrad);
           HashMap item;
           //id_idioma, nom_idioma, niv_lectura, niv_escritura, niv_habla
/*res ="<><>" +"<id_idioma>" + item.get("id")+ "</id_idioma>" + "<nom_idio>" + nom_idio+
"</nom_idio>"  + "<nivel_lecegre>" + nivel_lecegre +
"</nivel_lecegre>"+  "<nivel_escriegre>" + nivel_escriegre + "</nivel_escriegre>"
+  "<nivel_hablaegre>" + nivel_escriegre + "</nivel_hablaegre>"+  "<docgrad>" + docgrad + "</docgrad>" +"</idioma></listaidiomas>";*/
            int t = items.length;
            int i;
            res = "<listaidiomas>";
            for (i = 0; i < t; i++) {
                item = items[i];
                //id_estudio, nivel_formacion, nom_estudio,nom_inst
                /*</listaAfiliaciones>";*/
                res = res +"<idioma>"+"<id_idioma>" + item.get("id_idioma")+ "</id_idioma>" + "<nom_idio>" + item.get("nom_idioma")+
                    "</nom_idio>"  + "<nivel_lecegre>" + item.get("niv_lectura") +
                    "</nivel_lecegre>"+  "<nivel_escriegre>" + item.get("niv_escritura") + "</nivel_escriegre>"
                    +  "<nivel_hablaegre>" + item.get("niv_habla")+ "</nivel_hablaegre>"+  "<docgrad>" + docgrad + "</docgrad>" +"</idioma>";
            }
            res = res + "</listaidiomas>";
            //Enviar Respuesta
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
            Logger.getLogger(lisIdiograd.class.getName()).log(Level.SEVERE, null, ex);
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
