package br.com.squad4.blue_bank.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.squad4.blue_bank.dto.ContaDto;
import br.com.squad4.blue_bank.dto.TransacaoDTO;
import br.com.squad4.blue_bank.model.Conta;
import br.com.squad4.blue_bank.model.Transacao;
import br.com.squad4.blue_bank.repository.AgenciaRepository;
import br.com.squad4.blue_bank.repository.ClienteRepository;
import br.com.squad4.blue_bank.services.ContaService;
import br.com.squad4.blue_bank.services.TransacaoService;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AgenciaRepository agenciaRepository;
    
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<?>insert(@RequestBody @Valid ContaDto request){
        Conta conta = service.ToModel(request, clienteRepository, agenciaRepository);
        conta = service.insert(conta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
    
    @GetMapping("/transacoes/{contaId}")
    public ResponseEntity<Page<TransacaoDTO>> historico(@PathVariable Long contaId,Pageable pageable){
    	Page<Transacao> historico = transacaoService.historicoTransacoes(contaId, pageable);
    	return ResponseEntity.ok(TransacaoDTO.converterLista(historico));
    }
}
