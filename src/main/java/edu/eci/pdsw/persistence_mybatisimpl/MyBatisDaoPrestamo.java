/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence_mybatisimpl;

import edu.eci.pdsw.entities.PrestamoEquipo;
import edu.eci.pdsw.entities.PrestamoUsuario;
import edu.eci.pdsw.mybatis.mappers.EquipoMapper;
import edu.eci.pdsw.persistence.DaoPrestamo;
import java.util.Calendar;
import javax.persistence.PersistenceException;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2105534
 */
public class MyBatisDaoPrestamo implements DaoPrestamo{
 
    private EquipoMapper emap=null;

    public MyBatisDaoPrestamo(SqlSession session) throws PersistenceException {
         emap=session.getMapper(EquipoMapper.class);
    }
    
    @Override
    public void registrarNuevoPrestamo(PrestamoEquipo pe, PrestamoUsuario pu) throws PersistenceException {
        if(pe.getFechaExpedicion().getTime()!=Calendar.getInstance().getTime().getTime()){
            throw new PersistenceException("La fecha ingresada no es igual a la fecha actual");
        }
        if(emap.loadUsuarioById(pe.getUsuario_id())==null){
            throw new PersistenceException("El usuario con id "+pe.getUsuario_id()+" no se encuentra registrado en la base de datos");
        }
        if(emap.loadEquipoBySerial(pu.getEquipo_serial())==null){
            throw new PersistenceException("El equipo con serial"+pu.getEquipo_serial()+" no se encuentra registrado en la base de datos");
        }
        if(!emap.loadEquipoBySerial(pu.getEquipo_serial()).getSubEstado().equals("en almacén")){
            throw new PersistenceException("El equipo con serial"+pu.getEquipo_serial()+" se encuentra registrado en la base de datos, pero no esta disponible para prestar");
        }
        emap.registrarNuevoPrestamo(pe, pu);
    }
    
}
