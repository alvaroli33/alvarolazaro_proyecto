package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.RolesUsuariosVO;
import com.dawes.modelo.RolesVO;
import com.dawes.repositorio.RolesUsuariosRepositorio;
import com.dawes.servicio.ServicioRolesUsuarios;

@Service
public class ServicioRolesUsuariosImpl implements ServicioRolesUsuarios {
	@Autowired
	RolesUsuariosRepositorio rur;

	@Override
	public <S extends RolesUsuariosVO> S save(S entity) {
		return rur.save(entity);
	}

	@Override
	public <S extends RolesUsuariosVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rur.saveAll(entities);
	}

	@Override
	public Optional<RolesUsuariosVO> findById(Integer id) {
		return rur.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rur.existsById(id);
	}

	@Override
	public Iterable<RolesUsuariosVO> findAll() {
		return rur.findAll();
	}

	@Override
	public Iterable<RolesUsuariosVO> findAllById(Iterable<Integer> ids) {
		return rur.findAllById(ids);
	}

	@Override
	public long count() {
		return rur.count();
	}

	@Override
	public void deleteById(Integer id) {
		rur.deleteById(id);
	}

	@Override
	public void delete(RolesUsuariosVO entity) {
		rur.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends RolesUsuariosVO> entities) {
		rur.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rur.deleteAll();
	}

	@Override
	public List<RolesUsuariosVO> findByRoles(RolesVO rol) {
		return rur.findByRoles(rol);
	}
}
