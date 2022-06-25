package com.vetkin.CadastroServico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Servico")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recID_Servico")
	private Long recID_Servico;
	
	private String nome;
	private Float valorCusto;
	private Float valorVenda;
	private String status;

	
	public Servico () {
		
	}

	public Servico(Long recID_Servico, String nome, Float valorCusto, Float valorVenda,
			String status) {
		super();
		this.recID_Servico = recID_Servico;
		this.nome = nome;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.status = status;
	}

	public Long getRecID_Servico() {
		return recID_Servico;
	}

	public void setRecID_CadastroExame(Long recID_Servico) {
		this.recID_Servico = recID_Servico;
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
