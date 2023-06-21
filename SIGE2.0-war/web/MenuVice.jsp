<%-- 
    Document   : MenuVice
    Created on : 12/09/2012, 11:57:54 AM
    Author     : Luis Alberto Salas
--%>



    <%@page import="BDsige.EmpleadoRemote"%>
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


  
    //String paramtext = new String();
    //String titulo = new String("Servicio a Administradores");

    String error = new String();
    login.SessionUsrRemote admin =(login.SessionUsrRemote)session.getAttribute("usuario");
    String rol = new String ();
    String usuario = new String ();
    usuario=admin.getUser();
    rol=admin.getRol();
    String arreglo[]=new String[50];
    String texto[]=new String[20];
    String noticias[]=new String[200];
    String noti[]=new String[20];
    int i=0, not=0;
    int conmenu = 0;
    int k=0;
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
        <title>Menu Sige</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunVice.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>

        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
    </head>
    <body  >
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_mov"></jsp:include>
        <div align="center">
                <fieldset class="field_set">
        <table width="640" border="0" align="center" cellspacing="0">
            <tr class="textocom">
                 <td colspan="2" ><div align="center" class="menuprueba2"><font color="#FFFFFF">Opciones</font></div></td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
                <td width="30%" valign="top">
                    <%
                      if(error.equals("OK"))
                      {
                        for (int j=0; j<i; j++)
                        {
                            StringTokenizer st = new StringTokenizer(arreglo[j], "|");
                            k=0;
                            while (st.hasMoreTokens())
                            {
                                texto[k]=st.nextToken();
                                k=k+1;
                            }
                    %>
                    <%


                            if(texto[4].equals("0")){
                        %>
                             <table  width="100%" border="0"  cellspacing="0" bordercolor="#EEEBFC">

                                        <tr>
                                           <td width="200"  height="20" bgcolor="FFFFFF"  VALIGN="BOTTOM"  >
                                                <div align="left">
                                                    <a onclick="<%=texto[6]%>">
                                                       <font id="f<%=conmenu%>" color="#000000" class="menuprueba"><%=texto[5]%> </font></a></div>
                                            </td>
                                        </tr>
                        <%
                                        conmenu = conmenu+1;
                             }
                           }
                        }
                        %>

                    </table>


                </td>

                <td width="70%" align="left">
                    <table width="460" frame="lhs" >
                        <tr>
                            <td valign="top" height="500"  bgcolor="#FFFFFF" class="textocom" style="  box-shadow:  -5px 5px 5px 5px rgba(0,0,0,0.1); ">

                                <div align="left" id="consultamov" style="display: none">
                                <table  width="480"  cellspacing="0">
                                        <tr>
                                            <p>Por favor seleccione el programa acad&eacute;mico.</p>
                                        <p>
                                        <select name="ProgramaAcademico" id="ProgramaAcademico">
                                            <!--
                                            <option value="13">Ingenier&iacute;a Civil
                                            <option value="14">Ingenier&iacute;a El&eacute;ctrica
                                            <option value="15">Ingenier&iacute;a de Sistemas
                                            <option value="16">Ingenier&iacute;a Industrial
                                            <option value="17">Ingenier&iacute;a Electr&oacute;nica
                                            <option value="260">Ingenier&iacute;a Mec&aacute;nica
                                            <option value="262">Ingenier&iacute;a Biom&eacute;dica
                                            <option value="19">Administraci&oacute;n de Empresas
                                            <option value="18">Econom&iacute;a
                                            <option value="20">Matem&aacute;ticas
                                            -->
                                            <option value="0">Todos los programas
                                        </select>

                                        </p>
                                        <p>Por favor seleccione el programa de movilidad.</p>
                                        <p>
                                        <select name="ProgramaMovilidad" id="ProgramaMovilidad">
                                            <option value="'INTERCAMBIO NACIONAL'">Intercambio Nacional
                                            <option value="'INTERCAMBIO LOCAL'">Intercambio Local
                                            <option value="'JOVENES INGENIEROS'">Jovenes Ingenieros
                                            <option value="'INTERCAMBIO SOCIAL'">Intercambio Social
                                            <option value="'PRACTICA INTERNACIONAL' ">Pr&aacute;ctica Internacional
                                            <option value="'INTERCAMBIO INTERNACIONAL'">Intercambio Internacional
                                            <option value="'DOBLE TITULACION'">Doble Titulaci&oacute;n
                                            <option value="0">Todos los programas
                                         </select>
                                        </tr>
                                </table>
                                </div>
                                <div align="left" id="botonconsultamov" style="display: none">
                                    <table  width="480"  cellspacing="0">
                                        <table  width="480"  cellspacing="0">
                                                <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr><td>
                                                        <input class="button_azul_consulta" type="submit" value="consultar" name="consultar" onclick= "consultarApVice();"/></td></tr>
                                    </table>
                                </div>
                                <div align="left" id="botonestEXT" style="display: none">
                                    <table  width="480"  cellspacing="0">
                                        <tr>
                                                    <td>&nbsp;</td>

                                                </tr>
                                                <tr><td>
                                                        <input class="button_azul_consulta" type="submit" value="Consultar" name="Mostrar opcuni" onclick= " consultarestEXT();"/></td></tr>
                                    </table>
                                </div>
                                <div align="left" id="tablaconsultaVice" style="display: none">

                                      <table  width="80%" border="1" class="tabla" id="tablaplicantesVice" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                                    <th width="20%"><div align="center"><strong>Programa movilidad</strong></div></th>
                                                    <th width="15%"><div align="center"><strong>Entrevista</strong></div></th>
                                                    <th width="15%"><div align="center"><strong>Contrato</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="ApliMovVice">
                                            </tbody>
                                        </table>
                                </div>
                                <div align="left" id="tablaconsultaestEXT" style="display: none">

                                           <table  width="80%" border="1" class="tabla" id="tablaestEXT" align="center" >
                                            <thead>
                                                <tr>
                                                    <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                                    <th width="20%"><div align="center"><strong>Programa movilidad</strong></div></th>
                                                    <th width="10%"><div align="center"><strong>Estado</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpoestEXT">
                                            </tbody>
                                        </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                        <td colspan="2">
                            <br> 
                            <br> 
                            <div align="center" class="footer">
                                <p>Escuela Colombiana de Ingenier&iacute;a Julio Garavito</p>
                                <p>AK.45 No.205-59 (Autopista Norte)<br>
                                    PBX: +57(1) 668 3600 / Call center: 57(1) 668 3622 / L&iacute;nea Nacional Gratuita: 018000112668<br>
                                    www.escuelaing.edu.co</p>
                                <p>Bogot&aacute;, D.C. - Colombia</p>
                            </div>
                        </td>
                    </tr>
        </table>
                        </fieldset>  
        </div>
    </body>
</html>
