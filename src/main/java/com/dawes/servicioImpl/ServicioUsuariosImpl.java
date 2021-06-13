package com.dawes.servicioImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuariosVO;
import com.dawes.repositorio.UsuariosRepositorio;
import com.dawes.servicio.ServicioUsuarios;

@Service
public class ServicioUsuariosImpl implements ServicioUsuarios,UserDetailsService {
	@Autowired
	UsuariosRepositorio ur;

	@Override
	public <S extends UsuariosVO> S save(S entity) {
		return ur.save(entity);
	}

	@Override
	public <S extends UsuariosVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ur.saveAll(entities);
	}

	@Override
	public Optional<UsuariosVO> findById(Integer id) {
		return ur.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ur.existsById(id);
	}

	@Override
	public Iterable<UsuariosVO> findAll() {
		return ur.findAll();
	}

	@Override
	public Iterable<UsuariosVO> findAllById(Iterable<Integer> ids) {
		return ur.findAllById(ids);
	}

	@Override
	public long count() {
		return ur.count();
	}

	@Override
	public void deleteById(Integer id) {
		ur.deleteById(id);
	}

	@Override
	public void delete(UsuariosVO entity) {
		ur.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends UsuariosVO> entities) {
		ur.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ur.deleteAll();
	}

	@Override
	public Optional<UsuariosVO> findByUsername(String nombre) {
		return ur.findByUsername(nombre);
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ur.findByUsername(username).get();
    }
	
	private boolean CompararUsuarios(UsuariosVO usuario) throws Exception {
        Optional<UsuariosVO> u = ur.findByUsername(usuario.getUsername());
        if (u.isPresent()) {
            throw new Exception("El usuario ya existe, Introduzca otro");
        }
        return true;
    }

    private boolean CompararContraseñas(UsuariosVO usuario) throws Exception {
        if ( !usuario.getPassword().equals(usuario.getConfirmpassword())) {
            throw new Exception("La contraseña no son iguales");
        }
        return true;
    }

    public UsuariosVO CrearUsuario(UsuariosVO usuario) throws Exception {
        if (CompararUsuarios(usuario) && CompararContraseñas(usuario)) {
            BCryptPasswordEncoder encript=new BCryptPasswordEncoder();
            String contraseña = encript.encode(usuario.getPassword());
            usuario.setPassword(contraseña);
            usuario = ur.save(usuario);
        }
        return usuario;
    }
}
