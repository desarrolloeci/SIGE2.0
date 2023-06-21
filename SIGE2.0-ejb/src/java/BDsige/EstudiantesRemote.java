/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDsige;


import javax.ejb.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;



/**
 *
 * @author Luis Alberto Salas
 */
@Remote
public interface EstudiantesRemote {
    
    void inicializar(String idDoc) throws RemoteException;
    public HashMap AdministradorMov() throws Exception;
    public HashMap[] getAuditoriaMov(String idsolicitud) throws Exception; 
    public HashMap datosGeneralesEst(String id_est) throws Exception;
    public HashMap[] getFechasPracticasEst() throws Exception;
    public HashMap datosGeneralesEstPrac(String id_est) throws Exception;
    public String homologaPrograma(String prog_acad) throws Exception;
    public HashMap datosAcademicosEst(String id_est) throws Exception;
    public HashMap datosAcademicosEstPrac(String id_est) throws Exception;
    public HashMap datosEntrevistasEst(String id_sol)throws Exception;
    public HashMap datosMateria(String plan) throws Exception;
    public HashMap []estadodocu( String idsolicitud) throws Exception;
    public HashMap []estadoopc( String idsolicitud) throws Exception;
    public HashMap estadoAplicante (String id_est) throws Exception;
    public HashMap estadoAplicanteprac (String id_est) throws Exception;
    public HashMap  programamov (String id_est) throws Exception;
    public HashMap IdAplicacion (String id_est) throws Exception;
    public HashMap estadoAplicacion (String idsolicitud) throws Exception;
    public HashMap mensajeestado(String idest) throws Exception;
    public HashMap estadosbienestar(String idsolicitud) throws Exception;
    public HashMap [] datosSolicitud (String idSol) throws Exception;
    public HashMap datosSolicitudGeneral (String idSol) throws Exception;
    public HashMap datosSolicitudG (String idSol) throws Exception;
    public HashMap [] datosOpcionUni (String idSol) throws Exception;
    public HashMap datosEntrevista (String idSol) throws Exception;
    public HashMap datosContrato(String idSol) throws Exception;
    int registrarmat(String matext, String mateci,String periodo, String idsol) throws Exception;
    int eliminarmat (String id_plan)throws Exception;
    int eliminarcambiomat (String id_plan)throws Exception;
    int Actualizarestadoplan (String id_sol, String clave)throws Exception;
    public int Devolverplan (String id_sol, String clave)throws Exception;
    int Actualizarestadocambioplan (String id_sol, String clave, String usr)throws Exception;
    int ActSolicitudPrac(String ProgramaSolicitado,String ExvPrac,String ElcvPrac,String idest, String asigConj) throws Exception;
    int crearSolicitud(String programa_sol, String pais_mov, String idest) throws Exception;
    int crearSolicitud_int_mov_campus(String NUM_SOL_SERV, String EMPLID, String PROM_ANT, String MAIL_ACUD, String PROM_ACUM, String SEM_EST, String OBS_PS, String ACAD_PROG, String STRM) throws Exception;
    int crearSolicitud_int_prac_campus(String NUM_SOL_SERV, String EMPLID, String ELECT_ESTD, String FECHA_SOL, String FECHA_APROB, String ACAD_PROG, String STRM) throws Exception;
    int crearSolicitudPrac(String ProgramaSolicitado,String ExvPrac,String ElcvPrac,String idest, String asigConj) throws Exception;
    int regDisponibilidadEst(String disponibilidad, String idest) throws Exception;
    int ActualizarOpcuni(String fechain, String fechaout,String id_est) throws Exception;
    int ActualizarEstOpcUni(String idsolicitud, String clave, String idopc) throws Exception;
    int ActualizarVobosSolicitud(String idsolicitud, String clave, String nomcampo,String tipo) throws Exception;
    int ActualizarVobosOpcUni (String idsolicitud, String clave, String nomcampo, String tipo)throws Exception;
    public int ActualizarEstado(String idsolicitud, String clave ) throws Exception;
    public int FinalizarProceso(String idsolicitud, String clave, String comentario ) throws Exception;
    public HashMap[] getListaEstDoc(String res, String iddpto, String progmov) throws Exception;
    public HashMap[] Listaplan( String idsol) throws Exception;
    public HashMap[] Listacambioplan(String idsol) throws Exception;
    public HashMap []getpaises() throws Exception;
    public HashMap Idultimateria(String idsol) throws Exception;
    public HashMap cometarios_sol(String id_sol) throws Exception;
    public HashMap carnetEst(String usuario) throws Exception;
    public HashMap carnetEstPrac(String usuario) throws Exception;
    public HashMap veriSoliPrac(String user_name) throws Exception;
    public HashMap getEmplId(String usuario) throws Exception;
    public HashMap getEmplIdCel(String cedula) throws Exception;
    public HashMap getUser(String empl_id) throws Exception;
    public Boolean getPersona(String empl_id, String username, String rolename, HashMap datos_persona) throws Exception;
    public Boolean updateCarnetPorEmplid(String empl_id, String cedula) throws Exception;
    int ActDatosEgreDesdeCampus(String docegre) throws Exception;
    public void delPersonaLocal(String empl_id) throws Exception;
    public Boolean insertPersonaLocal(String consulta) throws Exception;
    int guardarcmt(String id_sol, String nom_cam, String comen) throws Exception;
    int RegistrarEstEmp(String id_est, String prog_mov) throws Exception;
    int RegistrarmateriaCambio(String plan, String nuevamat, String nuevoperiodo, String motivocambio ) throws Exception;
    public HashMap[] getsectoresest()throws Exception;
    public HashMap[] getTiposEstudios()throws Exception;
    public HashMap[] getTiposEstudios(String id_est) throws Exception;
    public HashMap programaacademicoest (String id_est) throws Exception;
    public int ActDatosPrac(String tel2prac,String celprac,String email2prac,String perfilprac,String refprac,String exvprac,String id_est, String electivasprac) throws Exception;
    public HashMap datosprac(String idest) throws Exception;
    public int RegistrarestPrac(String id_documento,String prog_estprac,String titulo_prac,String sector_estprac,String nom_instprac,
        String pais_estprac,String ciudad_estprac,String fecha_estprac, String tipo_estudio) throws Exception;
    public HashMap Idultimoestprac(String docgrad) throws Exception;
    public HashMap datosContPrac(String id_documento) throws Exception;
    public HashMap[] getExperienciasPrac(String doc_grad) throws Exception;
    public HashMap[] getEstudiosPrac(String doc_grad) throws Exception;
    public HashMap[] getIdiomasPrac(String doc_grad) throws Exception;
    public HashMap[] getDistincionesPrac(String doc_grad) throws Exception;
    public HashMap[] getAfiliacionesPrac(String doc_grad) throws Exception;
    //HashMap[] getListaOfertaPracDec(String iddpto, String TipoOfertaPrac) throws Exception;
    public HashMap[] getListaOfertaPracEst(String iddpto,String idest, String TipoOferPracEst,String TipoOferPracEst2) throws Exception;
    public HashMap getDatosEmpPracEst(String id_emp) throws Exception;
    public HashMap getDatosOferPracEst(String id_ofer) throws Exception;
    public HashMap estadoAplicacionPracEst(String idofer,String idest) throws Exception;
    public int ApliSolicitudPrac(String idofer,String idest) throws Exception;
    public HashMap mensajeEstApliPrac(String est) throws Exception;
    public HashMap getDatosEstEsp(String id_est, String prog_mov) throws Exception;
    public HashMap getDatosContratado(String id_est) throws Exception;
    public String getIdDpto(String nom_prog) throws Exception;
    public String getPerVerificaPagoMatri() throws Exception;
    public HashMap[] getProyectosPendientesEnvioCampus() throws Exception;
    public Integer guardaRegistroProyectoCampus(String id_est, String tip_proyecto, String id_ps_solserv, String programa, String razon_social_emp, String tip_prac, String est_envio_campus, String observacion) throws Exception;
    public Boolean estPagoMatricula(String doc_est, String per_acad) throws Exception;
    public Integer confirmaEnvioCampus(String id_est, String id_ps_solserv) throws Exception;
    public HashMap getDatosPracticante(String empl_id) throws Exception;
    public HashMap getNombreProgAcadémico(String codigo_prog) throws Exception;
    public Boolean getInfoEstCache(String emplid) throws Exception;
      int ActDocPrac(String idSolPract,String columnaBD) throws Exception;
  
}
