package com.vetkin.Fornecedor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_Fornecedor")
	private Long RecID_Fornecedor;
	
	private String empresa;
	private String nome;
	private String cnpj;
	private String inscricaoEstadual;
	private String contato;
	private String score;
	
	
	public Fornecedor () {
		
	}

	public Fornecedor(Long recID_Fornecedor, String empresa, String nome, String cnpj, String inscricaoEstadual,
			String contato, String score) {
		super();
		RecID_Fornecedor = recID_Fornecedor;
		this.empresa = empresa;
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.contato = contato;
		this.score = score;
	}

	public Long getRecID_Fornecedor() {
		return RecID_Fornecedor;
	}

	public void setRecID_Fornecedor(Long recID_Fornecedor) {
		RecID_Fornecedor = recID_Fornecedor;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
}
