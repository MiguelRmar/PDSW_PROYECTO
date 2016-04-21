
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2105534
 */
@ManagedBean(name="Equipos")
@SessionScoped
public class ServicioEquiposElectronicatobean implements Serializable{
    
    @ManagedProperty(value = "#{loginBean}")    
    private ShiroLoginBean loginBean;

    //Pagina principal
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private String medidaLargo=demeLargo();
    private String medidaAncho=demeAncho();
    
    
    //pagina usuario
    private List<Modelo> listaModelos;
    private String id;
    private String nombre;
    private String correo;
    
            
    //pagina registrarUnEquipo
    private String nombreDeModelo;
    private boolean elModeloYaExiste=false;
    private String textoSalidaModelo;
    private boolean yaBusqueModelo=false;
    private boolean elModeloNoExiste=false;
    //datos para un modelo nuevo
    private String claseModelo;
    private int vidaUtilEnHorasModelo;
    private int valorComercialModelo;
    private boolean estaAseguradoModelo;
    private String fotoModelo;
            
    
    
    
    
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
        //CONSULTAR A VER SI EL MODELO YA EXISTE EL NOMBRE DEL MODELO ES LA VARIABLE modeloABuscar
        if(false){//mira si el modelo existe
            setElModeloYaExiste(true);
            setYaBusqueModelo(true);
            setElModeloNoExiste(false);
            textoSalidaModelo="siii el modelo si existe, yei";
        }
        else{ // el modelo no existe
            setElModeloYaExiste(false);
            setYaBusqueModelo(true);
            setElModeloNoExiste(true);
            textoSalidaModelo="el modelo no existe,:c";
        }
        
        
        
        
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
    public String getId() {
        id=getLoginBean().getUsername();
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        id=getLoginBean().getUsername();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return "Carlos Andres Sanchez Venegas";
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
        return "carlos.sanchez-v@mail.escuelaing.edu.co";
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
     * @return the loginBean
     */
    public ShiroLoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(ShiroLoginBean loginBean) {
        this.loginBean = loginBean;
    }

    /**
     * @return the elModeloYaExiste
     */
    public boolean isElModeloYaExiste() {
        return elModeloYaExiste;
    }

    /**
     * @param elModeloYaExiste the elModeloYaExiste to set
     */
    public void setElModeloYaExiste(boolean elModeloYaExiste) {
        this.elModeloYaExiste = elModeloYaExiste;
    }

    /**
     * @return the yaBusqueModelo
     */
    public boolean isYaBusqueModelo() {
        return yaBusqueModelo;
    }

    /**
     * @param yaBusqueModelo the yaBusqueModelo to set
     */
    public void setYaBusqueModelo(boolean yaBusqueModelo) {
        this.yaBusqueModelo = yaBusqueModelo;
    }

    /**
     * @return the elModeloNoExiste
     */
    public boolean isElModeloNoExiste() {
        return elModeloNoExiste;
    }

    /**
     * @param elModeloNoExiste the elModeloNoExiste to set
     */
    public void setElModeloNoExiste(boolean elModeloNoExiste) {
        this.elModeloNoExiste = elModeloNoExiste;
    }

    /**
     * @return the nombreDeModelo
     */
    public String getNombreDeModelo() {
        return nombreDeModelo;
    }

    /**
     * @param nombreDeModelo the nombreDeModelo to set
     */
    public void setNombreDeModelo(String nombreDeModelo) {
        this.nombreDeModelo = nombreDeModelo;
    }

 
    /**
     * @return the claseModelo
     */
    public String getClaseModelo() {
        return claseModelo;
    }

    /**
     * @param claseModelo the claseModelo to set
     */
    public void setClaseModelo(String claseModelo) {
        this.claseModelo = claseModelo;
    }

    /**
     * @return the vidaUtilEnHorasModelo
     */
    public int getVidaUtilEnHorasModelo() {
        return vidaUtilEnHorasModelo;
    }

    /**
     * @param vidaUtilEnHorasModelo the vidaUtilEnHorasModelo to set
     */
    public void setVidaUtilEnHorasModelo(int vidaUtilEnHorasModelo) {
        this.vidaUtilEnHorasModelo = vidaUtilEnHorasModelo;
    }

    /**
     * @return the valorComercialModelo
     */
    public int getValorComercialModelo() {
        return valorComercialModelo;
    }

    /**
     * @param valorComercialModelo the valorComercialModelo to set
     */
    public void setValorComercialModelo(int valorComercialModelo) {
        this.valorComercialModelo = valorComercialModelo;
    }

    /**
     * @return the estaAseguradoModelo
     */
    public boolean isEstaAseguradoModelo() {
        return estaAseguradoModelo;
    }

    /**
     * @param estaAseguradoModelo the estaAseguradoModelo to set
     */
    public void setEstaAseguradoModelo(boolean estaAseguradoModelo) {
        this.estaAseguradoModelo = estaAseguradoModelo;
    }

    /**
     * @return the fotoModelo
     */
    public String getFotoModelo() {
        return fotoModelo;
    }

    /**
     * @param fotoModelo the fotoModelo to set
     */
    public void setFotoModelo(String fotoModelo) {
        this.fotoModelo = fotoModelo;
    }
    
}
