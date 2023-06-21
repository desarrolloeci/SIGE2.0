<%-- 
    Document   : MenuAdminPrac
    Created on : 28/12/2012, 03:30:54 PM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EmpresaRemote"%>
<%@page import="BDsige.EmpleadoRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject;" %>

<html>
    <head>
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");

            documentos.ruta ruta = new documentos.ruta();
            
            String rol = new String();
            String usuario = new String();

            String error = new String();
            login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
            
            if (admin == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'loginAdmin';
                    </script>
                <%
                return;
            }
            
            usuario = admin.getUser();
            rol = admin.getRol();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp", emp);
            HashMap[] programas = emp.getListaProgramasPregrado();
            HashMap[] fechas = emp.getFechasPracticas();
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
                FileReader ra = new FileReader(ruta.valruta() + "serviciosSIGEPrac.txt");
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

                i = i - 1;

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
        <title>SIEMPREG - Administrador de Prácticas Profesionales</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunAdminGrad.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunAdminPrac.js" ></script>
        <link href="CSS/calendario.css" type="text/css" rel="stylesheet"> 
        <script src="jscript/calendar.js" type="text/javascript"></script> 
        <script src="jscript/calendar-es.js" type="text/javascript"></script> 
        <script src="jscript/calendar-setup.js" type="text/javascript"></script> 
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_prac"></jsp:include>
            <div align="center">
                <fieldset class="field_set" style="width: 1000px;">
                    <table width="1000" border="0" align="center" cellspacing="0">
                        <tr class="textocom">
                            <td width="30%" height="20"><div align="center" class="menuprueba2"><font color="#FFFFFF"><strong>Opciones</strong></font></div></td>

                            <td width="70%" valign="top"><div align="center" class="menuprueba2"><font color="#990000"><strong></strong></font></div></td>
                        </tr>
                        <tr bgcolor="#FFFFFF" class="textocom">
                            <td width="30%" valign="top">
                            <%
                                if (error.equals("OK")) {
                                    for (int j = 0; j <= i; j++) {
                                        StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                        k = 0;
                                        while (st.hasMoreTokens()) {
                                            texto[k] = st.nextToken();
                                            k = k + 1;
                                        }
                            %>
                            <%
                                if (texto[3].equals("0")) {
                            %>
                            <table width="100%"   cellspacing="0" >
                                <tr>
                                    <td width="200" height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM">
                                        <div align="left">
                                            <a onclick="<%=texto[5]%>" class="menuprueba">
                                                <font id="f<%=conmenu%>" color="#000000"><%=texto[4]%> </font></a></div>
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
                            <table frame="lhs" width="100%">
                                <tr>
                                    <td  valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" style="  box-shadow:  -5px 5px 5px 5px rgba(0,0,0,0.1); ">
                                        <div align="center" id="ActFechasPrac"  style="display: none">
                                            <table width="460" cellspacing="0" >
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="center"><a class="textocom3">Periodos Actuales</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom2">Periodo para estudiantes</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom">Periodo para enviar solicitud a los decanos</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[4].get("fecha")%></a></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[5].get("fecha")%></a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom">Periodo para postularse a las ofertas</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[0].get("fecha")%></a></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[1].get("fecha")%></a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom2">Periodo para empresas</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[2].get("fecha")%></a></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[3].get("fecha")%></a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom2">Periodo para Decanos</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[6].get("fecha")%></a></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[7].get("fecha")%></a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom2">Periodo para Practica de Estudiantes</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[8].get("fecha")%></a></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><a class="textonegro"><%=fechas[9].get("fecha")%></a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="center"><a class="textocom3">Registrar nuevos periodos</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom2">Nuevo Periodo para estudiantes</a></td>
                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom">Nuevo Periodo para enviar solicitud a los decanos</a></td>
                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechainSolEst" id="fechainSolEst"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Inicial Estudiantes" id="lanzadorinSolEst"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechainSolEst", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadorinSolEst" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechaoutSolEst" id="fechaoutSolEst"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Final Estudiantes" id="lanzadoroutSolEst"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechaoutSolEst", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadoroutSolEst" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom">Nuevo Periodo para postularce a las ofertas</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechainEst" id="fechainEst"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Inicial Estudiantes" id="lanzadorinEst"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechainEst", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadorinEst" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechaouteEst" id="fechaouteEst"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Final Estudiantes" id="lanzadoroutEst"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechaouteEst", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadoroutEst" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom2">Nuevo Periodo para empresas</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechainEmp" id="fechainEmp"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Inicial Empresas" id="lanzadorinEmp"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechainEmp", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadorinEmp" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechaoutEmp" id="fechaoutEmp"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Final Empresas" id="lanzadoroutEmp"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechaoutEmp", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadoroutEmp" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom2">Nuevo Periodo para decanos</a></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechainDec" id="fechainDec"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Inicial Empresas" id="lanzadorinDec"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechainDec", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadorinDec" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechaoutDec" id="fechaoutDec"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Final Empresas" id="lanzadoroutDec"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechaoutDec", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadoroutDec" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>

                                                </tr>
                                                                                                <tr>
                                                    <td colspan="4" align="left"><a class="textocom">Nuevo Periodo Practicas de Estudiantes</a></td>
                                                </tr>
                                                <tr>
                                                    <td colspan="1" align="left"><a class="textocom">&nbsp;Desde</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechainPracE" id="fechainPracE"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Min Fecha Inicio Practicas" id="lanzadorinPracE"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechainPracE", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadorinPracE" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>
                                                    <td colspan="1" align="left"><a class="textocom">Hasta</a></td>
                                                    <td colspan="1" align="left"><input class="inputcorto" type="text" name="fechaoutPracE" id="fechaoutPracE"/> 

                                                        <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Max Fecha Fin Practicas" id="lanzadoroutPracE"> 
                                                        <!-- script que define y configura el calendario--> 
                                                        <script type="text/javascript">
                                                            Calendar.setup({
                                                                inputField: "fechaoutPracE", // id del campo de texto 
                                                                ifFormat: "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                                                button: "lanzadoroutPracE" // el id del botón que lanzará el calendario 
                                                            });
                                                        </script></td>

                                                </tr>
                                                <tr>
                                                    <td colspan="4">&nbsp;</td>

                                                </tr>
                                                <tr><td colspan="4" align="center"> <input class="button_azul1" type="submit" onclick="registrarFecPrac();" value="Registrar nuevo periodo" /></td></tr>

                                            </table>
                                        </div>
                                        <div align="left" id="ConsultaPracAdmin" style="display: none">
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
                                                        <b>Consultar Practicante_______________________________________________</b>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>                                            
                                                <tr>
                                                    <td colspan="2">
                                                        <p>Por favor seleccione el programa acad&eacute;mico.</p>
                                                        <p>
                                                            <select name="ProgramaAcademicoPrac" id="ProgramaAcademicoPrac">
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
                                                            </select>
                                                        </p>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <p>Por favor seleccione el programa acad&eacute;mico.</p>
                                                        <p>
                                                            <select name="EstadoSolicitud" id="EstadoSolicitud">
                                                                <%--<option value="Inicial">Inicial-Sin Solicitud--%>
                                                                <%--<option value="AprobadoDec">Aprobado por decanatura--%>
                                                                <option value="Solicitud">Solicitud en tramite
                                                                <option value="Seleccionado">En Entrevistas
                                                                <%--<option value="Contratado">Contratado--%>
                                                            </select>
                                                        </p>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2" align="center">
                                                        <input id="consultarpracticantes" class="button_azul_consulta1" type="submit" value="Consultar" name="consultarpracticantes" onclick= "consultarpracticante();"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="tablaConsultaPracAdmin" style="display: none">

                                            <table  width="80%" border="1" class="tabla" id="tablaPracAdmin" align="center" >
                                                <thead>
                                                    <tr>
                                                        <th width="25%"><div align="center"><strong>Nombre</strong></div></th>
                                                        <th width="25%"><div align="center"><strong>Estado</strong></div></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpotablaPracAdmin">
                                                </tbody>
                                            </table>
                                        </div>
                                        <div align="left" id="ConsultaEmpAdminP" style="display: none">
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
                                                        <input  class="inputlargo" name="nombreEmpAdminP" id="nombreEmpAdminP" type="text" size="20"><br>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td width="25%">
                                                        Nit:
                                                    </td>
                                                    <td align="left">
                                                        <input  class="inputlargo" name="nitEmpAdminP" id="nitEmpAdminP" type="text" size="20"><br>
                                                    </td>

                                                </tr>

                                                <tr>
                                                    <td colspan="2" align="center">
                                                        <input type="submit" value="Consultar" name="consultargraduado" onclick= "consultarEmpAdminP();"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="tablaConsultaEmpAdminP" style="display: none">

                                            <table  width="80%" border="1" class="tabla" id="tablaEmpAdminP" align="center" >
                                                <thead>
                                                    <tr>
                                                        <th width="25%"><div align="center"><strong>Nombre de la Empresa</strong></div></th>
                                                        <th width="25%"><div align="center"><strong>Estado</strong></div></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpotablaEmpAdminP">
                                                </tbody>
                                            </table>
                                        </div>
                                        <div align="left" id="consultaoferpracAdmin" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <b>Consultar Ofertas de Practicas_______________________________________________</b>
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
                                                        <select class="inputxlargo" name="programapracAdmin" id="programapracAdmin">
                                                            <option value="TODOS" >TODOS</option>
                                                                <%
                                                                    for (int cont = 0; cont < prg; cont++) {
                                                                        programa = programas[cont];
                                                                %>
                                                            <option value= "<%=programa.get("nom_prog")%>" ><%=programa.get("nom_prog")%></option>
                                                                <%}%>

                                                        </select>
                                                        <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="botonconsultaoferpracAdmin" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>
                                                        <br><input type="submit" value="Consultar" name="consultar" id="consultarOfPracAdmin" onclick="consultaroferpracAdmin();"/><br>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="botontramitaoferpracAdmin" style="display: none">
                                            <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td  align="center"><a class="textocom3">Tramitar Oferta</a></td>

                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <br><input class="button_azul_consulta"type="submit" value="Consultar Tramitar" name="consultar" onclick= "consuloferTrapracAdmin();"/><br>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="tablaofertaspracAdmin" style="display: none">
                                            <table  width="80%" border="1" class="tabla" id="tablaoferpracAdmin" align="center" >

                                                <thead>
                                                    <tr>
                                                        <th width="30%"><div align="center"><strong>Cargo</strong></div></th>
                                                        <th width="30%"><div align="center"><strong>Nom Empresa</strong></div></th>
                                                        <th width="30%"><div align="center"><strong>Fecha venc.</strong></div></th>
                                                        <th width="25%"><div align="center"><strong>Ver postulantes</strong></div></th>

                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpotablaofertaspracAdmin">
                                                </tbody>

                                            </table>
                                        </div>
                                        <div align="left" id="tramitarofertaspracAdmin" style="display: none">
                                            <table  width="90%" border="1" class="tabla" id="tablaTraoferpracAdmin" align="center" >

                                                <thead>
                                                    <tr>
                                                        <th width="35%"><div align="center"><strong>Cargo</strong></div></th>
                                                        <th width="35%"><div align="center"><strong>Empresa</strong></div></th>
                                                        <th width="10%"><div align="center"><strong>Fecha de Vencimiento</strong></div></th>
                                                        <th width="20%"><div align="center"><strong>Observaciones</strong></div></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpotablaTraoferpracAdmin">
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
                                                                        for (int cont = 0; cont < prg; cont++) {
                                                                            programa = programas[cont];
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
                                                            <input  class="inputcorto" name="fechaoutemailG" id="fechaoutemailG" type="text" size="20">(dd/aa/aaaa)<br>
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
                                                                new nicEditor({fullPanel: true}).panelInstance('mensajeAdminG');
                                                            });
                                                            //]]>
                                                </script>
                                                <textarea  name="mensajeAdminG" id="mensajeAdminG" rows="10" cols="1">Escriba la Descripción...</textarea>
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
                        <td colspan="2" align="center">
                            <jsp:include page="footer">
                                <jsp:param name="type" value="general" />
                            </jsp:include>
                        </td>
                    </tr>
                </table>
            </fieldset>  
        </div>
    </body>
</html>
