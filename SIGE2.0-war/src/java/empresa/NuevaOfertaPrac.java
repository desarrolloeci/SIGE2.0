/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package empresa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utiles.ConvertDate;

/**
 *
 * @author Luis Alberto Salas
 */
public class NuevaOfertaPrac extends HttpServlet {
   
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
            out.println("<title>Servlet NuevaOfertaPrac</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NuevaOfertaPrac at " + request.getContextPath () + "</h1>");
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
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            String res = "";
            int ret = 0;
            int re = 0;
            int numprog;
            String  ban,num,nit,nomcargonop,descripcionnop,Requisitosnop,paisnop,cont;
            String ciudadnop,areanop,sectornop,salarionop,fechaoutnop,fechainprac,fechaoutprac,horarionop,contratonop;
            String seguros_arp,nom_jefe,cargo_jefe,tel_jefe,email_jefe, tipoprac;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EmpresaRemote bd= conEjb.lookupEmpresaRemote();
            bd.inicializar("75107740");
            //'nomcargonop','descripcionnop','Requisitosnop','paisnop',
            //'ciudadnop','areanop','salarionop','fechaoutnop','fechainprac','fechaoutprac','horarionop','contratonop',
            //'seguros_arp','nom_jefe','cargo_jefe','tel_jefe','email_jefe'
            nit = request.getParameter("nit");
            nomcargonop = tildes(request.getParameter("nomcargonop"));
            descripcionnop = tildes(request.getParameter("descripcionnop"));
            Requisitosnop = tildes(request.getParameter("Requisitosnop"));
            paisnop = tildes(request.getParameter("paisnop"));
            ciudadnop = tildes(request.getParameter("ciudadnop"));
            areanop = tildes(request.getParameter("areanop"));
            sectornop = tildes(request.getParameter("sectornop"));
            salarionop = tildes(request.getParameter("salarionop"));
            fechaoutnop= tildes(request.getParameter("fechaoutnop"));
            fechaoutnop = fechaoutnop.split("/")[2]+"/"+fechaoutnop.split("/")[1]+"/"+fechaoutnop.split("/")[0];
            fechainprac= tildes(request.getParameter("fechainprac"));
            fechainprac = fechainprac.split("/")[2]+"/"+fechainprac.split("/")[1]+"/"+fechainprac.split("/")[0];
            fechaoutprac=tildes(request.getParameter("fechaoutprac"));
            fechaoutprac = fechaoutprac.split("/")[2]+"/"+fechaoutprac.split("/")[1]+"/"+fechaoutprac.split("/")[0];
            horarionop=tildes(request.getParameter("horarionop"));
            contratonop=tildes(request.getParameter("contratonop"));
            seguros_arp=tildes(request.getParameter("seguros_arp"));
            nom_jefe=tildes(request.getParameter("nom_jefe"));
            cargo_jefe=tildes(request.getParameter("cargo_jefe"));
            tel_jefe=tildes(request.getParameter("tel_jefe"));
            email_jefe=tildes(request.getParameter("email_jefe"));
            cont=tildes(request.getParameter("cont"));
            tipoprac=tildes(request.getParameter("tiprac"));
            String nomprog;
            nomprog="programa"+1;
            ban=request.getParameter(nomprog);
            num = request.getParameter("numprog");
            numprog=Integer.parseInt(num);
            String[] programas = new String[numprog];
            
            if (numprog != 0) {
                
                for (int i=1; i<=numprog;i++) {
                    nomprog="programa"+i;
                    programas[i-1]=tildes(request.getParameter(nomprog));
                }

                
                ret= bd.RegOfertaPrac(nit,nomcargonop,descripcionnop,Requisitosnop,paisnop,ciudadnop,areanop,sectornop,salarionop,fechaoutnop,
                fechainprac,fechaoutprac,horarionop,contratonop,seguros_arp,nom_jefe,cargo_jefe,tel_jefe,email_jefe,programas,cont,tipoprac, false);
                

                if (ret == 1) {
                    response.sendRedirect("MenuEmpresa?msgOfer=Su oferta ha sido publicada satisfactoriamente, puede verificarlo en la opción Prácticas Profesionales > Consultar Ofertas > Todas las Ofertas");
                } else if(ret == -1) {
                    response.sendRedirect("MenuEmpresa?msgOfer=Su oferta No se ha publicado porque su empresa ya tiene registrada una oferta vigente para el cargo "+nomcargonop+", no se permite duplicar ofertas. Para crear la oferta por favor especifique mejor el cargo, si por ejemplo el cargo es Practicante");
                } else{
                    response.sendRedirect("MenuEmpresa?msgOfer=Su oferta No se ha publicado correctamente, por favor intente más tarde.");
                }
                
                
            } else {
                /**
                pw.write("<html>");
                pw.write("<head>");
                pw.write("<script>window.history.back()</script>");
                pw.write("</head>");
                pw.write("</html>");
                //pw.write("Presione <a href=\"javascript:void(0)\" onclick=\"window.history.back()\"><b>aquí</b></a> para volver a su oferta.");
                pw.flush();
                pw.close();
                * */
                response.sendRedirect("MenuEmpresa?msgOfer=Su oferta no ha sido publicada, recuerde seleccionar al menos un programa requerido");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(NuevaOfertaGrad .class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("MenuEmpresa?msgOfer=Su oferta No se ha publicado correctamente, por favor intente más tarde.");
            /*String res = "";
            PrintWriter pw = response.getWriter();
            Logger.getLogger(NuevaOfertaGrad .class.getName()).log(Level.SEVERE, null, ex);

            res = "<resultado>";
            res = res + "<dato>" + String.valueOf(ex.getCause()) + "</dato>";
            res = res + "<valor>Fallo en la Operación"+String.valueOf(ex)+"</valor>";
            res = res + "</resultado>";
            response.setContentType("text/xml");
            pw.write(res);
            pw.flush();
            pw.close();*/
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
        result = result.replace("'", "''");
        result = result.replace("INGENIERÃA BIOMÉDICA", "INGENIERÍA BIOMÉDICA");
        result = result.replace("INGENIERÃA MECÃNICA", "INGENIERÍA MECÁNICA");
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
