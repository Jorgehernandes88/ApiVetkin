package com.vetkin.CadastroExame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exame")
public class Exame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recID_Exame")
	private Long recID_Exame;
	
	private String nome;
	private Float valorCusto;
	private Float valorVenda;
	private String status;

	
	public Exame () {
		
	}

	public Exame(Long recID_Exame, String nome, Float valorCusto, Float valorVenda,
			String status) {
		super();
		this.recID_Exame = recID_Exame;
		this.nome = nome;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.status = status;
	}

	public Long getRecID_Exame() {
		return recID_Exame;
	}

	public void setRecID_Exame(Long recID_CadastroExame) {
		recID_Exame = recID_CadastroExame;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Float valorCusto) {
		this.valorCusto = valorCusto;
	}

	public Float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Float valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
