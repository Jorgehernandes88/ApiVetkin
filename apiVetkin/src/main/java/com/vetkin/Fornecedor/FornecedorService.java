package com.vetkin.Fornecedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository rep;
		
	public Iterable<Fornecedor> getFornecedor(){
		return rep.findAll();
	}
	
	public Optional<Fornecedor> getFornecedorPorId(Long id){
		return rep.findById(id);
	}
	
	public Fornecedor save(Fornecedor Fornecedor) {
		return rep.save(Fornecedor);
	}
	
	public Fornecedor update(Fornecedor Fornecedor, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		
		Optional<Fornecedor> optional = getFornecedorPorId(id);
		if(optional.isPresent())
		{
			Fornecedor bd = optional.get();
			bd.setNome(Fornecedor.getNome());
			bd.setEmpresa(Fornecedor.getEmpresa());
			bd.setContato(Fornecedor.getContato());
			bd.setScore(Fornecedor.getScore());
			
			rep.save(bd);
			
			return bd;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
	
	public void delete(Long id)
	{
		Optional<Fornecedor> Fornecedor = getFornecedorPorId(id);
		if(Fornecedor.isPresent())
		{
			rep.deleteById(id);
		}
	}
}
