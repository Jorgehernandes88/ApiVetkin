package com.vetkin.ItensExames;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.vetkin.CadastroExame.Exame;


@Entity
@Table(name = "ItensExames")
public class ItensExames {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_ItensExames")
	private Long RecID_ItensExames;
	
	@ManyToOne
	@JoinColumn(name="recID_Exame", nullable=false)
	private Exame exames;

	public ItensExames()
	{
		
	}

	public ItensExames(Long recID_ItensExames, Exame exames) {
		super();
		RecID_ItensExames = recID_ItensExames;
		this.exames = exames;
	}



	public Long getRecID_ItensExames() {
		return RecID_ItensExames;
	}


	public void setRecID_ItensExames(Long recID_ItensExames) {
		RecID_ItensExames = recID_ItensExames;
	}



	public Exame getExames() {
		return exames;
	}

	public void setExames(Exame exames) {
		this.exames = exames;
	}

}
