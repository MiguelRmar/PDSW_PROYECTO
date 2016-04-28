/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence_mybatisimpl;

import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.EquipoBasico;
import edu.eci.pdsw.entities.Modelo;
import edu.eci.pdsw.mybatis.mappers.EquipoMapper;
import org.apache.ibatis.session.SqlSession;
import edu.eci.pdsw.persistence.DaoEquipo;
import java.util.Set;

/**
 *
 * @author 2107262
 */
public class MyBatisDaoEquipo implements DaoEquipo{
    private EquipoMapper emap=null;

    public MyBatisDaoEquipo(SqlSession session) {        
        emap=session.getMapper(EquipoMapper.class);
    }
    @Override
    public void registrarEquipoNuevo(Equipo e,String m) {
        emap.registrarEquipoNuevo(e,m);
    }

    @Override
    public void registrarModeloNuevo(Modelo m) {
        emap.registrarModeloNuevo(m);
    }

    @Override
    public Modelo loadModeloByName(String nombre) {
        Modelo mod=emap.loadModeloByName(nombre);
        return mod;
    }

    @Override
    public Equipo loadEquipoBySerial(int serial) {
        Equipo eq=emap.loadEquipoBySerial(serial);
        return eq;
    }

    @Override
    public EquipoBasico loadEquipoBasicoByName(String nombre) {
        EquipoBasico eqb=emap.loadEquipoBasicoByName(nombre);
        return eqb;
    }

    @Override
    public void registrarEquipoBasicoNuevo(EquipoBasico eq) {
        emap.registrarEquipoBasicoNuevo(eq);
    }

    @Override
    public Set<Modelo> loadModelos() {
        Set<Modelo> ans=emap.loadModelos();
        return ans;
    }
    
    @Override
    public Set<EquipoBasico> loadEquiposBasicos(){
        Set<EquipoBasico> ans=emap.loadEquiposBasicos();
        return ans;
    }

    
}