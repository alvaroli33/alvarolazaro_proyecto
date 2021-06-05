package com.dawes.modelo;

import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="viajes")
public class ViajesVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idviajes;
	private String horasalida;
	private String horallegada;
	private int asientos;
	private String coche;
	private String preferencias;
	private String estado;
	@ManyToOne
	@JoinColumn(name="idusuario")
	private UsuariosVO usuario;
	@ManyToOne
	@JoinColumn(name="iddestino")
	private DestinoVO destino;
}
