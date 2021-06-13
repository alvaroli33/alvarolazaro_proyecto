package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.UsuariosVO;

public interface ServicioUsuarios {

	<S extends UsuariosVO> S save(S entity);

	<S extends UsuariosVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuariosVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuariosVO> findAll();

	Iterable<UsuariosVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(UsuariosVO entity);

	void deleteAll(Iterable<? extends UsuariosVO> entities);

	void deleteAll();

	Optional<UsuariosVO> findByUsername(String nombre);
	
	UsuariosVO CrearUsuario(UsuariosVO usuario) throws Exception;
}