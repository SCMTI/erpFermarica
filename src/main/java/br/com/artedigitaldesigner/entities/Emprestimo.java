package br.com.artedigitaldesigner.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.artedigitaldesigner.enums.Status;

@Entity
@Table
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idEmprestimo;
	
	@Column(length = 250, nullable = false)
	private String codigo;
	
	@Temporal(TemporalType.DATE) // campo somente data
	@Column(nullable = false)
	private Date dataRetirada;
	
	@Temporal(TemporalType.DATE) // campo somente data
	@Column(nullable = true)
	private Date dataEntrega;
	
	@Temporal(TemporalType.DATE) // campo somente data
	@Column(nullable = false)
	private Date dataPromessa;
	
	@Column(nullable = false)
	private Double doacao;
	
	@ManyToMany
	@JoinTable(
			name = "itememprestimo",
			joinColumns = @JoinColumn(name = "idEmprestimo", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "idLivro", nullable = false))
	private List<Livro> livrosEmp;
	
	@ManyToOne // muitos Pedidos para 1 Cliente
	// Chave estrangeira do relacionamento
	@JoinColumn(name = "idLeitor", nullable = false)
	private Leitor leitor;
	
	@Column(length = 250, nullable = false)
	private Status status;

	public Emprestimo() {
		// TODO Auto-generated constructor stub
	}

	public Emprestimo(Integer idEmprestimo, String codigo, Date dataRetirada, Date dataEntrega, Date dataPromessa,
			Double doacao, List<Livro> livrosEmp, Leitor leitor, Status status) {
		super();
		this.idEmprestimo = idEmprestimo;
		this.codigo = codigo;
		this.dataRetirada = dataRetirada;
		this.dataEntrega = dataEntrega;
		this.dataPromessa = dataPromessa;
		this.doacao = doacao;
		this.livrosEmp = livrosEmp;
		this.leitor = leitor;
		this.status = status;
	}

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

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataPromessa() {
		return dataPromessa;
	}

	public void setDataPromessa(Date dataPromessa) {
		this.dataPromessa = dataPromessa;
	}

	public Double getDoacao() {
		return doacao;
	}

	public void setDoacao(Double doacao) {
		this.doacao = doacao;
	}

	public List<Livro> getLivrosEmp() {
		return livrosEmp;
	}

	

	public void setLivrosEmp(List<Livro> livrosEmp) {
		this.livrosEmp = livrosEmp;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Emprestimo [idEmprestimo=" + idEmprestimo + ", codigo=" + codigo + ", dataRetirada=" + dataRetirada
				+ ", dataEntrega=" + dataEntrega + ", dataPromessa=" + dataPromessa + ", doacao=" + doacao
				+ ", livrosEmp=" + livrosEmp + ", leitor=" + leitor + ", status=" + status + "]";
	}

}
