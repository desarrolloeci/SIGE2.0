/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import javax.ejb.Remote;

/**
 *
 * @author Luis Alberto Salas
 */
@Remote
public interface loginEstRemote {

    public java.lang.String getInicio(java.lang.String usuario, java.lang.String clave);
    
}
