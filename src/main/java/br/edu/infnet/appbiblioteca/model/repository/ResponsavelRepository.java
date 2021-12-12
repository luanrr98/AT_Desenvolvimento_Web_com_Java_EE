package br.edu.infnet.appbiblioteca.model.repository;

import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsavelRepository extends CrudRepository<Responsavel, Integer> {

    @Query("from Responsavel r where r.email =:email and r.senha =:senha")
    Responsavel autenticar(String email, String senha);

    List<Responsavel> findAll(Sort by);
}
