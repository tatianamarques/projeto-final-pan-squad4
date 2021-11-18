package br.com.squad4.blue_bank.dto;

import java.time.LocalDate;

import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Endereco;

public class ClienteDTO {



	    private String nome;

	    private String cpf;

	    private LocalDate dataNascimento;

	    private String email;

	    private TelefoneDTO telefoneDTO;

	    private Long conta;

	    private EnderecoDTO enderecoDTO;
	    


	    
	    
	    public ClienteDTO(Cliente cliente) {
			this.nome = cliente.getNome();
			this.cpf = cliente.getCpf();
			this.dataNascimento = cliente.getDataNascimento();
			this.email = cliente.getEmail();
		}

		public ClienteDTO() {
		}

		public ClienteDTO(String nome, String cpf, LocalDate dataNascimento, String email, TelefoneDTO telefone, EnderecoDTO enderecoId) {
	        this.nome = nome;
	        this.cpf = cpf;
	        this.dataNascimento = dataNascimento;
	        this.email = email;
	        this.enderecoDTO = enderecoId;
	        this.telefoneDTO = telefone;
	    }

	    public Cliente toModel() {
	    	Endereco endereco = enderecoDTO.toModel();
	    	Cliente cliente = new Cliente();
	    	cliente.setCpf(cpf);
	    	cliente.setNome(nome);
	    	cliente.setEndereco(endereco);
	    	cliente.setDataNascimento(dataNascimento);
	    	cliente.setEmail(email);
	    	//cliente. (telefoneDTO.toModel()); IMPLEMENTAR QUANDO TIVER O TELEFONE
	    	
	    	
	    	

	        return cliente;
	    }

		public Long getConta() {
			return conta;
		}

		public void setConta(Long conta) {
			this.conta = conta;
		}
	}

	


