package br.edu.infnet.appbiblioteca.controllers;

import br.edu.infnet.appbiblioteca.model.domain.Jogo;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
    public String excluir(Model model,@PathVariable Integer id,@SessionAttribute("resp") Responsavel responsavel) {
        try {
            jogoService.excluir(id);

        }catch (Exception e) {
            model.addAttribute("msg", "Não foi possível realizar a exclusão deste Jogo!");
        }

        return telaLista(model, responsavel);
    }

    @PostMapping(value = "/jogo/incluir")
    public String incluir(Model model, Jogo jogo, @SessionAttribute("resp") Responsavel responsavel) {
        jogo.setResponsavel(responsavel);
        jogoService.incluir(jogo);
        model.addAttribute("nome", jogo.getNome());
        return telaLista(model, responsavel);
    }


}

