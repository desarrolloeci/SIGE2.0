/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecampus;

import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_resp_msg.ECIBINTOSRCHRESPMSGTypeShape;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author juan.vanzina
 */
public class ConsultaOrganizaciones {

    public static void main(String[] args) {
        
        ECIBINTOSRCHRESPMSGTypeShape resp = new ECIBINTOSRCHRESPMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHREQMSGTypeShape ws_serv          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHREQMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesTypeShape msgdatainf               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.MsgDataTypeShape msgdata                     = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.TransactionTypeShape transac                 = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHMsgDataRecordTypeShape dta       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesECIBINTOSRCHTypeShape dtainf       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesECIBINTOSRCHTypeShape();      
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.EXTORGIDTypeShape exorgid                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.EXTORGIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NATIONALIDTypeShape natid                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NATIONALIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NAMETypeShape name            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NAMETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesCharFieldType fieldc               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesCharFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateFieldType fieldd               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesNumberFieldType fieldn             = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesNumberFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateTimeFieldType fielddt          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateTimeFieldType();
        
        dtainf.setEXTORGID(fieldc);
        dtainf.setNATIONALID(fieldc);
        dtainf.setNAME(fieldc);
        dtainf.setClazz("R");
        
        exorgid.setValue(fieldn.getType());
        exorgid.setValue("ORG0000011"); 
        
        dta.setEXTORGID(exorgid);
        dta.setNATIONALID(natid);//EL NIT PARA CONSULTA
        dta.setNAME(name);
        dta.setClazz("R");
        transac.setECIBINTOSRCH(dta);
        
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTOSRCH(dtainf);
       
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);

        resp = ecIBINTOSRCHOPRSRV(ws_serv);
    }
    
    
    private static ECIBINTOSRCHRESPMSGTypeShape ecIBINTOSRCHOPRSRV(com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHREQMSGTypeShape parameter) {
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_o_srv.ECIBINTOSRV service = new com.oracle.xmlns.enterprise.tools.services.ec_ib_int_o_srv.ECIBINTOSRV();
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_o_srv.ECIBINTOSRVPortType port = service.getECIBINTOSRVPort();
        
        //Logica oara agregar parametro al url
        BindingProvider bp= (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY)+"?From=EC_NODSG");
        return port.ecIBINTOSRCHOPRSRV(parameter);
    }
    
    public static void ConsultaOrganizacionNit(String nit){
        ECIBINTOSRCHRESPMSGTypeShape resp = new ECIBINTOSRCHRESPMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHREQMSGTypeShape ws_serv          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHREQMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesTypeShape msgdatainf               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.MsgDataTypeShape msgdata                     = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.TransactionTypeShape transac                 = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHMsgDataRecordTypeShape dta       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesECIBINTOSRCHTypeShape dtainf       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesECIBINTOSRCHTypeShape();      
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.EXTORGIDTypeShape exorgid                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.EXTORGIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NATIONALIDTypeShape natid                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NATIONALIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NAMETypeShape name                           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NAMETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesCharFieldType fieldc               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesCharFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateFieldType fieldd               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesNumberFieldType fieldn             = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesNumberFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateTimeFieldType fielddt          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateTimeFieldType();
        
        dtainf.setEXTORGID(fieldc);
        dtainf.setNATIONALID(fieldc);
        dtainf.setNAME(fieldc);
        dtainf.setClazz("R");
        
        //exorgid.setValue(fieldn.getType());
        //exorgid.setValue("ORG0000011"); 
        
        dta.setEXTORGID(exorgid);
        
        natid.setValue(fieldn.getType());
        natid.setValue(nit);
        
        dta.setNATIONALID(natid);//EL NIT PARA CONSULTA
        dta.setNAME(name);
        dta.setClazz("R");
        transac.setECIBINTOSRCH(dta);
        
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTOSRCH(dtainf);
       
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);

        resp = ecIBINTOSRCHOPRSRV(ws_serv);
    }
    
    public static void ConsultaOrganizacionExtOrgId(String ext_org_id){
        ECIBINTOSRCHRESPMSGTypeShape resp = new ECIBINTOSRCHRESPMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHREQMSGTypeShape ws_serv          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHREQMSGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesTypeShape msgdatainf               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.MsgDataTypeShape msgdata                     = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.TransactionTypeShape transac                 = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHMsgDataRecordTypeShape dta       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.ECIBINTOSRCHMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesECIBINTOSRCHTypeShape dtainf       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesECIBINTOSRCHTypeShape();      
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.EXTORGIDTypeShape exorgid                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.EXTORGIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NATIONALIDTypeShape natid                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NATIONALIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NAMETypeShape name                           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.NAMETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesCharFieldType fieldc               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesCharFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateFieldType fieldd               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesNumberFieldType fieldn             = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesNumberFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateTimeFieldType fielddt          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_srch_req_msg.FieldTypesDateTimeFieldType();
        
        dtainf.setEXTORGID(fieldc);
        dtainf.setNATIONALID(fieldc);
        dtainf.setNAME(fieldc);
        dtainf.setClazz("R");
        
        exorgid.setValue(fieldn.getType());
        exorgid.setValue(ext_org_id); 
        
        dta.setEXTORGID(exorgid);
        dta.setNATIONALID(natid);//EL NIT PARA CONSULTA
        dta.setNAME(name);
        dta.setClazz("R");
        transac.setECIBINTOSRCH(dta);
        
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTOSRCH(dtainf);
       
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);

        resp = ecIBINTOSRCHOPRSRV(ws_serv);
    }
    
}
