package br.com.squad4.blue_bank.dto;
import java.io.Serializable;

import org.springframework.data.domain.Page;

import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.utils.Formatacoes;
public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cpf;
	
	public ClienteDTO() {
	}
		
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = Formatacoes.mascaraCpf(cliente.getCpf());
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public static Page<ClienteDTO> converterParaListaDTO(Page<Cliente> clientes) {
		
		return clientes.map(ClienteDTO::new);
	}
}