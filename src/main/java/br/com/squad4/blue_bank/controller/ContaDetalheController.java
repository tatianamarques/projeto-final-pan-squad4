package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.ContaDetalhadaDTO;
import br.com.squad4.blue_bank.model.Conta;
import br.com.squad4.blue_bank.services.ContaService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conta/{id}")
public class ContaDetalheController {

     @Autowired
     private ContaService service;

    @GetMapping
    public ResponseEntity<?> detalharCliente(@PathVariable Long id ) throws ObjectNotFoundException {
        Conta buscarConta = service.find(id);
        if(buscarConta == null){
            return ResponseEntity.notFound().build();
        }

        ContaDetalhadaDTO contaDetalhadaDTO = new ContaDetalhadaDTO(buscarConta);
        return ResponseEntity.ok().body(contaDetalhadaDTO);

    }

}
