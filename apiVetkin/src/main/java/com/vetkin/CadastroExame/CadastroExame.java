package com.vetkin.CadastroExame;

import java.text.DecimalFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CadastroExame")
public class CadastroExame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_CadastroExame")
	private Long RecID_CadastroExame;
	
	private String nome;
	private Float valorCusto;
	private Float valorVenda;
	private String status;

	
	public CadastroExame () {
		
	}

	public CadastroExame(Long recID_CadastroExame, String nome, Float valorCusto, Float valorVenda,
			String status) {
		super();
		RecID_CadastroExame = recID_CadastroExame;
		this.nome = nome;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.status = status;
	}

	public Long getRecID_CadastroExame() {
		return RecID_CadastroExame;
	}

	public void setRecID_CadastroExame(Long recID_CadastroExame) {
		RecID_CadastroExame = recID_CadastroExame;
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
