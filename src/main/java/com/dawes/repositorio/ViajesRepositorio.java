package com.dawes.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.DestinoVO;
import com.dawes.modelo.UsuariosVO;
import com.dawes.modelo.ViajesVO;

@Repository
public interface ViajesRepositorio extends CrudRepository<ViajesVO, Integer>{
	List<ViajesVO> findByHorasalidaBetween(LocalDateTime hora1,LocalDateTime hora2);
	List<ViajesVO> findByHorallegadaBetween(LocalDateTime hora1,LocalDateTime hora2);
	List<ViajesVO> findByDestino(DestinoVO destino);
	List<ViajesVO> findByUsuario(UsuariosVO usuario);
}
