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
    private String codigoUsuarioPrestamo;
    private String equipoAPrestar ;
    private String nombreUsuarioPrestamo ;
    private String correoUsuarioPrestamo ; 
    private boolean estudianteExiste=false;
    private Set<RolUsuario> rolUsuarioPrestamo ;
    
    
    public void limpiarPaginaRegistrarUnPrestamo(){
        setEstudianteExiste(false);
        codigoUsuarioPrestamo=null;
        equipoAPrestar = null;
        nombreUsuarioPrestamo = null;
        correoUsuarioPrestamo = null; 
        rolUsuarioPrestamo = null;
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
            
            usuario = services.loadUsuarioById(Integer.parseInt(codigoUsuarioPrestamo));
            estudianteExiste=true;
            nombreUsuarioPrestamo = usuario.getNombre();
            correoUsuarioPrestamo = usuario.getCorreo();
            rolUsuarioPrestamo = usuario.getRoles();
            
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
}
