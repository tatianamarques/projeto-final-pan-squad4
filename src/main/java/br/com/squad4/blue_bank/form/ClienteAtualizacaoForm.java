package br.com.squad4.blue_bank.form;

import java.time.LocalDate;

import br.com.squad4.blue_bank.model.Cliente;

public class ClienteAtualizacaoForm {
	
	private String nome;
	private LocalDate dataNascimento;
	private String email;
	private EnderecoForm enderecoForm;
	
	public ClienteAtualizacaoForm() {
	}

	public ClienteAtualizacaoForm(String nome, LocalDate dataNascimento, String email, EnderecoForm enderecoForm) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.enderecoForm = enderecoForm;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public EnderecoForm getEnderecoForm() {
		return enderecoForm;
	}
	
	public Cliente toModel() {
		Cliente cliente = new Cliente();
		cliente.setDataNascimento(dataNascimento);
		cliente.setEmail(email);
		cliente.setNome(nome);	
		cliente.setEndereco(enderecoForm.toModel());
		return cliente;
	}
	
	
	

}
