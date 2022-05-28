package com.vetkin.CadastroProduto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vetkin.Fornecedor.Fornecedor;

@Entity
@Table(name = "CadastroProduto")
public class CadastroProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_CadastroProduto")
	private Long RecID_CadastroProduto;
	
	private String nome;
	private String marca;
	private String validade;
	private int quantidadeMinima;
	private int quantidadeAtual;
	private Float valorCusto;
	private Float valorVenda;
	private Float margemLucro;
	private Float comissao;
	private String comissaoSobreLucro;
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="RecID_Fornecedor")
	private Fornecedor fornecedor;
	
	public CadastroProduto () {
		
	}

	public Long getRecID_CadastroProduto() {
		return RecID_CadastroProduto;
	}

	public CadastroProduto(Long recID_CadastroProduto, String nome, String marca, String validade, int quantidadeMinima,
			int quantidadeAtual, Float valorCusto, Float valorVenda, Float margemLucro, Float comissao,
			String comissaoSobreLucro, String status, Fornecedor fornecedor) {
		super();
		RecID_CadastroProduto = recID_CadastroProduto;
		this.nome = nome;
		this.marca = marca;
		this.validade = validade;
		this.quantidadeMinima = quantidadeMinima;
		this.quantidadeAtual = quantidadeAtual;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.margemLucro = margemLucro;
		this.comissao = comissao;
		this.comissaoSobreLucro = comissaoSobreLucro;
		this.status = status;
		this.fornecedor = fornecedor;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public Float getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(Float margemLucro) {
		this.margemLucro = margemLucro;
	}

	public Float getComissao() {
		return comissao;
	}

	public void setComissao(Float comissao) {
		this.comissao = comissao;
	}

	public String getComissaoSobreLucro() {
		return comissaoSobreLucro;
	}

	public void setComissaoSobreLucro(String comissaoSobreLucro) {
		this.comissaoSobreLucro = comissaoSobreLucro;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
