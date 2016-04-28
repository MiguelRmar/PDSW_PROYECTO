/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.project.managedBeans;

import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.PrestamoEquipo;
import edu.eci.pdsw.entities.PrestamoUsuario;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.persistence.DaoFactory;
import edu.eci.pdsw.services.Services;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2107262
 */
@ManagedBean(name="DevolucionEquipos")
@SessionScoped
public class beanPruebaDevoluciones {
    public void registrarDevolucion(int serial){
        PrestamoUsuario prestamoActual = null;
        Usuario usuarioActual = null;       
        //falta probar que la siguiente linea retorne la hora actual
        java.sql.Date horaActual = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Services se = Services.getInstance("h2-applicationconfig.properties");
        Equipo equipoActual = se.loadEquipoBySerial(serial);
        Set<Usuario> usuarios = se.loadUsuarios();
        for(Usuario u:usuarios){
            Set<PrestamoUsuario> prestamos = u.getPrestamos();
            for (PrestamoUsuario p: prestamos){
                if(p.getEquipo_serial()==serial && p.getFechaExpedicion()==null){
                    usuarioActual = u;
                    p.setFechaVencimiento(horaActual);
                    
                }
            }
        }  
        Set<PrestamoEquipo> prestamose = equipoActual.getPrestamos();
        for (PrestamoEquipo p:prestamose){
            if(p.getUsuario_id() == usuarioActual.getId()){
                p.setFechaExpedicion(horaActual);
            }
        
        }
    }
}
