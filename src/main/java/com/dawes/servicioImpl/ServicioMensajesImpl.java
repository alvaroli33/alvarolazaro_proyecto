package com.dawes.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.MensajesVO;
import com.dawes.repositorio.MensajesRepositorio;
import com.dawes.servicio.ServicioMensajes;

@Service
public class ServicioMensajesImpl implements ServicioMensajes {

	@Autowired
	MensajesRepositorio mr;

	@Override
	public <S extends MensajesVO> S save(S entity) {
		return mr.save(entity);
	}

	@Override
	public <S extends MensajesVO> Iterable<S> saveAll(Iterable<S> entities) {
		return mr.saveAll(entities);
	}

	@Override
	public Optional<MensajesVO> findById(Integer id) {
		return mr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return mr.existsById(id);
	}

	@Override
	public Iterable<MensajesVO> findAll() {
		return mr.findAll();
	}

	@Override
	public Iterable<MensajesVO> findAllById(Iterable<Integer> ids) {
		return mr.findAllById(ids);
	}

	@Override
	public long count() {
		return mr.count();
	}

	@Override
	public void deleteById(Integer id) {
		mr.deleteById(id);
	}

	@Override
	public void delete(MensajesVO entity) {
		mr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends MensajesVO> entities) {
		mr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		mr.deleteAll();
	}
}
