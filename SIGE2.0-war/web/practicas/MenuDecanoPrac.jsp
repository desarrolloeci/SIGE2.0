<%-- 
    Document   : MenuDecanoPrac
    Created on : 10/12/2012, 03:36:47 PM
    Author     : Luis Alberto Salas
--%>



<%@page import="BDsige.EstudiantesRemote"%>
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
            login.SessionUsrRemote admin =(login.SessionUsrRemote) session.getAttribute("usuario");

            if (admin == null) {
                %>
                    <script>
                        alert("El usuario no está autenticado o su sesión ha finalizado.");
                        window.location = 'loginDec';
                    </script>
                <%
                return;
            }

            String rol = new String ();
            String usuario = new String ();
            usuario=admin.getUser();
            rol=admin.getRol();
            String arreglo[]=new String[50];
            String texto[]=new String[20];
            String noticias[]=new String[200];
            int i=0, not=0;
            int conmenu = 0;
            int k=0;

            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
            emp.inicializar("75107740");
            
            //Define las fechas definidas por la UGE y comprueba si la fecha actual se encuentra dentro de esta.
            Calendar hoy = Calendar.getInstance();
            hoy.getTime();
            
            HashMap[] fechasemp = emp.getFechasPracticasEst();
            
            int year_in = Integer.parseInt((String) fechasemp[6].get("year"));
            int year_out = Integer.parseInt((String) fechasemp[7].get("year"));
            int mes_in = Integer.parseInt((String) fechasemp[6].get("mes"));
            int mes_out = Integer.parseInt((String) fechasemp[7].get("mes"));
            int dia_in = Integer.parseInt((String) fechasemp[6].get("dia"));
            int dia_out = Integer.parseInt((String) fechasemp[7].get("dia"));
            
            Calendar fInDec = Calendar.getInstance();
            Calendar fOutDec = Calendar.getInstance();
            
            fInDec.set(year_in, mes_in-1, dia_in, 0, 0, 0);
            fOutDec.set(year_out, mes_out-1, dia_out, 24, 59, 59);
            
            String periodoDec = "bloquearDec";
            
            if ((hoy.after(fInDec) || hoy.equals(fInDec)) && (hoy.before(fOutDec) || hoy.equals(fOutDec))) {
                periodoDec = "activarDec";
            }

            try {
                FileReader ra = new FileReader(ruta.valruta() + "serviciosSIGEPrac.txt");
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
                i=i-1;
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
        <title>SIEMPREG Prácticas Profesionales - Menú Decanatura</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>       
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunDecPrac.js" ></script>

        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
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
        </style>
    </head>
    <body>
        <jsp:include page="header">
            <jsp:param name="type" value="prac" />
        </jsp:include>
        <table width="750" align="center" class="curvas loginPanel" cellspacing="10">
            <tr class="textocom">
                <td align="center" style="padding-bottom: 5px; width: 30%;">
                    <font color="#990000"><strong>Opciones</strong></font>
                </td>
                <td width="70%"></td>
            </tr>
            <tr bgcolor="#FFFFFF" class="textocom">
            <td width="30%" valign="top">
                    <%
                      if(error.equals("OK"))
                      {
                        for (int j=0; j<=i; j++)
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


                            if(texto[2].equals("0")){
                        %>
                             <table width="200"   cellspacing="0" >

                                        <tr>
                                            <td width="200" height="20" bgcolor="FFFFFF" class="menuprueba" >
                                                <div align="left">
                                                    <a onclick="<%=texto[5]%>">
                                                       <font id="f<%=conmenu%>" color="#000000"><%=texto[4]%> </font></a></div>
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

                <td width="70%">
                    <table width="500" frame="lhs" >
                        <tr>
                            <td valign="top" height="500"  class="textocom" >
                                <div align="left" id="consultaPracDec" style="display: none">
                                <table  width="480"  cellspacing="0">
                                     <tr><td>&nbsp;</td></tr>
                                     <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <td>
                                                <a class="textocom3">
                                                   Ofertas de prácticas
                                                </a>
                                            </td>
                                </tr>
                                <tr><td>&nbsp;</td></tr>
                                <tr>
                                            <td align="left" >
                                                <a class="textocom">
                                                    <% if (periodoDec.equals("activarDec")) {%>
                                                    El botón "Pendientes" listará las ofertas que tiene pendientes por tramitar.<br>
                                                    El botón "Aprobadas" listará las ofertas que usted ya aprobó y que se han hecho públicas hacia los estudiantes.<br>
                                                    El botón "Rechazadas" listará las ofertas que usted ha rechazado.<br>
                                                    <% } else {%>
                                                    El periodo para que la decanatura tramite las ofertas de prácticas es 
                                                    desde el 
                                                    <%=fechasemp[6].get("dia")%>/<%=fechasemp[6].get("mes")%>/<%=fechasemp[6].get("year")%> 
                                                    hasta el 
                                                    <%=fechasemp[7].get("dia")%>/<%=fechasemp[7].get("mes")%>/<%=fechasemp[7].get("year")%> <br><br>
                                                    El botón "Aprobadas" listará las ofertas que usted ya aprobó y que se han hecho públicas hacia los estudiantes.<br>
                                                    El botón "Rechazadas" listará las ofertas que usted ha rechazado.<br>
                                                    <% }%>
                                                </a>
                                            </td>
                                </tr>
                                <tr><td>&nbsp;</td></tr>
                                <tr>
                                            <td align="left" >
                                                
                                                   &nbsp;

                                                
                                            </td>
                                </tr>
                                </table>
                                </div>
                                <div align="left" id="consultaPracDec2" style="display: none">
                                <table  width="480"  cellspacing="0">
                                        <tr>
                                        <p>
                                        <select name="TipoConsultaPracDec2" id="TipoConsultaPracDec2">
                                            <option value="Pendiente" >Pendiente</option>
                                            <option value="Aprobado">Aprobado</option>
                                            <option value="Rechazado">Rechazado</option>
                                        </select>
                                        </p>
                                </tr>
                                </table>
                                </div>
                                <div align="left" id="consultaSolPracDec" style="display: none">
                                <table  width="480"  cellspacing="0">
                                        <tr><td>&nbsp;</td></tr>
                                     <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <td>
                                                <a class="textocom3">
                                                   Solicitudes de estudiantes
                                                </a>
                                            </td>
                                </tr>
                                <tr><td>&nbsp;</td></tr>
                                <tr>
                                            <td align="left" >
                                                <a class="textocom">                                                    
                                                    El botón “Tiempo completo” listará las solicitudes de estudiantes que quieren realizar prácticas de tiempo completo que no han sido tramitadas.<br>
                                                    El botón “Medio tiempo” listará las solicitudes de los estudiantes que quieren realizar prácticas de medio tiempo que no han sido tramitadas.<br>
                                                    El botón “Todos” listará todas las solicitudes que no han sido tramitadas. <br><br>
                                                    Si desea consultar una solicitud ya tramitada lo puede hacer en la opción “Formalizar practica” en el menú de la izquierda <br>
                                                </a>
                                            </td>
                                </tr>
                                <tr><td>&nbsp;</td></tr>
                                <tr>
                                            <td align="left" >
                                                
                                                   &nbsp;

                                                
                                            </td>
                                </tr>
                                </tr>
                                </table>
                               </div>
                               <div align="left" id="consultaEstPracDec" style="display: none">
                                <table  width="480"  cellspacing="0">
                                <tr><td>&nbsp;</td></tr>
                                <tr><td>&nbsp;</td></tr>
                                <tr>
                                    <td>
                                        <a class="textocom3">
                                            Consultar estado de estudiantes
                                        </a>
                                    </td>
                                </tr>
                                
                                <tr><td>&nbsp;</td></tr>
                                </table>
                               </div>
                               <div align="left" id="consultaPracFor" style="display: none">
                               <table width="480"  cellspacing="0">
                                   <tr height="32"></tr>
                                   <tr>
                                       <td>
                                           <a class="textocom3">
                                               Formalizar estudiantes
                                           </a>
                                       </td>
                                   </tr>
                                   <tr height="16"></tr>
                               </table>
                               <p>
                               <select name="TipoConsultaPracFor" id="TipoConsultaPracFor">
                                   <option value="Pendiente">Pendiente</option>
                                   <option value="Aprobado">Formalizado</option>
                               </select>
                               </p>
                               </div>
                                
                                <div align="left" id="botonconsultaOfertaPrac" style="display: none">
                                   
                                    <table  width="480"  cellspacing="0">
                                        <tr>
                                             <%if(periodoDec.equals("activarDec")){%>
                                            <td>
                                                 <input class="button_azul_consulta"type="submit" value="Pendientes" name="consultar" onclick= "consultaOferPracDec(<%=rol%>,'Pendiente');"/>
                                            </td>
                                            <%}%>
                                            <td>
                                                 <input class="button_azul_consulta"type="submit" value="Aprobadas" name="consultar" onclick= "consultaOferPracDec(<%=rol%>,'Aprobada');"/>
                                            </td>
                                            <td>
                                                 <input class="button_azul_consulta"type="submit" value="Rechazadas" name="consultar" onclick= "consultaOferPracDec(<%=rol%>,'Rechazada');"/>
                                            </td>
                                        </tr>
                                        
                                    </table>
                                            
                                </div>
                                <div align="left" id="botonconsultaSolPracDec" style="display: none">
                                    <table  width="480"  cellspacing="0">
                                        <tr>
                                            <td>
                                                 <input class="button_azul_consulta"type="submit" value="Todos" name="consultar" onclick= "consultaSolPracDec(<%=rol%>,'TODOS');"/>
                                            </td>
                                            <td>
                                                 <input class="button_azul_consulta"type="submit" value="Tiempo completo" name="consultar" onclick= "consultaSolPracDec(<%=rol%>,'TIEMPO COMPLETO');"/>
                                            </td>
                                            <td>
                                                 <input class="button_azul_consulta"type="submit" value="Medio tiempo" name="consultar" onclick= "consultaSolPracDec(<%=rol%>,'MEDIO TIEMPO');"/>
                                            </td>
                                        </tr>
                                      
                                    </table>
                                </div>
                                            
                                <div align="left" id="botonconsultaEstPracDec" style="display: none">
                                    <table  width="480"  cellspacing="0">
                                        <tr>
                                            <td>
                                                 <input type="submit" value="Consultar" name="consultar" onclick= "consultaEstPracDec('<%=rol%>');"/>
                                            </td>
                                        </tr>
                                      
                                    </table>
                                </div>
                                            
                                    <div align="left" id="botonconsultaForPracDec" style="display: none">
                                    <table  width="480"  cellspacing="0">
                                        <input type="submit" value="consultar" name="consultar" onclick= "consultaForPracDec(<%=rol%>);"/>
                                    </table>
                                </div>
                                <div align="left" id="tablaconsultaOfertaPrac" style="display: none">
                                      <table  width="90%" border="1" class="tabla" id="TablaOferPracDec" align="left" >
                                            <thead>
                                                <tr>
                                                    <th width="20%"><div align="center"><strong>Nombre del cargo </strong></div></th>
                                                    <th width="20%"><div align="center"><strong>Empresa</strong></div></th>
                                                    <th width="10%"><div align="center"><strong>Fecha de ven.</strong></div></th>
                                                </tr>
                                            </thead>
                                            <tbody id="cuerpotablaOfertaPrac">
                                            </tbody>
                                        </table>
                                </div>
                                <div align="left" id="tablaconsultaSolPracDec" style="display: none">
                                    <table  width="90%" border="1" class="tabla" id="TablaSolPracDec" align="left" >
                                        <thead>
                                        <tr>
                                            <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                            <th width="20%"><div align="center"><strong>Tipo</strong></div></th>
                                        </tr>
                                        </thead>
                                        <tbody id="cuerpoTablaSolPracDec">
                                        </tbody>
                                    </table>
                                </div>
                                    
                                <div align="left" id="tablaconsultaEstPracDec" style="display: none">
                                    <table  width="80%" border="1" class="tabla" id="TablaEstPracDec" align="center" >
                                        <thead>
                                        <tr>
                                            <th width="20%"><div align="center"><strong>Nombre</strong></div></th>
                                            <th width="20%"><div align="center"><strong>Estado Actual</strong></div></th>
                                        </tr>
                                        </thead>
                                    
                                        <tbody id="cuerpoTablaEstPracDec">
                                        </tbody>
                                    </table>
                                </div>
                                    
                                <div align="left" id="tablaconsultaForPracDec" style="display: none">
                                  <table  width="90%" border="1" class="tabla" id="TablaForPracDec" align="center" >
                                      <thead>
                                      <tr>
                                          <th width="25%"><div align="center"><strong>Nombre</strong></div></th>
                                          <th width="25%"><div align="center"><strong>Contratado por</strong></div></th>
                                          <th width="25%"><div align="center"><strong>Cargo</strong></div></th>
                                          <th width="25%"><div align="center"><strong>Tutor</strong></div></th>
                                      </tr>
                                      </thead>
                                      <tbody id="cuerpoTablaForPracDec">
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
    </body>
</html>

