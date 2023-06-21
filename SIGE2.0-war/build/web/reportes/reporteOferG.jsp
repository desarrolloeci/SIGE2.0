<%-- 
    Document   : reporteOferG
    Created on : 26/11/2012, 04:17:31 PM
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
       HashMap[] infos= Admin.getReporteOferG(programa, fechain, fechaout,datos);
       HashMap info;
       int numfilas=infos.length;
       int numcolumnas=numdatos;
          //response.setHeader ("Content-Disposition", "attachment;filename=\"report.xls\"");
        response.setHeader("Content-Disposition", "attachment; filename=\"Prácticas Profesionales - Reporte de Ofertas.xls\"");
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
            <tr> <td align="center" border="1"  bgcolor="#EEEBFC" style="font-size: 12pt; color:#000000 " > <i>INFORME DE OFERTAS</i> </td></tr><br/>
            <td valign="top" width="90%" class="textocom" >
                    <table align="center" border="1"   bordercolor="#000000">
                        <tr>
                            <td>Cargo</td>
                            <td>Vacantes</td>
                            <td>Teletrabajo</td>
                            <td>Discapacidad</td>
                            <td>Excepción de Publicación</td>
                            <td>Razón Social</td>
                            <td>Tipo ID</td>
                            <td>Tipo ID Text</td>
                            <td>ID</td>
                            <td>Dirigida a</td>
                            <td>Nivel de Estudios</td>
                            <td>Nivel de Estudios Text</td>
                            <td>Municipios Oferta</td>
                            <td>Tipo Contrato</td>
                            <td>Estado de la Oferta</td>
                            <td>Salario</td>
                            <td>URL</td>
                            <%for(int c=0;c<numcolumnas;c++){
                                  if(datos[c].equals("aÃ±os_exp")){
                                    datos[c]="años_exp";
                                 }%>
                                <td><%=datos[c]%> </td>
                            <%}
                            %>
                        </tr>
                        <% for(int f=0; f<numfilas;f++){
                            info=infos[f];
                         %>
                        <tr>
                            <td><%=info.get("cargo")%></td>
                            <td><%=info.get("vacantes")%></td>
                            <td><%=info.get("teletrabajo")%></td>
                            <td><%=info.get("discapacidad")%></td>
                            <td><%=info.get("excepcionpub")%></td>
                            <td><%=info.get("razon_social")%></td>
                            <td><%=info.get("tipoid")%></td>
                            <td><%=info.get("idtipo")%></td>
                            <td><%=info.get("nit")%></td>
                            <td><%=info.get("dirigido_a")%></td>
                            <td><%=info.get("estudios_requeridos")%></td>
                            <td><%=info.get("estudios_requeridost")%></td>
                            <td><%=info.get("municipios")%></td>
                            <td><%=info.get("idtipo_contrato")%></td>
                            <td><%=info.get("estado")%></td>
                            <td><%=info.get("Salario")%></td>
                            <td><%=info.get("URL")%></td>
                            <%for(int c=0;c<numcolumnas;c++){
                                if(datos[c].equals("aÃ±os_exp")){
                                    datos[c]="años_exp";
                                 }%>
                                <td><%=info.get(datos[c])%> </td>
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

