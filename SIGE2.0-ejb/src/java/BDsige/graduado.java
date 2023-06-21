/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDsige;


import java.rmi.RemoteException;
import java.util.HashMap;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

/**
 *
 * @author Luis Alberto Salas
 */
@Stateful
public class graduado extends Persona implements graduadoRemote, SessionBean {
    PersistenciaMIM bDatosMIM= new PersistenciaMIM();
    String usuario;
    private SessionContext context;
     public graduado() {
    }
    public graduado(String user) {
        this.usuario=user;
    }

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
    @Override
    public HashMap datosGeneralesGrd (String doc_grad) throws Exception {
        return bDatos.getRegistro(  "SELECT  id_documento, " +
                                            "documento, " +
                                            "ISNULL(num_ta_profesional, '') num_ta_profesional, " +
                                            "ISNULL(est_civil, '') est_civil, " +
                                            "fallecido, " +
                                            "ISNULL(CONVERT(VARCHAR(10), fecha_nacimiento, 103), '') fecha_nacimiento, " +
                                            "ISNULL(tel_indicativo, '') tel_indicativo, " +
                                            "ISNULL(tel_residencia, '') tel_residencia, " +
                                            "ISNULL(cel_indicativo, '') cel_indicativo, " +
                                            "ISNULL(cel, '') cel, " +
                                            "ISNULL(pais_residencia, '') pais_residencia, " +
                                            "ISNULL(ciudad_residencia, '') ciudad_residencia, " +
                                            "ISNULL(dir_residencia, '') dir_residencia, " +
                                            "ISNULL(email, '') email, " +
                                            "ISNULL(email2, '') email2, " +
                                            "ISNULL(social_fb, '') social_fb, " +
                                            "ISNULL(social_tw, '') social_tw, " +
                                            "ISNULL(social_insta, '') social_insta, " +
                                            "ISNULL(social_gplus, '') social_gplus, " +
                                            "ISNULL(social_linkedin, '') social_linkedin, " +
                                            "ISNULL(perfil, '') perfil, " +
                                            "ISNULL(pass, '') pass, " +
                                            "ISNULL(ultima_act, '') ultima_act, " +
                                            "ISNULL(vobopoliticadatos, '') vobopoliticadatos, " +
                                            "ISNULL(nomcortoes, '') nomcortoes "+
                                    "FROM uge.datos_egre " +
                                    "WHERE id_documento = '" + doc_grad + "'");
    }
    @Override
    public HashMap[] programaacademico (String doc_grad) throws Exception{
        /**ANTES DE CAMPUS
        return bDatos.getRegistros("select registro.programas.nom_prog, registro.estudiante.nom_est,pgrad from "
                + "registro.programas, registro.estudiante, registro.plan_estud,registro.inf_grad where "
                + "registro.inf_grad.id_est=registro.estudiante.id_est and "
                + "registro.estudiante.id_plan=registro.plan_estud.id_plan and "
                + "registro.plan_estud.id_prog = registro.programas.id_prog and doc_est= (select doc_est from registro.estudiante where id_est= '"+ doc_grad+"')");
                * */
        return bDatos.getRegistros("select (select HOMOL_PROG.DESCRIPCION from uge.homol_progs_campus HOMOL_PROG where HOMOL_PROG.ACAD_PROG=MIG_GRAD.ACAD_PROG) as nom_prog, MIG_GRAD.NOMBRE as nom_est, MIG_GRAD.FECHA_GRADO as pgrad from uge.migracion_directa_graduados MIG_GRAD where EMPLID= '"+doc_grad+"'");
    }
    @Override
    public HashMap getFechaGrado(String doc_grad) throws Exception{
     return bDatos.getRegistro("select pgrad from registro.inf_grad where id_est='"+doc_grad+"'");
    }
    @Override
    public HashMap docgrad(String usuario) throws Exception{
        HashMap[] res=bDatosMIM.getRegistrosMIM("select TOP 1 PEOPLE_ID as id_documento from Estados.dbo.CONSULTA_PEOPLESOFT where CEDULA='"+usuario+"' and PEOPLE_ID is not null and PEOPLE_ID is not null");
        HashMap ans=new HashMap();
        if(res.length>0){
            ans=res[0];
        }
        return ans;
        /**ANTES DE CAMPUS
      return bDatos.getRegistro("select id_documento from uge.datos_egre where documento ='"+usuario+"'");
      * */
    }
    @Override
     public HashMap datosClasificados(String id_clas) throws Exception{
            return bDatos.getRegistro("select * from uge.clasificado_egre where id ='"+id_clas+"' ");
     }
    
    @Override
    public int ActDatosEgre(String docegre, String num_trj, String estcivil, String fallecido, String dir_res, String tel_indicativo, String tel_res, String cel_indicativo, String cel, String pais_res, String ciudad_res, String emails, String email2, String social_fb, String social_tw, String social_insta, String social_gplus, String social_linkedin, String perfil, String nomcorto) throws Exception {
        
        String consulta = "UPDATE uge.datos_egre " +
                                    "SET num_ta_profesional = '" + num_trj + "', " +
                                        "est_civil = '" + estcivil + "', " +
                                        "fallecido = " + fallecido + ", " +
                                        "dir_residencia = '" + dir_res + "', " +
                                        "tel_indicativo = '" + tel_indicativo + "', " +
                                        "tel_residencia = '" + tel_res + "', " +
                                        "cel_indicativo = '" + cel_indicativo + "', " +
                                        "cel = '" + cel + "', " +
                                        "pais_residencia = '" + pais_res + "', " +
                                        "ciudad_residencia = '" + ciudad_res + "', " +
                                        "email = '" + emails + "', " +
                                        "email2 = '" + email2 + "', " +
                                        "social_fb = '" + social_fb + "', " +
                                        "social_tw = '" + social_tw + "', " +
                                        "social_insta = '" + social_insta + "', " +
                                        "social_gplus = '" + social_gplus + "', " +
                                        "social_linkedin = '" + social_linkedin + "', " +
                                        "perfil = '" + perfil + "', " +
                                        "ultima_act = GETDATE(), " +
                                        "nomcortoes = '"+nomcorto+"' "+    
                                    "WHERE documento = '" + docegre + "'";
        
        return bDatos.actualizar(   "UPDATE uge.datos_egre " +
                                    "SET num_ta_profesional = '" + num_trj + "', " +
                                        "est_civil = '" + estcivil + "', " +
                                        "fallecido = " + fallecido + ", " +
                                        "dir_residencia = '" + dir_res + "', " +
                                        "tel_indicativo = '" + tel_indicativo + "', " +
                                        "tel_residencia = '" + tel_res + "', " +
                                        "cel_indicativo = '" + cel_indicativo + "', " +
                                        "cel = '" + cel + "', " +
                                        "pais_residencia = '" + pais_res + "', " +
                                        "ciudad_residencia = '" + ciudad_res + "', " +
                                        "email = '" + emails + "', " +
                                        "email2 = '" + email2 + "', " +
                                        "social_fb = '" + social_fb + "', " +
                                        "social_tw = '" + social_tw + "', " +
                                        "social_insta = '" + social_insta + "', " +
                                        "social_gplus = '" + social_gplus + "', " +
                                        "social_linkedin = '" + social_linkedin + "', " +
                                        "perfil = '" + perfil + "', " +
                                        "ultima_act = GETDATE(), " +
                                        "nomcortoes = '"+nomcorto+"' "+    
                                    "WHERE documento = '" + docegre + "'");
    }
    
    @Override
    public int ActDatosEgreDesdeCampus(String docegre) throws Exception {
        
        HashMap graduado= bDatos.getRegistro("select NATIONAL_ID documento, ADDRESS1 direccion, PHONE telefono, COUNTRY pais, CITY ciudad, EMAIL_ADDR email from uge.ps_ec_ib_intp_vw where EMPLID='"+docegre+"'");
        
        return bDatos.actualizar("update uge.datos_egre set dir_residencia='"+graduado.get("direccion")+"', cel='"+graduado.get("telefono")+"', pais_residencia='"+graduado.get("pais")+"', ciudad_residencia='"+graduado.get("ciudad")+"', email='"+graduado.get("email")+"' where id_documento='"+docegre+"'");
    }
   
    @Override
    public HashMap[] getListaEstgrad(String docgrad) throws Exception {
        return bDatos.getRegistros( "SELECT  E.id_estudio, " +
                                            "E.nivel_formacion, " +
                                            "E.nom_estudio, " +
                                            "E.nom_inst, " +
                                            "ISNULL(T.nom_tipo, 'Otros') nom_tipo " +
                                    "FROM uge.estudios_sige E " +
                                        "LEFT JOIN uge.tipos_estudios_sige T ON T.ID = E.tipo_estudio " +
                                    "WHERE E.id_documento = '" + docgrad + "'");
    }
    @Override
    public HashMap[] getListaDisgrad(String docgrad) throws Exception
    {
              return bDatos.getRegistros("select id_distincion, nom_distincion, lugar_distincion, tipo_distincion"
                + " from  uge.distinciones_sige"
                + " where id_documento='"+ docgrad+"'");
    }
    @Override
    public HashMap[] getListaAfigrad(String docgrad) throws Exception{
               return bDatos.getRegistros("select id_afiliacion, nom_aso, tipo_aso, estado_afi"
                + " from  uge.afiliaciones_sige"
                + " where id_documento='"+ docgrad+"'");
    }
    @Override
    public HashMap[] getListaidiomasgrad(String docgrad) throws Exception{
        return bDatos.getRegistros("select id_idioma, nom_idioma, niv_lectura, niv_escritura ,niv_habla"
                + " from  uge.idiomas_sige"
                + " where id_documento='"+ docgrad+"'");
    }
    
    @Override
    public HashMap[] getListaExplaboralgrad(String docgrad) throws Exception {
        return bDatos.getRegistros( "SELECT  id_exp, " +
                                            "nom_empresa, " +
                                            "cargo, " +
                                            "ISNULL(estado_cargo, 'Finalizado') estado_cargo, " +
                                            "ISNULL(principal, '0') principal, " +
                                            "CASE WHEN (estado_cargo = '' OR fecha_in_cargo = CONVERT(DATETIME,'01/01/1900') OR funciones = '' OR funciones = 'NULL' OR logros = '' OR logros = 'NULL' OR fecha_in_cargo IS NULL OR funciones IS NULL OR logros IS NULL) THEN 0 ELSE 1 END AS validate " +
                                    "FROM uge.explaboral_egre " +
                                    "WHERE id_documento = '" + docgrad + "'");
    }
    
    @Override
    public boolean checkExpGrad(String docgrad, String idexp) throws Exception {
        HashMap result = bDatos.getRegistro("SELECT  COUNT(id_exp) conteo " +
                                            "FROM uge.explaboral_egre " +
                                            "WHERE   id_exp = '" + idexp + "' " +
                                                    //"AND estado_cargo = 'Actual' " +
                                                    "AND id_documento = '" + docgrad + "'");
        return (((String) result.get("conteo")).equals("0")?false:true);
    }
    
    @Override
    public HashMap getExpPrincipal(String docgrad) throws Exception {
        return bDatos.getRegistro(  "SELECT  nom_empresa, " +
                                            "cargo, " +
                                            "propia, " +
                                            "tel_emp " +
                                    "FROM uge.explaboral_egre " +
                                    "WHERE   principal = 1 " +
                                            "AND id_documento = '" + docgrad + "'");
    }
    
    @Override
    public int resetExpPrincipal(String docgrad) throws Exception {
        return bDatos.actualizar(   "UPDATE  uge.explaboral_egre " +
                                    "SET     principal = 0 " +
                                    "WHERE   id_documento = '" + docgrad + "'");
    }
    
    @Override
    public int resetExpPrincipal(String docgrad, String idexp) throws Exception {
        return bDatos.actualizar(   "UPDATE  uge.explaboral_egre " +
                                    "SET     principal = 0 " +
                                    "WHERE   id_exp = '" + idexp + "' " +
                                            "AND id_documento = '" + docgrad + "'");
    }
    
    @Override
    public int setExpPrincipal(String idexp) throws Exception {
        return bDatos.actualizar(   "UPDATE  uge.explaboral_egre " +
                                    "SET     principal = 1 " +
                                    "WHERE   id_exp = '" + idexp + "'");
    }
    
    //convert(varchar(7),fecha_in,111) as fecha_in, convert(varchar(7),fecha_out,111) as fecha_out
    @Override
    public HashMap[] getExperienciasGrad(String doc_grad) throws Exception{
       return bDatos.getRegistros(  "SELECT  nom_empresa, " +
                                            "cargo, " +
                                            "estado_cargo, " +
                                            "CONVERT(VARCHAR(7), fecha_in_cargo, 111) fecha_in_cargo, " +
                                            "CONVERT(VARCHAR(7), fecha_out_cargo, 111) fecha_out_cargo, " +
                                            "funciones, " +
                                            "logros, " +
                                            "CASE WHEN (estado_cargo = '' OR fecha_in_cargo = CONVERT(DATETIME,'01/01/1900') OR funciones = '' OR funciones = 'NULL' OR logros = '' OR logros = 'NULL' OR fecha_in_cargo IS NULL OR funciones IS NULL OR logros IS NULL) THEN 0 ELSE 1 END AS validate " +
                                    "FROM uge.explaboral_egre " +
                                    "WHERE   id_documento = '" + doc_grad + "' " +
                                    "ORDER BY fecha_in_cargo DESC");
    }
    @Override
    public HashMap getDatExperienciaGrad(String id_exp) throws Exception {
        return bDatos.getRegistro(  "SELECT  id_exp, " +
                                            "ISNULL(principal, 0) principal, " +
                                            "ISNULL(propia, 0) propia, " +
                                            "ISNULL(nom_empresa, '') nom_empresa, " +
                                            "ISNULL(cargo, '') cargo, " +
                                            "ISNULL(sector_emp, '.OTRO') sector_emp, " +
                                            "ISNULL(dir_emp, '') dir_emp, " +
                                            "ISNULL(tel_emp, '') tel_emp, " +
                                            "ISNULL(pais_emp, 'COL') pais_emp, " +
                                            "ISNULL(ciudad_emp, '') ciudad_emp, " +
                                            "ISNULL(salario, '1.000.000 y 1.500.000') salario, " +
                                            "ISNULL(estado_cargo, '') estado_cargo, " +
                                            "ISNULL(fecha_in_cargo, '1900-01-01 00:00:00.000') fecha_in_cargo, " +
                                            "ISNULL(fecha_out_cargo, '1900-01-01 00:00:00.000') fecha_out_cargo, " +
                                            "ISNULL(tipo_contrato, '') tipo_contrato, " +
                                            "ISNULL(horario, '') horario, " +
                                            "ISNULL(funciones, '') funciones," +
                                            "ISNULL(logros, '') logros, " +
                                            "id_documento, " +
                                            "ISNULL(MONTH(fecha_in_cargo), '01') mes_fecha_in, " +
                                            "ISNULL(YEAR(fecha_in_cargo), '1990') year_fecha_in, " +
                                            "ISNULL(MONTH(fecha_out_cargo), '01') mes_fecha_out, " +
                                            "ISNULL(YEAR(fecha_out_cargo), '1990') year_fecha_out, " +
                                            "CASE WHEN (estado_cargo = '' OR fecha_in_cargo = CONVERT(DATETIME,'01/01/1900') OR funciones = '' OR funciones = 'NULL' OR logros = '' OR logros = 'NULL' OR fecha_in_cargo IS NULL OR funciones IS NULL OR logros IS NULL) THEN 0 ELSE 1 END AS validate " +
                                    "FROM uge.explaboral_egre " +
                                    "WHERE   id_exp = '" + id_exp + "'");
    }
    
    @Override
    public HashMap[] getEstudiosGrad(String doc_grad) throws Exception{
       return bDatos.getRegistros("select nivel_formacion, titulo, nom_inst, "
               + "convert(varchar(7),fecha_grado,111) as fecha_grado"
               + " from uge.estudios_sige where id_documento='"+doc_grad+"' order by fecha_grado desc");
    }
    @Override
    public HashMap[] getIdiomasGrad(String doc_grad) throws Exception{
              return bDatos.getRegistros("select nom_idioma, niv_lectura, niv_escritura, "
               + "niv_habla"
               + " from uge.idiomas_sige where id_documento='"+doc_grad+"'");
    }
    
    @Override
    public HashMap[] getDistincionesGrad(String doc_grad) throws Exception {
        return bDatos.getRegistros( "SELECT  id_distincion, " +
                                            "nom_distincion, " +
                                            "lugar_distincion, " +
                                            "tipo_distincion, " +
                                            "ambito_distincion, " +
                                            "CONVERT(VARCHAR(7), fecha_distincion, 111) f_distincion, " +
                                            "id_documento " +
                                    "FROM uge.distinciones_sige " +
                                    "WHERE id_documento = '" + doc_grad + "' " +
                                    "ORDER BY fecha_distincion");
    }
    
    @Override
    public HashMap[] getAfiliacionesGrad(String doc_grad) throws Exception {
        return bDatos.getRegistros( "SELECT  id_afiliacion, " +
                                            "nom_aso, " +
                                            "tipo_aso, " +
                                            "estado_afi, " +
                                            "CONVERT(VARCHAR(7), fecha_in, 111) f_in, " +
                                            "fecha_out, " +
                                            "id_documento " +
                                    "FROM uge.afiliaciones_sige " +
                                    "WHERE id_documento = '" + doc_grad + "' " +
                                    "ORDER BY fecha_in DESC");
    }
    
    @Override
    public HashMap[] getMiscalsificados(String doc_grad) throws Exception{
            return bDatos.getRegistros("select * from uge.clasificado_egre where id_documento='"+doc_grad+"'");
    }
    @Override
    public HashMap[] getLosclasificados()throws Exception{
         return bDatos.getRegistros("select * from uge.clasificado_egre" );
    }
    @Override
    public HashMap[] getProgramas(String idoferta) throws Exception{
            return bDatos.getRegistros("select programa_requerido from uge.requerimientos_egre where id_oferta='"+idoferta+"'");

    }
    @Override
    public HashMap[] getListaofergrad(String docgrad,String tipocon) throws Exception{

            if(tipocon.equals("Toda oferta")){
               /*return bDatos.getRegistros("select o.id_oferta, o.cargo, o.salario_oferta, CONVERT(VARCHAR(10), o.fecha_publicacion, 103) fecha_publicacion, CONVERT(VARCHAR(10), o.fecha_limite, 103) fecha_limite, o.descripcion, 'Sin Aplicar' estado from uge.ofertas_egre o "
                        + "where  o.id_oferta not in(select id_oferta from uge.aplicaciones_egre where id_documento='"+docgrad+"') and o.fecha_limite >= CONVERT(DATE, GETDATE()) and estado='a' "
                        + "union"
                        + " select o.id_oferta, o.cargo, o.salario_oferta, CONVERT(VARCHAR(10), o.fecha_publicacion, 103) fecha_publicacion, CONVERT(VARCHAR(10), o.fecha_limite, 103) fecha_limite, o.descripcion, 'Aplico' estado from uge.ofertas_egre o "
                        + "where o.id_oferta in(select id_oferta from uge.aplicaciones_egre where id_documento='"+docgrad+"') and o.fecha_limite >= CONVERT(DATE, GETDATE()) and estado='a' "
                        + "ORDER BY fecha_limite DESC");*/
               return bDatos.getRegistros(  "SELECT  o.id_oferta, " +
                                                    "o.cargo, " +
                                                    "o.salario_oferta, " +
                                                    "CONVERT(VARCHAR(10), o.fecha_publicacion, 103) fecha_publicacion, " +
                                                    "CONVERT(VARCHAR(10), o.fecha_limite, 103) fecha_limite, " +
                                                    "fecha_limite flORD, " +
                                                    "o.descripcion, " +
                                                    "'Sin Aplicar' estado " +
                                            "FROM uge.ofertas_egre o " +
                                            "WHERE   o.id_oferta NOT IN  (" +
                                                                            "SELECT id_oferta " +
                                                                            "FROM uge.aplicaciones_egre " +
                                                                            "WHERE id_documento = '" + docgrad + "'" +
                                                                        ") " +
                                                    "AND o.fecha_limite >= GETDATE() " +
                                                    "AND estado = 'a' " +
                                            "UNION " +
                                            "SELECT  o.id_oferta, " +
                                                    "o.cargo, " +
                                                    "o.salario_oferta, " +
                                                    "CONVERT(VARCHAR(10), o.fecha_publicacion, 103) fecha_publicacion, " +
                                                    "CONVERT(VARCHAR(10), o.fecha_limite, 103) fecha_limite, " +
                                                    "fecha_limite flORD, " +
                                                    "o.descripcion, " +
                                                    "'Aplicó' estado " +
                                            "FROM uge.ofertas_egre o " +
                                            "WHERE   o.id_oferta IN  (" +
                                                                        "SELECT id_oferta " +
                                                                        "FROM uge.aplicaciones_egre " +
                                                                        "WHERE id_documento = '" + docgrad + "'" +
                                                                    ") " +
                                                    "AND o.fecha_limite >= GETDATE() " +
                                                    "AND estado = 'a' " +
                                            "ORDER BY flORD DESC");
            }else{
                
                      return bDatos.getRegistros("select distinct o.id_oferta, o.cargo, o.salario_oferta, CONVERT(VARCHAR(10), o.fecha_publicacion, 103) fecha_publicacion, CONVERT(VARCHAR(10), o.fecha_limite, 103) fecha_limite, fecha_limite flORD, o.descripcion, 'Aplico' estado from uge.ofertas_egre o "
                              + "inner join uge.requerimientos_egre r on r.id_oferta=o.id_oferta and r.programa_requerido="
                              + "(select registro.programas.nom_prog from registro.programas, registro.estudiante, registro.plan_estud "
                              + " where  registro.estudiante.id_plan=registro.plan_estud.id_plan and registro.plan_estud.id_prog = registro.programas.id_prog "
                              + "and id_est='"+docgrad+"') and o.fecha_limite >= CONVERT(DATE, GETDATE()) and estado='a' and o.id_oferta in(select id_oferta from uge.aplicaciones_egre where id_documento='"+docgrad+"' ) "
                              + " union "
                              + "select distinct o.id_oferta, o.cargo, o.salario_oferta, CONVERT(VARCHAR(10), o.fecha_publicacion, 103) fecha_publicacion, CONVERT(VARCHAR(10), o.fecha_limite, 103) fecha_limite, fecha_limite flORD, o.descripcion, 'Sin Aplicar' estado from uge.ofertas_egre o"
                              + " inner join uge.requerimientos_egre r on r.id_oferta=o.id_oferta and r.programa_requerido=(select registro.programas.nom_prog from registro.programas, "
                              + "registro.estudiante, registro.plan_estud where  registro.estudiante.id_plan=registro.plan_estud.id_plan and registro.plan_estud.id_prog = "
                              + "registro.programas.id_prog and id_est='"+docgrad+"') and o.fecha_limite >= CONVERT(DATE, GETDATE()) and estado='a'"
                              + "and o.id_oferta not in(select id_oferta from uge.aplicaciones_egre where id_documento='"+docgrad+"') ORDER BY flORD DESC");
                
            }           

    }
     
    @Override
    public HashMap[] getpaisesgrad() throws Exception {
        return bDatos.getRegistros("SELECT cod_iso as cod_pai, nom_pais as nom_pai FROM uge.paises ORDER BY nom_pai");
        /** ANTES DE CAMPUS
        return bDatos.getRegistros( "SELECT nom_pai " +
                                    "FROM registro.paises " +
                                    "ORDER BY nom_pai");
                                    * */
   }
    
    @Override
    public HashMap[] getciudadesgrad() throws Exception {
        return bDatos.getRegistros("SELECT pais, cod_dane, nom_ciudad as nom_ciu FROM uge.ciudades ORDER BY nom_ciu");
        /**ANTES DE CAMPUS
        return bDatos.getRegistros( "SELECT nom_ciu " +
                                    "FROM registro.ciudades " +
                                    "ORDER BY nom_ciu");
                                    * 
                                    *   */
    }
    
    @Override
    public HashMap[] getsectoresgrad()throws Exception{
      return bDatos.getRegistros("select nom_sector from uge.sectores_sige order by nom_sector");
    }
    @Override
    public int Actpassgrad(String pswantiguo,String pswnuevo,String docgrad) throws Exception{
         return bDatos.actualizar("Update uge.datos_egre set pass="+"'" + pswnuevo+ "'"+ " where id_documento='"+ docgrad+"' and pass='"+pswantiguo+"'");
    }
    @Override
    public int AceptarRegGrad(String docgrad) throws Exception{
     return bDatos.actualizar("Update uge.datos_egre set vobopoliticadatos= 'True' where id_documento='"+ docgrad+"'");
    }
    @Override
    public int newPassEgre(String docgrad) throws Exception{
        return bDatos.actualizar("Update uge.datos_egre set pass="+"'" + docgrad+ "'"+ " where documento='"+ docgrad+"'");
    }
    @Override
    public int Aplicarofergrad(String docgrad,String idofer) throws Exception{
    HashMap dato;
        String id_apli;
        dato = bDatos.getRegistro("select max(id_aplicacion) + 1 id from uge.aplicaciones_egre");
        id_apli = (String) dato.get("id");

        //
        return bDatos.actualizar("insert into uge.aplicaciones_egre"
             + "(id_aplicacion, id_oferta, id_documento,estado_apli,fecha_apli)"
             + " values ('" + id_apli + "'," + "'"+idofer+"'" + ",'" + docgrad + "'," + "'a',"+ "getdate()"+")");

}
    @Override
    public int eliminarEstgrad(String id_estudio) throws Exception{
      return bDatos.actualizar("delete from uge.estudios_sige where id_estudio ="+ id_estudio);
    }
    @Override
    public int eliminarDisgrad(String id_Dis) throws Exception{
      return bDatos.actualizar("delete from uge.distinciones_sige where id_distincion="+ id_Dis);
    }
    @Override
    public int eliminarAfigrad(String id_Afi) throws Exception{
      return bDatos.actualizar("delete from uge.afiliaciones_sige where id_afiliacion ="+ id_Afi);
    }
    @Override
    public int eliminarExpLgrad(String id_ExpL) throws Exception{
      return bDatos.actualizar("delete from uge.explaboral_egre where id_exp ="+ id_ExpL);
    }
    @Override
    public int eliminarIdiograd(String id_Idio) throws Exception{
      return bDatos.actualizar("delete from uge.idiomas_sige where id_idioma ="+ id_Idio);
    }
    @Override
    public int eliminarClasificado(String id_clas) throws Exception{
       return bDatos.actualizar("delete from uge.clasificado_egre where id="+id_clas);
    }

    @Override
     public int  Registrarestgrad(String docgrad,String NivEst,String titulo_grad,String sector_estgrad,String nom_inst,String pais_estgrad,String ciudad_estgrad,String fecha_estgrad,String prog_estgrad) throws Exception{

         HashMap dato;
        String id_estgrad;
        dato = bDatos.getRegistro("select max(id_estudio) + 1 id from uge.estudios_sige");
        id_estgrad = (String) dato.get("id");

        //
     /*   return bDatos.actualizar("insert into uge.estudios_sige "
             + "(id_estudio, nivel_formacion, titulo,"
             + " sector, nom_inst, pais_inst, ciudad_inst, fecha_grado, id_documento, nom_estudio) values ("
             + "'" + id_estgrad + "'," + "'"+NivEst+"'" + ",'" + titulo_grad + "'," + "'" + sector_estgrad+"',"+ "'" + nom_inst + "',"+"'"+ pais_estgrad + "',"+"'"+ ciudad_estgrad + "','1/"+ fecha_estgrad+ "',"+"'"+ docgrad + "',"+"'"+ prog_estgrad+"')");
     */
     
     String fecha_estgrad_formato= fecha_estgrad.split("/")[1]+"/"+fecha_estgrad.split("/")[0]+"/01";
        
     
     return bDatos.actualizar("insert into uge.estudios_sige "
             + "( nivel_formacion, titulo,"
             + " sector, nom_inst, pais_inst, ciudad_inst, fecha_grado, id_documento, nom_estudio) values ("
             +  "'"+NivEst+"'" + ",'" + titulo_grad + "'," + "'" + sector_estgrad+"',"+ "'" + nom_inst + "',"+"'"+ pais_estgrad + "',"+"'"+ ciudad_estgrad + "','"+fecha_estgrad_formato+"',"+"'"+ docgrad + "',"+"'"+ prog_estgrad+"')");
     }
    @Override
    public  int RegistrarClasificado(String Tituloclas,String Teloclas,String emailclas,String cuerpoclas,
        String docgrad) throws Exception{
        HashMap dato;
        String id_clas;
        dato = bDatos.getRegistro("select max(id)+ 1 id from uge.clasificado_egre");
        id_clas = (String) dato.get("id");
        //
        return bDatos.actualizar("insert into uge.clasificado_egre "
             + "(id, id_documento, titulo,"
             + " clasificado, estado_clas, tel_clas, email_clas) values("
             + "'" + id_clas + "'," + "'"+docgrad+"'" + ",'" + Tituloclas + "'," + "'" + cuerpoclas+"',"+ "'a','"+ Teloclas
             + "',"+"'"+ emailclas + "')");

     }
    @Override
     public int Registrardisgrad(String docgrad,String nom_disgrad,String inst_disgrad,String amb_disgrad,String Tipo_disgrad,String fecha_disgrad) throws Exception
     {
        HashMap dato;
        String id_disgrad;
        int ban;
        dato = bDatos.getRegistro("select max(id_distincion) + 1 id from uge.distinciones_sige");
        id_disgrad = (String) dato.get("id");
        
        String fecha_disgrad_formato= fecha_disgrad.split("/")[1]+"/"+fecha_disgrad.split("/")[0]+"/01";

        
        return bDatos.actualizar("insert into uge.distinciones_sige "
             + "(nom_distincion, lugar_distincion,"
             + " tipo_distincion, ambito_distincion, fecha_distincion, id_documento) values ("
             + "'"+nom_disgrad+"'" + ",'" + inst_disgrad + "'," + "'" + Tipo_disgrad +"',"+ "'" + amb_disgrad+ "','"+fecha_disgrad_formato+"',"+"'"+ docgrad +"')");
     
     }
    @Override
     public int Registrarafigrad(String docgrad,String inst_afigrad,String Tipo_afigrad,String fechaAfi,String estadoafi) throws Exception{
     HashMap dato;
        String id_afigrad;
        dato = bDatos.getRegistro("select max(id_afiliacion) + 1 id from uge.afiliaciones_sige");
        id_afigrad = (String) dato.get("id");
        
        String fecha_formato= fechaAfi.split("/")[1]+"/"+fechaAfi.split("/")[0]+"/01";
        //
        return bDatos.actualizar("insert into uge.afiliaciones_sige "
             + "(id_afiliacion, nom_aso, tipo_aso,"
             + " fecha_in, estado_afi, id_documento) values ("
             + "'" + id_afigrad + "',"+ "'" + inst_afigrad + "'," + "'"+Tipo_afigrad+"'" + ",'"+fecha_formato+"'," + "'" + estadoafi +"',"+"'"+ docgrad +"')");
     }
    @Override
     public int RegistrarIdiograd(String docgrad,String nom_idio,String nivel_lecegre,String nivel_escriegre,String nivel_hablaegre) throws Exception{
      HashMap dato;
        String id_idiograd;
        dato = bDatos.getRegistro("select max(id_idioma) + 1 id from uge.idiomas_sige");
        id_idiograd = (String) dato.get("id");
        
     return bDatos.actualizar("insert into uge.idiomas_sige "
             + "( nom_idioma, niv_lectura,"
             + " niv_escritura, niv_habla, id_documento) values ("
             +  "'" + nom_idio + "'," + "'"+nivel_lecegre+"'" + ",'" + nivel_escriegre + "'," + "'" + nivel_hablaegre +"',"+"'"+ docgrad +"')");
    
     }
    @Override
    public int RegistrarExpgrad(String docgrad,String empropia,String nom_empresaegre,String cargoegre,String sector_expgrad,
            String tel_expgrad,String dir_expgrad,String pais_expgrad,String ciudad_expgrad,String salario_expgrad,String estado_expegre,
            String fechain_expgrad,String fechaout_expgrad,String contrato_expgrad,String horario_expgrad,String fun_expgrad,
            String logros_expgrad) throws Exception{
        HashMap dato;
        String id_expgrad;
        dato = bDatos.getRegistro("select max(id_exp) + 1 id from uge.explaboral_egre");
        id_expgrad = (String) dato.get("id");
       
        String fechain_expgrad_formato= "";
         String fechaout_expgrad_formato= "";
        if(fechain_expgrad!=null&&!fechain_expgrad.equals("")){
            fechain_expgrad_formato= fechain_expgrad.split("/")[1]+"/"+fechain_expgrad.split("/")[0]+"/01";
        }
        if(fechaout_expgrad!=null&&!fechaout_expgrad.equals("")){
            fechaout_expgrad_formato= fechaout_expgrad.split("/")[1]+"/"+fechaout_expgrad.split("/")[0]+"/01";
        }
         
        
         if(fechaout_expgrad.equals("")){
            if (!salario_expgrad.equals("exp de un practicante")) bDatos.actualizar("UPDATE uge.datos_egre set ultima_act= getdate() where id_documento='"+docgrad+"'");
            
             bDatos.actualizar("insert into uge.explaboral_egre "
                + "( propia, nom_empresa, cargo,sector_emp, dir_emp, tel_emp,pais_emp,ciudad_emp,salario,"
                + " estado_cargo, fecha_in_cargo, fecha_out_cargo, tipo_contrato, horario, funciones, logros, id_documento)"
                + " values ('" + empropia + "'," + "'"+nom_empresaegre+"'" + ",'" +cargoegre + "',"
                + "'" + sector_expgrad +"',"+"'" + dir_expgrad +"',"+"'" + tel_expgrad +"','" + pais_expgrad +"',"+"'" + ciudad_expgrad +"',"
                +"'" + salario_expgrad +"',"+"'" + estado_expegre +"','"+fechain_expgrad_formato+"','01/01/1900',"
                +"'" + contrato_expgrad +"',"+"'" + horario_expgrad +"',"+"'" + fun_expgrad +"',"+"'" + logros_expgrad +"',"
                +"'"+ docgrad +"')");
            
                
         } else {
             if (!salario_expgrad.equals("exp de un practicante")) bDatos.actualizar("UPDATE uge.datos_egre set ultima_act= getdate() where id_documento='"+docgrad+"'");
             
              bDatos.actualizar("insert into uge.explaboral_egre "
                 + "( propia, nom_empresa, cargo,sector_emp, dir_emp, tel_emp,pais_emp,ciudad_emp,salario,"
                 + " estado_cargo, fecha_in_cargo, fecha_out_cargo, tipo_contrato, horario, funciones, logros, id_documento)"
                 + " values ('" + empropia + "'," + "'"+nom_empresaegre+"'" + ",'" +cargoegre + "',"
                 + "'" + sector_expgrad +"',"+"'" + dir_expgrad +"',"+"'" + tel_expgrad +"','" + pais_expgrad +"',"+"'" + ciudad_expgrad +"',"
                 +"'" + salario_expgrad +"',"+"'" + estado_expegre +"','"+fechain_expgrad_formato+"','"+fechaout_expgrad_formato+"',"
                 +"'" + contrato_expgrad +"',"+"'" + horario_expgrad +"',"+"'" + fun_expgrad +"',"+"'" + logros_expgrad +"',"
                 +"'"+ docgrad +"')");
         }
                bDatos.actualizar("Update uge.explaboral_egre set principal = 1 Where id_exp = (Select top 1 id_exp from uge.explaboral_egre where id_documento = '"+docgrad+"' AND fecha_in_cargo <= GETDATE() Order by fecha_in_cargo desc)");
         return bDatos.actualizar("Update uge.explaboral_egre set principal = 0 Where id_exp <> (Select top 1 id_exp from uge.explaboral_egre where id_documento = '"+docgrad+"' AND fecha_in_cargo <= GETDATE() Order by fecha_in_cargo desc) AND id_documento = '"+docgrad+"'");
     }
    @Override
    public int ActualizarExpgrad(String docgrad,String empropia,String nom_empresaegre,String cargoegre,String sector_expgrad,String tel_expgrad,String dir_expgrad,String 
             pais_expgrad,String ciudad_expgrad,String salario_expgrad,String estado_expegre,String fechain_expgrad,String fechaout_expgrad,String contrato_expgrad,
             String horario_expgrad,String fun_expgrad,String logros_expgrad,String id_exp) throws Exception {
        
        
        String fechain_expgrad_formato= "";
         String fechaout_expgrad_formato= "";
        if(fechain_expgrad!=null&&!fechain_expgrad.equals("")){
            fechain_expgrad_formato= fechain_expgrad.split("/")[1]+"/"+fechain_expgrad.split("/")[0]+"/01";
        }
        if(fechaout_expgrad!=null&&!fechaout_expgrad.equals("")){
            fechaout_expgrad_formato= fechaout_expgrad.split("/")[1]+"/"+fechaout_expgrad.split("/")[0]+"/01";
        }
        
        
        if (fechaout_expgrad.equals("")) {
            return bDatos.actualizar("UPDATE uge.explaboral_egre set propia='"+empropia+"',nom_empresa='"+nom_empresaegre+"',cargo='"+cargoegre+"',sector_emp='"+sector_expgrad+"', dir_emp='"+dir_expgrad
                +"', tel_emp='"+tel_expgrad+"',pais_emp='"+pais_expgrad+"',ciudad_emp='"+ciudad_expgrad+"',salario='"+salario_expgrad+"',estado_cargo='"+estado_expegre+
                "', fecha_in_cargo='"+fechain_expgrad_formato+"', fecha_out_cargo='01/01/1900', tipo_contrato='"+contrato_expgrad+"', horario='"+horario_expgrad+
                "', funciones='"+fun_expgrad+"', logros='"+logros_expgrad+"', id_documento='"+docgrad+"' where id_exp='"+id_exp+"'"+
                "UPDATE uge.datos_egre set ultima_act= getdate() where id_documento='"+docgrad+"'");
        } else {
            return bDatos.actualizar("UPDATE uge.explaboral_egre set propia='"+empropia+"',nom_empresa='"+nom_empresaegre+"',cargo='"+cargoegre+"',sector_emp='"+sector_expgrad+"', dir_emp='"+dir_expgrad
                +"', tel_emp='"+tel_expgrad+"',pais_emp='"+pais_expgrad+"',ciudad_emp='"+ciudad_expgrad+"',salario='"+salario_expgrad+"',estado_cargo='"+estado_expegre+
                "', fecha_in_cargo='"+fechain_expgrad_formato+"', fecha_out_cargo='"+fechaout_expgrad_formato+"', tipo_contrato='"+contrato_expgrad+"', horario='"+horario_expgrad+
                "', funciones='"+fun_expgrad+"', logros='"+logros_expgrad+"', id_documento='"+docgrad+"' where id_exp='"+id_exp+"'"+
                "UPDATE uge.datos_egre set ultima_act= getdate() where id_documento='"+docgrad+"'");
        }
        
    }
    @Override
     public HashMap getBanAplicacion(String doc_grad,String idoferta) throws Exception{
     
     return bDatos.getRegistro("if  exists(select id_aplicacion from uge.aplicaciones_egre where  id_oferta ='"+ idoferta
                + "'and id_documento='"+doc_grad+"')BEGIN select '1' as ban END ELSE select '0' as ban");
     }

    @Override
      public HashMap Idultimoestgrad(String docgrad) throws Exception{
           return bDatos.getRegistro("select max(id_estudio) id from uge.estudios_sige where id_documento="+docgrad);
     }
    @Override
      public HashMap IdultimoClasificado(String docgrad) throws Exception{
            return bDatos.getRegistro("select max(id) id from uge.clasificado_egre where id_documento="+docgrad);
      }
    @Override
      public HashMap Idultimadisgrad(String docgrad) throws Exception
      {
           return bDatos.getRegistro("select max(id_distincion) id from uge.distinciones_sige where id_documento="+docgrad);
      }
    @Override
      public HashMap IdultimaAfigrad(String docgrad) throws Exception{
          return bDatos.getRegistro("select max(id_afiliacion) id from uge.afiliaciones_sige where id_documento="+docgrad);
      }
    @Override
       public HashMap IdultimoIdioma(String docgrad) throws Exception{
        return bDatos.getRegistro("select max(id_idioma) id from uge.idiomas_sige where id_documento="+docgrad);
       }
    @Override
       public HashMap IdultimaExpgrad(String docgrad) throws Exception{
          return bDatos.getRegistro("select max(id_exp) id from uge.explaboral_egre where id_documento='"+docgrad+"'");
       }
    @Override
       public HashMap datosContGar(String doc_grad) throws Exception{
           return bDatos.getRegistro("select LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, tel_residencia, dir_residencia, email, cel, ciudad_residencia, perfil from uge.datos_egre, uge.ps_ec_ib_intp_vw where id_documento=EMPLID and EMPLID = '"+doc_grad+"'");
       }
    @Override
        public HashMap getDatosOferta(String idoferta) throws Exception{
           return bDatos.getRegistro("select * from uge.ofertas_egre where id_oferta='"+ idoferta+"'");
        }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String getEmplidCC(String cc) throws Exception {
        HashMap[] res=bDatosMIM.getRegistrosMIM("select PEOPLE_ID from Estados.dbo.CONSULTA_PEOPLESOFT where CEDULA='"+cc+"'");
        HashMap ans= new HashMap();
        if(res.length>0){
            ans=res[0];
        }
        return (res.length>0)?ans.get("PEOPLE_ID").toString():cc;
    }

    
    
}
