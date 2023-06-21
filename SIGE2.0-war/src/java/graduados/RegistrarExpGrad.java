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
public class RegistrarExpGrad extends HttpServlet {
   
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
            out.println("<title>Servlet RegistrarExpGrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarExpGrad at " + request.getContextPath () + "</h1>");
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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String res = "";
        
         try
         {
           int ret = 0;
           HashMap item;
           String docgrad,empropia,nom_empresaegre,cargoegre,sector_expgrad,pais_expgrad,ciudad_expgrad,fechain_expgrad,
               fechaout_expgrad,contrato_expgrad,horario_expgrad,fun_expgrad,logros_expgrad,tel_expgrad,dir_expgrad,salario_expgrad,estado_expegre;
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.graduadoRemote bd= conEjb.lookupgraduadoRemote();
           bd.inicializar("75107740");
           //session.setAttribute("emp", bd ) ;
           /*'empropia','nom_empresaegre','cargoegre','sector_expgrad','pais_expgrad','ciudad_expgrad','fechain_expgrad',
            'fechaout_expgrad','contrato_expgrad','horario_expgrad','fun_expgrad','logros_expgrad','tel_expgrad','dir_expgrad',
            'salario_expgrad','estado_expegre'*/


           docgrad=request.getParameter("docgrad");
           empropia=request.getParameter("empropia");
           nom_empresaegre=tildes(request.getParameter("nom_empresaegre"));
           cargoegre=tildes(request.getParameter("cargoegre"));
           sector_expgrad=request.getParameter("sector_expgrad");
           ciudad_expgrad=tildes(request.getParameter("ciudad_expgrad"));
           fechaout_expgrad=request.getParameter("fechaout_expgrad");
           if (fechaout_expgrad==null) fechaout_expgrad="";
           contrato_expgrad=request.getParameter("contrato_expgrad");
           horario_expgrad=request.getParameter("horario_expgrad");
           fun_expgrad=tildes(request.getParameter("fun_expgrad"));
           logros_expgrad=tildes(request.getParameter("logros_expgrad"));
           fechain_expgrad=request.getParameter("fechain_expgrad");
           pais_expgrad=tildes(request.getParameter("pais_expgrad"));
           tel_expgrad=request.getParameter("tel_expgrad");
           dir_expgrad=request.getParameter("dir_expgrad");
           salario_expgrad=request.getParameter("salario_expgrad");
           estado_expegre=request.getParameter("estado_expegre");

            ret = bd.RegistrarExpgrad(docgrad,empropia,nom_empresaegre,cargoegre,sector_expgrad,tel_expgrad,dir_expgrad,
                    pais_expgrad,ciudad_expgrad,salario_expgrad,estado_expegre,fechain_expgrad,fechaout_expgrad,contrato_expgrad,horario_expgrad,
                    fun_expgrad,logros_expgrad);
            item = bd.IdultimaExpgrad(docgrad);

            //Enviar Respuesta

        if (ret > 0 ) {
                //id_estudio, nivel_formacion, nom_estudio,nom_inst
                res =   "<listaexperiencias>" +
                            "<experiencia>" +
                                "<id_exp>" + escapeXML((String) item.get("id")) + "</id_exp>" +
                                "<principal>0</principal>" +
                                "<validate>1</validate>" +
                                "<nom_empresaegre>" + escapeXML((String) nom_empresaegre) + "</nom_empresaegre>" +
                                "<cargoegre>" + escapeXML((String) cargoegre) + "</cargoegre>" +
                                "<estado>" + escapeXML((String) estado_expegre) + "</estado>" +
                                "<docgrad>" + escapeXML((String) docgrad) + "</docgrad>" +
                            "</experiencia>" +
                        "</listaexperiencias>";

        } else {
            res = res + "<valor>Fallo en la Operación</valor>";
        }

        //Enviar Respuesta

            
        }
         catch (Exception ex) {
            Logger.getLogger(RegistrarExpGrad.class.getName()).log(Level.SEVERE, null, ex);
            res = "<valor>Fallo en la Operación</valor>";
        }
         response.setContentType("text/xml");
         pw.write(res);
         pw.flush();
         pw.close();
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
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
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String escapeXML(String escapeText) {
        String result = escapeText;
        if (result.equals("")) result = "_";
        result = result.replaceAll("&", "&amp;");
        result = result.replaceAll("<", "&lt;");
        result = result.replaceAll(">", "&gt;");
        result = result.replaceAll("\"", "&quot;");
        result = result.replaceAll("'", "&apos;");
        return result;
    }

}
