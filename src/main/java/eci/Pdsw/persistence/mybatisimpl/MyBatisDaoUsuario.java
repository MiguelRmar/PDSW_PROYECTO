/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.persistence.mybatisimpl;

import eci.pdsw.persistence.DaoUsuario;
import eci.pdsw.entities.Usuario;
import eci.pdsw.mybatis.mappers.EquipoMapper;
import java.util.Set;
import javax.persistence.PersistenceException;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Jhordy
 */
public class MyBatisDaoUsuario implements DaoUsuario{
    
    private EquipoMapper emap=null;

    public MyBatisDaoUsuario(SqlSession session) {        
        emap=session.getMapper(EquipoMapper.class);
    }

    @Override
    public Usuario loadUsuarioById(int id) throws PersistenceException {
        return emap.loadUsuarioById(id);
    }
    
}
