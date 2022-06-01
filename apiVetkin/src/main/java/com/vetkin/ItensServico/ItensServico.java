package com.vetkin.ItensServico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.vetkin.CadastroServico.CadastroServico;


@Entity
@Table(name = "ItensServicos")
public class ItensServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_ItensServicos")
	private Long RecID_ItensServicos;
	
	@ManyToOne
	@JoinColumn(name="RecID_CadastroServico", nullable=false)
	private CadastroServico servicos;

	public ItensServico()
	{
		
	}

	public ItensServico(Long recID_ItensServicos, CadastroServico servicos) {
		super();
		RecID_ItensServicos = recID_ItensServicos;
		this.servicos = servicos;
	}

	public Long getRecID_ItensServicos() {
		return RecID_ItensServicos;
	}

	public void setRecID_ItensServicos(Long recID_ItensServicos) {
		RecID_ItensServicos = recID_ItensServicos;
	}

	public CadastroServico getServicos() {
		return servicos;
	}

	public void setServicos(CadastroServico servicos) {
		this.servicos = servicos;
	}



}
