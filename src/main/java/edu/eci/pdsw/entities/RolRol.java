/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

/**
 *
 * @author Jhordy
 */
public class RolRol {
    
    private int usuario_id;
    
    /**
     * 
     */
    public RolRol() {
    }

    /**
     * @param usuario_id 
     */
    public RolRol(int usuario_id) {
        this.usuario_id = usuario_id;
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
    
    @Override
    public String toString() {
        return "("+usuario_id+")";
    }
}
