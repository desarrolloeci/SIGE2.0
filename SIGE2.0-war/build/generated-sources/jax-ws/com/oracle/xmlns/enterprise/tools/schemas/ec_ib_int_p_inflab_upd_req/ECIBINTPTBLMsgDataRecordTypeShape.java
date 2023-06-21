
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_upd_req;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EC_IB_INTP_TBLMsgDataRecord_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EC_IB_INTP_TBLMsgDataRecord_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EMPLID_TypeShape"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EFFDT_TypeShape"/&gt;
 *         &lt;element name="EC_ACTUALIZACIONES" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_ACTUALIZACIONES_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EFF_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EFF_STATUS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="NAME_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}NAME_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="FIRST_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}FIRST_NAME_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="MIDDLE_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}MIDDLE_NAME_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="LAST_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}LAST_NAME_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="SECOND_LAST_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}SECOND_LAST_NAME_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="BIRTHDATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}BIRTHDATE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="BIRTHPLACE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}BIRTHPLACE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="BIRTHCOUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}BIRTHCOUNTRY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="BIRTHSTATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}BIRTHSTATE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="CAMPUS_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}CAMPUS_ID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="MAR_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}MAR_STATUS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="MAR_STATUS_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}MAR_STATUS_DT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="SEX" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}SEX_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}COUNTRY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="NATIONAL_ID_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}NATIONAL_ID_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="NATIONAL_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}NATIONAL_ID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="LC_STATE3" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}LC_STATE3_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="CITY_AC" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}CITY_AC_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PRIMARY_NID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PRIMARY_NID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ADDRESS_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY2" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}COUNTRY2_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS1" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ADDRESS1_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS2" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ADDRESS2_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="CITY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}CITY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="STATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}STATE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="LC_ESTRATO_SOCIAL" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}LC_ESTRATO_SOCIAL_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="COUNTY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}COUNTY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="BLOOD_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}BLOOD_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PHONE_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PHONE_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PHONE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PHONE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EXTENSION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EXTENSION_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY_CODE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}COUNTRY_CODE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PREF_PHONE_FLAG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PREF_PHONE_FLAG_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="E_ADDR_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}E_ADDR_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EMAIL_ADDR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EMAIL_ADDR_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PREF_EMAIL_FLAG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PREF_EMAIL_FLAG_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="OPRID_APPROVED_BY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}OPRID_APPROVED_BY_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="OPRID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}OPRID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="INSTITUTION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}INSTITUTION_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_ORG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ACAD_ORG_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="INSTR_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}INSTR_TYPE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_CAREER" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ACAD_CAREER_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="STRM" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}STRM_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_PROG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ACAD_PROG_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ADM_RECR_CTR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ADM_RECR_CTR_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PROG_ACTION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PROG_ACTION_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="STDNT_CAR_NBR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}STDNT_CAR_NBR_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="CAMPUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}CAMPUS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ADMIT_TERM" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ADMIT_TERM_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EFFDT_ADDR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EFFDT_ADDR_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="PROG_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PROG_STATUS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="TEMPLATE_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}TEMPLATE_ID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="TEMPLATE_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}TEMPLATE_STATUS_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ALTER_EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ALTER_EMPLID_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ROLENAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ROLENAME_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_ACUDIENTE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_ACUDIENTE_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_DOBLE_TIT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_DOBLE_TIT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_PROM_ACUM" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_PROM_ACUM_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_PROM_ANT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_PROM_ANT_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_ULT_SEMES" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_ULT_SEMES_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="OPERPSWD" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}OPERPSWD_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EC_ROL_ADM" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_ROL_ADM_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_ORG1" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}ACAD_ORG1_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="EFFDT_ADD" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EFFDT_ADD_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="CONTACT_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}CONTACT_NAME_TypeShape" minOccurs="0"/&gt;
 *         &lt;element name="GUARDIAN_RELATIONS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}GUARDIAN_RELATIONS_TypeShape" minOccurs="0"/&gt;
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="EC_PERSWORK_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_PERSWORK_WRKMsgDataRecord_TypeShape"/&gt;
 *           &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PSCAMAMsgDataRecord_TypeShape" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="EC_PERS_EXP_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_PERS_EXP_WRKMsgDataRecord_TypeShape"/&gt;
 *           &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PSCAMAMsgDataRecord_TypeShape" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="EC_PERS_EDU_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_PERS_EDU_WRKMsgDataRecord_TypeShape"/&gt;
 *           &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PSCAMAMsgDataRecord_TypeShape" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="EC_PERSLANG_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_PERSLANG_WRKMsgDataRecord_TypeShape"/&gt;
 *           &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PSCAMAMsgDataRecord_TypeShape" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="EC_PERS_MEM_WRK" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}EC_PERS_MEM_WRKMsgDataRecord_TypeShape"/&gt;
 *           &lt;element name="PSCAMA" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_UPD_REQ.V1}PSCAMAMsgDataRecord_TypeShape" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="class" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="R" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EC_IB_INTP_TBLMsgDataRecord_TypeShape", propOrder = {
    "emplid",
    "effdt",
    "ecactualizaciones",
    "effstatus",
    "nametype",
    "firstname",
    "middlename",
    "lastname",
    "secondlastname",
    "birthdate",
    "birthplace",
    "birthcountry",
    "birthstate",
    "campusid",
    "marstatus",
    "marstatusdt",
    "sex",
    "country",
    "nationalidtype",
    "nationalid",
    "lcstate3",
    "cityac",
    "primarynid",
    "addresstype",
    "country2",
    "address1",
    "address2",
    "city",
    "state",
    "lcestratosocial",
    "county",
    "bloodtype",
    "phonetype",
    "phone",
    "extension",
    "countrycode",
    "prefphoneflag",
    "eaddrtype",
    "emailaddr",
    "prefemailflag",
    "opridapprovedby",
    "oprid",
    "institution",
    "acadorg",
    "instrtype",
    "acadcareer",
    "strm",
    "acadprog",
    "admrecrctr",
    "progaction",
    "stdntcarnbr",
    "campus",
    "admitterm",
    "effdtaddr",
    "progstatus",
    "templateid",
    "templatestatus",
    "alteremplid",
    "rolename",
    "ecacudiente",
    "ecdobletit",
    "ecpromacum",
    "ecpromant",
    "ecultsemes",
    "operpswd",
    "ecroladm",
    "acadorg1",
    "effdtadd",
    "contactname",
    "guardianrelations",
    "ecpersworkwrkAndPSCAMA",
    "ecpersexpwrkAndPSCAMA",
    "ecperseduwrkAndPSCAMA",
    "ecperslangwrkAndPSCAMA",
    "ecpersmemwrkAndPSCAMA"
})
public class ECIBINTPTBLMsgDataRecordTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected EMPLIDTypeShape emplid;
    @XmlElement(name = "EFFDT", required = true)
    protected EFFDTTypeShape effdt;
    @XmlElement(name = "EC_ACTUALIZACIONES")
    protected ECACTUALIZACIONESTypeShape ecactualizaciones;
    @XmlElement(name = "EFF_STATUS")
    protected EFFSTATUSTypeShape effstatus;
    @XmlElement(name = "NAME_TYPE")
    protected NAMETYPETypeShape nametype;
    @XmlElement(name = "FIRST_NAME")
    protected FIRSTNAMETypeShape firstname;
    @XmlElement(name = "MIDDLE_NAME")
    protected MIDDLENAMETypeShape middlename;
    @XmlElement(name = "LAST_NAME")
    protected LASTNAMETypeShape lastname;
    @XmlElement(name = "SECOND_LAST_NAME")
    protected SECONDLASTNAMETypeShape secondlastname;
    @XmlElement(name = "BIRTHDATE")
    protected BIRTHDATETypeShape birthdate;
    @XmlElement(name = "BIRTHPLACE")
    protected BIRTHPLACETypeShape birthplace;
    @XmlElement(name = "BIRTHCOUNTRY")
    protected BIRTHCOUNTRYTypeShape birthcountry;
    @XmlElement(name = "BIRTHSTATE")
    protected BIRTHSTATETypeShape birthstate;
    @XmlElement(name = "CAMPUS_ID")
    protected CAMPUSIDTypeShape campusid;
    @XmlElement(name = "MAR_STATUS")
    protected MARSTATUSTypeShape marstatus;
    @XmlElement(name = "MAR_STATUS_DT")
    protected MARSTATUSDTTypeShape marstatusdt;
    @XmlElement(name = "SEX")
    protected SEXTypeShape sex;
    @XmlElement(name = "COUNTRY")
    protected COUNTRYTypeShape country;
    @XmlElement(name = "NATIONAL_ID_TYPE")
    protected NATIONALIDTYPETypeShape nationalidtype;
    @XmlElement(name = "NATIONAL_ID")
    protected NATIONALIDTypeShape nationalid;
    @XmlElement(name = "LC_STATE3")
    protected LCSTATE3TypeShape lcstate3;
    @XmlElement(name = "CITY_AC")
    protected CITYACTypeShape cityac;
    @XmlElement(name = "PRIMARY_NID")
    protected PRIMARYNIDTypeShape primarynid;
    @XmlElement(name = "ADDRESS_TYPE")
    protected ADDRESSTYPETypeShape addresstype;
    @XmlElement(name = "COUNTRY2")
    protected COUNTRY2TypeShape country2;
    @XmlElement(name = "ADDRESS1")
    protected ADDRESS1TypeShape address1;
    @XmlElement(name = "ADDRESS2")
    protected ADDRESS2TypeShape address2;
    @XmlElement(name = "CITY")
    protected CITYTypeShape city;
    @XmlElement(name = "STATE")
    protected STATETypeShape state;
    @XmlElement(name = "LC_ESTRATO_SOCIAL")
    protected LCESTRATOSOCIALTypeShape lcestratosocial;
    @XmlElement(name = "COUNTY")
    protected COUNTYTypeShape county;
    @XmlElement(name = "BLOOD_TYPE")
    protected BLOODTYPETypeShape bloodtype;
    @XmlElement(name = "PHONE_TYPE")
    protected PHONETYPETypeShape phonetype;
    @XmlElement(name = "PHONE")
    protected PHONETypeShape phone;
    @XmlElement(name = "EXTENSION")
    protected EXTENSIONTypeShape extension;
    @XmlElement(name = "COUNTRY_CODE")
    protected COUNTRYCODETypeShape countrycode;
    @XmlElement(name = "PREF_PHONE_FLAG")
    protected PREFPHONEFLAGTypeShape prefphoneflag;
    @XmlElement(name = "E_ADDR_TYPE")
    protected EADDRTYPETypeShape eaddrtype;
    @XmlElement(name = "EMAIL_ADDR")
    protected EMAILADDRTypeShape emailaddr;
    @XmlElement(name = "PREF_EMAIL_FLAG")
    protected PREFEMAILFLAGTypeShape prefemailflag;
    @XmlElement(name = "OPRID_APPROVED_BY")
    protected OPRIDAPPROVEDBYTypeShape opridapprovedby;
    @XmlElement(name = "OPRID")
    protected OPRIDTypeShape oprid;
    @XmlElement(name = "INSTITUTION")
    protected INSTITUTIONTypeShape institution;
    @XmlElement(name = "ACAD_ORG")
    protected ACADORGTypeShape acadorg;
    @XmlElement(name = "INSTR_TYPE")
    protected INSTRTYPETypeShape instrtype;
    @XmlElement(name = "ACAD_CAREER")
    protected ACADCAREERTypeShape acadcareer;
    @XmlElement(name = "STRM")
    protected STRMTypeShape strm;
    @XmlElement(name = "ACAD_PROG")
    protected ACADPROGTypeShape acadprog;
    @XmlElement(name = "ADM_RECR_CTR")
    protected ADMRECRCTRTypeShape admrecrctr;
    @XmlElement(name = "PROG_ACTION")
    protected PROGACTIONTypeShape progaction;
    @XmlElement(name = "STDNT_CAR_NBR")
    protected STDNTCARNBRTypeShape stdntcarnbr;
    @XmlElement(name = "CAMPUS")
    protected CAMPUSTypeShape campus;
    @XmlElement(name = "ADMIT_TERM")
    protected ADMITTERMTypeShape admitterm;
    @XmlElement(name = "EFFDT_ADDR")
    protected EFFDTADDRTypeShape effdtaddr;
    @XmlElement(name = "PROG_STATUS")
    protected PROGSTATUSTypeShape progstatus;
    @XmlElement(name = "TEMPLATE_ID")
    protected TEMPLATEIDTypeShape templateid;
    @XmlElement(name = "TEMPLATE_STATUS")
    protected TEMPLATESTATUSTypeShape templatestatus;
    @XmlElement(name = "ALTER_EMPLID")
    protected ALTEREMPLIDTypeShape alteremplid;
    @XmlElement(name = "ROLENAME")
    protected ROLENAMETypeShape rolename;
    @XmlElement(name = "EC_ACUDIENTE")
    protected ECACUDIENTETypeShape ecacudiente;
    @XmlElement(name = "EC_DOBLE_TIT")
    protected ECDOBLETITTypeShape ecdobletit;
    @XmlElement(name = "EC_PROM_ACUM")
    protected ECPROMACUMTypeShape ecpromacum;
    @XmlElement(name = "EC_PROM_ANT")
    protected ECPROMANTTypeShape ecpromant;
    @XmlElement(name = "EC_ULT_SEMES")
    protected ECULTSEMESTypeShape ecultsemes;
    @XmlElement(name = "OPERPSWD")
    protected OPERPSWDTypeShape operpswd;
    @XmlElement(name = "EC_ROL_ADM")
    protected ECROLADMTypeShape ecroladm;
    @XmlElement(name = "ACAD_ORG1")
    protected ACADORG1TypeShape acadorg1;
    @XmlElement(name = "EFFDT_ADD")
    protected EFFDTADDTypeShape effdtadd;
    @XmlElement(name = "CONTACT_NAME")
    protected CONTACTNAMETypeShape contactname;
    @XmlElement(name = "GUARDIAN_RELATIONS")
    protected GUARDIANRELATIONSTypeShape guardianrelations;
    @XmlElements({
        @XmlElement(name = "EC_PERSWORK_WRK", type = ECPERSWORKWRKMsgDataRecordTypeShape.class),
        @XmlElement(name = "PSCAMA", type = PSCAMAMsgDataRecordTypeShape.class)
    })
    protected List<Object> ecpersworkwrkAndPSCAMA;
    @XmlElements({
        @XmlElement(name = "EC_PERS_EXP_WRK", type = ECPERSEXPWRKMsgDataRecordTypeShape.class),
        @XmlElement(name = "PSCAMA", type = PSCAMAMsgDataRecordTypeShape.class)
    })
    protected List<Object> ecpersexpwrkAndPSCAMA;
    @XmlElements({
        @XmlElement(name = "EC_PERS_EDU_WRK", type = ECPERSEDUWRKMsgDataRecordTypeShape.class),
        @XmlElement(name = "PSCAMA", type = PSCAMAMsgDataRecordTypeShape.class)
    })
    protected List<Object> ecperseduwrkAndPSCAMA;
    @XmlElements({
        @XmlElement(name = "EC_PERSLANG_WRK", type = ECPERSLANGWRKMsgDataRecordTypeShape.class),
        @XmlElement(name = "PSCAMA", type = PSCAMAMsgDataRecordTypeShape.class)
    })
    protected List<Object> ecperslangwrkAndPSCAMA;
    @XmlElements({
        @XmlElement(name = "EC_PERS_MEM_WRK", type = ECPERSMEMWRKMsgDataRecordTypeShape.class),
        @XmlElement(name = "PSCAMA", type = PSCAMAMsgDataRecordTypeShape.class)
    })
    protected List<Object> ecpersmemwrkAndPSCAMA;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad emplid.
     * 
     * @return
     *     possible object is
     *     {@link EMPLIDTypeShape }
     *     
     */
    public EMPLIDTypeShape getEMPLID() {
        return emplid;
    }

    /**
     * Define el valor de la propiedad emplid.
     * 
     * @param value
     *     allowed object is
     *     {@link EMPLIDTypeShape }
     *     
     */
    public void setEMPLID(EMPLIDTypeShape value) {
        this.emplid = value;
    }

    /**
     * Obtiene el valor de la propiedad effdt.
     * 
     * @return
     *     possible object is
     *     {@link EFFDTTypeShape }
     *     
     */
    public EFFDTTypeShape getEFFDT() {
        return effdt;
    }

    /**
     * Define el valor de la propiedad effdt.
     * 
     * @param value
     *     allowed object is
     *     {@link EFFDTTypeShape }
     *     
     */
    public void setEFFDT(EFFDTTypeShape value) {
        this.effdt = value;
    }

    /**
     * Obtiene el valor de la propiedad ecactualizaciones.
     * 
     * @return
     *     possible object is
     *     {@link ECACTUALIZACIONESTypeShape }
     *     
     */
    public ECACTUALIZACIONESTypeShape getECACTUALIZACIONES() {
        return ecactualizaciones;
    }

    /**
     * Define el valor de la propiedad ecactualizaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link ECACTUALIZACIONESTypeShape }
     *     
     */
    public void setECACTUALIZACIONES(ECACTUALIZACIONESTypeShape value) {
        this.ecactualizaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad effstatus.
     * 
     * @return
     *     possible object is
     *     {@link EFFSTATUSTypeShape }
     *     
     */
    public EFFSTATUSTypeShape getEFFSTATUS() {
        return effstatus;
    }

    /**
     * Define el valor de la propiedad effstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link EFFSTATUSTypeShape }
     *     
     */
    public void setEFFSTATUS(EFFSTATUSTypeShape value) {
        this.effstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad nametype.
     * 
     * @return
     *     possible object is
     *     {@link NAMETYPETypeShape }
     *     
     */
    public NAMETYPETypeShape getNAMETYPE() {
        return nametype;
    }

    /**
     * Define el valor de la propiedad nametype.
     * 
     * @param value
     *     allowed object is
     *     {@link NAMETYPETypeShape }
     *     
     */
    public void setNAMETYPE(NAMETYPETypeShape value) {
        this.nametype = value;
    }

    /**
     * Obtiene el valor de la propiedad firstname.
     * 
     * @return
     *     possible object is
     *     {@link FIRSTNAMETypeShape }
     *     
     */
    public FIRSTNAMETypeShape getFIRSTNAME() {
        return firstname;
    }

    /**
     * Define el valor de la propiedad firstname.
     * 
     * @param value
     *     allowed object is
     *     {@link FIRSTNAMETypeShape }
     *     
     */
    public void setFIRSTNAME(FIRSTNAMETypeShape value) {
        this.firstname = value;
    }

    /**
     * Obtiene el valor de la propiedad middlename.
     * 
     * @return
     *     possible object is
     *     {@link MIDDLENAMETypeShape }
     *     
     */
    public MIDDLENAMETypeShape getMIDDLENAME() {
        return middlename;
    }

    /**
     * Define el valor de la propiedad middlename.
     * 
     * @param value
     *     allowed object is
     *     {@link MIDDLENAMETypeShape }
     *     
     */
    public void setMIDDLENAME(MIDDLENAMETypeShape value) {
        this.middlename = value;
    }

    /**
     * Obtiene el valor de la propiedad lastname.
     * 
     * @return
     *     possible object is
     *     {@link LASTNAMETypeShape }
     *     
     */
    public LASTNAMETypeShape getLASTNAME() {
        return lastname;
    }

    /**
     * Define el valor de la propiedad lastname.
     * 
     * @param value
     *     allowed object is
     *     {@link LASTNAMETypeShape }
     *     
     */
    public void setLASTNAME(LASTNAMETypeShape value) {
        this.lastname = value;
    }

    /**
     * Obtiene el valor de la propiedad secondlastname.
     * 
     * @return
     *     possible object is
     *     {@link SECONDLASTNAMETypeShape }
     *     
     */
    public SECONDLASTNAMETypeShape getSECONDLASTNAME() {
        return secondlastname;
    }

    /**
     * Define el valor de la propiedad secondlastname.
     * 
     * @param value
     *     allowed object is
     *     {@link SECONDLASTNAMETypeShape }
     *     
     */
    public void setSECONDLASTNAME(SECONDLASTNAMETypeShape value) {
        this.secondlastname = value;
    }

    /**
     * Obtiene el valor de la propiedad birthdate.
     * 
     * @return
     *     possible object is
     *     {@link BIRTHDATETypeShape }
     *     
     */
    public BIRTHDATETypeShape getBIRTHDATE() {
        return birthdate;
    }

    /**
     * Define el valor de la propiedad birthdate.
     * 
     * @param value
     *     allowed object is
     *     {@link BIRTHDATETypeShape }
     *     
     */
    public void setBIRTHDATE(BIRTHDATETypeShape value) {
        this.birthdate = value;
    }

    /**
     * Obtiene el valor de la propiedad birthplace.
     * 
     * @return
     *     possible object is
     *     {@link BIRTHPLACETypeShape }
     *     
     */
    public BIRTHPLACETypeShape getBIRTHPLACE() {
        return birthplace;
    }

    /**
     * Define el valor de la propiedad birthplace.
     * 
     * @param value
     *     allowed object is
     *     {@link BIRTHPLACETypeShape }
     *     
     */
    public void setBIRTHPLACE(BIRTHPLACETypeShape value) {
        this.birthplace = value;
    }

    /**
     * Obtiene el valor de la propiedad birthcountry.
     * 
     * @return
     *     possible object is
     *     {@link BIRTHCOUNTRYTypeShape }
     *     
     */
    public BIRTHCOUNTRYTypeShape getBIRTHCOUNTRY() {
        return birthcountry;
    }

    /**
     * Define el valor de la propiedad birthcountry.
     * 
     * @param value
     *     allowed object is
     *     {@link BIRTHCOUNTRYTypeShape }
     *     
     */
    public void setBIRTHCOUNTRY(BIRTHCOUNTRYTypeShape value) {
        this.birthcountry = value;
    }

    /**
     * Obtiene el valor de la propiedad birthstate.
     * 
     * @return
     *     possible object is
     *     {@link BIRTHSTATETypeShape }
     *     
     */
    public BIRTHSTATETypeShape getBIRTHSTATE() {
        return birthstate;
    }

    /**
     * Define el valor de la propiedad birthstate.
     * 
     * @param value
     *     allowed object is
     *     {@link BIRTHSTATETypeShape }
     *     
     */
    public void setBIRTHSTATE(BIRTHSTATETypeShape value) {
        this.birthstate = value;
    }

    /**
     * Obtiene el valor de la propiedad campusid.
     * 
     * @return
     *     possible object is
     *     {@link CAMPUSIDTypeShape }
     *     
     */
    public CAMPUSIDTypeShape getCAMPUSID() {
        return campusid;
    }

    /**
     * Define el valor de la propiedad campusid.
     * 
     * @param value
     *     allowed object is
     *     {@link CAMPUSIDTypeShape }
     *     
     */
    public void setCAMPUSID(CAMPUSIDTypeShape value) {
        this.campusid = value;
    }

    /**
     * Obtiene el valor de la propiedad marstatus.
     * 
     * @return
     *     possible object is
     *     {@link MARSTATUSTypeShape }
     *     
     */
    public MARSTATUSTypeShape getMARSTATUS() {
        return marstatus;
    }

    /**
     * Define el valor de la propiedad marstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link MARSTATUSTypeShape }
     *     
     */
    public void setMARSTATUS(MARSTATUSTypeShape value) {
        this.marstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad marstatusdt.
     * 
     * @return
     *     possible object is
     *     {@link MARSTATUSDTTypeShape }
     *     
     */
    public MARSTATUSDTTypeShape getMARSTATUSDT() {
        return marstatusdt;
    }

    /**
     * Define el valor de la propiedad marstatusdt.
     * 
     * @param value
     *     allowed object is
     *     {@link MARSTATUSDTTypeShape }
     *     
     */
    public void setMARSTATUSDT(MARSTATUSDTTypeShape value) {
        this.marstatusdt = value;
    }

    /**
     * Obtiene el valor de la propiedad sex.
     * 
     * @return
     *     possible object is
     *     {@link SEXTypeShape }
     *     
     */
    public SEXTypeShape getSEX() {
        return sex;
    }

    /**
     * Define el valor de la propiedad sex.
     * 
     * @param value
     *     allowed object is
     *     {@link SEXTypeShape }
     *     
     */
    public void setSEX(SEXTypeShape value) {
        this.sex = value;
    }

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link COUNTRYTypeShape }
     *     
     */
    public COUNTRYTypeShape getCOUNTRY() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link COUNTRYTypeShape }
     *     
     */
    public void setCOUNTRY(COUNTRYTypeShape value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad nationalidtype.
     * 
     * @return
     *     possible object is
     *     {@link NATIONALIDTYPETypeShape }
     *     
     */
    public NATIONALIDTYPETypeShape getNATIONALIDTYPE() {
        return nationalidtype;
    }

    /**
     * Define el valor de la propiedad nationalidtype.
     * 
     * @param value
     *     allowed object is
     *     {@link NATIONALIDTYPETypeShape }
     *     
     */
    public void setNATIONALIDTYPE(NATIONALIDTYPETypeShape value) {
        this.nationalidtype = value;
    }

    /**
     * Obtiene el valor de la propiedad nationalid.
     * 
     * @return
     *     possible object is
     *     {@link NATIONALIDTypeShape }
     *     
     */
    public NATIONALIDTypeShape getNATIONALID() {
        return nationalid;
    }

    /**
     * Define el valor de la propiedad nationalid.
     * 
     * @param value
     *     allowed object is
     *     {@link NATIONALIDTypeShape }
     *     
     */
    public void setNATIONALID(NATIONALIDTypeShape value) {
        this.nationalid = value;
    }

    /**
     * Obtiene el valor de la propiedad lcstate3.
     * 
     * @return
     *     possible object is
     *     {@link LCSTATE3TypeShape }
     *     
     */
    public LCSTATE3TypeShape getLCSTATE3() {
        return lcstate3;
    }

    /**
     * Define el valor de la propiedad lcstate3.
     * 
     * @param value
     *     allowed object is
     *     {@link LCSTATE3TypeShape }
     *     
     */
    public void setLCSTATE3(LCSTATE3TypeShape value) {
        this.lcstate3 = value;
    }

    /**
     * Obtiene el valor de la propiedad cityac.
     * 
     * @return
     *     possible object is
     *     {@link CITYACTypeShape }
     *     
     */
    public CITYACTypeShape getCITYAC() {
        return cityac;
    }

    /**
     * Define el valor de la propiedad cityac.
     * 
     * @param value
     *     allowed object is
     *     {@link CITYACTypeShape }
     *     
     */
    public void setCITYAC(CITYACTypeShape value) {
        this.cityac = value;
    }

    /**
     * Obtiene el valor de la propiedad primarynid.
     * 
     * @return
     *     possible object is
     *     {@link PRIMARYNIDTypeShape }
     *     
     */
    public PRIMARYNIDTypeShape getPRIMARYNID() {
        return primarynid;
    }

    /**
     * Define el valor de la propiedad primarynid.
     * 
     * @param value
     *     allowed object is
     *     {@link PRIMARYNIDTypeShape }
     *     
     */
    public void setPRIMARYNID(PRIMARYNIDTypeShape value) {
        this.primarynid = value;
    }

    /**
     * Obtiene el valor de la propiedad addresstype.
     * 
     * @return
     *     possible object is
     *     {@link ADDRESSTYPETypeShape }
     *     
     */
    public ADDRESSTYPETypeShape getADDRESSTYPE() {
        return addresstype;
    }

    /**
     * Define el valor de la propiedad addresstype.
     * 
     * @param value
     *     allowed object is
     *     {@link ADDRESSTYPETypeShape }
     *     
     */
    public void setADDRESSTYPE(ADDRESSTYPETypeShape value) {
        this.addresstype = value;
    }

    /**
     * Obtiene el valor de la propiedad country2.
     * 
     * @return
     *     possible object is
     *     {@link COUNTRY2TypeShape }
     *     
     */
    public COUNTRY2TypeShape getCOUNTRY2() {
        return country2;
    }

    /**
     * Define el valor de la propiedad country2.
     * 
     * @param value
     *     allowed object is
     *     {@link COUNTRY2TypeShape }
     *     
     */
    public void setCOUNTRY2(COUNTRY2TypeShape value) {
        this.country2 = value;
    }

    /**
     * Obtiene el valor de la propiedad address1.
     * 
     * @return
     *     possible object is
     *     {@link ADDRESS1TypeShape }
     *     
     */
    public ADDRESS1TypeShape getADDRESS1() {
        return address1;
    }

    /**
     * Define el valor de la propiedad address1.
     * 
     * @param value
     *     allowed object is
     *     {@link ADDRESS1TypeShape }
     *     
     */
    public void setADDRESS1(ADDRESS1TypeShape value) {
        this.address1 = value;
    }

    /**
     * Obtiene el valor de la propiedad address2.
     * 
     * @return
     *     possible object is
     *     {@link ADDRESS2TypeShape }
     *     
     */
    public ADDRESS2TypeShape getADDRESS2() {
        return address2;
    }

    /**
     * Define el valor de la propiedad address2.
     * 
     * @param value
     *     allowed object is
     *     {@link ADDRESS2TypeShape }
     *     
     */
    public void setADDRESS2(ADDRESS2TypeShape value) {
        this.address2 = value;
    }

    /**
     * Obtiene el valor de la propiedad city.
     * 
     * @return
     *     possible object is
     *     {@link CITYTypeShape }
     *     
     */
    public CITYTypeShape getCITY() {
        return city;
    }

    /**
     * Define el valor de la propiedad city.
     * 
     * @param value
     *     allowed object is
     *     {@link CITYTypeShape }
     *     
     */
    public void setCITY(CITYTypeShape value) {
        this.city = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link STATETypeShape }
     *     
     */
    public STATETypeShape getSTATE() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link STATETypeShape }
     *     
     */
    public void setSTATE(STATETypeShape value) {
        this.state = value;
    }

    /**
     * Obtiene el valor de la propiedad lcestratosocial.
     * 
     * @return
     *     possible object is
     *     {@link LCESTRATOSOCIALTypeShape }
     *     
     */
    public LCESTRATOSOCIALTypeShape getLCESTRATOSOCIAL() {
        return lcestratosocial;
    }

    /**
     * Define el valor de la propiedad lcestratosocial.
     * 
     * @param value
     *     allowed object is
     *     {@link LCESTRATOSOCIALTypeShape }
     *     
     */
    public void setLCESTRATOSOCIAL(LCESTRATOSOCIALTypeShape value) {
        this.lcestratosocial = value;
    }

    /**
     * Obtiene el valor de la propiedad county.
     * 
     * @return
     *     possible object is
     *     {@link COUNTYTypeShape }
     *     
     */
    public COUNTYTypeShape getCOUNTY() {
        return county;
    }

    /**
     * Define el valor de la propiedad county.
     * 
     * @param value
     *     allowed object is
     *     {@link COUNTYTypeShape }
     *     
     */
    public void setCOUNTY(COUNTYTypeShape value) {
        this.county = value;
    }

    /**
     * Obtiene el valor de la propiedad bloodtype.
     * 
     * @return
     *     possible object is
     *     {@link BLOODTYPETypeShape }
     *     
     */
    public BLOODTYPETypeShape getBLOODTYPE() {
        return bloodtype;
    }

    /**
     * Define el valor de la propiedad bloodtype.
     * 
     * @param value
     *     allowed object is
     *     {@link BLOODTYPETypeShape }
     *     
     */
    public void setBLOODTYPE(BLOODTYPETypeShape value) {
        this.bloodtype = value;
    }

    /**
     * Obtiene el valor de la propiedad phonetype.
     * 
     * @return
     *     possible object is
     *     {@link PHONETYPETypeShape }
     *     
     */
    public PHONETYPETypeShape getPHONETYPE() {
        return phonetype;
    }

    /**
     * Define el valor de la propiedad phonetype.
     * 
     * @param value
     *     allowed object is
     *     {@link PHONETYPETypeShape }
     *     
     */
    public void setPHONETYPE(PHONETYPETypeShape value) {
        this.phonetype = value;
    }

    /**
     * Obtiene el valor de la propiedad phone.
     * 
     * @return
     *     possible object is
     *     {@link PHONETypeShape }
     *     
     */
    public PHONETypeShape getPHONE() {
        return phone;
    }

    /**
     * Define el valor de la propiedad phone.
     * 
     * @param value
     *     allowed object is
     *     {@link PHONETypeShape }
     *     
     */
    public void setPHONE(PHONETypeShape value) {
        this.phone = value;
    }

    /**
     * Obtiene el valor de la propiedad extension.
     * 
     * @return
     *     possible object is
     *     {@link EXTENSIONTypeShape }
     *     
     */
    public EXTENSIONTypeShape getEXTENSION() {
        return extension;
    }

    /**
     * Define el valor de la propiedad extension.
     * 
     * @param value
     *     allowed object is
     *     {@link EXTENSIONTypeShape }
     *     
     */
    public void setEXTENSION(EXTENSIONTypeShape value) {
        this.extension = value;
    }

    /**
     * Obtiene el valor de la propiedad countrycode.
     * 
     * @return
     *     possible object is
     *     {@link COUNTRYCODETypeShape }
     *     
     */
    public COUNTRYCODETypeShape getCOUNTRYCODE() {
        return countrycode;
    }

    /**
     * Define el valor de la propiedad countrycode.
     * 
     * @param value
     *     allowed object is
     *     {@link COUNTRYCODETypeShape }
     *     
     */
    public void setCOUNTRYCODE(COUNTRYCODETypeShape value) {
        this.countrycode = value;
    }

    /**
     * Obtiene el valor de la propiedad prefphoneflag.
     * 
     * @return
     *     possible object is
     *     {@link PREFPHONEFLAGTypeShape }
     *     
     */
    public PREFPHONEFLAGTypeShape getPREFPHONEFLAG() {
        return prefphoneflag;
    }

    /**
     * Define el valor de la propiedad prefphoneflag.
     * 
     * @param value
     *     allowed object is
     *     {@link PREFPHONEFLAGTypeShape }
     *     
     */
    public void setPREFPHONEFLAG(PREFPHONEFLAGTypeShape value) {
        this.prefphoneflag = value;
    }

    /**
     * Obtiene el valor de la propiedad eaddrtype.
     * 
     * @return
     *     possible object is
     *     {@link EADDRTYPETypeShape }
     *     
     */
    public EADDRTYPETypeShape getEADDRTYPE() {
        return eaddrtype;
    }

    /**
     * Define el valor de la propiedad eaddrtype.
     * 
     * @param value
     *     allowed object is
     *     {@link EADDRTYPETypeShape }
     *     
     */
    public void setEADDRTYPE(EADDRTYPETypeShape value) {
        this.eaddrtype = value;
    }

    /**
     * Obtiene el valor de la propiedad emailaddr.
     * 
     * @return
     *     possible object is
     *     {@link EMAILADDRTypeShape }
     *     
     */
    public EMAILADDRTypeShape getEMAILADDR() {
        return emailaddr;
    }

    /**
     * Define el valor de la propiedad emailaddr.
     * 
     * @param value
     *     allowed object is
     *     {@link EMAILADDRTypeShape }
     *     
     */
    public void setEMAILADDR(EMAILADDRTypeShape value) {
        this.emailaddr = value;
    }

    /**
     * Obtiene el valor de la propiedad prefemailflag.
     * 
     * @return
     *     possible object is
     *     {@link PREFEMAILFLAGTypeShape }
     *     
     */
    public PREFEMAILFLAGTypeShape getPREFEMAILFLAG() {
        return prefemailflag;
    }

    /**
     * Define el valor de la propiedad prefemailflag.
     * 
     * @param value
     *     allowed object is
     *     {@link PREFEMAILFLAGTypeShape }
     *     
     */
    public void setPREFEMAILFLAG(PREFEMAILFLAGTypeShape value) {
        this.prefemailflag = value;
    }

    /**
     * Obtiene el valor de la propiedad opridapprovedby.
     * 
     * @return
     *     possible object is
     *     {@link OPRIDAPPROVEDBYTypeShape }
     *     
     */
    public OPRIDAPPROVEDBYTypeShape getOPRIDAPPROVEDBY() {
        return opridapprovedby;
    }

    /**
     * Define el valor de la propiedad opridapprovedby.
     * 
     * @param value
     *     allowed object is
     *     {@link OPRIDAPPROVEDBYTypeShape }
     *     
     */
    public void setOPRIDAPPROVEDBY(OPRIDAPPROVEDBYTypeShape value) {
        this.opridapprovedby = value;
    }

    /**
     * Obtiene el valor de la propiedad oprid.
     * 
     * @return
     *     possible object is
     *     {@link OPRIDTypeShape }
     *     
     */
    public OPRIDTypeShape getOPRID() {
        return oprid;
    }

    /**
     * Define el valor de la propiedad oprid.
     * 
     * @param value
     *     allowed object is
     *     {@link OPRIDTypeShape }
     *     
     */
    public void setOPRID(OPRIDTypeShape value) {
        this.oprid = value;
    }

    /**
     * Obtiene el valor de la propiedad institution.
     * 
     * @return
     *     possible object is
     *     {@link INSTITUTIONTypeShape }
     *     
     */
    public INSTITUTIONTypeShape getINSTITUTION() {
        return institution;
    }

    /**
     * Define el valor de la propiedad institution.
     * 
     * @param value
     *     allowed object is
     *     {@link INSTITUTIONTypeShape }
     *     
     */
    public void setINSTITUTION(INSTITUTIONTypeShape value) {
        this.institution = value;
    }

    /**
     * Obtiene el valor de la propiedad acadorg.
     * 
     * @return
     *     possible object is
     *     {@link ACADORGTypeShape }
     *     
     */
    public ACADORGTypeShape getACADORG() {
        return acadorg;
    }

    /**
     * Define el valor de la propiedad acadorg.
     * 
     * @param value
     *     allowed object is
     *     {@link ACADORGTypeShape }
     *     
     */
    public void setACADORG(ACADORGTypeShape value) {
        this.acadorg = value;
    }

    /**
     * Obtiene el valor de la propiedad instrtype.
     * 
     * @return
     *     possible object is
     *     {@link INSTRTYPETypeShape }
     *     
     */
    public INSTRTYPETypeShape getINSTRTYPE() {
        return instrtype;
    }

    /**
     * Define el valor de la propiedad instrtype.
     * 
     * @param value
     *     allowed object is
     *     {@link INSTRTYPETypeShape }
     *     
     */
    public void setINSTRTYPE(INSTRTYPETypeShape value) {
        this.instrtype = value;
    }

    /**
     * Obtiene el valor de la propiedad acadcareer.
     * 
     * @return
     *     possible object is
     *     {@link ACADCAREERTypeShape }
     *     
     */
    public ACADCAREERTypeShape getACADCAREER() {
        return acadcareer;
    }

    /**
     * Define el valor de la propiedad acadcareer.
     * 
     * @param value
     *     allowed object is
     *     {@link ACADCAREERTypeShape }
     *     
     */
    public void setACADCAREER(ACADCAREERTypeShape value) {
        this.acadcareer = value;
    }

    /**
     * Obtiene el valor de la propiedad strm.
     * 
     * @return
     *     possible object is
     *     {@link STRMTypeShape }
     *     
     */
    public STRMTypeShape getSTRM() {
        return strm;
    }

    /**
     * Define el valor de la propiedad strm.
     * 
     * @param value
     *     allowed object is
     *     {@link STRMTypeShape }
     *     
     */
    public void setSTRM(STRMTypeShape value) {
        this.strm = value;
    }

    /**
     * Obtiene el valor de la propiedad acadprog.
     * 
     * @return
     *     possible object is
     *     {@link ACADPROGTypeShape }
     *     
     */
    public ACADPROGTypeShape getACADPROG() {
        return acadprog;
    }

    /**
     * Define el valor de la propiedad acadprog.
     * 
     * @param value
     *     allowed object is
     *     {@link ACADPROGTypeShape }
     *     
     */
    public void setACADPROG(ACADPROGTypeShape value) {
        this.acadprog = value;
    }

    /**
     * Obtiene el valor de la propiedad admrecrctr.
     * 
     * @return
     *     possible object is
     *     {@link ADMRECRCTRTypeShape }
     *     
     */
    public ADMRECRCTRTypeShape getADMRECRCTR() {
        return admrecrctr;
    }

    /**
     * Define el valor de la propiedad admrecrctr.
     * 
     * @param value
     *     allowed object is
     *     {@link ADMRECRCTRTypeShape }
     *     
     */
    public void setADMRECRCTR(ADMRECRCTRTypeShape value) {
        this.admrecrctr = value;
    }

    /**
     * Obtiene el valor de la propiedad progaction.
     * 
     * @return
     *     possible object is
     *     {@link PROGACTIONTypeShape }
     *     
     */
    public PROGACTIONTypeShape getPROGACTION() {
        return progaction;
    }

    /**
     * Define el valor de la propiedad progaction.
     * 
     * @param value
     *     allowed object is
     *     {@link PROGACTIONTypeShape }
     *     
     */
    public void setPROGACTION(PROGACTIONTypeShape value) {
        this.progaction = value;
    }

    /**
     * Obtiene el valor de la propiedad stdntcarnbr.
     * 
     * @return
     *     possible object is
     *     {@link STDNTCARNBRTypeShape }
     *     
     */
    public STDNTCARNBRTypeShape getSTDNTCARNBR() {
        return stdntcarnbr;
    }

    /**
     * Define el valor de la propiedad stdntcarnbr.
     * 
     * @param value
     *     allowed object is
     *     {@link STDNTCARNBRTypeShape }
     *     
     */
    public void setSTDNTCARNBR(STDNTCARNBRTypeShape value) {
        this.stdntcarnbr = value;
    }

    /**
     * Obtiene el valor de la propiedad campus.
     * 
     * @return
     *     possible object is
     *     {@link CAMPUSTypeShape }
     *     
     */
    public CAMPUSTypeShape getCAMPUS() {
        return campus;
    }

    /**
     * Define el valor de la propiedad campus.
     * 
     * @param value
     *     allowed object is
     *     {@link CAMPUSTypeShape }
     *     
     */
    public void setCAMPUS(CAMPUSTypeShape value) {
        this.campus = value;
    }

    /**
     * Obtiene el valor de la propiedad admitterm.
     * 
     * @return
     *     possible object is
     *     {@link ADMITTERMTypeShape }
     *     
     */
    public ADMITTERMTypeShape getADMITTERM() {
        return admitterm;
    }

    /**
     * Define el valor de la propiedad admitterm.
     * 
     * @param value
     *     allowed object is
     *     {@link ADMITTERMTypeShape }
     *     
     */
    public void setADMITTERM(ADMITTERMTypeShape value) {
        this.admitterm = value;
    }

    /**
     * Obtiene el valor de la propiedad effdtaddr.
     * 
     * @return
     *     possible object is
     *     {@link EFFDTADDRTypeShape }
     *     
     */
    public EFFDTADDRTypeShape getEFFDTADDR() {
        return effdtaddr;
    }

    /**
     * Define el valor de la propiedad effdtaddr.
     * 
     * @param value
     *     allowed object is
     *     {@link EFFDTADDRTypeShape }
     *     
     */
    public void setEFFDTADDR(EFFDTADDRTypeShape value) {
        this.effdtaddr = value;
    }

    /**
     * Obtiene el valor de la propiedad progstatus.
     * 
     * @return
     *     possible object is
     *     {@link PROGSTATUSTypeShape }
     *     
     */
    public PROGSTATUSTypeShape getPROGSTATUS() {
        return progstatus;
    }

    /**
     * Define el valor de la propiedad progstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link PROGSTATUSTypeShape }
     *     
     */
    public void setPROGSTATUS(PROGSTATUSTypeShape value) {
        this.progstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad templateid.
     * 
     * @return
     *     possible object is
     *     {@link TEMPLATEIDTypeShape }
     *     
     */
    public TEMPLATEIDTypeShape getTEMPLATEID() {
        return templateid;
    }

    /**
     * Define el valor de la propiedad templateid.
     * 
     * @param value
     *     allowed object is
     *     {@link TEMPLATEIDTypeShape }
     *     
     */
    public void setTEMPLATEID(TEMPLATEIDTypeShape value) {
        this.templateid = value;
    }

    /**
     * Obtiene el valor de la propiedad templatestatus.
     * 
     * @return
     *     possible object is
     *     {@link TEMPLATESTATUSTypeShape }
     *     
     */
    public TEMPLATESTATUSTypeShape getTEMPLATESTATUS() {
        return templatestatus;
    }

    /**
     * Define el valor de la propiedad templatestatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TEMPLATESTATUSTypeShape }
     *     
     */
    public void setTEMPLATESTATUS(TEMPLATESTATUSTypeShape value) {
        this.templatestatus = value;
    }

    /**
     * Obtiene el valor de la propiedad alteremplid.
     * 
     * @return
     *     possible object is
     *     {@link ALTEREMPLIDTypeShape }
     *     
     */
    public ALTEREMPLIDTypeShape getALTEREMPLID() {
        return alteremplid;
    }

    /**
     * Define el valor de la propiedad alteremplid.
     * 
     * @param value
     *     allowed object is
     *     {@link ALTEREMPLIDTypeShape }
     *     
     */
    public void setALTEREMPLID(ALTEREMPLIDTypeShape value) {
        this.alteremplid = value;
    }

    /**
     * Obtiene el valor de la propiedad rolename.
     * 
     * @return
     *     possible object is
     *     {@link ROLENAMETypeShape }
     *     
     */
    public ROLENAMETypeShape getROLENAME() {
        return rolename;
    }

    /**
     * Define el valor de la propiedad rolename.
     * 
     * @param value
     *     allowed object is
     *     {@link ROLENAMETypeShape }
     *     
     */
    public void setROLENAME(ROLENAMETypeShape value) {
        this.rolename = value;
    }

    /**
     * Obtiene el valor de la propiedad ecacudiente.
     * 
     * @return
     *     possible object is
     *     {@link ECACUDIENTETypeShape }
     *     
     */
    public ECACUDIENTETypeShape getECACUDIENTE() {
        return ecacudiente;
    }

    /**
     * Define el valor de la propiedad ecacudiente.
     * 
     * @param value
     *     allowed object is
     *     {@link ECACUDIENTETypeShape }
     *     
     */
    public void setECACUDIENTE(ECACUDIENTETypeShape value) {
        this.ecacudiente = value;
    }

    /**
     * Obtiene el valor de la propiedad ecdobletit.
     * 
     * @return
     *     possible object is
     *     {@link ECDOBLETITTypeShape }
     *     
     */
    public ECDOBLETITTypeShape getECDOBLETIT() {
        return ecdobletit;
    }

    /**
     * Define el valor de la propiedad ecdobletit.
     * 
     * @param value
     *     allowed object is
     *     {@link ECDOBLETITTypeShape }
     *     
     */
    public void setECDOBLETIT(ECDOBLETITTypeShape value) {
        this.ecdobletit = value;
    }

    /**
     * Obtiene el valor de la propiedad ecpromacum.
     * 
     * @return
     *     possible object is
     *     {@link ECPROMACUMTypeShape }
     *     
     */
    public ECPROMACUMTypeShape getECPROMACUM() {
        return ecpromacum;
    }

    /**
     * Define el valor de la propiedad ecpromacum.
     * 
     * @param value
     *     allowed object is
     *     {@link ECPROMACUMTypeShape }
     *     
     */
    public void setECPROMACUM(ECPROMACUMTypeShape value) {
        this.ecpromacum = value;
    }

    /**
     * Obtiene el valor de la propiedad ecpromant.
     * 
     * @return
     *     possible object is
     *     {@link ECPROMANTTypeShape }
     *     
     */
    public ECPROMANTTypeShape getECPROMANT() {
        return ecpromant;
    }

    /**
     * Define el valor de la propiedad ecpromant.
     * 
     * @param value
     *     allowed object is
     *     {@link ECPROMANTTypeShape }
     *     
     */
    public void setECPROMANT(ECPROMANTTypeShape value) {
        this.ecpromant = value;
    }

    /**
     * Obtiene el valor de la propiedad ecultsemes.
     * 
     * @return
     *     possible object is
     *     {@link ECULTSEMESTypeShape }
     *     
     */
    public ECULTSEMESTypeShape getECULTSEMES() {
        return ecultsemes;
    }

    /**
     * Define el valor de la propiedad ecultsemes.
     * 
     * @param value
     *     allowed object is
     *     {@link ECULTSEMESTypeShape }
     *     
     */
    public void setECULTSEMES(ECULTSEMESTypeShape value) {
        this.ecultsemes = value;
    }

    /**
     * Obtiene el valor de la propiedad operpswd.
     * 
     * @return
     *     possible object is
     *     {@link OPERPSWDTypeShape }
     *     
     */
    public OPERPSWDTypeShape getOPERPSWD() {
        return operpswd;
    }

    /**
     * Define el valor de la propiedad operpswd.
     * 
     * @param value
     *     allowed object is
     *     {@link OPERPSWDTypeShape }
     *     
     */
    public void setOPERPSWD(OPERPSWDTypeShape value) {
        this.operpswd = value;
    }

    /**
     * Obtiene el valor de la propiedad ecroladm.
     * 
     * @return
     *     possible object is
     *     {@link ECROLADMTypeShape }
     *     
     */
    public ECROLADMTypeShape getECROLADM() {
        return ecroladm;
    }

    /**
     * Define el valor de la propiedad ecroladm.
     * 
     * @param value
     *     allowed object is
     *     {@link ECROLADMTypeShape }
     *     
     */
    public void setECROLADM(ECROLADMTypeShape value) {
        this.ecroladm = value;
    }

    /**
     * Obtiene el valor de la propiedad acadorg1.
     * 
     * @return
     *     possible object is
     *     {@link ACADORG1TypeShape }
     *     
     */
    public ACADORG1TypeShape getACADORG1() {
        return acadorg1;
    }

    /**
     * Define el valor de la propiedad acadorg1.
     * 
     * @param value
     *     allowed object is
     *     {@link ACADORG1TypeShape }
     *     
     */
    public void setACADORG1(ACADORG1TypeShape value) {
        this.acadorg1 = value;
    }

    /**
     * Obtiene el valor de la propiedad effdtadd.
     * 
     * @return
     *     possible object is
     *     {@link EFFDTADDTypeShape }
     *     
     */
    public EFFDTADDTypeShape getEFFDTADD() {
        return effdtadd;
    }

    /**
     * Define el valor de la propiedad effdtadd.
     * 
     * @param value
     *     allowed object is
     *     {@link EFFDTADDTypeShape }
     *     
     */
    public void setEFFDTADD(EFFDTADDTypeShape value) {
        this.effdtadd = value;
    }

    /**
     * Obtiene el valor de la propiedad contactname.
     * 
     * @return
     *     possible object is
     *     {@link CONTACTNAMETypeShape }
     *     
     */
    public CONTACTNAMETypeShape getCONTACTNAME() {
        return contactname;
    }

    /**
     * Define el valor de la propiedad contactname.
     * 
     * @param value
     *     allowed object is
     *     {@link CONTACTNAMETypeShape }
     *     
     */
    public void setCONTACTNAME(CONTACTNAMETypeShape value) {
        this.contactname = value;
    }

    /**
     * Obtiene el valor de la propiedad guardianrelations.
     * 
     * @return
     *     possible object is
     *     {@link GUARDIANRELATIONSTypeShape }
     *     
     */
    public GUARDIANRELATIONSTypeShape getGUARDIANRELATIONS() {
        return guardianrelations;
    }

    /**
     * Define el valor de la propiedad guardianrelations.
     * 
     * @param value
     *     allowed object is
     *     {@link GUARDIANRELATIONSTypeShape }
     *     
     */
    public void setGUARDIANRELATIONS(GUARDIANRELATIONSTypeShape value) {
        this.guardianrelations = value;
    }

    /**
     * Gets the value of the ecpersworkwrkAndPSCAMA property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ecpersworkwrkAndPSCAMA property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getECPERSWORKWRKAndPSCAMA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ECPERSWORKWRKMsgDataRecordTypeShape }
     * {@link PSCAMAMsgDataRecordTypeShape }
     * 
     * 
     */
    public List<Object> getECPERSWORKWRKAndPSCAMA() {
        if (ecpersworkwrkAndPSCAMA == null) {
            ecpersworkwrkAndPSCAMA = new ArrayList<Object>();
        }
        return this.ecpersworkwrkAndPSCAMA;
    }

    /**
     * Gets the value of the ecpersexpwrkAndPSCAMA property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ecpersexpwrkAndPSCAMA property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getECPERSEXPWRKAndPSCAMA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ECPERSEXPWRKMsgDataRecordTypeShape }
     * {@link PSCAMAMsgDataRecordTypeShape }
     * 
     * 
     */
    public List<Object> getECPERSEXPWRKAndPSCAMA() {
        if (ecpersexpwrkAndPSCAMA == null) {
            ecpersexpwrkAndPSCAMA = new ArrayList<Object>();
        }
        return this.ecpersexpwrkAndPSCAMA;
    }

    /**
     * Gets the value of the ecperseduwrkAndPSCAMA property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ecperseduwrkAndPSCAMA property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getECPERSEDUWRKAndPSCAMA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ECPERSEDUWRKMsgDataRecordTypeShape }
     * {@link PSCAMAMsgDataRecordTypeShape }
     * 
     * 
     */
    public List<Object> getECPERSEDUWRKAndPSCAMA() {
        if (ecperseduwrkAndPSCAMA == null) {
            ecperseduwrkAndPSCAMA = new ArrayList<Object>();
        }
        return this.ecperseduwrkAndPSCAMA;
    }

    /**
     * Gets the value of the ecperslangwrkAndPSCAMA property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ecperslangwrkAndPSCAMA property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getECPERSLANGWRKAndPSCAMA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ECPERSLANGWRKMsgDataRecordTypeShape }
     * {@link PSCAMAMsgDataRecordTypeShape }
     * 
     * 
     */
    public List<Object> getECPERSLANGWRKAndPSCAMA() {
        if (ecperslangwrkAndPSCAMA == null) {
            ecperslangwrkAndPSCAMA = new ArrayList<Object>();
        }
        return this.ecperslangwrkAndPSCAMA;
    }

    /**
     * Gets the value of the ecpersmemwrkAndPSCAMA property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ecpersmemwrkAndPSCAMA property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getECPERSMEMWRKAndPSCAMA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ECPERSMEMWRKMsgDataRecordTypeShape }
     * {@link PSCAMAMsgDataRecordTypeShape }
     * 
     * 
     */
    public List<Object> getECPERSMEMWRKAndPSCAMA() {
        if (ecpersmemwrkAndPSCAMA == null) {
            ecpersmemwrkAndPSCAMA = new ArrayList<Object>();
        }
        return this.ecpersmemwrkAndPSCAMA;
    }

    /**
     * Obtiene el valor de la propiedad clazz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        if (clazz == null) {
            return "R";
        } else {
            return clazz;
        }
    }

    /**
     * Define el valor de la propiedad clazz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

}
