package br.com.artedigitaldesigner.interfaces;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.artedigitaldesigner.entities.Emprestimo;

public interface IEmprestimoRepository extends CrudRepository<Emprestimo, Integer> {
	
	@Query("from Emprestimo p join p.leitor c where c.idLeitor = :pidLeitor")
	List<Emprestimo> findByLeitor(@Param("pidLeitor") Integer idLeitor);
	
	
}
