<%-- 
    Document   : ActualizarInfoGradAdmin
    Created on : 16/11/2012, 03:42:50 PM
    Author     : Luis Alberto Salas
--%>


<%@page import="BDsige.EstudiantesRemote"%>
<%@page import="clientecampus.ConsultaPersonas"%>
<%@page import="BDsige.graduadoRemote"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
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
        
        String rol = new String ();
        String usuario = new String ();
        String doc_grad = new String ();
        String perfil = new String ();
        
        String error = new String();
        
        login.SessionUsrRemote admin = null;;
        
        try {
            admin = (login.SessionUsrRemote) session.getAttribute("usuario");
        } catch (Exception e) {
            %>
                <script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loginAdmin';
                </script>
            <%
        }
        
        if (admin == null) {
            %>
                <script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loginAdmin';
                </script>
            <%
            return;
        }
        
        usuario = admin.getUser();
        rol = admin.getRol();

        inicio.conectaEJB conEjb = new inicio.conectaEJB();
        graduadoRemote emp = conEjb.lookupgraduadoRemote();
        emp.inicializar("75107740");
        session.setAttribute("emp", emp ) ;
        
        
        HashMap id = emp.docgrad(request.getParameter("id_est"));
        doc_grad = (String)id.get("id_documento");;
        
        //Se consulta la persona en campus
        EstudiantesRemote est = conEjb.lookupEstudiantesRemote();
        est.inicializar("75107740");
        est.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "GRADUADO"));
        est.ActDatosEgreDesdeCampus(doc_grad);
        HashMap datos = emp.datosGeneralesGrd(doc_grad);
        HashMap datoExpPrincipal = emp.getExpPrincipal(doc_grad);
        HashMap[] datosAC= emp.programaacademico(doc_grad);
        HashMap datoAC=datosAC[0];
        int nump=datosAC.length;
        
        HashMap[] paises = emp.getpaisesgrad();
        
        HashMap[] ciudades = emp.getciudadesgrad();
        
        //HashMap Prom = emp.getFechaGrado(doc_grad);
        
        perfil = (String) datos.get("perfil");
    %>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>SIEMPREG - Actualizar Graduado</title>
        <script type="text/javascript">
            function funcion(id){
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
        <script language="javascript" type="text/javascript" src="jscript/graduados/FunEgre.js" ></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link href="CSS/comun.css" rel="stylesheet" type="text/css">
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
    <body background="imagenes/fondo.gif" onload="ver();" >
        <jsp:include page="header">
            <jsp:param name="type" value="admin" />
        </jsp:include>
        <table width="640" align="center" class="curvas loginPanel" cellspacing="10">
            <tr class="textocom">              
                <td width="430" valign="top"><div align="center"><font color="#990000"><strong></strong></font></div></td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td align="center">
                    <table border="0" cellspacing="0" style="width: 100%;">
                        <tr>
                            <td align="center"valign="top" height="500" class="textocom">
                                <div align="center" id="ActDatos" style="display:inline">
                                    <form action="ActDatosEgre2" method="Post">
                                        <input type="hidden" name="docegre" value="<%=datos.get("documento")%>">
                                        <input type="hidden" name="perfil" value="<%=perfil%>">
                                    <table width="99%">
                                        <tr>
                                            <td colspan="2" style="font-weight: bold; text-decoration: underline; text-align: left;">
                                                Información General
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td align="left" width="40%">Nombre:</td>
                                            <td align="left" width="60%"><%=datoAC.get("nom_est")%></td>
                                        </tr>
                                        <tr>
                                            <td align="left">Identificación:</td>
                                            <td align="left"><%=datos.get("documento")%></td>
                                        </tr>
                                        <tr>
                                            <td align="left">Programa: </td>
                                            <td align="left">
                                                <%
                                                    for (int i = 0; i < nump; i++) {
                                                        datoAC = datosAC[i];
                                                %>
                                                    <%=">> "+datoAC.get("nom_prog")+" Fec_Grad: "+datoAC.get("pgrad")%><br>
                                                <%
                                                    }
                                                %>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td align="left">Número de Tarjeta Profesional:</td>
                                            <td align="left"><input class="inputlargo" name="num_trj" id="num_trj" type="text" size="20" value="<%=datos.get("num_ta_profesional")%>"></td>
                                        </tr>
                                        <tr>
                                            <td align="left">Estado Civil:</td>
                                            <td align="left">
                                                <select class="inputlargo"  name="estcivil" id="estcivil">
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
                                            <td align="left"><input class="inputlargo" name="nomcortoes" id="nomcortoes" type="text" size="50" value="<%=datos.get("nomcortoes")%>"></td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td align="left">Graduado fallecido:</td>
                                            <td align="left"><input type="checkbox" id="fallecido" <%=((String) datos.get("fallecido")).equals("0")?"":"checked=\"true\""%> style="width: 10px;"> Fallecido</td>
                                        </tr>
                                        <tr style="height: 32px;"></tr>
                                        <tr>
                                            <td colspan="2" style="font-weight: bold; text-decoration: underline; text-align: left;">
                                                Información de Contacto
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td align="left">País de Residencia:</td>
                                            <td align="left">
                                                <select class="inputlargo" id="pais_res" onchange="ver();">
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
                                            <td align="right">Ciudad de Residencia: </td>
                                            <td>
                                                <select class="inputmediano" name="ciudad_res" id="ciudad_res">
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
                                            <td align="left">Teléfono de Residencia:</td>
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
                                        <tr style="height: 32px;"></tr>
                                        <tr style="display: none;">
                                            <td colspan="2" style="font-weight: bold; text-decoration: underline; text-align: left;">
                                                Perfil Profesional
                                            </td>
                                        </tr>
                                        <tr style="display: none;">
                                            <td align="center" colspan="2">
                                                <textarea name="perfil" id="perfil" rows="10" style="width: 100%;" readonly disabled><%=perfil%></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" style="text-align: center;">
                                                <div align="center">
                                                    <!--<input type="submit" class="button_rojo" value="Actualizar" name="ActdatosEgre" onclick="javascript:ActualizarDatEgre(<%=doc_grad%>);" />-->
                                                    <input type="submit" class="button_rojo" value="Actualizar" name="ActdatosEgre"/>
                                                    <input type="submit" class="button_rojo" value="Cerrar" name="ActdatosEgre" onclick="window.close();" />
                                                </div>
                                            </td> 
                                        </tr>
                                    </table>
                                   </form>
                                                    
                                    <table>
                                            
                                        <tr style="height: 32px;"></tr>
                                        <tr>
                                            <td colspan="2" style="font-weight: bold; text-decoration: underline; text-align: left;">
                                                Experiencia laboral principal
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td colspan="2">
                                                <span style="text-align: left; font-size: 12px;">
                                                    La experiencia laboral principal es aquella que el graduado ejerce actualmente de manera principal.
                                                </span>
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td align="left">Nombre Empresa:</td>
                                            <td align="left"><input class="inputlargo" name="nom_emp" id="nom_emp" type="text" size="50" value="<%=datoExpPrincipal.get("nom_empresa") == null?"":datoExpPrincipal.get("nom_empresa")%>"></td>
                                        </tr>
                                        <tr>
                                            <td align="left" >Empresa propia:</td>
                                            <td align="left">
                                                <select class="inputmediano" name="emp_propia" id="emp_propia">
                                                    <option value="False" <% if (datoExpPrincipal.get("propia") != null && datoExpPrincipal.get("propia").equals("0")) {%>selected<%}%>>No</option>
                                                    <option value="True" <% if (datoExpPrincipal.get("propia") != null && datoExpPrincipal.get("propia").equals("1")) {%>selected<%}%>>Si</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="left">Cargo:</td>
                                            <td align="left"><input class="inputlargo" name="cargo" id="cargo" type="text" size="50" value="<%=datoExpPrincipal.get("cargo") == null?"":datoExpPrincipal.get("cargo")%>"></td>
                                        </tr>
                                        <tr>
                                            <td align="left">Teléfono:</td>
                                            <td align="left"><input class="inputlargo" name="tel_emp" id="tel_emp" type="text" size="50" value="<%=datoExpPrincipal.get("tel_emp") == null?"":datoExpPrincipal.get("tel_emp")%>"></td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td colspan="2">
                                                <div align="center">
                                                    <input type="submit" class="button_rojo" value="Registrar nueva" name="RegExpPrincipal" style="width: 230px;" onclick="newExpPrincipal(<%=doc_grad%>);" />
                                                </div>
                                            </td> 
                                        </tr>
                                        <%
                                            if (rol.equals("2")) {
                                        %>
                                        <tr style="height: 32px;"></tr>
                                        <tr>
                                            <td colspan="2" style="font-weight: bold; text-decoration: underline; text-align: left;">
                                                Restablecer contraseña
                                            </td>
                                        </tr>
                                        <tr style="height: 16px;"></tr>
                                        <tr>
                                            <td colspan="2">
                                                <div align="center">
                                                    <input type="submit" class="button_rojo" value="Restablecer contraseña" name="ActdatosEgre" style="width: 230px;" onclick="reiniciarpassGrad(<%=datos.get("documento")%>);" />
                                                </div>
                                            </td> 
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
