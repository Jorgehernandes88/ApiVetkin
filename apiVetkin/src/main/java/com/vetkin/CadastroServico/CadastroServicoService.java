package com.vetkin.CadastroServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class CadastroServicoService {
	
	@Autowired
	private CadastroServicoRepository rep;
		
	public Iterable<CadastroServico> getCadastroServico(){
		return rep.findAll();
	}
	
	public Optional<CadastroServico> getCadastroServicoPorId(Long id){
		return rep.findById(id);
	}
	
	public CadastroServico save(CadastroServico CadastroServico) {
		return rep.save(CadastroServico);
	}
	
	public CadastroServico update(CadastroServico CadastroServico, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<CadastroServico> optional = getCadastroServicoPorId(id);
		if(optional.isPresent())
		{
			CadastroServico bd = optional.get();
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
		Optional<CadastroServico> CadastroServico = getCadastroServicoPorId(id);
		if(CadastroServico.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else {
			return null;
		}
	}
}
