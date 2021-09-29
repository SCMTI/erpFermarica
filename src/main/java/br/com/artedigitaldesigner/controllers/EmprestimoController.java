package br.com.artedigitaldesigner.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.artedigitaldesigner.dto.emprestimos.EmprestimoGetDTO;
import br.com.artedigitaldesigner.dto.emprestimos.EmprestimoPostDTO;
import br.com.artedigitaldesigner.dto.emprestimos.EmprestimoPutDTO;
import br.com.artedigitaldesigner.dto.leitores.LeitorGetDTO;
import br.com.artedigitaldesigner.dto.livros.LivroGetDTO;
import br.com.artedigitaldesigner.entities.Emprestimo;
import br.com.artedigitaldesigner.entities.Livro;
import br.com.artedigitaldesigner.enums.Status;
import br.com.artedigitaldesigner.helpers.DateHelper;
import br.com.artedigitaldesigner.interfaces.IEmprestimoRepository;
import br.com.artedigitaldesigner.interfaces.ILeitorRepository;
import br.com.artedigitaldesigner.interfaces.ILivroRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class EmprestimoController {
	private static final String ENDPOINT = "/api/emprestimo";

	@Autowired
	private ILivroRepository livroRepository;

	@Autowired
	private ILeitorRepository leitorRepository;

	@Autowired
	private IEmprestimoRepository emprestimoRepository;

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody EmprestimoPostDTO dto) {
		try {
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setCodigo(dto.getCodigo());
			emprestimo.setDataRetirada(DateHelper.toDatePtBR(dto.getDataRetirada()));
			emprestimo.setDataEntrega(DateHelper.toDatePtBR(dto.getDataEntrega()));
			emprestimo.setDataPromessa(DateHelper.toDatePtBR(dto.getDataPromessa()));
			emprestimo.setDoacao(dto.getDoacao());
			emprestimo.setLeitor(leitorRepository.findById(dto.getIdLeitor()).get());

			for (int i = 0; i < dto.getIdLivros().length; i++) {
				emprestimo.getLivrosEmp().add(livroRepository.findById(dto.getIdLivros()[i]).get());
			}
			emprestimo.setStatus(Status.valueOf(dto.getStatus()));
			
			emprestimoRepository.save(emprestimo);

			return ResponseEntity.status(HttpStatus.OK).body("Emprestimo de Livros executado com sucesso!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}

	}

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestBody EmprestimoPutDTO dto) {
		try {
			Optional<Emprestimo> result = emprestimoRepository.findById(dto.getIdEmprestimo());
			if (result == null || result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Emprestimo não encontrado.");
			}

			Emprestimo emprestimo = result.get();
			emprestimo.setDataEntrega(DateHelper.toDatePtBR(dto.getDataEntrega()));
			emprestimo.setDataPromessa(DateHelper.toDatePtBR(dto.getDataPromessa()));
			emprestimo.setDoacao(dto.getDoacao());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return ResponseEntity.status(HttpStatus.OK).body("Atualização de Emprestimo executado com sucesso!");
	}

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmprestimoGetDTO> get(@PathVariable("id") Integer id) {

		try {
			Optional<Emprestimo> result = emprestimoRepository.findById(id);
			if (result == null || result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
			Emprestimo emprestimo = result.get();
			EmprestimoGetDTO dto = new EmprestimoGetDTO();
			dto.setIdEmprestimo(emprestimo.getIdEmprestimo());

			LeitorGetDTO leitor_dto = new LeitorGetDTO();
			leitor_dto.setIdLeitor(emprestimo.getLeitor().getIdLeitor());
			leitor_dto.setIdEndereco(emprestimo.getLeitor().getEndereco().getIdEndereco());
			leitor_dto.setEstado(emprestimo.getLeitor().getEndereco().getEstado());
			leitor_dto.setCidade(emprestimo.getLeitor().getEndereco().getCidade());
			leitor_dto.setBairro(emprestimo.getLeitor().getEndereco().getBairro());
			leitor_dto.setLogradouro(emprestimo.getLeitor().getEndereco().getLogradouro());
			leitor_dto.setComplemento(emprestimo.getLeitor().getEndereco().getComplemento());
			leitor_dto.setCep(emprestimo.getLeitor().getEndereco().getCep());
			leitor_dto.setNumero(emprestimo.getLeitor().getEndereco().getNumero());
			leitor_dto.setCelular(emprestimo.getLeitor().getContato().getCelular());
			leitor_dto.setCpf(emprestimo.getLeitor().getCpf());
			leitor_dto.setEmail(emprestimo.getLeitor().getContato().getEmail());
			leitor_dto.setTelefone(emprestimo.getLeitor().getContato().getTelefone());
			leitor_dto.setIdcontato(emprestimo.getLeitor().getContato().getIdcontato());
			leitor_dto.setFuncao(emprestimo.getLeitor().getFuncao().toString());

			dto.setLeitor(leitor_dto);
			dto.setDataEntrega(DateHelper.toString(emprestimo.getDataEntrega()));
			dto.setDataPromessa(DateHelper.toString(emprestimo.getDataPromessa()));
			dto.setDataRetirada(DateHelper.toString(emprestimo.getDataRetirada()));
			dto.setDoacao(emprestimo.getDoacao());

			List<LivroGetDTO> livros = new ArrayList<LivroGetDTO>();

			for (Livro livro : livroRepository.findAll()) {

				LivroGetDTO dto_livro = new LivroGetDTO();
				dto_livro.setIdLivro(livro.getIdLivro());
				dto_livro.setTitulo(livro.getTitulo());
				dto_livro.setAutor(livro.getAutor());
				dto_livro.setCodigo(livro.getCodigo());
				dto_livro.setDataAquisicao(DateHelper.toString(livro.getDataAquisicao()));
				dto_livro.setDescricao(livro.getDescricao());
				dto_livro.setEdicao(livro.getEdicao());
				dto_livro.setEscritor(livro.getEscritor());
				dto_livro.setEstante(livro.getEstante());
				dto_livro.setTema(livro.getTema());
				dto_livro.setPrateleira(livro.getPrateleira());
				livros.add(dto_livro);
			}
			dto.setLivros(livros);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}

	@CrossOrigin
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<EmprestimoGetDTO>> getAll() {

		try {
			List<EmprestimoGetDTO> result = new ArrayList<EmprestimoGetDTO>();

			for (Emprestimo emprestimo : emprestimoRepository.findAll()) {

				EmprestimoGetDTO dto = new EmprestimoGetDTO();

				dto.setIdEmprestimo(emprestimo.getIdEmprestimo());
				dto.setCodigo(emprestimo.getCodigo());
				dto.setDataEntrega(DateHelper.toString(emprestimo.getDataEntrega()));
				dto.setDataPromessa(DateHelper.toString(emprestimo.getDataPromessa()));
				dto.setDataRetirada(DateHelper.toString(emprestimo.getDataRetirada()));
				dto.setDoacao(emprestimo.getDoacao());
				LeitorGetDTO leitor_dto = new LeitorGetDTO();
				leitor_dto.setIdLeitor(emprestimo.getLeitor().getIdLeitor());
				leitor_dto.setIdEndereco(emprestimo.getLeitor().getEndereco().getIdEndereco());
				leitor_dto.setEstado(emprestimo.getLeitor().getEndereco().getEstado());
				leitor_dto.setCidade(emprestimo.getLeitor().getEndereco().getCidade());
				leitor_dto.setBairro(emprestimo.getLeitor().getEndereco().getBairro());
				leitor_dto.setLogradouro(emprestimo.getLeitor().getEndereco().getLogradouro());
				leitor_dto.setComplemento(emprestimo.getLeitor().getEndereco().getComplemento());
				leitor_dto.setCep(emprestimo.getLeitor().getEndereco().getCep());
				leitor_dto.setNumero(emprestimo.getLeitor().getEndereco().getNumero());
				leitor_dto.setCelular(emprestimo.getLeitor().getContato().getCelular());
				leitor_dto.setCpf(emprestimo.getLeitor().getCpf());
				leitor_dto.setEmail(emprestimo.getLeitor().getContato().getEmail());
				leitor_dto.setTelefone(emprestimo.getLeitor().getContato().getTelefone());
				leitor_dto.setIdcontato(emprestimo.getLeitor().getContato().getIdcontato());
				leitor_dto.setFuncao(emprestimo.getLeitor().getFuncao().toString());
				dto.setLeitor(leitor_dto);
				List<LivroGetDTO> livros = new ArrayList<LivroGetDTO>();
				for (Livro livro : livroRepository.findAll()) {
					LivroGetDTO dto_livro = new LivroGetDTO();
					dto_livro.setIdLivro(livro.getIdLivro());
					dto_livro.setTitulo(livro.getTitulo());
					dto_livro.setAutor(livro.getAutor());
					dto_livro.setCodigo(livro.getCodigo());
					dto_livro.setDataAquisicao(DateHelper.toString(livro.getDataAquisicao()));
					dto_livro.setDescricao(livro.getDescricao());
					dto_livro.setEdicao(livro.getEdicao());
					dto_livro.setEscritor(livro.getEscritor());
					dto_livro.setEstante(livro.getEstante());
					dto_livro.setTema(livro.getTema());
					dto_livro.setPrateleira(livro.getPrateleira());
					livros.add(dto_livro);
				}
				dto.setLivros(livros);
				result.add(dto);
			}
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
