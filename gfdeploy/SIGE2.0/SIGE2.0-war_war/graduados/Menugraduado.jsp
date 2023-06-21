<%--
    Document   : Menugraduado
    Created on : 19/09/2012, 10:14:17 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.graduadoRemote"%>


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
            response.setHeader("Cache-Control","no-cache");

            documentos.ruta ruta = new documentos.ruta();

            String est = new String ();
            String doc_grad = new String (); 
            String usuario = new String ();

            login.SessionGradRemote graduado =(login.SessionGradRemote)session.getAttribute("usuario");
            
            if (graduado == null) {
                %><script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'logingraduado';
                  </script><%
                return;
            }
            
            usuario=graduado.getUser();           
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            graduadoRemote emp = conEjb.lookupgraduadoRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp", emp );
            HashMap id = emp.docgrad(usuario);
            doc_grad = (String)id.get("id_documento");

            //Se consulta la persona en campus
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote est = conEjb.lookupEstudiantesRemote();
            est.inicializar("75107740");

            
            est.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "GRADUADO"));
            
            

            HashMap datos = emp.datosGeneralesGrd(doc_grad);
            HashMap[] datosAC= emp.programaacademico(doc_grad);

            if(!datos.get("vobopoliticadatos").equals("1")) {
                %>
                <script>window.location = 'VoBo_Grad';</script>
                <%
                return;
            }

            String error = new String();
            String arreglo[]=new String[50];
            String texto[]=new String[20];
            String noticias[]=new String[200];
            int i=0, not=0;
            int conmenu = 0;
            int n = 0;
            int k=0;
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
        <title>SIEMPREG - Graduados</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>
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
            
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="grad" />
        </jsp:include>

        <table width="1000" align="center" class="curvas loginPanel" cellspacing="0" style="padding: 10px;">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        <strong>Opciones Graduado</strong>
                    </div>
                </td>
            </tr>
            <tr class="textocom">
                <td style="width: 25%; vertical-align: top;">
                    <%
                    if(error.equals("OK")) {
                        for (int j=0; j<i; j++) {
                            StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                            k=0;
                            
                            while (st.hasMoreTokens()) {
                                texto[k]=st.nextToken();
                                k=k+1;
                            }
                            
                            if(texto[0].equals("0")) {
                                %>
                                <table width="95%" border="0"  cellspacing="0">
                                    <tr>
                                        <td class="menuprueba" onclick="<%=texto[4]%>;" style="height: 20px; text-align: left; vertical-align: middle; color: #000000;">
                                            <span id="f<%=conmenu%>"><%=texto[3]%></span>
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
                    <table width="100%" frame="lhs">
                        <tr>
                            <td valign="top" height="500" class="textocom" style="box-shadow: -5px 5px 5px 5px rgba(0,0,0,0.1); padding: 10px;">
                                <div align="left" id="consultaofergrad" style="display: inline">
                                    <table  width="100%"  cellspacing="0">
                                        <tr>
                                            <div align="justify">
                                                <br>
                                                Bienvenidos al Sistema de Información para Graduados de la Escuela Colombiana de Ingeniería Julio Garavito.
                                                <br><br>
                                                Con el propósito de consolidar los lazos de los graduados con la Escuela, hemos creado el Sistema de Información de Graduados,
                                                que permite actualizar la información de contacto, de estudios, laboral y familiar a través de la web.
                                                <br><br>
                                                Esperamos que este Sistema sea de utilidad y contribuya a consolidar la comunidad de graduados de la Escuela Colombiana de Ingeniería Julio Garavito
                                                <br><br><br>
                                                * Bolsa de empleo autorizada y regulada por el Ministerio de Trabajo mediante resolución No. 478 de 2016.<br><br>
                                                                Contacto: Oficina de Graduados<br>
                                                                Mail:     graduados@escuelaing.edu.co<br>
                                                                Teléfono: 6683600 ext. 120<br><br>
                                            </div>
                                        </tr>
                                    </table>
                                </div>

                                <div align="left" id="consultaofergrad" style="display: none">
                                    <table  width="440"  cellspacing="0">
                                            <tr>
                                            <p>Por favor seleccione la opcion que desea.</p>
                                            <p>
                                            <select name="tipoconsultaofergrad" id="tipoconsultaofergrad">
                                                <option value="Toda oferta">Todas las Ofertas.
                                                <option value="ofertas aplicadas">Ofertas a las que ha aplicado.
                                                <option value="ofertas no aplicadas">Ofertas a las qeu no ha aplicado.
                                             </select>
                                             </p>
                                            </tr>
                                    </table>
                                    </div>
                                <div align="left" id="botonconsultaofergrad" style="display: none">
                                    <table  width="100%"  cellspacing="0">
                                        <tr>
                                            <td style="text-align: right;"><input class="button_azul_consulta1"type="submit" value="Ofertas de su programa" name="consultar" onclick= "consultarofergrad(<%=doc_grad%>,'por programa');"/></td>
                                            <td style="text-align: left;"><input class="button_azul_consulta1" type="submit" value="Todas las ofertas" name="consultar" onclick= "consultarofergrad(<%=doc_grad%>,'Toda oferta');"/></td>
                                         </tr>
                                    </table>
                                </div>
                                    <div align="left" id="tablaofertasgrad" style="display: none">
                                      <table width="100%" border="1" class="tabla" id="tablaofergrad" align="center" style="margin-top: 16px;">
                                            <thead>
                                                <tr>                                                    
                                                    <th width="40%"><div align="center"><strong>Cargo</strong></div></th>
                                                    <th width="12%"><div align="center"><strong>Fecha de publicación</strong></div></th>
                                                    <th width="12%"><div align="center"><strong>Fecha límite para aplicar</strong></div></th>
                                                    <th width="24%"><div align="center"><strong>Rango salarial</strong></div></th>
                                                    <th width="12%"><div align="center"><strong>Estado</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpotablaofertasgrad">
                                            </tbody>
                                        </table>
                                  </div>
                                  <div align="left" id="cambiocontrasenagrad" style="display: none" valign="middle">
                                    <table  width="70%"  cellspacing="0" align="center">

                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                         <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                         </tr>
                                        <tr>
                                                  <td colspan="2" align="center">
                                                      <span class="textocom3">Cambio de Contraseña</span>
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
                                                    <input type="submit" class="button_azul" style="width: 220px;" value="Cambiar contraseña" name="cambiarcontrasena" onclick= "cambiarcontrasenagrad(<%=doc_grad%>);"/>
                                                </td>
                                           </tr>
                                    </table>
                                    </div>
                                    <div align="left" id="tablaconsultaclasificado" style="display: none">
                                        <b><u>Clasificados   Registrados____________________________</u></b>
                                           <table  width="98%" border="1" class="tabla" id="tablaMisclasificados" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="35%"><div align="center"><strong>Titulo</strong></div></th>
                                                    <th width="35%"><div align="center"><strong>Eliminar</strong></div></th>

                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoMisclacificados">
                                            </tbody>
                                        </table>
                                    <input class="inputlargo" type="submit" value="Consultar Mis Clasificados" name="consultar" onclick= "actTabMisClasificados(<%=doc_grad%>);"/>
                                    </div>
                                        <div align="center" id="clasificadoEgre" style="display: none">
                                          <table width="99%" >
                                            <tr >
                                              <td   valign="bottom" align="left" colspan="2">
                                                  <b><u>Nuevo Clacificado________________________________</u></b>
                                              </td>
                                            </tr>

                                            <tr>
                                              <td align="left" >Titulo del clasificado:</td>
                                              <td align="left" ><input class="Tituloclas"  name="Tituloclas" id="Tituloclas" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Telefono de contacto:</td>
                                              <td align="left" ><input class="Tituloclas"  name="Teloclas" id="Teloclas" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >email de contacto:</td>
                                              <td align="left" ><input class="Tituloclas"  name="emailclas" id="emailclas" type="text" size="20" ></td>
                                            </tr>
                                            <tr>
                                              <td align="left" >Clasificado</td>
                                              <td align="left" ><textarea name="cuerpoclas" id="cuerpoclas" rows="10" cols="38"></textarea></td>
                                            </tr>
                                            <tr>
                                              <td  colspan="2">
                                                <div align="center"><input type="submit" value="Registrar nuevo Clasificado" name="Actestgrad" onclick= " RegistrarClasificado(<%=doc_grad%>);"/></div>
                                              </td>
                                            </tr>
                                          </table>
                                        </div>
                                       <div align="center" id="LosclasificadoEgre" style="display: none">
                                           <b><u>Clasificados   Registrados____________________________</u></b>
                                           <table  width="98%" border="1" class="tabla" id="tablaLosclasificados" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="35%"><div align="center"><strong>Titulo</strong></div></th>

                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoLosclacificados">
                                            </tbody>
                                        </table>
                                    <input class="inputlargo" type="submit" value="Consultar todos los  Clasificados" name="consultar" onclick= "actTabLosClasificados();"/>
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