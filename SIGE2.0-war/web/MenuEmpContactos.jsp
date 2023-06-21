<%-- 
    Document   : MenuEmpContactos
    Created on : 22/05/2013, 10:53:38 AM
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
            HashMap infCont;
            //usuario=nit
            login.SessionEmpRemote empresa = (login.SessionEmpRemote) session.getAttribute("usuario");
            
            //Verificamos que la sesión esté activa
            if (empresa == null) {
                %><script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loingempresa';
                  </script><%
                return;
            }
            
            usuario = empresa.getUser();
            Contacto = empresa.getUserCont();

            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar(Contacto);
            infCont = emp.infoContactoemp(Contacto, usuario);
            session.setAttribute("emp", emp);
            
            String error = new String();
            
            //Define las fechas definidas por la UGE y comprueba si la fecha actual se encuentra dentro de esta.
            Calendar hoy = Calendar.getInstance();
            hoy.getTime();
            
            HashMap[] fechasemp = emp.getFechasPracticasEmp();
            
            int year_in = Integer.parseInt((String) fechasemp[0].get("year"));
            int year_out = Integer.parseInt((String) fechasemp[1].get("year"));
            int mes_in = Integer.parseInt((String) fechasemp[0].get("mes"));
            int mes_out = Integer.parseInt((String) fechasemp[1].get("mes"));
            int dia_in = Integer.parseInt((String) fechasemp[0].get("dia"));
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
        <title>SIEMPREG - Menú Principal</title>
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
    <body background="imagenes/fondoblanco.gif">
        <jsp:include page="header">
            <jsp:param name="type" value="emp" />
        </jsp:include>
        <table width="640" align="center" class="curvas loginPanel" cellspacing="10">
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
                    <%if (infCont.get("sistema_contacto").equals("grad") || infCont.get("sistema_contacto").equals("prac-grad")) {%>
                    <tr>
                        <td width="200" height="20" class="textocom">
                            <div align="center" class="panelSubMenu">
                                Sistema de Graduados
                            </div>
                        </td>
                    </tr>
                    <%
                        if (error.equals("OK")) {
                            for (int j = 0; j < i; j++) {
                                StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                k = 0;
                                while (st.hasMoreTokens()) {
                                    texto[k] = st.nextToken();
                                    k = k + 1;
                                }
                                if (texto[0].equals("0")) {
                    %>
                    <tr>

                        <td class="menuprueba" width="200" height="20" bgcolor="FFFFFF" >
                            <div align="left">
                                <a onclick="<%=texto[3]%>" >
                                    <font id="f<%=conmenu%>" color="#000000"><%=texto[2]%> </font></a></div>
                        </td>
                    </tr>
                    <%
                                    conmenu = conmenu + 1;
                                }
                            }
                        }
                    %>
                    <%}%> 
                    <%if (infCont.get("sistema_contacto").equals("prac") || infCont.get("sistema_contacto").equals("prac-grad")) {%>
                    <tr>
                        <td width="200" height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM"  >
                            &nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td width="200" height="20" class="textocom">
                            <div align="center" class="panelSubMenu">
                                Sistema de Prácticas
                            </div>
                        </td>
                    </tr>
                    <%
                        conmenu = 0;
                        if (error.equals("OK")) {
                            if (periodo == "activarPrac") {
                                for (int j = 0; j < i; j++) {
                                    StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                    k = 0;
                                    while (st.hasMoreTokens()) {
                                        texto[k] = st.nextToken();
                                        k = k + 1;
                                    }
                                    if (texto[0].equals("2")) {
                    %>
                    <tr>

                        <td width="200" height="20" bgcolor="FFFFFF" class="menuprueba" >
                            <div align="left">
                                <a onclick="<%=texto[3]%>">
                                    <font id="f<%=conmenu%>" color="#000000"><%=texto[2]%> </font></a></div>
                        </td>
                    </tr>
                    <%
                                conmenu = conmenu + 1;
                            }
                        }
                    } else {%>
                    <tr>

                        <td width="200"  height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM" >
                            <div align="left">
                                <a>
                                    Usted podrá publicar ofertas de prácticas empresariales desde <%=fechasemp[0].get("fecha")%> hasta <%=fechasemp[1].get("fecha")%> 
                                </a></div>
                        </td>
                    </tr>
                    <tr>

                        <td width="200"  height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM" class="menuprueba" >
                            <div align="left">
                                <a onclick="verconsultaroferprac();">
                                    <font id="f80" color="#000000">Consultar Ofertas de Práctica </font></a></div>
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
                        }
                    %> 
                    </table>
                </td>
                <td style="box-shadow: -5px 5px 5px 5px rgba(0,0,0,0.1);">
                    <div align="left" id="cambiocontraseñaemp" style="display: none">

                    </div>
                    <div align="left" id="consultoferemp" style="display: none">

                    </div>
                    <div align="left" id="botonconsultaoferemp" style="display: none">
                        <table width="440" frame="lhs">
                            <tr>
                                <td colspan="3" align="left">
                                     <a style="font-family: 'Trebuchet MS', Arial, Helvetica, sans-serif; font-size: 20px; color: #000046;">Consultar vacantes</a>
                                </td>         
                            </tr>
                            <tr>
                                <td colspan="3">&nbsp;</td>
                            </tr>
                            <tr>
                                <td colspan="3"><p>Por favor seleccione el tipo vacante que desea consultar.</td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="submit" value="Todas las vacantes" name="consultar" onclick="ConsultarOferempCont('<%=Contacto%>','<%=usuario%>', 'Todas las ofertas');"/>
                                </td>
                                <td>
                                    <input type="submit" value="Vacantes vigentes" name="consultar" onclick="ConsultarOferempCont('<%=Contacto%>','<%=usuario%>', 'Ofertas vigentes');"/>
                                </td>
                                <td>
                                    <input type="submit" value="Vacantes caducadas" name="consultar" onclick="ConsultarOferempCont('<%=Contacto%>','<%=usuario%>', 'Ofertas caducadas');"/>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div align="left" id="botonconsultaoferpracemp" style="display: none">
                        <table  width="480"  cellspacing="0">
                            <td>
                                    <input type="submit" value="Todas las ofertas" name="consultar" onclick="ConsultarOferpracempCont('<%=Contacto%>','<%=usuario%>', 'Todas las ofertas');"/>
                                </td>
                                <td>
                                    <input type="submit" value="Ofertas vigentes" name="consultar" onclick="ConsultarOferpracempCont('<%=Contacto%>','<%=usuario%>', 'Ofertas vigentes');"/>
                                </td>
                                <td>
                                    <input type="submit" value="Ofertas caducadas" name="consultar" onclick="ConsultarOferpracempCont('<%=Contacto%>','<%=usuario%>', 'Ofertas caducadas');"/>
                                </td>

                        </table>
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
            <tr>
                <td colspan="2" align="center">
                    <jsp:include page="footer">
                        <jsp:param name="type" value="general" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
</html>