
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
package eci.pdsw.mybatis.mappers;
import eci.pdsw.entities.Equipo;
import eci.pdsw.entities.Modelo;
import eci.pdsw.entities.Prestamo;
import eci.pdsw.entities.Usuario;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author hcadavid
 */
public interface EquipoMapper {
    
    public Usuario loadUsuarioById(@Param("idusuario") int id);
    
    public void registrarEquipoNuevo(@Param("equipo")Equipo e);
    
    public void registrarModeloNuevo(@Param("modelo")Modelo m);
    
    public Modelo loadModeloByName(@Param("modelo")String nombre);
    
    public Set<Prestamo> loadPrestamos();
}
