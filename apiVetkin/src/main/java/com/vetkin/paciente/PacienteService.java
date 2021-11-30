package com.vetkin.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository rep;
		
	public Iterable<Paciente> getPaciente(){
		return rep.findAll();
	}
	
	public Optional<Paciente> getPacientePorId(Long id){
		return rep.findById(id);
	}
	
	public Paciente save(Paciente Paciente) {
		return rep.save(Paciente);
	}
	
	public Paciente update(Paciente Paciente, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<Paciente> optional = getPacientePorId(id);
		if(optional.isPresent())
		{
			Paciente bd = optional.get();
			// Copiar as propriedades
			bd.setAvatar(Paciente.getAvatar());
			bd.setNome(Paciente.getNome());
			bd.setRaca(Paciente.getRaca());
			bd.setStatus(Paciente.getStatus());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public void delete(Long id)
	{
		Optional<Paciente> cliente = getPacientePorId(id);
		if(cliente.isPresent())
		{
			rep.deleteById(id);
		}
	}
}
