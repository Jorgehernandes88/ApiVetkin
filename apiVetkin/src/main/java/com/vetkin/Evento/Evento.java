package com.vetkin.Evento;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vetkin.ItensServico.ItensServico;
import com.vetkin.cliente.TutorCliente;
import com.vetkin.paciente.Paciente;

@Entity
@Table(name = "Evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_Evento")
	private Long RecID_Evento;
	
	private String dataDoEvento;
	private String descrição;
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="RecID_Evento_ItensServicos")
	private List<ItensServico> servico = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="RecID_Evento_Paciente")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="RecID_Evento_Tutor")
	private TutorCliente tutor;
	
	public Evento () {
		
	}

	public Evento(Long recID_Evento, String dataDoEvento, String descrição, String status, List<ItensServico> servico,
			Paciente paciente, TutorCliente tutor) {
		super();
		RecID_Evento = recID_Evento;
		this.dataDoEvento = dataDoEvento;
		this.descrição = descrição;
		this.status = status;
		this.servico = servico;
		this.paciente = paciente;
		this.tutor = tutor;
	}

	public Long getRecID_Evento() {
		return RecID_Evento;
	}

	public void setRecID_Evento(Long recID_Evento) {
		RecID_Evento = recID_Evento;
	}

	public String getDataDoEvento() {
		return dataDoEvento;
	}

	public void setDataDoEvento(String dataDoEvento) {
		this.dataDoEvento = dataDoEvento;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public List<ItensServico> getServico() {
		return servico;
	}

	public void setServico(List<ItensServico> servico) {
		this.servico = servico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public TutorCliente getTutor() {
		return tutor;
	}

	public void setTutor(TutorCliente tutor) {
		this.tutor = tutor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
