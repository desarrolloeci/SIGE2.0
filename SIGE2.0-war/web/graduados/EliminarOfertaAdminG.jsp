<%-- 
    Document   : EliminarOfertaAdminG
    Created on : 18/06/2014, 12:24:14 PM
    Author     : Luis Salas
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
    HashMap datosoferta= emp.getDatosOfertaemp(idoferta);
    
    HashMap[] programas=emp.getProgramasEmp(idoferta);
    HashMap programa;
    int nump=programas.length;

%>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>solicitud</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunAdminGrad.js" ></script>

        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
    </head>
    <body >
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_grad"></jsp:include>
        <table width="450"  align="center" border="0"  cellspacing="0" bordercolor="#EEEBFC">
            <%if(datosoferta.get("cargo")!= null){%>
            <tr> <td align="center" bgcolor="#EEEBFC" style="font-size: 12pt; color:#000000 " > <i> OFERTA DE EMPLEO </i> </td></tr><br/>
            <td valign="top" width="90%" height="500"  bgcolor="#FFFFFF" class="textocom" style="  box-shadow:  -5px 5px 5px 5px rgba(0,0,0,0.1); ">
                <table border="0">
                    <tr>
                        <td valign="top"><b>Cargo:</b></td>
                        <td><%=datosoferta.get("cargo")%></td>
                    </tr>
                    <tr>
                        <td valign="top"><b>Descripción:</b></td>
                        <td><%=datosoferta.get("descripcion")%></td>
                    </tr>
                     <tr>
                        <td valign="top"><b>Requisitos</b></td>
                        <td><%=datosoferta.get("requisitos")%></td>
                    </tr>
                    <tr>
                        <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                    <tr>
                        <td><b>País:</b></td>
                        <td><%=datosoferta.get("pais_oferta")%></td>
                    </tr>
                    <tr>
                        <td><b>Ciudad:</b></td>
                        <td><%=datosoferta.get("ciudad_oferta")%></td>
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
                        <td valign="top"><b>Programas requeridos:</b></td>
                        <td>
                            <%for(int cont=0;cont<nump;cont++){
                                programa = programas[cont];
                            %>
                            <%=programa.get("programa_requerido")%><br/>
                            <%}%>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Años de experiencia:</b> </td>
                        <td><%=datosoferta.get("años_exp")%></td>
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
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                     </tr>
                    <tr>
                        <td colspan="1" align="center"><input  class="button_rojo" type="submit" value="Eliminar" name="ActExp" onclick= "EliminarOfertaGrad(<%=idoferta%>,'<%=usuario%>');"/></td>
                        <td colspan="1" align="center"><input class="button_rojo" type="submit" onclick="window.close()" value="Cerrar"/></td>
                      
                     </tr>
                </table>
            </td>
            <%}else{%>
            <tr> <td align="center" bgcolor="#EEEBFC" style="font-size: 12pt; color:#000000 " > <i> La Oferta ha sido eliminda</i> </td></tr><br/>
            <tr> <td align="center"> <div align="center" >
                <br><input class="button_rojo" type="submit" onclick="window.close()" value="Cerrar" />
        
        </div> </td></tr><br/>
            <%}%>
        </table>
                    <%
                 /*conEjb=null;
                 System.gc();*/
                %>
    </body>
</html>

