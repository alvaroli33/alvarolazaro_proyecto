package com.dawes.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.RolesUsuariosVO;
import com.dawes.modelo.RolesVO;

@Repository
public interface RolesUsuariosRepositorio extends CrudRepository<RolesUsuariosVO, Integer>{

	List<RolesUsuariosVO> findByRoles(RolesVO rol);
}
