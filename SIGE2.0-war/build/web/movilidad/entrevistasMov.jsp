<%-- 
    Document   : entrevistasMov
    Created on : 13/09/2012, 11:28:33 AM
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
           
           String idsolicitud;
           String nom;
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
           //DecanoRemote bd = conEjb.lookupDecanoRemote();
           login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");          
            String usuario = new String();
            usuario = admin.getUser();
           emp.inicializar(usuario);
           idsolicitud = request.getParameter("idSolicitud"); 
           nom = request.getParameter("nom");
           session.setAttribute("emp", emp ) ;
           HashMap datos = emp.datosEntrevista(idsolicitud);           
           HashMap estado = emp.estadoAplicacion(idsolicitud);
           
 
          
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrevista</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunVice.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>

        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
         <link href="CSS/calendario.css" type="text/css" rel="stylesheet"> 
<script src="jscript/calendar.js" type="text/javascript"></script> 
<script src="jscript/calendar-es.js" type="text/javascript"></script> 
<script src="jscript/calendar-setup.js" type="text/javascript"></script> 
    </head>
    <body>
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_mov"></jsp:include>
        <div align="center">
                <fieldset class="field_set">
  <table width="640" border="0" align="center" cellspacing="0">
    <tr> <td> <div align="center" class="menuprueba2"><font color="#FFFFFF"> PROGRAMAR ENTREVISTA </font></div> </td></tr>
    <tr>
        <td>
           &nbsp; 
        </td></tr>
    <tr>
        <td>
           &nbsp; 
        </td></tr>
    <tr>
        <tr>
        <td>
           &nbsp; 
        </td></tr>
    <tr>
      <td >
        <div align="center">
         <table width="60%">
            <tr>
              <td align="left" width="25%" class="textocom">Nombre:</td>
              <td align="left" width="75%" class="textocom"><%=datos.get("nom_est")%><br></td>
            </tr>
           
            <tr>
              <td align="left" width="25%" class="textocom">Documento de Identidad:</td>
              <td align="left" width="75%" class="textocom"><%=datos.get("doc_est")%><br></td>
            </tr>
            
            <tr>
              <td align="left" width="25%" class="textocom">Carnet:</td>
              <td align="left" width="75%" class="textocom"><%=datos.get("id_est")%><br></td>
            </tr>           
         </table>
        </div>
      </td>
    </tr>
    <tr>
      <td >
        <div align="center">
          <table width="60%" border="0">
            <tr>
              <td align="left" width="25%" class="textocom">Fecha</td>
              <td align="left" width="75%" class="textocom">
                    <input name="fechaEn" id="fechaEn" type="text" size="20" maxlength="25">
                    <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador">(dd/mm/aa) 
                                            <!-- script que define y configura el calendario--> 
                                            <script type="text/javascript"> 
                                            Calendar.setup({ 
                                            inputField : "fechaEn", // id del campo de texto 
                                            ifFormat : "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                            button : "lanzador" // el id del botón que lanzará el calendario 
                                            }); 
                                            </script>
              </td>
            </tr>
            <tr>
              <td align="left" width="25%" class="textocom">Hora</td>
              <td align="left" width="75%" class="textocom">
                    <input class="inputsupercorto" size="3" name="hora" id="hora" type="text"  maxlength="2">:
                    <input class="inputsupercorto" name="min" id="min" type="text" size="3" maxlength="2">
                    (hh:mm)
                    
              </td>
            </tr>
              <tr>              
              <td>                    
                   &nbsp; 
              </td>
            </tr>
            <tr>              
              <td>                    
                   &nbsp; 
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div align="center">
                    <input class="button_azul1" type="submit" value="Enviar Fecha y Hora"  name="Mostrar opcuni" onclick= "cargarfecha(<%=idsolicitud%>,'<%=nom%>','<%=usuario%>');"/>
                </div>
              </td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
    <tr>
        <td>
           &nbsp; 
        </td></tr>
    <tr>
        <td>
           &nbsp; 
        </td></tr>
      <tr>
                        <td >
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
      </body>
</html>

