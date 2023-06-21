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
import utiles.ConsultaException;
import utiles.ConvertDate;

/**
 *
 * @author Luis Alberto Salas
 */
@Stateful
public class Administradores extends Persona implements SessionBean, AdministradoresRemote {

    private SessionContext context;

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
    public EmpleadoRemote create() throws CreateException, RemoteException {
        return null;
    }

    public void ejbCreate() throws CreateException {
    }

    @Override
    public HashMap[] getListaApliMov(String res, String iddpto, String progmov) throws Exception {
        
        /**
        return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, uge.solicitud_mov.estado, uge.estados_mov.men_admin from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov, uge.estados_mov  " +
                                    "where uge.solicitud_mov.estado=uge.estados_mov.id_estado and  " +
                                    "uge.solicitud_mov.id_est=EMPLID " +
                                    " order by nom_est desc");
                                    * 
                                    * * */
        

        if (iddpto.equals("0")) {
            if (progmov.equals("0")) {
                return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, uge.solicitud_mov.estado, uge.estados_mov.men_admin from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov, uge.estados_mov  " +
                                    "where uge.solicitud_mov.estado=uge.estados_mov.id_estado and  " +
                                    "uge.solicitud_mov.id_est=EMPLID " +
                                    " order by nom_est desc");
            } else {
                return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, uge.solicitud_mov.estado, uge.estados_mov.men_admin from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov, uge.estados_mov where uge.solicitud_mov.estado=uge.estados_mov.id_estado and  uge.solicitud_mov.id_est=EMPLID and prog_mov LIKE '%"+progmov+"%' order by nom_est desc");
            }

        } else {
            if (progmov.equals("0")) {
                return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, SOL.estado, uge.estados_mov.men_admin from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov SOL, uge.estados_mov where SOL.estado=uge.estados_mov.id_estado and  SOL.id_est=EMPLID and SOL.acad_prog in (select HOM.ACAD_PROG from uge.homol_progs_campus HOM where HOM.ID_DPTO='"+iddpto+"') order by nom_est desc");
            } else {
                return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, SOL.estado, uge.estados_mov.men_admin from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov SOL, uge.estados_mov where SOL.estado=uge.estados_mov.id_estado and  SOL.id_est=EMPLID and SOL.acad_prog in (select HOM.ACAD_PROG from uge.homol_progs_campus HOM where HOM.ID_DPTO='"+iddpto+"') and prog_mov LIKE '%"+progmov+"%' order by nom_est desc");
            }

        }
    }

    @Override
    public HashMap[] getListaApliMov3(String res, String iddpto, String progmov) throws Exception {
        /**
        return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, uge.solicitud_mov.estado, uge.estados_mov.men_admin " +
                                    "from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov, uge.estados_mov " +
                                    "where uge.solicitud_mov.estado=uge.estados_mov.id_estado and (uge.solicitud_mov.estado = 'i' or uge.solicitud_mov.estado = 'j' or uge.solicitud_mov.estado = 'k' or uge.solicitud_mov.estado = 'r') " +
                                    "and uge.solicitud_mov.id_est=EMPLID " +
                                    "order by nom_est desc");
                                    */
        if (iddpto.equals("0")) {
            if (progmov.equals("0")) {
                return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, uge.solicitud_mov.estado, uge.estados_mov.men_admin " +
                                    "from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov, uge.estados_mov " +
                                    "where uge.solicitud_mov.estado=uge.estados_mov.id_estado and (uge.solicitud_mov.estado = 'i' or uge.solicitud_mov.estado = 'j' or uge.solicitud_mov.estado = 'k' or uge.solicitud_mov.estado = 'r') " +
                                    "and uge.solicitud_mov.id_est=EMPLID " +
                                    "order by nom_est desc");
            } else {
                return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, uge.solicitud_mov.estado, uge.estados_mov.men_admin from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov, uge.estados_mov where uge.solicitud_mov.estado=uge.estados_mov.id_estado and (uge.solicitud_mov.estado = 'i' or uge.solicitud_mov.estado = 'j' or uge.solicitud_mov.estado = 'k' or uge.solicitud_mov.estado = 'r') and uge.solicitud_mov.id_est=EMPLID and prog_mov='"+progmov+"' order by nom_est desc");
            }

        } else {
            if (progmov.equals("0")) {
                return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, SOLICITUD.estado, uge.estados_mov.men_admin from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov SOLICITUD, uge.estados_mov where SOLICITUD.estado=uge.estados_mov.id_estado and (SOLICITUD.estado = 'i' or SOLICITUD.estado = 'j' or SOLICITUD.estado = 'k' or SOLICITUD.estado = 'r') and SOLICITUD.id_est=EMPLID and SOLICITUD.acad_prog in (select PROGS.ACAD_PROG from uge.homol_progs_campus PROGS where PROGS.ID_DPTO='"+iddpto+"') order by nom_est desc");
            } else {
                return bDatos.getRegistros("select id_solicitud,LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, SOLICITUD.estado, uge.estados_mov.men_admin from uge.ps_ec_ib_intp_vw, registro.uge.solicitud_mov SOLICITUD, uge.estados_mov where SOLICITUD.estado=uge.estados_mov.id_estado and (SOLICITUD.estado = 'i' or SOLICITUD.estado = 'j' or SOLICITUD.estado = 'k' or SOLICITUD.estado = 'r') and SOLICITUD.id_est=EMPLID and SOLICITUD.prog_mov='"+progmov+"' and SOLICITUD.acad_prog in (select PROGS.ACAD_PROG from uge.homol_progs_campus PROGS where PROGS.ID_DPTO='"+iddpto+"') order by nom_est desc");
            }

        }
    }

    @Override
    public HashMap[] getListaApliMovVice(String res, String iddpto, String progmov) throws Exception {
        
        return bDatos.getRegistros("select id_solicitud, LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, prog_mov, vobo_vice, uge.solicitud_mov.estado, entre_vice, vobo_psico, vobo_medico, exm_psico, exm_medico " +
"                          from uge.ps_ec_ib_intp_vw, uge.solicitud_mov " +
"                          where uge.solicitud_mov.estado = 'h' and uge.solicitud_mov.id_est=EMPLID " +
"                          order by nom_est desc");
        
        /**ANTES DE CAMPUS HAY QUE CAMBIARLO DE ACUERDO A CAMPUS TODO
        if (iddpto.equals("0")) {
            if (progmov.equals("0")) {
                return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov, vobo_vice, uge.solicitud_mov.estado, entre_vice, vobo_psico, vobo_medico, exm_psico, exm_medico"
                        + " from registro.estudiante, registro.uge.solicitud_mov"
                        + " where uge.solicitud_mov.estado = 'h' and uge.solicitud_mov.id_est=registro.estudiante.id_est"
                        + " order by nom_est desc");
            } else {
                return bDatos.getRegistros("select id_solicitud,nom_est, prog_mov, vobo_vice, uge.solicitud_mov.estado, entre_vice, vobo_psico, vobo_medico, exm_psico, exm_medico"
                        + " from registro.estudiante, registro.uge.solicitud_mov"
                        + " where uge.solicitud_mov.estado = 'h'and uge.solicitud_mov.id_est=registro.estudiante.id_est and prog_mov=" + progmov
                        + " order by nom_est desc");
            }

        } else {
            if (progmov.equals("0")) {
                return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov, vobo_vice, uge.solicitud_mov.estado, entre_vice, vobo_psico, vobo_medico, exm_psico, exm_medico"
                        + " from registro.estudiante, registro.uge.solicitud_mov"
                        + " where uge.solicitud_mov.estado = 'h' and uge.solicitud_mov.id_est=registro.estudiante.id_est and registro.estudiante.id_dpto=" + iddpto
                        + " order by nom_est desc");
            } else {
                return bDatos.getRegistros("select id_solicitud, nom_est, prog_mov, vobo_vice, uge.solicitud_mov.estado, entre_vice, vobo_psico, vobo_medico, exm_psico, exm_medico"
                        + " from registro.estudiante, registro.uge.solicitud_mov"
                        + " where uge.solicitud_mov.estado = 'h' and uge.solicitud_mov.id_est=registro.estudiante.id_est and registro.estudiante.id_dpto=" + iddpto
                        + " and prog_mov=" + progmov
                        + " order by nom_est desc");
            }
        }
        * */
    }

    @Override
    public HashMap[] estadodocumentos(String idsolicitud) throws Exception {
        return bDatos.getRegistros("select estado, id_est, estado_notas, estado_idiomas, estado_cpadres, estado_HV, carta_ud, vobo_foresp "
                + "from uge.solicitud_mov, uge.opcionuni_mov where uge.solicitud_mov.id_solicitud =" + "'" + idsolicitud + "' and uge.opcionuni_mov.id_solicitud =" + "'" + idsolicitud + "'");
    }

    @Override
    public int ActualizarEstadodoc(String idsolicitud, String clave) throws Exception {
        return bDatos.actualizar("UPDATE uge.solicitud_mov set"
                + " estado ="
                + "'" + clave + "'" + "where id_solicitud =" + "'" + idsolicitud + "'");
    }

    @Override
    public int AprobarOfertaPrac(String id_ofer, String nomcargonop, String descripcionnop, String Requisitosnop, String paisnop, String ciudadnop,
            String areanop, String salarionop, String fechaoutnop, String fechainprac, String fechaoutprac, String horarionop, String contratonop,
            String seguros_arp, String nom_jefe, String cargo_jefe, String tel_jefe, String email_jefe) throws Exception {
        
        fechainprac=ConvertDate.getDate103(fechainprac);
        fechaoutnop=ConvertDate.getDate103(fechaoutnop);
        fechaoutprac=ConvertDate.getDate103(fechaoutprac);
        return bDatos.actualizar("UPDATE uge.ofertas_prac set  cargo='" + nomcargonop + "', descripcion='" + descripcionnop + "', requisitos='" + Requisitosnop + "', pais_oferta='" + paisnop + "', "
                + "ciudad_oferta='" + ciudadnop + "', area_oferta='" + areanop + "', salario_oferta='" + salarionop + "', fecha_limite=" + fechaoutnop + ", fecha_in=" + fechainprac + ", fecha_out=" + fechaoutprac + ", "
                + "horario_oferta='" + horarionop + "', tipo_contrato='" + contratonop + "', seguro_arp='" + seguros_arp + "', nom_jefe='" + nom_jefe + "', cargo_jefe='" + cargo_jefe + "',"
                + " tel_jefe='" + tel_jefe + "', email_jefe='" + email_jefe + "', estado='a' where id_oferta='" + id_ofer + "'");

    }

    @Override
    public int RechazarOfertaPracUge(String id_ofer) throws Exception {
        return bDatos.actualizar("UPDATE uge.ofertas_prac set estado='z' where id_oferta='" + id_ofer + "'");
    }
    
    @Override
    public int ObservacionOferPracUge(String id_ofer, String observaciones) throws Exception {
        return bDatos.actualizar(   "UPDATE uge.ofertas_prac " +
                                    "SET uge_obs = '" + observaciones + "' " +
                                    "WHERE id_oferta = '" + id_ofer + "'");
    }

    
    @Override
    public int ActualizaOferta(String id_ofer, String cargo, String desc, String requis, String idiomas, String pais, String ciudad, String area) throws Exception{
        return bDatos.actualizar(   "   Update uge.ofertas_egre " +
                                        "Set cargo         = '"+cargo+"'," +
                                        "    descripcion   = '"+desc+"'," +
                                        "    requisitos    = '"+requis+"'," +
                                        "    idiomas       = '"+idiomas+"'," +
                                        "    pais_oferta   = '"+pais+"'," +
                                        "    ciudad_oferta = '"+ciudad+"'," +
                                        "    area_oferta   = '"+area+"' " +
                                        "Where id_oferta   = "+id_ofer+"");
    }
    
    
    @Override
    public int ActualizaFechasOfPrac(String id_ofer, String fecini, String fecfin, String fenven) throws Exception{
     /*   return bDatos.actualizar(   "  Update registro.uge.ofertas_prac " +
                                    "  Set  fecha_in     = ''," +
                                    "       fecha_out    = ''," +
                                    "       fecha_limite = ''" +
                                    "  Where id_oferta   = 5756 ");*/
     
     fecini= fecini.split("/")[2]+"/"+fecini.split("/")[1]+"/"+fecini.split("/")[0];
     fecfin= fecfin.split("/")[2]+"/"+fecfin.split("/")[1]+"/"+fecfin.split("/")[0];
     fenven= fenven.split("/")[2]+"/"+fenven.split("/")[1]+"/"+fenven.split("/")[0];

        return bDatos.actualizar(   "  Update uge.ofertas_prac " +
                                    "  Set  fecha_in     = '"+fecini+"'," +
                                    "       fecha_out    = '"+fecfin+"'," +
                                    "       fecha_limite = '"+fenven+"'" +
                                    "  Where id_oferta   = "+id_ofer+"");
    }
    
    
    @Override
    public int IngresaOfertaExclusiva(String id_ofer, String id_est) throws Exception{

        return bDatos.actualizar(   " IF exists(select EMPLID from uge.ps_ec_ib_intp_vw where NATIONAL_ID = '"+id_est+"') Begin  " +
"                                     IF not exists (Select id_est from uge.oferta_especifica_prac Where id_est = '"+id_est+"' AND id_oferta = '"+id_ofer+"') begin  " +
"                                         INSERT INTO uge.oferta_especifica_prac   " +
"                                               (id_oferta  " +
"                                               ,id_est  " +
"                                               ,observaciones)  " +
"                                         VALUES   " +
"                                               ('"+id_ofer+"',  " +
"                                                '"+id_est+"',   " +
"                                                (select FIRST_NAME+' '+MIDDLE_NAME+' '+LAST_NAME+' '+SECOND_LAST_NAME from uge.ps_ec_ib_intp_vw where NATIONAL_ID='"+id_est+"')) End End");
    }    
    
    
    @Override
    public int setFechasPrac(String fechainEst, String fechaouteEst, String fechainEmp, String fechaoutEmp,String fechainSolEst,String fechaoutSolEst,String fechainDec,String fechaoutDec, String fechainPracE, String fechaoutPracE, String perVeriMatri) throws Exception {
        
        fechainEst=ConvertDate.getDate103(fechainEst);
        fechaouteEst=ConvertDate.getDate103(fechaouteEst);
        fechainEmp=ConvertDate.getDate103(fechainEmp);
        fechaoutEmp=ConvertDate.getDate103(fechaoutEmp);
        fechainSolEst=ConvertDate.getDate103(fechainSolEst);
        fechaoutSolEst=ConvertDate.getDate103(fechaoutSolEst);
        fechainDec=ConvertDate.getDate103(fechainDec);
        fechaoutDec=ConvertDate.getDate103(fechaoutDec);
        fechainPracE=ConvertDate.getDate103(fechainPracE);
        fechaoutPracE=ConvertDate.getDate103(fechaoutPracE);
        
        
        return bDatos.actualizar("UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechainEst + " " + "where nombre =" + "'fechainEstPrac'"
                + "UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechaouteEst + " " + "where nombre =" + "'fechaouteEstPrac'"
                + "UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechainEmp + " " + "where nombre =" + "'fechainEmpPrac'"
                + "UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechaoutEmp + " " + "where nombre =" + "'fechaoutEmpPrac'"
                + "UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechainSolEst + " " + "where nombre =" + "'fechainSolPrac'"
                + "UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechaoutSolEst + " " + "where nombre =" + "'fechaoutSolPrac'"
                + "UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechainDec + " " + "where nombre =" + "'fechainDec'"
                + "UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechaoutDec + " " + "where nombre =" + "'fechaoutDec'"
                + "UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechainPracE + " " + "where nombre =" + "'fechainPracE'"
                + "UPDATE uge.fechas_sige set"
                + " fecha ="
                + " " + fechaoutPracE + " " + "where nombre =" + "'fechaoutPracE'"
                + "UPDATE uge.fechas_sige set"
                + " descripcion ="
                + " '" + perVeriMatri + "' " + "where nombre =" + "'perVeriMatri'");
        
    }

   /* 
    @Override
    public HashMap[] getListaOpcuni(String res, String iddpto, String progmov) throws Exception {
        return bDatos.getRegistros( "SELECT  SOL.id_solicitud, " +
                                            "R.nom_est, " +
                                            "OPCUNI.id_opcion, " +
                                            "OPCUNI.uni_destino, " +
                                            "OPCUNI.estado_opcud " +
                                    "FROM uge.opcionuni_mov OPCUNI " +
                                    "INNER JOIN uge.solicitud_mov SOL ON SOL.id_solicitud = OPCUNI.id_solicitud " +
                                    "INNER JOIN registro.estudiante R ON R.id_est = SOL.id_est " +
                                    "WHERE   SOL.estado = 'd' " +
                                    //(!iddpto.equals("0")?"AND R.id_dpto = '" + iddpto + "' ":"") +
                                    (!progmov.equals("0")?"AND SOL.prog_mov = " + progmov:""));
    }
    */
    @Override
    public HashMap[] getListaOpcuni(String res, String iddpto, String progmov) throws Exception {
        return bDatos.getRegistros( " SELECT  SOL.id_solicitud, " +
                                    " UPPER(R.LAST_NAME+' '+R.SECOND_LAST_NAME+' '+R.FIRST_NAME+' '+R.MIDDLE_NAME) nom_est, " +
                                    " OPCUNI.id_opcion, " +
                                    " left(OPCUNI.uni_destino,70) uni_destino, " +
                                    " OPCUNI.estado_opcud " +
                                    " FROM uge.opcionuni_mov OPCUNI " +
                                    " INNER JOIN uge.solicitud_mov SOL ON SOL.id_solicitud = OPCUNI.id_solicitud " +
                                    " INNER JOIN uge.ps_ec_ib_intp_vw R ON R.EMPLID = SOL.id_est " +
                                    " WHERE   SOL.estado = 'd' " +
                                    " and  SOL.prog_mov IS NOT NULL " +

                                    //(!iddpto.equals("0")?"AND R.id_dpto = '" + iddpto + "' ":"") +
                                    (!progmov.equals("0")?"AND SOL.prog_mov = " + progmov:""));
}

    @Override
    public int crearSolicitud(String programa_sol, String descripcion, String comentario) throws Exception {
        int ban;
        ban = bDatos.actualizar("UPDATE uge.plantillacontratos_mov set"
                + " descripcion = '" + descripcion + " ' where prog_mov =" + programa_sol);
        return bDatos.actualizar("UPDATE uge.plantillacontratos_mov set"
                + " clausula = '" + comentario + " ' where prog_mov =" + programa_sol);
    }

    @Override
    public HashMap[] getLisNombreGradAdmin(String nombre, String apellido, String doc, String permisos) throws Exception {
        
            /**

            return bDatos.getRegistros(" select id_est, nom_est, STUFF(( Select ' - ' ,RP.nom_prog From  registro.estudiante R inner join registro.plan_estud PE on R.id_plan = PE.id_plan inner join registro.programas RP on PE.id_prog = RP.id_prog Where R.doc_est = E.doc_est AND (R.estado='-100' or R.estado='0') FOR XML PATH(''), TYPE).value('.', 'VARCHAR(MAX)'), 1, 2, '') as nom_prog from registro.estudiante E inner join uge.datos_egre G on E.id_est=G.id_documento inner join registro.plan_estud PE on E.id_plan = PE.id_plan inner join registro.programas RP on PE.id_prog = RP.id_prog and documento not like'%-%' and RP.id_dpto IN ("+permisos+") where"
                    + " ( doc_est='" + doc + "' and igrad='g' and (estado='-100' or estado='0'))");
                    * */
            return bDatos.getRegistros("select MIG_GRAD.NATIONAL_ID as id_est, MIG_GRAD.NOMBRE as nom_est, (select PROG.DESCRIPCION from uge.homol_progs_campus PROG where PROG.ACAD_PROG=MIG_GRAD.ACAD_PROG) as nom_prog from uge.datos_egre EGRESADO, uge.migracion_directa_graduados MIG_GRAD where MIG_GRAD.EMPLID=EGRESADO.id_documento and MIG_GRAD.NATIONAL_ID like '%"+doc+"%' and MIG_GRAD.NOMBRE like '%"+nombre+"%"+apellido+"%'");

        /**
        else {
            return bDatos.getRegistros(" select id_est, nom_est, STUFF(( Select ' - ' ,RP.nom_prog From  registro.estudiante R inner join registro.plan_estud PE on R.id_plan = PE.id_plan inner join registro.programas RP on PE.id_prog = RP.id_prog Where R.doc_est = E.doc_est AND (R.estado='-100' or R.estado='0') FOR XML PATH(''), TYPE).value('.', 'VARCHAR(MAX)'), 1, 2, '') as nom_prog from registro.estudiante E inner join uge.datos_egre G on E.id_est=G.id_documento inner join registro.plan_estud PE on E.id_plan = PE.id_plan inner join registro.programas RP on PE.id_prog = RP.id_prog and documento not like'%-%' and RP.id_dpto IN ("+permisos+") where"
                    + " (nom_est like '%" + apellido + "%' and nom_est like '%" + nombre + "%' and igrad='g' and (estado='-100' or estado='0'))");
            //return bDatos.getRegistros("select id_est, nom_est from registro.estudiante where (nom_est like '%"+apellido+"%'and nom_est like '%"+nombre+"%' and igrad='g' and (estado='-100' or estado='0'))");
        }
        * */

    }
    
    @Override
    public HashMap[] getLisDocGradAdmin(String nombre, String apellido, String doc, String permisos) throws Exception {
        
            /**

            return bDatos.getRegistros(" select id_est, nom_est, STUFF(( Select ' - ' ,RP.nom_prog From  registro.estudiante R inner join registro.plan_estud PE on R.id_plan = PE.id_plan inner join registro.programas RP on PE.id_prog = RP.id_prog Where R.doc_est = E.doc_est AND (R.estado='-100' or R.estado='0') FOR XML PATH(''), TYPE).value('.', 'VARCHAR(MAX)'), 1, 2, '') as nom_prog from registro.estudiante E inner join uge.datos_egre G on E.id_est=G.id_documento inner join registro.plan_estud PE on E.id_plan = PE.id_plan inner join registro.programas RP on PE.id_prog = RP.id_prog and documento not like'%-%' and RP.id_dpto IN ("+permisos+") where"
                    + " ( doc_est='" + doc + "' and igrad='g' and (estado='-100' or estado='0'))");
                    * */
            
            /**
             * Esta es la consulta correcta con Campus
             * return bDatos.getRegistros("select documento from uge.datos_egre where documento like '%"+doc+"%' and documento not like '%-%' and nom_est like '%"+apellido+"%"+nombre+"%'");
             */
            return bDatos.getRegistros("select documento from uge.datos_egre where documento like '%"+doc+"%' and documento not like '%-%' and nom_est like '%"+apellido+"%"+nombre+"%' and id_documento not in (select EMPLID from uge.ps_ec_ib_intp_vw)");

        /**
        else {
            return bDatos.getRegistros(" select id_est, nom_est, STUFF(( Select ' - ' ,RP.nom_prog From  registro.estudiante R inner join registro.plan_estud PE on R.id_plan = PE.id_plan inner join registro.programas RP on PE.id_prog = RP.id_prog Where R.doc_est = E.doc_est AND (R.estado='-100' or R.estado='0') FOR XML PATH(''), TYPE).value('.', 'VARCHAR(MAX)'), 1, 2, '') as nom_prog from registro.estudiante E inner join uge.datos_egre G on E.id_est=G.id_documento inner join registro.plan_estud PE on E.id_plan = PE.id_plan inner join registro.programas RP on PE.id_prog = RP.id_prog and documento not like'%-%' and RP.id_dpto IN ("+permisos+") where"
                    + " (nom_est like '%" + apellido + "%' and nom_est like '%" + nombre + "%' and igrad='g' and (estado='-100' or estado='0'))");
            //return bDatos.getRegistros("select id_est, nom_est from registro.estudiante where (nom_est like '%"+apellido+"%'and nom_est like '%"+nombre+"%' and igrad='g' and (estado='-100' or estado='0'))");
        }
        * */

    }
    
    
    @Override
    public HashMap[] getLisNombreGradAdmin2(String nombre, String apellido, String doc, String permisos) throws Exception {
       
            return bDatos.getRegistros("Select DE.id_documento, RE.doc_est, RE.nom_est, RP.id_dpto, STUFF(( Select ' - ' ,RP.nom_prog From  registro.estudiante R inner join registro.plan_estud PE on R.id_plan = PE.id_plan inner join registro.programas RP on PE.id_prog = RP.id_prog Where R.doc_est = RE.doc_est AND (R.estado='-100' or R.estado='0') FOR XML PATH(''), TYPE).value('.', 'VARCHAR(MAX)'), 1, 2, '') as nom_prog ,DE.ultima_act, RE.id_est\n" +
                                        "From registro.uge.datos_egre DE inner join registro.estudiante RE on DE.id_documento = RE.id_est \n" +
                                        "                                inner join registro.plan_estud PE on RE.id_plan = PE.id_plan\n" +
                                        "								inner join registro.programas RP on PE.id_prog = RP.id_prog\n" +
                                        "Where DE.documento not like '%-%' and (RE.estado='-100' or RE.estado='0') AND RP.id_dpto IN ("+permisos+") Order by nom_prog desc, RE.nom_est desc");
            //return bDatos.getRegistros("select id_est, nom_est from registro.estudiante where (nom_est like '%"+apellido+"%'and nom_est like '%"+nombre+"%' and igrad='g' and (estado='-100' or estado='0'))");
    }
    
    
    @Override
    public HashMap[] getLisAccesoConsulGrad(String user) throws Exception {
       
            return bDatos.getRegistros("(Select dpto_ac from registro.uge.usr_sige Where email_usr = '"+user+"')");
            //return bDatos.getRegistros("select id_est, nom_est from registro.estudiante where (nom_est like '%"+apellido+"%'and nom_est like '%"+nombre+"%' and igrad='g' and (estado='-100' or estado='0'))");
    }
    

    @Override
    public HashMap[] getLisNomEmpAdminG(String nombre, String nit) throws Exception {
        if (!nit.equals("")) {
            return bDatos.getRegistros("select id_empresa, replace(razon_social,'&','y') razon_social, nit, estado_empresa from uge.empresa_egre where nit='" + nit + "'");
        } else {
            return bDatos.getRegistros("select id_empresa, replace(razon_social,'&','y') razon_social, nit, estado_empresa from uge.empresa_egre where (razon_social like '%" + nombre + "%')");
        }

    }

    @Override
    public int eliminarEmpAdminGrad(String nit) throws Exception {
        HashMap dato;
        String est;
        int ban;
        dato = bDatos.getRegistro("select estado_empresa from uge.empresa_egre where nit='" + nit + "'");
        est = (String) dato.get("estado_empresa");
        if (est.equals("grad_prac")) {
            return bDatos.actualizar("update uge.empresa_egre set estado_empresa='prac'where nit='" + nit + "'");
        } else {
            if (est.equals("grad")) {
                return bDatos.actualizar("update uge.empresa_egre set estado_empresa='eliminada'where nit='" + nit + "'");
            } else {
                return -2;
            }
        }
    }

    @Override
    public int eliminarOfertaGrad(String id_ofer, String usr) throws Exception {
        HashMap[] dato;
        String est;
        int ban, ban2;
        dato = bDatos.getRegistros("select * from uge.aplicaciones_egre where id_oferta='" + id_ofer + "'");
        ban = dato.length;
        ban2 = bDatos.actualizar("delete from uge.aplicaciones_egre where id_oferta='" + id_ofer + "' "
                + "delete from uge.ofertas_egre where id_oferta='" + id_ofer + "' "
                + "delete from uge.requerimientos_egre where id_oferta='" + id_ofer + "' "
                + " insert into uge.auditoria_sige (descripcion, ejecutor) values ('elimino oferta con id " + id_ofer + " y " + ban + " postulaciones','" + usr + "')");
        if (ban2 > 0) {
            return ban;
        } else {
            ban = -2;
            return ban;
        }

    }

    @Override
    public int TramitarOfertaAdminG(String id_ofer, String usr, String tip) throws Exception {
       
        int ban;
        if (tip.equals("aprobar")) {
            ban = bDatos.actualizar("update uge.ofertas_egre set estado='a' where id_oferta='" + id_ofer + "' "
                    + " insert into uge.auditoria_sige (descripcion, ejecutor) values (convert (varchar,getdate())+' aprobó la oferta con id " + id_ofer + "','" + usr + "')");
        } else {
            ban = bDatos.actualizar("update uge.ofertas_egre set estado='z' where id_oferta='" + id_ofer + "' "
                    + " insert into uge.auditoria_sige (descripcion, ejecutor) values (convert (varchar,getdate())+' rechazó la oferta con id " + id_ofer + "','" + usr + "')");
        }
        if (ban > 0) {
            return ban;
        } else {
            return ban;
        }

    }

    @Override
    public HashMap[] getListaofergradAdmin(String programagradAdmin) throws Exception {
        if (programagradAdmin.equals("TODOS")) {
            return bDatos.getRegistros("select razon_social, nit, cargo, id_oferta, fecha_limite from uge.ofertas_egre,"
                    + " uge.empresa_egre where uge.ofertas_egre.id_empresa=uge.empresa_egre.id_empresa and fecha_limite > '2013-01-01' ORDER BY fecha_limite");
        } else {
            return bDatos.getRegistros("select razon_social, nit, cargo, uge.ofertas_egre.id_oferta, fecha_limite from uge.ofertas_egre, "
                    + "uge.empresa_egre, uge.requerimientos_egre where uge.ofertas_egre.id_empresa=uge.empresa_egre.id_empresa "
                    + "and uge.requerimientos_egre.id_oferta=uge.ofertas_egre.id_oferta and programa_requerido='" + programagradAdmin + "' and fecha_limite >'2013-12-12' ORDER BY fecha_limite");
        }
    }

    @Override
    public HashMap[] getListaTramoferAdminG() throws Exception {

        return bDatos.getRegistros("select replace(razon_social, '&', 'y') razon_social, nit, replace(cargo, '&', 'y') cargo, id_oferta, fecha_limite from uge.ofertas_egre,"
                + " uge.empresa_egre where uge.ofertas_egre.id_empresa=uge.empresa_egre.id_empresa and fecha_limite >= getdate() and estado='k'");


    }

    @Override
    public HashMap[] getListaoferxnit(String nit) throws Exception {
        return bDatos.getRegistros("select razon_social, nit, cargo, id_oferta, fecha_limite  from uge.ofertas_egre O inner join uge.empresa_egre E on O.id_empresa=E.id_empresa "
                + "and E.nit='" + nit + "'");
    }

    @Override
    public HashMap[] getListaoferpracAdmin(String programapracAdmin) throws Exception {
        if (programapracAdmin.equals("TODOS")) {
            return bDatos.getRegistros("select top(200) razon_social, nit, cargo, id_oferta, fecha_limite from uge.ofertas_prac, "
                    + "uge.empresa_egre where uge.ofertas_prac.id_empresa=uge.empresa_egre.id_empresa order by fecha_publicacion desc");
        } else {
            return bDatos.getRegistros("select razon_social, nit, cargo, uge.ofertas_prac.id_oferta, fecha_limite from "
                    + "uge.ofertas_prac,uge.empresa_egre, uge.requerimientos_prac where uge.ofertas_prac.id_empresa="
                    + "uge.empresa_egre.id_empresa and uge.requerimientos_prac.id_oferta=uge.ofertas_prac.id_oferta and programa_requerido"
                    + "='" + programapracAdmin + "' order by fecha_publicacion desc");
        }
    }

    @Override
    public HashMap[] getListaTramitaroferprac() throws Exception {
        return bDatos.getRegistros( "SELECT  EMP.razon_social, " +
                                            "EMP.nit, " +
                                            "OFER.cargo, " +
                                            "OFER.id_oferta, " +
                                            "CONVERT(VARCHAR(10), OFER.fecha_limite, 103) fecha_limite, " +
                                            "ISNULL(OFER.uge_obs, '') uge_obs " +
                                    "FROM uge.ofertas_prac OFER " +
                                        "INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa " +
                                    "WHERE OFER.estado = 'k' " +
                                    "ORDER BY OFER.fecha_limite");

        /*return bDatos.getRegistros("select razon_social, nit, cargo, id_oferta, fecha_limite from uge.ofertas_prac,"
                + "uge.empresa_egre where uge.ofertas_prac.id_empresa=uge.empresa_egre.id_empresa and uge.ofertas_prac.estado='k' ORDER BY fecha_publicacion DESC");*/
    }

    @Override
    public HashMap[] getListaPracAdmin(String iddpto, String TipoConsultaPracFor) throws Exception {
        HashMap[] ban = null;
        
        ban=bDatos.getRegistros("SELECT  E.EMPLID id_documento,   " +
        "        LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est,   " +
        "        EST.men_solprac estado   " +
        "FROM uge.solicitud_prac SOL   " +
        "    INNER JOIN uge.ps_ec_ib_intp_vw E ON Cast(E.EMPLID as varchar) = SOL.id_documento   " +
        "    INNER JOIN uge.datos_prac DP ON DP.id_documento = Cast(E.EMPLID as varchar)   " +
        "    INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = SOL.estado   " +
        "WHERE   SOL.fecha_sol >= (SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 5)  " +
        "ORDER BY SOL.fecha_sol");

        /**ANTES DE CAMPUS HAY QUE MODIFICAR ESTAS CONSULTAS PARA ADAPTARLAS A LOS DATOS DE CAMPUS TODO
        if (TipoConsultaPracFor.equals("Inicial")) {
            ban= bDatos.getRegistros("select D.id_documento, nom_est,'sin Solicitud' estado from uge.datos_prac D, "
                    + "registro.estudiante E,uge.solicitud_prac S "
                    + "where E.id_est=D.id_documento and E.id_dpto='" + iddpto + "' and S.id_documento != D.id_documento");
        } 
       if (TipoConsultaPracFor.equals("Solicitud")) {
                ban= bDatos.getRegistros(   "SELECT  E.id_est id_documento, " +
                                                    "E.nom_est, " +
                                                    "EST.men_solprac estado " +
                                            "FROM uge.solicitud_prac SOL " +
                                                "INNER JOIN registro.estudiante E ON Cast(E.id_est as varchar) = SOL.id_documento " +
                                                "INNER JOIN uge.datos_prac DP ON DP.id_documento = Cast(E.id_est as varchar) " +
                                                "INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = SOL.estado " +
                                            "WHERE   E.id_dpto like '" + iddpto + "' " +
                                                    "AND SOL.fecha_sol >= (SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 5)" +
                                            "ORDER BY SOL.fecha_sol");
       }
       
       if (TipoConsultaPracFor.equals("Seleccionado")) {
                ban= bDatos.getRegistros(   "SELECT  E.id_est id_documento, " +
                                                    "E.nom_est, " +
                                                    "ISNULL(EST.men_admin, '-') estado " +
                                            "FROM uge.aplicaciones_prac APL " +
                                                "INNER JOIN registro.estudiante E ON Cast(E.id_est as varchar) = APL.id_documento " +
                                                "INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = APL.estado_apli " +
                                            "WHERE   E.id_dpto = '" + iddpto + "' " +
                                                    "AND APL.fecha_apli >= (SELECT fecha FROM uge.fechas_sige WHERE id_fecha = 1)" +
                                            "ORDER BY APL.fecha_apli");
       }
       if (TipoConsultaPracFor.equals("AprobadoDec")) {
                ban= bDatos.getRegistros("SELECT A.id_documento, nom_est,ET.men_admin estado from uge.aplicaciones_prac A,"
                        + "registro.estudiante E,uge.estados_apli_ofer ET  where E.id_est=A.id_documento and E.id_dpto='" + iddpto + "'AND "
                        + "ET.estado_apli= A.estado_apli");
       }
         if(TipoConsultaPracFor.equals("Contratado")){
                ban= bDatos.getRegistros("SELECT A.id_documento, nom_est,ET.men_admin estado from uge.aplicaciones_prac A,"
                        + "registro.estudiante E,uge.estados_apli_ofer ET  where E.id_est=A.id_documento and E.id_dpto='" + iddpto + "'AND "
                        + "ET.estado_apli= A.estado_apli");
       }
       * */
       
       return ban;
            
        
    }

    @Override
    public HashMap[] getReporteGrad(String programa, String fechain, String fechaout, String datos[]) throws Exception {
        String sentencia = "";
        int numdatos;
        numdatos = (int) datos.length;
        for (int i = 0; i < numdatos; i++) {
            sentencia = sentencia + "," + datos[i];
        }
        if (programa.equals("TODOS")) {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select MIG_GRAD.NOMBRE as nom_est, DATOS_CAMPUS.SEX as sexo, (select TOP 1 PROGRAMAS.DESCRIPCION from uge.homol_progs_campus PROGRAMAS where PROGRAMAS.ACAD_PROG=MIG_GRAD.ACAD_PROG) as nom_prog, MIG_GRAD.FECHA_GRADO fec_grad, DATOS_EGRESADO.ultima_act, DATOS_EGRESADO.nomcortoes"
                        + sentencia + " from uge.datos_egre DATOS_EGRESADO, uge.ps_ec_ib_intp_vw DATOS_CAMPUS, uge.migracion_directa_graduados MIG_GRAD where DATOS_EGRESADO.id_documento = DATOS_CAMPUS.EMPLID and MIG_GRAD.EMPLID=DATOS_EGRESADO.id_documento");
            } else {
                return bDatos.getRegistros("select MIG_GRAD.NOMBRE as nom_est, DATOS_CAMPUS.SEX as sexo, (select TOP 1 PROGRAMAS.DESCRIPCION from uge.homol_progs_campus PROGRAMAS where PROGRAMAS.ACAD_PROG=MIG_GRAD.ACAD_PROG) as nom_prog, MIG_GRAD.FECHA_GRADO fec_grad, DATOS_EGRESADO.ultima_act, DATOS_EGRESADO.nomcortoes"
                        + sentencia + " from uge.datos_egre DATOS_EGRESADO, uge.ps_ec_ib_intp_vw DATOS_CAMPUS, uge.migracion_directa_graduados MIG_GRAD where DATOS_EGRESADO.id_documento = DATOS_CAMPUS.EMPLID and MIG_GRAD.EMPLID=DATOS_EGRESADO.id_documento and MIG_GRAD.FECHA_GRADO >='" + fechain + "' and "
                        + "MIG_GRAD.FECHA_GRADO <='" + fechaout + "' ");
            }
        } else {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select MIG_GRAD.NOMBRE as nom_est, DATOS_CAMPUS.SEX as sexo, (select TOP 1 PROGRAMAS.DESCRIPCION from uge.homol_progs_campus PROGRAMAS where PROGRAMAS.ACAD_PROG=MIG_GRAD.ACAD_PROG) as nom_prog, MIG_GRAD.FECHA_GRADO fec_grad, DATOS_EGRESADO.ultima_act, DATOS_EGRESADO.nomcortoes"
                        + sentencia + " from uge.datos_egre DATOS_EGRESADO, uge.ps_ec_ib_intp_vw DATOS_CAMPUS, uge.migracion_directa_graduados MIG_GRAD where DATOS_EGRESADO.id_documento = DATOS_CAMPUS.EMPLID and MIG_GRAD.EMPLID=DATOS_EGRESADO.id_documento and MIG_GRAD.ACAD_PROG in (select HOMOL.ACAD_PROG from uge.homol_progs_campus HOMOL where HOMOL.ACAD_PROG=MIG_GRAD.ACAD_PROG and HOMOL.ID_PROG='"+programa+"')");
            } else {
                return bDatos.getRegistros("select MIG_GRAD.NOMBRE as nom_est, DATOS_CAMPUS.SEX as sexo, (select TOP 1 PROGRAMAS.DESCRIPCION from uge.homol_progs_campus PROGRAMAS where PROGRAMAS.ACAD_PROG=MIG_GRAD.ACAD_PROG) as nom_prog, MIG_GRAD.FECHA_GRADO fec_grad, DATOS_EGRESADO.ultima_act, DATOS_EGRESADO.nomcortoes"
                        + sentencia + " from uge.datos_egre DATOS_EGRESADO, uge.ps_ec_ib_intp_vw DATOS_CAMPUS, uge.migracion_directa_graduados MIG_GRAD where DATOS_EGRESADO.id_documento = DATOS_CAMPUS.EMPLID and MIG_GRAD.EMPLID=DATOS_EGRESADO.id_documento and MIG_GRAD.FECHA_GRADO >='" + fechain + "' and "
                        + "MIG_GRAD.FECHA_GRADO <='" + fechaout + "' and MIG_GRAD.ACAD_PROG in (select HOMOL.ACAD_PROG from uge.homol_progs_campus HOMOL where HOMOL.ACAD_PROG=MIG_GRAD.ACAD_PROG and HOMOL.ID_PROG='"+programa+"')");
            }
        }


    }
    
    @Override
    public HashMap[] getReporteGradMon(String programa, String fechain, String fechaout) throws Exception {
        if (programa.equals("TODOS")) {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select DATOS_EGRESADO.documento as Documento, DATOS_EGRESADO.nom_est as Nombre, (select TOP 1 PROGRAMAS.DESCRIPCION from uge.homol_progs_campus PROGRAMAS where PROGRAMAS.ACAD_PROG=MIG_GRAD.ACAD_PROG) as Programa from uge.datos_egre DATOS_EGRESADO, uge.ps_ec_ib_intp_vw DATOS_CAMPUS, uge.migracion_directa_graduados MIG_GRAD where DATOS_EGRESADO.id_documento = DATOS_CAMPUS.EMPLID and MIG_GRAD.EMPLID=DATOS_EGRESADO.id_documento");
            } else {
                return bDatos.getRegistros("select DATOS_EGRESADO.documento as Documento, DATOS_EGRESADO.nom_est as Nombre, (select TOP 1 PROGRAMAS.DESCRIPCION from uge.homol_progs_campus PROGRAMAS where PROGRAMAS.ACAD_PROG=MIG_GRAD.ACAD_PROG) as Programa from uge.datos_egre DATOS_EGRESADO, uge.ps_ec_ib_intp_vw DATOS_CAMPUS, uge.migracion_directa_graduados MIG_GRAD where DATOS_EGRESADO.id_documento = DATOS_CAMPUS.EMPLID and MIG_GRAD.EMPLID=DATOS_EGRESADO.id_documento and MIG_GRAD.FECHA_GRADO >='" + fechain + "' and "
                        + "MIG_GRAD.FECHA_GRADO <='" + fechaout + "' ");
            }
        } else {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select DATOS_EGRESADO.documento as Documento, DATOS_EGRESADO.nom_est as Nombre, (select TOP 1 PROGRAMAS.DESCRIPCION from uge.homol_progs_campus PROGRAMAS where PROGRAMAS.ACAD_PROG=MIG_GRAD.ACAD_PROG) as Programa from uge.datos_egre DATOS_EGRESADO, uge.ps_ec_ib_intp_vw DATOS_CAMPUS, uge.migracion_directa_graduados MIG_GRAD where DATOS_EGRESADO.id_documento = DATOS_CAMPUS.EMPLID and MIG_GRAD.EMPLID=DATOS_EGRESADO.id_documento and MIG_GRAD.ACAD_PROG in (select HOMOL.ACAD_PROG from uge.homol_progs_campus HOMOL where HOMOL.ACAD_PROG=MIG_GRAD.ACAD_PROG and HOMOL.ID_PROG='"+programa+"')");
            } else {
                return bDatos.getRegistros("select DATOS_EGRESADO.documento as Documento, DATOS_EGRESADO.nom_est as Nombre, (select TOP 1 PROGRAMAS.DESCRIPCION from uge.homol_progs_campus PROGRAMAS where PROGRAMAS.ACAD_PROG=MIG_GRAD.ACAD_PROG) as Programa from uge.datos_egre DATOS_EGRESADO, uge.ps_ec_ib_intp_vw DATOS_CAMPUS, uge.migracion_directa_graduados MIG_GRAD where DATOS_EGRESADO.id_documento = DATOS_CAMPUS.EMPLID and MIG_GRAD.EMPLID=DATOS_EGRESADO.id_documento and MIG_GRAD.FECHA_GRADO >='" + fechain + "' and "
                        + "MIG_GRAD.FECHA_GRADO <='" + fechaout + "' and MIG_GRAD.ACAD_PROG in (select HOMOL.ACAD_PROG from uge.homol_progs_campus HOMOL where HOMOL.ACAD_PROG=MIG_GRAD.ACAD_PROG and HOMOL.ID_PROG='"+programa+"')");
            }
        }
    }

    @Override
    public HashMap[] getReporteDisG(String programa, String fechain, String fechaout, String datos[]) throws Exception {
        String sentencia = "";
        int numdatos;
        numdatos = (int) datos.length;
        for (int i = 0; i < numdatos; i++) {
            sentencia = sentencia + "," + datos[i];
        }
        if (programa.equals("TODOS")) {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.distinciones_sige DISTINCION, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento= PERSONA.EMPLID and EGRESADO.id_documento = DISTINCION.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento");
            } else {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.distinciones_sige DISTINCION, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento= PERSONA.EMPLID and EGRESADO.id_documento = DISTINCION.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and "
                        + "fecha_distincion>='" + fechain + "' and  fecha_distincion<='" + fechaout + "'");
            }
        } else {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.distinciones_sige DISTINCION, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento= PERSONA.EMPLID and EGRESADO.id_documento = DISTINCION.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and MIG_GRAD.ACAD_PROG in (select PROG.ACAD_PROG from uge.homol_progs_campus PROG where PROG.ID_PROG='" + programa + "')");

            } else {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.distinciones_sige DISTINCION, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento= PERSONA.EMPLID and EGRESADO.id_documento = DISTINCION.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and "
                        + "fecha_distincion>='" + fechain + "' and  fecha_distincion<='" + fechaout + "' and MIG_GRAD.ACAD_PROG in (select PROG.ACAD_PROG from uge.homol_progs_campus PROG where PROG.ID_PROG='" + programa + "')");
            }
        }

    }

    @Override
    public HashMap[] getReporteAfiG(String programa, String fechain, String fechaout, String datos[]) throws Exception {

        String sentencia = "";
        int numdatos;
        numdatos = (int) datos.length;
        for (int i = 0; i < numdatos; i++) {
            sentencia = sentencia + "," + datos[i];
        }
        if (programa.equals("TODOS")) {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select EGRESADO.nom_est ,(select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.afiliaciones_sige AFILIACION, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento= PERSONA.EMPLID and EGRESADO.id_documento = AFILIACION.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento ");
            } else {
                return bDatos.getRegistros("select EGRESADO.nom_est ,(select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.afiliaciones_sige AFILIACION, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento= PERSONA.EMPLID and EGRESADO.id_documento = AFILIACION.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento  and "
                        + "fecha_in>='" + fechain + "' and  fecha_in<='" + fechaout + "'");
            }
        } else {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select EGRESADO.nom_est ,(select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.afiliaciones_sige AFILIACION, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento= PERSONA.EMPLID and EGRESADO.id_documento = AFILIACION.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and MIG_GRAD.ACAD_PROG in (select PROG.ACAD_PROG from uge.homol_progs_campus PROG where PROG.ID_PROG='" + programa + "')");

            } else {
                return bDatos.getRegistros("select EGRESADO.nom_est ,(select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.afiliaciones_sige AFILIACION, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento= PERSONA.EMPLID and EGRESADO.id_documento = AFILIACION.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and "
                        + "fecha_in>='" + fechain + "' and  fecha_in<='" + fechaout + "' and MIG_GRAD.ACAD_PROG in (select PROG.ACAD_PROG from uge.homol_progs_campus PROG where PROG.ID_PROG='" + programa + "')");
            }
        }
    }

    @Override
    public HashMap[] getReporteIdioG(String programa, String fechain, String fechaout, String datos[]) throws Exception {
        String sentencia = "";
        int numdatos;
        numdatos = (int) datos.length;
        for (int i = 0; i < numdatos; i++) {
            sentencia = sentencia + "," + datos[i];
        }
        if (programa.equals("TODOS")) {

            return bDatos.getRegistros("select EGRESADO.nom_est ,(select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.ps_ec_ib_intp_vw PERSONA, uge.datos_egre EGRESADO, uge.idiomas_sige IDIOMA, uge.migracion_directa_graduados MIG_GRAD where PERSONA.EMPLID=EGRESADO.id_documento and EGRESADO.id_documento= IDIOMA.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento");
        } else {

            return bDatos.getRegistros("select EGRESADO.nom_est ,(select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.ps_ec_ib_intp_vw PERSONA, uge.datos_egre EGRESADO, uge.idiomas_sige IDIOMA, uge.migracion_directa_graduados MIG_GRAD where PERSONA.EMPLID=EGRESADO.id_documento and EGRESADO.id_documento= IDIOMA.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and MIG_GRAD.ACAD_PROG in (select PROG.ACAD_PROG from uge.homol_progs_campus PROG where PROG.ID_PROG='" + programa + "')");



        }

    }

    @Override
    public HashMap[] getReporteEstG(String programa, String fechain, String fechaout, String datos[]) throws Exception {
        String sentencia = "";
        int numdatos;
        numdatos = (int) datos.length;
        for (int i = 0; i < numdatos; i++) {
            sentencia = sentencia + "," + datos[i];
        }
        if (programa.equals("TODOS")) {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.estudios_sige ESTUDIO, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento=PERSONA.EMPLID and ESTUDIO.id_documento=EGRESADO.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and ESTUDIO.id_documento <> 'null' ORDER BY EGRESADO.nom_est");
            } else {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.estudios_sige ESTUDIO, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento=PERSONA.EMPLID and ESTUDIO.id_documento=EGRESADO.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and ESTUDIO.id_documento <> 'null' and "
                        + "MIG_GRAD.FECHA_GRADO>='" + fechain + "' and  MIG_GRAD.FECHA_GRADO<='" + fechaout + "' "
                        + "ORDER BY EGRESADO.nom_est");
            }
        } else {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.estudios_sige ESTUDIO, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento=PERSONA.EMPLID and ESTUDIO.id_documento=EGRESADO.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and MIG_GRAD.ACAD_PROG in (select PROG.ACAD_PROG from uge.homol_progs_campus PROG where PROG.ID_PROG='" + programa + "') and ESTUDIO.id_documento <> 'null' ORDER BY EGRESADO.nom_est");

            } else {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad" + sentencia + " from uge.datos_egre EGRESADO, uge.ps_ec_ib_intp_vw PERSONA, uge.estudios_sige ESTUDIO, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento=PERSONA.EMPLID and ESTUDIO.id_documento=EGRESADO.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and "
                        + "MIG_GRAD.FECHA_GRADO>='" + fechain + "' and  MIG_GRAD.FECHA_GRADO<='" + fechaout + "'and MIG_GRAD.ACAD_PROG in (select PROG.ACAD_PROG from uge.homol_progs_campus PROG where PROG.ID_PROG='" + programa + "') and ESTUDIO.id_documento <> 'null' "
                        + "ORDER BY EGRESADO.nom_est");
            }
        }
    }
    
    
    
    @Override
    public HashMap[] getReporteEstSolEs() throws Exception {
        
    return bDatos.getRegistros("Select	DE.documento,  " +
"        DE.nom_est, " +
"		DE.fecha_nacimiento,  " +
"		DE.tel_indicativo, " +
"		DE.tel_residencia, " +
"		DE.cel_indicativo, " +
"		DE.cel, DE.email,  " +
"		DE.email2, DE.perfil,  " +
"		DE.pais_residencia,  " +
"		DE.ciudad_residencia, " +
"		DE.vobopoliticadatos, " +
"		STUFF((Select top 1 '- ', CASE EL.propia WHEN 1 THEN 'Empresa Propia' ELSE '' END, ' ' , EL.nom_empresa, ' ' , EL.cargo, ' ' , EL.sector_emp, ' ' , EL.tel_emp, ' ' , EL.salario, ' ' , EL.fecha_in_cargo, ' ' , EL.fecha_out_cargo, ' ' , EL.tipo_contrato, ' ' , EL.principal from registro.uge.explaboral_egre EL Where EL.id_documento IN (Select id_documento from registro.uge.datos_egre Where documento = DE.documento) FOR XML PATH(''), TYPE).value('.', 'VARCHAR(MAX)'), 1, 1, '') as explaboral, " +
"		STUFF((Select '- ' ,nivel_formacion, ' ' , titulo, ' ' , nom_inst, ' ' , CONVERT(VARCHAR(10),fecha_grado, 103) from registro.uge.estudios_sige Where id_documento IN (Select id_documento from registro.uge.datos_egre Where documento = DE.documento) Order by fecha_grado asc FOR XML PATH(''), TYPE).value('.', 'VARCHAR(MAX)'), 1, 1, '')  as estudios, " +
"		STUFF((Select '- ' ,nom_distincion, ' ' , lugar_distincion, ' ' ,  tipo_distincion, ' ' , ambito_distincion, ' ' , fecha_distincion from registro.uge.distinciones_sige  Where id_documento IN (Select id_documento from registro.uge.datos_egre Where documento = DE.documento) FOR XML PATH(''), TYPE).value('.', 'VARCHAR(MAX)'), 1, 1, '') as distinciones, " +
"		STUFF((Select '- ' ,nom_aso, tipo_aso, ' ' , estado_afi, ' ' , fecha_in from registro.uge.afiliaciones_sige  Where id_documento IN (Select id_documento from registro.uge.datos_egre Where documento = DE.documento) FOR XML PATH(''), TYPE).value('.', 'VARCHAR(MAX)'), 1, 1, '') as afiliaciones " +
" from registro.uge.datos_egre DE " +
" Where documento not like '%-%'  " +
" Order by DE.documento");
      
    }

    @Override
    public HashMap[] getReporteExpG(String programa, String fechain, String fechaout, String datos[]) throws Exception {
        String sentencia = "";
        int numdatos;
        numdatos = (int) datos.length;
        for (int i = 0; i < numdatos; i++) {
            sentencia = sentencia + "," + datos[i];
        }
        if (programa.equals("TODOS")) {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad, ISNULL((EGRESADO.email),(EGRESADO.email2)) AS mail " + sentencia + " from uge.ps_ec_ib_intp_vw PERSONA, uge.datos_egre EGRESADO, uge.explaboral_egre EXPERIENCIA, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento=PERSONA.EMPLID and EGRESADO.id_documento= EXPERIENCIA.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento");
            } else {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad, ISNULL((EGRESADO.email),(EGRESADO.email2)) AS mail " + sentencia + " from uge.ps_ec_ib_intp_vw PERSONA, uge.datos_egre EGRESADO, uge.explaboral_egre EXPERIENCIA, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento=PERSONA.EMPLID and EGRESADO.id_documento= EXPERIENCIA.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and "
                        + "fecha_in_cargo>='" + fechain + "' and  fecha_in_cargo<='" + fechaout + "'");
            }
        } else {
            if (fechain.equals("") || fechaout.equals("")) {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad, ISNULL((EGRESADO.email),(EGRESADO.email2)) AS mail " + sentencia + " from uge.ps_ec_ib_intp_vw PERSONA, uge.datos_egre EGRESADO, uge.explaboral_egre EXPERIENCIA, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento=PERSONA.EMPLID and EGRESADO.id_documento= EXPERIENCIA.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and MIG_GRAD.ACAD_PROG in (select PROG.ACAD_PROG from uge.homol_progs_campus PROG where PROG.ID_PROG='" + programa + "')");

            } else {
                return bDatos.getRegistros("select EGRESADO.nom_est, (select TOP 1 DESCRIPCION from uge.homol_progs_campus PROGRAMA where PROGRAMA.ACAD_PROG=MIG_GRAD.ACAD_PROG) nom_prog, MIG_GRAD.FECHA_GRADO fec_grad, ISNULL((EGRESADO.email),(EGRESADO.email2)) AS mail " + sentencia + " from uge.ps_ec_ib_intp_vw PERSONA, uge.datos_egre EGRESADO, uge.explaboral_egre EXPERIENCIA, uge.migracion_directa_graduados MIG_GRAD where EGRESADO.id_documento=PERSONA.EMPLID and EGRESADO.id_documento= EXPERIENCIA.id_documento and MIG_GRAD.EMPLID=EGRESADO.id_documento and "
                        + "fecha_in_cargo>='" + fechain + "' and  fecha_in_cargo<='" + fechaout + "'and MIG_GRAD.ACAD_PROG in (select PROG.ACAD_PROG from uge.homol_progs_campus PROG where PROG.ID_PROG='" + programa + "')");
            }
        }

    }

    @Override
    public HashMap[] getReporteEmpG(String programa, String fechain, String fechaout, String datos[]) throws Exception {
        String sentencia = "";
        int numdatos;
        numdatos = (int) datos.length;
        for (int i = 0; i < numdatos; i++) {
            sentencia = sentencia + "," + datos[i];
        }

        if (fechain.equals("") || fechaout.equals("")) {
            return bDatos.getRegistros("select nit,estado_empresa" + sentencia + " from "
                    + " uge.empresa_egre where estado_empresa ='grad_prac' or estado_empresa ='grad'");

        } else {
            return bDatos.getRegistros("select nit,estado_empresa,fecha_reg" + sentencia + " from "
                    + " uge.empresa_egre where  "
                    + "fecha_reg>='" + fechain + "' and  fecha_reg<='" + fechaout + "' and (estado_empresa ='grad_prac' or estado_empresa ='grad') ");
        }

    }

    @Override
    public HashMap[] getReporteOferG(String programa, String fechain, String fechaout, String datos[]) throws Exception {
        String sentencia = "";
        int numdatos;
        numdatos = (int) datos.length;
        for (int i = 0; i < numdatos; i++) {
            if (datos[i].equals("aÃ±os_exp")) {
                datos[i] = "años_exp";
            }
            sentencia = sentencia + "," + datos[i];
        }
        
        return bDatos.getRegistros( "SELECT  OFER.cargo, " +
                                            "OFER.vacantes,"+
                                            "OFER.teletrabajo,"+
                                            "OFER.discapacidad,"+
                                            "CASE OFER.excepcionpub " +
                                            "WHEN 'S' THEN 'N' " +
                                            "WHEN 'N' THEN 'S' " +
                                            "ELSE 'N/A' END AS excepcionpub,"+
                                            "REPLACE(REPLACE(REPLACE(salario_oferta,'y','-'),'.',''),' ','') as Salario,"+
                                            "EMP.razon_social, " +
                                            "EMP.tipoid ,"+
                
                                            "CASE EMP.tipoid "+
                                            "WHEN '1' THEN 'NIT' "+
                                            "WHEN '2' THEN 'Cédula de Ciudadanía' "+
                                            "WHEN '3' THEN 'Cédula de Extranjería' "+
                                            "WHEN '4' THEN 'Pasaporte' "+
                                            "WHEN '5' THEN 'RUT' "+
                                            "ELSE '' END AS idtipo, "+
                
                                            "EMP.nit , " +
                                            "dirigido_a = (CASE WHEN LEN(STUFF(( SELECT '-' + programa_requerido  FROM registro.uge.requerimientos_egre WHERE id_oferta = OFER.id_oferta FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 1, ''))>672 THEN 'Todas las Carreras' ELSE STUFF(( SELECT '-' + programa_requerido  FROM registro.uge.requerimientos_egre WHERE id_oferta = OFER.id_oferta FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 1, '') END),"+
                                            "estudios_requeridos = ( SELECT CONVERT(varchar(10),max(codigo)) from registro.uge.estudiosreq_oferta where id_oferta = OFER.id_oferta ),"+    
                                            "estudios_requeridost = STUFF(( SELECT ',' + nombre from registro.uge.estudiosreq_oferta where id_oferta = OFER.id_oferta FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 1, ''),"+        
                                            "municipios = STUFF(( SELECT '-' + REPLICATE('0', 5-LEN(codigo))+CONVERT(varchar(10),codigo) from registro.uge.muni_oferta where id_oferta = OFER.id_oferta FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 1, ''),"+
                                            
                                            "CASE OFER.tipo_contrato "+
                                            "WHEN 'Termino Fijo' THEN '1' "+
                                            "WHEN 'Termino indefinido' THEN '2' "+
                                            "WHEN 'Prestación de servicios' THEN '5' "+
                                            "WHEN 'Otro' THEN '6' "+
                                            "ELSE '' END AS idtipo_contrato, "+
                
                                            "CASE EST.estado_apli " +
                                                "WHEN 'a' THEN 'Aprobado por la UGE' " +
                                                "WHEN 'k' THEN 'Pendiente de revisión por la UGE' " +
                                                "WHEN 'z' THEN 'Rechazdo por la UGE' " +
                                            "ELSE '' END AS estado," +
                                            "CONCAT('http://practicas.escuelaing.edu.co/SIGE2.0-war/VerOfertaEmpAdminG?idofer=',CONVERT(varchar(10),OFER.id_oferta)) AS URL"+
                                            sentencia + " " +
                                    "FROM uge.ofertas_egre OFER " +
                                        "INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa " +
                                        "INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = OFER.estado " +
                                    ((!fechain.equals("") || !fechaout.equals(""))?"WHERE ":"") +
                                    ((!fechain.equals(""))?"fecha_publicacion >= '" + fechain + "' ":"") +
                                    ((!fechain.equals("") && !fechaout.equals(""))?"AND ":"") +
                                    ((!fechaout.equals(""))?"fecha_publicacion <= '" + fechaout + "' ":"") +
                                    " AND EST.estado_apli = 'a' ORDER BY OFER.fecha_publicacion");

        /*if (fechain.equals("") || fechaout.equals("")) {
  
            return bDatos.getRegistros("select cargo, razon_social, nit" + sentencia + " from "
                    + " uge.empresa_egre, uge.ofertas_egre where uge.empresa_egre.id_empresa=uge.ofertas_egre.id_empresa");

        } else {
            return bDatos.getRegistros("select cargo, razon_social, nit" + sentencia + " from "
                    + " uge.empresa_egre, uge.ofertas_egre where uge.empresa_egre.id_empresa=uge.ofertas_egre.id_empresa and"
                    + " fecha_publicacion>='" + fechain + "' and  fecha_publicacion<='" + fechaout + "'");
        }*/
    }

    @Override
    public HashMap[] getReporteApliG(String programa, String fechain, String fechaout) throws Exception {
        if (fechain.equals("") || fechaout.equals("")) {
            return bDatos.getRegistros("select ES.nom_est, PER.SEX as sexo ,OT.area_oferta, cargo,razon_social,nit, " +
"                     men_admin estado, fecha_apli from uge.aplicaciones_egre AP " +
"                     inner join uge.estados_apli_ofer EO on EO.estado_apli= AP.estado_apli " +
"                     inner join uge.ofertas_egre   OT ON AP.id_oferta = OT.id_oferta " +
"                     inner join uge.empresa_egre EP on EP.id_empresa=OT.id_empresa " +
"                     inner join uge.datos_egre ES on ES.id_documento=AP.id_documento" +
"                       inner join uge.ps_ec_ib_intp_vw PER on PER.EMPLID=AP.id_documento");
        } else {
            return bDatos.getRegistros("select ES.nom_est, PER.SEX as sexo ,OT.area_oferta, cargo,razon_social,nit, " +
"                     men_admin estado, fecha_apli from uge.aplicaciones_egre AP " +
"                     inner join uge.estados_apli_ofer EO on EO.estado_apli= AP.estado_apli " +
"                     inner join uge.ofertas_egre   OT ON AP.id_oferta = OT.id_oferta " +
"                     inner join uge.empresa_egre EP on EP.id_empresa=OT.id_empresa " +
"                     inner join uge.datos_egre ES on ES.id_documento=AP.id_documento" +
"                       inner join uge.ps_ec_ib_intp_vw PER on PER.EMPLID=AP.id_documento where AP.fecha_apli >='" + fechain + "' and "
                    + "AP.fecha_apli <='" + fechaout + "' ");
        }

    }
    
    @Override
    public HashMap[] getReporteApliP() throws Exception {
        return bDatos.getRegistros( "SELECT  EMP.id_empresa,  " +
"                                            UPPER(EMP.razon_social) razon_social,  " +
"                                            UPPER(OFER.cargo) cargo,  " +
"                                            E.EMPLID as id_est,  " +
"                                            UPPER(E.LAST_NAME+' '+E.SECOND_LAST_NAME+' '+E.FIRST_NAME+' '+E.MIDDLE_NAME) nom_est,  " +
"                                            UPPER((select DESCRIPCION from uge.homol_progs_campus PROG where PROG.ACAD_PROG=E.ACAD_PROG)) nom_prog,  " +
"                                            ISNULL(EST.men_admin, '') men_admin,  " +
"                                            CONVERT(VARCHAR(10), fecha_apli, 103) fec_apli  " +
"                                    FROM uge.aplicaciones_prac APLI  " +
"                                        INNER JOIN uge.ofertas_prac OFER ON OFER.id_oferta = APLI.id_oferta  " +
"                                        INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa  " +
"                                        INNER JOIN uge.ps_ec_ib_intp_vw E ON E.EMPLID = APLI.id_documento   " +
"                                        INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = APLI.estado_apli  " +
"                                    ORDER BY fecha_apli DESC");
    }
    
    @Override
    public HashMap[] getReporteSolP() throws Exception {
        return bDatos.getRegistros(   "SELECT  CONVERT(VARCHAR(10), fecha_sol, 103) fec_sol,  " +
"                                              '' fec_aprob,  " +
"                                              E.EMPLID id_est,  " +
"                                              UPPER(E.LAST_NAME+' '+E.SECOND_LAST_NAME+' '+E.FIRST_NAME+' '+E.MIDDLE_NAME) nom_est,  " +
"                                              UPPER((select DESCRIPCION from uge.homol_progs_campus PROG where PROG.ACAD_PROG=SOL.ACAD_PROG)) nom_prog,  " +
"                                              E.[USER] + '@mail.escuelaing.edu.co' correo,  " +
"                                              ISNULL(DP.email2, '') correo2,  " +
"                                              E.PHONE tel,  " +
"                                              ISNULL(DP.tel2, '') tel2,  " +
"                                              ISNULL(DP.cel, '') cel,  " +
"                                              UPPER(EST.men_solprac) estado,  " +
"                                              SOL.observaciones comentarios  " +
"                                      FROM uge.solicitud_prac SOL  " +
"                                          INNER JOIN uge.ps_ec_ib_intp_vw E ON E.EMPLID = SOL.id_documento  " +
"                                          INNER JOIN uge.datos_prac DP ON DP.id_documento = SOL.id_documento  " +
"                                          INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = SOL.estado  WHERE fecha_sol > '2015-01-01' " +
"                                      ORDER BY fecha_sol DESC");
    }
     
    @Override
    public HashMap[] getReporteOferP() throws Exception {
        return bDatos.getRegistros( "SELECT  OFER.id_oferta, " +
                                            "EMP.nit, " +
                                            "UPPER(EMP.razon_social) razon_social, " +
                                            "REPLACE(REPLACE(REPLACE(UPPER(OFER.cargo), CHAR(9), ''), CHAR(10), ''), CHAR(13), '') cargo, " +
                                            "UPPER(ISNULL(OFER.sector_oferta, '')) sector_oferta, " +
                                            "REPLACE(REPLACE(REPLACE(UPPER(OFER.tipo_contrato), CHAR(9), ''), CHAR(10), ''), CHAR(13), '') tipo_contrato, " +
                                            "CONVERT(VARCHAR(10), OFER.fecha_in, 103) f_in, " +
                                            "CONVERT(VARCHAR(10), OFER.fecha_out, 103) f_out, " +
                                            "REQ.programa_requerido prog_acad, " +
                                            "REPLACE(UPPER(EST.men_oferprac), 'PENDIENTE DE REVISIÓN POR PARTE DEL DECANO ', 'APROBADO POR LA UGE') estado_uge, " +
                                            "UPPER(EST_REQ.men_oferprac) estado_dec, " +
                                            "CONVERT(VARCHAR(10), OFER.fecha_publicacion, 103) f_publicacion, " +
                                            "CONVERT(VARCHAR(10), OFER.fecha_limite, 103) f_limite " +
                                    "FROM uge.ofertas_prac OFER " +
                                        "INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa " +
                                        "INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = OFER.estado " +
                                        "INNER JOIN uge.requerimientos_prac REQ ON REQ.id_oferta = OFER.id_oferta " +
                                        "INNER JOIN uge.estados_apli_ofer EST_REQ ON EST_REQ.estado_apli = REQ.estado" +
                                    " ORDER BY OFER.fecha_publicacion DESC");
    }
    
    @Override
    public HashMap[] getReporteContratP() throws Exception {
        return bDatos.getRegistros( "SELECT  E.EMPLID as id_est,  " +
"                                            UPPER(E.LAST_NAME+' '+E.SECOND_LAST_NAME+' '+E.FIRST_NAME+' '+E.MIDDLE_NAME) nom_est,  " +
"                                            E.NATIONAL_ID as doc_est,  " +
"                                            UPPER((select DESCRIPCION from uge.homol_progs_campus PROG where PROG.ACAD_PROG=SOL.ACAD_PROG)) nom_prog,  " +
"                                            REPLACE(DP.tel2, 'null', '') tel,  " +
"                                            REPLACE(DP.cel, 'null', '') cel,  " +
"                                            E.[USER] + '@mail.escuelaing.edu.co' correo,  " +
"                                            REPLACE(DP.email2, 'null', '') correo2,  " +
"                                            CONVERT(VARCHAR(10), SOL.fecha_sol, 103) f_sol,  " +
"                                            UPPER(ISNULL(EMP.razon_social, '')) razon_social,  " +
"                                            ISNULL(CONVERT(VARCHAR(10), OFER.fecha_in, 103), '') f_in,  " +
"                                            ISNULL(CONVERT(VARCHAR(10), OFER.fecha_out, 103), '') f_out,  " +
"                                            UPPER(ISNULL(EMP.nom_rrhh, '')) nom_rrhh,  " +
"                                            ISNULL(EMP.tel_rrhh, '') tel_rrhh,  " +
"                                            ISNULL(EMP.email_rrhh, '') correo_rrhh,  " +
"                                            UPPER(ISNULL(OFER.nom_jefe, '')) nom_jefe,  " +
"                                            UPPER(ISNULL(OFER.cargo_jefe, '')) cargo_jefe,  " +
"                                            ISNULL(OFER.tel_jefe, '') tel_jefe,  " +
"                                            ISNULL(OFER.email_jefe, '') email_jefe  " +
"                                    FROM uge.solicitud_prac SOL  " +
"                                        INNER JOIN uge.ps_ec_ib_intp_vw E ON E.EMPLID = SOL.id_documento  " +
"                                        INNER JOIN uge.datos_prac DP ON DP.id_est = SOL.id_documento  " +
"                                        LEFT JOIN uge.aplicaciones_prac APL ON (APL.id_documento = SOL.id_documento AND (APL.estado_apli = 'h' OR APL.estado_apli = 'j'))  " +
"                                        LEFT JOIN uge.ofertas_prac OFER ON OFER.id_oferta = APL.id_oferta  " +
"                                        LEFT JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa  " +
"                                    WHERE SOL.estado = 'c'  " +
"                                    ORDER BY SOL.fecha_sol DESC, nom_est");
    }
    
    @Override
    public HashMap[] getReporteTutoresP() throws Exception {
        return bDatos.getRegistros( "SELECT  E.EMPLID as id_est,  " +
"                                            UPPER(E.LAST_NAME+' '+E.SECOND_LAST_NAME+' '+E.FIRST_NAME+' '+E.MIDDLE_NAME) nom_est,  " +
"                                            UPPER((select DESCRIPCION from uge.homol_progs_campus PROG where PROG.ACAD_PROG=SOL.ACAD_PROG)) nom_prog,  " +
"                                            CONVERT(VARCHAR(10), SOL.fecha_sol, 103) f_sol,  " +
"                                            UPPER(OFER.cargo) cargo,  " +
"                                            UPPER(EMP.razon_social) razon_social,  " +
"                                            CASE APL.estado_apli  " +
"                                                WHEN 'h' THEN 'No asignado'  " +
"                                                ELSE UPPER(ISNULL(PROF.LAST_NAME+' '+PROF.SECOND_LAST_NAME+' '+PROF.FIRST_NAME+' '+PROF.MIDDLE_NAME, ''))  " +
"                                            END tutor,  " +
"                                            ISNULL(PROF.EMAIL_ADDR, '') email_tutor  " +
"                                    FROM uge.solicitud_prac SOL  " +
"                                        INNER JOIN uge.ps_ec_ib_intp_vw E ON E.EMPLID = SOL.id_documento  " +
"                                        INNER JOIN uge.aplicaciones_prac APL ON (APL.id_documento = SOL.id_documento AND APL.estado_apli IN ('h', 'j'))  " +
"                                        INNER JOIN uge.ofertas_prac OFER ON OFER.id_oferta = APL.id_oferta  " +
"                                        INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa  " +
"                                        LEFT JOIN uge.ps_ec_ib_intp_vw PROF ON PROF.EMPLID = APL.id_tutor  " +
"                                    WHERE SOL.estado = 'c' and SOL.sol_serv_ps is not null " +
"                                    ORDER BY SOL.fecha_sol DESC");
    }
    
    @Override
    public HashMap[] getReporteEmpresas() throws Exception {
        return bDatos.getRegistros( "SELECT  id_empresa, " +
                                            "nit, " +
                                            "UPPER(razon_social) razon_social, " +
                                            "UPPER(dir_empresa) dir_empresa, " +
                                            "UPPER(ciudad_empresa) ciudad_empresa, " +
                                            "UPPER(pais_empresa) pais_empresa, " +
                                            "web_empresa, " +
                                            "email_empresa, " +
                                            "tel_empresa, " +
                                            "CASE  " +
                                                "WHEN fecha_reg IS NULL THEN 'Indefinida' " +
                                                "ELSE CONVERT(VARCHAR(10), fecha_reg, 103) " +
                                            "END f_reg " +
                                    "FROM uge.empresa_egre " +
                                    "ORDER BY fecha_reg DESC");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public HashMap[] getSolicitudesPrac() throws Exception {
        return bDatos.getRegistros("select id_documento from uge.solicitud_prac where sol_serv_ps is not null");
    }
    
    @Override
    public HashMap[] getSolicitudesPracPendientesActInfo() throws Exception {
        return bDatos.getRegistros("select id_documento from uge.solicitud_prac where sol_serv_ps is not null and id_documento not in (select EMPLID from uge.ps_ec_ib_intp_vw)");
    }

    @Override
    public HashMap[] getSolicitudesMov() throws Exception {
        return bDatos.getRegistros("select id_est from uge.solicitud_mov where sol_serv_ps is not null and LTRIM(RTRIM(estado))  in ('c','d','e','f','g','h','i','j','k','r')");
    }
    
    @Override
    public Boolean getInfoEstCache(String emplid) throws Exception{
        return !bDatos.getRegistro("select EMPLID from uge.ps_ec_ib_intp_vw where EMPLID='"+emplid+"'").isEmpty();
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
    public HashMap[] getListaEstDocPrac() throws Exception {
        return bDatos.getRegistros("select id_sol, LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est " +
                                    "from UGE.ps_ec_ib_intp_vw, uge.solicitud_prac " +
                                    "where uge.solicitud_prac.id_documento=EMPLID " +
                                    " and (uge.solicitud_prac.ComPraPro = 'Car' or uge.solicitud_prac.CarAce = 'Car' or uge.solicitud_prac.ConPra = 'Car' or uge.solicitud_prac.AutAsi = 'Car' or uge.solicitud_prac.ComPraPro = 'RechDoc' or uge.solicitud_prac.CarAce = 'RechDoc' or uge.solicitud_prac.ConPra = 'RechDoc' or uge.solicitud_prac.AutAsi = 'RechDoc' or uge.solicitud_prac.ComPraPro = 'NULL' or uge.solicitud_prac.CarAce = 'NULL' or uge.solicitud_prac.ConPra = 'NULL' or uge.solicitud_prac.AutAsi = 'NULL') " +
                                    " and (uge.solicitud_prac.estado = 'k' or uge.solicitud_prac.estado = 'd' or uge.solicitud_prac.estado = 'c') " +
                                    "order by nom_est desc");
    }   
}
