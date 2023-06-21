<%-- 
    Document   : cambioplanMov
    Created on : 27/09/2012, 02:49:25 PM
    Author     : Luis Alberto Salas
--%>

<%@page import="BDsige.EstudiantesRemote"%>
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


            String est = new String ();
            String idest = new String ();
            String progmov = new String ();
            String id_sol = new String ();
            String act = new String ();
            String usuario = new String ();
            login.SessionEstRemote estudiante =(login.SessionEstRemote)session.getAttribute("usuario");
            
            if (estudiante == null) {
                %>
                <script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loginestMov';
                  </script>
                <%
                return;
            }
            
            usuario=estudiante.getUser();
            HashMap datosetr;
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
            emp.inicializar("usuario");
            session.setAttribute("emp", emp ) ;
            HashMap id_est = emp.carnetEst(usuario);
            idest= (String)id_est.get("id_est");
            HashMap estado = emp.estadoAplicante(idest);
            est = (String)estado.get("estado");
            HashMap idsol = emp.IdAplicacion(idest);
            id_sol = (String)idsol.get("id_solicitud");
            if(id_sol==null){
                id_sol="1";
            }

    %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG Movilidad - Cambios al plan de estudios</title>
        <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/FunEstmov.js" ></script>
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
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="mov" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" cellspacing="10">
            <tr bgcolor="#FFFFFF" class="textocom">

                <td>
                    <table width="640" border="0"  cellspacing="0" align="center">
                        <tr><td>&nbsp;</td></tr>
                        <tr><td>&nbsp;</td></tr>
                        <tr><td>&nbsp;</td></tr>
                        <tr>
                            <td valign="top" align="center"   bgcolor="#FFFFFF" class="textocom" >
                                    <%
                                       if(est.equals("j         ") || est.equals("i         "))
                                       {
                                            HashMap programamov = emp.programamov(idest);
                                            progmov = (String)programamov.get("prog_mov");
                                            if(est.equals("j         "))
                                                {
                                                  act="disabled";
                                                %>
                                                    <a class="textocom2">"Su ultima solicitud de cambio en el plan de estudio  ha sido enviada al decano y está en estudio"</a>
                                                <%
                                                }
                                            else{
                                                  act="";
                                                %>
                                                <a class="textocom2">"Usted  esta habilitado para solicitar cambios en el plan de estudio"</a>
                                                <%
                                            }%>
                                                
                                               </td>
                        </tr> 
                        <tr><td>&nbsp;</td></tr>
                        <tr><td>&nbsp;</td></tr>
                        <tr><td align="center"><a class="textocom3">Plan de estudio actual</a></td></tr>
                          <tr><td>&nbsp;</td></tr>                      
                                                <%
                                            if(progmov.equals("PRACTICA INTERNACIONAL"))
                                            {

                                    %>
                            
                        
                        <tr>
                            <td>

                                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th ><div align="center"><strong>Periodo</strong></div></th>
                                                                <th ><div align="center"><strong>Empresa</strong></div></th>
                                                                <th ><div align="center"><strong>Materia de la ECI</strong></div></th>
                                                                <th ><div align="center"><strong>Cambiar</strong></div></th>

                                                            </tr>
                                                        </thead>
                                                        <tbody id="cuerpoplanpi">
                                                        </tbody>
                                                </table>

                                    <%
                                              }
                                              else
                                              {
                                                if(progmov.equals("DOBLE TITULACION"))
                                                {
                                        %>
<tr>
                            <td>
                                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th><div align="center"><strong>Periodo</strong></div></th>
                                                                <th><div align="center"><strong>Materia en la Universidad anfitriona</strong></div></th>
                                                                <th ><div align="center"><strong>Cambiar</strong></div></th>

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

<tr>
                            <td>
                                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th><div align="center"><strong>Periodo</strong></div></th>
                                                                <th><div align="center"><strong>Materia en la Universidad anfitriona</strong></div></th>
                                                                <th ><div align="center"><strong>Materia de la ECI</strong></div></th>
                                                                <th ><div align="center"><strong>Cambiar</strong></div></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody id="cuerpoplanpi">
                                                        </tbody>
                                                </table>                                                
                                                <%
                                                }
                                              }
                                            %>
                            </td></tr>
<tr><td>&nbsp;</td></tr>
                        <tr><td>&nbsp;</td></tr>
                          <tr><td align="center"><a class="textocom3">Plan de estudio propuesto</a></td></tr>
                          <tr><td>&nbsp;</td></tr>
<tr>
    <td>
                                            
                                               <%--<table frames="hsides" border="1" align="center"> <tr>
                                                  <td colspan="2" align="center">
                                                     <input class="inputlargo" type="submit" value="mostrar plan actual" name="enviarplan" onclick= " ListaPlanActual(<%=id_sol%>);"/>
                                                  </td>
                                                </tr></table>--%>
                                            
                                                  <table  width="99%" border="1" class="tabla" id="tablaCambioPlan" align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th><div align="center"><strong>Materia Actual</strong></div></th>
                                                                <th><div align="center"><strong>Materia Solicitada</strong></div></th>
                                                                <th><div align="center"><strong>Periodo</strong></div></th>
                                                                <th><div align="center"><strong>Motivo</strong></div></th>
                                                                <th><div align="center"><strong>Elminar</strong></div></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody id="cuerpocambioplan">
                                                        </tbody>
                                                </table>
                                                  <table frames="hsides" align="center">
                                                      <tr>
                                                  <td colspan="2" align="center">
                                                    &nbsp;
                                                  </td>
                                                </tr>
                                                 <tr>
                                                  <td colspan="2" align="center">
                                                    &nbsp;
                                                  </td>
                                                </tr>
                                                      <tr>
                                                  <td colspan="2" align="center">
                                                     <input class="inputlargo" type="submit" value="Enviar Solicitud de Cambio" name="enviarplan" onclick= " Enviarcambioplan(<%=id_sol%>,<%=idest%>);"<%=act%>/>
                                                  </td>
                                                </tr>
                                                <tr>
                                                  <td colspan="2" align="center">
                                                    &nbsp;
                                                  </td>
                                                </tr>
                                                <tr>
                                                  <td colspan="2" align="center">
                                                    &nbsp;
                                                  </td>
                                                </tr>
                                            </table>
                                            <%
                                           }

                                           else{
                                           %>
                                           <p>"Usted no esta habilitado para solicitar cambios en el plan de estudio"</p>
                                             <a onclick="location = 'EstMov'">
                                                       <font id="noB" color="#000000">Consultar estado</font>
                                             </a>
                                           <br><br><br>
                                           <%
                                            }

                                       %>
                                            <button class="button_azul"type="button" name="Atras" onclick= "window.location.href='EstMov'">
                                              <strong>Atras</strong>
                                            </button>
                        <script type="text/javascript">
    ListaPlanActual(<%=id_sol%>);                          
    
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
    </body>
</html>

