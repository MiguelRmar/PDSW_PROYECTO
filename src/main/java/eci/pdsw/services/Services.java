/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.services;

import eci.pdsw.entities.Equipo;
import eci.pdsw.entities.Modelo;
import eci.pdsw.entities.PrestamoUsuario;
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
    /**
     *
     * @param id
     * @return
     * @throws eci.pdsw.services.ServicesException
     * @throws ServicesException
     */
    public Usuario loadUsuarioById(int id){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        Usuario ans =df.getDaoUsuario().loadUsuarioById(id);
        df.commitTransaction();
        df.endSession();
        return ans;
    }
    
    public Set<PrestamoUsuario> loadPrestamos(){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        Set<PrestamoUsuario> ans =df.getDaoUsuario().loadPrestamos();
        df.commitTransaction();
        df.endSession();
        return ans;
    }
    
    public void registroEquipoNuevo(Equipo equipo){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        df.getDaoEquipo().registroEquipoNuevo(equipo);
        df.commitTransaction();
        df.endSession();
    }
    public void registroModeloNuevo(Modelo modelo){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        df.getDaoEquipo().registrarModeloNuevo(modelo);
        df.commitTransaction();
        df.endSession();
    }  
    public Modelo loadModeloByName(String nombre){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        Modelo ans =df.getDaoEquipo().loadModelo(nombre);
        df.endSession();
        return ans;
    }
}
