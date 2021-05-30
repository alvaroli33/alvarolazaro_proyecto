package com.dawes.servicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.DestinoVO;
import com.dawes.modelo.UsuariosVO;
import com.dawes.modelo.ViajesVO;

public interface ServicioViajes {

	<S extends ViajesVO> S save(S entity);

	<S extends ViajesVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ViajesVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ViajesVO> findAll();

	Iterable<ViajesVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ViajesVO entity);

	void deleteAll(Iterable<? extends ViajesVO> entities);

	void deleteAll();
	List<ViajesVO> findByHorasalidaBetween(LocalDateTime hora1,LocalDateTime hora2);
	List<ViajesVO> findByHorallegadaBetween(LocalDateTime hora1,LocalDateTime hora2);
	List<ViajesVO> findByDestino(DestinoVO destino);
	List<ViajesVO> findByUsuario(UsuariosVO usuario);

}