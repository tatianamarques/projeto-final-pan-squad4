package br.com.squad4.blue_bank.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.utils.Formatacoes;

public class ClienteDetalhadoDTO {

	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String email;
	private List<TelefoneDTO> listaTelefoneDTO = new ArrayList<TelefoneDTO>();	
	private EnderecoDTO enderecoDTO;

	public ClienteDetalhadoDTO(Cliente cliente) {
		this.enderecoDTO = new EnderecoDTO(cliente.getEndereco());
		this.nome = cliente.getNome();
		this.cpf = Formatacoes.mascaraCpf(cliente.getCpf());
		this.dataNascimento = cliente.getDataNascimento();
		this.email = cliente.getEmail();
		this.listaTelefoneDTO = TelefoneDTO.listaTelefoneDTO(cliente.getTelefones());
		
	}

	public ClienteDetalhadoDTO() {
	}
	

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public List<TelefoneDTO> getListaTelefoneDTO() {
		return listaTelefoneDTO;
	}

	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}
	
}
