package com.vetkin.CadastroConsulta;

import java.text.DecimalFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CadastroConsulta")
public class CadastroConsulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_CadastroConsulta")
	private Long RecID_CadastroConsulta;
	
	private String nome;
	private DecimalFormat valorCusto;
	private DecimalFormat valorVenda;
	private DecimalFormat comissaoSobLucro;
	private String status;

	
	public CadastroConsulta () {
		
	}

	public CadastroConsulta(Long recID_CadastroConsulta, String nome, DecimalFormat valorCusto, DecimalFormat valorVenda,
			DecimalFormat comissaoSobLucro, String status) {
		super();
		RecID_CadastroConsulta = recID_CadastroConsulta;
		this.nome = nome;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.comissaoSobLucro = comissaoSobLucro;
		this.status = status;
	}

	public Long getRecID_CadastroExame() {
		return RecID_CadastroConsulta;
	}

	public void setRecID_CadastroExame(Long recID_CadastroConsulta) {
		RecID_CadastroConsulta = recID_CadastroConsulta;
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

	public DecimalFormat getComissaoSobLucro() {
		return comissaoSobLucro;
	}

	public void setComissaoSobLucro(DecimalFormat comissaoSobLucro) {
		this.comissaoSobLucro = comissaoSobLucro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
