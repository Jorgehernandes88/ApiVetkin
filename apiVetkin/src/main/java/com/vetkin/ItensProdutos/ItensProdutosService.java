package com.vetkin.ItensProdutos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class ItensProdutosService {
	
	@Autowired
	private ItensProdutosRepository rep;
	
	public Iterable<ItensProdutos> getItensProdutos(){
		return rep.findAll();
	}
	
	public Optional<ItensProdutos> getItensProdutosId(Long id){
		return rep.findById(id);
	}
	
	public ItensProdutos save(ItensProdutos ItensProdutos) {
        return rep.save(ItensProdutos);
	}
	
	public ItensProdutos update(ItensProdutos ItensProdutos, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		//Buscar o cliente no banco de dados
		Optional<ItensProdutos> optional = getItensProdutosId(id);
		if(optional.isPresent())
		{
			ItensProdutos bd = optional.get();
			// Copiar as propriedades
			bd.setproduto(ItensProdutos.getproduto());
			//Atualizar o registro
			rep.save(bd);

			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public String delete(Long id)
	{
		//Buscar o cliente no banco de dados
		Optional<ItensProdutos> cliente = getItensProdutosId(id);
		if(cliente.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else {
			return null;
		}
		
	}
}
