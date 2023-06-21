<%-- 
    Document   : ActualizarInfoEmp
    Created on : 19/10/2012, 09:54:45 AM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EmpresaRemote"%>
<%@page import="java.util.*, java.io.File, java.text.SimpleDateFormat"%>
<%@page import="documentos.RutaDoc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache");
            String usuario = new String();
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
            
            usuario = empresa.getUser();
            Contacto = empresa.getUserCont();
            
            if (!Contacto.equals("0")) {
                %><script>
                    alert("Los contactos no están autorizados para modificar los datos de su empresa.");
                    window.location = 'MenuEmpContactos';
                  </script><%
                return;
            }
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EmpresaRemote emp = conEjb.lookupEmpresaRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp",emp);

            //Se consulta organizacion en Campus
            ConsultaOrganizaciones.ConsultaOrganizacionNit(usuario);
            //emp.getOrganizacion(usuario);

            HashMap datos = emp.datosGeneralesemp(usuario);   
            HashMap[] paises=emp.getpaises();
            HashMap pais;
            int pa = paises.length;
            
            //Verificamos existencia y vigencia del documento adjuntado
            String Rut = new RutaDoc("Doc_Emp_Sige").getRuta() + "Rut-" + usuario + "-CM.pdf";
            String Camara = new RutaDoc("Doc_Emp_Sige").getRuta() + "Cam-" + usuario + "-CM.pdf";
            
            File rutFile = new File(Rut);
            File camFile = new File(Camara);
            
            String lastMRut = "";
            String lastMCam = "";
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            if (rutFile.exists()) {
                Calendar rutDate = new GregorianCalendar();
                rutDate.setTimeInMillis(rutFile.lastModified());
                lastMRut = sdf.format(rutDate.getTime());
            }
            
            if (camFile.exists()) {
                Calendar camDate = new GregorianCalendar();
                camDate.setTimeInMillis(camFile.lastModified());
                lastMCam = sdf.format(camDate.getTime());
            }
            
            //nom_est, tel_residencia, dir_residencia, email, cel, ciudad_residencia, perfil
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Actualizar Datos</title>
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
    <body>
    <jsp:include page="header">
        <jsp:param name="type" value="emp" />
    </jsp:include>
        <table width="640" align="center" class="curvas loginPanel" cellspacing="10">
            <tr class="textocom">
                <td colspan="2">
                    <div align="center" class="panelSubTitulo">
                        Actualizar Datos de la Empresa
                    </div>
                </td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td>
                    <table width="100%" border="0"  cellspacing="0" style=" border-color:#ddddff">
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom">
                                <div align="left" id="tablaconsultaEstEgre" style="display: inline;">
                                    <table width="100%" border="0" class="tabla" id="tablaestudiosEgre" align="center" >
                                        <tr>
                                            <td height="92">
                                                <div align="left">
                                                    <table width="100%" align="left">
                                                        <tr style="height: 16px;"></tr>
                                                        <tr class="textocom">
                                                            <td colspan="2">
                                                                <div align="center" class="panelSubMenu">
                                                                    Datos Generales de la Empresa
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Tipo ID:</td>
                                                            <td align="left"><select class="inputgraduado" name="tipoid" id="tipoid">
                                                                    <option value="1">NIT</option>
                                                                    <option value="2">Cédula de Ciudadanía</option>
                                                                    <option value="3">Cédula de Extranjería</option>
                                                                    <option value="4">Pasaporte</option>
                                                                    <option value="5">RUT</option>
                                                                </select>
                                                            </td>
                                                        </tr>    
                                                        <tr>
                                                            <td align="right">ID:</td>
                                                            <td>
                                                                <input class="inputmediano" name="nit" id="nit" type="text" size="20" maxlength="25" value="<%=datos.get("nit")%>" disabled>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Razón Social:</td>
                                                            <td>
                                                                <input class="inputlargo"name="rasocial" id="rasocial" type="text" size="20"   value="<%=datos.get("razon_social")%>">
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">País de la empresa:</td>
                                                            <td>
                                                                <select class="inputmediano" name="paisemp" id="paisemp">
                                                                    <%
                                                                       for(int cont = 0; cont < pa; cont++) {
                                                                         pais = paises[cont];
                                                                    %>
                                                                    <option value="<%=pais.get("cod_pai")%>"<%=((String) datos.get("pais_empresa")).equals((String) pais.get("cod_pai"))?" selected":""%>> <%=pais.get("nom_pai")%></option>
                                                                    <%
                                                                       }
                                                                    %>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Ciudad de la empresa: </td>
                                                            <td>
                                                                <input class="inputmediano"name="ciudademp" id="ciudademp" type="text" size="20" maxlength="25"  value="<%=datos.get("ciudad_empresa")%>" >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Dirección de la empresa:</td>
                                                            <td>
                                                                <input class="inputmediano"name="diremp" id="diremp" type="text" size="20" maxlength="25" value="<%=datos.get("dir_empresa")%>" >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Página web:</td>
                                                            <td>
                                                                <input class="inputlargo"name="webemp" id="webemp" type="text" size="20"  value="<%=datos.get("web_empresa")%>" >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Email de la empresa:</td>
                                                            <td>
                                                                <input class="inputlargo"name="emailemp" id="emailemp" type="text" size="20" value="<%=datos.get("email_empresa")%>"  >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Teléfono de la empresa:</td>
                                                            <td>
                                                                <input class="inputmediano"name="telemp" id="telemp" type="text" size="20" maxlength="25" value="<%=datos.get("tel_empresa")%>"  >
                                                            </td>
                                                        </tr>
                                                        <tr style="height: 16px;"></tr>
                                                        <tr class="textocom">
                                                            <td colspan="2">
                                                                <div align="center" class="panelSubMenu">
                                                                    Datos de Recursos Humanos
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr style="height: 16px;"></tr>
                                                        <tr>
                                                            <td align="right">Nombre del Jefe de RRHH:</td>
                                                            <td>
                                                                <input class="inputlargo"name="nomrrhh" id="nomrrhh" type="text" size="20" value="<%=datos.get("nom_rrhh")%>" >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Teléfono RRHH:</td>
                                                            <td>
                                                                <input class="inputmediano"name="telrrhh" id="telrrhh" type="text" size="20" value="<%=datos.get("tel_rrhh")%>" >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Email RRHH:</td>
                                                            <td>
                                                                <input class="inputlargo"name="emailrrhh" id="emailrrhh" type="text" size="20"  value="<%=datos.get("email_rrhh")%>">
                                                            </td>
                                                        </tr>
                                                        <tr style="height: 16px;"></tr>
                                                        <tr class="textocom">
                                                            <td colspan="2">
                                                                <div align="center" class="panelSubMenu">
                                                                    Datos de Contacto
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr style="height: 16px;"></tr>
                                                        <tr>
                                                            <td align="right">Nombre del contacto:</td>
                                                            <td>
                                                                <input class="inputlargo"name="nomconte" id="nomconte" type="text" size="20"  value="<%=datos.get("nom_contacto")%>" >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Cargo en la empresa:</td>
                                                            <td>
                                                                <input class="inputlargo"name="cargoconte" id="cargoconte" type="text" size="20" value="<%=datos.get("cargo_contacto")%>" >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Área:</td>
                                                            <td>
                                                                <input class="inputlargo"name="areaconte" id="areaconte" type="text" size="20" value="<%=datos.get("area_contacto")%>"  >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Profesión:</td>
                                                            <td>
                                                                <input class="inputlargo"name="profconte" id="porfconte" type="text" size="20"value="<%=datos.get("profesion_contacto")%>"  >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Teléfono:</td>
                                                            <td>
                                                                <input class="inputmediano"name="telconte" id="telconte" type="text" size="20" value="<%=datos.get("tel_contacto")%>"  >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Fax:</td>
                                                            <td>
                                                                <input class="inputmediano"name="faxconte" id="faxconte" type="text" size="20" maxlength="25" value="<%=datos.get("fax_contacto")%>"  >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Email:</td>
                                                            <td>
                                                                <input class="inputlargo"name="emailconte" id="emailconte" type="text" size="20"  value="<%=datos.get("email_contacto")%>" >
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Celular:</td>
                                                            <td>
                                                                <input class="inputmediano"name="celconte" id="celconte" type="text" size="20" maxlength="25"  value="<%=datos.get("cel_contacto")%>">
                                                            </td>
                                                        </tr>
                                                        <tr style="height: 16px;"></tr>
                                                        <tr class="textocom">
                                                            <td colspan="2">
                                                                <div align="center" class="panelSubMenu">
                                                                    Documentos de la empresa
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr style="height: 16px;"></tr>
                                                        <tr>
                                                            <td align="right">RUT:</td>
                                                            <td>
                                                                <%=(rutFile.exists()?"Cargado el " + lastMRut:"Documento no cargado.")%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Cámara de comercio:</td>
                                                            <td>
                                                                <%=(camFile.exists()?"Cargado el " + lastMCam:"Documento no cargado.")%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2" align="center">
                                                                <input class="inputlargo" type="button" value="Cargue sus documentos aquí"  name="btnCargarDoc" onclick="location='solicitarDoc';"/>
                                                            </td>
                                                        </tr>
                                                        <tr style="height: 32px;"></tr>
                                                        <tr>
                                                            <td colspan="2">
                                                                <div align="center">
                                                                    <input class="inputmediano" type="submit" value="Actualizar Datos"  name="Mostrar opcuni" onclick="actuaizardatosemp();"/>
                                                                    <input class="inputmediano" type="submit" value="Regresar sin Actualizar"  name="Mostrar opcuni" onclick="location = 'MenuEmpresa';"/>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr style="height: 16px;"></tr>
                                                    </table>
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
        </table>
                                <script>
                                        document.getElementById('tipoid').value = '<%=datos.get("tipoid")%>';
                                </script>
    </body>
</html>
