package com.dawes.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.dawes.modelo.UsuariosVO;

@Repository
public interface UsuariosRepositorio extends CrudRepository<UsuariosVO, Integer>{

	Optional<UsuariosVO> findByNombre(String nombre);
}
