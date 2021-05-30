package com.dawes.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="destino")
public class DestinoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddestino;
	private String nombre;
}
