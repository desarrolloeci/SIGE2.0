<%-- 
    Document   : MenuAdminGrad
    Created on : 15/11/2012, 08:52:57 AM
    Author     : Luis Alberto Salas
--%>
<%--@page contentType="text/html" pageEncoding="ISO-8859-1"--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%
            response.setHeader("Cache-Control", "no-cache");

            documentos.ruta ruta = new documentos.ruta();
            String rol = new String();
            String usuario = new String();

            String error = new String();
            login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
            usuario = admin.getUser();
            rol = admin.getRol();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp", emp);
            HashMap[] programas = emp.getListaProgramas();
            HashMap programa;
            int prg = programas.length;
            //String paramtext = new String();
            //String titulo = new String("Servicio a Administradores");


            String arreglo[] = new String[50];
            String texto[] = new String[20];
            String noticias[] = new String[200];
            int i = 0, not = 0;
            int conmenu = 0;
            int k = 0;
            try {
                FileReader ra = new FileReader(ruta.valruta() + "serviciosSIGEGrad.txt");
                BufferedReader entrada = new BufferedReader(ra);
                String s;
                s = entrada.readLine();
                //empleado.setPeriodo(s);
                s = entrada.readLine();
                //empleado.setperHorario(s);
                s = entrada.readLine();
                //empleado.setTercio(s);
                while ((s = entrada.readLine()) != null) {
                    arreglo[i] = s;
                    i = i + 1;
                }
                ra = new FileReader(ruta.valruta() + "noticias.txt");
                entrada = new BufferedReader(ra);
                while ((s = entrada.readLine()) != null) {
                    noticias[not] = s;
                    not = not + 1;
                }
                entrada.close();
                ra.close();
                error = "OK";
            } catch (java.io.FileNotFoundException fnfex) {
                error = "Error: " + fnfex;
            } catch (java.io.IOException ioex) {
                error = "Error: " + ioex;
            }
        %>



        <title>Menu Sige</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunAdminGrad.js" ></script>



        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
        <style type="text/css"> 

        </style>
    </head>
    <body>
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_grad"></jsp:include>
            <div align="center">
                <fieldset class="field_set">
                    <table width="640"  align="center" cellspacing="0">
                        <tr class="textocom">
                            <td colspan="2" ><div align="center" class="menuprueba2"><font color="#FFFFFF"><strong>Opciones</strong></font></div></td>


                        </tr>
                        <tr bgcolor="#FFFFFF" class="textocom">
                            <td  valign="top">
                            <%
                                if (error.equals("OK")) {
                                    for (int j = 0; j < i; j++) {
                                        StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                        k = 0;
                                        while (st.hasMoreTokens()) {
                                            texto[k] = st.nextToken();
                                            k = k + 1;
                                        }
                            %>
                            <%


                                if (texto[2].equals("0")) {
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
                                                conmenu = conmenu + 1;
                                            }
                                        }
                                    }
                                %>

                            </table>


                        </td>

                        <td >
                            <table width="440" frame="lhs">
                                <tr>
                                    <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" >
                                        <div align="left" id="ConsultaTramOferGrad" style="display: none">
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
                                                        <b>Consultar Tramitar Oferta_____________________________________</b>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>

                                                <tr>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </table>

                                            <table  width="80%" border="1" class="tabla" name="tablaTramOferGrad" id="tablaTramOferGrad" align="center" >

                                                <thead>
                                                    <tr>
                                                        <th width="25%"><div align="center"><strong>Cargo</strong></div></th>
                                                        <th width="25%"><div align="center"><strong>Nom Empresa</strong></div></th>
                                                        <th width="25%"><div align="center"><strong>Nit Empresa</strong></div></th>
                                                        <th width="25%"><div align="center"><strong>Fecha venc.</strong></div></th>                                                   

                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpotablaTramOferGrad">
                                                </tbody>

                                            </table>
                                        </div>
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
                                                <input  class="inputlargo" value="<%=usuario%>" name="usuario" id="usuario" type="hidden" size="20">
                                                <tr>
                                                    <td colspan="2" align="center">
                                                        <input type="submit" value="Consultar" name="consultargraduado" onclick= "consultargraduado();"/>
                                                    </td>
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
                                                                    for (int cont = 0; cont < prg; cont++) {
                                                                        programa = programas[cont];
                                                                %>
                                                            <option value= "<%=programa.get("nom_prog")%>" ><%=programa.get("nom_prog")%>
                                                                <%}%>

                                                        </select>
                                                        <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="editaofergradAdmin" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <b>Eliminar Ofertas_______________________________________________</b>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        Por favor ingrese el nit de la empresa que público la oferta que quiere eliminar:
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>                                                  
                                                        <input name="nit_elm" id="nit_elm" type="text" size="20" maxlength="25">
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
                                        <div align="left" id="botonconsultarEliminarofer" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>
                                                        <br><input type="submit" value="consultar eliminar" name="consultar" onclick= "consultarEliminarofer();"/><br>
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
                                        <div align="left" id="tablaEditarofertasgrad" style="display: none">
                                            <table  width="80%" border="1" class="tabla" name="tablaEditarofergrad" id="tablaEditarofergrad" align="center" >

                                                <thead>
                                                    <tr>
                                                        <th width="30%"><div align="center"><strong>Cargo</strong></div></th>
                                                        <th width="30%"><div align="center"><strong>Nom Empresa</strong></div></th>
                                                        <th width="30%"><div align="center"><strong>Fecha venc.</strong></div></th>
                                                        <th width="25%"><div align="center"><strong>Ver postulantes</strong></div></th>

                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpotablaEditarofertasgrad">
                                                </tbody>

                                            </table>
                                        </div>
                                        <div align="left" id="emailAdminG" style="display: none">
                                            <form action="EmailMasivoGrad" method="post" onsubmit="return confirmEnviarMasivoGrad()">
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
                                                                <option value="AdminSige" selected>Administrador del Sistema</option>
                                                                <option value="EmpSige">Empresas</option>
                                                                <option value="TODOS1">TODOS PRIMER DIA</option>
                                                                <option value="TODOS2">TODOS SEGUNDO DIA</option>
                                                                <%
                                                                    for (int cont = 0; cont < prg; cont++) {
                                                                        programa = programas[cont];
                                                                    %>
                                                                <option value="<%=programa.get("nom_prog")%>"><%=programa.get("nom_prog")%></option>
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
                                                <script type="text/javascript" src="jscript/nicEdit2.js"></script>
                                                <script type="text/javascript">
                                                            //<![CDATA[
                                                            bkLib.onDomLoaded(function() {
                                                                new nicEditor({fullPanel: true}).panelInstance('mensajeAdminG');
                                                            });
                                                            //]]>
                                                </script>                                        
                                                <%--<textarea name="mensajeAdminG" id="mensajeAdminG" cols="5" accept-charset="ISO-8859-1">Escriba la Descripción...</textarea>--%>
                                                <textarea name="mensajeAdminG" id="mensajeAdminG" cols="5" accept-charset="UTF-8">Escriba la Descripción...</textarea>
                                                <table  width="480"  cellspacing="0">
                                                    <tr>
                                                        <td colspan="2">
                                                            <br><input type="submit" value="Enviar Email" name="EnviarEmail" /><br>
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
            </fieldset>  
        </div>
        <%
            /*conEjb = null;
            System.gc();*/
        %>
    </body>
</html>