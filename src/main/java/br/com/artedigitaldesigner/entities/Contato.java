package br.com.artedigitaldesigner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.artedigitaldesigner.enums.TipoContato;
@Entity
@Table
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idcontato;
	
	@Column(length = 13, nullable = true)
	private String telefone;
	
	@Column(length = 14, nullable = false)
	private String Celular;
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@OneToOne
	//mapeaando a chave estrangeira, unique=true (um para um)
	@JoinColumn(name = "idleitor", nullable = false, unique = true)
	private Leitor leitor;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoContato tipo;
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}

	public Contato(Integer idcontato, String telefone, String celular, String email, Leitor leitor, TipoContato tipo) {
		super();
		this.idcontato = idcontato;
		this.telefone = telefone;
		Celular = celular;
		this.email = email;
		this.leitor = leitor;
		this.tipo = tipo;
	}

	public Integer getIdcontato() {
		return idcontato;
	}

	public void setIdcontato(Integer idcontato) {
		this.idcontato = idcontato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public TipoContato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Contato [idcontato=" + idcontato + ", telefone=" + telefone + ", Celular=" + Celular + ", email="
				+ email + ", leitor=" + leitor + ", tipo=" + tipo + "]";
	}
	
	
}
