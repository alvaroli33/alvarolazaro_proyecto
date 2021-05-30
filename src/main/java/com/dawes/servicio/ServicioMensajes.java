package com.dawes.servicio;

import java.util.Optional;

import com.dawes.modelo.MensajesVO;

public interface ServicioMensajes {

	<S extends MensajesVO> S save(S entity);

	<S extends MensajesVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<MensajesVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<MensajesVO> findAll();

	Iterable<MensajesVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(MensajesVO entity);

	void deleteAll(Iterable<? extends MensajesVO> entities);

	void deleteAll();

}