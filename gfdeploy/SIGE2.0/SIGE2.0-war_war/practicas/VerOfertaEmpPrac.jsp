<%-- 
    Document   : VerOfertaEmpPrac
    Created on : 21/01/2013, 10:31:24 AM
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

            String UA = request.getHeader("User-Agent");
            boolean isMS = (UA != null && UA.indexOf("MSIE") != -1);

            documentos.ruta ruta = new documentos.ruta();

            String usuario = new String ();
            String idoferta = new String ();
            //usuario=nit
            login.SessionEmpRemote empresa =(login.SessionEmpRemote)session.getAttribute("usuario");

            //Verificamos que la sesión esté activa
            if (empresa == null) {
                %><script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.close();
                </script><%
                return;
            }

            usuario=empresa.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp",emp);
            String  error = new String();
            idoferta = request.getParameter("idofer");
            HashMap datosoferta= emp. getDatosOfertaPracEmp(idoferta);
            HashMap[] programas=emp.getProgramasPracEmp (idoferta);
        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Detalles de la oferta</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>

        <link href="CSS/empresas.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            body {
                background:url('imagenes/fondo empresas.jpg');
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
            
            .panelSubTitulo {
                width: 100%;
                border-top-left-radius: 20px;
                border-top-right-radius: 20px;
                border-bottom-left-radius: 5px;
                border-bottom-right-radius: 5px;
                color: #FFFFFF;
                background: rgb(153, 0, 0);
            }
            
            .panelSubMenu {
                width: 100%;
                height: 19px;
                border-radius: 20px;
                border: 1px solid rgb(153, 0, 0);
                color: rgb(153, 0, 0);
                background: #FFFFFF;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="emp" />
        </jsp:include>
        <table width="450" align="center" class="curvas loginPanel" cellspacing="10">
            <tr> <td align="center"> <a class="textocom3">Oferta de Práctica</a> </td></tr><br/>
             <tr> <td align="center">&nbsp; </td></tr><br/>
            <td align="left" valign="top" width="90%" height="500"  bgcolor="#FFFFFF" class="textocom" style="  box-shadow:  -5px 5px 5px 5px rgba(0,0,0,0.1); ">
                <table class="ofertStyle">
                    <tr>
                        <td><b>Tipo Práctica:</b></td>
                        <td><%=datosoferta.get("tiprac")%></td>
                    </tr>
                    <tr>
                        <td><b>Cargo:</b></td>
                        <td><%=datosoferta.get("cargo")%></td>
                    </tr>
                    <tr>
                        <td><b>Descripción y funciones:</b></td>
                        <td><<%=isMS?"div":"pre"%> class="textocom" style="margin: 0px; text-align: justify; white-space: pre-wrap"><%=datosoferta.get("descripcion")%></<%=isMS?"div":"pre"%>></td>
                    </tr>
                     <tr>
                        <td><b>Requisitos</b></td>
                        <td><<%=isMS?"div":"pre"%> class="textocom" style="margin: 0px; text-align: justify; white-space: pre-wrap"><%=datosoferta.get("requisitos")%></<%=isMS?"div":"pre"%>></td>
                    </tr>
                    <tr>
                        <td colspan="2">___________________________________________________________________________________________________</td>
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
                         <td colspan="2">___________________________________________________________________________________________________</td>
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
                        <td><b>Programas requeridos:</b></td>
                        <td>
                            <%
                            for(HashMap programa: programas) {
                            %>
                                <%=programa.get("programa_requerido")%> (<%=programa.get("men_oferprac")%>)<br>
                            <%
                            }
                            %>
                        </td>
                    </tr>                   
                     <tr>
                        <td colspan="2">___________________________________________________________________________________________________</td>
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
                        <td><b>Salario:</b></td>
                        <td><%=datosoferta.get("salario_oferta")%> CO$</td>
                    </tr>
                     <tr>
                         <td colspan="2">___________________________________________________________________________________________________</td>
                    </tr>
                     <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                     </tr>
                    <tr>
                        <td colspan =2"">
                            <div align="center">
                                <br>
                                <input class="button_azul1" type="submit" onclick="window.close()" value="Cerrar" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <jsp:include page="footer">
                                <jsp:param name="type" value="prac" />
                            </jsp:include>
                        </td>
                    </tr>
                </table>
            </td>
        </table>
    </body>
</html>
