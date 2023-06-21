/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integraciones;

/**
 *
 * @author juan.vanzina
 */
public class Mov_Response {
    
    private String codigo,motivo;
    
    public Mov_Response(String codigo, String motivo){
        this.codigo = codigo;
        this.motivo = motivo;
        
    }

    public Mov_Response() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
