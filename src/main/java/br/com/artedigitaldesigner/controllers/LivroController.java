package br.com.artedigitaldesigner.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.descriptor.java.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.artedigitaldesigner.dto.leitores.LeitorGetDTO;
import br.com.artedigitaldesigner.dto.livros.LivroGetDTO;
import br.com.artedigitaldesigner.dto.livros.LivroPostDTO;
import br.com.artedigitaldesigner.dto.livros.LivroPutDTO;
import br.com.artedigitaldesigner.entities.Livro;
import br.com.artedigitaldesigner.helpers.DateHelper;
import br.com.artedigitaldesigner.interfaces.ILivroRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class LivroController {

	@Autowired
	private ILivroRepository livroRepository;

	private static final String ENDPOINT = "/api/livro";
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody LivroPostDTO dto) {
		try {
			if (livroRepository.findByCodigo(dto.getCodigo()) != null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("O Livro informado já encontra-se cadastrado.");
			}

			Livro livro = new Livro();

			livro.setTitulo(dto.getTitulo());
			livro.setCodigo(dto.getCodigo());
			livro.setDescricao(dto.getDescricao());
			livro.setTema(dto.getTema());
			livro.setDataAquisicao(DateHelper.toDatePtBR(dto.getDataAquisicao()));
			livro.setEdicao(dto.getEdicao());
			livro.setEscritor(dto.getEscritor());
			livro.setAutor(dto.getAutor());
			livro.setEstante(dto.getEstante());
			livro.setPrateleira(dto.getPrateleira());

			livroRepository.save(livro);

			return ResponseEntity.status(HttpStatus.OK).body("Cadastro de Livro executado com sucesso!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}

	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestBody LivroPutDTO dto) {
		try {

			Optional<Livro> result = livroRepository.findById(dto.getIdLivro());

			if (result == null || result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Livro não encontrado.");
			}
			Livro livro = result.get();

			livro.setTitulo(dto.getTitulo());
			livro.setCodigo(dto.getCodigo());
			livro.setDescricao(dto.getDescricao());
			livro.setTema(dto.getTema());
			livro.setDataAquisicao(DateHelper.toDatePtBR(dto.getDataAquisicao()));
			livro.setEdicao(dto.getEdicao());
			livro.setEscritor(dto.getEscritor());
			livro.setAutor(dto.getAutor());
			livro.setEstante(dto.getEstante());
			livro.setPrateleira(dto.getPrateleira());

			livroRepository.save(livro);

			return ResponseEntity.status(HttpStatus.OK).body("Livro atualizado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {

			Optional<Livro> result = livroRepository.findById(id);

			if (result == null || result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Livro não encontrado.");
			}

			livroRepository.delete(result.get());

			return ResponseEntity.status(HttpStatus.OK).body("Livro excluido com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<LivroGetDTO>> get() {

		try {

			List<LivroGetDTO> result = new ArrayList<LivroGetDTO>();

			for (Livro livro : livroRepository.findAll()) {

				LivroGetDTO dto = new LivroGetDTO();
				dto.setIdLivro(livro.getIdLivro());
				dto.setCodigo(livro.getCodigo());
				dto.setAutor(livro.getAutor());
				dto.setEscritor(livro.getEscritor());
				dto.setDescricao(livro.getDescricao());
				dto.setDataAquisicao(DateHelper.toStringPtBR(livro.getDataAquisicao()));
				dto.setEdicao(livro.getEdicao());
				dto.setEstante(livro.getEstante());
				dto.setPrateleira(livro.getPrateleira());
				dto.setTitulo(livro.getTitulo());
				dto.setTema(livro.getTema());

				result.add(dto);
			}

			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = ENDPOINT + "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<LivroGetDTO> get(@PathVariable("codigo") String codigo) {
		try {

			Livro livro = livroRepository.findByCodigo(codigo);

			if (livro == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}

			LivroGetDTO dto = new LivroGetDTO();
			dto.setIdLivro(livro.getIdLivro());
			dto.setTitulo(livro.getTitulo());
			dto.setAutor(livro.getAutor());
			dto.setCodigo(livro.getCodigo());
			dto.setDataAquisicao(DateHelper.toStringPtBR(livro.getDataAquisicao()));
			dto.setDescricao(livro.getDescricao());
			dto.setEdicao(livro.getEdicao());
			dto.setEscritor(livro.getEscritor());
			dto.setEstante(livro.getEstante());
			dto.setPrateleira(livro.getPrateleira());
			dto.setTema(livro.getTema());
			
			return ResponseEntity.status(HttpStatus.OK).body(dto);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
