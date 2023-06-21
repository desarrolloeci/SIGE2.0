<%-- 
    Document   : reporteOferPDec
    Created on : 12/04/2016, 02:25:02 PM
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

    HashMap[] infos = Decano.getReporteOferPDec(rol);
    
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
    response.setHeader("Content-Disposition", "attachment; filename=\"Prácticas Profesionales - Reporte de Ofertas - " + tDate + ".xls\"");
%>
<table>
    <tr>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">ID Oferta</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">NIT</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Razón Social</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Cargo</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Sector</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Tipo de contrato</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de inicio</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de finalización</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Estado</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de publicación</td>
        <td style="background: #C0504D; color: #FFFFFF; font-weight: bold;">Fecha de vencimiento</td>
    </tr>
    <%
        for (HashMap info: infos) {
    %>
    <tr>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("id_oferta")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("nit")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("razon_social")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("cargo")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("sector_oferta")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("tipo_contrato")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("f_in")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("f_out")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("estado")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("f_publicacion")%></td>
        <td style="border: 1px solid #E0E0E0; border-top: 0px;"><%=info.get("f_limite")%></td>
    </tr>
    <%
        }
    %>
</table>