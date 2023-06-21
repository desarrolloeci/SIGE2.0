<%-- 
    Document   : TramitarOfertaAdminPrac
    Created on : 4/07/2014, 10:45:20 AM
    Author     : Luis Salas
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



<html>
    <head>
    <%

        response.setHeader("Cache-Control","no-cache");

        String rol = new String ();
        String usuario = new String ();
        String idoferta = new String ();
        String error = new String();
        String mensaje = new String();
        String vermensaje = new String();
        String vercerrar = new String();
        String chkContacto = new String();

        login.SessionUsrRemote admin = (login.SessionUsrRemote)session.getAttribute("usuario");
        usuario = admin.getUser();
        rol = admin.getRol();
        inicio.conectaEJB conEjb = new inicio.conectaEJB();
        EmpresaRemote emp = conEjb.lookupEmpresaRemote();
        emp.inicializar("75107740");
        session.setAttribute("emp",emp);
        
        mensaje = request.getParameter("mensaje");
        
        if (mensaje == null) {
            mensaje = "";
            vermensaje = "none";
        } else {
            if (mensaje.equals("0")) mensaje = "Error inesperado al guardar sus observaciones. Por favor intente nuevamente.";
            if (mensaje.equals("1")) mensaje = "Sus observaciones se han guardado satisfactoriamente";
            vermensaje = "inline";
        }
        
        idoferta = request.getParameter("idofer");
        HashMap datosoferta = emp.getDatosOfertaempP(idoferta);
        
        //Se consulta organizacion en Campus
        ConsultaOrganizaciones.ConsultaOrganizacionNit((String) datosoferta.get("id_empresa"));
        //emp.getOrganizacion((String) datosoferta.get("id_empresa"));
        
        HashMap DatosEmp = emp.getDatosGeneralesEmp((String) datosoferta.get("id_empresa"));
        chkContacto = (String) datosoferta.get("id_contacto");
        HashMap DatosContacto = new HashMap();
        
        
        
        
        
        if (!chkContacto.equals("0")) {
            DatosContacto = emp.datosContactoemp(chkContacto);
        }
        HashMap[] programas = emp.getProgramasEmpP(idoferta);
        HashMap programa;
        
        int nump = programas.length;
    %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Sige - Administrador</title>

        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunAdminPrac.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
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
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        
        <table width="800" align="center" class="curvas loginPanel" cellspacing="0" style="padding: 10px;">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        <strong>Aprobación Oferta</strong>
                    </div>
                </td>
            </tr>
            <tr class="textocom" style="background: #FFFFFF;">
                <td align="left">
                    <table width="100%">
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom">
                                <form name="fromprogramaspre" action="" method="post">
                                    <div align="left" id="FormOfertaPrac" name="FormOfertaPrac" style="display: inline">
                                    <table width="100%" >
                                        <tr>
                                            <td colspan="2"><div align="left" id="mensajeReg" style="display: <%=vermensaje%>"><%=mensaje%></div></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><div align="center"><a class="textocom3">Trámite de nueva oferta de Práctica Profesional</a></div></td>
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
                                            <td>Tipo Práctica:</td>
                                            <td>
                                                <%=datosoferta.get("tiprac")%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Nombre del Cargo:</td>
                                            <td>
                                                <input value="<%=datosoferta.get("cargo")%>"class="inputlargo" name="nomcargonop" id="nomcargonop" type="text" size="20" maxlength="50">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="1">Descripción del cargo: <br>(Por favor incluya en este espacio las actividades que el estudiante desempeñaría que el programa académico pueda validarlas y aprobarlas).</td>
                                            
                                            <td colspan="1" align="left">
                                                <textarea name="descripcionnop" id="descripcionnop" rows="10" cols="1"><%=datosoferta.get("descripcion")%></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="1">Requisitos:</td>
                                            <td colspan="1" align="left">
                                                <textarea name="Requisitosnop" id="Requisitosnop" rows="10" cols="1"><%=datosoferta.get("requisitos")%></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Pais:</td>
                                            <td>
                                                <input value="<%=datosoferta.get("pais_oferta")%>" name="paisnop" id="paisnop" type="text" size="20" maxlength="25" readonly="readonly">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ciudad:</td>
                                            <td>
                                                <input value="<%=datosoferta.get("ciudad_oferta")%>" class="inputcorto" name="ciudadnop" id="ciudadnop" type="text" size="20" maxlength="50" readonly="readonly">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Area de actividad:</td>
                                            <td>
                                                <input value="<%=datosoferta.get("area_oferta")%>"class="inputlargo" name="areanop" id="areanop" type="text" size="20" maxlength="50">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="left" >Apoyo Económico:</td>
                                            <td align="left">
                                                <input value="<%=datosoferta.get("salario_oferta")%>" class="inputmediano" name="salarionop" id="salarionop" type="text" size="20" maxlength="50">(COL$)
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Fecha de publicación</td>
                                            <td>
                                                <input value="<%=datosoferta.get("fecha_publicacion")%>"class="inputcorto" name="" id="" type="text" size="20" >(dd/mm/aaaa)
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Fecha de vencimiento:</td>
                                            <td>
                                                <input value="<%=datosoferta.get("fecha_limite")%>"class="inputcorto" name="fechaoutnop" id="fechaoutnop" type="text" size="20" >(dd/mm/aaaa)
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Fecha inicio de la práctica:</td>
                                            <td>
                                                <input value="<%=datosoferta.get("fecha_in")%>"class="inputcorto" name="fechainprac" id="fechainprac" type="text" size="20" >(dd/mm/aaaa)
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Fecha finalización de la práctica: </td>
                                            <td>
                                                <input value="<%=datosoferta.get("fecha_out")%>"class="inputcorto" name="fechaoutprac" id="fechaoutprac" type="text" size="20" >(dd/mm/aaaa)
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Jornada Laboral:</td>
                                            <td align="left">
                                                <select class="inputgraduado"  name="horarionop" id="horarionop">
                                                    <option value="Tiempo Completo" <%=(((String) datosoferta.get("horario_oferta")).equals("Tiempo Completo")?"selected":"")%>>Tiempo Completo</option>
                                                    <option value="Medio Tiempo" <%=(((String) datosoferta.get("horario_oferta")).equals("Medio Tiempo")?"selected":"")%>>Medio Tiempo</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Tipo de Contrato:</td>
                                            <td align="left">
                                                <select class="inputgraduado"  name="contratonop" id="contratonop">
                                                    <option value="Termino Fijo" <%=(((String) datosoferta.get("tipo_contrato")).equals("Termino Fijo")?"selected":"")%>>Término Fijo</option>
                                                    <option value="Termino indefinido" <%=(((String) datosoferta.get("tipo_contrato")).equals("Termino indefinido")?"selected":"")%>>Término indefinido</option>
                                                    <option value="Contrato de Aprendizaje" <%=(((String) datosoferta.get("tipo_contrato")).equals("Contrato de Aprendizaje")?"selected":"")%>>Contrato de Aprendizaje</option>
                                                    <option value="Convenio Interinstitucional" <%=(((String) datosoferta.get("tipo_contrato")).equals("Convenio Interinstitucional")?"selected":"")%>>Convenio Interinstitucional</option>
                                                    <option value="Prestación de servicios" <%=(((String) datosoferta.get("tipo_contrato")).equals("Prestación de servicios")?"selected":"")%>>Prestación de servicios</option>
                                                 </select>
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
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
                                                %>
                                                    <tr>
                                                        <td style="padding: 5px 20px; border: 1px solid #001553; background: #CDDAFF; border-radius: 2px;"><%=programa.get("programa_requerido")%></td>
                                                        <td style="padding: 5px 20px; border: 1px solid #001553; border-radius: 2px;"><%=programa.get("men_oferprac")%></td>
                                                    </tr>
                                                <%
                                                    }
                                                %>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td>Sistema de Seguro y Riesgos Profesionales:</td>
                                            <td>
                                                <input value="<%=datosoferta.get("seguro_arp")%>"class="inputmediano" name="seguros_arp" id="seguros_arp" type="text" size="20">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Reporta a (Nombre):</td>
                                            <td>
                                                <input value="<%=datosoferta.get("nom_jefe")%>" class="inputmediano" name="nom_jefe" id="nom_jefe" type="text" size="20">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Reporta a (Cargo):</td>
                                            <td>
                                                <input value="<%=datosoferta.get("cargo_jefe")%>"class="inputmediano" name="cargo_jefe" id="cargo_jefe" type="text" size="20">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Reporta a (Teléfono):</td>
                                            <td>
                                                <input value="<%=datosoferta.get("tel_jefe")%>" class="inputmediano" name="tel_jefe" id="tel_jefe" type="text" size="20">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Reporta a (E-mail):</td>
                                            <td>
                                                <input value="<%=datosoferta.get("email_jefe")%>" class="inputmediano" name="email_jefe" id="email_jefe" type="text" size="20">
                                            </td>
                                        </tr>
                                        <tr style="height: 32px;"></tr>
                                        <%
                                            if((datosoferta.get("estado").equals("k") || datosoferta.get("estado").equals("k         "))&&(DatosEmp.get("aprobada_uge")!=null&&DatosEmp.get("aprobada_uge").equals("1"))) {
                                        %>
                                        <tr>
                                            <td colspan="2">
                                                <div align="center">
                                                    <input class="button_azul_consulta1" style="margin-right: 10px;" type="submit" value="Aprobar Oferta de Práctica" name="AproOfer" onclick= "return AprobarofertapracUge(<%=idoferta%>);"/>
                                                    <input class="button_azul_consulta1" type="submit" value="Rechazar Oferta de Práctica" name="RchaOfer" onclick= "return RechazarofertapracUge(<%=idoferta%>);"/>
                                                </div>
                                            </td>
                                        </tr>
                                        <%
                                            } else if((DatosEmp.get("aprobada_uge")==null||!DatosEmp.get("aprobada_uge").equals("1"))) {
                                        %>
                                        <tr>
                                           <td colspan="2">
                                              <div align="center">
                                                La empresa no ha sido aprobada por la UGE.
                                                <br>
                                                <a href="ActualizarInfoEmpAdmin?id_emp=<%=(String) DatosEmp.get("nit")%>"><b>Ver Datos de la Empresa para Aprobación</b></a>
                                              </div>
                                           </td>
                                        </tr>
                                        <%
                                            } else {
                                        %>
                                        <tr>
                                           <td colspan="2">
                                              <div align="center">
                                                  Esta solicitud ya ha sido tramitada por parte de la UGE.
                                              </div>
                                           </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                        <tr style="height: 32px;"></tr>
                                        <tr>
                                            <td colspan="2">
                                                <div class="textocom2" align="center">
                                                    <strong>Observaciones de la UGE</strong>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td colspan="2" style="text-align: center;">
                                                <textarea id="uge_obs" style="width: 60%;"><%=(String) datosoferta.get("uge_obs")%></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <div align="center">
                                                    <input class="button_azul_consulta1" type="submit" value="Dejar una observación" name="ObservOfer" onclick="return ObservacionOfer(<%=idoferta%>);"/>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr style="height: 32px;"></tr>
                                        <tr>
                                           <td colspan="2">
                                              <div align="center">
                                                  <input class="button_azul" type="submit" onclick="window.close()" value="Cerrar" />
                                              </div>
                                           </td>
                                        </tr>
                                        <tr style="height: 32px;"></tr>
                                    </table>
                                    </div>
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <jsp:include page="footer">
                        <jsp:param name="type" value="general" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
</html>