<%-- 
    Document   : documentosEstMov
    Created on : 30/08/2012, 02:19:29 PM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EstudiantesRemote"%>
 <%@page import="BDsige.DecanoRemote"%>
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
  

       
           String idsolicitud;
            String id_est = new String ();
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
           login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");     
            String usuario = new String();
            usuario = admin.getUser();
           //DecanoRemote bd = conEjb.lookupDecanoRemote();
           emp.inicializar(usuario);
           idsolicitud = request.getParameter("idSolicitud");
           session.setAttribute("emp", emp ) ;
           HashMap estado = emp.estadoAplicacion(idsolicitud);
           id_est=(String) estado.get("id_est");
           HashMap datos = emp.datosGeneralesEst(id_est);
           HashMap[] datosSol= emp.datosSolicitud(idsolicitud);
           int ban=datosSol.length;
           HashMap datosSol1 = datosSol[0];
           HashMap datosSol2 ;
           if(ban>1){
               datosSol2= datosSol[1];
           }
           else{
           
               datosSol2= datosSol[0];
           }
                       
             
%>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documentos SIEMPREG</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
    </head>
    <body  >
        <p class="textocom">&nbsp;</p>
         <jsp:include page="encabezado_mov"></jsp:include>
         <div align="center">
                <fieldset class="field_set">
        <table width="640" border="0" align="center" cellspacing="0">
            <tr> <td align="center"  > <a class='textocom3'> SOLICITUD DE MOVILIDAD </a> </td></tr>
            <tr> <td align="center"  > <a class='textocom2'> Aprobación de documentos.</a> </td></tr>
            <tr>
            <td valign="top" class="textocom" align="center">
                <table  width="635"  cellspacing="0">

                    <tr> <td colspan="3" align="center" style="font-size: 10pt; color:#000000 " > DATOS GENERALES </td></tr> <br/>
                    <tr><td colspan="3"><br/>
                            Nombre: <font id="nom_est" color="#000000"><%=datos.get("nom_est")%></font>. <br /> <br />
                            Documento de identidad: <font id="doc_est" color="#000000"><%=datos.get("doc_est")%></font>. <br/><br/>
                         </td>
                    </tr>
                  <tr> <td colspan="3" align="center" style="font-size: 10pt; color:#000000 " > SOLICITUD </td></tr><br/><br/>
                  <tr>
                      <td colspan="3">
                          <br/>Programa de Movilidad Solicitado: <font id="prog_mov" color="#000000"><%=datosSol1.get("prog_mov")%></font> <br/> <br/>
                      </td>
                  </tr>
                  <tr>
                      <td colspan="3">
                          Pais al que aplica: <font id="prog_mov" color="#000000"><%=datosSol1.get("pais_mov")%></font> <br/>
                      </td>
                  </tr>
                  <tr>
                      <td colspan="3">

                          <br/>Fecha de inicio:<font id="fecha_in" color="#000000"><%=datosSol1.get("fecha_in")%></font> <br/>

                      </td>
                  </tr>
                  <tr>
                      <td colspan="3">

                          <br/>Fecha de finalización: <font id="fecha_out" color="#000000"><%=datosSol1.get("fecha_out")%></font> <br/>

                      </td>
                  </tr>
                  <tr>
                      <td colspan="3">
                          <br/><p> Universidades a las que desea aplicar:</p>
                           <p>Opcion1:</p>Nombre de la Institución:<font id="uni_destino1" color="#000000"><%=datosSol1.get("uni_destino")%></font> <br/>
                          Programa solicitado:<font id="prog_ud1" color="#000000"><%=datosSol1.get("prog_ud")%></font> <br/> <br/>
                      </td>
                  </tr>
                  <tr>
                      <td>

                           <p>Opcion2:</p>Nombre de la Institución:<font id="uni_destino2" color="#000000"><%=datosSol2.get("uni_destino")%></font> <br/>
                          Programa solicitado:<font id="prog_ud2" color="#000000"><%=datosSol2.get("prog_ud")%></font> <br/> <br/>
                      </td>
                  </tr>
                  
                  <tr align="center">
                      <td colspan="3" >
                          <br/><p> CARTA DE INTENCION</p>
                           <font id="prog_mov" color="#000000"><%=datosSol1.get("carta_eci")%></font> <br/> <br/><br/>
                      </td>                      
                  </tr>
                  </table>
                  <table  width="90%"  cellspacing="0" border="0" align="center">
                    <tr> <td colspan="3" align="center"><a class='textocom3'>DOCUMENTOS</a></td></tr>                    
                  </table>                
                  <table  width="90%" border="1" class="tabla" id="tabladocumentos" align="center" >
                    <thead>
                        <tr>
                            <th ><div align="center"><strong>Tipo de documento</strong></div></th>
                            <th ><div align="center"><strong>Aceptar</strong></div></th>
                            <th ><div align="center"><strong>Rechazar</strong></div></th>
                             <th ><div align="center"><strong>Estado</strong></div></th>
                        </tr>
                    </thead>
                    <tbody id="cuerpo4">
                    </tbody>
                  </table>
                 <script type="text/javascript">

                   actualizartabdocu(<%=idsolicitud%>);

                </script>
                    <table  width="90%"  cellspacing="0" border="0" align="center">
                                 <tr>
                                      <td  colspan="2" align="center">
                                          <br/><p> Comentarios sobre los documentos</p>
                                          <textarea name="comentariomov" id="comentariomov" rows="10" cols="38">Escriba su comentario....</textarea>
                                      </td>
                                  </tr>
                                  <tr> <td  colspan="2" align="center"><input type="submit" value="Enviar comentario" name="comen" onclick= " GuardarComentario(<%=idsolicitud%>,'obv_docu');"/></td></tr>
                  </table>
            </td>
        </tr>
        <tr>
                        <td >
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
