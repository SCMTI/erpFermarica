package br.com.artedigitaldesigner.dto.emprestimos;

import java.util.ArrayList;
import java.util.List;

import br.com.artedigitaldesigner.dto.livros.LivroGetDTO;

public class EmprestimoPutDTO {
	private Integer idEmprestimo;
	private String dataEntrega;
	private String dataPromessa;
	private Double doacao;
	private Integer[] livrosemprestado;
	
	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getDataPromessa() {
		return dataPromessa;
	}
	public void setDataPromessa(String dataPromessa) {
		this.dataPromessa = dataPromessa;
	}
	public Double getDoacao() {
		return doacao;
	}
	public void setDoacao(Double doacao) {
		this.doacao = doacao;
	}
	public Integer[] getLivrosemprestado() {
		return livrosemprestado;
	}
	public void setLivrosemprestado(Integer[] livrosemprestado) {
		this.livrosemprestado = livrosemprestado;
	}
	
	
}
