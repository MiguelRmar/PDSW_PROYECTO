/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.entities;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 2105461
 */
public class Equipo {
    private final ArrayList<String> estados=new ArrayList<>(Arrays.asList("Activo", "Desactivo"));
    private final ArrayList<String> subEstadoActivo =new ArrayList<>(Arrays.asList( "prestamo diario", "prestamo 24 horas" , "mantenimiento",  "en almacen" , "prestamo indefinido","prestamo por semestre"));
    private final ArrayList<String> subEstadoInactivo =new ArrayList<>(Arrays.asList("dado de baja", "reparacion"));
    public int serial;
    public Modelo modelo;
    public int placa;
    public String descripcion;
    public String proveedor;
    public String estado;
    public String subEstado;
    public Equipo( int serial, Modelo modelo, int placa, String des, String prov, String estado, String sub){
        //Falta revisar que no ingresen un serial ya existente
        this.serial=serial;
        this.modelo=modelo;
        //Fallta revisar que no ingresen una placa existente
        this.placa=placa;
        this.descripcion=des;
        this.proveedor=prov;
        if (estado.equals(estados.get(0))){
            for(String s:subEstadoActivo){
                if (sub.equals(s)){
                    this.estado=estado;
                    this.subEstado=sub;
                }
            }
        }
        else if(estado.equals(estados.get(1))){
            for(String s:subEstadoInactivo){
                if (sub.equals(s)){
                    this.estado=estado;
                    this.subEstado=sub;
                }
            }
        }
        else{
        
        }
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSubEstado() {
        return subEstado;
    }

    public void setSubEstado(String subEstado) {
        this.subEstado = subEstado;
    }
}
