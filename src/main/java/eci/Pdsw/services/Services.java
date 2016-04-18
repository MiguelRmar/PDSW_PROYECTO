/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.services;

import eci.pdsw.entities.Equipo;
import eci.pdsw.entities.Modelo;
import eci.pdsw.persistence.DaoFactory;
import eci.pdsw.entities.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;

/**
 *
 * @author Jhordy
 */
public class Services {

    private static Services instance=null;
    
    private final Properties properties=new Properties();
    
    private final DaoFactory dc=null;
    
    private Services(String propFileName) throws IOException{        
	InputStream input = null;
        input = this.getClass().getClassLoader().getResourceAsStream(propFileName);        
        properties.load(input);
        
    }
    
    public static Services getInstance(String propertiesFileName) throws RuntimeException{
        if (instance==null){
            try {
                instance=new Services(propertiesFileName);
            } catch (IOException ex) {
                throw new RuntimeException("Error on application configuration:",ex);
            }
        }        
        return instance;
    }
    
    /*METODOS*/
    
    public Usuario loadUsuarioById(int id) throws ServicesException{
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        Usuario ans =df.getDaoUsuario().loadUsuarioById(id);
        return ans;
    }
    public void registroEquipoNuevo(Equipo equipo) throws ServicesException{
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        df.getDaoEquipo().registroEquipoNuevo(equipo);
    }
    public void registroModeloNuevo(Modelo modelo) throws ServicesException{
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        df.getDaoEquipo().registrarModeloNuevo(modelo);
    }  
}
