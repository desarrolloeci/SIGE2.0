<%-- 
    Document   : infoPracAdmin
    Created on : 21/05/2013, 09:47:59 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.DecanoRemote"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,
         javax.rmi.PortableRemoteObject"
         %>

<html>
    <head>
        <%

            response.setHeader("Cache-Control", "no-cache");

            documentos.ruta ruta = new documentos.ruta();
            String Funciones = new String();
            String Logros = new String();

            String id_est;
            String idsol;
            String idofer;
            String idemp;
            String act = "";
            int t, e, f, d, ban, ap;
            //String paramtext = new String();
            //String titulo = new String("Servicio a Administradores");
            String men_estado = new String();
            login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
            String rol = new String();
            String usuario = new String();
            String est = new String();
            String idest = new String();
            usuario = admin.getUser();
            rol = admin.getRol();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            DecanoRemote emp = conEjb.lookupDecanoRemote();
            emp.inicializar(usuario);
            session.setAttribute("emp", emp);
            // session.setAttribute("emp", emp ) ;
            idest = request.getParameter("ca");
            HashMap id_sol = emp.idSolEstPrac(idest);
            //HashMap SolicitudPrac = emp.getDatosSolPracDec(id_sol)
            idsol = (String) id_sol.get("id");
            //Hashmap datosgenGrad= emp.
            HashMap datos = emp.datosGeneralesEstPracDec(idest);
            HashMap datosAC = emp.datosAcademicosEstPracDec(idest);
            HashMap programaAC = emp.programaacademicoEstDec(idest);
            HashMap datosprac = emp.datospracDec(idest);
            HashMap datosContacto = emp.datosContPracDec(idest);
            HashMap[] ExperienciasGrad = emp.getExperienciasPracDec(idest);
            HashMap[] EstudiosGrad = emp.getEstudiosPracDec(idest);
            HashMap[] IdiomasGrad = emp.getIdiomasPracDec(idest);
            HashMap[] OfertasAPPrac = emp.getOfertasAPPrac(idest);
            HashMap[] Distinciones = emp.getDistincionesPracDec(idest);
            HashMap[] Afiliaciones = emp.getAfiliacionesPracDec(idest);
            f = Afiliaciones.length;
            d = Distinciones.length;
            t = ExperienciasGrad.length;
            e = EstudiosGrad.length;
            ban = IdiomasGrad.length;
            ap = OfertasAPPrac.length;
            HashMap estado = emp.estadoSolPracDec(idsol);
            est = (String) estado.get("estado");
            if (!est.equals("b         ")) {
                act = "disabled";
            }
            men_estado = (String) estado.get("men_solprac");
            HashMap DatosSol = emp.getDatosSolPracDec(idsol);

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <style type="text/css">
            .f {
                color: #FFF;
            }
            .textoblanco {
                color: #FFF;
            }
        </style>
        <title>Menu Sige</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunDecPrac.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunEmpPrac.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
        <link href="CSS/hojadevidaPrac.css" rel="stylesheet" type="text/css">
    </head>
    <body >
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_prac"></jsp:include>
            <div align="center">
                <fieldset class="field_set">
                    <table width="700" height="752"  align="center">

                        <tr>
                            <td colspan="2" width="100%" align="center" valign="middle">
                                <table width="100%"  align="center">
                                    <tr >
                                        <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                    </tr>
                                    <tr >
                                        <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                    </tr>
                                    <tr >
                                        <td colspan="2" align="center" valign="middle"  ><a class="textocom3">Datos Generales del estudiante</a></td>
                                    </tr>
                                    <tr >
                                        <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                    </tr>
                                    <tr >
                                        <td width="30%"align="left"><a class="textocom2">Nombre:</a></td>
                                        <td width="70%" align="left"><a class="textocom"><%=datos.get("nom_est")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Fecha de nacimiento:</a></p></td>
                                    <td align="left"><a class="textocom"><%=datos.get("fec_nac")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Numero de identificacion:</a></td>
                                    <td align="left"><a class="textocom"><%=datos.get("doc_est")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Telefono de contacto:</a></td>
                                    <td align="left"><a class="textocom"><%=datos.get("tel_corr")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Telefono de contacto 2:</a></td>
                                    <td align="left"><a class="textocom"><%=datosprac.get("tel2")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Celular de contacto:</a></td>
                                    <td align="left"><a class="textocom"><%=datosprac.get("cel")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Email de contacto:</a></td>
                                    <td align="left"><a class="textocom"><%=datos.get("emails")%>@mail.escuelaing.edu.co</a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Email de contacto 2:</a></td>
                                    <td align="left"><a class="textocom"><%=datosprac.get("email2")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Programa Académico:</a></td>
                                    <td align="left"><a class="textocom"><%=programaAC.get("nom_prog")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Promedio Acumulado:</a></td>
                                    <td align="left"><a class="textocom"><%=datosAC.get("prom_acum")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Semestre Actual:</a></td>
                                    <td align="left"><a class="textocom"><%=datosAC.get("sem_est")%></a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Línea de profundización o Electivas técnicas:</strong></td>
                                    <td align="left"><textarea name="electivasprac" id="electivasprac" rows="10" cols="38" disabled><%=DatosSol.get("electivas")%></textarea></td>
                                </tr>
                                <tr  >
                                    <td align="left"><a class="textocom2">Expectativas:</a></td>
                                    <td align="left"><textarea name="exvprac" id="exvprac" rows="10" cols="38" disabled><%=DatosSol.get("expectativas")%></textarea></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center" valign="middle"  ><a class="textocom3">Hoja de Vida del Estudiante</a></td>
                                </tr>
                                <tr >
                                    <td colspan="2" align="center" valign="middle"  >&nbsp;</td>
                                </tr>
                                <tr>
                                    <td colspan="2" >
                                        <table width="100%" class="tabla_hv" rules="none" border="1"align="center" cellspacing="0" >
                                            <tr>
                                                <td align="center">

                                                    <table width="90%"  >
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
                                                        <%if (d != 0) {%>

                                                        <tr>
                                                            <td colspan="10" align="left">
                                                                <div class="titulo_conv_publica" align="left">
                                                                    <a class="href_rojo2">Distinciones</a>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="10" align="left">
                                                                <a>&nbsp;</a>
                                                            </td>
                                                        </tr>

                                                        <%
                                                            HashMap distin;
                                                            for (int b = 0; b < d; b++) {
                                                                distin = Distinciones[b];

                                                        %>

                                                        <tr>
                                                            <td colspan="1" width="3%" align="left">
                                                                &nbsp;

                                                            </td>
                                                            <td colspan="9" width="97%"align="left">
                                                                <div class="titulo_conv_publica" align="left">
                                                                    <a class="texto_gris2"><%=distin.get("nom_distincion")%></a>
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

                                                                <a class="texto_gris2"><%=distin.get("lugar_distincion")%></a>

                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="1" width="13%" align="left">
                                                                <a class="texto_negro2">&nbsp;</a>
                                                            </td>
                                                            <td colspan="2" width="13%" align="left">
                                                                <a class="texto_gris2">Fecha:</a>
                                                            </td>
                                                            <td colspan="7" width="74%"align="left">

                                                                <a class="texto_gris2"><%=distin.get("fecha_distincion")%></a>

                                                            </td>
                                                        </tr>
                                                        <%}
                                                }%>

                                                        <%if (f != 0) {%>

                                                        <tr>
                                                            <td colspan="10" align="left">
                                                                <div class="titulo_conv_publica" align="left">
                                                                    <a class="href_rojo2">Afiliaciones</a>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="10" align="left">
                                                                <a>&nbsp;</a>
                                                            </td>
                                                        </tr>

                                                        <%
                                                            HashMap afilia;
                                                            for (int b = 0; b < f; b++) {
                                                                afilia = Afiliaciones[b];

                                                        %>

                                                        <tr>
                                                            <td colspan="1" width="3%" align="left">
                                                                &nbsp;

                                                            </td>
                                                            <td colspan="9" width="97%"align="left">
                                                                <div class="titulo_conv_publica" align="left">
                                                                    <a class="texto_gris2"><%=afilia.get("nom_aso")%></a>
                                                                </div>                             
                                                            </td>
                                                        </tr>

                                                        <tr>
                                                            <td colspan="1" width="13%" align="left">
                                                                <a class="texto_negro2">&nbsp;</a>
                                                            </td>
                                                            <td colspan="2" width="13%" align="left">
                                                                <a class="texto_gris2">Fecha:</a>
                                                            </td>
                                                            <td colspan="7" width="74%"align="left">

                                                                <a class="texto_gris2"><%=afilia.get("fecha_in")%></a>

                                                            </td>
                                                        </tr>
                                                        <%}
                                                }%>



                                                    </table>
                                                </td>
                                            </tr>
                                        </table>


                                    </td>
                                </tr>

                                <tr>
                                    <td width="20%">&nbsp;</td>
                                    <td width="80%">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td width="20%">&nbsp;</td>
                                    <td width="80%">&nbsp;</td>
                                </tr>
                            </table>

                </table>

                <table>
                    <tr class="textocom">
                         <td colspan="2" align="center" valign="middle"  ><a class="textocom3">Tramite de aceptación al programa</a></td>
                    </tr>
                    <tr>
                                    <td width="20%">&nbsp;</td>
                                    <td width="80%">&nbsp;</td>
                                </tr>
                    <tr class="textocom" >
                        <td  align="left" width="178"><strong>Programa de práctica solicitado:</strong></td>
                        <td align="left"><%=DatosSol.get("jornada")%></td>
                    </tr>
                    <tr>
                                    <td width="20%">&nbsp;</td>
                                    <td width="80%">&nbsp;</td>
                                </tr>
                    <tr class="textocom" >
                        <td align="left"><strong>Asignaturas por las que contara la práctica</strong></td>
                        <%if(DatosSol.get("jornada").equals("MEDIO TIEMPO")){%>
                        <td align="left">1 electiva</td>
                        <%}else{%>
                        <td align="left">2 electivas</td>
                        <%}%>
                    </tr>
                    <tr>
                                    <td width="20%">&nbsp;</td>
                                    <td width="80%">&nbsp;</td>
                                </tr>
                    <tr class="textocom" >
                        <td align="left"><strong>Comentarios sobre la Solicitud:</strong></td>
                        <td align="left"><textarea name="comentarioDecSolPrac" id="comentarioDecSolPrac" rows="10" cols="38" <%=act%> ><%=DatosSol.get("observaciones")%></textarea></td>
                    </tr>
                              <tr>
                                    <td width="20%">&nbsp;</td>
                                    <td width="80%">&nbsp;</td>
                                </tr>
                    <tr class="textocom" >
                        <td align="left"><strong>Estado de la Solicitud</strong></td>
                        <td align="left"><%=men_estado%></td>
                    </tr>
                    <tr>
                                    <td width="20%">&nbsp;</td>
                                    <td width="80%">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td width="20%">&nbsp;</td>
                                    <td width="80%">&nbsp;</td>
                                </tr>
                    <tr class="textocom">
                        <td colspan="2" align="center" valign="middle"  ><a class="textocom3">Ofertas a las que Ha aplicado</a></td>
                    </tr>
                    <tr>
                                    <td width="20%">&nbsp;</td>
                                    <td width="80%">&nbsp;</td>
                                </tr>
                    <tr class="textocom">
                        <td colspan="2" align="center" valign="middle">
                            <table border="1" >
                                <tr class="textocom">
                                    <td><strong>Cargo</strong></td>
                                    <td><strong>Empresa</strong></td>
                                    <td><strong>Estado</strong></td>
                                </tr>
                                <%
                                    HashMap Aplicaciones;
                                    for (int i = 0; i < ap; i++) {
                                        Aplicaciones = OfertasAPPrac[i];
                                %>
                                <tr class="textocom">
                                    <td><a target='_blank' href='VerOfertaEmpAdminP?idofer=<%=Aplicaciones.get("id_oferta")%>'onclick='window.open(this.href, ventana_, toolbar = no, scrollbars = yes, location = yes, directories = yes, status = no, menubar = no, resizable = yes);
                                        return false;'><%=Aplicaciones.get("cargo")%></a></td>
                                    <td><%=Aplicaciones.get("razon_social")%></td>
                                    <%if(Aplicaciones.get("men_admin").equals("Contratado")){%>
                                    <td><a  href="CartaPracAdmin?ida=<%=Aplicaciones.get("id_aplicacion")%>"><%=Aplicaciones.get("men_admin")%></a></td>
                                    <%}else{%>
                                    <td><%=Aplicaciones.get("men_admin")%></td>
                                    <%}%>
                                </tr>
                                <%}%>
                            </table>
                        </td>
                    </tr>
                    <tr>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td align="center" colspan="2">
                                        <input class="href_rojo1" type="submit" onclick="window.close()" value="Cerrar" />
                                    </td>

                                </tr>
                </table>
            </fieldset>
        </div>
    </body>
</html>
