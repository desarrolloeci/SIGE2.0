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
public interface AdministradoresRemote {

    void inicializar(String idDoc) throws RemoteException;

    EmpleadoRemote create() throws CreateException, RemoteException;

    HashMap[] getListaApliMov(String res, String iddpto, String progmov) throws Exception;

    HashMap[] getListaApliMov3(String res, String iddpto, String progmov) throws Exception;

    public HashMap[] getListaApliMovVice(String res, String iddpto, String progmov) throws Exception;

    public HashMap[] estadodocumentos(String idsolicitud) throws Exception;

    public int ActualizarEstadodoc(String idsolicitud, String clave) throws Exception;

    public int AprobarOfertaPrac(String id_ofer, String nomcargonop, String descripcionnop, String Requisitosnop, String paisnop, String ciudadnop,
            String areanop, String salarionop, String fechaoutnop, String fechainprac, String fechaoutprac, String horarionop, String contratonop,
            String seguros_arp, String nom_jefe, String cargo_jefe, String tel_jefe, String email_jefe) throws Exception;

    public int RechazarOfertaPracUge(String id_ofer) throws Exception;
    
    public int ObservacionOferPracUge(String id_ofer, String observaciones) throws Exception;

    public int setFechasPrac(String fechainEst, String fechaouteEst, String fechainEmp, String fechaoutEmp, String fechainSolEst, String fechaoutSolEst, String fechainDec, String fechaoutDec, String fechainPracE, String fechaoutPracE, String perVeriMatri ) throws Exception;

    HashMap[] getListaOpcuni(String res, String iddpto, String progmov) throws Exception;

    public int crearSolicitud(String programa_sol, String descripcion, String comentario) throws Exception;

    HashMap[] getLisNombreGradAdmin(String nombre, String apellido, String doc, String dpto) throws Exception;
    
    public HashMap[] getLisDocGradAdmin(String nombre, String apellido, String doc, String permisos) throws Exception;
    
    HashMap[] getLisAccesoConsulGrad (String usuario) throws Exception;
    
    HashMap[] getLisNombreGradAdmin2(String nombre, String apellido, String doc, String dpto) throws Exception;

    HashMap[] getLisNomEmpAdminG(String nombre, String nit) throws Exception;

    public int eliminarEmpAdminGrad(String nit) throws Exception;

    public int eliminarOfertaGrad(String id_ofer, String usr) throws Exception;

    public int TramitarOfertaAdminG(String id_ofer, String usr, String tip) throws Exception;
    
    public int ActualizaOferta(String id_ofer, String cargo, String desc, String requis, String idiomas, String pais, String ciudad, String area) throws Exception;

    public int ActualizaFechasOfPrac(String id_ofer, String fecini, String fecfin, String fenven) throws Exception;
    
    public int IngresaOfertaExclusiva(String id_ofer, String id_est) throws Exception;
    
    HashMap[] getListaofergradAdmin(String programagradAdmin) throws Exception;

    public HashMap[] getListaTramoferAdminG() throws Exception;

    HashMap[] getListaoferxnit(String programagradAdmin) throws Exception;

    HashMap[] getListaoferpracAdmin(String programapracAdmin) throws Exception;

    HashMap[] getListaTramitaroferprac() throws Exception;
    
    HashMap[] getSolicitudesMov() throws Exception;

    HashMap[] getListaPracAdmin(String iddpto, String TipoConsultaPracFor) throws Exception;

    HashMap[] getReporteGrad(String programa, String fechain, String fechaout, String datos[]) throws Exception;
    
    HashMap[] getReporteGradMon(String programa, String fechain, String fechaout) throws Exception;

    HashMap[] getReporteDisG(String programa, String fechain, String fechaout, String datos[]) throws Exception;

    HashMap[] getReporteAfiG(String programa, String fechain, String fechaout, String datos[]) throws Exception;

    HashMap[] getReporteIdioG(String programa, String fechain, String fechaout, String datos[]) throws Exception;

    HashMap[] getReporteEstG(String programa, String fechain, String fechaout, String datos[]) throws Exception;
    
    HashMap[] getReporteEstSolEs() throws Exception;

    HashMap[] getReporteExpG(String programa, String fechain, String fechaout, String datos[]) throws Exception;

    HashMap[] getReporteEmpG(String programa, String fechain, String fechaout, String datos[]) throws Exception;

    HashMap[] getReporteOferG(String programa, String fechain, String fechaout, String datos[]) throws Exception;

    HashMap[] getReporteApliG(String programa, String fechain, String fechaout) throws Exception;
    
    HashMap[] getReporteSolP() throws Exception;
    
    HashMap[] getReporteApliP() throws Exception;

    HashMap[] getReporteOferP() throws Exception;
    
    HashMap[] getReporteContratP() throws Exception;
    
    HashMap[] getReporteTutoresP() throws Exception;
    
    HashMap[] getReporteEmpresas() throws Exception; 
    
    HashMap[] getSolicitudesPrac() throws Exception;
    
    public HashMap[] getSolicitudesPracPendientesActInfo() throws Exception;
    
    String getPerVerificaPagoMatri() throws Exception;
    
    public HashMap[] getProyectosPendientesEnvioCampus() throws Exception;
    
    public Boolean getInfoEstCache(String emplid) throws Exception;
    
    public HashMap[] getListaEstDocPrac() throws Exception;
}
