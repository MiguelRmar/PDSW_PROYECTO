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
public class EquipoBasico{

    private String nombre;
    private int valor;
    private String foto;
    private String descripcion;
    private int cantidadInventario;
    private Set<PrestamoBasicoEquipo> prestamosBasicos;
    
    public EquipoBasico() {
        this.prestamosBasicos = new LinkedHashSet<>();
    }
    
    public EquipoBasico(String nombre, int valor, String foto, String descripcion, int cantidadInventario) {
        this.nombre = nombre;
        this.valor = valor;
        this.foto = foto;
        this.descripcion = descripcion;
        this.cantidadInventario = cantidadInventario;
        this.prestamosBasicos = new LinkedHashSet<>();
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
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cantidadInventario
     */
    public int getCantidadInventario() {
        return cantidadInventario;
    }

    /**
     * @param cantidadInventario the cantidadInventario to set
     */
    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    /**
     * @return the prestamosBasicos
     */
    public Set<PrestamoBasicoEquipo> getPrestamosBasicos() {
        return prestamosBasicos;
    }

    /**
     * @param prestamosBasicos the prestamosBasicos to set
     */
    public void setPrestamosBasicos(Set<PrestamoBasicoEquipo> prestamosBasicos) {
        this.prestamosBasicos = prestamosBasicos;
    }
    
    @Override
    public String toString() {
        String rep = "EquipoBasico:["+nombre+","+valor+","+foto+","+descripcion+","+cantidadInventario+"]\n";
        for (PrestamoBasicoEquipo pb:prestamosBasicos){
            rep+="\t["+pb+"]\n";
        }
        return rep;
    }
}

