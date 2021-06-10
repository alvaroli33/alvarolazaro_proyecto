package com.dawes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelo.ViajesVO;
import com.dawes.repositorio.MensajesRepositorio;
import com.dawes.repositorio.ViajesRepositorio;

@RestController
public class ControladorRest {

	@Autowired
	 ViajesRepositorio vr;
	 @Autowired
	 MensajesRepositorio mr;
	 
	 @GetMapping("/viajes")
	 public ResponseEntity<?> findAll(){
		 List<ViajesVO> lista=(List<ViajesVO>) vr.findAll();
		 if (lista.isEmpty()) return ResponseEntity.notFound().build();
		 else return ResponseEntity.ok(lista);
	 }
	 
}

