package br.edu.infnet.appbiblioteca.controllers;

import br.edu.infnet.appbiblioteca.model.domain.Requerente;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.RequerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RequerenteController {

    @Autowired
    private RequerenteService requerenteService;


    @GetMapping(value = "/requerente")
    public String telaCadastro() {
        return "requerente/cadastro";
    }

    @GetMapping(value = "/requerentes")
    public String telaLista(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        model.addAttribute("listaRequerentes", requerenteService.obterTodos(responsavel));
        return "requerente/lista";
    }

    @GetMapping(value = "/requerente/excluir/{id}")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("resp") Responsavel responsavel) {
        try {
            requerenteService.excluir(id);

        } catch (Exception e) {
            model.addAttribute("msg", "Não foi possível realizar a exclusão deste Requerente!");
        }
        return this.telaLista(model, responsavel);
    }

    @PostMapping(value = "/requerente/incluir")
    public String incluir(Model model, Requerente requerente, @SessionAttribute("resp") Responsavel responsavel) {
        requerente.setResponsavel(responsavel);

        requerenteService.incluir(requerente);

        model.addAttribute("nome", requerente.getNome());

        return telaLista(model, responsavel);
    }


}

