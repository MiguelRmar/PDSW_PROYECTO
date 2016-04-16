/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import eci.pdsw.mybatis.mappers.EquipoMapper;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        Connection conn =  DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from USUARIOS");
        stmt.execute("delete from EQUIPOS");
        stmt.execute("delete from EQUIPOS_BASICOS");
        stmt.execute("delete from PRESTAMOS");
        stmt.execute("delete from PRESTAMOS_BASICOS");
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
    public void OneTest() throws SQLException{
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAa");
        Connection conn=getConnection();
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAa2");
        Statement stmt=conn.createStatement();        
        stmt.execute("INSERT INTO USUARIOS (id,nombre,correo,contrasena) VALUES (123,'PEDRO PEREZ','pedro.perez@mail.escuelaing.edu.co','1test1')");
        stmt.execute("INSERT INTO EQUIPOS (serial,nombre,modelo,clase,vidaUtil,valor,seguro,foto,placa,marca,descripcion,estado,subestados,proveedor) VALUES (456,'MultiTest',115,'abcd',100,200000,true,null,789,'La Ultima','tamano y altura promedio con buena calidad','activo','prestamo diario','Jhordy Salinas')");
        stmt.execute("INSERT INTO EQUIPOS_BASICOS (nombre,valor,foto,descripcion,cantidad) VALUES ('cables','5000',null,'un metro de longitud y 0.5 centimetros de diametro',500)");
        stmt.execute("INSERT INTO PRESTAMOS (USUARIOS_id,EQUIPOS_serial,fechaExpedicion,fechaVencimiento,tipoPrestamo) VALUES (123,456,'2000-01-01','2000-01-01','prestamo diario')");
        stmt.execute("INSERT INTO PRESTAMOS_BASICOS (USUARIOS_id,EQUIPOS_BASICOS_nombre,fechaExpedicion,fechaVencimiento,tipoPrestamo) VALUES (123,'cables','2000-01-01','2000-01-02','prestamo 24 horas')");
        conn.commit();
        conn.close();
        //Realizar la operacion de la logica y la prueba
        assertTrue(true);
    }
    
    
}
