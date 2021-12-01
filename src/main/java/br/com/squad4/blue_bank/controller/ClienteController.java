package br.com.squad4.blue_bank.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.squad4.blue_bank.dto.ClienteDTO;
import br.com.squad4.blue_bank.dto.ClienteDetalhadoDTO;
import br.com.squad4.blue_bank.form.ClienteAtualizacaoForm;
import br.com.squad4.blue_bank.form.ClienteForm;
import br.com.squad4.blue_bank.form.TelefoneForm;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.services.ClienteService;
import br.com.squad4.blue_bank.services.TelefoneService;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private TelefoneService telefoneService;

	@PostMapping
	public ResponseEntity<ClienteDetalhadoDTO> salvar(@RequestBody @Valid ClienteForm clienteForm,
			UriComponentsBuilder builder) {
		Cliente cliente = clienteService.salvar(clienteForm);
		URI uri = builder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDetalhadoDTO(cliente));
	}

	@PostMapping("/telefone")
	public ResponseEntity<ClienteDetalhadoDTO> salvarTelefone(@RequestBody @Valid TelefoneForm telefoneForm,
			UriComponentsBuilder builder) {
		Optional<Cliente> cliente = clienteService.buscarPorId(telefoneForm.getIdCliente());
		telefoneService.salvar(telefoneForm, cliente);
		URI uri = builder.path("/cliente/{id}").buildAndExpand(cliente.get().getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDetalhadoDTO(cliente.get()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDetalhadoDTO> buscarPorId(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.buscarPorId(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDetalhadoDTO(cliente.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> buscarTodos(@RequestParam(required = false) String nome,			                                            
			                                            @PageableDefault(sort = "nome",
			                                                             direction = Direction.ASC,
			                                                             page = 0,
			                                                             size = 20)
	                                                    Pageable paginacao) {
		if(nome == null) {
			Page<Cliente> clientes = clienteService.buscarTodos(paginacao);
			return ResponseEntity.ok(ClienteDTO.converterParaListaDTO(clientes));			
		}else {
			Page<Cliente> clientes = clienteService.buscarPorNome(nome, paginacao);
			return ResponseEntity.ok(ClienteDTO.converterParaListaDTO(clientes));	
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		if (clienteService.deletar(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/telefone/{id}")
	public ResponseEntity<?> deletarTelefone(@PathVariable Long id) {
		if (telefoneService.deletar(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDetalhadoDTO> atualizar(@RequestBody @Valid ClienteAtualizacaoForm clienteForm,
			                                            @PathVariable Long id) {		
		Optional<Cliente> cliente = clienteService.atualizar(id,clienteForm);
		if(cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new ClienteDetalhadoDTO(cliente.get()));
	}
	
	@GetMapping("/cpf/")
	public ResponseEntity<ClienteDetalhadoDTO> buscarPorCpf(@PathVariable String cpf){
		Optional<Cliente> cliente = clienteService.buscarClientePorCpf(cpf);
		if(cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new ClienteDetalhadoDTO(cliente.get()));
	}
	

	

}
