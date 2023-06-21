<%-- 
    Document   : index
    Created on : 25/07/2012, 11:12:57 AM
    Author     : Luis Alberto Salas
--%>


<%@page contentType="text/html"%>
<%@ page session="false" %>
<%@page pageEncoding="iso-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    
   <%--
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" /> 
<title>Documento sin t&iacute;tulo</title> 
<link href="CSS/calendario.css" type="text/css" rel="stylesheet"> 
<script src="jscript/calendar.js" type="text/javascript"></script> 
<script src="jscript/calendar-es.js" type="text/javascript"></script> 
<script src="jscript/calendar-setup.js" type="text/javascript"></script> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio SIGE</title>

        <script language="JavaScript" type="text/JavaScript">
           //FUNCION SOLO PARA REDIRIGIR A LOS RESPECTIVOS MENUS DE CADA ACTOR
           function menus(ctrl)
                {
                   for(i=0;i<ctrl.length;i++)
                   {
                       if(ctrl[i].checked)                       
                       {
                           //alert(ctrl[i].value);
                            switch (ctrl[i].value) {
                            case '1':  window.open("loginAdmin","servicioluis","toolbar=no,scrollbars=yes,location=no,directories=yes,status=no,menubar=no,resizable=yes");
                                        break;
                            case '2':
                                        break;
                            case '3':  alert(ctrl[i].value);
                                        break;
                            case '4':  window.open("loginDec","servicioluis","toolbar=no,scrollbars=yes,location=no,directories=yes,status=no,menubar=no,resizable=yes");
                                        break;
                            case '5':  window.open("logingraduado","servicioluis","toolbar=no,scrollbars=yes,location=no,directories=yes,status=no,menubar=no,resizable=yes");
                                        break;
                            case '6':  window.open("loingempresa","servicioluis","toolbar=no,scrollbars=yes,location=no,directories=yes,status=no,menubar=no,resizable=yes");                               
                                        break;
                            case '7':  window.open("loingestMov","servicioluis","toolbar=no,scrollbars=yes,location=no,directories=yes,status=no,menubar=no,resizable=yes");
                                        break;
                            case '8':  alert(ctrl[i].value);
                                        break;
                            case '9':  window.open("loginVice","servicioluis","toolbar=no,scrollbars=yes,location=no,directories=yes,status=no,menubar=no,resizable=yes");
                                        break;
                            case '10':  window.open("menubienestar","servicioluis","toolbar=no,scrollbars=yes,location=no,directories=yes,status=no,menubar=no,resizable=yes");

                                        break;
                            }

                       }
                   }
                }
        </script>
    </head>
    <body>
        <input type="text" name="ingreso" id="ingreso" value="dd-mm-yyyy" /> 

<img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"> 
<!-- script que define y configura el calendario--> 
<script type="text/javascript"> 
Calendar.setup({ 
inputField : "ingreso", // id del campo de texto 
ifFormat : "%d-%m-%Y", // formato de la fecha que se escriba en el campo de texto 
button : "lanzador" // el id del botón que lanzará el calendario 
}); 
</script> 
        <h1></h1>
        <!-- LOS DIFERENTES ACTORES -->
        <form name="menu">
            <input type="radio" name="usuarios" value="1">Administradores
            <br>            
            <br>
            <input type="radio" name="usuarios" value="4">Decanatura
            <br>
            <input type="radio" name="usuarios" value="5">Graduados
            <br>
            <input type="radio" name="usuarios" value="6">Empresas
            <br>
            <input type="radio" name="usuarios" value="7">Estudiante de la escuela
            <br>
            <input type="radio" name="usuarios" value="8">Tutor
            <br>
            <input type="radio" name="usuarios" value="9">Vicerrectoria y bienestar
         </form>
           <input name="aceptar" type="submit" class="boton" id="aceptar"  onclick="menus(document.menu.usuarios)" value="Aceptar">

    </body>
    --%>
</html>
