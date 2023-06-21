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

/**
 *
 * @author Luis Alberto Salas
 */
public class NuevaOfertaGrad extends HttpServlet {
   
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
            out.println("<title>Servlet NuevaOfertaGrad</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NuevaOfertaGrad at " + request.getContextPath () + "</h1>");
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
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            int ret = 0;
            int numprog ,numesi;
            String nit,cont,nomcargonog,descripcionnog,Requisitosnog, idiomReqG ,paisnog,areanog,salarionog,fechaoutnog,horarionog,contratonog,anosexpnog,num,ban,vacantes, teletrabajo, discapacidad, excepcionpub, tmes, numes;
            PrintWriter pw = response.getWriter();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.EmpresaRemote bd= conEjb.lookupEmpresaRemote();
            bd.inicializar("75107740");
            //'nomcargonog','descripcionnog','Requisitosnog','paisnog','ciudadnog','areanog','salarionog','fechaoutnog','horarionog','contratonog','añosexpnog'
            nit = request.getParameter("nit");
            nomcargonog = tildes(request.getParameter("nomcargonog"));
            descripcionnog = tildes(request.getParameter("descripcionnog"));
            Requisitosnog = tildes(request.getParameter("Requisitosnog"));
            idiomReqG = tildes(request.getParameter("idiomReqG"));
            paisnog = tildes(request.getParameter("paisnog"));
            String[] ciudadnog = request.getParameterValues("ciudadnog");
            areanog =tildes( request.getParameter("areanog"));
            salarionog = request.getParameter("salarionog");
            fechaoutnog= request.getParameter("fechaoutnog");
            horarionog= request.getParameter("horarionog");
            contratonog=request.getParameter("contratonog");
            anosexpnog= request.getParameter("anosexpnog");
            
            
            
            vacantes       = request.getParameter("vacnog");
            teletrabajo    = request.getParameter("teletrabajonog");
            discapacidad   = request.getParameter("discapacidadnog");
            excepcionpub   = request.getParameter("excepcionpubnog");
            
            cont=request.getParameter("cont");
            String nomprog;
            nomprog = "programa" + 1;
            String nomestreq;
            nomestreq = "estreq"+1;
            ban=request.getParameter(nomprog);
            tmes=request.getParameter(nomestreq);
            
            num = request.getParameter("numprog");
            numes = request.getParameter("numest");
            
            
            numprog = Integer.parseInt(num);
            numesi = Integer.parseInt(numes);
            
            String[] programas = new String[numprog];
            String[] estrequeridos = new String[numesi];
            
            if (numprog != 0) {
                for(int i = 1; i <= numprog; i++) {
                    nomprog = "programa" + i;
                    programas[i-1] = tildes(request.getParameter(nomprog));
                }
                for(int i = 1; i <= numesi; i++) {
                    nomestreq = "estreq" + i;
                    estrequeridos[i-1] = tildes(request.getParameter(nomestreq));
                }
                
                ret = bd.RegofertaGrad(nit,cont,nomcargonog,descripcionnog,Requisitosnog, idiomReqG,paisnog,ciudadnog,areanog,salarionog,fechaoutnog,horarionog,contratonog,anosexpnog,programas,vacantes,teletrabajo,discapacidad,excepcionpub,estrequeridos);
                
                //Enviar Respuesta
                if (ret > 0) {
                    response.sendRedirect("PublicarOfertaGrad?mensaje=3");
                } else if (ret == -1) {
                    response.sendRedirect("PublicarOfertaGrad?mensaje=1");
                } else {
                    response.sendRedirect("PublicarOfertaGrad?mensaje=0");
                }
        
            } else {
                response.sendRedirect("PublicarOfertaGrad?mensaje=2");
            }
        } catch (Exception ex) {
            Logger.getLogger(NuevaOfertaGrad .class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("PublicarOfertaGrad?mensaje=0");
        }
    }
    
    public String tildes(String dato) {
        String result = dato;
        
        result = result.replace("'", "''");
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
