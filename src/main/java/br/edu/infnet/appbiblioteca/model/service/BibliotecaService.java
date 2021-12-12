package br.edu.infnet.appbiblioteca.model.service;

import br.edu.infnet.appbiblioteca.model.domain.Biblioteca;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> obterTodos(Responsavel responsavel) {
        return bibliotecaRepository.findAll(responsavel.getId(), Sort.by(Sort.Direction.ASC, "titulo"));
    }

    public List<Biblioteca> obterTodos() {
        return (List<Biblioteca>) bibliotecaRepository.findAll();
    }

    public void excluir(Integer id) {
        bibliotecaRepository.deleteById(id);
    }

    public void incluir(Biblioteca biblioteca) {
        bibliotecaRepository.save(biblioteca);
    }

    public int obterQtd() {
        return (int) bibliotecaRepository.count();
    }
}
