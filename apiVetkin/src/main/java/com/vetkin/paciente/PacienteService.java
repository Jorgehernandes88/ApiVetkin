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
			bd.setNome(Paciente.getNome());
			bd.setEspecie(Paciente.getEspecie());
			bd.setDataNacimento(Paciente.getDataNacimento());
			bd.setRaca(Paciente.getRaca());
			bd.setRacaSecundaria(Paciente.getRacaSecundaria());
			bd.setPorte(Paciente.getPorte());
			bd.setAlergias(Paciente.getAlergias());
			bd.setObservacoes(Paciente.getObservacoes());
			bd.setSexo(Paciente.getSexo());
			bd.setAgressivo(Paciente.getAgressivo());
			bd.setStatus(Paciente.getStatus());
			bd.setAptoAReproducao(Paciente.getAptoAReproducao());
			bd.setPedigree(Paciente.getPedigree());
			bd.setMicrochip(Paciente.getMicrochip());
			bd.setAvatar(Paciente.getAvatar());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public String delete(Long id)
	{
		Optional<Paciente> cliente = getPacientePorId(id);
		if(cliente.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else
		{
			return null;
		}
	}
}
