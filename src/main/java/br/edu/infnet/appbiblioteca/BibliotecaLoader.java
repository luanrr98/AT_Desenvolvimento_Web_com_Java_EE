package br.edu.infnet.appbiblioteca;

import br.edu.infnet.appbiblioteca.model.domain.*;
import br.edu.infnet.appbiblioteca.model.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(4)
public class BibliotecaLoader implements ApplicationRunner {

    @Autowired
    private BibliotecaService bibliotecaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Responsavel responsavel = new Responsavel();
        responsavel.setId(1);

        Requerente requerente = new Requerente();
        requerente.setId(1);

        Manga manga = new Manga();
        manga.setId(1);

        Anime anime = new Anime();
        anime.setId(2);

        Jogo jogo = new Jogo();
        jogo.setId(3);

        List<Midia> midias = new ArrayList<Midia>();
        midias.add(manga);
        midias.add(anime);
        midias.add(jogo);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setTitulo("Biblioteca Principal Loader");
        biblioteca.setVisibilidade("Pública");
        biblioteca.setResponsavel(responsavel);
        biblioteca.setRequerente(requerente);
        biblioteca.setMidias(midias);

        bibliotecaService.incluir(biblioteca);


    }


}
