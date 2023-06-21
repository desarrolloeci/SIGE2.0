<%-- 
    Document   : reporteApliG
    Created on : 27/11/2012, 10:37:20 AM
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

    response.setHeader("Cache-Control","no-cache");
    response.setContentType("application/vnd.ms-excel");
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
     String num = new String ();
     String programa = new String ();
     String fechain = new String ();
     String fechaout = new String ();
      String nomdato = new String ();
       AdministradoresRemote Admin = conEjb.lookupAdministradoresRemote();
       Admin.inicializar("75107740");
       programa = request.getParameter("programagradAdmin");
       fechain = request.getParameter("fechainG");
       fechaout = request.getParameter("fechaoutG");
       //num = request.getParameter("numdatos");
       //"reporteGrad?programagradAdmin=TODOS&fechainG=2/2011&fechaoutG=2/2012&dato1=documento&dato2=est_civil&dato3=fecha_nacimiento&dato4=tel_residencia&&numdatos=4"
       //int numdatos=Integer.parseInt(num);
       //String datos[] = new String[numdatos];
       //for(int i=1; i<=numdatos;i++){
         // nomdato="dato"+i;
          //datos[i-1]=request.getParameter(nomdato);
       //}
       HashMap[] infos= Admin.getReporteApliG(programa, fechain, fechaout);
       HashMap info;
       int numfilas=infos.length;
       //int numcolumnas=numdatos;
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
            <tr> <td align="center" border="1"  bgcolor="#EEEBFC" style="font-size: 12pt; color:#000000 " > <i>INFORME DE DISTINCIONES</i> </td></tr><br/>
            <td valign="top" width="90%" class="textocom" >
                    <table align="center" border="1"   bordercolor="#000000">
                        <tr>
                            <td>Nombre Graduado</td>
                            <td>Genero</td>
                            <td>Area de la oferta</td>
                            <td>Cargo al que se postula</td>
                            <td>Empresa a la que se Postula</td>
                            <td>Nit de la empresa</td>
                            <td>Estado de la aplicación</td>
                            <td>Fecha de aplicación </td>
                        </tr>
                        <% for(int f=0; f<numfilas;f++){
                            info=infos[f];
                         %>

                        <tr>
                            <td><%=info.get("nom_est")%> </td>
                            <td><%=info.get("sexo")%> </td>
                            <td><%=info.get("area_oferta")%> </td>
                            <td><%=info.get("cargo")%> </td>
                            <td><%=info.get("razon_social")%> </td>
                            <td><%=info.get("nit")%> </td>
                            <td><%=info.get("estado")%> </td>
                            <td><%=info.get("fecha_apli")%> </td>
                        </tr>
                        <%
                         }
                        %>
                    </table>
            </td>
        </table>
    </body>
</html>