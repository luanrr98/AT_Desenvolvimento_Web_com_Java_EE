package br.edu.infnet.appbiblioteca;

import br.edu.infnet.appbiblioteca.model.domain.Anime;
import br.edu.infnet.appbiblioteca.model.domain.Jogo;
import br.edu.infnet.appbiblioteca.model.domain.Manga;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.exceptions.PlataformaInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.QuantidadeInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.TipoAnimacaoInvalidaException;
import br.edu.infnet.appbiblioteca.model.service.AnimeService;
import br.edu.infnet.appbiblioteca.model.service.JogoService;
import br.edu.infnet.appbiblioteca.model.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class MidiaLoader implements ApplicationRunner {

    @Autowired
    private MangaService mangaService;
    @Autowired
    private AnimeService animeService;
    @Autowired
    private JogoService jogoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            Responsavel responsavel = new Responsavel();
            responsavel.setId(1);

            Manga manga = new Manga("Uzumaki", "Horror", false, 10.0);
            manga.setQuantidadeCapitulos(20);
            manga.setQuantidadeVolumes(1);
            manga.setFrequenciaEstimadaLancamento("Quinzenal");
            manga.setResponsavel(responsavel);
            mangaService.incluir(manga);

            Anime anime = new Anime("Naruto", "Shonen", true, 10.0);
            anime.setTipoAnimacao("2D");
            anime.setNumeroEpisodios(220);
            anime.setNumeroTemporadas(5);
            anime.setResponsavel(responsavel);
            animeService.incluir(anime);

            Jogo jogo = new Jogo("Bloodstained", "MetroidVania", false, 10.0);
            jogo.setPlataforma("PC");
            jogo.setMultijogador(false);
            jogo.setEngine("Unreal Engine 4");
            jogo.setResponsavel(responsavel);
            jogoService.incluir(jogo);

        } catch (PlataformaInvalidaException | QuantidadeInvalidaException | TipoAnimacaoInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }


}
