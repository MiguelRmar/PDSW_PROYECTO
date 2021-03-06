/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence_mybatisimpl;

import edu.eci.pdsw.entities.PrestamoUsuario;
import edu.eci.pdsw.persistence.DaoUsuario;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.mybatis.mappers.EquipoMapper;
import java.util.Set;
import javax.persistence.PersistenceException;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Jhordy
 */
public class MyBatisDaoUsuario implements DaoUsuario{
    
    private EquipoMapper emap=null;

    public MyBatisDaoUsuario(SqlSession session) throws PersistenceException{        
        emap=session.getMapper(EquipoMapper.class);
    }

    @Override
    public Usuario loadUsuarioById(int id) throws PersistenceException {
        if(emap.loadUsuarioById(id)==null){
            throw new PersistenceException("El usuario con id "+id+" no se encuentra registrado en la base de datos");
        }
        return emap.loadUsuarioById(id);
    }

    @Override
    public Set<PrestamoUsuario> loadPrestamos() throws PersistenceException {
        return emap.loadPrestamos();
    }
    @Override
    public Set<Usuario> loadUsuarios() throws PersistenceException{
        return emap.loadUsuarios();
    }
    
}