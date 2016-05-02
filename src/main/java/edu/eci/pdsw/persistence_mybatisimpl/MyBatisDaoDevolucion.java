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
    public void updatePrestamos(int s, int u, java.sql.Date t) {
        emap.updatePrestamo(s, u,t);
    }

    @Override
    public void updatePrestamosBasicos(String equipoBasico_nombre, int usuario, Date fechaVencimiento, int cantidad) {
        emap.updatePrestamosBasicos(equipoBasico_nombre, usuario, fechaVencimiento, cantidad);
    }

    @Override
    public void updateEquiposBasicosDevo(String equipoBasico_nombre, int cantidadPrestada) {
        emap.updateEquiposBasicosDevo(equipoBasico_nombre, cantidadPrestada);
    }
    
}
