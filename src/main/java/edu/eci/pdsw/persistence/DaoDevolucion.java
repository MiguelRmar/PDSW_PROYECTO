/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.entities.EquipoBasico;
import java.sql.Date;

/**
 *
 * @author 2107262
 */
public interface DaoDevolucion {
    
    public void updatePrestamos(int s, int u, java.sql.Date t);

    public void updatePrestamosBasicos(String equipoBasico_nombre, int usuario, Date fechaVencimiento, int cantidad);

    public void updateEquiposBasicosDevo(String equipoBasico_nombre, int cantidadPrestada);
    
}
