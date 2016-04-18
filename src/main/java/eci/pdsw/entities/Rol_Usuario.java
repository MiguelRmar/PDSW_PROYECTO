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
    public Rol rol;
    public Usuario usuario;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Rol_Usuario(Rol rol, Usuario usuario) {
        this.rol = rol;
        this.usuario = usuario;
    }
    
}
