package br.com.artedigitaldesigner.interfaces;

import org.springframework.data.repository.CrudRepository;

import br.com.artedigitaldesigner.entities.Contato;

public interface IContatoRepository extends CrudRepository<Contato, Integer>{

}
