package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.RolesVO;
import com.dawes.modelo.UsuarioRolVO;
import com.dawes.repositorio.UsuarioRolRepositorio;
import com.dawes.servicio.ServicioUsuarioRol;

@Service
public class ServicioUsuarioRolImpl implements ServicioUsuarioRol  {
	@Autowired
	UsuarioRolRepositorio rur;

	@Override
	public <S extends UsuarioRolVO> S save(S entity) {
		return rur.save(entity);
	}

	@Override
	public <S extends UsuarioRolVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rur.saveAll(entities);
	}

	@Override
	public Optional<UsuarioRolVO> findById(Integer id) {
		return rur.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rur.existsById(id);
	}

	@Override
	public Iterable<UsuarioRolVO> findAll() {
		return rur.findAll();
	}

	@Override
	public Iterable<UsuarioRolVO> findAllById(Iterable<Integer> ids) {
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
	public void delete(UsuarioRolVO entity) {
		rur.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends UsuarioRolVO> entities) {
		rur.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rur.deleteAll();
	}

	
}
