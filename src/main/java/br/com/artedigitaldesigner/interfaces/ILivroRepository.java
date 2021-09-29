package br.com.artedigitaldesigner.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.artedigitaldesigner.entities.Livro;

public interface ILivroRepository extends CrudRepository<Livro, Integer> {
	
	@Query("from Livro where codigo = :pcodigo")
	Livro findByCodigo(@Param("pcodigo") String codigo);
}
