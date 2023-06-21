<%-- 
    Document   : reporteEstG
    Created on : 23/11/2012, 11:50:58 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.AdministradoresRemote"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,
         javax.rmi.PortableRemoteObject"
         %>

<html>
    <head>
<%

    //response.setHeader("Cache-Control","no-cache");
    //response.setContentType("application/vnd.ms-excel");
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
   

    
       AdministradoresRemote Admin = conEjb.lookupAdministradoresRemote();
       Admin.inicializar("75107740");
       
       //"reporteGrad?programagradAdmin=TODOS&fechainG=2/2011&fechaoutG=2/2012&dato1=documento&dato2=est_civil&dato3=fecha_nacimiento&dato4=tel_residencia&&numdatos=4"
      
       HashMap[] infos= Admin.getReporteEstSolEs();
       HashMap info;
       int numfilas=infos.length;
          //response.setHeader ("Content-Disposition", "attachment;filename=\"report.xls\"");
%>

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>solicitud</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>


    </head>
    <body >
        <p class="textocom">&nbsp;</p>
        <table width="450"  align="center" border="2"  cellspacing="0" bordercolor="#000000">
            <tr> <td align="center" border="1"  bgcolor="#EEEBFC" style="font-size: 12pt; color:#000000 " > <i>INFORME INFO GENERAL DE GRADUADOS</i> </td></tr><br/>
            <td valign="top" width="90%" class="textocom" >
                    <table align="center" border="1"   bordercolor="#000000">
                        <tr>
                            <td>Nro. Documento</td>
                            <td>Nombre</td>
                            <td>Fecha Nacimiento</td>
                            <td>Ind. Tel</td>
                            <td>Teléfono</td>
                            <td>Ind. Cel</td>
                            <td>Celular</td>
                            <td>email</td>
                            <td>email2</td>
                            <td>Perfil</td>
                            <td>País</td>
                            <td>Ciudad</td>
                            <td>VoBo Política</td>
                            <td>Experiencia Laboral</td>
                            <td>Estudios</td>
                            <td>Distinciones</td>
                            <td>Afiliaciones</td>
                        </tr>
                        <% for(int f=0; f<numfilas;f++){
                            info=infos[f];
                         %>

                        <tr>
                            <td><%=info.get("documento")%> </td>
                            <td><%=info.get("nom_est")%> </td>
                            <td><%=info.get("fecha_nacimiento")%> </td>
                            <td><%=info.get("tel_indicativo")%> </td>
                            <td><%=info.get("tel_residencia")%> </td>
                            <td><%=info.get("cel_indicativo")%> </td>
                            <td><%=info.get("cel")%> </td>
                            <td><%=info.get("email")%> </td>
                            <td><%=info.get("email2")%> </td>
                            <td><%=info.get("perfil")%> </td>
                            <td><%=info.get("pais_residencia")%> </td>
                            <td><%=info.get("ciudad_residencia")%> </td>
                            <td><%=info.get("vobopoliticadatos")%> </td>
                            <td><%=info.get("explaboral")%> </td>
                            <td><%=info.get("estudios")%> </td>
                            <td><%=info.get("distinciones")%> </td>
                            <td><%=info.get("afiliaciones")%> </td>
                        </tr>
                        <%
                         }
                        %>
                    </table>
            </td>
        </table>
    </body>
</html>

