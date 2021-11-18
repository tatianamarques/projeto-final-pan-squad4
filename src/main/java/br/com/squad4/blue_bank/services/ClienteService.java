package br.com.squad4.blue_bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad4.blue_bank.dto.ClienteDTO;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(ClienteDTO cliente) {
		
		return clienteRepository.save(cliente.toModel());
		
	}

}
