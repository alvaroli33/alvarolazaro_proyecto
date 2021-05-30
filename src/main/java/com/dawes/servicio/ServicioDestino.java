package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.DestinoVO;

public interface ServicioDestino {

	<S extends DestinoVO> S save(S entity);

	<S extends DestinoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<DestinoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<DestinoVO> findAll();

	Iterable<DestinoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(DestinoVO entity);

	void deleteAll(Iterable<? extends DestinoVO> entities);

	void deleteAll();

	Optional<DestinoVO> findByNombre(String nombre);
}