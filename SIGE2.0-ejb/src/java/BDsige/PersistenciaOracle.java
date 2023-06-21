/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BDsige;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import utiles.ConsultaException;

/**
 *
 * @author Luis Alberto Salas
 */
public class PersistenciaOracle {

    private static final String dbNameOracle = "jdbc/inthubpipe";

    private Connection conOracle;

    protected int numRegs;

    private Boolean conectadoOracle;

    protected String dbUrl;
    private String driver = "net.sourceforge.jtds.jdbc.Driver";
    /**
     * En este atributo de clase se almacenan todos los mensajes
     * cuando se ejecutan acciones sobre la base de datos. Es importante
     * tener en cuenta que sólo el último mensaje está disponible,
     * porque con cada nueva acción, el mensaje es actualizado.
     */
    protected String mensaje;

    /** Crea una instancia del objeto base de datos para ser usada por otros
     * objetos. Coloca el numero de registros en -1 y no hay conexion aun :
     * conectado = false
     */
    public PersistenciaOracle() {
        numRegs = -1;
        conectadoOracle = false;
    }

    
    public Boolean isConexionOracle(){
        Boolean ans=false;
        try{
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(dbNameOracle);
            conOracle = ds.getConnection();
            conectadoOracle = true;
            ans=true;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaOracle.class.getName()).log(Level.SEVERE, null, ex);
            return ans;
        } catch (NamingException ex) {
            Logger.getLogger(PersistenciaOracle.class.getName()).log(Level.SEVERE, null, ex);
            return ans;
        }
        return ans;
    }
    
    public HashMap[] getRegistrosOracle(String consulta){
        HashMap[] ans = null;
        Statement stmt = null;
        try{
            conectadoOracle=isConexionOracle();
            stmt=conOracle.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            ArrayList listado = new ArrayList();
            ResultSetMetaData rsm = rs.getMetaData();
            //Almacenamos la tabla con las propiedades obtenidas y su resultado
            while (rs.next()) {
                HashMap ht = new HashMap();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    ht.put(rsm.getColumnName(i), rs.getString(i));
                }
                listado.add(ht);
            }
            //Preparamos el resultado
            ans = new HashMap[listado.size()];
            ans = (HashMap[]) listado.toArray(ans);
            
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaOracle.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally {
            try {
                stmt.close();
                if (conectadoOracle) {
                    stmt.close();
                    isDesconectarOracle();
                }
            } catch (Exception e) {
                Logger.getLogger(PersistenciaOracle.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ans;
    }
    
    public Boolean isDesconectarOracle(){
        Boolean ans=false;
        try{
            conOracle.close();
            ans=true;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaOracle.class.getName()).log(Level.SEVERE, null, ex);
            return ans;
        }
        return ans;
    }

    public String getMensaje() {
        return this.mensaje;
    }
}
