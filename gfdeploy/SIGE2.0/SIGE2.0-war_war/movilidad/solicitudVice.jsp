<%-- 
    Document   : solicitudVice
    Created on : 12/09/2012, 12:13:43 PM
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

<html >
<head>
    <%
    response.setHeader("Cache-Control","no-cache");
    
           String consulta = new String ();

           String idsolicitud;
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
           //DecanoRemote bd = conEjb.lookupDecanoRemote();
           login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");          
           String usuario = new String();
           usuario = admin.getUser();
           emp.inicializar(usuario);
           idsolicitud = request.getParameter("i");
           session.setAttribute("emp", emp ) ;
           String id_est= new String ();
           HashMap datosSolG = emp.datosSolicitudG(idsolicitud);
           id_est = (String) datosSolG.get("id_est");
           HashMap datos = emp.datosGeneralesEst(id_est);
           HashMap datosContrato=emp.datosContrato(idsolicitud);
           consulta = (String)datosContrato.get("clausula1");
           consulta = consulta.replaceAll("\n", "<br>");
          
                     
             String dpto = new String ();
           if(datos.get("id_dpto").equals("13"))
           {
              dpto="Ingenier&iacute;a Civil";
           }
        if(datos.get("id_dpto").equals("14"))
        {
          dpto="Ingenier&iacute;a El&eacute;ctrica";
        }
        if(datos.get("id_dpto").equals("15"))
        {
          dpto="Ingenier&iacute;a de Sistemas";
        }
        if(datos.get("id_dpto").equals("16"))
        {
          dpto="Ingenier&iacute;a Industrial";
        }
        if(datos.get("id_dpto").equals("17"))
        {
          dpto="Ingenier&iacute;a Electr&oacute;nica";
        }
        if(datos.get("id_dpto").equals("260"))
        {
          dpto="Ingenier&iacute;a Mec&aacute;nica";
        }
        if(datos.get("id_dpto").equals("262"))
        {
          dpto="Ingenier&iacute;a Biom&eacute;dica";
        }
        if(datos.get("id_dpto").equals("19"))
        {
          dpto="Administraci&oacute;n de Empresas";
        }
        if(datos.get("id_dpto").equals("20"))
        {
          dpto="Matem&aacute;ticas";
        }
        if(datos.get("id_dpto").equals("18"))
        {
          dpto="Econom&iacute;a";
        }




%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>contrato</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">


</head>

<body>
<blockquote>
  <blockquote>
    <p>&nbsp;</p>
  </blockquote>
</blockquote>
     <jsp:include page="encabezado_mov"></jsp:include>
 <div align="center">
                <fieldset class="field_set">
   <table width="650" bgcolor="#FFFFFF"  align="center">
     <tr>
       <td><p align="center">CONTRATO DE ESTUDIOS</p>
       <p align="center">Programa: Intercambio académico</p>         <p align="center">&nbsp;</p></td>
     </tr>
     <tr>
       <td><table width="99%"  border="1">
         <tr>
           <td align="left">PROGRAMA ACADEMICO:   <%=dpto%></td>
          </tr>
       </table></td>
     </tr>
     <tr>
       <td><table width="99%"   border="1" >
         <tr>
           <td colspan="4" align="left">DATOS DEL ESTUDIANTE</td>
          </tr>
         <tr>
           <td colspan="4" align="left">Apellidos y Nombre:     <%=datos.get("nom_est")%></td>

          </tr>
         <tr>
           <td colspan="2" align="left">Telefono: <%=datos.get("tel_corr")%></td>
           <td colspan="2" align="left">email: <%=datos.get("emails")%>@mail.escuelaing.edu.co</td>

          </tr>
         <tr>
           <td colspan="4" align="left">Número de Identidad:  <%=datos.get("doc_est")%></td>
          </tr>
         <tr>
           <td colspan="4" align="left">Dirección permanente:  <%=datos.get("dir_corr")%></td>
          </tr>
       </table></td>
     </tr>
     <tr>
       <td align="left">REALIZARA EL INTERCAMBIO DESDE   <%=datosSolG.get("fecha_in")%>   HASTA   <%=datosSolG.get("fecha_out")%>  </td>
     </tr>
     <tr>
       <td><table width="99%"   border="1">
         <tr>
           <td align="left"><p>INSTITUCION DE DESTINO:  <%=datosSolG.get("uni_destino")%></p>
             <p>PAIS:  <%=datosSolG.get("pais_mov")%></p>
            <p>NOMBRE DEL PROGRAMA EN LA INSTITUCION ANFITRIONA:  <%=datosSolG.get("prog_ud")%></p></td>
          </tr>
       </table></td>
     </tr>
     <tr>
         <td align="left"><p>Descripcion del programa</p><%=consulta%> </td>
     </tr>
     <tr>
       <td ><%
                                            if(datosSolG.get("prog_mov").equals("PRACTICA INTERNACIONAL"))
                                            {

                                    %>


                                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th ><div align="center"><strong>Periodo</strong></div></th>
                                                                <th ><div align="center"><strong>Empresa</strong></div></th>
                                                                <th ><div align="center"><strong>Materia de la ECI</strong></div></th>


                                                            </tr>
                                                        </thead>
                                                        <tbody id="cuerpoplanpi">
                                                        </tbody>
                                                </table>


                                    <%
                                              }
                                              else
                                              {
                                                if(datosSolG.get("prog_mov").equals("DOBLE TITULACION"))
                                                {
                                        %>

                                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th><div align="center"><strong>Periodo</strong></div></th>
                                                                <th><div align="center"><strong>Materia en la Universidad anfitriona</strong></div></th>


                                                            </tr>
                                                        </thead>
                                                        <tbody id="cuerpoplanpi">
                                                        </tbody>
                                                        </table>
                                        <%
                                                }
                                                else
                                                {
                                                %>


                                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th><div align="center"><strong>Periodo</strong></div></th>
                                                                <th><div align="center"><strong>Materia en la Universidad anfitriona</strong></div></th>
                                                                <th ><div align="center"><strong>Materia de la ECI</strong></div></th>

                                                            </tr>
                                                        </thead>
                                                        <tbody id="cuerpoplanpi">
                                                        </tbody>
                                                </table>
                                                <%
                                                }
                                              }
                                           %></td>

     </tr>
     <script type="text/javascript">

                          ListaPlanDec(<%=idsolicitud%>);
                      </script>
     <tr>
       <td align="left"><p><%=datosContrato.get("clausula2")%></p>
       </td>
     </tr>
                  <tr>
                      <td  colspan="2" align="center">
                          <br/><p> Comentarios</p>
                          <textarea name="comentariomov" id="comentariomov" rows="10" cols="38">Escriba su comentario....</textarea>
                      </td>
                  </tr>
                  <tr> <td  colspan="2" align="center"><input class="button_azul_consulta" type="submit" value="Enviar comentario" name="comen" onclick= " GuardarComentario(<%=idsolicitud%>,'obv_vice');"/><br><br></td></tr>
                  <% if(datosSolG.get("vobo_vice")== null){%>
                 <tr>
                      <td id="botonSol" align="center">
                          <input class="button_azul_consulta" type="submit" value="Aceptar" name="vobocarta" onclick= " AceptarSolicitudVice(<%=idsolicitud%>,'<%=usuario%>');"/>
                          <input class="button_azul_consulta" type="submit" value="Pendiente" name="vobocarta" onclick= " DejarPendiente();"/>
                          <input class="button_azul_consulta" type="submit" value="Rechazar" name="vobocarta" onclick= " RechazarSolicitudVice(<%=idsolicitud%>,'<%=usuario%>');"/>
                          
                      </td>
                  </tr>
                  <tr>
                      <td id="msgBotonSol" align="center" style="visibility: hidden;"></td>
                  </tr>
                  <%}else{
                      if(datosSolG.get("vobo_vice").equals("1")){
                       %>
                  
                  <tr>
                      <td align="center">
                          <a class="textocom2">Esta solicitud ya ha sido tramitada por el Vicerrector Académico. Su estado actual es <b>aprobada</b>.</a>
                          <input class="button_azul_consulta" type="submit" value="Cerrar" name="vobocarta" onclick= " DejarPendiente();"/>
                          
                          
                      </td>
                  </tr>
                  <%   
                      }else{%>
                  <td align="center">
                          <a class="textocom2">Esta solicitud ya ha sido tramitada por el Vicerrector Académico. Su estado actual es <b>rechazada</b>.</a>
                          <input class="button_azul_consulta" type="submit" value="Cerrar" name="vobocarta" onclick= " DejarPendiente();"/>
                          
                          
                      </td>
                  
                  <%}
                  }%>
                  
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
