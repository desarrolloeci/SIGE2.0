/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDsige;

import java.util.HashMap;

/**
 *
 * @author andres.rojas
 */
public class HomolPais {
    private Persistencia bDatos= new Persistencia();
    public HashMap homologaPaisISO(String cod_iso) throws Exception{
        return bDatos.getRegistro("select cod_iso, nom_pais from uge.paises where cod_iso ='"+cod_iso+"'");
    }
    
}
