package com.vetkin.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Optional;

@Service
public class TutorClienteService {
	
	@Autowired
	private TutorClienteRepository rep;
	
	public Iterable<TutorCliente> getTutorClientes(){
		return rep.findAll();
	}
	
	public Optional<TutorCliente> getTutorClienteById(Long id){
		return rep.findById(id);
	}
	
	public List<TutorCliente> getTutorClientesByCpf(String cpf){
		return rep.findByCpf(cpf);
	}

	public TutorCliente save(TutorCliente TutorCliente) {
				
        List<TutorCliente> tutores = getTutorClientesByCpf(TutorCliente.getCpf());

        if (tutores.isEmpty()) {
            return rep.save(TutorCliente);
        } else {
            return null;
        }
	}
	
	public TutorCliente update(TutorCliente TutorCliente, Long id) {
		
		Assert.notNull(id,"Não foi possivel atualizar o registro");
		//Buscar o cliente no banco de dados
		Optional<TutorCliente> optional = getTutorClienteById(id);
		if(optional.isPresent())
		{
			TutorCliente bd = optional.get();
			// Copiar as propriedades
			bd.setNomeCompleto(TutorCliente.getNomeCompleto());
			bd.setEmail(TutorCliente.getEmail());
			bd.setProfissao(TutorCliente.getProfissao());
			bd.setTelefone(TutorCliente.getTelefone());
			bd.setReceberAvisos(TutorCliente.getReceberAvisos());
			bd.setAvatar(TutorCliente.getAvatar());
			bd.setEndereco(TutorCliente.getEndereco());
			bd.setPaciente(TutorCliente.getPaciente());
						
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
		Optional<TutorCliente> cliente = getTutorClienteById(id);
		if(cliente.isPresent())
		{
			rep.deleteById(id);
			return "OK";
		}else {
			return null;
		}
		
	}
}
