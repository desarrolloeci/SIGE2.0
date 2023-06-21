<%-- 
    Document   : reporteSolPDec
    Created on : 12/04/2016, 11:58:01 AM
    Author     : Mario Martínez
--%>

<%@page import="BDsige.DecanoRemote"%>
<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject"%>

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
                window.location = 'loginDec';
            </script>
        <%
        return;
    }

    String rol = admin.getRol();
    
    if (rol == null) {
        %>
            <script>
                alert("Usted no está autorizado para ver este reporte.");
                window.history.back();
            </script>
        <%
        return;
    }
    
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
    DecanoRemote Decano = conEjb.lookupDecanoRemote();
    Decano.inicializar("75107740");       

    HashMap[] infos = Decano.getReporteSolPDec(rol);
    
    if (infos.length == 0) {
        %>
            <script>
                alert("No se han encontrado resultados para esta consulta.");
                window.history.back();
            </script>
        <%
        return;
    }

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
        <%--<td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de aprobación o rechazo</td>--%>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Carné</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Nombre del estudiante</td>
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
        <%--<td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("fec_aprob")%></td>--%>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("id_est")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("nom_est")%></td>
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