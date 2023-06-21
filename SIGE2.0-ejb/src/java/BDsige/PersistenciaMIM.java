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
public class PersistenciaMIM {

    private static final String dbNameMIM = "jdbc/mim";

    private Connection conexionMIM;
    protected int numRegs;

    private Boolean conectadoMIM;
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
    public PersistenciaMIM() {
        numRegs = -1;
        conectadoMIM=false;
    }

    
    public boolean isConexionMIM() throws SQLException, Exception {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(dbNameMIM);
            conexionMIM = ds.getConnection();
            conectadoMIM = true;
        } catch (Exception e) {
            throw e;
        }
        return conectadoMIM;

    }

    
    public HashMap[] getRegistrosMIM(String consulta) throws ClassNotFoundException, SQLException, Exception {
        ResultSet resCons_ = null;
        HashMap[] resultado_ = null;
        PreparedStatement sentenciaConsulta_ = null;
        try {
            this.conectadoMIM = isConexionMIM();
            sentenciaConsulta_ = this.conexionMIM.prepareStatement(consulta);
            resCons_ = sentenciaConsulta_.executeQuery();
            ArrayList listado = new ArrayList();
            ResultSetMetaData rsm = resCons_.getMetaData();
            //Almacenamos la tabla con las propiedades obtenidas y su resultado
            while (resCons_.next()) {
                HashMap ht = new HashMap();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    ht.put(rsm.getColumnName(i), resCons_.getString(i));
                }
                listado.add(ht);
            }
            //Preparamos el resultado
            resultado_ = new HashMap[listado.size()];
            resultado_ = (HashMap[]) listado.toArray(resultado_);
            return resultado_;
        } catch (ClassNotFoundException e) {
            throw new ConsultaException("No se encontro el Driver de la Conexion.");
        } catch (SQLException e) {
            throw new ConsultaException("Error en la Consulta.");
        } catch (Exception e) {
            throw new ConsultaException("Error no Definido. " + e.getMessage());
        } finally {
            try {
                sentenciaConsulta_.close();
                if (conectadoMIM) {
                    isDesconectarMIM();
                }
            } catch (Exception e) {
                throw new ConsultaException("Error cerrando la conexion a la Base de Datos." + e.getMessage());
            }
        }
    }
    
    public boolean isDesconectarMIM() throws SQLException, Exception {
        try {
            conexionMIM.commit();
            conexionMIM.close();
            conectadoMIM = false;
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String getMensaje() {
        return this.mensaje;
    }
}
