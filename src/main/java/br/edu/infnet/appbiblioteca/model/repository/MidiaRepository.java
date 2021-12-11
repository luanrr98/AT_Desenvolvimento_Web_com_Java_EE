package br.edu.infnet.appbiblioteca.model.repository;

import br.edu.infnet.appbiblioteca.model.domain.Midia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MidiaRepository extends CrudRepository<Midia, Integer> {
    @Query("from Midia m where m.responsavel.id =:id")
    List<Midia> findAll(Integer id, Sort by);
}
