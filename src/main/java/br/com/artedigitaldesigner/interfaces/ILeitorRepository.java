package br.com.artedigitaldesigner.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.artedigitaldesigner.entities.Leitor;

public interface ILeitorRepository extends CrudRepository<Leitor, Integer> {
	
	@Query("from Leitor where cpf = :pcpf")
	Leitor findByCpf(@Param("pcpf") String cpf);

}
