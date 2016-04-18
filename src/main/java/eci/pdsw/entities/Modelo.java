/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.entities;

/**
 *
 * @author 2107262
 */
public class Modelo {
    //Modelo, nombre, clase, vida útil en horas, valor comercial aproximado, si está asegurado o no y su fotografía
    public String nombre;
    public int vidaUtilHoras;
    public int valorComercial;
    public String seguro;
    public String foto;
    public Modelo(String nombre, int vida, int valor, String seguro, String foto){
        this.nombre=nombre;
        this.vidaUtilHoras=vida;
        this.valorComercial=valor;
        this.seguro=seguro;
        this.foto=foto;
    }
    public Modelo(String nombre, int vida, int valor, String seguro){
        this.nombre=nombre;
        this.vidaUtilHoras=vida;
        this.valorComercial=valor;
        this.seguro=seguro;
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

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }   
}
