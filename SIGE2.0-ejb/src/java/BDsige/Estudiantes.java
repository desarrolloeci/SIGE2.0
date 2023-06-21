/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDsige;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.ArrayList;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import utiles.ConsultaException;

/**
 *
 * @author Luis Alberto Salas
 */
@Stateful
public class Estudiantes extends Persona implements EstudiantesRemote, SessionBean {

    private SessionContext context;
    private PersistenciaMIM bDatosMim = new PersistenciaMIM();
    private PersistenciaOracle bDatosOracle = new PersistenciaOracle();

    @Override
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ejbActivate() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Override
    public HashMap AdministradorMov() throws Exception {
        return bDatos.getRegistro("select email_usr from uge.usr_sige where id_usr=1");
        //select nom_est, doc_est,id_dpto, dir_corr, tel_corr, emails, nom_acud, dir_acud, tel_acud from registro.estudiante where id_est= 2067558
    }
     @Override
     public HashMap[] getAuditoriaMov(String idsolicitud) throws Exception{
     return bDatos.getRegistros("select * from uge.auditoria_mov where id_sol='"+idsolicitud+"'");
     }
    @Override
    public HashMap datosGeneralesEst(String id_est) throws Exception {
        return bDatos.getRegistro("select LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, NATIONAL_ID as doc_est , uge.solicitud_mov.ACAD_PROG as id_dpto, ADDRESS1 as dir_corr, PHONE as tel_corr, EMAIL_ADDR as emails, '' as nom_acud, email_acudiente as dir_acud, PHONE tel_acud from uge.ps_ec_ib_intp_vw, uge.solicitud_mov where EMPLID=id_est and EMPLID='"+id_est+"'");
        
        /**ANTES DE CAMPUS
        return bDatos.getRegistro("select nom_est, doc_est,id_dpto, dir_corr, tel_corr, emails, nom_acud, dir_acud, tel_acud"
                + " from registro.estudiante"
                + "  where id_est='"+id_est+"'");
        //select nom_est, doc_est,id_dpto, dir_corr, tel_corr, emails, nom_acud, dir_acud, tel_acud from registro.estudiante where id_est= 2067558
        * */
    }
    
    @Override
    public HashMap[] getFechasPracticasEst() throws Exception{
        return bDatos.getRegistros("select id_fecha, nombre,YEAR(fecha)year,MONTH(fecha)mes,day(fecha)dia, CAST(CONVERT(NVARCHAR, fecha, 112) AS DATE) fecha from  uge.fechas_sige where id_fecha >= '1' and id_fecha <= '8' ORDER BY id_fecha");
    }
    @Override
     public HashMap datosGeneralesEstPrac(String empl_id) throws Exception {
        
        /**
         * ANTES DE CAMPUS
        return bDatos.getRegistro("select nom_est, doc_est, id_dpto, dir_corr, tel_corr, emails, convert(varchar(10),fec_nac,111) fec_nac from registro.estudiante "
                + "where id_est='"+id_est+"'");
                * */
        
        return bDatos.getRegistro("select LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, NATIONAL_ID as doc_est, (select (select ID_DPTO from uge.homol_progs_campus PROGS where PROGS.ACAD_PROG=SOL.acad_prog) from uge.solicitud_prac SOL where id_documento=EMPLID and id_sol=(select max(SOL1.id_sol) from uge.solicitud_prac SOL1 where id_documento=EMPLID)) as id_dpto, ADDRESS1 as dir_corr, PHONE as tel_corr, [USER]+'@mail.escuelaing.edu.co' as emails, BIRTHDATE as fec_nac from uge.ps_ec_ib_intp_vw where EMPLID='"+empl_id+"'");
        //select nom_est, doc_est,id_dpto, dir_corr, tel_corr, emails, nom_acud, dir_acud, tel_acud from registro.estudiante where empl_id= 2067558
    }
    @Override
    public HashMap datosAcademicosEst(String empl_id) throws Exception{
        HashMap ban=new HashMap();
        HashMap promedios=new HashMap();
        String prom_sem="";
        String prom_acum="";
        /*ANTES DE CAMPUS
        ban = bDatos.getRegistro(   "SELECT EST.empl_id, "
                                            + "CONVERT(DECIMAL(3,2),ROUND( SUM((BD.prsem*BD.nota)) / (SUM(BD.prsem)/0.1), 2)) as prom_acum, "
                                            + "EST.sem_est "
                                    + "FROM registro.estudiante EST "
                                        + "INNER JOIN registro.biblia_def BD ON BD.empl_id = EST.id_Est "
                                    + "WHERE    BD.clave <> 'I' "
                                                + "AND BD.empl_id = '" + empl_id + "' "
                                    + "GROUP BY EST.empl_id, EST.sem_est");
        promedios.put("prom_acum", ban.get("prom_acum"));
        promedios.put("sem_est", ban.get("sem_est"));
        ban = bDatos.getRegistro(     "DECLARE @per_acad VARCHAR(6) "
                                    + "DECLARE @idEstud INT "
                                    + "DECLARE @pr_semant DECIMAL(3,2) "
                                    + "SET @idEstud = '" + empl_id + "' "
                                    + "SET @per_acad =(SELECT REPLACE(REPLACE(MAX(REPLACE(REPLACE(per_acad,'-1','-0'),'-I','-1')),'-1','-I'),'-0','-1') per_acad "
                                                    + "FROM registro.biblia_def "
                                                    + "WHERE   empl_id = @idEstud "
                                                            + "AND clave <> 'C' "
                                                            + "AND clave <> 'R' "
                                                            + "AND clave <> 'I' "
                                                            + "AND prom > 0 "
                                                            + ")"
                                    + "SET @pr_semant = (  SELECT  ROUND(SUM(nota*prsem)/(SUM(prsem)/0.10), 2)"
                                                        + "FROM registro.biblia_def "
                                                        + "WHERE   empl_id = @idEstud "
                                                                + "AND clave <> 'C' "
                                                                + "AND clave <> 'R' "
                                                                + "AND clave <> 'I' "
                                                                + "AND prom > 0 "
                                                                + "AND per_acad = @per_acad "
                                                                + ")"
                                    + "SELECT  @pr_semant AS pr_semant");
         promedios.put("pr_semant", ban.get("pr_semant"));
        */
        //promedios= bDatos.getRegistro("select 30 as prom_acum, 2 as sem_est, 30 as pr_semant from uge.ps_ec_ib_intp_vw where EMPLID='"+empl_id+"'");
        
        promedios= bDatos.getRegistro("select prog_mov, sem_est, prom_ant as pr_semant from uge.solicitud_mov where id_solicitud= (select max(id_solicitud) from uge.solicitud_mov where id_est='"+empl_id+"')");
        return promedios;
    }
    
    @Override
    public HashMap datosAcademicosEstPrac(String id_est) throws Exception {
        return bDatos.getRegistro("SELECT  EST.EMPLID as id_est,  '0' AS prom_acum, '0' as sem_est FROM uge.ps_ec_ib_intp_vw EST WHERE EST.EMPLID= '"+id_est+"'");
        /**ANTES DE ENLACE YA NO SE USAN ESTOS VALORES
        return bDatos.getRegistro(  "SELECT  EST.id_est, "
                                            + "CONVERT(DECIMAL(3,2),ROUND( SUM(BD.nota*BD.prom) / (SUM(BD.prom)/0.10), 2)) AS prom_acum, "
                                            + "EST.sem_est "
                                    + "FROM registro.estudiante EST "
                                        + "INNER JOIN registro.biblia_def BD ON BD.id_est = EST.id_est "
                                    + "WHERE   BD.id_est=" + id_est + " "
                                            + "AND BD.clave <> 'I' "
                                    + "GROUP BY  EST.id_est, EST.sem_est");
                                    * */
    }

    @Override
    public HashMap datosEntrevistasEst(String id_sol)throws Exception{
      return bDatos.getRegistro("SELECT  CONVERT(VARCHAR(19), entre_vice, 0) entre_vice, " +
                                        "CONVERT(VARCHAR(19), exm_psico, 0) exm_psico, " +
                                        "CONVERT(VARCHAR(19), exm_medico, 0) exm_medico " +
                                "FROM uge.solicitud_mov " +
                                "WHERE id_solicitud  = '" + id_sol + "'");
    }
    @Override
    public HashMap datosMateria(String plan) throws Exception
    {
        return bDatos.getRegistro("Select uge.planest_mov.materia_ud, uge.planest_mov.semestre from uge.planest_mov where "
                + "not exists (select 1 from uge.cambioplan_mov where uge.cambioplan_mov.id_plan = uge.planest_mov.id_plan) "
                + "and uge.planest_mov.id_plan  ='"+plan+"'");
    }
    @Override
    public HashMap []estadodocu(String idsolicitud) throws Exception{
        return bDatos.getRegistros( "SELECT  estado_notas, " +
                                            "estado_idiomas, " +
                                            "estado_cpadres, " +
                                            "estado_HV, " +
                                            "carta_ud, " +
                                            "vobo_foresp " +
                                    "FROM uge.solicitud_mov SOL " +
                                        "LEFT JOIN uge.opcionuni_mov UNI ON UNI.id_solicitud = SOL.id_solicitud " +
                                    "WHERE SOL.id_solicitud = '" + idsolicitud + "'");
    }
    @Override
    public HashMap []estadoopc( String idsolicitud) throws Exception{
         return bDatos.getRegistros("select estado_opcud "
                 + "from uge.opcionuni_mov where id_solicitud ="+ "'"+idsolicitud+"'");
    }

    @Override
    public HashMap  estadoAplicante (String id_est) throws Exception{
        return bDatos.getRegistro("select estado from uge.solicitud_mov where id_solicitud =(select max(id_solicitud) from uge.solicitud_mov where id_est="+ id_est+")");
    }
    @Override
    public HashMap estadoAplicanteprac (String id_est) throws Exception{
        /**
        return bDatos.getRegistro(  "SELECT  SOL.estado, " +
                                            "APL.estado_apli, " +
                                            "EST.men_solprac men_estado, " +
                                            "SOL.jornada, " +
                                            "SOL.disponibilidad, " +
                                            "SOL.observaciones, " +
                                            "SOL.asig_conjunta " +
                                    "FROM uge.solicitud_prac SOL " +
                                        "INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli=SOL.estado " +
                                        "LEFT JOIN uge.aplicaciones_prac APL ON (APL.id_documento = SOL.id_documento " +
                                                                                "AND (APL.estado_apli = 'h' " +
                                                                                "OR APL.estado_apli = 'j')) " +
                                    "WHERE   SOL.id_sol =(   SELECT MAX(id_sol) " +
                                                            "FROM uge.solicitud_prac " +
                                                            "WHERE id_documento = '" + id_est + "') " +
                                            "AND (   SOL.fecha_sol >= (  SELECT fecha " +
                                                                        "FROM uge.fechas_sige " +
                                                                        "WHERE id_fecha = 5) " +
                                                    "OR APL.estado_apli = 'h' " +
                                                    "OR APL.estado_apli = 'j')");
                                                    * */
        //QUITAR VERIFICACION DE FECHA DE SOLICITUD
        return bDatos.getRegistro("SELECT  ISNULL(SOL.estado, '') estado, ISNULL(APL.estado_apli, '') estado_apli, ISNULL(EST.men_solprac, '') men_estado, ISNULL(SOL.jornada, '') jornada, ISNULL(SOL.disponibilidad, '') disponibilidad, ISNULL(SOL.observaciones, '') observaciones, ISNULL(SOL.asig_conjunta, '') asig_conjunta FROM uge.solicitud_prac SOL INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli=SOL.estado LEFT JOIN uge.aplicaciones_prac APL ON (APL.id_documento = SOL.id_documento AND (APL.estado_apli = 'h' OR APL.estado_apli = 'j')) WHERE   SOL.id_sol =(   SELECT MAX(id_sol) FROM uge.solicitud_prac WHERE id_documento = '"+id_est+"') AND (   SOL.fecha_sol >= (  SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 5) OR APL.estado_apli = 'h' OR APL.estado_apli = 'j')");
    }
    
    @Override
    public HashMap getDatosContratado(String id_est) throws Exception {
        return bDatos.getRegistro(  "SELECT  EMP.razon_social, " +
                                            "EMP.nit, " +
                                            "O.cargo " +
                                    "FROM uge.aplicaciones_prac APL " +
                                        "INNER JOIN uge.ofertas_prac O ON O.id_oferta = APL.id_oferta " +
                                        "INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = O.id_empresa " +
                                    "WHERE   APL.id_documento = '" + id_est + "' " +
                                            "AND (   APL.estado_apli = 'h' " +
                                                    "OR APL.estado_apli = 'j')");
    }
    
    
    @Override
    public HashMap  programamov (String id_est) throws Exception{
        return bDatos.getRegistro("select prog_mov from uge.solicitud_mov where id_solicitud =(select max(id_solicitud) from uge.solicitud_mov where id_est ='"+ id_est+"')");
    }
    @Override
    public HashMap IdAplicacion (String id_est) throws Exception{
        return bDatos.getRegistro("select id_solicitud from uge.solicitud_mov where id_solicitud =(select max(id_solicitud) from uge.solicitud_mov where id_est ='"+ id_est+"')");
    }
    @Override
     public HashMap estadoAplicacion (String idsolicitud) throws Exception
    {
        return bDatos.getRegistro("select estado, id_est, prog_mov from uge.solicitud_mov where id_solicitud ="+ "'"+idsolicitud+"'");
    }
    @Override
     public HashMap mensajeestado(String idest) throws Exception{
       return bDatos.getRegistro("select men_est from uge.estados_mov where id_estado ="+ "'"+idest+"'");
     }
    @Override
     public HashMap estadosbienestar(String idsolicitud) throws Exception{
         return bDatos.getRegistro("select vobo_vice, vobo_psico, vobo_medico from uge.solicitud_mov where id_solicitud ="+ "'"+idsolicitud+"'");
     }
    @Override
    public HashMap [] datosSolicitud (String idSol) throws Exception {
        return bDatos.getRegistros( "SELECT  id_est, " +
                                            "prom_ant, " +
                                            "carta_eci, " +
                                            "prog_mov, " +
                                            "pais_mov, " +
                                            "prom_acum, " +
                                            "uni_destino, " +
                                            "prog_ud,obv_cartaeci, " +
                                            "CONVERT(VARCHAR(7), fecha_in, 111) as fecha_in, " +
                                            "CONVERT(VARCHAR(7), fecha_out,111) as fecha_out " +
                                    "FROM uge.solicitud_mov SOL " +
                                        "LEFT JOIN uge.opcionuni_mov UNI ON UNI.id_solicitud = SOL.id_solicitud " +
                                    "WHERE SOL.id_solicitud = '" + idSol + "'");
    }
    
    @Override
    public HashMap datosSolicitudGeneral (String idSol) throws Exception
    {
        return bDatos.getRegistro("select id_est, prom_ant, prog_mov, pais_mov, prom_acum,"
                + "obv_plan "
                + "from uge.solicitud_mov "
                + "where uge.solicitud_mov.id_solicitud ='" + idSol + "'");
    }
    @Override
    public HashMap datosSolicitudG (String idSol) throws Exception
    {
        return bDatos.getRegistro("select id_est, prom_ant, prog_mov, pais_mov, prom_acum, uni_destino, prog_ud,estado_opcud,obv_plan,vobo_vice,"
                + "convert(varchar(7),fecha_in,111) as fecha_in, convert(varchar(7),fecha_out,111) as fecha_out,obv_plan "
                + "from uge.solicitud_mov,uge.opcionuni_mov "
                + "where uge.solicitud_mov.id_solicitud ='" + idSol + "'and uge.opcionuni_mov.id_solicitud='" + idSol + "'and uge.opcionuni_mov.estado_opcud='aceptado'");
    }
    @Override
    public HashMap[] datosOpcionUni (String idSol) throws Exception{
    return bDatos.getRegistros("select id_est, prom_ant, prog_mov, pais_mov, prom_acum, uni_destino, prog_ud,estado_opcud,"
                + "convert(varchar(7),fecha_in,111) as fecha_in, convert(varchar(7),fecha_out,111) as fecha_out,obv_plan "
                + "from uge.solicitud_mov,uge.opcionuni_mov "
                + "where uge.solicitud_mov.id_solicitud ='" + idSol + "'and uge.opcionuni_mov.id_solicitud='" + idSol + "'");
    }
    @Override
     public HashMap datosEntrevista (String idSol) throws Exception
    {   
        return bDatos.getRegistro("select LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, uge.solicitud_mov.id_est,NATIONAL_ID " +
"                 from uge.solicitud_mov,uge.opcionuni_mov, uge.ps_ec_ib_intp_vw " +
"                 where uge.solicitud_mov.id_est=EMPLID and uge.solicitud_mov.id_solicitud ='"+idSol+"'and uge.opcionuni_mov.id_solicitud='"+idSol+"'and uge.opcionuni_mov.estado_opcud='aceptado'");
        /**ANTES DE CAMPUS
        return bDatos.getRegistro("select nom_est, uge.solicitud_mov.id_est,doc_est "
                
                + "from uge.solicitud_mov,uge.opcionuni_mov, registro.estudiante "
                + "where uge.solicitud_mov.id_est=registro.estudiante.id_est and uge.solicitud_mov.id_solicitud ='" + idSol + "'and uge.opcionuni_mov.id_solicitud='" + idSol + "'and uge.opcionuni_mov.estado_opcud='aceptado'");
                * */
    }
    @Override
    public HashMap datosContrato(String idSol) throws Exception
    {
        return bDatos.getRegistro("select clausula1, clausula2"
                + " from uge.contratos_mov "
                + "where id_solicitud ='" + idSol+"'");
    }
    @Override
    public int registrarmat(String matext, String mateci,String periodo, String idsol) throws Exception{

        HashMap dato;
        String id_opc, id_mat;
        if(( matext.equals("")) || periodo.equals(""))
        {
            return 0;
        }
        else
        {
            dato = bDatos.getRegistro("select id_opcion from uge.opcionuni_mov where id_solicitud ='"+idsol+"' and estado_opcud = 'aceptado'");
            id_opc = (String) dato.get("id_opcion");
            dato = bDatos.getRegistro("select max(id_plan) + 1 id from uge.planest_mov");
            id_mat = (String) dato.get("id");
            return bDatos.actualizar("insert into uge.planest_mov(id_plan, est_plan, materia_ud, materia_eci, semestre, id_opcion) values"
                    + " ('"+id_mat+"','cargado','"+ matext +"','"+ mateci +"','"+ periodo +"','"+ id_opc +"')");
        }
    }
    @Override
    public int eliminarmat (String id_plan)throws Exception{
        return bDatos.actualizar("delete from uge.planest_mov where id_plan ="+ id_plan);

    }
    @Override
    public int eliminarcambiomat (String id_plan)throws Exception{
        return bDatos.actualizar("delete from uge.cambioplan_mov where id_plan ="+ id_plan);
    }
    @Override
    public int Actualizarestadoplan (String id_sol, String clave)throws Exception{

        HashMap dato;
        String id_opc,id_aud;
        int ban,ban2;
        dato = bDatos.getRegistro("select id_opcion from uge.opcionuni_mov where id_solicitud ='"+id_sol+"' and estado_opcud = 'aceptado'");
        id_opc = (String) dato.get("id_opcion");
       ban= bDatos.actualizar("UPDATE uge.planest_mov set"
                  + " est_plan = 'enviado' where id_opcion =" + id_opc);
       ban2= bDatos.actualizar("UPDATE uge.solicitud_mov set"
                  + " estado = 'g'"
                  +  "where id_solicitud =" + "'"+id_sol+"'");
       dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
 ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+id_sol+"','El estudiante con carné numero "+docId
                    +" ha enviado un plan de estudio en la fecha('+convert(varchar,getdate())+')','estudiante con carné no"+docId+"')");
        return ban;
    }
    @Override
    public int Devolverplan (String id_sol, String clave)throws Exception{

        HashMap dato;
        String id_opc,id_aud;
        int ban,ban2;
        dato = bDatos.getRegistro("select id_opcion from uge.opcionuni_mov where id_solicitud ='"+id_sol+"' and estado_opcud = 'aceptado'");
        id_opc = (String) dato.get("id_opcion");
       ban= bDatos.actualizar("UPDATE uge.planest_mov set"
                  + " est_plan = 'cargado' where id_opcion =" + id_opc);
       ban2= bDatos.actualizar("UPDATE uge.solicitud_mov set"
                  + " estado = 'f'"
                  +  "where id_solicitud =" + "'"+id_sol+"'");
       dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
       return bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+id_sol+"','La decanatura ha devuelto el plan de estudio para corrección por parte del estudiante en la fecha ('+convert(varchar,getdate())+')','Decanatura con usuario: "+docId+"')");
    }
    @Override
    public int Actualizarestadocambioplan (String id_sol, String clave,String usr)throws Exception
    {
         HashMap dato;
        String id_opc,id_aud;
        int ban,ban2;
        dato = bDatos.getRegistro("select id_opcion from uge.opcionuni_mov where id_solicitud ='"+id_sol+"' and estado_opcud = 'aceptado'");
        id_opc = (String) dato.get("id_opcion");
       ban= bDatos.actualizar("UPDATE uge.cambioplan_mov set"
                  + " est_plan = 'enviado' where id_opcion =" + id_opc);
       ban2= bDatos.actualizar("UPDATE uge.solicitud_mov set"
                  + " estado = 'j'"
                  +  "where id_solicitud =" + "'"+id_sol+"'");
       dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
       return bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+id_sol+"','El estudiante con carné No "+usr+" que se encuentra en el exterior ha enviado una solicitud para cambiar su plan de estudio en la fecha ('+convert(varchar,getdate())+')','Estudiante con carné: "+usr+"')");
    }
    @Override
    public int ActSolicitudPrac(String ProgramaSolicitado,String ExvPrac,String ElcvPrac,String idest, String asigConj) throws Exception{
        HashMap dato;
        String id_sol;

        //jornada,"+ " expectativas, electivas, estado, fecha_sol
        dato = bDatos.getRegistro("select max(id_sol) id from uge.solicitud_prac where id_documento='" + idest + "'");
        id_sol = (String) dato.get("id");
           return  bDatos.actualizar("UPDATE uge.solicitud_prac set"
                  + " jornada = '"+ProgramaSolicitado+"',"
                  + "expectativas = '"+ExvPrac+"',"
                  + " electivas = '"+ElcvPrac+"',"
                   + "asig_conjunta = '" + asigConj + "',"
                  + " estado = 'b',"
                  + " fecha_sol = getdate()"
                  +  "where id_sol =" + "'"+id_sol+"'");

    }

    @Override
    public int crearSolicitud(String programa_sol, String pais_mov, String idest) throws Exception {


        HashMap dato;
        String id_sol, opc1, opc2;
        int ban, ban1, ban2;


        dato = bDatos.getRegistro("select max(id_solicitud) id from uge.solicitud_mov where id_est='"+idest+"'");
        id_sol = (String) dato.get("id");
        
        return bDatos.actualizar("update uge.solicitud_mov set prog_mov='"+programa_sol+"', pais_mov='"+pais_mov+"' where id_solicitud='"+id_sol+"'");

          
    }
    
    private String prepareStringToSQL(String input){
        return input.replace("'", "");
    }
    
    @Override
    public int crearSolicitud_int_mov_campus(String NUM_SOL_SERV, String EMPLID, String PROM_ANT, String MAIL_ACUD, String PROM_ACUM, String SEM_EST, String OBS_PS, String ACAD_PROG, String STRM) throws Exception {

        HashMap dato;
        int ban;
        String query="";
        
        
        if(OBS_PS!=null && !OBS_PS.equals("")){
            OBS_PS=prepareStringToSQL(OBS_PS);
        }
        
        if(MAIL_ACUD!=null && !MAIL_ACUD.equals("")){
            MAIL_ACUD=prepareStringToSQL(MAIL_ACUD);
        }
        
        query = "INSERT INTO uge.solicitud_mov " +
                                    "           (id_est " +
                                    "           ,prom_ant " +
                                    "           ,estado " +
                                    "           ,email_acudiente " +
                                    "           ,prom_acum " +
                                    "           ,sem_est " +
                                    "           ,obs_ps " +
                                    "           ,sol_serv_ps"+ 
                                    "           ,acad_prog"+ 
                                    "           ,strm) " +
                                    "     VALUES "+
                                    "           ("+ EMPLID +
                                    "           ," + PROM_ANT +
                                    "           ,'b' " +
                                    "           ,'"+ MAIL_ACUD + "'"+
                                    "           ," + PROM_ACUM +
                                    "           ," + SEM_EST +
                                    "           ,'" + OBS_PS + "'" +
                                    "           ,'"+NUM_SOL_SERV+"'"+
                                    "           ,'"+ACAD_PROG+"'"+
                                    "           ,'"+STRM+"'"+") ";

        ban = bDatos.actualizar(query);
        
        if(ban==1){
            query = "insert into uge.opcionuni_mov (id_solicitud, id_opcion, estado_opcud, uni_destino, prog_ud, duracion, fecha_in, fecha_out, carta_ud, vobo_foresp) " +
                "values ((select max(id_solicitud) from uge.solicitud_mov where id_est='"+EMPLID+"') , (select max(id_opcion)+1 from uge.opcionuni_mov), 'en espera', '"+OBS_PS+"', '"+OBS_PS+"', NULL, GETDATE(), NULL, NULL, NULL)";
            
            ban=bDatos.actualizar(query);
        }
        
        
        
        
        
        return ban;
    } 
    
    @Override
    public int crearSolicitud_int_prac_campus(String NUM_SOL_SERV, String EMPLID, String ELECT_ESTD, String FECHA_SOL, String FECHA_APROB, String ACAD_PROG, String STRM) throws Exception {

        HashMap dato;
        dato = bDatos.getRegistro("select max(id_sol) + 1 id from uge.solicitud_prac");
        String id_sol = (String) dato.get("id");
        int ban;
        
        if(ELECT_ESTD!=null && !ELECT_ESTD.equals("")){
            ELECT_ESTD=prepareStringToSQL(ELECT_ESTD);
        }
        
        
        
        String query = "";
        
        query="INSERT INTO [uge].[solicitud_prac] " +
                        "           ( [id_sol]" +
                        "           ,[id_documento] " +
                        "           ,[electivas] " +
                        "           ,[estado] " +
                        "           ,[fecha_sol] " +
                        "           ,[sol_serv_ps] " +
                        "           ,[fecha_aprob]" + 
                        "           ,[acad_prog]" + 
                        "           ,[strm]" + 
                        "           ,[jornada]) " +
                        "     VALUES " +
                        "           ("+ id_sol + ", " + EMPLID +
                        "            " +
                        "           ,'" + ELECT_ESTD +"'"+
                        "           ,'c' " +
                        "           ,'" + FECHA_SOL + "'"+
                        "           , '" + NUM_SOL_SERV + "'"+
                        "           ,'"+ FECHA_APROB + "'"+
                        "           ,'"+ ACAD_PROG + "'"+
                        "           ,'"+ STRM +"'" +
                        "           ,'TIEMPO COMPLETO') " ;

        
        
        ban = bDatos.actualizar(query);
        
        return ban;
    } 
    
    @Override
    public int crearSolicitudPrac(String ProgramaSolicitado,String ExvPrac,String ElcvPrac,String idest, String asigConj) throws Exception{
        HashMap dato;
        String id_sol, opc1, opc2;
        int ban, ban1, ban2;
        dato = bDatos.getRegistro("select max(id_sol) + 1 id from uge.solicitud_prac");
        id_sol = (String) dato.get("id");
        return bDatos.actualizar("insert into uge.solicitud_prac "
                + "(id_sol, id_documento, jornada,"
                + " expectativas, electivas, estado, fecha_sol, asig_conjunta) values ("
                + "'" + id_sol + "'," + "'"+idest+"'" + ",'" + ProgramaSolicitado+ "'," + "'" + ExvPrac+"',"+ "'" + ElcvPrac + "',"+"'b',getdate(), '" + asigConj + "')");
    }
    @Override
    public int regDisponibilidadEst(String disponibilidad, String idest) throws Exception{
       return bDatos.actualizar("UPDATE uge.solicitud_prac set disponibilidad='"+disponibilidad+"' where id_documento='"+idest+"'");
    }
    @Override
    public int ActualizarOpcuni (String fechain, String fechaout,String id_est) throws Exception
    {

        int ban;
        HashMap idsol = bDatos.getRegistro("select id_solicitud from uge.solicitud_mov where id_solicitud =(select max(id_solicitud) from uge.solicitud_mov where id_est ='"+ id_est+"')");
        String id_solicitud=idsol.get("id_solicitud").toString();
        String fecha_in_formato= fechain.split("/")[1]+"/"+fechain.split("/")[0]+"/01";
        String fecha_out_formato= fechaout.split("/")[1]+"/"+fechaout.split("/")[0]+"/01";
        
        ban= bDatos.actualizar("update uge.opcionuni_mov set fecha_in='"+fecha_in_formato+"', fecha_out='"+fecha_out_formato+"' where id_solicitud='"+id_solicitud+"'");
        return ban;

    }
    @Override
    public int ActualizarVobosSolicitud(String idsolicitud, String clave, String nomcampo, String tipo) throws Exception
    {
        HashMap dato;
String id_aud;
int ban;
        ban= bDatos.actualizar("UPDATE uge.solicitud_mov set "
                  +  nomcampo + "="
                  + "'"+clave+"'" +  "where id_solicitud =" + "'"+idsolicitud+"'");
        dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
        if(clave.equals("cargado")){
 ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','El estudiante con carné numero "+docId
                    +" ha cargado el documento tipo "+tipo+" en la fecha('+convert(varchar,getdate())+')','estudiante con carné no"+docId+"')");}
        else{
            ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','se ha cambiado el estado de un documento tipo: "+tipo+" su estado ha quedado: "
                + ""+clave+" en la fecha('+convert(varchar,getdate())+')','usuario: ORI')");
        }
        return ban;
    }
    @Override
    public int ActualizarEstOpcUni(String idsolicitud, String clave, String idopc) throws Exception
    {
        int ban;
        HashMap dato;
        String ban2,id_aud;
        dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
        if(clave.equals("rechazado_por_uni")||clave.equals("rechazado_por_est"))
        {
            ban= bDatos.actualizar("UPDATE uge.opcionuni_mov set estado_opcud ="                  
                  + "'"+clave+"'" +  "where id_opcion =" + "'"+idopc+"'");
            ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','se ha cambiado el estado de la opcion de una universidad: "+idopc+" su estado ha quedado: "
                + ""+clave+" en la fecha('+convert(varchar,getdate())+')','usuario: ORI')");
            return ban;
        }
        else{
            ban = bDatos.actualizar("UPDATE uge.opcionuni_mov set estado_opcud ="                  
                  + "'"+clave+"'" +  "where id_opcion =" + "'"+idopc+"'");
            ban= bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','se ha cambiado el estado de la opcion de una universidad: "+idopc+" su estado ha quedado: "
                + ""+clave+" en la fecha('+convert(varchar,getdate())+')','usuario: ORI')");
            dato=bDatos.getRegistro("if  exists(select id_opcion from uge.opcionuni_mov where  id_solicitud ='"+idsolicitud+"' and id_opcion != '"+idopc+"' and estado_opcud = 'en espera')"
                    + "BEGIN select '1' as existe "
                    + "END ELSE select '0' as existe");
            ban2= (String) dato.get("existe");
            if(ban2.equals("1")){
                ban = bDatos.actualizar("UPDATE uge.opcionuni_mov set estado_opcud = 'rechazado_por_est'"                  
                       +  "where id_solicitud =" + "'"+idsolicitud+"' and id_opcion !="+ "'"+idopc+"' and estado_opcud = 'en espera'");
                dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
                id_aud=(String) dato.get("id");
                return bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                        + "values('"+id_aud+"','"+idsolicitud+"','se ha cambiado el estado de la opcion de una universidad: "+idopc+" su estado ha quedado: "
                    + ""+clave+" en la fecha('+convert(varchar,getdate())+')','usuario: ORI')");
            } else{
                return ban;
            }
        }
        
    }

    @Override
    public int ActualizarVobosOpcUni (String idsolicitud, String clave, String nomcampo, String tipo)throws Exception
    {
        HashMap dato;
        String id_aud;
        int ban;
        if( (tipo.equals("FormatoU1")) ||(tipo.equals("CartaU1"))){
         ban= bDatos.actualizar("UPDATE uge.opcionuni_mov set "
                  +  nomcampo + "="
                  + "'"+clave+"'" +  "where  id_opcion =(select MIN(id_opcion)from uge.opcionuni_mov WHERE id_solicitud ="
                  + idsolicitud + ")");
        }
        else
        {
             ban= bDatos.actualizar("UPDATE uge.opcionuni_mov set "
                  +  nomcampo + "="
                  + "'"+clave+"'" +  "where  id_opcion =(select MAX(id_opcion)from uge.opcionuni_mov WHERE id_solicitud ="
                  + idsolicitud + ")");

        }
        dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
        if(clave.equals("cargado")){
                ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','El estudiante con carné numero"+docId
                    +" ha cargado el documento tipo "+tipo+" en la fecha('+convert(varchar,getdate())+')','estudiante con carné no"+docId+"')");
        }else{
        ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','se ha cambiado el estado de un documento tipo: "+tipo+" su estado ha quedado: "
                + ""+clave+" en la fecha('+convert(varchar,getdate())+')','usuario: ORI')");
        }
        return ban;
    }
    @Override
    public int ActualizarEstado(String idsolicitud, String clave ) throws Exception
    {
        HashMap dato;
        String id_aud;
        int ban;
         dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
        if(clave.equals("k")){            
            ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','se ha Finalizado con exito el intercambio"
                +" en la fecha('+convert(varchar,getdate())+')','usuario: ORI')");
        }
        return bDatos.actualizar("UPDATE uge.solicitud_mov set"
                  + " estado ="
                  + "'"+clave+"'" +  "where id_solicitud =" + "'"+idsolicitud+"'");
    }
    @Override
    public int FinalizarProceso(String idsolicitud, String clave, String comentario) throws Exception
    {
        HashMap dato;
        String id_aud;
        int ban;
         dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
        
        ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','se ha Finalizado la solicitud"
                +" en la fecha('+convert(varchar,getdate())+') con el siguiente comentario: " + comentario + "','usuario: ORI')");
            
        return bDatos.actualizar("UPDATE uge.solicitud_mov set"
                  + " estado ="
                  + "'"+clave+"'" +  "where id_solicitud =" + "'"+idsolicitud+"'");
    }
    @Override
    public HashMap[] getListaEstDoc(String res, String iddpto, String progmov) throws Exception {
        return bDatos.getRegistros("select id_solicitud, LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov " +
                                    "from UGE.ps_ec_ib_intp_vw, uge.solicitud_mov " +
                                    "where uge.solicitud_mov.id_est=EMPLID " +
                                    "        and (uge.solicitud_mov.estado = 'c' or uge.solicitud_mov.estado = 'e' ) " +
                                    "order by nom_est desc");
        /**ANTES DE CAMPUS SE DEBE MODIFICAR DE ACUERDO A CAMPUS TODO
         if (iddpto.equals("0"))
         {
             if(progmov.equals("0"))
             {
                 return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov"
                + " from registro.estudiante, registro.uge.solicitud_mov"
                + " where uge.solicitud_mov.id_est=registro.estudiante.id_est"
                         + " and (uge.solicitud_mov.estado = 'c' or uge.solicitud_mov.estado = 'e' )"
                + " order by nom_est desc");
             }
            else
            {
                 return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov"
                + " from registro.estudiante, registro.uge.solicitud_mov"
                + " where uge.solicitud_mov.id_est=registro.estudiante.id_est and prog_mov=" + progmov
                         + " and uge.solicitud_mov.estado = 'c'"
                + " order by nom_est desc");
            }

         }
         else
         {
             if(progmov.equals("0"))
             {
                 return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov"
                    + " from registro.estudiante, registro.uge.solicitud_mov"
                    + " where uge.solicitud_mov.id_est=registro.estudiante.id_est and registro.estudiante.id_dpto=" + iddpto
                    + " and uge.solicitud_mov.estado = 'c'"
                    + " order by nom_est desc" );
             }
             else{
                   return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov"
                    + " from registro.estudiante, registro.uge.solicitud_mov"
                    + " where uge.solicitud_mov.id_est=registro.estudiante.id_est and registro.estudiante.id_dpto=" + iddpto
                    + " and prog_mov="+ progmov
                    + " and uge.solicitud_mov.estado = 'c'"
                    + " order by nom_est desc" );
                 }
         }
         * */
    }
    @Override
   public HashMap[] Listaplan( String idsol) throws Exception{
         HashMap dato;
        String id_opc;
        dato = bDatos.getRegistro("select id_opcion from uge.opcionuni_mov where id_solicitud ='"+idsol+"' and estado_opcud = 'aceptado'");
        id_opc = (String) dato.get("id_opcion");
        return bDatos.getRegistros("select prog_mov,est_plan, materia_ud, materia_eci, semestre,id_plan "
                    + " from uge.solicitud_mov,uge.planest_mov"
                    + " where id_opcion=" + id_opc+" and id_solicitud="+ idsol);

    }
    @Override
   public HashMap[] Listacambioplan(String idsol) throws Exception{
        HashMap dato;
        String id_opc;
        dato = bDatos.getRegistro("select id_opcion from uge.opcionuni_mov where id_solicitud ='"+idsol+"' and estado_opcud = 'aceptado'");
        id_opc = (String) dato.get("id_opcion");
        return bDatos.getRegistros("select uge.planest_mov.materia_ud, uge.cambioplan_mov.materia_ud as materiacambio,  "
                + "uge.cambioplan_mov.semestre, motivo, uge.cambioplan_mov.est_plan, uge.cambioplan_mov.id_plan from uge.planest_mov, "
                + "uge.cambioplan_mov where  uge.planest_mov.id_plan=uge.cambioplan_mov.id_plan and "
                + "uge.cambioplan_mov.id_opcion='"+id_opc+"'");
   }
    @Override
   public HashMap []getpaises() throws Exception{
       return bDatos.getRegistros("select cod_iso as cod_pai, nom_pais as nom_pai from uge.paises order by nom_pai");
   }
    @Override
   public HashMap Idultimateria(String idsol) throws Exception{
       HashMap dato;
        String id_opc;
        dato = bDatos.getRegistro("select id_opcion from uge.opcionuni_mov where id_solicitud ='"+idsol+"' and estado_opcud = 'aceptado'");
        id_opc = (String) dato.get("id_opcion");
        return bDatos.getRegistro("select max(id_plan) id from uge.solicitud_mov, uge.planest_mov where id_opcion="+id_opc+"and id_solicitud="+ idsol);
   }
    @Override
   public HashMap cometarios_sol(String id_sol) throws Exception
   {
       return bDatos.getRegistro("select obv_cartaeci, obv_plan, obv_vice, obv_docu from uge.solicitud_mov where id_solicitud="+ id_sol);
   }
    
    @Override
    public HashMap carnetEst(String usuario) throws Exception {
        
        HashMap resultado = new HashMap();
        /* Login en Producción
        //Estudiantes en excepción
        if (usuario.equals("mario.martinez-b")) {
            return bDatos.getRegistro("select id_est from registro.estudiante where emails like '" + usuario + "' AND id_est='2077126'");
        }*/
        
        try {
        
            String carnet;
            /**

            carnet = (String) bDatos.getRegistro(   "SELECT id_est " +
                                                    "FROM registro.estudiante " +
                                                    "WHERE   ((estado > 0 " +
                                                            "AND estado NOT IN ('10', '20') OR '"+usuario+"' IN ('debora.pinzon','felipe.suarez')) " +
                                                            "OR (tip_est = 'E' " +
                                                            "AND fec_insc >= (   SELECT fecha_inicio " +
                                                                                "FROM registro.inscrito_pregrado " +
                                                                                "WHERE id_evento = 4))) " +
                                                            "AND emails = '" + usuario + "'").get("id_est");

            if (carnet == null) {
                
                HashMap[] noActivo = bDatos.getRegistros(   "SELECT id_est " +
                                                            "FROM registro.estudiante " +
                                                            "WHERE   estado BETWEEN '-90' AND '-1' " +
                                                                    "AND estado NOT IN ('-19', '-11', '-10') " +
                                                                    "AND emails <> '' " +
                                                                    "AND emails NOT LIKE '%@%' " +
                                                                    "AND emails = '" + usuario + "'");

                if (noActivo.length > 0) {
                    
                    if (noActivo.length > 1) throw new Exception("");
                    
                    carnet = (String) noActivo[0].get("id_est");
                    
                    boolean Inactivo2Periodos = false;
                    HashMap ultActividad = bDatos.getRegistro(  "SELECT LEFT(MAX(per_acad), 4) ult_ano, RIGHT(MAX(per_acad), 1) ult_per " +
                                                                "FROM registro.biblia_def " +
                                                                "WHERE   per_acad NOT LIKE '%-0' " +
                                                                        "AND per_acad NOT LIKE '%-I' " +
                                                                        "AND clave NOT IN ('R', 'C') " +
                                                                        "AND id_est = '" + carnet + "'");

                    int ultAno = Integer.parseInt((String) ultActividad.get("ult_ano"));
                    int ultPer = Integer.parseInt((String) ultActividad.get("ult_per"));

                    Calendar hoy = Calendar.getInstance();
                    int actAno = hoy.get(Calendar.YEAR);
                    int actPer = ((hoy.get(Calendar.MONTH)+1)<7)?1:2;

                    if (actAno > ultAno) {
                        int cantPer = ((actAno - ultAno)*2)-1;
                        if (actPer < ultPer) cantPer -= 1;
                        if (actPer > ultPer) cantPer += 1;
                        
                        if (cantPer >= 2) Inactivo2Periodos = true;
                    }
                    
                    if (Inactivo2Periodos) throw new Exception("");
                } else {
                    carnet = (String) bDatos.getRegistro(   "SELECT id_est " +
                                                            "FROM registro.estudiante " +
                                                            "WHERE   estado IN ('-91', '-92', '-93', '-94', '-95', '-96') " +
                                                                    "AND emails = '" + usuario + "'").get("id_est");

                    if (carnet == null) throw new Exception("");
                }
            }
            
            resultado.put ("id_est", carnet);
            return resultado;*/
            
            resultado.put("id_est", this.getEmplId(usuario));
        
        } catch (Exception err) {
            resultado.put ("id_est", null);
            return resultado;
        }
        return resultado;
        /* Login en Pruebas */
        //return bDatos.getRegistro("select id_est from registro.estudiante where emails like '"+ usuario+"'");
    }
    
    @Override
    public HashMap carnetEstPrac(String usuario) throws Exception {
        //ESTE METODO YA NO SE USA
        HashMap resultado = new HashMap();
        
        try {
            
            //Obtiene el carnet yel plan de estudio del estudiante que esté asociado al correo institucional dado, y verifica que se encuentre activo en la institución
            HashMap estudiante = bDatos.getRegistro("SELECT  id_est, " +
                                                            "id_plan " +
                                                    "FROM registro.estudiante " +
                                                    "WHERE  ((estado > 0 " +
                                                            "AND estado NOT IN ('10', '20')) OR estado = -3 " +
                                                            "OR (tip_est = 'E' " +
                                                            "AND fec_insc >= (   SELECT fecha_inicio " +
                                                                                "FROM registro.inscrito_pregrado " +
                                                                                "WHERE id_evento = 4))) " +
                                                            "AND emails = '" + usuario + "'");
            
            String carnet = (String) estudiante.get("id_est");
            
            if (carnet != null) {
                
                String plan = (String) estudiante.get("id_plan");
                
                 //Esto es para que el estudiante pueda hacer su solicitud de practica de su segundo programa (14) sin haber terminado el primero (17)
                if(carnet.equals("2107532")){
                    plan="300";
                }
                
                
                
                //Obtiene los créditos totales y aprobados del estudiante
                HashMap credTotal = bDatos.getRegistro( "SELECT SUM(PE.peso) cred_total " +
                                                        "FROM registro.asplanestud PE " +
                                                        "WHERE   PE.idest = '" + carnet + "' " +
                                                                "AND PE.idplan = '" + plan + "'");
                
                HashMap credAprob = bDatos.getRegistro( "SELECT SUM(PE.peso) cred_aprob " +
                                                        "FROM registro.asplanestud PE " +
                                                            "INNER JOIN registro.biblia_def BD ON (BD.id_est = PE.idest AND BD.id_asig = PE.idas) " +
                                                        "WHERE   BD.nota >= 30 " +
                                                                "AND BD.clave NOT IN ('R', 'C') " +
                                                                "AND PE.idest = '" + carnet + "' " +
                                                                "AND PE.idplan = '" + plan + "'");

                float credTot = Float.parseFloat(credTotal.get("cred_total").toString());
                float credApr = Float.parseFloat(credAprob.get("cred_aprob").toString());
                
                //Compara si la cantidad de créditos aprobados es mayor al 70% del total de créditos del plan.
                if (Math.ceil((credApr/credTot)*100f) < 70f) throw new Exception("");
                
            } else {
                carnet = (String) bDatos.getRegistro(   "SELECT id_est " +
                                                        "FROM registro.estudiante " +
                                                        "WHERE   estado = '20' " +
                                                                "AND emails = '" + usuario + "'").get("id_est");
                
                if (carnet == null) throw new Exception("");
            }
            
            //Comprueba la asistencia al seminario de Mercado Laboral (registrado por la UGE)
            HashMap seminario = bDatos.getRegistro( "SELECT estadoc estado " +
                                                    "FROM registro.inscrito_eventos INS " +
                                                        "INNER JOIN registro.eventos E ON (E.id_evento = INS.id_evento AND E.dpto = 253) " +
                                                    "WHERE   INS.id_Curso = 1001 " +
                                                            "AND documento = '" + carnet + "' and estadoc = 'APROBADO'");

            if (!((String) seminario.get("estado")).equals("APROBADO")) throw new Exception(""); 
            
            
            resultado.put ("id_est", carnet);
            return resultado;//*/


            /* Login de Prueba*/
            //return bDatos.getRegistro("SELECT id_est FROM registro.estudiante WHERE emails = '" + usuario + "'");
      } catch (Exception err) {
          resultado.put ("id_est", null);
          return resultado;
      }
      
   }
    
   @Override
   public int guardarcmt(String id_sol, String nom_cam, String comen) throws Exception
   {
       return bDatos.actualizar("UPDATE uge.solicitud_mov set "
                  +  nom_cam + "=( select CAST(isnull("+nom_cam+",'') AS varchar(MAX))+ "+" '\n "+comen+" (comentario enviado en la fecha - '+ CAST(getdate()AS char)+')' from  uge.solicitud_mov  where id_solicitud =" + "'"+id_sol+"')"
                   +" where id_solicitud =" + "'"+id_sol+"'");
   }
    @Override
   public int RegistrarEstEmp(String id_est, String prog_mov) throws Exception{
      return bDatos.actualizar("INSERT INTO uge.est_esp_mov (id_est, prog_mov) values ('"+id_est+"','"+prog_mov+"')");
   }
    @Override
   public int RegistrarmateriaCambio(String plan, String nuevamat, String nuevoperiodo, String motivocambio ) throws Exception{
       int ban;
       ban = bDatos.actualizar("INSERT INTO uge.cambioplan_mov (id_plan, materia_eci, id_opcion) SELECT id_plan, materia_eci, id_opcion FROM uge.planest_mov WHERE uge.planest_mov.id_plan = '"+plan+"'");
       return bDatos.actualizar("UPDATE uge.cambioplan_mov set materia_ud='"+nuevamat+"',semestre='"+nuevoperiodo+"',motivo='"+motivocambio+"',est_plan='cargado'"
               + " where id_plan='"+plan+"'");
   }
    @Override
   public HashMap[] getsectoresest()throws Exception{
      return bDatos.getRegistros("select nom_sector from uge.sectores_sige order by nom_sector");
    }
    
    @Override
    public HashMap[] getTiposEstudios()throws Exception{
        return bDatos.getRegistros( "SELECT  ID, " +
                                            "nom_tipo " +
                                    "FROM uge.tipos_estudios_sige " +
                                    "ORDER BY ID");
    }
    
    @Override
    public HashMap[] getTiposEstudios(String id_est)throws Exception{
        return bDatos.getRegistros( "SELECT DISTINCT TE.ID, " +
                                                    "TE.nom_tipo " +
                                    "FROM uge.tipos_estudios_sige TE " +
                                        "INNER JOIN uge.estudios_sige EST ON EST.tipo_estudio = TE.ID " +
                                    "WHERE EST.id_documento = '" + id_est + "' " +
                                    "ORDER BY TE.ID");
    }
    
    @Override
   public HashMap programaacademicoest (String empl_id) throws Exception{
       
       //
       /**ANTES DE CAMPUS
        return bDatos.getRegistro("select registro.programas.nom_prog, registro.estudiante.nom_est from "
                + "registro.programas, registro.estudiante, registro.plan_estud where "
                + "registro.estudiante.id_plan=registro.plan_estud.id_plan and "
                + "registro.plan_estud.id_prog = registro.programas.id_prog and id_est= '"+ id_est+"'");
                * */
       return bDatos.getRegistro("select progs.DESCRIPCION nom_prog,  LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est from uge.ps_ec_ib_intp_vw datos, uge.homol_progs_campus progs, uge.solicitud_prac solicitud where datos.EMPLID='"+empl_id+"' and solicitud.ACAD_PROG=progs.ACAD_PROG and solicitud.id_documento=datos.EMPLID");
    }
    
    @Override
    public int ActDatosPrac(String tel2prac, String celprac, String email2prac, String perfilprac, String refprac, String exvprac, String id_est, String electivasprac) throws Exception{
        HashMap dato = bDatos.getRegistro(  "IF EXISTS(" +
                                                "SELECT id_documento " +
                                                "FROM uge.datos_prac " +
                                                "WHERE id_documento ='" + id_est + "') " +
                                            "BEGIN SELECT '1' AS ban END ELSE SELECT '0' AS ban");
        String ban = (String) dato.get("ban");
        bDatos.actualizar( "update uge.solicitud_prac set electivas='"+electivasprac+"' where id_documento='"+id_est+"'");
        HashMap datosSol=bDatos.getRegistro("select electivas, acad_prog from uge.solicitud_prac where id_documento='"+id_est+"'");
        if(datosSol.get("electivas")!=null &&  !((String) datosSol.get("electivas")).trim().equals("")){
            electivasprac=datosSol.get("electivas").toString();
        }
        
        
        if (ban.equals("1")) {
            
            
            return bDatos.actualizar(   "UPDATE uge.datos_prac " +
                                        "SET    id_est = " + id_est +", " +
                                                "tel2 = '" + tel2prac + "', " +
                                                "email2 = '" + email2prac + "', " +
                                                "cel = '" + celprac + "', " +
                                                "perfil = '" + perfilprac + "', " +
                                                "referencias = '" + refprac + "', " +
                                                "expectativas = '" + exvprac + "', " +
                                                "estado = 'a', " +
                                                "electivas = '" + electivasprac + "' " +
                                        "WHERE id_documento = '" + id_est + "'");
        } else {
            return  bDatos.actualizar(  "INSERT INTO uge.datos_prac (" +
                                            "id_documento, " +
                                            "id_est, " +
                                            "tel2, " +
                                            "email2, " +
                                            "cel, " +
                                            "perfil, " +
                                            "referencias, " +
                                            "expectativas, " +
                                            "electivas) " +
                                        "values (" +
                                            "'" + id_est + "', " +
                                            id_est + ", " +
                                            "'" + tel2prac + "', " +
                                            "'" + email2prac + "', " +
                                            "'" + celprac + "'," +
                                            "'" + perfilprac + "', " +
                                            "'" + refprac + "', " +
                                            "'" + exvprac + "', " +
                                            "'" + electivasprac + "')");
        }
    }
    
    @Override
    public HashMap datosprac(String empl_id) throws Exception{
        
        /** ANTES DE CAMPUS
        return bDatos.getRegistro(  "SELECT  ISNULL(tel2,'') tel2, " +
                                            "ISNULL(email2,'') email2, " +
                                            "ISNULL(cel, '') cel, " +
                                            "ISNULL(perfil, '') perfil, " +
                                            "ISNULL(referencias, '') referencias, " +
                                            "ISNULL(expectativas, '') expectativas, " +
                                            "ISNULL(estado, '') estado, " +
                                            "ISNULL(electivas, '') electivas " +
                                    "FROM uge.datos_prac " +
                                    "WHERE id_documento = '" + idest + "'");
                                    * */
        return bDatos.getRegistro("select DATOSPRAC.tel2, ISNULL(EMAIL_ADDR, '') email2,  DATOSPRAC.cel,  ISNULL(perfil, '') perfil, ISNULL(DATOSPRAC.referencias, '')  referencias,  ISNULL(DATOSPRAC.expectativas, '') expectativas,  ISNULL(SOLICITUD.estado, '') estado,  ISNULL(SOLICITUD.electivas, '') electivas  from uge.ps_ec_ib_intp_vw as DATOS, uge.solicitud_prac as SOLICITUD, uge.datos_prac as DATOSPRAC where DATOS.EMPLID=SOLICITUD.id_documento and DATOS.EMPLID=DATOSPRAC.id_documento and DATOS.EMPLID='"+empl_id+"'");
    }
    
    @Override
    public int  RegistrarestPrac(String id_documento,String prog_estprac,String titulo_prac,String sector_estprac,String nom_instprac,
            String pais_estprac,String ciudad_estprac,String fecha_estprac, String tipo_estudio) throws Exception {
        HashMap dato;
        String id_estgrad;
        dato = bDatos.getRegistro("select max(id_estudio) + 1 id from uge.estudios_sige");
        id_estgrad = (String) dato.get("id");
        
        String fecha_estprac_formato= fecha_estprac.split("/")[1]+"/"+fecha_estprac.split("/")[0]+"/01";

        //
        return bDatos.actualizar("insert into uge.estudios_sige "
             + "(nivel_formacion, titulo,"
             + " sector, nom_inst, pais_inst, ciudad_inst, fecha_grado, id_documento, nom_estudio, tipo_estudio) values ("
             +  "'OTRO'" + ",'" + titulo_prac + "'," + "'" + sector_estprac+"',"+ "'" + nom_instprac 
             + "',"+"'"+ pais_estprac + "',"+"'"+ ciudad_estprac + "','"+fecha_estprac_formato+"',"+"'"+ id_documento + "',"+"'"
             + prog_estprac+"', " + tipo_estudio + ")");
    }
    
    @Override
    public HashMap Idultimoestprac(String docgrad) throws Exception{
           return bDatos.getRegistro("select max(id_estudio) id from uge.estudios_sige where id_documento=" + docgrad);
     }
    
    @Override
    public HashMap datosContPrac(String id_documento) throws Exception{
        
        
        return bDatos.getRegistro("select LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, PHONE as tel_corr, tel2, " 
                +"ADDRESS1 as dir_corr, [USER] as emails, email2, cel, perfil, referencias, expectativas,  electivas " +
                "from uge.ps_ec_ib_intp_vw, uge.datos_prac where EMPLID='"+id_documento+"' and id_documento=EMPLID");
        
        /**ANTES DE CAMPUS
           return bDatos.getRegistro("select nom_est, tel_corr, tel2, dir_corr, emails,email2, cel,perfil, referencias, expectativas, "
                   + "electivas  from uge.datos_prac, registro.estudiante where id_documento=Cast(registro.estudiante.id_est as varchar) "
                   + "and registro.estudiante.id_est = '"+id_documento+"'");
        * */
       }
    @Override
    public HashMap[] getExperienciasPrac(String doc_grad) throws Exception{
       return bDatos.getRegistros("select nom_empresa, cargo, estado_cargo, "
               + "convert(varchar(7),fecha_in_cargo,111) as fecha_in_cargo, convert(varchar(7),fecha_out_cargo,111) "
               + "as fecha_out_cargo, funciones, logros, dir_emp, tel_emp from uge.explaboral_egre where id_documento='" + doc_grad + "' order by fecha_in_cargo desc");
    }
    @Override
    public HashMap[] getEstudiosPrac(String doc_grad) throws Exception{
       return bDatos.getRegistros(  "SELECT  nom_estudio, " +
                                            "titulo, " +
                                            "nom_inst, " +
                                            "CONVERT(VARCHAR(7), fecha_grado, 111) f_grado, " +
                                            "tipo_estudio " +
                                    "FROM uge.estudios_sige " +
                                    "WHERE id_documento = '" + doc_grad + "' " +
                                    "ORDER BY tipo_estudio, fecha_grado DESC");
    }
    @Override
    public HashMap[] getIdiomasPrac(String doc_grad) throws Exception{
              return bDatos.getRegistros("select nom_idioma, niv_lectura, niv_escritura, "
               + "niv_habla"
               + " from uge.idiomas_sige where id_documento='"+doc_grad+"'");
    }
    @Override
    public HashMap[] getDistincionesPrac(String doc_grad) throws Exception{
              return bDatos.getRegistros("select id_distincion, nom_distincion, lugar_distincion, tipo_distincion, ambito_distincion, convert(varchar(7),fecha_distincion,111) fecha_distincion, id_documento from uge.distinciones_sige where id_documento='"+doc_grad+"' order by fecha_distincion desc");
    }
    @Override
     public HashMap[] getAfiliacionesPrac(String doc_grad) throws Exception{
              return bDatos.getRegistros("SELECT id_afiliacion, nom_aso, tipo_aso, estado_afi, convert(varchar(7),fecha_in,111) fecha_in,fecha_out, id_documento FROM uge.afiliaciones_sige where id_documento='"+doc_grad+"' order by fecha_in desc");
    }
    @Override
     public HashMap[] getListaOfertaPracEst(String iddpto,String idest,String TipoOferPracEst,String TipoOferPracEst2) throws Exception{
        
         iddpto=this.getIdDpto(iddpto);
         
        HashMap[] resultado;
        
        resultado = bDatos.getRegistros( "SELECT  DISTINCT  R.id_req, "
                                                    + "R.id_oferta, "
                                                    + "O.cargo, "
                                                    + "CONVERT(VARCHAR(10), O.fecha_limite, 103) fecha_limite, "
                                                    + "O.horario_oferta, "
                                                    + "O.id_empresa, "
                                                    + "E.razon_social, "
                                                    + "E.nit "
                                            + "FROM uge.ofertas_prac O "
                                                + "INNER JOIN uge.solicitud_prac SOL ON (SOL.id_documento = '" + idest + "' "
                                                                                        + "AND SOL.fecha_sol >= (SELECT fecha "
                                                                                                                + "FROM uge.fechas_sige "
                                                                                                                + "WHERE id_fecha='3')) "
                                                + "INNER JOIN uge.requerimientos_prac R ON  R.id_oferta = O.id_oferta "
                                                                                            + "AND R.id_oferta " + (TipoOferPracEst.equals("aplicado")?"":"NOT ") + "IN ( SELECT id_oferta "
                                                                                                                    + "FROM uge.aplicaciones_prac "
                                                                                                                    + "WHERE id_documento='" + idest + "') "
                                                                                            + "AND R.programa_requerido = ( SELECT nom_prog "
                                                                                                                            + "FROM registro.programas "
                                                                                                                            + "WHERE    tip_prog = '1' "
                                                                                                                                        + "AND id_dpto = '" + iddpto + "' and id_prog<>'285') "
                                                + "INNER JOIN uge.empresa_egre E ON E.id_empresa = O.id_empresa "
                                            + "WHERE    O.horario_oferta = '" + (TipoOferPracEst2.equals("TIEMPO COMPLETO")?"Tiempo Completo":"Medio Tiempo") + "' "
                                                        + "AND O.estado = 'a' "
                                                        + "AND R.estado = 'b' "
                                                        + "AND O.fecha_publicacion >= ( SELECT fecha "
                                                                                        + "FROM uge.fechas_sige "
                                                                                        + "WHERE id_fecha='3')");
        
        ArrayList list = new ArrayList();
        for (HashMap row : resultado) {
            

            /*
             * Los siguientes eran utilizados para las excepciones de estudiantes sobre las ofertas.
             * Ya no se utiliza más sobre el código, se debe utilizar la tabla uge.oferta_especifica_prac
             * 
             * SEMESTRE 2014-2
             *
            //Oferta específica de estudiante ANDRÉS FELIPE RODRÍGUEZ CHACÓN
            if (((String) row.get("id_oferta")).equals("4468") && !idest.equals("2082809")) continue;
            //Oferta específica de estudiante JURIS ZAPATA JUAN SEBASTIAN
            if (((String) row.get("id_oferta")).equals("4501") && !idest.equals("2083309")) continue;
            //Oferta específica de estudiante TELLEZ FARIAS CRISTIAN RAMIRO
            if (((String) row.get("id_oferta")).equals("4503") && !idest.equals("2083062")) continue;
            //Oferta específica de estudiante DELGADO COLLAZOS ANDREA PATRICIA
            if (((String) row.get("id_oferta")).equals("4513") && !idest.equals("2082559")) continue;
            //Oferta específica de estudiante TORRES ECHEVERRI VIVIAN ANDREA
            //if (((String) row.get("id_oferta")).equals("4516") && !idest.equals("2091207")) continue;
            //Oferta específica de estudiante JARA VELANDIA ADRIANA KATHERINE
            if (((String) row.get("id_oferta")).equals("4519") && !idest.equals("2080138")) continue;
            //Oferta específica de estudiante LOPEZ JIMENEZ CAMILO ANDRES
            if (((String) row.get("id_oferta")).equals("4522") && !idest.equals("2080901")) continue;
            //Oferta específica de estudiante FRANCO SANCHEZ DIANA CAROLINA
            if (((String) row.get("id_oferta")).equals("4524") && !idest.equals("2083181")) continue;
            //Oferta específica de estudiante CORREDOR ACOSTA MANUEL ALEJANDRO y ORTIZ VELASCO DAVID EDUARDO
            if (((String) row.get("id_oferta")).equals("4528") && !idest.equals("2083362") && !idest.equals("2081122")) continue;
            //Oferta específica de estudiante HERNANDEZ GUZMAN DIEGO FERNANDO
            if (((String) row.get("id_oferta")).equals("4549") && !idest.equals("2083319")) continue;
            //Oferta específica de estudiante RODRIGUEZ CAMACHO MIGUEL ALEXANDER
            if (((String) row.get("id_oferta")).equals("4550") && !idest.equals("2081565")) continue;
            //Oferta específica de estudiante HERNANDEZ FONTECHA CARLOS ANDRES
            if (((String) row.get("id_oferta")).equals("4554") && !idest.equals("2088981")) continue;
            //Oferta específica de estudiante ORTIZ TINOCO JESSICA LORENA y RODRIGUEZ LOPEZ ANA MARIA
            if (((String) row.get("id_oferta")).equals("4555") && !idest.equals("2075500") && !idest.equals("2072928")) continue;
            //Oferta específica de estudiante CASTELLANOS CASTILLO ANA MARIA
            if (((String) row.get("id_oferta")).equals("4562") && !idest.equals("2075199")) continue;
            //Oferta específica de estudiante CARDENAS VELANDIA ROSMY LISSED
            if (((String) row.get("id_oferta")).equals("4489") && !idest.equals("2087770")) continue;
            //Oferta específica de estudiante HENAO HERNANDEZ LINDA ESTEFANY
            if (((String) row.get("id_oferta")).equals("4572") && !idest.equals("2078706")) continue;
            //Oferta específica de estudiante DIAZ ORTIZ JESSICA CATHERIN
            if (((String) row.get("id_oferta")).equals("4579") && !idest.equals("2084396")) continue;
            //Oferta específica de estudiante SANCHEZ GARCIA JUAN DAVID
            if (((String) row.get("id_oferta")).equals("4585") && !idest.equals("2082708")) continue;
            //Oferta específica de estudiante ACHURY PLAZA YESICA ANDREA
            if (((String) row.get("id_oferta")).equals("4587") && !idest.equals("2084101")) continue;
            //Oferta específica de estudiante CONTRERAS LOPEZ NATALIA ALEJANDRA
            if (((String) row.get("id_oferta")).equals("4588") && !idest.equals("2083158")) continue;
            //Oferta específica de estudiante GARZON ROBAYO NICOLE STEPHANEA
            if (((String) row.get("id_oferta")).equals("4589") && !idest.equals("2084468")) continue;
            //Oferta específica de estudiante GARCIA CASTAÑO YESSICA LORENA
            if (((String) row.get("id_oferta")).equals("4590") && !idest.equals("2079810")) continue;
            //Oferta específica de estudiante CAROPRESE PEREZ ANDREA ITALINA
            if (((String) row.get("id_oferta")).equals("4591") && !idest.equals("2083768")) continue;
            //Oferta específica de estudiante ANGULO LOPEZ CARLOS JERSON
            if (((String) row.get("id_oferta")).equals("4596") && !idest.equals("2084917")) continue;
            //Oferta específica de estudiante RIAÑO SANCHEZ JULIO ANDRES
            if (((String) row.get("id_oferta")).equals("4598") && !idest.equals("2079164")) continue;
            //Oferta específica de estudiante RODRIGUEZ LIEVANO NATALIA
            if (((String) row.get("id_oferta")).equals("4606") && !idest.equals("2079914")) continue;
            //Oferta específica de estudiante MORENO GARCIA LIZETH YOJANA
            if (((String) row.get("id_oferta")).equals("4611") && !idest.equals("2082907")) continue;
            //Oferta específica de estudiante GOMEZ TAMAYO LAURA LORENA
            if (((String) row.get("id_oferta")).equals("4617") && !idest.equals("2087660")) continue;
            //Oferta específica de estudiante RUBIO FORERO NICOLAS
            if (((String) row.get("id_oferta")).equals("4618") && !idest.equals("2083075")) continue;
            //Oferta específica de estudiante HERRERA CORREA LAURA CATALINA
            if (((String) row.get("id_oferta")).equals("4619") && !idest.equals("2083853")) continue;
            //Oferta específica de estudiante SEGURA HERRERA PAULA ANDREA
            if (((String) row.get("id_oferta")).equals("4620") && !idest.equals("2082765")) continue;
            //Oferta específica de estudiante MORALES GALEANO DIANA CAROLINA
            if (((String) row.get("id_oferta")).equals("4625") && !idest.equals("2084346")) continue;
            //Oferta específica de estudiante PARRA GARCES DIEGO ALEXANDER
            if (((String) row.get("id_oferta")).equals("4626") && !idest.equals("2080696")) continue;
            //Oferta específica de estudiante MEDINA SANDOVAL GERALDINE NATALIA
            if (((String) row.get("id_oferta")).equals("4627") && !idest.equals("2085611")) continue;
            //Oferta específica de estudiante DIAZ ORTIZ JESSICA CATHERIN y GARCIA CASTAÑO YESSICA LORENA
            if (((String) row.get("id_oferta")).equals("4633") && !idest.equals("2084396") && !idest.equals("2079810")) continue;
            //Oferta específica de estudiante AVILA PRIETO GABRIELA y MORENO RUIZ JULIAN DAVID 
            //if (((String) row.get("id_oferta")).equals("4637") && !idest.equals("2084766") && !idest.equals("2077185")) continue;
            //Oferta específica de estudiante CARREÑO CAMARGO ELIANA MARCELA
            if (((String) row.get("id_oferta")).equals("4640") && !idest.equals("2084494")) continue;
            //Oferta específica de estudiante ROJAS POVEDA YESID
            if (((String) row.get("id_oferta")).equals("4645") && !idest.equals("2082551")) continue;
            //Oferta específica de estudiante CABALLERO ACEVEDO ANDRES FELIPE
            if (((String) row.get("id_oferta")).equals("4651") && !idest.equals("2084304")) continue;
            //Oferta específica de estudiante PARRA RAMIREZ FABER ALI
            if (((String) row.get("id_oferta")).equals("4662") && !idest.equals("3075224")) continue;
            
             * SEMESTRE 2015-1
             * 
            //Oferta específica de estudiante LEDESMA ORTEGA GLORIA ALEJANDRA
            /*if (((String) row.get("id_oferta")).equals("4719") && !idest.equals("2085588")) continue;
            //Oferta específica de estudiante MARTINEZ MARTINEZ ANDRES FABIAN
            if (((String) row.get("id_oferta")).equals("4724") && !idest.equals("2078788")) continue;
            //Oferta específica de estudiante TORRES LOPEZ LAURA PAOLA
            if (((String) row.get("id_oferta")).equals("4729") && !idest.equals("2083364")) continue;
            */

            HashMap[] temp = bDatos.getRegistros(   "SELECT  id_oferta, " +
                                                            "id_est " + 
                                                    "FROM uge.oferta_especifica_prac " +
                                                    "WHERE   id_oferta = '" + row.get("id_oferta").toString() + "'");
            
            
            HashMap cedula_map = bDatos.getRegistro("select NATIONAL_ID from uge.ps_ec_ib_intp_vw where EMPLID='"+idest+"'");
            String cedula="";
            if(!cedula_map.isEmpty()){
                cedula= (String) cedula_map.get("NATIONAL_ID");
            }
            
            boolean ofespMatch = false;
            for (HashMap ofesp : temp) {
                if (ofesp.get("id_est").equals(cedula)) ofespMatch = true;
            }
            
            
            
            if (temp.length > 0 && !ofespMatch) continue;
            
            list.add(row);
        }
            
        resultado = new HashMap[list.size()];
        resultado = (HashMap[]) list.toArray(resultado);
        
        return resultado;
    }

     
    @Override
    public HashMap getDatosEmpPracEst(String id_emp) throws Exception {
  return bDatos.getRegistro("select razon_social, dir_empresa, web_empresa, nom_contacto, tel_contacto, email_contacto "
          + "from uge.empresa_egre where id_empresa='"+ id_emp+"'");
}
    @Override
    public HashMap getDatosOferPracEst(String id_ofer) throws Exception{
 return bDatos.getRegistro("select cargo, descripcion, requisitos, pais_oferta, ciudad_oferta, area_oferta, salario_oferta, "
         + "CONVERT(VARCHAR(10), fecha_publicacion, 103) fecha_publicacion, CONVERT(VARCHAR(10), fecha_limite, 103) fecha_limite, CONVERT(VARCHAR(10), fecha_in, 103) fecha_in, CONVERT(VARCHAR(10), fecha_out, 103) fecha_out, horario_oferta, tipo_contrato, seguro_arp, nom_jefe, cargo_jefe, "
         + "tel_jefe, email_jefe from uge.ofertas_prac where id_oferta='"+id_ofer+"'");
}
    @Override
    public HashMap estadoAplicacionPracEst(String idofer, String idest) throws Exception {
        return bDatos.getRegistro("select id_aplicacion, estado_apli from uge.aplicaciones_prac where id_oferta='" + idofer + "' and id_documento='" + idest + "'");
    }

    @Override
    public int ApliSolicitudPrac(String idofer,String idest) throws Exception{
     HashMap dato;
     HashMap sol;
        String id_apli,id_sol;

        dato = bDatos.getRegistro("select max(id_aplicacion) + 1 id from uge.aplicaciones_prac");
        sol= bDatos.getRegistro("select max(id_sol) id_sol from uge.solicitud_prac where id_documento='"+idest+"'");
        id_apli = (String) dato.get("id");
        id_sol = (String) sol.get("id_sol");
        return bDatos.actualizar("insert into uge.aplicaciones_prac "
             + "(id_aplicacion, id_oferta, id_documento,estado_apli,fecha_apli, id_sol)"
             + "values ("
             + "'" + id_apli + "'," + "'"+idofer+"'" + ",'" + idest + "'," + "'a',getdate(),'"+id_sol+"'"
             +")");
}
    @Override
    public HashMap mensajeEstApliPrac(String est) throws Exception{
    return bDatos.getRegistro("select men_usr from uge.estados_apli_ofer where estado_apli='"+est+"'");

}
    @Override
    public HashMap getDatosEstEsp(String id_est, String prog_mov) throws Exception{
      return bDatos.getRegistro("select id_est from uge.est_esp_mov where id_est='"+id_est+"' and prog_mov='"+prog_mov+"'");
}

    @Override
    public HashMap veriSoliPrac(String empl_id) throws Exception {
        
       
        return bDatos.getRegistro("select id_sol, id_documento, razon, jornada, observaciones, expectativas, electivas, estado, fecha_sol, disponibilidad, asig_conjunta, sol_serv_ps, fecha_aprob from uge.solicitud_prac where id_sol = (select max(id_sol) from uge.solicitud_prac where id_documento='"+empl_id+"' group by id_documento)");
        
        
    }

    @Override
    public HashMap getEmplId(String usuario) throws Exception {
        HashMap res=new HashMap();
        HashMap[] datos=bDatosMim.getRegistrosMIM("select PEOPLE_ID from Estados.dbo.CONSULTA_PEOPLESOFT where USERNAME ='"+usuario+"' and PEOPLE_ID is not null and ESTADO='Activo'");
        if(datos.length>0){
            res=datos[0];
        }
        return res;
    }
    
    @Override
    public HashMap getEmplIdCel(String cedula) throws Exception {
        HashMap res=new HashMap();
        HashMap[] datos=bDatosMim.getRegistrosMIM("select PEOPLE_ID from Estados.dbo.CONSULTA_PEOPLESOFT where CEDULA ='"+cedula+"' and PEOPLE_ID is not null and ESTADO='Activo'");
        if(datos.length>0){
            res=datos[0];
        }
        return res;
    }
    
    @Override
    public HashMap getUser(String empl_id) throws Exception {
        HashMap res=new HashMap();
        HashMap[] datos=bDatosMim.getRegistrosMIM("select USERNAME, CEDULA from Estados.dbo.CONSULTA_PEOPLESOFT where PEOPLE_ID ='"+empl_id+"' and PEOPLE_ID is not null and ESTADO='Activo'");
        if(datos.length>0){
            res=datos[0];
        }
        return res;
    }

    @Override
    public Boolean getPersona(String empl_id, String username, String rolename, HashMap datos_persona) throws Exception {
        HashMap res= datos_persona;
        /**Ya no se consulta ORACLE
        HashMap[] datos= bDatosOracle.getRegistrosOracle("select EMPLID, EFFDT, EFF_STATUS, NAME_TYPE, FIRST_NAME, MIDDLE_NAME, LAST_NAME, SECOND_LAST_NAME, BIRTHDATE, BIRTHPLACE, BIRTHCOUNTRY, BIRTHSTATE, CAMPUS_ID, MAR_STATUS, MAR_STATUS_DT, SEX, COUNTRY, NATIONAL_ID_TYPE, NATIONAL_ID, LC_STATE3, CITY_AC, PRIMARY_NID, ADDRESS_TYPE, COUNTRY2, ADDRESS1, ADDRESS2, CITY, STATE, LC_ESTRATO_SOCIAL, COUNTY, BLOOD_TYPE, PHONE_TYPE, PHONE, EXTENSION, COUNTRY_CODE, PREF_PHONE_FLAG, E_ADDR_TYPE, EMAIL_ADDR, PREF_EMAIL_FLAG, OPRID_APPROVED_BY, OPRID, INSTITUTION, ACAD_ORG, INSTR_TYPE, ACAD_CAREER, STRM, ACAD_PROG, ROLENAME, ADM_RECR_CTR, PROG_ACTION, STDNT_CAR_NBR, CAMPUS, ADMIT_TERM, EFFDT_ADDR, PROG_STATUS, TEMPLATE_ID, TEMPLATE_STATUS, ALTER_EMPLID, OPERPSWD from ps_ec_ib_intp_vw where emplid ='"+empl_id+"' and ROLENAME='"+rolename+"'");
        if(datos.length>0){
            res=datos[0];
        }
        * */
        
        
        //Se actualiza de carne a emplid
        this.updateCarnetPorEmplid(empl_id, res.get("NATIONAL_ID").toString());
        //Se borra la persona de los datos locales
        try{
            this.delPersonaLocal(empl_id);
        }catch(ConsultaException e){
            System.out.println("No tuvo que eliminar");
        }

        //Se inserta el usuario en la respuesta
        res.put("[USER]", username);

        String campos = "insert into uge.ps_ec_ib_intp_vw (";
        String valores = " values(";
        for (Object dato : res.keySet()) {
            campos = campos+ ""+dato.toString()+", ";
            if(res.get(dato)==null){
                valores = valores+ ""+res.get(dato)+", ";
            }else{
                valores = valores+ "'"+res.get(dato).toString().replace("'", "")+"', ";
            }
        }

        if (campos.endsWith(", ")) {
            campos = campos.substring(0, campos.length() - 2);
        }   
        if (valores.endsWith(", ")) {
            valores = valores.substring(0, valores.length() - 2);
        }   

        campos=campos+")";
        valores=valores+")";

        String consulta = campos+valores;
        
        return this.insertPersonaLocal(consulta);
    }
    
    @Override
    public Boolean updateCarnetPorEmplid(String empl_id, String cedula) throws Exception {
        Boolean ans=false;

        HashMap respuesta=bDatos.getRegistro("select id_documento from uge.datos_egre where documento='"+cedula+"'");
        if(!respuesta.isEmpty()){
            String id_anterior=respuesta.get("id_documento").toString();
            ans=bDatos.actualizarConCeroFilas("update uge.datos_egre set id_documento='"+empl_id+"' where documento='"+cedula+"'")>=1;
            ans=bDatos.actualizarConCeroFilas("update uge.aplicaciones_egre set id_documento='"+empl_id+"' where id_documento='"+id_anterior+"'")>=1;
            ans=bDatos.actualizarConCeroFilas("update uge.clasificado_egre set id_documento='"+empl_id+"' where id_documento='"+id_anterior+"'")>=1;
            ans=bDatos.actualizarConCeroFilas("update uge.distinciones_sige set id_documento='"+empl_id+"' where id_documento='"+id_anterior+"'")>=1;
            ans=bDatos.actualizarConCeroFilas("update uge.afiliaciones_sige set id_documento='"+empl_id+"' where id_documento='"+id_anterior+"'")>=1;
            ans=bDatos.actualizarConCeroFilas("update uge.estudios_sige set id_documento='"+empl_id+"' where id_documento='"+id_anterior+"'")>=1;
            ans=bDatos.actualizarConCeroFilas("update uge.idiomas_sige set id_documento='"+empl_id+"' where id_documento='"+id_anterior+"'")>=1;
            ans=bDatos.actualizarConCeroFilas("update uge.explaboral_egre set id_documento='"+empl_id+"' where id_documento='"+id_anterior+"'")>=1;
        }
        return ans;
    }
    
    @Override
    public int ActDatosEgreDesdeCampus(String docegre) throws Exception {
        
        HashMap graduado= bDatos.getRegistro("select NATIONAL_ID documento, ADDRESS1 direccion, PHONE telefono, COUNTRY2 pais, CITY_AC ciudad, EMAIL_ADDR email, BIRTHDATE fecha_nacimiento from uge.ps_ec_ib_intp_vw where EMPLID='"+docegre+"'");
        
        return bDatos.actualizarConCeroFilas("update uge.datos_egre set dir_residencia='"+graduado.get("direccion")+"', cel='"+graduado.get("telefono")+"', pais_residencia='"+graduado.get("pais")+"', ciudad_residencia='"+graduado.get("ciudad")+"', email='"+graduado.get("email")+"', fecha_nacimiento='"+graduado.get("fecha_nacimiento")+"' where id_documento='"+docegre+"'");
    }

    @Override
    public void delPersonaLocal(String empl_id) throws Exception {
        bDatos.actualizar("delete from uge.ps_ec_ib_intp_vw where emplid ='"+empl_id+"'");
    }

    @Override
    public Boolean insertPersonaLocal(String consulta) throws Exception {
        return bDatos.actualizar(consulta)==1;
    }

    @Override
    public String homologaPrograma(String prog_acad) throws Exception {
        if(prog_acad==null){
            prog_acad="";
        }
        prog_acad=prog_acad.trim();
        Object desc=bDatos.getRegistro("select DESCRIPCION from uge.homol_progs_campus where (ID_DPTO='"+prog_acad+"' OR ACAD_PROG='"+prog_acad+"') and TIP_PROG='PRE'").get("DESCRIPCION");
        return (desc==null)?"No Homologado":desc.toString();
    }

    @Override
    public String getIdDpto(String nom_prog) throws Exception {
        HashMap ans=bDatos.getRegistro("select distinct(ID_DPTO) as id_dpto from uge.homol_progs_campus where ACAD_PROG='"+nom_prog+"'");
        return (ans.isEmpty())?nom_prog:ans.get("id_dpto").toString();
    }

    @Override
    public String getPerVerificaPagoMatri() throws Exception{
        return (String) bDatos.getRegistro("select descripcion from uge.fechas_sige where nombre='perVeriMatri'").get("descripcion");
    }
    @Override
    public HashMap[] getProyectosPendientesEnvioCampus() throws Exception {
        return bDatos.getRegistros("select nit_empresa ,razon_social ,dir_empresa ,ciudad_empresa ,pais_empresa ,web_empresa ,email_empresa ,tel_empresa ,nom_rrhh ,tel_rrhh ,email_rrhh ,nom_contacto ,profesion_contacto ,cargo_contacto ,area_contacto ,tel_contacto ,fax_contacto ,email_contacto ,cel_contacto ,id_est ,mod_prac ,id_ps_solserv ,programa from uge.envios_pendientes_campus where enviado_campus='0'");
    }
    
    @Override
    public Integer guardaRegistroProyectoCampus(String id_est, String tip_proyecto, String id_ps_solserv, String programa, String razon_social_emp, String tip_prac, String est_envio_campus, String observacion) throws Exception{
        return bDatos.actualizar("insert into uge.envio_proyectos_campus (id_est, tip_proyecto, id_ps_solserv, programa, razon_social_emp, tip_prac, est_envio_campus, observacion) values ('"+id_est+"', '"+tip_proyecto+"', '"+id_ps_solserv+"', '"+programa+"', '"+razon_social_emp+"', '"+tip_prac+"', '"+est_envio_campus+"', '"+observacion+"')");
    }
    
    @Override
    public Boolean estPagoMatricula(String doc_est, String per_acad) throws Exception{
        return bDatos.getRegistros("select ORDEN.num_orden from Novasoft.dbo.usr_cxc_alum_matri ALUMNO, Novasoft.dbo.usr_cxc_orden_matri ORDEN where ALUMNO.docum_alumno= '"+doc_est+"' and ALUMNO.cod_alum=ORDEN.cod_alum and ORDEN.periodo='"+per_acad+"'").length>0;
    }
    
    @Override
    public Integer confirmaEnvioCampus(String id_est, String id_ps_solserv) throws Exception{
        return bDatos.actualizar("update uge.envios_pendientes_campus set enviado_campus='1' where id_est='"+id_est+"' and id_ps_solserv='"+id_ps_solserv+"'");
    }
    
    @Override
    public HashMap getDatosPracticante(String empl_id) throws Exception{
        return bDatos.getRegistro("select NATIONAL_ID cedula, CITY ciudad, COUNTRY pais, ADDRESS1 direccion from uge.ps_ec_ib_intp_vw where EMPLID='"+empl_id+"'");
    }
    
    @Override
    public HashMap getNombreProgAcadémico(String codigo_prog) throws Exception{
        return bDatos.getRegistro("select DESCRIPCION from uge.homol_progs_campus where ACAD_PROG='"+codigo_prog+"'");
    }
    
    @Override
    public Boolean getInfoEstCache(String emplid) throws Exception{
        return !bDatos.getRegistro("select EMPLID from uge.ps_ec_ib_intp_vw where EMPLID='"+emplid+"'").isEmpty();
    }
    
    
     @Override
    public int ActDocPrac(String idSolPract,String columnaBD) throws Exception{
        return  bDatos.actualizar("UPDATE uge.solicitud_prac set "
               + columnaBD + " = 'Car', Carge_" + columnaBD + " = GETDATE()"
               + " where id_sol =" + "'"+idSolPract+"'");
    }
}
