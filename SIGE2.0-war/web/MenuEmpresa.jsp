<%-- 
    Document   : MenuEmpresa
    Created on : 18/10/2012, 11:51:46 AM
    Author     : Luis Alberto Salas
--%>
<%@page import="BDsige.EmpresaRemote"%>
<%@page import="documentos.RutaDoc"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,
         javax.rmi.PortableRemoteObject"
         %>

<html>
    <head>
        <%
            response.setHeader("Cache-Control", "no-cache");
            documentos.ruta ruta = new documentos.ruta();
            String usuario = new String();
            String Contacto = new String();

            login.SessionEmpRemote empresa = (login.SessionEmpRemote) session.getAttribute("usuario");
            
            //Verificamos que la sesión esté activa
            if (empresa == null) {
                %><script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loingempresa';
                  </script><%
                return;
            }
            
            String msgOfer=request.getParameter("msgOfer");

            if(msgOfer!=null&&!msgOfer.trim().equals("")){
                %><script>
                    alert("<%=msgOfer%>");
                  </script><%
            }

            usuario = empresa.getUser();
            Contacto = empresa.getUserCont();
            
            if (!Contacto.equals("0")) {
                %><script>
                    alert("Los contactos no están autorizados para modificar los datos de su empresa.");
                    window.location = 'MenuEmpContactos';
                  </script><%
                return;
            }
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar(usuario);
            session.setAttribute("emp", emp);
            
            String error = new String();
            
            //Define las fechas definidas por la UGE y comprueba si la fecha actual se encuentra dentro de esta.
            Calendar hoy = Calendar.getInstance();
            hoy.getTime();
            
            HashMap[] fechasemp=emp.getFechasPracticasEmp();
            
            int year_in = Integer.parseInt((String) fechasemp[0].get("year"));                
            int year_out = Integer.parseInt((String) fechasemp[1].get("year"));
            int mes_in= Integer.parseInt((String) fechasemp[0].get("mes"));
            int mes_out = Integer.parseInt((String) fechasemp[1].get("mes"));
            int dia_in= Integer.parseInt((String) fechasemp[0].get("dia"));
            int dia_out = Integer.parseInt((String) fechasemp[1].get("dia"));

            Calendar fInEmp = Calendar.getInstance();
            Calendar fOutEmp = Calendar.getInstance();
            
            fInEmp.set(year_in, mes_in-1, dia_in, 0, 0, 0);
            fOutEmp.set(year_out, mes_out-1, dia_out, 24, 59, 59);
            
            String periodo = "bloquearPrac";
            
            if ((hoy.after(fInEmp) || hoy.equals(fInEmp)) && (hoy.before(fOutEmp) || hoy.equals(fOutEmp))) {
                periodo = "activarPrac";
            }
            
            String arreglo[] = new String[50];
            String texto[] = new String[20];
            String noticias[] = new String[200];

            int i = 0, not = 0;
            int conmenu = 0;
            int k = 0;
            
            try {
                FileReader ra = new FileReader(ruta.valruta() + "serviciosSIGEEmp.txt");
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
        <title>SIEMPREG Empresas - Menú Principal</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/funcionemp.js" ></script>
        <link href="CSS/empresas.css" rel="stylesheet" type="text/css">
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
    <body onload="myFunctionIni();">
        <jsp:include page="header">
            <jsp:param name="type" value="emp" />
        </jsp:include>
        <table width="800" align="center" class="curvas loginPanel" cellspacing="10">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        Opciones Empresa
                    </div>
                </td>
            </tr>
                <tr bgcolor="#FFFFFF" class="textocom">
                    <td valign="top" style="padding-right: 10px;">
                        <table width="200" border="0"  cellspacing="0" bordercolor="#EEEBFC">
                            <tr class="textocom">
                                <td colspan="2">
                                    <div align="center" class="panelSubMenu">
                                        Opciones Generales
                                    </div>
                                </td>
                            </tr>
                        <%
                            if (error.equals("OK")) {
                                for (int j = 0; j <= i; j++) {
                                    StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                    k = 0;
                                    while (st.hasMoreTokens()) {
                                        texto[k] = st.nextToken();
                                        k = k + 1;
                                    }
                                    if (texto[0].equals("4")) {
                        %>
                        <tr>

                            <td width="200"  height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM"  >
                                <div align="left" >
                                    <a onclick="<%=texto[3]%>" class="menuprueba" >
                                        <font id="f<%=conmenu%>" color="#000000"><%=texto[2]%> </font></a></div>
                            </td>
                        </tr>
                        <%
                                        conmenu = conmenu + 1;
                                    }
                                }
                            }
                        %>
                        <tr>

                            <td width="200" height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM"  >
                                &nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td>Seleccione:</td>
                        </tr>
                        <tr style="height: 10px;">
                        <tr>
                            <td align="center"><button style="width: 80%;" onclick="myFunction()" class="textocom">Bolsa de Empleo</button><button style="width: 80%;" onclick="myFunction2()" class="textocom">Prácticas Profesionales</button></td>
                        </tr>
                        <tr style="height: 25px;">
                        </tr>
                        </table>
                        <div id="myDIV">
                        <table width="200" border="0"  cellspacing="0" bordercolor="#EEEBFC" id ="grad">
                        <tr >
                            <td width="200" height="20" class="textocom">
                                <div align="center" class="panelSubMenu">
                                    Sistema de Graduados
                                </div>
                            </td>
                        </tr>
                        <tr>
                        <%
                            if (error.equals("OK")) {
                                for (int j = 0; j <= i; j++) {
                                    StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                    k = 0;
                                    while (st.hasMoreTokens()) {
                                        texto[k] = st.nextToken();
                                        k = k + 1;
                                    }
                                    if (texto[0].equals("0")) {
                        %>                            
                        <tr>

                            <td width="200" height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM"  >
                                <div align="left">
                                    <a onclick="<%=texto[3]%>" class="menuprueba">
                                        <font id="f<%=conmenu%>" color="#000000"><%=texto[2]%> </font></a></div>
                            </td>
                        </tr>
                        <%
                                        conmenu = conmenu + 1;
                                    }
                                }
                            }
                        %>
                        <tr>

                            <td width="200" height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM"  >
                                <br> <font size="1">* Bolsa de empleo autorizada y regulada por el Ministerio de Trabajo mediante resolución No. 478 de 2016. <br><br>
                                                    -------------------------------------------------------<br>
                                                    Contacto: Oficina de Graduados<br>
                                                    Mail: graduados@escuelaing.edu.co<br>
                                                    Teléfono: 6683600 ext. 120<br><br></font> &nbsp;
                            </td>
                        </tr>
                    </table>
                    </div>
                    <div id="myDIV2">
                    <table width="200" border="0"  cellspacing="0" bordercolor="#EEEBFC" id="prac">
                        <tr>
                           <td width="200" height="20" class="textocom">
                                <div align="center" class="panelSubMenu">
                                    Sistema de Prácticas
                                </div>
                            </td>
                        </tr>
                         <%
                        conmenu=0;
                      if(error.equals("OK"))
                      {
                        if(periodo=="activarPrac"){
                        for (int j=0; j<=i; j++)
                        {
                            StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                            k=0;
                            while (st.hasMoreTokens())
                            {
                                texto[k]=st.nextToken();
                                k=k+1;
                            }
                            if(texto[0].equals("2")){
                        %>
                                        <tr>

                                           <td width="200" height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM" >
                                                <div align="left">
                                                        <a onclick="<%=texto[3]%>" class="menuprueba">
                                                       <font id="f<%=conmenu%>" color="#000000"><%=texto[2]%> </font></a></div>
                                            </td>
                                        </tr>
                                        
                        <%
                                        conmenu = conmenu+1;
                             }
                           }
                        %>
                        <tr>

                            <td width="200" height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM"  >
                                <p style="text-align: justify;"><font size="1">
                                        <!--
                                                 Recuerde que para el proceso de prácticas profesionales del periodo 2018-2, 
                                                 los estudiantes seleccionados pueden iniciar su práctica desde el <u><b>1 de junio de 2018 </b></u>
                                                 y finalizar máximo el <u><b>31 de diciembre de 2018</b></u>, la práctica profesional debe tener una 
                                                 duración entre (4) cuatro y (6) seis meses de acuerdo a sus requerimientos entre las 
                                                 fechas anteriormente descritas.
                                        -->
                                                 <br><br>-------------------------------------------------------<br>
                                                    Contacto: Oficina de Relaciones Universidad Empresa<br>
                                                    Mail: practicas@escuelaing.edu.co<br>
                                                    Teléfono: 6683600 Ext 294 -312<br><br>
                                                 </p> &nbsp;
                            </td>
                        </tr>
                        <%
                          }else{%>
                          
                        <tr>

                                           <td width="200"  height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM" >
                                                <div style="font-size: 12px; padding: 4px 10px; text-align: justify; color: #787878;">
                                                  <p style="text-align: justify;"><font size="1">
                                                    El proceso de prácticas para el periodo académico 2018-2 ha finalizado. Para el periodo académico 2019-1 el proceso iniciará el 27 de agosto de 2018
                                                    
                                                    <!--Únicamente es posible publicar ofertas de práctica entre las fechas <%=fechasemp[0].get("fecha")%> y <%=fechasemp[1].get("fecha")%>-->
                                                    
                                                    <br><br>-------------------------------------------------------<br>
                                                    Contacto: Oficina de Relaciones Universidad Empresa<br>
                                                    Mail: practicas@escuelaing.edu.co<br>
                                                    Teléfono: 6683600 Ext 294 -312<br><br>
                                                 </p>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>

                                            <td width="200"  height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM" class="menuprueba" >
                                                <div align="left">
                                                        <a onclick="verconsultaroferprac();">
                                                       <font id="f80" color="#000000">Consultar Ofertas de Práctica</font></a>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>

                                            <td width="200"  height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM" class="menuprueba" >
                                                <div align="left">
                                                        <a onclick="cerrarsesionEmp();">
                                                       <font id="f80" color="#000000">Salir </font></a></div>
                                            </td>
                                        </tr>
                                        
                                        <%}
                        }
                        %> 
                       
                    </table>    
                    </div> 
                </td>
                <td align="center" style="box-shadow: -5px 5px 5px 5px rgba(0,0,0,0.1);">
                    <table width="440" frame="lhs" border ="0">
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom"><br>
                                
                                <div align="left" id="cambiocontraseñaemp" style="display: none" valign="middle">
                                    <table  width="440"  cellspacing="1" >

                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="left">
                                                <a class="textocom3">Cambio de Contraseña</a>
                                                
                                            </td>

                                        </tr>
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Contraseña actual:
                                            </td>
                                            <td>
                                                <input type="password" class="inputmediano" name="pswantiguo" id="pswantiguo" type="text" size="20" maxlength="25">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Nueva Contraseña:
                                            </td>
                                            <td>
                                                <input type="password"  class="inputmediano" name="pswnuevo" id="pswnuevo" type="text" size="20" maxlength="25">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Confirme Nueva Contraseña:
                                            </td>
                                            <td>
                                                <input type="password"  class="inputmediano" name="pswnuevo2" id="pswnuevo2" type="text" size="20" maxlength="25">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center">
                                                <input class="button_azul1" type="submit" value="Cambiar contraseña" name="cambiarcontrasena" onclick= "cambiarcontrasenaemp('<%=usuario%>');"/>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div align="left" id="consultoferemp" style="display: none">
                                   

                                </div>

                                <div align="left" id="botonconsultaoferemp" style="display: none">
                                    <table  width="480"  cellspacing="0">
                                        <tr>
                                            <td colspan="3" align="left">
                                                     <a class="textocom3">Consultar vacantes para Graduados</a>
                                            </td>
                                            
                                        </tr>
                                        <tr>
                                            <td colspan="3">&nbsp;</td>
                                        </tr>
                                        
                                        <tr>
                                            <td colspan="3"><p>Por favor seleccione el tipo vacante que desea consultar. </p></td>
                                        <p>
                                           
                                            </tr>
                                        <tr>
                                            <td>
                                                <input class="button_azul_consulta"type="submit" value="Todas las vacantes" name="consultar" onclick= "ConsultarOferemp('<%=usuario%>', 'Todas las ofertas');"/>
                                            </td>
                                            <td>
                                                <input class="button_azul_consulta" type="submit" value="Vacantes vigentes" name="consultar" onclick= "ConsultarOferemp('<%=usuario%>', 'Ofertas vigentes');"/>
                                            </td>
                                            <td>
                                                <input  class="button_azul_consulta" type="submit" value="Vacantes caducadas" name="consultar" onclick= "ConsultarOferemp('<%=usuario%>', 'Ofertas caducadas');"/>
                                            </td>
                                        </tr>
                                    </table>
                                    <br>
                                </div>
                                <div align="left" id="botonconsultaoferpracemp" style="display: none">
                                    <table  width="480"  cellspacing="0">
                                        <tr>
                                            <td colspan="3" align="left">
                                                 <a class="textocom3">Consultar ofertas de Práctica Profesional</a>
                                            </td>
                                            
                                        </tr>
                                    <tr>
                                            <td colspan="3">&nbsp;</td>
                                        </tr>
                                        
                                        <tr>
                                            <td colspan="3"><p>Por favor seleccione el tipo ofertas que desea consultar. </p></td>
                                        <p>
                                           
                                            </tr>
                                        <tr>
                                            <td>
                                                <input class="button_azul_consulta"type="submit" value="Todas las ofertas" name="consultar" onclick= "ConsultarOferpracemp('<%=usuario%>', 'Todas las ofertas');"/>
                                            </td>
                                            <td>
                                                <input class="button_azul_consulta" type="submit" value="Ofertas vigentes" name="consultar" onclick= "ConsultarOferpracemp('<%=usuario%>', 'Ofertas vigentes');"/>
                                            </td>
                                            <td>
                                                <input  class="button_azul_consulta" type="submit" value="Ofertas caducadas" name="consultar" onclick= "ConsultarOferpracemp('<%=usuario%>', 'Ofertas caducadas');"/>
                                            </td>
                                        </tr>
                                    </table>
                                    <br>
                                </div>
                                <div align="left" id="tablaconsultaoferemp" style="display: none">

                                    <table  width="80%" border="1" class="tabla" id="tablaoferemp" align="center" >
                                        <thead>
                                            <tr>
                                                <th width="25%"><div align="center"><strong>Cargo</strong></div></th>
                                                <th width="25%"><div align="center"><strong>Fecha Venc.</strong></div></th>
                                                <th width="25%"><div align="center"><strong>Ver Postulantes</strong></div></th>

                                            </tr>
                                        </thead>
                                        <tbody id="cuerpotablaoferemp">
                                        </tbody>
                                    </table>
                                </div>
                                <div align="left" id="tablaconsultaoferpracemp" style="display: none">

                                    <table  width="80%" border="1" class="tabla" id="tablaoferpracemp" align="center" >
                                        <thead>
                                            <tr>
                                                <th width="25%"><div align="center"><strong>Cargo</strong></div></th>
                                                <th width="25%"><div align="center"><strong>Fecha Venc.</strong></div></th>
                                                <th width="25%"><div align="center"><strong>Ver Postulantes</strong></div></th>

                                            </tr>
                                        </thead>
                                        <tbody id="cuerpotablaoferpracemp">
                                        </tbody>
                                    </table>
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
                    <script>
                        
                        function myFunctionIni() {        
                              var x = document.getElementById("myDIV");
                              var y = document.getElementById("myDIV2");
                                  x.style.display = "none";
                                  y.style.display = "none";    
                          }
                        
                          function myFunction() {
                              var x = document.getElementById("myDIV");
                              var y = document.getElementById("myDIV2");
                              if (x.style.display === "none") {
                                  x.style.display = "block";
                                  y.style.display = "none";
                              } else {
                                  x.style.display = "none";
                                  y.style.display = "none";
                              }
                              
                          }
                          
                          function myFunction2() {
                              var y = document.getElementById("myDIV2");
                              var x = document.getElementById("myDIV");
                              if (y.style.display === "none") {
                                  y.style.display = "block";
                                  x.style.display = "none";
                              } else {
                                  y.style.display = "none";
                                  x.style.display = "none";
                              }                              
                          }
                    </script>
    </body>
</html>

