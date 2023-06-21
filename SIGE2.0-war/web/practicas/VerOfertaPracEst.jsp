<%-- 
    Document   : VerOfertaPracEst
    Created on : 16/01/2013, 10:59:58 AM
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

<html>
    <head>
        <%
            response.setHeader("Cache-Control","no-cache");
            
            String UA = request.getHeader("User-Agent");
            boolean isMS = (UA != null && UA.indexOf("MSIE") != -1);
            
            documentos.ruta ruta = new documentos.ruta();

            String idreq;
            String idofer;
            String idemp;
            String estApl = new String();
            String doc_grad = new String();
            String usuario = new String();
            String idest = new String();
            String estMsg = new String();
            String estSol = new String();


            login.SessionEstRemote estudiante =(login.SessionEstRemote)session.getAttribute("usuario");

            if (estudiante == null) {
                %><script>
                    alert("El usuario no está autenticado o su sesión ha finalizado.");
                    window.location = 'loginestMov';
                  </script><%
                return;
            }

            usuario=estudiante.getUser();
            inicio.conectaEJB conEjb = new inicio.conectaEJB();
            EstudiantesRemote emp = conEjb.lookupEstudiantesRemote();
            emp.inicializar("75107740");
            session.setAttribute("emp", emp );
            HashMap id_est = emp.getEmplId(usuario);
            idest= (String)id_est.get("PEOPLE_ID");
            idreq = request.getParameter("idreq");
            idofer = request.getParameter("idofer");
            idemp = request.getParameter("idemp");
            session.setAttribute("emp", emp );

            HashMap DatosEmp = emp.getDatosEmpPracEst(idemp);
            HashMap DatosOfer = emp.getDatosOferPracEst(idofer);
            HashMap estado = emp.estadoAplicacionPracEst(idofer,idest);
            HashMap mensaje = emp.mensajeEstApliPrac(estApl);
            HashMap estadoSol = emp.estadoAplicanteprac(idest);

            estApl = (String) estado.get("estado_apli");
            if(estApl == null) estApl="";
            
            //Define las fechas definidas por la UGE y comprueba si la fecha actual se encuentra dentro de esta.
            Calendar hoy = Calendar.getInstance();
            hoy.getTime();
            
            HashMap[] fechasemp = emp.getFechasPracticasEst();
            
            int year_in = Integer.parseInt((String) fechasemp[0].get("year"));
            int year_out = Integer.parseInt((String) fechasemp[1].get("year"));
            int mes_in = Integer.parseInt((String) fechasemp[0].get("mes"));
            int mes_out = Integer.parseInt((String) fechasemp[1].get("mes"));
            int dia_in = Integer.parseInt((String) fechasemp[0].get("dia"));
            int dia_out = Integer.parseInt((String) fechasemp[1].get("dia"));
                      
            Calendar fInApl = Calendar.getInstance();
            Calendar fOutApl = Calendar.getInstance();
            
            fInApl.set(year_in, mes_in-1, dia_in, 0, 0, 0);
            fOutApl.set(year_out, mes_out-1, dia_out, 24, 59, 59);
            
            String periodoApli = "bloquearApli";
            
            if ((hoy.after(fInApl) || hoy.equals(fInApl)) && (hoy.before(fOutApl) || hoy.equals(fOutApl))) {
                periodoApli = "activarApli";
            }
            
            estMsg = (String) mensaje.get("men_usr");
            if (estMsg == null) estMsg = "Ninguno";

            estSol = (String) estadoSol.get("estado");
            if (estSol == null) estSol = "init";
            estSol = estSol.trim();

            if (!estSol.equals("c")) {
                %><script>
                    alert("Debe tener una solicitud aprobada por su decano para éste semestre para poder visualizar las ofertas de prácticas.");
                    window.history.back();
                  </script><%
                return;
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <style type="text/css">
.f {
	color: #FFF;
}
.textoblanco {
	color: #FFF;
}
</style>
<title>Menu Sige</title>
         <script type="text/javascript" src="jscript/conectar.js"></script>
        <script language="javascript" type="text/javascript" src="jscript/practicas/FunEstPrac.js" ></script>
        <script language="javascript" type="text/javascript" src="jscript/movilidad/funcion1.js" ></script>
        <link href="CSS/practicas.css" rel="stylesheet" type="text/css">
</head>

<body >
        <p class="textocom">&nbsp;</p>
        <jsp:include page="encabezado_prac"></jsp:include>
            <div align="center">
                <fieldset class="field_set">
<table width="700" height="752"  align="center">
     
  <tr>
    <td width="700" align="center" valign="middle">
    <table width="700"  align="center">
      <tr height="16"></tr>
      <tr >
        <td colspan="2" align="center" ><a class="textocom3">Datos de la empresa oferente</a></td>
      </tr>
      <tr height="16"></tr>
      <tr class="textocom">
        <td width="25%" align="left"><strong>Razón Social:</strong></td>
        <td width="75%" align="left"><%=DatosEmp.get("razon_social")%></td>
      </tr >
      <tr class="textocom">
        <td  align="left"><strong>Direccion:</strong></td>
        <td align="left"><%=DatosEmp.get("dir_empresa")%></td>
      </tr>
      <tr class="textocom">
        <td align="left"><strong>Página Web:</strong></td>
        <td align="left"><%=DatosEmp.get("web_empresa")%></td>
      </tr>
      <%--
      <tr class="textocom" >
        <td><strong>Nombre del contacto:</strong></td>
        <td align="left"><%=DatosEmp.get("nom_contacto")%></td>
      </tr>
      <tr class="textocom" >
        <td><strong>Telefono de contacto:</strong></td>
        <td align="left"><%=DatosEmp.get("tel_contacto")%></td>
      </tr>
      <tr class="textocom" >
        <td><strong>Email de contacto:</strong></td>
        <td align="left"><%=DatosEmp.get("email_contacto")%></td>
      </tr>
      --%>
      <tr height="16"></tr>
      <tr>
        <td colspan="2" align="center" ><a class="textocom3">Práctica Ofrecida</a></td>
      </tr>
      <tr height="16"></tr>
      <tr class="textocom">
        <td align="left"><strong>Cargo a desempeñar:</strong></td>
        <td align="left"><%=DatosOfer.get("cargo")%></td>
      </tr>
      <tr class="textocom">
        <td align="left" valign="top"><p><strong>Descripcion:</strong></p></td>
        <td align="left"><<%=isMS?"div":"pre"%> class="textocom" style="margin: 13px 0px; text-align: justify; white-space: pre-wrap;"><%=DatosOfer.get("descripcion")%></<%=isMS?"div":"pre"%>></td>
      </tr>
      <tr class="textocom">
        <td align="left" valign="top"><p><strong>Requisitos</strong></p></td>
        <td align="left"><<%=isMS?"div":"pre"%> class="textocom" style="margin: 13px 0px; text-align: justify; white-space: pre-wrap;"><%=DatosOfer.get("requisitos")%></<%=isMS?"div":"pre"%>></td>
      </tr>
      <tr class="textocom">
        <td align="left"><strong>Area:</strong></td>
        <td align="left"><%=DatosOfer.get("area_oferta")%></td>
      </tr>
      <tr class="textocom">
        <td align="left"><strong>País:</strong></td>
        <td align="left"><%=DatosOfer.get("pais_oferta")%></td>
      </tr>
      <tr class="textocom">
        <td align="left"><strong>Ciudad:</strong></td>
        <td align="left"><%=DatosOfer.get("ciudad_oferta")%></td>
      </tr>
      <tr class="textocom">
        <td align="left"><strong>Jornada:</strong></td>
        <td align="left"><%=DatosOfer.get("horario_oferta")%></td>
      </tr>
      <tr class="textocom">
        <td align="left"><strong>Tipo de Contrato:</strong></td>
        <td align="left"><%=DatosOfer.get("tipo_contrato")%></td>
      </tr>
      <tr class="textocom">
        <td align="left"><strong>Apoyo Económico(COL$):</strong></td>
        <td align="left"><%=DatosOfer.get("salario_oferta")%></td>
      </tr>
      <tr class="textocom">
        <td align="left" height="49"><strong>Salud y Riesgos Profesionales </strong></td>
        <td align="left"><%=DatosOfer.get("seguro_arp")%></td>
      </tr>
      <tr class="textocom">
        <td align="left" height="23"><strong>Fecha de inicio:</strong></td>
        <td align="left"><%=DatosOfer.get("fecha_in")%></td>
      </tr>
      <tr class="textocom">
        <td align="left" height="27"><strong>Fecha de Finalización: </strong></td>
        <td align="left"><%=DatosOfer.get("fecha_out")%></td>
      </tr>
      <%--<tr class="textocom" >
        <td align="left" height="28"><p><strong>Nombre del Supervisor o Jefe:</strong></p></td>
        <td align="left"><%=DatosOfer.get("nom_jefe")%></td>
      </tr>
      <tr class="textocom" >
        <td align="left" height="27"><strong>Cargo:</strong></td>
        <td align="left"><%=DatosOfer.get("cargo_jefe")%></td>
      </tr>
      <tr class="textocom" >
        <td align="left" height="27"><strong>Telefono:</strong></td>
        <td align="left"><%=DatosOfer.get("tel_jefe")%></td>
      </tr>
      <tr class="textocom" >
        <td align="left" height="27"><strong>Email:</strong></td>
        <td align="left"><%=DatosOfer.get("email_jefe")%></td>
      </tr>--%>
      <tr height="16"></tr>
      <tr class="textocom">
        <td colspan="2" align="center" ><a class="textocom3">Información Adicional</a></td>
      </tr>
      <tr height="16"></tr>
      <tr class="textocom">
        <td align="left"><strong>Fecha de publicación:</strong></td>
        <td align="left"><%=DatosOfer.get("fecha_publicacion")%></td>
      </tr>
      <tr class="textocom">
        <td align="left"><strong>Fecha de vencimiento:</strong></td>
        <td align="left"><%=DatosOfer.get("fecha_limite")%></td>
      </tr>
      <tr height="16"></tr>
      <tr class="textocom">
        <td align="left"><strong>Estado de la Aplicacion:</strong></td>
        <td align="left"><%=estMsg%></td>
      </tr>
      <tr height="16">
        <td colspan="2" align="center" ><a class="textocom3">&nbsp;</a></td>
      </tr>
      <% 
          if(periodoApli.equals("activarApli")){
              if (estApl.equals("")) {
      %>
      <tr class="textocom">
        <td colspan="2">
            <input id="btnAplicarOferPrac" class="button_azul_consulta1" type="submit" value="Aplicar" name="vobocarta" onclick= "AplicarOferprac('<%=idofer%>','<%=idest%>');"/>
        </td>
      </tr>
      <%
              } else {
      %>
      <tr class="textocom">     
        <td colspan="2">           
            <a class="texto_rojo2">
                Usted ya ha aplicado a esta oferta.
            </a> 
        </td>
      </tr>
      <%
              }
          } else {
      %>
      <tr class="textocom">     
        <td colspan="2">           
            <a class="texto_rojo2">
                El periodo para aplicar a las ofertas de prácticas es 
                desde el 
                <%=fechasemp[0].get("dia")%>/<%=fechasemp[0].get("mes")%>/<%=fechasemp[0].get("year")%> 
                hasta el 
                <%=fechasemp[1].get("dia")%>/<%=fechasemp[1].get("mes")%>/<%=fechasemp[1].get("year")%>
            </a>
        </td>
      </tr>
      <%
          }
      %>
      <tr height="32"></tr>
      <tr>
        <td colspan="2">           
          <input class="button_rojo"type="submit" value="Salir" name="vobocarta" onclick="DejarPendiente();"/>
        </td>        
      </tr>
    </table>
    </td>
  </tr>
     <tr>
       <td colspan="2">
         <jsp:include page="footer">
             <jsp:param name="type" value="prac" />
         </jsp:include>
       </td>
    </tr>
</table>
       </fieldset>  
        </div>
</body>
</html>
