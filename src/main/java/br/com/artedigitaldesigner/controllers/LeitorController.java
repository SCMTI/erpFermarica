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

import br.com.artedigitaldesigner.dto.leitores.LeitorGetDTO;
import br.com.artedigitaldesigner.dto.leitores.LeitorPostDTO;
import br.com.artedigitaldesigner.dto.leitores.LeitorPutDTO;
import br.com.artedigitaldesigner.entities.Contato;
import br.com.artedigitaldesigner.entities.Endereco;
import br.com.artedigitaldesigner.entities.Leitor;
import br.com.artedigitaldesigner.enums.Funcao;
import br.com.artedigitaldesigner.enums.Sexo;
import br.com.artedigitaldesigner.enums.Status;
import br.com.artedigitaldesigner.enums.TipoContato;
import br.com.artedigitaldesigner.interfaces.IContatoRepository;
import br.com.artedigitaldesigner.interfaces.IEnderecoRepository;
import br.com.artedigitaldesigner.interfaces.ILeitorRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class LeitorController {

	private static final String ENDPOINT = "/api/leitor";

	@Autowired
	private ILeitorRepository leitorRepository;

	@Autowired
	private IEnderecoRepository enderecoRepository;

	@Autowired
	private IContatoRepository contatoRepository;

	@CrossOrigin
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> post(@RequestBody LeitorPostDTO dto) {

		try {
			if (leitorRepository.findByCpf(dto.getCpf()) != null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("O CPF informado já encontra-se cadastrado.");
			}
			Leitor leitor = new Leitor();
			leitor.setNome(dto.getNome());
			leitor.setSexo(Sexo.valueOf(dto.getSexo()));
			leitor.setStatus(Status.valueOf(dto.getStatus()));
			leitor.setFuncao(Funcao.valueOf(dto.getFuncao()));
			leitor.setCpf(dto.getCpf());

			Endereco endereco = new Endereco();
			endereco.setEstado(dto.getEstado());
			endereco.setCidade(dto.getCidade());
			endereco.setBairro(dto.getBairro());
			endereco.setLogradouro(dto.getLogradouro());
			endereco.setComplemento(dto.getComplemento());
			endereco.setNumero(dto.getNumero());
			endereco.setCep(dto.getCep());

			Contato contato = new Contato();
			contato.setTipo(TipoContato.valueOf(dto.getTipo()));
			contato.setCelular(dto.getCelular());
			contato.setTelefone(dto.getTelefone());
			contato.setEmail(dto.getEmail());

			endereco.setLeitor(leitor);
			contato.setLeitor(leitor);
			leitorRepository.save(leitor);
			enderecoRepository.save(endereco);
			contatoRepository.save(contato);

			return ResponseEntity.status(HttpStatus.OK).body("Leitor cadastrado com sucesso.");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}

	}

	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestBody LeitorPutDTO dto) {

		try {

			Optional<Leitor> result = leitorRepository.findById(dto.getIdLeitor());

			if (result == null || result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Leitor não encontrado.");
			}

			Leitor leitor = result.get();
			leitor.setNome(dto.getNome());
			leitor.setSexo(Sexo.valueOf(dto.getSexo()));
			leitor.setStatus(Status.valueOf(dto.getStatus()));
			leitor.setFuncao(Funcao.valueOf(dto.getFuncao()));
			
			
			Endereco endereco = new Endereco();
			endereco.setIdEndereco(dto.getIdEndereco());
			endereco.setEstado(dto.getEstado());
			endereco.setCidade(dto.getCidade());
			endereco.setBairro(dto.getBairro());
			endereco.setLogradouro(dto.getLogradouro());
			endereco.setComplemento(dto.getComplemento());
			endereco.setNumero(dto.getNumero());
			endereco.setCep(dto.getCep());

			Contato contato = new Contato();
			contato.setIdcontato(dto.getIdcontato());
			contato.setTipo(TipoContato.valueOf(dto.getTipo()));
			contato.setCelular(dto.getCelular());
			contato.setTelefone(dto.getTelefone());
			contato.setEmail(dto.getEmail());

			endereco.setLeitor(leitor);
			contato.setLeitor(leitor);
			leitorRepository.save(leitor);
			enderecoRepository.save(endereco);
			contatoRepository.save(contato);

			return ResponseEntity.status(HttpStatus.OK).body("Leitor atualizado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}

	}

	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {

			Optional<Leitor> result = leitorRepository.findById(id);

			if (result == null || result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Leitor não encontrado.");
			}

			leitorRepository.delete(result.get());

			return ResponseEntity.status(HttpStatus.OK).body("Leitor excluido com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}
	}

	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.GET)
	public ResponseEntity<LeitorGetDTO> get(@PathVariable("id") Integer id) {
		try {

			Optional<Leitor> result = leitorRepository.findById(id);

			if (result == null || result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}

			Leitor leitor = result.get();
			LeitorGetDTO dto = new LeitorGetDTO();

			dto.setIdLeitor(leitor.getIdLeitor());
			dto.setIdcontato(leitor.getContato().getIdcontato());
			dto.setIdEndereco(leitor.getEndereco().getIdEndereco());
			dto.setNome(leitor.getNome());
			dto.setSexo(leitor.getSexo().toString());
			dto.setStatus(leitor.getStatus().toString());
			dto.setFuncao(leitor.getFuncao().toString());
			dto.setTelefone(leitor.getContato().getTelefone());
			dto.setCelular(leitor.getContato().getCelular());
			dto.setEmail(leitor.getContato().getEmail());
			dto.setTipo(leitor.getContato().getTipo().toString());
			dto.setLogradouro(leitor.getEndereco().getLogradouro());
			dto.setNumero(leitor.getEndereco().getNumero());
			dto.setComplemento(leitor.getEndereco().getComplemento());
			dto.setBairro(leitor.getEndereco().getBairro());
			dto.setEstado(leitor.getEndereco().getEstado());
			dto.setCidade(leitor.getEndereco().getCidade());
			dto.setCep(leitor.getEndereco().getCep());
			dto.setCpf(leitor.getCpf());

			return ResponseEntity.status(HttpStatus.OK).body(dto);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<LeitorGetDTO>> get() {

		try {

			List<LeitorGetDTO> result = new ArrayList<LeitorGetDTO>();

			for (Leitor leitor : leitorRepository.findAll()) {

				LeitorGetDTO dto = new LeitorGetDTO();

				dto.setIdLeitor(leitor.getIdLeitor());
				dto.setIdcontato(leitor.getContato().getIdcontato());
				dto.setIdEndereco(leitor.getEndereco().getIdEndereco());
				dto.setNome(leitor.getNome());
				dto.setSexo(leitor.getSexo().toString());
				dto.setStatus(leitor.getStatus().toString());
				dto.setFuncao(leitor.getFuncao().toString());
				dto.setTelefone(leitor.getContato().getTelefone());
				dto.setCelular(leitor.getContato().getCelular());
				dto.setEmail(leitor.getContato().getEmail());
				dto.setTipo(leitor.getContato().getTipo().toString());
				dto.setLogradouro(leitor.getEndereco().getLogradouro());
				dto.setNumero(leitor.getEndereco().getNumero());
				dto.setComplemento(leitor.getEndereco().getComplemento());
				dto.setBairro(leitor.getEndereco().getBairro());
				dto.setEstado(leitor.getEndereco().getEstado());
				dto.setCidade(leitor.getEndereco().getCidade());
				dto.setCep(leitor.getEndereco().getCep());
				dto.setCpf(leitor.getCpf());

				result.add(dto);
			}

			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
