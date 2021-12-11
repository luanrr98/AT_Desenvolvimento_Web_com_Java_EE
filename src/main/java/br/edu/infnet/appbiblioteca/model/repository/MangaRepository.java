package br.edu.infnet.appbiblioteca.model.repository;

import br.edu.infnet.appbiblioteca.model.domain.Manga;
import br.edu.infnet.appbiblioteca.model.domain.Midia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends CrudRepository<Manga, Integer> {
    @Query("from Manga m where m.responsavel.id =:id")
    List<Manga> findAll(Integer id, Sort by);
}
