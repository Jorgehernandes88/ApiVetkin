package com.vetkin.CadastroProduto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CadastroProduto")
public class CadastroProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_CadastroProduto")
	private Long RecID_CadastroProduto;
	
	private String nome;
	private int quantidadeMinima;
	private int quantidadeAtual;
	private Float valorCusto;
	private Float valorVenda;
	private String status;

	
	public CadastroProduto () {
		
	}


	public CadastroProduto(Long recID_CadastroProduto, String nome, int quantidadeMinima, int quantidadeAtual,
			Float valorCusto, Float valorVenda, String status) {
		super();
		RecID_CadastroProduto = recID_CadastroProduto;
		this.nome = nome;
		this.quantidadeMinima = quantidadeMinima;
		this.quantidadeAtual = quantidadeAtual;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.status = status;
	}


	public Long getRecID_CadastroProduto() {
		return RecID_CadastroProduto;
	}


	public void setRecID_CadastroProduto(Long recID_CadastroProduto) {
		RecID_CadastroProduto = recID_CadastroProduto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}


	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}


	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}


	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
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
