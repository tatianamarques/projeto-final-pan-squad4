package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.NovoClienteRequest;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @PostMapping
    public ResponseEntity<?>criarCliente(@RequestBody @Valid NovoClienteRequest request ){

        Cliente cliente = request.toModel(entityManager);

        clienteRepository.save(cliente);

        return ResponseEntity.ok().build();






    }
}
