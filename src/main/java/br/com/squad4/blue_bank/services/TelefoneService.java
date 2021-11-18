package br.com.squad4.blue_bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad4.blue_bank.dto.TelefoneDTO;
import br.com.squad4.blue_bank.model.Telefone;
import br.com.squad4.blue_bank.repository.ClienteRepository;
import br.com.squad4.blue_bank.repository.TelefoneRepository;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Telefone salvar( TelefoneDTO novoTelefone){

        Telefone telefone = novoTelefone.toModel(clienteRepository);

        telefoneRepository.save(telefone);


      return telefone;

    }



}
