<%-- 
    Document   : loingestMov
    Created on : 9/10/2012, 12:07:47 PM
    Author     : Luis Alberto Salas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Ingreso Estudiantes</title>
        <link href="CSS/login.css" rel="stylesheet" type="text/css">
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
       
        <table width="772" class="curvas" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-bottom: 32px">
            <tr>
                <td align="center" style="padding: 5px;">
                    <img name="encabezado_emp" src="imagenes/header_admin.jpg" class="curvas" border="0" alt="">
                </td>
            </tr>
        </table><form id="login" action="LoginEst" method="post">
        <table width="450" align="center" class="curvas loginPanel" cellspacing="10">
            <tr style="height: 64px;">
                <td colspan="2" align="center" height="30">
                    <a class="titulocom" style="color: #000046;">Ingreso Estudiantes</a>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2" class="textocom">(El estudiante debe autenticarse con el correo electrónico institucional.)</td>
            </tr>
            <tr>
                <td align="right" width="35%" class="textocom">Usuario:</td>
                <td align="left" width="65%"><input readonly type="text" name="usuario" id="usuario" value="${userInfo.displayableId}" /></td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>               
                <td colspan="2" align="center" class="textocom">Por favor seleccione el sistema al que desea ingresar:</td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <select name="sistemaest" id="sistemaest" class="textocom" class="textocom2">
                        <option value="practicas">Sistema de Prácticas</option>
                        <option value="movilidad">Sistema de Movilidad</option>
                    </select>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>
               <td colspan="2" align="center">
                   <input id="btnLogIn" class="button_azul" type="submit" value="Conectar" />
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
            </form>
    </body>
</html>
