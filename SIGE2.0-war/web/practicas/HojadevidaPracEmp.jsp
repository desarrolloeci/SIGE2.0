<%-- 
    Document   : HojadevidaPracEmp
    Created on : 21/01/2013, 11:45:34 AM
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

            String Funciones = new String();
            String Logros = new String();
            String idest = new String();
            String id_apli = new String();
            String usuario = new String();
            String est = new String();
            
            login.SessionEmpRemote empresa = (login.SessionEmpRemote) session.getAttribute("usuario");
            
            if (empresa == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.close();
                    </script>
                <%
                return;
            }
            
            
            usuario = empresa.getUser();
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar(usuario);
            
            session.setAttribute("emp", emp);
            
            idest = request.getParameter("ref");
            id_apli = request.getParameter("ida");

            HashMap estado_apli = emp.EstadoActApliPracEmp(id_apli);
            est = (String) estado_apli.get("estado_apli");
            
            HashMap datossol = emp.DatosSolEstEmp(id_apli);
            String dispo = (String) datossol.get("disponibilidad");
            
            if (dispo == null) {
                dispo = "El estudiante no ha registrado todavía un horario de disponibilidad para el proceso de selección, por favor contacte con el estudiante para confirmar su disponibilidad.";
            }
            
            HashMap datosContacto = emp.datosContPracEmp(idest);
            HashMap[] ExperienciasPrac = emp.getExperienciasPracEmp(idest);
            HashMap[] EstudiosPrac = emp.getEstudiosPracEmp(idest);
            HashMap[] TiposEstudios = emp.getTiposEstudiosPracEmp(idest);
            HashMap[] IdiomasPrac = emp.getIdiomasPracEmp(idest);
            HashMap[] Distinciones = emp.getDistincionesPracEmp(idest);
            HashMap[] Afiliaciones = emp.getAfiliacionesPracEmp(idest);
        %>
        <title>SIEMPREG - <%=datosContacto.get("nom_est")%></title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/funcionemp.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunEmpPrac.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/hojadevidaPrac.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <jsp:include page="encabezado_clasif_aplicante"></jsp:include>
        <div class="set_hv">
            <table style="border-collapse: separate; border-spacing: 0px 5px; background: #FFFFFF; width: 100%; text-align: left;">
                <tr>
                    <td>
                        <table style="width: 100%; border: 1px solid #E0E0E0; border-radius: 5px; margin: 0px auto; background: #F7F7F7;">
                            <tr style="height: 1em;"></tr>
                            <tr>
                                <td colspan="1" width="10%"></td>
                                <td colspan="1" class="texto_gris" align="left" width="60%">El estado actual del postulante es:</td>
                                <td colspan="1" class="texto_gris2" align="left" width="30%"><%=estado_apli.get("men_usr")%></td>
                            </tr>
                            <%
                                if (est.equals("a") || est.equals("b") || est.equals("d") || est.equals("f")) {
                            %>
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="2" class="texto_gris">
                                    Por favor seleccione el estado en el que se encuentra este estudiante:
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="1" align="left">
                                    <select name="estadoapliprac" id="estadoapliprac" style="width: 80%;">
                                        <option value="b">En entrevista con el psicólogo</option>
                                        <option value="d">En entrevista con el jefe directo</option>
                                        <option value="f">En pruebas de conocimiento</option>
                                        <option value="c">No sigue en el proceso por psicologo</option>
                                        <option value="e">No sigue en el proceso por jefe directo</option>
                                        <option value="g">No sigue en el proceso por pruebas de conocimiento</option>
                                        <option value="h">Contratado</option>
                                    </select>
                                </td>
                                <td colspan="1" align="left">
                                    <input class="button_rojo_clasif" type="submit" value="Clasificar" name="consultar" onclick= "ActestadoapliPrac(<%=id_apli%>,<%=idest%>);"/>
                                </td>
                            </tr>
                            <%
                                } else if (est.equals("h") || est.equals("j")) {
                            %>
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="2">
                                    <input type="submit" class="button_rojo_clasif" style="width: auto;" value="Generar Carta de Aceptación" name="consultar" onclick="generarCartaDecEmp(<%=id_apli%>);"/>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            <tr style="height: 1em;"></tr>
                        </table>
                        <table style="width: 100%; margin: 0px auto;">
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="3" class="href_rojo1" align="left">
                                    Disponibilidad del estudiante
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <tr>
                                <td colspan="1" align="left" width="10%"></td>
                                <td colspan="2" align="left" width="90%"> <a class="texto_gris">La disponibilidad del estudiante para el proceso de selección es la siguiente:</a></td>
                            </tr>
                            <tr>
                                <td colspan="1" align="left""></td>
                                <td colspan="2" class="texto_gris2" align="left"><%=dispo.replaceAll("\n", "<br>")%></td>
                            </tr>
                            <tr style="height: 2em;"></tr>
                        </table>
                        <table style="width: 100%; margin: 0px auto; text-align: left;">
                            <tr>
                                <td colspan="3" class="href_rojo1" align="left">
                                    Hoja de Vida
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <tr>
                                <td colspan="1" style="width: 10%;"></td>
                                <td colspan="1" style="width: 20%;" class="texto_gris2">
                                    <a class="">Nombre:</a>
                                </td>
                                <td colspan="1" style="width: 70%;" class="titulo_conv_publica texto_gris2">
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
                                    <%=!datosContacto.get("email2").toString().equals("")?"<br>" + datosContacto.get("email2"):""%>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="1" class="texto_gris2">
                                    Teléfono:
                                </td>
                                <td colspan="1" class="texto_gris2">
                                    <%=datosContacto.get("tel_corr")%><%=!datosContacto.get("tel2").toString().equals("")?" - " + datosContacto.get("tel2"):""%>
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
                                <td colspan="3" class="titulo_conv_publica href_rojo2">
                                    Perfil Profesional
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="2" class="texto_conv_publica texto_gris2" style="padding: 10px 20px; text-align: justify;">
                                    <%=datosContacto.get("perfil").toString().replace("\n", "<br />")%>                            
                                </td>
                            </tr>
                            <tr style="height: 2em;"></tr>
                            <%
                                if (ExperienciasPrac.length > 0) {
                            %>
                            <tr>
                                <td colspan="3" align="left">
                                    <div class="titulo_conv_publica" align="left">
                                        <a class="href_rojo2">Experiencia laboral</a>
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <%
                                    for (HashMap Experiencia : ExperienciasPrac) {
                                        Funciones = Experiencia.get("funciones").toString().replaceAll("\n", "<br>");
                                        Logros = Experiencia.get("logros").toString().replaceAll("\n", "<br>");
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
                                    Cargo:
                                </td>
                                <td colspan="1" class="texto_gris2">
                                    <%=Experiencia.get("cargo")%>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1"></td>
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
                                <td colspan="1"></td>
                                <td colspan="1" class="texto_gris2">
                                    Funciones:
                                </td>
                                <td colspan="1" class="texto_gris2" style="border: 2px solid #C0C0C0; border-width: 2px 0px; border-radius: 15px;">
                                    <pre style="white-space: pre-line; text-align: justify; font-family: inherit;"><%=Funciones%></pre>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="1" class="texto_gris2">
                                    Logros:
                                </td>
                                <td colspan="1" class="texto_gris2" style="border: 2px solid #C0C0C0; border-width: 2px 0px; border-radius: 15px;">
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
                                    Estudios realizados
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
                                    for (HashMap Idioma : IdiomasPrac) {
                            %>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="2" class="titulo_conv_publica texto_gris2">
                                    <%=Idioma.get("nom_idioma")%>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="1" class="texto_gris2">
                                    Nivel de lectura:
                                </td>
                                <td colspan="1" class="texto_gris2">
                                    <%=Idioma.get("niv_lectura")%>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="1" class="texto_gris2">
                                    Nivel de escritura:
                                </td>
                                <td colspan="1" class="texto_gris2">
                                    <%=Idioma.get("niv_escritura")%>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="1" class="texto_gris2">
                                    Nivel de habla:
                                </td>
                                <td colspan="1" class="texto_gris2">
                                    <%=Idioma.get("niv_habla")%>
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
                                <td colspan="1"></td>
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
                                    <%=distincion.get("f_distincion")%>
                                </td>
                            </tr>
                            <tr style="height: 2em;"></tr>
                            <%
                                    }
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
                                    for (HashMap afilia : Afiliaciones) {
                            %>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="2" class="titulo_conv_publica texto_gris2">
                                    <%=afilia.get("nom_aso")%>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="1"></td>
                                <td colspan="1" class="texto_gris2">
                                    Fecha:
                                </td>
                                <td colspan="1" class="texto_gris2">
                                    <%=afilia.get("f_in")%>
                                </td>
                            </tr>
                            <tr style="height: 2em;"></tr>
                            <%
                                    }
                                }
                            %>
                            <tr>
                                <td colspan="3" class="titulo_conv_publica href_rojo2">
                                    Lineas de profundización o Electivas cursadas
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="2" class="texto_conv_publica texto_gris2" style="padding: 10px 20px; text-align: justify;">
                                    <%=datossol.get("electivas").toString().replace("\n", "<br />")%>
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
                                    <%=datossol.get("expectativas").toString().replace("\n", "<br />")%>
                                </td>
                            </tr>
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="3" class="titulo_conv_publica href_rojo2">
                                    Referencias
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <tr>
                                <td colspan="1"></td>
                                <td colspan="2" class="texto_conv_publica texto_gris2" style="padding: 10px 20px; text-align: justify;">
                                    <%=datosContacto.get("referencias").toString().replace("\n", "<br />")%>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3" align="center">
                                    <jsp:include page="footer">
                                        <jsp:param name="type" value="prac" />
                                    </jsp:include>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>