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
public interface graduadoRemote {
     void inicializar(String idDoc) throws RemoteException;
     
     public HashMap datosGeneralesGrd (String doc_grad) throws Exception;
     public HashMap[] programaacademico (String doc_grad) throws Exception;
     public HashMap getFechaGrado(String doc_grad) throws Exception;
     public HashMap docgrad(String usuario) throws Exception;
     public HashMap datosClasificados(String id_clas) throws Exception;
     int ActDatosEgre(String docegre, String num_trj, String estcivil, String fallecido, String dir_res, String tel_indicativo, String tel_res, String cel_indicativo, String cel, String pais_res, String ciudad_res, String emails, String email2, String social_fb, String social_tw, String social_insta, String social_gplus, String social_linkedin, String perfil, String nomcorto) throws Exception;
     int ActDatosEgreDesdeCampus(String docegre) throws Exception;
     public HashMap[] getListaEstgrad(String docgrad) throws Exception;
     public HashMap[] getListaDisgrad(String docgrad) throws Exception;
     public HashMap[] getListaAfigrad(String docgrad) throws Exception;
     public HashMap[] getListaidiomasgrad(String docgrad) throws Exception;
     public HashMap[] getListaExplaboralgrad(String docgrad) throws Exception;
     public boolean checkExpGrad(String docgrad, String idexp) throws Exception;
     public HashMap getExpPrincipal(String docgrad) throws Exception;
     public int resetExpPrincipal(String docgrad) throws Exception;
     public int resetExpPrincipal(String docgrad, String idexp) throws Exception;
     public int setExpPrincipal(String idexp) throws Exception;
     public HashMap[] getExperienciasGrad(String doc_grad) throws Exception;
     public HashMap getDatExperienciaGrad(String id_exp) throws Exception;
     public HashMap[] getEstudiosGrad(String doc_grad) throws Exception;
     public HashMap[] getIdiomasGrad(String doc_grad) throws Exception;
     public HashMap[] getDistincionesGrad(String doc_grad) throws Exception;
     public HashMap[] getAfiliacionesGrad(String doc_grad) throws Exception;
     public HashMap[] getMiscalsificados(String doc_grad) throws Exception;
     public HashMap[] getLosclasificados()throws Exception;
     public HashMap[] getProgramas(String idoferta) throws Exception;
     public HashMap[] getListaofergrad(String docgrad,String tipocon) throws Exception; 
     public HashMap[] getpaisesgrad() throws Exception;
     public HashMap[] getciudadesgrad() throws Exception;
     public HashMap[]getsectoresgrad()throws Exception;
     int Actpassgrad(String pswantiguo,String pswnuevo,String docgrad) throws Exception;
     int AceptarRegGrad(String docgrad) throws Exception;
     int newPassEgre(String docgrad) throws Exception;
     int Aplicarofergrad(String docgrad,String idofer) throws Exception;
     int eliminarEstgrad(String id_estudio) throws Exception;
     int eliminarDisgrad(String id_Dis) throws Exception;
     int eliminarAfigrad(String id_Afi) throws Exception;
     int eliminarExpLgrad(String id_ExpL) throws Exception;
     int eliminarIdiograd(String id_Idio) throws Exception;
     int eliminarClasificado(String id_clas) throws Exception;
     
     int  Registrarestgrad(String docgrad,String NivEst,String titulo_grad,String sector_estgrad,String nom_inst,String pais_estgrad,String ciudad_estgrad,String fecha_estgrad,String prog_estgrad)throws Exception;
     int RegistrarClasificado(String Tituloclas,String Teloclas,String emailclas,String cuerpoclas,String docgrad) throws Exception;
     int Registrardisgrad(String docgrad,String nom_disgrad,String inst_disgrad,String amb_disgrad,String Tipo_disgrad,String fecha_disgrad)throws Exception;
     int Registrarafigrad(String docgrad,String inst_afigrad,String Tipo_afigrad,String fechaAfi,String estadoafi) throws Exception;
     int RegistrarIdiograd(String docgrad,String nom_idio,String nivel_lecegre,String nivel_escriegre,String nivel_hablaegre) throws Exception;
     int RegistrarExpgrad(String docgrad,String empropia,String nom_empresaegre,String cargoegre,String sector_expgrad,String tel_expgrad,String dir_expgrad,String 
             pais_expgrad,String ciudad_expgrad,String salario_expgrad,String estado_expegre,String fechain_expgrad,String fechaout_expgrad,String contrato_expgrad,
             String horario_expgrad,String fun_expgrad,String logros_expgrad) throws Exception;
     int ActualizarExpgrad(String docgrad,String empropia,String nom_empresaegre,String cargoegre,String sector_expgrad,String tel_expgrad,String dir_expgrad,String 
             pais_expgrad,String ciudad_expgrad,String salario_expgrad,String estado_expegre,String fechain_expgrad,String fechaout_expgrad,String contrato_expgrad,
             String horario_expgrad,String fun_expgrad,String logros_expgrad,String id_exp) throws Exception;
     public HashMap getBanAplicacion(String doc_grad,String idoferta) throws Exception;
     public HashMap Idultimoestgrad(String docgrad) throws Exception;
     public HashMap IdultimoClasificado(String docgrad) throws Exception;
     public HashMap Idultimadisgrad(String docgrad) throws Exception;
     public HashMap IdultimaAfigrad(String docgrad) throws Exception;
     public HashMap IdultimoIdioma(String docgrad) throws Exception;
     public HashMap IdultimaExpgrad(String docgrad) throws Exception;
     public HashMap datosContGar(String doc_grad) throws Exception;
     public HashMap getDatosOferta(String idoferta) throws Exception;
     public String getEmplidCC(String empl_id) throws Exception;
}
