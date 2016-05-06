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
    public void updatePrestamos(int serial_equipo, int usuario) throws PersistenceException{
        if(emap.loadEquipoBySerial(serial_equipo)==null){
            throw new PersistenceException("No existe ningun equipo con el serial "+ serial_equipo +" en la base de datos");
        }
        else{
            emap.updatePrestamo(serial_equipo, usuario);
        }
    }

    @Override
    public void updatePrestamosBasicos(String equipoBasico_nombre, int usuario) throws PersistenceException {

        if(emap.loadEquipoBasicoByName(equipoBasico_nombre)==null){
            throw new PersistenceException("No existe ningun equipo basico con el nombre "+ equipoBasico_nombre +" en la base de datos");
        }
        else{
            emap.updatePrestamosBasicos(equipoBasico_nombre, usuario);
        }
    }

    @Override
    public void updateEquiposBasicosDevo(String equipoBasico_nombre, int cantidadPrestada) throws PersistenceException{
        if(cantidadPrestada == 0){
            throw new PersistenceException("No puede devolver 0 equipos");
        }
        else{
            emap.updateEquiposBasicosDevo(equipoBasico_nombre, cantidadPrestada);
        }
    }

    @Override
    public void updateEquiposDevo(int equipo_serial) throws PersistenceException{
        if(emap.loadEquipoBySerial(equipo_serial)==null){
            throw new PersistenceException("No existe ningun equipo con el serial "+ equipo_serial +" en la base de datos");
        }
        else{
            emap.updateEquipoDevo(equipo_serial);
        }
    }
}
