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
    public int serial;
    public String marca;
    public String modelo;
    public int placa;
    public String descripcion;
    public String proveedor;
    public String estado;
    public String subEstado;
    public Equipo( int serial, String modelo, int placa, String des, String prov, String estado, String sub, String marca){
        //Falta revisar que no ingresen un serial ya existente
        this.serial=serial;
        this.modelo=modelo;
        //Falta revisar que no ingresen una placa existente
        this.placa=placa;
        this.descripcion=des;
        this.proveedor=prov;
        this.marca=marca;
        //Falta que hacer si la información es suminstrada incorrectamente de estado y subestado
        this.estado=estado;
        this.subEstado=sub;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
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
