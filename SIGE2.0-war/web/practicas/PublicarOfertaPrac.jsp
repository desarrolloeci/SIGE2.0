<%-- 
    Document   : PublicarOfertaPrac
    Created on : 27/12/2012, 09:18:54 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EmpresaRemote"%>
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

            String est = new String();
            String doc_grad = new String();
            String usuario = new String();
            String mensaje = new String();
            String ban = new String();
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
            
            mensaje = request.getParameter("mensaje");
            if (mensaje == null) {
                mensaje = "";
                ban = "none";
            } else {
                ban = "inline";
            }

            usuario = empresa.getUser();
            Contacto = empresa.getUserCont();
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp", emp);
            
            HashMap DatosRHContEmp = emp.getDatosRHContEmp(usuario);
            HashMap[] fechascol = emp.getFechasPracticas();
            
            String fecini = fechascol[8].get("fecha").toString();
            
            if (DatosRHContEmp.get("nom_contacto") == null || DatosRHContEmp.get("tel_contacto") == null || DatosRHContEmp.get("email_contacto") == null) {
                %><script>
                    alert("La información de los datos del contacto en la empresa está incompleta. Debe completarla antes de poder publicar sus ofertas para los practicantes.");
                    window.location = 'ActualizarInfoEmp';
                </script><%
                return;
            }
            
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

            if (periodo.equals("bloquearPrac")) {
                %><script>
                    alert("Únicamente es posible publicar ofertas de práctica entre las fechas <%=fechasemp[0].get("fecha")%> y <%=fechasemp[1].get("fecha")%>");
                    window.history.back();
                </script><%
                return;
            }
                        
            
            HashMap[] programas = emp.getListaProgramasPregrado();
            HashMap[] paises = emp.getpaises();
            HashMap pais;
            int pa = paises.length;
            
            HashMap[] sectores = emp.getSectores();
            //HashMap id = emp.docgrad(usuario);
            //doc_grad = (String)id.get("id_documento");
            //HashMap datos = emp.datosGeneralesGrd(doc_grad);
            //HashMap datosAC= emp.programaacademico(doc_grad);
            String error = new String("");

            //String paramtext = new String();
            //String mensajeest = new String("No tiene ninguna solicitud en tramite ");

            //est = estado.get("estado");
            String arreglo[] = new String[50];
            String texto[] = new String[20];
            String noticias[] = new String[200];
            //String noti[]=new String[20];
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
        <title>SIEMPREG - Nueva oferta practicante</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunEmpPrac.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
        <link href="CSS/empresas.css" rel="stylesheet" type="text/css">
        <link href="CSS/calendario.css" type="text/css" rel="stylesheet"> 
        <script src="jscript/calendar.js" type="text/javascript"></script> 
        <script src="jscript/calendar-es.js" type="text/javascript"></script> 
        <script src="jscript/calendar-setup.js" type="text/javascript"></script> 
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
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
    <body <%=mensaje.equals("")?"onload=\"vernuevaofertaprac();\"":""%>>
        <jsp:include page="header">
            <jsp:param name="type" value="emp" />
        </jsp:include>
        <table width="700" align="center" class="curvas loginPanel" cellspacing="10">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        Publicación de nueva Práctica Profesional
                    </div>
                </td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td valign="top" style="padding-right: 10px;">
                    <table width="200" border="0"  cellspacing="0" >
                        <tr>
                            <td width="200" height="20" class="textocom">
                                <div align="center" class="panelSubMenu">
                                    Sistema de Practicas
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
                                    if (Contacto.equals("0")?texto[1].equals("1"):texto[1].equals("5")) {
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
                    </table>
                </td>
                <td align="center" style="box-shadow: -5px 5px 5px 5px rgba(0,0,0,0.1);">
                    <table width="490"  frame="lhs">
                        <tr>
                            <td colspan="2"><div align="left" id="mensajeReg" style="display: <%=ban%>"><%=mensaje%></div></td>
                        </tr>
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom">
                                <form name="fromprogramaspre" action="" method="post">
                                    <div align="left" id="FormOfertaPrac" name="FormOfertaPrac" style="display: none">
                                        <table width="100%" style="text-align: left;">
                                            <tr style="height: 32px;"></tr>
                                            <tr>
                                                <td colspan="2"><div align="center"><a class="textocom3">Registro de nueva oferta de Práctica Profesional</a></div></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">
                                                    <p>
                                                    <img name="informacion" src="imagenes/Info_Simple.png" width="12" height="12" border="0" alt=""> = Información Importante (Poner mouse encima)
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2"><div align="left"><a class="textocom2"><strong>Datos generales de la oferta</strong></a><br></div></td>
                                            </tr>
                                            <tr>
                                            <td align="left">Tipo de Práctica:</td>
                                            <td align="left">
                                                <select class="inputlargo" name="tiprac" id="tiprac" required>
                                                    
                                                        <option value="Práctica Empresarial">Práctica Empresarial</option>
                                                        <option value="Práctica Docente">Práctica Docente</option>
                                                        <option value="Práctica Social">Práctica Social</option>
                                                        <option value="Práctica Investigativa">Práctica Investigativa</option>

                                                </select>
                                            </td>
                                        </tr>
                                            <tr>
                                                <td>Nombre del cargo:</td>
                                                <td><input class="inputlargo" name="nomcargonop" id="nomcargonop" type="text" size="20" maxlength="100"></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">
                                                    <a onmousemove="show('InfDes',event);" onmouseout="hide('InfDes');">
                                                    <img name="informacion" src="imagenes/Info_Simple.png" width="12" height="12" border="0" alt="">
                                                    </a>
                                                    Descripción y funciones del cargo: 
                                                </td>
                                            </tr>
                                            <tr>
                                                <div id="InfDes" class="tooltipbox">
                                                    <a class='textoinfo'>Indique el área y/o proyecto en el cual se desarrollará la práctica, las funciones que desempeñará el estudiante en práctica, y los beneficios adicionales al apoyo de sostenimiento mensual.</a>
                                                </div>
                                            </tr>
                                            <tr>
                                                <td  colspan="2" align="center">
                                                    <textarea name="descripcionnop" id="descripcionnop" rows="10" cols="1" maxlength="4500" onkeyup="showCharCount('descCharLeft', this, this.getAttribute('maxlength'));" placeholder="Escriba la descripción..."></textarea>
                                                </td><td></td>
                                            </tr>
                                            <tr>
                                                <td id="descCharLeft" colspan="2" align="right" style="font-size: 10px;">Quedan 4500 caracteres</td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">
                                                    <a onmousemove="show('InfReq',event);" onmouseout="hide('InfReq');">
                                                    <img name="informacion" src="imagenes/Info_Simple.png" width="12" height="12" border="0" alt="">
                                                    </a>
                                                    Requisitos:
                                                </td>
                                            </tr>
                                            <tr>
                                                <div id="InfReq" class="tooltipbox">
                                                    <a class='textoinfo'>Indique las habilidades y competencias personales y técnicas del aspirante para el desarrollo de la práctica.</a>
                                                </div>
                                            </tr>
                                            <tr>
                                                <td  colspan="2" align="center">
                                                    <textarea name="Requisitosnop" id="Requisitosnop" rows="10" cols="1" maxlength="4500" onkeyup="showCharCount('reqCharLeft', this, this.getAttribute('maxlength'));" placeholder="Escriba los requisitos..."></textarea>
                                                </td><td></td>
                                            </tr>
                                            <tr>
                                                <td id="reqCharLeft" colspan="2" align="right" style="font-size: 10px;">Quedan 4500 caracteres</td>
                                            </tr>
                                            <tr>
                                                <td>País:</td>
                                                <td>
                                                    <select class="inputmediano" name="paisnop" id="paisnop">
                                                            <%
                                                                for (int cont = 0; cont < pa; cont++) {
                                                                    pais = paises[cont];
                                                            %>
                                                        <option value="<%=pais.get("cod_pai")%>" <%=((String) pais.get("cod_pai")).equals("COL")?"selected":""%>><%=pais.get("nom_pai")%></option>
                                                            <%}%>

                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Ciudad:</td>
                                                <td>  <input class="inputmediano" name="ciudadnop" id="ciudadnop" type="text" size="20" maxlength="50" value="Bogotá"></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <a onmousemove="show('InfAct',event);" onmouseout="hide('InfAct');">
                                                    <img name="informacion" src="imagenes/Info_Simple.png" width="12" height="12" border="0" alt="">
                                                    </a>
                                                    Área de la actividad:
                                                </td>
                                                <td> <input class="inputlargo" name="areanop" id="areanop" type="text" size="20" maxlength="50"></td>
                                            </tr>
                                            <tr>
                                                <div id="InfAct" class="tooltipbox">
                                                    <a class='textoinfo'>Indique el área o division de la empresa donde se desarrollarán las actividades por parte del estudiante en práctica.</a>
                                                </div>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Sector:
                                                </td>
                                                <td align="left">
                                                    <select class="inputmediano" name="sectornop" id="sectornop">
                                                        <%
                                                            for (HashMap sector:sectores) {
                                                        %>
                                                            <option value="<%=sector.get("nom_sector")%>" ><%=sector.get("nom_sector")%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="left">Apoyo de sostenimiento mensual:</td>
                                                <td align="left"> <input class="inputmediano" name="salarionop" id="salarionop" type="text" size="20" maxlength="50"> (COL$)
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Sistema de seguro y riesgos profesionales:</td>
                                                <td><input class="inputmediano" name="seguros_arp" id="seguros_arp" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                                <td>Fecha límite para aplicar:</td>
                                                <td><input class="inputcorto" name="fechaoutnop" id="fechaoutnop" type="text" size="20" > 
                                                    
                                                    formato(dd/mm/aaaa)
                                                       
                                                    <br></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Fecha de inicio de la práctica (min: <%=fechascol[8].get("fecha")%>):
                                                </td>
                                                <td>  <input class="inputcorto" name="fechainprac" id="fechainprac" type="text" size="20" > 
                                                    
                                                    formato(dd/mm/aaaa)

                                                </td>
                                            </tr>
                                            <tr>
                                                <div id="InfFecIni" class="tooltipbox">
                                                    <a class='textoinfo'>La fecha de inicio de prácticas profesionales para el periodo académico 2016-2 es a partir del 1 de Junio del 2016</a>
                                                </div>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Fecha de finalización de la práctica (max: <%=fechascol[9].get("fecha")%>):
                                                </td>
                                                <td><input class="inputcorto" name="fechaoutprac" id="fechaoutprac" type="text" size="20" > 
                                                    
                                                     formato(dd/mm/aaaa)
                                                     
                                                    </td>
                                            </tr>
                                            <tr>
                                                <div id="InfFecFin" class="tooltipbox">
                                                    <a class='textoinfo'>De acuedo al reglamento de práctias profesionales, la duración de las prácticas son de 4 a 6 meses, con fecha de finalización máxima el 30 de Junio o el 31 de Diciembre, de acuerdo al periodo académico.</a>
                                                </div>
                                            </tr>
                                            <tr>
                                                <td>Jornada laboral:</td>
                                                <td align="left" >
                                                    <input type="hidden" value="Tiempo Completo" id="horarionop" name="horarionop">
                                                    <label>Tiempo Completo</label>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Tipo de contrato:</td>
                                                <td align="left" ><select class="inputgraduado"  name="contratonop" id="contratonop">
                                                        <option value="Termino Fijo">Término Fijo</option>
                                                        <option value="Termino indefinido">Término Indefinido</option>
                                                        <option value="Contrato de Aprendizaje">Contrato de Aprendizaje</option>
                                                        <option value="Convenio Interinstitucional">Convenio Interinstitucional</option>
                                                    </select></td>
                                            </tr>
                                            <tr style="height: 16px;"></tr>
                                            <tr>
                                                <td colspan="2"><a class="textocom2"><strong>Programas académicos a los que va dirigida la oferta</strong></a> </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">Por favor seleccione los programas académicos de pregrado a los que va dirigida la oferta:</td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">
                                                    <div  style="height:200px;width: 99%; overflow-y: auto;">
                                                        <%
                                                            for (HashMap programa: programas) {
                                                                //if(!programa.get("nom_prog").equals("INGENIERÍAS HAMBIENTAL")){ // Se activó la opción de ing ambiental temporalmente por correo de Andrés Pinzon - para volver solo se activa el if de esta linea
                                                        %>
                                                                <input class="inputsupercorto" type="checkbox" id="programaspre" name="programaspre" value="<%=programa.get("nom_prog")%>"><%=programa.get("nom_prog")%><br>
                                                        <% //}
                                                            }
                                                        %>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr style="height: 16px;"></tr>
                                            <tr>
                                                <td colspan="2">
                                                    <a onmousemove="show('InfTutor',event);" onmouseout="hide('InfTutor');">
                                                    <img name="informacion" src="imagenes/Info_Simple.png" width="12" height="12" border="0" alt="">
                                                    </a>
                                                    <a class="textocom2"><strong>Datos del Tutor Empresarial</strong></a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <div id="InfTutor" class="tooltipbox">
                                                    <a class='textoinfo'>Indicar la información del tutor en la empresa quien dirigirá las actividades que el estudiante en práctica desempeñará.</a>
                                                </div>
                                            </tr>
                                            <tr>
                                                <td>Nombre del Supervisor o Jefe:</td>
                                                <td><input class="inputmediano" name="nom_jefe" id="nom_jefe" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                                <td>Cargo:</td>
                                                <td><input class="inputmediano" name="cargo_jefe" id="cargo_jefe" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                                <td>Teléfono:</td>
                                                <td><input class="inputmediano" name="tel_jefe" id="tel_jefe" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                                <td>Email:</td>
                                                <td><input class="inputmediano" name="email_jefe" id="email_jefe" type="text" size="20" ></td>
                                                <td><input type="hidden" id="fechainiadmin" name="fechainiadmin" value="<%=fechascol[8].get("fecha")%>" ></td>
                                                <td><input type="hidden" id="fechafinadmin" name="fechafinadmin" value="<%=fechascol[9].get("fecha")%>" ></td>
                                            </tr>
                                            <tr style="height: 16px;"></tr>
                                            <tr>
                                                <td  colspan="2">
                                                    <div align="center"><input id="show_button" class="button_azul_consulta1" type="submit" value="Publicar" name="nuevaofer" onclick= "return Registrarofertaprac('<%=usuario%>','<%=Contacto%>');"/></div>
                                                </td>
                                            </tr>
                                            <tr style="height: 32px;"></tr>
                                        </table>
                                    </div>
                                </form>
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
                                                
 <script type="text/javascript">
    var button = document.getElementById('show_button')
    button.addEventListener('click',hideshow,false);

    function hideshow() {
        document.getElementById('hidden-div').style.display = 'block'; 
        this.style.display = 'none'
    }   
</script>
    </body>
</html>
