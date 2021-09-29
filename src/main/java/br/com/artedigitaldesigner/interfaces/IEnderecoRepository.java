package br.com.artedigitaldesigner.interfaces;

import org.springframework.data.repository.CrudRepository;

import br.com.artedigitaldesigner.entities.Endereco;

public interface IEnderecoRepository extends CrudRepository<Endereco, Integer> {

}
