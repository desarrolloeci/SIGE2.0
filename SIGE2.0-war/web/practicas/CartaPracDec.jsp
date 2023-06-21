<%-- 
    Document   : CartaPracDec
    Created on : 28/01/2013, 02:08:19 PM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EmpresaRemote"%>


<%@page contentType="application/msword" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@ page import="javax.naming.*,javax.rmi.PortableRemoteObject;" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:w='urn:schemas-microsoft-com:office:word' xmlns='http://www.w3.org/TR/REC-html40'>
    <head>
<%
    response.setHeader("Cache-Control","no-cache");
    
    String id_apli = new String();
    String usuario = new String();

    login.SessionEmpRemote empresa =(login.SessionEmpRemote)session.getAttribute("usuario");
    
    //Verificamos que la sesión esté activa
    if (empresa == null) {
        %><script>
            alert("El usuario no está autenticado o su sesión ha finalizado.");
            window.location = 'loingempresa';
          </script><%
        return;
    }
    
    response.setContentType("application/msword");
    usuario=empresa.getUser();
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
    EmpresaRemote emp = conEjb.lookupEmpresaRemote();
    emp.inicializar("75107740");;
    session.setAttribute("emp", emp ) ;

    id_apli = request.getParameter("ida");

    HashMap datosCartaprac = emp.datosCartaPrac(id_apli);
    HashMap datoDecEmp = emp.getDatoDecEmp(datosCartaprac.get("id_dpto").toString());
    
    Calendar dateNow = Calendar.getInstance();
    
    response.setHeader("Content-Disposition", "attachment; filename=\"Carta de Aceptación" + (datosCartaprac.get("nom_est") != null?" - " + datosCartaprac.get("nom_est"):"") + ".doc\"");
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carta Decanatura</title>
        <style>
            html, body {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 11px;
                /*color: #000046;*/
                color: #000000;
            }
            
            table {
                width: 100%;
                border: 1px solid #C0C0C0;
                border-collapse: collapse;
            }
            
            table td, th {
                border: 1px solid #C0C0C0;
            }
            
            table td.title {
                font-weight: bold;
                width: 20%;
                line-height: 150%;
            }
            
            .subTitle {
                margin-top: 32px;
                margin-bottom: 16px;
                font-size: 13px;
            }
        </style>
        
        <style> 
            @page Section1 {
                mso-header: h1;
                mso-footer: f1;
            }
            
            div.Section1 {
                page: Section1;
            }
            
            p.MsoHeader, li.MsoHeader, div.MsoHeader {
                mso-pagination: widow-orphan;
                tab-stops: center 3.0in right 6.0in;
            }
            
            p.MsoFooter, li.MsoFooter, div.MsoFooter {
                margin:0in;
                margin-bottom:.0001pt;
                mso-pagination:widow-orphan;
                tab-stops:center 3.0in right 6.0in;
            }
            
            table#norepeat {
                margin:0in 0in 0in 900in;
                width: 0px;
                height: 0px;
                overflow: hidden;
            }
        </style>
        
        <xml>
        <w:WordDocument>
        <w:View>Print</w:View>
        <w:DoNotOptimizeForBrowser/>
        </w:WordDocument>
        </xml>
    
    </head>
    
    <body>
        <div class="Section1">
            <p>
                Bogot&aacute;, <%=dateNow.get(Calendar.DAY_OF_MONTH)%> de <%=dateNow.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("es","CO"))%> de <%=dateNow.get(Calendar.YEAR)%>
            </p>
            <p>
                Ingeniero(a)<br>
                <b><%=(datoDecEmp.get("nombre") != null?datoDecEmp.get("nombre"):"<span style=\"color: #B20000\">NOMBRE DEL DECANO</span>")%></b><br>
                DECANO DE <b><%=(datosCartaprac.get("nom_dpto") != null?datosCartaprac.get("nom_dpto"):"<span style=\"color: #B20000\">NOMBRE DEL PROGRAMA</span>")%></b><br>
                Escuela Colombiana de Ingenier&iacute;a Julio Garavito<br>
            </p>
            <p style="text-align: justify;">
                Por medio de la presente informamos que el estudiante <b><%=(datosCartaprac.get("nom_est") != null?datosCartaprac.get("nom_est"):"<span style=\"color: #B20000\">NOMBRE DEL ESTUDIANTE</span>")%></b>,
                de la Escuela Colombiana de Ingenier&iacute;a Julio Garavito, 
                fue escogido para realizar la Pr&aacute;ctica Empresarial,
                con el prop&oacute;sito fundamental de aproximarlo al ejercicio profesional
                en una actividad que representa un valor agregado para su preparaci&oacute;n
                acad&eacute;mica.
            </p>
            <p>La informaci&oacute;n de la empresa y perfil del cargo requerido es el siguiente:</p>
            <p class="subTitle" style="font-weight: bold;">
                Informaci&oacute;n de la empresa:
            </p>

            <table style="width: 100%; text-align: left;">
                <tr>
                    <td class="title">
                        Raz&oacute;n Social:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("razon_social") != null?datosCartaprac.get("razon_social"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        NIT:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("nit") != null?datosCartaprac.get("nit"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Pa&iacute;s:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("pais_empresa") != null?datosCartaprac.get("pais_empresa"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Ciudad:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("ciudad_empresa") != null?datosCartaprac.get("ciudad_empresa"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Direcci&oacute;n:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("dir_empresa") != null?datosCartaprac.get("dir_empresa"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        P&aacute;gina Web:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("web_empresa") != null?datosCartaprac.get("web_empresa"):"")%>
                    </td>
                </tr>
            </table>

            <p class="subTitle" style="font-weight: bold;">
                Descripci&oacute;n de la pr&aacute;ctica:
            </p>

            <table style="width: 100%; text-align: left;">
                <tr>
                    <td class="title">
                        Programa Acad&eacute;mico:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("nom_dpto") != null?datosCartaprac.get("nom_dpto"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Cargo:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("cargo") != null?datosCartaprac.get("cargo"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Justificaci&oacute;n:
                    </td>
                    <td style="height: 64px; text-align: justify;"></td>
                </tr>
                <tr>
                    <td class="title">
                        Funciones y objetivos del cargo:
                    </td>
                    <td style="height: 64px; text-align: justify;"></td>
                </tr>
                <tr>
                    <td class="title">
                        Requisitos que debe cumplir el candidato:
                    </td>
                    <td style="height: 64px; text-align: justify;">
                        <%=(datosCartaprac.get("requisitos") != null?datosCartaprac.get("requisitos"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Tipo de Jornada:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("horario_oferta") != null?datosCartaprac.get("horario_oferta"):"")%>
                    </td>
                </tr>
            </table>
                    
            <br clear=all style='mso-special-character:line-break;'>

            <p class="subTitle" style="font-weight: bold;">
                Datos del remitente de la oferta:
            </p>

            <table>
                <tr>
                    <td class="title">
                        Nombre:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("nom_contacto") != null?datosCartaprac.get("nom_contacto"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Cargo:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("cargo_contacto") != null?datosCartaprac.get("cargo_contacto"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Tel&eacute;fono:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("tel_contacto") != null?datosCartaprac.get("tel_contacto"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        E-mail
                    </td>
                    <td>
                        <%=(datosCartaprac.get("email_contacto") != null?datosCartaprac.get("email_contacto"):"")%>
                    </td>
                </tr>
            </table>

            <p class="subTitle" style="font-weight: bold;">
                Legalizaci&oacute;n de la pr&aacute;ctica:
            </p>

            <table>
                <tr>
                    <td class="title">
                        Tipo de Contrato:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("tipo_contrato") != null?datosCartaprac.get("tipo_contrato"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Supervisor o Jefe (Nombre):
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="title">
                        Cargo:
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="title">
                        Teléfono:
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="title">
                        E-mail:
                    </td>
                    <td></td>
                </tr>
            </table>

            <p class="subTitle" style="font-weight: bold;">
                Fechas de Inicio y Fin de la pr&aacute;ctica
            </p>

            <table>
                <tr>
                    <td class="title">
                        Fecha de inicio de la pr&aacute;ctica con validez acad&eacute;mica:
                    </td>
                    <td class="title">
                        Fecha de finalizaci&oacute;n de la pr&aacute;ctica con validez acad&eacute;mica:
                </tr>
                <tr>
                    <td style="height: 16px;"></td>
                    <td style="height: 16px;"></td>
                </tr>
            </table>
            
            <br clear=all style='mso-special-character:line-break;page-break-before:always'>
            
            <p class="subTitle" style="font-weight: bold;">
                Afiliaciones y Apoyo de Sostenimiento
            </p>

            <table>
                <tr>
                    <td class="title">
                        ARL:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("seguro_arp") != null?datosCartaprac.get("seguro_arp"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Apoyo de sostenimiento mensual:
                    </td>
                    <td>
                        <%=(datosCartaprac.get("salario_oferta") != null?datosCartaprac.get("salario_oferta"):"")%>
                    </td>
                </tr>
                <tr>
                    <td class="title">
                        Nombre del responsable en RRHH:
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="title">
                        Cargo:
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="title">
                        Tel&eacute;fono:
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="title">
                        E-mail:
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: justify;">
                        <span style="font-weight: bold;">Nota:</span> 
                        de acuerdo con el decreto 055 del 2015 mediante el cual se reglamenta la afiliación de estudiantes al 
                        Sistema de Riesgos Laborales, es obligación de la empresa afiliar, al estudiante en práctica vinculado mediante 
                        contrato de trabajo al sistema de seguridad social integral; al estudiante con contrato de aprendizaje al 
                        sistema de seguridad social en salud y riesgos laborales; y al estudiante vinculado mediante convenio al 
                        sistema general de riesgos laborales, y garantizar su permanencia en el sistema correspondiente mientras 
                        se mantenga un vínculo con la empresa.
                    </td>
                </tr>
            </table>

            <table style="width: 80%; margin-top: 64px; border: 0px; border-collapse: separate; border-spacing: 60px;">
                <tr style="border: 0px;">
                    <td style="width: 50%; border: 0px; font-size: 14px; vertical-align: top; padding: 0px 10px;">
                        Firma del Supervisor o Jefe:
                    </td>
                    <td style="width: 50%; border: 0px; font-size: 14px; vertical-align: top; padding: 0px 10px;">
                        Firma RRHH:
                    </td>
                </tr>
                <tr style="border: 0px;">
                    <td style="height: 64px; border: 0px; padding: 0px 10px;">
                        _______________________________________
                    </td>
                    <td style="height: 64px; border: 0px; padding: 0px 10px;">
                        _______________________________________
                    </td>
                </tr>
            </table>
            
            <!--[if supportFields]>
            <table id='norepeat' border='0' cellspacing='0' cellpadding='0'>
                <tr>
                    <td>
                        <div style="mso-element: header" id="h1">
                            <p class="MsoHeader" style="text-align: center; font-weight: bold; padding: 50px 0px; border: 1px dashed #B20000; color: #B20000;">
                                Nota: Este documento se debe imprimir en formato de papelería de la empresa. Por favor borre éste recuadro y reemplácelo por su propio encabezado.
                            </p>
                        </div>
                    </td>
                    <td>
                        <div style="mso-element: footer" id="f1">
                            <p class="MsoFooter">
                                <span style=mso-tab-count:2'></span>
                                Página <span style='mso-field-code: PAGE '></span> de <span style='mso-field-code: NUMPAGES '></span>
                            </p>
                        </div>
                    </td>
                </tr>
            </table>
            <![endif]-->
        </div>
    </body>
</html>