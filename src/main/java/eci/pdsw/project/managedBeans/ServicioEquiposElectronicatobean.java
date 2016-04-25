
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.project.managedBeans;

import eci.pdsw.entities.Modelo;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;


/**
 *
 * @author 2105534
 */
@ManagedBean(name="Equipos")
@SessionScoped
public class ServicioEquiposElectronicatobean implements Serializable{
    
    @ManagedProperty(value = "#{loginBean}")    
    private ShiroLoginBean loginBean;

        
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
    private UploadedFile fotoModelo;
    //datos para equipo nuevo
    private int serialEquipo;
    private String nombreEquipo;
    private int placaEquipo;
    private String marcaEquipo;
    private String descripcionEquipo;
    private String estadoEquipo;
    private String subEstadoEquipo;
    private String proveedorEquipo;
            

    
    
    

    
    public void limpiarPaginaRegistrarUnEquipo(){
        nombreDeModelo=null;
        elModeloYaExiste=false;
        textoSalidaModelo=null;
        yaBusqueModelo=false;
        elModeloNoExiste=false;
        //datos para un modelo nuevo
        claseModelo=null;
        vidaUtilEnHorasModelo=0;
        valorComercialModelo=0;
        estaAseguradoModelo=false;
        fotoModelo=null;
        //datos para equipo nuevo
        serialEquipo=0;
        nombreEquipo=null;
        placaEquipo=0;
        marcaEquipo=null;
        descripcionEquipo=null;
        estadoEquipo=null;
        subEstadoEquipo=null;
        proveedorEquipo=null;
    }
    public void mensajeCreacionEquipoExitoso(){
        
        //mira si se hizo el registro bien
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Successful","Se ha registrado el equipo con exito"));
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('crearEquipo').hide();");
    }
    
    public void mensajeCreacionModeloExitoso(){
        
       //mira si se hizo bien el registro
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Successful","Se ha registrado el modelo con exito"));
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('crearModelo').hide();PF('crearEquipoLuegoDeModelo').show();");
        
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
        listaModelos.add(new Modelo("modelo nuevo","alta",1,1,true,null));
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
    public UploadedFile getFotoModelo() {
        return fotoModelo;
    }

    /**
     * @param fotoModelo the fotoModelo to set
     */
    public void setFotoModelo(UploadedFile fotoModelo) {
        this.fotoModelo = fotoModelo;
        
    }

    /**
     * @return the serialEquipo
     */
    public int getSerialEquipo() {
        return serialEquipo;
    }

    /**
     * @param serialEquipo the serialEquipo to set
     */
    public void setSerialEquipo(int serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    /**
     * @return the nombreEquipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * @param nombreEquipo the nombreEquipo to set
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * @return the placaEquipo
     */
    public int getPlacaEquipo() {
        return placaEquipo;
    }

    /**
     * @param placaEquipo the placaEquipo to set
     */
    public void setPlacaEquipo(int placaEquipo) {
        this.placaEquipo = placaEquipo;
    }

    /**
     * @return the marcaEquipo
     */
    public String getMarcaEquipo() {
        return marcaEquipo;
    }

    /**
     * @param marcaEquipo the marcaEquipo to set
     */
    public void setMarcaEquipo(String marcaEquipo) {
        this.marcaEquipo = marcaEquipo;
    }

    /**
     * @return the descripcionEquipo
     */
    public String getDescripcionEquipo() {
        return descripcionEquipo;
    }

    /**
     * @param descripcionEquipo the descripcionEquipo to set
     */
    public void setDescripcionEquipo(String descripcionEquipo) {
        this.descripcionEquipo = descripcionEquipo;
    }

    /**
     * @return the estadoEquipo
     */
    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    /**
     * @param estadoEquipo the estadoEquipo to set
     */
    public void setEstadoEquipo(String estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    /**
     * @return the subEstadoEquipo
     */
    public String getSubEstadoEquipo() {
        return subEstadoEquipo;
    }

    /**
     * @param subEstadoEquipo the subEstadoEquipo to set
     */
    public void setSubEstadoEquipo(String subEstadoEquipo) {
        this.subEstadoEquipo = subEstadoEquipo;
    }

    /**
     * @return the proveedorEquipo
     */
    public String getProveedorEquipo() {
        return proveedorEquipo;
    }

    /**
     * @param proveedorEquipo the proveedorEquipo to set
     */
    public void setProveedorEquipo(String proveedorEquipo) {
        this.proveedorEquipo = proveedorEquipo;
    }
    
}
