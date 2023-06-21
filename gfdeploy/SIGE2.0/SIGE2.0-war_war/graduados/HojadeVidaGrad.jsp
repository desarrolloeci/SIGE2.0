<%-- 
    Document   : HojadeVidaGrad
    Created on : 20/04/2016, 04:01:59 PM
    Author     : Mario Martínez
--%>

<%@page import="BDsige.graduadoRemote"%>
<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject, documentos.RutaDoc;"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache"); 

            String Funciones = new String();
            String Logros = new String();
            String doc_grad = new String();
            String usuario = new String();
            
            login.SessionGradRemote graduado =(login.SessionGradRemote)session.getAttribute("usuario");

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
            
            session.setAttribute("emp", emp );

            HashMap id = emp.docgrad(usuario);
            doc_grad = (String)id.get("id_documento");

            //Se consulta la persona en campus
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote est = conEjb.lookupEstudiantesRemote();
            est.inicializar("75107740");
            
            est.getPersona(doc_grad, null, "GRADUADO", ConsultaPersonas.consultaPersona(doc_grad, "GRADUADO"));

            
            
            RutaDoc docPath = new RutaDoc("Doc_Graduado_SIGE");
            File photo = new File(docPath.getRuta() + "ph-" + doc_grad + ".jpg");
            
            HashMap datosContacto = emp.datosContGar(doc_grad);
            
            HashMap[] ExperienciasGrad = emp.getExperienciasGrad(doc_grad);
            HashMap[] EstudiosGrad = emp.getEstudiosGrad(doc_grad);
            HashMap[] IdiomasGrad = emp.getIdiomasGrad(doc_grad);
            HashMap[] Distinciones = emp.getDistincionesGrad(doc_grad);
            HashMap[] Afiliaciones = emp.getAfiliacionesGrad(doc_grad);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG - Hoja de vida</title>
        <link href="CSS/hojadevida.css" rel="stylesheet" type="text/css">
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
            
            .photoImg {
                width: 125px;
                height: 162px;
                margin: 0px auto;
                border-radius: 10px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="grad" />
        </jsp:include>
        <table width="800" align="center" class="curvas loginPanel" cellspacing="0" style="padding: 10px;">
            <tr style="height: 32px;"></tr>
            <tr>
                <td colspan="<%=photo.exists()?"1":"2"%>" <%=photo.exists()?"style=\"width: 67%;\"":""%>>
                    <table style="width: <%=photo.exists()?"60%; margin-left: 15%;":"100%;"%>">
                        <tr>
                            <td colspan="2" style="text-align: <%=photo.exists()?"left":"center"%>; font-weight: bold;">
                                <%=datosContacto.get("nom_est")%>
                            </td>
                        </tr>
                        <%
                            if (datosContacto.get("email") != null && !datosContacto.get("email").equals("")) {
                        %>
                        <tr>
                            <td colspan="2" style="text-align: <%=photo.exists()?"left":"center"%>;">
                                E-mail: <%=datosContacto.get("email")%>
                            </td>
                        </tr>
                        <%  }

                            if (datosContacto.get("tel_residencia") != null && !datosContacto.get("tel_residencia").equals("")) {
                        %>
                        <tr>
                            <td colspan="2" style="text-align: <%=photo.exists()?"left":"center"%>;">
                                Teléfono: <%=datosContacto.get("tel_residencia")%>
                            </td>
                        </tr>
                        <%
                            }

                            if (datosContacto.get("cel") != null && !datosContacto.get("cel").equals("")) {
                        %>

                        <tr>
                            <td colspan="2" style="text-align: <%=photo.exists()?"left":"center"%>;">
                                Celular: <%=datosContacto.get("cel")%>
                            </td>
                        </tr>
                        <%
                            }

                            if (datosContacto.get("ciudad_residencia") != null && !datosContacto.get("ciudad_residencia").equals("")) {
                        %>
                        <tr>
                            <td colspan="2" style="text-align: <%=photo.exists()?"left":"center"%>;">
                                <%=datosContacto.get("ciudad_residencia")%>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </td>
                <%
                    if (photo.exists()) {
                %>
                <td colspan="1" style="text-align: right;">
                    <div class="photoImg" style="border: 1px dashed #FFFFFF;">
                        <img src="<%="http://tycho.escuelaing.edu.co/Doc_Graduado_SIGE/" + photo.getName()%>" style="width: 100%; height: 100%; border-radius: 10px;"/>
                    </div>
                </td>
                <%
                    }
                %>
            </tr>
            <tr style="height: 32px;"></tr>
            <tr>
                <td colspan="2">
                    <div class="tituloHV" align="center">Perfil Profesional</div></td>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>
                <td colspan="2">
                    <div class="textoHV"><%=datosContacto.get("perfil").toString().replace("\n", "<br />")%></div>
                </td>
            </tr>
            <tr style="height: 32px;"></tr>
            <tr>
                <td colspan="2">
                    <div class="tituloHV" align="center">Experiencia Laboral</div></td>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <%
                for (HashMap Experiencia : ExperienciasGrad) {
                    
                    if (((String) Experiencia.get("validate")).equals("1")) {

                        Funciones = (String)Experiencia.get("funciones");

                        if(Funciones!= null && !Funciones.equals("NULL")){
                            Funciones = Funciones.replaceAll("Ã¡","á");
                            Funciones = Funciones.replaceAll("Ã©","é");
                            Funciones = Funciones.replaceAll("Ã­","í");
                            Funciones = Funciones.replaceAll("Ã³","ó");
                            Funciones = Funciones.replaceAll("Ãº","ú");
                            Funciones = Funciones.replaceAll("Ã±","ñ");        
                        } else {
                            Funciones = "";
                        }

                        Logros = (String)Experiencia.get("logros");

                        if( Logros!= null && !Logros.equals("NULL")){
                            Logros = Logros.replaceAll("Ã¡","á");
                            Logros = Logros.replaceAll("Ã©","é");
                            Logros = Logros.replaceAll("Ã­","í");
                            Logros = Logros.replaceAll("Ã³","ó");
                            Logros = Logros.replaceAll("Ãº","ú");
                            Logros = Logros.replaceAll("Ã±","ñ");
                        } else {
                            Logros = "";
                        }
            %>
            <tr>
                <td colspan="2">
                    <div>
                        <table class="elementoHV" width="80%" align="center">
                            <tr>
                                <td width="30%">Empresa:</td>
                                <td width="70%"><%=Experiencia.get("nom_empresa")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Cargo:</td>
                                <td width="70%"><%=Experiencia.get("cargo")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Desde:</td>
                                <td width="70%"><%=Experiencia.get("fecha_in_cargo")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Hasta:</td>
                                <td width="70%"><%=Experiencia.get("fecha_out_cargo").equals("1900/01")?"Actualidad":Experiencia.get("fecha_out_cargo")%></td>
                            </tr>
                            <tr style="height: 16px;"></tr>
                            <tr>
                                <td colspan="2">Funciones:</td>
                            </tr>
                            <tr style="height: 16px;"></tr>
                            <tr>
                                <td colspan="2">
                                    <div class="textoHV" style="width: 95%;"><%=Funciones%></div>
                                </td>
                            </tr>
                            <tr style="height: 16px;"></tr>
                            <tr>
                                <td colspan="2">Logros:</td>
                            </tr>
                            <tr style="height: 16px;"></tr>
                            <tr>
                                <td colspan="2">
                                    <div class="textoHV" style="width: 95%;"><%=Logros%></div>
                                </td>
                            </tr>
                            <tr style="height: 16px;"></tr>
                        </table>
                    </div>
                </td>
            </tr>
            <%
                    }
                }
            %>
            <tr style="height: 32px;"></tr>
            <tr>
                <td colspan="2">
                    <div class="tituloHV" align="center">Estudios Realizados</div></td>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <%
                for (HashMap Estudio : EstudiosGrad) {
            %>
            <tr>
                <td colspan="2">
                    <div>
                        <table class="elementoHV" width="80%" align="center">
                            <tr>
                                <td width="30%">Institución:</td>
                                <td width="70%"><%=Estudio.get("nom_inst")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Nivel de formación:</td>
                                <td width="70%"><%=Estudio.get("nivel_formacion")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Título:</td>
                                <td width="70%"><%=Estudio.get("titulo")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Fecha de grado:</td>
                                <td width="70%"><%=Estudio.get("fecha_grado")%></td>
                            </tr>
                            <tr style="height: 16px;"></tr>
                        </table>
                    </div>
                </td>
            </tr>
            <%
                }
            %>
            <%
                if (IdiomasGrad.length> 0) {
            %>
            <tr style="height: 32px;"></tr>
            <tr>
                <td colspan="2">
                    <div class="tituloHV" align="center">Idiomas</div></td>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <%
                    for (HashMap Idioma : IdiomasGrad) {
            %>
            <tr>
                <td colspan="2">
                    <div>
                        <table class="elementoHV" width="80%" align="center">
                            <tr>
                                <td colspan="2" style="font-weight: bold;"><%=Idioma.get("nom_idioma")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Escritura:</td>
                                <td width="70%"><%=Idioma.get("niv_escritura")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Lectura:</td>
                                <td width="70%"><%=Idioma.get("niv_lectura")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Habla:</td>
                                <td width="70%"><%=Idioma.get("niv_habla")%></td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <%
                    }
                }
                
                if (Distinciones.length > 0) {
            %>
            <tr style="height: 32px;"></tr>
            <tr>
                <td colspan="2">
                    <div class="tituloHV" align="center">Distinciones</div></td>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <%
                    for (HashMap Distincion : Distinciones) {
            %>
            <tr>
                <td colspan="2">
                    <div>
                        <table class="elementoHV" width="80%" align="center">
                            <tr>
                                <td colspan="2" style="font-weight: bold;"><%=Distincion.get("nom_distincion")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Institución:</td>
                                <td width="70%"><%=Distincion.get("lugar_distincion")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Fecha:</td>
                                <td width="70%"><%=Distincion.get("f_distincion")%></td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <%
                    }
                }
                
                if (Afiliaciones.length > 0) {
            %>
            <tr style="height: 32px;"></tr>
            <tr>
                <td colspan="2">
                    <div class="tituloHV" align="center">Afiliaciones</div></td>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <%
                    for (HashMap Afiliacion : Afiliaciones) {
            %>
            <tr>
                <td colspan="2">
                    <div>
                        <table class="elementoHV" width="80%" align="center">
                            <tr>
                                <td colspan="2" style="font-weight: bold;"><%=Afiliacion.get("nom_aso")%></td>
                            </tr>
                            <tr>
                                <td width="30%">Fecha:</td>
                                <td width="70%"><%=Afiliacion.get("f_in")%></td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
