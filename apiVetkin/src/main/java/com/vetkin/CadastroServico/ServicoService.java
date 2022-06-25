package com.vetkin.CadastroServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository rep;
		
	public Iterable<Servico> getCadastroServico(){
		return rep.findAll();
	}
	
	public Optional<Servico> getCadastroServicoPorId(Long id){
		return rep.findById(id);
	}
	
	public Servico save(Servico CadastroServico) {
		return rep.save(CadastroServico);
	}
	
	public Servico update(Servico CadastroServico, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<Servico> optional = getCadastroServicoPorId(id);
		if(optional.isPresent())
		{
			Servico bd = optional.get();
			bd.setNome(CadastroServico.getNome());
			bd.setStatus(CadastroServico.getStatus());
			bd.setValorCusto(CadastroServico.getValorCusto());
			bd.setValorVenda(CadastroServico.getValorVenda());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public String delete(Long id)
	{
		Optional<Servico> CadastroServico = getCadastroServicoPorId(id);
		if(CadastroServico.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else {
			return null;
		}
	}
}
