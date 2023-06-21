/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDsige;

import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.HashMap;
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
public class Empresa extends Persona implements SessionBean, EmpresaRemote {
    private PersistenciaOracle bDatosOracle= new PersistenciaOracle();
    String nit;
   private SessionContext context;

    public Empresa() {
    }
    public Empresa(String nit) {
        this.nit=nit;
    }

    @Override
     public String getNit() {
        return nit;
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
     public int eliminarContEmp(String idcont) throws Exception{
      return bDatos.actualizar("delete from uge.contactos_emp_sige where id_contacto ="+ idcont);
    }
    @Override
    public HashMap  getRegistroemp(String nit) throws Exception{
        return bDatos.getRegistro("if not exists(select nit from uge.empresa_egre where  nit ='"+ nit
                + "') BEGIN select '1' as existe END ELSE select '0' as existe");

    }
    @Override
    public int Registrarempresa(String nit,String rasocial,String paisemp,String ciudademp,String diremp,String webemp,String emailemp,
                        String telemp,String nomconte,String cargoconte,String areaconte,String porfconte,String telconte,
                        String faxconte,String emailconte,String celconte,String passemp,String nomrrhh,String telrrhh,String emailrrhh,String tipoid) throws ConsultaException{

        HashMap dato;
        String id_emp;
        dato = bDatos.getRegistro("select max(id_empresa) + 1 id from uge.empresa_egre");
        id_emp = (String) dato.get("id");

        return bDatos.actualizar("insert into uge.empresa_egre "
                + "( id_empresa,nit, razon_social, dir_empresa, ciudad_empresa, pais_empresa, web_empresa, email_empresa, tel_empresa,"
                + "nom_rrhh,tel_rrhh,email_rrhh, "
                + " nom_contacto, profesion_contacto, cargo_contacto, area_contacto, tel_contacto, fax_contacto, email_contacto, cel_contacto"
                + ", estado_empresa, pass_empresa, fecha_reg,rut, tipoid, aprobada_uge) values ('"+ id_emp+"',"
                + "'" + nit + "'," + "'"+rasocial+"'" + ",'" + diremp+ "'," + "'" + ciudademp+"',"+ "'" + paisemp + "',"+ "'" + webemp + "',"
                + "'" + emailemp + "',"+ "'" + telemp + "',"+ "'"+nomrrhh+"','"+telrrhh+"','"+emailrrhh+"',"+"'" + nomconte + "',"+ "'" + porfconte + "',"+ "'" + cargoconte + "',"+ "'"
                + areaconte + "',"+ "'" + telconte + "',"+ "'" + faxconte + "',"+ "'" + emailconte + "',"+ "'" + celconte + "','grad_prac',"+ "'"
                + passemp + "', getdate(),'cargado',"+tipoid+", '0')");

    }
    @Override
    public HashMap datosGeneralesemp(String usuario) throws Exception{
         return bDatos.getRegistro("select isnull(id_empresa,'')id_empresa,isnull(nit,'')nit,isnull(razon_social,'')razon_social,isnull(dir_empresa,'')dir_empresa,isnull"
                 + "(ciudad_empresa,'')ciudad_empresa,isnull(pais_empresa,'')pais_empresa,isnull(web_empresa,'')"
                 + "web_empresa,isnull(email_empresa,'')email_empresa,isnull(tel_empresa,'')tel_empresa,isnull(nom_rrhh,'')nom_rrhh,isnull(tel_rrhh,'')"
                 + "tel_rrhh,isnull(email_rrhh,'')email_rrhh,isnull(nom_contacto,'')nom_contacto,isnull(profesion_contacto,'')profesion_contacto,isnull(cargo_contacto,'')"
                 + "cargo_contacto,isnull(area_contacto,'')area_contacto,isnull(tel_contacto,'')tel_contacto,isnull(fax_contacto,'')fax_contacto,isnull(email_contacto,'')email_contacto,"
                 + "isnull(cel_contacto,'')cel_contacto,isnull(estado_empresa,'')estado_empresa,isnull(pass_empresa,'')pass_empresa,isnull(fecha_reg,'')fecha_reg,isnull(tipoid,'')tipoid, isnull(aprobada_uge, '0')aprobada_uge" +
"  from uge.empresa_egre where nit='"+ usuario +"'");
    }
    @Override
    public HashMap datosContactoemp(String usuario) throws Exception{
        return bDatos.getRegistro("select * from uge.contactos_emp_sige where id_contacto='"+usuario+"'");
    }
    @Override
    public HashMap infoContactoemp(String Contacto, String usuario) throws Exception{
    return bDatos.getRegistro("select * from uge.contactos_emp_sige where doc_contacto='" + Contacto + "' and nit='" + usuario + "'");
}
    @Override
    public int  ActDatempresa(String nit,String rasocial,String paisemp,String ciudademp,String diremp,String webemp,String emailemp,
                        String telemp,String nomconte,String cargoconte,String areaconte,String porfconte,String telconte,
                        String faxconte,String emailconte,String celconte,String passemp,String nomrrhh,String telrrhh,String emailrrhh, String tipoid)throws Exception{

                
              return bDatos.actualizar("Update uge.empresa_egre set "
                + "razon_social='"+rasocial+"',dir_empresa='"+diremp+"',ciudad_empresa='"+ciudademp+"',pais_empresa='"+paisemp+"'"
                + ",web_empresa='"+webemp+"', email_empresa='"+emailemp+"', tel_empresa='"+telemp+"',nom_rrhh='"+nomrrhh+"',tel_rrhh='"
                + telrrhh +"',email_rrhh='"+emailrrhh+"',nom_contacto='"+nomconte+"', "
                + "profesion_contacto='"+porfconte+"', cargo_contacto='"+cargoconte+"', area_contacto='"+areaconte+"', "
                + "tel_contacto='"+telconte+"', fax_contacto='"+faxconte+"', email_contacto='"+emailconte+"', cel_contacto='"+celconte
                + "', tipoid = "+tipoid+" where nit='"+nit+"'");
    }
    
    @Override
    public int ActDatempresaDesdeCampus(String nit, String rasocial, String paisemp, String ciudademp, String diremp, String webemp, String emailemp, String telemp, String telconte, String faxconte, String emailconte, String celconte, String nomrrhh, String telrrhh, String emailrrhh, String tipoid) throws Exception {
        return bDatos.actualizar("Update uge.empresa_egre set "
                + "razon_social='"+rasocial+"',dir_empresa='"+diremp+"',ciudad_empresa='"+ciudademp+"',pais_empresa='"+paisemp+"'"
                + ",web_empresa='"+webemp+"', email_empresa='"+emailemp+"', tel_empresa='"+telemp+"',nom_rrhh='"+nomrrhh+"',tel_rrhh='"
                + telrrhh +"',email_rrhh='"+emailrrhh+"', "
                + "tel_contacto='"+telconte+"', fax_contacto='"+faxconte+"', email_contacto='"+emailconte+"', cel_contacto='"+celconte
                + "', tipoid = "+tipoid+" where nit='"+nit+"'");
    }
    
    @Override            
    public int  ReiniciarPassEmp(String nit)throws Exception{
     return bDatos.actualizar("Update uge.empresa_egre set "
                + "pass_empresa='"+nit
                + "' where nit='"+nit+"'");
    }
    @Override
    public int RegistrarContEmp(String nit,String rasocial,String nomconte,String cargoconte, String areaconte,
                    String porfconte,String telconte,String emailconte,String celconte,String SistemaSolicitado,String doc_cont) throws Exception{
        HashMap dato;
        String id_cont;
        dato = bDatos.getRegistro("select max(id_contacto) + 1 id from uge.contactos_emp_sige");
        id_cont = (String) dato.get("id");

        return bDatos.actualizar("insert into uge.contactos_emp_sige "
                + "(id_contacto, nit, nom_contacto,profesion_contacto, cargo_contacto, area_contacto, tel_contacto, email_contacto,"
                + "cel_contacto,sistema_contacto,doc_contacto) values ("+ "'" + id_cont + "',"
                + "'" + nit + "'," + "'"+nomconte+"'" + ",'" + porfconte+ "'," + "'" + cargoconte+"',"+ "'" + areaconte + "',"+ "'" + telconte + "',"
                + "'" + emailconte + "',"+ "'" + celconte + "',"+ "'"+SistemaSolicitado+"','"+doc_cont+"')");

    }
    @Override
    public int Actpassemp(String pswantiguo,String pswnuevo,String idemp) throws Exception{
         return bDatos.actualizar("Update uge.empresa_egre set pass_empresa="+"'" + pswnuevo+ "'"+ " where nit='"+ idemp+"' and pass_empresa='"+pswantiguo+"'");
    }
    @Override
    public int ActEstApliGrad(String estadoapligrad, String id_apli) throws Exception {
        return bDatos.actualizar(   "UPDATE uge.aplicaciones_egre " +
                                    "SET estado_apli = '" + estadoapligrad + "' " +
                                    "WHERE   id_aplicacion = '" + id_apli + "'");
    }
    @Override
    public int ActEstApliPrac(String estadoapligrad,String id_apli, String id_est) throws Exception{
        int ban=0;
        if(!estadoapligrad.equals("h")){
         return bDatos.actualizar("Update uge.aplicaciones_prac set estado_apli='"+estadoapligrad+"' where id_aplicacion ="+id_apli
                    + " and estado_apli != 'c' and estado_apli != 'e' and estado_apli != 'g'and estado_apli != 'h' and estado_apli != 'i'");
        }
        else{
                ban=  bDatos.actualizar("Update uge.aplicaciones_prac set estado_apli='"+estadoapligrad+"' where id_aplicacion ="+id_apli
                    + " and estado_apli != 'c' and estado_apli != 'e' and estado_apli != 'g'and estado_apli != 'h'");

                
                if(ban!=0){
                    try{
                        return bDatos.actualizar("Update uge.aplicaciones_prac set estado_apli='i' where id_aplicacion !="+id_apli
                    + " and id_documento="+id_est+" and estado_apli != 'c' and estado_apli != 'e' and estado_apli != 'g'and estado_apli != 'h'");
                    }catch(Exception e){
                        if(e.getMessage().equals("Error no Definido. Cero filas afectadas.")){
                            return 1;
                        }else{
                            throw new ConsultaException(e.getMessage());
                        }
                    }
                        
                }
                else
                {
                    return ban;
                }
        }
    }
    @Override
   public int RegofertaGrad(String nit,String cont, String nomcargonog,String descripcionnog,String Requisitosnog, String idiomReqG, String paisnog,String[] ciudadnog,
           String areanog,String salarionog,String fechaoutnog,String horarionog,String contratonog,String añosexpnog,String programas[], String vacantes, String teletrabajo,
           String discapacidad, String excepcionpub, String[] estrequeridos)throws Exception{

        HashMap dato,dato2;
        String id_ofer, id_emp, id_req,id_cont;
        int numprog,ban, ban1=0, ban2=0, ban3=0,numest,numciudad;
        
        dato = bDatos.getRegistro("select max(id_oferta) + 1 id from uge.ofertas_egre");
        id_ofer = (String) dato.get("id");
        
        dato=bDatos.getRegistro("select id_empresa from uge.empresa_egre where nit='"+nit+"'");
        id_emp=(String)dato.get("id_empresa");
        
        dato2=bDatos.getRegistro("select id_contacto from uge.contactos_emp_sige where doc_contacto='"+cont+"' and nit='"+nit+"'");
        id_cont=(String)dato2.get("id_contacto");
        if (id_cont== null){
            id_cont="0";
        }
        
        String[] fechaOutParts = fechaoutnog.split("/");
        Calendar fechaOutCalendar = Calendar.getInstance();
        Calendar varDate = Calendar.getInstance();
        fechaOutCalendar.set(Integer.parseInt(fechaOutParts[2]), Integer.parseInt(fechaOutParts[1]), Integer.parseInt(fechaOutParts[0]));
        varDate.setTimeInMillis(fechaOutCalendar.getTimeInMillis()-varDate.getTimeInMillis());
        
        if ((varDate.get(Calendar.YEAR)-1970) < 1 && varDate.get(Calendar.MONTH) <= 3) {
            
            //Convertir formato fecha
            String fecTemp = fechaoutnog.substring(6, 10)+"/"+fechaoutnog.substring(3, 5)+"/"+fechaoutnog.substring(0, 2);
            fechaoutnog=fecTemp;
            
            ban= bDatos.actualizar("insert into uge.ofertas_egre(id_oferta, cargo, descripcion, requisitos, idiomas, pais_oferta, "
                + "ciudad_oferta, area_oferta, salario_oferta, fecha_publicacion, fecha_limite, horario_oferta, tipo_contrato, "
                + "años_exp, id_empresa, id_contacto,estado, vacantes, teletrabajo, discapacidad, excepcionpub) values('"+id_ofer+"','"+nomcargonog+"','"+descripcionnog+"','"+Requisitosnog+"','"+idiomReqG+"','"+paisnog
                +"','"+ciudadnog+"','"+areanog + "','"+salarionog+"',getdate(),'"+fechaoutnog+"','"+horarionog+"','"+contratonog+"','"
                +añosexpnog+"','"+id_emp+"','"+id_cont+"','k',"+vacantes+","+teletrabajo+","+discapacidad+",'"+excepcionpub+"')");
            
            numprog=(int)programas.length;
            numest=(int)estrequeridos.length;
            numciudad=(int)ciudadnog.length;
            
            for(int i=0; i < numprog; i++){
                 dato = bDatos.getRegistro("select max(id_req) + 1 id from uge.requerimientos_egre");
                 id_req = (String)dato.get("id");
                 
                 ban1 = bDatos.actualizar("insert into uge.requerimientos_egre( id_oferta, programa_requerido) values('" + id_ofer + "','" + programas[i] + "')");
            }
            
            for(int i=0; i < numest; i++){
                 String nombre="";
                 if(estrequeridos[i].equals("6")){nombre = "Universitario";}
                 if(estrequeridos[i].equals("7")){nombre = "Especialización";}
                 if(estrequeridos[i].equals("8")){nombre = "Maestría";}
                 
                 ban3 = bDatos.actualizar("insert into uge.estudiosreq_oferta( id_oferta, codigo, nombre) values(" + id_ofer + "," + estrequeridos[i] + ",'"+nombre+"')");
            }
            
            String Noms = "";
            
             for(int i=0; i < numciudad; i++){
                 String nombre=""; 
                 dato = bDatos.getRegistro("Select MuniDepto from registro.uge.MunicipiosDANE Where CodigoDANE = "+ciudadnog[i]);
                 nombre = dato.get("MuniDepto").toString();
                 Noms = Noms + nombre + " | ";
                 ban1 = bDatos.actualizar("insert into uge.muni_oferta( id_oferta, codigo, nombre) values(" + id_ofer + "," + ciudadnog[i] + ",'"+nombre+"')");    
            }
            
             ban2 = bDatos.actualizar("Update uge.ofertas_egre set ciudad_oferta = '"+Noms+"' Where id_oferta = "+id_ofer+"");    
             

            
            if(ban == 1 && ban1 == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
        
        
        
        
       
    }
    @Override
   public int RegOfertaPrac(String nit,String nomcargonop,String descripcionnop,String Requisitosnop,String paisnop,String ciudadnop,
           String areanop,String sectornop,String salarionop,String fechaoutnop,String fechainprac,String fechaoutprac,String horarionop,String contratonop,
           String seguros_arp,String nom_jefe,String cargo_jefe,String tel_jefe,String email_jefe,String programas[],String cont, String tiprac, Boolean permite_duplicacion)throws Exception{

        HashMap dato,dato2;
        String id_ofer, id_emp, id_req,id_cont;
        int numprog=0,ban=1 , ban1=1;
        
        
        
        dato = bDatos.getRegistro("select max(id_oferta) + 1 id from uge.ofertas_prac");
        id_ofer = (String) dato.get("id");
        
        dato=bDatos.getRegistro("select id_empresa from uge.empresa_egre where nit='"+nit+"'");
        id_emp=(String)dato.get("id_empresa");
        
        Boolean duplicada = bDatos.getRegistros("select id_oferta from uge.ofertas_prac where id_empresa='"+id_emp+"' and cargo='"+nomcargonop+"' and fecha_limite >= getdate()").length>0;
        
        dato2=bDatos.getRegistro("select id_contacto from uge.contactos_emp_sige where doc_contacto='"+cont+"' and nit='"+nit+"'");
        id_cont=(String)dato2.get("id_contacto");
        if(!duplicada || (duplicada&&permite_duplicacion)){
            if(id_cont== null){
                id_cont="0";
            }
            numprog=(int)programas.length;
            for(int i=0;i<numprog && ban1>0;i++){
                 dato=bDatos.getRegistro("select max(id_req) + 1 id from uge.requerimientos_prac");
                 id_req=(String)dato.get("id");
                 String req_repetido=bDatos.getRegistro("select count(id_req) cant from uge.requerimientos_prac where id_oferta='"+id_ofer+"' and programa_requerido='"+programas[i]+"'").get("cant").toString();
                 if(req_repetido.equals("0")){
                     ban1=bDatos.actualizar("insert into uge.requerimientos_prac(id_req, id_oferta, programa_requerido,estado)values('"+id_req+"','"
                         +id_ofer+"','"+programas[i]+"','a')");
                 }else{
                     ban1=1;
                 }
                 
            }
            if(ban1>0){
                ban= bDatos.actualizar("insert into uge.ofertas_prac(id_oferta, cargo, descripcion, requisitos, pais_oferta, "
                    + "ciudad_oferta, area_oferta, sector_oferta, salario_oferta, fecha_publicacion, fecha_limite, fecha_in, fecha_out, "
                    + "horario_oferta, tipo_contrato, id_empresa, seguro_arp, nom_jefe, cargo_jefe, tel_jefe, email_jefe, estado,id_contacto, tiprac"
                    + ") values('"+id_ofer+"','"+nomcargonop+"','"+descripcionnop+"','"+Requisitosnop+"','"+paisnop
                    +"','"+ciudadnop+"','"+ areanop + "','"+ sectornop + "','"+salarionop+"',getdate(), '"+fechaoutnop+"' , '"+fechainprac+"' , '"+fechaoutprac+"' ,'"
                    + horarionop+"','"+contratonop+"','"+id_emp+"','"+seguros_arp+"','"+nom_jefe+"','"+cargo_jefe+"','"+tel_jefe+"','"+email_jefe
                    +"','k','"+id_cont+"', '"+tiprac+"')");
            }else{
                ban=0;
            }
            
            if(ban>0 && ban1>0){
                return 1;
            }
            else{
                return 0;
            }
        }else{
            return -1;
        }
        
        
        

    }
    @Override
    public HashMap[] getListaProgramas() throws Exception{
        return bDatos.getRegistros( "SELECT id_prog, "
                                            + "id_dpto, "
                                            + "nom_prog, "
                                            + "tip_prog "
                                    + "FROM registro.programas "
                                    + "WHERE tip_prog != 2 "
                                    + "ORDER BY tip_prog, nom_prog");
        //return bDatos.getRegistros("SELECT id_prog, id_dpto, nom_prog from registro.programas ORDER BY nom_prog");
    }
    @Override
    public HashMap[]getListaProgramasPregrado() throws Exception{
    return bDatos.getRegistros("select id_prog, id_dpto, nom_prog from  registro.programas where tip_prog='1' and id_prog<>'285' ORDER BY nom_prog");
}
    @Override
    public HashMap[] getFechasPracticas() throws Exception{
    return bDatos.getRegistros("select id_fecha, nombre,CAST(CONVERT(NVARCHAR, fecha, 112) AS DATE) fecha, descripcion from  uge.fechas_sige where id_fecha >= '1' and id_fecha <= '11'   ORDER BY id_fecha");
    }
     @Override
    public HashMap[] getFechasPracticasEmp() throws Exception{
    return bDatos.getRegistros("select id_fecha, nombre,YEAR(fecha)year,MONTH(fecha)mes,day(fecha)dia, CAST(CONVERT(NVARCHAR, fecha, 112) AS DATE) fecha from  uge.fechas_sige where id_fecha >= '3' and id_fecha <= '8'   ORDER BY id_fecha");
    }
    @Override
    public HashMap []getpaises() throws Exception{
       return bDatos.getRegistros("select cod_iso as cod_pai, nom_pais as nom_pai from uge.paises order by nom_pai");
   }
    @Override
    public HashMap []getciudades() throws Exception{
       return bDatos.getRegistros("select cod_dane as cod_ciu, nom_ciudad as nom_ciu, pais from uge.ciudades order by nom_ciu");
   }
    @Override
    public HashMap[]getListaOferEmp(String idemp, String consulta) throws Exception{
    if(consulta.equals("Todas las ofertas")){
        return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_egre where id_empresa=(select "
                + "id_empresa from uge.empresa_egre where nit='"+idemp+"') order by fecha_limite");
    }
    else{
        if(consulta.equals("Ofertas vigentes")){
            return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_egre where id_empresa=(select "
                    + "id_empresa from uge.empresa_egre where nit='"+idemp+"') and fecha_limite >= getdate() order by fecha_limite");
        }
        else{
            return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_egre where id_empresa=(select "
                    + "id_empresa from uge.empresa_egre where nit='"+idemp+"') and fecha_limite < getdate() order by fecha_limite");
        }
    }

}
    @Override
  public HashMap[]getListaOferEmpCont(String idemp, String nitEmp, String consulta) throws Exception{
  
     if(consulta.equals("Todas las ofertas")){
        return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_egre where id_contacto=(select " +
                " id_contacto from uge.contactos_emp_sige where doc_contacto='"+idemp+"' and nit='" + nitEmp + "') order by fecha_limite");
    }
    else{
        if(consulta.equals("Ofertas vigentes")){
            return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_egre where id_contacto=(select " +
                " id_contacto from uge.contactos_emp_sige where doc_contacto='"+idemp+"' and nit='" + nitEmp + "') and fecha_limite >= getdate() order by fecha_limite");
        }
        else{
            return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_egre where id_contacto=(select " +
                " id_contacto from uge.contactos_emp_sige where doc_contacto='"+idemp+"' and nit='" + nitEmp + "') and fecha_limite < getdate() order by fecha_limite");
        }
    }

  }
        @Override
    public HashMap[]getListaOferPracEmpCont(String idemp, String nitEmp, String consulta) throws Exception{
    if(consulta.equals("Todas las ofertas")){
        return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_prac where id_contacto=(select "
                + "id_contacto from uge.contactos_emp_sige where doc_contacto='"+idemp+"' and nit='" + nitEmp + "') order by fecha_limite");
    }
    else{
        if(consulta.equals("Ofertas vigentes")){
            return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_prac where id_contacto=(select "
                    + "id_contacto from uge.contactos_emp_sige where doc_contacto='"+idemp+"' and nit='" + nitEmp + "') and fecha_limite >= getdate() order by fecha_limite");
        }
        else{
            return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_prac where id_contacto=(select "
                    + "id_contacto from uge.contactos_emp_sige where doc_contacto='"+idemp+"' and nit='" + nitEmp + "') and fecha_limite < getdate() order by fecha_limite");
        }
    }
}
    @Override
    public HashMap[]getListaContEmp(String idemp) throws Exception{
    return bDatos.getRegistros("select id_contacto,nom_contacto, cargo_contacto from uge.contactos_emp_sige where nit='"+ idemp+"'");
}
    @Override
    public HashMap[]getListaOferPracEmp(String idemp, String consulta) throws Exception{
    if(consulta.equals("Todas las ofertas")){
        return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_prac where id_empresa=(select "
                + "id_empresa from uge.empresa_egre where nit='"+idemp+"') order by fecha_limite");
    }
    else{
        if(consulta.equals("Ofertas vigentes")){
            return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_prac where id_empresa=(select "
                    + "id_empresa from uge.empresa_egre where nit='"+idemp+"') and fecha_limite >= getdate() order by fecha_limite");
        }
        else{
            return bDatos.getRegistros("select id_oferta, cargo, fecha_limite from uge.ofertas_prac where id_empresa=(select "
                    + "id_empresa from uge.empresa_egre where nit='"+idemp+"') and fecha_limite < getdate() order by fecha_limite");
        }
    }
}
    @Override
    public HashMap getDatosOfertaemp(String idoferta) throws Exception{
           return bDatos.getRegistro("select * from uge.ofertas_egre where id_oferta='"+ idoferta+"'");
        }
    @Override
    public HashMap getDatosOfertaempP(String idoferta) throws Exception{
        return bDatos.getRegistro(  "SELECT  id_oferta, " +
                                            "cargo, " +
                                            "descripcion, " +
                                            "funciones, " +
                                            "requisitos, " +
                                            "pais_oferta, " +
                                            "ciudad_oferta, " +
                                            "area_oferta, " +
                                            "salario_oferta, " +
                                            "CONVERT(VARCHAR(10), fecha_publicacion, 103) fecha_publicacion, " +
                                            "CONVERT(VARCHAR(10), fecha_limite, 103) fecha_limite, " +
                                            "CONVERT(VARCHAR(10), fecha_in, 103) fecha_in, " +
                                            "CONVERT(VARCHAR(10), fecha_out, 103) fecha_out, " +
                                            "horario_oferta, " +
                                            "tipo_contrato, " +
                                            "años_exp, " +
                                            "id_empresa, " +
                                            "seguro_arp, " +
                                            "nom_jefe, " +
                                            "cargo_jefe, " +
                                            "tel_jefe, " +
                                            "email_jefe, " +
                                            "estado, " +
                                            "id_contacto, " +
                                            "ISNULL(uge_obs, '') uge_obs, tiprac " +
                                    "FROM uge.ofertas_prac " +
                                    "WHERE id_oferta = '" + idoferta + "'");
         /*return bDatos.getRegistro("select *,Convert(char(10), fecha_in, 103)fecha_in_oferta,Convert(char(10), fecha_out, 103)fecha_out_oferta,Convert(char(10), "
                 + "fecha_limite, 103)fecha_limite_oferta from uge.ofertas_prac where id_oferta='"+ idoferta+"'");*/
}

    @Override
    public HashMap[] getOfertaExclusivaPracEmp(String idoferta) throws Exception{
        return bDatos.getRegistros("Select id_est from registro.uge.oferta_especifica_prac Where id_oferta = '"+ idoferta+"'");
    }
    
    @Override
    public HashMap getDatosOfertaPracEmp(String idoferta) throws Exception{
        return bDatos.getRegistro("select * from uge.ofertas_prac where id_oferta='"+ idoferta+"'");
}

    @Override
 public HashMap[] getProgramasEmp(String idoferta) throws Exception{
            return bDatos.getRegistros("select programa_requerido from uge.requerimientos_egre where id_oferta='"+idoferta+"' order by programa_requerido");

    }
    @Override
  public HashMap[] getProgramasEmpP(String idoferta) throws Exception{
        return bDatos.getRegistros("select R.programa_requerido, men_oferprac, R.comen_dec from uge.estados_apli_ofer EA "
                + "inner join uge.requerimientos_prac R on EA.estado_apli=R.estado where id_oferta='"+idoferta+"'");
  }
    @Override
  public HashMap[] getProgramasPracEmp (String idoferta) throws Exception{
        return bDatos.getRegistros("select programa_requerido, men_oferprac from uge.requerimientos_prac, uge.estados_apli_ofer where id_oferta='"+idoferta+"' and estado= estado_apli");
  }
    @Override
  public HashMap[] getAplicantesOferEmp(String idoferta) throws Exception{
      return bDatos.getRegistros("select id_aplicacion, id_documento, men_usr, LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est from uge.aplicaciones_egre,  " +
                                    "uge.estados_apli_ofer, uge.ps_ec_ib_intp_vw where id_oferta='"+idoferta+"' and uge.aplicaciones_egre.estado_apli= " +
                                    "uge.estados_apli_ofer.estado_apli and id_documento=EMPLID");
      /**ANTES DE CAMPUS
                return bDatos.getRegistros("select id_aplicacion, id_documento, men_usr, nom_est from uge.aplicaciones_egre, "
                        + "uge.estados_apli_ofer, registro.estudiante where id_oferta='"+idoferta+"' and uge.aplicaciones_egre.estado_apli= "
                        + "uge.estados_apli_ofer.estado_apli and id_documento=cast(id_est as varchar)");
                        * 
                        * */
  }
    @Override
  public HashMap[] getAplicantesOferEmpP(String idoferta) throws Exception{
    return bDatos.getRegistros("select id_aplicacion, id_documento, men_usr, LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est from uge.aplicaciones_prac, " +
                                "uge.estados_apli_ofer, uge.ps_ec_ib_intp_vw where id_oferta='"+idoferta+"' and uge.aplicaciones_prac.estado_apli=  " +
                                "uge.estados_apli_ofer.estado_apli and id_documento=EMPLID");
  }
    @Override
   public HashMap[] Contactosemp(String usuario) throws Exception {
        return bDatos.getRegistros("select id_contacto, nom_contacto, sistema_contacto from uge.contactos_emp_sige where nit='"+usuario+"'");
    }
    @Override
  public HashMap[] getAplicantesOferPracEmp(String idoferta) throws Exception{
      return bDatos.getRegistros("select id_aplicacion, id_documento, men_usr, LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est from uge.aplicaciones_prac, " +
"                     uge.estados_apli_ofer, uge.ps_ec_ib_intp_vw where id_oferta='"+idoferta+"' " +
"                     and uge.aplicaciones_prac.estado_apli= uge.estados_apli_ofer.estado_apli and id_documento=EMPLID");
      
      /**ANTES DE CAMPUS
            return bDatos.getRegistros("select id_aplicacion, id_documento, men_usr, nom_est from uge.aplicaciones_prac, "
                    + "uge.estados_apli_ofer, registro.estudiante where id_oferta='"+idoferta+"' "
                    + "and uge.aplicaciones_prac.estado_apli= uge.estados_apli_ofer.estado_apli and id_documento=cast(id_est as varchar)");
                    * */
  }
    @Override
  public HashMap datosContGar(String doc_grad) throws Exception{
      return bDatos.getRegistro("select LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, tel_residencia, dir_residencia, email, cel, ciudad_residencia, " +
"                    perfil from uge.datos_egre, uge.ps_ec_ib_intp_vw where id_documento=EMPLID and EMPLID = '"+doc_grad+"'");
      /**ANTES DE CAMPUS
           return bDatos.getRegistro("select nom_est, tel_residencia, dir_residencia, email, cel, ciudad_residencia, "
                   + "perfil from uge.datos_egre, registro.estudiante where id_documento=cast(id_est as varchar) and id_est = '"+doc_grad+"'");
                   * */
       }
    @Override
  public HashMap[] getExperienciasGrad(String doc_grad) throws Exception {
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
    public HashMap datosContPracEmp(String id_documento) throws Exception{
        
        return bDatos.getRegistro("select LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME as nom_est, PHONE as tel_corr,tel2, ADDRESS1 as dir_corr, EMAIL_ADDR as emails,email2, cel,perfil, referencias, expectativas,  " +
"                    electivas  from uge.datos_prac, uge.ps_ec_ib_intp_vw where id_documento=EMPLID  " +
"                    and EMPLID = '"+id_documento+"'");
        
        /**ANTES DE CAMPUS
           return bDatos.getRegistro("select nom_est, tel_corr,tel2, dir_corr, emails,email2, cel,perfil, referencias, expectativas, "
                   + "electivas  from uge.datos_prac, registro.estudiante where id_documento=cast(registro.estudiante.id_est as varchar) "
                   + "and registro.estudiante.id_est = '"+id_documento+"'"); 
                   * */
    }
    
    @Override
    public HashMap datosCartaPrac(String id_apli) throws Exception{
        return bDatos.getRegistro("SELECT ISNULL(EMP.razon_social, '') razon_social,   " +
"                                            ISNULL(EMP.nit, '') nit,   " +
"                                            ISNULL(EMP.pais_empresa, '') pais_empresa,   " +
"                                            ISNULL(EMP.ciudad_empresa, '') ciudad_empresa,   " +
"                                            ISNULL(EMP.dir_empresa, '') dir_empresa,   " +
"                                            ISNULL(EMP.web_empresa, '') web_empresa,   " +
"                                            ISNULL(DEP.ID_DPTO, '') id_dpto,   " +
"                                            ISNULL(DEP.DESCRIPCION, '') nom_dpto,   " +
"                                            ISNULL(OFER.cargo, '') cargo,   " +
"                                            ISNULL(OFER.requisitos, '') requisitos,   " +
"                                            ISNULL(OFER.horario_oferta, '') horario_oferta,   " +
"                                            ISNULL(CASE OFER.id_contacto WHEN 0 THEN EMP.nom_contacto ELSE CONT.nom_contacto END, '') nom_contacto,   " +
"                                            ISNULL(CASE OFER.id_contacto WHEN 0 THEN EMP.cargo_contacto ELSE CONT.cargo_contacto END, '') cargo_contacto,   " +
"                                            ISNULL(CASE OFER.id_contacto WHEN 0 THEN EMP.tel_contacto ELSE CONT.tel_contacto END, '') tel_contacto,   " +
"                                            ISNULL(CASE OFER.id_contacto WHEN 0 THEN EMP.email_contacto ELSE CONT.email_contacto END, '') email_contacto,   " +
"                                            ISNULL(OFER.tipo_contrato, '') tipo_contrato,   " +
"                                            ISNULL(OFER.seguro_arp, '') seguro_arp,   " +
"                                            ISNULL(OFER.salario_oferta, '') salario_oferta,   " +
"                                            ISNULL(LAST_NAME+' '+SECOND_LAST_NAME+' '+FIRST_NAME+' '+MIDDLE_NAME , '') nom_est   " +
"                                    FROM uge.aplicaciones_prac APL   " +
"                                        INNER JOIN uge.ps_ec_ib_intp_vw R ON R.EMPLID = APL.id_documento   " +
"										INNER JOIN uge.solicitud_prac SOL ON R.EMPLID=SOL.id_documento " +
"                                        INNER JOIN uge.homol_progs_campus DEP ON DEP.ACAD_PROG = SOL.ACAD_PROG   " +
"                                        INNER JOIN uge.ofertas_prac OFER ON OFER.id_oferta = APL.id_oferta   " +
"                                        INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa   " +
"                                        LEFT JOIN uge.contactos_emp_sige CONT ON CONT.id_contacto = OFER.id_contacto " +
"										" +
"                                    WHERE APL.id_aplicacion = '"+id_apli+"'");
        /**ANTES DE CAMPUS TODO
        return bDatos.getRegistro(  "SELECT  ISNULL(EMP.razon_social, '') razon_social, " +
                                            "ISNULL(EMP.nit, '') nit, " +
                                            "ISNULL(EMP.pais_empresa, '') pais_empresa, " +
                                            "ISNULL(EMP.ciudad_empresa, '') ciudad_empresa, " +
                                            "ISNULL(EMP.dir_empresa, '') dir_empresa, " +
                                            "ISNULL(EMP.web_empresa, '') web_empresa, " +
                                            "ISNULL(DEP.id_dpto, '') id_dpto, " +
                                            "ISNULL(DEP.nom_dpto, '') nom_dpto, " +
                                            "ISNULL(OFER.cargo, '') cargo, " +
                                            "ISNULL(OFER.requisitos, '') requisitos, " +
                                            "ISNULL(OFER.horario_oferta, '') horario_oferta, " +
                                            "ISNULL(CASE OFER.id_contacto WHEN 0 THEN EMP.nom_contacto ELSE CONT.nom_contacto END, '') nom_contacto, " +
                                            "ISNULL(CASE OFER.id_contacto WHEN 0 THEN EMP.cargo_contacto ELSE CONT.cargo_contacto END, '') cargo_contacto, " +
                                            "ISNULL(CASE OFER.id_contacto WHEN 0 THEN EMP.tel_contacto ELSE CONT.tel_contacto END, '') tel_contacto, " +
                                            "ISNULL(CASE OFER.id_contacto WHEN 0 THEN EMP.email_contacto ELSE CONT.email_contacto END, '') email_contacto, " +
                                            "ISNULL(OFER.tipo_contrato, '') tipo_contrato, " +
                                            "ISNULL(OFER.seguro_arp, '') seguro_arp, " +
                                            "ISNULL(OFER.salario_oferta, '') salario_oferta, " +
                                            "ISNULL(R.nom_est, '') nom_est " +
                                    "FROM uge.aplicaciones_prac APL " +
                                        "INNER JOIN registro.estudiante R ON R.id_est = APL.id_documento " +
                                        "INNER JOIN registro.departamento DEP ON DEP.id_dpto = R.id_dpto " +
                                        "INNER JOIN uge.ofertas_prac OFER ON OFER.id_oferta = APL.id_oferta " +
                                        "INNER JOIN uge.empresa_egre EMP ON EMP.id_empresa = OFER.id_empresa " +
                                        "LEFT JOIN uge.contactos_emp_sige CONT ON CONT.id_contacto = OFER.id_contacto " +
                                    "WHERE APL.id_aplicacion = '" + id_apli + "'");
                                    * 
                                    * 
            return bDatos.getRegistro("select id_dpto, id_documento,nom_est, uge.aplicaciones_prac.id_oferta, "
                    + "uge.ofertas_prac.id_empresa, razon_social,nit,pais_oferta,ciudad_oferta, dir_empresa, web_empresa, cargo, "
                    + "descripcion, requisitos, horario_oferta, nom_jefe, cargo_jefe, tel_jefe, email_jefe,tipo_contrato, seguro_arp, "
                    + "fecha_limite, fecha_in, fecha_out,nom_rrhh, tel_rrhh, email_rrhh from uge.aplicaciones_prac, registro.estudiante,"
                    + " uge.ofertas_prac, uge.empresa_egre where id_documento=id_est and id_aplicacion='"+id_apli+"' and "
                    + "uge.aplicaciones_prac.id_oferta=uge.ofertas_prac.id_oferta and uge.empresa_egre.id_empresa="
                    + "uge.ofertas_prac.id_empresa ");*/
    }
    
    @Override
    public HashMap getDatoDecEmp(String iddpto) throws Exception {
        return bDatos.getRegistro(  "SELECT ISNULL(NOM.nombres, '') nombre " +
                                    "FROM uge.usr_sige USR " +
                                    "INNER JOIN registro.dbo.empnomina NOM ON NOM.e_mail COLLATE SQL_Latin1_General_CP1_CI_AS = USR.email_usr + '@escuelaing.edu.co' " +
                                    "WHERE USR.rol_usr = '" + iddpto + "'");
        //return bDatos.getRegistro("select email_usr from uge.usr_sige where rol_usr='"+iddpto+"' ");
    }
    
    @Override
    public HashMap[] getTiposEstudiosPracEmp()throws Exception{
        return bDatos.getRegistros( "SELECT  ID, " +
                                            "nom_tipo " +
                                    "FROM uge.tipos_estudios_sige " +
                                    "ORDER BY ID");
    }
    
    @Override
    public HashMap[] getTiposEstudiosPracEmp(String id_est)throws Exception{
        return bDatos.getRegistros( "SELECT DISTINCT TE.ID, " +
                                                    "TE.nom_tipo " +
                                    "FROM uge.tipos_estudios_sige TE " +
                                        "INNER JOIN uge.estudios_sige EST ON EST.tipo_estudio = TE.ID " +
                                    "WHERE EST.id_documento = '" + id_est + "' " +
                                    "ORDER BY TE.ID");
    }
    
    @Override
    public HashMap[] getExperienciasPracEmp(String doc_grad) throws Exception{
       return bDatos.getRegistros("select nom_empresa, cargo, estado_cargo, "
               + "convert(varchar(7),fecha_in_cargo,111) as fecha_in_cargo, convert(varchar(7),fecha_out_cargo,111) "
               + "as fecha_out_cargo, funciones, logros from uge.explaboral_egre where id_documento='"+doc_grad+"'");
    }
    @Override
    public HashMap[] getEstudiosPracEmp(String doc_grad) throws Exception{
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
    public HashMap[] getIdiomasPracEmp(String doc_grad) throws Exception{
              return bDatos.getRegistros("select nom_idioma, niv_lectura, niv_escritura, "
               + "niv_habla"
               + " from uge.idiomas_sige where id_documento='"+doc_grad+"'");
    }
    @Override
    public HashMap[] getDistincionesPracEmp(String doc_grad) throws Exception{
              return bDatos.getRegistros("select id_distincion, nom_distincion, lugar_distincion, tipo_distincion, ambito_distincion, convert(varchar(7),fecha_distincion,111) f_distincion, id_documento from uge.distinciones_sige where id_documento='"+doc_grad+"' ORDER BY fecha_distincion");
    }
    @Override
     public HashMap[] getAfiliacionesPracEmp(String doc_grad) throws Exception{
              return bDatos.getRegistros("select id_afiliacion, nom_aso, tipo_aso, estado_afi, convert(varchar(7),fecha_in,111) f_in, fecha_out, id_documento from uge.afiliaciones_sige where id_documento='"+doc_grad+"' ORDER BY fecha_in DESC");
    }
    
    @Override
    public HashMap EstadoActApliGradEmp(String id_apl) throws Exception{
            return bDatos.getRegistro(  "SELECT  APL.estado_apli, " +
                                                "EST.men_usr " +
                                        "FROM uge.aplicaciones_egre APL " +
                                        "INNER JOIN uge.estados_apli_ofer EST ON EST.estado_apli = APL.estado_apli " +
                                        "WHERE APL.id_aplicacion = '" + id_apl + "'");
    }
    
    @Override
    public HashMap EstadoActApliPracEmp(String id_apli) throws Exception{
            return bDatos.getRegistro("select uge.aplicaciones_prac.estado_apli, men_usr from uge.aplicaciones_prac,"
                    + "uge.estados_apli_ofer where id_aplicacion='"+id_apli+"'"
                    + " and uge.estados_apli_ofer.estado_apli=uge.aplicaciones_prac.estado_apli");
    }
    @Override
    public HashMap DatosTutorEmp(String id_apli) throws Exception{
            return bDatos.getRegistro("select nom_prof from uge.aplicaciones_prac,  registro.profesor where id_prof=id_tutor and id_aplicacion='"+id_apli+"'");
        }
    @Override
        public HashMap DatosSolEstEmp(String id_apli) throws Exception{
        return bDatos.getRegistro("select dat.expectativas, s.electivas, disponibilidad from uge.solicitud_prac s, uge.aplicaciones_prac a, uge.datos_prac dat where s.id_documento=a.id_documento  and a.id_aplicacion='"+id_apli+"' and s.id_sol=a.id_sol and dat.id_documento=s.id_documento");


    }
    @Override
    public HashMap IdultimoContEmp(String nit) throws Exception{
           return bDatos.getRegistro("select max(id_contacto) id from uge.contactos_emp_sige where nit='" + nit + "'");
    }
    
    @Override
    public HashMap getDatosGeneralesEmp(String id_emp) throws Exception {
    return bDatos.getRegistro("select razon_social, nit, dir_empresa, web_empresa, nom_contacto, tel_contacto, email_contacto, aprobada_uge "
          + "from uge.empresa_egre where id_empresa='"+ id_emp+"'");
    }
    /**
    @Override
    public Boolean getOrganizacion(String nit) throws Exception {
        HashMap res= new HashMap();
        HashMap[] datos=bDatosOracle.getRegistrosOracle("SELECT EMPLID " +
"      ,CONTACT_TYPE " +
"      ,EC_CONTACT_NAT_ID " +
"      ,EXT_ORG_ID " +
"      ,EFFDT " +
"      ,EFF_STATUS " +
"      ,EXT_ORG_TYPE " +
"      ,DESCR " +
"      ,DESCR50 " +
"      ,DESCRLONG " +
"      ,ORG_CONTACT " +
"      ,ORG_LOCATION " +
"      ,COUNTRY " +
"      ,ADDRESS1 " +
"      ,STATE " +
"      ,CITY " +
"      ,LC_ESTRATO_SOCIAL " +
"      ,COUNTY " +
"      ,URL_ADDRESS " +
"      ,EMAILID " +
"      ,EDI_ADDRESS " +
"      ,PHONE_TYPE " +
"      ,COUNTRY_CODE " +
"      ,PHONE " +
"      ,EXTENSION " +
"      ,PREF_PHONE_FLAG " +
"      ,EC_IND_CLI " +
"      ,EC_DOM_LOC " +
"      ,EC_REGIMEN " +
"      ,EC_IND_AUTO " +
"      ,EC_AGEN_RET " +
"      ,EC_ACCOUNT " +
"      ,EC_ACCOUNT2 " +
"      ,NATIONAL_ID " +
"      ,LC_NATIONAL_ID_TYP " +
"  FROM ps_ec_ib_into_vw where NATIONAL_ID='"+nit+"'");
        Boolean ans=false;
        
        
        if(datos!=null&&datos.length>0){
            res=datos[0];
            ans=true;
        }
        if(ans){
            
            //Se borra la organizacion de los datos locales
            try{
                this.delOrganizacionLocal(nit);
            }catch(ConsultaException e){
                System.out.println("No tuvo que eliminar");
            }


            String campos = "insert into uge.ps_ec_ib_into_vw (";
            String valores = " values(";
            HashMap datosP=null;
            for (Object dato : res.keySet()) {
                campos = campos+ ""+dato.toString()+", ";
                if(res.get(dato)==null){
                    valores = valores+ "' ', ";
                }else{
                    valores = valores+ "'"+res.get(dato)+"', ";
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

            ans=ans&&this.insertOrganizacionLocal(consulta);

            HashMap[] datos2= bDatosOracle.getRegistrosOracle("SELECT CONTACT_NAME " +
                                                                "      ,JOBTITLE " +
                                                                "      ,ORG_DEPARTMENT " +
                                                                "  FROM ps_ec_ib_into_tbl where NATIONAL_ID='"+nit+"'");


            HashMap res2= null;
            if(datos2!=null&&datos2.length>0){
                res.put("CONTACT_NAME", (datos2[0].get("CONTACT_NAME")==null)?" ":datos2[0].get("CONTACT_NAME").toString());
                res.put("JOBTITLE", (datos2[0].get("JOBTITLE")==null)?" ":datos2[0].get("JOBTITLE").toString());
                res.put("ORG_DEPARTMENT", (datos2[0].get("ORG_DEPARTMENT")==null)?" ":datos2[0].get("ORG_DEPARTMENT").toString());
            }else{
                res.put("CONTACT_NAME"," ");
                res.put("JOBTITLE", " ");
                res.put("ORG_DEPARTMENT", " ");
            }
            //Esto se deshabilita porque no se tomaran datos de campus
            /**
            if(ans){
                //Se insertan los valores en las tablas de SIGE
                //Se consulta si está la empresa
                String consultaEmp = "SELECT * " +
                            "  FROM [uge].[empresa_egre] where nit='"+nit+"'";

                if(!this.existeRegistro(consultaEmp)){
                    this.Registrarempresa(res.get("NATIONAL_ID").toString(), res.get("DESCR50").toString(), res.get("COUNTRY").toString(), res.get("CITY").toString(), res.get("ADDRESS1").toString(), res.get("URL_ADDRESS").toString(), res.get("EMAILID").toString(), res.get("PHONE").toString(), res.get("DESCR50").toString(), res.get("JOBTITLE").toString(), res.get("JOBTITLE").toString(), res.get("JOBTITLE").toString(), res.get("PHONE").toString(), res.get("PHONE").toString(), res.get("EMAILID").toString(), res.get("PHONE").toString(), res.get("NATIONAL_ID").toString(), res.get("CONTACT_NAME").toString(), res.get("PHONE").toString(), res.get("EMAILID").toString(), res.get("LC_NATIONAL_ID_TYP").toString());
                }else{
                    this.ActDatempresaDesdeCampus(res.get("NATIONAL_ID").toString(), res.get("DESCR50").toString(), res.get("COUNTRY").toString(), res.get("CITY").toString(), res.get("ADDRESS1").toString(), res.get("URL_ADDRESS").toString(), res.get("EMAILID").toString(), res.get("PHONE").toString(), res.get("PHONE").toString(), res.get("PHONE").toString(), res.get("PHONE").toString(), res.get("EMAILID").toString(), res.get("PHONE").toString(), res.get("PHONE").toString(), res.get("EMAILID").toString(), "1");
                }

            }
            * */
    /**
        }
        
        
        return ans;
    }
    */
    
    
    @Override
    public void delOrganizacionLocal(String nit) throws Exception {
        bDatos.actualizar("delete from uge.ps_ec_ib_into_vw where NATIONAL_ID='"+nit+"'");
    }
    
    @Override
    public Boolean insertOrganizacionLocal(String consulta) throws Exception {
        return  bDatos.actualizar(consulta)==1;
    }

    
    @Override
    public HashMap getDatosRHContEmp(String nit) throws Exception {
    return bDatos.getRegistro("select nom_contacto, tel_contacto, email_contacto "
          + "from uge.empresa_egre where nit='" + nit + "'");
    }
    
    @Override
    public HashMap[] getSectores() throws Exception {
        return bDatos.getRegistros( "SELECT nom_sector " +
                                    "FROM uge.sectores_sige " +
                                    "ORDER BY nom_sector");
    }
    
    @Override
    public HashMap[] getMunicipios() throws Exception {
        return bDatos.getRegistros( "SELECT CodigoDANE, MuniDepto " +
                                    "FROM uge.MunicipiosDANE " +
                                    "ORDER BY MuniDepto");
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")    

    @Override
    public Boolean aprobarEmpresa(String nit) throws Exception {
        Boolean ans=false;
        ans= bDatos.actualizar("update uge.empresa_egre set aprobada_uge='1' where nit='"+nit+"'")==1;
        //Se envía la empresa para crearla en Campus
        //bDatos.getRegistro(nit)
        
        return ans;
    }

    @Override
    public HashMap consultaEmp(String nit) throws Exception {
        return bDatos.getRegistro("select  nit,  razon_social,  dir_empresa,  ciudad_empresa,  pais_empresa,  web_empresa,  email_empresa, " +
"             tel_empresa,  nom_rrhh,  tel_rrhh,  email_rrhh,  nom_contacto,  profesion_contacto,  cargo_contacto,  area_contacto," +
"             tel_contacto,  fax_contacto,  email_contacto,  cel_contacto from uge.empresa_egre where nit='"+nit+"'");
    }

    @Override
    public Boolean existeRegistro(String consulta) throws Exception {
        return bDatos.getRegistro(consulta).size()>0;
    }

    @Override
    public HashMap getNitOfertaApli(String id_apli) throws Exception {
        return bDatos.getRegistro("select EMP.nit, EMP.aprobada_uge from uge.empresa_egre EMP, uge.ofertas_prac OFER, uge.aplicaciones_prac APLI where APLI.id_aplicacion='"+id_apli+"' and APLI.id_oferta=OFER.id_oferta and OFER.id_empresa=EMP.id_empresa");
    }

    @Override
    public HashMap getPSIDSolPrac(String empl_id) throws Exception {
        return bDatos.getRegistro("select sol_serv_ps, acad_prog from uge.solicitud_prac where sol_serv_ps is not null and id_sol=(select max(id_sol) from uge.solicitud_prac where sol_serv_ps is not null and id_documento='"+empl_id+"')");
    }

    @Override
    public HashMap getDatosOferta(String id_apli) throws Exception {
        return bDatos.getRegistro("select OFERTA.tiprac, OFERTA.cargo, OFERTA.descripcion from uge.ofertas_prac OFERTA, uge.empresa_egre EMP, uge.aplicaciones_prac APLI where APLI.id_aplicacion='"+id_apli+"' and APLI.id_oferta=OFERTA.id_oferta and OFERTA.id_empresa=EMP.id_empresa");
    }

    @Override
    public Boolean estPagoMatricula(String doc_est, String per_acad) throws Exception{
        return bDatos.getRegistros("select ORDEN.num_orden from Novasoft.dbo.usr_cxc_alum_matri ALUMNO, Novasoft.dbo.usr_cxc_orden_matri ORDEN where ALUMNO.docum_alumno= '"+doc_est+"' and ALUMNO.cod_alum=ORDEN.cod_alum and ORDEN.periodo='"+per_acad+"'").length>0;
    }

    

    @Override
    public String getPerVerificaPagoMatri() throws Exception{
        return (String) bDatos.getRegistro("select descripcion from uge.fechas_sige where nombre='perVeriMatri'").get("descripcion");
    }


    @Override
    public Integer guardaRegistroProyectoCampus(String id_est, String tip_proyecto, String id_ps_solserv, String programa, String razon_social_emp, String tip_prac, String est_envio_campus, String observacion) throws Exception{
        return bDatos.actualizar("insert into uge.envio_proyectos_campus (id_est, tip_proyecto, id_ps_solserv, programa, razon_social_emp, tip_prac, est_envio_campus, observacion) values ('"+id_est+"', '"+tip_proyecto+"', '"+id_ps_solserv+"', '"+programa+"', '"+razon_social_emp+"', '"+tip_prac+"', '"+est_envio_campus+"', '"+observacion+"')");
    }

    @Override
    public HashMap getRegistroProyectoCampus(String id_ps_solserv) throws  Exception{
        return bDatos.getRegistro("select id_est, tip_proyecto, programa, razon_social_emp, tip_prac, est_envio_campus, observacion from uge.envio_proyectos_campus where id_ps_solserv='"+id_ps_solserv+"'");
    }
    
    @Override
    public Integer guardaCacheEnviosCampus(String nit_empresa, String razon_social, String dir_empresa, String ciudad_empresa, String pais_empresa, String web_empresa, String email_empresa, String tel_empresa, String nom_rrhh, String tel_rrhh, String email_rrhh, String nom_contacto, String profesion_contacto, String cargo_contacto, String area_contacto, String tel_contacto, String fax_contacto, String email_contacto, String cel_contacto, String id_est, String mod_prac, String id_ps_solserv, String programa, String tipprac, String enviado_campus) throws  Exception{
        return bDatos.actualizar("INSERT INTO [uge].[envios_pendientes_campus] ([nit_empresa] ,[razon_social] ,[dir_empresa] ,[ciudad_empresa] ,[pais_empresa] ,[web_empresa] ,[email_empresa] ,[tel_empresa] ,[nom_rrhh] ,[tel_rrhh] ,[email_rrhh] ,[nom_contacto] ,[profesion_contacto] ,[cargo_contacto] ,[area_contacto] ,[tel_contacto] ,[fax_contacto] ,[email_contacto] ,[cel_contacto] ,[id_est] ,[mod_prac] ,[id_ps_solserv] ,[programa] ,[tipprac] ,[enviado_campus]) "
                + " VALUES ('"+nit_empresa+"' ,'"+razon_social+"' ,'"+dir_empresa+"' ,'"+ciudad_empresa+"' ,'"+pais_empresa+"' ,'"+web_empresa+"' ,'"+email_empresa+"' ,'"+tel_empresa+"' ,'"+nom_rrhh+"' ,'"+tel_rrhh+"' ,'"+email_rrhh+"' ,'"+nom_contacto+"' ,'"+profesion_contacto+"' ,'"+cargo_contacto+"' ,'"+area_contacto+"' ,'"+tel_contacto+"' ,'"+fax_contacto+"' ,'"+email_contacto+"' ,'"+cel_contacto+"' ,'"+id_est+"' ,'"+mod_prac+"' ,'"+id_ps_solserv+"' ,'"+programa+"' ,'"+tipprac+"' ,'"+enviado_campus+"')");
    }
    
    @Override
    public String estadoAprobaciónUGEOferta(String id_oferta) throws Exception{
        return bDatos.getRegistro("select (select men_oferprac from uge.estados_apli_ofer ESTA where ESTA.estado_apli=OFER.estado) estado from uge.ofertas_prac OFER where id_oferta='"+id_oferta+"'").get("estado").toString();
    }
    
}
