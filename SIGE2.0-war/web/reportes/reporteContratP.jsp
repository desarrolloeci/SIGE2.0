<%-- 
    Document   : reporteContratP
    Created on : 12/04/2016, 11:05:02 AM
    Author     : Mario Martínez
--%>

<%@page import="BDsige.AdministradoresRemote"%>
<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject;" %>

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

    HashMap[] infos = Admin.getReporteContratP();

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd h mm a");
    Calendar today = Calendar.getInstance();
    
    df.setTimeZone(today.getTimeZone());
    
    String tDate = df.format(today.getTime());
    
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition", "attachment; filename=\"Prácticas Profesionales - Reporte de Contratados - " + tDate + ".xls\"");
%>

<table>
    <tr>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Carné</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Nombre del estudiante</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Documento</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Programa Académico</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Teléfono</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Celular</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Correo</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Correo 2</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de solicitud</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Empresa</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de inicio</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de finalización</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Nombre RRHH</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Teléfono RRHH</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Correo RRHH</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Supervisor o Jefe</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Cargo</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Teléfono</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Email</td>
    </tr>
    <%
        for (HashMap info: infos) {
    %>
    <tr>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("id_est")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("nom_est")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("doc_est")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("nom_prog")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("tel")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("cel")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("correo")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("correo2")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("f_sol")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("razon_social")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("f_in")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("f_out")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("nom_rrhh")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("tel_rrhh")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("correo_rrhh")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("nom_jefe")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("cargo_jefe")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("tel_jefe")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("email_jefe")%></td>
    </tr>
    <%
        }
    %>
</table>