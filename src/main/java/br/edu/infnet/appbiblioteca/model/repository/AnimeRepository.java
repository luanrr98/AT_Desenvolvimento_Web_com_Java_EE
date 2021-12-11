package br.edu.infnet.appbiblioteca.model.repository;

import br.edu.infnet.appbiblioteca.model.domain.Anime;
import br.edu.infnet.appbiblioteca.model.domain.Midia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends CrudRepository<Anime, Integer> {
    @Query("from Anime a where a.responsavel.id =:id")
    List<Anime> findAll(Integer id, Sort by);
}
