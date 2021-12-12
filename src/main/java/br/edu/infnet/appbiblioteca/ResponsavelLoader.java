package br.edu.infnet.appbiblioteca;

import br.edu.infnet.appbiblioteca.model.domain.Endereco;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ResponsavelLoader implements ApplicationRunner {

    @Autowired
    private ResponsavelService responsavelSevice;

    @Override
    public void run(ApplicationArguments args) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua das flores");
        endereco.setNumero(666);
        endereco.setComplemento("Casa de madeira");
        endereco.setBairro("Cerejeiras");
        endereco.setLocalidade("Terra dos Fantasmas");
        endereco.setUf("JP");
        endereco.setCep("67423000");

        Responsavel responsavel = new Responsavel();
        responsavel.setEndereco(endereco);
        responsavel.setNome("Enma Dai Oh");
        responsavel.setEmail("enma@mail.com");
        responsavel.setSenha("123");
        responsavel.setIdade(100000);
        responsavel.setAdmin(true);

        responsavelSevice.incluir(responsavel);


    }
}
