<%-- 
    Document   : ActualizarInfoGrad
    Created on : 5/10/2012, 12:30:22 PM
    Author     : Luis Alberto Salas
--%>

<%@page import="clientecampus.ConsultaPersonas"%>
<%@page import="BDsige.EstudiantesRemote"%>
<%@page import="BDsige.graduadoRemote"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;"%>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject, documentos.RutaDoc;"%>




<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache");

            documentos.ruta ruta = new documentos.ruta();

            String doc_grad = new String ();
            String perfil = new String ();
            String usuario = new String ();     

            login.SessionGradRemote graduado = (login.SessionGradRemote) session.getAttribute("usuario");

            if (graduado == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'logingraduado';
                    </script>
                <%
                return;
            }

            usuario = graduado.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            graduadoRemote emp = conEjb.lookupgraduadoRemote();
            emp.inicializar("75107740");
            
            session.setAttribute("emp", emp ) ;
            
            HashMap id = emp.docgrad(usuario);
            doc_grad = (String)id.get("id_documento");

            //Se consulta la persona en campus
            EstudiantesRemote est = conEjb.lookupEstudiantesRemote();
            est.inicializar("75107740");
            
            est.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "GRADUADO"));

            

            est.ActDatosEgreDesdeCampus(doc_grad);
            
            RutaDoc docPath = new RutaDoc("Doc_Graduado_SIGE");
            File photo = new File(docPath.getRuta() + "ph-" + doc_grad + ".jpg");
            
            HashMap datos = emp.datosGeneralesGrd(doc_grad);
            HashMap[] datosAC= emp.programaacademico(doc_grad);
            HashMap datoAC = datosAC[0];
            if(datosAC.length==0){
                datoAC.put("nom_prog", "No retornado por Campus");
                datoAC.put("nom_est", "No retornado por Campus");
            }
            
            int nump=datosAC.length;
            String error = new String();
            
            HashMap[] sectores = emp.getsectoresgrad();
            HashMap sector;
            int se = sectores.length;
            
            HashMap[] paises = emp.getpaisesgrad();
            HashMap pais;
            int pa = paises.length;
            
            HashMap[] ciudades = emp.getciudadesgrad();
            //String paramtext = new String();
            //String titulo = new String("Servicio a Administradores");
            String arreglo[] = new String[50];
            String texto[] = new String[20];
            String noticias[] = new String[200];
            int i = 0, not = 0;
            int conmenu = 0;
            int n = 0;
            int k = 0;
            try {
                FileReader ra = new FileReader(ruta.valruta() + "serviciosSIGEGrad.txt");
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
            perfil = (String) datos.get("perfil");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SIEMPREG - Actualización de Hoja de vida</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link href="CSS/graduados.css" rel="stylesheet" type="text/css">
        <style type="text/css"> 
            body { 
                background: url('imagenes/fondo graduados.jpg');
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
            
            .panelSubTitulo {
                width: 100%;
                border-top-left-radius: 20px;
                border-top-right-radius: 20px;
                border-bottom-left-radius: 5px;
                border-bottom-right-radius: 5px;
                color: #FFFFFF;
                background: rgb(0, 0, 70);
            }
            
            .noFotoTxt {
                position: relative;
                width: 100%;
                height: auto;
                top: 45%;
                color: #A7A7FF;
                text-align: center;
                font-size: 1.2em;
            }
            
            .photoImg {
                width: 125px;
                height: 162px;
                margin: 0px auto;
                border-radius: 10px;
            }
        </style>
    </head>
    <body onload="actTabExpEgre(<%=doc_grad%>); actCiudadesConPais();">
        <jsp:include page="header">
            <jsp:param name="type" value="grad" />
        </jsp:include>

        <table width="800" align="center" class="curvas loginPanel" cellspacing="0" style="padding: 10px;">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        <strong>Opciones Graduado</strong>
                    </div>
                </td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom" >
                <td style="width: 30%; vertical-align: top;">
                    <%
                    if(error.equals("OK")) {
                        for (int j=0; j < i; j++) {
                            StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                            k=0;
                            while (st.hasMoreTokens()) {
                                texto[k]=st.nextToken();
                                k=k+1;
                            }

                            if(texto[1].equals("0")) {
                                %>
                                <table width="95%" border="0"  cellspacing="0">
                                    <tr>
                                        <td height="20">
                                            <div align="left">
                                                <a class="menuprueba" onclick="<%=texto[4]%>" style="height: 20px; text-align: left; vertical-align: middle; color: #000000;">
                                                    <font id="f<%=conmenu%>" color="#000000"><%=texto[3]%> </font>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                                <%
                                conmenu = conmenu+1;
                            }
                        }
                    }
                    %>
                </td>
                <td align="center">
                    <table width="100%" cellspacing="0" frame="lhs">
                        <tr>
                            <td valign="top" height="500" class="textocom" style="box-shadow:-5px 5px 5px 5px rgba(0,0,0,0.1); padding: 10px 20px;">
                                        <div align="center" id="ActDatos" style="display:inline">
                                            <table width="99%">
                                                <tr>
                                                    <td colspan="2" style="font-weight: bold; text-decoration: underline; text-align: left;">
                                                        Información General
                                                    </td>
                                                </tr>
                                                <tr style="height: 16px"></tr>
                                                <tr>
                                                    <td align="left" width="40%">Nombre:</td>
                                                    <td align="left" width="60%"><%=datoAC.get("nom_est")%></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Identificación:</td>
                                                    <td align="left"><%=datos.get("documento")%></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Programa<%=(nump > 1)?"s":""%>:</td>
                                                    <td align="left">
                                                        <%
                                                            for (int s = 0; s < nump; s++) {
                                                                datoAC = datosAC[s];
                                                        %>
                                                                <%=(nump > 1)?"» ":""%><%=datoAC.get("nom_prog")%><br>
                                                        <%
                                                            }
                                                        %>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Número de Tarjeta Profesional:</td>
                                                    <td align="left"><input class="inputmediano"  name="num_trj" id="num_trj" type="text" size="20" value="<%=datos.get("num_ta_profesional")%>"></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Estado Civil:</td>
                                                    <td align="left">
                                                        <select class="inputmediano"  name="estcivil" id="estcivil">
                                                            <option value="Soltero(a)"<%=datos.get("est_civil").equals("Soltero(a)")?" selected":""%>>Soltero(a)</option>
                                                            <option value="Casado(a)"<%=datos.get("est_civil").equals("Casado(a)")?" selected":""%>>Casado(a)</option>
                                                            <option value="Divorciado(a)"<%=datos.get("est_civil").equals("Divorciado(a)")?" selected":""%>>Divorciado(a)</option>
                                                            <option value="Religioso"<%=datos.get("est_civil").equals("Religioso")?" selected":""%>>Religioso</option>
                                                            <option value="Separado(a)"<%=datos.get("est_civil").equals("Separado(a)")?" selected":""%>>Separado(a)</option>
                                                            <option value="Unión Libre"<%=datos.get("est_civil").equals("Unión Libre")?" selected":""%>>Unión Libre</option>
                                                            <option value="Viudo(a)"<%=datos.get("est_civil").equals("Viudo(a)")?" selected":""%>>Viudo(a)</option>
                                                       </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Fecha de Nacimiento:</td>
                                                    <td align="left"><%=datos.get("fecha_nacimiento")%></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Nombre para Comunicaciones:</td>
                                                    <td align="left"><input class="inputmediano" name="nomcortoes" id="nomcortoes" type="text" size="50" value="<%=datos.get("nomcortoes")%>"></td>
                                                </tr>
                                                
                                                <tr style="height: 32px"></tr>
                                                <tr>
                                                    <td colspan="2" style="font-weight: bold; text-decoration: underline; text-align: left;">
                                                        Información de Contacto
                                                    </td>
                                                </tr>
                                                <tr style="height: 16px"></tr>
                                                <tr>
                                                    <td align="left">País de Residencia:</td>
                                                    <td align="left">
                                                        <select class="inputlargo" id="pais_res" onchange="actCiudadesConPaisGrad();">
                                                            <option value="">Seleccione</option>
                                                            <%
                                                                for (HashMap paisItem : paises) {
                                                                    String nomPais = (String) paisItem.get("cod_pai");
                                                            %>
                                                                    <option value="<%=paisItem.get("cod_pai")%>"<%=nomPais.equalsIgnoreCase((String) datos.get("pais_residencia"))?" selected":""%>><%=paisItem.get("nom_pai")%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Ciudad de Residencia: </td>
                                                    <td>
                                                        <select class="inputmediano" name="ciudad_res" id="ciudad_res">
                                                            <option value="">Seleccione</option>
                                                            <%
                                                                HashMap ciudad;
                                                               for(int cont=0;cont<ciudades.length;cont++)
                                                             {
                                                                 ciudad=ciudades[cont];
                                                            %>
                                                                <option data-pais="<%=ciudad.get("pais")%>" value="<%=ciudad.get("cod_dane")%>" <%=((String) ciudad.get("cod_dane")).equalsIgnoreCase((String) datos.get("ciudad_residencia"))?" selected":""%>><%=ciudad.get("nom_ciu")%></option>
                                                            <%}%>

                                                       </select>
                                                        <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Dirección de Residencia:</td>
                                                    <td align="left"><input class="inputlargo" name="dir_res" id="dir_res" type="text" size="20" value="<%=datos.get("dir_residencia")%>"></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Teléfono Principal:</td>
                                                    <td align="left">
                                                        +<input class="inputsupercorto" name="tel_indicativo" id="tel_indicativo" type="text" maxlength="3" style="margin: 0px 0px 0px 5px;" value="<%=datos.get("tel_indicativo")%>">
                                                        -<input class="inputmediano" name="tel_res" id="tel_res" type="text" style="margin: 0px 0px 0px 5px;" value="<%=datos.get("tel_residencia")%>">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Número de Celular:</td>
                                                    <td align="left">
                                                        +<input class="inputsupercorto" name="cel_indicativo" id="cel_indicativo" type="text" maxlength="3" style="margin: 0px 0px 0px 5px;" value="<%=datos.get("cel_indicativo")%>">
                                                        -<input class="inputmediano" name="cel" id="cel" type="text" maxlength="20" style="margin: 0px 0px 0px 5px;" value="<%=datos.get("cel")%>">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Email:</td>
                                                    <td align="left"><input class="inputlargo" name="emails" id="emails" type="text" size="20" value="<%=datos.get("email")%>"></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Email 2:</td>
                                                    <td align="left"><input class="inputlargo" name="email2" id="email2" type="text" size="20" value="<%=datos.get("email2")%>"></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Facebook:</td>
                                                    <td align="left"><input class="inputlargo" name="social_fb" id="social_fb" type="text" size="50" value="<%=datos.get("social_fb")%>"></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Twitter:</td>
                                                    <td align="left"><input class="inputlargo" name="social_tw" id="social_tw" type="text" size="50" value="<%=datos.get("social_tw")%>"></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Instragram:</td>
                                                    <td align="left"><input class="inputlargo" name="social_insta" id="social_insta" type="text" size="50" value="<%=datos.get("social_insta")%>"></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">Google+:</td>
                                                    <td align="left"><input class="inputlargo" name="social_gplus" id="social_gplus" type="text" size="50" value="<%=datos.get("social_gplus")%>"></td>
                                                </tr>
                                                <tr>
                                                    <td align="left">LinkedIn:</td>
                                                    <td align="left"><input class="inputlargo" name="social_linkedin" id="social_linkedin" type="text" size="50" value="<%=datos.get("social_linkedin")%>"></td>
                                                </tr>
                                                <tr style="height: 32px"></tr>
                                                <tr>
                                                    <td colspan="2" style="font-weight: bold; text-decoration: underline; text-align: left;">
                                                        Perfil Profesional
                                                    </td>
                                                </tr>
                                                <tr style="height: 16px"></tr>
                                                <tr>
                                                    <td align="center" colspan="2">
                                                        <textarea name="perfil" id="perfil" rows="10" cols="38" accept-charset="UTF-8"><%=perfil%></textarea>
                                                    </td>
                                                </tr>
                                                <tr style="height: 32px"></tr>
                                                <tr>
                                                    <td colspan="2">
                                                      <div align="center"><input type="submit" class="button_azul" value="Actualizar" name="ActdatosEgre" onclick="ActualizarDatEgre(<%=usuario%>);"/></div>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div align="center" id="FotoGrad" style="display:none;">
                                            <table width="99%">
                                                <tr>
                                                    <td colspan="2" style="font-weight: bold; text-decoration: underline; text-align: left;">
                                                        Actualizar Foto
                                                    </td>
                                                </tr>
                                                <tr style="height: 32px"></tr>
                                                <tr>
                                                    <td colspan="2">
                                                        <%
                                                            if (photo.exists()) {
                                                        %>
                                                        <div class="photoImg" style="border: 1px dashed #A7A7FF;">
                                                            <img src="<%="http://tycho.escuelaing.edu.co/Doc_Graduado_SIGE/" + photo.getName()%>" style="width: 100%; height: 100%; border-radius: 10px;"/>
                                                        </div>
                                                        <%
                                                            } else {
                                                        %>
                                                        <div class="photoImg" style="border: 1px dashed #A7A7FF;">
                                                            <div class="noFotoTxt">
                                                                Sin foto
                                                            </div>
                                                        </div>
                                                        <%
                                                            }
                                                        %>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2" style="text-align: center;">(125 x 162) pixeles</td>
                                                </tr>
                                                <tr style="height: 16px"></tr>
                                                <tr>
                                                    <td colspan="2">
                                                        <span style="font-weight: bold;">Nota: </span>
                                                        El aspecto que tenga su foto en este recuadro será el mismo que tendrá en 
                                                        las hojas de vida que verán las empresas a las que usted ha aplicado.
                                                    </td>
                                                </tr>
                                                <tr style="height: 16px"></tr>
                                                <tr>
                                                    <td>
                                                        <form name="frmLoadPhoto" id="frmLoadPhoto" enctype="multipart/form-data" style="width: 100%;">
                                                            <input type="file" name="photoFile" id="photoFile" class="inputlargo" style="border: 1px solid #DDDDFF; border-radius: 5px; width: 100%;"><br>
                                                        </form>
                                                    </td>
                                                </tr>
                                                <tr style="height: 16px"></tr>
                                                <tr>
                                                    <td>
                                                        <fieldset form="formCargarFoto" style="border: 0px; text-align: center;">
                                                            <input type="submit" id="upPhoto" class="button_azul" value="Cargar foto" onclick="loadPhoto(); return false;">
                                                            <%
                                                                if (photo.exists()) {
                                                            %>
                                                            <input type="button" id="deletePhoto" class="button_azul" value="Borrar foto" onclick="deletePhoto();">
                                                            <%
                                                                }
                                                            %>
                                                        </fieldset>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div align="left" id="tablaconsultaEstEgre" style="display: none">
                                            <b><u>Estudios Registrados____________________________</u></b>
                                           <table  width="98%" border="1" class="tabla" id="tablaestudiosEgre" align="center" style="margin: 16px 0px;">
                                            <thead>
                                                <tr>
                                                    <th width="35%"><div align="center"><strong>Programa</strong></div></th>
                                                    <th width="35%"><div align="center"><strong>Institución</strong></div></th>
                                                    <th width="30%"><div align="center"><strong>Nivel de Formación</strong></div></th>
                                                    <th width="30%"><div align="center"><strong>Eliminar</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoestudiosEgre">
                                            </tbody>
                                        </table>
                                            <input type="submit" class="button_azul_consulta1" value="Consultar estudios" name="consultar" onclick="actualizarTabEstEgre(<%=doc_grad%>);"/>
                                        </div>
                                        <div align="center" id="EstEgre" style="display: none">
                                          <table width="99%" >
                                              <tr style="height: 16px;"></tr>
                                            <tr>
                                              <td valign="bottom" align="left" colspan="2">
                                                <b><u>Nuevo Estudio________________________________</u></b>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nivel de Formación:</td>
                                              <td align="left">
                                                  <select class="inputmediano" name="NivEst" id="NivEst">
                                                    <option value="Especializacion">Especialización</option>
                                                    <option value="Maestria">Maestría</option>
                                                    <option value="Doctorado">Doctorado</option>
                                                    <option value="Diplomado">Diplomado</option>
                                                    <option value="Pregrado Profesional">Pregrado Profesional</option>
                                                    <option value="Otro">Otro</option>
                                                  </select>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Programa Académico</td>
                                              <td align="left" ><input class="inputmediano"  name="prog_estgrad" id="prog_estgrad" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Título:</td>
                                              <td align="left">
                                                  <input class="inputmediano"  name="titulo_grad" id="titulo_grad" type="text" size="20" >
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left">Sector</td>
                                              <td align="left">
                                                  <select class="inputmediano" name="sector_estgrad" id="sector_estgrad">
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
                                              <td align="left" ><input class="inputmediano" name="nom_inst" id="nom_inst" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left">Pais:</td>
                                              <td align="left">
                                                  <select class="inputmediano" name="pais_estgrad" id="pais_estgrad">
                                                      <%
                                                         for (int cont = 0; cont < pa; cont++) {
                                                            pais=paises[cont];
                                                      %>
                                                            <option value="<%=pais.get("cod_pai")%>"<%=((String) pais.get("cod_pai")).equals("COL")?" selected":""%>><%=pais.get("nom_pai")%></option>
                                                      <%
                                                         }
                                                      %>
                                                 </select>
                                                  <%--<input name="pais_mov" id="pais_mov" type="text" size="20" maxlength="25">--%>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Ciudad:</td>
                                              <td align="left" ><input class="inputmediano"  name="ciudad_estgrad" id="ciudad_estgrad" type="text" size="20"></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Fecha de grado:</td>
                                              <td align="left" ><input class="inputcorto"  name="fecha_estgrad" id="fecha_estgrad" type="text" size="20" >(mm/aaaa)</td>
                                            </tr>
                                            <tr>
                                              <td  colspan="2">
                                                <div align="center"><input type="submit" class="button_azul" value="Registrar" name="Actestgrad" onclick="RegistrarEstGrad(<%=doc_grad%>);"/></div>
                                              </td>
                                            </tr>
                                          </table>
                                        </div>
                                        <div align="left" id="tablaconsultaDisEgre" style="display: none">
                                            <b><u>Distinciones Registradas__________________________</u></b>
                                           <table  width="98%" border="1" class="tabla" id="tabladistincionesEgre" align="center" style="margin: 16px 0px;">
                                            <thead>
                                                <tr>
                                                    <th width="35%"><div align="center"><strong>Nombre</strong></div></th>
                                                    <th width="35%"><div align="center"><strong>Institución</strong></div></th>
                                                    <th width="30%"><div align="center"><strong>Tipo</strong></div></th>
                                                    <th width="30%"><div align="center"><strong>Eliminar</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpodistincionesEgre">
                                            </tbody>
                                        </table>
                                             <input type="submit" class="button_azul_consulta1" value="Consultar distinciones" name="consultar" onclick="actTabDisEgre(<%=doc_grad%>);"/>
                                        </div>
                                        <div align="center" id="DisEgre" style="display: none">
                                          <table width="99%" >
                                              <tr style="height: 16px;"></tr>
                                            <tr >
                                              <td   valign="bottom" align="left" colspan="2">
                                                <b><u>Nueva Distinción________________________________</u></b>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nombre de la Distinción:</td>
                                              <td align="left" ><input class="inputmediano"  name="nom_disgrad" id="nom_disgrad" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Institución:</td>
                                              <td align="left">
                                                  <input class="inputmediano"  name="inst_disgrad" id="inst_disgrad" type="text" size="20" >
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Ámbito:</td>
                                              <td align="left"> <select class="inputmediano"  name="amb_disgrad" id="amb_disgrad">
                                                    <option value="Empresarial">Empresarial</option>
                                                    <option value="Gremial">Gremial</option>
                                                    <option value="Regional">Regional</option>
                                                    <option value="Nacional">Nacional</option>
                                                    <option value="Internacional">Internacional</option>
                                                    <option value="Otro">Otro</option>
                                                 </select>
                                            </td>
                                            </tr>
                                             <tr>
                                              <td align="left" >Tipo:</td>
                                              <td align="left"> <select class="inputmediano"  name="Tipo_disgrad" id="Tipo_disgrad">
                                                    <option value="Cientifica">Científica</option>
                                                    <option value="Profesional">Profesional</option>
                                                    <option value="Academica">Académica</option>
                                                    <option value="Otra">Otra</option>
                                                 </select>
                                            </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Fecha:</td>
                                              <td align="left" ><input class="inputcorto"  name="fecha_disgrad" id="fecha_disgrad" type="text" size="20" >(mm/aaaa)</td>
                                            </tr>
                                            <tr>
                                              <td colspan="2">
                                                <div align="center"><input type="submit" class="button_azul" value="Registrar" name="Actestgrad" onclick="RegistrarDisGrad(<%=doc_grad%>);"/></div>
                                              </td>
                                            </tr>
                                          </table>
                                        </div>
                                              <div align="left" id="tablaconsultaAfiEgre" style="display: none">
                                            <b><u>Afiliaciones Registradas__________________________</u></b>
                                           <table  width="98%" border="1" class="tabla" id="tablaafiliacionesEgre" align="center" style="margin: 16px 0px;">
                                            <thead>
                                                <tr>
                                                    <th width="35%"><div align="center"><strong>Nombre</strong></div></th>
                                                    <th width="35%"><div align="center"><strong>Tipo</strong></div></th>
                                                    <th width="30%"><div align="center"><strong>Estado</strong></div></th>
                                                    <th width="30%"><div align="center"><strong>Eliminar</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoafiliacionesEgre">
                                            </tbody>
                                        </table>
                                             <input type="submit" class="button_azul_consulta1" value="Consultar afiliaciones" name="consultar" onclick="actTabAfiEgre(<%=doc_grad%>);"/>
                                        </div>
                                        <div align="center" id="AfiEgre" style="display: none">
                                          <table width="99%" >
                                              <tr style="height: 16px;"></tr>
                                            <tr >
                                              <td   valign="bottom" align="left" colspan="2">
                                                <b><u>Nueva Afiliación________________________________</u></b>
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
                                              <td align="left">
                                                  <select class="inputcorto" name="Tipo_afigrad" id="Tipo_afigrad">
                                                    <option value="Científica">Científica</option>
                                                    <option value="Profesional">Profesional</option>
                                                    <option value="Académica">Académica</option>
                                                    <option value="Social">Social</option>
                                                    <option value="Otra">Otra</option>
                                                 </select>
                                            </td>
                                            </tr>
                                             <tr>
                                              <td align="left" >Fecha de ingreso:</td>
                                              <td align="left"> <input class="inputcorto"  name="fechaAfi" id="fechaAfi">(mm/aaaa)
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
                                              <td  colspan="2">
                                                <br><div align="center"><input type="submit" class="button_azul" value="Registrar" name="Actestgrad" onclick="RegistrarAfiGrad(<%=doc_grad%>);"/></div>
                                              </td>
                                            </tr>
                                          </table>
                                        </div>
                                        <div align="left" id="tablaconsultaIdioEgre" style="display:none">
                                            <b><u>Idiomas Registrados__________________________</u></b>
                                           <table  width="98%" border="1" class="tabla" id="tablaidiomasEgre" align="center" style="margin: 16px 0px;">
                                            <thead>
                                                <tr>
                                                    <th width="25%"><div align="center"><strong>Nombre del idioma</strong></div></th>
                                                    <th width="25%"><div align="center"><strong>Nivel de lectura</strong></div></th>
                                                    <th width="25%"><div align="center"><strong>Nivel de escritura</strong></div></th>
                                                    <th width="25%"><div align="center"><strong>Nivel de habla</strong></div></th>
                                                    <th width="25%"><div align="center"><strong>Eliminar</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoidiomasEgre">
                                            </tbody>
                                        </table>
                                             <input type="submit" class="button_azul_consulta1" value="Consultar idiomas" name="consultar" onclick="actTabIdioEgre(<%=doc_grad%>);"/>
                                        </div>
                                        <div align="center" id="idioEgre" style="display: none">
                                          <table width="99%" >
                                              <tr style="height: 16px;"></tr>
                                            <tr>
                                              <td   valign="bottom" align="left" colspan="2">
                                                <b><u>Nuevo Idioma________________________________</u></b>
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
                                                    <option value="Alto">Alto</option>
                                                    <option value="Medio">Medio</option>
                                                    <option value="Bajo ">Bajo</option>
                                                 </select>
                                            </td>
                                            </tr>
                                             <tr>
                                              <td align="left" >Nivel de escritura:</td>
                                              <td align="left"> <select class="inputcorto"  name="nivel_escriegre" id="nivel_escriegre">
                                                     <option value="Alto">Alto</option>
                                                    <option value="Medio">Medio</option>
                                                    <option value="Bajo ">Bajo</option>
                                                 </select>
                                            </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nivel de habla:</td>
                                              <td align="left"> <select class="inputcorto"  name="nivel_hablaegre" id="nivel_hablaegre">
                                                     <option value="Alto">Alto</option>
                                                    <option value="Medio">Medio</option>
                                                    <option value="Bajo ">Bajo</option>
                                                 </select>
                                            </td>
                                            </tr>
                                            <tr>
                                              <td  colspan="2">
                                                <br><div align="center"><input type="submit" class="button_azul" value="Registrar" name="ActIdigrad" onclick="RegistrarIdioGrad(<%=doc_grad%>);"/></div>
                                              </td>
                                            </tr>
                                          </table>
                                        </div>
                                        <div align="left" id="tablaconsultaExpEgre" style="display: none">
                                            <b><u>Experiencias Laborales Registradas___________</u></b><br><br>
                                           <table  width="98%" border="1" class="tabla" id="tablaExpLaboralEgre" align="center" style="margin: 16px 0px;">
                                            <thead>
                                                <tr>
                                                    <th width="40%"><div align="center"><strong>Empresa</strong></div></th>
                                                    <th width="40%"><div align="center"><strong>Cargo</strong></div></th>
                                                    <th width="20%"><div align="center"><strong>Opciones</strong></div></th>

                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoExpLaboralEgre">
                                            </tbody>
                                        </table>
                                            <span style="text-align: left; font-size: 12px;"><b>Nota:</b> La experiencia laboral principal (<img src="imagenes/grad/favorite.png" style="width: 3%; height: auto; vertical-align: middle;"/>) debe ser aquella que usted ejerce actualmente de manera principal.</span><br>
                                            <span id="InvalidMsg" style="display: none; text-align: left; font-size: 12px;"><br><b>Nota:</b> Si su experiencia laboral aparece como <span style="color: #FE2E2E;">[Inválida]</span>, debe entrar a editarla y luego actualizar la tabla, de lo contrario no aparecerá en su hoja de vida.</span><br>
                                            <input type="submit" class="button_azul_consulta1" style="width: 275px;" value="Actualizar lista de experiencias laborales" name="consultar" onclick="actTabExpEgre(<%=doc_grad%>);"/>
                                        </div>

                                        <div align="center" id="ExpLEgre" style="display: none">
                                          <table width="99%" >
                                              <tr style="height: 16px;"></tr>
                                            <tr >
                                              <td   valign="bottom" align="left" colspan="2">
                                                <b><u>Nueva Experiencia Laboral____________________</u></b>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >¿Es su empresa?:</td>
                                              <td align="left"> <select name="empropia" id="empropia">
                                                    <option value="False">No</option>
                                                    <option value="True">Si</option>
                                                 </select>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Nombre de la Empresa:</td>
                                              <td align="left" ><input class="inputmediano"  name="nom_empresaegre" id="nom_empresaegre" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Cargo:</td>
                                              <td align="left">
                                                  <input class="inputmediano"  name="cargoegre" id="cargoegre" type="text" size="20" >
                                              </td>
                                            </tr>
                                            <tr>
                                             <td align="left" >Salario:</td>
                                              <td align="left">Entre <select class="inputmediano"  name="salario_expgrad" id="salario_expgrad">
                                                    <option value="1.000.000 y 1.500.000">1.000.000 y 1.500.000</option>
                                                    <option value="1.500.000 y 2.000.000">1.500.000 y 2.000.000</option>
                                                    <option value="2.000.000 y 3.000.000">2.000.000 y 3.000.000</option>
                                                    <option value="3.000.000 y 4.000.000">3.000.000 y 4.000.000</option>
                                                    <option value="4.000.000 y 5.000.000">4.000.000 y 5.000.000</option>
                                                    <option value="5.000.000 y 6.000.000">5.000.000 y 6.000.000</option>
                                                    <option value="6.000.000 y 7.000.000">6.000.000 y 7.000.000</option>
                                                    <option value="7.000.000 y 8.000.000">7.000.000 y 8.000.000</option>
                                                    <option value="8.000.000 y 10.000.000">8.000.000 y 10?000.000</option>
                                                    <option value="mas de 10.000.000">Mas de 10.000.000</option>
                                                 </select> de pesos
                                              </td>
                                              </tr>
                                               <tr>
                                              <td align="left" >Estado:</td>
                                              <td align="left"> <select class="inputmediano"  name="estado_expegre" id="estado_expegre" onchange="setExpActualGrad();">
                                                    <option value="Finalizado">Finalizado</option>
                                                    <option value="Actual">Actual</option>
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
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >País:</td>
                                               <td align="left">
                                                  <select class="inputmediano" name="pais_expgrad" id="pais_expgrad">
                                                      <%
                                                         for(int cont=0;cont<pa;cont++) {
                                                           pais=paises[cont];
                                                      %>
                                                      <option value="<%=pais.get("cod_pai")%>"<%=pais.get("cod_pai").equals("COL")?" selected":""%>><%=pais.get("nom_pai")%></option>
                                                      <%
                                                         }
                                                      %>
                                                 </select>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Ciudad:</td>
                                              <td align="left" ><input class="inputmediano"  name="ciudad_expgrad" id="ciudad_expgrad" type="text" size="20"></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Dirección de la empresa:</td>
                                              <td align="left" ><input class="inputmediano"  name="dir_expgrad" id="dir_expgrad" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Teléfono de la empresa:</td>
                                              <td align="left" ><input class="inputmediano"  name="tel_expgrad" id="tel_expgrad" type="text" size="20"></td>
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
                                              <td align="left"><select class="inputmediano"  name="contrato_expgrad" id="contrato_expgrad">
                                                    <option value="Termino Fijo">Término fijo</option>
                                                    <option value="Termino indefinido">Término indefinido</option>
                                                    <option value="Prestación de servicios">Prestación de servicios</option>
                                                    <option value="Otro">Otro</option>
                                                 </select>
                                              </td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Horario:</td>
                                              <td align="left" ><select class="inputmediano"  name="horario_expgrad" id="horario_expgrad">
                                                    <option value="Tiempo Completo">Tiempo Completo</option>
                                                    <option value="Medio Tiempo">Medio Tiempo</option>
                                                    <option value="Otro">Otro</option>
                                                 </select></td>
                                            </tr>
                                          </table>
                                        </div>
                                        <div align="center" id="ExpLEgre2" style="display: none">
                                          <table width="99%" >
                                               <tr>
                                              <td align="left" >Funciones en el cargo:</td>
                                              <td align="left" > <textarea name="fun_expgrad" id="fun_expgrad" rows="10" cols="38" placeholder="Escriba las funciones desempeñadas..."></textarea></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Logros:</td>
                                              <td align="left" > <textarea name="logros_expgrad" id="logros_expgrad" rows="10" cols="38" placeholder="Escriba los logros alcanzados..."></textarea></td>
                                            </tr>
                                            <tr>
                                              <td  colspan="2">
                                                <div align="center"><input type="submit" class="button_azul" value="Registrar" name="ActExpgrad" onclick="RegistrarExpGrad(<%=doc_grad%>);"/></div>
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
                <td colspan="3" align="center">                             
                    <jsp:include page="footer">
                        <jsp:param name="type" value="grad" />
                    </jsp:include>
                </td>
            </tr>
        </table>
    </body>
</html>
