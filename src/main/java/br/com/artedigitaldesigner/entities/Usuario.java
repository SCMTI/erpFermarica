package br.com.artedigitaldesigner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "idUsuario")
	private Integer idUsuario;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 150, nullable = false)
	private String email;
	
	@Column(name = "senha", length = 150, nullable = false)
	private String senha;
	
	@Column(name = "funcao", length = 150, nullable = false)
	private String funcao;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	public Usuario(Integer idUsuario, String nome, String email, String senha, String funcao) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.funcao = funcao;
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", funcao=" + funcao + "]";
	}


	
}
