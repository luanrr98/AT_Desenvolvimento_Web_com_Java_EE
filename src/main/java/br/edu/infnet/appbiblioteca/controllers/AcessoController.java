package br.edu.infnet.appbiblioteca.controllers;

import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@SessionAttributes("resp")
@Controller
public class AcessoController {

    @Autowired
    private ResponsavelService responsavelService;
    @Autowired
    private RequerenteService requerenteService;
    @Autowired
    private BibliotecaService bibliotecaService;
    @Autowired
    private MangaService mangaService;
    @Autowired
    private AnimeService animeService;
    @Autowired
    private JogoService jogoService;
    @Autowired
    private MidiaService midiaService;

    @GetMapping(value = "/")
    public String telaIndex() {
        return "index";
    }

    @GetMapping(value = "/disc")
    public String telaHome() {
        return "disc";
    }

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String telaLogout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("resp");

        return "redirect:/";
    }

    @PostMapping(value = "/login")
    public String logar(Model model, @RequestParam String email, @RequestParam String senha) {
        Responsavel responsavel = responsavelService.autenticar(email, senha);

        if (responsavel != null) {
            model.addAttribute("resp", responsavel);
            return "index";
        }

        model.addAttribute("msg", email + ", não foi possível autenticar! credenciais inválidas!");
        return "login";
    }

    @GetMapping("/info")
    public String telaInfo(Model model){
        Map<String, Integer> mapInfo = new LinkedHashMap<String, Integer>();

        mapInfo.put("Responsaveis", responsavelService.obterQtd());
        mapInfo.put("Requerentes", requerenteService.obterQtd());
        mapInfo.put("Bibliotecas", bibliotecaService.obterQtd());
        mapInfo.put("Mangas", mangaService.obterQtd());
        mapInfo.put("Animes", animeService.obterQtd());
        mapInfo.put("Jogos", jogoService.obterQtd());
        mapInfo.put("Total de Midias", midiaService.obterQtd());

        model.addAttribute("map", mapInfo);

        return "info";


    }

}
