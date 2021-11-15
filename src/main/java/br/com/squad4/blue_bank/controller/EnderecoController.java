package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.NovoEnderecoRequest;
import br.com.squad4.blue_bank.model.Endereco;
import br.com.squad4.blue_bank.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
   private EnderecoRepository enderecoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<?>criarEndereco(@RequestBody @Valid NovoEnderecoRequest request){
        Endereco endereco = request.toModel();

        enderecoRepository.save(endereco);

        return ResponseEntity.ok().build();

    }
}
