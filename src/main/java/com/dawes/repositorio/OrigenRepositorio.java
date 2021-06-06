package com.dawes.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.OrigenVO;

@Repository	
public interface OrigenRepositorio extends CrudRepository<OrigenVO, Integer> {

	Optional<OrigenVO> findByNombre(String nombre);
}
