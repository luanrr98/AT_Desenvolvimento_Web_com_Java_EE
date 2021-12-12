package br.edu.infnet.appbiblioteca;

import br.edu.infnet.appbiblioteca.model.domain.Requerente;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.RequerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class RequerenteLoader implements ApplicationRunner {


    @Autowired
    private RequerenteService requerenteService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Responsavel responsavel = new Responsavel();
        responsavel.setId(1);

        Requerente requerente = new Requerente();
        requerente.setResponsavel(responsavel);
        requerente.setNome("José Kakarotto");
        requerente.setEmail("joseK@mail.com");
        requerente.setApelido("Rotto89");
        requerenteService.incluir(requerente);


    }
}
