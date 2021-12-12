package br.edu.infnet.appbiblioteca.controllers;

import br.edu.infnet.appbiblioteca.model.domain.Manga;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MangaController {

  @Autowired
  private MangaService mangaService;


    @GetMapping(value = "/manga")
    public String telaCadastro(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        return "manga/cadastro";
    }

    @GetMapping(value = "/mangas")
    public String telaLista(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        model.addAttribute("listaMangas", mangaService.obterTodos(responsavel));
        return "manga/lista";
    }

    @GetMapping(value = "/manga/excluir/{id}")
    public String excluir(@PathVariable Integer id) {

            mangaService.excluir(id);

        return "redirect:/mangas";
    }

    @PostMapping(value = "/manga/incluir")
    public String incluir(Model model, Manga manga, @RequestParam String[] midiaIds, @SessionAttribute("resp") Responsavel responsavel) {
        manga.setResponsavel(responsavel);
        mangaService.incluir(manga);
        model.addAttribute("nome", manga.getNome());
        return telaLista(model, responsavel);
    }


}

