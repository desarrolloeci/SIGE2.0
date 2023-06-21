<%-- 
    Document   : VerCartaPracDec
    Created on : 23/01/2013, 03:23:59 PM
    Author     : Luis Alberto Salas
--%>


<%@page import="BDsige.EmpresaRemote"%>


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

            response.setHeader("Cache-Control", "no-cache");

            String id_apli = new String();
            String usuario = new String();
            String est = new String();

            login.SessionUsrRemote empresa = (login.SessionUsrRemote) session.getAttribute("usuario");
            
            if (empresa == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'loginDec';
                    </script>
                <%
                return;
            }
            
            usuario = empresa.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar("75107740");;
            session.setAttribute("emp", emp);
            //idest = request.getParameter("ref");
            id_apli = request.getParameter("ida");
            HashMap datosCartaprac = emp.datosCartaPrac(id_apli);
            HashMap datoDecEmp = emp.getDatoDecEmp(datosCartaprac.get("id_dpto").toString());
            HashMap datosTutor = emp.DatosTutorEmp(id_apli);
            HashMap estado = emp.EstadoActApliPracEmp(id_apli);
            est = estado.get("estado_apli").toString();
            String dpto = new String();
            if (datosCartaprac.get("id_dpto").equals("13")) {
                dpto = "Ingenier&iacute;a Civil";
            }
            if (datosCartaprac.get("id_dpto").equals("14")) {
                dpto = "Ingenier&iacute;a El&eacute;ctrica";
            }
            if (datosCartaprac.get("id_dpto").equals("15")) {
                dpto = "Ingenier&iacute;a de Sistemas";
            }
            if (datosCartaprac.get("id_dpto").equals("16")) {
                dpto = "Ingenier&iacute;a Industrial";
            }
            if (datosCartaprac.get("id_dpto").equals("17")) {
                dpto = "Ingenier&iacute;a Electr&oacute;nica";
            }
            if (datosCartaprac.get("id_dpto").equals("260")) {
                dpto = "Ingenier&iacute;a Mec&aacute;nica";
            }
            if (datosCartaprac.get("id_dpto").equals("262")) {
                dpto = "Ingenier&iacute;a Biom&eacute;dica";
            }
            if (datosCartaprac.get("id_dpto").equals("19")) {
                dpto = "Administraci&oacute;n de Empresas";
            }
            if (datosCartaprac.get("id_dpto").equals("20")) {
                dpto = "Matem&aacute;ticas";
            }
            if (datosCartaprac.get("id_dpto").equals("18")) {
                dpto = "Econom&iacute;a";
            }
            //HashMap datosContacto=emp.datosContPracEmp(idest);
            //datosContacto.size();

            //nom_est, tel_residencia, dir_residencia, email, cel, ciudad_residencia, perfil
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG Prácticas - Tutores</title>
        <script type="text/javascript" src="jscript/conectar.js"></script> 
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunDecPrac.js" ></script>
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
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
            
            .titulocom {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 20px;
                color: #990000;
            }
        </style>
    </head>

    <body >
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel">
            <tr style="height: 64px;">
                <td colspan="2" class="titulocom" style="text-align: center;">
                    Reportes de Prácticas Profesionales
                </td>
            </tr>
            <tr>
                <td class="texto_rojo2" align="right">Nombre del estudiante:</td>
                <td class="textocom2" align="left"><%=datosCartaprac.get("nom_est")%></td>
            </tr>
            <tr>
                <td class="texto_rojo2" align="right">Cargo a desempeñar:</td>
                <td class="textocom2" align="left"><%=datosCartaprac.get("cargo")%></td>
            </tr>
            <tr>
                <td class="texto_rojo2" align="right">Nombre de la empresa:</td>
                <td class="textocom2" align="left"><%=datosCartaprac.get("razon_social")%></td>
            </tr>
            <tr>
                <td class="texto_rojo2" align="right">NIT:</td>
                <td class="textocom2" align="left"><%=datosCartaprac.get("nit")%></td>
            </tr>
            <tr height="32"></tr>
            <%--<tr>
                <td  align='left' colspan="2">
                    <blockquote>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <p>Ingeniero(a)<br>
                        <%=datoDecEmp.get("email_usr")%> </p>
                        <p>DECANO DE <%=dpto%><br>
                        Escuela Colombiana de Ingenier&iacute;a Julio Garavito<br>
                        La Ciudad de Bogot&aacute;</p>
                        <p>Por medio de la presente informamos que el estudiante <%=datosCartaprac.get("nom_est")%>,
                        de la Escuela Colombiana de Ingenier&iacute;a
                        Julio Garavito, fue escogido para realizar la pr&aacute;ctica empresarial,
                        con el prop&oacute;sito fundamental de aproximarlo al ejercicio profesional
                        en una actividad que representa un valor agregado para su preparaci&oacute;n
                        acad&eacute;mica.</p>
                        <p>El perfil del cargo requerido es el siguiente:<br>
                        </p>
                        </blockquote>
                        <div align="center"> </div>
                        <table width="89%" border="1" align="center">
                            <tr>
                                <td colspan="2">
                                    <div align="center"><b>Datos de la empresa oferente</b></div>
                                </td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Nombre de la empresa (raz&oacute;n social)</b></td>
                                <td width="63%"><%=datosCartaprac.get("razon_social")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>N&uacute;mero de registro ante las autoridades competentes
                                        (NIT)</b></td>
                                <td width="63%"><%=datosCartaprac.get("nit")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Pa&iacute;s en el que se desarrollar&aacute; la pr&aacute;ctica</b></td>
                                <td width="63%"><%=datosCartaprac.get("pais_oferta")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Ciudad</b></td>
                                <td width="63%"><%=datosCartaprac.get("ciudad_oferta")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Direcci&oacute;n</b></td>
                                <td width="63%"><%=datosCartaprac.get("dir_empresa")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>P&aacute;gina Web</b></td>
                                <td width="63%"><%=datosCartaprac.get("web_empresa")%></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div align="center"><b>Pr&aacute;ctica ofrecida</b></div>
                                </td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Cargo o posici&oacute;n a desempe&ntilde;ar :</b></td>
                                <td width="63%"><%=datosCartaprac.get("cargo")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Descripcion:</b></td>
                                <td width="63%"><%=datosCartaprac.get("descripcion")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Jornada</b></td>
                                <td width="63%"><%=datosCartaprac.get("horario_oferta")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Estudiante del programa</b></td>
                                <td width="63%"><%=dpto%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Requisitos que debe cumplir el candidato </b></td>
                                <td width="63%"><%=datosCartaprac.get("requisitos")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Reporta a (Nombre)</b></td>
                                <td width="63%"><%=datosCartaprac.get("nom_jefe")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Reporta a (cargo o posici&oacute;n)</b></td>
                                <td width="63%"><%=datosCartaprac.get("cargo_jefe")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Tel&eacute;fono</b></td>
                                <td width="63%"><%=datosCartaprac.get("tel_jefe")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>E-mail</b></td>
                                <td width="63%"><%=datosCartaprac.get("email_jefe")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Tipo de contrato</b></td>
                                <td width="63%"><%=datosCartaprac.get("tipo_contrato")%></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div align="center"><b>Garant&iacute;as laborales</b></div>
                                </td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Sistema de seguro de salud y de riesgos laborales
                                        para el practicante</b></td>
                                <td width="63%"><%=datosCartaprac.get("seguro_arp")%></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div align="center"><b>Informaci&oacute;n adicional sobre la oferta</b></div>
                                </td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Fecha l&iacute;mite de recepci&oacute;n de hojas
                                        de vida</b></td>
                                <td width="63%"><%=datosCartaprac.get("fecha_limite")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Fecha inicio de la pr&aacute;ctica con validez acad&eacute;mica</b></td>
                                <td width="63%"><%=datosCartaprac.get("fecha_in")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Fecha finalizaci&oacute;n de la pr&aacute;ctica con
                                        validez acad&eacute;mica</b></td>
                                <td width="63%"><%=datosCartaprac.get("fecha_out")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>Nombre del Jefe de Recursos Humanos.</b></td>
                                <td width="63%"><%=datosCartaprac.get("nom_rrhh")%></td>
                            </tr>        
                            <tr>
                                <td width="37%"><b>Tel&eacute;fono del Jefe de Recursos Humanos</b></td>
                                <td width="63%"><%=datosCartaprac.get("tel_rrhh")%></td>
                            </tr>
                            <tr>
                                <td width="37%"><b>E-mail del Jefe de Recursos Humanos</b></td>
                                <td width="63%"><%=datosCartaprac.get("email_rrhh")%></td>
                            </tr>
                            <tr>
                                <td width="37%">&nbsp;</td>
                                <td width="63%">&nbsp;</td>
                            </tr>
                        </table>
                        <blockquote>
                        <p>&nbsp;</p>
                    </blockquote>
                </td>
            </tr>
            <tr>
                <td align='left' width="50%">
                    <blockquote>
                        <p>&nbsp;</p>
                        <p>__________________________</p>
                        <p>Frirma </p>
                        <p><%=datosCartaprac.get("nom_jefe")%></p>
                        <p>Jefe de Planta</p>
                    </blockquote>
                </td>
                <td width="50%">
                    <blockquote>
                        <p>&nbsp;</p>
                        <p>____________________________</p>
                        <p>Firma</p>
                        <p><%=datosCartaprac.get("nom_rrhh")%></p>
                        <p>Jefe RRHH</p>
                    </blockquote>
                </td>
            </tr>--%>
            <%if (!est.equals("j")) {%>
            <tr>
                <td colspan="2">
                    <div class="textocom" align="center"><b>
                            ------------------------Buscar Tutor--------------------
                            <table  width="80%" border="1" class="tabla" id="tablatutores2" align="center" >
                                <tr>
                                    <td width="25%">
                                        Nombre:
                                    </td>
                                    <td align="left">
                                        <input  class="inputlargo" name="nombretutor" id="nombretutor" type="text" size="20"><br>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="25%">
                                        Apellido:
                                    </td>
                                    <td align="left">
                                        <input  class="inputlargo" name="apellidotutor" id="apellidotutor" type="text" size="20"><br>
                                    </td>
                                </tr>

                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="submit"  value="Consultar" name="consultartutor" onclick= "consultarprofesores('<%=id_apli%>');"/>
                                    </td>
                                </tr>
                            </table>
                        </b>
                    </div>
                    <div style="height: 16px;"></div>
                    <div align="center">
                        <b>
                            <table width="80%" border="1" class="tabla" id="tablatutores" align="center" >
                                <thead>
                                    <tr>
                                        <th width="30%"><div class="textocom2" align="center"><strong>Resultados de la consulta</strong></div></th>
                                    </tr>
                                </thead>
                                <tbody id="cuerpotablatutores">
                                </tbody>
                            </table>
                        </b>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2">



                    <div class="textocom" align="center"><b>
                            ------------------------Tutor Seleccionado------------------------
                            <table  width="80%" border="1" class="tabla" id="tablatutorSelec" align="center" >
                                <thead>
                                    <tr>
                                        <th width="30%"><div align="center"><strong>Tutor seleccionado</strong></div></th>
                                        <th width="30%"><div align="center"><strong>Formalizar</strong></div></th>
                                    </tr>
                                </thead>
                                <tbody id="cuerpotablatutorSelec">
                                </tbody>
                            </table>
                        </b></div>
                </td>
            </tr>

            <%} else {%>

            <tr>
                <td colspan="2">
                    <div align="center"><b>
                            ------------------------Tutor Seleccionado------------------------
                            <table  width="80%" border="1" class="tabla" id="tablatutorSelec" align="center" >
                                <thead>
                                    <tr>
                                        <th width="30%"><div align="center"><strong>Tutor seleccionado</strong></div></th>
                                        <th width="30%"><div align="center"><strong><%=datosTutor.get("nom_prof")%></strong></div></th>
                                    </tr>
                                </thead>

                            </table>
                        </b>
                        <p>&nbsp;</p>

                    </div>
                    <input class="button_azul_consulta" type="submit" value="Salir" name="vobocarta" onclick= "window.close();"/>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                </td>

            </tr>
            <%}%>
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
    </body>
</html>
