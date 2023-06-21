<%-- 
    Document   : solicitarDoc
    Created on : 15/05/2014, 11:03:57 AM
    Author     : Luis Salas
--%>

<%@page import="BDsige.EstudiantesRemote"%>
<%@page import="BDsige.DecanoRemote"%>
<%@page import="BDsige.EmpleadoRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;"%>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject;"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            response.setHeader("Cache-Control", "no-cache");
            
            documentos.ruta ruta = new documentos.ruta();
            
            String usuario = new String();
            
            login.SessionEmpRemote empresa = (login.SessionEmpRemote) session.getAttribute("usuario");
            
            if (empresa == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'loingempresa';
                    </script>
                <%
                return;
            }
            
            usuario = empresa.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            
            int msgId = (request.getParameter("msg") != null?Integer.parseInt(request.getParameter("msg")):0);
            
            String message = "";
            
            if (msgId == -1) {
                message = "Todos los archivos a cargar deben ser de tipo PDF.";
            } else if (msgId == -2) {
                message = "El peso de los archivos debe ser inferior a 15 MB.";
            }  else if (msgId == -3) {
                message = "No ha escogido ningun documento para cargar.";
            }
            
            String redir = request.getParameter("redir");
        %>
        <title>SIEMPREG - Cargue su documento</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/funcionemp.js" ></script>
        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
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
            
            .message {
                box-sizing: border-box;
                background: #FFF1B3;
                border: 1px solid #E6DFBA;
                border-radius: 10px;
                padding: 10px 30px;
                color: #000000;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="emp" />
        </jsp:include>
        <table width="640" class="curvas loginPanel" cellspacing="10" style="margin: 0px auto;">
            <tr style="height: 1em;"></tr>
            <%
                if (msgId != 0 && !message.equals("")) {
            %>
            <tr style="height: 1em;">
                <td class="textocom"><div class="message"><%=message%></div></td>
            </tr>
            <%
                }
            %>
            <tr>
                <td class="textocom" style="text-align: justify;">
                    Apreciado empresario, agradecemos su interés en contar con graduados de la Escuela Colombiana de Ingeniería Julio Garavito a través del sistema SIEMPREG, enmarcado bajo el Reglamento de Prestación de Servicios de Bolsa de Empleo.
                    <br>
                    <br> 
                    Para publicar una vacante, es de suma importancia que según el reglamento de prestación de servicios de bolsa de empleo en el parágrafo 
                    <a href="http://practicas.escuelaing.edu.co/contenido/osiris/graduados/REGLAMENTOBOLSAEMPLEO.pdf" target="_blank">Responsabilidades de la Escuela</a>, se realice una verificación de la vigencia 
                    legal de los demandantes; 
                    para esto le solicitamos que anexe los documentos requeridos de acuerdo a la siguiente clasificación:
                    <br>
                    <br>
                    •	<span style="text-decoration: underline;">Persona Jurídica:</span> Certificado de Existencia y representación legal expedido por la Cámara de Comercio (con una expedición no superior a 60 días) y el RUT correspondiente.<br><br>
                    •	<span style="text-decoration: underline;">Persona Natural:</span> Cédula de ciudadanía o cualquier otro documento que permita establecer la veracidad de la información suministrada.
                </td>
            </tr>
            <tr style="height: 1em;"></tr>
            <tr>
                <td class="textocom" style="font-size: 0.9em;">Ingrese los documentos:</td>
            </tr>
            <tr>
                <td class="textocom">
                    <form name="CargarDoc" action="CargarDoc" method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="nit" value="<%=usuario%>">
                        <input type="hidden" name="redir" value="<%=(redir != null?"y":"n")%>">
                        <table style="width: 100%;">
                            <tr>
                                <td style="width: 25%;">RUT / Documento:</td>
                                <td style="width: 75%;">
                                    <input type="file" name="Rut" accept="application/pdf" class="inputlargo" style="width: 100%; font-size: 1em;">
                                </td>
                            </tr>
                            <tr>
                                <td>Cámara de Comercio:</td>
                                <td>
                                    <input type="file" name="Cam" accept="application/pdf" class="inputlargo" style="width: 100%; font-size: 1em;">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: center; padding-top: 15px; font-size: 10px; color: #757575;">
                                    El sistema admite documentos solo en formato PDF, y con un peso menor a 15MB.
                                </td>
                            </tr>
                        </table>
                        <input type="submit" id="subFor1" value="Enviar PDF" style="display: block; height: 25px; font-size: 1em; margin: 20px auto 0px auto;">
                        <%
                            if (redir == null) {
                        %>
                        <input type="button" id="" value="Volver" style="display: block; height: 25px; font-size: 1em; margin: 5px auto;" onclick="location = 'ActualizarInfoEmp';">
                        <%
                            }
                        %>
                    </form>
                </td>
            </tr>
            <tr style="height: 1em;"></tr>
            <tr>
                <td align="center" colspan="2" class="textocom" style="font-size: 9px;">
                    Al enviar el documento declaro que he leído y acepto los términos y condiciones expresadas por la Escuela Colombiana de Ingeniería Julio Garavito para el uso del sistema SIEMPREG 
                    y la bolsa de empleos expresadas en el siguiente <a href="http://practicas.escuelaing.edu.co/contenido/osiris/graduados/REGLAMENTOBOLSAEMPLEO.pdf" target="_blank">REGLAMENTO</a>.
                    <br>
                </td>
            </tr>
            <tr style="height: 1em;"></tr>
        </table>
    </body>
</html>
