
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.project.managedBeans;

import eci.pdsw.entities.Modelo;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;


/**
 *
 * @author 2105534
 */
@ManagedBean(name="Equipos")
@SessionScoped
public class ServicioEquiposElectronicatobean implements Serializable{
    
    private static ServicioEquiposElectronicatobean instance;
    //Pagina principal
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private String medidaLargo=demeLargo();
    private String medidaAncho=demeAncho();
    
    
    //pagina usuario
    private List<Modelo> listaModelos;
    private int id;
    private String nombre;
    private String correo;
    
            
    //pagina registrarUnEquipo
    private String modeloABuscar;
    private boolean textoLuegoConsultarModelo=false;
    private String textoSalidaModelo;
    
    
    //pagina registrarUnaDevolucion
    
    
    
    
    private String demeLargo(){
        return (screenSize.height-100)+"px";
    }
    private String demeAncho(){
        return screenSize.width+"px";
    }
    
    /**
     * 
     */
    
    public void accionBotonBuscarModelo(){
        textoLuegoConsultarModelo=true;
        System.out.println("entro");
        textoSalidaModelo="siii el modelo si existe, yei";
        //CONSULTAR A VER SI EL MODELO YA EXISTE EL MODELO ES LA VARIABLE modeloABuscar
        
    }
    /**
     * 
     */
    public String accionBotonRegistrarUnaDevolucion(){
        
        return "registrarunadevolucion";
    }
    
    /**
     * 
     */
    public String accionBotonRegistrarUnEquipo(){
        return "registrarunequipo";
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
     * Accede a la base de datos para traer el nombre de usuario
     * @return retorna el nombre de usuario que tiene el equipo en prestamo 
     */
    public String getNombreUsuario(){
        this.nombre = "            ";
        return nombre;
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
     * @return the listaConsultas
     */
    public List<Modelo> getListaModelos() {
        listaModelos=new ArrayList<Modelo>();
        listaModelos.add(new Modelo("modelo nuevo","alta",1,1,true,"sin foto"));
        return listaModelos;
    }

    /**
     * @param listaConsultas the listaConsultas to set
     */
    public void setListaModelos(List<Modelo> listaConsultas) {
        this.listaModelos = listaConsultas;
    }

    /**
     * @return the modeloABuscar
     */
    public String getModeloABuscar() {
        return modeloABuscar;
    }

    /**
     * @param modeloABuscar the modeloABuscar to set
     */
    public void setModeloABuscar(String modeloABuscar) {
        this.modeloABuscar = modeloABuscar;
    }

    /**
     * @return the textoLuegoConsultarModelo
     */
    public boolean isTextoLuegoConsultarModelo() {
        return textoLuegoConsultarModelo;
    }

    /**
     * @param textoLuegoConsultarModelo the textoLuegoConsultarModelo to set
     */
    public void setTextoLuegoConsultarModelo(boolean textoLuegoConsultarModelo) {
        this.textoLuegoConsultarModelo = textoLuegoConsultarModelo;
    }

    /**
     * @return the textoSalidaModelo
     */
    public String getTextoSalidaModelo() {
        return textoSalidaModelo;
    }

    /**
     * @param textoSalidaModelo the textoSalidaModelo to set
     */
    public void setTextoSalidaModelo(String textoSalidaModelo) {
        this.textoSalidaModelo = textoSalidaModelo;
    }
    
    
    /**
     * get instance
     */
    public static ServicioEquiposElectronicatobean getCurrentInstance(){
        if (instance==null){
            instance= new ServicioEquiposElectronicatobean();
        }
        return instance;
    
    }
    
    
    
}
