package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.AgenciaDTO;
import br.com.squad4.blue_bank.dto.EnderecoAgenciaDTO;
import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.model.EnderecoAgencia;
import br.com.squad4.blue_bank.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/api/agencia")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @Transactional
    @PostMapping
    public Object criarAgencia(@RequestBody @Valid AgenciaDTO request,
                               UriComponentsBuilder builder){
        List<Agencia> lista = agenciaService.buscarAgencias();
        String erro = "Já existe agencia com esse número, tente novamente";
        for (Agencia agencia : lista){
            if(agencia.getNumeroAgencia().equals(request.getNumeroAgencia())){
                return erro;
            }
        }
        Agencia agencia = agenciaService.salvar(request);
        URI uri = builder.path("/agencia/{id}").buildAndExpand(agencia.getId()).toUri();
        return ResponseEntity.created(uri).body(new AgenciaDTO(agencia));
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public ResponseEntity<AgenciaDTO> editarAgencia(@PathVariable("id") Long id, @RequestBody @Valid AgenciaDTO request){
        Optional<Agencia> agencia = agenciaService.editar(request, id);
        if (agencia.isPresent()){
        return ResponseEntity.ok().build();}
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<Page<AgenciaDTO>> listarAgencias(@RequestParam(required = false) String numeroAgencia,
                                                        @PageableDefault(sort = "numeroAgencia",
                                                                direction = Sort.Direction.ASC,
                                                                page = 0,
                                                                size = 20)
                                                                Pageable paginacao) {
        if(numeroAgencia == null) {
            Page<Agencia> agencias = agenciaService.buscarTodas(paginacao);
            return ResponseEntity.ok(AgenciaDTO.converterParaListaDTO(agencias));
        }else {
            Page<Agencia> agencias = agenciaService.buscarPorNumero(numeroAgencia, paginacao);
            return ResponseEntity.ok(AgenciaDTO.converterParaListaDTO(agencias));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenciaDTO> buscarPorId(@PathVariable Long id){
        Optional<Agencia> agencia = agenciaService.buscarPorId(id);
        if(agencia.isPresent()){
            return ResponseEntity.ok(new AgenciaDTO(agencia.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/numero/{numeroAgencia}")
    public ResponseEntity<AgenciaDTO> buscarPorNumero(@PathVariable String numeroAgencia){
        Optional<Agencia> agencia = agenciaService.buscarPorNumero(numeroAgencia);
        if(agencia.isPresent()){
            return ResponseEntity.ok(new AgenciaDTO(agencia.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
