/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integraciones;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author juan.vanzina
 */
public class SolicitudMov {
        
         public List<EstructureMovResponse> RequestBD(String NUM_SOL_SERV, String EMPLID, String PROM_ANT, String MAIL_ACUD, String PROM_ACUM, String SEM_EST, String OBS_PS, String ACAD_PROG, String STRM) throws Exception{

              int ban = 0;
              List<EstructureMovResponse> estruct = new ArrayList<>();   
              List<Mov_Response>  listainfo = new ArrayList<>();   
              
              inicio.conectaEJB conEjb = new inicio.conectaEJB();
              BDsige.EstudiantesRemote best= conEjb.lookupEstudiantesRemote();
              best.inicializar("75107740");
              
              try {
                 
                  ban = best.crearSolicitud_int_mov_campus(NUM_SOL_SERV, EMPLID, PROM_ANT, MAIL_ACUD, PROM_ACUM, SEM_EST, OBS_PS, ACAD_PROG, STRM);
                  
                  listainfo.add(new Mov_Response("0","Operacion exitosa"));
                  
             } catch (Exception e) {
                 
                 String msg= e.getMessage();
                 listainfo.add(new Mov_Response("1","Error: "+msg ));
             }

              estruct.add(new EstructureMovResponse(listainfo));

              return  estruct;
              
          }
    
}