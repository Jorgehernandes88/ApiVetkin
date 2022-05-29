package com.vetkin.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Optional<Usuario> findByLogin( String Login);	

}
