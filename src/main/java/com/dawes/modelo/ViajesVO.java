package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	private int asientos;
	private String coche;
	private String preferencias;
	private String estado;
	private String destino;
	private String origen;
	@ManyToOne
	@JoinColumn(name="idusuario")
	private UsuariosVO usuario;
}
