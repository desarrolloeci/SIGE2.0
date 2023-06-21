<%--
    Document   : EditarExpLabGrad
    Created on : 12/05/2014, 11:56:24 AM
    Author     : Luis Salas
--%>

<%@page import="clientecampus.ConsultaPersonas"%>
<%@page import="BDsige.EstudiantesRemote"%>
<%@page import="BDsige.graduadoRemote"%>
<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
 <%@page import="BDsige.EmpresaRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>        
        <%
            response.setHeader("Cache-Control", "no-cache");
            documentos.ruta ruta = new documentos.ruta();
            String doc_grad = new String();
            String perfil = new String();
            String usuario = new String("");
            String IdExp=new String();
            String mensaje=new String();
            String opt = new String("");

            login.SessionGradRemote graduado =(login.SessionGradRemote)session.getAttribute("usuario");
            
            if (graduado == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'logingraduado';
                    </script>
                <%
                return;
            }
            
            usuario=graduado.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            graduadoRemote emp = conEjb.lookupgraduadoRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp", emp ) ;
            HashMap id = emp.docgrad(usuario);
            doc_grad = (String)id.get("id_documento");

            //Se consulta la persona en campus
            EstudiantesRemote est = conEjb.lookupEstudiantesRemote();
            est.inicializar("75107740");
            
            est.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "GRADUADO"));

            

            IdExp = request.getParameter("idexp");
            mensaje = request.getParameter("men");
            
            if(mensaje == null) mensaje = "";
            
            HashMap[] paises=emp.getpaisesgrad();
            HashMap pais;
            int pa = paises.length;
            HashMap[] sectores=emp.getsectoresgrad();
            HashMap sector;
            HashMap DatExp = emp.getDatExperienciaGrad(IdExp);
            int se = sectores.length;
        %>
     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Edición de Experiencia Laboral</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>
        <link href="CSS/graduados.css" rel="stylesheet" type="text/css">
        <style type="text/css"> 
            body { 
                background: url('imagenes/fondo graduados.jpg');
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
            <jsp:param name="type" value="grad" />
        </jsp:include>

        <table width="800" align="center" class="curvas loginPanel" cellspacing="0" style="padding: 10px;">
            <tr class="textocom">
                <td colspan="2" align="center">
                    <form name="fromExpLab" action="" method="post">
                        <div align="center" id="ExpLEgre">
                            <table width="80%">
                                <tr>
                                    <td valign="bottom" align="left" colspan="2">
                                        <b><u>Editar Experiencia Laboral_____________________________________________</u></b>
                                    </td>
                                </tr>
                                <tr style="height: 16px"></tr>
                                <%
                                    if (mensaje != null && !mensaje.equals("")) {
                                %>
                                <tr style="height: 32px;">
                                    <td colspan="2" style="text-align: center; vertical-align: middle; border-radius: 20px; border: 1px solid #DDDDDD; color: #094D60;">
                                        <b><%=mensaje%></b>
                                    </td>
                                </tr>
                                <tr style="height: 16px"></tr>
                                <%
                                    }
                                %>
                                <tr>
                                    <td align="left" >¿Es su empresa?:</td>
                                    <td align="left">
                                        <select class="inputmediano" name="empropia" id="empropia">
                                            <option value="False" <% if (DatExp.get("propia").equals("0")) {%>selected<%}%>>No</option>
                                            <option value="True" <% if (DatExp.get("propia").equals("1")) {%>selected<%}%>>Si</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left">Nombre de la Empresa:</td>
                                    <td align="left"><input value="<%=DatExp.get("nom_empresa")%>" class="inputsuperlargo"  name="nom_empresaegre" id="nom_empresaegre" type="text" size="20"></td>
                                </tr>
                                <tr>
                                    <td align="left">Cargo:</td>
                                    <td align="left">
                                        <input value="<%=DatExp.get("cargo")%>"class="inputsuperlargo"  name="cargoegre" id="cargoegre" type="text" size="20" >
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left" >Salario:</td>
                                    <td align="left"> Entre 
                                        <select class="inputmediano"  name="salario_expgrad" id="salario_expgrad">
                                            <%
                                                opt = "";
                                                opt = DatExp.get("salario").toString();
                                            %>
                                            <option value="1.000.000 y 1.500.000" <%if (opt.equals("1.000.000 y 1.500.000")) {%>selected<%}%>>1.000.000 y 1.500.000</option>
                                            <option value="1.500.000 y 2.000.000" <%if (opt.equals("1.500.000 y 2.000.000")) {%>selected<%}%>>1.500.000 y 2.000.000</option>
                                            <option value="2.000.000 y 3.000.000" <%if (opt.equals("2.000.000 y 3.000.000")) {%>selected<%}%>>2.000.000 y 3.000.000</option>
                                            <option value="3.000.000 y 4.000.000" <%if (opt.equals("3.000.000 y 4.000.000")) {%>selected<%}%>>3.000.000 y 4.000.000</option>
                                            <option value="4.000.000 y 5.000.000" <%if (opt.equals("4.000.000 y 5.000.000")) {%>selected<%}%>>4.000.000 y 5.000.000</option>
                                            <option value="5.000.000 y 6.000.000" <%if (opt.equals("5.000.000 y 6.000.000")) {%>selected<%}%>>5.000.000 y 6.000.000</option>
                                            <option value="6.000.000 y 7.000.000" <%if (opt.equals("6.000.000 y 7.000.000")) {%>selected<%}%>>6.000.000 y 7.000.000</option>
                                            <option value="7.000.000 y 8.000.000" <%if (opt.equals("7.000.000 y 8.000.000")) {%>selected<%}%>>7.000.000 y 8.000.000</option>
                                            <option value="8.000.000 y 10.000.000" <%if (opt.equals("8.000.000 y 10.000.000")) {%>selected<%}%>>8.000.000 y 10.000.000</option>
                                            <option value="mas de 10.000.000" <%if (opt.equals("mas de 10.000.000")) {%>selected<%}%>>Más de 10.000.000</option>
                                        </select>de pesos
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left" >Estado:</td>
                                    <td align="left">
                                        <select  class="inputmediano"  name="estado_expegre" id="estado_expegre" onchange="setExpActualGrad();">
                                            <%
                                                opt = "";
                                                opt = DatExp.get("estado_cargo").toString();
                                            %>
                                            <option value="Finalizado" <% if (opt.equals("Finalizado")) {%> selected<%}%>>Finalizado</option>
                                            <option value="Actual" <% if (opt.equals("Actual")) {%> selected<%}%>>Actual</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left">Sector</td>
                                    <td align="left">
                                        <select class="inputmediano" name="sector_expgrad" id="sector_expgrad">
                                            <%
                                                opt = "";
                                                opt = DatExp.get("sector_emp").toString();
                                                for (int cont=0;cont<se;cont++) {
                                                    sector=sectores[cont];
                                            %>
                                            <option value="<%=sector.get("nom_sector")%>" <% if (opt.equals(sector.get("nom_sector").toString())) {%>selected<%}%>><%=sector.get("nom_sector")%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left" >País:</td>
                                    <td align="left">
                                        <select class="inputmediano" name="pais_expgrad" id="pais_expgrad">
                                            <%
                                                opt = "";
                                                opt = DatExp.get("pais_emp").toString();
                                                for (int cont=0;cont<pa;cont++) {
                                                    pais=paises[cont];
                                            %>
                                            <option value="<%=pais.get("cod_pai")%>" <%if (opt.equals(pais.get("cod_pai").toString())) {%>selected<%}%>><%=pais.get("nom_pai")%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left" >Ciudad:</td>
                                    <td align="left" ><input value= "<%=DatExp.get("ciudad_emp")%>" class="inputmediano"  name="ciudad_expgrad" id="ciudad_expgrad" type="text" size="20"></td>
                                </tr>
                                <tr>
                                    <td align="left" >Dirección de la empresa:</td>
                                    <td align="left" ><input value= "<%=DatExp.get("dir_emp")%>" class="inputmediano"  name="dir_expgrad" id="dir_expgrad" type="text" size="20" ></td>
                                </tr>
                                <tr>
                                    <td align="left">Teléfono de la empresa :</td>
                                    <td align="left"><input value="<%=DatExp.get("tel_emp")%>" class="inputmediano"  name="tel_expgrad" id="tel_expgrad" type="text" size="20"></td>
                                </tr>
                                <tr>
                                    <td align="left">Fecha de ingreso:</td>
                                    <td align="left"><input value="<%=DatExp.get("mes_fecha_in")%>/<%=DatExp.get("year_fecha_in")%>" class="inputcorto"  name="fechain_expgrad" id="fechain_expgrad" type="text" size="20" >(mm/aaaa)</td>
                                </tr>
                                <tr>
                                    <td align="left">Fecha de retiro:</td>
                                    <%
                                        if (DatExp.get("estado_cargo").toString().equals("Actual")) {
                                    %>
                                    <td align="left"><input value="" class="inputcorto" name="fechaout_expgrad" id="fechaout_expgrad" type="text" size="20" style="background-color: #AAAAAA;" disabled>(mm/aaaa)</td>
                                    <%
                                        } else {
                                    %>
                                    <td align="left"><input value="<%=DatExp.get("mes_fecha_out")%>/<%=DatExp.get("year_fecha_out")%>" class="inputcorto"  name="fechaout_expgrad" id="fechaout_expgrad" type="text" size="20" >(mm/aaaa)</td>
                                    <%
                                        }
                                    %>
                                </tr>
                                <tr>
                                    <td align="left">Tipo de Contrato:</td>
                                    <td align="left">
                                        <select class="inputmediano"  name="contrato_expgrad" id="contrato_expgrad">
                                            <%
                                                opt = "";
                                                opt = DatExp.get("tipo_contrato").toString();
                                            %>
                                            <option value="Termino Fijo" <%if (opt.equals("Termino Fijo")) {%>selected<%}%>>Termino Fijo</option>
                                            <option value="Termino indefinido" <%if (opt.equals("Termino indefinido")) {%>selected<%}%>>Termino indefinido</option>
                                            <option value="Prestacion de servicios" <%if (opt.equals("Prestacion de servicios")) {%>selected<%}%>>Prestación de servicios</option>
                                            <option value="Otro" <%if (opt.equals("Otro")) {%>selected<%}%>>Otro</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left">Horario:</td>
                                    <td align="left">
                                        <select class="inputmediano"  name="horario_expgrad" id="horario_expgrad">
                                            <%
                                                opt = "";
                                                opt = DatExp.get("horario").toString();
                                            %>
                                            <option value="Tiempo Completo" <%if (opt.equals("Tiempo Completo")) {%>selected<%}%>>Tiempo Completo</option>
                                            <option value="Medio Tiempo" <%if (opt.equals("Medio Tiempo")) {%>selected<%}%>>Medio Tiempo</option>
                                            <option value="Otro" <%if (opt.equals("Otro")) {%>selected<%}%>>Otro</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left">Funciones en el cargo:</td>
                                    <td align="left"><textarea  name="fun_expgrad" id="fun_expgrad" rows="10" cols="38"><%=DatExp.get("funciones")%></textarea></td>
                                </tr>
                                <tr>
                                    <td align="left">Logros:</td>
                                    <td align="left"><textarea name="logros_expgrad" id="logros_expgrad" rows="10" cols="38"><%=DatExp.get("logros")%></textarea></td>
                                </tr>
                                <tr style="height: 16px"></tr>
                                <tr>
                                    <td align="center" colspan="2">
                                        <input type="submit" class="button_azul" value="Actualizar" name="ActExp" onclick="return ActualizarExpLab('<%=IdExp%>','<%=doc_grad%>');"/>
                                        <input type="submit" class="button_azul" value="Cerrar" name="ActdatosEgre" onclick="DejarPendienteDatGrad()"/>
                                    </td>
                                </tr>
                                <tr style="height: 32px;"></tr>
                            </table>
                        </div>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>