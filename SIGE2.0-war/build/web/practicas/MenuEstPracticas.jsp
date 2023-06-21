<%--
    Document   : MenuEstPracticas
    Created on : 10/12/2012, 02:16:57 PM
    Author     : Luis Alberto Salas
--%>

<%@page import="utiles.ConsultaException"%>
<%@page import="clientecampus.ConsultaPersonas"%>
<%@page import="BDsige.EstudiantesRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,javax.rmi.PortableRemoteObject"%>



<html>
    <head>
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            .f {
                color: #FFF;
            }
            .textoblanco {
                color: #FFF;
            }
        </style>
        <title>SIEMPREG Prácticas Profesionales - Menú Principal</title>
        <script type="text/javascript">
            function funcion(id) {
                var opcion = document.getElementById(id);
                if (opcion.style.display == 'block') {
                    opcion.style.display = 'none';
                } else {
                    opcion.style.display = 'block';
                }
            }
        </script>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunEstPrac.js" ></script>
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
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
        <%
            response.setHeader("Cache-Control", "no-cache");

            documentos.ruta ruta = new documentos.ruta();

            String est = new String();
            String menest = new String();
            String jornada = new String();
            String obs = new String();
            String estApl = new String();

            String usuario = new String();
            String idest = new String();

            String expecta = new String();
            String electivas = new String();
            String asigConj = new String();

            //String doc_grad = new String();
            //doc_grad="2067558";
            //login.InicioProfRemoteBusiness empleado = (login.InicioProfRemoteBusiness) session.getAttribute("empleado");
            login.SessionEstRemote estudiante = (login.SessionEstRemote) session.getAttribute("usuario");
            usuario = estudiante.getUser();

            if (estudiante == null) {
        %><script>
            alert("El usuario no está autenticado o su sesión ha finalizado.");
            window.location = 'loginestMov';
        </script><%
                          return;
                      }

                      inicio.conectaEJB conEjb = new inicio.conectaEJB();
                      EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();

                      emp.inicializar("75107740");
                      session.setAttribute("emp", emp);

                      /**
                       *
                       * HashMap id_est = emp.carnetEstPrac(usuario); idest =
                       * (String) id_est.get("id_est");
            *
                       */
                      idest = emp.getEmplId(usuario).getOrDefault("PEOPLE_ID", "").toString();

                      //Se consulta la solicitud de practicas
                      HashMap solicitud_prac = emp.veriSoliPrac(emp.getEmplId(usuario).getOrDefault("PEOPLE_ID", "").toString());

                      //Se consulta la persona en campus
                      if (!emp.getEmplId(usuario).isEmpty()) {
                          emp.getPersona(emp.getEmplId(usuario).getOrDefault("PEOPLE_ID", "").toString(), usuario, "ESTUDIANTE", ConsultaPersonas.consultaPersona(emp.getEmplId(usuario).getOrDefault("PEOPLE_ID", "").toString(), "ESTUDIANTE"));
                      }

                      session.setAttribute("id_est", emp.getEmplId(usuario).getOrDefault("PEOPLE_ID", ""));

                      if (solicitud_prac.isEmpty()) {
        %>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" cellspacing="10">
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
            <tr>
                <td colspan="2">
                    <div align="center" >
                        <br><input class="button_azul1" type="submit" onclick="location = 'loginestMov';" value="Volver al inicio" />

                    </div>
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
    </body>
</html>
<%
        session.invalidate();
        return;
    } else {
        //No se porque esta linea
        //emp.ActDatosPrac("", "", "", "", "", "", idest, "");
    }

    HashMap datos = emp.datosGeneralesEstPrac(idest);
    HashMap datosAC = emp.datosAcademicosEst(idest);
    HashMap datosprac = emp.datosprac(idest);
    HashMap estado = emp.estadoAplicanteprac(idest);

    String dpto = emp.homologaPrograma((datos.get("id_dpto") == null) ? "" : datos.get("id_dpto").toString());

    est = (String) estado.get("estado");
    menest = (String) estado.get("men_estado");
    jornada = (String) estado.get("jornada");
    obs = (String) estado.get("observaciones");
    estApl = (String) estado.get("estado_apli");

    expecta = (String) datosprac.get("expectativas");
    electivas = (String) datosprac.get("electivas");

    asigConj = (String) estado.get("asig_conjunta");

    if (estApl != null && (estApl.equals("h") || estApl.equals("j"))) {
        HashMap datosContratado = emp.getDatosContratado(idest);
        String empContratado = (String) datosContratado.get("razon_social");
        String nitContratado = (String) datosContratado.get("nit");
        String cargoContratado = (String) datosContratado.get("cargo");
%>
</head>
<body>
    <jsp:include page="header">
        <jsp:param name="type" value="prac" />
    </jsp:include>
    <table width="750" align="center" class="curvas loginPanel" cellspacing="10">
        <tr>
            <td class="textocom2" align="center" style="padding-top: 32px; font-weight: bold;">
                Usted ha sido contratado por una empresa
            </td>
        </tr>
        <tr>
            <td class="textocom" align="center">
                La empresa <b><%=empContratado%></b> con NIT: <i><%=nitContratado%></i> le ha cambiado el estado a contratado 
                para el cargo de <i><%=cargoContratado%></i><br><br>
                <input type="submit" id="botSolDocPraApro" value="Adjuntar archivos" style="display: block; height: 25px; font-size: 1em; margin: 20px auto 0px auto;" onclick="location = 'solicitarDocPrac';">
                <input type="submit" id="botSal" value="Salir" style="display: block; height: 25px; font-size: 1em; margin: 20px auto 0px auto;" onclick="cerrarsesionEst();">
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
</body>
</html>
<%
        return;
    }

    //Define las fechas definidas por la UGE y comprueba si la fecha actual se encuentra dentro de esta.
    Calendar hoy = Calendar.getInstance();
    hoy.getTime();

    HashMap[] fechasemp = emp.getFechasPracticasEst();

    int year_in = Integer.parseInt((String) fechasemp[4].get("year"));
    int year_out = Integer.parseInt((String) fechasemp[5].get("year"));
    int mes_in = Integer.parseInt((String) fechasemp[4].get("mes"));
    int mes_out = Integer.parseInt((String) fechasemp[5].get("mes"));
    int dia_in = Integer.parseInt((String) fechasemp[4].get("dia"));
    int dia_out = Integer.parseInt((String) fechasemp[5].get("dia"));

    Calendar fInSol = Calendar.getInstance();
    Calendar fOutSol = Calendar.getInstance();

    fInSol.set(year_in, mes_in - 1, dia_in, 0, 0, 0);
    fOutSol.set(year_out, mes_out - 1, dia_out, 24, 59, 59);

    String periodoSol = "bloquearSol";

    if ((hoy.after(fInSol) || hoy.equals(fInSol)) && (hoy.before(fOutSol) || hoy.equals(fOutSol))) {
        periodoSol = "activarSol";
    }

    if (est == null) {
        est = "init";
    }
    if (jornada == null) {
        jornada = "";
    }
    if (obs == null) {
        obs = "";
    }

    String error = new String();
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
</head>
<body>
    <jsp:include page="header">
        <jsp:param name="type" value="prac" />
    </jsp:include>
    <table width="750" align="center" class="curvas loginPanel" cellspacing="10">
        <tr bgcolor="#FFFFFF" class="textocom">
            <td width="30%" valign="top" style="padding-top: 15px;">
                <table cellspacing="0" >
                    <tr>
                        <td align="center" style="padding-bottom: 5px;">
                            <font color="#990000"><strong>Opciones</strong></font>
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
                                if (texto[0].equals("0")) {
                    %>
                    <tr>
                        <td height="20" class="menuprueba" align="left" onclick="<%=texto[5]%>">
                            <font id="f<%=conmenu%>" color="#000000"><%=texto[4]%></font>
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
            <td width="70%" style="padding-top: 15px;">
                <table width="500" frame="lhs">
                    <tr>
                        <td width="100%" valign="top" height="480"   class="textocom" >
                            <div align="left" id="solicitudPracEst" style="display: none">
                                <table align="center" style="padding-left: 20px;">
                                    <tr>
                                        <td colspan="2" align="center" valign="middle" class="textocom3">Datos generales del estudiante</td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td colspan="2" align="center" >&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td  align="left" ><a class="textocom2">Nombre:</a></td>
                                        <td  align="left"><%=datos.get("nom_est")%></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td align="left"><a class="textocom2">Fecha de nacimiento:</a></td>
                                        <td align="left"><%=datos.get("fec_nac")%></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td align="left"><a class="textocom2">Numero de identificacion:</a></td>
                                        <td align="left"><%=datos.get("doc_est")%></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td align="left"><a class="textocom2">Telefono de contacto:</a></td>
                                        <td align="left"><%=datos.get("tel_corr")%></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td align="left"><a class="textocom2">Telefono de contacto 2:</a></td>
                                        <td align="left"><%=datosprac.get("tel2")%></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td align="left"><a class="textocom2">Celular de contacto:</a></td>
                                        <td align="left"><%=datosprac.get("cel")%></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td align="left"><a class="textocom2">Email de contacto:</a></td>
                                        <td align="left"><%=datos.get("emails")%></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td align="left"><a class="textocom2">Email de contacto 2:</a></td>
                                        <td align="left"><%=datosprac.get("email2")%></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td align="left"><a class="textocom2">Programa Académico:</a></td>
                                        <td align="left"><%=dpto%></td>
                                    </tr>
                                    <!--tr class="textocom" >
                                        <td align="left"><a class="textocom2">Promedio Acumulado:</a></td>
                                        <td align="left"><%=datosAC.get("prom_acum")%></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td align="left"><a class="textocom2">Semestre Actual:</a></td>
                                        <td align="left"><%=datosAC.get("sem_est")%></td>
                                    </tr-->
                                    <tr class="textocom">
                                        <td align="left"><a class="textocom2">Tipo de práctica que desea solicitar:</a></td>
                                        <td align="left">
                                            <select class="inputmediano" name="ProgramaSolicitado" id="ProgramaSolicitado">
                                                <option value="TIEMPO COMPLETO" <%=jornada.equals("TIEMPO COMPLETO") ? "selected" : ""%>>Práctica-tiempo completo</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td colspan="2" align="center">&nbsp;</td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td colspan="2" align="center">&nbsp;</td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td colspan="2" align="center" valign="middle" class="textocom3"><strong>Hoja de Vida del Estudiante</strong></td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td colspan="2" align="center">&nbsp;</td>
                                    </tr>
                                    <tr class="textocom" >
                                        <td  colspan="2">
                                            <a href="HojadeVidaPrac" target="_blank" class="href_rojo2">Ver Hoja de vida actual</a>
                                        </td>
                                    </tr>
                                    <tr class="textocom">
                                        <td colspan="2" align="center" >&nbsp;</td>
                                    </tr>
                                    <tr class="textocom">
                                        <td align="left" colspan="2"><a class="textocom2">Expectativas:</a></td>
                                    </tr>
                                    <tr>
                                        <td align="left" colspan="2"><div><textarea id="exvprac" name="exvprac" cols="12" disabled><%=expecta%></textarea></div></td>
                                        </tr>
                                        <tr class="textocom">
                                            <td colspan="2" align="center" >&nbsp;</td>
                                        </tr>
                                        <tr class="textocom">
                                            <td align="left" colspan="2"><a class="textocom2">Línea de profundización o Electivas técnicas cursadas:</a></td>
                                        </tr>
                                        <tr>
                                            <td align="left" colspan="2"><div><textarea id="electivasprac" name="electivasprac" cols="12" disabled><%=electivas%></textarea></div></td>
                                        </tr>
                                        <tr class="textocom">
                                            <td colspan="2" align="center" >&nbsp;</td>
                                        </tr>
                                        <tr class="textocom">
                                            <td align="left" colspan="2"><a class="textocom2">(Opcional) Asignaturas a cursar en conjunto a las Prácticas Profesionales:</a></td>
                                        </tr>
                                        <tr>
                                            <td align="left" colspan="2"><div><textarea id="asigconj" name="asigconj" cols="12" disabled><%="Este campo no aplica, ya fue diligenciado en Enlace Académico y no es requerido en SiempreG"%></textarea></div></td>
                                        </tr>
                                         <tr class="textocom">
                                            <td colspan="2" align="center">&nbsp;</td>
                                        </tr>
                                         <tr class="textocom">
                                            <td colspan="2" align="center" >&nbsp;</td>
                                        </tr>
                                        <tr class="textocom">
                                            <td colspan="2"><strong>Asegúrese que la información esta actualizada antes de enviar la solicitud, de no ser así por favor actualícela en “Actualizar hoja de vida” en el menú de la izquierda.</strong></td>
                                        </tr>
                                         <tr class="textocom">
                                            <td colspan="2" align="center" >&nbsp;</td>
                                        </tr>
                                         <tr class="textocom">
                                            <td colspan="2" align="center" >&nbsp;</td>
                                        </tr>
                                        <tr class="textocom">                                                
                                        <% if (periodoSol.equals("activarSol")) {%>
                                        <% if (false && est.equals("init")) {%>

                                            <td  colspan="2">
                                                <input id="envSolPrac" type="submit" value="Enviar solicitud" name="vobocarta" onclick= "EnviarSolPrac(<%=idest%>);"/>
                                            </td>

                                        <% } else {%>

                                        <% if (est.equals("d         ")) {%>

                                            <td  colspan="2">
                                                <input id="actSolPrac" type="submit" value="Actualizar solicitud" name="vobocarta" onclick= "ActualizarSolPrac(<%=idest%>);"/>
                                            </td>

                                        <% } else {%>

                                            <td  colspan="2" align="center">
                                                <a class="href_rojo2">

                                                <% if (est.equals("r         ") || est.equals("c         ") || est.trim().equals("c")) {%>
                                                <%=menest%>
                                                <% } else {%>
                                                    Su solicitud se encuentra en proceso.
                                                <% }%>

                                                </a>
                                            </td>

                                        <% }%>

                                        </tr>
                                        <tr height="16"></tr>
                                        <tr>
                                            <td colspan="2" align="center">

                                            <% if (!est.equals("r         ") && !est.equals("c         ") || est.trim().equals("c")) {%>

                                            <a class="href_rojo2"><b>Estado:</b> <%=menest%></a>

                                            <% }%>
                                            <% if (!est.equals("b         ")) {%>

                                            <p align="left" style="font-weight: bold;">Observaciones:</p>
                                            <p align="left"><%=(obs.equalsIgnoreCase("null") || obs.equalsIgnoreCase("")) ? "Sin observaciones." : obs%></p>

                                            <% }%>

                                            </td>
                                        <% }%>
                                        <% } else {%>
                                            <td colspan="2" align="center">
                                                <a class="href_rojo2">
                                                    El periodo para enviar su solicitud de Práctica Profesional es 
                                                    desde el 
                                                <%=fechasemp[4].get("dia")%>/<%=fechasemp[4].get("mes")%>/<%=fechasemp[4].get("year")%> 
                                                    hasta el
                                                <%=fechasemp[5].get("dia")%>/<%=fechasemp[5].get("mes")%>/<%=fechasemp[5].get("year")%>
                                                </a>
                                            </td>
                                        <%}%>
                                        </tr>                                              
                                    </table>
                                </div>
                                <div align="left" id="RegDisponibilidad" style="display: none">
                                <% if (est.equals("c         ") || est.trim().equals("c") || est.trim().equals("c")) {%>
                                    <table width="440"  border="0" align="center">
                                        <tr>
                                            <td>
                                                <table width="440" border="0" align="center">
                                                    <tr>
                                                        <td colspan="2" >Escriba los días y las horas en las que está disponible para realizar
                                                            los procesos de selección de las diferentes empresas:
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2" align="left">
                                                            <textarea name="DisponibilidadEst" id="DisponibilidadEst" rows="10" cols="38"><%=estado.get("disponibilidad") == null ? "" : estado.get("disponibilidad")%></textarea>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2"><input type="submit" value="Registrar" name="consultar" onclick= "RegDisponibilidadEst(<%=idest%>);"/></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                <%} else {%>
                                        <table  width="480" cellspacing="0">
                                            <tr class="textocom">
                                                <td colspan="2" style="font-weight: 600;"><p>Su solicitud debe contar con una aprobación de su decano para poder registrar una disponibilidad.</p></td>
                                            </tr>
                                        </table>
                                <%}%>
                                </div>
                                <div align="left" id="consultaOferPracEst" style="display: none">
                                <% if (est.equals("c         ") || est.trim().equals("c")) {%>
                                        <table  width="480"  cellspacing="0">
                                            <tr>
                                            <p>
                                                <select name="TipoOferPracEst" id="TipoOferPracEst">
                                                    <option value="no aplicado">A las que NO ha aplicado</option>
                                                    <option value="aplicado" >A las que ha aplicado</option>
                                            <%--<option value="TODOS">Todos</option>--%>
                                                </select>
                                            </p>
                                            </tr>
                                        </table>
                                <%}%>
                                </div>
                                <div align="left" id="consultaOferPracEst2" style="display: none">
                                <% if (est.equals("c         ") || est.trim().equals("c")) {%>
                                        <table  width="480"  cellspacing="0">
                                            <tr>
                                                <p>
                                                <select name="TipoOferPracEst2" id="TipoOferPracEst2">
                                                    <option value="TIEMPO COMPLETO" >Tiempo completo</option>
                                            <%--<option value="TODOS">Todos</option>--%>
                                                </select>
                                                </p>
                                            </tr>
                                        </table>
                                <%}%>
                                </div>
                                <div align="left" id="botonconsultaSolOferPracEst" style="display: none">
                                    <table  width="480" cellspacing="0">
                                    <% if (est.equals("c         ") || est.trim().equals("c")) {%>
                                        <tr class="textocom">
                                            <p>
                                                <input type="submit" value="Consultar Ofertas" name="consultar" onclick= "consultaOferPracEst('<%=datos.get("id_dpto")%>', '<%=idest%>');"/>
                                            </p>
                                        </tr>
                                    <% } else {%>
                                        <tr class="textocom">
                                            <td colspan="2" style="font-weight: 600;"><p>Su solicitud debe contar con una aprobación de su decano para poder aplicar a las ofertas</p></td>
                                        </tr>
                                    <%}%>
                                    </table>
                                </div>
                                <div align="left" id="solicitudOferPracEst" style="display: none">
                                <% if (est.equals("c         ") || est.trim().equals("c")) {%>
                                        <table  width="80%" border="1" class="tabla" id="TablaOferPracEst" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="20%"><div align="center"><strong>Nombre del cargo </strong></div></th>
                                                    <th width="20%"><div align="center"><strong>Empresa</strong></div></th>
                                                    <th width="10%"><div align="center"><strong>Fecha Límite</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpotablaOferPracEst">
                                            </tbody>
                                        </table>
                                <% }%>
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