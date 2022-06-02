package com.vetkin.Consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository rep;
	
	public Iterable<Consulta> getConsulta(){
		return rep.findAll();
	}
	
	public Optional<Consulta> getConsultaId(Long id){
		return rep.findById(id);
	}
	
	public Consulta save(Consulta Consulta) {
        return rep.save(Consulta);
	}
	
	public Consulta update(Consulta Consulta, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		//Buscar o cliente no banco de dados
		Optional<Consulta> optional = getConsultaId(id);
		if(optional.isPresent())
		{
			Consulta bd = optional.get();
			// Copiar as propriedades
			bd.setAnaminese(Consulta.getAnaminese());
			bd.setStatus(Consulta.getStatus());
			bd.setDataInicio(Consulta.getDataInicio());
			bd.setDataFim(Consulta.getDataFim());
			bd.setDataDoAgendamento(Consulta.getDataDoAgendamento());
			bd.setDetalhamento(Consulta.getDetalhamento());
			bd.setValorTotal(Consulta.getValorTotal());
			bd.setTipoDePagamento(Consulta.getTipoDePagamento());
			
			bd.setPaciente(Consulta.getPaciente());
			bd.setTutor(Consulta.getTutor());
			bd.setVeterinario(Consulta.getVeterinario());
			bd.setExames(Consulta.getExames());
			bd.setProdutos(Consulta.getProdutos());
			bd.setServico(Consulta.getServico());
			bd.setImgConsultas(Consulta.getImgConsultas());
			
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
		Optional<Consulta> consulta = getConsultaId(id);
		if(consulta.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else {
			return null;
		}
		
	}
}
