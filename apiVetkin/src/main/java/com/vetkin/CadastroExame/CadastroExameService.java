package com.vetkin.CadastroExame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class CadastroExameService {
	
	@Autowired
	private CadastroExameRepository rep;
		
	public Iterable<CadastroExame> getCadastroExame(){
		return rep.findAll();
	}
	
	public Optional<CadastroExame> getCadastroExamePorId(Long id){
		return rep.findById(id);
	}
	
	public CadastroExame save(CadastroExame CadastroExame) {
		return rep.save(CadastroExame);
	}
	
	public CadastroExame update(CadastroExame CadastroExame, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<CadastroExame> optional = getCadastroExamePorId(id);
		if(optional.isPresent())
		{
			CadastroExame bd = optional.get();
			bd.setNome(CadastroExame.getNome());
			bd.setQuantidade(CadastroExame.getQuantidade());
			bd.setStatus(CadastroExame.getStatus());
			bd.setValorCusto(CadastroExame.getValorCusto());
			bd.setValorVenda(CadastroExame.getValorVenda());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public String delete(Long id)
	{
		Optional<CadastroExame> CadastroExame = getCadastroExamePorId(id);
		if(CadastroExame.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else
		{
			return null;
		}
	}
}
