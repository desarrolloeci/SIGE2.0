/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import BDsige.Persona;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Mario Martínez
 */
@Stateless
public class EnviarEmail extends Persona implements SessionBean, EnviarEmailRemote {
    
    private SessionContext context;
    
    private static final int practicas = 0;
    private static final int graduados = 1;
    private static final int movilidad = 2;
    
    private static final String SMTP = "smtp.office365.com"; 
    private static final String mailCompl = "@escuelaing.edu.co";
    private static final String mailComplEst = "@mail.escuelaing.edu.co";
    
    private static final String logInP = "practicas" + mailCompl;
    //private static final String authP = "practicas2016-1";
    private static final String authP = "carlomagno123";
    
    private static final String logInG = "graduados"  + mailCompl;
    //private static final String authG = "escuelagraduados";
    private static final String authG = "escuelagraduados2017";
    
    private static final String logInM = "ori" + mailCompl;
    //private static final String authM = "Ori2016";
    private static final String authM = "InternacionalING21#";
    
    private String origen;
    private String auth;
    
    //private static final String emailCCO = "mario.martinez" + mailCompl;
    
    private Properties mailProperties = new Properties();
    
    public EnviarEmail() {
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.starttls.enable", "true");
        mailProperties.put("mail.smtp.host", SMTP);
        mailProperties.put("mail.smtp.port", "587");
    }

    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }

    public void ejbRemove() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ejbActivate() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ejbPassivate() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void defineSystem(int sistema) {
        if (sistema == practicas) {
            origen = logInP;
            auth = authP;
        } else if (sistema == graduados) {
            origen = logInG;
            auth = authG;
        } else {
            origen = logInM;
            auth = authM;
        }
    }

    private Session getAuth() {
        return Session.getInstance(mailProperties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(origen, auth);
            }
        });
    }
    
    private boolean sendEmail(String asunto, String[] destino, String cuerpo, Session authSession) {
        try {
            //Body
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setText(cuerpo, "UTF-8", "html");

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(mbp);

            //Header
            MimeMessage msg = new MimeMessage(authSession);
            msg.setFrom(new InternetAddress(origen));
            if (destino[0].length() > 0) msg.setRecipients(Message.RecipientType.TO, destino[0]);
            if (destino.length > 1 && destino[1].length() > 0 ) msg.setRecipients(Message.RecipientType.CC, destino[1]);
            //msg.setRecipients(Message.RecipientType.BCC, emailCCO);
            if (destino.length > 2 && destino[2].length() > 0 ) msg.addRecipients(Message.RecipientType.BCC, destino[2]);
            msg.setSubject(asunto);
            msg.setSentDate(new Date());

            msg.setContent(multipart);
            
            //descomentar
            Transport.send(msg);
            
            return true;
        } catch (Exception err) {
            Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, err);
            err.printStackTrace();
            return false;
        }
    }
    
    
    /* MOVILIDAD */
    
    @Override
    public int enviar(String id, String tipo) throws Exception {
        //cambioplan_dec
        //solplan_dec
        //sol_dec
        HashMap emails;
        
        String asunto = "Sistema SIEMPREG - Movilidad Estudiantil";
        String cuerpo = getMsgMov(tipo, id);

        defineSystem(movilidad);

        Session authSession = getAuth();
        authSession.setDebug(true);
        
        String id_dpto;
        HashMap regIdDpto;
        if (tipo.equals("sol_dec")) {
            regIdDpto = bDatos.getRegistro( "SELECT B.id_dpto id_dpto FROM uge.ps_ec_ib_into_vw A, uge.homol_progs_campus B, uge.solicitud_mov C WHERE A.EMPLID=C.id_est AND C.acad_prog=B.ACAD_PROG AND A.EMPLID='" + id + "'");
            id_dpto = (String) regIdDpto.get("id_dpto");

        } else if (tipo.equals("solplan_dec") || tipo.equals("cambioplan_dec")) {
            regIdDpto = bDatos.getRegistro( "SELECT B.id_dpto id_dpto FROM uge.ps_ec_ib_into_vw A, uge.homol_progs_campus B, uge.solicitud_mov C WHERE A.EMPLID=C.id_est AND C.acad_prog=B.ACAD_PROG AND C.id_solicitud='" + id + "'");
            id_dpto = (String) regIdDpto.get("id_dpto");
        } else {
            return 0;
        }
        
        emails = bDatos.getRegistro("SELECT email_usr, email_copia " +
                                    "FROM uge.usr_sige " +
                                    "WHERE rol_usr='" + id_dpto + "'");
        String[] destino = {
            ((String) emails.get("email_usr")) + mailCompl, 
            (((String) emails.get("email_copia")).length() > 0)?((String) emails.get("email_copia")) + mailCompl:""
        };
        
        if (sendEmail(asunto, destino, cuerpo, authSession)) return 1;
        return 0;
    }
    
    @Override
    public int enviarEst(String id, String tipo) throws Exception {
        //CamPlanAcep
        //devplan_est
        //CamPlanRec
        //rechazo_carta
        //VoBo_carta
        //entrevista
        
        //obv_plan
        //obv_docu
        //obv_cartaeci
        //obv_vice
        HashMap emails;
        
        String asunto = "Sistema SIEMPREG - Movilidad Estudiantil";
        String cuerpo = getMsgMov(tipo, id);
        
        defineSystem(movilidad);

        Session authSession = getAuth();
        authSession.setDebug(true);

        emails = bDatos.getRegistro("select (select EMAIL_ADDR from uge.ps_ec_ib_intp_vw where EMPLID= A.id_est) as emails from uge.solicitud_mov A where A.id_solicitud='"+id+"'");
        String destino = ((String) emails.get("emails"));
        
        if (sendEmail(asunto, new String[]{destino}, cuerpo, authSession)) return 1;
        return 0;
    }
    
    
    @Override
    public int enviarEstFormalizaTutor(String idapli) throws Exception {
      
        HashMap[] listado;

        String asunto = "Sistema SIEMPREG - Prácticas Profesionales: Una empresa ha enviado una oferta";
        
        defineSystem(practicas);

        Session authSession = getAuth();
        authSession.setDebug(true);
        
        listado = bDatos.getRegistros("Select P.id_documento, RE.FIRST_NAME+' '+RE.MIDDLE_NAME+' '+RE.LAST_NAME+' '+RE.SECOND_LAST_NAME nom_est, RE.EMAIL_ADDR as emails, RP.FIRST_NAME+' '+RP.MIDDLE_NAME+' '+RP.LAST_NAME+' '+RP.SECOND_LAST_NAME nom_prof, RP.EMAIL_ADDR e_mail, EE.razon_social from registro.uge.aplicaciones_prac P, registro.uge.ofertas_prac OP,uge.ps_ec_ib_intp_vw RE, uge.ps_ec_ib_intp_vw RP , registro.uge.empresa_egre EE " +
"Where P.id_documento = RE.EMPLID AND OP.id_oferta = P.id_oferta AND EE.id_empresa = OP.id_empresa AND P.id_tutor = RP.EMPLID AND P.id_aplicacion = '"+idapli+"'");

        
       
        String cuerpo = "Apreciado(a) Estudiante y/o Tutor<br><br>" +
                        "El Sistema SIEMPREG de la Unidad de Gestión Externa le informa que la Práctica Profesional del estudiante "+(String) listado[0].get("nom_est")+", fue formalizada por la Decanatura.<br><br>" +
                        "<br>" +
                        "De manera atenta le solicitamos se proceda con tramites pertinentes con la siguiente información: <br><br><br>" +
                        "<table>"+
                        "<tr><td>Estudiante:       </td><td>" + (String) listado[0].get("nom_est")+ "</td></tr>" +
                        "<tr><td>Email estudiante: </td><td>" + (String) listado[0].get("emails")+ "</td></tr>" +
                        "<tr><td>Tutor:            </td><td>" + (String) listado[0].get("nom_prof")+  "</td></tr>" +
                        "<tr><td>Email tutor:      </td><td>" + (String) listado[0].get("e_mail")+  "</td></tr>" +
                        "<tr><td>Empresa:          </td><td>" + (String) listado[0].get("razon_social")+  "</td></tr>" +
                        "<table>"+
                        "<br><br>"+
                        "Cordialmente";
        
        cuerpo = formatoCorreo(cuerpo, practicas);

        //Dar copia de este correo a Andrés
        StringBuilder DestinoBBC = new StringBuilder(logInP);
/*        for (int i = 0; i < detallesOferta.length; i++) {
            DestinoBBC.append((", " + (String) detallesOferta[i].get("email_usr")) + mailCompl);
            if (((String) detallesOferta[i].get("email_copia")).length() > 0) DestinoBBC.append((", " + (String) detallesOferta[i].get("email_copia")) + mailCompl);
        }
*/
            DestinoBBC.append((", " + (String) listado[0].get("emails")));
            DestinoBBC.append((", " + (String) listado[0].get("e_mail")));
            DestinoBBC.append((", " + "practicas") + mailCompl);
        
        
        String[] destino = {"", "", DestinoBBC.toString()};
           
        if (sendEmail(asunto, destino, cuerpo, authSession)) return 1;
        return 0;
        
    }
    

    @Override
    public int enviarAdmin(String id, String tipo) throws Exception {
        //doc_load
        HashMap emails;
        
        String asunto = "Sistema SIEMPREG - Movilidad Estudiantil";
        String cuerpo = getMsgMov(tipo, id);
        
        defineSystem(movilidad);

        Session authSession = getAuth();
        authSession.setDebug(true);

        emails = bDatos.getRegistro("SELECT email_usr, email_copia " +
                                    "FROM uge.usr_sige " +
                                    "WHERE rol_usr='1'");
        
        String[] destino = {
            ((String) emails.get("email_usr")) + mailCompl, 
            (((String) emails.get("email_copia")).length() > 0)?((String) emails.get("email_copia")) + mailCompl:""
        };

        if (sendEmail(asunto, destino, cuerpo, authSession)) return 1;
        return 0;

    }

    @Override
    public int enviarVice(String id, String tipo) throws Exception {
        //solentrevistas
        HashMap emailsVice;
        HashMap[] emailsBienestar;
        
        String asunto = "Sistema SIEMPREG - Movilidad Estudiantil";
        String cuerpo = getMsgMov(tipo, id);
        
        defineSystem(movilidad);

        Session authSession = getAuth();
        authSession.setDebug(true);


        emailsVice = bDatos.getRegistro("SELECT email_usr, " +
                                                "email_copia " +
                                        "FROM uge.usr_sige " +
                                        "WHERE rol_usr = '4'");
        
        emailsBienestar = bDatos.getRegistros(  "SELECT  email_usr, " +
                                                        "email_copia " +
                                                "FROM uge.usr_sige " +
                                                "WHERE rol_usr = '5'");
        
        StringBuilder DestinoBBC = new StringBuilder(((String) emailsVice.get("email_usr")) + mailCompl);
        if (((String) emailsVice.get("email_copia")).length() > 0) DestinoBBC.append(", " + ((String) emailsVice.get("email_copia")) + mailCompl);
        
        for (int i = 0; i < emailsBienestar.length; i++) {
            DestinoBBC.append((", " + (String) emailsBienestar[i].get("email_usr")) + mailCompl);
            if (((String) emailsBienestar[i].get("email_copia")).length() > 0) DestinoBBC.append((", " + (String) emailsBienestar[i].get("email_copia")) + mailCompl);
        }
        
        String[] destino = {"", "", DestinoBBC.toString()};

        if (sendEmail(asunto, destino, cuerpo, authSession)) return 1;
        return 0;
    }
    
    
    /* PRACTICAS */
    
    @Override
    public int enviarUgeADecPrac(String id) throws Exception {
        HashMap[] detallesOferta;
        HashMap[] listado_programas;

        String asunto = "Sistema SIEMPREG - Prácticas Profesionales: Una empresa ha enviado una oferta";
        
        defineSystem(practicas);

        Session authSession = getAuth();
        authSession.setDebug(true);
        
        listado_programas = bDatos.getRegistros("SELECT  DISTINCT PROG.DESCRIPCION as nom_prog FROM uge.usr_sige USR INNER JOIN uge.homol_progs_campus PROG ON PROG.id_dpto = USR.rol_usr " +
"INNER JOIN uge.requerimientos_prac REQ ON REQ.programa_requerido = PROG.DESCRIPCION WHERE REQ.id_oferta = '" + id + "'");
        
        
        
        detallesOferta = bDatos.getRegistros(   "SELECT DISTINCT USR.email_usr, USR.email_copia, PROG.DESCRIPCION " +
"FROM uge.usr_sige USR INNER JOIN uge.homol_progs_campus PROG ON PROG.id_dpto = USR.rol_usr " +
"INNER JOIN uge.requerimientos_prac REQ ON REQ.programa_requerido = PROG.DESCRIPCION WHERE REQ.id_oferta = '" + id + "'");
        
        StringBuilder programasReq = new StringBuilder();
        for (int i = 0; i < listado_programas.length; i++) {
            programasReq.append("  - " + (String) listado_programas[i].get("nom_prog") + "<br>");
        }
        
        programasReq.append("<br>");
        
        String cuerpo = "Apreciado(a) Decano(a)<br><br>" +
                        "El Sistema SIEMPREG de la Unidad de Gestión Externa le informa que tiene una nueva oferta de Práctica Profesional para su trámite.<br><br>" +
                        "Esta oferta está dirigida para la aprobación de los siguientes programas:<br>" +
                        programasReq.toString() +
                        "De manera atenta le solicitamos ingresar al " +
                        "<a href='http://practicas.escuelaing.edu.co/SIGE2.0-war/loginDec'>Sistema SIEMPREG</a>, y en el menú principal ingresar a la opción " +
                        "\"Consultar ofertas\", haciendo click en el botón \"Pendientes\" encontrará las ofertas que tiene pendientes por tramitar.<br><br><br>" +
                        "Cordialmente";
        
        cuerpo = formatoCorreo(cuerpo, practicas);

        //Dar copia de este correo a Andrés
        StringBuilder DestinoBBC = new StringBuilder(logInP);
        for (int i = 0; i < detallesOferta.length; i++) {
            DestinoBBC.append((", " + (String) detallesOferta[i].get("email_usr")) + mailCompl);
            if (((String) detallesOferta[i].get("email_copia")).length() > 0) DestinoBBC.append((", " + (String) detallesOferta[i].get("email_copia")) + mailCompl);
        }

        String[] destino = {"", "", DestinoBBC.toString()};
           
        if (sendEmail(asunto, destino, cuerpo, authSession)) return 1;
        return 0;
    }
    
    @Override
    public int enviarSolDecPrac(String id, boolean act) throws Exception {
        
        String asunto = "Sistema SIEMPREG - Prácticas Profesionales: Un estudiante ha enviado una solicitud de Práctica Profesional";
        
        defineSystem(practicas);

        Session authSession = getAuth();
        authSession.setDebug(true);
        
        HashMap datosEstudiante = bDatos.getRegistro(   "SELECT  E.FIRST_NAME+' '+E.MIDDLE_NAME+' '+E.LAST_NAME+' '+E.SECOND_LAST_NAME nombre, PROG.DESCRIPCION programa " +
        "FROM uge.ps_ec_ib_intp_vw E " +
        "INNER JOIN uge.homol_progs_campus PROG ON PROG.ACAD_PROG = E.ACAD_PROG " +
        "WHERE E.EMPLID = '" + id + "'");
        
        String cuerpo = "Apreciado(a) Decano(a)<br><br>" +
                        "El Sistema SIEMPREG de la Unidad de Gestión Externa le informa que el estudiante " + ((String) datosEstudiante.get("nombre")) + " ha realizado la " + (act?"actualización":"solicitud") + " de su Práctica Profesional, " +
                        "por lo que de manera atenta le solicitamos realizar la validación respectiva.<br><br>" +
                        "Puede visualizarla ingresando al <a href='http://practicas.escuelaing.edu.co/SIGE2.0-war/loginDec'>Sistema SIEMPREG</a>, y en el menú principal accediendo a la opción " +
                        "\"Tramitar solicitudes\". A continuación haga click en alguna de las opciones (Tiempo completo, Medio tiempo, o Todos) para listar las solicitudes que tiene pendientes por tramitar.<br><br><br>" +
                        "Cordialmente";
        
        cuerpo = formatoCorreo(cuerpo, practicas);
        
        HashMap emailsDecanos = bDatos.getRegistro("SELECT DISTINCT USR.email_usr, USR.email_copia " +
        "FROM uge.usr_sige USR " +
        "INNER JOIN uge.homol_progs_campus PROG ON PROG.id_dpto = USR.rol_usr " +
        "WHERE PROG.DESCRIPCION = '" + ((String) datosEstudiante.get("programa")) + "'");
        
        //Dar copia de este correo a Andrés
        StringBuilder DestinoBBC = new StringBuilder(logInP);
        String Destino = (String) emailsDecanos.get("email_usr") + mailCompl;
        
        if (((String) emailsDecanos.get("email_copia")).length() > 0) DestinoBBC.append((", " + (String) emailsDecanos.get("email_copia")) + mailCompl);

        String[] destino = {Destino, "", DestinoBBC.toString()};
           
        if (sendEmail(asunto, destino, cuerpo, authSession)) return 1;
        return 0;
    }
    
    @Override
    public int enviarActOferPrac(String id, String dec, String comentario, boolean rechazada) throws Exception{
        HashMap datoOferta, datosEmp;
        String cuerpo;
        
        String asunto = "Sistema SIEMPREG - Prácticas Profesionales: Oferta de Práctica Profesional";
        
        defineSystem(practicas);
        
        Session authSession = getAuth();
        authSession.setDebug(true);
        
        datoOferta = bDatos.getRegistro("SELECT  id_empresa, " +
                                                "id_contacto, " +
                                                "cargo cargoof" +
                                        "FROM uge.ofertas_prac " +
                                        "WHERE id_oferta = '" + id + "'");
        
        if (!datoOferta.get("id_contacto").equals("0")) {
            datosEmp = bDatos.getRegistro(  "SELECT  nom_contacto nombre, " +
                                                    "email_contacto email, " +
                                                    "nit NIT, " +
                                                    "doc_contacto password " +
                                            "FROM uge.contactos_emp_sige " +
                                            "WHERE id_contacto = '" + datoOferta.get("id_contacto") + "'");
            
            cuerpo =    "Señor(a)<br>";           
        } else {
            datosEmp = bDatos.getRegistro(  "SELECT  razon_social nombreemp, " +
                                                    "email_empresa email, " +
                                                    "nit NIT, " +
                                                    "pass_empresa password " +
                                            "FROM uge.empresa_egre " +
                                            "WHERE id_empresa='" + datoOferta.get("id_empresa") + "'");
            
            cuerpo =    "Señores<br>";
        }
        
        cuerpo +=   ((String) datosEmp.get("nombreemp")) + "<br><br>" +
                    "Reciba un cordial saludo de la Unidad de Gestión Externa de la Escuela Colombiana de Ingeniería Julio Garavito.<br><br>" +
                    "Usted ha enviado una oferta de Práctica Profesional denominada <i>" + ((String) datoOferta.get("cargoof")) + "</i> a través del " +
                    "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loingempresa\" target=\"_blank\">Sistema SIEMPREG</a>.<br>" +
                    "Ésta oferta ha sido " + (rechazada?"rechazada":"aprobada") + " por la decanatura de " + dec + " con el siguiente comentario:<br><br>" +
                    "<i>" + comentario + "</i><br><br><br>" +
                    "Cordialmente";
        
        cuerpo = formatoCorreo(cuerpo, practicas);
        
        //Por ahora solo a Andrés
        String[] destino = {"", "", logInP};
           
        if (sendEmail(asunto, destino, cuerpo, authSession)) return 1;
        return 0;
    }
    
    @Override
    public int enviarDevolucionSolPrac(String id, String idsol, boolean rechazada) throws Exception {
        HashMap datosEst, datosEstPrac;
        
        String asunto = "Sistema SIEMPREG - Prácticas Profesionales: " + (String) (rechazada?"Rechazo":"Devolución") +  " de Solicitud";
        
        defineSystem(practicas);
        
        Session authSession = getAuth();
        authSession.setDebug(true);
        
        String comentario = bDatos.getRegistro( "SELECT observaciones " +
                                                "FROM uge.solicitud_prac " +
                                                "WHERE id_sol = " + idsol
                            ).get("observaciones").toString();
        
        String cuerpo = "Apreciado(a) Estudiante<br><br>" +
                        "Su solicitud de Práctica Profesional ha sido " +
                        (String) (rechazada?"rechazada ":"devuelta ") +
                        "por su decanatura con el siguiente comentario:<br><br>" +
                        "<i>" + comentario + "</i><br><br>";
        
        if (!rechazada) cuerpo += "Por favor ingrese al <a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginestMov\" target=\"_blank\">Sistema SIEMPREG</a> y actualice su solicitud.<br><br>";
        
        cuerpo +=   "<br>";
        cuerpo +=   "Cordialmente";
        
        cuerpo = formatoCorreo(cuerpo, practicas);

        datosEst = bDatos.getRegistro(  "SELECT EMAIL_ADDR as emails FROM uge.ps_ec_ib_intp_vw WHERE EMPLID = '" + id + "'");

        datosEstPrac = bDatos.getRegistro(  "SELECT email2 " +
                                            "FROM uge.datos_prac " +
                                            "WHERE id_documento = '" + id + "'");

        String[] destino = {
            ((String) datosEst.get("emails")),
            chkEmailFormat((String) datosEstPrac.get("email2"))?(String) datosEstPrac.get("email2"):""
        };
        
        if (sendEmail(asunto, destino, cuerpo, authSession)) return 1;
        return 0;
    }
    
    
    /* GRADUADOS */
    
    @Override
    public int enviarApliEmp(String docgrad, String id) throws Exception {
        HashMap datoOferta, datosEmp;
        String cuerpo;
        
        String asunto = "Sistema SIEMPREG - Graduados: Un graduado se postuló a su oferta";
        
        defineSystem(graduados);
        
        Session authSession = getAuth();
        authSession.setDebug(true);
        
        datoOferta = bDatos.getRegistro("SELECT  id_empresa, " +
                                                "id_contacto, " +
                                                "cargo " +
                                        "FROM uge.ofertas_egre " +
                                        "WHERE id_oferta = '" + id + "'");
        
        if (!datoOferta.get("id_contacto").equals("0")) {
            datosEmp = bDatos.getRegistro(  "SELECT  nom_contacto nombre, " +
                                                    "email_contacto email, " +
                                                    "nit NIT, " +
                                                    "doc_contacto password " +
                                            "FROM uge.contactos_emp_sige " +
                                            "WHERE id_contacto = '" + datoOferta.get("id_contacto") + "'");
            
            cuerpo =    "Señor(a)<br>";
                        
        } else {
            datosEmp = bDatos.getRegistro(  "SELECT  razon_social nombre, " +
                                                    "email_empresa email, " +
                                                    "nit NIT, " +
                                                    "pass_empresa password " +
                                            "FROM uge.empresa_egre " +
                                            "WHERE id_empresa='" + datoOferta.get("id_empresa") + "'");
            
            cuerpo =    "Señores<br>";
        }
        
        cuerpo +=   ((String) datosEmp.get("nombre")) + "<br><br>" +
                    "Un graduado de la Escuela Colombiana de Ingeniería se ha postulado a la oferta \"" + ((String) datoOferta.get("cargo")) + "\" " +
                    "publicada en nuestro Sistema SIEMPREG.<br><br>" +
                    "Para ver la hoja de vida del graduado ingrese al " +
                    "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loingempresa\" target=\"_blank\">Sistema SIEMPREG</a>, " +
                    "y consulte la oferta en la opción \"Consultar Ofertas Laborales\" del menú para el Sistema de Graduados.<br><br>" +
                    "Recuerde que su usuario es el NIT de su empresa (" + ((String) datosEmp.get("NIT")) + ") y su contraseña es " + ((String) datosEmp.get("password")) + "<br><br><br>" +
                    "Cordialmente";
        
        cuerpo = formatoCorreo(cuerpo, graduados);
        
        String[] destino = {
            chkEmailFormat((String) datosEmp.get("email"))?((String) datosEmp.get("email")):"",
            "", 
            logInG
        };
        
        if (sendEmail(asunto, destino, cuerpo, authSession)) return 1;
        return 0;
    }
    
    @Override
    public int enviarmasivoGrad(String programaEmailAdmin, String fechainemailG, String fechaoutemailG, String asuntoemailmas, String area1) throws Exception {

        defineSystem(graduados);

        Session authSession = getAuth();
        authSession.setDebug(true);
        
        MimeMessage msg = new MimeMessage(authSession);

        try {
            //Body 
            MimeBodyPart mbp = new MimeBodyPart();
            //mbp.setText(area1, "ISO-8859-1", "html");
            mbp.setText(area1, "UTF-8", "html");
            
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(mbp);
            
            //Header
            msg.setFrom(new InternetAddress(origen));
            msg.setSubject(asuntoemailmas);
            msg.setContent(multipart);
        } catch (Exception err) {
            return 0;
        }
        
        HashMap[] listEmails;
        
        if (programaEmailAdmin.equals("AdminSige")) {
            listEmails = bDatos.getRegistros("SELECT    email_usr AS emailReg, " +
                                                        "'' AS email, " +
                                                        "'' AS email2 " +
                                            "FROM uge.usr_sige " +
                                            "WHERE id_usr = '2'");
        } else if (programaEmailAdmin.equals("EmpSige")) {
            listEmails = bDatos.getRegistros("SELECT    email_empresa AS email, " +
                                                        "email_rrhh AS email2, " +
                                                        "'' AS emailReg " +
                                            "FROM uge.empresa_egre " +
                                            "ORDER BY fecha_reg DESC");
        } else {
            String programa = "";
            
            if (!programaEmailAdmin.equals("TODOS1") && !programaEmailAdmin.equals("TODOS2")) programa = programaEmailAdmin;

            if (fechainemailG == null) fechainemailG = "";
            if (fechaoutemailG == null) fechaoutemailG = "";

            listEmails = bDatos.getRegistros("SELECT REPLACE(REPLACE(R.emails, ';', ','),' ','') emailReg, " +
                                                    "REPLACE(REPLACE(E.email, ';', ','),' ','') email, " +
                                                    "REPLACE(REPLACE(E.email2, ';', ','),' ','') email2, " +
                                                    "RG.fec_grad " +
                                            "FROM uge.datos_egre E " +
                                                "INNER JOIN registro.estudiante R ON R.id_est = E.id_documento " +
                                                "INNER JOIN registro.inf_grad RG ON RG.id_est = E.id_documento " +
                                                "INNER JOIN registro.plan_estud PE ON PE.id_plan = R.id_plan " +
                                                "INNER JOIN registro.programas PR on PR.id_prog = PE.id_prog " +
                                            (!programa.equals("") || !fechainemailG.equals("") || !fechaoutemailG.equals("")?"WHERE ":"") +
                                                (!programa.equals("")?"PR.nom_prog = '" + programa + "' ":"") +
                                                ((!programa.equals("") && !fechainemailG.equals(""))?"AND ":"") +
                                                (!fechainemailG.equals("")?"RG.fec_grad >= '" + fechainemailG + "' ":"") +
                                                (((!fechainemailG.equals("") && !fechaoutemailG.equals("")) || (!programa.equals("") && !fechaoutemailG.equals("")))?"AND ":"") +
                                                (!fechaoutemailG.equals("")?"RG.fec_grad <= '" + fechaoutemailG + "' ":"") +
                                            "ORDER BY RG.fec_grad DESC");
        }
        
        int startEmail = 0;
        int endEmail = 5000;
        
        int totalEmails = 0;
        
        if (programaEmailAdmin.equals("TODOS2")) startEmail = 5001;
        if (!programaEmailAdmin.equals("TODOS1") || listEmails.length < endEmail) endEmail = listEmails.length;
        
        //msg.setRecipients(Message.RecipientType.BCC, emailCCO);
        
        
        for (int i = startEmail; i < endEmail; i++) {
            HashMap personEmails = listEmails[i];
            String chkEmail = "";
            int cantEmail = 0;
            
            for (String optValue: new String[] {"","2","Reg"}) {
            
                if (personEmails.get("email" + optValue) != null && !((String) personEmails.get("email" + optValue)).equals("")) {
                    chkEmail = (String) personEmails.get("email" + optValue);
                    
                    if (optValue.equals("Reg")) chkEmail = chkEmail.contains("@")?chkEmail:chkEmail+"@" + (!programaEmailAdmin.equals("AdminSige")?"mail.":"") + "escuelaing.edu.co";
                    
                    if (chkEmail.contains(",")) {
                        String[] arrayEmails = chkEmail.split(",");

                        for (int j = 0; j < arrayEmails.length; j++) {
                            if (chkEmailFormat(arrayEmails[j])) {
                                if (cantEmail < 2) {
                                    try {
                                        boolean checkEmail = false;
                                        Address[] sendList = msg.getRecipients(Message.RecipientType.BCC);
                                        for (Address chkList: sendList) {
                                            if (arrayEmails[j].equals(chkList.toString())) checkEmail = true;
                                        }

                                        if (!checkEmail) {
                                            msg.addRecipients(Message.RecipientType.BCC, arrayEmails[j]);
                                            cantEmail++;
                                            totalEmails++;
                                        }
                                    } catch (Exception err) {
                                        Logger.getLogger(EnviarEmail.class.getName()).log(Level.INFO, "Error al intentar agregar la dirección '" + arrayEmails[j] + "' : " + err);
                                    }
                                }
                            }
                        }
                    } else {
                        if (chkEmailFormat(chkEmail)) {
                            if (cantEmail < 2) {
                                try {
                                    boolean checkEmail = false;
                                    Address[] sendList = msg.getRecipients(Message.RecipientType.BCC);
                                    for (Address chkList: sendList) {
                                        if (chkEmail.equals(chkList.toString())) checkEmail = true;
                                    }
                                
                                    if (!checkEmail) {
                                        msg.addRecipients(Message.RecipientType.BCC, chkEmail);
                                        cantEmail++;
                                        totalEmails++;
                                    }
                                } catch (Exception err) {
                                    Logger.getLogger(EnviarEmail.class.getName()).log(Level.INFO, "Error al intentar agregar la dirección '" + chkEmail + "' : " + err);
                                }
                            }
                        }
                    }
                }
            }
            
            if (msg.getRecipients(Message.RecipientType.BCC).length > 60 || i == endEmail - 1) {
                try {
                    msg.setSentDate(new Date());
                    //Transport.send(msg);
                    //msg.setRecipients(Message.RecipientType.BCC, emailCCO);
                    totalEmails++;
                } catch (Exception err) {
                    Logger.getLogger(EnviarEmail.class.getName()).log(Level.INFO, "Error al intentar enviar el correo: " + err);
                    break;
                }
            }
        }
        
        try {
            String cuerpo = "Se confirma el envío de " + totalEmails + " correos.";
            cuerpo = formatoCorreo(cuerpo, graduados);
            //Body 
            MimeBodyPart mbp = new MimeBodyPart();
            //mbp.setText(cuerpo, "ISO-8859-1", "html");
            mbp.setText(cuerpo, "UTF-8", "html");
            
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(mbp);
            
            //Header
            msg.setFrom(new InternetAddress(origen));
            msg.setSubject("Confirmación de envío de correos masivos");
            msg.setContent(multipart);
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, origen);
            //msg.setRecipients(Message.RecipientType.BCC, emailCCO);
            //Transport.send(msg);
        } catch (Exception err) {}
        return 1;
    }
    
    private String getMsgMov(String tipo, String doc) throws Exception {
        String mensaje = "";

        if (tipo.equals("sol_dec")) {
            String nom_est =    bDatos.getRegistro("select FIRST_NAME+' '+MIDDLE_NAME+' '+LAST_NAME+' '+SECOND_LAST_NAME as nom_est from uge.ps_ec_ib_intp_vw where EMPLID='"+doc+"'")
                                .get("nom_est").toString();
            
            String prog_mov =   bDatos.getRegistro( "SELECT prog_mov " +
                                                "FROM uge.solicitud_mov " +
                                                "WHERE id_solicitud = (  SELECT MAX(id_solicitud) " +
                                                                        "FROM uge.solicitud_mov " +
                                                                        "WHERE id_est = " + doc + ")")
                                .get("prog_mov").toString();
            
            mensaje =   "Buenos días,<br><br>" +
                        "Con el fin de inscribirse al programa de Movilidad Estudiantil para realizar un(a) " + prog_mov + ", " +
                        "el estudiante " + nom_est + " ha enviado una solicitud a través del " +
                        "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginDec\" target=\"_blank\">Sistema SIEMPREG</a>, " +
                        "y que comedidamente nos permitimos solicitarle revise, y convenga una entrevista con el candidato.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("VoBo_carta")) {
            mensaje =   "Buenos días,<br><br>" +
                        "Su solicitud de Movilidad Estudiantil ha sido aceptada por su decano, por favor ingrese al " +
                        "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginestMov\" target=\"_blank\">Sistema SIEMPREG</a>, " +
                        "y revise el estado de su solicitud para continuar con el proceso.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("rechazo_carta")) {
            mensaje =   "Buenos días,<br><br>" +
                        "Su solicitud de Movilidad Estudiantil ha sido rechazada por su decano.<br><br>" +
                        "Los comentarios del decano los puede consultar ingresando al " +
                        "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginestMov\" target=\"_blank\">Sistema SIEMPREG</a>, " +
                        "haciendo click en la opción \"Consultar estado del proceso\" del menú principal.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("doc_load")) {

            String nom_est =    bDatos.getRegistro( "select (select FIRST_NAME+' '+MIDDLE_NAME+' '+LAST_NAME+' '+SECOND_LAST_NAME as nom_est from uge.ps_ec_ib_intp_vw where EMPLID= A.id_est) nom_est from uge.solicitud_mov A where A.id_solicitud='"+doc+"'")
                                .get("nom_est").toString();
            
            mensaje =   "Buenos días,<br><br>" +
                        "Con el fin de continuar con el programa de Movilidad Estudiantil, el estudiante " +
                        nom_est + " ha cargado los documentos solicitados al " +
                        "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginAdmin\" target=\"_blank\">Sistema SIEMPREG</a>, " +
                        "y que comedidamente nos permitimos solicitarle revise.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("obv_cartaeci") || tipo.equals("obv_plan") || tipo.equals("obv_vice") || tipo.equals("obv_docu")) {
            String comentario = bDatos.getRegistro( "SELECT " + tipo + " " +
                                                    "FROM uge.solicitud_mov " +
                                                    "WHERE id_solicitud = '" + doc + "'")
                                .get(tipo).toString();
            
            mensaje =   "Buenos días,<br><br>" +
                        "El Sistema SIEMPREG de la Unidad de Gestión Externa le informa que ha recibido el siguiente comentario " +
                        "en su solicitud de Movilidad Estudiantil:<br><br>" +
                        "<i>" + comentario + "</i><br><br>" +
                        "Para obtener más detalles por favor ingrese al " +
                        "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginestMov\" target=\"_blank\">Sistema SIEMPREG</a> " +
                        "y revise el estado actual de su solicitud.";
        } else if (tipo.equals("solplan_dec")) {
            String nom_est =    bDatos.getRegistro( "select (select FIRST_NAME+' '+MIDDLE_NAME+' '+LAST_NAME+' '+SECOND_LAST_NAME as nom_est from uge.ps_ec_ib_intp_vw where EMPLID= A.id_est) nom_est from uge.solicitud_mov A where A.id_solicitud='"+doc+"'")
                                .get("nom_est").toString();
            
            mensaje =   "Buenos días,<br><br>" +
                        "Con el fin continuar con el programa de Movilidad Estudiantil, el estudiante " + nom_est + " " +
                        "ha enviado una solicitud de Plan de Estudios a través del " +
                        "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginDec\" target=\"_blank\">Sistema SIEMPREG</a>, " +
                        "y que comedidamente nos permitimos solicitarle revise, y convenga una entrevista con el candidato.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("devplan_est")) {
            mensaje =   "Buenos días<br><br>" +
                        "Su Plan de Estudios ha sido devuelto por su decano.<br><br>" +
                        "Los comentarios del decano los puede consultar ingresando al, " +
                        "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginestMov\" target=\"_blank\">Sistema SIEMPREG</a>, " +
                        "haciendo click en la opción \"Consultar estado del proceso\" del menú principal.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("cambioplan_dec")) {
            String nom_est =    bDatos.getRegistro( "select (select FIRST_NAME+' '+MIDDLE_NAME+' '+LAST_NAME+' '+SECOND_LAST_NAME as nom_est from uge.ps_ec_ib_intp_vw where EMPLID= A.id_est) nom_est from uge.solicitud_mov A where A.id_solicitud='"+doc+"'")
                                .get("nom_est").toString();
            
            mensaje =   "Buenos días,<br><br>" +
                        "El estudiante " + nom_est + " que se encuentra en el exterior ha enviado una solicitud de cambio en el " +
                        "Plan de Estudios a través del " +
                        "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginDec\" target=\"_blank\">Sistema SIEMPREG</a>, " +
                        "y que comedidamente nos permitimos solicitarle revise.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("CamPlanAcep")) {
            mensaje =   "Buenos días,<br><br>" +
                        "Su solicitud de cambio en el Plan de Estudios ha sido aceptada por su decano.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("CamPlanRec")) {
            mensaje =   "Buenos días,<br><br>" +
                        "Su solicitud de cambio en el Plan de Estudios ha sido rechazada por su decano.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("solentrevistas")) {
            String nom_est =    bDatos.getRegistro( "select (select FIRST_NAME+' '+MIDDLE_NAME+' '+LAST_NAME+' '+SECOND_LAST_NAME as nom_est from uge.ps_ec_ib_intp_vw where EMPLID= A.id_est) nom_est from uge.solicitud_mov A where A.id_solicitud='"+doc+"'")
                                .get("nom_est").toString();
            
            mensaje =   "Buenos días,<br><br>" +
                        "El estudiante " + nom_est + " se encuentra en proceso de formalización de una solicitud de Movilidad Estudiantil, " +
                        "por ello le solicitamos cordialmente que ingrese al " +
                        "<a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginVice\" target=\"_blank\">Sistema SIEMPREG</a> " +
                        "y le programe una fecha para entrevista.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("entrevista")) {
            mensaje =   "Buenos días,<br><br>" +
                        "Se ha programado una nueva entrevista para su solicitud de Movilidad Estudiantil.<br><br>" +
                        "Por favor ingrese al <a href=\"http://practicas.escuelaing.edu.co/SIGE2.0-war/loginestMov\" target=\"_blank\">Sistema SIEMPREG</a>, " +
                        "y consulte el estado de su solicitud.<br><br><br>" +
                        "Cordialmente";
        } else if (tipo.equals("process_end")) {
            mensaje =   "Buenos días,<br><br>" +
                        "Usted ha formalizado exitosamente su solicitud de Movilidad Estudiantil.<br><br>" +
                        "Por favor acérquese con el contrato de estudios firmado a la Oficina de Relaciones Internacionales en la Unidad de Gestión Externa.<br><br><br>" +
                        "Cordialmente";
        }
        
        mensaje += "<br><br><span style=\"font-size: 10px;\">Éste es un mensaje automático enviado por el Sistema SIEMPREG de la Unidad de Gestión Externa.<br>"
                + "Si usted requiere alguna instrucción o tiene alguna observación del mismo, no dude en contactarnos.</span>";
        
        mensaje = formatoCorreo(mensaje, movilidad);
        return mensaje;
    }
    
    private static String formatoCorreo(String cuerpo, int sistema) {

        String formatoCuerpo = "";
        
        formatoCuerpo = "<div align=\"center\"><table width=\"600\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"0\">\n" +
                        "  <tr>\n" +
                        "    <td align=\"left\" valign=\"top\"><table width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#EFEFEF\">\n" +
                        "      <tr>\n" +
                        "        <td align=\"left\" valign=\"top\" bgcolor=\"#FFFFFF\"><table width=\"600\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                        "          <tr>\n" +
                        "            <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"10\" cellspacing=\"0\">\n";
                        
                        
        if (sistema == graduados) {
       formatoCuerpo += "              <tr>\n" +
                        "                <td width=\"33%\" align=\"left\" valign=\"middle\"><img src=\"http://tycho.escuelaing.edu.co/contenido/graduados/img/logo-acreditacion.gif\" width=\"156\" height=\"100\" /></td>\n" +
                        "                <td width=\"33%\" align=\"center\" valign=\"middle\"><img src=\"http://tycho.escuelaing.edu.co/contenido/graduados/img/logo-graduados.gif\" width=\"122\" height=\"100\" /></td>\n" +
                        "                <td align=\"right\" valign=\"middle\"><img src=\"http://tycho.escuelaing.edu.co/contenido/graduados/img/logo-escuela2.png\" width=\"180\" height=\"100\" /></td>\n" +
                        "              </tr>";
        } else {
       formatoCuerpo += "              <tr>\n" +
                        "                <td width=\"50%\" align=\"left\" valign=\"middle\"><img src=\"http://tycho.escuelaing.edu.co/contenido/graduados/img/logo-acreditacion.gif\" width=\"156\" height=\"100\"></td>\n" +
                        "                <td width=\"50%\" align=\"right\" valign=\"middle\"><img src=\"http://tycho.escuelaing.edu.co/contenido/graduados/img/logo-escuela2.png\" width=\"180\" height=\"100\"></td>\n" +
                        "              </tr>\n";
        }
        
       formatoCuerpo += "            </table></td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"5\" cellspacing=\"1\">\n" +
                        "              <tr>\n" +
                        "                <td width=\"20%\" align=\"center\" valign=\"middle\" bgcolor=\"#F2F2F2\"><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:13px; color:#666\">SIEMPREG</font></td>\n" +
                        "                <td width=\"80%\" align=\"left\" valign=\"middle\" bgcolor=\"#F2F2F2\"><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:11px; color:#666\">Sistema de informaci&oacute;n para empresas, movilidad, practicas y relaciones con graduados</font></td>\n" +
                        "              </tr>\n" +
                        "            </table></td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"40\" cellspacing=\"0\">\n" +
                        "              <tr>\n" +
                        "                <td>\n" +
                        "                  <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:13px; color:#000; text-align:justify\">\n" +
                        "                    <pre style=\"white-space: pre-wrap; font-family: Calibri; font-size: 13px; text-align: justify;\">" +
                                                cuerpo +
                        "                    </pre>" +
                        "                  </font>\n" +
                        "                </td>\n" +
                        "              </tr>\n" +
                        "            </table></td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td align=\"left\" valign=\"top\">&nbsp;</td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td align=\"left\" valign=\"top\" bgcolor=\"#990000\"><table width=\"100%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n" +
                        "              <tr>\n" +
                        "                <td><table width=\"100%\" border=\"0\" cellpadding=\"18\" cellspacing=\"0\">\n";
        if (sistema == practicas) {
       formatoCuerpo += "                  <tr>\n" +
                        "                    <td align=\"center\" valign=\"middle\"><p><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:13px; color:#FFF\">Oficina de Prácticas Profesionales</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:12px; color:#FFF\">Tel: 668 3600 Ext. 294</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:12px; color:#FFF\">practicas@escuelaing.edu.co</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:11px; color:#FFF\">Unidad de Gestión Externa</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:14px; color:#FFF\">Escuela Colombiana de Ingenier&iacute;a Julio Garavito</font><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:13px; color:#FFF\">                    </font></p></td>\n" +
                        "                  </tr>\n";
        } else if (sistema == graduados) {
       formatoCuerpo += "                  <tr>\n" +
                        "                    <td align=\"center\" valign=\"middle\"><p><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:13px; color:#FFF\">Oficina de Graduados</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:12px; color:#FFF\">Tel: 668 3600 Ext. 120</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:12px; color:#FFF\">graduados@escuelaing.edu.co</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:11px; color:#FFF\">Unidad de Gestión Externa</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:14px; color:#FFF\">Escuela Colombiana de Ingenier&iacute;a Julio Garavito</font><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:13px; color:#FFF\">                    </font></p></td>\n" +
                        "                  </tr>\n";
        } else {
       formatoCuerpo += "                  <tr>\n" +
                        "                    <td align=\"center\" valign=\"middle\"><p><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:13px; color:#FFF\">Oficina de Movilidad Estudiantil</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:12px; color:#FFF\">Tel: 668 3600 Ext. 128</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:12px; color:#FFF\">ori@escuelaing.edu.co</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:11px; color:#FFF\">Unidad de Gestión Externa</font><br>\n" +
                        "                      <font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:14px; color:#FFF\">Escuela Colombiana de Ingenier&iacute;a Julio Garavito</font><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:13px; color:#FFF\">                    </font></p></td>\n" +
                        "                  </tr>\n";
        }
        
       formatoCuerpo += "                </table></td>\n" +
                        "                <td align=\"center\" valign=\"middle\"><img src=\"http://tycho.escuelaing.edu.co/contenido/graduados/img/linea-blanca.gif\" width=\"5\" height=\"131\"></td>\n" +
                        "                <td><table width=\"100%\" border=\"0\" cellpadding=\"18\" cellspacing=\"0\">\n" +
                        "                  <tr>\n" +
                        "                    <td align=\"left\" valign=\"middle\"><p><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:12px; color:#FFF\">AK.45 No.205-59 (Autopista Norte)<br>\n" +
                        "                      PBX: 57(1) 668 3600<br>\n" +
                        "                      Call center: 57(1) 668 3622<br>\n" +
                        "                      L&iacute;nea Nacional Gratuita: 018000112668<br>\n" +
                        "                      www.escuelaing.edu.co</font></p>\n" +
                        "                      <p><font style=\"font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; font-size:12px; color:#FFF\">Bogot&aacute;, D.C. - Colombia</font></p></td>\n" +
                        "                  </tr>\n" +
                        "                </table></td>\n" +
                        "              </tr>\n" +
                        "            </table></td>\n" +
                        "          </tr>\n" +
                        "        </table></td>\n" +
                        "      </tr>\n" +
                        "    </table></td>\n" +
                        "  </tr>\n" +
                        "</table></div>";
        
        return formatoCuerpo;
    }
    
    private boolean chkEmailFormat(String email) {
        boolean valid = false;
        try {
            InternetAddress chkEmail = new InternetAddress(email);
            chkEmail.validate();
            if (email.substring(0, 1).equals(".")) throw new Exception("");
            if (email.contains(".@")) throw new Exception("");
            if (email.contains("@.")) throw new Exception("");
            valid = true;
        } catch (AddressException err) {} catch (Exception err) {}
        
        return valid;
    }
}
