package com.dawes.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dawes.modelo.OrigenVO;
import com.dawes.repositorio.OrigenRepositorio;
import com.dawes.servicio.ServicioOrigen;

@Service
public class ServicioOrigenImpl implements ServicioOrigen {

	@Autowired
	OrigenRepositorio or;

	@Override
	public <S extends OrigenVO> S save(S entity) {
		return or.save(entity);
	}

	@Override
	public <S extends OrigenVO> Iterable<S> saveAll(Iterable<S> entities) {
		return or.saveAll(entities);
	}

	@Override
	public Optional<OrigenVO> findById(Integer id) {
		return or.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return or.existsById(id);
	}

	@Override
	public Iterable<OrigenVO> findAll() {
		return or.findAll();
	}

	@Override
	public Iterable<OrigenVO> findAllById(Iterable<Integer> ids) {
		return or.findAllById(ids);
	}

	@Override
	public long count() {
		return or.count();
	}

	@Override
	public void deleteById(Integer id) {
		or.deleteById(id);
	}

	@Override
	public void delete(OrigenVO entity) {
		or.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends OrigenVO> entities) {
		or.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		or.deleteAll();
	}

	@Override
	public Optional<OrigenVO> findByNombre(String nombre) {
		return or.findByNombre(nombre);
	}
	
}
