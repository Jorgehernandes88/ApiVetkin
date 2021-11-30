package com.vetkin.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository rep;
		
	public Iterable<Endereco> getEndereco(){
		return rep.findAll();
	}
	
	public Optional<Endereco> getEnderecoPorId(Long id){
		return rep.findById(id);
	}
	
	public Endereco save(Endereco Endereco) {
		return rep.save(Endereco);
	}
	
	public Endereco update(Endereco Endereco, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<Endereco> optional = getEnderecoPorId(id);
		if(optional.isPresent())
		{
			Endereco bd = optional.get();
			// Copiar as propriedades
			bd.setCep(Endereco.getCep());
			bd.setEndereco(Endereco.getEndereco());
			bd.setNumero(Endereco.getNumero());
			bd.setComplemento(Endereco.getComplemento());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public void delete(Long id)
	{
		Optional<Endereco> cliente = getEnderecoPorId(id);
		if(cliente.isPresent())
		{
			rep.deleteById(id);
		}
	}
}
