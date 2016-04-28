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
 * @author 2107262
 */
public class Modelo {

    private String nombre;
    private String clase;
    private int vidaUtilHoras;
    private int valorComercial;
    private Boolean seguro;
    private String foto;
    private Set<Equipo> equipos;
    
    /**
     * 
     */
    public Modelo() {
        this.equipos = new LinkedHashSet<>();
    }
    
    /**
     * @param nombre
     * @param clase
     * @param vidaUtilHoras
     * @param valorComercial
     * @param seguro
     * @param foto 
     */
    public Modelo(String nombre, String clase, int vidaUtilHoras, int valorComercial, Boolean seguro,String foto) {
        this.nombre = nombre;
        this.clase = clase;
        this.vidaUtilHoras = vidaUtilHoras;
        this.valorComercial = valorComercial;
        this.seguro = seguro;
        this.foto = foto;
        this.equipos = new LinkedHashSet<>();
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
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * @return the vidaUtilHoras
     */
    public int getVidaUtilHoras() {
        return vidaUtilHoras;
    }

    /**
     * @param vidaUtilHoras the vidaUtilHoras to set
     */
    public void setVidaUtilHoras(int vidaUtilHoras) {
        this.vidaUtilHoras = vidaUtilHoras;
    }

    /**
     * @return the valorComercial
     */
    public int getValorComercial() {
        return valorComercial;
    }

    /**
     * @param valorComercial the valorComercial to set
     */
    public void setValorComercial(int valorComercial) {
        this.valorComercial = valorComercial;
    }

    /**
     * @return the seguro
     */
    public Boolean getSeguro() {
        return seguro;
    }

    /**
     * @param seguro the seguro to set
     */
    public void setSeguro(Boolean seguro) {
        this.seguro = seguro;
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
     * @return the equipos
     */
    public Set<Equipo> getEquipos() {
        return equipos;
    }

    /**
     * @param equipos the equipos to set
     */
    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    @Override
    public String toString() {
        String rep = "Modelo:["+nombre+","+clase+","+vidaUtilHoras+","+valorComercial+","+seguro+","+foto+"]\n";
        for (Equipo e:equipos){
            rep+="\t["+e+"]\n";
        }
        return rep;
    }
}
