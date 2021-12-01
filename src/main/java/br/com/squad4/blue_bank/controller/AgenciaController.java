package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.dto.AgenciaDTO;
import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/api/agencia")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @Transactional
    @PostMapping
    public ResponseEntity<AgenciaDTO>criarAgencia(@RequestBody @Valid AgenciaDTO request){
        List<Agencia> lista = agenciaService.buscarAgencias();
        for (Agencia agencia : lista){
            if(agencia.getNumeroAgencia().equals(request.getNumeroAgencia())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }
        agenciaService.salvar(request);
        return ResponseEntity.ok().build();
    }


    @Transactional
    @PutMapping(value = "/{id}")
    public ResponseEntity<AgenciaDTO> editarAgencia(@PathVariable("id") Long id, @RequestBody @Valid AgenciaDTO request){
        Optional<Agencia> agencia = agenciaService.editar(request, id);
        if (agencia.isPresent()){
        return ResponseEntity.ok().build();}
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/listartodas")
    public ResponseEntity<List<Agencia>> listarAgencias(){
        List<Agencia> lista = agenciaService.buscarAgencias();
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AgenciaDTO> buscarPorId(@PathVariable Long id){
        Optional<Agencia> agencia = agenciaService.buscarPorId(id);
        if(agencia.isPresent()){
            return ResponseEntity.ok(new AgenciaDTO(agencia.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/conta/{numeroAgencia}")
    public ResponseEntity<AgenciaDTO> buscarPorNumero(@PathVariable String numeroAgencia){
        List<Agencia> lista = agenciaService.buscarAgencias();
        for(Agencia agencia: lista){
            if(agencia.getNumeroAgencia().equals(numeroAgencia)){
                return ResponseEntity.ok(new AgenciaDTO(agencia));
            }
        }
        return ResponseEntity.notFound().build();
    }
}
