<%-- 
    Document   : format_footer
    Created on : 15/01/2015, 04:04:53 PM
    Author     : Mario Martínez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String getType = request.getParameter("type");
    
    if (getType == null) {
        response.sendRedirect("http://www.escuelaing.edu.co");
        return;
    }
%>
<div align="center" class="footer" style="border-bottom-left-radius: 20px; border-bottom-right-radius: 20px; padding: 10px 0px;">
    <p style="margin-top: 0px;">Escuela Colombiana de Ingeniería Julio Garavito</p>
    <p>
    <%
    if (getType.equals("general")) {
        %>
        SIEMPREG - Sistema de Información para Empresas, Movilidad, Prácticas y Relación con Graduados<br>
        Unidad de Gestión Externa<br>
        uge@escuelaing.edu.co<br>
        PBX: +57(1) 668 3600 ext. 128 / Línea Nacional Gratuita: 018000112668<br>
        <%
    } else if (getType.equals("grad")) {
        %>
        Sistema de Información de Graduados<br>
        Oficina de Graduados<br>
        graduados@escuelaing.edu.co<br>
        PBX: +57(1) 668 3600 ext. 120 / Línea Nacional Gratuita: 018000112668<br>
        <%
    } else if (getType.equals("prac")) {
        %>
        Sistema de Prácticas Profesionales<br>
        Oficina de Prácticas<br>
        practicas@escuelaing.edu.co<br>
        PBX: +57(1) 668 3600 ext. 294 / Línea Nacional Gratuita: 018000112668<br>
        <%
    } else if (getType.equals("movi")) {
        %>
        Sistema de Movilidad<br>
        Oficina de Relaciones Internacionales<br>
        ori@escuelaing.edu.co<br>
        PBX: +57(1) 668 3600 ext. 328 / Línea Nacional Gratuita: 018000112668<br>
        <%
    }
    %>
    (Autopista Norte) AK 45 # 205-59<br>
    www.escuelaing.edu.co
</p>
<p style="margin-bottom: 0px;">Bogotá, D.C. - Colombia</p>
</div>
    
