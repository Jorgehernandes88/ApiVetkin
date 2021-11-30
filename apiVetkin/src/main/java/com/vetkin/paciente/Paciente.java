package com.vetkin.paciente;

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
@Table(name = "Paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_Paciente")
	private Long RecID_Paciente;
	
	private String nome;
	private String raca;
	private String Status;
	private String avatar;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="tutorCliente_RecID")
	private TutorCliente tutorCliente = new TutorCliente();
	
	public Paciente() {
		
	}

	public Paciente(Long recID_Paciente, String nome, String raca, String status, String avatar,
			TutorCliente tutorCliente) {
		super();
		RecID_Paciente = recID_Paciente;
		this.nome = nome;
		this.raca = raca;
		Status = status;
		this.avatar = avatar;
		this.tutorCliente = tutorCliente;
	}

	public Long getRecID_Paciente() {
		return RecID_Paciente;
	}

	public void setRecID_Paciente(Long recID_Paciente) {
		RecID_Paciente = recID_Paciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public TutorCliente getTutorCliente() {
		return tutorCliente;
	}

	public void setTutorCliente(TutorCliente tutorCliente) {
		this.tutorCliente = tutorCliente;
	}
}
