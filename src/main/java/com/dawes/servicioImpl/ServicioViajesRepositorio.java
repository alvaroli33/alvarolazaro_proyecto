package com.dawes.servicioImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.DestinoVO;
import com.dawes.modelo.UsuariosVO;
import com.dawes.modelo.ViajesVO;
import com.dawes.repositorio.ViajesRepositorio;
import com.dawes.servicio.ServicioViajes;

@Service
public class ServicioViajesRepositorio implements ServicioViajes {
	@Autowired
	ViajesRepositorio vr;

	@Override
	public <S extends ViajesVO> S save(S entity) {
		return vr.save(entity);
	}

	@Override
	public <S extends ViajesVO> Iterable<S> saveAll(Iterable<S> entities) {
		return vr.saveAll(entities);
	}

	@Override
	public Optional<ViajesVO> findById(Integer id) {
		return vr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return vr.existsById(id);
	}

	@Override
	public Iterable<ViajesVO> findAll() {
		return vr.findAll();
	}

	@Override
	public Iterable<ViajesVO> findAllById(Iterable<Integer> ids) {
		return vr.findAllById(ids);
	}

	@Override
	public long count() {
		return vr.count();
	}

	@Override
	public void deleteById(Integer id) {
		vr.deleteById(id);
	}

	@Override
	public void delete(ViajesVO entity) {
		vr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ViajesVO> entities) {
		vr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		vr.deleteAll();
	}

	@Override
	public List<ViajesVO> findByHorasalidaBetween(LocalDateTime hora1, LocalDateTime hora2) {
		return vr.findByHorasalidaBetween(hora1, hora2);
	}

	@Override
	public List<ViajesVO> findByHorallegadaBetween(LocalDateTime hora1, LocalDateTime hora2) {
		return vr.findByHorallegadaBetween(hora1, hora2);
	}

	@Override
	public List<ViajesVO> findByDestino(DestinoVO destino) {
		return vr.findByDestino(destino);
	}

	@Override
	public List<ViajesVO> findByUsuario(UsuariosVO usuario) {
		return vr.findByUsuario(usuario);
	}


}
