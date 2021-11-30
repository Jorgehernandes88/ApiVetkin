package com.vetkin.usuario;

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
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_Usuario")
	private Long RecID_Usuario;
	
	private String Login;
	private String Senha;
	private String perfil;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="tutorCliente_RecID")
	private TutorCliente tutorCliente = new TutorCliente();

	public Usuario () {
		
	}

	public Usuario(Long recID_Usuario, String login, String senha, String perfil, TutorCliente tutorCliente) {
		super();
		RecID_Usuario = recID_Usuario;
		Login = login;
		Senha = senha;
		this.perfil = perfil;
		this.tutorCliente = tutorCliente;
	}

	public Long getRecID_Usuario() {
		return RecID_Usuario;
	}

	public void setRecID_Usuario(Long recID_Usuario) {
		RecID_Usuario = recID_Usuario;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public TutorCliente getTutorCliente() {
		return tutorCliente;
	}

	public void setTutorCliente(TutorCliente tutorCliente) {
		this.tutorCliente = tutorCliente;
	}
}
