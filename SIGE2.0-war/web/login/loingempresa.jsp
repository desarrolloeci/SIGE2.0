<%-- 
    Document   : loingempresa
    Created on : 11/10/2012, 12:01:13 PM
    Author     : Luis Alberto Salas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%
            HttpSession sesion;
            sesion = request.getSession(false);
            if (sesion != null) {
                sesion.invalidate();
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Ingreso Empresas</title>
        <link href="CSS/login.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" language="javascript">
            var http_request = false;
            
            var btnLogIn;
            var txtUsr;
            var txtPsw;
            
            window.onload = function() {
                btnLogIn = document.getElementById('btnLogIn');
                txtUsr = document.getElementById('usuario');
                txtPsw = document.getElementById('clave');
                txtUsr.focus();
            }
            
            function checkEnter(e) {
                if (e.keyCode==13) {
                    makeRequest('LoginEmpresa?');
                }
            }
            
            function makeRequest(url) {
                
                var usr = document.getElementById("usuario").value;
                
                if (/[^\d]/g.test(usr)) {
                    alert("El usuario ingresado debe ser un NIT y no debe contener caracteres. Por favor ingrese un valor numérico.\n");
                    return;
                }
                
                http_request = false;

                if (window.XMLHttpRequest) {// Mozilla, Safari,...
                    http_request = new XMLHttpRequest();
                    if (http_request.overrideMimeType) {
                        http_request.overrideMimeType('text/xml');
                    }
                } else if (window.ActiveXObject) { // IE
                    try {
                        http_request = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e) {
                        try {
                            http_request = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e) {}
                    }
                }

                if (!http_request) {
                    alert('Giving up :( Cannot create an XMLHTTP instance)');
                    return false;
                }
                
                btnLogIn.disabled = true;
                txtUsr.disabled = true;
                txtPsw.disabled = true;
                btnLogIn.value = 'Conectando...';
                btnLogIn.className = 'button_disabled';
                
                url = url + "usuario=" + usr + "&clave=" + encodeURIComponent(document.getElementById("clave").value);
                //alert(url);
                http_request.onreadystatechange = alertContents;
                http_request.open('POST', url, true);
                http_request.send(null);

            }

            function alertContents() {

                if (http_request.readyState != 4) return;
                    
                btnLogIn.disabled = false;
                txtUsr.disabled = false;
                txtPsw.disabled = false;
                btnLogIn.value = 'Conectar';
                btnLogIn.className = 'button_azul';
                
                if (http_request.status != 200) {
                    alert('Ha ocurrido un error al intentar ingresar al sistema. Por favor intentelo de nuevo.');
                    return;
                }

                var xmldoc = http_request.responseXML;
                var root_node = xmldoc.getElementsByTagName('root').item(0);
                if (root_node.firstChild.data != "OK1") {
                    if (root_node.firstChild.data != "OK2") {
                        alert(root_node.firstChild.data);
                    } else {
                         window.location="MenuEmpContactos";
                    }
                } else {
                    window.location="MenuEmpresa";
                }
            }
        </script>
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
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="emp" />
        </jsp:include>
        <table width="450" align="center" class="curvas loginPanel" cellspacing="10">
            <tr style="height: 64px;">
                <td colspan="3" align="center" height="30">
                    <a class="titulocom">Ingreso Empresas</a><br>
                </td>
            </tr>
            <tr>
                <td align="left" width="4%" class="textocom">Usuario:</td>
                <td align="left" width="30%"><input type="text" name="usuario" id="usuario" value="" /></td>
                <td align="justify" width="66%" class="textocom" style="font-size: 11px;">Recuerde que el usuario es el NIT de la empresa, sin puntos, incluido el dígito de verificación sin el guión.</td>
            </tr>
            <tr>               
                <td align="left" width="4%" class="textocom">Clave:</td>
                <td align="left" width="30%"><input type="password" name="clave" id="clave" value="" onkeydown="checkEnter(event);" /></td>
                <td align="left" width="66%"></td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>            
                <td colspan="3" align="center" class="textocom">
                    <input id="btnLogIn" class="button_azul" type="submit" onclick="makeRequest('LoginEmpresa?');" value="Conectar" />
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center"><br> <a class="href_rojo1"href="RegistrarEmp">Registre su empresa AQUI</a><br></td>
            </tr>
            <tr>
                <td colspan="3" align="center" class="textocom">Si presenta inquietudes o inconvenientes con el ingreso al sistema, por favor comuníquese a la Unidad de Gestión Externa al teléfono 6683600 ext. 312 <br><br> <u>Correo Electronico:</u> <br><br> Prácticas Profesionales:<a href="mailto:practicas@escuelaing.edu.co">practicas@escuelaing.edu.co</a><br> Graduados:<a href="mailto:graduados@escuelaing.edu.co">graduados@escuelaing.edu.co</a></td><br>
            </tr>
            <tr>
                <td colspan="3" align="center" class="textocom"><strong>¡Estamos para servirle!</strong></td>
            </tr>
            <tr>
                <td colspan="3" align="center">                             
                    <jsp:include page="footer">
                        <jsp:param name="type" value="general" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
</html>

