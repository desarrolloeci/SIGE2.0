<%-- 
    Document   : cambioplanMov2
    Created on : 27/09/2012, 03:06:08 PM
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
           String nom,plan;
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
           //DecanoRemote bd = conEjb.lookupDecanoRemote();
           emp.inicializar("75107740");
           idsolicitud = request.getParameter("idsol"); 
           plan=request.getParameter("id_plan");            
           session.setAttribute("emp", emp ) ;
           HashMap datos = emp.datosMateria(plan);
           
           
 
          
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambio</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
    </head>
    <body >
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_mov"></jsp:include>
        <div align="center">

                <fieldset class="field_set">
     <%
     if(datos.get("materia_ud")!=null){

    %>
  <table width="640" align="center" rules="none" >
    <tr>
      <td height="44">
        <div align="center">
          <table width="75%" >
              <tr>
              <td align="center">
                 &nbsp;
              </td>
            </tr>
            <tr>
              <td align="center">
                  &nbsp;
              </td>
            </tr>
            <tr>
              <td align="center">
                  <a class="textocom3">Solicitar Cambio</a>
              </td>
            </tr>
            <tr>
              <td align="center">
                  &nbsp;
              </td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
    <tr>
      <td height="61">
        <div align="center">
         <table width="100%" >
            <tr>
                <td align="left" width="37%"><a class="textocom2">Materia Actual en la Universidad Anfitriona:</a></td>
                <td align="left" width="63%"><a class="textocom"><%=datos.get("materia_ud")%></a></td>
            </tr>
            <tr>
              <td align="center" colspan="2">
                  &nbsp;
              </td>
            </tr>
            <tr>
                <td align="left" width="37%"><a class="textocom2">Periodo Actual de la Materia:</a></td>
                <td align="left" width="63%"><a class="textocom"><%=datos.get("semestre")%></a></td>
            </tr> 
            <tr>
              <td align="center" colspan="2">
                  &nbsp;
              </td>
            </tr>
            <tr>
              <td align="center" colspan="2">
                  &nbsp;
              </td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
    <tr>
      <td height="92">
        <div align="center">
          <table width="90%" >
            <tr>
              <td width="35%" align="left" class="textocom2">Materia propuesta:</td>
              <td  width="65%" align="left" class="textocom">
                    <input class="inputmediano"name="nuevamat" id="nuevamat" type="text" size="20" maxlength="25"> No utilice siglas
              </td>
            </tr>
            <tr>
              <td class="textocom2" align="left" >Periodo de la nueva Materia:</td>
              <td  class="textocom"align="left"  >
                    <input class="inputcorto"name="nuevoperiodo" id="nuevoperiodo" type="text" size="20" maxlength="25"> (mm-aaaa)
              </td>
            </tr>
            <tr>
              <td class="textocom2"align="left" >Motivo del Cambio:</td>
              <td class="textocom"  align="left" >
                    <input class="inputlargo"name="motivocambio" id="motivocambio" type="text" size="20" maxlength="25">
              </td>
            </tr>
             <tr>
              <td align="center" colspan="2">
                  &nbsp;
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div align="center">
                    <input class="button_azul_consulta"type="submit" value="Registrar cambio"  name="Registrar opcuni" onclick= "registrarcambiomat(<%=plan%>);"/>
                </div>
                
              </td>
            </tr>
             <tr>
              <td align="center" colspan="2">
                  &nbsp;
              </td>
            </tr>
             <tr>
              <td align="center" colspan="2">
                  &nbsp;
              </td>
            </tr>
             <tr>
              <td align="left" colspan="2">
                  
                      <a class="textocom3" href="javascript:history.back()">atras</a>
              </td>
            </tr>
            
          </table>
        </div>
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
                     <%
           }
           else{

    %>
    <table width="640" align="center" rules="none">
    <tr>
      <td height="44">
        <div align="center">
          <table width="75%" align="center" >
            <tr>
              <td align="center">
                  <a class="textocom3">Solicitar Cambio</a>
              </td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
    <tr>
      <td height="92">
        <div align="center">
          <table width="70%" >
            <tr>
              <td colspan="2" class="textocom">Esta materia ya tiene una solicitud de cambio registrada, si aun no a enviado la solicitud de cambio al decano y desea modificarla primero elimínela de la tabla. Si ya envió la solicitud espere la respuesta de la Decanatura.  </td>

            </tr>
            <tr>
              <td colspan="2">
                  <a class="textocom3" href="javascript:history.back()">atras</a>
              </td>
            </tr>
          </table>
        </div>
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
 <%
  }
 %>
                </fieldset>
</div>
</body>
</html>
