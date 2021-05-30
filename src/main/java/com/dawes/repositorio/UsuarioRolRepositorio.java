package com.dawes.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.dawes.modelo.RolesVO;
import com.dawes.modelo.UsuarioRolVO;

@Repository
public interface UsuarioRolRepositorio extends CrudRepository<UsuarioRolVO, Integer>{

}
