/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.entities.PrestamoUsuario;
import edu.eci.pdsw.entities.Usuario;
import java.util.Set;
import javax.persistence.PersistenceException;

/**
 *
 * @author Jhordy
 */
public interface DaoUsuario {
    
    /**
    * carga un usuario dado el id de este
    * @param id, el identificador del usuario a cargar
    * @return el usuario identificado con ese id
    */
    public Usuario loadUsuarioById(int id) throws PersistenceException;
    
    /**
    * cargar todos los prestamos
    * @return un contenedor con todos los prestamos que se han hecho
    */    
    public Set<PrestamoUsuario> loadPrestamos() throws PersistenceException;
    
    /**
     * cargar todos los usuarios
     * @return un contenedor con todos los usuarios que estan registrados
     */
    public Set<Usuario> loadUsuarios() throws PersistenceException;
}
