/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movilidad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 *
 * @author Luis Alberto Salas
 */
public class ActualizarEstMov extends HttpServlet {
   
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
            out.println("<title>Servlet ActualizarEstMov</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarEstMov at " + request.getContextPath () + "</h1>");
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
            int ban = 0;
           String idsolicitud, clave,est, comment="";
           PrintWriter pw = response.getWriter();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           BDsige.EstudiantesRemote bd= conEjb.lookupEstudiantesRemote();
           bd.inicializar("75107740");
           idsolicitud = request.getParameter("idsolicitud");
           clave = request.getParameter("clave");
           if (clave == null) clave = "";
           HashMap estado = bd.estadoAplicacion(idsolicitud);
           est = (String) estado.get("estado");
           
           //Verifica que se esté rechazando el proceso en cualquier estado
           if (clave.equals("k") && !(est.equals("i         ") || est.equals("j         "))) {
               est = "finalizarProceso";
               comment = request.getParameter("comentario");
           }
           
            utiles.EnviarEmailRemote em=conEjb.lookupEnviarEmailRemote();
            em.inicializar(idsolicitud);
           //session.setAttribute("emp", bd ) ;
           if(est.equals("a         "))
           {
               ret= bd.ActualizarEstado(idsolicitud, clave );
           }
           if(est.equals("b         "))
           {
               ret= bd.ActualizarEstado(idsolicitud, clave );
               if(ret>0){
                    ban=em.enviarAdmin(idsolicitud,"doc_load");
               }
           }
           if(est.equals("c         "))
           {
                HashMap [] estadodocu;
                estadodocu= bd.estadodocu(idsolicitud);
                int ban9=estadodocu.length;
                HashMap estadodocu1 = estadodocu[0];
                HashMap estadodocu2 ;
                if(ban9>1){
                 estadodocu2 = estadodocu[1];
                }else{
                estadodocu2 = estadodocu[0];
                }
                if(estadodocu1.get("estado_HV").equals("aceptado  ") && estadodocu1.get("estado_notas").equals("aceptado  ") && estadodocu1.get("estado_idiomas").equals("aceptado  ")
                    && estadodocu1.get("estado_cpadres").equals("aceptado  ") && estadodocu1.get("vobo_foresp").equals("aceptado") && estadodocu2.get("vobo_foresp").equals("aceptado")
                    && estadodocu1.get("carta_ud").equals("aceptado") && estadodocu2.get("carta_ud").equals("aceptado"))
                    {
                        clave="d";
                        ret= bd.ActualizarEstado(idsolicitud, clave );

                    }
                else{
                    if(estadodocu1.get("estado_HV").equals("rechazado ") || estadodocu1.get("estado_notas").equals("rechazado ") || estadodocu1.get("estado_idiomas").equals("rechazado ")
                    || estadodocu1.get("estado_cpadres").equals("rechazado ") || estadodocu1.get("vobo_foresp").equals("rechazado") || estadodocu2.get("vobo_foresp").equals("rechazado")
                    || estadodocu1.get("carta_ud").equals("rechazado") || estadodocu2.get("carta_ud").equals("rechazado"))
                    {
                        clave="e";
                        ret= bd.ActualizarEstado(idsolicitud, clave );

                    }
                    else{
                        clave="c";
                        ret= bd.ActualizarEstado(idsolicitud, clave );
                    }

                }
           }
           if(est.equals("e         "))
           {
                HashMap [] estadodocu;
                estadodocu= bd.estadodocu(idsolicitud);
                HashMap estadodocu1 = estadodocu[0];
                if(estadodocu.length > 1){
                HashMap estadodocu2 = estadodocu[1];
                if(estadodocu1.get("estado_HV").equals("aceptado  ") && estadodocu1.get("estado_notas").equals("aceptado  ") && estadodocu1.get("estado_idiomas").equals("aceptado  ")
                    && estadodocu1.get("estado_cpadres").equals("aceptado  ") && estadodocu1.get("vobo_foresp").equals("aceptado") && estadodocu2.get("vobo_foresp").equals("aceptado")
                    && estadodocu1.get("carta_ud").equals("aceptado") && estadodocu2.get("carta_ud").equals("aceptado"))
                    {
                        clave="d";
                        ret= bd.ActualizarEstado(idsolicitud, clave );
                        //clave="en espera";
                    }
                }else{
                
                if(estadodocu1.get("estado_HV").equals("aceptado  ") && estadodocu1.get("estado_notas").equals("aceptado  ") && estadodocu1.get("estado_idiomas").equals("aceptado  ")
                    && estadodocu1.get("estado_cpadres").equals("aceptado  ") && estadodocu1.get("vobo_foresp").equals("aceptado") 
                    && estadodocu1.get("carta_ud").equals("aceptado"))
                    {
                        clave="d";
                        ret= bd.ActualizarEstado(idsolicitud, clave );
                        //clave="en espera";
                    }
                }
             }
           if(est.equals("d         "))
           {
                HashMap [] estadoopc;
                estadoopc= bd.estadoopc(idsolicitud);
                HashMap estadoopc1 = estadoopc[0];
                HashMap estadoopc2 = estadoopc[1];
                if(estadoopc1.get("estado_opcud").equals("aceptado")|| estadoopc2.get("estado_opcud").equals("aceptado"))
                    {
                        clave="f";
                        ret= bd.ActualizarEstado(idsolicitud, clave );
                    }
                else
                {
                   if(estadoopc1.get("estado_opcud").equals("rechazado_por_uni"))
                   {
                        if(estadoopc2.get("estado_opcud").equals("rechazado_por_uni"))
                        {
                            clave="r";
                            ret= bd.ActualizarEstado(idsolicitud, clave );
                        }
                        else
                        {
                                if(estadoopc2.get("estado_opcud").equals("rechazado_por_est"))
                                {
                                    clave="r";
                                    ret= bd.ActualizarEstado(idsolicitud, clave );
                                }
                                else
                                {
                                    clave="d";
                                    ret= bd.ActualizarEstado(idsolicitud, clave );
                                }
                        }
                   }
                   else
                   {
                       if(estadoopc1.get("estado_opcud").equals("rechazado_por_est"))
                       {
                            if(estadoopc2.get("estado_opcud").equals("rechazado_por_uni"))
                            {
                                clave="r";
                                ret= bd.ActualizarEstado(idsolicitud, clave );

                            }
                            else
                            {
                                    if(estadoopc2.get("estado_opcud").equals("rechazado_por_est"))
                                    {
                                        clave="r";
                                        ret= bd.ActualizarEstado(idsolicitud, clave );
                                    }
                                     else
                                    {
                                        clave="d";
                                        ret= bd.ActualizarEstado(idsolicitud, clave );
                                    }
                            }
                       }
                       else
                        {
                            clave="d";
                            ret= bd.ActualizarEstado(idsolicitud, clave );
                        }
                    }
                 }
             }
            if(est.equals("g         "))
           {
               ret= bd.ActualizarEstado(idsolicitud, clave );
                if(ret>0){
                   ban=em.enviarVice(idsolicitud,"solentrevistas");
               }
        
           }
           if(est.equals("h         "))
           {
               HashMap estadosbienestar = bd.estadosbienestar(idsolicitud);
               String vobo_vice,vobo_psico,vobo_medico;
               vobo_vice="2";
               vobo_psico="2";
               vobo_medico="2";
               if(estadosbienestar.get("vobo_vice")!= null){
                    vobo_vice=(String) estadosbienestar.get("vobo_vice");
                    ret=1;
               }
                if(estadosbienestar.get("vobo_psico")!= null){
                    vobo_psico=(String) estadosbienestar.get("vobo_psico");
                    ret=1;
               }
                 if(estadosbienestar.get("vobo_medico")!= null){
                    vobo_medico=(String) estadosbienestar.get("vobo_medico");
                    ret=1;
               }
               
               if(vobo_vice.equals("0") || vobo_psico.equals("0")|| vobo_medico.equals("0")){
                   clave="r";
                   ret= bd.ActualizarEstado(idsolicitud, clave );
               }
               if(vobo_vice.equals("1")&& vobo_psico.equals("1")&& vobo_medico.equals("1")){
                     ret= bd.ActualizarEstado(idsolicitud, clave );
                     ban=em.enviarEst(idsolicitud,"process_end");
               }
           }
            if(est.equals("j         "))
           {
               ret= bd.ActualizarEstado(idsolicitud, clave );
           }
            if(est.equals("i         "))
           {
               ret= bd.ActualizarEstado(idsolicitud, clave );
           }
            //Rechaza proceso en cualquier estado 
           if(est.equals("finalizarProceso"))
           {
               ret= bd.FinalizarProceso(idsolicitud, clave, comment);
           }
        res = "<resultado>";        
        //ret=bd.
            //Enviar Respuesta
        res = res + "<dato>" + idsolicitud + "</dato>";
        if (ret > 0){
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
            Logger.getLogger(ActualizarEstMov.class.getName()).log(Level.SEVERE, null, ex);
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
