package com.dawes.servicio;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.RolesUsuariosVO;
import com.dawes.modelo.RolesVO;

public interface ServicioRolesUsuarios {

	<S extends RolesUsuariosVO> S save(S entity);

	<S extends RolesUsuariosVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<RolesUsuariosVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<RolesUsuariosVO> findAll();

	Iterable<RolesUsuariosVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(RolesUsuariosVO entity);

	void deleteAll(Iterable<? extends RolesUsuariosVO> entities);

	void deleteAll();
	List<RolesUsuariosVO> findByRoles(RolesVO rol);

}