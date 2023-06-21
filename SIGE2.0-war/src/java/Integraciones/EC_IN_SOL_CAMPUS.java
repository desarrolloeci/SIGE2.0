/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integraciones;

import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author juan.vanzina
 */
@WebService(serviceName = "EC_IN_SOL_PRAC")
@HandlerChain(file = "EC_IN_SOL_CAMPUS_handler.xml")
public class EC_IN_SOL_CAMPUS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "EC_IN_SOL_PRAC")
    public List<EstructurePracResponse> SOL_PRAC_SYNC(
            @WebParam(name = "NUM_SOL_SERV") String   NUM_SOL_SERV,
            @WebParam(name = "EMPLID") String   EMPLID,
            @WebParam(name = "ELECT_ESTD") String   ELECT_ESTD,
            @WebParam(name = "FECHA_SOL") String   FECHA_SOL,
            @WebParam(name = "FECHA_APROB") String   FECHA_APROB,
            @WebParam(name = "ACAD_PROG") String   ACAD_PROG,
            @WebParam(name = "STRM") String   STRM) throws Exception {
        
        
        SolicitudPrac b = new SolicitudPrac();
        
         return b.RequestBD(NUM_SOL_SERV, EMPLID, ELECT_ESTD, FECHA_SOL, FECHA_APROB, ACAD_PROG, STRM);
         
    }
    
    @WebMethod(operationName = "EC_IN_SOL_MOV")
    public List<EstructureMovResponse> SOL_MOV_SYNC(
            @WebParam(name = "NUM_SOL_SERV") String   NUM_SOL_SERV,
            @WebParam(name = "EMPLID") String   EMPLID,
            @WebParam(name = "PROM_ANT") String   PROM_ANT,
            @WebParam(name = "MAIL_ACUD") String   MAIL_ACUD,
            @WebParam(name = "PROM_ACUM") String   PROM_ACUM,
            @WebParam(name = "SEM_EST") String   SEM_EST,
            @WebParam(name = "OBS_PS") String   OBS_PS,
            @WebParam(name = "ACAD_PROG") String   ACAD_PROG,
            @WebParam(name = "STRM") String   STRM) throws Exception {

        SolicitudMov c = new SolicitudMov();
        
        return c.RequestBD(NUM_SOL_SERV, EMPLID, PROM_ANT, MAIL_ACUD, PROM_ACUM, SEM_EST, OBS_PS, ACAD_PROG, STRM);
    }
}
