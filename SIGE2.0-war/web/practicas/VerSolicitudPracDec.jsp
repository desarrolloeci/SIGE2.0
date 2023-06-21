<%-- 
    Document   : VerSolicitudPracDec
    Created on : 9/01/2013, 04:26:00 PM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.DecanoRemote"%>
<%@page import="BDsige.EstudiantesRemote"%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject;" %>
<!DOCTYPE html>

<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache");
            
            documentos.ruta ruta = new documentos.ruta();
            String Funciones = new String ();
            String Logros = new String ();
            
            String id_sol;
            String idofer;
            String idemp;
            String act="";
            
            String men_estado = new String();
            login.SessionUsrRemote admin =(login.SessionUsrRemote)session.getAttribute("usuario");
            
            if (admin == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'loginDec';
                    </script>
                <%
                return;
            }
            
            String rol = new String ();
            String usuario = new String ();
            String est= new String();
            String idest = new String ();
            usuario=admin.getUser();
            rol=admin.getRol();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            DecanoRemote emp = conEjb.lookupDecanoRemote();
            emp.inicializar(usuario);
            session.setAttribute("emp",emp);

            id_sol = request.getParameter("id_sol");
            HashMap id_est = emp.carnetEstPracDec(id_sol);
            
            idest= (String)id_est.get("id_documento");
            
            HashMap datos = emp.datosGeneralesEstPracDec(idest);
            HashMap datosAC = emp.datosAcademicosEstPracDec(idest);
            HashMap programaAC = emp.programaacademicoEstDec(idest);
            HashMap datosprac = emp.datospracDec(idest);
            HashMap datosContacto = emp.datosContPracDec(idest);
            
            HashMap[] ExperienciasPrac = emp.getExperienciasPracDec(idest);
            HashMap[] EstudiosPrac = emp.getEstudiosPracDec(idest);
            HashMap[] TiposEstudios = emp.getTiposEstudiosPracDec(idest);
            HashMap[] IdiomasPrac = emp.getIdiomasPracDec(idest);
            HashMap[] Distinciones = emp.getDistincionesPracDec(idest);
            HashMap[] Afiliaciones = emp.getAfiliacionesPracDec(idest);

            HashMap estado = emp.estadoSolPracDec(id_sol);
            est = (String) estado.get("estado");
            
            if (!est.equals("b         ")) {
                act = "disabled";
            }
            
            men_estado = (String) estado.get("men_solprac");
            HashMap DatosSol = emp.getDatosSolPracDec(id_sol);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG Prácticas Profesionales - Solicitud de estudiante</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunDecPrac.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
        <link href="CSS/hojadevida.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            .f {
                color: #FFF;
            }
            .textoblanco {
                color: #FFF;
            }
            
            .divHvTitle {
                width: 90%;
                background: #EEEEEE;
                text-align: center;
                font-size: 1.2em;
                padding: 0.2em 0px;
            }
            
            .detailsHV {
                width: 96%;
                height: 150px;
                background: #FFFFFF;
                border: 1px solid #C0C0C0;
                border-radius: 5px;
                padding: 10px 2%;
                white-space: pre-line;
                text-align: justify;
                overflow-y: scroll;
            }
            
            .loopsHV {
                width: 80%;
                margin: 0px auto;
                border: 1px solid #C0C0C0;
                border-radius: 5px;
                text-align: left;
            }
            
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
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        <div height="772" class ="curvas loginPanel"style="padding: 50px 100px; width: 750px; margin: 0px auto; " align="center">
            <%
                if (est != null && !est.equals("b         ")) {
            %>
            <div style="padding: 20px 0px; border: 1px solid #C0C0C0; border-radius: 5px; background: #F0F0F0; margin-bottom: 50px;">
                <td colspan="2" style="text-align: center; border: 2px solid #CECECE; border-radius: 8px; background: #F0F0F0;">
                    <span style="font-weight: 600; color: #900000;">ESTADO ACTUAL DE ESTA SOLICITUD</span><br>
                    <%=men_estado%>
                </td>
            </div>
            <%
                }
            %>
            <table style="width: 100%;">
                <tr>
                    <td colspan="2" class="textoblanco" style="padding: 10px 0px; text-align: center; background: #660000;">
                        <strong>Datos Generales del estudiante</strong>
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <tr class="textocom">
                    <td width="178" align="left"><strong>Nombre:</strong></td>
                    <td width="568" align="left" style="padding: 5px 0px 5px 10px;"><%=datos.get("nom_est")%></td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Fecha de nacimiento:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=datos.get("fec_nac")%></td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Numero de identificacion:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=datos.get("doc_est")%></td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Telefono de contacto:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=datos.get("tel_corr")%></td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Telefono de contacto 2:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=datosprac.get("tel2")%></td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Celular de contacto:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=datosprac.get("cel")%></td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Email de contacto:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=datos.get("emails")%>@mail.escuelaing.edu.co</td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Email de contacto 2:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=datosprac.get("email2")%></td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Programa Académico:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=programaAC.get("nom_prog")%></td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Promedio Acumulado:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=datosAC.get("prom_acum")%></td>
                </tr>
                <tr class="textocom">
                    <td align="left"><strong>Semestre Actual:</strong></td>
                    <td align="left" style="padding: 5px 0px 5px 10px;"><%=datosAC.get("sem_est")%></td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr class="textocom">
                    <td colspan="2" style="padding: 5px 0px 5px 0px; text-align: center;"><strong>Línea de profundización o Electivas técnicas cursadas</strong></td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr>
                    <td colspan="2" align="left">
                        <div class="detailsHV"><%=DatosSol.get("electivas")%></div>
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr class="textocom">
                    <td colspan="2" style="padding: 5px 0px 5px 0px; text-align: center;"><strong>Expectativas</strong></td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr>
                    <td colspan="2" align="left">
                        <div class="detailsHV"><%=DatosSol.get("expectativas")%></div>
                    </td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr class="textocom">
                    <td colspan="2" style="padding: 5px 0px 5px 0px; text-align: center;"><strong>Asignaturas a cursar conjunto a la Práctica Profesional</strong></td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr>
                    <td colspan="2" align="left">
                        <div class="detailsHV" readonly><%=DatosSol.get("asig_conjunta")%></div>
                    </td>
                </tr>
            </table>
            <table style="width: 100%; margin-top: 50px;">
                <tr class="textocom" >
                    <td colspan="2" class="textoblanco" style="padding: 10px 0px; text-align: center; background: #660000;">
                        <strong>Hoja de Vida del Estudiante</strong>
                    </td>
                </tr>
                <tr class="textocom" >
                    <td colspan="2" border="1">
                        <table style="width: 100%;">
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="2">
                                    <div  align="center">
                                        <%=datosContacto.get("nom_est")%><br>
                                        E-mail: <%=datosContacto.get("emails")%>@mail.escuelaing.edu.co<br>
                                        <%=datosContacto.get("email2")%><br>
                                        Teléfono: <%=datosContacto.get("tel_corr")%>-<%=datosContacto.get("tel2")%><br>
                                        Celular: <%=datosContacto.get("cel")%><br>
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div class="divHvTitle">
                                        Perfil Profesional
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <tr>
                                <td colspan="2">
                                    <div style="width: 80%; margin: 0px auto; white-space: pre-line; text-align: justify; font-family: inherit;">
                                        <%=datosContacto.get("perfil")%>
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 2em;"></tr>
                            <%
                                if (ExperienciasPrac.length > 0) {
                            %>
                            <tr>
                                <td colspan="2" align="center">
                                    <div class="divHvTitle">
                                        Experiencia Laboral
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <%
                                    for (HashMap Experiencia: ExperienciasPrac) {
                                        Funciones = ((String) Experiencia.get("funciones")).replaceAll("\n", "<br>");
                                        Logros = ((String) Experiencia.get("logros")).replaceAll("\n", "<br>");
                            %>
                            <tr>
                                <td colspan="2">
                                    <table class="loopsHV">
                                        <tr>
                                            <td colspan="2" class="divHvTitle" style="text-align: left; font-size: inherit;"><%=Experiencia.get("nom_empresa")%></td>
                                        </tr>
                                        <tr>
                                            <td width="25%">Cargo:</td>
                                            <td width="75%"><%=Experiencia.get("cargo")%></td>
                                        </tr>
                                        <tr>
                                            <td>Desde:</td>
                                            <td><%=Experiencia.get("fecha_in_cargo")%></td>
                                        </tr>
                                        <tr>
                                            <td>Hasta:</td>
                                            <td><%=Experiencia.get("fecha_out_cargo").equals("1900/01") ? "Actualidad" : Experiencia.get("fecha_out_cargo")%></td>
                                        </tr>
                                        <tr>
                                            <td>Funciones:</td>
                                            <td>
                                                <div style="white-space: pre-line; text-align: justify; font-family: inherit;"><%=Funciones%></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Logros:</td>
                                            <td>
                                                <div style="white-space: pre-line; text-align: justify; font-family: inherit;"><%=Logros%></div>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <%      }
                                }
                                if (EstudiosPrac.length > 0) {
                            %>
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div class="divHvTitle">
                                        Estudios realizados
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <%
                                    for (HashMap tipoEst : TiposEstudios) {
                                        if (TiposEstudios.length > 1 || Integer.parseInt((String) tipoEst.get("ID")) != 5) {
                            %>
                            <tr style="height: 1em;"></tr>
                            <tr>
                                <td colspan="2">
                                    <div class="divHvTitle" style="width: 80%; margin: 0px auto; font-weight: bold; text-align: left;">
                                        <%=tipoEst.get("nom_tipo")%>
                                    </div>
                                </td>
                            </tr>
                            <%
                                        }
                                        for (HashMap Estudio: EstudiosPrac) {
                                            if (Integer.parseInt((String) Estudio.get("tipo_estudio")) == Integer.parseInt((String) tipoEst.get("ID"))) {
                            %>
                            <tr>
                                <td colspan="2">
                                    <table class="loopsHV">
                                        <tr>
                                            <td colspan="2" class="divHvTitle" style="text-align: left; font-size: inherit;"><%=Estudio.get("nom_estudio")%></td>
                                        </tr>
                                        <tr>
                                            <td width="25%" align="left">Institución:</td>
                                            <td width="75%" align="left"><%=Estudio.get("nom_inst")%></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha de grado:</td>
                                            <td><%=Estudio.get("f_grado")%></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <%
                                            }
                                        }
                                    }
                                }

                                if (IdiomasPrac.length > 0) {
                            %>
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div class="divHvTitle">
                                        Idiomas
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <%
                                    for (HashMap Idioma : IdiomasPrac) {
                            %>
                            <tr>
                                <td colspan="2">
                                    <table class="loopsHV">
                                        <tr>
                                            <td colspan="2" class="divHvTitle" style="text-align: left; font-size: inherit;"><%=Idioma.get("nom_idioma")%></td>
                                        </tr>
                                        <tr>
                                            <td width="25%">Nivel de lectura:</td>
                                            <td width="75%"><%=Idioma.get("niv_lectura")%></td>
                                        </tr>
                                        <tr>
                                            <td>Nivel de escritura:</td>
                                            <td><%=Idioma.get("niv_escritura")%></td>
                                        </tr>
                                        <tr>
                                            <td>Nivel de habla:</td>
                                            <td><%=Idioma.get("niv_habla")%></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                                
                                if (Distinciones.length > 0) {
                            %>
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div class="divHvTitle">
                                        Distinciones
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <%
                                    for (HashMap Distincion : Distinciones) {
                            %>
                            <tr>
                                <td colspan="2">
                                    <table class="loopsHV">
                                        <tr>
                                            <td colspan="2" class="divHvTitle" style="text-align: left; font-size: inherit;"><%=Distincion.get("nom_distincion")%></td>
                                        </tr>
                                        <tr>
                                            <td width="25%">Institución:</td>
                                            <td width="75%"><%=Distincion.get("lugar_distincion")%></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha: </td>
                                            <td><%=Distincion.get("fecha_distincion")%></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                                
                                if (Afiliaciones.length > 0) {
                            %>
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div class="divHvTitle">
                                        Afiliaciones
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <%
                                    for (HashMap Afiliacion : Afiliaciones) {
                            %>
                            <tr>
                                <td colspan="2">
                                    <table class="loopsHV">
                                        <tr>
                                            <td colspan="2" class="divHvTitle" style="text-align: left; font-size: inherit;"><%=Afiliacion.get("nom_aso")%></td>
                                        </tr>
                                        <tr>
                                            <td width="25%">Fecha:</td>
                                            <td width="75%"><%=Afiliacion.get("fecha_in")%></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                            <tr style="height: 2em;"></tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <div class="divHvTitle">
                                        Referencias
                                    </div>
                                </td>
                            </tr>
                            <tr style="height: 1em;"></tr>
                            <tr>
                                <td colspan="2">
                                    <div style="width: 80%; margin: 0px auto; white-space: pre-line; text-align: justify; font-family: inherit;">
                                        <%=datosContacto.get("referencias")%>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <%
                if (est != null && !est.equals("b         ")) {
            %>
            <div style="padding: 20px 0px; border: 1px solid #C0C0C0; border-radius: 5px; background: #F0F0F0; margin-top: 50px;">
                <td colspan="2" style="text-align: center; border: 2px solid #CECECE; border-radius: 8px; background: #F0F0F0;">
                    <span style="font-weight: 600; color: #900000;">ESTADO ACTUAL DE ESTA SOLICITUD</span><br>
                    <%=men_estado%>
                </td>
            </div>
            <%
                }
            %>
            <table style=" width: 100%; margin-top: 50px; border: 1px solid #D2D2D2; border-radius: 5px; border-spacing: 0px;">
                <tr class="textocom">
                    <td class="textoblanco" style="padding: 10px 0px; text-align: center; background: #660000;">
                        <strong>Trámite de aceptación al programa</strong>
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <tr class="textocom">
                    <td style="padding: 0px 20px;"><strong>Comentarios sobre la Solicitud:</strong></td>
                </tr>
                <tr style="height: 1em;"></tr>
                <tr class="textocom">
                    <td style="padding: 0px 20px;">
                        <textarea class="detailsHV" name="comentarioDecSolPrac" id="comentarioDecSolPrac" style="height: 150px;" rows="15" cols="38" placeholder="Escriba sus comentarios en este espacio, en caso de Devolver la solicitud el estudiante podrá leerlos." <%=act%>><%=DatosSol.get("observaciones") == null ? "" : DatosSol.get("observaciones")%></textarea>
                    </td>
                </tr>
                <tr style="height: 2em;"></tr>
                <tr class="textocom">
                    <td class="textoblanco" style="padding: 10px 0px; text-align: center; background: #660000;">
                        <strong>La solicitud tiene validez académica y puede ser aprobada</strong>
                    </td>
                </tr>
                <tr class="textocom" style="height: 98px;">
                    <td align="center">
                        <input type="submit" value="Devolver" name="Devolver" style="padding: 3px 0px;" onclick="DevolverSolprac(<%=id_sol%>);" <%=act%>/>
                        <input type="submit" value="Rechazar" name="vobocarta" style="padding: 3px 0px;" onclick="RechazarSolprac(<%=id_sol%>);" <%=act%>/>
                        <br><br>
                        <input type="submit" value="Aprobar" name="vobocarta" style="padding: 3px 0px;" onclick="AprobarSolprac(<%=id_sol%>);" <%=act%>/>
                        <input type="submit" value="Dejar Pendiente" name="vobocarta" style="padding: 3px 0px;" onclick="window.close();" <%=act%>/>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
