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
	private DecimalFormat valorCusto;
	private DecimalFormat valorVenda;
	private int quantidade;
	private String status;

	
	public CadastroExame () {
		
	}

	public CadastroExame(Long recID_CadastroExame, String nome, DecimalFormat valorCusto, DecimalFormat valorVenda,
			int quantidade, String status) {
		super();
		RecID_CadastroExame = recID_CadastroExame;
		this.nome = nome;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.quantidade = quantidade;
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

	public DecimalFormat getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(DecimalFormat valorCusto) {
		this.valorCusto = valorCusto;
	}

	public DecimalFormat getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(DecimalFormat valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
