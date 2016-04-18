/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.persistence_mybatisimpl;

import eci.pdsw.persistence.DaoEquipos;

import eci.pdsw.persistence.DaoFactory;
import eci.pdsw.persistence.DaoUsuario;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.persistence.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Jhordy
 */
public class MyBatisDaoFactory extends DaoFactory{

    private static volatile SqlSessionFactory sessionFactory;
    
    private Properties appProperties=null;
    
    private SqlSession currentSession=null;
    
    public MyBatisDaoFactory(Properties appProperties) {
        this.appProperties=appProperties;
        if (sessionFactory==null){
            synchronized(MyBatisDaoFactory.class){
                if (sessionFactory==null){
                    sessionFactory=getSqlSessionFactory(this.appProperties); 
                }
            }
           
        }
    }
    
   /**
     * Construye un SQLSessionFactory usando el archivo de configuración de
     * MyBatis cuyo nombre está en el archivo de configuración de la aplicación.
     * @param appProperties
     * @return una nueva SQLSessionFactory
     */
    private SqlSessionFactory getSqlSessionFactory(Properties appProperties) {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(appProperties.getProperty("mybatis-config-file"));
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory;
    }
    
    @Override
    public void beginSession() throws PersistenceException {
        currentSession=sessionFactory.openSession();
    }

    @Override
    public void commitTransaction() throws PersistenceException {
        currentSession.commit();
    }

    @Override
    public void rollbackTransaction() throws PersistenceException {
        currentSession.rollback();
    }

    @Override
    public void endSession() throws PersistenceException {
        currentSession.close();
    }

    @Override
    public DaoUsuario getDaoUsuario() {
        return new MyBatisDaoUsuario(currentSession);
    }

    @Override
    public DaoEquipos getDaoEquipo() {
        return new MyBatisDaoEquipo(currentSession);
     }
    
}