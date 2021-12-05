package com.vetkin.Fornecedor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vetkin.CadastroProduto.CadastroProduto;
import com.vetkin.CadastroVacina.CadastroVacina;
import com.vetkin.Veterinario.Veterinario;
import com.vetkin.cliente.TutorCliente;

@Entity
@Table(name = "Fornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecID_Fornecedor")
	private Long RecID_Fornecedor;
	
	private String empresa;
	private String nome;
	private String contato;
	private String score;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="VacinaFornecedor_RecID")
	private CadastroVacina cadastroVacina = new CadastroVacina();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ProdutoFornecedor_RecID")
	private CadastroProduto cadastroProduto = new CadastroProduto();
	
	public Fornecedor () {
		
	}

	public Fornecedor(Long recID_Fornecedor, String empresa, String nome, String contato, String score) {
		super();
		RecID_Fornecedor = recID_Fornecedor;
		this.empresa = empresa;
		this.nome = nome;
		this.contato = contato;
		this.score = score;
	}

	public Long getRecID_Fornecedor() {
		return RecID_Fornecedor;
	}

	public void setRecID_Fornecedor(Long recID_Fornecedor) {
		RecID_Fornecedor = recID_Fornecedor;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
}
