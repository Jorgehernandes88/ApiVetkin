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
	private String especie;
	private String dataNacimento;
	private String raca;
	private String racaSecundaria;
	private String porte;
	private String alergias;
	private String observacoes;
	private String sexo;
	private String agressivo;
	private String status;
	private String aptoAReproducao;
	private String pedigree;
	private String microchip;
	private String avatar;
	
	
	public Paciente() {
		
	}

	public Paciente(Long recID_Paciente, String nome, String especie, String dataNacimento, String raca,
			String racaSecundaria, String porte, String alergias, String observacoes, String sexo, String agressivo,
			String status, String aptoAReproducao, String pedigree, String microchip, String avatar) {
		super();
		RecID_Paciente = recID_Paciente;
		this.nome = nome;
		this.especie = especie;
		this.dataNacimento = dataNacimento;
		this.raca = raca;
		this.racaSecundaria = racaSecundaria;
		this.porte = porte;
		this.alergias = alergias;
		this.observacoes = observacoes;
		this.sexo = sexo;
		this.agressivo = agressivo;
		this.status = status;
		this.aptoAReproducao = aptoAReproducao;
		this.pedigree = pedigree;
		this.microchip = microchip;
		this.avatar = avatar;
	}

	public Long getRecID_Paciente() {
		return RecID_Paciente;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(String dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public String getRacaSecundaria() {
		return racaSecundaria;
	}

	public void setRacaSecundaria(String racaSecundaria) {
		this.racaSecundaria = racaSecundaria;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getAgressivo() {
		return agressivo;
	}

	public void setAgressivo(String agressivo) {
		this.agressivo = agressivo;
	}

	public String getAptoAReproducao() {
		return aptoAReproducao;
	}

	public void setAptoAReproducao(String aptoAReproducao) {
		this.aptoAReproducao = aptoAReproducao;
	}

	public String getPedigree() {
		return pedigree;
	}

	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}

	public String getMicrochip() {
		return microchip;
	}

	public void setMicrochip(String microchip) {
		this.microchip = microchip;
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
