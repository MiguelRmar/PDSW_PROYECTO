/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.entities.Modelo;
import edu.eci.pdsw.entities.PrestamoEquipo;
import edu.eci.pdsw.entities.PrestamoUsuario;
import javax.persistence.PersistenceException;

/**
 *
 * @author 2105534
 */
public interface DaoPrestamo {
     /**
    * registrar un prestamo nuevo dado el prestamo como entidad (objeto)
    * @param pe, el prestamoEquipo a registrar en la bd
    * @param pu, el prestamoUsuario a registrar en la bd
    */
    public void registrarNuevoPrestamo(PrestamoEquipo pe,PrestamoUsuario pu) throws PersistenceException;
}
