<%-- 
    Document   : logSolicitudMov
    Created on : 4/09/2014, 02:22:29 PM
    Author     : Luis Salas
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
            String idsolicitud;
            String id_est = new String();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
            login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");     
            String usuario = new String();
            usuario = admin.getUser();
            emp.inicializar(usuario);
            idsolicitud = request.getParameter("i");
            HashMap comentarios = emp.cometarios_sol(idsolicitud);
            session.setAttribute("emp", emp);
            HashMap idest = emp.estadoAplicacion(idsolicitud);
            id_est = (String) idest.get("id_est");
            HashMap AdministradorMov= emp.AdministradorMov();
            HashMap []auditoria=emp.getAuditoriaMov(idsolicitud);
            HashMap datosSolGeneral = emp.datosSolicitudGeneral(idsolicitud);
            HashMap datosOpcionUni[] = emp.datosOpcionUni(idsolicitud);
            HashMap datosSolG = emp.datosSolicitudG(idsolicitud);
            HashMap datos = emp.datosGeneralesEst(id_est);
            HashMap datosAC = emp.datosAcademicosEst(id_est);


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
        <title>INFORMACION GENERAL</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
    </head>
    <body >

        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_mov"></jsp:include>
            <div align="center">
                <fieldset class="field_set">
                    <table width="640" border="0" align="center" cellspacing="0">
                        <tr>
                            <td align="center"  > <a class="texto_rojo1">
                                    INFORMACION GENERAL </a> </td>
                        </tr>
                        <tr>
                            <td align="left" valign="top" height="500"  bgcolor="#FFFFFF" class="textocom">
                                <table  width="635"  border="0"cellspacing="0">
                                    <tr>
                                        <td width=25% align="center"   >
                                            &nbsp;
                                        </td>
                                        <td  width=25% align="center"  >
                                            &nbsp;
                                        </td>
                                        <td  width=25% align="center"   >
                                            &nbsp;
                                        </td>
                                        <td  width=25% align="center"   >
                                            &nbsp                                       
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td colspan="4" align="center" style="font-size: 10pt; color:#000000 " >
                                            <table width="75%" border="1">
                                                <tr>
                                                    <td colspan="3">
                                                        <div align="center">DATOS GENERALES DEL ESTUDIANTE</div>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td colspan="1" align="left" width="20%">Nombre:</td>
                                        <td colspan="3" align="left"><%=datos.get("nom_est")%></td>

                                </tr>
                                <tr>
                                    <td colspan="1" align="left" width="20%">Carné:</td>
                                    <td colspan="3" align="left"><%=id_est%></td>

                                </tr>
                                <tr>
                                    <td colspan="1" align="left" width="20%">Documento de identidad:</td>
                                    <td colspan="3" align="left"><%=datos.get("doc_est")%></td>

                                </tr>
                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 "  >
                                        &nbsp;
                                    </td>

                                </tr>
                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 " >
                                        <table width="75%" border="1">
                                            <tr>
                                                <td>
                                                    <div align="center">DATOS ACADEMICOS DEL ESTUDIANTE</div>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr> 
                                <tr>
                                    <td colspan="1" align="left" width="20%">Programa Académico:</td>
                                    <td colspan="3" align="left"><%=dpto%></td>

                                </tr>
                                <tr>
                                    <td colspan="1" align="left" width="20%">Semestre Actual:</td>
                                    <td colspan="3" align="left"><%=datosAC.get("sem_est")%></td>

                                </tr>
                                <tr>
                                    <td colspan="1" align="left" width="20%">Promedio del Semestre Anterior:</td>
                                    <td colspan="3" align="left"><%=datosSolGeneral.get("prom_ant")%></td>

                                </tr>
                                <tr>
                                    <td colspan="1" align="left" width="20%">Promedio Acumulado:</td>
                                    <td colspan="3" align="left"><%=datosSolGeneral.get("prom_acum")%></td>

                                </tr>

                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 "  >
                                        &nbsp;
                                    </td>

                                </tr>

                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 " >
                                        <table width="75%" border="1">
                                            <tr>
                                                <td>
                                                    <div align="center">DATOS DE LA SOLICITUD </div>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="1" align="left" width="20%">Programa de Movilidad Solicitado:</td>
                                    <td colspan="3" align="left"><%=datosSolGeneral.get("prog_mov")%></td>

                                </tr>
                                <tr>
                                    <td colspan="1" align="left" width="20%">Pais al que aplica:</td>
                                    <td colspan="3" align="left"><%=datosSolGeneral.get("pais_mov")%></td>

                                </tr>
                                <tr>
                                    <td colspan="1" align="left" width="20%">Fecha de inicio:</td>
                                    <td colspan="3" align="left"><%=datosOpcionUni[0].get("fecha_in")%></td>

                                </tr>
                                <tr>
                                    <td colspan="1" align="left" width="20%">Fecha de finalización:</td>
                                    <td colspan="3" align="left"><%=datosOpcionUni[0].get("fecha_out")%></td>

                                </tr>
                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 "  >
                                        &nbsp;
                                    </td>

                                </tr>
                                <tr>
                                    <td colspan="4" align="left">Instituciones Solicitadas por el Estudiante:</td>


                                </tr>


                                <% int ban = datosOpcionUni.length;
                                    for (int i = 0; i < ban; i++) {

                                %>
                                                               
                                <tr>
                                    <td colspan="4">
                                        <table  width="90%" border="1" class="tabla" id="tablaOpcUni" align="center" >
                                            <tr><td colspan="3" align ="center">Opcion <%=i + 1%></td></tr>
                                            <tr>
                                                <td colspan="1" align="center"><a class="textocom"> Nombre de la Institución</a></td>
                                                <td colspan="1" align="center"><a class="textocom">Programa solicitado</a></td>
                                                <td colspan="1" align="center"><a class="textocom">Estado</a></td>
                                            </tr>
                                            <tr>
                                                <td colspan="1" align="left" ><%=datosOpcionUni[i].get("uni_destino")%></td>
                                                <td colspan="1" align="left" ><%=datosOpcionUni[i].get("prog_ud")%></td>
                                                <td colspan="1" align="left" ><%=datosOpcionUni[i].get("estado_opcud")%></td>
                                            </tr>
                                        </table>
                                    </td>

                                </tr>                       

                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 "  >
                                        &nbsp;
                                    </td>
                                </tr>
                                <%}%>

                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 " >
                                        <table width="75%" border="1">
                                            <tr>
                                                <td>
                                                    <div align="center">PLAN DE ESTUDIO PROPUESTO POR EL ESTUDIANTE</div>
                                                </td>
                                            </tr>
                                        </table>

                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                        <%
                                            if (idest.get("prog_mov").equals("PRACTICA INTERNACIONAL")) {

                                        %>


                                        <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                            <thead>
                                                <tr>
                                                    <th><div align="center"><strong>Periodo</strong></div></th>
                                                    <th><div align="center"><strong>Empresa</strong></div></th>
                                                    <th><div align="center"><strong>Materia de la Escuela</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoplanpi">
                                            </tbody>
                                        </table>


                                        <%            } else {
                                            if (idest.get("prog_mov").equals("DOBLE TITULACION")) {
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
                                        <%                      } else {
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
                                        <%                                }
                                            }
                                        %>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 "  >
                                        &nbsp;
                                    </td>

                                </tr>
                                <tr>
                                    
                            <td align="center"  colspan="4" > <a class="texto_rojo1">
                                    &nbsp; </a> </td>
                                    <tr>
                                    
                            <td align="center"  colspan="4" > <a class="texto_rojo1">
                                    &nbsp; </a> </td>
                                <tr>
                                    
                            <td align="center"  colspan="4" > <a class="texto_rojo1">
                                    LOG DE LA SOLICITUD </a> </td>
                        </tr>
                                <tr>
                                    <td colspan="4" align="center" >
                                        <table  border="1" class="tabla">
                                            <tr>
                                                
                                                <td with="75%">
                                                    <a class="textocom2">Actividad</a>
                                                </td>
                                                <td  with="20%">
                                                    <a class="textocom2">Ejecutor</a>
                                                </td>
                                            </tr>
                                            <%for(int i=0; i<auditoria.length;i++){%>
                                            <tr>
                                               
                                                <td  align="left" with="75%">
                                                    <a  class="textocom"><%=auditoria[i].get("descripcion")%></a>
                                                </td>
                                                <td  align="left" with="20%">
                                                    <a class="textocom"><%=auditoria[i].get("ejecutor")%></a>
                                                </td>
                                            </tr>
                                            
                                            
                                            <%}%>
                                        </table>
                                        
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 "  >
                                        &nbsp;
                                    </td>

                                </tr>

                                <tr>
                                    <td colspan="4">
                                        <h3><u>Cometarios sobre la solicitud (carta de intención) por parte de la Decanatura:</u></h3>
                                                <%=comentarios.get("obv_cartaeci")%>
                                        <h3><u>Cometarios sobre los documentos por parte de la ORI:</u></h3>
                                                <%=comentarios.get("obv_docu")%>
                                        <h3><u>Comentarios del plan de estudio por parte de la Decanatura:</u></h3>
                                                <%=comentarios.get("obv_plan")%>
                                        <h3><u>Comentarios del vicerrector:</u></h3>
                                                <%=comentarios.get("obv_vice")%>
                                    </td>
                                </tr>
                                <%if(usuario.equals((String) AdministradorMov.get("email_usr"))){
                                
%>
                                
                                <tr>
                                    <td colspan="4" align="center">
                                        <button class="button_azul1"type="button" name="vercontrato" onclick= "window.history.back()">
                                            <strong>Atras</strong>
                                        </button>
                                    </td>
                                </tr>
                                
                                
                                
                                <%
}%>
                                <tr>
                                    <td colspan="4" align="center" style="font-size: 10pt; color:#000000 "  >
                                        &nbsp;
                                    </td>

                                </tr>
                                <tr>
                                    <td colspan="4">
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

                                <script type="text/javascript">
                                            ListaPlanDec(<%=idsolicitud%>);
                                </script>
                            </table>
                        </td>
                    </tr>
                </table>
            </fieldset>  
        </div>
    </body>
</html>
