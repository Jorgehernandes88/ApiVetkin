package com.vetkin.CadastroExame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository rep;
		
	public Iterable<Exame> getCadastroExame(){
		return rep.findAll();
	}
	
	public Optional<Exame> getCadastroExamePorId(Long id){
		return rep.findById(id);
	}
	
	public Exame save(Exame CadastroExame) {
		return rep.save(CadastroExame);
	}
	
	public Exame update(Exame CadastroExame, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<Exame> optional = getCadastroExamePorId(id);
		if(optional.isPresent())
		{
			Exame bd = optional.get();
			bd.setNome(CadastroExame.getNome());
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
		Optional<Exame> CadastroExame = getCadastroExamePorId(id);
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
