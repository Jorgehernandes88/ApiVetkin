package com.vetkin.Veterinario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class VeterinarioService {
	
	@Autowired
	private VeterinarioRepository rep;
		
	public Iterable<Veterinario> getVeterinario(){
		return rep.findAll();
	}
	
	public Optional<Veterinario> getVeterinarioPorId(Long id){
		return rep.findById(id);
	}
	
	public Veterinario save(Veterinario Veterinario) {
		return rep.save(Veterinario);
	}
	
	public Veterinario update(Veterinario Veterinario, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<Veterinario> optional = getVeterinarioPorId(id);
		if(optional.isPresent())
		{
			Veterinario bd = optional.get();
			bd.setNomeCompleto(Veterinario.getNomeCompleto());
			bd.setTelefone(Veterinario.getTelefone());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public void delete(Long id)
	{
		Optional<Veterinario> Veterinario = getVeterinarioPorId(id);
		if(Veterinario.isPresent())
		{
			rep.deleteById(id);
		}
	}
}
