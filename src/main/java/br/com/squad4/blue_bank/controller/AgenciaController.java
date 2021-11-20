package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.AgenciaDTO;
import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value= "/agencia")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @Transactional
    @PostMapping
    public ResponseEntity<AgenciaDTO>criarAgencia(@RequestBody @Valid AgenciaDTO request){
        //System.out.println(request);
        agenciaService.salvar(request);
        return ResponseEntity.ok().build();
    }

//    public void criarAgencia(@RequestBody AgenciaDTO agenciaDTO){
//        var agencia = new Agencia();
//        agencia.setNumero(agenciaDTO.getNumeroAgencia());
//        agencia.setTelefone(agenciaDTO.getTelefoneDTO());
//        agencia.setEndereco(agenciaDTO.getEnderecoDTO());
//
//    }
}
