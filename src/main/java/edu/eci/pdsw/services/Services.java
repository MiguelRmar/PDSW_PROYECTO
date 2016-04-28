/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.services;

import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.EquipoBasico;
import edu.eci.pdsw.entities.Modelo;
import edu.eci.pdsw.entities.PrestamoUsuario;
import edu.eci.pdsw.persistence.DaoFactory;
import edu.eci.pdsw.entities.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

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
     * carga un usuario dado el id de este
     * @param id, el identificador del usuario a cargar
     * @return el usuario identificado con ese id
     */
    public Usuario loadUsuarioById(int id){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        Usuario ans =df.getDaoUsuario().loadUsuarioById(id);
        df.commitTransaction();
        df.endSession();
        return ans;
    }
    
    /**
     * carga un modelo dado el nombre de este
     * @param nombre, el nombre del modelo a cargar
     * @return el modelo identificado con ese nombre
     */    
    public Modelo loadModeloByName(String nombre){
        DaoFactory df=  DaoFactory.getInstance(properties);
        df.beginSession();
        Modelo ans = df.getDaoEquipo().loadModeloByName(nombre);
        df.endSession();
        return ans;
    }
    
    /**
     * carga un equipo dado el serial de este
     * @param serial, el serial del equipo a cargar
     * @return el equipo identificado con ese serial
     */    
    public Equipo loadEquipoBySerial(int serial){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        Equipo ans =df.getDaoEquipo().loadEquipoBySerial(serial);
        df.endSession();
        return ans;
    }
    
    /**
     * carga un equipo basico dado el nombre de este
     * @param nombre, el nombre del equipo basico a cargar
     * @return el equipo basico identificado con ese nombre
    */
    public EquipoBasico loadEquipoBasicoByName(String name){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        EquipoBasico ans =df.getDaoEquipo().loadEquipoBasicoByName(name);
        df.endSession();
        return ans; 
    }
    
    /**
     * cargar todos los prestamos
     * @return un contenedor con todos los prestamos que se han hecho
     */    
    public Set<PrestamoUsuario> loadPrestamos(){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        Set<PrestamoUsuario> ans =df.getDaoUsuario().loadPrestamos();
        df.commitTransaction();
        df.endSession();
        return ans;
    }
    
    /**
     * registrar un equipo nuevo dado el equipo como entidad (objeto)
     * @param e, el equipo a registrar en la bd
     * @param modelo, el modelo al que pertenece este equipo
     */    
    public void registroEquipoNuevo(Equipo equipo,String modelo){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        df.getDaoEquipo().registrarEquipoNuevo(equipo,modelo);
        df.commitTransaction();
        df.endSession();
    }
    
    /**
     * registrar un modelo nuevo dado el modelo como entidad (objeto)
     * @param m, el modelo a registrar en la bd
     */    
    public void registroModeloNuevo(Modelo modelo){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        df.getDaoEquipo().registrarModeloNuevo(modelo);
        df.commitTransaction();
        df.endSession();
    }
    
    /**
     * registrar un equipo nuevo dado el equipo como entidad (objeto)
     * @param e, el equipo a registrar en la bd
     * @param modelo, el modelo al que pertenece este equipo
     */    
    public void registroEquipoBasicoNuevo(EquipoBasico equipobasico){
        DaoFactory df=DaoFactory.getInstance(properties);
        df.beginSession();
        df.getDaoEquipo().registrarEquipoBasicoNuevo(equipobasico);
        df.commitTransaction();
        df.endSession();
    }
    
     /**
     * cargar todos los usuarios
     * @return un contenedor con todos los usuarios que estan registrados
     */    
    public Set<Usuario> loadUsuarios(){
        DaoFactory df= DaoFactory.getInstance(properties);
        df.beginSession();
        Set<Usuario> usuarios = df.getDaoUsuario().loadUsuarios();
        df.commitTransaction();
        df.endSession();
        return usuarios;
    }
    
    /**
     * cargar todos los modelos
     * @return un contenedor con todos los modelos que se han registrado
     */    
    public Set<Modelo> loadModelos(){
        DaoFactory df= DaoFactory.getInstance(properties);
        df.beginSession();
        Set<Modelo> modelos = df.getDaoEquipo().loadModelos();
        df.commitTransaction();
        df.endSession();
        return modelos;
    }
    
    /**
     * cargar todos los equipos basicos
     * @return un contenedor con todos los equipos basicos que se han registrado
     */    
    public Set<EquipoBasico> loadEquiposBasicos(){
        DaoFactory df= DaoFactory.getInstance(properties);
        df.beginSession();
        Set<EquipoBasico> equiposBasicos= df.getDaoEquipo().loadEquiposBasicos();
        df.commitTransaction();
        df.endSession();
        return equiposBasicos;
    }
    
    public void updateEquipoBasico(EquipoBasico equipoBasico,int cantidad){
        DaoFactory df= DaoFactory.getInstance(properties);
        df.beginSession();
        df.getDaoEquipo().updateEquipoBasico(equipoBasico,cantidad);
        df.commitTransaction();
        df.endSession();
    }
    
}
