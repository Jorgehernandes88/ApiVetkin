package com.vetkin.Consulta;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vetkin.ImgConsultas.ImgConsultas;
import com.vetkin.ItensExames.ItensExames;
import com.vetkin.ItensProdutos.ItensProdutos;
import com.vetkin.ItensServico.ItensServico;
import com.vetkin.Veterinario.Veterinario;
import com.vetkin.cliente.TutorCliente;
import com.vetkin.paciente.Paciente;


@Entity
@Table(name = "Consultas")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_Consulta")
	private Long RecID_Consulta;
	 
	private String status;
	private String dataInicio;
	private String dataFim;
	private String dataDoAgendamento;
	private String anaminese;
	private String detalhamento;
	private Float valorTotal;
	private String tipoDePagamento;

	@OneToOne
	@JoinColumn(name="RecID_Paciente")
	private Paciente paciente;
	
	@OneToOne
	@JoinColumn(name="RecID_TutorCliente")
	private TutorCliente tutor;
	
	@OneToOne
	@JoinColumn(name="RecID_Veterinario")
	private Veterinario veterinario;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="RecID_Consulta_ItensExames")
	private List<ItensExames> exames = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="RecID_Consulta_ItensProdutos")
	private List<ItensProdutos> produtos = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="RecID_Consulta_ItensServicos")
	private List<ItensServico> servico = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="RecID_Consulta_ImgConsultas")
	private List<ImgConsultas> imgConsultas = new ArrayList<>();

	public Consulta()
	{
		
	}

	public Consulta(Long recID_Consulta, String status, String dataInicio, String dataFim, String dataDoAgendamento,
			String anaminese, String detalhamento, Float valorTotal, String tipoDePagamento, Paciente paciente,
			TutorCliente tutor, Veterinario veterinario, List<ItensExames> exames, List<ItensProdutos> produtos,
			List<ItensServico> servico, List<ImgConsultas> imgConsultas) {
		super();
		RecID_Consulta = recID_Consulta;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.dataDoAgendamento = dataDoAgendamento;
		this.anaminese = anaminese;
		this.detalhamento = detalhamento;
		this.valorTotal = valorTotal;
		this.tipoDePagamento = tipoDePagamento;
		this.paciente = paciente;
		this.tutor = tutor;
		this.veterinario = veterinario;
		this.exames = exames;
		this.produtos = produtos;
		this.servico = servico;
		this.imgConsultas = imgConsultas;
	}

	public Long getRecID_Consulta() {
		return RecID_Consulta;
	}

	public void setRecID_Consulta(Long recID_Consulta) {
		RecID_Consulta = recID_Consulta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getDataDoAgendamento() {
		return dataDoAgendamento;
	}

	public void setDataDoAgendamento(String dataDoAgendamento) {
		this.dataDoAgendamento = dataDoAgendamento;
	}

	public String getAnaminese() {
		return anaminese;
	}

	public void setAnaminese(String anaminese) {
		this.anaminese = anaminese;
	}

	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTipoDePagamento() {
		return tipoDePagamento;
	}

	public void setTipoDePagamento(String tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
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

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}


	public List<ItensExames> getExames() {
		return exames;
	}


	public void setExames(List<ItensExames> exames) {
		this.exames = exames;
	}


	public List<ItensProdutos> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<ItensProdutos> produtos) {
		this.produtos = produtos;
	}


	public List<ItensServico> getServico() {
		return servico;
	}


	public void setServico(List<ItensServico> servico) {
		this.servico = servico;
	}

	public List<ImgConsultas> getImgConsultas() {
		return imgConsultas;
	}

	public void setImgConsultas(List<ImgConsultas> imgConsultas) {
		this.imgConsultas = imgConsultas;
	}

}
