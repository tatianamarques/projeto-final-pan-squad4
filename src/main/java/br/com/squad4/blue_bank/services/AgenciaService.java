package br.com.squad4.blue_bank.services;

import br.com.squad4.blue_bank.dto.AgenciaDTO;
import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.model.EnderecoAgencia;
import br.com.squad4.blue_bank.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public Agencia salvar(AgenciaDTO agenciaDTO) {

        return agenciaRepository.save(agenciaDTO.toModel());
    }


    public Optional<Agencia> editar(AgenciaDTO agenciaDTO, Long id) {
        Optional<Agencia> agencia = agenciaRepository.findById(id);
        if (agencia.isPresent()) {
            agencia.get().setEndereco(agenciaDTO.getEnderecoDTO().toModel());
            agencia.get().setTelefone(agenciaDTO.getTelefoneDTO().toModel());
            return agencia;
        }
        return Optional.empty();
    }


    public Optional<Agencia> buscarPorId(Long id){
        Optional<Agencia> agencia = agenciaRepository.findById(id);
        if(agencia.isEmpty()){
            return Optional.empty();
        }
        return agencia;
    }

    public List<Agencia> buscarAgencias() {
        return agenciaRepository.findAll();
    }

    public Page<Agencia> buscarTodas(Pageable paginacao) {
        return agenciaRepository.findAll(paginacao);
    }

    private Optional<Agencia> agenciaExiste(Long id) {
        Optional<Agencia> agencia = agenciaRepository.findById(id);
        if (agencia.isPresent()) {
            return agencia;
        }
        return Optional.empty();
    }


    public Page<Agencia> buscarPorNumero(String numeroAgencia, Pageable paginacao) {
        return agenciaRepository.findByNumeroAgenciaContainingIgnoreCase(numeroAgencia, paginacao);
    }

    public Optional<Agencia> buscarPorNumero(String numeroAgencia) {
        Optional<Agencia> agencia = agenciaRepository.findByNumeroAgencia(numeroAgencia);
        if (agencia.isEmpty()) {
            return Optional.empty();
        }
        return agencia;
    }

}
