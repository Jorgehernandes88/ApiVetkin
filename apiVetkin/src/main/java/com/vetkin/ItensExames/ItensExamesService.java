package com.vetkin.ItensExames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class ItensExamesService {
	
	@Autowired
	private ItensExamesRepository rep;
	
	public Iterable<ItensExames> getConsulta_Exames(){
		return rep.findAll();
	}
	
	public Optional<ItensExames> getConsulta_ExamesById(Long id){
		return rep.findById(id);
	}
	
	public ItensExames save(ItensExames Consulta_Exames) {
        return rep.save(Consulta_Exames);
	}
	
	public ItensExames update(ItensExames Consulta_Exames, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		//Buscar o cliente no banco de dados
		Optional<ItensExames> optional = getConsulta_ExamesById(id);
		if(optional.isPresent())
		{
			ItensExames bd = optional.get();
			// Copiar as propriedades
			bd.setExames(Consulta_Exames.getExames());
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
		Optional<ItensExames> cliente = getConsulta_ExamesById(id);
		if(cliente.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else {
			return null;
		}
		
	}
}
