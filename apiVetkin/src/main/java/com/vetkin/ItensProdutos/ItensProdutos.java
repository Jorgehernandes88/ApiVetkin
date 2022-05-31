package com.vetkin.ItensProdutos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.vetkin.CadastroProduto.CadastroProduto;


@Entity
@Table(name = "ItensProdutos")
public class ItensProdutos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_ItensProdutos")
	private Long RecID_ItensProdutos;
	
	@ManyToOne
	@JoinColumn(name="RecID_CadastroProduto", nullable=false)
	private CadastroProduto produto;

	public ItensProdutos()
	{
		
	}

	public ItensProdutos(Long recID_ItensProdutos, CadastroProduto produto) {
		super();
		RecID_ItensProdutos = recID_ItensProdutos;
		this.produto = produto;
	}



	public Long getRecID_ItensProdutos() {
		return RecID_ItensProdutos;
	}


	public void setRecID_ItensProdutos(Long recID_ItensProdutos) {
		RecID_ItensProdutos = recID_ItensProdutos;
	}



	public CadastroProduto getproduto() {
		return produto;
	}

	public void setproduto(CadastroProduto produto) {
		this.produto = produto;
	}

}
