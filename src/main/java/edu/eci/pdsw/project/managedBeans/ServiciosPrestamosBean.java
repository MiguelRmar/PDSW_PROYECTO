/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.project.managedBeans;

import edu.eci.pdsw.entities.RolUsuario;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.services.Services;
import edu.eci.pdsw.services.ServicesException;
import java.io.Serializable;
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
    private int codigoUsuarioPrestamo=0;
    private String equipoAPrestar = null;
    private String nombreUsuarioPrestamo = null;
    private String correoUsuarioPrestamo = null; 
    private Set<RolUsuario> rolUsuarioPrestamo = null;
    
    public void limpiarPaginaRegistrarUnPrestamo(){
        codigoUsuarioPrestamo=0;
        equipoAPrestar = null;
        nombreUsuarioPrestamo = null;
        correoUsuarioPrestamo = null; 
        rolUsuarioPrestamo = null;
    }
    
    /**
     * @param codigo codigo de usuario a quien se le va a realizar un prestamo
     */
    public void setCodigoUsuarioPrestamo(int codigo){
        this.codigoUsuarioPrestamo = codigo;
    }
    
    /**
     * @return codigo del usuario a quien se le realiza el prestamo
     */
    public int getCodigoUsuarioPrestamo(){
        return codigoUsuarioPrestamo;
    }
    
    /**
     * @param nombre equipo que se desea prestar
     */
    public void setEquipoAPrestar(String nombre){
        this.equipoAPrestar=nombre;
    }
    
    /**
     * @return equipo en prestamo
     */
    public String getEquipoAPrestar(){
        return equipoAPrestar;
    }
    /**
     * @return Nombre del usuario a quien se le desea prestar los equipos
     */
    public String getNombreUsuarioPrestamo(){
        return nombreUsuarioPrestamo;
    }
    
    /**
     * @return Correo del usuario a quien se le desea prestar los equipos
     */
    public String getCorreoUsuarioPrestamo(){
        return correoUsuarioPrestamo;
    }
    
    /**
     * @return Rol del usuario al que se le desea prestar los equipos
     */
    public Set<RolUsuario> getRolUsuarioPrestamo(){
        return rolUsuarioPrestamo;
    }
    
    
    /**
     * Actualiza los datos del usuario a quien se le realiza el prestamo
     */
    public void accionBotonUsuarioPrestamo(){
        Usuario usuario=null;
        try {
            usuario = services.loadUsuarioById(codigoUsuarioPrestamo);
        } 
        catch (ServicesException ex) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Error",ex.getMessage()));
        }
        nombreUsuarioPrestamo = usuario.getNombre();
        correoUsuarioPrestamo = usuario.getCorreo();
        rolUsuarioPrestamo = usuario.getRoles();
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
}
