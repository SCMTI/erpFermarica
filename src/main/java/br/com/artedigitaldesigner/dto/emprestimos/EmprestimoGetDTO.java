package br.com.artedigitaldesigner.dto.emprestimos;

import java.util.Date;
import java.util.List;

import br.com.artedigitaldesigner.dto.leitores.LeitorGetDTO;
import br.com.artedigitaldesigner.dto.livros.LivroGetDTO;

public class EmprestimoGetDTO {
	
	private Integer idEmprestimo;
	private String codigo;
	private String dataRetirada;
	private String dataEntrega;
	private String dataPromessa;
	private Double doacao;
	private LeitorGetDTO leitor;
	private List<LivroGetDTO> livros;
	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
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
	public LeitorGetDTO getLeitor() {
		return leitor;
	}
	public void setLeitor(LeitorGetDTO leitor) {
		this.leitor = leitor;
	}
	public List<LivroGetDTO> getLivros() {
		return livros;
	}
	public void setLivros(List<LivroGetDTO> livros) {
		this.livros = livros;
	}
	
	
}
