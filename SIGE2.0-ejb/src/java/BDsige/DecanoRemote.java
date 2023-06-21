/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BDsige;

import java.rmi.RemoteException;
import java.util.HashMap;
import javax.ejb.CreateException;
import javax.ejb.Remote;

/**
 *
 * @author Luis Alberto Salas
 */
@Remote
public interface DecanoRemote {

    EmpleadoRemote create() throws CreateException, RemoteException;

    void inicializar(String idDoc) throws RemoteException;

    HashMap[] getListaSolicitudes(String res, String iddpto, String progmov) throws Exception;

    HashMap[] getListaEstPlan(String res, String iddpto, String progmov) throws Exception;

    HashMap[] getListaEstcambioPlan(String res, String iddpto, String progmov) throws Exception;

    HashMap[] getListaOfertaPracDec(String iddpto, String TipoOfertaPrac) throws Exception;

    HashMap[] getListaSolPracDec(String iddpto, String TipoSolPracDec) throws Exception;
    
    HashMap[] getListaEstPracDec(String iddpto) throws Exception;

    HashMap[] getListaForPracDec(String iddpto, String TipoConsultaPracDec) throws Exception;

    HashMap[] getListaProfesores(String nombre, String Apellidos) throws Exception;

    HashMap getDatosProfSelect(String id) throws Exception;

    HashMap getDatosEmpPracDec(String id_emp) throws Exception;

    HashMap getDatosOferPracDec(String id_ofer) throws Exception;

    HashMap estadoRequerimiento(String idreq) throws Exception;

    HashMap getDatosSolPracDec(String id_sol) throws Exception;

    HashMap estadoSolPracDec(String id_sol) throws Exception;

    HashMap estadoApliPracDec(String id_apli) throws Exception;

    int ActualizarEstOferPrac(String idreq, String clave, String comentario) throws Exception;

    int ActualizarEstSolPrac(String idsol, String clave, String comentario) throws Exception;

    int FormalizarApliPrac(String id_apli, String clave, String id_prof) throws Exception;

    int ActualizarEstado(String idsolicitud, String clave) throws Exception;

    int ActualizarVoBo(String idsolicitud, String clave, String nom) throws Exception;

    public int crearcontrato(String idsolicitud) throws Exception;

    public int aceptarcambioplan(String idsolicitud) throws Exception;

    public int rechazarcambioplan(String idsolicitud) throws Exception;

    HashMap carnetEstPracDec(String idest) throws Exception;

    HashMap idSolEstPrac(String id_sol) throws Exception;
    
    public HashMap[] getTiposEstudiosPracDec()throws Exception;
    
    public HashMap[] getTiposEstudiosPracDec(String id_est) throws Exception;

    public HashMap datosContPracDec(String id_documento) throws Exception;

    public HashMap[] getExperienciasPracDec(String doc_grad) throws Exception;

    public HashMap[] getEstudiosPracDec(String doc_grad) throws Exception;

    public HashMap[] getIdiomasPracDec(String doc_grad) throws Exception;
    
    public HashMap[] getDistincionesPracDec(String doc_grad) throws Exception;
    
    public HashMap[] getAfiliacionesPracDec(String doc_grad) throws Exception;
    
    public HashMap[] getOfertasAPPrac(String doc_prac) throws Exception;

    public HashMap datosGeneralesEstPracDec(String id_est) throws Exception;

    public HashMap datosAcademicosEstPracDec(String id_est) throws Exception;

    public HashMap datospracDec(String idest) throws Exception;

    public HashMap programaacademicoEstDec(String doc_grad) throws Exception;
    
    public HashMap[] getReporteSolPDec(String id_dpto) throws Exception;
    
    public HashMap[] getReporteApliPDec(String id_dpto) throws Exception;
    
    public HashMap[] getReporteOferPDec(String id_dpto) throws Exception;
    
    public HashMap[] getReporteTutoresPDec(String id_dpto) throws Exception;
    
    public String getPerVerificaPagoMatri() throws Exception;
    
    public Boolean estPagoMatricula(String doc_est, String per_acad) throws Exception;
}
