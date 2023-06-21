<%-- 
    Document   : MenuDecano
    Created on : 10/08/2012, 04:32:05 PM
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



            //String paramtext = new String();
            //String titulo = new String("Servicio a Administradores");

            String error = new String();
            login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
            
            if (admin == null) {
                %>
                <script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loginDec';
                  </script>
                <%
                return;
            }
            
            String rol = new String();
            String usuario = new String();
            usuario = admin.getUser();
            rol = admin.getRol();
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
                //i=i-1;
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
        <title>SIEMPREG Movilidad - Menú Decanatura</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
        <style type="text/css"> 
            body { 
                background: url('imagenes/fondoblanco.gif');
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
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="mov" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" cellspacing="10">
            <tr class="textocom">
                <td align="center" style="padding-bottom: 5px; width: 30%;">
                    <font color="#990000"><strong>Opciones</strong></font>
                </td>
                <td width="70%"></td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td valign="top">
                    <%
                        if (error.equals("OK")) {
                            for (int j = 0; j < i; j++) {
                                StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                k = 0;
                                while (st.hasMoreTokens()) {
                                    texto[k] = st.nextToken();
                                    k = k + 1;
                                }
                        if (texto[3].equals("0")) {
                    %>
                    <table width="100%" border="0"  cellspacing="0" bordercolor="#EEEBFC">
                        <tr>
                            <td width="200"  height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM" >
                                <div align="left">
                                    <a onclick="<%=texto[6]%>" class="menuprueba">
                                        <font id="f<%=conmenu%>" color="#000000"><%=texto[5]%></font>
                                    </a>
                                </div>
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
                <td align="left">
                    <table width="440" frame="lhs" >
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" style="  box-shadow:  -5px 5px 5px 5px rgba(0,0,0,0.1); ">

                                <div align="left" id="consultamov" style="display: none">
                                    <table  width="440"  cellspacing="0">
                                        <tr class="textocom">
                                        <p>
                                            <select name="ProgramaAcademico" id="ProgramaAcademico" disabled style="display: none">
                                                <option value=<%=rol%>>Decanatura</option>
                                            </select>
                                        </p>
                                        <p>Por favor seleccione el programa de movilidad.</p>
                                        <p>
                                            <select name="ProgramaMovilidad" id="ProgramaMovilidad">
                                                <option value="0">Todos los programas
                                                <option value="'INTERCAMBIO NACIONAL'">Intercambio Nacional
                                                <option value="'INTERCAMBIO LOCAL'">Intercambio Local
                                                <option value="'JOVENES INGENIEROS'">Jovenes Ingenieros
                                                <option value="'INTERCAMBIO SOCIAL'">Intercambio social
                                                <option value="'PRACTICA INTERNACIONAL' ">Pr&aacute;ctica Internacional
                                                <option value="'INTERCAMBIO INTERNACIONAL'">Intercambio Internacional
                                                <option value="'DOBLE TITULACION'">Doble Titulaci&oacute;n
                                            </select>                                         
                                            </tr>
                                        <tr>
                                            <td>
                                                &nbsp;
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div align="left" id="botonconsultamov" style="display: none">
                                    <table  width="440"  cellspacing="0">
                                        <input class="button_azul_consulta" type="submit" value="consultar" name="consultar" onclick= "consultarApMov();"/>
                                    </table>
                                </div>
                                <div align="left" id="botonaprobarsol" style="display: none">
                                    <table  width="440"  cellspacing="0">
                                        <input class="button_azul_consulta1" type="submit" value="Mostrar Postulantes" name="Mostrar aplicantes" onclick= " consultarCartas();"/>
                                    </table>
                                </div>
                                <div align="left" id="botonLisEstPlan" style="display: none">
                                    <table  width="440"  cellspacing="0">
                                        <input class="button_azul_consulta1" class="inputlargo" type="submit" value="Mostrar Estudiantes con plan" name="Mostrar Estudiantes con plan" onclick= " consultarEstPlan();"/>
                                    </table>
                                </div>
                                <div align="left" id="botonestEXT" style="display: none">
                                    <table  width="440"  cellspacing="0">
                                        <input class="button_azul_consulta" type="submit" value="Consultar" name="Mostrar opcuni" onclick= " consultarestEXT();"/>
                                    </table>
                                </div>
                                <div align="left" id="botonLiscambioPlan" style="display: none">
                                    <table  width="440"  cellspacing="0">
                                        <input class="button_azul_consulta1" type="submit" value="Mostrar solicitud de cambio" name="Mostrar cambio plan" onclick= " consultarcambioPlan();"/>
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
                                <div align="left" id="tablaaprobarsol" style="display: none">

                                    <table  width="80%" border="1" class="tabla" id="tablasolicitudes" align="center" >
                                        <thead>
                                            <tr>
                                                <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                                <th width="20%"><div align="center"><strong>Programa movilidad</strong></div></th>
                                            </tr>
                                        </thead>
                                        <tbody id="cuerpo2">
                                        </tbody>
                                    </table>                                   
                                </div>
                                <div align="left" id="tablaaprobarplan" style="display: none">

                                    <table  width="80%" border="1" class="tabla" id="tablaLisEstPlan" align="center" >
                                        <thead>
                                            <tr>
                                                <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                                <th width="20%"><div align="center"><strong>Programa movilidad</strong></div></th>
                                            </tr>
                                        </thead>
                                        <tbody id="cuerpoEstPlan">
                                        </tbody>
                                    </table>                      
                                </div>
                                <div align="left" id="tablaconsultaestEXT" style="display: none">

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
                                <div align="left" id="tablaaprobarcambioplan" style="display: none">

                                    <table  width="80%" border="1" class="tabla" id="tablaLisEstcambioPlan" align="center" >
                                        <thead>
                                            <tr>
                                                <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                                <th width="20%"><div align="center"><strong>Programa movilidad</strong></div></th>
                                            </tr>
                                        </thead>
                                        <tbody id="cuerpocambioEstPlan">
                                        </tbody>
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
    </body>
</html>
