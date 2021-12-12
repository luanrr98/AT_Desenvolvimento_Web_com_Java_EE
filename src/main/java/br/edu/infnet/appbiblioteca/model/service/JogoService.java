package br.edu.infnet.appbiblioteca.model.service;

import br.edu.infnet.appbiblioteca.model.domain.Jogo;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> obterTodos(Responsavel responsavel) {
        return jogoRepository.findAll(responsavel.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }

    public void excluir(Integer id) {
        jogoRepository.deleteById(id);
    }

    public void incluir(Jogo jogo) {
        jogoRepository.save(jogo);
    }

    public Jogo obterPorId(Integer id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public int obterQtd() {
        return (int) jogoRepository.count();
    }
}
