<%-- 
    Document   : logingraduado
    Created on : 8/10/2012, 12:42:01 PM
    Author     : Luis Alberto Salas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
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
        <title>SIEMPREG - Ingreso Graduados</title>
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
                if (e.keyCode == 13) {
                    makeRequest('LoginGrad?');
                }
            }
            
            function makeRequest(url) {
                http_request = false;

                if (window.XMLHttpRequest) { // Mozilla, Safari,...
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
                    alert('Giving up :( Cannot create an XMLHTTP instance');
                    return false;
                }
                
                btnLogIn.disabled = true;
                txtUsr.disabled = true;
                txtPsw.disabled = true;
                btnLogIn.value = 'Conectando...';
                btnLogIn.className = 'button_disabled';
                
                url = url + "usuario=" + document.getElementById("usuario").value + "&clave=" + encodeURIComponent(document.getElementById("clave").value);
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
                if (root_node.firstChild.data != "OK") {
                    if (root_node.firstChild.data == "Falta Politica de Datos") {
                        var answer = confirm("Lea las politicas http://practicas.escuelaing.edu.co/contenido/osiris/graduados/REGLAMENTOBOLSAEMPLEO.pdf");                                
                        if (answer) {
                            window.location = "Menugraduado";
                        } else {
                            window.closed;   
                        }
                    } else {
                        alert(root_node.firstChild.data);
                    }
                } else {
                    window.location = " Menugraduado";
                }
            }
        </script>
        <style type="text/css"> 
            body { 
                background: url('imagenes/fondo graduados.jpg');
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
                border: 1px solid rgb(0, 0, 70);
                border-top: 2px solid rgba(0, 0, 70, 0.5);
                border-bottom: 2px solid rgba(0, 0, 70, 0.2);
                border-left: 0px solid rgba(0, 0, 70, 0);
                border-right: 0px solid rgba(0, 0, 70, 0);
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
            <jsp:param name="type" value="grad" />
        </jsp:include>
        <table width="450" align="center" class="curvas loginPanel" cellspacing="10">
            <tr style="height: 64px;">
                <td colspan="3" style="text-align: center;">
                    <a class="titulocom" style="color: #000046;">Ingreso Graduados</a>
                </td>
            </tr>
            <tr>
                <td align="left" width="4%" class="textocom">Usuario:</td>
                <td align="left" width="30%"><input type="text" name="usuario" id="usuario" value="" /></td>
                <td align="left" width="66%" class="textocom">(Es su número de identificación)</td>
            </tr>
            <tr>               
                <td align="left" width="4%" class="textocom">Clave:</td>
                <td align="left" width="30%"><input type="password" name="clave" id="clave" value="" onkeydown="checkEnter(event);" /></td>
                <td align="left" width="66%" class="textocom">(Inicialmente, su número de identificación)</td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>            
                <td colspan="3" align="center" class="textocom">
                    <input id="btnLogIn" class="button_azul" type="submit" onclick="makeRequest('LoginGrad?');" value="Conectar" />
                    <br><br><br>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center" class="textocom">Si se le presenta algún inconveniente con el ingreso al sistema u olvidó su contraseña, por favor comuníquese a la Oficina de Graduados al teléfono 6683600 ext. 120 o al correo electrónico <a href="mailto:graduados@escuelaing.edu.co">graduados@escuelaing.edu.co.</a></td>
            </tr>
            <tr>
                <td colspan="3" align="center" class="textocom">¡Recuerde que estamos para servirle!<br><br> * Bolsa de empleo autorizada y regulada por el Ministerio de Trabajo mediante resolución No. 478 de 2016.<br></td>
            </tr>
            <tr>
                <td colspan="3" align="center">                             
                    <jsp:include page="footer">
                        <jsp:param name="type" value="grad" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
</html>
