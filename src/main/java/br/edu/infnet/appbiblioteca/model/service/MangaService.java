package br.edu.infnet.appbiblioteca.model.service;

import br.edu.infnet.appbiblioteca.model.domain.Manga;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;
    public List<Manga> obterTodos(Responsavel responsavel) {
        return mangaRepository.findAll(responsavel.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }

    public void excluir(Integer id) {
        mangaRepository.deleteById(id);
    }

    public void incluir(Manga manga) {
        mangaRepository.save(manga);
    }
    public Manga obterPorId(Integer id){
        return mangaRepository.findById(id).orElse(null);
    }
}
