package com.vetkin.CadastroVacina;

import java.text.DecimalFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CadastroVacina")
public class CadastroVacina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_CadastroVacina")
	private Long RecID_CadastroVacina;
	
	private String nome;
	private int quantidadeMinima;
	private int quantidadeAtual;
	private Float valorCusto;
	private Float valorVenda;
	private Float comissaoSobLucro;
	private String status;
	
	public CadastroVacina() {
		
	}
	
	public CadastroVacina(Long recID_CadastroVacina, String nome, int quantidadeMinima, int quantidadeAtual,
			Float valorCusto, Float valorVenda, Float comissaoSobLucro, String status) {
		super();
		RecID_CadastroVacina = recID_CadastroVacina;
		this.nome = nome;
		this.quantidadeMinima = quantidadeMinima;
		this.quantidadeAtual = quantidadeAtual;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.comissaoSobLucro = comissaoSobLucro;
		this.status = status;
	}

	public Long getRecID_CadastroVacina() {
		return RecID_CadastroVacina;
	}

	public void setRecID_CadastroVacina(Long recID_CadastroVacina) {
		RecID_CadastroVacina = recID_CadastroVacina;
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

	public Float getComissaoSobLucro() {
		return comissaoSobLucro;
	}

	public void setComissaoSobLucro(Float comissaoSobLucro) {
		this.comissaoSobLucro = comissaoSobLucro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
