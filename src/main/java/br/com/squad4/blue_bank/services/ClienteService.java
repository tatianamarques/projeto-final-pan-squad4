package br.com.squad4.blue_bank.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad4.blue_bank.form.ClienteAtualizacaoForm;
import br.com.squad4.blue_bank.form.ClienteForm;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Endereco;
import br.com.squad4.blue_bank.repository.ClienteRepository;
import br.com.squad4.blue_bank.repository.EnderecoRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Transactional
	public Cliente salvar(ClienteForm cliente) {		
		return clienteRepository.save(cliente.toModel());		
	}
	
	
	public Optional<Cliente> buscarPorId(Long id) {		
		return clienteExiste(id);
	}


	
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}


	@Transactional
	public boolean deletar(Long id) {
		Optional<Cliente> cliente = buscarPorId(id);
		if(cliente.isPresent()) {
			clienteRepository.deleteById(id);		
			return true;
		}
		return false;
		
	}

	@Transactional
	public Optional<Cliente> atualizar(Long id, ClienteAtualizacaoForm clienteForm) {
		if(clienteExiste(id).isEmpty()) {
			return clienteExiste(id);
		}else {
			Cliente cliente = clienteExiste(id).get();		
			cliente.setDataNascimento(clienteForm.getDataNascimento());
			cliente.setEmail(clienteForm.getEmail());
			cliente.setNome(clienteForm.getNome());
			Endereco endereco = enderecoRepository.findByClienteId(id);
			endereco.setBairro(clienteForm.getEnderecoForm().getBairro());
			endereco.setCep(clienteForm.getEnderecoForm().getCep());
			endereco.setCidade(clienteForm.getEnderecoForm().getCidade());
			endereco.setComplemento(clienteForm.getEnderecoForm().getComplemento());
			endereco.setLogradouro(clienteForm.getEnderecoForm().getLogradouro());
			endereco.setNumero(clienteForm.getEnderecoForm().getNumero());
			endereco.setUf(clienteForm.getEnderecoForm().getUf());			
			return Optional.of(cliente);
		}
		
	}

	private Optional<Cliente> clienteExiste(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return cliente;
		}
		return Optional.empty();
	}
}
