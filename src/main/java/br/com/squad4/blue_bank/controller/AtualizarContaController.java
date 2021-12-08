package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.AtualizarContaDTO;
import br.com.squad4.blue_bank.model.Conta;
import br.com.squad4.blue_bank.repository.ContaRepository;
import br.com.squad4.blue_bank.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/conta/{id}")
public class AtualizarContaController {

    @Autowired
    ContaRepository contaRepository;

     @PutMapping
    public ResponseEntity<?>atualizarConta(@PathVariable("id")Long id, @RequestBody @Valid AtualizarContaDTO request ){

          Optional<Conta> optional = contaRepository.findById(id);
          if(optional.isPresent()){
              Conta conta = request.toModelAtualizar(id, contaRepository);
              contaRepository.save(conta);
              return ResponseEntity.ok().build();

          }
              return ResponseEntity.notFound().build();
    }
}
