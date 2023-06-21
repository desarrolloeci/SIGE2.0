<%-- 
    Document   : VerClacificadosGrad
    Created on : 17/04/2013, 02:42:06 PM
    Author     : Luis Alberto Salas
--%>


<%@page import="clientecampus.ConsultaPersonas"%>
<%@page import="BDsige.EstudiantesRemote"%>
<%@page import="BDsige.graduadoRemote"%>
<%@page import="BDsige.DecanoRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,
         javax.rmi.PortableRemoteObject"
         %>



<html>
    <head>
<%
   response.setHeader("Cache-Control","no-cache");
   String est = new String ();
   String idclas;
   String usuario = new String ();
           //doc_grad="2067558";
           //login.InicioProfRemoteBusiness empleado = (login.InicioProfRemoteBusiness) session.getAttribute("empleado");
           login.SessionGradRemote graduado =(login.SessionGradRemote)session.getAttribute("usuario");
           usuario=graduado.getUser();
   inicio.conectaEJB conEjb = new inicio.conectaEJB();
   graduadoRemote grad = conEjb.lookupgraduadoRemote();
   //DecanoRemote bd = conEjb.lookupDecanoRemote();
   grad.inicializar("75107740");
   String doc_grad = new String ();
   HashMap id = grad.docgrad(usuario);
   doc_grad = (String)id.get("id_documento");
   
   //Se consulta la persona en campus
    EstudiantesRemote estu = conEjb.lookupEstudiantesRemote();
    estu.inicializar("75107740");
    
    estu.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "GRADUADO"));
   
    
    
   idclas = request.getParameter("i");
   HashMap clasificado = grad.datosClasificados(idclas);
%>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>solicitud</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>
        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
    </head>
    <body background="imagenes/fondoblanco.gif" >
        <p class="textocom">&nbsp;</p>
        <table width="450"  align="center" border="1"  cellspacing="0" bordercolor="#EEEBFC">
            <tr> <td align="center" bgcolor="#EEEBFC" style="font-size: 12pt; color:#000000 " > <i> CLASIFICADO </i> </td></tr><br/>
            <td valign="top" width="90%"  bgcolor="#FFFFFF" class="textocom" style="  box-shadow:  -5px 5px 5px 5px rgba(0,0,0,0.1); ">
                <table >
                    <tr>
                        <td valign="top"><b>Titulo:</b></td>
                        <td><%=clasificado.get("titulo")%></td>
                    </tr>
                    <tr>
                        <td valign="top"><b>Telefono de contacto:</b></td>
                        <td><%=clasificado.get("tel_clas")%></td>
                    </tr>
                     <tr>
                        <td valign="top"><b>Email de contacto</b></td>
                        <td><%=clasificado.get("email_clas")%></td>
                    </tr>
                    <tr>
                        <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                    <tr>
                        <td><b>Clasificado:</b></td>
                        <td><%=clasificado.get("clasificado")%></td>
                    </tr>
                    
                     <tr>
                         <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                    
                   
                     <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                     </tr>
                  <%--  <tr>

                        <td colspan="2" align="center"><b>Apreciado graduado:</b><br/>Antes de postularse a una oferta verifique el cumplimiento de los
                            requisitos establecidos, y estar de acuerdo con las condiciones propuestas en ella.<br/>Adicionalmente le
                            recomendamos que antes de de presentarse a la entrevista se informe sobre la empresa, prepare una hoja
                            de vida impresa y tenga especial atención en la primera impresión que dejará, para lo cual la
                            presentación personal es clave. <br/>Para postularse a esta oferta haga click en el botón Aplicar</td>
                    </tr>--%>
                    
                    
                </table>
            </td>
        </table>
                  <%
                 /*conEjb=null;
                 System.gc();*/
                %>
    </body>
</html>
