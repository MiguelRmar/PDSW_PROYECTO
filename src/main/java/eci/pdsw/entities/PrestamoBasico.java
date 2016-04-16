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
public class PrestamoBasico {

    private int usuario_id;
    private String equipoBasico_nombre;
    private Date fechaExpedicion;
    private Date fechaVencimiento;
    private String tipoPrestamo;
    
    public PrestamoBasico(int usuarios_id, String equipoBasico_nombre, Date fechaExpedicion, Date fechaVencimiento, String tipoPrestamo) {
        this.usuario_id = usuarios_id;
        this.equipoBasico_nombre = equipoBasico_nombre;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoPrestamo = tipoPrestamo;
    }

    /**
     * @return the usuarios_id
     */
    public int getUsuarios_id() {
        return usuario_id;
    }

    /**
     * @param usuarios_id the usuarios_id to set
     */
    public void setUsuarios_id(int usuarios_id) {
        this.usuario_id = usuarios_id;
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
    
    @Override
    public String toString() {
        return "("+usuario_id+","+equipoBasico_nombre+","+fechaExpedicion+","+fechaVencimiento+","+tipoPrestamo+")";
    }
}
