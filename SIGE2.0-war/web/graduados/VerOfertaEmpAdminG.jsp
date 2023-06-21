<%-- 
    Document   : VerOfertaEmpAdminG
    Created on : 20/11/2012, 11:55:05 AM
    Author     : Luis Alberto Salas
--%>


<%@page import="BDsige.EmpresaRemote"%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
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
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>

        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
    </head>
    <body background="imagenes/fondo.gif" >
        <p class="textocom">&nbsp;</p>
        <table width="450"  align="center" border="1"  cellspacing="0" bordercolor="#EEEBFC">
            <tr> <td align="center" bgcolor="#EEEBFC" style="font-size: 12pt; color:#000000 " > <i> OFERTA DE EMPLEO </i> </td></tr><br/>
            <td valign="top" width="90%" height="500"  bgcolor="#FFFFFF" class="textocom" style="  box-shadow:  -5px 5px 5px 5px rgba(0,0,0,0.1); ">
                <form action="ActualizaOferta" method="Post" id="form_act_of">
                <table border="1">
                    <tr>
                        <td valign="top"><b>Cargo:</b></td>
                        <td><input type="text" name="cargo" value="<%=datosoferta.get("cargo")%>" Style="width: 400px;"></td>
                    </tr>
                    <tr>
                        <td valign="top"><b>Descripción:</b></td>
                        <td><textarea name="desc" Style="width: 400px; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 11px; background-color: #EEEBFC;"><%=datosoferta.get("descripcion")%></textarea></td>
                    </tr>
                    <tr>
                        <td valign="top"><b>Requisitos</b></td>
                        <td><textarea name="requis" Style="width: 400px; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 11px; background-color: #EEEBFC;"><%=datosoferta.get("requisitos")%></textarea></td>
                    </tr>
                    <tr>
                        <td valign="top"><b>Idiomas requeridos:</b></td>
                        <td><input type="text" name="idiomas" value="<%=datosoferta.get("idiomas")%>" Style="width: 400px;"></td>
                    </tr>
                    <tr>
                        <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                    <tr>
                        <td><b>País:</b></td>
                        <td><input type="text" name="pais" value="<%=datosoferta.get("pais_oferta")%>" Style="width: 400px;"></td>
                    </tr>
                    <tr>
                        <td><b>Ciudad:</b></td>
                        <td><input type="text" name="ciudad" value="<%=datosoferta.get("ciudad_oferta")%>" Style="width: 400px;"></td>
                    </tr>
                    <tr>
                        <td><b>Sector:</b></td>
                        <td><input type="text" name="area" value="<%=datosoferta.get("area_oferta")%>" Style="width: 400px;"></td>
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
                        <td><input type="hidden" name="idoferta" value="<%=idoferta%>">&nbsp;</td>
                        <td><div align="center"><% if(usuario.equals("graduados")) { %><button>Actualizar Oferta</button>&nbsp;<%}%></div></td>
                     </tr>
                </table>
               </form>
            </td>
        </table>
                    <%
                 /*conEjb=null;
                 System.gc();*/
                %>
    </body>
</html>
