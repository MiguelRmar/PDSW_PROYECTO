
import eci.pdsw.entities.PrestamoUsuario;
import eci.pdsw.services.Services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2107262
 */
public class DevolucionTest {
     
    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from ROLES_USUARIOS");
        stmt.execute("delete from ROLES");
        stmt.execute("delete from PRESTAMOS");
        stmt.execute("delete from EQUIPOS");
        stmt.execute("delete from MODELOS");
        stmt.execute("delete from PRESTAMOS_BASICOS");
        stmt.execute("delete from EQUIPOS_BASICOS");
        stmt.execute("delete from USUARIOS");
        conn.commit();
        conn.close();
    }
    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");
    }  
    
    //Prueba 1:Un usuario con un solo prestamo realiza una devolucion
    //@Test
    public void firstTest() throws SQLException{
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        Services servicios = Services.getInstance("h2-applicationconfig.properties");
        PrestamoUsuario prestamo =null;
        try {
            //Insercion en BD
            stmt.execute("INSERT INTO ROLES(rol) values ('estudiante')");
            stmt.execute("INSERT INTO USUARIOS (id,nombre,correo,contrasena) VALUES (124,'PEDRO PEREZ','pedro.perez@mail.escuelaing.edu.co','1test1')");
            stmt.execute("INSERT INTO ROLES_USUARIOS(USUARIOS_id,ROLES_rol) values (124,'estudiante')");
            stmt.execute("INSERT INTO MODELOS (nombre,clase,vidaUtil,valor,seguro,foto) values ('modelo1','abcd',100,200000,true,null)");              
            stmt.execute("INSERT INTO EQUIPOS (serial,nombre,placa,marca,descripcion,estado,subestados,proveedor,Modelos_nombre) VALUES (123,'Multimetro',456,'falsa','Equipo funcional y  de buena calidad','activo','almacen','Leonardo Herrera','modelo1')");
            stmt.execute("INSERT INTO PRESTAMOS (USUARIOS_id,EQUIPOS_serial,fechaExpedicion,fechaVencimiento,tipoPrestamo) VALUES (124,123,'2015-01-01 00:00:00',null,'prestamo diario')");
            conn.commit();
            conn.close();                      
        } catch (SQLException ex) {
            Logger.getLogger(DevolucionTest.class.getName()).log(Level.SEVERE, null, ex);
            conn.rollback();
            conn.close();
        }
        Set<PrestamoUsuario> prestamos = servicios.loadPrestamos();
        for (PrestamoUsuario p:prestamos){
            
        }
    }
}
