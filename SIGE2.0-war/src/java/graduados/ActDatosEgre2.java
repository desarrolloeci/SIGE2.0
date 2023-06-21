/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graduados;

import clientecampus.CrearPersona;
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
public class ActDatosEgre2 extends HttpServlet {
   
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
            out.println("<title>Servlet ActDatosEgre</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActDatosEgre at " + request.getContextPath () + "</h1>");
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
        String res="";
        String docegre="";
        String empl_id="";
        int ret = 0;
        try {
            response.setContentType("text/html;charset=UTF-8");
            res = "";
            
            String num_trj, estcivil, fallecido, dir_res, tel_indicativo, tel_res, cel_indicativo, cel, pais_res, ciudad_res, emails, email2, social_fb, social_tw, social_insta, social_gplus, social_linkedin, perfil,nomcorto;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.graduadoRemote bd= conEjb.lookupgraduadoRemote();

            bd.inicializar("75107740");
            
            docegre = request.getParameter("docegre");
            num_trj = request.getParameter("num_trj");
            estcivil = request.getParameter("estcivil");
            fallecido = request.getParameter("fallecido");
            dir_res = request.getParameter("dir_res");
            tel_indicativo = request.getParameter("tel_indicativo");
            tel_res = request.getParameter("tel_res");
            cel_indicativo = request.getParameter("cel_indicativo");
            cel = request.getParameter("cel");
            pais_res = request.getParameter("pais_res");
            ciudad_res = request.getParameter("ciudad_res");
            emails = request.getParameter("emails");
            email2 = request.getParameter("email2");
            social_fb = request.getParameter("social_fb");
            social_tw = request.getParameter("social_tw");
            social_insta = request.getParameter("social_insta");
            social_gplus = request.getParameter("social_gplus");
            social_linkedin = request.getParameter("social_linkedin");
            perfil = request.getParameter("perfil");
            nomcorto = request.getParameter("nomcortoes");

/*            ciudad_res=ciudad_res.replace("Ã¡","á");
            ciudad_res=ciudad_res.replace("Ã©","é");
            ciudad_res=ciudad_res.replace("Ã­","í");
            ciudad_res=ciudad_res.replace("Ã³","ó");
            ciudad_res=ciudad_res.replace("Ãº","ú");             
            ciudad_res=ciudad_res.replace("Ã±","ñ"); 
            
            perfil=perfil.replace("Ã¡","á");
            perfil=perfil.replace("Ã©","é");
            perfil=perfil.replace("Ã­","í");
            perfil=perfil.replace("Ã³","ó");
            perfil=perfil.replace("Ãº","ú");            
            perfil=perfil.replace("Ã±","ñ");    
 */          
            
            if(request.getParameter("fallecido") == null){
                fallecido = "0";
            }else{
                fallecido = "1";
            }
            
            res = "<resultado>";
            //Se envia a Campus
            
            empl_id=bd.getEmplidCC(docegre);
            try{
                CrearPersona.modificaPersona(empl_id, ciudad_res, pais_res, dir_res, emails, cel_indicativo+cel, docegre);
                ret = bd.ActDatosEgre(docegre, num_trj, estcivil, fallecido, dir_res, tel_indicativo, tel_res, cel_indicativo, cel, pais_res, ciudad_res, emails, email2, social_fb, social_tw, social_insta, social_gplus, social_linkedin, perfil, nomcorto);
            }catch(Exception exc){
                if(exc.getMessage().equals("Error no Definido. Cero filas afectadas.")){
                    System.out.println("No se afectaron filas");
                    ret=1;
                }else{
                    throw exc;
                }
            }
            
            res += "<dato>" + String.valueOf(ret) + "</dato>";
            
           
            response.sendRedirect("ActualizarInfoGradAdmin?id_est="+docegre);
           
           
        }
         catch (Exception ex) {
            Logger.getLogger(ActDatosEgre.class.getName()).log(Level.SEVERE, null, ex);
            res += "<dato>" + "No se pudo completar la acción" + "</dato>";
            
           
            response.sendRedirect("ActualizarInfoGradAdmin?id_est="+docegre);
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
