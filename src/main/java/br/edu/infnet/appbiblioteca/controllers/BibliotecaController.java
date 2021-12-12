package br.edu.infnet.appbiblioteca.controllers;

import br.edu.infnet.appbiblioteca.model.domain.Biblioteca;
import br.edu.infnet.appbiblioteca.model.domain.Midia;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.BibliotecaService;
import br.edu.infnet.appbiblioteca.model.service.MidiaService;
import br.edu.infnet.appbiblioteca.model.service.RequerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;
    @Autowired
    private MidiaService midiaService;
    @Autowired
    private RequerenteService requerenteService;


    @GetMapping(value = "/biblioteca")
    public String telaCadastro(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        model.addAttribute("midias", midiaService.obterTodos(responsavel));
        model.addAttribute("requerentes", requerenteService.obterTodos(responsavel));
        return "biblioteca/cadastro";
    }

    @GetMapping(value = "/bibliotecas")
    public String telaLista(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        model.addAttribute("listaBibliotecas", bibliotecaService.obterTodos(responsavel));
        return "biblioteca/lista";
    }

    @GetMapping(value = "/biblioteca/excluir/{id}")
    public String excluir(@PathVariable Integer id) {

        bibliotecaService.excluir(id);

        return "redirect:/bibliotecas";
    }

    @PostMapping(value = "/biblioteca/incluir")
    public String incluir(Model model, Biblioteca biblioteca, @RequestParam String[] midiaIds, @SessionAttribute("resp") Responsavel responsavel) {
        List<Midia> listaMidias = new ArrayList<Midia>();
        biblioteca.setResponsavel(responsavel);
        for (String id : midiaIds) {
            Midia midia = midiaService.obterPorId(Integer.valueOf(id));
            listaMidias.add(midia);
        }
        biblioteca.setMidias(listaMidias);

        bibliotecaService.incluir(biblioteca);
        model.addAttribute("titulo", biblioteca.getTitulo());

        return telaLista(model, responsavel);
    }


}

