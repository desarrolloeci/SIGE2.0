<%-- 
    Document   : loginAdmin
    Created on : 23/10/2012, 10:47:34 AM
    Author     : Luis Alberto Salas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Ingreso Administradores</title>
        <link href="CSS/login.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" language="javascript">
            var http_request = false;
            
            var btnLogIn;
            var txtUsr;
            var txtPsw;
            var selectSystem;
            
            window.onload = function() {
                btnLogIn = document.getElementById('btnLogIn');
                txtUsr = document.getElementById('usuario');
                txtPsw = document.getElementById('clave');
                selectSystem = document.getElementById('sistemaadmin');
                txtUsr.focus();
            }
            
            function checkSelection() {
                var userVal = document.getElementById('usuario').value.substr(0,3);
                var selOpt = document.getElementById('sistemaadmin').options;
                if (userVal == 'ori') {
                    selOpt[0].selected = true;
                } else if (userVal == 'pra') {
                    selOpt[1].selected = true;
                } else {
                    selOpt[2].selected = true;
                }
            }
            
            function checkEnter(e) {
                if (e.keyCode==13) {
                    makeRequest('LoginSige?');
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
                    alert('Giving up :( Cannot create an XMLHTTP instance)');
                    return false;
                }
                
                btnLogIn.disabled = true;
                txtUsr.disabled = true;
                txtPsw.disabled = true;
                selectSystem.disabled = true;
                btnLogIn.value = 'Conectando...';
                btnLogIn.className = 'button_disabled';
                
                url = url + "usuario=" + document.getElementById("usuario").value + "&clave=" + encodeURIComponent(document.getElementById("clave").value)+"&tipo=Admin&sistema="+document.getElementById("sistemaadmin").value;
                
                http_request.onreadystatechange = alertContents;
                http_request.open('POST', url, true);
                http_request.send(null);

            }

            function alertContents() {

                if (http_request.readyState != 4) return;
                
                btnLogIn.disabled = false;
                txtUsr.disabled = false;
                txtPsw.disabled = false;
                selectSystem.disabled = false;
                btnLogIn.value = 'Conectar';
                btnLogIn.className = 'button_rojo';
                
                if (http_request.status != 200) {
                    alert('Ha ocurrido un error al intentar ingresar al sistema. Por favor intentelo de nuevo.');
                    return;
                }
                
                var xmldoc = http_request.responseXML;
                var root_node = xmldoc.getElementsByTagName('root').item(0);
                if (root_node.firstChild.data != "OK") {
                    if (root_node.firstChild.data == "MonGrad") {
                       window.location = "MenuMonitor";
                    } else {
                        alert(root_node.firstChild.data);
                    }
                } else {
                    if (document.getElementById("sistemaadmin").value=="movilidad") {
                        window.location ="AdminMov";
                    } else {
                        if (document.getElementById("sistemaadmin").value=="practicas") {
                            window.location ="AdminPrac";
                        } else {
                            window.location ="AdminGrad";
                        }
                    }
                }
            }
        </script>
        <style type="text/css"> 
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
            <jsp:param name="type" value="admin" />
        </jsp:include>
        <table width="450" align="center" class="curvas loginPanel" cellspacing="10">
            <tr style="height: 64px;">
                <td colspan="2" align="center" height="30">
                    <a class="titulocom">Ingreso Administradores</a>
                </td>
            </tr>
            <tr>
                <td align="right" width="35%" class="textocom">Usuario:</td>
                <td align="left" width="65%"><input type="text" name="usuario" id="usuario" value="" onkeyup="checkSelection();"/></td>
            </tr>
            <tr>               
                <td align="right" width="35%" class="textocom">Clave:</td>
                <td align="left" width="65%"><input type="password" name="clave" id="clave" value="" maxlength="50" onkeydown="checkEnter(event);" /></td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>
                <td colspan="2" align="center" class="textocom">Por favor seleccione el sistema al que desea ingresar:</td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <select name="sistemaadmin" id="sistemaadmin" class="textocom2">
                        <option value="movilidad">Sistema de Movilidad</option>
                        <option value="practicas">Sistema de Prácticas</option>
                        <option value="graduados">Sistema de Graduados</option>
                    </select>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>
                <td colspan="2" align="center">
                    <input id="btnLogIn" class="button_rojo" type="submit" onclick="makeRequest('LoginSige?');" value="Conectar" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">                             
                    <jsp:include page="footer">
                        <jsp:param name="type" value="general" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
</html>
