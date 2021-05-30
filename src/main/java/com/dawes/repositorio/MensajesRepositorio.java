package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.MensajesVO;

@Repository
public interface MensajesRepositorio extends CrudRepository<MensajesVO, Integer>{

}
