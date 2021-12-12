package br.edu.infnet.appbiblioteca.model.service;

import br.edu.infnet.appbiblioteca.client.EnderecoClient;
import br.edu.infnet.appbiblioteca.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoClient enderecoClient;

    public Endereco obterViaCep(String cep) {
        return enderecoClient.buscarCep(cep);

    }
}
