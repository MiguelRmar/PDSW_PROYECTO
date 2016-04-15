/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.entities;

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
    private Set<Prestamo> prestamos;
    private Set<PrestamoBasico> prestamosBasicos;
    
    public Usuario(int id, String nombre, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        prestamos=new LinkedHashSet<>();
        prestamosBasicos=new LinkedHashSet<>();
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
     * @return the correo
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
    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * @param prestamos the prestamos to set
     */
    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * @return the prestamosBasicos
     */
    public Set<PrestamoBasico> getPrestamosBasicos() {
        return prestamosBasicos;
    }

    /**
     * @param prestamosBasicos the prestamosBasicos to set
     */
    public void setPrestamosBasicos(Set<PrestamoBasico> prestamosBasicos) {
        this.prestamosBasicos = prestamosBasicos;
    }
    
    @Override
    public String toString() {
        String rep="Paciente:["+id+","+nombre+","+correo+","+contrasena+"]\n";
        for (Prestamo c:prestamos){
            rep+="\t["+c+"]\n";
        }
        for (PrestamoBasico k:prestamosBasicos){
            rep+="\t["+k+"]\n";
        }
        return rep;
    }
}
