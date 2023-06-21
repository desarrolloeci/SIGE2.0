/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import BDsige.EmpresaRemote;
import clientecampus.CreaOrganizacion;
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
 * @author andres.rojas
 */
public class AprobarEmpresa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AprobarEmpresa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AprobarEmpresa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String nit=request.getParameter("nit");
        inicio.conectaEJB conEjb = new inicio.conectaEJB();
        EmpresaRemote emp = conEjb.lookupEmpresaRemote();     
        try {

            emp.inicializar(nit);
            HashMap empresa=emp.consultaEmp(nit);
            //ESTO DEBE OCURRIR EN EL ESTADO CONTRATADO
            //CreaOrganizacion.enviarOrganizacion(empresa.get("nit").toString(), empresa.get("razon_social").toString(), empresa.get("dir_empresa").toString(), empresa.get("ciudad_empresa").toString(), empresa.get("pais_empresa").toString(), empresa.get("web_empresa").toString(), empresa.get("email_empresa").toString(), empresa.get("tel_empresa").toString(), empresa.get("nom_rrhh").toString(), empresa.get("tel_rrhh").toString(), empresa.get("email_rrhh").toString(), empresa.get("nom_contacto").toString(), empresa.get("profesion_contacto").toString(), empresa.get("cargo_contacto").toString(), empresa.get("area_contacto").toString(), empresa.get("tel_contacto").toString(), empresa.get("fax_contacto").toString(), empresa.get("email_contacto").toString(), empresa.get("cel_contacto").toString());
            emp.aprobarEmpresa(nit);
        } catch (Exception ex) {
            Logger.getLogger(AprobarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("ActualizarInfoEmpAdmin?id_emp="+nit);
        
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
