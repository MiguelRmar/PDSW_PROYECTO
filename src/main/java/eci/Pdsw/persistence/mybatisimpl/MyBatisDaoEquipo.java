/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.Pdsw.persistence.mybatisimpl;

import eci.Pdsw.persistence.DaoEquipos;
import eci.pdsw.entities.Equipo;
import eci.pdsw.entities.Modelo;
import eci.pdsw.mybatis.mappers.EquipoMapper;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2107262
 */
public class MyBatisDaoEquipo implements DaoEquipos{
    private EquipoMapper emap=null;

    public MyBatisDaoEquipo(SqlSession session) {        
        emap=session.getMapper(EquipoMapper.class);
    }
    @Override
    public void registroEquipoNuevo(Equipo e) {
        emap.registrarEquipoNuevo(e);
    }

    @Override
    public void registrarModeloNuevo(Modelo m) {
        emap.registrarModeloNuevo(m);
    }

    @Override
    public Modelo loadModelo(String nombre) {
        //falta mandar una excepcion si mod es nulo indicando que no existe el modelo requerido.
        Modelo mod=emap.loadModeloByName(nombre);
        return mod;
    }
    
}
