/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

/**
 *
 * @author 2105461
 */
public class RolUsuario {
    
    private String rol_r;

    public RolUsuario() {
    }
    
    public RolUsuario(String rol_r) {
        this.rol_r = rol_r;
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
        return "("+rol_r+")";
    }
}

