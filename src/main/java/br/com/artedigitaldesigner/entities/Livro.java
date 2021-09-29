package br.com.artedigitaldesigner.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idLivro;

	@Column(length = 250, nullable = false)
	private String estante;

	@Column(length = 250, nullable = false)
	private String prateleira;

	@Column(length = 250, nullable = false, unique = true)
	private String codigo;

	@Column(length = 250, nullable = false)
	private String titulo;

	@Column(length = 250, nullable = false)
	private String autor;

	@Column(length = 250, nullable = false)
	private String escritor;

	
	@Column(length = 250,nullable = true)
	private String edicao;

	@Temporal(TemporalType.DATE) // campo somente data
	@Column(nullable = false)
	private Date dataAquisicao;

	@Column(length = 250, nullable = true)
	private String tema;

	@Column(length = 250, nullable = true)
	private String descricao;

	@ManyToMany(mappedBy = "livrosEmp")
	private List<Emprestimo> emprestimo;

	public Livro() {
		// TODO Auto-generated constructor stub
	}



	public Livro(Integer idLivro, String estante, String prateleira, String codigo, String titulo, String autor,
			String escritor, String edicao, Date dataAquisicao, String tema, String descricao,
			List<Emprestimo> emprestimo) {
		super();
		this.idLivro = idLivro;
		this.estante = estante;
		this.prateleira = prateleira;
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.escritor = escritor;
		this.edicao = edicao;
		this.dataAquisicao = dataAquisicao;
		this.tema = tema;
		this.descricao = descricao;
		this.emprestimo = emprestimo;
	}



	public Integer getIdLivro() {
		return idLivro;
	}



	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}



	public String getEstante() {
		return estante;
	}



	public void setEstante(String estante) {
		this.estante = estante;
	}



	public String getPrateleira() {
		return prateleira;
	}



	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getEscritor() {
		return escritor;
	}



	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}



	public String getEdicao() {
		return edicao;
	}



	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}



	public Date getDataAquisicao() {
		return dataAquisicao;
	}



	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}



	public String getTema() {
		return tema;
	}



	public void setTema(String tema) {
		this.tema = tema;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}



	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}



	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", estante=" + estante + ", prateleira=" + prateleira + ", codigo="
				+ codigo + ", titulo=" + titulo + ", autor=" + autor + ", escritor=" + escritor + ", edicao=" + edicao
				+ ", dataAquisicao=" + dataAquisicao + ", tema=" + tema + ", descricao=" + descricao + ", emprestimo="
				+ emprestimo + "]";
	}

}
