<%-- 
    Document   : MenuMonitor
    Created on : 8/11/2013, 10:05:21 AM
    Author     : Luis Salas
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="BDsige.EmpresaRemote"%>
<%@page import="BDsige.EmpleadoRemote"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,
         javax.rmi.PortableRemoteObject"
         %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <%
            response.setHeader("Cache-Control","no-cache");

            documentos.ruta ruta = new documentos.ruta();
            String rol = new String ();
             String usuario = new String ();

            String error = new String();
            login.SessionUsrRemote admin =(login.SessionUsrRemote) session.getAttribute("usuario");
            
            if (admin == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'loginAdmin';
                    </script>
                <%
                return;
            }
            
            usuario=admin.getUser();
            rol=admin.getRol();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();    
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp",emp);
            HashMap[] programas= emp.getListaProgramas();
            HashMap programa;
            int prg =programas.length;
            //String paramtext = new String();
            //String titulo = new String("Servicio a Administradores");


            String arreglo[]=new String[50];
            String texto[]=new String[20];
            String noticias[]=new String[200];
            int i=0, not=0;
            int conmenu = 0;
            int k=0;
            try {
                FileReader ra = new FileReader(ruta.valruta() + "serviciosSIGEMon.txt");
                BufferedReader entrada = new BufferedReader(ra);
                String s;
                s = entrada.readLine();
                //empleado.setPeriodo(s);
                s = entrada.readLine();
                //empleado.setperHorario(s);
                s = entrada.readLine();
                //empleado.setTercio(s);
                while((s = entrada.readLine()) != null) {
                    arreglo[i]= s;
                    i=i+1;
                }
                ra = new FileReader(ruta.valruta() + "noticias.txt");
                entrada = new BufferedReader(ra);
                while((s = entrada.readLine()) != null) {
                    noticias[not]= s;
                    not=not+1;
                }
                entrada.close();
                ra.close();
                error = "OK";
            }catch(java.io.FileNotFoundException fnfex) {
                error = "Error: " + fnfex;
            }catch(java.io.IOException ioex) {
                error = "Error: " + ioex;
            }
        %>
        <title>SIEMPREG - Monitor</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunAdminGrad.js" ></script>
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
    <body background="imagenes/fondoblanco.gif">
        <jsp:include page="header">
            <jsp:param name="type" value="admin" />
        </jsp:include>
        <table width="640" align="center" class="curvas loginPanel" cellspacing="5">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        Opciones Empresa
                    </div>
                </td>
            </tr>
            <tr class="textocom" style="height: 0px;">
                <td width="200"><!--<div align="center" class="menuprueba2"><font color="#FFFFFF"><strong>Opciones</strong></font></div>--></td>
                <td width="430" valign="top"><!--<div align="center" class="menuprueba2"><font color="#990000"><strong></strong></font></div>--></td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td valign="top">
                    <%
                      if(error.equals("OK"))
                      {
                        for (int j=0; j<i; j++)
                        {
                            StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                            k=0;
                            while (st.hasMoreTokens())
                            {
                                texto[k]=st.nextToken();
                                k=k+1;
                            }
                    %>
                    <%


                            if(texto[2].equals("0") && texto[1].equals("0")){
                        %>
                             <table width="200"   cellspacing="0" >
                                        <tr>
                                            <td width="200" height="20" bgcolor="FFFFFF"  >
                                                <div align="left">
                                                    <a onclick="<%=texto[4]%>" class="menuprueba">
                                                       <font id="f<%=conmenu%>" color="#000000"><%=texto[3]%> </font></a></div>
                                            </td>
                                        </tr>
                        <%
                                        conmenu = conmenu+1;
                             }
                           }
                        }
                        %>

                    </table>


                </td>

                <td>
                    <table width="100%" frame="lhs">
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" style="  box-shadow:  -5px 5px 5px 5px rgba(0,0,0,0.1); ">
                             <div align="left" id="ConsultaGradAdmin" style="display: none">
                                <table cellspacing="0">
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                         <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                        <tr>
                                                  <td colspan="2">
                                                      <b>Consultar graduado_______________________________________________</b>
                                                  </td>

                                            </tr>
                                            <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                            <tr>
                                                  <td width="25%">
                                                         Nombre:
                                                  </td>
                                                  <td align="left">
                                                      <input  class="inputlargo" name="nombregrad" id="nombregrad" type="text" size="20"><br>
                                                  </td>
                                            </tr>
                                            <tr>
                                                  <td width="25%">
                                                         Apellido:
                                                  </td>
                                                  <td align="left">
                                                      <input  class="inputlargo" name="apellidograd" id="apellidograd" type="text" size="20"><br>
                                                  </td>
                                            </tr>
                                            <tr>
                                                  <td>
                                                         Ingrese el Documento:
                                                  </td>
                                                  <td>
                                                      <input  class="inputmediano" name="DocGrad" id="DocGrad" type="text" size="20">
                                                  </td>
                                            </tr>
                                          <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                         <input  class="inputlargo" value="<%=usuario%>" name="usuario" id="usuario" type="hidden" size="20"><br>
                                            <tr>
                                              <td colspan="1" align="center">
                                                        <input type="submit" value="Consultar" name="consultargraduado" onclick= "consultargraduado();"/>
                                              </td>
                                              <!--td colspan="1" align="center">
                                                        <input type="submit" value="Listar Todos" name="consultargraduado" onclick= "consultargraduado2();"/>
                                              </td-->
                                           </tr>
                                             <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                    </table>
                                  </div>
                                 <div align="left" id="tablaConsultaGradAdmin" style="display: none">

                                      <table  width="80%" border="1" class="tabla" id="tablaGradAdmin" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="25%"><div align="center"><strong>Nombre</strong></div></th>                                                    
                                                    <th width="25%"><div align="center"><strong>Programa</strong></div></th>                                                    
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpotablaGradAdmin">
                                            </tbody>
                                        </table>
                                </div>
                                <div align="left" id="ConsultaEmpAdminG" style="display: none">
                                <table    cellspacing="0">
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                         <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                        <tr>
                                                  <td colspan="2">
                                                      <b>Consultar Empresa_______________________________________________</b>
                                                  </td>

                                            </tr>
                                            <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                            <tr>
                                                  <td width="25%">
                                                         Nombre:
                                                  </td>
                                                  <td align="left">
                                                      <input  class="inputlargo" name="nombreEmpAdminG" id="nombreEmpAdminG" type="text" size="20"><br>
                                                  </td>
                                            </tr>
                                            <tr>
                                                  <td width="25%">
                                                         Nit:
                                                  </td>
                                                  <td align="left">
                                                      <input  class="inputlargo" name="nitEmpAdminG" id="nitEmpAdminG" type="text" size="20"><br>
                                                  </td>

                                            </tr>

                                            <tr>
                                                <td colspan="2" align="center">
                                                        <input type="submit" value="Consultar" name="consultargraduado" onclick= "consultarEmpAdminG();"/>
                                              </td>
                                           </tr>
                                         <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                    </table>
                                  </div>
                                 <div align="left" id="tablaConsultaEmpAdminG" style="display: none">

                                      <table  width="80%" border="1" class="tabla" id="tablaEmpAdminG" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="25%"><div align="center"><strong>Nombre de la Empresa</strong></div></th>
                                                    <th width="25%"><div align="center"><strong>Estado</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpotablaEmpAdminG">
                                            </tbody>
                                        </table>
                                </div>
                                <div align="left" id="consultaofergradAdmin" style="display: none">
                                    <table  width="480"  cellspacing="0">
                                        <tr>
                                            <td>&nbsp;</td>
                                           
                                         </tr>
                                         <tr>
                                            <td>&nbsp;</td>
                                            
                                         </tr>
                                        <tr>
                                                  <td>
                                                      <b>Consultar Ofertas_______________________________________________</b>
                                                  </td>

                                            </tr>
                                            <tr>
                                            <td>&nbsp;</td>
                                            
                                         </tr>
                                        <tr>
                                            <td>
                                                Por favor seleccione un programa académico:
                                            </td>
                                        </tr>
                                        <tr>
                                              <td>
                                                  <select class="inputxlargo" name="programagradAdmin" id="programagradAdmin">
                                                      <option value="TODOS" >TODOS
                                                      <%
                                                         for(int cont=0;cont<prg;cont++)
                                                       {
                                                           programa=programas[cont];
                                                      %>
                                                        <option value= "<%=programa.get("id_prog")%>" ><%=programa.get("nom_prog")%>
                                                      <%}%>

                                                 </select>
                                                  <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                                </td>
                                            </tr>
                                    </table>
                                    </div>
                                <div align="left" id="botonconsultaofergradAdmin" style="display: none">
                                    <table  width="480"  cellspacing="0">
                                        <tr>
                                            <td>
                                                <br><input type="submit" value="consultar" name="consultar" onclick= "consultarofergradAdmin();"/><br>
                                           </td>
                                           
                                        </tr>
                                        <tr>
                                            <td>&nbsp;</td>
                                        </tr>
                                    </table>
                                </div>
                                    <div align="left" id="tablaofertasgradAdmin" style="display: none">
                                      <table  width="80%" border="1" class="tabla" name="tablaofergradAdmin" id="tablaofergradAdmin" align="center" >

                                                <thead>
                                                    <tr>
                                                        <th width="30%"><div align="center"><strong>Cargo</strong></div></th>
                                                        <th width="30%"><div align="center"><strong>Nom Empresa</strong></div></th>
                                                        <th width="30%"><div align="center"><strong>Fecha venc.</strong></div></th>
                                                        <th width="25%"><div align="center"><strong>Ver postulantes</strong></div></th>

                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpotablaofertasgradAdmin">
                                                </tbody>

                                        </table>
                                  </div>
                                  <div align="left" id="emailAdminG" style="display: none">
                                      <form action="EmailMasivoGrad"  method="post" >
                                      <table cellspacing="0">
                                        <tr>
                                              <td colspan="2">
                                                  <b>Correo Masivo_______________________________________________</b>
                                               </td>
                                         </tr>
                                         <tr>
                                            <td colspan="2">&nbsp;</td>
                                         </tr>
                                          <tr>
                                            <td colspan="2">
                                                Por favor seleccione un programa académico:
                                            </td>
                                        </tr>
                                        <tr>
                                              <td colspan="2">
                                                  <select class="inputxlargo" name="programaEmailAdmin" id="programaEmailAdmin">
                                                      <option value="AdminSige"> Administrador del Sistema.
                                                      <option value="TODOS" >TODOS
                                                      <%
                                                         for(int cont=0;cont<prg;cont++)
                                                       {
                                                           programa=programas[cont];
                                                      %>
                                                        <option value= "<%=programa.get("nom_prog")%>" ><%=programa.get("nom_prog")%>
                                                      <%}%>

                                                 </select>
                                                  <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                                </td>
                                            </tr>
                                            <tr>
                                            <td colspan="2">&nbsp;</td>
                                        </tr>
                                            <tr>
                                            <td colspan="2">
                                               Por favor ingrese el periodo de tiempo de las promociones:
                                            </td>
                                        </tr>
                                            <tr>
                                                  <td width="25%">
                                                         Fecha inicial:
                                                  </td>
                                                  <td align="left">
                                                      <input  class="inputcorto" name="fechainemailG" id="fechainemailG" type="text" size="20">(dd/mm/aaaa)<br>
                                                  </td>
                                           </tr>
                                            <tr>
                                                  <td width="25%">
                                                         Fecha Final:
                                                  </td>
                                                  <td align="left">
                                                      <input  class="inputcorto" name="fechaoutemailG" id="fechaoutemailG" type="text" size="20">(dd/mm/aaaa)<br>
                                                  </td>
                                           </tr>
                                           <tr>
                                            <td colspan="2">&nbsp;</td>
                                        </tr>
                                         <tr>
                                                  <td width="25%">
                                                         Asunto:
                                                  </td>
                                                  <td align="left">
                                                      <input  class="inputlargo" name="asuntoemailmas" id="asuntoemailmas" type="text" size="20"><br>
                                                  </td>
                                           </tr>
                                      </table>
                                          <script type="text/javascript" src="jscript/nicEdit2.js"></script> <script type="text/javascript">
                                        //<![CDATA[
                                          bkLib.onDomLoaded(function() {
                                                new nicEditor({fullPanel : true}).panelInstance('mensajeAdminG');
                                          });
                                          //]]>
                                          </script>                                        
                                                <textarea  name="mensajeAdminG" id="mensajeAdminG" rows="20" cols="1" accept-charset="ISO-8859-1">Escriba la Descripción...</textarea>
                                          <table  width="480"  cellspacing="0">                                            
                                        <tr>
                                            <td colspan="2">
                                                <br> <input type="submit" value="Enviar Email" name="EnviarEmail" /><br>
                                           </td>
                                        </tr>

                                    </table>
                                </form>

                                  </div>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
                                                <%
                 /*conEjb=null;
                 System.gc();*/
                %>
    </body>
</html>
