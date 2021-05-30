package com.dawes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.modelo.DestinoVO;
import com.dawes.modelo.MensajesVO;
import com.dawes.modelo.RolesUsuariosVO;
import com.dawes.modelo.RolesVO;
import com.dawes.modelo.UsuariosVO;
import com.dawes.modelo.ViajesVO;
import com.dawes.servicio.ServicioDestino;
import com.dawes.servicio.ServicioMensajes;
import com.dawes.servicio.ServicioRoles;
import com.dawes.servicio.ServicioRolesUsuarios;
import com.dawes.servicio.ServicioUsuarios;
import com.dawes.servicio.ServicioViajes;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AlvarolazaroProyectoApplicationTests {

	@Autowired
	ServicioDestino sd;
	@Autowired
	ServicioMensajes sm;
	@Autowired
	ServicioRoles sr;
	@Autowired
	ServicioRolesUsuarios sru;
	@Autowired
	ServicioUsuarios su;
	@Autowired
	ServicioViajes sv;
	
	
	@Test
	@Order(1)
	public void inicializar() {
		sd.save(new DestinoVO(0, "Gijon"));
		sd.save(new DestinoVO(0, "Oviedo"));
		su.save(new UsuariosVO(0,"Alvaro","Lazaro","contraseña",20,"descripcion","correo",123456789));
		su.save(new UsuariosVO(0,"Juan","Fernandez","contraseña2",18,"descripcion2","correo2",987654321));
		sm.save(new MensajesVO(0,"Hola",su.findByNombre("Alvaro").get(),su.findByNombre("Juan").get()));
		sr.save(new RolesVO(0,"Registrado"));
		sru.save(new RolesUsuariosVO(0,su.findByNombre("Alvaro").get(),sr.findByNombre("Registrado").get()));
		sru.save(new RolesUsuariosVO(0,su.findByNombre("Juan").get(),sr.findByNombre("Registrado").get()));
		sv.save(new ViajesVO(0,LocalDateTime.now(),LocalDateTime.now(),3,"seat","No fumar","disponible",su.findByNombre("Alvaro").get(),sd.findByNombre("Gijon").get()));
		sv.save(new ViajesVO(0,LocalDateTime.now(),LocalDateTime.now(),2,"opel","No animales","disponible",su.findByNombre("Juan").get(),sd.findByNombre("Oviedo").get()));
	}
	
	
	@Test
	@Order(2)
	public void usuariosPorDestino() {
		assertEquals(1,sv.findByDestino(sd.findByNombre("Gijon").get()).size());
	}
	
	@Test
	@Order(3)
	public void destinosPorUsuarios() {
		assertEquals(1,sv.findByUsuario(su.findByNombre("Alvaro").get()).size());
	}
	
	@Test
	@Order(4)
	public void viajessalidaEntreFechas() {
		assertEquals(2,sv.findByHorasalidaBetween(LocalDateTime.of(2021, 02, 9, 11, 00), LocalDateTime.of(2021, 02, 10, 12, 00)).size());
	}
	
	@Test
	@Order(5)
	public void viajesllegadaEntreFechas() {
		assertEquals(2,sv.findByHorallegadaBetween(LocalDateTime.of(2021, 02, 9, 11, 00), LocalDateTime.of(2021, 02, 10, 12, 00)).size());
	}
	
	@Test
	@Order(6)
	public void usuariosporRol() {
		assertEquals(2,sru.findByRoles(sr.findByNombre("Registrado").get()).size());
	}
	
}
