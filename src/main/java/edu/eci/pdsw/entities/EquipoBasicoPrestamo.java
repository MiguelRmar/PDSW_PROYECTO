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
public class EquipoBasicoPrestamo {
    private EquipoBasico equipoBasico;
    private int cantidad;
    private String tipoPrestamo;
    
    public EquipoBasicoPrestamo(EquipoBasico eq,int cantidad,String tipo){
        equipoBasico=eq;
        this.cantidad=cantidad;
        tipoPrestamo=tipo;
    }

    /**
     * @return the equipoBasico
     */
    public EquipoBasico getEquipoBasico() {
        return equipoBasico;
    }

    /**
     * @param equipoBasico the equipoBasico to set
     */
    public void setEquipoBasico(EquipoBasico equipoBasico) {
        this.equipoBasico = equipoBasico;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    
}
