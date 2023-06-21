<%-- 
    Document   : menubienestar
    Created on : 17/09/2012, 01:05:34 PM
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


   String error = new String();
    //String paramtext = new String();
    //String titulo = new String("Servicio a Administradores");


    String arreglo[]=new String[50];
    String texto[]=new String[20];
    String noticias[]=new String[200];
    String noti[]=new String[20];
    int i=0, not=0;
    int conmenu = 0;
    int k=0;
    login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");          
            String usuario = new String();
            usuario = admin.getUser();
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
        <title>Menu SIEMPREG</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunVice.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>

        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
    </head>
    <body >
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_mov"></jsp:include>
         <div align="center">
                <fieldset class="field_set">
        <table width="640" border="0" align="center" cellspacing="0">
            <tr class="textocom">
                <td colspan="2" ><div align="center" class="menuprueba2"><font color="#FFFFFF">Opciones</font></div></td>                
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">


                <td align="center">
                    <table width="640" border="0"  cellspacing="0" >
                        <tr>
                            <td valign="top" height="500"   class="textocom"  ">

                                <div align="center">
                                  <table width="100%" >

                                       <tr>
                                                  <td colspan="5">
                                                    &nbsp;
                                                  </td>
                                                </tr>
                                                 <tr>
                                                  <td colspan="5">
                                                    &nbsp;
                                                  </td>
                                                </tr>
                                      
                                      <tr>
                                                  <td colspan="5">
                                                    <div align="center">
                                                        <p><a class="textocom3"> Lista de Postulantes a Movilidad Internacional</a></p>
                                                      <p><a class="textocom3">Bienestar Universitario</a></p>
                                                    </div>
                                                  </td>

                                                </tr>
                                                <tr>
                                                  <td colspan="5">
                                                    &nbsp;
                                                  </td>
                                                </tr>
                                                 <tr>
                                                  <td colspan="5">
                                                    &nbsp;
                                                  </td>
                                                </tr>
                                                <tr>
                                                  <td colspan="5">
                                                    <div align="center">
                                                      <input class="button_azul1"type="submit" value="Actualizar la Lista" name="ActualizarB" onclick= " actualizartabbienestar();"/>
                                                      </div>
                                                  </td>
                                                </tr>
                                                 <tr>
                                                  <td colspan="5">
                                                    &nbsp;
                                                  </td>
                                                </tr>
                                                
                                  </table>
                                    <table width="95%" border="1" class="tabla" id="tablaplicantesbienestar" align="center">
                                              <thead>
                                                <tr>
                                                    <th width="20%"><div align="center"><strong>Nombre</strong></div></th>                                                    
                                                    <th width="15%"><div align="center"><strong>Programa academico</strong></div></th>
                                                    <th width="15%"><div align="center"><strong>Examen Psicologico</strong></div></th>
                                                    <th width="15%"><div align="center"><strong>Examen medico</strong></div></th>
                                                </tr>
                                            </thead>

                                            <tbody id="aplibienestar">
                                            </tbody>                                     
                                  </table>
                                </div>
                                <script type="text/javascript">
                                   actualizartabbienestar('<%=usuario%>');
                                   
                               </script>
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
