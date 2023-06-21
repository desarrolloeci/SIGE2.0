<%-- 
    Document   : reporteGrad
    Created on : 21/11/2012, 03:57:40 PM
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
       num = request.getParameter("numdatos");
       //"reporteGrad?programagradAdmin=TODOS&fechainG=2/2011&fechaoutG=2/2012&dato1=documento&dato2=est_civil&dato3=fecha_nacimiento&dato4=tel_residencia&&numdatos=4"
       int numdatos=Integer.parseInt(num);
       String datos[] = new String[numdatos];
       for(int i=1; i<=numdatos;i++){
            nomdato="dato"+i;
            datos[i-1]=request.getParameter(nomdato);
       }      
            
            
       HashMap[] infos= Admin.getReporteGrad(programa, fechain, fechaout,datos);
       HashMap info;
       int numfilas=infos.length;
       int numcolumnas=numdatos;
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
            <tr> <td align="center" border="1"  bgcolor="#EEEBFC" style="font-size: 12pt; color:#000000 " > <i>INFORME DE DATOS DEL GRADUADO</i> </td></tr><br/>
            <td valign="top" width="90%" class="textocom" >
                    <table align="center" border="1"   bordercolor="#000000">
                        <tr>
                            <td>Nombre</td>
                            <td>Nombre Comunicaciones</td>
                            <td>Genero</td>
                            <td>Programa Académico</td>
                            <td>Fecha de Graduación</td>
                            <td>Última Actualización</td>
                            <%for(int c=0;c<numcolumnas;c++){
                                if(datos[c].contains(" as ")){
                                    datos[c]=datos[c].split(" as ")[1];
                                }
                                %>
                                <td><%=datos[c]%> </td>
                            <%}
                            %>
                        </tr>
                        <% for(int f=0; f<numfilas;f++){
                            info=infos[f];
                         %>

                        <tr>
                            <td><%=(String) info.get("nom_est") != null?info.get("nom_est"):""%> </td>
                            <td><%=(String) info.get("nomcortoes") != null?info.get("nom_est"):""%> </td>
                            <td><%=(String) info.get("sexo") != null?info.get("sexo"):""%> </td>
                            <td><%=(String) info.get("nom_prog") != null?info.get("nom_prog"):""%> </td>
                            <td><%=(String) info.get("fec_grad") != null?info.get("fec_grad"):""%> </td>
                            <td><%=(String) info.get("ultima_act") != null?info.get("ultima_act"):""%> </td>
                            <%for(int c=0;c<numcolumnas;c++){ %>
                                <td><%=(String) info.get(datos[c]) != null?info.get(datos[c]):""%> </td>
                            <%}
                            %>

                        </tr>
                        <%
                         }
                        %>                      
                    </table>
            </td>
        </table>
    </body>
</html>
