/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author 2105461
 */
public class Rol {
    
    private String rol;
    private Set<RolRol> rolesdeusuarios;
    
    public Rol() {
        this.rolesdeusuarios = new LinkedHashSet<>();
    }
    
    public Rol(String rol, Set<RolRol> rolesdeusuarios) {
        this.rol = rol;
        this.rolesdeusuarios = new LinkedHashSet<>();
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the rolesdeusuarios
     */
    public Set<RolRol> getRolesdeusuarios() {
        return rolesdeusuarios;
    }

    /**
     * @param rolesdeusuarios the rolesdeusuarios to set
     */
    public void setRolesdeusuarios(Set<RolRol> rolesdeusuarios) {
        this.rolesdeusuarios = rolesdeusuarios;
    }
    
    @Override
    public String toString() {
        String rep="Rol:["+rol+"]\n";
        for (RolRol r:rolesdeusuarios){
            rep+="\t["+r+"]\n";
        }
        return rep;
    }
}
