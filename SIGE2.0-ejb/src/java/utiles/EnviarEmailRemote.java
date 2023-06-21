/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utiles;

import java.util.HashMap;
import javax.ejb.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Luis Alberto Salas
 */
@Remote
public interface EnviarEmailRemote {
    void inicializar(String idDoc) throws RemoteException;
    public int enviar(String id, String tipo)throws Exception;
    public int enviarEst(String id, String tipo)throws Exception;
    public int enviarEstFormalizaTutor(String idapli)throws Exception;
    public int enviarAdmin(String id, String tipo)throws Exception;
    public int enviarVice(String id, String tipo)throws Exception;
    public int enviarUgeADecPrac(String id) throws Exception;
    public int enviarSolDecPrac(String id, boolean act) throws Exception;
    public int enviarActOferPrac(String id, String dec, String comentario, boolean rechazada) throws Exception;
    public int enviarDevolucionSolPrac(String id, String idsol, boolean rechazada) throws Exception; 
    public int enviarApliEmp(String docgrad, String id) throws Exception;
    public int enviarmasivoGrad(String programaEmailAdmin, String fechainemailG, String fechaoutemailG, String asuntoemailmas, String area1) throws Exception;
}
