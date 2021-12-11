package br.edu.infnet.appbiblioteca.model.repository;

import br.edu.infnet.appbiblioteca.model.domain.Biblioteca;
import br.edu.infnet.appbiblioteca.model.domain.Midia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibliotecaRepository extends CrudRepository<Biblioteca, Integer> {
    @Query("from Biblioteca b where b.responsavel.id =:id")
    List<Biblioteca> findAll(Integer id, Sort by);
}
