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
public class SolicitudPrac {
        
         public List<EstructurePracResponse> RequestBD(String NUM_SOL_SERV, String EMPLID, String ELECT_ESTD, String FECHA_SOL, String FECHA_APROB, String ACAD_PROG, String STRM) throws Exception{

               int ban = 0;
              List<EstructurePracResponse> estruct = new ArrayList<>();   
              List<Prac_Response>  listainfo = new ArrayList<>();   
              
              inicio.conectaEJB conEjb = new inicio.conectaEJB();
              BDsige.EstudiantesRemote best= conEjb.lookupEstudiantesRemote();
              best.inicializar("75107740");
              
              try {
                 
                   ban = best.crearSolicitud_int_prac_campus(NUM_SOL_SERV, EMPLID, ELECT_ESTD, FECHA_SOL, FECHA_APROB, ACAD_PROG, STRM);
                  
                  listainfo.add(new Prac_Response("0","Operacion exitosa"));
                  
             } catch (Exception e) {
                 
                 String msg= e.getMessage();
                 listainfo.add(new Prac_Response("1","Error: "+msg ));
             }

              estruct.add(new EstructurePracResponse(listainfo));

              return  estruct;
              
          }
    
}