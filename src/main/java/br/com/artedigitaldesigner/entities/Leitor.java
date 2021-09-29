package br.com.artedigitaldesigner.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.artedigitaldesigner.enums.Funcao;
import br.com.artedigitaldesigner.enums.Sexo;
import br.com.artedigitaldesigner.enums.Status;
@Entity
@Table
public class Leitor{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idLeitor;
	
	@Column(length = 250, nullable = false)
	private String nome;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cpf;
	
	@OneToOne(mappedBy = "leitor", cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private Sexo sexo;
	
	@OneToMany(mappedBy = "leitor")
	private List<Emprestimo> emprestimos;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 100, nullable = false)
	private Funcao funcao;
	
	@OneToOne(mappedBy = "leitor", cascade = CascadeType.ALL)
	private Contato contato;

	public Leitor() {
		// TODO Auto-generated constructor stub
	}


	public Leitor(Integer idLeitor, String nome, String cpf, Endereco endereco, Sexo sexo, List<Emprestimo> emprestimos,
			Status status, Funcao funcao, Contato contato) {
		super();
		this.idLeitor = idLeitor;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.sexo = sexo;
		this.emprestimos = emprestimos;
		this.status = status;
		this.funcao = funcao;
		this.contato = contato;
	}



	public Integer getIdLeitor() {
		return idLeitor;
	}


	public void setIdLeitor(Integer idLeitor) {
		this.idLeitor = idLeitor;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Sexo getSexo() {
		return sexo;
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}


	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Funcao getFuncao() {
		return funcao;
	}


	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}


	public Contato getContato() {
		return contato;
	}


	public void setContato(Contato contato) {
		this.contato = contato;
	}


	@Override
	public String toString() {
		return "Leitor [idLeitor=" + idLeitor + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", sexo="
				+ sexo + ", emprestimos=" + emprestimos + ", status=" + status + ", funcao=" + funcao + ", contato="
				+ contato + "]";
	}



}
