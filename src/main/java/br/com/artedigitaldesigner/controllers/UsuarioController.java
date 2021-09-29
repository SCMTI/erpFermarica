package br.com.artedigitaldesigner.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {

	private static final String ENDPOINT = "/api/usuario";

	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	public ResponseEntity<String> post() {
		// TODO
		return ResponseEntity.status(HttpStatus.OK).body("Cadastro de Usúario executado com sucesso!");
	}

	@RequestMapping(value=ENDPOINT,method=RequestMethod.PUT)
	public ResponseEntity<String> put() {
		// TODO
		return ResponseEntity.status(HttpStatus.OK).body("Atualização de Usúario executado com sucesso!");
	}

	
	@RequestMapping(value = ENDPOINT, method = RequestMethod.DELETE)
	public ResponseEntity<String> delete() {
		// TODO
		return ResponseEntity.status(HttpStatus.OK).body("Exclusão de Usúario executado com sucesso!");
	}

	
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	public ResponseEntity<String> get() {
		// TODO
		return ResponseEntity.status(HttpStatus.OK).body("Consulta de Usúario executado com sucesso!");
	}
}
