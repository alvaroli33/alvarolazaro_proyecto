package com.dawes.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuarios")	
public class UsuariosVO implements UserDetails {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idusuario;
		private String username;
		private String lastname;
		private String password;
		private int edad;
		private String descripcion;
		private String correo;
		private int telefono;
		@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
		@JsonIgnore
		List<UsuarioRolVO> roles;
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<GrantedAuthority> privilegios= new ArrayList<>();
			for(UsuarioRolVO u:roles)
			privilegios.add(new SimpleGrantedAuthority(u.getRol().getNombre()));
			return privilegios;
		}
		@Override
		public boolean isAccountNonExpired() {
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}
		@Override
		public boolean isEnabled() {
			return true;
		}
	}

	

