<%--
    Document   : VerOfertaPracDec
    Created on : 4/01/2013, 09:43:31 AM
    Author     : Luis Alberto Salas
--%>
<%@page import="BDsige.DecanoRemote"%>
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
            response.setHeader("Cache-Control", "no-cache");
            
            String UA = request.getHeader("User-Agent");
            boolean isMS = (UA != null && UA.indexOf("MSIE") != -1);
            
            documentos.ruta ruta = new documentos.ruta();

            String idreq;
            String idofer;
            String idemp;
            //String paramtext = new String();
            //String titulo = new String("Servicio a Administradores");
            String error = new String();
            login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
            String rol = new String();
            String usuario = new String();
            String est = new String();
            usuario = admin.getUser();
            rol = admin.getRol();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            DecanoRemote emp = conEjb.lookupDecanoRemote();
            emp.inicializar("75107740");
            idreq = request.getParameter("idreq");
            idofer = request.getParameter("idofer");
            idemp = request.getParameter("idemp");
            session.setAttribute("emp", emp);
            HashMap DatosEmp = emp.getDatosEmpPracDec(idemp);
            HashMap DatosOfer = emp.getDatosOferPracDec(idofer);
            HashMap estado = emp.estadoRequerimiento(idreq);
            est = (String) estado.get("estado");

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG Prácticas Profesionales - Solicitud de estudiante</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunDecPrac.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>        
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            .f {
                color: #FFF;
            }
            .textoblanco {
                color: #FFF;
            }
            
            body { 
                background: url('imagenes/fondoblanco.gif');
                background-position: center;
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: 100% 100%;
                -webkit-background-size: 100% 100%;
                -moz-background-size: 100% 100%;
                -o-background-size: 100% 100%;
            }
            
            .loginPanel {
                box-shadow: 0px 4px 5px 5px rgba(0, 0, 0, 0.3);
                border: 1px solid rgb(153, 0, 0);
                border-top: 2px solid rgba(153, 0, 0, 0.5);
                border-bottom: 2px solid rgba(153, 0, 0, 0.2);
                border-left: 0px solid rgba(153, 0, 0, 0);
                border-right: 0px solid rgba(153, 0, 0, 0);
            }
            
            .curvas {
                border-radius: 20px;
                -webkit-border-radius: 20px;
                -moz-border-radius: 20px;
                background-color: #FFFFFF;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        <table width="600" height="752" align="center" class="curvas loginPanel" style="padding: 0px 25px;">
            <tr>
                <td width="950" align="center" valign="middle">
                    <table width="100%"  align="center">
                        <tr >
                            <td >&nbsp;</td>
                        </tr>
                        <tr >
                            <td colspan="2" align="center" valign="middle" class="f"><a class="textocom3">Datos de la empresa oferente</a></td>
                        </tr>
                        <tr >
                            <td >&nbsp;</td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left" width="178"><a class="textocom2">Razón Social:</a></td>
                            <td width="568" align="left"><%=DatosEmp.get("razon_social")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Direccion:</a></td>
                            <td align="left"><%=DatosEmp.get("dir_empresa")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><p><a class="textocom2">Página Web:</a></p></td>
                            <td align="left"><%=DatosEmp.get("web_empresa")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Nombre del contacto:</a></td>
                            <td align="left"><%=DatosEmp.get("nom_contacto")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Telefono de contacto:</a></td>
                            <td align="left"><%=DatosEmp.get("tel_contacto")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Email de contacto:</a></td>
                            <td align="left"><%=DatosEmp.get("email_contacto")%></td>
                        </tr>
                        <tr>
                            <td >&nbsp;</td>
                        </tr>
                        <tr>
                            <td >&nbsp;</td>
                        </tr>
                        <tr class="textocom" >
                            <td colspan="2" align="center" valign="middle" bgcolor="#000066" class="textoblanco"><strong>Práctica Ofrecida</strong></td>
                        </tr>
                        <tr>
                            <td >&nbsp;</td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Tipo Práctica:</a></td>
                            <td align="left"><%=DatosOfer.get("tiprac")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Cargo a desempeñar:</a></td>
                            <td align="left"><%=DatosOfer.get("cargo")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Descripción y funciones:</a></td>
                            <td align="left"><<%=isMS?"div":"pre"%> class="textocom" style="margin: 0px; text-align: justify; white-space: pre-wrap;"><%=DatosOfer.get("descripcion")%></<%=isMS?"div":"pre"%>></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Requisitos</a></td>
                            <td align="left"><<%=isMS?"div":"pre"%> class="textocom" style="margin: 0px; text-align: justify; white-space: pre-wrap;"><%=DatosOfer.get("requisitos")%></<%=isMS?"div":"pre"%>></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Area:</a></td>
                            <td align="left"><%=DatosOfer.get("area_oferta")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">País:</a></td>
                            <td align="left"><%=DatosOfer.get("pais_oferta")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Ciudad:</a></td>
                            <td align="left"><%=DatosOfer.get("ciudad_oferta")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Jornada:</a></td>
                            <td align="left"><%=DatosOfer.get("horario_oferta")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Tipo de Contrato:</a></td>
                            <td align="left"><%=DatosOfer.get("tipo_contrato")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Apoyo Económico(COL$):</a></td>
                            <td align="left"><%=DatosOfer.get("salario_oferta")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left" height="49"><a class="textocom2">Salud y Riesgos Profesionales </a></td>
                            <td align="left"><%=DatosOfer.get("seguro_arp")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left" height="23"><a class="textocom2">Fecha de inicio:</a></td>
                            <td align="left"><%=DatosOfer.get("fecha_in")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left" height="27"><a class="textocom2">Fecha de Finalización: </a></td>
                            <td align="left"><%=DatosOfer.get("fecha_out")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left" height="28"><p><a class="textocom2">Nombre del Supervisor o Jefe:</a></p></td>
                            <td align="left"><%=DatosOfer.get("nom_jefe")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left" height="27"><a class="textocom2">Cargo:</a></td>
                            <td align="left"><%=DatosOfer.get("cargo_jefe")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left" height="27"><a class="textocom2">Telefono:</a></td>
                            <td align="left"><%=DatosOfer.get("tel_jefe")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left" height="27"><a class="textocom2">Email:</a></td>
                            <td align="left"><%=DatosOfer.get("email_jefe")%></td>
                        </tr>
                        <tr >
                                <td >&nbsp;</td>
                            </tr>
                            <tr >
                                <td >&nbsp;</td>
                            </tr>
                        <tr class="textocom">
                            <td colspan="2" align="center" valign="middle" bgcolor="#000066" class="textoblanco"><strong>Información Adicional</strong></td>
                        </tr>
                        <tr >
                                <td >&nbsp;</td>
                            </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Fecha de publicación:</a></td>
                            <td align="left"><%=DatosOfer.get("fecha_publicacion")%></td>
                        </tr>
                        <tr class="textocom" >
                            <td align="left"><a class="textocom2">Fecha de vencimiento:</a></td>
                            <td align="left"><%=DatosOfer.get("fecha_limite")%></td>
                        </tr>
                        <tr class="textocom">
                            <td border="1" class="textocom2" height="89" align="center" valign="middle"><a class="textocom2">La Práctica tiene validez académica y puede ser publicada</a></td>
                            <% if (est.equals("a         ")) {
                            %>
                            <td class="textocom2" >
                                <br/><p> Comentarios sobre la oferta: &nbsp;
                                    <textarea name="comentarioDecOferPrac" id="comentarioDecOferPrac" rows="10" cols="38" ></textarea></p>
                                <input type="submit" value="Aprobar y Publicar" name="vobocarta" onclick= "AprobarOferprac(<%=idreq%>);"/>
                                <input type="submit" value="Devolver oferta a la empresa" name="vobocarta" onclick= "RechazarOferprac(<%=idreq%>);"/>  </td>
                                <%} else {%>
                            <td class="textocom2" >
                                <br/><p> Comentarios sobre la oferta: &nbsp;
                                    <textarea name="comentarioDecOferPrac" id="comentarioDecOferPrac" rows="10" cols="38" disabled > <%=estado.get("comen_dec")%></textarea></p>
                                <input class="button_azul_consulta" type="submit" value="Salir" name="vobocarta" onclick= "window.close();"/>
                            </td>
                            <%}%>
                        </tr>
                        <tr class="textocom2" >
                            <td align="left"><a class="textocom2">Estado de la oferta</a></td>
                            <td align="left"><%=estado.get("men_oferprac")%></td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2">
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
    </body>
</html>
