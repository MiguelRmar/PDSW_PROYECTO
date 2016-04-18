/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.persistence;

import eci.pdsw.entities.Prestamo;
import eci.pdsw.entities.Usuario;
import java.util.Set;
import javax.persistence.PersistenceException;

/**
 *
 * @author Jhordy
 */
public interface DaoUsuario {
    
    /**
     *
     * @param id
     * @return
     * @throws PersistenceException
     */
    public Usuario loadUsuarioById(int id) throws PersistenceException;
    
    public Set<Prestamo> loadPrestamos() throws PersistenceException;
    
}
