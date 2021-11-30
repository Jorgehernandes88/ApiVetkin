package com.vetkin.cliente;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

@Service
public class TutorClienteService {
	
	@Autowired
	private TutorClienteRepository rep;
		
	public Iterable<TutorCliente> getClientes(){
		return rep.findAll();
	}
	
	public Optional<TutorCliente> getClienteById(Long id){
		return rep.findById(id);
	}
	
	public List<TutorCliente> getClientesByCpf(String cpf){
		return rep.findByCpf(cpf);
	}

	public TutorCliente save(TutorCliente TutorCliente) {
		return rep.save(TutorCliente);
	}
	
	public TutorCliente update(TutorCliente TutorCliente, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		//Buscar o cliente no banco de dados
		Optional<TutorCliente> optional = getClienteById(id);
		if(optional.isPresent())
		{
			TutorCliente bd = optional.get();
			// Copiar as propriedades
			bd.setNomeCompleto(TutorCliente.getNomeCompleto());
			//bd.setSobreNome(cliente.getSobreNome());
			
			//Atualizar o registro
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public void delete(Long id)
	{
		//Buscar o cliente no banco de dados
		Optional<TutorCliente> cliente = getClienteById(id);
		if(cliente.isPresent())
		{
			rep.deleteById(id);
		}
		
	}
	
}
