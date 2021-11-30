package com.vetkin.endereco;

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
@Table(name = "Endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_Endereco")
	private Long RecID_Endereco;
	
	private String cep;
	private String endereco;
	private String numero;
	private String complemento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="tutorCliente_RecID")
	private TutorCliente tutorCliente = new TutorCliente();
	
	public Endereco() {
		
	}

	public Endereco(Long recID_Endereco, String cep, String endereco, String numero, String complemento,
			TutorCliente tutorCliente) {
		super();
		RecID_Endereco = recID_Endereco;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.tutorCliente = tutorCliente;
	}

	public Long getRecID_Endereco() {
		return RecID_Endereco;
	}

	public void setRecID_Endereco(Long recID_Endereco) {
		RecID_Endereco = recID_Endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public TutorCliente getTutorCliente() {
		return tutorCliente;
	}

	public void setTutorCliente(TutorCliente tutorCliente) {
		this.tutorCliente = tutorCliente;
	}

}
