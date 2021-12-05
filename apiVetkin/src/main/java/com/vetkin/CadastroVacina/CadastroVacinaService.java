package com.vetkin.CadastroVacina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class CadastroVacinaService {
	
	@Autowired
	private CadastroVacinaRepository rep;
		
	public Iterable<CadastroVacina> getCadastroVacina(){
		return rep.findAll();
	}
	
	public Optional<CadastroVacina> getCadastroVacinaPorId(Long id){
		return rep.findById(id);
	}
	
	public CadastroVacina save(CadastroVacina CadastroVacina) {
		return rep.save(CadastroVacina);
	}
	
	public CadastroVacina update(CadastroVacina CadastroVacina, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<CadastroVacina> optional = getCadastroVacinaPorId(id);
		if(optional.isPresent())
		{
			CadastroVacina bd = optional.get();
			bd.setNome(CadastroVacina.getNome());
			bd.setComissaoSobLucro(CadastroVacina.getComissaoSobLucro());
			bd.setQuantidadeAtual(CadastroVacina.getQuantidadeAtual());
			bd.setQuantidadeMinima(CadastroVacina.getQuantidadeMinima());
			bd.setStatus(CadastroVacina.getStatus());
			bd.setValorCusto(CadastroVacina.getValorCusto());
			bd.setValorVenda(CadastroVacina.getValorVenda());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public void delete(Long id)
	{
		Optional<CadastroVacina> CadastroConsulta = getCadastroVacinaPorId(id);
		if(CadastroConsulta.isPresent())
		{
			rep.deleteById(id);
		}
	}
}
