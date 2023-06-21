<%-- 
    Document   : VerAplicantesOferGrad
    Created on : 14/11/2012, 11:46:07 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EmpresaRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;"%>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject;"%>

<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache");
   
            String usuario = new String ();
            String idoferta = new String ();
            
            login.SessionEmpRemote empresa =(login.SessionEmpRemote)session.getAttribute("usuario");
            
            //Verificamos que la sesión esté activa
            if (empresa == null) {
                %><script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.close();
                </script><%
                return;
            }
            
            usuario=empresa.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp",emp);
            String  error = new String();
            idoferta = request.getParameter("idofer");
            HashMap datosoferta= emp.getDatosOfertaemp(idoferta);
            HashMap[] aplicantes=emp.getAplicantesOferEmp(idoferta);
            
            HashMap aplicante;           
            int numa=aplicantes.length;
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Aplicantes de la oferta</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>     
        
        <link href="CSS/empresas.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            body {
                background:url('imagenes/fondo empresas.jpg');
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
            
            .panelSubTitulo {
                width: 100%;
                border-top-left-radius: 20px;
                border-top-right-radius: 20px;
                border-bottom-left-radius: 5px;
                border-bottom-right-radius: 5px;
                color: #FFFFFF;
                background: rgb(153, 0, 0);
            }
            
            .panelSubMenu {
                width: 100%;
                height: 19px;
                border-radius: 20px;
                border: 1px solid rgb(153, 0, 0);
                color: rgb(153, 0, 0);
                background: #FFFFFF;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="emp" />
        </jsp:include>
        <table width="450" align="center" class="curvas loginPanel" cellspacing="10">        
            <tr>
                <td>
                    <div align="center" class="textocom3">
                        Oferta Laboral
                    </div>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>
            <td align="center" valign="top" width="80%" height="500">
                <table>
                    <tr>
                        <td valign="top" style="width: 40%;"><a class="textocom2">Cargo:</a></td>
                        <td><a class="textocom" style="width: 60%;"><%=datosoferta.get("cargo")%></a></td>
                    </tr>                    
                    <tr>
                        <td><a class="textocom2">Área Laboral:</a></td>
                        <td><a class="textocom"><%=datosoferta.get("area_oferta")%></a></td>
                    </tr>
                     <tr>
                         <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                    <tr>
                        <td><a class="textocom2">Fecha de publicación:</a></td>
                        <td><a class="textocom"><%=datosoferta.get("fecha_publicacion")%></a></td>
                    </tr>
                    <tr>
                        <td><a class="textocom2">Fecha de vencimiento:</a> </td>
                        <td><a class="textocom"><%=datosoferta.get("fecha_limite")%></a></td>
                    </tr>                     
                     <tr>
                        <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                    <tr>
                        <td><a class="textocom2">Jornada:</a></td>
                        <td><a class="textocom"><%=datosoferta.get("horario_oferta")%></a></td>
                    </tr>
                    <tr>
                        <td><a class="textocom2">Tipo de contrato:</a></td>
                        <td><a class="textocom"><%=datosoferta.get("tipo_contrato")%></a></td>
                    </tr>
                    <tr>
                        <td valign="top"><a class="textocom2">Salario:</a></td>
                        <td><a class="textocom">Entre <%=datosoferta.get("salario_oferta")%> de pesos</a></td>
                    </tr>
                    <tr>
                         <td colspan="2">_________________________________________________________________________</td>
                    </tr>
                     <tr>
                        <td colspan="2">&nbsp;</td>
                        
                     </tr>                   
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                     </tr>
                </table>
                    <table align="center" border="0"  cellspacing="0" >
                        <tr><td colspan="2"><div align="center" ><a class="textocom3">Postulantes a esta oferta </a></div> </td></tr>
                        <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                     </tr>
                    </table>
                        
                    <table align="center" class="tabla_apli" border="1" cellspacing="0" style="width: 90%;">                        
                        <%
                            if (numa==0) {
                        %>
                        <tr><td colspan="2"><a class="textocom2">Esta oferta aun no tiene ningún postulantes</a></td></tr>
                        <%
                            } else {
                        %>
                        <tr>
                            <td class="textocom2" align="center" style="width: 65%; font-weight: bold;">Nombre del postulante</td>
                            <td class="textocom2" align="center" style="width: 35%; font-weight: bold;">Estado</td>
                        </tr>
                        <%
                                for (int i = 0; i < numa; i++) {
                                    aplicante=aplicantes[i];
                        %>
                        <tr>
                                <td align="left" style="padding: 0.5% 0% 0.5% 2%; font-family: Verdana, sans-serif; font-size: 14px;"><a href="HojadevidaGradEmp?ref=<%=aplicante.get("id_documento")%>&ida=<%=aplicante.get("id_aplicacion")%>" onclick='window.open(this.href,"ventana","toolbar=no,scrollbars=yes,location=no,directories=yes,status=no,menubar=no,resizable=yes"); return false;'><%=aplicante.get("nom_est")%></a></td>
                                <td align="center"><a class="textocom"><%=aplicante.get("men_usr")%></a></td>
                        </tr>
                        <%
                                }
                            }
                        %>
                          
                    </table>
            </td>
             </tr>
             <tr> 
                        <td align="center" colspan="2"> <div align="center" >
                                
                <input class="button_rojo" type="submit" onclick="window.close()" value="Cerrar" />
        
        </div> </td></tr>
              <tr>
                <td colspan="2" align="center">
                    <jsp:include page="footer">
                        <jsp:param name="type" value="grad" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
</html>