<%-- 
    Document   : DatosContEmp
    Created on : 27/05/2013, 02:39:59 PM
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
           String rol = new String ();
           String usuario = new String ();
           String nit = new String ();
           String error = new String();
           int ban;
           login.SessionUsrRemote admin =(login.SessionUsrRemote)session.getAttribute("usuario");
           usuario=admin.getUser();
           rol=admin.getRol();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           EmpresaRemote emp = conEjb.lookupEmpresaRemote();
           session.setAttribute("emp",emp);
           //id_emp
           nit = request.getParameter("id_emp");
           emp.inicializar(nit);           
           HashMap contacto = emp.datosContactoemp(nit);
           //inicio.conectaEJB conEjb = new inicio.conectaEJB();
           //Hashmap datosgenGrad= emp.
           //nom_est, tel_residencia, dir_residencia, email, cel, ciudad_residencia, perfil
       %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunAdminGrad.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/funcionemp.js" ></script>
         <link href="CSS/comun.css" rel="stylesheet" type="text/css">
    </head>
    <body background="imagenes/fondoblanco.gif" >
          <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado"></jsp:include>
        <table width="640" border="0" align="center" cellspacing="0">
            <tr class="textocom">
                <td width="200" height="20"><div align="center"><font color="#990000"><strong>Actualizar Datos de la Empresa</strong></font></div></td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td>
                    <table width="100%" border="1"  cellspacing="0" style=" border-color:#ddddff">
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" style=" box-shadow:-5px 5px 5px 5px rgba(0,0,0,0.1);">

                                        <div align="left" id="tablaconsultaEstEgre" style="display:inline">
                                            <b><u>Datos Registrados____________________________</u></b>
                                           <table  width="70%" border="1" class="tabla" id="tablaestudiosEgre" align="center" >
                                             <tr>
                                                  <td height="92">
                                                    <div align="left">
                                                      <table width="100%" align="left">
                                                        <tr>
                                                          <td >&nbsp;</td>
                                                          <td>&nbsp;</td>
                                                        </tr>
                                                         <tr>
                                                              <td colspan="2">
                                                                  <table  width="100%" bordercolor='#CCCCFF' frame="hsides"    >
                                                                      <tr>
                                                                          <td width="5%" align="center" bgcolor="#CCCCFF" >
                                                                              1.
                                                                          </td>
                                                                          <td width="95%" align="left" bgcolor="f7f7f7">Datos del Contacto</td>
                                                                      </tr>
                                                                  </table>
                                                              </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="left">Nombre del contacto:</td>

                                                          <td align="left"><%=contacto.get("nom_contacto")%></td>

                                                        </tr>
                                                         <tr>
                                                          <td align="left">Cargo en la empresa:</td>

                                                              <td align="left"><%=contacto.get("cargo_contacto")%></td>

                                                        </tr>
                                                         <tr>
                                                          <td align="left">Área:</td>
                                                              <td align="left"><%=contacto.get("area_contacto")%></td>

                                                        </tr>
                                                         <tr>
                                                          <td align="left">Profesión:</td>
                                                               <td align="left"><%=contacto.get("profesion_contacto")%></td>
                                                        </tr>
                                                         <tr>
                                                          <td align="left">Teléfono:</td>
                                                          <td align="left"><%=contacto.get("tel_contacto")%></td>
                                                        </tr>
                                                         
                                                         <tr>
                                                          <td align="left">Email:</td>
                                                          <td align="left"><%=contacto.get("email_contacto")%></td>
                                                        </tr>
                                                         <tr>
                                                          <td align="left">Celular:</td>
                                                          <td align="left"><%=contacto.get("cel_contacto")%></td>
                                                        </tr>
                                                        <tr>
                                                          <td >&nbsp;</td>
                                                          <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                          <td colspan="2">
                                                            <div align="center">
                                                                <input class="inputmediano" type="submit" value="ATRAS"  name="Mostrar opcuni" onclick= "history.back()"/>
                                                            </div>
                                                          </td>
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