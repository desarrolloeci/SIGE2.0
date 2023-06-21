<%-- 
    Document   : ActualizarInfoEmpAdmin
    Created on : 19/11/2012, 11:34:37 AM
    Author     : Luis Alberto Salas
--%>
<%@page import="clientecampus.ConsultaOrganizaciones"%>
<%@page import="BDsige.EmpresaRemote"%>
<%@page import="java.util.*, java.io.File, java.text.SimpleDateFormat"%>
<%@page import="documentos.RutaDoc"%>
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
            login.SessionUsrRemote admin = (login.SessionUsrRemote)session.getAttribute("usuario");
            usuario=admin.getUser();
            rol=admin.getRol();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();          
            session.setAttribute("emp",emp);
            //id_emp
            nit = request.getParameter("id_emp");
            emp.inicializar(nit);
            //Se consulta organizacion en Campus
            ConsultaOrganizaciones.ConsultaOrganizacionNit(nit);
            //emp.getOrganizacion(nit);
            
            
            HashMap datos = emp.datosGeneralesemp(nit);
            
            HashMap[] contactos = emp.Contactosemp(nit);
            ban=contactos.length;
            
            
            
            //Verificamos existencia y vigencia del documento adjuntado
            String Rut = new RutaDoc("Doc_Emp_Sige").getRuta() + "Rut-" + nit + "-CM.pdf";
            String Camara = new RutaDoc("Doc_Emp_Sige").getRuta() + "Cam-" + nit + "-CM.pdf";
            
            File rutFile = new File(Rut);
            File camFile = new File(Camara);
            
            String lastMRut = "";
            String lastMCam = "";
            
            HashMap[] paises=emp.getpaises();
            HashMap[] ciudades=emp.getciudades();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            if (rutFile.exists()) {
                Calendar rutDate = new GregorianCalendar();
                rutDate.setTimeInMillis(rutFile.lastModified());
                lastMRut = sdf.format(rutDate.getTime());
            }
            
            if (camFile.exists()) {
                Calendar camDate = new GregorianCalendar();
                camDate.setTimeInMillis(camFile.lastModified());
                lastMCam = sdf.format(camDate.getTime());
            }
            
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
        <jsp:include page="encabezado_grad"></jsp:include>
        <table width="640" border="0" align="center" cellspacing="0">
            <tr class="textocom">
                <td width="200" height="20"><div align="center" class="menuprueba2"><font color="#FFFFFF"><strong>Actualizar Datos de la Empresa</strong></font></div></td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td>
                    <table width="100%" border="1"  cellspacing="0" style=" border-color:#ddddff">
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" style=" box-shadow:-5px 5px 5px 5px rgba(0,0,0,0.1);">

                                        <div align="left" id="tablaconsultaEstEgre" style="display:inline">
                                            <b><u>Datos Registrados____________________________</u></b>
                                           <table  width="98%" border="0" class="tabla" id="tablaestudiosEgre" align="center" >
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
                                                                          
                                                                          <td width="95%" align="left" bgcolor="f7f7f7">Datos Generales de la Empresa</td>
                                                                      </tr>
                                                                  </table>
                                                              </td>
                                                        </tr>
                                                        <tr>
                                                          <td align="right">NIT:</td>
                                                          <td>
                                                              <input class="inputmediano" name="nit" id="nit" type="text" size="20" maxlength="25" value="<%=datos.get("nit")%>" disabled>
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Razón Social:</td>
                                                          <td>
                                                              <input class="inputlargo"name="rasocial" id="rasocial" type="text" size="20"   value="<%=datos.get("razon_social")%>">
                                                          </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">País de la empresa:</td>
                                                            <td>
                                                                <select class="inputmediano" name="paisemp" id="paisemp" onchange="actCiudadesConPais()" required>
                                                                    <option value="">Seleccione</option>
                                                                    <%
                                                                        HashMap pais;
                                                                       for(int cont = 0; cont < paises.length; cont++) {
                                                                         pais = paises[cont];
                                                                    %>
                                                                    <option value="<%=pais.get("cod_pai")%>"<%=((String) datos.get("pais_empresa")).equals((String) pais.get("cod_pai"))?" selected":""%>> <%=pais.get("nom_pai")%></option>
                                                                    <%
                                                                       }
                                                                    %>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Ciudad de la empresa: </td>
                                                            <td>
                                                                <select class="inputmediano" name="ciudademp" id="ciudademp" required>
                                                                    <option value="">Seleccione</option>
                                                                    <%
                                                                        HashMap ciudad;
                                                                       for(int cont=0;cont<ciudades.length;cont++)
                                                                     {
                                                                         ciudad=ciudades[cont];
                                                                    %>
                                                                      <option data-pais="<%=ciudad.get("pais")%>" value="<%=ciudad.get("cod_ciu")%>" <%=((String) ciudad.get("cod_ciu")).equals(datos.get("ciudad_empresa"))?"selected":""%>><%=ciudad.get("nom_ciu")%></option>
                                                                    <%}%>

                                                               </select>
                                                                <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                                            </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Dirección de la empresa:</td>
                                                          <td  >
                                                              <input class="inputmediano"name="diremp" id="diremp" type="text" size="20" maxlength="25" value="<%=datos.get("dir_empresa")%>" >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Pagina web:</td>
                                                          <td  >
                                                              <input class="inputlargo"name="webemp" id="webemp" type="text" size="20"  value="<%=datos.get("web_empresa")%>" >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Email de la empresa:</td>
                                                          <td >
                                                              <input class="inputlargo"name="emailemp" id="emailemp" type="text" size="20" value="<%=datos.get("email_empresa")%>"  >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Teléfono de la empresa:</td>
                                                          <td >
                                                              <input class="inputmediano"name="telemp" id="telemp" type="text" size="20" maxlength="25" value="<%=datos.get("tel_empresa")%>"  >
                                                          </td>
                                                        </tr>
                                                        <tr>
                                                          <td align="right">Documentos de la empresa:</td>
                                                          <td>
                                                              <%
                                                                  if (rutFile.exists()) {
                                                              %>
                                                              <a href='http://practicas.escuelaing.edu.co/Doc_Emp_Sige/Rut-<%=nit%>-CM.pdf' target='_blank'>RUT</a> - Cargado el <%=lastMRut%><br>
                                                              <%
                                                                  }
                                                                  
                                                                  if (camFile.exists()) {
                                                              %>
                                                              <a href='http://practicas.escuelaing.edu.co/Doc_Emp_Sige/Cam-<%=nit%>-CM.pdf' target='_blank'>Cámara de comercio</a> - Cargado el <%=lastMCam%>
                                                              <%
                                                                  }

                                                                  if (!rutFile.exists() && !camFile.exists()) {
                                                              %>
                                                              La empresa no posee documentos cargados en el sistema.
                                                              <%
                                                                  }
                                                              %>
                                                          </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Empresa aprobada:</td>
                                                            <td><%=datos.get("aprobada_uge").toString().equals("1")?"Si":"No"%></td>
                                                        </tr>
                                                        <%if(!datos.get("aprobada_uge").toString().equals("1")){%>
                                                        <tr>
                                                          <td >&nbsp;</td>
                                                          <td>
                                                            <!--a href="AprobarEmpresa?nit=<%=datos.get("nit")%>"><b>APROBAR ESTA EMPRESA</b></a-->
                                                              <form action="AprobarEmpresa" method="post">
                                                                  <input type="hidden" id="nit" name="nit" value="<%=datos.get("nit")%>">
                                                                  <input type="submit" value="APROBAR ESTA EMPRESA">
                                                              </form>
                                                          </td>
                                                        </tr>
                                                        <%}%>
                                                        <tr>
                                                          <td >&nbsp;</td>
                                                          <td>&nbsp;</td>
                                                        </tr>
                                                         <tr>
                                                              <td colspan="2">
                                                                  <table  width="100%" bordercolor='#CCCCFF' frame="hsides"    >
                                                                      <tr>
                                                                          
                                                                          <td width="95%" align="left" bgcolor="f7f7f7">Datos de Contacto</td>
                                                                      </tr>
                                                                  </table>
                                                              </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Nombre del contacto:</td>
                                                          <td >
                                                              <input class="inputlargo"name="nomconte" id="nomconte" type="text" size="20"  value="<%=datos.get("nom_contacto")%>" >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Cargo en la empresa:</td>
                                                          <td >
                                                              <input class="inputlargo"name="cargoconte" id="cargoconte" type="text" size="20" value="<%=datos.get("cargo_contacto")%>" >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Área:</td>
                                                          <td  >
                                                              <input class="inputlargo"name="areaconte" id="areaconte" type="text" size="20" value="<%=datos.get("area_contacto")%>"  >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Profesión:</td>
                                                          <td >
                                                              <input class="inputlargo"name="profconte" id="porfconte" type="text" size="20"value="<%=datos.get("profesion_contacto")%>"  >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Teléfono:</td>
                                                          <td >
                                                              <input class="inputmediano"name="telconte" id="telconte" type="text" size="20" value="<%=datos.get("tel_contacto")%>"  >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Fax:</td>
                                                          <td  >
                                                              <input class="inputmediano"name="faxconte" id="faxconte" type="text" size="20" maxlength="25" value="<%=datos.get("fax_contacto")%>"  >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Email:</td>
                                                          <td  >
                                                              <input class="inputlargo"name="emailconte" id="emailconte" type="text" size="20"  value="<%=datos.get("email_contacto")%>" >
                                                          </td>
                                                        </tr>
                                                         <tr>
                                                          <td align="right">Celular:</td>
                                                          <td >
                                                              <input class="inputmediano"name="celconte" id="celconte" type="text" size="20" maxlength="25"  value="<%=datos.get("cel_contacto")%>">
                                                          </td>
                                                        </tr>

                                                        <tr>
                                                          <td >&nbsp;</td>
                                                          <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                          <td colspan="2">
                                                            <div align="center">
                                                                <input class="inputmediano" type="submit" value="Actualizar Datos"  name="Mostrar opcuni" onclick= "actuaizardatosempAdmin();"/>                                                                
                                                            </div>
                                                          </td>
                                                        </tr>

                                                        <tr>
                                                              <td colspan="2">
                                                                  <table  width="100%" bordercolor='#CCCCFF' frame="hsides"    >
                                                                      <tr>                                                                          
                                                                          <td width="95%" align="left" bgcolor="f7f7f7">Otros Contactos </td>
                                                                      </tr>
                                                                  </table>
                                                              </td>

                                                        </tr>
                                                        <tr align="center">
                                                            <td colspan="2" align="center">
                                                                <table  width="70%" bordercolor='#CCCCFF'border="1" >
                                                                    <tr>
                                                                        <td align="center" width="200"  bgcolor="FFFFFF"  >
                                                                            Nombre
                                                                        </td>
                                                                        <td align="left" width="200"  bgcolor="FFFFFF" >
                                                                           Sistema
                                                                        </td>
                                                                    </tr>
                                                        <%
                                                        HashMap Contacto;
                                                        for (int i=0; i<ban; i++){
                                                                Contacto=contactos[i];

                                                        %>                                                        
                                                                    <tr>
                                                                        <td align="center" width="200"  bgcolor="FFFFFF" class="menuprueba" >
                                                                            <div align="left">
                                                                                <a onclick="location='DatosContEmp?id_emp=<%=Contacto.get("id_contacto")%>'">
                                                                                   <font id="contacto<%=i%>" color="#000000"><%=Contacto.get("nom_contacto")%> </font></a>
                                                                            </div>
                                                                        </td>
                                                                        <td align="left" width="200"  bgcolor="FFFFFF" >
                                                                            <%=Contacto.get("sistema_contacto")%>
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
                                                                  <table  width="100%" bordercolor='#CCCCFF' frame="hsides"    >
                                                                      <tr>                                                                          
                                                                          <td width="95%" align="left" bgcolor="f7f7f7">Opciones de Administrador</td>
                                                                      </tr>
                                                                  </table>
                                                              </td>

                                                        </tr>
                                                         <tr>
                                                          <td colspan="2">
                                                            <div align="center">
                                                                <input class="inputmediano" type="submit" value="Reiniciar contraseña  "  name="Mostrar opcuni" onclick= "reiniciarpassEmp(<%=nit%>);"/>
                                                                <input class="inputmediano" type="submit" value="Eliminar"  name="Mostrar empg" onclick= "EliminarempAdminG(<%=nit%>)"/>
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