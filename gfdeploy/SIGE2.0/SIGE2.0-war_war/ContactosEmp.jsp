<%-- 
    Document   : ContactosEmp
    Created on : 18/04/2013, 08:47:07 AM
    Author     : Luis Alberto Salas
--%>
<%@page import="BDsige.EmpresaRemote"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache");
            String usuario = new String ();
            login.SessionEmpRemote empresa =(login.SessionEmpRemote)session.getAttribute("usuario");
            
            //Verificamos que la sesión esté activa
            if (empresa == null) {
                %><script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loingempresa';
                  </script><%
                return;
            }
            
            usuario=empresa.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp",emp);

            //Se consulta organizacion en Campus
            ConsultaOrganizaciones.ConsultaOrganizacionNit(usuario);
            //emp.getOrganizacion(usuario);

            HashMap datos = emp.datosGeneralesemp(usuario);
            
            //inicio.conectaEJB conEjb = new inicio.conectaEJB();
            //Hashmap datosgenGrad= emp.
            //nom_est, tel_residencia, dir_residencia, email, cel, ciudad_residencia, perfil
       %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Administrar Contactos</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/funcionemp.js" ></script>
        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            body {
                background:url('imagenes/fondo empresas.jpg');
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
            
            .panelSubTitulo {
                width: 100%;
                border-top-left-radius: 20px;
                border-top-right-radius: 20px;
                border-bottom-left-radius: 5px;
                border-bottom-right-radius: 5px;
                color: #FFFFFF;
                background: rgb(153, 0, 0);
            }
            
            .panelSubMenu {
                width: 100%;
                height: 19px;
                border-radius: 20px;
                border: 1px solid rgb(153, 0, 0);
                color: rgb(153, 0, 0);
                background: #FFFFFF;
                font-weight: bold;
            }
        </style>
    </head>
    <body onload="actualizarTabContEmp(<%=datos.get("nit")%>);">
        <jsp:include page="header">
            <jsp:param name="type" value="emp" />
        </jsp:include>
        <table width="640" align="center" class="curvas loginPanel" cellspacing="10">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        Administrar Contactos
                    </div>
                </td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td>
                    <table width="100%" border="0"  cellspacing="0" style=" border-color:#ddddff">
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" style=" box-shadow:-5px 5px 5px 5px rgba(0,0,0,0.1);">
                                <br>

                                        <div align="left" id="tablaconsultaEstEgre" style="display:inline">
                                             <font color="#990000"><u>Contactos Registrados______________________________________________________</u></font>
                                             <br>
                                             <br>
                                        <table  width="98%" border="1" class="tabla" id="tablacontactosEmp" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="35%"><div align="center"><strong>Nombre</strong></div></th>
                                                    <th width="35%"><div align="center"><strong>Cargo</strong></div></th>                                                    
                                                    <th width="30%"><div align="center"><strong>Eliminar</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoContactosEgre">
                                            </tbody>
                                        </table>
                                             <br>
                                            <%--<input class="inputlargo" type="submit" value="Consultar los Contactos Registrados" name="consultar" onclick= "actualizarTabContEmp(<%=datos.get("nit")%>);"/>--%><br><br><br>
                                            <font color="#990000"><u>Nuevo Contacto____________________________________________________________</u></font>
                                           <table  width="98%" border="0" class="tabla" id="tablaestudiosEgre" align="center" >
                                             <tr>
                                                  <td height="92">
                                                    <div align="left">
                                                      <table width="100%" align="left">
                                                        <tr style="height: 16px;"></tr>
                                                        <tr>
                                                          <td align="right">NIT:</td>
                                                          <td>
                                                              <input class="inputmediano" name="nit" id="nit" type="text" size="20" maxlength="25" value="<%=datos.get("nit")%>" disabled>
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Razón Social:</td>
                                                          <td  >
                                                              <input class="inputlargo"name="rasocial" id="rasocial" type="text" size="20"   value="<%=datos.get("razon_social")%>" disabled>
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Nombre del contacto:</td>
                                                          <td>
                                                              <input class="inputlargo"name="nomconte" id="nomconte" type="text" size="20"   >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Cargo en la empresa:</td>
                                                          <td >
                                                              <input class="inputlargo"name="cargoconte" id="cargoconte" type="text" size="20"  >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Área:</td>
                                                          <td>
                                                              <input class="inputlargo"name="areaconte" id="areaconte" type="text" size="20"   >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Profesión:</td>
                                                          <td >
                                                              <input class="inputlargo"name="profconte" id="porfconte" type="text" size="20" >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Teléfono:</td>
                                                          <td >
                                                              <input class="inputmediano"name="telconte" id="telconte" type="text" size="20"   >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Email:</td>
                                                          <td  >
                                                              <input class="inputlargo"name="emailconte" id="emailconte" type="text" size="20"   >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Celular:</td>
                                                          <td>
                                                              <input class="inputmediano"name="celconte" id="celconte" type="text" size="20" maxlength="25"  >
                                                          </td>
                                                        </tr>
                                                        <tr>
                                                          <td align="right">Documento del contacto:</td>
                                                          <td>
                                                              <input class="inputmediano"name="doccont" id="doccont" type="text" size="20" maxlength="25"  >
                                                          </td>
                                                        </tr>
                                                        <tr>
                                                          <td align="right">Confirme documento del contacto:</td>
                                                          <td>
                                                              <input class="inputmediano"name="doccont2" id="doccont2" type="text" size="20" maxlength="25"  >
                                                          </td>
                                                        </tr>
                                                        <tr>
                                                          <td align="right">Sistema a cargo:</td>

                                                         <td >
                                                             <select class="inputmediano"name="SistemaSolicitado" id="SistemaSolicitado">
                                                                <option value="prac">Sistema de Prácticas</option>
                                                                <option value="grad">Sistema de Graduados</option>
                                                                <option value="prac-grad">Prácticas y Graduados</option>
                                                             </select>
                                                         </td>
                                                        </tr>
                                                        <tr>
                                                          <td >&nbsp;</td>
                                                          <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                          <td colspan="2">
                                                            <div align="center">
                                                                <input class="inputmediano" type="submit" value="Registrar Contacto"  name="Registrar Contacto emp" onclick="registrarcontactoEmp();"/>
                                                                <input class="inputmediano" type="submit" value="Regresar"  name="Mostrar opcuni" onclick="history.back();"/>
                                                            </div>
                                                          </td>
                                                        </tr>
                                                        <tr>
                                                          <td >&nbsp;</td>
                                                          <td>&nbsp;</td>
                                                        </tr>
                                                      </table>
                                                    </div>
                                                  </td>
                                                </tr>
                                        </table>
                                  </div>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>