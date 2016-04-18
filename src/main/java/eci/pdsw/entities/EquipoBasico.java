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
public class EquipoBasico {
    public String nombre;
    public int cantidadInventario;
    public int valor;
    public String descripcion;
    public String foto;
    public EquipoBasico(String nombre, int cantidad, int valor, String foto, String descripcion){
        this.nombre=nombre;
        this.cantidadInventario=cantidad;
        this.valor=valor;
        this.foto=foto;
        this.descripcion=descripcion;
    }
    public EquipoBasico(String nombre, int cantidad, int valor, String descripcion){
        this.nombre=nombre;
        this.cantidadInventario=cantidad;
        this.valor=valor;
        this.descripcion=descripcion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}
