<%-- 
    Document   : reporteEmpresas
    Created on : 12/04/2016, 09:16:28 AM
    Author     : Mario Mart�nez
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
        %><script>
            alert("El usuario no est� autenticado o su sesi�n ha finalizado.");
            window.location = 'loginAdmin';
          </script><%
        return;
    }

    String rol = admin.getRol();
    
    if (!rol.equals("1") && !rol.equals("2") && !rol.equals("3")) {
        %>
            <script>
                alert("Usted no est� autorizado para ver este reporte.");
                window.history.back();
            </script>
        <%
        return;
    }
    
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
    AdministradoresRemote Admin = conEjb.lookupAdministradoresRemote();
    Admin.inicializar("75107740");       

    HashMap[] infos = Admin.getReporteEmpresas();

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd h mm a");
    Calendar today = Calendar.getInstance();
    
    df.setTimeZone(today.getTimeZone());
    
    String tDate = df.format(today.getTime());
    
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition", "attachment; filename=\"SIEMPREG - Reporte de Empresas - " + tDate + ".xls\"");
%>

<table>
    <tr>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">ID Empresa</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">NIT</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Raz�n Social</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Direcci�n</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Ciudad</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Pa�s</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">P�gina web</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Email</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Tel�fono</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de registro</td>
    </tr>
    <%
        for (HashMap info: infos) {
    %>
    <tr>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("id_empresa")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("nit")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("razon_social")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("dir_empresa")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("ciudad_empresa")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("pais_empresa")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("web_empresa")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("email_empresa")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("tel_empresa")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("f_reg")%></td>
    </tr>
    <%
        }
    %>
</table>