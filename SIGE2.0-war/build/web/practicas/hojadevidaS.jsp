<%-- 
    <<<<<<<<<<<<<<<<[DESABILITADO]>>>>>>>>>>>>>>>>>
    Document   : hojadevidaS
    Created on : 11/09/2014, 02:21:22 PM
    Author     : Luis Salas
--%>

<%@page import="BDsige.EstudiantesRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,
         javax.rmi.PortableRemoteObject"
         %>


        <%

            response.setHeader("Cache-Control", "no-cache");
            /*
             String doc_grad = new String ();
             String idest = new String ();
             String act= new String();
             //tel2, email2, cel, perfil, referencias, expectativas, estado
             String usuario = new String ();

             session.setAttribute("emp", emp ) ;
             */

            String Funciones = new String();
            String Logros = new String();
            String idest = new String();
            String doc_grad = new String();
            String usuario = new String();
            int t, e, ban;
            login.SessionEstRemote estudiante = (login.SessionEstRemote) session.getAttribute("usuario");
            usuario = estudiante.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
            emp.inicializar("75107740");;
            session.setAttribute("emp", emp);
            HashMap id_est = emp.carnetEstPrac(usuario);
            idest = (String) id_est.get("id_est");
            //Hashmap datosgenGrad= emp.
            HashMap datosContacto = emp.datosContPrac(idest);
            HashMap[] ExperienciasGrad = emp.getExperienciasPrac(idest);
            HashMap[] EstudiosGrad = emp.getEstudiosPrac(idest);
            HashMap[] IdiomasGrad = emp.getIdiomasPrac(idest);
            t = ExperienciasGrad.length;
            e = EstudiosGrad.length;
            ban = IdiomasGrad.length;
            //datosContacto.size();

            //nom_est, tel_residencia, dir_residencia, email, cel, ciudad_residencia, perfil
        %>
       
        
        <link href="CSS/hojadevidaPrac.css" rel="stylesheet" type="text/css">

    <body >   
        <%if (datosContacto.size() != 0) {%>
        <table width="500" border="0" align="center" cellspacing="0" >
            <tr>
                <td>
                    <div align="center">
                        <table width="100%" border="0" align="center" cellspacing="0" bgcolor="#FFFFFF">
                            <tr>
                                <td colspan="10">&nbsp;</td>

                            </tr>
                            <tr>
                                <td colspan="10" align="left">
                                    <a class="href_rojo1">Hoja de Vida</a>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="10">&nbsp;</td>
                            </tr>


                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro3">Nombre</a>

                                </td>
                                <td colspan="9" width="87%"align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="texto_gris2"><%=datosContacto.get("nom_est")%></a>
                                    </div>                             
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_gris2">E-mail:</a>
                                </td>
                                <td colspan="8" width="74%"align="left">

                                    <a class="texto_gris2"><%=datosContacto.get("emails")%>@mail.escuelaing.edu.co<br>
                                        <%=datosContacto.get("email2")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_gris2">Teléfono:</a>
                                </td>
                                <td colspan="8" width="74%"align="left">

                                    <a class="texto_gris2"><%=datosContacto.get("tel_corr")%>-<%=datosContacto.get("tel2")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_gris2">Celular:</a>
                                </td>
                                <td colspan="8" width="74%"align="left">

                                    <a class="texto_gris2"> <%=datosContacto.get("cel")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_gris2">Dirección:</a>
                                </td>
                                <td colspan="8" width="74%"align="left">

                                    <a class="texto_gris2"> <%=datosContacto.get("dir_corr")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="10" align="left">
                                    <a>&nbsp;</a>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="10" align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="href_rojo2">PERFIL PROFESIONAL</a>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="10" align="left">
                                    <a>&nbsp;</a>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="3%" align="left">
                                    &nbsp;

                                </td>
                                <td colspan="9" width="97%"align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="texto_gris2"><%=datosContacto.get("perfil")%></a>
                                    </div>                             
                                </td>
                            </tr>



                            <tr>
                                <td colspan="10" align="left">
                                    <a>&nbsp;</a>
                                </td>
                            </tr>
                            <%if (t != 0) {%>
                            <tr>
                                <td colspan="10" align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="href_rojo2">Experiencia laboral</a>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="10" align="left">
                                    <a>&nbsp;</a>
                                </td>
                            </tr>
                            <%
                                HashMap Experiencia;
                                for (int i = 0; i < t; i++) {
                                    Experiencia = ExperienciasGrad[i];
                                    Funciones = (String) Experiencia.get("funciones");
                                    Funciones = Funciones.replaceAll("\n", "<br>");
                                    Logros = (String) Experiencia.get("logros");
                                    Logros = Logros.replaceAll("\n", "<br>");
                            %>

                            <tr>
                                <td colspan="1" width="3%" align="left">
                                    &nbsp;

                                </td>
                                <td colspan="9" width="97%"align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="texto_gris2"><%=Experiencia.get("nom_empresa")%></a>

                                    </div>                             
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Cargo:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">

                                    <a class="texto_gris2"><%=Experiencia.get("cargo")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Desde:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">

                                    <a class="texto_gris2"><%=Experiencia.get("fecha_in_cargo")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Hasta:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">

                                    <a class="texto_gris2"><%=Experiencia.get("fecha_out_cargo")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Funciones:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">

                                    <a class="texto_gris2"><%=Funciones%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Logros:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">

                                    <a class="texto_gris2"><%=Logros%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_gris2">&nbsp;</a>
                                </td>
                                <td colspan="8" width="74%"align="left">

                                    <a class="texto_gris2">&nbsp;</a>

                                </td>
                            </tr>

                            <%}
                                }
                                if (e != 0) {
                            %>
                            <tr>
                                <td colspan="10" align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="href_rojo2">ESTUDIOS REALIZADOS</a>
                                    </div>
                                </td>
                            </tr>
                            <td colspan="10" align="left">
                                <a>&nbsp;</a>
                            </td>

                            <%
                                HashMap Estudio;
                                for (int l = 0; l < e; l++) {
                                    Estudio = EstudiosGrad[l];
                            %>
                            <tr>
                                <td colspan="1" width="3%" align="left">
                                    &nbsp;

                                </td>
                                <td colspan="9" width="97%"align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="texto_gris2"><%=Estudio.get("nom_estudio")%></a>
                                    </div>                             
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Institución:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">

                                    <a class="texto_gris2"><%=Estudio.get("nom_inst")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Fecha de grado:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">
                                    <a class="texto_gris2"><%=Estudio.get("f_grado")%> 
                                    </a>

                                </td>
                            </tr>

                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_gris2">&nbsp;</a>
                                </td>
                                <td colspan="8" width="74%"align="left">

                                    <a class="texto_gris2">&nbsp;</a>

                                </td>
                            </tr>


                            <%
                                    }
                                }
                            %>
                            <%if (ban != 0) {%>

                            <tr>
                                <td colspan="10" align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="href_rojo2">Idiomas</a>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="10" align="left">
                                    <a>&nbsp;</a>
                                </td>
                            </tr>




                            <%
                                HashMap Idioma;
                                for (int b = 0; b < ban; b++) {
                                    Idioma = IdiomasGrad[b];

                            %>

                            <tr>
                                <td colspan="1" width="3%" align="left">
                                    &nbsp;

                                </td>
                                <td colspan="9" width="97%"align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="texto_gris2"><%=Idioma.get("nom_idioma")%></a>
                                    </div>                             
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Nivel de lectura:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">

                                    <a class="texto_gris2"><%=Idioma.get("niv_lectura")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Nivel de escritura:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">

                                    <a class="texto_gris2"><%=Idioma.get("niv_escritura")%></a>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="2" width="13%" align="left">
                                    <a class="texto_gris2">Nivel de habla:</a>
                                </td>
                                <td colspan="7" width="74%"align="left">

                                    <a class="texto_gris2"><%=Idioma.get("niv_habla")%> 
                                    </a>

                                </td>
                            </tr>  
                            <tr>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_negro2">&nbsp;</a>
                                </td>
                                <td colspan="1" width="13%" align="left">
                                    <a class="texto_gris2">&nbsp;</a>
                                </td>
                                <td colspan="8" width="74%"align="left">

                                    <a class="texto_gris2">&nbsp;</a>

                                </td>
                            </tr>


                            <%
                                }
                            %>




                            <%}%>

                        </table>
                    </div>
                </td>
            </tr>
        </table>
        <%}%>

 
