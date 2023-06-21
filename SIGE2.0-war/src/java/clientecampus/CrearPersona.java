/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecampus;



import com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_req_msg.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author andres.rojas
 */
public class CrearPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, DatatypeConfigurationException {
        
        CrearPersona EJEC= new CrearPersona();
        ECIBINTREQMSGTypeShape ws_serv = new ECIBINTREQMSGTypeShape();
        FieldTypesECIBINTPTBLTypeShape  dtainf = new FieldTypesECIBINTPTBLTypeShape();
        ECIBINTPTBLMsgDataRecordTypeShape dta = new ECIBINTPTBLMsgDataRecordTypeShape();
        FieldTypesTypeShape msgdatainf        = new FieldTypesTypeShape();
        MsgDataTypeShape  msgdata             = new MsgDataTypeShape();
        TransactionTypeShape transac          = new TransactionTypeShape();
        
        
        EMPLIDTypeShape emplid = new EMPLIDTypeShape();
        CITYTypeShape city                    = new CITYTypeShape();
        COUNTRY2TypeShape country              = new COUNTRY2TypeShape();
        ADDRESS1TypeShape address             = new ADDRESS1TypeShape();
        EMAILADDRTypeShape email = new EMAILADDRTypeShape();
        STATETypeShape state = new STATETypeShape();
        PHONETypeShape phone = new PHONETypeShape();
        ECACTUALIZACIONESTypeShape act = new ECACTUALIZACIONESTypeShape();
        EFFSTATUSTypeShape effst = new EFFSTATUSTypeShape();
        PRIMARYNIDTypeShape prinid = new PRIMARYNIDTypeShape();
        PHONETYPETypeShape phonetype = new PHONETYPETypeShape();
        EADDRTYPETypeShape mailtype = new EADDRTYPETypeShape();
        PREFEMAILFLAGTypeShape prefmail = new PREFEMAILFLAGTypeShape();
        PREFPHONEFLAGTypeShape prefphone = new PREFPHONEFLAGTypeShape();
        ADDRESSTYPETypeShape addresstypets = new ADDRESSTYPETypeShape();
        
        FieldTypesCharFieldType fieldc        = new FieldTypesCharFieldType();
        FieldTypesDateFieldType fieldd        = new FieldTypesDateFieldType();
        FieldTypesNumberFieldType fieldn      = new FieldTypesNumberFieldType();
        
        EFFDTTypeShape effdt                  = new EFFDTTypeShape();
        EFFSTATUSTypeShape effdtstts          = new EFFSTATUSTypeShape();
        

        
        //Empl_Id
        dtainf.setEMPLID(fieldc);
        //Ciudad
        dtainf.setCITY(fieldc);
        //Pais
        dtainf.setCOUNTRY2(fieldc);
        //Direccion
        dtainf.setADDRESS1(fieldc);
        //Correo
        dtainf.setEMAILADDR(fieldc);
        //Departamento
        dtainf.setSTATE(fieldc);
        //Telefono
        dtainf.setPHONE(fieldc);
        //Bandera Actualizacion
        dtainf.setECACTUALIZACIONES(fieldc);
        //Fecha efectiva
        dtainf.setEFFSTATUS(fieldc);
        //Tipo Tel
        dtainf.setPHONETYPE(fieldc);
        //Tipo Mail
        dtainf.setEADDRTYPE(fieldc);
        //Pref Mail
        dtainf.setPREFEMAILFLAG(fieldc);
        //Pref Tel
        dtainf.setPREFPHONEFLAG(fieldc);
        //PriId
        dtainf.setPRIMARYNID(fieldc);
        //AddressType
        dtainf.setADDRESSTYPE(fieldc);
        
        //Definicion de la fecha
        String dateFormat = "yyyy-MM-dd";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String effdtstring= sdf.format(cal.getTime());
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(sdf.parse(effdtstring));
        XMLGregorianCalendar xmldate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        

        
        emplid.setValue("1000000411");
        city.setValue("1");
        country.setValue("BRA");
        address.setValue("Elm Street");
        email.setValue("prueba@mail.com");
        state.setValue("1");
        phone.setValue("7594321");
        act.setValue("2,3,4");
        effst.setValue("A");
        effdt.setValue(xmldate);
        phonetype.setValue("OTR");
        mailtype.setValue("OTHR");
        prefmail.setValue("Y");
        prefphone.setValue("Y");
        prinid.setValue("Y");
        addresstypets.setValue("OTR");
        
        
        
        
        
        dta.setEMPLID(emplid);
        dta.setCITY(city);
        dta.setCOUNTRY2(country);
        dta.setADDRESS1(address);
        dta.setEMAILADDR(email);
        dta.setSTATE(state);
        dta.setPHONE(phone);
        dta.setECACTUALIZACIONES(act);
        dta.setEFFSTATUS(effst);
        dta.setEFFDT(effdt);
        dta.setPHONETYPE(phonetype);
        dta.setEADDRTYPE(mailtype);
        dta.setPREFEMAILFLAG(prefmail);
        dta.setPREFPHONEFLAG(prefphone);
        dta.setPRIMARYNID(prinid);
        dta.setADDRESSTYPE(addresstypets);
        dta.setClazz("R");
        
        transac.setECIBINTPTBL(dta);
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTPTBL(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        
        EJEC.ecIBINTOPRSRV(ws_serv);
        
        
                
        
    }   

    private static void ecIBINTOPRSRV(com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_req_msg.ECIBINTREQMSGTypeShape parameter) {
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_srv.ECIBINTSRV service = new com.oracle.xmlns.enterprise.tools.services.ec_ib_int_srv.ECIBINTSRV();
        com.oracle.xmlns.enterprise.tools.services.ec_ib_int_srv.ECIBINTSRVPortType port = service.getECIBINTSRVPort();
        //Logica oara agregar parametro al url
        BindingProvider bp= (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY)+"?From=EC_NODSG");
        port.ecIBINTOPRSRV(parameter);
    }
    
    
    public static void modificaPersona(String empl_id_st, String city_st, String country_st, String address_st, String email_st, String phone_st, String nat_id_st){
        CrearPersona EJEC= new CrearPersona();
        ECIBINTREQMSGTypeShape ws_serv = new ECIBINTREQMSGTypeShape();
        FieldTypesECIBINTPTBLTypeShape  dtainf = new FieldTypesECIBINTPTBLTypeShape();
        ECIBINTPTBLMsgDataRecordTypeShape dta = new ECIBINTPTBLMsgDataRecordTypeShape();
        FieldTypesTypeShape msgdatainf        = new FieldTypesTypeShape();
        MsgDataTypeShape  msgdata             = new MsgDataTypeShape();
        TransactionTypeShape transac          = new TransactionTypeShape();
        ECACTUALIZACIONESTypeShape act = new ECACTUALIZACIONESTypeShape();
        EMPLIDTypeShape emplid = new EMPLIDTypeShape();
        CITYTypeShape city                    = new CITYTypeShape();
        COUNTRY2TypeShape country              = new COUNTRY2TypeShape();
        ADDRESS1TypeShape address             = new ADDRESS1TypeShape();
        EMAILADDRTypeShape email = new EMAILADDRTypeShape();
        //STATETypeShape state = new STATETypeShape();
        PHONETypeShape phone = new PHONETypeShape();
        FieldTypesCharFieldType fieldc        = new FieldTypesCharFieldType();
        FieldTypesDateFieldType fieldd        = new FieldTypesDateFieldType();
        FieldTypesNumberFieldType fieldn      = new FieldTypesNumberFieldType();
        EFFDTTypeShape effdt                  = new EFFDTTypeShape();
        EFFSTATUSTypeShape effdtstts          = new EFFSTATUSTypeShape();
        ROLENAMETypeShape rolename            = new ROLENAMETypeShape();
        NATIONALIDTypeShape nat_id            = new NATIONALIDTypeShape();
        NATIONALIDTYPETypeShape nat_id_type   = new NATIONALIDTYPETypeShape();
        EADDRTYPETypeShape email_type         = new EADDRTYPETypeShape();
        PREFEMAILFLAGTypeShape pref_email     = new PREFEMAILFLAGTypeShape();
        PHONETYPETypeShape phone_type         = new PHONETYPETypeShape();
        PREFPHONEFLAGTypeShape pref_phone     = new PREFPHONEFLAGTypeShape();
        ADDRESSTYPETypeShape address_type     = new ADDRESSTYPETypeShape();
        
        
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
        
        //Empl_Id
        dtainf.setEMPLID(fieldc);
        //Ciudad
        dtainf.setCITY(fieldc);
        //Pais
        dtainf.setCOUNTRY2(fieldc);
        //Direccion
        dtainf.setADDRESS1(fieldc);
        //Correo
        dtainf.setEMAILADDR(fieldc);
        //Departamento
        //dtainf.setSTATE(fieldc);
        //Telefono
        dtainf.setPHONE(fieldc);
        dtainf.setECACTUALIZACIONES(fieldc);
        dtainf.setEFFDT(fieldd);
        dtainf.setEFFSTATUS(fieldc);
        dtainf.setROLENAME(fieldc);
        dtainf.setNATIONALID(fieldc);
        dtainf.setNATIONALIDTYPE(fieldc);
        dtainf.setEADDRTYPE(fieldc);
        dtainf.setPREFEMAILFLAG(fieldc);
        dtainf.setPHONETYPE(fieldc);
        dtainf.setPREFPHONEFLAG(fieldc);
        dtainf.setADDRESSTYPE(fieldc);
        
        emplid.setValue(empl_id_st);
        city.setValue(city_st);
        country.setValue(country_st);
        address.setValue(address_st);
        email.setValue(email_st);
        //state.setValue(state_st);
        phone.setValue(phone_st);
        act.setValue("2,3,4");
        effdt.setValue(xmldate);
        effdtstts.setValue("A");
        rolename.setValue("GRADUADO");
        nat_id.setValue(nat_id_st);
        nat_id_type.setValue("CC");
        email_type.setValue("OTHR");
        pref_email.setValue("Y");
        phone_type.setValue("OTR");
        pref_phone.setValue("Y");
        address_type.setValue("OTH");
        
        
        
        dta.setEMPLID(emplid);
        dta.setCITY(city);
        dta.setCOUNTRY2(country);
        dta.setADDRESS1(address);
        dta.setEMAILADDR(email);
        //dta.setSTATE(state);
        dta.setPHONE(phone);
        dta.setECACTUALIZACIONES(act);
        dta.setEFFDT(effdt);
        dta.setEFFSTATUS(effdtstts);
        dta.setROLENAME(rolename);
        dta.setNATIONALID(nat_id);
        dta.setNATIONALIDTYPE(nat_id_type);
        dta.setEADDRTYPE(email_type);
        dta.setPREFEMAILFLAG(pref_email);
        dta.setPHONETYPE(phone_type);
        dta.setPREFPHONEFLAG(pref_phone);
        dta.setADDRESSTYPE(address_type);
        dta.setClazz("R");
        
        transac.setECIBINTPTBL(dta);
        msgdata.setTransaction(transac);
        msgdatainf.setECIBINTPTBL(dtainf);
        
        ws_serv.setFieldTypes(msgdatainf);
        ws_serv.setMsgData(msgdata);
        
        EJEC.ecIBINTOPRSRV(ws_serv);
    }
            
}
