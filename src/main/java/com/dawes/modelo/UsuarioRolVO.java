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
@Table(name="usuariorol")
public class UsuarioRolVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuariorol;
	@ManyToOne
	@JoinColumn(name="idusuario")
	private UsuariosVO usuario;
	@ManyToOne
	@JoinColumn(name="idrol")
	private RolesVO rol;
}
