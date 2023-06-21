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
public interface SessionUsrRemote {
  public String getUser();
  public String getRol();
}
