<%-- 
    Document   : reporteEstPrac
    Created on : 11/04/2016, 11:28:10 AM
    Author     : Mario Martínez
--%>

<%@page import="BDsige.AdministradoresRemote"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject;" %>

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
    
    if (!rol.equals("3")) {
        %>
            <script>
                alert("Usted no está autorizado para ver este reporte.");
                window.history.back();
            </script>
        <%
        return;
    }
    
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
    AdministradoresRemote Admin = conEjb.lookupAdministradoresRemote();
    Admin.inicializar("75107740");       

    HashMap[] infos = Admin.getReporteSolP();

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd h mm a");
    Calendar today = Calendar.getInstance();
    
    df.setTimeZone(today.getTimeZone());
    
    String tDate = df.format(today.getTime());
    
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition", "attachment; filename=\"Prácticas Profesionales - Reporte de Solicitudes - " + tDate + ".xls\"");
%>

<table>
    <tr>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de solicitud</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de aprobación o rechazo</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Carné</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Nombre del estudiante</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Programa Académico</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Correo</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Correo 2</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Teléfono</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Teléfono 2</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Celular</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Estado de la solicitud</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Comentarios</td>
    </tr>
    <%
        for (HashMap info: infos) {
    %>
    <tr>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("fec_sol")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("fec_aprob")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("id_est")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("nom_est")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("nom_prog")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("correo")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("correo2")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("tel")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("tel2")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("cel")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("estado")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("comentarios")%></td>
    </tr>
    <%
        }
    %>
</table>