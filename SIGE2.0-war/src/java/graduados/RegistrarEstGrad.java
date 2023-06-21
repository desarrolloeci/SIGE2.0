/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graduados;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Alberto Salas
 */
public class RegistrarEstGrad extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarEstGrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarEstGrad at " + request.getContextPath () + "</h1>");
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
           response.setContentType("text/html;charset=ISO-8859-1");
           String res = "";
           int ret = 0;
           HashMap item;
           String docgrad,NivEst,prog_estgrad,titulo_grad,sector_estgrad,nom_inst,pais_estgrad,ciudad_estgrad,fecha_estgrad;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.graduadoRemote bd= conEjb.lookupgraduadoRemote();

           bd.inicializar("75107740");
           //session.setAttribute("emp", bd ) ;
           


           docgrad=request.getParameter("docgrad");
           NivEst=tildes(request.getParameter("NivEst"));
           titulo_grad=tildes(request.getParameter("titulo_grad"));
           sector_estgrad=tildes(request.getParameter("sector_estgrad"));
           nom_inst=tildes(request.getParameter("nom_inst"));
           pais_estgrad=tildes(request.getParameter("pais_estgrad"));
           ciudad_estgrad=tildes(request.getParameter("ciudad_estgrad"));
           fecha_estgrad=request.getParameter("fecha_estgrad");
           prog_estgrad=tildes(request.getParameter("prog_estgrad"));

            
            ret= bd.Registrarestgrad(docgrad,NivEst,titulo_grad,sector_estgrad,nom_inst,pais_estgrad,ciudad_estgrad,fecha_estgrad,prog_estgrad);
            item = bd.Idultimoestgrad(docgrad);
            //Enviar Respuesta
            
        if (ret > 0 ) {
                //id_estudio, nivel_formacion, nom_estudio,nom_inst
                res ="<lisaestudios><estudio>" +"<id_estudio>" + item.get("id")+ "</id_estudio>" + "<nivel_formacion>" + NivEst+
                        "</nivel_formacion>"  + "<nom_inst>" + nom_inst +
                        "</nom_inst>"+  "<nom_estudio>" + prog_estgrad + "</nom_estudio>"+  "<docgrad>" + docgrad + "</docgrad>" +"</estudio></lisaestudios>";

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
            Logger.getLogger(RegistrarEstGrad.class.getName()).log(Level.SEVERE, null, ex);
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
