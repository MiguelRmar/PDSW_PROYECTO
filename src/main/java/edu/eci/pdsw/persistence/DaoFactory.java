/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.persistence_mybatisimpl.MyBatisDaoFactory;
import java.util.Properties;
import javax.persistence.PersistenceException;

/**
 *
 * @author Jhordy
 */
public abstract class DaoFactory {
    
    /**
     * 
     */
    protected DaoFactory() {
    }
    
    private static volatile DaoFactory instance = null;
    
    /**
     * crear una instancia de este objeto
     * @param appProperties, las propiedades que configuran el dao
     * @return un onjeto de esta clase
     */
    public static DaoFactory getInstance(Properties appProperties) {
        if (instance == null) {
            synchronized (DaoFactory.class) {
                if (instance == null) {
                    if (appProperties.get("dao").equals("mybatis")) {
                        instance = new MyBatisDaoFactory(appProperties);
                    } else {
                        throw new RuntimeException("Wrong configuration: Unsupported DAO:" + appProperties.get("dao"));
                    }
                }
            }
        }
        return instance;
    }
    
    /**
     * iniciar sesion en el dao 
     * @throws PersistenceException 
     */
    public abstract void beginSession() throws PersistenceException;

    /**
     * obtener un objeto del dao usuario para usar sus metodos
     * @return un objeto de tipo dao usuario
    */
    public abstract DaoUsuario getDaoUsuario();
    
    /**
     * obtener un objeto del dao equipo para usar sus metodos
     * @return un objeto de tipo dao equipo
     */
    public abstract DaoEquipo getDaoEquipo();
    
    /**
     * obtener un objeto del dao devolucion para usar sus metodos
     * @return un objeto de tipo dao devolucion
     */
    public abstract DaoDevolucion getDaoDevolucion();
    /**
     * obtener un objeto del dao prestamo para usar sus metodos
     * @return un objeto de tipo dao prestamo
     */
    public abstract DaoPrestamo getDaoPrestamo();
    /**
     * realizar los cambios en el dao
     * @throws PersistenceException 
     */
    public abstract void commitTransaction() throws PersistenceException;

    /**
     * devuelve estado en el dao
     * @throws PersistenceException 
     */
    public abstract void rollbackTransaction() throws PersistenceException;
    
    /**
     * cerrar sesion en el dao
     * @throws PersistenceException 
     */
    public abstract void endSession() throws PersistenceException;
}

