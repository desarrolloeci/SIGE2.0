<%-- 
    Document   : InformesMonGrad
    Created on : 22/01/2014, 04:56:20 PM
    Author     : Luis Salas
--%>

<%@page import="BDsige.EmpresaRemote"%>
<%@page import="BDsige.EmpleadoRemote"%>
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
            response.setHeader("Cache-Control","no-cache");

            documentos.ruta ruta = new documentos.ruta();
            String rol = new String ();
            String usuario = new String ();

            String error = new String();
            login.SessionUsrRemote admin =(login.SessionUsrRemote)session.getAttribute("usuario");
      
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
                FileReader ra = new FileReader(ruta.valruta() + "informesadminSIGE.txt");
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
            } catch(java.io.FileNotFoundException fnfex) {
                error = "Error: " + fnfex;
            } catch(java.io.IOException ioex) {
                error = "Error: " + ioex;
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Reportes Monitores</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunAdminGrad.js" ></script>
        <link href="CSS/calendario.css" type="text/css" rel="stylesheet"> 
        <script src="jscript/calendar.js" type="text/javascript"></script> 
        <script src="jscript/calendar-es.js" type="text/javascript"></script> 
        <script src="jscript/calendar-setup.js" type="text/javascript"></script> 
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
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="admin" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" cellspacing="5">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        Opciones Empresa
                    </div>
                </td>
            </tr>
            <tr class="textocom" style="height: 0px;">
                <td width="250"><!--<div align="center" class="menuprueba2"><font color="#FFFFFF"><strong>Opciones</strong></font></div>--></td>
                <td width="500" valign="top"><!--<div align="center" class="menuprueba2"><font color="#990000"><strong></strong></font></div>--></td>
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
                                texto[k] = st.nextToken();
                                k=k+1;
                            }
                    %>
                    <%


                            if(texto[1].equals("4")){
                        %>
                               <table width="100%"   cellspacing="0" >
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
                             <div align="left" id="tituloReporteGrad" style="display: none">
                                <table    cellspacing="0">
                                     <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                     <tr>
                                            <td colspan="2"><b>Reporte por Graduados___________________________________</b></td>
                                     </tr>
                                     <tr>
                                        <td>(En fechas indique el periodo de tiempo que contenga las fechas de grado que desea abarcar en el informe. Si no las define obtendrá un informe histórico. )</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                    </table>
                              </div>
                            <div align="left" id="tituloReporteDisG" style="display: none">
                                <table    cellspacing="0">
                                     <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                     <tr>
                                            <td colspan="2"><b>Reporte por Distinciones___________________________________</b></td>

                                     </tr>
                                     <tr>
                                        <td>(En fechas indique el periodo de tiempo que contenga las fechas en las que se otorgaron las distinciones que desea abarcar en el informe. Si no lo define obtendrá un informe histórico.)</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                    </table>
                              </div>
                                <div align="left" id="tituloReporteAfiG" style="display: none">
                                <table    cellspacing="0">
                                     <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                     <tr>
                                            <td colspan="2"><b>Reporte por Afiliaciones___________________________________</b></td>

                                     </tr>
                                     <tr>
                                        <td>(En fechas indique el periodo de tiempo que contenga las fechas en las que se realizaron las afiliaciones que desea abarcar en el informe. Si no lo define obtendrá un informe histórico.)</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                    </table>
                              </div>
                                <div align="left" id="tituloReporteIdioG" style="display: none">
                                <table    cellspacing="0">
                                     <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                     <tr>
                                            <td colspan="2"><b>Reporte por Idiomas___________________________________</b></td>

                                     </tr>
                                     <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                    </table>
                              </div>
                                <div align="left" id="tituloReporteEstG" style="display: none">
                                <table    cellspacing="0">
                                     <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                     <tr>
                                            <td colspan="2"><b>Reporte por Estudios___________________________________</b></td>

                                     </tr>
                                     <tr>
                                        <td>(En fechas indique el periodo de tiempo que contenga las fechas en las que recibieron el grado de los estudios que desea abarcar en el informe. Si no lo define obtendrá un informe histórico.)</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                    </table>
                              </div>
                                <div align="left" id="tituloReporteExpG" style="display: none">
                                <table    cellspacing="0">
                                     <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                     <tr>
                                        <td colspan="2"><b>Reporte por Experiencias Laborales___________________________________</b></td>
                                     </tr>
                                     <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                    </table>
                              </div>
                                <div align="left" id="tituloReporteEmpG" style="display: none">
                                <table    cellspacing="0">
                                     
                                    </table>
                              </div>
                                <div align="left" id="tituloReporteOferG" style="display: none">
                                <table    cellspacing="0">
                                    
                                    </table>
                              </div>
                                <div align="left" id="tituloReporteApliG" style="display: none">
                                <table    cellspacing="0">
                                     
                                    </table>
                              </div>
                             
                              <div align="left" id="FechasReporteG" style="display: none">
                                   
                                <table    cellspacing="0">
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                  <tr>
                                      <td width="50%">
                                             Fecha inicial(dd/mm/yyyy):
                                      </td>
                                      <td align="left">
                                          
                                          <%--<input  class="inputcorto" name="fechainG" id="fechainG" type="text" size="20">(dd/mm/aaaa)<br>--%>
                                          <input class="inputcorto" type="text" name="fechainG" id="fechainG"  /> 

                                            <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"> 
                                            <!-- script que define y configura el calendario--> 
                                            <script type="text/javascript"> 
                                            Calendar.setup({ 
                                            inputField : "fechainG", // id del campo de texto 
                                            ifFormat : "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                            button : "lanzador" // el id del botón que lanzará el calendario 
                                            }); 
                                            </script>
                                      </td>
                                   </tr>
                                    <tr>
                                      <td width="50%">
                                             Fecha Final(dd/mm/yyyy):
                                      </td>
                                      <td align="left">
                                          <input  class="inputcorto" name="fechaoutG" id="fechaoutG" type="text" >
                                           <img src="imagenes/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador2"> 
                                            <!-- script que define y configura el calendario--> 
                                            <script type="text/javascript"> 
                                            Calendar.setup({ 
                                            inputField : "fechaoutG", // id del campo de texto 
                                            ifFormat : "%d/%m/%Y", // formato de la fecha que se escriba en el campo de texto 
                                            button : "lanzador2" // el id del botón que lanzará el calendario 
                                            }); 
                                            </script>
                                      </td>
                                   </tr>
                                </table>
                             </div>
                                <div align="left" id="ProgramaReporteG" style="display: none">
                                <table    cellspacing="0">
                                     <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                     </tr>
                                     <tr>
                                        <td colspan="2">Por favor seleccione el programa académico</td>
                                     </tr>
                                     <tr>
                                          <td colspan="2">
                                              <select class="inputxlargo" name="programagradAdmin" id="programagradAdmin">
                                                  <option value="TODOS">TODOS</option>
                                                  <%
                                                     for(int cont = 0; cont < prg; cont++) {
                                                         programa = programas[cont];
                                                  %>
                                                  <option value="<%=programa.get("id_prog")%>"><%=programa.get("nom_prog")%></option>
                                                  <%
                                                     }
                                                  %>
                                             </select>
                                          </td>
                                     </tr>
                                    </table>
                              </div>
                             <div align="left" id="checkReporteGrad" style=" display: none; height: 300px;width: 99%; overflow-y: auto;" >                                  
                                Seleccione la información que desea en el reporte.
                                   <form name="fromReporteGrad" >
                                       <table  width="480"  cellspacing="0">
                                            <tr>
                                                <td>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="documento" >Documento<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="est_civil" >Estado civil<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="fecha_nacimiento" >Fecha de nacimiento<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="tel_residencia" >Teléfono de residencia<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="dir_residencia" >Dirección de residencia<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="email" >email<br>
                                               </td>
                                                <td>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="email2" >email2<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="cel" >Celular<br>                                                    
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="pais_residencia" >País residencia<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="ciudad_residencia" >Ciudad residencia<br>
                                                    <%--<input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="programa" >Programa académico<br>--%>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                              </div>
                              <div align="left" id="checkReporteDisG" style=" display: none; height: 300px;width: 99%; overflow-y: auto;" >
                                Seleccione la información que desea en el reporte.
                                   <form name="fromReporteDisG" >
                                       <table  width="480"  cellspacing="0">
                                            <tr>
                                                <td>
                                                    
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteDisG" value="nom_distincion" >Nombre de la distinción<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteDisG" value="lugar_distincion" >Lugar de la distinción<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteDisG" value="tipo_distincion" >Tipo de distinción<br>
                                               </td>
                                                <td>
                                                    
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteDisG" value="ambito_distincion" >Ambito de la distinción<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteDisG" value="fecha_distincion" >Fecha de la distinción<br>
                                                    <%--<input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="programa" >Programa académico<br>--%>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                              </div>
                               <div align="left" id="checkReporteAfiG" style=" display: none; height: 300px;width: 99%; overflow-y: auto;" >
                                Seleccione la información que desea en el reporte.
                                   <form name="fromReporteAfiG" >
                                       <table  width="480"  cellspacing="0">
                                            <tr>
                                                <td>

                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteAfiG" value="nom_aso" >Nombre de la asociación <br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteAfiG" value="tipo_aso" >Tipo de afiliación<br>
                                               </td>
                                                <td>

                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteAfiG" value="estado_afi" >Estado de la afiliación<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteAfiG" value="fecha_in" >Fecha de afiliación <br>
                                                    <%--<input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="programa" >Programa académico<br>--%>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                              </div>
                              <div align="left" id="checkReporteIdioG" style=" display: none; height: 300px;width: 99%; overflow-y: auto;" >
                                Seleccione la información que desea en el reporte.
                                   <form name="fromReporteIdioG" >
                                       <table  width="480"  cellspacing="0">
                                            <tr>
                                                <td>

                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteIdioG" value="nom_idioma" >Nombre del idioma <br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteIdioG" value="niv_lectura" >Nivel de lectura<br>
                                               </td>
                                                <td>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteIdioG" value="niv_escritura" >Nivel de habla<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteIdioG" value="niv_habla" >Nivel de escritura<br>
                                                    <%--<input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="programa" >Programa académico<br>--%>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                              </div>
                              <div align="left" id="checkReporteEstG" style=" display: none; height: 300px;width: 99%; overflow-y: auto;" >
                                Seleccione la información que desea en el reporte.
                                   <form name="fromReporteEstG" >
                                       <table  width="480"  cellspacing="0">
                                            <tr>
                                                <td>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteEstG" value="nom_estudio" >Nombre del estudio <br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteEstG" value="titulo" >Título obtenido  <br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteEstG" value="nivel_formacion" >Nivel de formación<br>
                                                     <input class="inputsupercorto"  type="checkbox" name="BoxReporteEstG" value="sector" >Sector del estudio<br>
                                               </td>
                                                <td>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteEstG" value="nom_inst" >Nombre de la institución<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteEstG" value="pais_inst" >País de la institución<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteEstG" value="ciudad_inst" >Ciudad de la institución<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteEstG" value="fecha_grado" >Fecha en la que obtuvo el titulo  <br>
                                                    <%--<input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="programa" >Programa académico<br>--%>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                              </div>
                                <div align="left" id="checkReporteExpG" style=" display: none; height: 300px;width: 99%; overflow-y: auto;" >
                                Seleccione la información que desea en el reporte.
                                   <form name="fromReporteExpG" >
                                       <table  width="480"  cellspacing="0">
                                            <tr>
                                                <td>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteExpG" value="nom_empresa" >Nombre de la empresa <br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteExpG" value="cargo" >Cargo <br>                                                    
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteExpG" value="salario" >Salario<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteExpG" value="estado_cargo" >Estado del cargo<br>
                                                   
                                               </td>
                                                <td>                                                 
                                                    
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteExpG" value="fecha_in_cargo" >Fecha de ingreso<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteExpG" value="fecha_out_cargo" >Fecha de salida<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteExpG" value="tipo_contrato" >Tipo de contrato<br>
                                                    <input class="inputsupercorto"  type="checkbox" name="BoxReporteExpG" value="horario" >Horario<br>
                                                    <%--<input class="inputsupercorto"  type="checkbox" name="BoxReporteGrad" value="programa" >Programa académico<br>--%>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                              </div>
                              <div align="left" id="checkReporteEmpG" style=" display: none; height: 300px;width: 99%; overflow-y: auto;" >
                                Seleccione la información que desea en el reporte.
                                   <form name="fromReporteEmpG" >
                                       <table  width="480"  cellspacing="0">
                                            
                                        </table>
                                    </form>
                              </div>
                              <div align="left" id="checkReporteOferG" style=" display: none; height: 300px;width: 99%; overflow-y: auto;" >
                                Seleccione la información que desea en el reporte.
                                   <form name="fromReporteOferG" >
                                       <table  width="480"  cellspacing="0">
                                            
                                        </table>
                                    </form>
                              </div>                              
                               <div align="left" id="botonReporteGrad" style="display: none">
                                <table  width="480"  cellspacing="0">
                                    <tr>
                                        <td>
                                            <br><input type="submit" value="Generar Reporte" name="Generar Reporte" onclick= "generarReporteGradMon();"/><br>
                                       </td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>
                                   
                              </div>
                                             <div align="left" id="botonReporteDisG" style="display: none">
                                <table  width="480"  cellspacing="0">
                                    <tr>
                                        <td>
                                            <br><input type="submit" value="Generar Reporte" name="Generar Reporte" onclick= "generarReporteDisG();"/><br>
                                       </td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>

                              </div>
                                             <div align="left" id="botonReporteAfiG" style="display: none">
                                <table  width="480"  cellspacing="0">
                                    <tr>
                                        <td>
                                            <br><input type="submit" value="Generar Reporte" name="Generar Reporte" onclick= "generarReporteAfiG();"/><br>
                                       </td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>

                              </div>
                                             <div align="left" id="botonReporteIdioG" style="display: none">
                                <table  width="480"  cellspacing="0">
                                    <tr>
                                        <td>
                                            <br><input type="submit" value="Generar Reporte" name="Generar Reporte" onclick= "generarReporteIdioG();"/><br>
                                       </td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>
                              </div>
                                             <div align="left" id="botonReporteEstG" style="display: none">
                                <table  width="480"  cellspacing="0">
                                    <tr>
                                        <td>
                                            <br><input type="submit" value="Generar Reporte" name="Generar Reporte" onclick= "generarReporteEstG();"/><br>
                                       </td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>

                              </div>
                              <div align="left" id="botonReporteExpG" style="display: none">
                                <table  width="480"  cellspacing="0">
                                    <tr>
                                        <td>
                                            <br><input type="submit" value="Generar Reporte" name="Generar Reporte" onclick= "generarReporteExpG();"/><br>
                                       </td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>
                              </div>
                              <div align="left" id="botonReporteEmpG" style="display: none">
                                <table  width="480"  cellspacing="0">
                                    <tr>
                                        <td>
                                            
                                       </td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>
                              </div>
                              <div align="left" id="botonReporteOferG" style="display: none">
                                <table  width="480"  cellspacing="0">
                                    <tr>
                                        <td>
                                          
                                       </td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>
                              </div>
                              <div align="left" id="botonReporteApliG" style="display: none">
                                <table  width="480"  cellspacing="0">
                                    <tr>
                                        <td>
                                            
                                       </td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>
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