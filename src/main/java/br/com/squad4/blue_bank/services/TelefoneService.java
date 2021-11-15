package br.com.squad4.blue_bank.services;

import br.com.squad4.blue_bank.dto.NovoTelefoneRequest;
import br.com.squad4.blue_bank.model.Telefone;
import br.com.squad4.blue_bank.repository.ClienteRepository;
import br.com.squad4.blue_bank.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Telefone salvar( NovoTelefoneRequest novoTelefone){

        Telefone telefone = novoTelefone.toModel(clienteRepository);

        telefoneRepository.save(telefone);


      return telefone;

    }



}
