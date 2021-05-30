package com.dawes.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.DestinoVO;
import com.dawes.repositorio.DestinoRepositorio;
import com.dawes.servicio.ServicioDestino;

@Service
public class ServicioDestinoImpl implements ServicioDestino {

	@Autowired
	DestinoRepositorio dr;

	@Override
	public <S extends DestinoVO> S save(S entity) {
		return dr.save(entity);
	}

	@Override
	public <S extends DestinoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return dr.saveAll(entities);
	}

	@Override
	public Optional<DestinoVO> findById(Integer id) {
		return dr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return dr.existsById(id);
	}

	@Override
	public Iterable<DestinoVO> findAll() {
		return dr.findAll();
	}

	@Override
	public Iterable<DestinoVO> findAllById(Iterable<Integer> ids) {
		return dr.findAllById(ids);
	}

	@Override
	public long count() {
		return dr.count();
	}

	@Override
	public void deleteById(Integer id) {
		dr.deleteById(id);
	}

	@Override
	public void delete(DestinoVO entity) {
		dr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends DestinoVO> entities) {
		dr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		dr.deleteAll();
	}

	@Override
	public Optional<DestinoVO> findByNombre(String nombre) {
		return dr.findByNombre(nombre);
	}
	
}
