<%-- 
    Document   : TramitarOfertaAdminGrad
    Created on : 19/08/2014, 03:20:32 PM
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

        <link href="CSS/graduados.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_grad"></jsp:include>
        <div align="center">
                <fieldset class="field_set">
        <table width="700"  align="center" border="0"  cellspacing="0" bordercolor="#EEEBFC">
            <tr> <td colspan="3" align="center">&nbsp;</td></tr>
            <tr> <td colspan="3" align="center"><a class="textocom3"> TRAMITAR OFERTA DE EMPLEO</a> </td></tr>
            <tr>
                <td colspan="3"valign="top" width="100%">
                <table border="0" width="100%">                    
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td valign="top" width="20%" align="left"><a class="textocom2">Oferta Publicable:</a></td>
                    <%String publica="N/A"; if(datosoferta.get("excepcionpub").equals("N")){publica="NO";} else{publica="SI";}%>
                        <td width="80%" align="left"><a class="textocom"><%=publica%></a></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td valign="top" width="20%" align="left"><a class="textocom2">Cargo:</a></td>
                        <td width="80%" align="left"><a class="textocom"><%=datosoferta.get("cargo")%></a></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td valign="top" width="10%" align="left"><a class="textocom2">Descripción:</a></td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("descripcion")%></a></td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td valign="top" width="10%" align="left"><a class="textocom2">Requisitos</a></td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("requisitos")%></a></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td valign="top" width="10%" align="left"><a class="textocom2">Idiomas requeridos:</a></td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("idiomas")%></a></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td width="10%" align="left"><a class="textocom2">País:</a></td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("pais_oferta")%></a></td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td width="10%" align="left"><a class="textocom2">Ciudad:</a></td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("ciudad_oferta")%></a></td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td width="10%" align="left"><a class="textocom2">Sector:</a></td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("area_oferta")%></a></td>
                    </tr>
                      <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td width="10%" align="left"><a class="textocom2">Fecha de publicación:</a></td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("fecha_publicacion")%></a></td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td width="10%" align="left"><a class="textocom2">Fecha de vencimiento:</b> </td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("fecha_limite")%></a></td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td width="10%" valign="top" align="left"><a class="textocom2">Programas requeridos:</a></td>
                        <td width="90%" align="left"><a class="textocom">
                            <%for(int cont=0;cont<nump;cont++){
                                programa = programas[cont];
                            %>
                            <%=programa.get("programa_requerido")%><br/>
                            <%}%>
                        </a></td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td width="10%" align="left"><a class="textocom2">Años de experiencia:</a> </td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("años_exp")%></a></td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left"><a class="textocom2">Jornada:</a></td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("horario_oferta")%></a></td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td width="10%" align="left"><a class="textocom2">Tipo de contrato:</a></td>
                        <td width="90%" align="left"><a class="textocom"><%=datosoferta.get("tipo_contrato")%></a></td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                    <tr>
                        <td width="10%" valign="top" align="left"><a class="textocom2">Salario:</a></td>
                        <td width="90%" align="left"><a class="textocom">entre <%=datosoferta.get("salario_oferta")%> de pesos</a></td>
                    </tr>
                      <tr>
                        <td colspan="2">&nbsp;</td>                        
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>
                        
                     </tr>
                    
                </table>
                    
                    
                    <%if(usuario.equals("graduados")){%>
                      <center> <a href="/SIGE2.0-war/VerOfertaEmpAdminG?idofer=<%=idoferta%>">Editar Oferta</a> </center>
                      <br>
                    <%}%>
            </td>
            </tr>
            <%if(datosoferta.get("estado").equals("k")){%>
            
            <tr> <td align="center"><input  class="button_rojo" type="submit" value="Aprobar" name="ActExp" onclick= "TramitarOfertaGrad(<%=idoferta%>,'<%=usuario%>','aprobar');"/> </td>
            <td align="center"><input class="button_rojo" type="submit" onclick="window.close()" value="Cerrar" /></td>
            <td align="center"><input  class="button_rojo" type="submit" value="Rechazar" name="ActExp" onclick= "TramitarOfertaGrad(<%=idoferta%>,'<%=usuario%>','rechazar');"/> </td></tr>
            <%}else{%>
            <tr> <td colspan="3"><a class="textocom2">Esta oferta ya ha sido tramitada su estado actual es: <%if(datosoferta.get("estado").equals("a")){%> Aprobada <%}else{%> Rechazada <%}%></a></td>
            </tr>
            <tr>
                        <td colspan="3">&nbsp;</td>
                        
                     </tr>
                    
            <tr>
            <td align="center" colspan="3"><input class="button_rojo" type="submit" onclick="window.close()" value="Cerrar" /></td>
            </tr>
            
            <%}%>
            <tr>
                        <td colspan="3">
                            <br> 
                            <br> 
                            <div align="center" class="footer">
                                <p>Escuela Colombiana de Ingenier&iacute;a Julio Garavito</p>
                                <p>AK.45 No.205-59 (Autopista Norte)<br>
                                    PBX: +57(1) 668 3600 / Call center: 57(1) 668 3622 / L&iacute;nea Nacional Gratuita: 018000112668<br>
                                    www.escuelaing.edu.co</p>
                                <p>Bogot&aacute;, D.C. - Colombia</p>
                            </div>
                        </td>
                    </tr>
        </table>
                </fieldset>
        </div>
                    <%
                 /*conEjb=null;
                 System.gc();*/
                %>
    </body>
</html>

