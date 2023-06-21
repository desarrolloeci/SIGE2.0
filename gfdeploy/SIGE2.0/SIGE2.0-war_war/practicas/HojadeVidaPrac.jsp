<%-- 
    Document   : HojadeVidaPrac
    Created on : 14/04/2016, 14:45:01 AM
    Author     : Mario Martínez
--%>

<%@page import="BDsige.EstudiantesRemote"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject;" %>
<!DOCTYPE html>

<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache");
            
            String Funciones = new String ();
            String Logros = new String ();
            String idest = new String ();
            String usuario = new String ();
            
            login.SessionEstRemote estudiante = (login.SessionEstRemote) session.getAttribute("usuario");
            
            if (estudiante == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'loginestMov';
                    </script>
                <%
                return;
            }
            
            usuario = estudiante.getUser();
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
            emp.inicializar("75107740");
            
            session.setAttribute("emp", emp );
            
            HashMap id_est = emp.carnetEstPrac(usuario);
            idest = (String)id_est.get("id_est");
            
            HashMap datosContacto = emp.datosContPrac(idest);
            HashMap[] ExperienciasPrac = emp.getExperienciasPrac(idest);
            HashMap[] EstudiosPrac = emp.getEstudiosPrac(idest);
            HashMap[] TiposEstudios = emp.getTiposEstudios(idest);
            HashMap[] IdiomasPrac = emp.getIdiomasPrac(idest);
            HashMap[] Distinciones = emp.getDistincionesPrac(idest);
            HashMap[] Afiliaciones = emp.getAfiliacionesPrac(idest);
        %>
        <title>SIEMPREG - Hoja de vida</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link href="CSS/hojadevidaPrac.css" rel="stylesheet" type="text/css">
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
        </style>
    </head>
    <body style="margin: 0px; padding: 0px;">
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        <div class="set_hv curvas loginPanel">
            <%
                if (datosContacto.size() != 0) {
            %>
            <table style="border-collapse: separate; border-spacing: 0px 5px; background: #FFFFFF; width: 100%; text-align: left;">
                <tr>
                    <td colspan="3" class="href_rojo1">
                        Hoja de Vida
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr>
                    <td colspan="1" style="width: 10%;"></td>
                    <td colspan="1" style="width: 20%;" class="texto_gris2">
                        Nombre:
                    </td>
                    <td colspan="1" style="width: 70%" class="titulo_conv_publica texto_gris2">
                        <%=datosContacto.get("nom_est")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        E-mail:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=datosContacto.get("emails")%>@mail.escuelaing.edu.co
                        <%=!((String) datosContacto.get("email2")).equals("")?"<br>" + datosContacto.get("email2"):""%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Teléfono:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=datosContacto.get("tel_corr")%><%=!((String) datosContacto.get("tel2")).equals("")?" - " + datosContacto.get("tel2"):""%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Celular:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=datosContacto.get("cel")%>
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <tr>
                    <td colspan="10">
                        <div class="titulo_conv_publica href_rojo2">
                            Perfil Profesional
                        </div>
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="2" class="texto_conv_publica texto_gris2" style="padding: 10px 20px; text-align: justify;">
                        <%=datosContacto.get("perfil").toString().replace("\n","<br />")%>                        
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <tr>
                    <td colspan="3" class="titulo_conv_publica href_rojo2">
                        Lineas de profundización o Electivas cursadas
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="2" class="texto_conv_publica texto_gris2" style="padding: 10px 20px; text-align: justify;">
                        <%=datosContacto.get("electivas").toString().replace("\n","<br />")%>                        
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <tr>
                    <td colspan="3" class="titulo_conv_publica href_rojo2">
                        Expectativas
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="2" class="texto_conv_publica texto_gris2" style="padding: 10px 20px; text-align: justify;">
                        <%=datosContacto.get("expectativas").toString().replace("\n","<br />")%>                        
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <%
                    if (ExperienciasPrac.length > 0) {
                %>
                <tr>
                    <td colspan="3" class="titulo_conv_publica href_rojo2">
                        Experiencia laboral
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <%

                        for (HashMap Experiencia : ExperienciasPrac) {
                            
                            Funciones = ((String) Experiencia.get("funciones")).replaceAll("\n", "<br>");
                            Logros = ((String) Experiencia.get("logros")).replaceAll("\n", "<br>");
                %>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="2" class="titulo_conv_publica texto_gris2">
                        <%=Experiencia.get("nom_empresa")%>                     
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        <a class="">Cargo:</a>
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=Experiencia.get("cargo")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Dirección:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=Experiencia.get("dir_emp")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1">
                    </td>
                    <td colspan="1" class="texto_gris2">
                        Teléfono:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=Experiencia.get("tel_emp")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1">
                    </td>
                    <td colspan="1" class="texto_gris2">
                        Desde:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=Experiencia.get("fecha_in_cargo")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Hasta:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=Experiencia.get("fecha_out_cargo").equals("1900/01") ? "Actualidad" : Experiencia.get("fecha_out_cargo")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1">
                    </td>
                    <td colspan="1" class="texto_gris2">
                        Funciones:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <pre style="white-space: pre-line; text-align: justify; font-family: inherit;"><%=Funciones%></pre>
                    </td>
                </tr>
                <tr>
                    <td colspan="1">
                    </td>
                    <td colspan="1" class="texto_gris2">
                        Logros:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <pre style="white-space: pre-line; text-align: justify; font-family: inherit;"><%=Logros%></pre>
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <%      }
                    }

                    if (EstudiosPrac.length > 0) {
                %>
                <tr>
                    <td colspan="3" class="titulo_conv_publica href_rojo2">
                        Estudios
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <%
                        for (HashMap tipoEst : TiposEstudios) {
                            if (TiposEstudios.length > 1 || Integer.parseInt((String) tipoEst.get("ID")) != 5) {
                %>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="2" class="titulo_conv_publica texto_gris2" style="font-weight: bold;">
                        <%=tipoEst.get("nom_tipo")%>
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <%
                            }
                            for (HashMap Estudio : EstudiosPrac) {
                                if (Integer.parseInt((String) Estudio.get("tipo_estudio")) == Integer.parseInt((String) tipoEst.get("ID"))) {
                %>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="2" class="titulo_conv_publica texto_gris2">
                        <%=Estudio.get("nom_estudio")%>                     
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Institución:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=Estudio.get("nom_inst")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Fecha de grado:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=Estudio.get("f_grado")%>
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <%
                                }
                            }
                        }
                    }

                    if (IdiomasPrac.length > 0) {
                %>
                <tr>
                    <td colspan="3" class="titulo_conv_publica href_rojo2">
                        Idiomas
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <%
                        for (HashMap idioma : IdiomasPrac) {
                %>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="2" class="titulo_conv_publica texto_gris2">
                        <%=idioma.get("nom_idioma")%>                       
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Nivel de lectura:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=idioma.get("niv_lectura")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Nivel de escritura:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=idioma.get("niv_escritura")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Nivel de habla:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=idioma.get("niv_habla")%>
                    </td>
                </tr>  
                <tr style="height: 2em;"></tr>
                <%
                        }
                    }

                    if (Distinciones.length > 0) {
                %>
                <tr>
                    <td colspan="3" class="titulo_conv_publica href_rojo2">
                        Distinciones
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <%
                        for (HashMap distincion : Distinciones) {
                %>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="2" class="titulo_conv_publica texto_gris2">
                        <%=distincion.get("nom_distincion")%>      
                    </td>
                </tr>
                <tr>
                    <td colspan="1">
                    </td>
                    <td colspan="1" class="texto_gris2">
                        Institución:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=distincion.get("lugar_distincion")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="1" class="texto_gris2">
                        Fecha:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=distincion.get("fecha_distincion")%>
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <%      }
                    }

                    if (Afiliaciones.length > 0) {
                %>
                <tr>
                    <td colspan="3" class="titulo_conv_publica href_rojo2">
                        Afiliaciones
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <%
                        for (HashMap afiliacion : Afiliaciones) {
                %>
                <tr>
                    <td colspan="1"></td>
                    <td colspan="2" class="titulo_conv_publica texto_gris2">
                        <%=afiliacion.get("nom_aso")%>
                    </td>
                </tr>
                <tr>
                    <td colspan="1">
                    </td>
                    <td colspan="1" class="texto_gris2">
                        Fecha:
                    </td>
                    <td colspan="1" class="texto_gris2">
                        <%=afiliacion.get("fecha_in")%>
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <%      }
                    }
                %>
                <tr>
                    <td colspan="3" class="titulo_conv_publica href_rojo2">
                        Referencias
                    </td>
                </tr>
                
                <tr style="height: 1em;"></tr>
                <tr>
                    <td colspan="1" ></td>
                    <td colspan="2" class="texto_conv_publica texto_gris2" style="padding: 10px 20px; text-align: justify;">
                        <%=datosContacto.get("referencias").toString().replace("\n","<br />")%>                        
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
            </table>
            <%
                } else {
            %>
            <table style="border-collapse: separate; border-spacing: 10px 0px; background: #FFFFFF; width: 100%; text-align: center;">
                <tr>
                    <td class="texto_negro2">Usted nunca ha actualizado su hoja de vida.<br><br>Por favor ingrese al Sistema de Prácticas y diríjase a Actualizar Hoja de vida.</td>
                </tr>
            </table>
            <%
                }
            %>
            <br>
            <br> 
            <div style="text-align: center;">
                <input class="button_claro" type="button" onclick="window.close();" value="Cerrar esta ventana" />
            </div>
        </div>
    </body>
</html>

