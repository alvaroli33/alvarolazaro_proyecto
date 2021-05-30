package com.dawes.repositorio;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.RolesVO;

@Repository
public interface RolesRepositorio extends CrudRepository<RolesVO, Integer>{

	Optional<RolesVO> findByNombre(String nombre);
}
