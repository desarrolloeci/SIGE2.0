/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecampus;


import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_resp_msg.*;
import java.util.HashMap;
import javax.xml.bind.JAXBException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author juan.vanzina
 */
public class ConsultaPersonas {
    
    public static void main(String[] args) throws JAXBException {

        ECIBINTPSRCHRESPMSGTypeShape resp       = new ECIBINTPSRCHRESPMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.MsgDataTypeShape msgdata                         = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesTypeShape  msgdatainf                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.TransactionTypeShape transac                     = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHREQMSGTypeShape ws_serv              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHREQMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHMsgDataRecordTypeShape dta           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EMPLIDTypeShape empid                            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EMPLIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NATIONALIDTypeShape natid                        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NATIONALIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NAMETypeShape namet                              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NAMETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ROLENAMETypeShape role                           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ROLENAMETypeShape();         
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EFFDTTypeShape efdt                              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EFFDTTypeShape();        
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesCharFieldType fieldc                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesCharFieldType(); 
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesDateFieldType fieldd                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesNumberFieldType fieldn                 = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesNumberFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesECIBINTPSRCHTypeShape dtainf           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesECIBINTPSRCHTypeShape();
        
        
        
        
        dtainf.setEMPLID(fieldc);
        dtainf.setNATIONALID(fieldc);
        dtainf.setNAME(fieldc);
        dtainf.setROLENAME(fieldc);
        dtainf.setEFFDT(fieldd);
        dtainf.setClazz("R");
        
        empid.setValue("0000000234"); 
        
        dta.setEMPLID(empid);
        dta.setNATIONALID(natid);
        dta.setNAME(namet);
        dta.setROLENAME(role);
        dta.setEFFDT(efdt);
        dta.setClazz("R");
        transac.setECIBINTPSRCH(dta);
        
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTPSRCH(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        
        
        
        
        
        
        resp = ecIBINTSRCHOPRSRV(ws_serv);
        //ECIBINTPSRCHRESPMSGTypeShape respu = new ECIBINTPSRCHRESPMSGTypeShape();
        
        
        
        
        
        
        
        
        
        ECIBINTPSRCHRESPMSGTypeShape respu = ecIBINTSRCHOPRSRV(ws_serv);
        
        
        System.out.println(resp.getMsgData());
    }

    private static ECIBINTPSRCHRESPMSGTypeShape ecIBINTSRCHOPRSRV(com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHREQMSGTypeShape parameter) {
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_srv.ECIBINTSRV service = new com.oracle.xmlns.enterprise.tools.services.ec_ib_int_srv.ECIBINTSRV();
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_srv.ECIBINTSRVPortType port = service.getECIBINTSRVPort();
        
        //int responseCode = (Integer)((BindingProvider) port).getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);

        //Logica oara agregar parametro al url
        BindingProvider bp= (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY)+"?From=EC_NODSG");
        return port.ecIBINTSRCHOPRSRV(parameter);
    }

    public static HashMap consultaPersona(String empl_id, String rolename){
        ECIBINTPSRCHRESPMSGTypeShape resp       = new ECIBINTPSRCHRESPMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.MsgDataTypeShape msgdata                         = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesTypeShape  msgdatainf                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.TransactionTypeShape transac                     = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHREQMSGTypeShape ws_serv              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHREQMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHMsgDataRecordTypeShape dta           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EMPLIDTypeShape empid                            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EMPLIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NATIONALIDTypeShape natid                        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NATIONALIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NAMETypeShape namet                              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NAMETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ROLENAMETypeShape role                           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ROLENAMETypeShape();         
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EFFDTTypeShape efdt                              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EFFDTTypeShape();        
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesCharFieldType fieldc                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesCharFieldType(); 
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesDateFieldType fieldd                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesNumberFieldType fieldn                 = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesNumberFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesECIBINTPSRCHTypeShape dtainf           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesECIBINTPSRCHTypeShape();
        
        dtainf.setEMPLID(fieldc);
        dtainf.setNATIONALID(fieldc);
        dtainf.setNAME(fieldc);
        dtainf.setROLENAME(fieldc);
        dtainf.setEFFDT(fieldd);
        dtainf.setClazz("R");
        
        empid.setValue(empl_id); 
        role.setValue(rolename);
        
        dta.setEMPLID(empid);
        dta.setNATIONALID(natid);
        dta.setNAME(namet);
        dta.setROLENAME(role);
        dta.setEFFDT(efdt);
        dta.setClazz("R");
        transac.setECIBINTPSRCH(dta);
        
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTPSRCH(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        
        /**
        HashMap[] datos= bDatosOracle.getRegistrosOracle("select EMPLID, 
        * EFFDT, 
        * EFF_STATUS, 
        * NAME_TYPE, 
        * FIRST_NAME, 
        * MIDDLE_NAME, 
        * LAST_NAME, 
        * SECOND_LAST_NAME, 
        * BIRTHDATE, 
        * BIRTHPLACE, 
        * BIRTHCOUNTRY, 
        * BIRTHSTATE, 
        * CAMPUS_ID, 
        * MAR_STATUS, 
        * MAR_STATUS_DT, 
        * SEX, 
        * COUNTRY, 
        * NATIONAL_ID_TYPE, 
        * NATIONAL_ID, 
        * LC_STATE3, 
        * CITY_AC, 
        * PRIMARY_NID, 
        * ADDRESS_TYPE, 
        * COUNTRY2, 
        * ADDRESS1, 
        * ADDRESS2, 
        * CITY, 
        * STATE, 
        * LC_ESTRATO_SOCIAL, 
        * COUNTY, 
        * BLOOD_TYPE, 
        * PHONE_TYPE, 
        * PHONE, 
        * EXTENSION, 
        * COUNTRY_CODE, 
        * PREF_PHONE_FLAG, 
        * E_ADDR_TYPE, 
        * EMAIL_ADDR, 
        * PREF_EMAIL_FLAG, 
        * OPRID_APPROVED_BY, 
        * OPRID, 
        * INSTITUTION, 
        * ACAD_ORG, 
        * INSTR_TYPE, 
        * ACAD_CAREER, 
        * STRM, 
        * ACAD_PROG, 
        * ROLENAME, 
        * ADM_RECR_CTR, 
        * PROG_ACTION, 
        * STDNT_CAR_NBR, 
        * CAMPUS, 
        * ADMIT_TERM, 
        * EFFDT_ADDR, 
        * PROG_STATUS, 
        * TEMPLATE_ID, 
        * TEMPLATE_STATUS, 
        * ALTER_EMPLID, 
        * OPERPSWD from ps_ec_ib_intp_vw where emplid ='"+empl_id+"' and ROLENAME='"+rolename+"'");
        */
        resp = ecIBINTSRCHOPRSRV(ws_serv);
        ECIBINTPTBLMsgDataRecordTypeShape data = resp.getMsgData().getTransaction().get(0).getECIBINTPTBL();
        
        //Se almacena la respuesta para retornarla
        HashMap<String, String> respuesta;
        respuesta = new HashMap();
        respuesta.put("EMPLID", data.getEMPLID().getValue());
        respuesta.put("EFFDT", data.getEFFDT().getValue().toString());
        respuesta.put("EFF_STATUS", data.getEFFSTATUS().getValue());
        respuesta.put("NAME_TYPE", data.getNAMETYPE().getValue());
        respuesta.put("FIRST_NAME", data.getFIRSTNAME().getValue());
        respuesta.put("MIDDLE_NAME", data.getMIDDLENAME().getValue());
        respuesta.put("LAST_NAME", data.getLASTNAME().getValue());
        respuesta.put("SECOND_LAST_NAME", data.getSECONDLASTNAME().getValue());
        respuesta.put("BIRTHDATE", data.getBIRTHDATE().getValue().toString());
        respuesta.put("BIRTHPLACE", data.getBIRTHPLACE().getValue());
        respuesta.put("BIRTHCOUNTRY", data.getBIRTHCOUNTRY().getValue());
        respuesta.put("BIRTHSTATE", data.getBIRTHSTATE().getValue());
        respuesta.put("CAMPUS_ID", data.getCAMPUSID().getValue());
        respuesta.put("MAR_STATUS", data.getMARSTATUS().getValue());
        respuesta.put("MAR_STATUS_DT", data.getMARSTATUSDT().getValue().toString());
        respuesta.put("SEX", data.getSEX().getValue());
        respuesta.put("COUNTRY", data.getCOUNTRY().getValue());
        respuesta.put("NATIONAL_ID_TYPE", data.getNATIONALIDTYPE().getValue());
        respuesta.put("NATIONAL_ID", data.getNATIONALID().getValue());
        respuesta.put("LC_STATE3", data.getLCSTATE3().getValue());
        respuesta.put("CITY_AC", data.getCITYAC().getValue());
        respuesta.put("PRIMARY_NID", data.getPRIMARYNID().getValue());
        respuesta.put("ADDRESS_TYPE", data.getADDRESSTYPE().getValue());
        respuesta.put("COUNTRY2", data.getCOUNTRY2().getValue());
        respuesta.put("ADDRESS1", data.getADDRESS1().getValue());
        respuesta.put("ADDRESS2", data.getADDRESS2().getValue());
        respuesta.put("CITY", data.getCITY().getValue());
        respuesta.put("STATE", data.getSTATE().getValue());
        respuesta.put("LC_ESTRATO_SOCIAL", data.getLCESTRATOSOCIAL().getValue());
        respuesta.put("COUNTY", data.getCOUNTY().getValue());
        respuesta.put("BLOOD_TYPE", data.getBLOODTYPE().getValue());
        respuesta.put("PHONE_TYPE", data.getPHONETYPE().getValue());
        respuesta.put("PHONE", data.getPHONE().getValue().replace("/", "").replace("-", ""));
        respuesta.put("EXTENSION", data.getEXTENSION().getValue());
        respuesta.put("COUNTRY_CODE", data.getCOUNTRYCODE().getValue());
        respuesta.put("PREF_PHONE_FLAG", data.getPREFPHONEFLAG().getValue());
        respuesta.put("E_ADDR_TYPE", data.getEADDRTYPE().getValue());
        respuesta.put("EMAIL_ADDR", data.getEMAILADDR().getValue());
        respuesta.put("PREF_EMAIL_FLAG", data.getPREFEMAILFLAG().getValue());
        respuesta.put("OPRID_APPROVED_BY", data.getOPRIDAPPROVEDBY().getValue());
        respuesta.put("OPRID", data.getOPRID().getValue());
        respuesta.put("INSTITUTION", data.getINSTITUTION().getValue());
        respuesta.put("ACAD_ORG", data.getACADORG().getValue());
        respuesta.put("INSTR_TYPE", data.getINSTRTYPE().getValue());
        respuesta.put("ACAD_CAREER", data.getACADCAREER().getValue());
        respuesta.put("STRM", data.getSTRM().getValue());
        respuesta.put("ACAD_PROG", data.getACADPROG().getValue());
        respuesta.put("ROLENAME", "PERSONA");
        respuesta.put("ADM_RECR_CTR", data.getADMRECRCTR().getValue());
        respuesta.put("PROG_ACTION", data.getPROGACTION().getValue());
        respuesta.put("STDNT_CAR_NBR", data.getSTDNTCARNBR().getValue().toString());
        respuesta.put("CAMPUS", data.getCAMPUS().getValue());
        respuesta.put("ADMIT_TERM", data.getADMITTERM().getValue());
        respuesta.put("EFFDT_ADDR", data.getEFFDTADDR().getValue().toString());
        respuesta.put("PROG_STATUS", data.getPROGSTATUS().getValue());
        respuesta.put("TEMPLATE_ID", data.getTEMPLATEID().getValue());
        respuesta.put("TEMPLATE_STATUS", data.getTEMPLATESTATUS().getValue());
        respuesta.put("ALTER_EMPLID", data.getALTEREMPLID().getValue());
        respuesta.put("OPERPSWD", "");
        
        return respuesta;

    
        
        
    }
    
    
    
    public static HashMap consultaPersonaId(String empl_id, String rolename){
        ECIBINTPSRCHRESPMSGTypeShape resp       = new ECIBINTPSRCHRESPMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.MsgDataTypeShape msgdata                         = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesTypeShape  msgdatainf                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.TransactionTypeShape transac                     = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHREQMSGTypeShape ws_serv              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHREQMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHMsgDataRecordTypeShape dta           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ECIBINTPSRCHMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EMPLIDTypeShape empid                            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EMPLIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NATIONALIDTypeShape natid                        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NATIONALIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NAMETypeShape namet                              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.NAMETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ROLENAMETypeShape role                           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.ROLENAMETypeShape();         
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EFFDTTypeShape efdt                              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.EFFDTTypeShape();        
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesCharFieldType fieldc                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesCharFieldType(); 
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesDateFieldType fieldd                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesNumberFieldType fieldn                 = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesNumberFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesECIBINTPSRCHTypeShape dtainf           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_srch_req_msg.FieldTypesECIBINTPSRCHTypeShape();
        
        dtainf.setEMPLID(fieldc);
        dtainf.setNATIONALID(fieldc);
        dtainf.setNAME(fieldc);
        dtainf.setROLENAME(fieldc);
        dtainf.setEFFDT(fieldd);
        dtainf.setClazz("R");
        
        natid.setValue(empl_id); 
        //role.setValue(rolename);
        
        dta.setEMPLID(empid);
        dta.setNATIONALID(natid);
        dta.setNAME(namet);
        dta.setROLENAME(role);
        dta.setEFFDT(efdt);
        dta.setClazz("R");
        transac.setECIBINTPSRCH(dta);
        
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTPSRCH(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        
        /**
        HashMap[] datos= bDatosOracle.getRegistrosOracle("select EMPLID, 
        * EFFDT, 
        * EFF_STATUS, 
        * NAME_TYPE, 
        * FIRST_NAME, 
        * MIDDLE_NAME, 
        * LAST_NAME, 
        * SECOND_LAST_NAME, 
        * BIRTHDATE, 
        * BIRTHPLACE, 
        * BIRTHCOUNTRY, 
        * BIRTHSTATE, 
        * CAMPUS_ID, 
        * MAR_STATUS, 
        * MAR_STATUS_DT, 
        * SEX, 
        * COUNTRY, 
        * NATIONAL_ID_TYPE, 
        * NATIONAL_ID, 
        * LC_STATE3, 
        * CITY_AC, 
        * PRIMARY_NID, 
        * ADDRESS_TYPE, 
        * COUNTRY2, 
        * ADDRESS1, 
        * ADDRESS2, 
        * CITY, 
        * STATE, 
        * LC_ESTRATO_SOCIAL, 
        * COUNTY, 
        * BLOOD_TYPE, 
        * PHONE_TYPE, 
        * PHONE, 
        * EXTENSION, 
        * COUNTRY_CODE, 
        * PREF_PHONE_FLAG, 
        * E_ADDR_TYPE, 
        * EMAIL_ADDR, 
        * PREF_EMAIL_FLAG, 
        * OPRID_APPROVED_BY, 
        * OPRID, 
        * INSTITUTION, 
        * ACAD_ORG, 
        * INSTR_TYPE, 
        * ACAD_CAREER, 
        * STRM, 
        * ACAD_PROG, 
        * ROLENAME, 
        * ADM_RECR_CTR, 
        * PROG_ACTION, 
        * STDNT_CAR_NBR, 
        * CAMPUS, 
        * ADMIT_TERM, 
        * EFFDT_ADDR, 
        * PROG_STATUS, 
        * TEMPLATE_ID, 
        * TEMPLATE_STATUS, 
        * ALTER_EMPLID, 
        * OPERPSWD from ps_ec_ib_intp_vw where emplid ='"+empl_id+"' and ROLENAME='"+rolename+"'");
        */
        resp = ecIBINTSRCHOPRSRV(ws_serv);
        ECIBINTPTBLMsgDataRecordTypeShape data = resp.getMsgData().getTransaction().get(0).getECIBINTPTBL();
        
        //Se almacena la respuesta para retornarla
        HashMap<String, String> respuesta;
        respuesta = new HashMap();
        respuesta.put("EMPLID", data.getEMPLID().getValue());
        respuesta.put("EFFDT", data.getEFFDT().getValue().toString());
        respuesta.put("EFF_STATUS", data.getEFFSTATUS().getValue());
        respuesta.put("NAME_TYPE", data.getNAMETYPE().getValue());
        respuesta.put("FIRST_NAME", data.getFIRSTNAME().getValue());
        respuesta.put("MIDDLE_NAME", data.getMIDDLENAME().getValue());
        respuesta.put("LAST_NAME", data.getLASTNAME().getValue());
        respuesta.put("SECOND_LAST_NAME", data.getSECONDLASTNAME().getValue());
        respuesta.put("BIRTHDATE", data.getBIRTHDATE().getValue().toString());
        respuesta.put("BIRTHPLACE", data.getBIRTHPLACE().getValue());
        respuesta.put("BIRTHCOUNTRY", data.getBIRTHCOUNTRY().getValue());
        respuesta.put("BIRTHSTATE", data.getBIRTHSTATE().getValue());
        respuesta.put("CAMPUS_ID", data.getCAMPUSID().getValue());
        respuesta.put("MAR_STATUS", data.getMARSTATUS().getValue());
        respuesta.put("MAR_STATUS_DT", data.getMARSTATUSDT().getValue().toString());
        respuesta.put("SEX", data.getSEX().getValue());
        respuesta.put("COUNTRY", data.getCOUNTRY().getValue());
        respuesta.put("NATIONAL_ID_TYPE", data.getNATIONALIDTYPE().getValue());
        respuesta.put("NATIONAL_ID", data.getNATIONALID().getValue());
        respuesta.put("LC_STATE3", data.getLCSTATE3().getValue());
        respuesta.put("CITY_AC", data.getCITYAC().getValue());
        respuesta.put("PRIMARY_NID", data.getPRIMARYNID().getValue());
        respuesta.put("ADDRESS_TYPE", data.getADDRESSTYPE().getValue());
        respuesta.put("COUNTRY2", data.getCOUNTRY2().getValue());
        respuesta.put("ADDRESS1", data.getADDRESS1().getValue());
        respuesta.put("ADDRESS2", data.getADDRESS2().getValue());
        respuesta.put("CITY", data.getCITY().getValue());
        respuesta.put("STATE", data.getSTATE().getValue());
        respuesta.put("LC_ESTRATO_SOCIAL", data.getLCESTRATOSOCIAL().getValue());
        respuesta.put("COUNTY", data.getCOUNTY().getValue());
        respuesta.put("BLOOD_TYPE", data.getBLOODTYPE().getValue());
        respuesta.put("PHONE_TYPE", data.getPHONETYPE().getValue());
        respuesta.put("PHONE", data.getPHONE().getValue().replace("/", "").replace("-", ""));
        respuesta.put("EXTENSION", data.getEXTENSION().getValue());
        respuesta.put("COUNTRY_CODE", data.getCOUNTRYCODE().getValue());
        respuesta.put("PREF_PHONE_FLAG", data.getPREFPHONEFLAG().getValue());
        respuesta.put("E_ADDR_TYPE", data.getEADDRTYPE().getValue());
        respuesta.put("EMAIL_ADDR", data.getEMAILADDR().getValue());
        respuesta.put("PREF_EMAIL_FLAG", data.getPREFEMAILFLAG().getValue());
        respuesta.put("OPRID_APPROVED_BY", data.getOPRIDAPPROVEDBY().getValue());
        respuesta.put("OPRID", data.getOPRID().getValue());
        respuesta.put("INSTITUTION", data.getINSTITUTION().getValue());
        respuesta.put("ACAD_ORG", data.getACADORG().getValue());
        respuesta.put("INSTR_TYPE", data.getINSTRTYPE().getValue());
        respuesta.put("ACAD_CAREER", data.getACADCAREER().getValue());
        respuesta.put("STRM", data.getSTRM().getValue());
        respuesta.put("ACAD_PROG", data.getACADPROG().getValue());
        respuesta.put("ROLENAME", "PERSONA");
        respuesta.put("ADM_RECR_CTR", data.getADMRECRCTR().getValue());
        respuesta.put("PROG_ACTION", data.getPROGACTION().getValue());
        respuesta.put("STDNT_CAR_NBR", data.getSTDNTCARNBR().getValue().toString());
        respuesta.put("CAMPUS", data.getCAMPUS().getValue());
        respuesta.put("ADMIT_TERM", data.getADMITTERM().getValue());
        respuesta.put("EFFDT_ADDR", data.getEFFDTADDR().getValue().toString());
        respuesta.put("PROG_STATUS", data.getPROGSTATUS().getValue());
        respuesta.put("TEMPLATE_ID", data.getTEMPLATEID().getValue());
        respuesta.put("TEMPLATE_STATUS", data.getTEMPLATESTATUS().getValue());
        respuesta.put("ALTER_EMPLID", data.getALTEREMPLID().getValue());
        respuesta.put("OPERPSWD", "");
        
        return respuesta;

    
        
        
    }
    
}
