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

/**
 *
 * @author Luis Salas
 */
public class AprobarOfertaPracUge extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AprobarOfertaPracUge</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AprobarOfertaPracUge at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
           int mail = 0;
           String  ban,num,id_oferta,nomcargonop,descripcionnop,Requisitosnop,paisnop,cont;
           String ciudadnop,areanop,salarionop,fechaoutnop,fechainprac,fechaoutprac,horarionop,contratonop;
           String seguros_arp,nom_jefe,cargo_jefe,tel_jefe,email_jefe;
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.AdministradoresRemote bd= conEjb.lookupAdministradoresRemote();           
           bd.inicializar("75107740");
           //'nomcargonop','descripcionnop','Requisitosnop','paisnop',
           //'ciudadnop','areanop','salarionop','fechaoutnop','fechainprac','fechaoutprac','horarionop','contratonop',
           //'seguros_arp','nom_jefe','cargo_jefe','tel_jefe','email_jefe'
           id_oferta = request.getParameter("idofer");
           nomcargonop = tildes(request.getParameter("nomcargonop"));
           descripcionnop = tildes(request.getParameter("descripcionnop"));
           Requisitosnop = tildes(request.getParameter("Requisitosnop"));
           paisnop = tildes(request.getParameter("paisnop"));
           ciudadnop = tildes(request.getParameter("ciudadnop"));
           areanop = tildes(request.getParameter("areanop"));
           salarionop = tildes(request.getParameter("salarionop"));
           fechaoutnop= tildes(request.getParameter("fechaoutnop"));
           fechainprac= tildes(request.getParameter("fechainprac"));
           fechaoutprac=tildes(request.getParameter("fechaoutprac"));
           horarionop=tildes(request.getParameter("horarionop"));
           contratonop=tildes(request.getParameter("contratonop"));
           seguros_arp=tildes(request.getParameter("seguros_arp"));
           nom_jefe=tildes(request.getParameter("nom_jefe"));
           cargo_jefe=tildes(request.getParameter("cargo_jefe"));
           tel_jefe=tildes(request.getParameter("tel_jefe"));
           email_jefe=tildes(request.getParameter("email_jefe"));
                   


            res = "<resultado>";
            ret= bd.AprobarOfertaPrac(id_oferta,nomcargonop,descripcionnop,Requisitosnop,paisnop,ciudadnop,areanop,salarionop,fechaoutnop,
                    fechainprac,fechaoutprac,horarionop,contratonop,seguros_arp,nom_jefe,cargo_jefe,tel_jefe,email_jefe);
            //Enviar Respuesta
            res = res + "<dato>" + String.valueOf(ret) + "</dato>";
        if (ret > 0) {
            utiles.EnviarEmailRemote em=conEjb.lookupEnviarEmailRemote();
            em.inicializar(id_oferta);
            mail=em.enviarUgeADecPrac(id_oferta);
            res = res + "<valor>Operación Exitosa</valor>";
        } else
            {
              res = res + "<valor>Fallo en la Operación</valor>";
            }
        res = res + "</resultado>";
        //Enviar Respuesta
           response.sendRedirect("TramitarOfertaAdminPrac?idofer="+id_oferta+"&mensaje=La oferta ha sido aprobada satisfactoriamente por la UGE");
       
        }
         catch (Exception ex) {
            String res = "";
             PrintWriter pw = response.getWriter();
            Logger.getLogger(AprobarOfertaPracUge.class.getName()).log(Level.SEVERE, null, ex);
             
             res = "<resultado>";
                   res = res + "<dato>" + String.valueOf(ex.getCause()) + "</dato>";
                   res = res + "<valor>Fallo en la Operación"+String.valueOf(ex)+"</valor>";
                   res = res + "</resultado>";
                    response.setContentType("text/xml");
                    pw.write(res);
                    pw.flush();
                    pw.close();
        }
    }
    public String tildes(String dato) {
          String result = dato;
        result = result.replace("Ã¡", "á");
        //result = result.replace("Ã ", "Á");
        result = result.replace("Ã©", "é");
        result = result.replace("Ã", "É");
        result = result.replace("Ã­", "í");
        //result = result.replace("Ã­", "Í");
        result = result.replace("Ã³", "ó");
        result = result.replace("Ã", "Ó");
        result = result.replace("Ãº", "ú");
        result = result.replace("Ã", "Ú");
        result = result.replace("Ã±", "ñ");
        result = result.replace("Ã", "Ñ");
        result = result.replace("&", "y");
        result = result.replace("&", "y");
        result = result.replace("INGENIERÃA BIOMÉDICA", "INGENIERÍA BIOMÉDICA");
        result = result.replace("INGENIERÃA MECÃNICA", "INGENIERÍA MECÁNICA");
        return result;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
