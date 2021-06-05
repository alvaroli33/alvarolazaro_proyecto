package com.dawes.modelo;

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
@Table(name="mensajes")
public class MensajesVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmensaje;
	private String texto;
	@ManyToOne
	@JoinColumn(name="idusuario")
	private UsuariosVO usuario;
	@ManyToOne
	@JoinColumn(name="idusuario2")
	private UsuariosVO usuario2;
}
