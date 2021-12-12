package br.edu.infnet.appbiblioteca.controllers;

import br.edu.infnet.appbiblioteca.model.domain.Jogo;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JogoController {

  @Autowired
  private JogoService jogoService;


    @GetMapping(value = "/jogo")
    public String telaCadastro(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        return "jogo/cadastro";
    }

    @GetMapping(value = "/jogos")
    public String telaLista(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        model.addAttribute("listaJogos", jogoService.obterTodos(responsavel));
        return "jogo/lista";
    }

    @GetMapping(value = "/jogo/excluir/{id}")
    public String excluir(@PathVariable Integer id) {

            jogoService.excluir(id);

        return "redirect:/jogos";
    }

    @PostMapping(value = "/jogo/incluir")
    public String incluir(Model model, Jogo jogo, @RequestParam String[] midiaIds, @SessionAttribute("resp") Responsavel responsavel) {
        jogo.setResponsavel(responsavel);
        jogoService.incluir(jogo);
        model.addAttribute("nome", jogo.getNome());
        return telaLista(model, responsavel);
    }


}

