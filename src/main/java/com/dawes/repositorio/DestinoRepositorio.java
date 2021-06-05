package com.dawes.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.DestinoVO;

@Repository	
public interface DestinoRepositorio extends CrudRepository<DestinoVO, Integer> {

	Optional<DestinoVO> findByNombre(String nombre);
}
