/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.entities;

import java.sql.Date;

/**
 *
 * @author 2105461
 */
public class PrestamoUsuario {

    private int equipo_serial;
    private Date fechaExpedicion;
    private Date fechaVencimiento;
    private String tipoPrestamo;
    
    public PrestamoUsuario(){ 
    }
    
    public PrestamoUsuario(int equipo_serial, Date fechaExpedicion, Date fechaVencimiento, String tipoPrestamo) {
        this.equipo_serial = equipo_serial;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoPrestamo = tipoPrestamo;
    }
    
    /**
     * @return the equipo_serial
     */
    public int getEquipo_serial() {
        return equipo_serial;
    }

    /**
     * @param equipo_serial the equipo_serial to set
     */
    public void setEquipo_serial(int equipo_serial) {
        this.equipo_serial = equipo_serial;
    }

    /**
     * @return the fechaExpedicion
     */
    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * @param fechaExpedicion the fechaExpedicion to set
     */
    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * @return the fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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
    
    @Override
    public String toString() {
        return "("+equipo_serial+","+fechaExpedicion+","+fechaVencimiento+","+tipoPrestamo+")";
    }  
}
