/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDsige;


import java.rmi.RemoteException;
import java.util.HashMap;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

/**
 *
 * @author Luis Alberto Salas
 */
@Stateful
public class Decano extends Persona implements SessionBean, DecanoRemote{

   private SessionContext context;


   @Override
    public void setSessionContext(SessionContext aContext){
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
    public EmpleadoRemote create() throws CreateException, RemoteException {
        return null;
    }
   @Override
    public HashMap[] getListaSolicitudes(String res, String iddpto, String progmov) throws Exception {
         if (iddpto.equals("0"))
         {
             if(progmov.equals("0"))
             {
                 return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov"
                + " from registro.estudiante, registro.uge.solicitud_mov"
                + " where uge.solicitud_mov.id_est=registro.estudiante.id_est"
                         + " and uge.solicitud_mov.estado = 'a'"
                + " order by nom_est desc");
             }
            else
            {
                 return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov"
                + " from registro.estudiante, registro.uge.solicitud_mov"
                + " where uge.solicitud_mov.id_est=registro.estudiante.id_est and prog_mov=" + progmov
                         + " and uge.solicitud_mov.estado = 'a'"
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
                    + " and uge.solicitud_mov.estado = 'a'"
                    + " order by nom_est desc" );
             }
             else{
                   return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov"
                    + " from registro.estudiante, registro.uge.solicitud_mov"
                    + " where uge.solicitud_mov.id_est=registro.estudiante.id_est and registro.estudiante.id_dpto=" + iddpto
                    + " and prog_mov="+ progmov
                    + " and uge.solicitud_mov.estado = 'a'"
                    + " order by nom_est desc" );
                 }

         }
    }
   @Override
    public HashMap[] getListaEstPlan(String res, String iddpto, String progmov) throws Exception {
         if (iddpto.equals("0"))
         {
             if(progmov.equals("0"))
             {
                 return bDatos.getRegistros("select SOLICITUD.id_solicitud, PERSONA.FIRST_NAME+' '+PERSONA.MIDDLE_NAME+' '+PERSONA.LAST_NAME+' '+PERSONA.SECOND_LAST_NAME as nom_est, SOLICITUD.prog_mov " +
"                  from uge.ps_ec_ib_intp_vw PERSONA, registro.uge.solicitud_mov SOLICITUD " +
"                  where SOLICITUD.id_est=PERSONA.EMPLID " +
"                           and SOLICITUD.estado = 'g' " +
"                  order by nom_est desc");
             }
            else
            {
                 return bDatos.getRegistros("select SOLICITUD.id_solicitud, PERSONA.FIRST_NAME+' '+PERSONA.MIDDLE_NAME+' '+PERSONA.LAST_NAME+' '+PERSONA.SECOND_LAST_NAME as nom_est, SOLICITUD.prog_mov " +
"                  from uge.ps_ec_ib_intp_vw PERSONA, registro.uge.solicitud_mov SOLICITUD " +
"                  where SOLICITUD.id_est=PERSONA.EMPLID and SOLICITUD.prog_mov='"+progmov+"' " +
"                           and SOLICITUD.estado = 'g' " +
"                  order by nom_est desc");
            }

         }
         else
         {
             if(progmov.equals("0"))
             {
                 return bDatos.getRegistros("select SOLICITUD.id_solicitud, PERSONA.FIRST_NAME+' '+PERSONA.MIDDLE_NAME+' '+PERSONA.LAST_NAME+' '+PERSONA.SECOND_LAST_NAME as nom_est, SOLICITUD.prog_mov " +
"                  from uge.ps_ec_ib_intp_vw PERSONA, registro.uge.solicitud_mov SOLICITUD " +
"                  where SOLICITUD.id_est=PERSONA.EMPLID and SOLICITUD.acad_prog in (select PROGS.ACAD_PROG from uge.homol_progs_campus PROGS where PROGS.ID_DPTO='"+iddpto+"') " +
"                           and SOLICITUD.estado = 'g' " +
"                  order by nom_est desc" );
             }
             else{
                   return bDatos.getRegistros("select SOLICITUD.id_solicitud, PERSONA.FIRST_NAME+' '+PERSONA.MIDDLE_NAME+' '+PERSONA.LAST_NAME+' '+PERSONA.SECOND_LAST_NAME as nom_est, SOLICITUD.prog_mov " +
"                  from uge.ps_ec_ib_intp_vw PERSONA, registro.uge.solicitud_mov SOLICITUD " +
"                  where SOLICITUD.id_est=PERSONA.EMPLID and SOLICITUD.acad_prog in (select PROGS.ACAD_PROG from uge.homol_progs_campus PROGS where PROGS.ID_DPTO='"+iddpto+"') " +
"                           and SOLICITUD.estado = 'g' and SOLICITUD.prog_mov='"+progmov+"' " +
"                  order by nom_est desc" );
                 }

         }
    }
   @Override
    public HashMap[] getListaEstcambioPlan(String res, String iddpto, String progmov) throws Exception{
    if (iddpto.equals("0"))
         {
             if(progmov.equals("0"))
             {
                 return bDatos.getRegistros("select SOLICITUD.id_solicitud, PERSONA.FIRST_NAME+' '+PERSONA.MIDDLE_NAME+' '+PERSONA.LAST_NAME+' '+PERSONA.SECOND_LAST_NAME as nom_est, SOLICITUD.prog_mov " +
"                  from uge.ps_ec_ib_intp_vw PERSONA, registro.uge.solicitud_mov SOLICITUD " +
"                  where SOLICITUD.id_est=PERSONA.EMPLID " +
"                           and SOLICITUD.estado = 'j' " +
"                  order by nom_est desc");
             }
            else
            {
                 return bDatos.getRegistros("select SOLICITUD.id_solicitud, PERSONA.FIRST_NAME+' '+PERSONA.MIDDLE_NAME+' '+PERSONA.LAST_NAME+' '+PERSONA.SECOND_LAST_NAME as nom_est, SOLICITUD.prog_mov " +
"                  from uge.ps_ec_ib_intp_vw PERSONA, registro.uge.solicitud_mov SOLICITUD " +
"                  where SOLICITUD.id_est=PERSONA.EMPLID and SOLICITUD.prog_mov='"+progmov+"' " +
"                           and SOLICITUD.estado = 'j' " +
"                  order by nom_est desc");
            }

         }
         else
         {
             if(progmov.equals("0"))
             {
                 return bDatos.getRegistros("select SOLICITUD.id_solicitud, PERSONA.FIRST_NAME+' '+PERSONA.MIDDLE_NAME+' '+PERSONA.LAST_NAME+' '+PERSONA.SECOND_LAST_NAME as nom_est, SOLICITUD.prog_mov " +
"                  from uge.ps_ec_ib_intp_vw PERSONA, registro.uge.solicitud_mov SOLICITUD " +
"                  where SOLICITUD.id_est=PERSONA.EMPLID and SOLICITUD.acad_prog in (select PROGS.ACAD_PROG from uge.homol_progs_campus PROGS where PROGS.ID_DPTO='"+iddpto+"') " +
"                           and SOLICITUD.estado = 'j' " +
"                  order by nom_est desc" );
             }
             else{
                   return bDatos.getRegistros("select SOLICITUD.id_solicitud, PERSONA.FIRST_NAME+' '+PERSONA.MIDDLE_NAME+' '+PERSONA.LAST_NAME+' '+PERSONA.SECOND_LAST_NAME as nom_est, SOLICITUD.prog_mov " +
"                  from uge.ps_ec_ib_intp_vw PERSONA, registro.uge.solicitud_mov SOLICITUD " +
"                  where SOLICITUD.id_est=PERSONA.EMPLID and SOLICITUD.acad_prog in (select PROGS.ACAD_PROG from uge.homol_progs_campus PROGS where PROGS.ID_DPTO='"+iddpto+"') " +
"                           and SOLICITUD.estado = 'j' and SOLICITUD.prog_mov='"+progmov+"' " +
"                  order by nom_est desc" );
                 }

         }
    }
   @Override
     public HashMap[] getListaOfertaPracDec(String iddpto, String TipoOfertaPrac) throws Exception{

        if(TipoOfertaPrac.equals("Pendiente")){
            return bDatos.getRegistros("select id_req,uge.requerimientos_prac.id_oferta, replace(convert(varchar(max),cargo),'&','y') cargo, fecha_limite, uge.ofertas_prac.id_empresa"
                    + ", nit, replace(razon_social,'&','y') razon_social from uge.requerimientos_prac, uge.ofertas_prac, uge.empresa_egre where programa_requerido="
                    + "(select nom_prog from  registro.programas where tip_prog='1' and id_dpto='"+iddpto+"' and  id_prog <> 285) and "
                    + "uge.requerimientos_prac.id_oferta=uge.ofertas_prac.id_oferta and "
                    + "uge.ofertas_prac.id_empresa=uge.empresa_egre.id_empresa and uge.ofertas_prac.estado='a' and uge.requerimientos_prac.estado='a' and fecha_limite >= GETDATE() order by fecha_limite desc");

        }
        else{
            if(TipoOfertaPrac.equals("Aprobada")){
                return bDatos.getRegistros("select top(200) id_req,uge.requerimientos_prac.id_oferta, replace(convert(varchar(max),cargo),'&','y') cargo, fecha_limite, uge.ofertas_prac.id_empresa"
                    + ", nit, replace(razon_social,'&','y') razon_social from uge.requerimientos_prac, uge.ofertas_prac, uge.empresa_egre where programa_requerido="
                    + "(select nom_prog from  registro.programas where tip_prog='1' and id_dpto='"+iddpto+"' and  id_prog <> 285) and "
                    + "uge.requerimientos_prac.id_oferta=uge.ofertas_prac.id_oferta and "
                    + "uge.ofertas_prac.id_empresa=uge.empresa_egre.id_empresa and uge.requerimientos_prac.estado='b' order by fecha_limite desc");
            }
            else{
                    return bDatos.getRegistros("select top(200) id_req,uge.requerimientos_prac.id_oferta, replace(convert(varchar(max),cargo),'&','y') cargo, fecha_limite, uge.ofertas_prac.id_empresa"
                    + ", nit, replace(razon_social,'&','y') razon_social from uge.requerimientos_prac, uge.ofertas_prac, uge.empresa_egre where programa_requerido="
                    + "(select nom_prog from  registro.programas where tip_prog='1' and id_dpto='"+iddpto+"' and  id_prog <> 285) and "
                    + "uge.requerimientos_prac.id_oferta=uge.ofertas_prac.id_oferta and "
                    + "uge.ofertas_prac.id_empresa=uge.empresa_egre.id_empresa and uge.requerimientos_prac.estado='r' order by fecha_limite desc");

            }
        }

     }
   @Override
   public   HashMap[] getListaSolPracDec(String iddpto,String TipoSolPracDec) throws Exception{

            if(TipoSolPracDec.equals("MEDIO TIEMPO")|| TipoSolPracDec.equals("TIEMPO COMPLETO")){
                /*return bDatos.getRegistros("select id_sol,nom_est, uge.solicitud_prac.id_documento, jornada from uge.solicitud_prac, "
                        + "uge.datos_prac, registro.estudiante where uge.solicitud_prac.id_documento=uge.datos_prac.id_documento and "
                        + "uge.solicitud_prac.estado='b' and uge.datos_prac.id_est= registro.estudiante.id_est and id_dpto='"+iddpto+"'and jornada='"+TipoSolPracDec+"'");*/
                return bDatos.getRegistros( "SELECT  id_sol, " +
                                                    "nom_est, " +
                                                    "id_est id_documento, " +
                                                    "jornada " +
                                            "FROM uge.solicitud_prac SOL " +
                                                "INNER JOIN registro.estudiante E ON Cast(E.id_est as varchar) = SOL.id_documento " +
                                            "WHERE   SOL.estado = 'b' " +
                                                    "AND SOL.fecha_sol >= (  SELECT fecha " +
                                                                            "FROM uge.fechas_sige " +
                                                                            "WHERE id_fecha = '5')" +
                                                    "AND SOL.jornada = '" + TipoSolPracDec + "' " +
                                                    "AND E.id_dpto = '" + iddpto + "'");
            } else {
                 /*return bDatos.getRegistros("select id_sol,nom_est, uge.solicitud_prac.id_documento, jornada from uge.solicitud_prac, "
                        + "uge.datos_prac, registro.estudiante where uge.solicitud_prac.id_documento=uge.datos_prac.id_documento and "
                        + "uge.solicitud_prac.estado='b' and uge.datos_prac.id_est= registro.estudiante.id_est and id_dpto='"+iddpto+"'");*/
                return bDatos.getRegistros( "SELECT  id_sol, " +
                                                    "nom_est, " +
                                                    "id_est id_documento, " +
                                                    "jornada " +
                                            "FROM uge.solicitud_prac SOL " +
                                                "INNER JOIN registro.estudiante E ON Cast(E.id_est as varchar) = SOL.id_documento " +
                                            "WHERE   SOL.estado = 'b' " +
                                                    "AND SOL.fecha_sol >= (  SELECT fecha " +
                                                                            "FROM uge.fechas_sige " +
                                                                            "WHERE id_fecha = '5')" +
                                                    "AND E.id_dpto = '" + iddpto + "'");
            }

   }
   
   @Override
   public HashMap[] getListaEstPracDec(String iddpto) throws Exception{
      return bDatos.getRegistros(   "SELECT SP.id_sol IdSol, R.nom_est Nombre, EAO.men_solprac Estado "
                                    + "FROM uge.solicitud_prac SP "
                                        + "INNER JOIN registro.estudiante R ON Cast(R.id_est as varchar) = SP.id_documento "
                                        + "INNER JOIN uge.estados_apli_ofer EAO ON EAO.estado_apli = SP.estado "
                                    + "WHERE    R.id_dpto = '" + iddpto + "' "
                                                + "AND NOT (EAO.estado_apli = 'b') "
                                                + "AND SP.fecha_sol >= (   SELECT fecha "
                                                                        + "FROM uge.fechas_sige "
                                                                        + "WHERE id_fecha = 5) "
                                    + "ORDER BY R.nom_est");
   }
   
   @Override
  public  HashMap[] getListaForPracDec(String iddpto, String  TipoConsultaPracDec) throws Exception{
        if(TipoConsultaPracDec.equals("Pendiente")){
            return bDatos.getRegistros( "SELECT  AP.id_aplicacion, OP.id_empresa, E.FIRST_NAME+' '+E.MIDDLE_NAME+' '+E.LAST_NAME+' '+E.SECOND_LAST_NAME nom_est, OP.cargo, EMP.razon_social, ISNULL((select PROF.FIRST_NAME+' '+PROF.MIDDLE_NAME+' '+PROF.LAST_NAME+' '+PROF.SECOND_LAST_NAME from uge.ps_ec_ib_intp_vw PROF where PROF.EMPLID=AP.id_tutor), '-') nom_tutor FROM uge.aplicaciones_prac AP INNER JOIN uge.solicitud_prac SOL ON SOL.id_sol = AP.id_sol LEFT JOIN uge.ps_ec_ib_intp_vw E ON E.EMPLID = AP.id_documento LEFT JOIN uge.ofertas_prac OP ON OP.id_oferta = AP.id_oferta LEFT JOIN uge.empresa_egre EMP ON EMP.id_empresa = OP.id_empresa LEFT JOIN uge.ps_ec_ib_intp_vw RP ON RP.EMPLID = AP.id_tutor INNER JOIN uge.homol_progs_campus PROG ON E.ACAD_PROG=PROG.ACAD_PROG WHERE   AP.estado_apli = 'h' AND PROG.ID_DPTO like '"+iddpto+"' AND SOL.sol_serv_ps is not null AND SOL.fecha_sol >= (  SELECT fecha FROM uge.fechas_sige WHERE id_fecha = '5')");
                /*return bDatos.getRegistros("select id_aplicacion, o.id_empresa, nom_est, replace(convert(varchar(max),cargo),'&','y') cargo, razon_social from uge.aplicaciones_prac a, "
                        + "uge.ofertas_prac o, registro.estudiante e, uge.empresa_egre m "
                        + "where  a.id_oferta= o.id_oferta and id_est=id_documento and estado_apli='h' "
                        + "and o.id_empresa = m.id_empresa");*/
        } else {
            return bDatos.getRegistros( "SELECT  AP.id_aplicacion, OP.id_empresa, E.FIRST_NAME+' '+E.MIDDLE_NAME+' '+E.LAST_NAME+' '+E.SECOND_LAST_NAME nom_est, OP.cargo, EMP.razon_social, ISNULL((select PROF.FIRST_NAME+' '+PROF.MIDDLE_NAME+' '+PROF.LAST_NAME+' '+PROF.SECOND_LAST_NAME from uge.ps_ec_ib_intp_vw PROF where PROF.EMPLID=AP.id_tutor), '-') nom_tutor FROM uge.aplicaciones_prac AP INNER JOIN uge.solicitud_prac SOL ON SOL.id_sol = AP.id_sol LEFT JOIN uge.ps_ec_ib_intp_vw E ON E.EMPLID = AP.id_documento LEFT JOIN uge.ofertas_prac OP ON OP.id_oferta = AP.id_oferta LEFT JOIN uge.empresa_egre EMP ON EMP.id_empresa = OP.id_empresa LEFT JOIN uge.ps_ec_ib_intp_vw RP ON RP.EMPLID = AP.id_tutor INNER JOIN uge.homol_progs_campus PROG ON E.ACAD_PROG=PROG.ACAD_PROG WHERE   AP.estado_apli = 'j' AND PROG.ID_DPTO like '"+iddpto+"' AND SOL.sol_serv_ps is not null AND SOL.fecha_sol >= (  SELECT fecha FROM uge.fechas_sige WHERE id_fecha = '5')");
             /*return bDatos.getRegistros("select id_aplicacion, o.id_empresa, nom_est, replace(convert(varchar(max),cargo),'&','y') cargo, razon_social from uge.aplicaciones_prac a, "
                    + "uge.ofertas_prac o, registro.estudiante e, uge.empresa_egre m "
                    + "where  a.id_oferta= o.id_oferta and id_est=id_documento and estado_apli='j' "
                    + "and o.id_empresa = m.id_empresa");*/
        }
  }
   @Override
  public HashMap[] getListaProfesores(String nombre, String Apellidos) throws Exception {
      
      PersistenciaMIM bDatosMIM=new PersistenciaMIM();
       return bDatosMIM.getRegistrosMIM("select (NOMBRE+' '+APELLIDOS) nom_prof, PEOPLE_ID id_prof from Estados.dbo.CONSULTA_PEOPLESOFT where TIPO_USU='Administrativo' and NOMBRE like '%"+nombre+"%' and APELLIDOS like '%"+Apellidos+"%'");
        /*return bDatos.getRegistros("select nom_prof, id_prof from registro.profesor where nom_prof like '%"+nombre+"%' and  nom_prof like '%"+Apellidos+"%'");*/
  }
    @Override
    public HashMap getDatosProfSelect(String id) throws Exception{
            return bDatos.getRegistro("select (FIRST_NAME+' '+MIDDLE_NAME+' '+LAST_NAME+' '+SECOND_LAST_NAME) nom_prof, EMPLID id_prof from uge.ps_ec_ib_intp_vw where EMPLID ='"+id+"'");
   }
    
    @Override
    public int ActualizarEstOferPrac(String idreq, String clave, String comentario) throws Exception {
        return bDatos.actualizar(   "UPDATE uge.requerimientos_prac " +
                                    "SET estado = '" + clave + "', " +
                                        "comen_dec = '" + comentario + "' " +
                                    "WHERE id_req = '" + idreq + "'");
    }
    
   @Override
   public int ActualizarEstSolPrac(String idsol, String clave, String comentario) throws Exception{
    return bDatos.actualizar("UPDATE uge.solicitud_prac set observaciones='"+ comentario+"', estado='"+clave+"' where id_sol='"+idsol+"'");
}
   @Override
   public int FormalizarApliPrac(String id_apli, String clave, String id_prof) throws Exception{
        return bDatos.actualizar("UPDATE uge.aplicaciones_prac set id_tutor='"+id_prof+"',estado_apli='"+clave+"' "
                + "where id_aplicacion='"+id_apli+"'");
}
   @Override
    public int ActualizarEstado(String idsolicitud, String clave ) throws Exception
    {
        return bDatos.actualizar("UPDATE uge.solicitud_mov set"
                  + " estado ="
                  + "'"+clave+"'" +  "where id_solicitud =" + "'"+idsolicitud+"'");
    }

   @Override
    public int ActualizarVoBo(String idsolicitud, String clave, String nom ) throws Exception
    {
        HashMap dato;
        String id_aud;
        int ban;
        dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        
        if(clave.split(" ").length==2){
            String fecha = clave.split(" ")[0];
            String hora = clave.split(" ")[1];
            if(fecha.split("/").length==3){
                fecha=fecha.split("/")[1]+"/"+fecha.split("/")[0]+"/"+fecha.split("/")[2];
                clave=fecha+" "+hora;
            }
        }
        
        id_aud=(String) dato.get("id");
        ban= bDatos.actualizar("UPDATE uge.solicitud_mov set "
                  + nom +"=" + "'"+clave+"'" + 
                  "where id_solicitud =" + "'"+idsolicitud+"'");
        if(nom.equals("vobo_cartaeci")){
             
             ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','Se le ha cambiado el estado al visto bueno de la solicitud, el estado actual es: "+clave
                    +" la fecha del cambio es: ('+convert(varchar,getdate())+')','Decanatura con usuario: "+docId+"')");
        
        }
         if(nom.equals("vobo_plan")){
             
             ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','Se le ha cambiado el estado al plan de estudio de la solicitud, el estado actual es: "+clave
                    +" la fecha del cambio es: ('+convert(varchar,getdate())+')','Decanatura con usuario: "+docId+"')");
        
        }
         if(nom.equals("entre_vice")){
                    ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','El día ('+convert(varchar,getdate())+') se ha agendado una entrevista con el vicerrector académico para el siguiente día y hora:"+clave
                    +"','"+docId+"')");
         
         }
         if(nom.equals("exm_psico")){
         ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','El día ('+convert(varchar,getdate())+') se ha agendado una entrevista con el Psicologo  para el siguiente día y hora:"+clave
                    +"','"+docId+"')");
         }
         if(nom.equals("exm_medico")){
         ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','El día ('+convert(varchar,getdate())+') se ha agendado una entrevista con el Medico  para el siguiente día y hora:"+clave
                    +"','"+docId+"')");
         }
         if(nom.equals("vobo_vice")){
         ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','Se le ha cambiado el estado al visto del vicerrector académico, el estado actual es: "+clave
                    +" la fecha del cambio es: ('+convert(varchar,getdate())+')','"+docId+"')");
         }
         if(nom.equals("vobo_psico")){
         ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','Se le ha cambiado el estado al visto del psicologo, el estado actual es: "+clave
                    +" la fecha del cambio es: ('+convert(varchar,getdate())+')','"+docId+"')");
         
         }
         if(nom.equals("vobo_medico")){
         ban=bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','Se le ha cambiado el estado al visto del Medico, el estado actual es: "+clave
                    +" la fecha del cambio es: ('+convert(varchar,getdate())+')','"+docId+"')");
         }
          
        return ban;
    }
   @Override
   public HashMap getDatosEmpPracDec(String id_emp) throws Exception {
  return bDatos.getRegistro("select razon_social, dir_empresa, web_empresa, nom_contacto, tel_contacto, email_contacto "
          + "from uge.empresa_egre where id_empresa='"+ id_emp+"'");
}
   @Override
   public HashMap getDatosOferPracDec(String id_ofer) throws Exception{
 return bDatos.getRegistro("select replace(convert(varchar(max),cargo),'&','y') cargo, descripcion, requisitos, pais_oferta, ciudad_oferta, area_oferta, salario_oferta, "
         + "fecha_publicacion, fecha_limite, fecha_in, fecha_out, horario_oferta, tipo_contrato, seguro_arp, nom_jefe, cargo_jefe, "
         + "tel_jefe, email_jefe from uge.ofertas_prac where id_oferta='"+id_ofer+"'");
}
   @Override
   public HashMap estadoRequerimiento(String idreq) throws Exception{
    return bDatos.getRegistro("select estado, comen_dec, men_oferprac, programa_requerido, id_oferta  from uge.requerimientos_prac, uge.estados_apli_ofer where id_req='"+idreq+"' and estado_apli= estado");
}
   @Override
   public HashMap getDatosSolPracDec(String id_sol) throws Exception{
    return bDatos.getRegistro("select expectativas, electivas, asig_conjunta, observaciones,jornada from uge.solicitud_prac where id_sol='"+id_sol+"'");
}
   @Override
   public HashMap estadoSolPracDec(String id_sol) throws Exception{
    return bDatos.getRegistro("select estado, men_solprac from uge.solicitud_prac, uge.estados_apli_ofer where id_sol='"+id_sol+"' and estado_apli = estado ");
}
   @Override
   public HashMap estadoApliPracDec(String id_apli) throws Exception{
    return bDatos.getRegistro("select estado_apli from uge.aplicaciones_prac where id_aplicacion ='"+id_apli+"'");
}
   @Override
  public int crearcontrato(String idsolicitud) throws Exception{
        HashMap dato;
        String id_cont, opc1, opc2;
        int ban, ban1, ban2;


        dato = bDatos.getRegistro("select max(id_contrato) + 1 id from uge.contratos_mov");
        id_cont = (String) dato.get("id");
        ban= bDatos.actualizar("insert into uge.contratos_mov (id_contrato, id_solicitud) values( "
                + "'"+id_cont+"','"+idsolicitud+"')");
        dato = bDatos.getRegistro("select descripcion from uge.plantillacontratos_mov, uge.solicitud_mov where uge.plantillacontratos_mov.prog_mov =uge.solicitud_mov.prog_mov and id_solicitud="+idsolicitud);
        opc1=(String) dato.get("descripcion");

        ban1= bDatos.actualizar("UPDATE uge.contratos_mov set "
              + "clausula1 = '"+opc1+"'"
              +  "where id_contrato =" + "'"+id_cont+"'");
        ban2=bDatos.actualizar("UPDATE uge.contratos_mov set "
              + "clausula2 = (select clausula from uge.plantillacontratos_mov, uge.solicitud_mov where uge.plantillacontratos_mov.prog_mov =uge.solicitud_mov.prog_mov and id_solicitud="+idsolicitud+")"
              +  "where id_contrato =" + "'"+id_cont+"'");
        return bDatos.actualizar("UPDATE uge.contratos_mov set prog_mov = (select prog_mov from "
                + "uge.solicitud_mov where id_solicitud = " + idsolicitud + ") where id_contrato =" + "'" + id_cont +"'");
    }
   @Override
  public int aceptarcambioplan(String idsolicitud) throws Exception{
        HashMap dato;
        String id_opc,id_aud;
        int ban,ban2;
         dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
        dato = bDatos.getRegistro("select id_opcion from uge.opcionuni_mov where id_solicitud ='"+idsolicitud+"' and estado_opcud = 'aceptado'");
        id_opc = (String) dato.get("id_opcion");
       ban= bDatos.actualizar("update uge.planest_mov set uge.planest_mov.materia_ud=uge.cambioplan_mov.materia_ud, uge.planest_mov.semestre=uge.cambioplan_mov.semestre from "
               + "uge.cambioplan_mov   where uge.planest_mov.id_plan=uge.cambioplan_mov.id_plan and uge.planest_mov.id_opcion ='"+id_opc+"'");
       ban2= bDatos.actualizar("DELETE FROM uge.cambioplan_mov where  uge.cambioplan_mov.id_opcion ='"+id_opc+"'");
       return bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','Se ha aprobado un cambio en el plan de estudio,"
                    +" la fecha de la Aprobación es: ('+convert(varchar,getdate())+')','Decanatura con usuario: "+docId+"')");
  }
   @Override
  public int rechazarcambioplan(String idsolicitud) throws Exception{
        HashMap dato;
        String id_opc,id_aud;
        int ban;
        dato = bDatos.getRegistro("select max(id) + 1 id from uge.auditoria_mov");
        id_aud=(String) dato.get("id");
        dato = bDatos.getRegistro("select id_opcion from uge.opcionuni_mov where id_solicitud ='"+idsolicitud+"' and estado_opcud = 'aceptado'");
        id_opc = (String) dato.get("id_opcion");
        ban= bDatos.actualizar("DELETE FROM uge.cambioplan_mov where  uge.cambioplan_mov.id_opcion ='"+id_opc+"'");
        return bDatos.actualizar("insert into uge.auditoria_mov(id,id_sol,descripcion,ejecutor) "
                    + "values('"+id_aud+"','"+idsolicitud+"','Se ha rechazado un cambio en el plan de estudio,"
                    +" la fecha del rechazo es: ('+convert(varchar,getdate())+')','Decanatura con usuario: "+docId+"')");
  }
   @Override
  public HashMap carnetEstPracDec(String id_sol) throws Exception{
      return  bDatos.getRegistro("Select id_documento from uge.solicitud_prac where id_sol = '"+id_sol+"'");
  }
   @Override
  public HashMap idSolEstPrac(String idest) throws Exception{
        return  bDatos.getRegistro("select max(id_sol) id from uge.solicitud_prac where id_documento='"+idest+"'");
  }

    @Override
    public HashMap[] getTiposEstudiosPracDec()throws Exception{
        return bDatos.getRegistros( "SELECT  ID, " +
                                            "nom_tipo " +
                                    "FROM uge.tipos_estudios_sige " +
                                    "ORDER BY ID");
    }
    
    @Override
    public HashMap[] getTiposEstudiosPracDec(String id_est)throws Exception{
        return bDatos.getRegistros( "SELECT DISTINCT TE.ID, " +
                                                    "TE.nom_tipo " +
                                    "FROM uge.tipos_estudios_sige TE " +
                                        "INNER JOIN uge.estudios_sige EST ON EST.tipo_estudio = TE.ID " +
                                    "WHERE EST.id_documento = '" + id_est + "' " +
                                    "ORDER BY TE.ID");
    }
    
    @Override
    public HashMap datosContPracDec(String id_documento) throws Exception{
        return bDatos.getRegistro("select LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, PHONE as tel_corr,tel2, ADDRESS1 as dir_corr, EMAIL_ADDR as emails, email2, cel,perfil, referencias, expectativas, electivas from uge.datos_prac, uge.ps_ec_ib_intp_vw where id_documento = EMPLID and EMPLID = '"+id_documento+"'");
        /**ANTES DE CAMPUS
           return bDatos.getRegistro("select nom_est, tel_corr,tel2, dir_corr, emails,email2, cel,perfil, referencias, expectativas, "
                   + "electivas  from uge.datos_prac, registro.estudiante where id_documento = Cast(registro.estudiante.id_est as varchar) "
                   + "and registro.estudiante.id_est = '"+id_documento+"'");
                   * */
    }
    
    @Override
    public HashMap[] getExperienciasPracDec(String doc_grad) throws Exception{
       return bDatos.getRegistros("select nom_empresa, cargo, estado_cargo, "
               + "convert(varchar(7),fecha_in_cargo,111) as fecha_in_cargo, convert(varchar(7),fecha_out_cargo,111) "
               + "as fecha_out_cargo, funciones, logros from uge.explaboral_egre where id_documento='"+doc_grad+"' order by fecha_in_cargo desc");
    }
   @Override
    public HashMap[] getEstudiosPracDec(String doc_grad) throws Exception{
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
    public HashMap[] getIdiomasPracDec(String doc_grad) throws Exception{
              return bDatos.getRegistros("select nom_idioma, niv_lectura, niv_escritura, "
               + "niv_habla"
               + " from uge.idiomas_sige where id_documento='"+doc_grad+"'");
    }
   @Override
    public HashMap[] getDistincionesPracDec(String doc_grad) throws Exception{
              return bDatos.getRegistros("select * from uge.distinciones_sige where id_documento='"+doc_grad+"'");
    }
    @Override
     public HashMap[] getAfiliacionesPracDec(String doc_grad) throws Exception{
              return bDatos.getRegistros("select * from uge.afiliaciones_sige where id_documento='"+doc_grad+"'");
    }
   @Override
    public HashMap[]getOfertasAPPrac(String doc_prac) throws Exception{
            return bDatos.getRegistros("select AP.id_oferta, O.cargo,EM.razon_social,EA.men_admin,AP.id_aplicacion from uge.aplicaciones_prac AP inner join uge.ofertas_prac O on O.id_oferta= AP.id_oferta "
                    + "inner join uge.empresa_egre EM on  O.id_empresa=EM.id_empresa "
                    + "inner join uge.estados_apli_ofer EA on EA.estado_apli=AP.estado_apli "
                    + "where AP.id_documento ='"+doc_prac+"'");

    }
   @Override
     public HashMap datosGeneralesEstPracDec(String id_est) throws Exception {
         return bDatos.getRegistro("SELECT  LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est,  NATIONAL_ID as doc_est, PROG.ID_DPTO as id_dpto, ADDRESS1 as dir_corr, PHONE as tel_corr, EMAIL_ADDR as emails,   CONVERT(VARCHAR(10), BIRTHDATE, 103) fec_nac FROM uge.ps_ec_ib_intp_vw, uge.solicitud_prac SOL, uge.homol_progs_campus PROG WHERE EMPLID = '"+id_est+"' and EMPLID=SOL.id_documento and SOL.acad_prog=PROG.ACAD_PROG and id_sol=(select max(id_sol) from uge.solicitud_prac where id_documento='"+id_est+"')");
         /**ANTES DE CAMPUS
        return bDatos.getRegistro(  "SELECT  nom_est,  " +
                                            "doc_est,  " +
                                            "id_dpto,  " +
                                            "dir_corr, " +
                                            "tel_corr, " +
                                            "emails,   " +
                                            "CONVERT(VARCHAR(10), fec_nac, 103) fec_nac " +
                                    "FROM registro.estudiante " +
                                    "WHERE id_est = '" + id_est + "'");
                                    * */
        //select nom_est, doc_est,id_dpto, dir_corr, tel_corr, emails, nom_acud, dir_acud, tel_acud from registro.estudiante where id_est= 2067558
    }
   @Override
     public HashMap datosAcademicosEstPracDec(String id_est) throws Exception{
         return bDatos.getRegistro("select 30 as prom_acum, 2 as sem_est, 30 as pr_semant from uge.ps_ec_ib_intp_vw where EMPLID='"+id_est+"'");
         /**ANTES DE CAMPUS
       return bDatos.getRegistro(   "SELECT  EST.id_est, "
                                            + "CONVERT(DECIMAL(3,2),ROUND(SUM(BD.nota*BD.prom)/(SUM(BD.prom)/0.10), 3)) AS prom_acum, "
                                            + "EST.sem_est "
                                    + "FROM registro.estudiante EST "
                                        + "INNER JOIN registro.biblia_def BD ON BD.id_est = EST.id_est "
                                    + "WHERE   BD.id_est=" + id_est + " "
                                            + "AND BD.clave <> 'I' "
                                    + "GROUP BY  EST.id_est, EST.sem_est");
       
        /*return bDatos.getRegistro("select  registro.estudiante.id_est, round(sum( ( prom * nota ) ) /(sum( prom) / 0.10), 3) "
                + "as prom_acum, round(sum_ult * 0.1 / can_ult, 2) as pr_semant, sem_est from registro.estudiante, "
                + "registro.biblia_def where (registro.estudiante.id_est = registro.biblia_def.id_est) and (clave <> 'I' ) and "
                + "registro.biblia_def.id_est ='"+id_est+"' group by  registro.estudiante.id_est, sem_est");*/
    }
   @Override
     public HashMap datospracDec(String idest) throws Exception{
      return bDatos.getRegistro("select tel2, email2, cel, perfil, referencias, expectativas, estado, electivas from uge.datos_prac "
              + "where id_documento='"+idest+"'" );
   }
   @Override
     public HashMap programaacademicoEstDec (String doc_grad) throws Exception{
         return bDatos.getRegistro("select PROG.DESCRIPCION as nom_prog, PER.LAST_NAME+' '+PER.SECOND_LAST_NAME+' '+PER.FIRST_NAME+' '+PER.MIDDLE_NAME as nom_est from uge.ps_ec_ib_intp_vw PER, uge.solicitud_prac SOL, uge.homol_progs_campus PROG where EMPLID='"+doc_grad+"' and EMPLID=SOL.id_documento and SOL.acad_prog=PROG.ACAD_PROG and id_sol=(select max(id_sol) from uge.solicitud_prac where id_documento='"+doc_grad+"')");
         /**ANTES DE CAMPUS
        return bDatos.getRegistro("select registro.programas.nom_prog, registro.estudiante.nom_est from "
                + "registro.programas, registro.estudiante, registro.plan_estud where "
                + "registro.estudiante.id_plan=registro.plan_estud.id_plan and "
                + "registro.plan_estud.id_prog = registro.programas.id_prog and id_est= '"+ doc_grad+"'");
                * */
    }
    
    @Override
    public HashMap[] getReporteSolPDec(String id_dpto) throws Exception {
        return bDatos.getRegistros( "SELECT  CONVERT(VARCHAR(10), fecha_sol, 103) fec_sol, " +
                                            "'' fec_aprob, " +
                                            "E.id_est, " +
                                            "UPPER(E.nom_est) nom_est, " +
                                            "E.emails + '@mail.escuelaing.edu.co' correo, " +
                                            "ISNULL(DP.email2, '') correo2, " +
                                            "E.tel_corr tel, " +
                                            "ISNULL(DP.tel2, '') tel2, " +
                                            "ISNULL(DP.cel, '') cel, " +
                                            "UPPER(EST.men_solprac) estado, " +
                                            "SOL.observaciones comentarios " +
                                    "FROM uge.solicitud_prac SOL " +
                                        "INNER JOIN registro.estudiante E ON Cast(E.id_est as varchar) = SOL.id_documento " +
                                        "INNER JOIN registro.plan_estud PE ON PE.id_plan = E.id_plan " +
                                        "INNER JOIN registro.programas PROG ON PROG.id_prog = PE.id_prog " +
                                        "INNER JOIN uge.datos_prac DP ON DP.id_documento = SOL.id_documento " +
                                        "INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = SOL.estado " +
                                    "WHERE E.id_dpto = " + id_dpto + " " +
                                          "AND SOL.fecha_sol >= (SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 5) " +
                                    "ORDER BY fecha_sol DESC");
    }
    
    @Override
    public HashMap[] getReporteApliPDec(String id_dpto) throws Exception{
        return bDatos.getRegistros( "SELECT  EMP.id_empresa, " +
                                            "UPPER(EMP.razon_social) razon_social, " +
                                            "UPPER(OFER.cargo) cargo, " +
                                            "E.id_est, " +
                                            "UPPER(E.nom_est) nom_est, " +
                                            "UPPER(ISNULL(EST.men_admin, '')) men_admin, " +
                                            "CONVERT(VARCHAR(10), fecha_apli, 103) fec_apli " +
                                    "FROM uge.aplicaciones_prac APLI " +
                                        "INNER JOIN uge.ofertas_prac OFER ON OFER.id_oferta = APLI.id_oferta " +
                                        "INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa " +
                                        "INNER JOIN registro.estudiante E ON E.id_est = APLI.id_documento " +
                                        "INNER JOIN registro.plan_estud PE ON PE.id_plan = E.id_plan " +
                                        "INNER JOIN registro.programas PROG ON PROG.id_prog = PE.id_prog " +
                                        "INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = APLI.estado_apli " +
                                    "WHERE   E.id_dpto = " + id_dpto + " " +
                                            "AND APLI.fecha_apli >= (SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 1) " +
                                    "ORDER BY fecha_apli DESC");
    }
    
    @Override
    public HashMap[] getReporteOferPDec(String id_dpto) throws Exception {
        return bDatos.getRegistros( "SELECT  OFER.id_oferta, " +
                                            "EMP.nit, " +
                                            "UPPER(EMP.razon_social) razon_social, " +
                                            "UPPER(OFER.cargo) cargo, " +
                                            "UPPER(ISNULL(OFER.sector_oferta, '')) sector_oferta, " +
                                            "UPPER(OFER.tipo_contrato) tipo_contrato, " +
                                            "CONVERT(VARCHAR(10), OFER.fecha_in, 103) f_in, " +
                                            "CONVERT(VARCHAR(10), OFER.fecha_out, 103) f_out, " +
                                            "UPPER(EST.men_oferprac) estado, " +
                                            "CONVERT(VARCHAR(10), OFER.fecha_publicacion, 103) f_publicacion, " +
                                            "CONVERT(VARCHAR(10), OFER.fecha_limite, 103) f_limite " +
                                    "FROM uge.ofertas_prac OFER " +
                                        "INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa " +
                                        "INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = OFER.estado " +
                                        "INNER JOIN uge.requerimientos_prac REQ ON REQ.id_oferta = OFER.id_oferta " +
                                    "WHERE   REQ.programa_requerido = (SELECT nom_prog FROM registro.programas WHERE id_dpto = " + id_dpto + " AND tip_prog = 1) " +
                                            "AND OFER.fecha_publicacion >= (SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 3) " +
                                    "ORDER BY OFER.fecha_publicacion DESC");
    }
    
    @Override
    public HashMap[] getReporteTutoresPDec(String id_dpto) throws Exception {
        return bDatos.getRegistros( "SELECT  E.id_est, " +
                                            "UPPER(E.nom_est) nom_est, " +
                                            "CONVERT(VARCHAR(10), SOL.fecha_sol, 103) f_sol, " +
                                            "UPPER(OFER.cargo) cargo, " +
                                            "UPPER(EMP.razon_social) razon_social, " +
                                            "CASE APL.estado_apli " +
                                                "WHEN 'h' THEN 'No asignado' " +
                                                "ELSE UPPER(ISNULL(PROF.nom_prof, '')) " +
                                            "END tutor, " +
                                            "ISNULL(PROF.email, '') email_tutor " +
                                    "FROM uge.solicitud_prac SOL " +
                                        "INNER JOIN registro.estudiante E ON Cast(E.id_est as varchar) = SOL.id_documento " +
                                        "INNER JOIN registro.plan_estud PE ON PE.id_plan = E.id_plan " +
                                        "INNER JOIN registro.programas PROG ON PROG.id_prog = PE.id_prog " +
                                        "INNER JOIN uge.aplicaciones_prac APL ON (APL.id_documento = SOL.id_documento AND APL.estado_apli IN ('h', 'j')) " +
                                        "INNER JOIN uge.ofertas_prac OFER ON OFER.id_oferta = APL.id_oferta " +
                                        "INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa " +
                                        "LEFT JOIN registro.profesor PROF ON PROF.id_prof = APL.id_tutor " +
                                    "WHERE   SOL.estado = 'c' " +
                                            "AND E.id_dpto = " + id_dpto + " " +
                                            "AND APL.fecha_apli >= (SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 1) " +
                                            "AND OFER.fecha_publicacion >= (SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 3) " +
                                            "AND SOL.fecha_sol >= (SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 5) " +
                                    "ORDER BY SOL.fecha_sol DESC");
    }
    
    @Override
    public String getPerVerificaPagoMatri() throws Exception{
        return (String) bDatos.getRegistro("select descripcion from uge.fechas_sige where nombre='perVeriMatri'").get("descripcion");
    }
    
    @Override
    public Boolean estPagoMatricula(String doc_est, String per_acad) throws Exception{
        return bDatos.getRegistros("select ORDEN.num_orden from Novasoft.dbo.usr_cxc_alum_matri ALUMNO, Novasoft.dbo.usr_cxc_orden_matri ORDEN where ALUMNO.docum_alumno= '"+doc_est+"' and ALUMNO.cod_alum=ORDEN.cod_alum and ORDEN.periodo='"+per_acad+"'").length>0;
    }
}
