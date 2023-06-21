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
 * @author Luis Salas
 */
public class EditarExpLab extends HttpServlet {

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
            out.println("<title>Servlet EditarExpLab</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarExpLab at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            String res = "";
            int ret = 0;
            HashMap item;
            String docgrad,empropia,nom_empresaegre,cargoegre,sector_expgrad,pais_expgrad,ciudad_expgrad,fechain_expgrad,
            fechaout_expgrad,contrato_expgrad,horario_expgrad,fun_expgrad,logros_expgrad,tel_expgrad,dir_expgrad,salario_expgrad,estado_expegre,id_exp;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.graduadoRemote bd= conEjb.lookupgraduadoRemote();
            bd.inicializar("75107740");
            //session.setAttribute("emp", bd ) ;
            /*'empropia','nom_empresaegre','cargoegre','sector_expgrad','pais_expgrad','ciudad_expgrad','fechain_expgrad',
            'fechaout_expgrad','contrato_expgrad','horario_expgrad','fun_expgrad','logros_expgrad','tel_expgrad','dir_expgrad',
            'salario_expgrad','estado_expegre'*/

            id_exp=request.getParameter("idExp");
            docgrad=request.getParameter("doc_grad");
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
           
            if (estado_expegre.equals("Finalizado")) bd.resetExpPrincipal(docgrad, id_exp);

            ret=bd.ActualizarExpgrad(docgrad,empropia,nom_empresaegre,cargoegre,sector_expgrad,tel_expgrad,dir_expgrad,
                    pais_expgrad,ciudad_expgrad,salario_expgrad,estado_expegre,fechain_expgrad,fechaout_expgrad,contrato_expgrad,horario_expgrad,
                    fun_expgrad,logros_expgrad,id_exp);
            item = bd.IdultimaExpgrad(docgrad);

            //Enviar Respuesta

            if (ret > 0 ) {
                    //id_estudio, nivel_formacion, nom_estudio,nom_inst
                   /* res ="<listaexperiencias><experiencia>" +"<id_exp>" + item.get("id")+ "</id_exp>" + "<nom_empresaegre>" + nom_empresaegre+
                            "</nom_empresaegre>"  + "<cargoegre>" + cargoegre +
                            "</cargoegre>"+ "<docgrad>" + docgrad + "</docgrad>" +"</experiencia></listaexperiencias>";*/
                res="La experiencia laboral se ha actualizado con exito.";

            } else {
                res ="Fallo en la Operación.";
            }
            response.sendRedirect("EditarExpLabGrad?idexp="+id_exp+"&men="+res);
            //Enviar Respuesta

            /*response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();*/
        }
         catch (Exception ex) {
            Logger.getLogger(EditarExpLab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
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
}
