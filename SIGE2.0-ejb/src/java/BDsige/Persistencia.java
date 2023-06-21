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
public class Persistencia {

    private static final String dbName = "jdbc/registro";
    private Connection conexion;
    protected int numRegs;
    private boolean conectado;
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
    public Persistencia() {
        numRegs = -1;
        conectado = false;
    }

    public boolean isConexion() throws SQLException, Exception {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(dbName);
            conexion = ds.getConnection();
            conectado = true;
        } catch (Exception e) {
            throw e;
        }
        return conectado;

    }
    



    public boolean isDesconectar() throws SQLException, Exception {
        try {
            conexion.commit();
            conexion.close();
            conectado = false;
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public HashMap[] getRegistros(String consulta) throws ClassNotFoundException, SQLException, Exception {
        ResultSet resCons_ = null;
        HashMap[] resultado_ = null;
        PreparedStatement sentenciaConsulta_ = null;
        try {
            this.conectado = isConexion();
            sentenciaConsulta_ = this.conexion.prepareStatement(consulta);
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
                if (conectado) {
                    isDesconectar();
                }
            } catch (Exception e) {
                throw new ConsultaException("Error cerrando la conexion a la Base de Datos." + e.getMessage());
            }
        }
    }

    public HashMap getRegistro(String consulta) throws ConsultaException {
        ResultSet resCons_ = null;
        HashMap resultado_ = new HashMap();
        PreparedStatement sentenciaConsulta_ = null;
        try {
            this.conectado = isConexion();
            sentenciaConsulta_ = this.conexion.prepareStatement(consulta);
            resCons_ = sentenciaConsulta_.executeQuery();

            ResultSetMetaData rsm = resCons_.getMetaData();
            //Almacenamos la tabla con las propiedades obtenidas y su resultado
            while (resCons_.next()) {
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    resultado_.put(rsm.getColumnName(i), resCons_.getString(i));
                }
            }
            return resultado_;
        } catch (ClassNotFoundException e) {
            throw new ConsultaException("No se encontro el Driver de la Conexion.");
        } catch (SQLException e) {
            throw new ConsultaException("Error en la consulta: " + e.getMessage());
        } catch (Exception e) {
            throw new ConsultaException("Error no Definido. " + e.getMessage());
        } finally {
            try {
                sentenciaConsulta_.close();
                if (conectado) {
                    isDesconectar();
                }
            } catch (Exception e) {
                throw new ConsultaException("Error cerrando la conexion a la Base de Datos."+ e.getMessage());
            }
        }
    }

    public int actualizar(String consulta) throws ConsultaException {
        try {
            this.conectado = isConexion();
            int resCons;
            PreparedStatement sentenciaConsulta;
            consulta = consulta.replaceAll("<mas>", "+");
            consulta = consulta.replace("+ CHAR(39) + '+char(10)+' + CHAR(39) +", "+char(10)+");
            consulta = consulta.replaceAll("\n", "'+char(10)+'");
            sentenciaConsulta = conexion.prepareStatement(consulta);
            resCons = sentenciaConsulta.executeUpdate();
            sentenciaConsulta.close();
            if (resCons == 0) {
                throw new ConsultaException("Cero filas afectadas.");
            }
            return resCons;
        } catch (ClassNotFoundException e) {
            throw new ConsultaException("No se encontro el Driver de la Conexion. " + e.getMessage());
        } catch (SQLException e) {
            throw new ConsultaException("Error en la Actualizacion. " + e.getMessage());
        } catch (Exception e) {
            throw new ConsultaException("Error no Definido. " + e.getMessage());
        } finally {
            try {
                if (conectado) {
                    isDesconectar();
                }
            } catch (Exception e) {
                throw new ConsultaException("Error cerrando la conexion a la Base de Datos."+ e.getMessage());
            }
        }
    }
    
    public int actualizarConCeroFilas(String consulta) throws ConsultaException {
        try {
            this.conectado = isConexion();
            int resCons;
            PreparedStatement sentenciaConsulta;
            consulta = consulta.replaceAll("<mas>", "+");
            consulta = consulta.replace("+ CHAR(39) + '+char(10)+' + CHAR(39) +", "+char(10)+");
            consulta = consulta.replaceAll("\n", "'+char(10)+'");
            sentenciaConsulta = conexion.prepareStatement(consulta);
            resCons = sentenciaConsulta.executeUpdate();
            sentenciaConsulta.close();
            if (resCons == 0) {
                resCons=1;
            }
            return resCons;
        } catch (ClassNotFoundException e) {
            throw new ConsultaException("No se encontro el Driver de la Conexion. " + e.getMessage());
        } catch (SQLException e) {
            throw new ConsultaException("Error en la Actualizacion. " + e.getMessage());
        } catch (Exception e) {
            throw new ConsultaException("Error no Definido. " + e.getMessage());
        } finally {
            try {
                if (conectado) {
                    isDesconectar();
                }
            } catch (Exception e) {
                throw new ConsultaException("Error cerrando la conexion a la Base de Datos."+ e.getMessage());
            }
        }
    }

    public String getMensaje() {
        return this.mensaje;
    }
}
