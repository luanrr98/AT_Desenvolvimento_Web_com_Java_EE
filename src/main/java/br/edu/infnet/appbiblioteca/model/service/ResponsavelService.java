package br.edu.infnet.appbiblioteca.model.service;

import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public Responsavel autenticar(String email, String senha) {
        return responsavelRepository.autenticar(email,senha);
    }

    public List<Responsavel> obterTodos() {
        return  responsavelRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));
    }

    public void incluir(Responsavel responsavel) {
        responsavelRepository.save(responsavel);
    }

    public void excluir(Integer id) {
        responsavelRepository.deleteById(id);
    }
}
