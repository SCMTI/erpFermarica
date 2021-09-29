package br.com.artedigitaldesigner.dto.livros;

import java.util.Date;

public class LivroPutDTO {
	private Integer idLivro;
	private String estante;
	private String prateleira;
	private String codigo;
	private String titulo;
	private String autor;
	private String escritor;
	private String Edicao;
	private String dataAquisicao;
	private String tema;
	private String descricao;
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
		return Edicao;
	}
	public void setEdicao(String edicao) {
		Edicao = edicao;
	}
	
	public String getDataAquisicao() {
		return dataAquisicao;
	}
	public void setDataAquisicao(String dataAquisicao) {
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
	
	
	
}
