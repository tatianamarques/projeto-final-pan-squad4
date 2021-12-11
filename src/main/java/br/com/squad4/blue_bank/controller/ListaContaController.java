package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.ContaDetalhadaDTO;
import br.com.squad4.blue_bank.model.Conta;
import br.com.squad4.blue_bank.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/api/contas")
public class ListaContaController {

     @Autowired
    private ContaService service;

     @GetMapping
    public List<ContaDetalhadaDTO>lista(){
        List<Conta>contas = service.buscarContas();
        return ContaDetalhadaDTO.toModel(contas);
    }


}
