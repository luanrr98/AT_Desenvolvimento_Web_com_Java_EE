package br.edu.infnet.appbiblioteca.controllers;

import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.MidiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MidiaController {

    @Autowired
    private MidiaService midiaService;


    @GetMapping(value = "/midias")
    public String telaLista(Model model, @SessionAttribute("resp") Responsavel responsavel) {
        model.addAttribute("listaMidias", midiaService.obterTodos(responsavel));
        return "midia/lista";
    }

    @GetMapping(value = "/midia/excluir/{id}")
    public String excluir(Model model,@PathVariable Integer id,@SessionAttribute("resp") Responsavel responsavel) {
        try {
            midiaService.excluir(id);

        }catch (Exception e) {
            model.addAttribute("msg", "Não foi possível realizar a exclusão desta Midia!");
        }

        return telaLista(model, responsavel);
    }


}

