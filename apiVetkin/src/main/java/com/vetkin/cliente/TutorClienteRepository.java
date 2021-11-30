package com.vetkin.cliente;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TutorClienteRepository extends CrudRepository<TutorCliente, Long> {
	List<TutorCliente> findByCpf( String cpf);	
}
