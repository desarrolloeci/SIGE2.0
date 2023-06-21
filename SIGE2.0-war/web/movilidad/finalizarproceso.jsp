<%-- 
    Document   : finalizarproceso
    Created on : 1/10/2012, 04:04:59 PM
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
           login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");     
            String usuario = new String();
            usuario = admin.getUser();
           //DecanoRemote bd = conEjb.lookupDecanoRemote();
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
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
        
    </head>
    <body  >
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_mov"></jsp:include>
        <div align="center">
            <fieldset class="field_set">
  <table width="640" align="center" rules="none">
    <tr>
      <td height="44">
        <div align="center">
          <table width="75%" >
            <tr>
              <td height="24">
                 <a class="textocom3">Finalizar proceso</a>
              </td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
    <% if ((((String)estado.get("estado")).equals("i         ") || ((String) estado.get("estado")).equals("j         "))) {%>
    <tr>
      <td height="61">
        <div align="center">
         <table width="75%" >
            <tr>
              <td align="left" width="37%" class="textocom2">Nombre:</td>
              <td align="left" width="63%" class="textocom"><%=datos.get("nom_est")%></td>
            </tr>
            <tr>
              <td align="left" width="37%" class="textocom2">Documento de Identidad:</td>
              <td align="left" width="63%" class="textocom"><%=datos.get("doc_est")%></td>
            </tr>
            <tr>
              <td align="left" width="37%" class="textocom2" >Carnet:</td>
              <td align="left" width="63%" class="textocom"><%=datos.get("id_est")%></td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
    <%} else {%>
    <tr>
      <td height="92">
        <div align="center">
          <table width="70%" >
            <tr>
              <td class="textocom2" colspan="2">
                Comentario:
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <textarea name="comment" id="comment" rows="10" cols="38"></textarea>
              </td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
    <%}%>
    <tr>
      <td height="92">
        <div align="center">
          <table width="70%" >
            <tr>
              <td colspan="2">
                <div align="center">
                    <input class="button_azul_consulta1" type="submit" value="Finalizar Proceso"  name="Finalizar Proceso" onclick= "finalizarestado('<%=idsolicitud%>','<%=(String) estado.get("estado")%>');"/>
                </div>
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
        </fieldset>
</div>
</body>
</html>

