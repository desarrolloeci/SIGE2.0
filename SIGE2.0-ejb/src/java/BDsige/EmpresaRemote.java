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
public interface EmpresaRemote {
   void inicializar(String idDoc) throws RemoteException;
   public java.lang.String getNit();
   public int eliminarContEmp(String idcont) throws Exception;
   public HashMap  getRegistroemp(String nit) throws Exception;
   int Registrarempresa(String nit,String rasocial,String paisemp,String ciudademp,String diremp,String webemp,String emailemp,
                        String telemp,String nomconte,String cargoconte,String areaconte,String porfconte,String telconte,
                        String faxconte,String emailconte,String celconte,String passemp,String nomrrhh,String telrrhh,String emailrrhh,String tipoid)throws Exception;
   public HashMap datosGeneralesemp(String usuario) throws Exception;
   public Boolean aprobarEmpresa(String nit)throws Exception;
   public HashMap consultaEmp(String nit) throws Exception;
   public HashMap datosContactoemp(String usuario) throws Exception;
   public HashMap infoContactoemp(String Contacto, String usuario) throws Exception;
   public HashMap getDatosOfertaemp(String idoferta) throws Exception;
   public HashMap getDatosOfertaempP(String idoferta) throws Exception;
   public HashMap[] getOfertaExclusivaPracEmp(String idoferta) throws Exception;
   public HashMap getDatosOfertaPracEmp(String idoferta) throws Exception;
   int  ActDatempresa(String nit,String rasocial,String paisemp,String ciudademp,String diremp,String webemp,String emailemp,
                        String telemp,String nomconte,String cargoconte,String areaconte,String porfconte,String telconte,
                        String faxconte,String emailconte,String celconte,String passemp,String nomrrhh,String telrrhh,String emailrrhh, String tipoid)throws Exception;
   int  ActDatempresaDesdeCampus(String nit,String rasocial,String paisemp,String ciudademp,String diremp,String webemp,String emailemp,
                        String telemp, String telconte,
                        String faxconte,String emailconte,String celconte,String nomrrhh,String telrrhh,String emailrrhh, String tipoid)throws Exception;
      int  ReiniciarPassEmp(String nit)throws Exception;
   int RegistrarContEmp(String nit,String rasocial,String nomconte,String cargoconte, String areaconte,
                    String porfconte,String telconte,String emailconte,String celconte, String SistemaSolicitado, String doc_cont) throws Exception;
   int Actpassemp(String pswantiguo,String pswnuevo,String idemp) throws Exception;
   int ActEstApliGrad(String estadoapligrad,String id_apli) throws Exception;
   int ActEstApliPrac(String estadoapligrad,String id_apli,String id_est) throws Exception;
   int RegofertaGrad(String nit,String cont, String nomcargonog,String descripcionnog,String Requisitosnog, String idiomReqG, String paisnog,String[] ciudadnog,
           String areanog,String salarionog,String fechaoutnog,String horarionog,String contratonog,String añosexpnog, String programas[], String vacantes, String teletrabajo,
           String discapacidad, String excepcionpub, String[] estrequeridos)throws Exception;
   public int RegOfertaPrac(String nit,String nomcargonop,String descripcionnop,String Requisitosnop,String paisnop,String ciudadnop,
           String areanop,String sectornop,String salarionop,String fechaoutnop,String fechainprac,String fechaoutprac,String horarionop,String contratonop,
           String seguros_arp,String nom_jefe,String cargo_jefe,String tel_jefe,String email_jefe,String programas[],String cont, String tiporac, Boolean permite_duplicacion)throws Exception;
   public HashMap[] getListaProgramas() throws Exception ;
   public HashMap[]getListaProgramasPregrado() throws Exception;
   public HashMap[] getFechasPracticas() throws Exception;
   public HashMap[] getFechasPracticasEmp() throws Exception;
   public HashMap []getpaises() throws Exception;
   public HashMap []getciudades() throws Exception;
   public HashMap[]getListaOferEmp(String idemp, String consulta) throws Exception;
   public HashMap[]getListaOferEmpCont(String idemp, String nitEmp, String consulta) throws Exception;
   public HashMap[]getListaOferPracEmpCont(String idemp, String nitEmp,String consulta) throws Exception;
   public HashMap[]getListaContEmp(String idemp) throws Exception;
   public HashMap[]getListaOferPracEmp(String idemp, String consulta) throws Exception;
   public HashMap[] getProgramasEmp(String idoferta) throws Exception;
   public HashMap[] getProgramasEmpP(String idoferta) throws Exception;
   public HashMap[] getProgramasPracEmp (String idoferta) throws Exception;
   public HashMap[] getAplicantesOferEmp(String idoferta) throws Exception;
   public HashMap[] getAplicantesOferEmpP(String idoferta) throws Exception;
   public HashMap[] Contactosemp(String usuario) throws Exception;
   public HashMap[] getAplicantesOferPracEmp(String idoferta) throws Exception;
   public HashMap datosContGar(String doc_grad) throws Exception;
   public HashMap[] getExperienciasGrad(String doc_grad) throws Exception;
   public HashMap[] getEstudiosGrad(String doc_grad) throws Exception;
   public HashMap[] getIdiomasGrad(String doc_grad) throws Exception;
   public HashMap[] getDistincionesGrad(String doc_grad) throws Exception;
   public HashMap[] getAfiliacionesGrad(String doc_grad) throws Exception;
   public HashMap datosContPracEmp(String id_documento) throws Exception;
   public HashMap datosCartaPrac(String id_apli) throws Exception;
   public HashMap getDatoDecEmp(String iddpto) throws Exception;
   public HashMap[] getTiposEstudiosPracEmp()throws Exception;
   public HashMap[] getTiposEstudiosPracEmp(String id_est) throws Exception;
   public HashMap[] getExperienciasPracEmp(String doc_grad) throws Exception;
   public HashMap[] getEstudiosPracEmp(String doc_grad) throws Exception;
   public HashMap[] getIdiomasPracEmp(String doc_grad) throws Exception;
   public HashMap[] getDistincionesPracEmp(String doc_grad) throws Exception;
   public HashMap[] getAfiliacionesPracEmp(String doc_grad) throws Exception;
   public HashMap EstadoActApliGradEmp(String id_apl) throws Exception;
   public HashMap EstadoActApliPracEmp(String id_apli) throws Exception;
   public HashMap DatosTutorEmp(String id_apli) throws Exception;
   public HashMap DatosSolEstEmp(String id_apli) throws Exception;
   public HashMap IdultimoContEmp(String nit) throws Exception;
   public HashMap getDatosGeneralesEmp(String id_emp) throws Exception;
   //public Boolean getOrganizacion(String nit) throws Exception;
   public Boolean existeRegistro(String consulta) throws Exception;
   public void delOrganizacionLocal(String nit) throws Exception;
   public Boolean insertOrganizacionLocal(String consulta) throws Exception;
   public HashMap getDatosRHContEmp(String nit) throws Exception;
   public HashMap[] getSectores() throws Exception;
   public HashMap[] getMunicipios() throws Exception;
   /**
    * Retorna el nit de la empresa que ofrece la oferta a la que se esta aplicando con el id_apli
    * @param id_apli id aplicacion a oferta de practica
    * @return nit de la empresa y el indicador si la empresa fue aprobada por la uge
    * @throws Exception 
    */
   public HashMap getNitOfertaApli(String id_apli) throws Exception;
   
   public HashMap getPSIDSolPrac(String empl_id) throws Exception;
   
   public HashMap getDatosOferta(String id_apli) throws Exception;
   
   public Boolean estPagoMatricula(String id_est, String per_acad) throws Exception;
   
   public String getPerVerificaPagoMatri() throws Exception;
   
   public Integer guardaRegistroProyectoCampus(String id_est, String tip_proyecto, String id_ps_solserv, String programa, String razon_social_emp, String tip_prac, String est_envio_campus, String observacion) throws Exception;
   
   public HashMap getRegistroProyectoCampus(String id_ps_solserv) throws  Exception;
   
   public Integer guardaCacheEnviosCampus(String nit_empresa, String razon_social, String dir_empresa, String ciudad_empresa, String pais_empresa, String web_empresa, String email_empresa, String tel_empresa, String nom_rrhh, String tel_rrhh, String email_rrhh, String nom_contacto, String profesion_contacto, String cargo_contacto, String area_contacto, String tel_contacto, String fax_contacto, String email_contacto, String cel_contacto, String id_est, String mod_prac, String id_ps_solserv, String programa, String tipprac, String enviado_campus) throws  Exception;
   
   public String estadoAprobaciónUGEOferta(String id_oferta) throws Exception;
}
