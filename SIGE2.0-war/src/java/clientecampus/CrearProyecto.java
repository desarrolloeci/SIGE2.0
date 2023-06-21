/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecampus;

import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ACADPROGTypeShape;
import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.PROJECTTYPETypeShape;
import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_res_msg.ECIBPROYECTOSRESMSGTypeShape;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author juan.vanzina
 */
public class CrearProyecto {

    public static void main(String[] args) {
        
        ECIBPROYECTOSRESMSGTypeShape resp = new ECIBPROYECTOSRESMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ECIBPROYECTOSREQMSGTypeShape ws_serv          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ECIBPROYECTOSREQMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesTypeShape msgdatainf                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.MsgDataTypeShape msgdata                      = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesECSSRRSTHESITypeShape dtainf        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesECSSRRSTHESITypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.TransactionTypeShape transac                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ECSSRRSTHESIMsgDataRecordTypeShape dta        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ECSSRRSTHESIMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.CAMPUSIDTypeShape campusid                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.CAMPUSIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.EMPLIDTypeShape emplid                        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.EMPLIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.SSRRSTHESISTITLTypeShape ssrth                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.SSRRSTHESISTITLTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.LCIDSOLSERVICIOTypeShape lcid                 = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.LCIDSOLSERVICIOTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.INSTITUTIONTypeShape instit                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.INSTITUTIONTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ACADCAREERTypeShape carreer                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ACADCAREERTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.SSRDESCR100TypeShape descrp                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.SSRDESCR100TypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.LCIDSOLSERVICIOTypeShape  solserv             = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.LCIDSOLSERVICIOTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesCharFieldType fieldc                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesCharFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesDateFieldType fieldd                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesDateTimeFieldType fielddt           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesDateTimeFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesNumberFieldType fieldn              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesNumberFieldType();
        
        dtainf.setCAMPUSID(fieldc);
        dtainf.setEMPLID(fieldc);
        dtainf.setINSTITUTION(fieldc);
        dtainf.setACADCAREER(fieldc);
        dtainf.setSSRDESCR100(fieldc);
        dtainf.setLCIDSOLSERVICIO(fieldc);
        dtainf.setClazz("R");
           
        campusid.setValue("MAIN");
        emplid.setValue("0140");
        instit.setValue("PSUNV");
        carreer.setValue("PREG");
        descrp.setValue("PRACTICA_ING_CIVIL_PRUEBA");
        solserv.setValue("PREM");// este es el codigo presente en solicitud_prac.sol_servicio
        ssrth.setValue("<p>PRACTICA EMPRESARIAL</p>");
        lcid.setValue("NEXT");
        
        dta.setCAMPUSID(campusid);
        dta.setEMPLID(emplid);
        dta.setINSTITUTION(instit);
        dta.setACADCAREER(carreer);
        dta.setSSRDESCR100(descrp);
        dta.setLCIDSOLSERVICIO(solserv);
        dta.setClazz("R");
        transac.setECSSRRSTHESI(dta);
        
        msgdata.setTransaction(transac);
        msgdatainf.setECSSRRSTHESI(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        
        resp = ecIBINTPROYECTOSOPRSRV(ws_serv);
    }
    
    private static ECIBPROYECTOSRESMSGTypeShape ecIBINTPROYECTOSOPRSRV(com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ECIBPROYECTOSREQMSGTypeShape parameter) {
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_pra_pro_srv.ECIBINTPRAPROSRV service = new com.oracle.xmlns.enterprise.tools.services.ec_ib_int_pra_pro_srv.ECIBINTPRAPROSRV();
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_pra_pro_srv.ECIBINTPRAPROSRVPortType port = service.getECIBINTPRAPROSRVPort();
        //Logica oara agregar parametro al url
        BindingProvider bp= (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY)+"?From=EC_NODSG");
        return port.ecIBINTPROYECTOSOPRSRV(parameter);
    }
    
    public static void EnviaProyecto(String empl_id, String tema, String id_sol, String prog, String nomEmp, String tipoPrac){
        ECIBPROYECTOSRESMSGTypeShape resp = new ECIBPROYECTOSRESMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ECIBPROYECTOSREQMSGTypeShape ws_serv          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ECIBPROYECTOSREQMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesTypeShape msgdatainf                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.MsgDataTypeShape msgdata                      = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesECSSRRSTHESITypeShape dtainf        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesECSSRRSTHESITypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.TransactionTypeShape transac                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ECSSRRSTHESIMsgDataRecordTypeShape dta        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ECSSRRSTHESIMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.CAMPUSIDTypeShape campusid                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.CAMPUSIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.EMPLIDTypeShape emplid                        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.EMPLIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.SSRRSTHESISTITLTypeShape ssrth                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.SSRRSTHESISTITLTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.INSTITUTIONTypeShape instit                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.INSTITUTIONTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ACADCAREERTypeShape carreer                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ACADCAREERTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.SSRDESCR100TypeShape descrp                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.SSRDESCR100TypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.LCIDSOLSERVICIOTypeShape  solserv             = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.LCIDSOLSERVICIOTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesCharFieldType fieldc                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesCharFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesDateFieldType fieldd                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesDateTimeFieldType fielddt           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesDateTimeFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesNumberFieldType fieldn              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.FieldTypesNumberFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.PROJECTTYPETypeShape proType                  = new PROJECTTYPETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_proyectos_req_msg.ACADPROGTypeShape  programa                       = new ACADPROGTypeShape();

        
        
        dtainf.setCAMPUSID(fieldc);
        dtainf.setEMPLID(fieldc);
        dtainf.setINSTITUTION(fieldc);
        dtainf.setACADCAREER(fieldc);
        dtainf.setSSRDESCR100(fieldc);
        dtainf.setLCIDSOLSERVICIO(fieldc);
        dtainf.setPROJECTTYPE(fieldc);
        dtainf.setSSRRSTHESISTITL(fieldc);
        dtainf.setACADPROG(fieldc);
        dtainf.setClazz("R");
           
        //campusid.setValue("MAIN");
        emplid.setValue(empl_id);
        instit.setValue("ECIJG");
        carreer.setValue("PREG");
        descrp.setValue(nomEmp);
        solserv.setValue(id_sol);// este es el codigo presente en solicitud_prac.sol_servicio
        ssrth.setValue(tipoPrac);
        proType.setValue("PRPR");
        programa.setValue(prog);
        
        dta.setCAMPUSID(campusid);
        dta.setEMPLID(emplid);
        dta.setINSTITUTION(instit);
        dta.setACADCAREER(carreer);
        dta.setSSRDESCR100(descrp);
        dta.setLCIDSOLSERVICIO(solserv);
        dta.setPROJECTTYPE(proType);
        dta.setSSRRSTHESISTITL(ssrth);
        dta.setACADPROG(programa);
        dta.setClazz("R");
        transac.setECSSRRSTHESI(dta);
        
        msgdata.setTransaction(transac);
        msgdatainf.setECSSRRSTHESI(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        
        resp = ecIBINTPROYECTOSOPRSRV(ws_serv);
    }
    
}
