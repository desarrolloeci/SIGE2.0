<%-- 
    Document   : PublicarOfertaGrad
    Created on : 19/10/2012, 01:47:29 PM
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
            response.setHeader("Cache-Control","no-cache");

            documentos.ruta ruta = new documentos.ruta();

            String est = new String();
            String doc_grad = new String();
            String usuario = new String();
            String mensaje = new String();
            boolean msgReturnError = true;
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
            
            usuario=empresa.getUser();
            Contacto=empresa.getUserCont();

            //Verificamos existencia y vigencia del documento adjuntado
            String Rut = new RutaDoc("Doc_Emp_Sige").getRuta() + "Rut-" + usuario + "-CM.pdf";
            String Camara = new RutaDoc("Doc_Emp_Sige").getRuta() + "Cam-" + usuario + "-CM.pdf";
            File fichero = new File(Rut);
            if (!fichero.exists()) fichero = new File(Camara);

            Calendar limitDate = new GregorianCalendar();
            limitDate.setTimeInMillis(fichero.lastModified());
            limitDate.add(Calendar.MONTH, 2);
                        
            Calendar nowDate = new GregorianCalendar();

            if (!fichero.exists() || (fichero.lastModified() != 0L && nowDate.after(limitDate))) {
                %><script><%
                if (fichero.lastModified() != 0L && nowDate.after(limitDate)) {
                    limitDate.add(Calendar.MONTH, -2);
                    String monthName = limitDate.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("es","CO"));
                    monthName = monthName.substring(0,1).toUpperCase() + monthName.substring(1);

                    %>
                      alert('La vigencia del documento ha superado los 60 dias.\n'
                      + 'El último documento fue cargado el <%=limitDate.get(Calendar.DAY_OF_MONTH)%> de <%=monthName%> de <%=limitDate.get(Calendar.YEAR)%>\n'
                      + 'Por favor vuelva a cagar el documento.');
                    <%
                }
                    
                %>
                    window.location = 'solicitarDoc?redir=y';
                <%
                %></script><%
                return;
            }

            mensaje=request.getParameter("mensaje");
            if(mensaje == null){
                mensaje="";
            } else if (mensaje.equals("0")) {
                mensaje = "Ha ocurrido un error al intentar publicar la vacante. Por favor intente más tarde.";
            } else if (mensaje.equals("1")) {
                mensaje = "La fecha de vencimiento no debe sobrepasar los 3 meses después de la publicación de esta vacante.";
            } else if (mensaje.equals("2")) {
                mensaje = "Usted no ha escogido ningun programa académico.";
            } else if (mensaje.equals("3")) {
                mensaje = "Su vacante ha sido enviada satisfactoriamente.";
                msgReturnError = false;
            } else {
                mensaje = "";
            }
            
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            
            emp.inicializar(usuario);
            session.setAttribute("emp",emp);
            
            HashMap[] programas= emp.getListaProgramas();
            HashMap[] paises=emp.getpaises();
            HashMap pais;
            int pa = paises.length;
            
            HashMap[] sectores = emp.getSectores();
            HashMap[] municipio = emp.getMunicipios();
            HashMap muni;
            int mu = municipio.length;
            //HashMap id = emp.docgrad(usuario);
            //doc_grad = (String)id.get("id_documento");
            //HashMap datos = emp.datosGeneralesGrd(doc_grad);
            //HashMap datosAC= emp.programaacademico(doc_grad);
            String  error = new String();

            //String paramtext = new String();
            //String mensajeest = new String("No tiene ninguna solicitud en tramite ");
            
            //est = estado.get("estado");
            String arreglo[]=new String[50];
            String texto[]=new String[20];
            String noticias[]=new String[200];
            //String noti[]=new String[20];
            int i=0, not=0;
            int conmenu = 0;
            int k=0;
            
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
        <title>SIEMPREG - Nueva vacante</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEmpEgre.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
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
    
    <body <%=mensaje.equals("")?"onload=\"vernuevaofertaegre();\"":""%>>
        <jsp:include page="header">
            <jsp:param name="type" value="emp" />
        </jsp:include>
        <table width="700" align="center" class="curvas loginPanel" cellspacing="10">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        Publicación de nueva vacante
                    </div>
                </td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td valign="top" style="padding-right: 10px;">
                <table width="200" border="0"  cellspacing="0" bordercolor="#EEEBFC">
                    <tr>
                        <td width="200" height="20"  class="textocom">
                            <div class="panelSubMenu" align="center">
                                Sistema de Graduados
                            </div>
                        </td>
                    </tr>
                    <%
                        if(error.equals("OK")) {
                            for (int j=0; j<i; j++) {
                                StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                k=0;
                                while (st.hasMoreTokens()) {
                                    texto[k]=st.nextToken();
                                    k = k + 1;
                                }

                                if(Contacto.equals("0")?texto[0].equals("1"):texto[0].equals("5")){
                    %>
                                        <tr>
                                             <td width="200"  height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM"  >
                                                <div align="left">
                                                    <a onclick="<%=texto[3]%>" class="menuprueba">
                                                    <font id="f<%=conmenu%>" color="#000000"><%=texto[2]%> </font></a>
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
                <td align="center" style="box-shadow: -5px 5px 5px 5px rgba(0,0,0,0.1);">
                    <table width="490" border="0"  cellspacing="0">
                        <%if (!mensaje.equals("")) {%>
                        <tr>
                            <td colspan="2" align="center" class="textocom2" style="padding-top: 10px;">Resultado de la operación:</td>
                        </tr>
                        <tr>
                            <td colspan="2" align="left" class="textocom" style="padding-top: 10px;"><div id="mensajeReg"><%=mensaje%></div></td>
                        </tr>
                            <%if (msgReturnError) {%>
                            <tr>
                                <td colspan="2" align="center" class="textocom" style="font-size: 12px; padding-top: 10px; cursor: pointer;"><a href="javascript:history.back()" onmouseover="this.style.textDecoration='underline';" onmouseout="this.style.textDecoration='none';">Volver a la publicación</a></td>
                            </tr>
                            <%}%>
                        <%}%>
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom">
                                <form name="fromprogramas" action="" method="POST">
                                <div align="left" id="FormOfertaGrad" style="display: none">
                                    <table width="100%" style="text-align: left;">
                                        <tr style="height: 32px;"></tr>
                                        <tr>
                                            <td colspan="2"><div align="center"><a class="textocom3">Registro de nueva vacante</a></div></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <p>
                                                <img name="informacion" src="imagenes/Info_Simple.png" width="12" height="12" border="0" alt=""> = Información Importante (Poner mouse encima)
                                                </p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><div align="left"><a class="textocom2"><strong>Datos generales de la vacante</strong></a><br></div></td>
                                        </tr>
                                        <tr>
                                          <td style="width: 50%;">Nombre del cargo:</td>
                                          <td><input class="inputlargo" name="nomcargonog" id="nomcargonog" type="text" size="20" maxlength="100"></td>
                                        </tr>
                                        <tr style="height: 10px;"></tr>
                                        <tr>
                                            <td>Numero de Vacantes:</td>
                                            <td><input class="inputsupercorto" name="vacnog" id="vacnog" type="number" min="1" size="20"> (Solo números)</td>
                                        </tr>
                                        <tr style="height: 10px;"></tr>
                                        <tr>
                                            <td colspan="2">
                                                <a onmousemove="show('CargoDesc',event);" onmouseout="hide('CargoDesc');">
                                                <img name="informacion" src="imagenes/Info_Simple.png" width="12" height="12" border="0" alt="">
                                                </a>
                                                Descripción del cargo:
                                            </td>
                                        </tr>
                                        <tr>
                                            <div id="CargoDesc" class="tooltipbox">
                                                <a class='textoinfo'>Indique el área en el cual se desempeñará el profesional, las funciones a realizar y las especificaciones adicionales que considere pertinentes del cargo.</a>
                                            </div>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center">
                                                <textarea name="descripcionnog" id="descripcionnog" maxlength="4500" onkeyup="showCharCount('descCharLeft', this, this.getAttribute('maxlength'));" placeholder="Escriba la descripción..."></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td id="descCharLeft" colspan="2" align="right" style="font-size: 10px;">Quedan 4500 caracteres</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <a onmousemove="show('ReqDes',event);" onmouseout="hide('ReqDes');">
                                                <img name="informacion" src="imagenes/Info_Simple.png" width="12" height="12" border="0" alt="">
                                                </a>
                                                Requisitos:
                                            </td>                                      
                                        </tr>
                                        <tr>
                                            <div id="ReqDes" class="tooltipbox">
                                                <a class='textoinfo'>Indique las habilidades, competencias personales y técnicas del profesional.</a>
                                            </div>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center">
                                                <textarea name="Requisitosnog" id="Requisitosnog" maxlength="4500" onkeyup="showCharCount('reqCharLeft', this, this.getAttribute('maxlength'));" placeholder="Escriba los requisitos..."></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td id="reqCharLeft" colspan="2" align="right" style="font-size: 10px;">Quedan 4500 caracteres</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                Idiomas requeridos (Opcional):
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center">
                                                <textarea name="idiomReqG" id="idiomReqG" maxlength="4500" onkeyup="showCharCount('idiomReqCharLeft', this, this.getAttribute('maxlength'));" placeholder="Escriba los idiomas que se requieren en ésta vacante..."></textarea>
                                            </td>
                                        </tr>
                                         <tr style="height: 10px;"></tr>
                                        <tr>
                                            <td colspan="2">Nivel de Estudios Requeridos:</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <div  style="width: 99%;">
                                                                <input class="inputsupercorto"  type="checkbox" name="estudiosreq" value="6" >Universitario<br>
                                                                <input class="inputsupercorto"  type="checkbox" name="estudiosreq" value="7" >Especialización<br>
                                                                <input class="inputsupercorto"  type="checkbox" name="estudiosreq" value="8" >Maestría<br>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td id="idiomReqCharLeft" colspan="2" align="right" style="font-size: 10px;">Quedan 4500 caracteres</td>
                                        </tr>
                                        <tr>
                                            <td>País:</td>
                                            <td>
                                                <select class="inputmediano" name="paisnog" id="paisnog">
                                                    <%
                                                        for(int cont = 0; cont < pa; cont++) {
                                                            pais=paises[cont];
                                                    %>
                                                        <option value="<%=pais.get("cod_pai")%>" <%=((String) pais.get("cod_pai")).equals("COL")?"selected":""%>><%=pais.get("nom_pai")%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr style="height: 10px;"></tr>
                                        <tr>
                                            <td>Municipio(s) de Oferta:<br><br><font color="red">Seleccione uno o varios* <br> (*presionando tecla Ctrl)</font></td>
                                            
                                            <!--<td><input class="inputmediano" name="ciudadnog" id="ciudadnog" type="text" size="20" maxlength="50"></td>-->
                                            <td align="left">
                                                <div id="room_fileds"><div class="content">
                                                        <select multiple class="inputlargo" name="ciudadnog" id="ciudadnog" size="10">
                                                    <%
                                                        for(int cont = 0; cont < mu; cont++) {
                                                            muni=municipio[cont];
                                                    %>
                                                        <option value="<%=muni.get("CodigoDANE")%>"><%=muni.get("MuniDepto")%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr style="height: 10px;"></tr>
                                        <tr>
                                            <td align="left">Sector</td>
                                            <td align="left">
                                                <select class="inputmediano" name="areanog" id="areanog">
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
                                            <td align="left">Salario:</td>
                                            <td align="left"> Entre <select class="inputgraduado"  name="salarionog" id="salarionog">                                                    
                                                    <option value="1.500.000 y 2.000.000">1.500.000 y 2.000.000</option>
                                                    <option value="2.000.000 y 3.000.000">2.000.000 y 3.000.000</option>
                                                    <option value="3.000.000 y 4.000.000">3.000.000 y 4.000.000</option>
                                                    <option value="4.000.000 y 5.000.000">4.000.000 y 5.000.000</option>
                                                    <option value="5.000.000 y 6.000.000">5.000.000 y 6.000.000</option>
                                                    <option value="6.000.000 y 7.000.000">6.000.000 y 7.000.000</option>
                                                    <option value="7.000.000 y 8.000.000">7.000.000 y 8.000.000</option>
                                                    <option value="8.000.000 y 10.000.000">8.000.000 y 10.000.000</option>
                                                    <option value="mas de 10.000.000">Mas de 10.000.000</option>
                                                </select> de pesos
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a onmousemove="show('FecLimDes',event);" onmouseout="hide('FecLimDes');">
                                                <img name="informacion" src="imagenes/Info_Simple.png" width="12" height="12" border="0" alt="">
                                                </a>
                                                Fecha límite para aplicar:
                                            </td>
                                            <td><input class="inputcorto" name="fechaoutnog" id="fechaoutnog" type="text" size="20"> (dd/mm/aaaa)</td>
                                        </tr>
                                        <tr>
                                            <div id="FecLimDes" class="tooltipbox">
                                                <a class='textoinfo'>La fecha límite para aplicar debe ser máximo tres meses a partir de la fecha de publicación de la vacante.</a>
                                            </div>
                                        </tr>
                                        <tr>
                                            <td>Jornada laboral:</td>
                                            <td align="left" ><select class="inputgraduado"  name="horarionog" id="horarionog">
                                                    <option value="Tiempo Completo">Tiempo Completo</option>
                                                    <option value="Medio Tiempo">Medio Tiempo</option>
                                                    <option value="Otro">Otro</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Tipo de contrato:</td>
                                            <td align="left" ><select class="inputgraduado"  name="contratonog" id="contratonog">
                                                    <option value="Termino Fijo">Término fijo</option>
                                                    <option value="Termino indefinido">Término indefinido</option>
                                                    <option value="Prestación de servicios">Prestación de servicios</option>
                                                    <option value="Otro">Otro</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Años de experiencia:</td>
                                            <td><input class="inputsupercorto" name="anosexpnog" id="anosexpnog" type="text" size="20" > (Solo números)</td>
                                        </tr>
                                        <tr style="height: 32px;"></tr>
                                     
                                        <tr>
                                            <td colspan="2"><a class="textocom2"><strong>Programas académicos a los que va dirigida la vacante</strong></a> </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">Por favor seleccione los programas académicos de los graduados a los que va dirigida la vacante:</td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td colspan="2" style="font-weight: bold;">Programas de Pregrado:</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <div  style="width: 99%;">
                                                    <%
                                                        for(HashMap programa: programas) {
                                                           // programa=programas[cont];
                                                            if (((String) programa.get("tip_prog")).equals("1")) {
                                                    %>
                                                                <input class="inputsupercorto"  type="checkbox" name="programas" value="<%=programa.get("nom_prog")%>"><%=programa.get("nom_prog")%><br>
                                                    <%      }
                                                        }
                                                    %>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td colspan="2" style="font-weight: bold;">Programas de Especialización:</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <div  style="width: 99%;">
                                                    <%
                                                        for(HashMap programa: programas) {
                                                            if (((String) programa.get("tip_prog")).equals("3")) {
                                                    %>
                                                                <input class="inputsupercorto"  type="checkbox" name="programas" value="<%=programa.get("nom_prog")%>" ><%=programa.get("nom_prog")%><br>
                                                    <%      }
                                                        }
                                                    %>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td colspan="2" style="font-weight: bold;">Programas de Maestría:</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <div  style="width: 99%;">
                                                    <%
                                                        for(HashMap programa: programas) {
                                                            if (((String) programa.get("tip_prog")).equals("4")) {
                                                    %>
                                                                <input class="inputsupercorto"  type="checkbox" name="programas" value="<%=programa.get("nom_prog")%>" ><%=programa.get("nom_prog")%><br>
                                                    <%      }
                                                        }
                                                    %>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr style="height: 20px;"></tr>
                                        <tr>
                                        <tr>
                                            <td>¿Aplica el teletrabajo a la vacante que está próxima a publicar?</td>
                                            <td align="left" ><select class="inputgraduado"  name="teletrabajonog" id="teletrabajonog">
                                                    <option value="1">SI</option>
                                                    <option value="0">NO</option>
                                                </select>
                                                <br>
                                            </td>
                                        </tr>
                                        <tr style="height: 10px;"></tr>
                                        <tr>
                                        <tr>
                                            <td>¿Puede una persona en condición de discapacidad aplicar a la vacante laboral?</td>
                                            <td align="left" ><select class="inputgraduado"  name="discapacidadnog" id="discapacidadnog">
                                                    <option value="1">SI</option>
                                                    <option value="0">NO</option>
                                                </select>
                                                <br>
                                            </td>
                                        </tr>
                                        <tr style="height: 10px;"></tr>
                                        <tr>
                                        <tr>
                                            <td>¿Desea que la vacante sea visible a los graduados?</td>
                                            <td align="left" ><select class="inputgraduado"  name="excepcionpubnog" id="excepcionpubnog">
                                                    <option value="S">SI</option>
                                                    <option value="N">NO</option>
                                                </select>
                                                <br>
                                            </td>
                                        </tr>
                                        <tr style="height: 32px;"></tr>
                                    <tr style="height: 16px;"></tr>
                                    <tr>
                                       <td  colspan="2">
                                          <div align="center"><input class="button_azul_consulta1" type="submit" value="Publicar" name="nuevaofer" onclick= "return Registrarofertagrad('<%=usuario%>','<%=Contacto%>');"/></div>
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
                        <jsp:param name="type" value="grad" />
                    </jsp:include>
                </td>
            </tr>
        </table>                       
    </body>
</html>


