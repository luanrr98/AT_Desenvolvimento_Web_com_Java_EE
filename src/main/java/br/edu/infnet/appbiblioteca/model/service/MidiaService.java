package br.edu.infnet.appbiblioteca.model.service;

import br.edu.infnet.appbiblioteca.model.domain.Midia;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.repository.MidiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MidiaService {

    @Autowired
    private MidiaRepository midiaRepository;

    public List<Midia> obterTodos(Responsavel responsavel) {
        return midiaRepository.findAll(responsavel.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Midia obterPorId(Integer id) {
        return midiaRepository.findById(id).orElse(null);

    }


    public void excluir(Integer id) {
        midiaRepository.deleteById(id);

    }

    public int obterQtd() {
        return (int) midiaRepository.count();
    }
}
