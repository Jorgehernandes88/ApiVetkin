package com.vetkin.CadastroServico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CadastroServico")
public class CadastroServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_CadastroServico")
	private Long RecID_CadastroServico;
	
	private String nome;
	private Float valorCusto;
	private Float valorVenda;
	private String status;

	
	public CadastroServico () {
		
	}

	public CadastroServico(Long recID_CadastroServico, String nome, Float valorCusto, Float valorVenda,
			String status) {
		super();
		RecID_CadastroServico = recID_CadastroServico;
		this.nome = nome;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.status = status;
	}

	public Long getRecID_CadastroExame() {
		return RecID_CadastroServico;
	}

	public void setRecID_CadastroExame(Long recID_CadastroServico) {
		RecID_CadastroServico = recID_CadastroServico;
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
