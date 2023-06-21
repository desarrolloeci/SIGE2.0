<%-- 
    Document   : reporteGradMon
    Created on : 13/06/2016, 04:59:10 PM
    Author     : Mario Martínez
--%>

<%@page import="BDsige.AdministradoresRemote"%>
<%@page import="java.util.*, java.awt.*, java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject" %>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Connection", "close");
    response.setCharacterEncoding("ISO-8859-1");
    
    login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
    
    if (admin == null) {
        %>
            <script>
                alert("El usuario no está autenticado o su sesión ha finalizado.");
                window.location = 'loginAdmin';
            </script>
        <%
        return;
    }
    
    String rol = admin.getRol();
    
    //if (!rol.equals("6")) {
        %>
    <!--        <script>
                alert("Usted no está autorizado para ver este reporte.");
                window.history.back();
            </script>
    -->    <%
    //    return;
    //}
    
    String programa = request.getParameter("programagradAdmin");
    String fechain = request.getParameter("fechainG");
    String fechaout = request.getParameter("fechaoutG");
    
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
    AdministradoresRemote Admin = conEjb.lookupAdministradoresRemote();
    Admin.inicializar("75107740");
    
    HashMap[] infos = Admin.getReporteGradMon(programa, fechain, fechaout);
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h mm a");
    Calendar today = Calendar.getInstance();
    
    sdf.setTimeZone(today.getTimeZone());
    
    String tDate = sdf.format(today.getTime());
    
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition", "attachment; filename=\"Monitores - Reporte de Graduados - " + tDate + ".xls\"");
%>
<table>
    <tr>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Documento</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Nombre</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Programa</td>
    </tr>
    <%
        for (HashMap info: infos) {
    %>
    <tr>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("Documento")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("Nombre")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("Programa")%></td>
    </tr>
    <%
        }
    %>
</table>