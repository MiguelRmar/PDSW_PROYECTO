/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.persistence;

import eci.pdsw.entities.Equipo;
import eci.pdsw.entities.Modelo;

/**
 *
 * @author 2107262
 */
public interface DaoEquipos {
    
    public void registroEquipoNuevo(Equipo e);
    
    public void registrarModeloNuevo(Modelo m);

    public Modelo loadModelo(String nombre);
    
}
