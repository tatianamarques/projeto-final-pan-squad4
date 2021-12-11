package br.com.squad4.blue_bank.services;

import br.com.squad4.blue_bank.dto.ContaDetalhadaDTO;
import br.com.squad4.blue_bank.dto.ContaDto;
import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Conta;
import br.com.squad4.blue_bank.repository.AgenciaRepository;
import br.com.squad4.blue_bank.repository.ClienteRepository;
import br.com.squad4.blue_bank.repository.ContaRepository;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;



    public Conta ToModel(ContaDto conta, ClienteRepository clienteRepository, AgenciaRepository agenciaRepository) {
        Agencia agencia = agenciaRepository.getById(conta.getAgenciaId());
        Cliente cliente = clienteRepository.getById(conta.getClienteId());

        return new Conta(agencia,cliente, conta.getNumero(),conta.getTipoConta(), conta.getSaldo(), conta.getSaldoEspecial(),conta.isEstaBloqueada(), conta.getSenha(),conta.getDataAbertura());


    }

    public Conta insert(Conta conta) {
            return repository.save(conta);
    }

    @JsonBackReference
    public Conta find(Long id) throws ObjectNotFoundException {
        Optional<Conta> conta = repository.findById(id);
        return conta.orElseThrow(() -> new ObjectNotFoundException(
                "Conta não encontrado! Id: " + id + ", Tipo: " + Conta.class.getName()));
    }

    public List<Conta> buscarContas() {
        return repository.findAll();
    }

}
