<%-- 
    Document   : MenuAdminMovilidad
    Created on : 25/07/2012, 11:16:35 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EmpleadoRemote"%>
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

            documentos.ruta ruta = new documentos.ruta();
            String rol = new String();
            String usuario = new String();

            String error = new String();
            login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
            usuario = admin.getUser();
            rol = admin.getRol();
            //String paramtext = new String();
            //String titulo = new String("Servicio a Administradores");


            String arreglo[] = new String[50];
            String texto[] = new String[20];
            String noticias[] = new String[200];
            int i = 0, not = 0;
            int conmenu = 0;
            int k = 0;
            try {
                FileReader ra = new FileReader(ruta.valruta() + "serviciossSIGE.txt");
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


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Sige</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunVice.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_mov"></jsp:include>
            <div align="center">
                <fieldset class="field_set">
                    <table width="600" border="0" align="center" cellspacing="0">
                        <tr class="textocom">
                            <td width="30%" height="20"><div align="center" class="menuprueba2"><font color="#FFFFFF"><strong>Opciones</strong></font></div></td>
                            <td width="70%" valign="top"><div align="center" class="menuprueba2"><font color="#990000"><strong></strong></font></div></td>
                        </tr>
                        <tr bgcolor="#FFFFFF" class="textocom">
                            <td width="30%" valign="top">
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


                                if (texto[1].equals("0")) {
                            %>
                            <table width="100%"    cellspacing="0" >
                                <tr>
                                    <td width="200" height="20" bgcolor="FFFFFF" > <%--onMouseOver="this.style.backgroundColor='#CCCCFF'"  onMouseOut=" this.style.backgroundColor='#FFFFFF'"--%>
                                        <div align="left" class="tabla">
                                            <a onclick="<%=texto[6]%>"  class="menuprueba">
                                                <font id="f<%=conmenu%>" color="#000000"><%=texto[5]%> </font></a></div>
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

                        <td width="70%" align="left">
                            <table  width="460" frame="lhs">
                                <tr>
                                    <td width="100%" valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" >
                                        <div align="left" id="consultamov" style="display: none">
                                            <table  width="460"  cellspacing="0">
                                                <tr>
                                                <p>Por favor seleccione el programa acad&eacute;mico.</p>
                                                <p>
                                                    <select name="ProgramaAcademico" id="ProgramaAcademico">
                                                        <!--
                                                        <option value="13">Ingenier&iacute;a Civil
                                                        <option value="14">Ingenier&iacute;a El&eacute;ctrica
                                                        <option value="15">Ingenier&iacute;a de Sistemas
                                                        <option value="16">Ingenier&iacute;a Industrial
                                                        <option value="17">Ingenier&iacute;a Electr&oacute;nica
                                                        <option value="260">Ingenier&iacute;a Mec&aacute;nica
                                                        <option value="262">Ingenier&iacute;a Biom&eacute;dica
                                                        <option value="19">Administraci&oacute;n de Empresas
                                                        <option value="18">Econom&iacute;a
                                                        <option value="20">Matem&aacute;ticas
                                                        -->
                                                        <option value="0">Todos los programas
                                                    </select>

                                                </p>
                                                <p>Por favor seleccione el programa de movilidad.</p>
                                                <p>
                                                    <select name="ProgramaMovilidad" id="ProgramaMovilidad">
                                                        <option value="'INTERCAMBIO NACIONAL'">Intercambio Nacional
                                                        <option value="'INTERCAMBIO LOCAL'">Intercambio Local
                                                        <option value="'JOVENES INGENIEROS'">Jovenes Ingenieros
                                                        <option value="'INTERCAMBIO SOCIAL'">Intercambio Social
                                                        <option value="'PRACTICA INTERNACIONAL' ">Pr&aacute;ctica Internacional
                                                        <option value="'INTERCAMBIO INTERNACIONAL'">Intercambio Internacional
                                                        <option value="'DOBLE TITULACION'">Doble Titulaci&oacute;n
                                                        <option value="0">Todos los programas
                                                    </select>
                                                    </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="datosRedEst" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                <p>Por favor Ingrese el Numero del Carné:</p>
                                                <p>
                                                    <input  name="Carnetest" id="Carnetest" type="text" size="20" maxlength="25">

                                                </p>
                                                <p>Por favor seleccione el programa de movilidad.</p>
                                                <p>
                                                    <select name="ProgramaMovilidadEsp" id="ProgramaMovilidadEsp">
                                                        <option value="'JOVENES INGENIEROS'">Jovenes Ingenieros
                                                        <option value="'INTERCAMBIO SOCIAL'">Intercambio Social
                                                        <option value="'PRACTICA INTERNACIONAL' ">Pr&aacute;ctica Internacional
                                                    </select>
                                                    </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="botondatosRedEst" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input class="button_azul_consulta" type="submit" value="Registrar" name="consultar" onclick= "RegistrarEstEspMov();"/>
                                                    </td>

                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="botonconsultamov" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input class="button_azul_consulta" type="submit" value="consultar" name="consultar" onclick= "consultarApMov();"/>
                                                    </td>

                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="botonaprobardoc" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input class="button_azul_consulta1" type="submit" value="Mostrar documentos" name="Mostrar documentos" onclick= " consultarDocumentos();"/>
                                                    </td>

                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="botonclacificarUni" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input class="button_azul_consulta" type="submit" value="Consultar" name="Mostrar opcuni" onclick= " consultaropcuni();"/>
                                                    </td>

                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="botonestEXT" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input class="button_azul_consulta" type="submit" value="Consultar" name="Mostrar opcuni" onclick= " consultarestEXT();"/>
                                                    </td>

                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="botonfinpro" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input class="button_azul_consulta" type="submit" value="Consultar" name="Mostrar fin" onclick= " consultarestEXTfin();"/>
                                                    </td>

                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="tablaconsultamov" style="display: none">

                                            <table  width="80%" border="1" class="tabla" id="tablaplicantes" align="center" >
                                                <thead>
                                                    <tr>
                                                        <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                                        <th width="20%"><div align="center"><strong>Programa movilidad</strong></div></th>
                                                        <th width="10%"><div align="center"><strong>Estado</strong></div></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpo">
                                                </tbody>
                                            </table>
                                        </div>
                                        <div align="left" id="tablaaprobardoc" style="display: none">

                                            <table  width="80%" border="1" class="tabla" id="tablaestdocumentos" align="center" >
                                                <thead>
                                                    <tr>
                                                        <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                                        <th width="20%"><div align="center"><strong>Programa movilidad</strong></div></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpo3">
                                                </tbody>
                                            </table>
                                        </div>
                                        <div align="left" id="tablaclacificarUni" style="display: none">
                                            <table  width="80%" border="1" class="tabla" id="tablaclacifUni" align="center" >
                                                <thead>
                                                    <tr>
                                                        <th width="20%"><div align="center"><strong>Nombre del estudiante</strong></div></th>
                                                        <th width="20%"><div align="center"><strong>Nombre de la Institución</strong></div></th>
                                                        <th width="20%"><div align="center"><strong>estado</strong></div></th>
                                                        <th width="20%"><div align="center"><strong>Clasificaciones</strong></div></th>

                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpo6">
                                                </tbody>
                                            </table>
                                        </div>
                                        <div align="left" id="tablaconsultaestEXT" style="display: none">
                                        <p class="textocom2"><b>Estudiantes para consultar proceso:</b></p>
                                            <table  width="80%" border="1" class="tabla" id="tablaestEXT" align="center" >
                                                <thead>
                                                    <tr>
                                                        <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                                        <th width="20%"><div align="center"><strong>Programa movilidad</strong></div></th>
                                                        <th width="10%"><div align="center"><strong>Estado</strong></div></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpoestEXT">
                                                </tbody>
                                            </table>
                                        </div>
                                        <div align="left" id="tablafinproceso" style="display: none">
                                            <p class="textocom2"><b>Estudiantes para finalizar proceso:</b></p>
                                            <table  width="80%" border="1" class="tabla" id="tablafinpro" align="center" >
                                                <thead>
                                                    <tr>
                                                        <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                                        <th width="20%"><div align="center"><strong>Programa movilidad</strong></div></th>
                                                        <th width="10%"><div align="center"><strong>Estado</strong></div></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpotablafinpro">
                                                </tbody>
                                            </table>
                                        </div>
                                        <div align="left" id="cambiarcontratos" style="display: none">
                                            <table  width="80%" class="tabla" id="tablacambiarcontratos" align="center" >
                                                <tr>
                                                    <td  align="left">
                                                        <br/><p> Por favor seleccione el programa de movilidad al cual le desea cambiar los términos del contrato.</p>                                                  
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td   align="left">
                                                        <select name="OpcContratoPrograma" id="OpcContratoPrograma">
                                                            <option value="'INTERCAMBIO NACIONAL'">Intercambio Nacional
                                                            <option value="'INTERCAMBIO LOCAL'">Intercambio Local
                                                            <option value="'JOVENES INGENIEROS'">Jovenes Ingenieros
                                                            <option value="'INTERCAMBIO SOCIAL'">Intercambio social
                                                            <option value="'PRACTICA INTERNACIONAL' ">Pr&aacute;ctica Internacional
                                                            <option value="'INTERCAMBIO INTERNACIONAL'">Intercambio Internacional
                                                            <option value="'DOBLE TITULACION'">Doble Titulaci&oacute;n
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td   align="left">
                                                        <br/><p>Por favor introduzca el texto de "la descripción del programa de movilidad" y el texto de "los comentarios del contrato para el programa de movilidad"</p>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td   align="left">
                                                        <br/><p> Descripcion del programa seleccionado</p>
                                                        <textarea name="descripcioncont_mov" id="descripcioncont_mov" rows="10" cols="38">Escriba la descripcion....</textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td   align="left">
                                                        <br/><p> Comentarios para el programa seleccionado</p>
                                                        <textarea name="comentariocont_mov" id="comentariocont_mov" rows="10" cols="38">Escriba el comentario....</textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td  align="left">
                                                        <input type="submit" value="Modificar Contrato" name="cambiarcontrato" onclick= " cambiarcontrato();"/>
                                                    </td>
                                                </tr>

                                            </table>
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
    </body>
</html>