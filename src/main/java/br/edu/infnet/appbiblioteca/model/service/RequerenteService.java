package br.edu.infnet.appbiblioteca.model.service;

import br.edu.infnet.appbiblioteca.model.domain.Requerente;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.repository.RequerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequerenteService {

    @Autowired
    private RequerenteRepository requerenteRepository;

    public List<Requerente> obterTodos() {
        return (List<Requerente>) requerenteRepository.findAll();
    }

    public List<Requerente> obterTodos(Responsavel responsavel) {
        return  requerenteRepository.findAll(responsavel.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }

    public void incluir(Requerente requerente) {
        requerenteRepository.save(requerente);
    }

    public void excluir(Integer id) {
        requerenteRepository.deleteById(id);
    }
}
