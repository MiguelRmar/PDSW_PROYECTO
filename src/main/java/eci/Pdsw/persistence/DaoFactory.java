/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.persistence;

import eci.pdsw.persistence.mybatisimpl.MyBatisDaoFactory;
import java.util.Properties;
import javax.persistence.PersistenceException;

/**
 *
 * @author Jhordy
 */
public abstract class DaoFactory {
    
    protected DaoFactory() {
    }

    private static volatile DaoFactory instance = null;

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

    public abstract void beginSession() throws PersistenceException;

    public abstract DaoUsuario getDaoUsuario();

    public abstract void commitTransaction() throws PersistenceException;

    public abstract void rollbackTransaction() throws PersistenceException;

    public abstract void endSession() throws PersistenceException;
}
