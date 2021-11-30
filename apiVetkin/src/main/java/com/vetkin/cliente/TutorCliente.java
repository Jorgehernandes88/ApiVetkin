package com.vetkin.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TutorCliente")
public class TutorCliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_TutorCliente")
	private Long RecID_TutorCliente;
	
	private String nomeCompleto;
	private String email;
	private String cpf;
	private String profissao;
	private String telefone;
	private String receberAvisos;
	private String avatar;
	
	public TutorCliente()
	{
		
	}

	public TutorCliente(Long recID_TutorCliente, String nomeCompleto, String email, String cpf, String profissao,
			String telefone, String receberAvisos, String avatar) {
		super();
		RecID_TutorCliente = recID_TutorCliente;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.cpf = cpf;
		this.profissao = profissao;
		this.telefone = telefone;
		this.receberAvisos = receberAvisos;
		this.avatar = avatar;
	}

	public Long getRecID_TutorCliente() {
		return RecID_TutorCliente;
	}

	public void setRecID_TutorCliente(Long recID_TutorCliente) {
		RecID_TutorCliente = recID_TutorCliente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getReceberAvisos() {
		return receberAvisos;
	}

	public void setReceberAvisos(String receberAvisos) {
		this.receberAvisos = receberAvisos;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
