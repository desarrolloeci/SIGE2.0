<%-- 
    Document   : RegistrarEmp2
    Created on : 16/10/2012, 10:43:33 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="BDsige.EmpresaRemote"%>
<%@page import="documentos.RutaDoc"%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>        
<%
    response.setHeader("Cache-Control","no-cache");
    String usuario = new String ();          
    BDsige.EmpresaRemote empreg =(BDsige.EmpresaRemote)session.getAttribute("empreg");
    
    if (empreg == null) {
        %>
        <script>
            alert("Por favor ingrese un NIT para registrar la empresa.");
            window.location='RegistrarEmp';
        </script>
        <%
        return;
    }
    
    usuario=empreg.getNit();
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
    //inicio.conectaEJB conEjb = new inicio.conectaEJB();
    EmpresaRemote emp = conEjb.lookupEmpresaRemote();
    emp.inicializar("75107740");
    
    HashMap chkExists = emp.getRegistroemp(usuario);
            
    if(chkExists.get("existe").equals("0")) {
        %>
        <script>
            alert("El NIT <%=usuario%> ya se encuentra registrado en el sistema.");
            window.location='RegistrarEmp';
        </script>
        <%
        return;
    }
    
    HashMap[] paises = emp.getpaises();
    HashMap[] ciudades = emp.getciudades();
    HashMap pais;
    int pa = paises.length;
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registro</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/funcionemp.js" ></script>
        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            body {
                background:url('imagenes/fondo empresas.jpg');
                background-position : center; 
                background-repeat : no-repeat; 
                background-attachment : fixed;
                -webkit-background-size: 100% 100%;
                -moz-background-size: 100% 100%;
                -o-background-size: 100% 100%;
                background-size: 100% 100%;
            }
            
            .loginPanel {
                box-shadow: 0px 4px 5px 5px rgba(0,0,0,0.3);
                border-top: 2px solid rgba(153,0,0,0.5);
                border-bottom: 2px solid rgba(153,0,0,0.2);
            }
            
            .curvas {
                border-radius: 20px;
                -webkit-border-radius: 20px;
                -moz-border-radius: 20px;
                background-color: #FFFFFF;
                background-color: rgba(255, 255, 255, 0.8);
            }
        </style>
    </head>
    <body background="imagenes/fondo empresas.jpg" >
        <table width="772" class="curvas" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td colspan="3" align="center" style="padding: 5px;">
                    <img name="encabezado_emp" src="imagenes/encabezado - empresas.jpg" class="curvas" border="0" alt="">
                </td>
            </tr>
        </table>
        <br>
        <div align="center">
        <table class="textocom curvas loginPanel" width="640" align="center">
            <tr>
                <td colspan="3" valign="BOTTOM" align="left" height="45" font-family="sans serif">
                    <a class="titulocom">Registro de Empresa</a>
                </td>
            </tr>
            <tr>
                <td height="92">
                    <div align="left">
                        <table width="100%" align="left">
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <table  width="100%" bordercolor='#CCCCFF' frame="hsides">
                                        <tr>
                                            <td width="5%" align="center" bgcolor="#CCCCFF">1.</td>
                                            <td width="95%" align="left" bgcolor="f7f7f7">Datos Generales de la Empresa</td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                                            <td align="right">Tipo ID:</td>
                                                            <td align="left"><select class="inputgraduado" name="tipoid" id="tipoid">
                                                                    <option value="1">NIT</option>
                                                                    <option value="2">Cédula de Ciudadanía</option>
                                                                    <option value="3">Cédula de Extranjería</option>
                                                                    <option value="4">Pasaporte</option>
                                                                    <option value="5">RUT</option>
                                                                </select>*
                                                            </td>
                                                        </tr> 
                            <tr>
                                <td align="right">ID:</td>
                                <td>
                                    <input class="inputmediano" name="nit" id="nit" type="text" size="20" maxlength="25" value="<%=usuario%>" disabled >
                                </td>
                            </tr>
             <tr>
              <td align="right">Razón Social:</td>
              <td  >
                  <input class="inputlargo"name="rasocial" id="rasocial" type="text" size="20"  >*
              </td>
            </tr>
             <tr>
              <td align="right">País de la empresa:</td>
              <td>
                  <select class="inputmediano" name="paisemp" id="paisemp" onchange="actCiudadesConPais()">
                      <option value="">Seleccione</option>
                      <%
                         for(int cont=0;cont<pa;cont++)
                       {
                           pais=paises[cont];
                      %>
                        <option value="<%=pais.get("cod_pai")%>" <%=((String) pais.get("cod_pai")).equals("COL")?"selected":""%>><%=pais.get("nom_pai")%></option>
                      <%}%>

                 </select>
                  <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
              </td>
            </tr>
             <tr>
              <td align="right">Ciudad de la empresa: </td>
              <td>
                  <select class="inputmediano" name="ciudademp" id="ciudademp">
                      <option value="">Seleccione</option>
                      <%
                          HashMap ciudad;
                         for(int cont=0;cont<ciudades.length;cont++)
                       {
                           ciudad=ciudades[cont];
                      %>
                        <option data-pais="<%=ciudad.get("pais")%>" value="<%=ciudad.get("cod_ciu")%>" <%=((String) ciudad.get("cod_ciu")).equals("11001")?"selected":""%>><%=ciudad.get("nom_ciu")%></option>
                      <%}%>

                 </select>
                      <script>
                          actCiudadesConPais();
                      </script>
                  <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
              </td>
            </tr>
             <tr>
              <td align="right">Dirección de la empresa:</td>
              <td  >
                  <input class="inputmediano"name="diremp" id="diremp" type="text" size="20" maxlength="25" >*
              </td>
            </tr>
             <tr>
              <td align="right">Pagina web:</td>
              <td  >
                  <input class="inputlargo"name="webemp" id="webemp" type="text" size="20"  >*
              </td>
            </tr>
             <tr>
              <td align="right">Email de la empresa:</td>
              <td >
                  <input class="inputlargo"name="emailemp" id="emailemp" type="text" size="20"  >*
              </td>
            </tr>
             <tr>
              <td align="right">Teléfono de la empresa:</td>
              <td >
                  <input class="inputmediano"name="telemp" id="telemp" type="text" size="20" maxlength="25" >*
              </td>
            </tr>
            <tr>
              <td >&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
                  <td colspan="2">
                      <table  width="100%" bordercolor='#CCCCFF' frame="hsides"    >
                          <tr>
                              <td width="5%" align="center" bgcolor="#CCCCFF" >
                                  2.
                              </td>
                              <td width="95%" align="left" bgcolor="f7f7f7">Datos de Recursos Humanos  </td>
                          </tr>
                      </table>
                  </td>

            </tr>
             <tr>
              <td align="right">Nombre del responsable de Recursos Humanos:</td>
              <td >
                  <input class="inputlargo"name="nomrrhh" id="nomrrhh" type="text" size="20"  >*
              </td>
            </tr>
             <tr>
              <td align="right">Teléfono:</td>
              <td >
                  <input class="inputmediano"name="telrrhh" id="telrrhh" type="text" size="20"  >*
              </td>
            </tr>
             <tr>
              <td align="right">Email:</td>
              <td  >
                  <input class="inputlargo"name="emailrrhh" id="emailrrhh" type="text" size="20"  >*
              </td>
            </tr>
            <tr>
              <td >&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
             <tr>
                  <td colspan="2">
                      <table  width="100%" bordercolor='#CCCCFF' frame="hsides">
                          <tr>
                              <td width="5%" align="center" bgcolor="#CCCCFF">
                                  2.
                              </td>
                              <td width="95%" align="left" bgcolor="f7f7f7">Datos de Contacto</td>
                          </tr>
                      </table>
                  </td>

            </tr>
             <tr>
              <td align="right">Nombre del contacto:</td>
              <td >
                  <input class="inputlargo"name="nomconte" id="nomconte" type="text" size="20"  >*
              </td>
            </tr>
             <tr>
              <td align="right">Cargo en la empresa:</td>
              <td >
                  <input class="inputlargo"name="cargoconte" id="cargoconte" type="text" size="20">*
              </td>
            </tr>
             <tr>
              <td align="right">Área:</td>
              <td  >
                  <input class="inputlargo"name="areaconte" id="areaconte" type="text" size="20"  >*
              </td>
            </tr>
             <tr>
              <td align="right">Profesión:</td>
              <td >
                  <input class="inputlargo"name="profconte" id="porfconte" type="text" size="20" >*
              </td>
            </tr>
             <tr>
              <td align="right">Teléfono:</td>
              <td >
                  <input class="inputmediano"name="telconte" id="telconte" type="text" size="20"  >*
              </td>
            </tr>
             <tr>
              <td align="right">Fax:</td>
              <td  >
                  <input class="inputmediano"name="faxconte" id="faxconte" type="text" size="20" maxlength="25" >*
              </td>
            </tr>
             <tr>
              <td align="right">Email:</td>
              <td  >
                  <input class="inputlargo"name="emailconte" id="emailconte" type="text" size="20"  >*
              </td>
            </tr>
             <tr>
              <td align="right">Celular:</td>
              <td >
                  <input class="inputmediano"name="celconte" id="celconte" type="text" size="20" maxlength="25" >*
              </td>
            </tr>
            <tr>
              <td >&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
                  <td colspan="2">
                      <table  width="100%" bordercolor='#CCCCFF' frame="hsides"    >
                          <tr>
                              <td width="5%" align="center" bgcolor="#CCCCFF" >
                                  3.
                              </td>
                              <td width="95%" align="left" bgcolor="f7f7f7">Datos de Identificaciòn dentro del Sistema</td>
                          </tr>
                      </table>
                  </td>
            </tr>
            <tr>
              <td align="right">Ingrese su clave:</td>
              <td >
                  <input type="password" class="inputmediano"name="passemp" id="passemp" type="text" size="20" maxlength="25" >*
              </td>
            </tr>
           
            <tr>
              <td align="right">Confirme su clave:</td>
              <td  >
                  <input type="password" class="inputmediano"name="passemp2" id="passemp2" type="text" size="20" maxlength="25" >*
              </td>
            </tr>
            <tr>
              <td >&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
                 <tr>
                  <td colspan="2">
                      <table  width="100%" bordercolor='#CCCCFF' frame="hsides"    >
                          <tr>
                              <td width="5%" align="center" bgcolor="#CCCCFF" >
                                  4.
                              </td>
                              <td width="95%" align="left" bgcolor="f7f7f7">Acepto términos y condiciones. </td>
                          </tr>
                      </table>
                  </td>

            </tr>
             <tr>
                  <td align="center" colspan="2">
                      <FONT SIZE=2>Al registrarme declaro que he leído y acepto los términos y condiciones expresadas por la Escuela Colombiana de Ingeniería Julio Garavito para el uso del sistema SIEMPREG 
                          y la bolsa de empleos expresadas en el siguiente <a href="http://practicas.escuelaing.edu.co/contenido/osiris/graduados/REGLAMENTOBOLSAEMPLEO.pdf">REGLAMENTO</a>.</FONT>
                  </td>
            </tr>
            <tr>
              <td colspan="2">
                <div align="center">
                    <input class="inputmediano" id="BtnRegEmp" type="submit" value="Registrar" name="Mostrar opcuni" onclick="registraremp();"/>
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
              <%
              /*conEjb=null;
                 System.gc();*/
              %>
</body>
</html>
