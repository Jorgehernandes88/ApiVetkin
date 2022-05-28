package com.vetkin.Veterinario;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Veterinario")
public class Veterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_Veterinario")
	private Long RecID_Veterinario;
	
	private String nomeCompleto;
	private String especialidade;
	private String telefone;
	private String observacao;
	private String status;
	private String avatar;
	
	public Veterinario () {
		
	}

	public Veterinario(Long recID_Veterinario, String nomeCompleto, String especialidade, String telefone,
			String observacao, String status, String avatar) {
		super();
		RecID_Veterinario = recID_Veterinario;
		this.nomeCompleto = nomeCompleto;
		this.especialidade = especialidade;
		this.telefone = telefone;
		this.observacao = observacao;
		this.status = status;
		this.avatar = avatar;
	}



	public Long getRecID_Veterinario() {
		return RecID_Veterinario;
	}

	public void setRecID_Veterinario(Long recID_Veterinario) {
		RecID_Veterinario = recID_Veterinario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
