
/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.mybatis.mappers;
import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.EquipoBasico;
import edu.eci.pdsw.entities.Modelo;
import edu.eci.pdsw.entities.PrestamoUsuario;
import edu.eci.pdsw.entities.Usuario;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author hcadavid
 */
public interface EquipoMapper {
    
    public Usuario loadUsuarioById(@Param("idusuario") int id);
    
    public Modelo loadModeloByName(@Param("nombremodelo")String nombre);
    
    public Equipo loadEquipoBySerial(@Param("serialequipo")int serial);
    
    public EquipoBasico loadEquipoBasicoByName(@Param("nombreequipobasico")String nombre);
    
    public Set<PrestamoUsuario> loadPrestamos();
    
    public void registrarModeloNuevo(@Param("modelo")Modelo m);
    
    public void registrarEquipoNuevo(@Param("equipo")Equipo e,@Param("modelo") String modelo);

    public void registrarEquipoBasicoNuevo(@Param("equipoBasico")EquipoBasico eb);
    
    public Set<Usuario> loadUsuarios();
    
    public Set<Modelo> loadModelos();
    
    public Set<EquipoBasico> loadEquiposBasicos();
    
}
