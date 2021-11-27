package br.com.squad4.blue_bank.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.squad4.blue_bank.model.Cliente;

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
		this.cpf = cliente.getCpf();
	}

	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}



		public void setConta(Long conta) {
			this.conta = conta;
		}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TelefoneDTO getTelefoneDTO() {
		return telefoneDTO;
	}

	public void setTelefoneDTO(TelefoneDTO telefoneDTO) {
		this.telefoneDTO = telefoneDTO;
	}

	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}

	public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;

	}
}


	public static List<ClienteDTO> converterParaListaDTO(List<Cliente> clientes) {
		
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

}
