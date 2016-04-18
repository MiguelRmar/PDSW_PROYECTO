
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.project.managedBeans;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2105534
 */
@ManagedBean(name="Equipos")
@SessionScoped
public class ServicioEquiposElectronicatobean implements Serializable{
    //Pagina principal
    private int identificador;
    private String clave;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private String medidaLargo=demeLargo();
    private String medidaAncho=demeAncho();
    
    
    //pagina usuario
    private int id;
    private String nombre;
    private String correo;
    //botonesDisponibles        
    private boolean botonRegistrarEquipoEnInventario=false;
    private boolean botonRegistrarUnaDevolucion=false;
            
            
            
    private String demeLargo(){
        return (screenSize.height-100)+"px";
    }
    private String demeAncho(){
        return screenSize.width+"px";
    }
    
    
    /**
     * Accion boton login en la pagina principal
     * @return el string de la pagina a redireccionar
     */
    public String accionBotonLogin(){
        boolean loEncontro=true;
        String ans="";
        //intenta buscar en base de datos, si no lo encuentra entonces LoEncontro=false
        if(loEncontro){
            //redirecciona a la pagina nueva
            System.out.println(identificador);
            System.out.println(clave);
            ans="usuario";
            
            //prueba
            id=2105534;
            nombre="Carlos Andres Sanchez";
            correo="Carlos.sanchez-v@mail.escuelaing.edu.co";
            botonRegistrarEquipoEnInventario=true;
            botonRegistrarUnaDevolucion=true;
            //pone los atributos de la pagina laboratorista con los datos del usuario nuevo
        }
        else{
            //no lo encontro, y se redirecciona a la misma pagina y lanza algun tipo de error
        }
        
        return ans;
    }
    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the medidaLargo
     */
    public String getMedidaLargo() {
        return medidaLargo;
    }

    /**
     * @param medidaLargo the medidaLargo to set
     */
    public void setMedidaLargo(String medidaLargo) {
        this.medidaLargo = medidaLargo;
    }

    /**
     * @return the medidaAncho
     */
    public String getMedidaAncho() {
        return medidaAncho;
    }

    /**
     * @param medidaAncho the medidaAncho to set
     */
    public void setMedidaAncho(String medidaAncho) {
        this.medidaAncho = medidaAncho;
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
     * @return the botonRegistrarEquipoEnInventario
     */
    public boolean isBotonRegistrarEquipoEnInventario() {
        return botonRegistrarEquipoEnInventario;
    }

    /**
     * @param botonRegistrarEquipoEnInventario the botonRegistrarEquipoEnInventario to set
     */
    public void setBotonRegistrarEquipoEnInventario(boolean botonRegistrarEquipoEnInventario) {
        this.botonRegistrarEquipoEnInventario = botonRegistrarEquipoEnInventario;
    }

    /**
     * @return the botonRegistrarUnaDevolucion
     */
    public boolean isBotonRegistrarUnaDevolucion() {
        return botonRegistrarUnaDevolucion;
    }

    /**
     * @param botonRegistrarUnaDevolucion the botonRegistrarUnaDevolucion to set
     */
    public void setBotonRegistrarUnaDevolucion(boolean botonRegistrarUnaDevolucion) {
        this.botonRegistrarUnaDevolucion = botonRegistrarUnaDevolucion;
    }
}
