<%-- 
    Document   : SolPlandeEstudio
    Created on : 10/09/2012, 09:32:12 AM
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
            //DecanoRemote bd = conEjb.lookupDecanoRemote();
            emp.inicializar(usuario);
            idsolicitud = request.getParameter("idSolicitud");
            session.setAttribute("emp", emp);
            String id_est = new String();
            HashMap datosSolG = emp.datosSolicitudG(idsolicitud);
            String comentarios = new String();
            id_est = (String) datosSolG.get("id_est");
            HashMap datos = emp.datosGeneralesEst(id_est);
            HashMap datosAC = emp.datosAcademicosEst(id_est);
            HashMap estado = emp.estadoAplicacion(idsolicitud);
            est = (String) estado.get("estado");
            
            HashMap mensajeestado = emp.mensajeestado(est);
            menest = (String) mensajeestado.get("men_est");
            comentarios = (String) datosSolG.get("obv_plan");
            if (comentarios != null && !comentarios.equals("NULL")) {                
                comentarios = comentarios.replaceAll("null", "");
                comentarios = comentarios.replaceAll("Ã¡", "á");
                comentarios = comentarios.replaceAll("Ã©", "é");
                comentarios = comentarios.replaceAll("Ã­", "í");
                comentarios = comentarios.replaceAll("Ã³", "ó");
                comentarios = comentarios.replaceAll("Ãº", "ú");
                comentarios = comentarios.replaceAll("Ã±", "ñ");
                comentarios = comentarios.replaceAll("\n", "<br>");
            }
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
        <title>SIEMPREG Movilidad - Aprobación de Plan de Estudios</title>
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
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="mov" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" style="padding: 15px 25px;">
            <tr style="height: 64px;">
                <td colspan="2" class="titulocom" style="text-align: center;">
                        Solicitud de Plan de Estudio para Movilidad
                </td>
            </tr>
            <tr>
                <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" align="left">
                    <table  width="640"  cellspacing="0">
                    <% if (est.equals("g         ")) {
                    %>

                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr> <td colspan="2" align="center"><a class="textocom2">DATOS GENERALES</a> </td></tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr>
                        <td>
                            Nombre:
                        </td>
                        <td>
                            <font id="nom_est" color="#000000"><%=datos.get("nom_est")%></font>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Carné:
                        </td>
                        <td>
                            <font id="doc_est" color="#000000"><%=id_est%></font>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Documento de identidad:
                        </td>
                        <td>
                            <font id="doc_est" color="#000000"><%=datos.get("doc_est")%></font>
                        </td>
                    </tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr> <td colspan="2" align="center"><a class="textocom2"> DATOS ACADEMICOS</a> </td></tr> 
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr>
                        <td>
                            Programa Académico:
                        </td>
                        <td>
                            <font id="id_dpto" color="#000000"><%=dpto%></font>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Semestre Actual:
                        </td>
                        <td>
                            <font id="sem_est" color="#000000"><%=datosAC.get("sem_est")%></font>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Promedio del Semestre Anterior:
                        </td>
                        <td>
                            <font id="pr_semant" color="#000000"><%=datosSolG.get("prom_ant")%></font>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Promedio Acumulado:
                        </td>
                        <td>
                            <font id="prom_acum" color="#000000"><%=datosSolG.get("prom_acum")%></font>
                        </td>
                    </tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>


                    <tr> <td colspan="2" align="center"><a class="textocom2"> DATOS DE LA SOLICITUD</a> </td></tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr>
                        <td>
                            Programa de Movilidad Solicitado:
                        </td>
                        <td>
                            <font id="prog_mov" color="#000000"><%=datosSolG.get("prog_mov")%></font>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Pais al que aplica:
                        </td>
                        <td>
                            <font id="prog_mov" color="#000000"><%=datosSolG.get("pais_mov")%></font>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Fecha de inicio:
                        </td>
                        <td>
                            <font id="fecha_in" color="#000000"><%=datosSolG.get("fecha_in")%></font>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Fecha de finalización:
                        </td>
                        <td>
                            <font id="fecha_out" color="#000000"><%=datosSolG.get("fecha_out")%></font>
                        </td>
                    </tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr>
                        <td colspan="2">
                            Universidad Aceptada por el Estudiante:
                        </td>
                    </tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr>
                        <td>
                            Nombre de la Institución:
                        </td>
                        <td>
                            <font id="uni_destino" color="#000000"><%=datosSolG.get("uni_destino")%></font>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Programa solicitado:
                        </td>
                        <td>
                            <font id="prog_ud" color="#000000"><%=datosSolG.get("prog_ud")%></font>
                        </td>
                    </tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr> <td colspan="2" align="center"><a class="textocom2">PLAN DE ESTUDIO PROPUESTO POR EL ESTUDIANTE</a></td></tr>
                    <tr><td colspan="2">
                            <%
                                if (datosSolG.get("prog_mov").equals("PRACTICA INTERNACIONAL")) {

                            %>


                            <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                <thead>
                                    <tr>
                                        <th ><div align="center"><strong>Periodo</strong></div></th>
                                        <th ><div align="center"><strong>Empresa</strong></div></th>
                                        <th ><div align="center"><strong>Materia de la Escuela</strong></div></th>


                                    </tr>
                                </thead>
                                <tbody id="cuerpoplanpi">
                                </tbody>
                            </table>


                            <%                                    } else {
                                if (datosSolG.get("prog_mov").equals("DOBLE TITULACION")) {
                            %>

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
                            <%                                        } else {
                            %>


                            <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                <thead>
                                    <tr>
                                        <th><div align="center"><strong>Periodo</strong></div></th>
                                        <th><div align="center"><strong>Materia en la Universidad anfitriona</strong></div></th>
                                        <th ><div align="center"><strong>Materia de la Escuela</strong></div></th>

                                    </tr>
                                </thead>
                                <tbody id="cuerpoplanpi">
                                </tbody>
                            </table>                                               
                            <%                                                        }
                                }
                            %>
                        </td></tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr><td align="center" colspan="2">
                            <a class="textocom2">Comentarios sobre el Plan de estudio</a> 
                        </td>
                    </tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr>
                        <td colspan="2">                                    
                            <a class="textocom2">Comentarios Anteriores:</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">                                    
                            <%=comentarios%>
                        </td>
                    </tr>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <tr>
                        <td  colspan="2" align="center">
                            <br/><p> </p>
                            <textarea name="comentariomov" id="comentariomov" rows="10" cols="38">Escriba su comentario....</textarea>
                        </td>
                    </tr>
                    <tr> <td   colspan="2" align="center"><input class="button_azul_consulta" type="submit" value="Enviar comentario" name="comen" onclick= " GuardarComentario(<%=idsolicitud%>, 'obv_plan');"/></td></tr>
                    <tr>
                    <script type="text/javascript">
                        ListaPlanDec(<%=idsolicitud%>);
                    </script>
                    <tr> <td width="35%">                                    
                            &nbsp;
                        </td>
                        <td width="65%">                                    
                            &nbsp;
                        </td></td></tr>
                    <td align="center" align="center" colspan="2">
                        <input class="button_azul_consulta" type="submit" value="Aceptar" name="vobocarta" onclick= " AceptarPlan(<%=idsolicitud%>,'<%=usuario%>');"/>
                        <input class="button_azul_consulta" type="submit" value="Dejar Pendiente" name="vobocarta" onclick= " DejarPendiente();"/>
                        <input class="button_azul_consulta" type="submit" value="Devolver" name="Devolver" onclick= " DevolverPlan(<%=idsolicitud%>,'<%=usuario%>');"/>
                        <input class="button_azul_consulta" type="submit" value="Rechazar" name="vobocarta" onclick= " RechazarSolicitud(<%=idsolicitud%>,'<%=usuario%>');"/>                          
                    </td>

        </tr>



        <%
        } else {
        %>
        <tr>
            <td>
                <br/>Este Plan de estudio ya fue tramitado su estado actual es:<%=menest%> <br/> <br/>
            </td>
        </tr>
        <%
            }

        %>
    </table>
    </td>
    </tr>
     <tr>
            <td >
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