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
public class Usuario {
    
    private int id;
    private String nombre;
    private String correo;
    private String contrasena;
    private Set<PrestamoUsuario> prestamos;
    private Set<PrestamoBasicoUsuario> prestamosBasicos;
    private Set<RolUsuario> roles;
    
    /**
     * 
     */
    public Usuario(){
        prestamos=new LinkedHashSet<>();
        prestamosBasicos=new LinkedHashSet<>();
        roles=new LinkedHashSet<>();
    }
    
    /**
     * @param id
     * @param nombre
     * @param correo
     * @param contrasena 
     */
    public Usuario(int id, String nombre, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.prestamos=new LinkedHashSet<>();
        this.prestamosBasicos=new LinkedHashSet<>();
        this.roles=new LinkedHashSet<>();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the corrulta() {eo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the prestamos
     */
    public Set<PrestamoUsuario> getPrestamos() {
        return prestamos;
    }

    /**
     * @param prestamos the prestamos to set
     */
    public void setPrestamos(Set<PrestamoUsuario> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * @return the prestamosBasicos
     */
    public Set<PrestamoBasicoUsuario> getPrestamosBasicos() {
        return prestamosBasicos;
    }

    /**
     * @return the roles
     */
    public Set<RolUsuario> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<RolUsuario> roles) {
        this.roles = roles;
    }
    /**
     * @param prestamosBasicos the prestamosBasicos to set
     */
    public void setPrestamosBasicos(Set<PrestamoBasicoUsuario> prestamosBasicos) {
        this.prestamosBasicos = prestamosBasicos;
    }
    
    @Override
    public String toString() {
        String rep="Paciente:["+id+","+nombre+","+correo+","+contrasena+"]\n";
        for (PrestamoUsuario c:prestamos){
            rep+="\t["+c+"]\n";
        }
        for (PrestamoBasicoUsuario k:prestamosBasicos){
            rep+="\t["+k+"]\n";
        }
        for (RolUsuario r:roles){
            rep+="\t["+r+"]\n";
        }
        return rep;
    }
}
