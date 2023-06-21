/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

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
 * @author Mario Martínez
 */
public class lisEstPracDec extends HttpServlet {

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
        
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        String iddpto;
        String res = "";
        
        try {

            res = "<lisEstudiantes>";

            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            BDsige.DecanoRemote bd= conEjb.lookupDecanoRemote();
            bd.inicializar("75107740");

            iddpto = request.getParameter("iddpto");

            HashMap[] items = bd.getListaEstPracDec(iddpto);

            for (HashMap item: items) {
                    res +=  "<estudiante>" 
                            + "<idsol>" + item.get("IdSol") + "</idsol>"
                            + "<nombre>" + item.get("Nombre") + "</nombre>" 
                            + "<est>" + item.get("Estado") + "</est>" 
                            + "</estudiante>";
            }
            res += "</lisEstudiantes>";
        } catch (Exception err) {
            Logger.getLogger(lisEstPracDec.class.getName()).log(Level.SEVERE, null, err);
            res = "<valor>Error Inesperado: " + err + "</valor>";
        }
        
        pw.write(res);
        pw.flush();
        pw.close();
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
