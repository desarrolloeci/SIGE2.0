<%-- 
    Document   : VerOfertaGrad
    Created on : 9/11/2012, 04:12:26 PM
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
            String idoferta;
            String usuario = new String ();

            login.SessionGradRemote graduado =(login.SessionGradRemote)session.getAttribute("usuario");

            if (graduado == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'logingraduado';
                    </script>
                <%
                return;
            }

            usuario=graduado.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            graduadoRemote grad = conEjb.lookupgraduadoRemote();
            grad.inicializar("75107740");

            String doc_grad = new String();
            HashMap id = grad.docgrad(usuario);
            doc_grad = (String)id.get("id_documento");

            //Se consulta la persona en campus
            EstudiantesRemote estu = conEjb.lookupEstudiantesRemote();
            estu.inicializar("75107740");
            
            estu.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "GRADUADO"));

            

            idoferta = request.getParameter("i");

            HashMap datosoferta= grad.getDatosOferta(idoferta);
            HashMap[] programas=grad.getProgramas(idoferta);
            HashMap programa;
            int nump = programas.length;
            String ban = new String ();
            HashMap ban1 = grad.getBanAplicacion(doc_grad,idoferta);
            ban = (String) ban1.get("ban");          
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Oferta Laboral</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>        
        <link href="CSS/graduados.css" rel="stylesheet" type="text/css">
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
            
            .panelSubTitulo {
                width: 100%;
                border-top-left-radius: 20px;
                border-top-right-radius: 20px;
                border-bottom-left-radius: 5px;
                border-bottom-right-radius: 5px;
                color: #FFFFFF;
                background: rgb(0, 0, 70);
            }
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="grad" />
        </jsp:include>
        <table width="800" align="center" class="curvas loginPanel" cellspacing="0" style="padding: 10px;">
            <tr style="height: 32px;"></tr>
            <tr>
                <td align="center">
                    <a class="textocom3">OFERTA LABORAL</a>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>
                <td valign="top" width="90%" height="500"  bgcolor="#FFFFFF" class="textocom">
                    <table>
                        <tr>
                            <td valign="top" width="35%"><a class="textocom2">Cargo:</a></td>
                            <td width="75%"><a class="textocom"><%=datosoferta.get("cargo")%></a></td>
                        </tr>
                        <tr>
                            <td valign="top" width="35%"><a class="textocom2">Vacantes:</a></td>
                            <%String vac="No Registra"; if(datosoferta.get("vacantes").toString().equals(null)){vac="";}else{vac = datosoferta.get("vacantes").toString();}%>
                            <td width="75%"><a class="textocom"><%=vac%></a></td>
                        </tr>
                        <tr style="height: 16px;"></tr>
                        <tr>
                            <td valign="top"><a class="textocom2">Descripción:</a></td>
                            <td><a class="textocom" style="text-align: justify;"><%=datosoferta.get("descripcion")%></a></td>
                        </tr>
                        <tr style="height: 16px;"></tr>
                        <tr>
                            <td valign="top"><a class="textocom2">Requisitos:</a></td>
                            <td><a class="textocom" style="text-align: justify;"><%=datosoferta.get("requisitos")%></a></td>
                        </tr>                    
                        <tr style="height: 16px;"></tr>
                        <tr>
                            <td valign="top"><a class="textocom2">Idiomas requeridos:</a></td>
                            <td><a class="textocom" style="text-align: justify;"><%=datosoferta.get("idiomas")%></a></td>
                        </tr>                    
                        <tr style="height: 16px;"></tr>
                        <tr>
                            <td><a class="textocom2">País:</a></td>
                            <td><a class="textocom"><%=datosoferta.get("pais_oferta")%></a></td>
                        </tr>
                        <tr>
                            <td><a class="textocom2">Ciudad:</a></td>
                            <td><a class="textocom"><%=datosoferta.get("ciudad_oferta")%></a></td>
                        </tr>
                        <tr>
                            <td><a class="textocom2">Sector:</a></td>
                            <td><a class="textocom"><%=datosoferta.get("area_oferta")%></a></td>
                        </tr>
                        <tr style="height: 16px;"></tr>
                        <tr>
                            <td><a class="textocom2">Fecha de publicación:</a></td>
                            <td><a class="textocom"><%=datosoferta.get("fecha_publicacion")%></a></td>
                        </tr>
                        <tr>
                            <td><a class="textocom2">Fecha de vencimiento:</a> </td>
                            <td><a class="textocom"><%=datosoferta.get("fecha_limite")%></a></td>
                        </tr>
                        <tr style="height: 16px;"></tr>
                        <tr>
                            <td valign="top"><a class="textocom2">Programas requeridos:</a></td>
                            <td>
                                <a class="textocom">
                                    <%
                                        for (int cont=0; cont < nump; cont++) {
                                            programa = programas[cont];                                
                                    %>
                                            <%=programa.get("programa_requerido")%><br/>
                                    <%
                                        }
                                    %>
                                </a>
                            </td>
                        </tr>
                        <tr style="height: 16px;"></tr>
                        <tr>
                            <td><a class="textocom2">Años de experiencia:</a> </td>
                            <td><a class="textocom"><%=datosoferta.get("años_exp")%></a></td>
                        </tr>
                        <tr style="height: 16px;"></tr>
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
                            <td><a class="textocom">entre <%=datosoferta.get("salario_oferta")%> de pesos</a></td>
                        </tr>
                        <tr style="height: 32px;"></tr>
                        <tr>
                            <td valign="top"><a class="textocom2">Teletrabajo:</a></td>
                            <%String tele="No Registra"; if(datosoferta.get("teletrabajo").toString().equals(null)){tele="";}if(datosoferta.get("teletrabajo").toString().equals("1")){tele="SI";}if(datosoferta.get("teletrabajo").toString().equals("0")){tele="NO";}%>
                            <td><a class="textocom"><%=tele%></a></td>
                        </tr>
                        <tr>
                            <td valign="top"><a class="textocom2">Permite persona en situación de discapacidad:</a></td>
                            <%String disc="No Registra"; if(datosoferta.get("discapacidad").toString().equals(null)){disc="";}if(datosoferta.get("discapacidad").toString().equals("1")){disc="SI";}if(datosoferta.get("discapacidad").toString().equals("0")){disc="NO";}%>
                            <td><a class="textocom"><%=disc%></a></td>
                        </tr>
                        <tr style="height: 32px;"></tr>
                        <tr>
                            <td colspan="2" align="center" style="border-radius: 20px; border: 1px solid #DDDDDD;">
                                <a class="textocom2" style="text-decoration: underline;">Apreciado graduado:</a>
                                <a class="textocom">
                                    <br>
                                    Antes de postularse a una oferta verifique el cumplimiento de los
                                    requisitos establecidos, y estar de acuerdo con las condiciones propuestas en ella.<br>
                                    Adicionalmente le recomendamos que antes de presentarse a la entrevista se informe sobre la empresa, prepare una hoja
                                    de vida impresa y tenga especial atención en la primera impresión que dejará, para lo cual la
                                    presentación personal es clave.<br><br>
                                    Para postularse a esta oferta haga click en el botón Postularse
                                </a>
                            </td>
                        </tr>
                        <tr style="height: 32px;"></tr>
                        <tr>
                            <%
                                if (ban.equals("0")) {
                            %>
                            <td colspan="2" align="center" id="btnAplicarOferta">
                                <input class="button_azul" type="submit" value="Postularse" name="EnvAplicaciongrad" onclick="AplicarOfertaGrad(<%=idoferta%>,<%=doc_grad%>);"/>
                            </td>
                            <%
                                } else {
                            %>
                            <td colspan="2" align="center">
                                <a class="textocom3">Usted ya se ha postulado a esta oferta.</a>
                            </td>
                            <%
                                }
                            %>
                        </tr>
                        <tr style="height: 32px;"></tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">                             
                    <jsp:include page="footer">
                        <jsp:param name="access" value="1" />
                        <jsp:param name="type" value="grad" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
</html>
