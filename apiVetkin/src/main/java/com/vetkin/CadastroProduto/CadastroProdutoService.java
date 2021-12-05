package com.vetkin.CadastroProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class CadastroProdutoService {
	
	@Autowired
	private CadastroProdutoRepository rep;
		
	public Iterable<CadastroProduto> getCadastroProduto(){
		return rep.findAll();
	}
	
	public Optional<CadastroProduto> getCadastroProdutoPorId(Long id){
		return rep.findById(id);
	}
	
	public CadastroProduto save(CadastroProduto CadastroProduto) {
		return rep.save(CadastroProduto);
	}
	
	public CadastroProduto update(CadastroProduto CadastroProduto, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<CadastroProduto> optional = getCadastroProdutoPorId(id);
		if(optional.isPresent())
		{
			CadastroProduto bd = optional.get();
			bd.setNome(CadastroProduto.getNome());
			bd.setQuantidadeAtual(CadastroProduto.getQuantidadeAtual());
		    bd.setQuantidadeMinima(CadastroProduto.getQuantidadeMinima());
		    bd.setStatus(CadastroProduto.getStatus());
		    bd.setValorCusto(CadastroProduto.getValorCusto());
		    bd.setValorVenda(CadastroProduto.getValorVenda());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public void delete(Long id)
	{
		Optional<CadastroProduto> CadastroExame = getCadastroProdutoPorId(id);
		if(CadastroExame.isPresent())
		{
			rep.deleteById(id);
		}
	}
}
