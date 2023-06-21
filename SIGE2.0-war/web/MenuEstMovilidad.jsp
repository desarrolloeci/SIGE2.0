<%-- 
    Document   : MenuEstMovilidad
    Created on : 31/07/2012, 03:20:26 PM
    Author     : Luis Alberto Salas
--%>
<%@page import="clientecampus.ConsultaPersonas"%>
<%@page import="BDsige.EstudiantesRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,
         javax.rmi.PortableRemoteObject"
         %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG Movilidad - Menú Principal</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
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
        <%
            response.setHeader("Cache-Control", "no-cache");
            HttpSession sesion;
            documentos.ruta ruta = new documentos.ruta();
            sesion = request.getSession(false);

            String est = new String();
            String id_sol = new String();
            String idest = new String();
            String mensaje1 = new String();
            String mensaje = new String();
            String uploadStatus = new String();
            String ban = new String();
            String usuario = new String();
            int semestre;
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
            HashMap datosetr;
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp", emp);
            HashMap id_est = emp.carnetEst(usuario);
            mensaje1 = request.getParameter("mensaje");
            if (mensaje1 == null) {
                mensaje1 = "";
                ban = "none";
            } else {
                ban = "inline";
            }

            uploadStatus = request.getParameter("uploadStatus");
            if (uploadStatus == null) {
                uploadStatus = "";
            }

            if (id_est.isEmpty()) {
        %>
        <script>
            alert("El usuario no está autenticado o su sesión ha finalizado.");
            window.location = 'loginestMov';
        </script>
        <%
                return;
            }

            idest = ((HashMap) id_est.getOrDefault("id_est", "")).getOrDefault("PEOPLE_ID", "").toString();
            HashMap idsol = emp.IdAplicacion(idest);

            if (!emp.getEmplId(usuario).isEmpty()) {
                //Se consulta la persona en campus
                emp.getPersona(emp.getEmplId(usuario).getOrDefault("PEOPLE_ID", "").toString(), usuario, "ESTUDIANTE", ConsultaPersonas.consultaPersona(emp.getEmplId(usuario).getOrDefault("PEOPLE_ID", "").toString(), "ESTUDIANTE"));
            }
            if (idsol.isEmpty()) {
        %>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="mov" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" cellspacing="10">
            <tr style="height: 32px;"></tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td colspan="2" style="padding: 0px 15px;">
                    Usted no está autorizado para ingresar al Sistema de Movilidad debido a que no cumple con alguno de los siguientes requisitos:<br><br>
                    - Ser estudiante de pregrado o posgrado activo en el semestre actual.<br>
                    - Haber realizado su solicitud de movilidad por el autoservicio.
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div align="center" >
                        <br><input class="button_azul1" type="submit" onclick="location = 'loginestMov';" value="Volver al inicio" />

                    </div>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <jsp:include page="footer">
                        <jsp:param name="type" value="movi" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
    <%
            sesion = request.getSession(false);
            if (sesion != null) {
                sesion.invalidate();
            }
            return;
        }
        HashMap solicitud_movilidad = emp.datosSolicitudGeneral(idsol.get("id_solicitud").toString());
        HashMap datos = emp.datosGeneralesEst(idest);
        HashMap datosAC = emp.datosAcademicosEst(idest);
        HashMap estado = emp.estadoAplicante(idest);
        HashMap[] paises = emp.getpaises();
        HashMap pais;
        int p = paises.length;

        est = (String) estado.get("estado");

        id_sol = (String) idsol.get("id_solicitud");
        HashMap comentarios = emp.cometarios_sol(id_sol);
        semestre = Integer.parseInt((String) datosAC.get("sem_est"));

        if (id_sol == null) {
            id_sol = "1";
        }
        if (est == null) {
            est = "r         ";
        }
        datosetr = emp.datosEntrevistasEst(id_sol);

        HashMap mensajeest = emp.mensajeestado(est);
        mensaje = (String) mensajeest.get("men_est");

        HashMap[] estadodocu;
        HashMap estadodocu1;
        HashMap estadodocu2;
        estadodocu = emp.estadodocu(id_sol);

        int cantdocu = estadodocu.length;

        estadodocu1 = estadodocu[0];
        estadodocu2 = estadodocu[0];

        if (cantdocu > 1) {
            estadodocu2 = estadodocu[1];
        }

        String dpto = emp.homologaPrograma(datos.get("id_dpto").toString());

        String error = new String();
        String[] arreglo = new String[50];
        String[] texto = new String[20];
        String[] noticias = new String[200];
        //String noti[]=new String[20];
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
            not = 0;
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
        <jsp:param name="type" value="mov" />
    </jsp:include>
    <table width="750" align="center" class="curvas loginPanel" cellspacing="10">

        <%if (semestre >= 0) {%>
        <%if (!(solicitud_movilidad.get("prog_mov") == null || solicitud_movilidad.get("pais_mov") == null)) {%>
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
                            if (texto[2].equals("0")) {
                %>
                <table width="200"   cellspacing="0" >

                    <tr>

                        <td width="200" height="20" bgcolor="#FFFFFF" VALIGN="BOTTOM" > <%--onMouseOver="this.style.backgroundColor='#CCCCFF'"  onMouseOut=" this.style.backgroundColor='#FFFFFF'"--%>
                            <div align="left">

                                <a onclick="<%=texto[6]%>" class="menuprueba">                                                    
                                    <font id="f<%=conmenu%>" color="#000000"><%=texto[5]%></font></a></div>
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
            <%}%>
            <td align="left">
                <table width="100%" frame="lhs">

                    <tr>
                        <td class="textocom" style="height: 500px; vertical-align: top; box-sizing: border-box; padding: 0px 15px;">
                            <%
                                if (solicitud_movilidad.get("prog_mov") == null || solicitud_movilidad.get("pais_mov") == null) {
                            %>
                            <div align="left" id="datosol">
                                Este formulario debe diligenciarse de acuerdo con la solicitud aprobada por su decano en Enlace Académico, no es una nueva solicitud. Si tiene dudas con el programa de movilidad que debe seleccionar por favor comuniquese con la Unidad de Gestión Externa.
                                <form onsubmit="return validaProgPais()" name="fromSolicitudMov" action="GuardarSolicitud" method="POST">
                                    <input name="idest" id="idest" value="<%=idest%>" type="hidden"/>
                                    <table  width="100%"  cellspacing="0">

                                        <tr>

                                            <td >
                                                Seleccione el programa de movilidad de su solicitud.
                                            </td>

                                            <td >
                                                <select class="inputmediano" required name="ProgramaSolicitado" id="ProgramaSolicitado">
                                                    <option value="">Seleccione</option>
                                                    <option value="INTERCAMBIO NACIONAL">Intercambio Nacional</option>
                                                    <option value="INTERCAMBIO LOCAL">Intercambio Local</option>
                                                    <option value="JOVENES INGENIEROS">Jovenes Ingenieros</option>
                                                    <option value="INTERCAMBIO SOCIAL">Intercambio Social</option>
                                                    <option value="PRACTICA INTERNACIONAL">Pr&aacute;ctica Internacional</option>
                                                    <option value="INTERCAMBIO INTERNACIONAL">Intercambio Internacional</option>
                                                    <option value="DOBLE TITULACION">Doble Titulaci&oacute;n</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td >
                                                País destino en su solicitud:
                                            </td>
                                            <td >
                                                <select class="inputmediano" required name="pais_mov" id="pais_mov">
                                                    <option value="">Seleccione</option>
                                                    <%
                                                        for (int cont = 0; cont < p; cont++) {
                                                            pais = paises[cont];

                                                    %>
                                                    <option value="<%=pais.get("cod_pai")%>" <%=((String) pais.get("cod_pai")).equals("COL") ? "selected" : ""%>><%=pais.get("nom_pai")%></option>
                                                    <%}%>

                                                </select>
                                                <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td >
                                                Fecha de inicio:
                                            <td >
                                                <input class="inputcorto" name="fechain" required id="fechain" type="text" size="20" maxlength="25"> (mm/aaaa)
                                            </td>                        
                                        </tr>
                                        <tr>
                                            <td >
                                                Fecha de finalización: 
                                            </td>
                                            <td >
                                                <input class="inputcorto" name="fechaout" required id="fechaout" type="text" size="20" maxlength="25"> (mm/aaaa)
                                            </td>
                                        </tr>
                                        <tr>
                                            <td  colspan="3" align="center">
                                                &nbsp;
                                            </td>
                                        </tr>
                                        <tr>
                                            <td  colspan="3" align="center">
                                                &nbsp;
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center">                                          
                                                <input id="EnvSolMov" class="button_azul"type="submit" value="Enviar" name="EnvSolicitud" />
                                            </td><td></td>
                                        </tr>

                                    </table>
                                </form>

                            </div>
                            <%
                            } else {
                            %>
                            <div align="left" id="cargardocumentos" style="display:none">
                                <%
                                    if (est.equals("b         ") && estadodocu1.get("estado_HV") != null && estadodocu1.get("estado_notas") != null && estadodocu1.get("estado_idiomas") != null && estadodocu1.get("estado_cpadres") != null
                                            && estadodocu1.get("vobo_foresp") != null && estadodocu2.get("vobo_foresp") != null && estadodocu1.get("carta_ud") != null && estadodocu2.get("carta_ud") != null) {
                                        if (estadodocu1.get("estado_HV").equals("cargado   ") && estadodocu1.get("estado_notas").equals("cargado   ") && estadodocu1.get("estado_idiomas").equals("cargado   ")
                                                && estadodocu1.get("estado_cpadres").equals("cargado   ") && estadodocu1.get("vobo_foresp").equals("cargado") && estadodocu2.get("vobo_foresp").equals("cargado")
                                                && estadodocu1.get("carta_ud").equals("cargado") && estadodocu2.get("carta_ud").equals("cargado")) {
                                %>

                                <script type="text/javascript">
                                    <%est = "c         ";%>
                                    actualizarestadoest(<%=id_sol%>);

                                </script>                                         
                                <%
                                        }
                                    }

                                    if (est.equals("b         ") || est.equals("e         ")) {

                                %>
                                <br>
                                <span style="font-size: 12px;"><b>Nota:</b> En caso de solo tener una opción de universidad cargue los documentos de la primera universidad en todos los casos.<br><br>
                                    En <a href="https://europass.cedefop.europa.eu/es/documents/curriculum-vitae/templates-instructions" target="_blank">este enlace</a> puede encontrar plantillas internacionales de hoja de vida para obtener una guía.</span>
                                <p class="texto_rojo1" style="font-size: 16px;"><%=uploadStatus%></p>
                                <table  width="100%" border="1" class="tabla" id="tablaCrgardoc" align="center" >
                                    <thead>
                                        <tr>
                                            <th ><div align="center"><strong>Tipo de documento</strong></div></th>
                                            <th ><div align="center"><strong>Enviar</strong></div></th>
                                        </tr>
                                    </thead>
                                    <tbody id="cuerpo5">
                                    </tbody>
                                </table>
                                <script type="text/javascript">
                                    actualizartablaCrgardoc(<%=id_sol%>);
                                </script>
                                <%
                                } else {
                                %>
                                <p>"Usted no esta habilitado para cargar documentos al sistema si quiere saber su estado haga click"</p>
                                <a  onclick="VerConsultarEstado();">
                                    <font id="noB" color="#000000">Consultar estado </font></a>
                                        <%                                             }
                                        %>

                            </div>
                            <div align="left" name="Cnestado" id="Cnestado" style="display: inline">
                                <table  width="100%"  cellspacing="0">
                                    <tr>
                                        <td>
                                            <div align="left" id="mensajeSol" style="display: <%=ban%>"><%=mensaje1%></div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p style="text-decoration: underline; font-weight: bold; margin: 0px 0px 5px 0px;">Estado de la solicitud:</p>
                                            <%=mensaje%>
                                        </td>
                                    </tr>
                                    <%
                                        if (est.equals("h         ")) //entre_vice, exm_psico, exm_medico
                                        {
                                    %>
                                    <tr style="height: 16px;"></tr>
                                    <tr>
                                        <td>
                                            <table style="width: 100%; border-spacing: 2px 5px;">
                                                <tr>
                                                    <td style="width: 50%; text-align: center; font-weight: bold; background: #990000; color: #FFFFFF; border-radius: 5px 0px 0px 0px;">
                                                        Tipo
                                                    </td>
                                                    <td style="width: 50%; text-align: center; font-weight: bold; background: #990000; color: #FFFFFF; border-radius: 0px 5px 0px 0px;">
                                                        Fecha
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="border-bottom: 1px solid #CACAFF;">Entrevista con el vicerrector</td>
                                                    <td style="border-bottom: 1px solid #CACAFF;"><%=datosetr.get("entre_vice") != null ? datosetr.get("entre_vice") : "Sin definir"%></td>
                                                </tr>
                                                <tr>
                                                    <td style="border-bottom: 1px solid #CACAFF;">Examen medico</td>
                                                    <td style="border-bottom: 1px solid #CACAFF;"><%=datosetr.get("exm_medico") != null ? datosetr.get("exm_medico") : "Sin definir"%></td>
                                                </tr>
                                                <tr>
                                                    <td style="border-bottom: 1px solid #CACAFF;">Examen psicológico </td>
                                                    <td style="border-bottom: 1px solid #CACAFF;"><%=datosetr.get("exm_psico") != null ? datosetr.get("exm_psico") : "Sin definir"%></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                    <tr>
                                        <td>
                                            <p style="text-decoration: underline; font-weight: bold; margin: 20px 0px 5px 0px;">Cometarios acerca de la solicitud (Carta de intención) por parte de la Decanatura:</p>
                                            <%
                                                if (comentarios.get("obv_cartaeci") != null) {
                                            %>
                                            <div style="white-space: pre-line;"><%=comentarios.get("obv_cartaeci")%></div>
                                            <%
                                                }
                                            %>
                                            <p style="text-decoration: underline; font-weight: bold; margin: 20px 0px 5px 0px;">Cometarios acerca de los documentos por parte de la ORI:</p>
                                            <%
                                                if (comentarios.get("obv_docu") != null) {
                                            %>
                                            <div style="white-space: pre-line;"><%=comentarios.get("obv_docu")%></div>
                                            <%
                                                }
                                            %>
                                            <p style="text-decoration: underline; font-weight: bold; margin: 20px 0px 5px 0px;">Comentarios acerca del plan de estudio por parte de la Decanatura:</p>
                                            <%
                                                if (comentarios.get("obv_plan") != null) {
                                            %>
                                            <div style="white-space: pre-line;"><%=comentarios.get("obv_plan")%></div>
                                            <%
                                                }
                                            %>
                                            <p style="text-decoration: underline; font-weight: bold; margin: 20px 0px 5px 0px;">Comentarios del vicerrector:</p>
                                            <%
                                                if (comentarios.get("obv_vice") != null) {
                                            %>
                                            <div style="white-space: pre-line;"><%=comentarios.get("obv_vice")%></div>
                                            <%
                                                }
                                            %>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <%}
        } else {%>
        <tr bgcolor="#FFFFFF" class="textocom">
            <td valign="top">
                El estudiante no puede realizar ninguna operación porque aún no cumple con todos los requisitos. 
            </td>
        </tr>
        <%}%>
        <tr>
            <td align="center" colspan="2">
                <jsp:include page="footer">
                    <jsp:param name="type" value="movi" />
                </jsp:include>
            </td>
        </tr>
    </table>
</body>
</html>
