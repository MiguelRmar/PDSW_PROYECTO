/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.project.managedBeans;

import edu.eci.pdsw.entities.PrestamoEquipo;
import edu.eci.pdsw.entities.PrestamoUsuario;
import edu.eci.pdsw.entities.RolUsuario;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.services.Services;
import edu.eci.pdsw.services.ServicesException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jhordy
 */
@ManagedBean(name="Prestamo")
@SessionScoped
public class ServiciosPrestamosBean implements Serializable{

    public ServiciosPrestamosBean() {
    }
    Services services = Services.getInstance("applicationconfig.properties");
    @ManagedProperty(value = "#{loginBean}")    
    private ShiroLoginBean loginBean;
    private String codigoUsuarioPrestamo;
    private boolean estudianteExiste=false;
    private Usuario usuarioSeleccionado=null;
    private String rolesUsuarioSeleccionado="";
    private String nombreEquipoBasicoPrestar="";
    private String codigoEquipo="";
    private String tipoEquipo="";
    private boolean codificado=false;
    private boolean noCodificado=false;
    private String tipoPrestamoSeleccionado;
    private List<String> nombresTipoPrestamo;
    
    public void limpiarPaginaRegistrarUnPrestamo(){
        nombresTipoPrestamo=new ArrayList<String>();
        setEstudianteExiste(false);
        usuarioSeleccionado=null;
        codigoUsuarioPrestamo=null;
        rolesUsuarioSeleccionado="";
        setCodigoEquipo("");
        setNombreEquipoBasicoPrestar("");
        setTipoEquipo("");
        setCodificado(false);
        setNoCodificado(false);
        tipoPrestamoSeleccionado=null;
    }
    
    /**
     * @param codigo codigo de usuario a quien se le va a realizar un prestamo
     */
    public void setCodigoUsuarioPrestamo(String codigo){
        
        this.codigoUsuarioPrestamo = codigo;
    }
    
    /**
     * @return codigo del usuario a quien se le realiza el prestamo
     */
    public String getCodigoUsuarioPrestamo(){
        return codigoUsuarioPrestamo;
    }
    /**
     * registra un prestamo de un equipo
     */
    public void accionRegistrarPrestamoEquipo(){
        try {
            System.out.println(codigoUsuarioPrestamo);
            System.out.println(codigoEquipo);
            System.out.println(tipoPrestamoSeleccionado);
            
            PrestamoEquipo pe=new PrestamoEquipo(Integer.parseInt(codigoUsuarioPrestamo),new java.sql.Date(Calendar.getInstance().getTime().getTime()),null,tipoPrestamoSeleccionado);
            PrestamoUsuario pu=new PrestamoUsuario(Integer.parseInt(codigoEquipo),new java.sql.Date(Calendar.getInstance().getTime().getTime()),null,tipoPrestamoSeleccionado);
            services.registrarNuevoPrestamo(pe,pu);
            System.out.println("pase");
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Succes","Se ha registrado el préstamo con éxito"));
            //falta actualizar el estado del equipo a prestado
        }
        catch (ServicesException ex) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Error",ex.getMessage()));
        }
    }
    
    /**
     * registra un prestamo de un equipo basico
     */
    public void accionRegistrarPrestamoEquipoBasico(){
            
        
    }
    
    
    public void accionCambiarTipo(){
        if (tipoEquipo.equals("Codificado")){
            codificado=true;
            noCodificado=false;
            
        }
        else if(tipoEquipo.equals("NO Codificado")){
            codificado=false;
            noCodificado=true;
        }
        else{
            codificado=false;
            noCodificado=false;
        }
        tipoPrestamoSeleccionado=null;
    }
    /**
     * Actualiza los datos del usuario a quien se le realiza el prestamo
     */
    public void accionBotonUsuarioPrestamo(){
        usuarioSeleccionado=null;
        try {
            usuarioSeleccionado = services.loadUsuarioById(Integer.parseInt(codigoUsuarioPrestamo));
            String roles="";
            for (RolUsuario r: usuarioSeleccionado.getRoles()) {
                roles+=r.getRol_r()+", ";
            }
            rolesUsuarioSeleccionado=roles.substring(0,roles.length()-2);
            estudianteExiste=true;
        } 
        catch (ServicesException ex) {
            estudianteExiste=false;
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Error",ex.getMessage()));
        }
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
     * @return the estudianteExiste
     */
    public boolean isEstudianteExiste() {
        return estudianteExiste;
    }

    /**
     * @param estudianteExiste the estudianteExiste to set
     */
    public void setEstudianteExiste(boolean estudianteExiste) {
        this.estudianteExiste = estudianteExiste;
    }

    /**
     * @return the usuarioSeleccionado
     */
    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    /**
     * @param usuarioSeleccionado the usuarioSeleccionado to set
     */
    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    /**
     * @return the rolesUsuarioSeleccionado
     */
    public String getRolesUsuarioSeleccionado() {
        return rolesUsuarioSeleccionado;
    }

    /**
     * @param rolesUsuarioSeleccionado the rolesUsuarioSeleccionado to set
     */
    public void setRolesUsuarioSeleccionado(String rolesUsuarioSeleccionado) {
        this.rolesUsuarioSeleccionado = rolesUsuarioSeleccionado;
    }

    /**
     * @return the nombreEquipoBasicoPrestar
     */
    public String getNombreEquipoBasicoPrestar() {
        return nombreEquipoBasicoPrestar;
    }

    /**
     * @param nombreEquipoBasicoPrestar the nombreEquipoBasicoPrestar to set
     */
    public void setNombreEquipoBasicoPrestar(String nombreEquipoBasicoPrestar) {
        this.nombreEquipoBasicoPrestar = nombreEquipoBasicoPrestar;
    }

    /**
     * @return the codigoEquipo
     */
    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    /**
     * @param codigoEquipo the codigoEquipo to set
     */
    public void setCodigoEquipo(String codigoEquipo) {
        
        this.codigoEquipo = codigoEquipo;
    }

    /**
     * @return the tipoEquipo
     */
    public String getTipoEquipo() {
        return tipoEquipo;
    }

    /**
     * @param tipoEquipo the tipoEquipo to set
     */
    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    /**
     * @return the codificado
     */
    public boolean isCodificado() {
        return codificado;
    }

    /**
     * @param codificado the codificado to set
     */
    public void setCodificado(boolean codificado) {
        this.codificado = codificado;
    }

    /**
     * @return the noCodificado
     */
    public boolean isNoCodificado() {
        return noCodificado;
    }

    /**
     * @param noCodificado the noCodificado to set
     */
    public void setNoCodificado(boolean noCodificado) {
        this.noCodificado = noCodificado;
    }

    /**
     * @return the tipoPrestamoSeleccionado
     */
    public String getTipoPrestamoSeleccionado() {
        
        return tipoPrestamoSeleccionado;
    }

    /**
     * @param tipoPrestamoSeleccionado the tipoPrestamoSeleccionado to set
     */
    public void setTipoPrestamoSeleccionado(String tipoPrestamoSeleccionado) {
        this.tipoPrestamoSeleccionado = tipoPrestamoSeleccionado;
    }

    /**
     * @return the nombresTipoPrestamo
     */
    public List<String> getNombresTipoPrestamo() {
        nombresTipoPrestamo=new ArrayList<String>();
        String[] listaNombres=rolesUsuarioSeleccionado.split(", ");
        nombresTipoPrestamo.add("Préstamo diario");
        nombresTipoPrestamo.add("Préstamo 24 horas");
        nombresTipoPrestamo.add("Préstamo por semestre");
        for(int i=0;i<listaNombres.length;i++){
            if(listaNombres[i].equals("profesor")){
                nombresTipoPrestamo.add("Préstamo indefinido");
            }
        }
        
        return nombresTipoPrestamo;
    }

    /**
     * @param nombresTipoPrestamo the nombresTipoPrestamo to set
     */
    public void setNombresTipoPrestamo(List<String> nombresTipoPrestamo) {
        this.nombresTipoPrestamo = nombresTipoPrestamo;
    }
}
