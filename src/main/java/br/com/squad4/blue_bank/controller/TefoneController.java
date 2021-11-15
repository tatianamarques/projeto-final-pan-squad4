package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.NovoTelefoneRequest;

import br.com.squad4.blue_bank.model.Telefone;
import br.com.squad4.blue_bank.repository.TelefoneRepository;
import br.com.squad4.blue_bank.services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/telefone")
public class TefoneController {

    @Autowired
    TelefoneService telefoneService;

    @Transactional
    @PostMapping
    public ResponseEntity<?>criarEndereco(@RequestBody @Valid NovoTelefoneRequest telefoneRequest){

           telefoneService.salvar( telefoneRequest );

        return ResponseEntity.ok().build();




    }
}
