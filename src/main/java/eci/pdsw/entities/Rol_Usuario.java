/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.entities;

/**
 *
 * @author 2105461
 */
public class Rol_Usuario {

    private int usuario_id;
    private String rol_r;

    public Rol_Usuario(int usuario_id, String rol_r) {
        this.usuario_id = usuario_id;
        this.rol_r = rol_r;
    }

    public Rol_Usuario() {
    }

    /**
     * @return the usuario_id
     */
    public int getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    /**
     * @return the rol_r
     */
    public String getRol_r() {
        return rol_r;
    }

    /**
     * @param rol_r the rol_r to set
     */
    public void setRol_r(String rol_r) {
        this.rol_r = rol_r;
    }
    
    @Override
    public String toString() {
        return "("+usuario_id+","+rol_r+")";
    } 
}

