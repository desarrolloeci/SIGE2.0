<%-- 
    Document   : VerAplicantesOferPracAdmin
    Created on : 4/02/2013, 11:11:53 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EmpresaRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


    String rol = new String ();
    String usuario = new String ();
    String idoferta = new String ();
    String error = new String();
    login.SessionUsrRemote admin =(login.SessionUsrRemote)session.getAttribute("usuario");
    usuario=admin.getUser();
    rol=admin.getRol();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           EmpresaRemote emp = conEjb.lookupEmpresaRemote();
           emp.inicializar("75107740");
           session.setAttribute("emp",emp);
           idoferta = request.getParameter("idofer");
           HashMap datosoferta= emp.getDatosOfertaempP(idoferta);
           HashMap[] aplicantes=emp.getAplicantesOferEmpP(idoferta);
           //id_aplicacion
           HashMap aplicante;
          int numa=aplicantes.length;
%>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>solicitud</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>

        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
    </head>
    <body background="imagenes/fondo.gif" >
        <p class="textocom">&nbsp;</p>
        <table width="450"  align="center" border="1"  cellspacing="0" bordercolor="#EEEBFC">
            <tr> <td align="center" bgcolor="#EEEBFC" style="font-size: 12pt; color:#000000 " > <i> OFERTA LABORAL </i> </td></tr><br/>
            <td valign="top" width="90%" height="500"  bgcolor="#FFFFFF" class="textocom" style="  box-shadow:  -5px 5px 5px 5px rgba(0,0,0,0.1); ">
                <table >
                    <tr>
                        <td valign="top"><b>Cargo:</b></td>
                        <td><%=datosoferta.get("cargo")%></td>
                    </tr>
                    <tr>
                        <td><b>Área Laboral:</b></td>
                        <td><%=datosoferta.get("area_oferta")%></td>
                    </tr>
                     <tr>
                         <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                    <tr>
                        <td><b>Fecha de publicación:</b></td>
                        <td><%=datosoferta.get("fecha_publicacion")%></td>
                    </tr>
                    <tr>
                        <td><b>Fecha de vencimiento:</b> </td>
                        <td><%=datosoferta.get("fecha_limite")%></td>
                    </tr>

                     <tr>
                        <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                    <tr>
                        <td><b>Jornada:</b></td>
                        <td><%=datosoferta.get("horario_oferta")%></td>
                    </tr>
                    <tr>
                        <td><b>Tipo de contrato:</b></td>
                        <td><%=datosoferta.get("tipo_contrato")%></td>
                    </tr>
                    <tr>
                        <td valign="top"><b>Salario:</b></td>
                        <td>entre <%=datosoferta.get("salario_oferta")%>de pesos</td>
                    </tr>
                    <tr>
                         <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>

                     </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                     </tr>
                </table>
                    <table align="center" border="1"  cellspacing="0" bordercolor="#EEEBFC">
                        <tr><td colspan="2" align="center" bgcolor="#EEEBFC" style="font-size: 9pt; color:#000000 " > <i> Postulantes a esta oferta </i> </td></tr>
                        <%if(numa==0){%>
                          <tr><td colspan="2">Esta oferta no tiene ningún postulante</td></tr>


                        <%}else{%>
                        <tr>
                                <td align="center">Nom. Postulante</td>
                                <td align="center">Estado</td>
                        </tr>
                        <%for(int i=0;i<numa;i++){
                           aplicante=aplicantes[i];
    %>
                        <tr>
                                <td><a><%=aplicante.get("nom_est")%></a></td>
                                <td><%=aplicante.get("men_usr")%></td>
                        </tr>
                        <%}
                        }%>
                    </table>
            </td>
        </table>
    </body>
</html>
