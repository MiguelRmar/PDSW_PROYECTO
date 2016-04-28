
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.project.managedBeans;

import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.Modelo;
import edu.eci.pdsw.entities.PrestamoEquipo;
import edu.eci.pdsw.entities.PrestamoUsuario;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.services.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
//busqueda
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import edu.eci.pdsw.entities.EquipoBasico;



/**
 *
 * @author 2105534
 */
@ManagedBean(name="Equipos")
@SessionScoped
public class ServicioEquiposElectronicatobean implements Serializable{
    
    public ServicioEquiposElectronicatobean() {        
        //inical lista
        listaModelos=new ArrayList<>();
        Set<Modelo> conjunto=services.loadModelos();
        Modelo[] listaModelo=new Modelo[conjunto.size()];
        conjunto.toArray(listaModelo);
        listaModelos=Arrays.asList(listaModelo);
        //filtrada lista
        filteredListaModelos=new ArrayList<>();
        filteredListaModelos=Arrays.asList(listaModelo);
        //estado y subestado de equipo
        estados  = new HashMap<>();
        estados.put("Desactivo", "Desactivo");
        estados.put("Activo", "Activo");
        Map<String,String> map;
        map = new HashMap<>();
        map.put("Préstamo diario", "Préstamo diario");
        map.put("Préstamo 24 horas", "Préstamo 24 horas");
        map.put("Préstamo por semestre", "Préstamo por semestre");
        map.put("Préstamo indefinido","Préstamo indefinido");
        map.put("Mantenimiento","Mantenimiento");
        map.put("En almacén","En almacén");
        data.put("Activo", map);
        map = new HashMap<>();
        map.put("Dado de baja", "Dado de baja");
        map.put("En reparación","En reparación");
        data.put("Desactivo", map);   
    }
    
    @ManagedProperty(value = "#{loginBean}")    
    private ShiroLoginBean loginBean;
    //pagina usuario
    private List<Modelo> listaModelos;
    private List<Modelo> filteredListaModelos = new ArrayList<>();
    //
    private String id;
    private String nombre;
    private String correo;
    //pagina registrarUnEquipo
    private Services services=Services.getInstance("applicationconfig.properties");
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
    private Modelo modeloSeleccionado;
    //datos para equipo nuevo
    private int serialEquipo;
    private String nombreEquipo;
    private int placaEquipo;
    private String marcaEquipo;
    private String descripcionEquipo;
    private String estadoEquipo;
    private String subEstadoEquipo;
    private String proveedorEquipo;
    private Map<String,String> estados;
    private Map<String,String> subestados;
    private final Map<String,Map<String,String>> data = new HashMap<>();
    //datos para una devolucion de un equipo normal
    private boolean yaBusqueEquipoADevolver=false;
    private boolean serialDevolucionEncontrado=false;
    private boolean serialDevolucionNoEncontrado=true;
    private String textoSalidaEquipoADevolver;
    private int serialADevolver;
    private Usuario usuarioDevolucion;
    //datos para una devolucion de un equipo basico
    private int condigoEstudianteBasicos;
    
    private int cantidadDevuelta;
    //datos para equipo basico
    private List<Modelo> listaEquipoBasico = new ArrayList<>();
    private List<Modelo> filteredListaEquipoBasico = new ArrayList<>();
    private String nombreEquipoBasico;
    private int valorEquipoBasico;
    private String fotoEquipoBasico;
    private String descripcionEquipoBasico;
    private int cantidadEquipoBasico;
    private EquipoBasico equipoBasicoSeleccionado;
    
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
    public void onEstadoChange() {
        if(estadoEquipo != null && !estadoEquipo.equals(""))
            setSubestados(data.get(estadoEquipo));
        else
            setSubestados(new HashMap<String, String>());
    }
    
    public String demeIcono(){
        if(modeloSeleccionado.getSeguro()){
            return "check";
        }
        else{
            return  "fail";
        }
    }
    
    public void filterList(){
        ArrayList<String> ListaNombres = new ArrayList<String>();
        for (int i = 0; i<listaModelos.size() ; i++) {
            ListaNombres.add(listaModelos.get(i).getNombre());
        } 
        List<String> filteredListNames;
        filteredListNames = Lists.newArrayList(Collections2.filter(ListaNombres,Predicates.containsPattern(nombreDeModelo)));
        List<Modelo> filteredList = new ArrayList<>();
        for (int i = 0; i < listaModelos.size(); i++) {
            if (filteredListNames.contains(listaModelos.get(i).getNombre())){
                filteredList.add(listaModelos.get(i));
            }
        }
    setFilteredListaModelos(filteredList);
    }
    public void filterListEquipoBasico(){
        ArrayList<String> ListaNombres = new ArrayList<String>();
        for (int i = 0; i<listaEquipoBasico.size() ; i++) {
            ListaNombres.add(listaEquipoBasico.get(i).getNombre());
        } 
        List<String> filteredListNames;
        filteredListNames = Lists.newArrayList(Collections2.filter(ListaNombres,Predicates.containsPattern(nombreEquipoBasico)));
        List<Modelo> filteredList = new ArrayList<>();
        for (int i = 0; i < listaEquipoBasico.size(); i++) {
            if (filteredListNames.contains(listaEquipoBasico.get(i).getNombre())){
                filteredList.add(listaEquipoBasico.get(i));
            }
        }
        setFilteredListaEquipoBasico(filteredList);
    }
    
    
    public void mensajeCreacionEquipoExitoso(){
        try{
        Equipo equipoNuevo=new Equipo(serialEquipo, nombreEquipo, placaEquipo,marcaEquipo, descripcionEquipo, estadoEquipo, subEstadoEquipo,proveedorEquipo);
        services.registroEquipoNuevo(equipoNuevo,nombreDeModelo);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Successful","Se ha registrado el equipo con exito"));
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('crearEquipo').hide();");
        }
        catch(Exception e){
            System.out.println(e.getCause());
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Error","No se ha registrado el Equipo ,sucedio algo inesperado"));
    
        }
        
    }
    
    public void mensajeCreacionModeloExitoso(){
        
       //mira si se hizo bien el registro
       try{
        Modelo modeloNuevo=new Modelo(nombreDeModelo, claseModelo, vidaUtilEnHorasModelo, valorComercialModelo, estaAseguradoModelo, fotoModelo);
        services.registroModeloNuevo(modeloNuevo);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Successful","Se ha registrado el modelo con exito"));
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('crearModelo').hide();");
       }catch(Exception e){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Error","No se ha registrado el modelo ,sucedio algo inesperado"));
       }
    }
    public void accionBuscarDevolucion(){
        Services se = Services.getInstance("applicationconfig.properties");
        Set<Usuario> usuarios = se.loadUsuarios();
        for(Usuario u:usuarios){
            Set<PrestamoUsuario> prestamos = u.getPrestamos();
            for (PrestamoUsuario p: prestamos){
                if(p.getEquipo_serial()==serialADevolver && p.getFechaVencimiento()==null){
                    setUsuarioDevolucion(u);      
                    setSerialDevolucionEncontrado(true);
                    setSerialDevolucionNoEncontrado(false);
                    textoSalidaEquipoADevolver="El usuario con el prestamo del equipo fue encontrado exitosamente";
                }
            }
        }
        if (getUsuarioDevolucion()==null){
            setTextoSalidaEquipoADevolver("No fue encontrado un usuario con el presente equipo en prestamo");
        }
        setYaBusqueEquipoADevolver(true);
    }
    public void accionRealizarDevolucion(){
        PrestamoUsuario prestamoActual = null; 
        //falta probar que la siguiente linea retorne la hora actual
        Services se = Services.getInstance("applicationconfig.properties");
        java.sql.Date horaActual = new java.sql.Date(Calendar.getInstance().getTime().getTime());     
        Equipo equipoActual = se.loadEquipoBySerial(serialADevolver);
        Set<Usuario> usuarios = se.loadUsuarios();
        Set<PrestamoUsuario> prestamos = usuarioDevolucion.getPrestamos();
            for (PrestamoUsuario p: prestamos){
                if(p.getEquipo_serial()==serialADevolver && p.getFechaExpedicion()==null){
                    p.setFechaVencimiento(horaActual);
            }
        }  
        Set<PrestamoEquipo> prestamose = equipoActual.getPrestamos();
        for (PrestamoEquipo p:prestamose){
            if(p.getUsuario_id() == usuarioDevolucion.getId()){
                p.setFechaExpedicion(horaActual);
            }
        
        }
        
    }
    public void accionRealizarDevolucionBasica(){
    
    }
    
    
    public void accionBotoncrearEquipo(String modelo){
        nombreDeModelo=modelo;
    }
    
    public void accionBotonBuscarModelo(){
        //CONSULTAR A VER SI EL MODELO YA EXISTE EL NOMBRE DEL MODELO ES LA VARIABLE modeloABuscar
        Modelo modelo;
        modelo=services.loadModeloByName(nombreDeModelo);
        if(modelo!=null){//mira si el modelo existe
            setElModeloYaExiste(true);
            setYaBusqueModelo(true);
            setElModeloNoExiste(false);
            textoSalidaModelo="El modelo ya existe, cree el equipo de este modelo";
        }
        else{ // el modelo no existe
            setElModeloYaExiste(false);
            setYaBusqueModelo(true);
            setElModeloNoExiste(true);
            textoSalidaModelo="El modelo no existe, Registre el modelo";
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
        if(listaModelos.size()!=services.loadModelos().size()){
            listaModelos=new ArrayList<>();
           Set<Modelo> conjunto=services.loadModelos();
           Modelo[] listaModelo=new Modelo[conjunto.size()];
           conjunto.toArray(listaModelo);
           listaModelos=Arrays.asList(listaModelo);
           setFilteredListaModelos(listaModelos);
        }
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

    /**
     * @return the yaBusqueEquipoADevolver
     */
    public boolean isYaBusqueEquipoADevolver() {
        return yaBusqueEquipoADevolver;
    }

    /**
     * @param yaBusqueEquipoADevolver the yaBusqueEquipoADevolver to set
     */
    public void setYaBusqueEquipoADevolver(boolean yaBusqueEquipoADevolver) {
        this.yaBusqueEquipoADevolver = yaBusqueEquipoADevolver;
    }

    /**
     * @return the serialDevolucionEncontrado
     */
    public boolean isSerialDevolucionEncontrado() {
        return serialDevolucionEncontrado;
    }

    /**
     * @param serialDevolucionEncontrado the serialDevolucionEncontrado to set
     */
    public void setSerialDevolucionEncontrado(boolean serialDevolucionEncontrado) {
        this.serialDevolucionEncontrado = serialDevolucionEncontrado;
    }

    /**
     * @return the serialDevolucionNoEncontrado
     */
    public boolean isSerialDevolucionNoEncontrado() {
        return serialDevolucionNoEncontrado;
    }

    /**
     * @param serialDevolucionNoEncontrado the serialDevolucionNoEncontrado to set
     */
    public void setSerialDevolucionNoEncontrado(boolean serialDevolucionNoEncontrado) {
        this.serialDevolucionNoEncontrado = serialDevolucionNoEncontrado;
    }

    /**
     * @return the textoSalidaEquipoADevolver
     */
    public String getTextoSalidaEquipoADevolver() {
        return textoSalidaEquipoADevolver;
    }

    /**
     * @param textoSalidaEquipoADevolver the textoSalidaEquipoADevolver to set
     */
    public void setTextoSalidaEquipoADevolver(String textoSalidaEquipoADevolver) {
        this.textoSalidaEquipoADevolver = textoSalidaEquipoADevolver;
    }

    /**
     * @return the serialADevolver
     */
    public int getSerialADevolver() {
        return serialADevolver;
    }

    /**
     * @param serialADevolver the serialADevolver to set
     */
    public void setSerialADevolver(int serialADevolver) {
        this.serialADevolver = serialADevolver;
    }

    /**
     * @return the usuarioDevolucion
     */
    public Usuario getUsuarioDevolucion() {
        return usuarioDevolucion;
    }

    /**
     * @param usuarioDevolucion the usuarioDevolucion to set
     */
    public void setUsuarioDevolucion(Usuario usuarioDevolucion) {
        this.usuarioDevolucion = usuarioDevolucion;
    }

    /**
     * @return the condigoEstudianteBasicos
     */
    public int getCondigoEstudianteBasicos() {
        return condigoEstudianteBasicos;
    }

    /**
     * @param condigoEstudianteBasicos the condigoEstudianteBasicos to set
     */
    public void setCondigoEstudianteBasicos(int condigoEstudianteBasicos) {
        this.condigoEstudianteBasicos = condigoEstudianteBasicos;
    }



    /**
     * @return the cantidadDevuelta
     */
    public int getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    /**
     * @param cantidadDevuelta the cantidadDevuelta to set
     */
    public void setCantidadDevuelta(int cantidadDevuelta) {
        this.cantidadDevuelta = cantidadDevuelta;
    }

    /**
     * @return the estados
     */
    public Map<String,String> getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(Map<String,String> estados) {
        this.estados = estados;
    }

    /**
     * @return the subestados
     */
    public Map<String,String> getSubestados() {
        return subestados;
    }

    /**
     * @param subestados the subestados to set
     */
    public void setSubestados(Map<String,String> subestados) {
        this.subestados = subestados;
    }

    /**
     * @return the modeloSeleccionado
     */
    public Modelo getModeloSeleccionado() {
        
        return modeloSeleccionado;
    }

    /**
     * @param modeloSeleccionado the modeloSeleccionado to set
     */
    public void setModeloSeleccionado(Modelo modeloSeleccionado) {
        
        this.modeloSeleccionado = modeloSeleccionado;
    }

    /**
     * @return the filteredListaModelos
     */
    public List<Modelo> getFilteredListaModelos() {
       if(listaModelos!=null && listaModelos.size()!=services.loadModelos().size()){
            listaModelos=new ArrayList<>();
           Set<Modelo> conjunto=services.loadModelos();
           Modelo[] listaModelo=new Modelo[conjunto.size()];
           conjunto.toArray(listaModelo);
           listaModelos=Arrays.asList(listaModelo);
           setFilteredListaModelos(listaModelos);
           filterList();
        }
        
        return filteredListaModelos;
    }

    /**
     * @param filteredListaModelos the filteredListaModelos to set
     */
    public void setFilteredListaModelos(List<Modelo> filteredListaModelos) {
        this.filteredListaModelos = filteredListaModelos;
    }

    /**
     * @return the nombreEquipoBasico
     */
    public String getNombreEquipoBasico() {
        return nombreEquipoBasico;
    }

    /**
     * @param nombreEquipoBasico the nombreEquipoBasico to set
     */
    public void setNombreEquipoBasico(String nombreEquipoBasico) {
        this.nombreEquipoBasico = nombreEquipoBasico;
    }

    /**
     * @return the valorEquipoBasico
     */
    public int getValorEquipoBasico() {
        return valorEquipoBasico;
    }

    /**
     * @param valorEquipoBasico the valorEquipoBasico to set
     */
    public void setValorEquipoBasico(int valorEquipoBasico) {
        this.valorEquipoBasico = valorEquipoBasico;
    }

    /**
     * @return the fotoEquipoBasico
     */
    public String getFotoEquipoBasico() {
        return fotoEquipoBasico;
    }

    /**
     * @param fotoEquipoBasico the fotoEquipoBasico to set
     */
    public void setFotoEquipoBasico(String fotoEquipoBasico) {
        this.fotoEquipoBasico = fotoEquipoBasico;
    }

    /**
     * @return the descripcionEquipoBasico
     */
    public String getDescripcionEquipoBasico() {
        return descripcionEquipoBasico;
    }

    /**
     * @param descripcionEquipoBasico the descripcionEquipoBasico to set
     */
    public void setDescripcionEquipoBasico(String descripcionEquipoBasico) {
        this.descripcionEquipoBasico = descripcionEquipoBasico;
    }

    /**
     * @return the cantidadEquipoBasico
     */
    public int getCantidadEquipoBasico() {
        return cantidadEquipoBasico;
    }

    /**
     * @param cantidadEquipoBasico the cantidadEquipoBasico to set
     */
    public void setCantidadEquipoBasico(int cantidadEquipoBasico) {
        this.cantidadEquipoBasico = cantidadEquipoBasico;
    }

    /**
     * @return the listaEquipoBasico
     */
    public List<Modelo> getListaEquipoBasico() {
        return listaEquipoBasico;
    }

    /**
     * @param listaEquipoBasico the listaEquipoBasico to set
     */
    public void setListaEquipoBasico(List<Modelo> listaEquipoBasico) {
        this.listaEquipoBasico = listaEquipoBasico;
    }

    /**
     * @return the filteredListaEquipoBasico
     */
    public List<Modelo> getFilteredListaEquipoBasico() {
        filteredListaEquipoBasico= new ArrayList();
        //falta metodo de services .loadEquiposBasicos
        /**
        if(listaEquipoBasico!=null && listaEquipoBasico.size()!=services.loadModelos().size()){
            listaModelos=new ArrayList<>();
           Set<Modelo> conjunto=services.loadModelos();
           Modelo[] listaModelo=new Modelo[conjunto.size()];
           conjunto.toArray(listaModelo);
           listaModelos=Arrays.asList(listaModelo);
           setFilteredListaModelos(listaModelos);
           filterList();
        }**/
        return filteredListaEquipoBasico;
    }

    /**
     * @param filteredListaEquipoBasico the filteredListaEquipoBasico to set
     */
    public void setFilteredListaEquipoBasico(List<Modelo> filteredListaEquipoBasico) {
        this.filteredListaEquipoBasico = filteredListaEquipoBasico;
    }

    /**
     * @return the equipoBasicoSeleccionado
     */
    public EquipoBasico getEquipoBasicoSeleccionado() {
        return equipoBasicoSeleccionado;
    }

    /**
     * @param equipoBasicoSeleccionado the equipoBasicoSeleccionado to set
     */
    public void setEquipoBasicoSeleccionado(EquipoBasico equipoBasicoSeleccionado) {
        this.equipoBasicoSeleccionado = equipoBasicoSeleccionado;
    }
      
    
}

