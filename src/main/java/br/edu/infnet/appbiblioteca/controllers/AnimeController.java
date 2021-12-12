package br.edu.infnet.appbiblioteca.controllers;

import br.edu.infnet.appbiblioteca.model.domain.Anime;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.sql.SQLIntegrityConstraintViolationException;

@Controller
public class AnimeController {

    @Autowired
    private AnimeService animeService;


    @GetMapping(value = "/anime")
    public String telaCadastro(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        return "anime/cadastro";
    }

    @GetMapping(value = "/animes")
    public String telaLista(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        model.addAttribute("listaAnimes", animeService.obterTodos(responsavel));
        return "anime/lista";
    }

    @GetMapping(value = "/anime/excluir/{id}")
    public String excluir(Model model,@PathVariable Integer id,@SessionAttribute("resp") Responsavel responsavel) {
       try {
           animeService.excluir(id);

       }catch (Exception e) {
           model.addAttribute("msg", "Não foi possível realizar a exclusão deste Anime!");
       }

        return telaLista(model, responsavel);
    }


    @PostMapping(value = "/anime/incluir")
    public String incluir(Model model, Anime anime, @SessionAttribute("resp") Responsavel responsavel) {
        anime.setResponsavel(responsavel);
        animeService.incluir(anime);
        model.addAttribute("nome", anime.getNome());
        return telaLista(model, responsavel);
    }


}

