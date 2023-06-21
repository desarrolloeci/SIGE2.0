<%-- 
    Document   : RegistrarEmp
    Created on : 11/10/2012, 02:36:23 PM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EstudiantesRemote"%>
<%@page import="BDsige.DecanoRemote"%>
<%@page import="BDsige.EmpleadoRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,
         javax.rmi.PortableRemoteObject"
         %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
    <%
        response.setHeader("Cache-Control","no-cache");
    %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Registro Empresa</title>
        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/funcionemp.js" ></script>  
        <style type="text/css">
            body {
                background:url('imagenes/fondo empresas.jpg');
                background-position : center; 
                background-repeat : no-repeat; 
                background-attachment : fixed;
                background-size: 100% 100%;
                -webkit-background-size: 100% 100%;
                -moz-background-size: 100% 100%;
                -o-background-size: 100% 100%;
            }
            
            .loginPanel {
                box-shadow: 0px 4px 5px 5px rgba(0,0,0,0.3);
                border-top: 2px solid rgba(153,0,0,0.5);
                border-bottom: 2px solid rgba(153,0,0,0.2);
            }
            
            .curvas {
                border-radius: 20px;
                -webkit-border-radius: 20px;
                -moz-border-radius: 20px;
                background-color: #FFFFFF;
            }
        </style>
    </head>
    <body background="imagenes/fondo empresas.jpg" >
        <table width="772" class="curvas" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-bottom: 30px">
            <tr>
                <td colspan="3" align="center" style="padding: 5px;">
                    <img name="encabezado_emp" src="imagenes/encabezado - empresas.jpg" class="curvas" border="0" alt="">
                </td>
            </tr>
        </table>
        <table width="640" align="center" class="textocom curvas loginPanel" cellspacing="10">
            <tr>
                <td colspan="3" align="center" height="30" font-family="Sans Serif">
                    <a class="titulocom">Registro de Empresa</a>
                </td>        
            </tr>
            <tr>
                <td class="textocom">Ingrese el ID de su empresa (NIT, Cedula, Pasaporte, RUT):</td>
                <td  align="center">
                    <input class="inputmediano" name="nit" id="nit" type="text" size="20" maxlength="25">
                </td>
                <td  align="left" class="textocom" style="font-size: 9px;">
                  Sin puntos, NO INCLUYA EL DIGITO DE VERIFICACION.<br>Ej: 860034811-3 -> 860034811
                </td>
            </tr>            
            <tr>
                            <td colspan="3">
                                <table  width="100%" bordercolor='#CCCCFF' frame="hsides"    >
                                    <tr>
                                        <td width="5%" align="center" bgcolor="#f7f7f7" >
                                           
                                        </td>
                                        <td width="95%" align="left" bgcolor="f7f7f7">Información Importante.</td>
                                    </tr>
                                </table>
                            </td>

                    </tr>
                     <tr>
                         <td align="justify" colspan="3">
                             <FONT SIZE=2>Dando cumplimiento a lo estipulado en la Ley 1581 de 2012 y lo previsto en el artículo 7 del Decreto 1377 de 2013, la Escuela Colombiana de Ingeniería Julio Garavito informa que los datos suministrados por Usted en el presente y siguiente formulario serán utilizados con la finalidad de comunicar información propia de la institución, incluyendo nuevos servicios y demás relacionados con nuestra naturaleza jurídica. Su almacenamiento, uso, acceso y manejo se efectúa bajo estrictos estándares de responsabilidad, dentro de los cuales se encuentran el respeto al debido proceso y a la protección de la información; por tanto se garantiza la privacidad, confidencialidad y seguridad de los datos entregados, los cuales están sujetos a la Política para el tratamiento de datos personales, la cual puede consultar en el siguiente <a href="http://www.escuelaing.edu.co/uploads/descargables/2810_politica_para_el_tratamiento_de_datos_personales.pdf" target="_blank">enlace.</a> Lo anterior, sin perjuicio del derecho que le asiste como titular de información en cualquier tiempo de consultar, conocer, actualizar, rectificar o solicitar la supresión de sus datos personales. En caso de que desee ser retirado de nuestra base de datos debe escribir a uge@escuelaing.edu.co.</FONT>
                          </td>
             </tr>
             <tr>
                 <td colspan="3"><label for="cbox">Acepto los términos de tratamiento de datos.</label><input type="checkbox" id="cbox" onchange="document.getElementById('sendNewSms').disabled = !this.checked;" /></td>
             </tr>
            <tr>
                <td colspan="2">
                    <div align="center">
                        <input type="submit" value="Siguiente"  name="Mostrar opcuni" id="sendNewSms" onclick="verificardatosemp();" disabled/>
                    </div>
                </td>
            </tr>
            
                      
                    
            </table>
                <!--</div>
              </td>
            </tr>
        </table>-->
    </body>
</html>