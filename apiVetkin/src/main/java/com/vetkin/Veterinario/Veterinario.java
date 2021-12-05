package com.vetkin.Veterinario;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vetkin.cliente.TutorCliente;

@Entity
@Table(name = "Veterinario")
public class Veterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_Veterinario")
	private Long RecID_Veterinario;
	
	private String nomeCompleto;
	private String telefone;
	
	public Veterinario () {
		
	}

	public Veterinario(Long recID_Veterinario, String nomeCompleto, String telefone) {
		super();
		RecID_Veterinario = recID_Veterinario;
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
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

}
