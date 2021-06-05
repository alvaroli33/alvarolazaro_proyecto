package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.RolesVO;

public interface ServicioRoles {

	<S extends RolesVO> S save(S entity);

	<S extends RolesVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<RolesVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<RolesVO> findAll();

	Iterable<RolesVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(RolesVO entity);

	void deleteAll(Iterable<? extends RolesVO> entities);

	void deleteAll();
	Optional<RolesVO> findByNombre(String nombre);

}