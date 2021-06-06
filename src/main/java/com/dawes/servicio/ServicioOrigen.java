package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.OrigenVO;

public interface ServicioOrigen {

	<S extends 	OrigenVO> S save(S entity);

	<S extends OrigenVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<OrigenVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<OrigenVO> findAll();

	Iterable<OrigenVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(OrigenVO entity);

	void deleteAll(Iterable<? extends OrigenVO> entities);

	void deleteAll();

	Optional<OrigenVO> findByNombre(String nombre);
}