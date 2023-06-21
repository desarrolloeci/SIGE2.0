
package com.oracle.xmlns.enterprise.tools.schemas.ec_ib_int_p_inflab_srch_resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FieldTypesEC_IB_INTP_TBL_TypeShape complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FieldTypesEC_IB_INTP_TBL_TypeShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType"/&gt;
 *         &lt;element name="EFFDT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesDateFieldType"/&gt;
 *         &lt;element name="EC_ACTUALIZACIONES" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EFF_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="NAME_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="FIRST_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="MIDDLE_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="LAST_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="SECOND_LAST_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="BIRTHDATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="BIRTHPLACE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="BIRTHCOUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="BIRTHSTATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="CAMPUS_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="MAR_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="MAR_STATUS_DT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="SEX" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="NATIONAL_ID_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="NATIONAL_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="LC_STATE3" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="CITY_AC" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PRIMARY_NID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY2" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS1" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS2" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="CITY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="STATE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="LC_ESTRATO_SOCIAL" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="COUNTY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="BLOOD_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PHONE_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PHONE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EXTENSION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="COUNTRY_CODE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PREF_PHONE_FLAG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="E_ADDR_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EMAIL_ADDR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PREF_EMAIL_FLAG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="OPRID_APPROVED_BY" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="OPRID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="INSTITUTION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_ORG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="INSTR_TYPE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_CAREER" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="STRM" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_PROG" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ADM_RECR_CTR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PROG_ACTION" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="STDNT_CAR_NBR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesNumberFieldType" minOccurs="0"/&gt;
 *         &lt;element name="CAMPUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ADMIT_TERM" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EFFDT_ADDR" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="PROG_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="TEMPLATE_ID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="TEMPLATE_STATUS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ALTER_EMPLID" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ROLENAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_ACUDIENTE" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_DOBLE_TIT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_PROM_ACUM" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesNumberFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_PROM_ANT" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesNumberFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_ULT_SEMES" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="OPERPSWD" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EC_ROL_ADM" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="ACAD_ORG1" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="EFFDT_ADD" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesDateFieldType" minOccurs="0"/&gt;
 *         &lt;element name="CONTACT_NAME" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
 *         &lt;element name="GUARDIAN_RELATIONS" type="{http://xmlns.oracle.com/Enterprise/Tools/schemas/EC_IB_INT_P_INFLAB_SRCH_RESP.V1}FieldTypesCharFieldType" minOccurs="0"/&gt;
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
@XmlType(name = "FieldTypesEC_IB_INTP_TBL_TypeShape", propOrder = {
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
    "guardianrelations"
})
public class FieldTypesECIBINTPTBLTypeShape {

    @XmlElement(name = "EMPLID", required = true)
    protected FieldTypesCharFieldType emplid;
    @XmlElement(name = "EFFDT", required = true)
    protected FieldTypesDateFieldType effdt;
    @XmlElement(name = "EC_ACTUALIZACIONES")
    protected FieldTypesCharFieldType ecactualizaciones;
    @XmlElement(name = "EFF_STATUS")
    protected FieldTypesCharFieldType effstatus;
    @XmlElement(name = "NAME_TYPE")
    protected FieldTypesCharFieldType nametype;
    @XmlElement(name = "FIRST_NAME")
    protected FieldTypesCharFieldType firstname;
    @XmlElement(name = "MIDDLE_NAME")
    protected FieldTypesCharFieldType middlename;
    @XmlElement(name = "LAST_NAME")
    protected FieldTypesCharFieldType lastname;
    @XmlElement(name = "SECOND_LAST_NAME")
    protected FieldTypesCharFieldType secondlastname;
    @XmlElement(name = "BIRTHDATE")
    protected FieldTypesDateFieldType birthdate;
    @XmlElement(name = "BIRTHPLACE")
    protected FieldTypesCharFieldType birthplace;
    @XmlElement(name = "BIRTHCOUNTRY")
    protected FieldTypesCharFieldType birthcountry;
    @XmlElement(name = "BIRTHSTATE")
    protected FieldTypesCharFieldType birthstate;
    @XmlElement(name = "CAMPUS_ID")
    protected FieldTypesCharFieldType campusid;
    @XmlElement(name = "MAR_STATUS")
    protected FieldTypesCharFieldType marstatus;
    @XmlElement(name = "MAR_STATUS_DT")
    protected FieldTypesDateFieldType marstatusdt;
    @XmlElement(name = "SEX")
    protected FieldTypesCharFieldType sex;
    @XmlElement(name = "COUNTRY")
    protected FieldTypesCharFieldType country;
    @XmlElement(name = "NATIONAL_ID_TYPE")
    protected FieldTypesCharFieldType nationalidtype;
    @XmlElement(name = "NATIONAL_ID")
    protected FieldTypesCharFieldType nationalid;
    @XmlElement(name = "LC_STATE3")
    protected FieldTypesCharFieldType lcstate3;
    @XmlElement(name = "CITY_AC")
    protected FieldTypesCharFieldType cityac;
    @XmlElement(name = "PRIMARY_NID")
    protected FieldTypesCharFieldType primarynid;
    @XmlElement(name = "ADDRESS_TYPE")
    protected FieldTypesCharFieldType addresstype;
    @XmlElement(name = "COUNTRY2")
    protected FieldTypesCharFieldType country2;
    @XmlElement(name = "ADDRESS1")
    protected FieldTypesCharFieldType address1;
    @XmlElement(name = "ADDRESS2")
    protected FieldTypesCharFieldType address2;
    @XmlElement(name = "CITY")
    protected FieldTypesCharFieldType city;
    @XmlElement(name = "STATE")
    protected FieldTypesCharFieldType state;
    @XmlElement(name = "LC_ESTRATO_SOCIAL")
    protected FieldTypesCharFieldType lcestratosocial;
    @XmlElement(name = "COUNTY")
    protected FieldTypesCharFieldType county;
    @XmlElement(name = "BLOOD_TYPE")
    protected FieldTypesCharFieldType bloodtype;
    @XmlElement(name = "PHONE_TYPE")
    protected FieldTypesCharFieldType phonetype;
    @XmlElement(name = "PHONE")
    protected FieldTypesCharFieldType phone;
    @XmlElement(name = "EXTENSION")
    protected FieldTypesCharFieldType extension;
    @XmlElement(name = "COUNTRY_CODE")
    protected FieldTypesCharFieldType countrycode;
    @XmlElement(name = "PREF_PHONE_FLAG")
    protected FieldTypesCharFieldType prefphoneflag;
    @XmlElement(name = "E_ADDR_TYPE")
    protected FieldTypesCharFieldType eaddrtype;
    @XmlElement(name = "EMAIL_ADDR")
    protected FieldTypesCharFieldType emailaddr;
    @XmlElement(name = "PREF_EMAIL_FLAG")
    protected FieldTypesCharFieldType prefemailflag;
    @XmlElement(name = "OPRID_APPROVED_BY")
    protected FieldTypesCharFieldType opridapprovedby;
    @XmlElement(name = "OPRID")
    protected FieldTypesCharFieldType oprid;
    @XmlElement(name = "INSTITUTION")
    protected FieldTypesCharFieldType institution;
    @XmlElement(name = "ACAD_ORG")
    protected FieldTypesCharFieldType acadorg;
    @XmlElement(name = "INSTR_TYPE")
    protected FieldTypesCharFieldType instrtype;
    @XmlElement(name = "ACAD_CAREER")
    protected FieldTypesCharFieldType acadcareer;
    @XmlElement(name = "STRM")
    protected FieldTypesCharFieldType strm;
    @XmlElement(name = "ACAD_PROG")
    protected FieldTypesCharFieldType acadprog;
    @XmlElement(name = "ADM_RECR_CTR")
    protected FieldTypesCharFieldType admrecrctr;
    @XmlElement(name = "PROG_ACTION")
    protected FieldTypesCharFieldType progaction;
    @XmlElement(name = "STDNT_CAR_NBR")
    protected FieldTypesNumberFieldType stdntcarnbr;
    @XmlElement(name = "CAMPUS")
    protected FieldTypesCharFieldType campus;
    @XmlElement(name = "ADMIT_TERM")
    protected FieldTypesCharFieldType admitterm;
    @XmlElement(name = "EFFDT_ADDR")
    protected FieldTypesDateFieldType effdtaddr;
    @XmlElement(name = "PROG_STATUS")
    protected FieldTypesCharFieldType progstatus;
    @XmlElement(name = "TEMPLATE_ID")
    protected FieldTypesCharFieldType templateid;
    @XmlElement(name = "TEMPLATE_STATUS")
    protected FieldTypesCharFieldType templatestatus;
    @XmlElement(name = "ALTER_EMPLID")
    protected FieldTypesCharFieldType alteremplid;
    @XmlElement(name = "ROLENAME")
    protected FieldTypesCharFieldType rolename;
    @XmlElement(name = "EC_ACUDIENTE")
    protected FieldTypesCharFieldType ecacudiente;
    @XmlElement(name = "EC_DOBLE_TIT")
    protected FieldTypesCharFieldType ecdobletit;
    @XmlElement(name = "EC_PROM_ACUM")
    protected FieldTypesNumberFieldType ecpromacum;
    @XmlElement(name = "EC_PROM_ANT")
    protected FieldTypesNumberFieldType ecpromant;
    @XmlElement(name = "EC_ULT_SEMES")
    protected FieldTypesCharFieldType ecultsemes;
    @XmlElement(name = "OPERPSWD")
    protected FieldTypesCharFieldType operpswd;
    @XmlElement(name = "EC_ROL_ADM")
    protected FieldTypesCharFieldType ecroladm;
    @XmlElement(name = "ACAD_ORG1")
    protected FieldTypesCharFieldType acadorg1;
    @XmlElement(name = "EFFDT_ADD")
    protected FieldTypesDateFieldType effdtadd;
    @XmlElement(name = "CONTACT_NAME")
    protected FieldTypesCharFieldType contactname;
    @XmlElement(name = "GUARDIAN_RELATIONS")
    protected FieldTypesCharFieldType guardianrelations;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Obtiene el valor de la propiedad emplid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEMPLID() {
        return emplid;
    }

    /**
     * Define el valor de la propiedad emplid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEMPLID(FieldTypesCharFieldType value) {
        this.emplid = value;
    }

    /**
     * Obtiene el valor de la propiedad effdt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getEFFDT() {
        return effdt;
    }

    /**
     * Define el valor de la propiedad effdt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setEFFDT(FieldTypesDateFieldType value) {
        this.effdt = value;
    }

    /**
     * Obtiene el valor de la propiedad ecactualizaciones.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECACTUALIZACIONES() {
        return ecactualizaciones;
    }

    /**
     * Define el valor de la propiedad ecactualizaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECACTUALIZACIONES(FieldTypesCharFieldType value) {
        this.ecactualizaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad effstatus.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEFFSTATUS() {
        return effstatus;
    }

    /**
     * Define el valor de la propiedad effstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEFFSTATUS(FieldTypesCharFieldType value) {
        this.effstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad nametype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getNAMETYPE() {
        return nametype;
    }

    /**
     * Define el valor de la propiedad nametype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setNAMETYPE(FieldTypesCharFieldType value) {
        this.nametype = value;
    }

    /**
     * Obtiene el valor de la propiedad firstname.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getFIRSTNAME() {
        return firstname;
    }

    /**
     * Define el valor de la propiedad firstname.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setFIRSTNAME(FieldTypesCharFieldType value) {
        this.firstname = value;
    }

    /**
     * Obtiene el valor de la propiedad middlename.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getMIDDLENAME() {
        return middlename;
    }

    /**
     * Define el valor de la propiedad middlename.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setMIDDLENAME(FieldTypesCharFieldType value) {
        this.middlename = value;
    }

    /**
     * Obtiene el valor de la propiedad lastname.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getLASTNAME() {
        return lastname;
    }

    /**
     * Define el valor de la propiedad lastname.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setLASTNAME(FieldTypesCharFieldType value) {
        this.lastname = value;
    }

    /**
     * Obtiene el valor de la propiedad secondlastname.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getSECONDLASTNAME() {
        return secondlastname;
    }

    /**
     * Define el valor de la propiedad secondlastname.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setSECONDLASTNAME(FieldTypesCharFieldType value) {
        this.secondlastname = value;
    }

    /**
     * Obtiene el valor de la propiedad birthdate.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getBIRTHDATE() {
        return birthdate;
    }

    /**
     * Define el valor de la propiedad birthdate.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setBIRTHDATE(FieldTypesDateFieldType value) {
        this.birthdate = value;
    }

    /**
     * Obtiene el valor de la propiedad birthplace.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getBIRTHPLACE() {
        return birthplace;
    }

    /**
     * Define el valor de la propiedad birthplace.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setBIRTHPLACE(FieldTypesCharFieldType value) {
        this.birthplace = value;
    }

    /**
     * Obtiene el valor de la propiedad birthcountry.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getBIRTHCOUNTRY() {
        return birthcountry;
    }

    /**
     * Define el valor de la propiedad birthcountry.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setBIRTHCOUNTRY(FieldTypesCharFieldType value) {
        this.birthcountry = value;
    }

    /**
     * Obtiene el valor de la propiedad birthstate.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getBIRTHSTATE() {
        return birthstate;
    }

    /**
     * Define el valor de la propiedad birthstate.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setBIRTHSTATE(FieldTypesCharFieldType value) {
        this.birthstate = value;
    }

    /**
     * Obtiene el valor de la propiedad campusid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCAMPUSID() {
        return campusid;
    }

    /**
     * Define el valor de la propiedad campusid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCAMPUSID(FieldTypesCharFieldType value) {
        this.campusid = value;
    }

    /**
     * Obtiene el valor de la propiedad marstatus.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getMARSTATUS() {
        return marstatus;
    }

    /**
     * Define el valor de la propiedad marstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setMARSTATUS(FieldTypesCharFieldType value) {
        this.marstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad marstatusdt.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getMARSTATUSDT() {
        return marstatusdt;
    }

    /**
     * Define el valor de la propiedad marstatusdt.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setMARSTATUSDT(FieldTypesDateFieldType value) {
        this.marstatusdt = value;
    }

    /**
     * Obtiene el valor de la propiedad sex.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getSEX() {
        return sex;
    }

    /**
     * Define el valor de la propiedad sex.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setSEX(FieldTypesCharFieldType value) {
        this.sex = value;
    }

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCOUNTRY() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCOUNTRY(FieldTypesCharFieldType value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad nationalidtype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getNATIONALIDTYPE() {
        return nationalidtype;
    }

    /**
     * Define el valor de la propiedad nationalidtype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setNATIONALIDTYPE(FieldTypesCharFieldType value) {
        this.nationalidtype = value;
    }

    /**
     * Obtiene el valor de la propiedad nationalid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getNATIONALID() {
        return nationalid;
    }

    /**
     * Define el valor de la propiedad nationalid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setNATIONALID(FieldTypesCharFieldType value) {
        this.nationalid = value;
    }

    /**
     * Obtiene el valor de la propiedad lcstate3.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getLCSTATE3() {
        return lcstate3;
    }

    /**
     * Define el valor de la propiedad lcstate3.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setLCSTATE3(FieldTypesCharFieldType value) {
        this.lcstate3 = value;
    }

    /**
     * Obtiene el valor de la propiedad cityac.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCITYAC() {
        return cityac;
    }

    /**
     * Define el valor de la propiedad cityac.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCITYAC(FieldTypesCharFieldType value) {
        this.cityac = value;
    }

    /**
     * Obtiene el valor de la propiedad primarynid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPRIMARYNID() {
        return primarynid;
    }

    /**
     * Define el valor de la propiedad primarynid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPRIMARYNID(FieldTypesCharFieldType value) {
        this.primarynid = value;
    }

    /**
     * Obtiene el valor de la propiedad addresstype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getADDRESSTYPE() {
        return addresstype;
    }

    /**
     * Define el valor de la propiedad addresstype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setADDRESSTYPE(FieldTypesCharFieldType value) {
        this.addresstype = value;
    }

    /**
     * Obtiene el valor de la propiedad country2.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCOUNTRY2() {
        return country2;
    }

    /**
     * Define el valor de la propiedad country2.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCOUNTRY2(FieldTypesCharFieldType value) {
        this.country2 = value;
    }

    /**
     * Obtiene el valor de la propiedad address1.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getADDRESS1() {
        return address1;
    }

    /**
     * Define el valor de la propiedad address1.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setADDRESS1(FieldTypesCharFieldType value) {
        this.address1 = value;
    }

    /**
     * Obtiene el valor de la propiedad address2.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getADDRESS2() {
        return address2;
    }

    /**
     * Define el valor de la propiedad address2.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setADDRESS2(FieldTypesCharFieldType value) {
        this.address2 = value;
    }

    /**
     * Obtiene el valor de la propiedad city.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCITY() {
        return city;
    }

    /**
     * Define el valor de la propiedad city.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCITY(FieldTypesCharFieldType value) {
        this.city = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getSTATE() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setSTATE(FieldTypesCharFieldType value) {
        this.state = value;
    }

    /**
     * Obtiene el valor de la propiedad lcestratosocial.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getLCESTRATOSOCIAL() {
        return lcestratosocial;
    }

    /**
     * Define el valor de la propiedad lcestratosocial.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setLCESTRATOSOCIAL(FieldTypesCharFieldType value) {
        this.lcestratosocial = value;
    }

    /**
     * Obtiene el valor de la propiedad county.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCOUNTY() {
        return county;
    }

    /**
     * Define el valor de la propiedad county.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCOUNTY(FieldTypesCharFieldType value) {
        this.county = value;
    }

    /**
     * Obtiene el valor de la propiedad bloodtype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getBLOODTYPE() {
        return bloodtype;
    }

    /**
     * Define el valor de la propiedad bloodtype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setBLOODTYPE(FieldTypesCharFieldType value) {
        this.bloodtype = value;
    }

    /**
     * Obtiene el valor de la propiedad phonetype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPHONETYPE() {
        return phonetype;
    }

    /**
     * Define el valor de la propiedad phonetype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPHONETYPE(FieldTypesCharFieldType value) {
        this.phonetype = value;
    }

    /**
     * Obtiene el valor de la propiedad phone.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPHONE() {
        return phone;
    }

    /**
     * Define el valor de la propiedad phone.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPHONE(FieldTypesCharFieldType value) {
        this.phone = value;
    }

    /**
     * Obtiene el valor de la propiedad extension.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEXTENSION() {
        return extension;
    }

    /**
     * Define el valor de la propiedad extension.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEXTENSION(FieldTypesCharFieldType value) {
        this.extension = value;
    }

    /**
     * Obtiene el valor de la propiedad countrycode.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCOUNTRYCODE() {
        return countrycode;
    }

    /**
     * Define el valor de la propiedad countrycode.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCOUNTRYCODE(FieldTypesCharFieldType value) {
        this.countrycode = value;
    }

    /**
     * Obtiene el valor de la propiedad prefphoneflag.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPREFPHONEFLAG() {
        return prefphoneflag;
    }

    /**
     * Define el valor de la propiedad prefphoneflag.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPREFPHONEFLAG(FieldTypesCharFieldType value) {
        this.prefphoneflag = value;
    }

    /**
     * Obtiene el valor de la propiedad eaddrtype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEADDRTYPE() {
        return eaddrtype;
    }

    /**
     * Define el valor de la propiedad eaddrtype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEADDRTYPE(FieldTypesCharFieldType value) {
        this.eaddrtype = value;
    }

    /**
     * Obtiene el valor de la propiedad emailaddr.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getEMAILADDR() {
        return emailaddr;
    }

    /**
     * Define el valor de la propiedad emailaddr.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setEMAILADDR(FieldTypesCharFieldType value) {
        this.emailaddr = value;
    }

    /**
     * Obtiene el valor de la propiedad prefemailflag.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPREFEMAILFLAG() {
        return prefemailflag;
    }

    /**
     * Define el valor de la propiedad prefemailflag.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPREFEMAILFLAG(FieldTypesCharFieldType value) {
        this.prefemailflag = value;
    }

    /**
     * Obtiene el valor de la propiedad opridapprovedby.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getOPRIDAPPROVEDBY() {
        return opridapprovedby;
    }

    /**
     * Define el valor de la propiedad opridapprovedby.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setOPRIDAPPROVEDBY(FieldTypesCharFieldType value) {
        this.opridapprovedby = value;
    }

    /**
     * Obtiene el valor de la propiedad oprid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getOPRID() {
        return oprid;
    }

    /**
     * Define el valor de la propiedad oprid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setOPRID(FieldTypesCharFieldType value) {
        this.oprid = value;
    }

    /**
     * Obtiene el valor de la propiedad institution.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getINSTITUTION() {
        return institution;
    }

    /**
     * Define el valor de la propiedad institution.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setINSTITUTION(FieldTypesCharFieldType value) {
        this.institution = value;
    }

    /**
     * Obtiene el valor de la propiedad acadorg.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getACADORG() {
        return acadorg;
    }

    /**
     * Define el valor de la propiedad acadorg.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setACADORG(FieldTypesCharFieldType value) {
        this.acadorg = value;
    }

    /**
     * Obtiene el valor de la propiedad instrtype.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getINSTRTYPE() {
        return instrtype;
    }

    /**
     * Define el valor de la propiedad instrtype.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setINSTRTYPE(FieldTypesCharFieldType value) {
        this.instrtype = value;
    }

    /**
     * Obtiene el valor de la propiedad acadcareer.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getACADCAREER() {
        return acadcareer;
    }

    /**
     * Define el valor de la propiedad acadcareer.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setACADCAREER(FieldTypesCharFieldType value) {
        this.acadcareer = value;
    }

    /**
     * Obtiene el valor de la propiedad strm.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getSTRM() {
        return strm;
    }

    /**
     * Define el valor de la propiedad strm.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setSTRM(FieldTypesCharFieldType value) {
        this.strm = value;
    }

    /**
     * Obtiene el valor de la propiedad acadprog.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getACADPROG() {
        return acadprog;
    }

    /**
     * Define el valor de la propiedad acadprog.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setACADPROG(FieldTypesCharFieldType value) {
        this.acadprog = value;
    }

    /**
     * Obtiene el valor de la propiedad admrecrctr.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getADMRECRCTR() {
        return admrecrctr;
    }

    /**
     * Define el valor de la propiedad admrecrctr.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setADMRECRCTR(FieldTypesCharFieldType value) {
        this.admrecrctr = value;
    }

    /**
     * Obtiene el valor de la propiedad progaction.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPROGACTION() {
        return progaction;
    }

    /**
     * Define el valor de la propiedad progaction.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPROGACTION(FieldTypesCharFieldType value) {
        this.progaction = value;
    }

    /**
     * Obtiene el valor de la propiedad stdntcarnbr.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public FieldTypesNumberFieldType getSTDNTCARNBR() {
        return stdntcarnbr;
    }

    /**
     * Define el valor de la propiedad stdntcarnbr.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public void setSTDNTCARNBR(FieldTypesNumberFieldType value) {
        this.stdntcarnbr = value;
    }

    /**
     * Obtiene el valor de la propiedad campus.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCAMPUS() {
        return campus;
    }

    /**
     * Define el valor de la propiedad campus.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCAMPUS(FieldTypesCharFieldType value) {
        this.campus = value;
    }

    /**
     * Obtiene el valor de la propiedad admitterm.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getADMITTERM() {
        return admitterm;
    }

    /**
     * Define el valor de la propiedad admitterm.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setADMITTERM(FieldTypesCharFieldType value) {
        this.admitterm = value;
    }

    /**
     * Obtiene el valor de la propiedad effdtaddr.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getEFFDTADDR() {
        return effdtaddr;
    }

    /**
     * Define el valor de la propiedad effdtaddr.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setEFFDTADDR(FieldTypesDateFieldType value) {
        this.effdtaddr = value;
    }

    /**
     * Obtiene el valor de la propiedad progstatus.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getPROGSTATUS() {
        return progstatus;
    }

    /**
     * Define el valor de la propiedad progstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setPROGSTATUS(FieldTypesCharFieldType value) {
        this.progstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad templateid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getTEMPLATEID() {
        return templateid;
    }

    /**
     * Define el valor de la propiedad templateid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setTEMPLATEID(FieldTypesCharFieldType value) {
        this.templateid = value;
    }

    /**
     * Obtiene el valor de la propiedad templatestatus.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getTEMPLATESTATUS() {
        return templatestatus;
    }

    /**
     * Define el valor de la propiedad templatestatus.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setTEMPLATESTATUS(FieldTypesCharFieldType value) {
        this.templatestatus = value;
    }

    /**
     * Obtiene el valor de la propiedad alteremplid.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getALTEREMPLID() {
        return alteremplid;
    }

    /**
     * Define el valor de la propiedad alteremplid.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setALTEREMPLID(FieldTypesCharFieldType value) {
        this.alteremplid = value;
    }

    /**
     * Obtiene el valor de la propiedad rolename.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getROLENAME() {
        return rolename;
    }

    /**
     * Define el valor de la propiedad rolename.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setROLENAME(FieldTypesCharFieldType value) {
        this.rolename = value;
    }

    /**
     * Obtiene el valor de la propiedad ecacudiente.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECACUDIENTE() {
        return ecacudiente;
    }

    /**
     * Define el valor de la propiedad ecacudiente.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECACUDIENTE(FieldTypesCharFieldType value) {
        this.ecacudiente = value;
    }

    /**
     * Obtiene el valor de la propiedad ecdobletit.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECDOBLETIT() {
        return ecdobletit;
    }

    /**
     * Define el valor de la propiedad ecdobletit.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECDOBLETIT(FieldTypesCharFieldType value) {
        this.ecdobletit = value;
    }

    /**
     * Obtiene el valor de la propiedad ecpromacum.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public FieldTypesNumberFieldType getECPROMACUM() {
        return ecpromacum;
    }

    /**
     * Define el valor de la propiedad ecpromacum.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public void setECPROMACUM(FieldTypesNumberFieldType value) {
        this.ecpromacum = value;
    }

    /**
     * Obtiene el valor de la propiedad ecpromant.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public FieldTypesNumberFieldType getECPROMANT() {
        return ecpromant;
    }

    /**
     * Define el valor de la propiedad ecpromant.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesNumberFieldType }
     *     
     */
    public void setECPROMANT(FieldTypesNumberFieldType value) {
        this.ecpromant = value;
    }

    /**
     * Obtiene el valor de la propiedad ecultsemes.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECULTSEMES() {
        return ecultsemes;
    }

    /**
     * Define el valor de la propiedad ecultsemes.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECULTSEMES(FieldTypesCharFieldType value) {
        this.ecultsemes = value;
    }

    /**
     * Obtiene el valor de la propiedad operpswd.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getOPERPSWD() {
        return operpswd;
    }

    /**
     * Define el valor de la propiedad operpswd.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setOPERPSWD(FieldTypesCharFieldType value) {
        this.operpswd = value;
    }

    /**
     * Obtiene el valor de la propiedad ecroladm.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getECROLADM() {
        return ecroladm;
    }

    /**
     * Define el valor de la propiedad ecroladm.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setECROLADM(FieldTypesCharFieldType value) {
        this.ecroladm = value;
    }

    /**
     * Obtiene el valor de la propiedad acadorg1.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getACADORG1() {
        return acadorg1;
    }

    /**
     * Define el valor de la propiedad acadorg1.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setACADORG1(FieldTypesCharFieldType value) {
        this.acadorg1 = value;
    }

    /**
     * Obtiene el valor de la propiedad effdtadd.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public FieldTypesDateFieldType getEFFDTADD() {
        return effdtadd;
    }

    /**
     * Define el valor de la propiedad effdtadd.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesDateFieldType }
     *     
     */
    public void setEFFDTADD(FieldTypesDateFieldType value) {
        this.effdtadd = value;
    }

    /**
     * Obtiene el valor de la propiedad contactname.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getCONTACTNAME() {
        return contactname;
    }

    /**
     * Define el valor de la propiedad contactname.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setCONTACTNAME(FieldTypesCharFieldType value) {
        this.contactname = value;
    }

    /**
     * Obtiene el valor de la propiedad guardianrelations.
     * 
     * @return
     *     possible object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public FieldTypesCharFieldType getGUARDIANRELATIONS() {
        return guardianrelations;
    }

    /**
     * Define el valor de la propiedad guardianrelations.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldTypesCharFieldType }
     *     
     */
    public void setGUARDIANRELATIONS(FieldTypesCharFieldType value) {
        this.guardianrelations = value;
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
