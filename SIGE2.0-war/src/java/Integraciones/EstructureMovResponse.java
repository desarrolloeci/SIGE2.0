/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integraciones;

import java.util.List;

/**
 *
 * @author juan.vanzina
 */
public class EstructureMovResponse {
    
        public EstructureMovResponse(List<Mov_Response> n1){
            this.n1 = n1;

        }

        private List<Mov_Response> n1;

        public List<Mov_Response> getN1() {
            return n1;
        }

        public void setN1(List<Mov_Response> n1) {
            this.n1 = n1;
        }  
}
