<%-- 
    Document   : plandeestudio
    Created on : 6/09/2012, 10:21:13 AM
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
    
    usuario = estudiante.getUser();
    
    HashMap datosetr;
    inicio.conectaEJB conEjb = new inicio.conectaEJB();
    EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
    emp.inicializar("75107740");
    session.setAttribute("emp", emp ) ;
    HashMap id_est = emp.carnetEst(usuario);
    idest= (String)id_est.get("id_est");
    HashMap estado = emp.estadoAplicante(idest);
    est = (String)estado.get("estado");
    HashMap idsol = emp.IdAplicacion(idest);
    id_sol = (String)idsol.get("id_solicitud");
    if (id_sol==null) {
        id_sol="1";
    }
   
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIEMPREG Movilidad - Plan de estudio</title>
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
            <tr class="textocom">
                <td width="100%" height="20">
                    <font color="#FFFFFF"><strong>Plan de Estudio</strong></font>
                </td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">

                <td align="left">
                    <table width="90%" border="0"  cellspacing="0" align="center">

                        <tr>
                            <td class="textocom" style="vertical-align: top;">
                                    <%
                                       if(est.equals("f         ") || est.equals("g         "))
                                       {
                                            HashMap programamov = emp.programamov(idest);
                                            progmov = (String)programamov.get("prog_mov");
                                            if(est.equals("g         "))
                                                {
                                                  act="disabled";
                                                %>

                                                <p>"Su plan de estudio ha sido enviado al decano y está en estudio del mismo  "</p>
                                                <%
                                                }
                                            else{
                                                  act="";
                                                %>
                                                <p>"Usted está habilitado para modificar su plan de estudio"</p>
                                                <%
                                            }
                                            if(progmov.equals("PRACTICA INTERNACIONAL"))
                                            {

                                    %>
                                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th ><div align="center"><strong>Periodo</strong></div></th>
                                                                <th ><div align="center"><strong>Empresa</strong></div></th>
                                                                <th ><div align="center"><strong>Materia de la Escuela</strong></div></th>
                                                                <th ><div align="center"><strong>Eliminar</strong></div></th>

                                                            </tr>
                                                        </thead>
                                                        <tbody id="cuerpoplanpi">
                                                        </tbody>
                                                </table>
                                                
                                            <table frames="hsides">
                                                <tr>
                                                  <td width="30%" >
                                                      Nombre de la empresa donde va a realizar la practica
                                                  <td >
                                                       <input name="Matext" id="Matext" type="text" size="20" maxlength="70"> (no utilice siglas)
                                                  </td>
                                              </tr>
                                              <tr>
                                                  <td >
                                                     Materia en la Escuela
                                                  </td>
                                                  <td >
                                                      <input name="Mateci" id="Mateci" type="text" size="20" maxlength="70"> (no utilice siglas)
                                                  </td>
                                              </tr>
                                              <tr>
                                                  <td >
                                                     Periodo en el que va a realizar la practica
                                                  </td>
                                                  <td >
                                                      <input name="periodomat" id="periodomat" type="text" size="20" maxlength="70"> (pp-aaaa)
                                                  </td>
                                              </tr>
                                            </table>
                                    <%
                                              }
                                              else
                                              {
                                                if(progmov.equals("DOBLE TITULACION"))
                                                {
                                        %>
                                                 
                                                <table  width="90%" border="1" class="tabla" id="tablaPlanest" align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th><div align="center"><strong>Periodo</strong></div></th>
                                                                <th><div align="center"><strong>Materia en la Universidad anfitriona</strong></div></th>
                                                                <th ><div align="center"><strong>Eliminar</strong></div></th>

                                                            </tr>
                                                        </thead>
                                                        <tbody id="cuerpoplanpi">
                                                        </tbody>
                                                </table>
                                                 <table frames="hsides">
                                                     <tr>

                                                  <td colspan="2">
                                                      <input name="Mateci" id="Mateci" type="text" size="20" maxlength="70" value="DOBLE TITULACION"> 
                                                  </td>
                                              </tr>
                                              <tr>
                                                  <td  width="30%">
                                                     Materia en la Universidad Anfitriona
                                                  </td>
                                                  <td >
                                                      <input name="Matext" id="Matext" type="text" size="20" maxlength="70"> (no utilice siglas)
                                                  </td>
                                              </tr>
                                              <tr>
                                                  <td >
                                                     Periodo en el que va a tomar la materia
                                                  </td>
                                                  <td >
                                                      <input name="periodomat" id="periodomat" type="text" size="20" maxlength="70"> (pp-aaaa)
                                                  </td>
                                              </tr>
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
                                                                <th ><div align="center"><strong>Materia de la Escuela</strong></div></th>
                                                                <th ><div align="center"><strong>Eliminar</strong></div></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody id="cuerpoplanpi">
                                                        </tbody>
                                                </table>
                                                <p>Si desea agregar una materia por favor diligencie los siguientes campos y de click en el botón de registrar materia </p>
                                                <table frames="hsides" border="1" >
                                                <tr>
                                                  <td width="30%" >
                                                     Materia en la universidad anfitriona
                                                     </td>
                                                  <td >
                                                       <input name="Matext" id="Matext" type="text" size="20" maxlength="70"> (no utilice siglas)
                                                  </td>
                                              </tr>
                                              <tr>
                                                  <td >
                                                     Materia en la Escuela
                                                  </td>
                                                  <td >
                                                      <input name="Mateci" id="Mateci" type="text" size="20" maxlength="70"> (no utilice siglas)
                                                  </td>
                                              </tr>
                                              <tr>
                                                  <td >
                                                     Periodo en el que va a tomar la materia
                                                  </td>
                                                  <td >
                                                      <input name="periodomat" id="periodomat" type="text" size="20" maxlength="70"> (pp-aaaa)
                                                  </td>
                                              </tr>

                                            </table>
                                                <%
                                                }
                                              }
                                            %>
                                            
                                            <table frames="hsides" align="center">
                                                <tr>
                                                  <td colspan="2" align="center">
                                                      <input class="button_azul_consulta1" type="submit" value="Registrar materia al plan de estudio" name="registrarmat" onclick= " Registrarmat(<%=id_sol%>,'<%=progmov%>');"<%=act%>/>
                                                  </td>
                                                </tr>
                                            </table>
                                            <p></p>
                                            <p>Antes de enviar el plan de estudio verifique que este registrado correctamente</p>
                                            <input class="button_azul_consulta1" type="submit" value="Enviar Plan de estudio al decano" name="enviarplan" onclick= " Enviarplan(<%=id_sol%>,<%=idest%>);"<%=act%>/>
                                            <%
                                           }

                                           else{
                                           %>
                                           "Usted no esta habilitado para enviar su plan de estudio."
                                             
                                           <%
                                            }

                                       %>
                                                        <div align="center" >
                                    <br>
                                    <input class="button_azul1" type="submit" onclick="window.history.back()" value="Volver" />
        
        </div>
                        <script type="text/javascript">
                              ListaPlan(<%=id_sol%>);
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
