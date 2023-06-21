/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecampus;

import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.CONTACTNAMETypeShape;
import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EMAILIDTypeShape;
import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.JOBTITLETypeShape;
import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGDEPARTMENTTypeShape;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;


/**
 *
 * @author juan.vanzina
 */
public class CreaOrganizacion {

    public static void main(String[] args) throws DatatypeConfigurationException, ParseException {
        
        CreaOrganizacion EJEC = new CreaOrganizacion();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOREQMSGTypeShape ws_serv       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOREQMSGTypeShape(); 
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesTypeShape msgdatainf        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.MsgDataTypeShape  msgdata             = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.TransactionTypeShape transac          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesECIBINTOTBLTypeShape dtainf = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesECIBINTOTBLTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOTBLMsgDataRecordTypeShape dta = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOTBLMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.NATIONALIDTypeShape natid             = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.NATIONALIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.LCNATIONALIDTYPTypeShape lnatid       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.LCNATIONALIDTYPTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTORGIDTypeShape exorid              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTORGIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EFFDTTypeShape effdt                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EFFDTTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EFFSTATUSTypeShape effdtstts          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EFFSTATUSTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTORGTYPETypeShape extorgtype        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTORGTYPETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCRTypeShape desc                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCRTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCR50TypeShape desc50               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCR50TypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCRLONGTypeShape desclong           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCRLONGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGCONTACTTypeShape orgcon            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGCONTACTTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGLOCATIONTypeShape orgloc           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGLOCATIONTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTRYTypeShape country              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTRYTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ADDRESS1TypeShape address             = new   com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ADDRESS1TypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.STATETypeShape state                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.STATETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.CITYTypeShape city                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.CITYTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.LCESTRATOSOCIALTypeShape lcestrato    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.LCESTRATOSOCIALTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTYTypeShape county                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTYTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.URLADDRESSTypeShape urladd            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.URLADDRESSTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EMAILIDTypeShape email                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EMAILIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EDIADDRESSTypeShape ediadd            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EDIADDRESSTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PHONETYPETypeShape phonetype          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PHONETYPETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTRYCODETypeShape cocod            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTRYCODETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PHONETypeShape phone                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PHONETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTENSIONTypeShape ext                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTENSIONTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PREFPHONEFLAGTypeShape preflag        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PREFPHONEFLAGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECINDCLITypeShape indcli              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECINDCLITypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECDOMLOCTypeShape domloc              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECDOMLOCTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECREGIMENTypeShape regimen            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECREGIMENTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECINDAUTOTypeShape indauto            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECINDAUTOTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECAGENRETTypeShape agenret            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECAGENRETTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECACCOUNTTypeShape account            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECACCOUNTTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECACCOUNT2TypeShape account2          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECACCOUNT2TypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesCharFieldType fieldc        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesCharFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesDateFieldType fieldd        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesNumberFieldType fieldn      = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesNumberFieldType();
       
        dtainf.setNATIONALID(fieldc);
        dtainf.setLCNATIONALIDTYP(fieldc);
        dtainf.setEXTORGID(fieldc);
        dtainf.setEFFDT(fieldd);
        dtainf.setEFFSTATUS(fieldc);
        dtainf.setEXTORGTYPE(fieldc);
        dtainf.setDESCR(fieldc);
        dtainf.setDESCR50(fieldc);
        dtainf.setDESCRLONG(fieldc);
        dtainf.setORGCONTACT(fieldn);
        dtainf.setORGLOCATION(fieldn);
        dtainf.setCOUNTRY(fieldc);
        dtainf.setADDRESS1(fieldc);
        dtainf.setSTATE(fieldc);
        dtainf.setCITY(fieldc);
        dtainf.setLCESTRATOSOCIAL(fieldc);
        dtainf.setCOUNTRY(fieldc);
        dtainf.setURLADDRESS(fieldc);
        dtainf.setEMAILID(fieldc);
        dtainf.setEDIADDRESS(fieldc);
        dtainf.setPHONETYPE(fieldc);
        dtainf.setCOUNTRYCODE(fieldc);
        dtainf.setPHONE(fieldc);
        dtainf.setEXTENSION(fieldc);
        dtainf.setPREFPHONEFLAG(fieldc);
        dtainf.setECINDCLI(fieldc);
        dtainf.setECDOMLOC(fieldc);
        dtainf.setECREGIMEN(fieldc);
        dtainf.setECINDAUTO(fieldc);
        dtainf.setECAGENRET(fieldc);
        dtainf.setECACCOUNT(fieldc);
        dtainf.setECACCOUNT2(fieldc);
        
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        
        
        /**
	String dateInString = "21-12-2018 12:00:00";
	Date date = sdf.parse(dateInString);
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar effdate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        * */
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(sdf.parse("2019-02-13"));
        XMLGregorianCalendar effdate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        
        BigInteger orgcontact = new BigInteger("1");
        
        natid.setValue("2856179777");
        lnatid.setValue("NI");
        //exorid.setValue("");
        effdt.setValue(effdate);
        effdtstts.setValue("A");
        extorgtype.setValue("SCHL");
        desc.setValue("CESCUELA_5");
        desc50.setValue("ESTO ES UNA PRUEBA");
        desclong.setValue("CESCUELA_3");
        //orgcon.setValue(orgcontact);//Este dato puede ser foraneo, preguntar en reunion
        country.setValue("COL");
        address.setValue("Autopista Norte Calle 205 No 59");
        state.setValue("CUNDIN");
        city.setValue("Bogotá");
        lcestrato.setValue("6");
        county.setValue("Colombia");
        urladd.setValue("");
        email.setValue("");
        ediadd.setValue("");
        phonetype.setValue("");
        cocod.setValue("");
        phone.setValue("");
        ext.setValue("");
        preflag.setValue("");
        indcli.setValue("1");
        domloc.setValue("");
        regimen.setValue("");
        indauto.setValue("");
        agenret.setValue("");
        account.setValue("");
        account2.setValue("");
        
        dta.setNATIONALID(natid);
        dta.setLCNATIONALIDTYP(lnatid);
        dta.setEXTORGID(exorid);
        dta.setEFFDT(effdt);
        dta.setEFFSTATUS(effdtstts);
        dta.setEXTORGTYPE(extorgtype);
        dta.setDESCR(desc);
        dta.setDESCR50(desc50);
        dta.setDESCRLONG(desclong);
        dta.setORGCONTACT(orgcon);
        dta.setORGLOCATION(orgloc);
        dta.setCOUNTRY(country);
        dta.setADDRESS1(address);
        dta.setSTATE(state);
        dta.setCITY(city);
        dta.setLCESTRATOSOCIAL(lcestrato);
        dta.setCOUNTY(county);
        dta.setURLADDRESS(urladd);
        dta.setEMAILID(email);
        dta.setEDIADDRESS(ediadd);
        dta.setPHONETYPE(phonetype);
        dta.setCOUNTRYCODE(cocod);
        dta.setPHONE(phone);
        dta.setEXTENSION(ext);
        dta.setPREFPHONEFLAG(preflag);
        dta.setECINDCLI(indcli);
        dta.setECDOMLOC(domloc);
        dta.setECREGIMEN(regimen);
        dta.setECINDAUTO(indauto);
        dta.setECAGENRET(agenret);
        dta.setECACCOUNT(account);
        dta.setECACCOUNT2(account2);
        dta.setClazz("R");
        
        transac.setECIBINTOTBL(dta);
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTOTBL(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        EJEC.ecIBINTOOPRSRV(ws_serv);
    }
    
    
    
    private static void ecIBINTOOPRSRV(com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOREQMSGTypeShape parameter) {
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_o_srv.ECIBINTOSRV service = new com.oracle.xmlns.enterprise.tools.services.ec_ib_int_o_srv.ECIBINTOSRV();
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_o_srv.ECIBINTOSRVPortType port = service.getECIBINTOSRVPort();
        
        //Logica oara agregar parametro al url
        BindingProvider bp= (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY)+"?From=EC_NODSG");
        port.ecIBINTOOPRSRV(parameter);
    }   
    
    public static void enviarOrganizacion(String nit, String razon_social, String dir_empresa, String ciudad_empresa, String pais_empresa, String web_empresa, String email_empresa, 
            String tel_empresa, String nom_rrhh, String tel_rrhh, String email_rrhh, String nom_contacto, String profesion_contacto, String cargo_contacto, String area_contacto,
            String tel_contacto, String fax_contacto, String email_contacto, String cel_contacto){
        
        
        CreaOrganizacion EJEC = new CreaOrganizacion();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOREQMSGTypeShape ws_serv       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOREQMSGTypeShape(); 
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesTypeShape msgdatainf        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.MsgDataTypeShape  msgdata             = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.MsgDataTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.TransactionTypeShape transac          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.TransactionTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesECIBINTOTBLTypeShape dtainf = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesECIBINTOTBLTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOTBLMsgDataRecordTypeShape dta = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECIBINTOTBLMsgDataRecordTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.NATIONALIDTypeShape natid             = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.NATIONALIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.LCNATIONALIDTYPTypeShape lnatid       = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.LCNATIONALIDTYPTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTORGIDTypeShape exorid              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTORGIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EFFDTTypeShape effdt                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EFFDTTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EFFSTATUSTypeShape effdtstts          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EFFSTATUSTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTORGTYPETypeShape extorgtype        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTORGTYPETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCRTypeShape desc                   = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCRTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCR50TypeShape desc50               = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCR50TypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCRLONGTypeShape desclong           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.DESCRLONGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGCONTACTTypeShape orgcon            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGCONTACTTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGLOCATIONTypeShape orgloc           = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGLOCATIONTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTRYTypeShape country              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTRYTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ADDRESS1TypeShape address             = new   com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ADDRESS1TypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.STATETypeShape state                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.STATETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.CITYTypeShape city                    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.CITYTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.LCESTRATOSOCIALTypeShape lcestrato    = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.LCESTRATOSOCIALTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTYTypeShape county                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTYTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.URLADDRESSTypeShape urladd            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.URLADDRESSTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EMAILIDTypeShape email                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EMAILIDTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EDIADDRESSTypeShape ediadd            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EDIADDRESSTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PHONETYPETypeShape phonetype          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PHONETYPETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTRYCODETypeShape cocod            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.COUNTRYCODETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PHONETypeShape phone                  = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PHONETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTENSIONTypeShape ext                = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.EXTENSIONTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PREFPHONEFLAGTypeShape preflag        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.PREFPHONEFLAGTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECINDCLITypeShape indcli              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECINDCLITypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECDOMLOCTypeShape domloc              = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECDOMLOCTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECREGIMENTypeShape regimen            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECREGIMENTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECINDAUTOTypeShape indauto            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECINDAUTOTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECAGENRETTypeShape agenret            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECAGENRETTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECACCOUNTTypeShape account            = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECACCOUNTTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECACCOUNT2TypeShape account2          = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ECACCOUNT2TypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.CONTACTNAMETypeShape coname           = new CONTACTNAMETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.JOBTITLETypeShape cargocon            = new JOBTITLETypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.ORGDEPARTMENTTypeShape areacon        = new ORGDEPARTMENTTypeShape();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesCharFieldType fieldc        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesCharFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesDateFieldType fieldd        = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesDateFieldType();
        com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesNumberFieldType fieldn      = new com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_o_req_msg.FieldTypesNumberFieldType();
       
        dtainf.setNATIONALID(fieldc);
        dtainf.setLCNATIONALIDTYP(fieldc);
        dtainf.setEXTORGID(fieldc);
        dtainf.setEFFDT(fieldd);
        dtainf.setEFFSTATUS(fieldc);
        dtainf.setEXTORGTYPE(fieldc);
        dtainf.setDESCR(fieldc);
        dtainf.setDESCR50(fieldc);
        dtainf.setDESCRLONG(fieldc);
        dtainf.setORGCONTACT(fieldn);
        dtainf.setORGLOCATION(fieldn);
        dtainf.setCOUNTRY(fieldc);
        dtainf.setADDRESS1(fieldc);
        dtainf.setSTATE(fieldc);
        dtainf.setCITY(fieldc);
        dtainf.setLCESTRATOSOCIAL(fieldc);
        dtainf.setCOUNTRY(fieldc);
        dtainf.setURLADDRESS(fieldc);
        dtainf.setEMAILID(fieldc);
        dtainf.setEDIADDRESS(fieldc);
        dtainf.setPHONETYPE(fieldc);
        dtainf.setCOUNTRYCODE(fieldc);
        dtainf.setPHONE(fieldc);
        dtainf.setEXTENSION(fieldc);
        dtainf.setPREFPHONEFLAG(fieldc);
        dtainf.setECINDCLI(fieldc);
        dtainf.setECDOMLOC(fieldc);
        dtainf.setECREGIMEN(fieldc);
        dtainf.setECINDAUTO(fieldc);
        dtainf.setECAGENRET(fieldc);
        dtainf.setECACCOUNT(fieldc);
        dtainf.setECACCOUNT2(fieldc);
        dtainf.setCONTACTNAME(fieldc);
        dtainf.setJOBTITLE(fieldc);
        dtainf.setORGDEPARTMENT(fieldn);
        
        XMLGregorianCalendar effdate=null;
        
        //Definicion de la fecha
        String dateFormat = "yyyy-MM-dd";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String effdtstring= sdf.format(cal.getTime());
        GregorianCalendar c = new GregorianCalendar();
        XMLGregorianCalendar xmldate = null;
        try {
            c.setTime(sdf.parse(effdtstring));
            xmldate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (ParseException ex) {
            Logger.getLogger(CreaOrganizacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(CreaOrganizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        BigInteger orgcontact = new BigInteger("1");
        
        natid.setValue(nit);
        lnatid.setValue("NI");
        //exorid.setValue("ORG11112222");
        //exorid.setValue("");
        effdt.setValue(xmldate);
        effdtstts.setValue("A");
        extorgtype.setValue("BUSN");
        
        desc.setValue(razon_social.length()>30?razon_social.substring(0, 29):razon_social);
        desc50.setValue(razon_social.length()>50?razon_social.substring(0, 49):razon_social);
        desclong.setValue(razon_social);
        country.setValue(pais_empresa);
        address.setValue(dir_empresa);
        state.setValue("11");
        city.setValue(ciudad_empresa);
        lcestrato.setValue("6");
        urladd.setValue(web_empresa);
        
        email.setValue(email_empresa);
        ediadd.setValue("");
        phonetype.setValue("BUSN");
        cocod.setValue("");
        
        phone.setValue(tel_empresa);
        ext.setValue("");
        preflag.setValue("Y");
        indcli.setValue("1");
        domloc.setValue("");
        regimen.setValue("2");
        indauto.setValue("");
        agenret.setValue("");
        account.setValue("");
        account2.setValue("");
        coname.setValue(nom_contacto);
        cargocon.setValue(cargo_contacto);
        areacon.setValue(new BigInteger("1"));
        orgcon.setValue(new BigInteger("0"));
        orgloc.setValue(new BigInteger("1"));
        
        dta.setNATIONALID(natid);
        dta.setLCNATIONALIDTYP(lnatid);
        dta.setEXTORGID(exorid);
        dta.setEFFDT(effdt);
        dta.setEFFSTATUS(effdtstts);
        dta.setEXTORGTYPE(extorgtype);
        dta.setDESCR(desc);
        dta.setDESCR50(desc50);
        dta.setDESCRLONG(desclong);
        dta.setORGCONTACT(orgcon);
        dta.setORGLOCATION(orgloc);
        dta.setCOUNTRY(country);
        dta.setADDRESS1(address);
        dta.setSTATE(state);
        dta.setCITY(city);
        dta.setLCESTRATOSOCIAL(lcestrato);
        dta.setCOUNTY(county);
        dta.setURLADDRESS(urladd);
        dta.setEMAILID(email);
        dta.setEDIADDRESS(ediadd);
        dta.setPHONETYPE(phonetype);
        dta.setCOUNTRYCODE(cocod);
        dta.setPHONE(phone);
        dta.setEXTENSION(ext);
        dta.setPREFPHONEFLAG(preflag);
        dta.setECINDCLI(indcli);
        dta.setECDOMLOC(domloc);
        dta.setECREGIMEN(regimen);
        dta.setECINDAUTO(indauto);
        dta.setECAGENRET(agenret);
        dta.setECACCOUNT(account);
        dta.setECACCOUNT2(account2);
        dta.setCONTACTNAME(coname);
        dta.setJOBTITLE(cargocon);
        dta.setORGDEPARTMENT(areacon);
        dta.setClazz("R");
        
        //PRIMER ENVIO CON PRIMER CONTACTO Y UBICACION
        
        
        transac.setECIBINTOTBL(dta);
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTOTBL(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        EJEC.ecIBINTOOPRSRV(ws_serv);
        
        //SEGUNDO ENVIO CON SEGUNDO CONTACTO Y SEGUNDA UBICACION
        
        phone.setValue(tel_contacto);
        email.setValue(email_contacto);
        dta.setEMAILID(email);
        dta.setPHONE(phone);
        orgcon.setValue(new BigInteger("1"));
        orgloc.setValue(new BigInteger("0"));
        dta.setORGCONTACT(orgcon);
        dta.setORGLOCATION(orgloc);
        
        transac.setECIBINTOTBL(dta);
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTOTBL(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        EJEC.ecIBINTOOPRSRV(ws_serv);
        
        
    }

    
    
    
    
}
