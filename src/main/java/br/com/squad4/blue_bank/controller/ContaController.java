package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.ContaDto;
import br.com.squad4.blue_bank.model.Conta;
import br.com.squad4.blue_bank.repository.AgenciaRepository;
import br.com.squad4.blue_bank.repository.ClienteRepository;
import br.com.squad4.blue_bank.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AgenciaRepository agenciaRepository;

    @PostMapping
    public ResponseEntity<?>insert(@RequestBody @Valid ContaDto request){
        Conta conta = service.ToModel(request, clienteRepository, agenciaRepository);
        conta = service.insert(conta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
