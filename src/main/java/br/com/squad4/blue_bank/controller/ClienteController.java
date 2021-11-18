package br.com.squad4.blue_bank.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.squad4.blue_bank.dto.ClienteDTO;
import br.com.squad4.blue_bank.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    
    @Autowired
    private ClienteService clienteService;
    
    


    @Transactional
    @PostMapping
    public ResponseEntity<ClienteDTO>criarCliente(@RequestBody @Valid ClienteDTO request ){

//        Cliente cliente = request.toModel(entityManager);

       clienteService.salvar(request);

        return ResponseEntity.ok().build();

    }
}
