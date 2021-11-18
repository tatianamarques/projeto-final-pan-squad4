package br.com.squad4.blue_bank.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.squad4.blue_bank.dto.TelefoneDTO;
import br.com.squad4.blue_bank.services.TelefoneService;

@RestController
@RequestMapping("/telefone")
public class TefoneController {

    @Autowired
    TelefoneService telefoneService;

    @Transactional
    @PostMapping
    public ResponseEntity<?>criarEndereco(@RequestBody @Valid TelefoneDTO telefoneRequest){

           telefoneService.salvar( telefoneRequest );

        return ResponseEntity.ok().build();




    }
}
