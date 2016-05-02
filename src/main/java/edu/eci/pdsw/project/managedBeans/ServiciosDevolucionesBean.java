/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.project.managedBeans;

import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.PrestamoBasicoUsuario;
import edu.eci.pdsw.entities.PrestamoEquipo;
import edu.eci.pdsw.entities.PrestamoUsuario;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.services.Services;
import edu.eci.pdsw.services.ServicesException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author 2107262
 */
@ManagedBean(name="Devolucion")
@SessionScoped
public class ServiciosDevolucionesBean implements Serializable{

    public ServiciosDevolucionesBean() {
        
    }
    @ManagedProperty(value = "#{loginBean}")    
    private ShiroLoginBean loginBean;
    //datos para una devolucion de un equipo normal
    private boolean yaBusqueEquipoADevolver = false;
    private boolean serialDevolucionEncontrado = false;
    private boolean serialDevolucionNoEncontrado = true;
    private String textoSalidaEquipoADevolver;
    private int serialADevolver;
    private Usuario usuarioDevolucion;
    java.sql.Date horaActual = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    //datos para una devolucion de un equipo basico
    private int condigoEstudianteBasicos;
    private String nombreEquipoBasicoDevolver;
    private int cantidadBasicaDevuelta;
    private Usuario usuarioDevolucionBasico;
    
    public void limpiarDevolucion(){
        yaBusqueEquipoADevolver = false;
        serialDevolucionEncontrado = false;
        serialDevolucionNoEncontrado = true;
        textoSalidaEquipoADevolver = null;
        setSerialADevolver(0);
        usuarioDevolucion = null;
    
    }
    public void limpiarDevolucionBasica(){
        condigoEstudianteBasicos = 0;
        nombreEquipoBasicoDevolver = null;
        cantidadBasicaDevuelta = 0;
        usuarioDevolucionBasico = null;
    }
    
   public void accionBuscarDevolucion() {
        try {
            Services se = Services.getInstance("applicationconfig.properties");
            Set<Usuario> usuarios = se.loadUsuarios();
            for (Usuario u : usuarios) {
                Set<PrestamoUsuario> prestamos = u.getPrestamos();
                for (PrestamoUsuario p : prestamos) {
                    if (p.getEquipo_serial() == getSerialADevolver() && p.getFechaVencimiento() == null) {
                        setUsuarioDevolucion(u);
                        setSerialDevolucionEncontrado(true);
                        setSerialDevolucionNoEncontrado(false);
                        textoSalidaEquipoADevolver = "El usuario con el prestamo del equipo fue encontrado exitosamente";
                    }
                }
            }
            if (getUsuarioDevolucion() == null) {
                setTextoSalidaEquipoADevolver("No fue encontrado un usuario con el presente equipo  " + getSerialADevolver() + " en prestamo ");
            }
            setYaBusqueEquipoADevolver(true);
        } catch (ServicesException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong", "Ocurrio un error inesperado"));
            RequestContext context = RequestContext.getCurrentInstance();
            Logger.getLogger(ServiciosDevolucionesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void accionRealizarDevolucion() {
        try {
            PrestamoUsuario prestamoActual = null;
            //la fecha actual entrega año,mes y dia pero no minutos ni segundos.
            Services se = Services.getInstance("applicationconfig.properties");
            Equipo equipoActual = se.loadEquipoBySerial(getSerialADevolver());
            Set<PrestamoUsuario> prestamos = usuarioDevolucion.getPrestamos();
            for (PrestamoUsuario p : prestamos) {
                if (p.getEquipo_serial() == getSerialADevolver() && p.getFechaVencimiento() == null) {
                    p.setFechaVencimiento(horaActual);
                    se.updatePrestamos(p,usuarioDevolucion.getId());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", "Se ha realizado la devolución exitosamente"));
                    RequestContext context = RequestContext.getCurrentInstance();
                    break;
                }
            }
            Set<PrestamoEquipo> prestamose = equipoActual.getPrestamos();
            for (PrestamoEquipo p : prestamose) {
                if (p.getUsuario_id() == usuarioDevolucion.getId()) {
                    p.setFechaExpedicion(horaActual);
                    break;
                }
                
            }
            limpiarDevolucion();
        } catch (ServicesException ex) {
            Logger.getLogger(ServiciosDevolucionesBean.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }

    public void accionRealizarDevolucionBasica() {
        try {
            Services se = Services.getInstance("applicationconfig.properties");
            Set<Usuario> usuarios = se.loadUsuarios();
            for (Usuario u : usuarios) {
                Set<PrestamoBasicoUsuario> prestamos = u.getPrestamosBasicos();
                for (PrestamoBasicoUsuario p : prestamos) {
                    if (p.getCantidadPrestada() == cantidadBasicaDevuelta && p.getFechaVencimiento() == null && p.getEquipoBasico_nombre().equals(nombreEquipoBasicoDevolver)) {
                        setUsuarioDevolucionBasico(u);
                        p.setFechaVencimiento(horaActual);
                        se.updatePrestamosBasicos(p, u.getId());
                    }
                }
            }
            if(usuarioDevolucionBasico != null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", "Se ha realizado la devolución exitosamente"));
                RequestContext context = RequestContext.getCurrentInstance();
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong", "No se encontro usuario con los objetos prestados"));
                RequestContext context = RequestContext.getCurrentInstance();
            }
            limpiarDevolucionBasica();
        } catch (ServicesException ex) {
            Logger.getLogger(ServiciosDevolucionesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     * @return the nombreEquipoBasicoDevolver
     */
    public String getNombreEquipoBasicoDevolver() {
        return nombreEquipoBasicoDevolver;
    }

    /**
     * @param nombreEquipoBasicoDevolver the nombreEquipoBasicoDevolver to set
     */
    public void setNombreEquipoBasicoDevolver(String nombreEquipoBasicoDevolver) {
        this.nombreEquipoBasicoDevolver = nombreEquipoBasicoDevolver;
    }

    /**
     * @return the cantidadBasicaDevuelta
     */
    public int getCantidadBasicaDevuelta() {
        return cantidadBasicaDevuelta;
    }

    /**
     * @param cantidadBasicaDevuelta the cantidadBasicaDevuelta to set
     */
    public void setCantidadBasicaDevuelta(int cantidadBasicaDevuelta) {
        this.cantidadBasicaDevuelta = cantidadBasicaDevuelta;
    }

    /**
     * @return the usuarioDevolucionBasico
     */
    public Usuario getUsuarioDevolucionBasico() {
        return usuarioDevolucionBasico;
    }

    /**
     * @param usuarioDevolucionBasico the usuarioDevolucionBasico to set
     */
    public void setUsuarioDevolucionBasico(Usuario usuarioDevolucionBasico) {
        this.usuarioDevolucionBasico = usuarioDevolucionBasico;
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
