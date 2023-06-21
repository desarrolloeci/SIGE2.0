<%-- 
    Document   : informesDecPrac
    Created on : 12/04/2016, 11:37:23 AM
    Author     : Mario Martínez
--%>

<%@page import="BDsige.EmpresaRemote"%>
<%@page import="BDsige.EmpleadoRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.*,java.awt.*,java.io.*, java.text.*, java.net.*;" %>
<%@page import="javax.naming.*, javax.rmi.PortableRemoteObject;" %>

<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache");

            documentos.ruta ruta = new documentos.ruta();

            String rol = new String ();
            String usuario = new String ();
            String error = new String();

            login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");

            if (admin == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado");
                        window.location = 'loginDec';
                    </script>
                <%
                return;
            }

            usuario = admin.getUser();
            rol = admin.getRol();
            
            if (rol == null) {
                response.setContentType("text/html");
                %>
                    <script>
                        alert("Usted no está autorizado para ver esta página");
                        window.history.back();
                    </script>
                <%
                return;
            }
            
            String[] arreglo = new String[50];
            String[] texto = new String[20];
            String[] noticias = new String[200];
            
            int i = 0, not = 0;
            int conmenu = 0;
            int k = 0;

            try {
                FileReader ra = new FileReader(ruta.valruta() + "informesDecSIGE.txt");
                BufferedReader entrada = new BufferedReader(ra);
                
                String s;
                while ((s = entrada.readLine()) != null) {
                    arreglo[i]= s;
                    i=i+1;
                }

                ra = new FileReader(ruta.valruta() + "noticias.txt");
                entrada = new BufferedReader(ra);
                while ((s = entrada.readLine()) != null) {
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
        <title>SIEMPREG Prácticas Profesionales - Reportes para Decanaturas</title>

        <link href="CSS/calendario.css" type="text/css" rel="stylesheet"> 
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
            
            .titulocom {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 20px;
                color: #990000;
            }
        </style>
        <script type="text/javascript" src="jscript/conectar.js"></script>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" cellspacing="10">
            <tr style="height: 64px;">
                <td colspan="2" class="titulocom" style="text-align: center;">
                    Reportes de Prácticas Profesionales
                </td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td valign="top">
                    <%
                        if(error.equals("OK")) {
                    %>
                    <table align="center" width="50%" cellspacing="0" >
                    <%
                            for (int j=0; j<i; j++) {
                                StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                                k=0;

                                while (st.hasMoreTokens()) {
                                    texto[k]=st.nextToken();
                                    k=k+1;
                                }

                                if(texto[2].equals("3")){
                    %>
                        <tr>
                            <td height="20" bgcolor="FFFFFF"  >
                                <div align="left">
                                    <a onclick="<%=texto[4]%>" class="menuprueba">
                                       <font id="f<%=conmenu%>" color="#000000"><%=texto[3]%> </font>
                                    </a>
                                </div>
                            </td>
                        </tr>
                    <%
                                    conmenu = conmenu+1;
                                }
                            }
                    %>
                    </table>
                    <%
                        }
                    %>
                </td>
            </tr>
        </table>
    </body>
</html>