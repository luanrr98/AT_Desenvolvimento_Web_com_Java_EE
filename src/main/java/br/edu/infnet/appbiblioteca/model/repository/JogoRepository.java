package br.edu.infnet.appbiblioteca.model.repository;

import br.edu.infnet.appbiblioteca.model.domain.Jogo;
import br.edu.infnet.appbiblioteca.model.domain.Midia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends CrudRepository<Jogo, Integer> {
    @Query("from Jogo j where j.responsavel.id =:id")
    List<Jogo> findAll(Integer id, Sort by);
}
