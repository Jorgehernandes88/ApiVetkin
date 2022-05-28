package com.vetkin.Veterinario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.rmi.activation.Activatable;
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
			bd.setEspecialidade(Veterinario.getEspecialidade());
			bd.setObservacao(Veterinario.getObservacao());
			bd.setStatus(Veterinario.getStatus());
			bd.setAvatar(Veterinario.getAvatar());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public String delete(Long id)
	{
		Optional<Veterinario> Veterinario = getVeterinarioPorId(id);
		if(Veterinario.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else {
			return null;
		}
	}
}
