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
public class EstructurePracResponse {
    
        public EstructurePracResponse(List<Prac_Response> n1){
            this.n1 = n1;

        }

        private List<Prac_Response> n1;

        public List<Prac_Response> getN1() {
            return n1;
        }

        public void setN1(List<Prac_Response> n1) {
            this.n1 = n1;
        }  
}
