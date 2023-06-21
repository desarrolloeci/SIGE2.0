<%-- 
    Document   : contratoMov
    Created on : 10/09/2012, 04:18:41 PM
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
  
           String consulta = new String ();
         
           String idsolicitud;
           inicio.conectaEJB conEjb = new inicio.conectaEJB();
           EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
           login.SessionUsrRemote admin = (login.SessionUsrRemote) session.getAttribute("usuario");
            
            if (admin == null) {
                %>
                <script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loginDec';
                  </script>
                <%
                return;
            }
           //DecanoRemote bd = conEjb.lookupDecanoRemote();
           emp.inicializar("75107740");
           idsolicitud = request.getParameter("i");
           session.setAttribute("emp", emp ) ;
           String id_est= new String ();
           HashMap datos=null;
           HashMap datosSolG = emp.datosSolicitudG(idsolicitud);
           id_est = (String) datosSolG.get("id_est");
           if(id_est != null){           
               datos = emp.datosGeneralesEst(id_est);
           }
           HashMap datosContrato=emp.datosContrato(idsolicitud);
           consulta = (String)datosContrato.get("clausula1");
           if(consulta != null){
            consulta = consulta.replaceAll("\n", "<br>");
           }
      if(consulta!=null && id_est!=null){     
          
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SIEMPREG Movilidad - Contrato de estudios</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunAdminmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunDecmov.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
      <link rel="stylesheet" type="text/css" href="CSS/imprimir.css"  />
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
        </style>
        

</head>

<body>
    
    <div id="contenedor"> 
     
   
   <div id="cuerpo"> 
     
    <div id="derecha"> 
       <div id="principal"> 
<table width="100%" height="382" align="center">
     <tr>
       <td><p align="center">CONTRATO DE ESTUDIOS</p>
       <p align="center">Programa: Intercambio académico</p>         <p align="center">&nbsp;</p></td>
     </tr>
     <tr>
       <td><table width="99%"  border="1">
         <tr>
           <td>PROGRAMA ACADEMICO:   <%=dpto%></td>
          </tr>
       </table></td>
     </tr>
     <tr>
       <td><table width="99%"   border="1">
         <tr>
           <td colspan="4">DATOS DEL ESTUDIANTE</td>
          </tr>
         <tr>
           <td colspan="4">Apellidos y Nombre:     <%=datos.get("nom_est")%></td>
           
          </tr>
         <tr>
           <td colspan="2">Telefono: <%=datos.get("tel_corr")%></td>
           <td colspan="2">email: <%=datos.get("emails")%>@mail.escuelaing.edu.co</td>
          
          </tr>
         <tr>
           <td colspan="4">Número de Identidad:  <%=datos.get("doc_est")%></td>
          </tr>
         <tr>
           <td colspan="4">Dirección permanente:  <%=datos.get("dir_corr")%></td>
          </tr>
       </table></td>
     </tr>
     <tr>
       <td>REALIZARA EL INTERCAMBIO DESDE   <%=datosSolG.get("fecha_in")%>   HASTA   <%=datosSolG.get("fecha_out")%>  </td>
     </tr>
     <tr>
       <td><table width="99%"   border="1">
         <tr>
           <td><p>INSTITUCION DE DESTINO:  <%=datosSolG.get("uni_destino")%></p>
             <p>PAIS:  <%=datosSolG.get("pais_mov")%></p>
            <p>NOMBRE DEL PROGRAMA EN LA INSTITUCION ANFITRIONA:  <%=datosSolG.get("prog_ud")%></p></td>
          </tr>
       </table></td>
     </tr>
     <tr>
         <td><p>Descripcion del programa</p><%=consulta%> </td>
     </tr>
     <tr>
       <td>
           <div class="tablacompleta">
           <%
                                            if(datosSolG.get("prog_mov").equals("PRACTICA INTERNACIONAL"))
                                            {

                                    %>


                                                <table  width="90%" border="1" id="tablaPlanest" align="center" style="page-break-inside:avoid" >
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

                                                <table  width="90%" border="1"  id="tablaPlanest" align="center" style="page-break-inside:avoid">
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


                                                <table  width="90%" border="1" id="tablaPlanest" align="center" style="page-break-inside:avoid">
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
                                           %>
           </div>
           </td>
           

     </tr>
     <script type="text/javascript">

                          ListaPlanDec(<%=idsolicitud%>);
                      </script>
        
     
  </table>
                      <table width="99%"  style="page-break-inside:avoid">
                          <tr>
     
         <td>
             
             <p><%=datosContrato.get("clausula2")%></p>
           <p><%=datosContrato.get("obv_plan")%></p>
       <p>Firma del Estudiante:_____________________________</p>
             
         </td>
         
     </tr>  
      </table>
       <table    width="99%"   border="1" style="page-break-inside:avoid">
         <tr>
           <td colspan="2">INSTITUCIÓN DE ORIGEN: Confirmamos que el programa y contrato de estudios quedan aprobados</td>
          </tr>
          <tr>
           <td><p>Decano</p>
             <p>_____________________________</p>
             <p>Lugar y Fecha:_______________</p>
             <p>&nbsp;</p>
             <p>Firma:_______________________</p></td>
           <td><p>Estudiante</p>
             <p>_____________________________</p>
             <p>Lugar y Fecha:_______________</p>
             <p>&nbsp;</p>
             <p>Firma:_______________________</p></td>
          </tr>
          <tr>
           <td><p>Secretario General</p>
             <p>_____________________________</p>
             <p>Lugar y Fecha:_______________</p>
             <p>&nbsp;</p>
             <p>Firma:_______________________</p></td>
           <td><p>Vicerrector Académico</p>
             <p>_____________________________</p>
             <p>Lugar y Fecha:_______________</p>
             <p>&nbsp;</p>
             <p>Firma:_______________________</p></td>
          </tr>
         
         
       </table>
      
       </div> 
    </div> 
   </div> 
    
</div> 
   
</body>
<%}else{%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INFORMACION CONTRATO</title>
        
        <link href="CSS/movilidad.css" rel="stylesheet" type="text/css">
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
            
            .titulocom {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 20px;
                color: #990000;
            }
        </style>
    </head>
    <body >
        <jsp:include page="header">
            <jsp:param name="type" value="mov" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" style="padding: 15px 25px;">
            <tr style="height: 64px;">
                <td colspan="2" class="titulocom" style="text-align: center;">
                        Esta solicitud no ha generado ningun contrato
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>
                <td>
                    <div align="center" >
                        <input class="button_azul1" type="submit" onclick="window.history.back()" value="Volver al Historial" />
                    </div>
                </td>
                <td>
                    <div align="center" >
                        <input class="button_azul1" type="submit" onclick="window.close()" value="Cerrar esta ventana" />
                    </div>
                </td>
            </tr>
            <tr style="height: 16px;"></tr>
            <tr>
                <td colspan="4">
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
    </body>
<%}%>
</html>
