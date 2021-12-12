package br.edu.infnet.appbiblioteca.model.service;

import br.edu.infnet.appbiblioteca.model.domain.Anime;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;
    public List<Anime> obterTodos(Responsavel responsavel) {
        return animeRepository.findAll(responsavel.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }

    public void excluir(Integer id) {
        animeRepository.deleteById(id);
    }

    public void incluir(Anime anime) {
        animeRepository.save(anime);
    }
    public Anime obterPorId(Integer id){
        return animeRepository.findById(id).orElse(null);
    }
}
