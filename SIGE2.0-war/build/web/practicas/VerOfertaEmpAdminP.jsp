<%-- 
    Document   : VerOfertaEmpAdminP
    Created on : 4/02/2013, 10:10:28 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="utiles.ConsultaException"%>
<%@page import="clientecampus.ConsultaOrganizaciones"%>
<%@page import="BDsige.EmpresaRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,
         javax.rmi.PortableRemoteObject"
         %>

<%
    response.setHeader("Cache-Control", "no-cache");


    String rol = new String();
    String usuario = new String();
    String idoferta = new String();
    String error = new String();
    String chkContacto = new String();
    
    login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
    usuario = admin.getUser();
    rol = admin.getRol();
    
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
    EmpresaRemote emp = conEjb.lookupEmpresaRemote();
    emp.inicializar("75107740");
    session.setAttribute("emp", emp);
    
    idoferta = request.getParameter("idofer");
    HashMap datosoferta = emp.getDatosOfertaempP(idoferta);
    
    //Se consulta organizacion en Campus
    ConsultaOrganizaciones.ConsultaOrganizacionNit((String) datosoferta.get("id_empresa"));
    //emp.getOrganizacion((String) datosoferta.get("id_empresa"));
   
    HashMap DatosEmp = emp.getDatosGeneralesEmp((String) datosoferta.get("id_empresa"));
    chkContacto = (String) datosoferta.get("id_contacto");
    HashMap DatosContacto = new HashMap();
    
    
    //Se usa el servicio web para Campus

    ConsultaOrganizaciones.ConsultaOrganizacionNit(DatosEmp.get("nit").toString());

    //emp.getOrganizacion(DatosEmp.get("nit").toString());
    
    
    if (!chkContacto.equals("0")) {
            DatosContacto = emp.datosContactoemp(chkContacto);
        }
    
    HashMap[] programas = emp.getProgramasEmpP(idoferta);
    HashMap programa;
    HashMap[] oferex = emp.getOfertaExclusivaPracEmp(idoferta);
    int nump = programas.length;
    HashMap of;
    int numa=oferex.length;
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>solicitud</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>
        <script>
            function closeMe(){
                try{
                    window.close();
                }catch (e){console.log(e)}
                try{
                    self.close();
                }catch (e){console.log(e)}
                //alert("La pestaña no se puede cerrar automáticamente, pero puede cerrarla manualmente desde la X en la pestaña del navegador");
            }
        </script>
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
        <style type="text/css"> 
            body { 
                background: #FFFFFF;
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
            
            .panelSubTitulo {
                width: 100%;
                border-top-left-radius: 20px;
                border-top-right-radius: 20px;
                border-bottom-left-radius: 5px;
                border-bottom-right-radius: 5px;
                color: #FFFFFF;
                background: rgb(0, 0, 70);
            }
        </style>
    </head>
    <body  >
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        <table width="800" align="center" class="curvas loginPanel" cellspacing="0" style="padding: 10px;">
            <tr class="textocom" style="background: #FFFFFF;">
                <td align="left">
                    <form action="ActualizaFechasOfPrac" method="Post" id="form_act_of">
                    <table width="100%">
                    <tr>
                        <td colspan="2"><div align="center"><a class="textocom3">Oferta de Práctica Profesional</a></div></td>
                    </tr>
                    <tr style="height: 16px;"></tr>
                    <tr>
                        <td colspan="2">
                            <div class="textocom2" align="left">
                                <strong>Datos de la Empresa</strong>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td width="30%">Razón Social:</td>
                        <td width="70%"><%=DatosEmp.get("razon_social")%></td>
                    </tr>
                    <tr>
                        <td>NIT:</td>
                        <td><%=DatosEmp.get("nit")%></td>
                    </tr>
                    <tr>
                        <td>Dirección:</td>
                        <td><%=DatosEmp.get("dir_empresa")%></td>
                    </tr>
                    <tr>
                        <td>Página Web:</td>
                        <td><%=DatosEmp.get("web_empresa")%></td>
                    </tr>
                    <tr style="height: 16px;"></tr>
                    <tr>
                        <td>Nombre del Contacto:</td>
                        <td><%=DatosEmp.get("nom_contacto")%></td>
                    </tr>
                    <tr>
                        <td>Teléfono del Contacto:</td>
                        <td><%=DatosEmp.get("tel_contacto")%></td>
                    </tr>
                    <tr>
                        <td>E-mail del Contacto:</td>
                        <td><%=DatosEmp.get("email_contacto")%></td>
                    </tr>
                    <tr style="height: 16px;"></tr>
                    <%
                        if (!chkContacto.equals("0")) {
                    %>
                    <tr>
                        <td colspan="2">
                            <div class="textocom2" align="left">
                                <strong>Datos de publicación</strong>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Publicado por contacto:</td>
                        <td><%=DatosContacto.get("nom_contacto")%></td>
                    </tr>
                    <tr>
                        <td>Teléfono del Contacto:</td>
                        <td><%=DatosContacto.get("tel_contacto")%></td>
                    </tr>
                    <tr>
                        <td>Celular del Contacto</td>
                        <td><%=DatosContacto.get("cel_contacto")%></td>
                    </tr>
                    <tr>
                        <td>E-mail del Contacto:</td>
                        <td><%=DatosContacto.get("email_contacto")%></td>
                    </tr>
                    <tr style="height: 16px;"></tr>
                    <%
                        }
                    %>
                    <tr>
                        <td colspan="2">
                            <div class="textocom2" align="left">
                                <strong>Datos Generales de la Oferta</strong>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" align="left">Tipo Práctica:</td>
                        <td align="left"><%=datosoferta.get("tiprac")%></td>
                    </tr>
                    <tr>
                        <td valign="top" align="left">Cargo:</td>
                        <td align="left"><%=datosoferta.get("cargo")%></td>
                    </tr>
                    <tr>
                        <td valign="top" align="left">Descripción del cargo:</td>
                        <td align="left"><div class="textocom" style="margin: 0px; text-align: justify; white-space: pre-wrap;"><%=datosoferta.get("descripcion")%></div></td>
                    </tr>
                    <tr>
                        <td align="left"valign="top">Requisitos</td>
                        <td align="left"><div class="textocom" style="margin: 0px; text-align: justify; white-space: pre-wrap;"><%=datosoferta.get("requisitos")%></div></td>
                    </tr>
                    <tr style="height: 16px;"></tr>
                    <tr>
                        <td align="left">País:</td>
                        <td align="left"><%=datosoferta.get("pais_oferta")%></td>
                    </tr>
                    <tr>
                        <td align="left">Ciudad:</td>
                        <td align="left"><%=datosoferta.get("ciudad_oferta")%></td>
                    </tr>
                    <tr>
                        <td align="left">Área de actividad:</td>
                        <td align="left"><%=datosoferta.get("area_oferta")%></td>
                    </tr>
                    <tr style="height: 16px;"></tr>
                    <tr>
                        <td align="left">Fecha de inicio de la práctica:</td>
                        <td align="left"><input type="text" name="fecini" value="<%=datosoferta.get("fecha_in")%>" Style="width: 100px; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 12px; background-color: #EEEBFC;"> formato (dd/mm/aaaa)</td>
                    </tr>
                    <tr>
                        <td align="left">Fecha de finalización de la práctica:</td>
                        <td align="left"><input type="text" name="fecfin" value="<%=datosoferta.get("fecha_out")%>" Style="width: 100px; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 12px; background-color: #EEEBFC;"> formato (dd/mm/aaaa)</td>
                    </tr>
                    <tr>
                        <td align="left">Fecha de vencimiento:</td>
                        <td align="left"><input type="text" name="fecven" value="<%=datosoferta.get("fecha_limite")%>" Style="width: 100px; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 12px; background-color: #EEEBFC;"> formato (dd/mm/aaaa)</td>
                    </tr>
                    <tr>
                        <td align="left">Fecha de publicación:</td>
                        <td align="left"><%=datosoferta.get("fecha_publicacion")%></td>
                    </tr>
                    
                    <tr style="height: 16px;"></tr>
                    <tr>
                        <td align="left">Oferta Exclusiva para:</td>
                        <td align="left"><input type="text" name="ofex" Style="width: 100px; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 12px; background-color: #EEEBFC;"> (C&eacute;dula Estudiante) Nota: La exclusividad de la oferta no quedará registrada si el estudiante no ha actualizado su hoja de vida.</td>
                    </tr>
                    <%if(numa>0){%>
                    <%for(int i=0;i<numa;i++){
                        of=oferex[i];%>
                     <tr>
                             <td></td>
                             <td><a><%=of.get("id_est")%></a></td>
                     </tr>
                     <%}}%>
                    <tr style="height: 16px;"></tr>
                    <tr>
                        <td>Sistema de Seguro y Riesgos Profesionales:</td>
                        <td>
                            <input value="<%=datosoferta.get("seguro_arp")%>"class="inputmediano" name="seguros_arp" id="seguros_arp" type="text" size="20" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>Reporta a (Nombre):</td>
                        <td>
                            <input value="<%=datosoferta.get("nom_jefe")%>" class="inputmediano" name="nom_jefe" id="nom_jefe" type="text" size="20" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>Reporta a (Cargo):</td>
                        <td>
                            <input value="<%=datosoferta.get("cargo_jefe")%>"class="inputmediano" name="cargo_jefe" id="cargo_jefe" type="text" size="20" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>Reporta a (Teléfono):</td>
                        <td>
                            <input value="<%=datosoferta.get("tel_jefe")%>" class="inputmediano" name="tel_jefe" id="tel_jefe" type="text" size="20" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>Reporta a (E-mail):</td>
                        <td>
                            <input value="<%=datosoferta.get("email_jefe")%>" class="inputmediano" name="email_jefe" id="email_jefe" type="text" size="20" disabled>
                        </td>
                    </tr>
                    <tr><td><input type="hidden" name="idoferta" value="<%=idoferta%>">&nbsp;</td></tr>
                    <tr><td colspan="2"><div align="center"><% if(usuario.equals("practicas")) { %><button>Actualizar Oferta</button>&nbsp;<%}%></div></td></tr>
                    <tr style="height: 16px"></tr>
                    <tr style="height: 16px;"></tr>
                    <%
                        if (datosoferta.get("estado").equals("k") || datosoferta.get("estado").equals("k         ")) {
                    %>
                    <tr>
                        <td colspan="2" style="text-align: center; padding: 5px 20px; border: 1px solid #001553; background: #FFE7CD; border-radius: 2px;">Esta oferta está siendo evaluada por la unidad de gestión externa.</td>
                    </tr>
                    <%
                        } else if (datosoferta.get("estado").equals("z") || datosoferta.get("estado").equals("z         ")) {
                    %>
                    <tr>
                        <td colspan="2" style="text-align: center; padding: 5px 20px; border: 1px solid #001553; background: #FFCDCD; border-radius: 2px;">Esta oferta ha sido rechazada por la unidad de gestión externa.</td></tr>
                    <%
                        } else {
                    %>
                    <tr>
                        <td colspan="2">
                            <div class="textocom2" align="left">
                                <strong>Programas Académicos requeridos</strong>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <table style="border-collapse: separate; border-spacing: 2px;">
                            <%
                                for (int cont=0; cont < nump; cont++) {
                                    programa = programas[cont];
                                    String comentario = (String) programa.get("comen_dec");
                            %>
                                <tr>
                                    <td style="padding: 5px 20px; border: 1px solid #001553; background: #CDDAFF; border-radius: 2px;"><%=programa.get("programa_requerido")%></td>
                                    <td style="padding: 5px 20px; border: 1px solid #001553; border-radius: 2px;"><%=programa.get("men_oferprac")%></td>
                                </tr>
                            <%
                                    if (comentario != null && !comentario.equalsIgnoreCase("NULL") && !comentario.equals("")) {
                            %>
                                <tr>
                                    <td style="padding: 5px 20px; border: 1px solid #001553; border-radius: 2px;">Comentario:</td>
                                    <td style="padding: 5px 20px; border: 1px solid #001553; border-radius: 2px;"><%=comentario%></td>
                                </tr>
                            <%
                                    }
                                }
                            %>
                            </table>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    <tr style="height: 16px;"></tr>
                    <tr>
                        <td align="left"><b>Jornada:</b></td>
                        <td align="left"><%=datosoferta.get("horario_oferta")%></td>
                    </tr>
                    <tr>
                        <td align="left"><b>Tipo de contrato:</b></td>
                        <td align="left"><%=datosoferta.get("tipo_contrato")%></td>
                    </tr>
                    <tr>
                        <td align="left" valign="top"><b>Apoyo económico </b></td>
                        <td align="left"> <%=datosoferta.get("salario_oferta")%> pesos</td>
                    </tr>               
                    <tr style="height: 32px;"></tr>
                    <tr>
                        <td  colspan="2">
                            <div align="center"><input class="button_azul" type="button" onclick="closeMe();" value="Cerrar" /></div>
                        </td>
                    </tr>
                </table>
                    </form>
            </td></tr>
        <tr>
            <td>
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
