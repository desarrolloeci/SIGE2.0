<%-- 
    Document   : solicitud
    Created on : 13/08/2012, 03:49:48 PM
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
            String id_est = new String();
            String menest = new String();
            String idsolicitud;
            String carta = new String ();
            String comentarios = new String ();
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
            usuario = admin.getUser();
            //DecanoRemote bd = conEjb.lookupDecanoRemote();
            emp.inicializar(usuario);
            idsolicitud = request.getParameter("idSolicitud");
            session.setAttribute("emp", emp);
            HashMap estado = emp.estadoAplicacion(idsolicitud);
            id_est = (String) estado.get("id_est");
            HashMap datos = emp.datosGeneralesEst(id_est);
            HashMap datosAC = emp.datosAcademicosEst(id_est);
            HashMap[] datosSol = emp.datosSolicitud(idsolicitud);
            HashMap datosSol2 = datosSol[0];
            int cantdat = datosSol.length;

            HashMap datosSol1 = datosSol[0];
            if (cantdat > 1) {
                datosSol2 = datosSol[1];
            }

            est = (String) estado.get("estado");
            HashMap mensajeestado = emp.mensajeestado(est);
            menest = (String) mensajeestado.get("men_est");
            carta = (String)datosSol1.get("carta_eci");
if( carta!= null && !carta.equals("NULL")){        
         
         carta=carta.replaceAll("Ã¡","á");
         carta = carta.replaceAll("Ã©","é");
         carta = carta.replaceAll("Ã­","í");
         carta = carta.replaceAll("Ã³","ó");
         carta = carta.replaceAll("Ãº","ú");
         carta = carta.replaceAll("Ã±","ñ");
         carta = carta.replaceAll("\n", "<br>");   
            }
comentarios = (String)datosSol1.get("obv_cartaeci");
if( comentarios!= null && !comentarios.equals("NULL")){          
         comentarios = comentarios.replaceAll("Ã¡","á");
         comentarios = comentarios.replaceAll("Ã©","é");
         comentarios = comentarios.replaceAll("Ã­","í");
         comentarios = comentarios.replaceAll("Ã³","ó");
         comentarios = comentarios.replaceAll("Ãº","ú");
         comentarios = comentarios.replaceAll("Ã±","ñ");
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
        <title>SIEMPREG Movilidad - Solicitud de Movilidad</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>

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
                        Solicitud de Movilidad
                </td>
            </tr>
            <tr>
                <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" align="left">                
                    <table  width="635"  cellspacing="0">
                        <% if (est.equals("a         ")) {
                        %>

                        <tr> <td width="40%">                                    
                                &nbsp;
                            </td>
                            <td width="60%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr> <td colspan="2" align="center"><a class="textocom2"> DATOS GENERALES</a> </td></tr> 
                        <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr>  
                        <tr>
                            <td width="30%">                                    
                                Nombre:
                            </td>
                            <td>                                    
                                <%=datos.get("nom_est")%>
                            </td>
                        </tr>
                        <tr>
                            <td width="30%">                                    
                                Carné:
                            </td>
                            <td>                                    
                                <%=id_est%>
                            </td>
                        </tr>
                        <tr>
                            <td width="30%">                                    
                                Documento de identidad:
                            </td>
                            <td>                                    
                                <%=datos.get("doc_est")%>
                            </td>
                        </tr>
                        <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                           <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 

                        <tr> <td colspan="2" align="center" ><a class="textocom2"> DATOS ACADEMICOS</a> </td></tr>

                            <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                            <tr>
                            <td>                                    
                                Programa Académico:
                            </td>
                            <td>                                    
                                <%=dpto%>
                            </td>
                        </tr>
                        <tr>
                            <td>                                    
                                Semestre Actual:
                            </td>
                            <td>                                    
                                <%=datosAC.get("sem_est")%>
                            </td>
                        </tr>
                        <tr>
                            <td>                                    
                                Promedio del Semestre Anterior: 
                            </td>
                            <td>                                    
                                <%=datosSol1.get("prom_ant")%>
                            </td>
                        </tr>
                         <tr>
                            <td>                                    
                                Promedio Acumulado: 
                            </td>
                            <td>                                    
                                <%=datosSol1.get("prom_acum")%>
                            </td>
                        </tr>                            

<tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
<tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr> <td colspan="2" align="center" ><a class="textocom2"> SOLICITUD</a> </td></tr>
                        <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                         <tr>
                            <td>                                    
                                Programa de Movilidad Solicitado: 
                            </td>
                            <td>                                    
                                <%=datosSol1.get("prog_mov")%>
                            </td>
                        </tr> 
                       <tr>
                            <td>                                    
                                Pais al que aplica:
                            </td>
                            <td>                                    
                                <%=datosSol1.get("pais_mov")%>
                            </td>
                        </tr>
                       <tr>
                            <td>                                    
                                Fecha de inicio:
                            </td>
                            <td>                                    
                                <%=datosSol1.get("fecha_in")%>
                            </td>
                        </tr>
                        <tr>
                            <td>                                    
                                Fecha de finalización:
                            </td>
                            <td>                                    
                                <%=datosSol1.get("fecha_out")%>
                            </td>
                        </tr>
                        <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr>
                            <td colspan="2">                                    
                                Universidades a las que desea aplicar:
                            </td>

                        </tr>
                        <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr>
                            <td colspan="2">                                    
                                Opcion1:
                            </td>

                        </tr>
                         <tr>
                            <td>                                    
                                Nombre de la Institución:
                            </td>
                            <td>                                    
                                <%=datosSol1.get("uni_destino")%>
                            </td>
                        </tr>
                        <tr>
                            <td>                                    
                                Programa solicitado:
                            </td>
                            <td>                                    
                                <%=datosSol1.get("prog_ud")%>
                            </td>
                        </tr>

                        <%  if (cantdat > 1) {%>
                        <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr>
                            <td colspan="2">                                    
                                Opcion2:
                            </td>

                        </tr>
                        <tr>
                            <td>                                    
                                Nombre de la Institución:
                            </td>
                            <td>                                    
                                <%=datosSol2.get("uni_destino")%>
                            </td>
                        </tr>
                        <tr>
                            <td>                                    
                                Programa solicitado:
                            </td>
                            <td>                                    
                                <%=datosSol2.get("prog_ud")%>
                            </td>
                        </tr>

                        <%}%>
                       <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                           <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr> <td colspan="2" align="center" ><a class="textocom2"> CARTA DE INTENCION</a> </td></tr>
                        <tr align="center">
                            <td colspan="2"> 
                                <div class="textohv" align="center" >
                                    <fieldset class="field_set1">
                                        <div  class="carta"><br/><br/><br/><%=carta%> <br/> <br/><br/></div></fieldset></div>
                            </td>
                        </tr>
                        <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr>
                            <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr>
                        <tr>
                            <td colspan="2" align="center"><a class="textocom2">Comentarios sobre la Solicitud</a></td>
                        </tr>
                        <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
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
                        <tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr>
                            <td  colspan="2" align="center">

                                <textarea name="comentariomov" id="comentariomov" rows="10" cols="38">Escriba su comentario....</textarea>
                            </td>
                        </tr>
                        <tr> <td  colspan="2" align="center"><input class="button_azul_consulta1" type="submit" value="Enviar comentario" name="comen" onclick= " GuardarComentario(<%=idsolicitud%>, 'obv_cartaeci');"/></td></tr>
<tr> <td width="30%">                                    
                                &nbsp;
                            </td>
                            <td width="70%">                                    
                                &nbsp;
                            </td></td></tr> 
                        <tr>
                            <td id="botonSol" align="center" colspan="2">
                                <input class="button_azul_consulta" type="submit" value="Aceptar" name="vobocarta" onclick="AceptarSolicitud(<%=idsolicitud%>,'<%=usuario%>');"/>
                                <input class="button_azul_consulta" type="submit" value="Pendiente" name="vobocarta" onclick="DejarPendiente();"/>
                                <input class="button_azul_consulta" type="submit" value="Rechazar" name="vobocarta" onclick="RechazarSolicitud(<%=idsolicitud%>,'<%=usuario%>');"/>
                            </td>
                        </tr>
                        <tr>
                            <td id="msgBotonSol" align="center" colspan="2" style="visibility: hidden;"></td>
                        </tr>
                        <%
                        } else {
                        %>
                        <tr>
                            <td>
                                <br/><br/><br/><br/>La solicitud del estudiante <%=datos.get("nom_est")%>  ya fue tramitada, su estado actual es: "<%=mensajeestado.get("men_est")%>" <br/> <br/>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" >
                                <a href="javascript:window.close();">Click para cerrar esta ventana</a>
                            </td>
                        </tr>

                        <%
                            }
                        %>
                    </table>
                </td>
            </tr>
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