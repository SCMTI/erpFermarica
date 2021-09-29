package br.com.artedigitaldesigner.dto.emprestimos;

import java.util.Date;

public class EmprestimoPostDTO {
	
	private String codigo;
	private String dataRetirada;
	private String dataEntrega;
	private String dataPromessa;
	private Double doacao;
	private Integer idLeitor;
	private Integer[] idLivros;
	private String status;
	
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
	
	public Double getDoacao() {
		return doacao;
	}
	public void setDoacao(Double doacao) {
		this.doacao = doacao;
	}
	
	public Integer[] getIdLivros() {
		return idLivros;
	}
	public void setIdLivros(Integer[] idLivros) {
		this.idLivros = idLivros;
	}
	
	public Integer getIdLeitor() {
		return idLeitor;
	}
	public void setIdLeitor(Integer idLeitor) {
		this.idLeitor = idLeitor;
	}
	public String getDataPromessa() {
		return dataPromessa;
	}
	public void setDataPromessa(String dataPromessa) {
		this.dataPromessa = dataPromessa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
