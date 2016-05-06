/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.entities.EquipoBasico;
import java.sql.Date;
import javax.persistence.PersistenceException;

/**
 *
 * @author 2107262
 */
public interface DaoDevolucion {
    
    /**
     * Actualizar la fecha de vencimiento de un prestamo normal
     * @param s, serial del equipo a devolver
     * @param u, identificador del usuario que esta devolviendo el equipo
     */
    public void updatePrestamos(int s, int u) throws PersistenceException;

    /**
     * Actualizar la fecha de vencimiento para un préstamo de equipo básico
     * @param equipoBasico_nombre, nombre del equipo basico a devolver
     * @param usuario, id del usuario que realiza la devolución
     */
    public void updatePrestamosBasicos(String equipoBasico_nombre, int usuario) throws PersistenceException;
    
    /**
     * Actualizar la cantidad en almacen de un equipo básico
     * @param equipoBasico_nombre, nombre del equipo basico a devolver
     * @param cantidadPrestada, cantidad devuelta
     */
    public void updateEquiposBasicosDevo(String equipoBasico_nombre, int cantidadPrestada) throws PersistenceException;
    
    /**
     * Actualizar el estado y el subestado de un equipo
     * @param equipo_serial, serial del equipo devuelto
     */
    public void updateEquiposDevo(int equipo_serial) throws PersistenceException;
    
}
