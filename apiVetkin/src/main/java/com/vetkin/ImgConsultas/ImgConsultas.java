package com.vetkin.ImgConsultas;

import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ImgConsultas")
public class ImgConsultas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_ImgConsultas")
	private Long ImgConsultas;
	
	private Blob imagem;
	private String descrição;

	public ImgConsultas () {
		
	}

	public ImgConsultas(Long imgConsultas, Blob imagem, String descrição) {
		super();
		ImgConsultas = imgConsultas;
		this.imagem = imagem;
		this.descrição = descrição;
	}

	public Long getImgConsultas() {
		return ImgConsultas;
	}

	public void setImgConsultas(Long imgConsultas) {
		ImgConsultas = imgConsultas;
	}

	public Blob getImagem() {
		return imagem;
	}

	public void setImagem(Blob imagem) {
		this.imagem = imagem;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

}
