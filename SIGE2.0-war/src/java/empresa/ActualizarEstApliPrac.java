/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package empresa;

import BDsige.EstudiantesRemote;
import clientecampus.ConsultaPersonas;
import clientecampus.CreaOrganizacion;
import clientecampus.CrearProyecto;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ActualizarEstApliPrac extends HttpServlet {
   
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
            out.println("<title>Servlet ActualizarEstApliPrac</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarEstApliPrac at " + request.getContextPath () + "</h1>");
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
            int ret = 0;
            int re = 0;
            int numprog;
            String estadoapligrad,id_apli,id_est;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EmpresaRemote bd= conEjb.lookupEmpresaRemote();
            EstudiantesRemote est = conEjb.lookupEstudiantesRemote();
            bd.inicializar("75107740");
            //'nomcargonog','descripcionnog','Requisitosnog','paisnog','ciudadnog','areanog','salarionog','fechaoutnog','horarionog','contratonog','añosexpnog'
            estadoapligrad = request.getParameter("estadoapliprac");
            id_apli = request.getParameter("id_apli");
            id_est = request.getParameter("id_est");
            
            String cedula = (String) est.getUser(id_est).get("CEDULA");
            
            res = "<resultado>";
            res = res + "<dato>" + String.valueOf(ret) + "</dato>";
            
            HashMap nitEmp=bd.getNitOfertaApli(id_apli);
            HashMap oferta=bd.getDatosOferta(id_apli);
            
            String id_ps_solserv="";
            String programa="";
            HashMap sol= bd.getPSIDSolPrac(id_est);
            if(!sol.isEmpty()){
                id_ps_solserv=sol.get("sol_serv_ps").toString();
                programa=sol.get("acad_prog").toString();
            }
            
            
            //Una bandera para reconocer errores en la integracion
            Boolean errorCampus=false;
            //Se verifica si el estudiante ya pago su matricula para el periodo parametrizado por la UGE
            Boolean pagoMatricula = bd.estPagoMatricula(cedula, bd.getPerVerificaPagoMatri());
            
            /**
            //Por pruebas de Diana
            if(!pagoMatricula){
                pagoMatricula=true;
            }
            * */
            String nit=nitEmp.get("nit").toString();
            HashMap empresa=bd.consultaEmp(nit);
            //Enviar Respuesta
            if(pagoMatricula && estadoapligrad.equals("h") && !nitEmp.isEmpty() && nitEmp.get("aprobada_uge").toString().equals("1")){
                try{
                    //Enviar Organizacion y Proyecto a Campus
                    //ESTO DEBE OCURRIR EN EL ESTADO CONTRATADO
                    CreaOrganizacion.enviarOrganizacion(empresa.get("nit").toString(), empresa.get("razon_social").toString(), empresa.get("dir_empresa").toString(), empresa.get("ciudad_empresa").toString(), empresa.get("pais_empresa").toString(), empresa.get("web_empresa").toString(), empresa.get("email_empresa").toString(), empresa.get("tel_empresa").toString(), empresa.get("nom_rrhh").toString(), empresa.get("tel_rrhh").toString(), empresa.get("email_rrhh").toString(), empresa.get("nom_contacto").toString(), empresa.get("profesion_contacto").toString(), empresa.get("cargo_contacto").toString(), empresa.get("area_contacto").toString(), empresa.get("tel_contacto").toString(), empresa.get("fax_contacto").toString(), empresa.get("email_contacto").toString(), empresa.get("cel_contacto").toString());
                    CrearProyecto.EnviaProyecto(id_est, "Practica Empresarial", id_ps_solserv, programa, empresa.get("razon_social").toString(), oferta.get("tiprac").toString());
                    bd.guardaRegistroProyectoCampus(id_est, "Practica Empresarial", id_ps_solserv, programa, empresa.get("razon_social").toString(), oferta.get("tiprac").toString(), "1", "Registro y envío satisfactorio");
                }catch(Exception e){
                    e.printStackTrace();
                    res = res + "<valor>No se puede asignar el estado contratado por problemas técnicos de conexión con Campus</valor>";
                    bd.guardaRegistroProyectoCampus(id_est, "Practica Empresarial", id_ps_solserv, programa, empresa.get("razon_social").toString(), oferta.get("tiprac").toString(), "0", "Hubo un error en el envío del proyecto a Campus");
                    errorCampus=true;
                }
                
            }else if(!nitEmp.get("aprobada_uge").toString().equals("1") && estadoapligrad.equals("h")){
                res = res + "<valor>No se puede asignar el estado contratado cuando la empresa no ha sido aprobada por la UGE</valor>";
            }
            
            if(!errorCampus&&nitEmp.get("aprobada_uge").toString().equals("1")){
                ret= bd.ActEstApliPrac(estadoapligrad,id_apli,id_est);
                if(estadoapligrad.equals("h")){
                    String enviado_a_campus="1";
                    if(!pagoMatricula){
                        enviado_a_campus="0";
                    }
                    ret= bd.guardaCacheEnviosCampus(empresa.get("nit").toString(), empresa.get("razon_social").toString(), empresa.get("dir_empresa").toString(), empresa.get("ciudad_empresa").toString(), empresa.get("pais_empresa").toString(), empresa.get("web_empresa").toString(), empresa.get("email_empresa").toString(), empresa.get("tel_empresa").toString(), empresa.get("nom_rrhh").toString(), empresa.get("tel_rrhh").toString(), empresa.get("email_rrhh").toString(), empresa.get("nom_contacto").toString(), empresa.get("profesion_contacto").toString(), empresa.get("cargo_contacto").toString(), empresa.get("area_contacto").toString(), empresa.get("tel_contacto").toString(), empresa.get("fax_contacto").toString(), empresa.get("email_contacto").toString(), empresa.get("cel_contacto").toString(), id_est, "Practica Empresarial", id_ps_solserv, programa, oferta.get("tiprac").toString(), enviado_a_campus);
                }
            }
            
            

        if (ret > 0) {
            res = res + "<valor>Operación Exitosa</valor>";
        } else {
            res = res + "<valor>Fallo en la Operación</valor>";
        }
        res = res + "</resultado>";
        //Enviar Respuesta

            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();
        }
         catch (Exception ex) {
                if(ex.getMessage().equals("Error no Definido. Cero filas afectadas.")){
                     int ret = 0;
                     String res = "";
                     PrintWriter pw = response.getWriter();
                     res = "<resultado>";
                     res = res + "<dato>" + String.valueOf(ret) + "</dato>";
                     res = res + "<valor> El aplicante o ya no continua en el proceso o fue contratado. Verifique el estado en el sistema – consultar ofertas – ver aplicante </valor>";
                     res = res + "</resultado>";
                     response.setContentType("text/xml");
                    pw.write(res);
                    pw.flush();
                    pw.close();
                 }
                else{
                     int ret = 0;
                     String res = "";
                     PrintWriter pw = response.getWriter();
                     res = "<resultado>";
                     res = res + "<dato>" + String.valueOf(ret) + "</dato>";
                     res = res + "<valor>Fallo en la Operación</valor>";
                     res = res + "</resultado>";
                     response.setContentType("text/xml");
                    pw.write(res);
                    pw.flush();
                    pw.close();
                }

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
