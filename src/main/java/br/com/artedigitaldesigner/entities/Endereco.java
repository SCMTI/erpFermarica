package br.com.artedigitaldesigner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idEndereco;
	
	@Column(length = 250, nullable = false)
	private String logradouro;
	
	@Column(length = 25, nullable = false)
	private String numero;
	
	@Column(length = 150, nullable = false)
	private String complemento;
	
	@Column(length = 100, nullable = false)
	private String bairro;
	
	@Column(length = 100, nullable = false)
	private String cidade;
	
	@Column(length = 50, nullable = false)
	private String estado;
	
	@Column(length = 9, nullable = false)
	private String cep;
	

	@OneToOne
	//mapeaando a chave estrangeira, unique=true (um para um)
	@JoinColumn(name = "idleitor", nullable = false, unique = true)
	private Leitor leitor;


	public Integer getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public Leitor getLeitor() {
		return leitor;
	}


	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	
}
