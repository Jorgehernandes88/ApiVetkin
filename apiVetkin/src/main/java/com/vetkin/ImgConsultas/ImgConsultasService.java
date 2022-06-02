package com.vetkin.ImgConsultas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class ImgConsultasService {

	@Autowired
	private ImgConsultasRepository rep;

	public Iterable<ImgConsultas> getImgConsultas() {
		return rep.findAll();
	}

	public Optional<ImgConsultas> getImgConsultasPorId(Long id) {
		return rep.findById(id);
	}

	public ImgConsultas save(ImgConsultas ImgConsultas) {
		return rep.save(ImgConsultas);
	}

	public ImgConsultas update(ImgConsultas ImgConsultas, Long id) {

		Assert.notNull(id, "Não foi possivel atualizar o registro");

		Optional<ImgConsultas> optional = getImgConsultasPorId(id);
		if (optional.isPresent()) {
			ImgConsultas bd = optional.get();
			// Copiar as propriedades
			bd.setImagem(ImgConsultas.getImagem());
			bd.setDescrição(ImgConsultas.getDescrição());

			rep.save(bd);

			return bd;
		} else {
			throw new RuntimeException("Não foi possivel atualizar o registro");
		}
	}
}
