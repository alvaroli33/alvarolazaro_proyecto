package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.RolesVO;
import com.dawes.repositorio.RolesRepositorio;
import com.dawes.servicio.ServicioRoles;

@Service
public class ServicioRolesImpl implements ServicioRoles {
	@Autowired
	RolesRepositorio rr;

	@Override
	public <S extends RolesVO> S save(S entity) {
		return rr.save(entity);
	}

	@Override
	public <S extends RolesVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rr.saveAll(entities);
	}

	@Override
	public Optional<RolesVO> findById(Integer id) {
		return rr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rr.existsById(id);
	}

	@Override
	public Iterable<RolesVO> findAll() {
		return rr.findAll();
	}

	@Override
	public Iterable<RolesVO> findAllById(Iterable<Integer> ids) {
		return rr.findAllById(ids);
	}

	@Override
	public long count() {
		return rr.count();
	}

	@Override
	public void deleteById(Integer id) {
		rr.deleteById(id);
	}

	@Override
	public void delete(RolesVO entity) {
		rr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends RolesVO> entities) {
		rr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rr.deleteAll();
	}

	@Override
	public Optional<RolesVO> findByNombre(String nombre) {
		return rr.findByNombre(nombre);
	}
}
