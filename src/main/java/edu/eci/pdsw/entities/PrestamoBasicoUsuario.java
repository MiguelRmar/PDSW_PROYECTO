/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

import java.sql.Date;

/**
 *
 * @author 2105461
 */
public class PrestamoBasicoUsuario {

    private String equipoBasico_nombre;
    private Date fechaExpedicion;
    private Date fechaVencimiento;
    private String tipoPrestamo;
    private int cantidadPrestada;
    
    /**
     * 
     */
    public PrestamoBasicoUsuario() {
    }

    /**
     * @param equipoBasico_nombre
     * @param fechaExpedicion
     * @param fechaVencimiento
     * @param tipoPrestamo
     * @param cantidadPrestada 
     */
    public PrestamoBasicoUsuario(String equipoBasico_nombre, Date fechaExpedicion, Date fechaVencimiento, String tipoPrestamo, int cantidadPrestada) {
        this.equipoBasico_nombre = equipoBasico_nombre;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoPrestamo = tipoPrestamo;
        this.cantidadPrestada = cantidadPrestada;
    }

    /**
     * @return the equipoBasico_nombre
     */
    public String getEquipoBasico_nombre() {
        return equipoBasico_nombre;
    }

    /**
     * @param equipoBasico_nombre the equipoBasico_nombre to set
     */
    public void setEquipoBasico_nombre(String equipoBasico_nombre) {
        this.equipoBasico_nombre = equipoBasico_nombre;
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

    /**
     * @return the cantidadPrestada
     */
    public int getCantidadPrestada() {
        return cantidadPrestada;
    }

    /**
     * @param cantidadPrestada the cantidadPrestada to set
     */
    public void setCantidadPrestada(int cantidadPrestada) {
        this.cantidadPrestada = cantidadPrestada;
    }
    
    @Override
    public String toString() {
        return "("+equipoBasico_nombre+","+fechaExpedicion+","+fechaVencimiento+","+tipoPrestamo+","+cantidadPrestada+")";
    }
}
