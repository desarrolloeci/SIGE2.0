<%-- 
    Document   : VoBo_Grad
    Created on : 19/09/2014, 02:37:52 PM
    Author     : Luis Salas
--%>

<%@page import="clientecampus.ConsultaPersonas"%>
<%@page import="BDsige.graduadoRemote"%>
<%@page import="BDsige.EstudiantesRemote"%>
<%@page import="BDsige.DecanoRemote"%>
<%@page import="BDsige.EmpleadoRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject;" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache");

            documentos.ruta ruta = new documentos.ruta();

            String est = new String ();
            String doc_grad = new String (); 
            String usuario = new String ();
            
            login.SessionGradRemote graduado = (login.SessionGradRemote)session.getAttribute("usuario");
            
            if (graduado == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'logingraduado';
                    </script>
                <%
                return;
            }
            
            usuario = graduado.getUser();     
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            graduadoRemote emp = conEjb.lookupgraduadoRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp", emp );
            HashMap id = emp.docgrad(usuario);
            doc_grad = (String)id.get("id_documento");

            //Se consulta la persona en campus
            EstudiantesRemote estu = conEjb.lookupEstudiantesRemote();
            estu.inicializar("75107740");
            
            estu.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "GRADUADO"));

            

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Visto bueno del graduado</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>
        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
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
        <table width="650" align="center" class="curvas loginPanel" style="padding: 15px 25px;">
            <tr style="height: 64px;">
                <td colspan="2" class="titulocom" style="text-align: center;">Ingreso Graduados</td>
            </tr>
            <tr>
                <td align="left" colspan="2" class="textocom">
                    Apreciado Graduado,<br><br>
                    Bienvenidos al Sistema de Información para Graduados de la Escuela Colombiana de Ingeniería Julio Garavito.<br><br>
                    Con el propósito de consolidar los lazos con nuestros graduados, hemos creado el Sistema de Información de Graduados,
                    que permite actualizar la información de contacto, de estudios, laboral y familiar a través de la web.<br><br>
                    Esperamos que este sistema sea de utilidad y contribuya a consolidar la comunidad de graduados de la Escuela Colombiana de Ingeniería Julio Garavito.
                </td>
            </tr>
            <tr style="height: 32px;"></tr>
            <tr>
                <td align="center" colspan="2" class="textocom" style="font-size: 9px;">
                    Al aceptar los términos declaro que he leído y acepto los términos y condiciones expresadas por la Escuela Colombiana de Ingeniería Julio Garavito para el uso del sistema SIEMPREG 
                    y la bolsa de empleos expresadas en el siguiente <a href="http://practicas.escuelaing.edu.co/contenido/osiris/graduados/REGLAMENTOBOLSAEMPLEO.pdf" target="_blank">REGLAMENTO</a>.
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>
                <td class="textocom" align="right">
                    <input type="submit" value="ACEPTAR" name="ACEPTAR" onclick="AceptarReglamentoGrad(<%=doc_grad%>);"/>
                </td>
                <td  align="left" class="textocom">
                    <input type="submit" value="RECHAZAR" name="RECHAZAR" onclick="location = 'logingraduado';"/>
                </td>
            </tr>            
        </table>
    </body>
</html>