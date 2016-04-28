/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.EquipoBasico;
import edu.eci.pdsw.entities.Modelo;
import java.util.Set;

/**
 *
 * @author 2107262
 */
public interface DaoEquipo {
    
    public Modelo loadModeloByName(String nombre);
    
    public Equipo loadEquipoBySerial(int serial);
    
    public EquipoBasico loadEquipoBasicoByName(String nombre);
    
    public void registrarEquipoNuevo(Equipo e,String modelo);
    
    public void registrarModeloNuevo(Modelo m);
    
    public void registrarEquipoBasicoNuevo(EquipoBasico eq);
    
    public Set<Modelo> loadModelos();
    
    public Set<EquipoBasico> loadEquiposBasicos();
    
    public void updateEquipoBasico(EquipoBasico equipoBasico,int cantidad);
    
}
