/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence_mybatisimpl;

import edu.eci.pdsw.entities.EquipoBasico;
import edu.eci.pdsw.mybatis.mappers.EquipoMapper;
import edu.eci.pdsw.persistence.DaoDevolucion;
import java.sql.Date;
import java.util.Calendar;
import javax.persistence.PersistenceException;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2107262
 */
public class MyBatisDaoDevolucion implements DaoDevolucion{
    
    private EquipoMapper emap=null;
    
    MyBatisDaoDevolucion(SqlSession currentSession) {
        emap=currentSession.getMapper(EquipoMapper.class);
    }

   @Override
    public void updatePrestamos(int s, int u, java.sql.Date t) throws PersistenceException {
        if(emap.loadUsuarioById(u) == null){
            throw new PersistenceException("El usuario con id "+u+" no se encuentra registrado en la base de datos");
        }
        if(emap.loadEquipoBySerial(s)==null){
            throw new PersistenceException("El equipo con serial "+s+" no se encuentra registrado en la base de datos");
        }
        if(t.compareTo(new java.sql.Date(Calendar.getInstance().getTime().getTime()))==0){
            throw new PersistenceException("La fecha no coincide con la fecha actual del sistema");
        }
        
        emap.updatePrestamo(s, u,t);
    }

    @Override
    public void updatePrestamosBasicos(String equipoBasico_nombre, int usuario, Date fechaVencimiento, int cantidad) throws PersistenceException{
        emap.updatePrestamosBasicos(equipoBasico_nombre, usuario, fechaVencimiento, cantidad);
    }

    @Override
    public void updateEquiposBasicosDevo(String equipoBasico_nombre, int cantidadPrestada) throws PersistenceException{
        emap.updateEquiposBasicosDevo(equipoBasico_nombre, cantidadPrestada);
    }
    
}
