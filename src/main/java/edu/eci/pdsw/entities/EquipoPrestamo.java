/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

/**
 *
 * @author carlo
 */
public class EquipoPrestamo {
    private String tipoPrestamo;
    private Equipo equipoBasico;
    public EquipoPrestamo(Equipo eq,String tipo){
        tipoPrestamo=tipo;
       
        equipoBasico=eq;
    }

    /**
     * @return the tipoPrestamo
     */
    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    /**
     * @param tipoPrestamo the tipoPrestamo to set
     */
    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    /**
     * @return the equipoBasico
     */
    public Equipo getEquipoBasico() {
        return equipoBasico;
    }

    /**
     * @param equipoBasico the equipoBasico to set
     */
    public void setEquipoBasico(Equipo equipoBasico) {
        this.equipoBasico = equipoBasico;
    }
}
