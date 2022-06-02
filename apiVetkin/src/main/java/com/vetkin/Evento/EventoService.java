package com.vetkin.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class EventoService {

	@Autowired
	private EventoRepository rep;

	public Iterable<Evento> getEvento() {
		return rep.findAll();
	}

	public Optional<Evento> getEventoPorId(Long id) {
		return rep.findById(id);
	}

	public Evento save(Evento Evento) {
		return rep.save(Evento);
	}

	public Evento update(Evento Evento, Long id) {

		Assert.notNull(id, "Não foi possivel atualizar o registro");

		Optional<Evento> optional = getEventoPorId(id);
		if (optional.isPresent()) {
			Evento bd = optional.get();
			// Copiar as propriedades
			bd.setDataDoEvento(Evento.getDataDoEvento());
			bd.setDescrição(Evento.getDescrição());
			bd.setPaciente(Evento.getPaciente());
			bd.setTutor(Evento.getTutor());
			bd.setServico(Evento.getServico());
			

			rep.save(bd);

			return bd;
		} else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
}
