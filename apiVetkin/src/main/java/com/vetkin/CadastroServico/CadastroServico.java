package com.vetkin.CadastroServico;

import java.text.DecimalFormat;
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
	private DecimalFormat valorCusto;
	private DecimalFormat valorVenda;
	private int quantidade;
	private String status;

	
	public CadastroServico () {
		
	}

	public CadastroServico(Long recID_CadastroServico, String nome, DecimalFormat valorCusto, DecimalFormat valorVenda,
			int quantidade, String status) {
		super();
		RecID_CadastroServico = recID_CadastroServico;
		this.nome = nome;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.quantidade = quantidade;
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
