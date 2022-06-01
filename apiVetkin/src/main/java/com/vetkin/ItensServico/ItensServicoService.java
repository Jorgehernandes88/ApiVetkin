package com.vetkin.ItensServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class ItensServicoService {
	
	@Autowired
	private ItensServicoRepository rep;
	
	public Iterable<ItensServico> getItensServico(){
		return rep.findAll();
	}
	
	public Optional<ItensServico> getItensServicoId(Long id){
		return rep.findById(id);
	}
	
	public ItensServico save(ItensServico ItensServico) {
        return rep.save(ItensServico);
	}
	
	public ItensServico update(ItensServico ItensServico, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		//Buscar o cliente no banco de dados
		Optional<ItensServico> optional = getItensServicoId(id);
		if(optional.isPresent())
		{
			ItensServico bd = optional.get();
			// Copiar as propriedades
			bd.setServicos(ItensServico.getServicos());
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
		Optional<ItensServico> cliente = getItensServicoId(id);
		if(cliente.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else {
			return null;
		}
		
	}
}
