/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import eci.pdsw.services.Services;
import eci.pdsw.services.ServicesException;
import eci.pdsw.entities.Equipo;
import eci.pdsw.entities.Prestamo;
import eci.pdsw.entities.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import eci.pdsw.mybatis.mappers.EquipoMapper;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import junit.framework.Assert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author 2105461
 */
public class RegistroDevolucionTest {
    
    public RegistroDevolucionTest(){}
    
    
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
    
    @Test
    public void OneTest() throws SQLException, ServicesException{
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();       
        stmt.execute("INSERT INTO ROLES(rol) values ('estudiante')");
        stmt.execute("INSERT INTO ROLES(rol) values ('profesor')");
        stmt.execute("INSERT INTO ROLES(rol) values ('laboratorista')");
        stmt.execute("INSERT INTO ROLES(rol) values ('administrador')");
        stmt.execute("INSERT INTO USUARIOS (id,nombre,correo,contrasena) VALUES (124,'PEDRO PEREZ','pedro.perez@mail.escuelaing.edu.co','1test1')");
        stmt.execute("INSERT INTO USUARIOS (id,nombre,correo,contrasena) VALUES (123,'PEDRO PEREZ','pedro.perez@mail.escuelaing.edu.co','1test1')");
        stmt.execute("INSERT INTO ROLES_USUARIOS(USUARIOS_id,ROLES_rol) values (124,'laboratorista')");
        stmt.execute("INSERT INTO ROLES_USUARIOS(USUARIOS_id,ROLES_rol) values (124,'estudiante')");
        stmt.execute("INSERT INTO MODELOS (nombre,clase,vidaUtil,valor,seguro,foto) values ('modelo1','abcd',100,200000,true,null)");              
        
        
        stmt.execute("INSERT INTO EQUIPOS (serial,nombre,placa,marca,descripcion,estado,subestados,proveedor,Modelos_nombre) VALUES (456,'MultiTest',789,'La Ultima','tamano y altura promedio con buena calidad','activo','prestamo diario','Jhordy Salinas','modelo1')");
        stmt.execute("INSERT INTO EQUIPOS (serial,nombre,placa,marca,descripcion,estado,subestados,proveedor,Modelos_nombre) VALUES (567,'MultiTest',245,'La Ultima','tamano y altura promedio con buena calidad','activo','prestamo diario','Jhordy Salinas','modelo1')");
        
        stmt.execute("INSERT INTO EQUIPOS_BASICOS (nombre,valor,foto,descripcion,cantidad) VALUES ('cables','5000',null,'un metro de longitud y 0.5 centimetros de diametro',500)");      
        
        stmt.execute("INSERT INTO PRESTAMOS (USUARIOS_id,EQUIPOS_serial,fechaExpedicion,fechaVencimiento,tipoPrestamo) VALUES (124,567,'2015-01-01 00:00:00',null,'prestamo diario')");
        stmt.execute("INSERT INTO PRESTAMOS (USUARIOS_id,EQUIPOS_serial,fechaExpedicion,fechaVencimiento,tipoPrestamo) VALUES (124,456,'2015-01-01 00:00:00',null,'prestamo diario')");
        
        stmt.execute("INSERT INTO PRESTAMOS_BASICOS (USUARIOS_id,EQUIPOS_BASICOS_nombre,fechaExpedicion,fechaVencimiento,tipoPrestamo,cantidadPrestada) VALUES (124,'cables','2015-01-01 00:00:00','2015-01-01 03:00:00','prestamo 24 horas',10)");
        conn.commit();
        conn.close();
        //Realizar la operacion de la logica y la prueba
        Services servicios=Services.getInstance("h2-applicationconfig.properties");
        Usuario Jhordy = servicios.loadUsuarioById(124);
        System.out.println(Jhordy.toString());
        //Set<Prestamo> jhordy= servicios.loadPrestamos();
        //System.out.println(jhordy.toString());
        //Prestamo ans = new Prestamo(123,456,java.sql.Date.valueOf("2015-01-01 00:00:00"),null,"prestamo diario");
        //Set<Prestamo> p_jhordy = jhordy.getPrestamos();
        //assertEquals(p_jhordy.contains(ans),true);*/
    }
    
}
