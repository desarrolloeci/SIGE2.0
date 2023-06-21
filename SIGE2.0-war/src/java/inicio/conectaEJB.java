/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inicio;

import BDsige.AdministradoresRemote;
import BDsige.AdministrativosRemote;
import BDsige.DecanoRemote;
import BDsige.EmpleadoRemote;
import BDsige.EmpresaRemote;
import BDsige.EstudiantesRemote;
import BDsige.graduadoRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import login.LogsigeRemote;
import login.SessionGradRemote;
import login.loginEstRemote;
import login.loginempRemote;
import login.logingradRemote;
import utiles.EnviarEmailRemote;

/**
 *
 * @author Luis Alberto Salas
 */
public class conectaEJB {
 boolean conProf;
    boolean conLog;

    /** Creates a new instance of conectaEJB */
    public conectaEJB() {
        conProf = false;
        conLog = false;
    }


    public EmpleadoRemote lookupEmpleadoRemote() {
        try {
            Context c = new InitialContext();
            return (EmpleadoRemote) c.lookup("java:comp/env/Empleado");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    } 

    public AdministrativosRemote lookupAdministrativosRemote() {
        try {
            Context c = new InitialContext();
            return (AdministrativosRemote) c.lookup("java:comp/env/Administrativos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    public EstudiantesRemote lookupEstudiantesRemote() {
        try {
            Context c = new InitialContext();
            return (BDsige.EstudiantesRemote) c.lookup("java:comp/env/Estudiantes");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public AdministradoresRemote lookupAdministradoresRemote() {
        try {
            Context c = new InitialContext();
            return (AdministradoresRemote) c.lookup("java:comp/env/Administradores");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public DecanoRemote lookupDecanoRemote() {
        try {
            Context c = new InitialContext();
            return (DecanoRemote) c.lookup("java:comp/env/Decano");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    public graduadoRemote lookupgraduadoRemote() {
        try {
            Context c = new InitialContext();
            return (BDsige.graduadoRemote) c.lookup("java:comp/env/graduado");

        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public logingradRemote lookuplogingradRemote() {
        try {
            Context c = new InitialContext();
            return (login.logingradRemote) c.lookup("java:comp/env/logingrad");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
      public loginEstRemote lookuploginEstRemote() {
        try {
            Context c = new InitialContext();
            return (loginEstRemote) c.lookup("java:comp/env/loginEst");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public EmpresaRemote lookupEmpresaRemote() {
        try {
            Context c = new InitialContext();
            return (EmpresaRemote) c.lookup("java:comp/env/Empresa");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

   

    public SessionGradRemote lookupSessionGradRemote() {
        try {
            Context c = new InitialContext();
            return (SessionGradRemote) c.lookup("java:comp/env/SessionGrad");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
   

    public LogsigeRemote lookupLogsigeRemote() {
        try {
            Context c = new InitialContext();
            return (LogsigeRemote) c.lookup("java:comp/env/Logsige");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public loginempRemote lookuploginempRemote() {
        try {
            Context c = new InitialContext();
            return (loginempRemote) c.lookup("java:comp/env/loginemp");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public EnviarEmailRemote lookupEnviarEmailRemote() {
        try {
            Context c = new InitialContext();
            return (EnviarEmailRemote) c.lookup("java:comp/env/EnviarEmail");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
