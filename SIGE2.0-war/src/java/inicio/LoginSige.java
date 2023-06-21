/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import login.SessionUsr;
//import login.LoginUsrGrad;
//import login.SessionGrad;

/**
 *
 * @author Luis Alberto Salas
 */
public class LoginSige extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginSige</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginSige at " + request.getContextPath () + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        HttpSession sesion;
        String conectado;
        String derechos;
        Boolean ban = false;
        String usuario, clave, sistema, tipo;

        usuario = request.getParameter("usuario");
        //usuario = "alexander.perez";
        usuario = usuario.replace("@escuelaing.edu.co", "");
        usuario = usuario.replace("@mail.escuelaing.edu.co", "");

        clave = "NA";
        
        
        sistema = request.getParameter("sistema");
        tipo = request.getParameter("tipo");
        
                
        if(tipo.equals("Admin")){
            
            clave = request.getParameter("clave");
            
        }
        

        PrintWriter pw = response.getWriter();
        inicio.conectaEJB conEjb = new inicio.conectaEJB();
        login.LogsigeRemote loginusr = null;

        if (usuario == null || clave == null || usuario.equals("") || clave.equals("")) {
            pw.write("<root>Debe ingresar los campos de usuario y clave.</root>");
        } else {

            loginusr = conEjb.lookupLogsigeRemote();
            
            if(tipo.equals("Admin")){
            
            conectado = loginusr.getInicioSige(usuario, clave);
            
            }else{
                conectado = "conectado";
            }
            

            if (conectado.equals("conectado")) {
                try {
                    loginusr.inicializar("75107740");
                    HashMap item = loginusr.getPermiso(usuario);
                    derechos = (String) item.get("rol_usr");

                    if (!derechos.equals("0")) {
                        SessionUsr usr = new SessionUsr(usuario, derechos);
                        sesion = request.getSession(true);
                        sesion.setAttribute("usuario", usr);

                        if (tipo.equals("Admin")) {
                            if (derechos.equals("1") && sistema.equals("movilidad")) {
                                pw.write("<root>OK</root>");
                                ban = true;
                            } else if (derechos.equals("2") && sistema.equals("graduados")) {
                                pw.write("<root>OK</root>");
                                ban = true;
                            } else if (derechos.equals("3") && sistema.equals("practicas")) {
                                pw.write("<root>OK</root>");
                                ban = true;
                            } else if ((derechos.equals("6")
                                    || derechos.equals("13") || derechos.equals("14")
                                    || derechos.equals("15") || derechos.equals("16")
                                    || derechos.equals("17") || derechos.equals("260")
                                    || derechos.equals("262") || derechos.equals("19")
                                    || derechos.equals("20") || derechos.equals("18"))
                                    && sistema.equals("graduados")) {
                                pw.write("<root>MonGrad</root>");
                                sistema = "monitor";
                                ban = true;
                            } else {
                                pw.write("<root>El usuario NO se autentico en el sitema correcto</root>");
                            }
                        } else if (tipo.equals("Decanatura") && Integer.parseInt(derechos) >= 13) {
                            pw.write("<root>OK</root>");
                            ban = true;
                        } else if (tipo.equals("Vice") && derechos.equals("4")) {
                            pw.write("<root>OK</root>");
                            ban = true;
                        } else if (tipo.equals("Bienestar") && derechos.equals("5")) {
                            pw.write("<root>OK</root>");
                            ban = true;
                        } else {
                            pw.write("<root>El usuario NO se autentico en el sitema correcto</root>");
                        }
                    } else {
                        pw.write("<root>Su usuario o clave son incorrectos, o el usuario no se encuentra autorizado para ingresar a éste sistema</root>");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LoginSige.class.getName()).log(Level.SEVERE, null, ex);
                    pw.write("<root>Ha ocurrido un error al intentar ingresar al sistema. Por favor intentelo de nuevo.</root>");
                }
            } else {
                pw.write("<root>Su usuario o clave son incorrectos, o el usuario no se encuentra autorizado para ingresar a éste sistema</root>");
            }
        }
        //pw.flush();
        if (ban) {
            if (tipo.equals("Vice")) {
                response.sendRedirect("MenuVice");
            } else if (tipo.equals("Bienestar")) {
                response.sendRedirect("menubienestar");
            } else if (tipo.equals("Decanatura")) {
                if (sistema != null && sistema.equals("movilidad")) {
                    response.sendRedirect("DecanoMov");
                } else {
                    response.sendRedirect("DecanoPrac");
                }
            } else if (tipo.equals("Admin")) {
                if (sistema.equals("monitor")) {
                    response.sendRedirect("MenuMonitor");
                } else if (sistema.equals("movilidad")) {
                    response.sendRedirect("AdminMov");
                } else if (sistema.equals("practicas")) {
                    response.sendRedirect("AdminPrac");
                } else {
                    response.sendRedirect("AdminGrad");
                }
            }
        }

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

    public String caracterEsp(String dato) {
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
        result = result.replace("Â¡", "¡");
        result = result.replace("Â", "");
        return result;
    }

}
