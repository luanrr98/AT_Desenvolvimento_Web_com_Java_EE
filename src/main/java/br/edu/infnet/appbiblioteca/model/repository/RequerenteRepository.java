package br.edu.infnet.appbiblioteca.model.repository;

import br.edu.infnet.appbiblioteca.model.domain.Requerente;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequerenteRepository extends CrudRepository<Requerente, Integer> {

    @Query("from Requerente r where r.responsavel.id =:id")
    List<Requerente> findAll(Integer id, Sort by);

}
