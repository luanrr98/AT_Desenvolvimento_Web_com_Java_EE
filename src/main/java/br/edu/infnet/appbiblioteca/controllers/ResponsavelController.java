package br.edu.infnet.appbiblioteca.controllers;

import br.edu.infnet.appbiblioteca.model.domain.Endereco;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.EnderecoService;
import br.edu.infnet.appbiblioteca.model.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/responsavel")
    public String telaCadastro() {
        return "responsavel/cadastro";
    }

    @GetMapping(value = "/responsaveis")
    public String telaLista(Model model) {
        model.addAttribute("listaResponsaveis", responsavelService.obterTodos());
        return "responsavel/lista";
    }

    @GetMapping(value = "/responsavel/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        responsavelService.excluir(id);
        return "redirect:/responsaveis";
    }

    @PostMapping(value = "/responsavel/incluir")
    public String incluir(Model model, Responsavel responsavel, Endereco endereco) {
        responsavel.setEndereco(endereco);
        responsavelService.incluir(responsavel);

        return "index";
    }

    @PostMapping(value = "/cep")
    public String cep(Model model, @RequestParam String cep) {
        model.addAttribute("endereco", enderecoService.obterViaCep(cep));
        return "responsavel/cadastro";
    }


}

