/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.entities;

import java.util.Set;

/**
 *
 * @author 2107262
 */
public class Modelo {
    //Modelo, nombre, clase, vida útil en horas, valor comercial aproximado, si está asegurado o no y su fotografía
    public String nombre;
    public int vidaUtilHoras;
    public int valorComercial;
    private String clase;
    public Boolean seguro;
    public String foto;
    public Set<Equipo> equipos;

    public Modelo(String nombre, int vida, int valor, Boolean seguro, String foto, String clase){
        this.nombre=nombre;
        this.vidaUtilHoras=vida;
        this.valorComercial=valor;
        this.seguro=seguro;
        this.foto=foto;
        this.clase=clase;
    }
    public Modelo(String nombre, int vida, int valor, Boolean seguro, String clase){
        this.nombre=nombre;
        this.vidaUtilHoras=vida;
        this.valorComercial=valor;
        this.seguro=seguro;
        this.clase=clase;
    }
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaUtilHoras() {
        return vidaUtilHoras;
    }

    public void setVidaUtilHoras(int vidaUtilHoras) {
        this.vidaUtilHoras = vidaUtilHoras;
    }

    public int getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(int valorComercial) {
        this.valorComercial = valorComercial;
    }

    public Boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(Boolean seguro) {
        this.seguro = seguro;
    }   
    
    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
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
}
