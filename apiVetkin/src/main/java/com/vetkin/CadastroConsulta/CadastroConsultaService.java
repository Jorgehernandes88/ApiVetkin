package com.vetkin.CadastroConsulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class CadastroConsultaService {
	
	@Autowired
	private CadastroConsultaRepository rep;
		
	public Iterable<CadastroConsulta> getCadastroConsulta(){
		return rep.findAll();
	}
	
	public Optional<CadastroConsulta> getCadastroConsultaPorId(Long id){
		return rep.findById(id);
	}
	
	public CadastroConsulta save(CadastroConsulta CadastroConsulta) {
		return rep.save(CadastroConsulta);
	}
	
	public CadastroConsulta update(CadastroConsulta CadastroConsulta, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<CadastroConsulta> optional = getCadastroConsultaPorId(id);
		if(optional.isPresent())
		{
			CadastroConsulta bd = optional.get();
			bd.setNome(CadastroConsulta.getNome());
			bd.setComissaoSobLucro(CadastroConsulta.getComissaoSobLucro());
			bd.setStatus(CadastroConsulta.getStatus());
			bd.setValorCusto(CadastroConsulta.getValorCusto());
			bd.setValorVenda(CadastroConsulta.getValorVenda());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public void delete(Long id)
	{
		Optional<CadastroConsulta> CadastroConsulta = getCadastroConsultaPorId(id);
		if(CadastroConsulta.isPresent())
		{
			rep.deleteById(id);
		}
	}
}
