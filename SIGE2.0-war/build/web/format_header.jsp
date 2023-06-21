<%-- 
    Document   : format_header
    Created on : 12/06/2015, 09:16:38 AM
    Author     : Mario Martínez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String getHeader = request.getParameter("type");
    String imgHeader = "header_";
    
    if (getHeader == null || getHeader.equals("")) {
        response.sendRedirect("http://www.escuelaing.edu.co");
        return;
    }
    
    imgHeader += getHeader + ".jpg";
%>
<table width="772" class="curvas" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-bottom: 32px">
    <tr>
        <td align="center" style="padding: 5px;">
            <img name="encabezado_emp" src="imagenes/<%=imgHeader%>" class="curvas" border="0" alt="">
        </td>
    </tr>
</table>
