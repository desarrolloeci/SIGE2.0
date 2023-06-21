<%-- 
    Document   : SolCambioPlanEst
    Created on : 1/10/2012, 12:14:29 PM
    Author     : Luis Alberto Salas
--%>



<%@page import="BDsige.EstudiantesRemote"%>
<%@page import="BDsige.DecanoRemote"%>
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
            String est = new String();
            String idsolicitud;
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
            //DecanoRemote bd = conEjb.lookupDecanoRemote();
            login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
            
            if (admin == null) {
                %>
                <script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loginDec';
                  </script>
                <%
                return;
            }
            
            String usuario = new String();
            String menest= new String();
            usuario = admin.getUser();
            emp.inicializar(usuario);
            idsolicitud = request.getParameter("idSolicitud");
            session.setAttribute("emp", emp);
            String id_est = new String();
            HashMap datosSolG = emp.datosSolicitudG(idsolicitud);
            id_est = (String) datosSolG.get("id_est");
            HashMap datos = emp.datosGeneralesEst(id_est);
            HashMap datosAC = emp.datosAcademicosEst(id_est);
            HashMap estado = emp.estadoAplicacion(idsolicitud);
            est = (String) estado.get("estado");
            String dpto = new String();
            if (datos.get("id_dpto").equals("13")) {
                dpto = "Ingenier&iacute;a Civil";
            }
            if (datos.get("id_dpto").equals("14")) {
                dpto = "Ingenier&iacute;a El&eacute;ctrica";
            }
            if (datos.get("id_dpto").equals("15")) {
                dpto = "Ingenier&iacute;a de Sistemas";
            }
            if (datos.get("id_dpto").equals("16")) {
                dpto = "Ingenier&iacute;a Industrial";
            }
            if (datos.get("id_dpto").equals("17")) {
                dpto = "Ingenier&iacute;a Electr&oacute;nica";
            }
            if (datos.get("id_dpto").equals("260")) {
                dpto = "Ingenier&iacute;a Mec&aacute;nica";
            }
            if (datos.get("id_dpto").equals("262")) {
                dpto = "Ingenier&iacute;a Biom&eacute;dica";
            }
            if (datos.get("id_dpto").equals("19")) {
                dpto = "Administraci&oacute;n de Empresas";
            }
            if (datos.get("id_dpto").equals("20")) {
                dpto = "Matem&aacute;ticas";
            }
            if (datos.get("id_dpto").equals("18")) {
                dpto = "Econom&iacute;a";
            }


        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG Movilidad - Cambio de Plan de Estudios</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
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
            
            .titulocom {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 20px;
                color: #990000;
            }
        </style>
    </head>
    <body >
        <jsp:include page="header">
            <jsp:param name="type" value="mov" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" style="padding: 15px 25px;">
            <tr style="height: 64px;">
                <td colspan="2" class="titulocom" style="text-align: center;">
                        Solicitud de cambio de Plan de Estudio para Movilidad
                </td>
            </tr>
            <tr>
                <td valign="top" class="textocom">
                    <table  width="635"  cellspacing="0">
                    <% if (est.equals("j         ")) {
                    %>
                        <tr> <td align="center" width="30%"> &nbsp; </td><td align="center" width="70%" > &nbsp; </td></tr>
                        <tr> <td align="center" colspan="2"><a class="textocom2">DATOS GENERALES</a> </td></tr> 
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr>
                            <td align="left">Nombre:</td>
                            <td align="left"> <font id="nom_est" color="#000000"><%=datos.get("nom_est")%></font>. </td></tr>
                        <tr><td align="left">
                                Documento de identidad:</td>
                            <td align="left"> <font id="doc_est" color="#000000"><%=datos.get("doc_est")%></font>


                            </td>
                        </tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr> <td align="center" colspan="2"><a class="textocom2" > DATOS ACADEMICOS</a> </td></tr> 
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr><td align="left">

                                Programa Académico:</td><td align="left"> <font id="id_dpto" color="#000000"><%=dpto%></font>.
                            </td></tr>
                        <tr><td align="left">
                                Semestre Actual:</td><td align="left"> <font id="sem_est" color="#000000"><%=datosAC.get("sem_est")%></font></td></tr>
                        <tr><td align="left">
                                Promedio del Semestre Anterior:</td><td align="left"> <font id="pr_semant" color="#000000"><%=datosSolG.get("prom_ant")%></font> </td></tr>
                        <tr><td align="left">
                                Promedio Acumulado:</td><td align="left"> <font id="prom_acum" color="#000000"><%=datosSolG.get("prom_acum")%></font> 
                            </td>
                        </tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr> <td align="center" colspan="2"><a class="textocom2" >DATOS DE LA SOLICITUD</a> </td></tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr>
                            <td align="left">
                                Programa de Movilidad Solicitado:</td><td align="left"> <font id="prog_mov" color="#000000"><%=datosSolG.get("prog_mov")%></font> 
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                Pais al que aplica: </td><td align="left"><font id="prog_mov" color="#000000"><%=datosSolG.get("pais_mov")%></font> 
                            </td>
                        </tr>
                        <tr>
                            <td align="left">

                                <br/>Fecha de inicio:</td><td align="left"><font id="fecha_in" color="#000000"><%=datosSolG.get("fecha_in")%></font>

                            </td>
                        </tr>
                        <tr>
                            <td align="left">

                                <br/>Fecha de finalización:</td><td align="left"> <font id="fecha_out" color="#000000"><%=datosSolG.get("fecha_out")%></font> 

                            </td>
                        </tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr>
                            <td colspan="2" align="left">
                                <p> Universidad Aceptada por el Estudiante:</p>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                Nombre de la Institución:</td><td align="left"><font id="uni_destino" color="#000000"><%=datosSolG.get("uni_destino")%></font> 
                            </td></tr>
                        <tr>
                            <td align="left">
                                Programa solicitado:</td><td align="left"><font id="prog_ud" color="#000000"><%=datosSolG.get("prog_ud")%></font> 
                            </td>
                        </tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr> <td align="center" colspan="2"><a class="textocom2" > PLAN DE ESTUDIO ACTUAL</a></td></tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <%
                            if (datosSolG.get("prog_mov").equals("PRACTICA INTERNACIONAL")) {

                        %>

                        <tr><td colspan="2">
                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                    <thead>
                                        <tr>
                                            <th ><div align="center"><strong>Periodo</strong></div></th>
                                            <th ><div align="center"><strong>Empresa</strong></div></th>
                                            <th ><div align="center"><strong>Materia de la ECI</strong></div></th>


                                        </tr>
                                    </thead>
                                    <tbody id="cuerpoplanpi">
                                    </tbody>
                                </table>
                            </td></tr>
                            <%                                    } else {
                                if (datosSolG.get("prog_mov").equals("DOBLE TITULACION")) {
                            %>
                        <tr><td colspan="2">
                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                    <thead>
                                        <tr>
                                            <th><div align="center"><strong>Periodo</strong></div></th>
                                            <th><div align="center"><strong>Materia en la Universidad anfitriona</strong></div></th>


                                        </tr>
                                    </thead>
                                    <tbody id="cuerpoplanpi">
                                    </tbody>
                                </table>
                            </td></tr>
                            <%                                        } else {
                            %>
                        <tr><td colspan="2">

                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                    <thead>
                                        <tr>
                                            <th><div align="center"><strong>Periodo</strong></div></th>
                                            <th><div align="center"><strong>Materia en la Universidad anfitriona</strong></div></th>
                                            <th ><div align="center"><strong>Materia de la ECI</strong></div></th>

                                        </tr>
                                    </thead>
                                    <tbody id="cuerpoplanpi">
                                    </tbody>
                                </table>
                            </td></tr>
                            <%                                                        }
                                }
                            %>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <%--<tr><td colspan="2">
                                <table frames="hsides" border="1" align="center">
                                    <tr>
                                        <td colspan="2" align="center">
                                            <input class="inputlargo" type="submit" value="mostrar plan actual" name="enviarplan" onclick= " ListaPlanDec(<%=idsolicitud%>);"/>
                                        </td>
                                    </tr>
                                </table>
                            </td></tr>--%>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>


                        <tr> <td align="center" colspan="2"><a class="textocom2" >SOLICITUD DE CAMBIO</a></td></tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>

                        <tr><td colspan="2">
                                <table  width="99%" border="1" class="tabla" id="tablaCambioPlan" align="center" >

                                    <thead>

                                        <tr>
                                            <th><div align="center"><strong>Materia Actual</strong></div></th>
                                            <th><div align="center"><strong>Materia Solicitada</strong></div></th>
                                            <th><div align="center"><strong>Periodo</strong></div></th>
                                            <th><div align="center"><strong>Motivo</strong></div></th>                                                                
                                        </tr>
                                    </thead>
                                    <tbody id="cuerpocambioplan">
                                    </tbody>
                                </table>
                            </td></tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
                        <tr> <td align="center" colspan="2"> &nbsp; </td></tr>

                    </table>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><a class="textocom2" > Comentarios sobre el Plan de estudio</a></td></tr>
            <tr>
                <td align="center">
                    <textarea name="comentariomov" id="comentariomov" rows="10" cols="38">Escriba su comentario....</textarea>
                </td>
            </tr>
            <tr> <td  colspan="2" align="center"><input class="button_azul_consulta1"type="submit" value="Enviar comentario" name="comen" onclick= " GuardarComentario(<%=idsolicitud%>, 'obv_plan');"/></td></tr>
            <tr>
            <script type="text/javascript">
                                                ListaCambioPlanDec(<%=idsolicitud%>);
            </script>
            <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
            <tr> <td align="center" colspan="2"> &nbsp; </td></tr>
            <td align="center">
                <input class="button_azul_consulta1" type="submit" value="Aceptar Cambio" name="vobocarta" onclick=  "AceptarcambioPlan(<%=idsolicitud%>,'<%=usuario%>');"/>
                <input class="button_azul_consulta1" type="submit" value="Dejar Pendiente" name="vobocarta" onclick= " DejarPendiente();"/>
                <input class="button_azul_consulta1" type="submit" value="Rechazar Cambio" name="vobocarta" onclick= " RechazarcambioPlan(<%=idsolicitud%>,'<%=usuario%>');"/>

            </td>

            </tr>



            <%
            } else {
            %>
            <tr>
                <td>
                    <br/>Este Plan de estudio ya fue tramitado su estado actual es:<%=estado.get("estado")%> <br/> <br/>
                </td>
            </tr>
            <%
                }

            %>
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
