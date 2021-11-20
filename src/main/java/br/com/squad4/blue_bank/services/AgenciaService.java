package br.com.squad4.blue_bank.services;

import br.com.squad4.blue_bank.dto.AgenciaDTO;
import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public Agencia salvar(AgenciaDTO agenciaDTO){

        return agenciaRepository.save(agenciaDTO.toModel());
    }
}
