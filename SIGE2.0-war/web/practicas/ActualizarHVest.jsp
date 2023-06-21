<%-- 
    Document   : ActualizarHVest
    Created on : 10/12/2012, 02:23:12 PM
    Author     : Luis Alberto Salas
--%>


<%@page import="clientecampus.ConsultaPersonas"%>
<%@page import="BDsige.EstudiantesRemote"%>
<%@page import="BDsige.graduadoRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*, javax.rmi.PortableRemoteObject"%>

<html>
    <head>
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
        <%
            response.setHeader("Cache-Control","no-cache");
            documentos.ruta ruta = new documentos.ruta();

            String idest = new String ();
            String estSol= new String();
            String mensaje = new String();
            
            String bckColor = "#CCFFCC";
            String brdColor = "#009900";
            String txtColor = "#000000";
            
            //tel2, email2, cel, perfil, referencias, expectativas, estado
            String usuario = new String ();
            
            login.SessionEstRemote estudiante = (login.SessionEstRemote) session.getAttribute("usuario");
            
            if (estudiante == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'loginestMov';
                    </script>
                <%
                return;
            }
            
            usuario = estudiante.getUser();
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp", emp);
            
            /**
            HashMap id_est = emp.carnetEstPrac(usuario);
            idest = (String) id_est.get("id_est");
            * */
            
            idest = emp.getEmplId(usuario).get("PEOPLE_ID").toString();
            //Se consulta la solicitud de practicas
            HashMap solicitud_prac = emp.veriSoliPrac(emp.getEmplId(usuario).get("PEOPLE_ID").toString());

            //Se consulta la persona en campus
            
            emp.getPersona(emp.getEmplId(usuario).get("PEOPLE_ID").toString(), usuario,"ESTUDIANTE", ConsultaPersonas.consultaPersona(emp.getEmplId(usuario).get("PEOPLE_ID").toString(),"ESTUDIANTE"));
            

            session.setAttribute("empl_id", emp.getEmplId(usuario).get("PEOPLE_ID"));

            
            if (solicitud_prac.isEmpty()) {
                %>
                </head>
                <body>
                    <jsp:include page="encabezado_prac"></jsp:include>
                    <div align="center">
                        <fieldset class="field_set">
                            <table>
                                <tr>
                                    <td class="textocom2" align="center" style="padding-top: 32px; font-weight: bold;">
                                        No cumple con los requisitos.
                                    </td>
                                </tr>
                                <tr>
                                    <td class="textocom" align="left">
                                        Para ingresar al sistema de Prácticas Profesionales usted debe cumplir con los siguientes requisitos:<br>
                                        <blockquote>
                                            - Haber realizado solicitud de practicas desde el Autoservicio.<br>
                                        </blockquote>
                                    </td>
                                </tr>
                                <tr align="center">
                                    <td>
                                        <jsp:include page="footer">
                                            <jsp:param name="type" value="prac" />
                                        </jsp:include>
                                    </td>
                                </tr>
                            </table>
                                
                        </fieldset>
                    </div>
                </body>
                </html>
                <%
                session.invalidate();
                return;
            }
            
            HashMap datos = emp.datosGeneralesEstPrac(idest);
            HashMap datosAC = emp.datosAcademicosEstPrac(idest);
            HashMap programa= emp.programaacademicoest(idest);
            HashMap datosprac = emp.datosprac(idest);
            HashMap estado = emp.estadoAplicanteprac(idest);
            
            mensaje = request.getParameter("mensaje");
            
            if (mensaje == null) {
                mensaje = "";
            } else if (mensaje.equals("0")) {
                mensaje = "Fallo inesperado";
                bckColor = "#FF9C9C";
                brdColor = "#990000";
                txtColor = "#A70000";
            } else if (mensaje.equals("1")) {
                mensaje = "Información general actualizada";
            } else {
                mensaje = "";
            }
            estSol = (String) estado.get("estado");
            if (estSol == null) estSol = "init";
            estSol = estSol.trim();
            
            String error = new String();
            HashMap[] paises=emp.getpaises();
            HashMap pais;
            int pa = paises.length;
            HashMap[] sectores=emp.getsectoresest();
            HashMap sector;
            int se = sectores.length;
            HashMap[] tipos = emp.getTiposEstudios();
            
            //String paramtext = new String();
            //String titulo = new String("Servicio a Administradores");
            String arreglo[]=new String[50];
            String texto[]=new String[20];
            String noticias[]=new String[200];
            int i=0, not=0;
            int conmenu = 0;
            int n = 0;
            int k=0;
            
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prácticas Profesionales - Actualizar su hoja de vida</title>       
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunEstPrac.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>
        <script type="text/javascript">
            iniciarvariablesPrac(<%=idest%>);
        </script>
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
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" cellspacing="10">
            <tr bgcolor="#FFFFFF" class="textocom">
                <td width="30%" valign="top" style="padding: 15px 7px 0px 0px;">
                    <table width="100%"   cellspacing="0">
                        <tr>
                            <td align="center" style="padding-bottom: 5px;">
                                <font color="#990000"><strong>Opciones</strong></font>
                            </td>
                        </tr>
                        <%
                        if(error.equals("OK")) {
                            for (int j=0; j<i; j++) {
                                StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                k=0;
                                while (st.hasMoreTokens()) {
                                    texto[k]=st.nextToken();
                                    k=k+1;
                                }

                                if(texto[1].equals("0")) {
                        %>
                        <tr>
                            <td height="20" class="menuprueba" align="left" onclick="<%=texto[5]%>">
                                <font id="f<%=conmenu%>" color="#000000"><%=texto[4]%> </font>
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
                <td width="70%" style="padding-top: 15px;">
                    <table frame="lhs" style="width: 100%;">
                        <tr>
                            <td valign="top" height="500" class="textocom" style="background: #FFFFFF;">
                                       <div align="center" id="ActDatosPrac" style="display:inline">
                                       <form name="fromDatGeneralesPrac" action="" method="POST">
                                          <table width="99%" >
                                            <tr>
                                              <td align="left" width="30%">&nbsp;</td>
                                              <td align="left" width="70%">&nbsp;</td>
                                            </tr>
                                            <tr>
                                              <td  valign="bottom" align="center" colspan="2">
                                                  <a class="textocom3">Información general del estudiante</a></b>
                                              </td>
                                            </tr>
                                            <%
                                                if (mensaje != "") {
                                            %>
                                            <tr style="height: 64px;">
                                                <td colspan="2">
                                                    <div style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 15px; color: <%=txtColor%>; text-align: center; border: 1px solid <%=brdColor%>; background: <%=bckColor%>; padding: 8px 0px 8px 0px;">
                                                        <%=mensaje%>
                                                    </div>
                                                </td>
                                            </tr>
                                            <%
                                                } else {
                                            %>
                                            <tr>
                                              <td align="left" width="30%">&nbsp;</td>
                                              <td align="left" width="70%">&nbsp;</td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                            <tr>
                                              <td align="left" width="30%">Nombre:</td>
                                              <td align="left" width="70%"><%=datos.get("nom_est")%></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Identificacion:</td>
                                              <td align="left" ><%=datos.get("doc_est")%></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Programa: </td>
                                              <td align="left" ><%=programa.get("nom_prog")%></td>
                                            </tr>                                    
                                            <tr>
                                              <td align="left" >Fecha de Nacimiento:</td>
                                              <td align="left" ><%=datos.get("fec_nac")%></td>
                                            </tr>
                                            <!--tr>
                                              <td align="left" >Promedio acumulado:</td>
                                              <td align="left" ><%//=datosAC.get("prom_acum")%></td>
                                            </tr-->
                                            <%--
                                            <tr>
                                              <td align="left" >Promedios semestre anterior:</td>
                                              <td align="left" ><%=datosAC.get("pr_semant")%></td>
                                            </tr>
                                            --%>
                                            <tr>
                                              <td align="left" width="30%">&nbsp;</td>
                                              <td align="left" width="70%">&nbsp;</td>
                                            </tr>
                                            <tr>
                                              <td align="left" colspan="2">&nbsp;</td>
                                            </tr>
                                             <tr>
                                              <td align="center" colspan="2">
                                                <a class="textocom3">Información de Contacto</a></b>
                                              </td>
                                            </tr> 
                                            <tr>
                                              <td align="left" width="30%">&nbsp;</td>
                                              <td align="left" width="70%">&nbsp;</td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Tel. Principal:</td>
                                              <td align="left" ><input class="inputgraduado"  name="tel_campus" id="tel_campus" type="number" size="20" maxlength="20" value="<%=datos.get("tel_corr")%>"></td></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Telefono 2:</td>
                                              <td align="left" ><input class="inputgraduado"  name="tel2prac" id="tel2prac" type="number" size="20" maxlength="20" value="<%=datosprac.get("tel2")%>"></td>
                                            </tr>

                                            <tr>
                                              <td align="left" >Numero de Celular:</td>
                                              <td align="left" ><input class="inputgraduado"  name="celprac" id="celprac" type="number" size="20" maxlength="20" value="<%=datosprac.get("cel")%>" ></td>
                                            </tr>                                           
                                            <tr>
                                              <td align="left" >Email:</td>
                                              <td align="left" ><%=datos.get("emails")%></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Email 2:</td>
                                              <td align="left" ><input class="inputgraduado"  name="email2prac" id="email2prac" type="text" size="20" maxlength="100" value="<%=datosprac.get("email2")%>"></td>
                                            </tr>
                                            <tr>
                                              <td align="left" width="30%">&nbsp;</td>
                                              <td align="left" width="70%">&nbsp;</td>
                                            </tr>
                                            <tr>
                                              <td align="left" width="30%">&nbsp;</td>
                                              <td align="left" width="70%">&nbsp;</td>
                                            </tr>
                                              <tr>
                                              <td align="center" colspan="2">
                                                <a class="textocom3">Información general de la hoja de vida</a></b>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" width="30%">&nbsp;</td>
                                              <td align="left" width="70%">&nbsp;</td>
                                            </tr>
                                            <tr>
                                              <td align="left" colspan="2">Perfil Profesional:</td>
                                            </tr>
                                            <tr>
                                              <td align="center" colspan="2"><textarea name="perfilprac" id="perfilprac" cols="38" maxlength="4500" style="width: 100%;"><%=datosprac.get("perfil")%></textarea></td>
                                            </tr>
                                            <tr>
                                              <td align="left" colspan="2">Referencias:</td>
                                            </tr>
                                            <tr>
                                              <td align="center" colspan="2"><textarea name="refprac" id="refprac" rows="10" cols="38" maxlength="4500" style="width: 100%;"><%=datosprac.get("referencias")%></textarea></td>
                                            </tr>
                                            <tr>
                                              <td align="left" colspan="2">Expectativas:</td>
                                            </tr>
                                            <tr>
                                              <td align="center" colspan="2"> <textarea name="exvprac" id="exvprac" rows="10" cols="38" maxlength="4500" style="width: 100%;"><%=datosprac.get("expectativas")%></textarea></td>
                                            </tr>
                                            <tr>
                                              <td align="left" colspan="2">Línea de profundización o Electivas técnicas ya cursadas:</td>
                                            </tr>
                                            <tr>
                                                <td align="center" colspan="2"> <textarea name="electivasprac" id="electivasprac" rows="10" cols="38" maxlength="4500" style="width: 100%;"><%=datosprac.get("electivas")%></textarea></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >&nbsp;</td>
                                              <td align="left" >&nbsp;</td>
                                            </tr>
                                            <tr>
                                              <td colspan="2">
                                                <div align="center">
                                                  <input class="button_azul_consulta1" type="submit" value="Actualizar" name="ActdatosPrac" onclick="return ActualizarDatPrac();"/>
                                                </div>
                                              </td>
                                            </tr>
                                          </table>
                                            </form>
                                        </div>
                                        <div align="center" id="tablaconsultaEstPrac" style="display: none">
                                            <a class="textocom3">Estudios Registrados</a><br>
                                            <br>
                                           <table  width="98%" border="1" class="tblStyle" id="tablaestudiosPrac" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="35%"><div align="center"><strong>Nombre del Estudio</strong></div></th>
                                                    <th width="35%"><div align="center"><strong>Institución</strong></div></th>
                                                    <th width="24%"><div align="center"><strong>Tipo</strong></div></th>
                                                    <th width="6%"></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoestudiosPrac">
                                            </tbody>
                                        </table>
                                            <%--<input class="inputlargo" type="submit" value="Consultar Todos Los Estudios" name="consultar" onclick= "actualizarTabEstPrac(<%=idest%>);"/>--%>
                                        </div>
                                        <div align="center" id="EstPrac" style="display: none">
                                          <table width="99%" >
                                            <tr >
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            </tr>
                                            <tr >
                                              <td valign="bottom" align="left" colspan="2">
                                                <a class="textocom3">Nuevo Estudio o actividad complementaria</a></b>
                                              </td>
                                            </tr> 
                                            <tr>
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nombre</td>
                                              <td align="left" ><input class="inputgraduado"  name="prog_estprac" id="prog_estprac" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Titulo:</td>
                                              <td align="left">
                                                  <input class="inputgraduado"  name="titulo_prac" id="titulo_prac" type="text" size="20" >
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left">Tipo de estudio:</td>
                                              <td align="left">
                                                  <select class="inputmediano" name="tipo_estudio" id="tipo_estudio">
                                                      <%
                                                           for(HashMap tipo: tipos) {
                                                      %>
                                                        <option value="<%=tipo.get("ID")%>"><%=tipo.get("nom_tipo")%></option>
                                                      <%
                                                           }
                                                      %>
                                                 </select>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Sector:</td>

                                              <td align="left">
                                                  <select class="inputmediano" name="sector_estprac" id="sector_estprac">
                                                      <%
                                                         for(int cont=0;cont<se;cont++)
                                                       {
                                                           sector=sectores[cont];
                                                      %>
                                                        <option value="<%=sector.get("nom_sector")%>" ><%=sector.get("nom_sector")%></option>
                                                      <%}%>
                                                 </select>
                                                  <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nombre de la Institución:</td>
                                              <td align="left" ><input class="inputgraduado"  name="nom_instprac" id="nom_instprac" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left">Pais:</td>
                                              <td align="left">
                                                  <select class="inputmediano" name="pais_estprac" id="pais_estprac">
                                                      <%
                                                         for (int cont = 0; cont < pa; cont++) {
                                                           pais = paises[cont];
                                                      %>
                                                        <option value="<%=pais.get("cod_pai")%>" <%=((String) pais.get("cod_pai")).equals("COL")?"selected":""%>><%=pais.get("nom_pai")%></option>
                                                      <%}%>
                                                 </select>
                                                  <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Ciudad:</td>
                                              <td align="left" ><input class="inputgraduado"  name="ciudad_estprac" id="ciudad_estprac" type="text" size="20"></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Fecha en que lo realizó:</td>
                                              <td align="left" ><input class="inputcorto"  name="fecha_estgrad" id="fecha_estprac" type="text" size="20" >(mm/aaaa)</td>
                                            </tr>
                                            <tr>
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            </tr>
                                            <tr>
                                              <td colspan="2">
                                                <div align="center">
                                                    <input class="button_azul_consulta1" type="submit" value="Registrar nuevo estudio" name="Actestgrad" onclick="RegistrarEstPrac();"/>
                                                </div>
                                              </td>
                                            </tr>
                                          </table>
                                        </div>
                                        <div align="center" id="tablaconsultaDisPrac" style="display: none">
                                            <a class="textocom3">Distinciones Registradas</a><br>
                                            <br>
                                           <table  width="98%" border="1" class="tblStyle" id="tabladistincionesEgre" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="35%"><div align="center"><strong>Nombre</strong></div></th>
                                                    <th width="35%"><div align="center"><strong>Institución</strong></div></th>
                                                    <th width="24%"><div align="center"><strong>Tipo</strong></div></th>
                                                    <th width="6%"></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpodistincionesEgre">
                                            </tbody>
                                        </table>
                                             <%--<input class="inputlargo" type="submit" value="Consultar Todos Las Distinciones" name="consultar" onclick= "actTabDisEgre(<%=idest%>);"/>--%>
                                        </div>
                                        <div align="center" id="DisPrac" style="display: none">
                                          <table width="99%" >
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            <tr >
                                              <td   valign="bottom" align="left" colspan="2">
                                                <a class="textocom3">Nueva Distinción</a></b>
                                              </td>
                                            </tr>
                                            <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            <tr>
                                              <td align="left" >Nombre de la Distinción:</td>
                                              <td align="left" ><input class="inputgraduado"  name="nom_disgrad" id="nom_disgrad" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Institución:</td>
                                              <td align="left">
                                                  <input class="inputgraduado"  name="inst_disgrad" id="inst_disgrad" type="text" size="20" >
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Ámbito:</td>
                                              <td align="left"> <select class="inputgraduado"  name="amb_disgrad" id="amb_disgrad">
                                                    <option value="Empresarial">Empresarial
                                                    <option value="Gremial">Gremial
                                                    <option value="Regional">Regional
                                                    <option value="Nacional">Nacional
                                                    <option value="Internacional">Internacional
                                                    <option value="otro">Otro
                                                 </select>
                                            </td>
                                            </tr>
                                             <tr>
                                              <td align="left" >Tipo:</td>
                                              <td align="left"> <select class="inputgraduado"  name="Tipo_disgrad" id="Tipo_disgrad">
                                                    <option value="Cientifica">Cientifica
                                                    <option value="Profesional">Profesional
                                                    <option value="Academica">Academica
                                                    <option value="Otra">Otra
                                                 </select>
                                            </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Fecha:</td>
                                              <td align="left" ><input class="inputcorto"  name="fecha_disgrad" id="fecha_disgrad" type="text" size="20" >(mm/aaaa)</td>
                                            </tr>
                                            <tr>
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            </tr>
                                            <tr>
                                              <td colspan="2">
                                                <div align="center">
                                                    <input class="button_azul_consulta1" type="submit" value="Registrar nueva distinción" name="Actestgrad" onclick="RegistrarDisPrac(<%=idest%>);"/>
                                                </div>
                                              </td>
                                            </tr>
                                          </table>
                                        </div>
                                              <div align="center" id="tablaconsultaAfiPrac" style="display: none">
                                            <a class="textocom3">Afiliaciones Registradas</a><br>
                                                <br>
                                           <table  width="98%" border="1" class="tblStyle" id="tablaafiliacionesEgre" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="46%"><div align="center"><strong>Nombre</strong></div></th>
                                                    <th width="24%"><div align="center"><strong>Tipo</strong></div></th>
                                                    <th width="24%"><div align="center"><strong>Estado</strong></div></th>
                                                    <th width="6%"></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoafiliacionesEgre">
                                            </tbody>
                                        </table>
                                             <%--<input class="inputlargo" type="submit" value="Consultar Todas Las Afiliaciones" name="consultar" onclick= " actTabAfiEgre(<%=idest%>);"/>--%>
                                        </div>
                                        <div align="center" id="AfiPrac" style="display: none">
                                          <table width="99%">
                                            <tr>
                                                <td colspan="2">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td valign="bottom" align="left" colspan="2">
                                                    <a class="textocom3">Nueva Afiliación</a></b>
                                                </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Institución:</td>
                                              <td align="left">
                                                  <input class="inputlargo"  name="inst_afigrad" id="inst_afigrad" type="text" size="20" >
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Tipo:</td>
                                              <td align="left"> <select class="inputcorto"  name="Tipo_afigrad" id="Tipo_afigrad">
                                                    <option value="Científica">Científica
                                                    <option value="Profesional">Profesional
                                                    <option value="Académica">Académica
                                                    <option value="Social ">Social
                                                    <option value="Otra ">Otra
                                                 </select>
                                            </td>
                                            </tr>
                                             <tr>
                                              <td align="left" >Fecha de ingreso:</td>
                                              <td align="left"> <input class="inputcorto"  name="fechaAfi" id="fechaAfi">
                                              (mm/aaaa)
                                            </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Estado:</td>
                                              <td align="left">
                                                  <select class="inputcorto"  name="estadoafi" id="estadoafi">
                                                    <option value="True">Activa
                                                    <option value="False">Finalizada
                                                 </select>
                                             </td>
                                            </tr>
                                            <tr>
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            </tr>
                                            <tr>
                                              <td colspan="2">
                                                <div align="center">
                                                  <input class="button_azul_consulta1" type="submit" value="Registrar nueva afiliación" name="Actestgrad" onclick= " RegistrarAfiPrac(<%=idest%>);"/>
                                                </div>
                                              </td>
                                            </tr>
                                          </table>
                                        </div>
                                        <div align="center" id="tablaconsultaIdioPrac" style="display:none">
                                            <a class="textocom3">Idiomas Registrados</a><br><br>
                                           <table  width="98%" border="1" class="tblStyle" id="tablaidiomasEgre" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="49%"><div align="center"><strong>Nombre del idioma</strong></div></th>
                                                    <th width="15%"><div align="center"><strong>Nivel de lectura</strong></div></th>
                                                    <th width="15%"><div align="center"><strong>Nivel de escritura</strong></div></th>
                                                    <th width="15%"><div align="center"><strong>Nivel de habla</strong></div></th>
                                                    <th width="6%"></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoidiomasEgre">
                                            </tbody>
                                        </table>
                                             <%--<input class="inputlargo" type="submit" value="Consultar Todos Los Idiomas" name="consultar" onclick= " actTabIdioEgre(<%=idest%>);"/>--%>
                                        </div>
                                        <div align="center" id="idioPrac" style="display: none">
                                          <table width="99%" >
                                               <tr>
                                            <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                            </td>
                                            </tr>
                                            <tr>
                                              <td   valign="bottom" align="left" colspan="2">
                                                 <a class="textocom3">Nueva Idioma</a></b>
                                              </td>
                                            </tr>
                                            <tr>
                                            <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                            </td>
                                            </tr>
                                            <tr>
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nombre del idioma:</td>
                                              <td align="left">
                                                  <input class="inputmediano"  name="nom_idio" id="nom_idio" type="text" size="20" >
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nivel de lectura:</td>
                                              <td align="left"> <select class="inputcorto"  name="nivel_lecegre" id="nivel_lecegre">
                                                    <option value="Alto">Alto
                                                    <option value="Medio">Medio
                                                    <option value="Bajo ">Bajo
                                                 </select>
                                            </td>
                                            </tr>
                                             <tr>
                                              <td align="left" >Nivel de escritura:</td>
                                              <td align="left"> <select class="inputcorto"  name="nivel_escriegre" id="nivel_escriegre">
                                                     <option value="Alto">Alto
                                                    <option value="Medio">Medio
                                                    <option value="Bajo ">Bajo
                                                 </select>
                                            </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nivel de habla:</td>
                                              <td align="left"> <select class="inputcorto"  name="nivel_hablaegre" id="nivel_hablaegre">
                                                     <option value="Alto">Alto
                                                    <option value="Medio">Medio
                                                    <option value="Bajo ">Bajo
                                                 </select>
                                            </td>
                                            </tr>
                                            <tr>
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            </tr>
                                            <tr>
                                              <td colspan="2">
                                                <div align="center">
                                                  <input class="button_azul_consulta1" type="submit" value="Registrar nuevo idioma" name="ActIdigrad" onclick="RegistrarIdioPrac(<%=idest%>);"/>
                                                </div>
                                              </td>
                                            </tr>
                                          </table>
                                        </div>
                                        <div align="left" id="tablaconsultaExpPrac" style="display: none">
                                            <a class="textocom3">Experiencias Laborales Registradas</a><br><br>
                                           <table  width="98%" border="1" class="tblStyle" id="tablaExpLaboralEgre" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="50%"><div align="center"><strong>Empresa</strong></div></th>
                                                    <th width="44%"><div align="center"><strong>Cargo</strong></div></th>
                                                    <th width="6%"></th>

                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoExpLaboralEgre">
                                            </tbody>
                                        </table>
                                            <%--<input class="inputlargo" type="submit" value="Consultar Todas las Experiencias Laborales" name="consultar" onclick= "actTabExpEgre(<%=idest%>);"/>--%>
                                        </div>

                                        <div align="center" id="ExpLPrac" style="display: none">
                                          <table width="99%" >
                                               <tr>
                                            <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                            </td>
                                            </tr>
                                            <tr>
                                              <td   valign="bottom" align="left" colspan="2">
                                                <a class="textocom3">Nueva Experiencia Laboral</a>
                                              </td>
                                            </tr>
                                             <tr>
                                            <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                            </td>
                                            </tr>
                                             <tr>
                                            <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                            </td>
                                            </tr>
                                            <tr>
                                              <td align="left" style="display: none" >¿Es su empresa?:</td>
                                              <td align="left" style="display: none"> <select class="inputgraduado"  name="empropia" id="empropia" >
                                                    <option value="False">No
                                                 </select>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nombre de la Empresa</td>
                                              <td align="left" ><input class="inputgraduado"  name="nom_empresaegre" id="nom_empresaegre" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Cargo:</td>
                                              <td align="left">
                                                  <input class="inputgraduado"  name="cargoegre" id="cargoegre" type="text" size="20" >
                                              </td>
                                            </tr>
                                            <tr>
                                             <td align="left" style="display: none">Salario</td>
                                              <td align="left" style="display: none"> <select class="inputgraduado"  name="salario_expgrad" id="salario_expgrad">
                                                    <option value="exp de un practicante">experiencia como practicante
                                                 </select>
                                              </td>
                                              </tr>
                                            
                                               <tr>
                                              <td align="left" >Estado</td>
                                              <td align="left"> <select class="inputgraduado"  name="estado_expegre" id="estado_expegre" onchange="setExpActualPrac();">
                                                    <option value="Finalizado">Finalizado
                                                    <option value="Actual">Actual
                                                 </select>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Sector</td>

                                              <td align="left">
                                                  <select class="inputmediano" name="sector_expgrad" id="sector_expgrad">
                                                      <%
                                                         for(int cont=0;cont<se;cont++)
                                                       {
                                                           sector=sectores[cont];
                                                      %>
                                                        <option value="<%=sector.get("nom_sector")%>" ><%=sector.get("nom_sector")%></option>
                                                      <%}%>
                                                 </select>
                                                  <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >País:</td>
                                               <td align="left">
                                                  <select class="inputmediano" name="pais_expgrad" id="pais_expgrad">
                                                      <option value="COL">COLOMBIA</option>
                                                      <%
                                                         for(int cont=0;cont<pa;cont++)
                                                       {
                                                           pais=paises[cont];
                                                      %>
                                                      <option value="<%=pais.get("cod_pai")%>" ><%=pais.get("nom_pai")%></option>
                                                      <%}%>
                                                 </select>
                                                  <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Ciudad:</td>
                                              <td align="left" ><input class="inputgraduado"  name="ciudad_expgrad" id="ciudad_expgrad" type="text" size="20"></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Dirección de la empresa:</td>
                                              <td align="left" ><input class="inputgraduado"  name="dir_expgrad" id="dir_expgrad" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Teléfono de la empresa :</td>
                                              <td align="left" ><input class="inputgraduado"  name="tel_expgrad" id="tel_expgrad" type="text" size="20"></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Fecha de ingreso:</td>
                                              <td align="left" ><input class="inputcorto"  name="fechain_expgrad" id="fechain_expgrad" type="text" size="20" >(mm/aaaa)</td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Fecha de retiro:</td>
                                              <td align="left" ><input class="inputcorto"  name="fechaout_expgrad" id="fechaout_expgrad" type="text" size="20" >(mm/aaaa)</td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Tipo de Contrato:</td>
                                              <td align="left" ><select class="inputgraduado"  name="contrato_expgrad" id="contrato_expgrad">
                                                    <option value="Termino Fijo">Termino Fijo
                                                    <option value="Termino indefinido">Termino indefinido
                                                    <option value="Prestación de servicios">Prestación de servicios
                                                    <option value="Otro">Otro
                                                 </select></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Horario:</td>
                                              <td align="left" ><select class="inputgraduado"  name="horario_expgrad" id="horario_expgrad">
                                                    <option value="Tiempo Completo">Tiempo Completo
                                                    <option value="Medio Tiempo">Medio Tiempo
                                                    <option value="Otro">Otro
                                                 </select></td>
                                            </tr>
                                          </table>
                                        </div>
                                        <div align="center" id="ExpLPrac2" style="display: none">
                                          <table width="99%" >
                                               <tr>
                                              <td align="left" >Funciones en el cargo:</td>
                                              <td align="left" > <textarea name="fun_expgrad" id="fun_expgrad" rows="10" cols="38">Escriba sus funciones....</textarea></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Logros:</td>
                                              <td align="left" > <textarea name="logros_expgrad" id="logros_expgrad" rows="10" cols="38">Escriba sus Logros....</textarea></td>
                                            </tr>
                                            <tr>
                                              <td valign="bottom" align="left" colspan="2">
                                                &nbsp;
                                              </td>
                                            </tr>
                                            <tr>
                                              <td colspan="2">
                                                <div align="center">
                                                  <input class="button_azul_consulta1" type="submit" value="Registrar nueva experiencia laboral" name="ActExpgrad" onclick= "RegistrarExpPrac(<%=idest%>);"/>
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
            <tr>
                <td colspan="2" align="center">
                    <jsp:include page="footer">
                        <jsp:param name="type" value="prac" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
</html>

