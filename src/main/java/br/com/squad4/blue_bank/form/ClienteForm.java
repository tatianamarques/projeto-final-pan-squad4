package br.com.squad4.blue_bank.form;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Endereco;
import br.com.squad4.blue_bank.model.Telefone;
import br.com.squad4.blue_bank.utils.Formatacoes;
import br.com.squad4.blue_bank.validacoes.CpfUnico;
import br.com.squad4.blue_bank.validacoes.EmailUnico;


public class ClienteForm {
	
	@NotBlank
	@NotNull
	@Size(min = 10,max = 100)
	private String nome;
	@CpfUnico(message = "O CPF informado já está cadastrado!")
	@CPF
	private String cpf;	
	private LocalDate dataNascimento;
	@Email
	@EmailUnico(message = "O e-mail informado já está cadastrado!")
	private String email;
	private EnderecoForm enderecoForm = new EnderecoForm();
	private TelefoneForm telefoneForm = new TelefoneForm();
	public ClienteForm() {
	}
	
	public ClienteForm(String nome, String cpf, LocalDate dataNascimento, 
			           String email, TelefoneForm telefoneForm, EnderecoForm enderecoForm) {
        this.nome = nome;
        this.cpf = Formatacoes.retirarPontosHifen(cpf);
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.enderecoForm = enderecoForm;
        this.telefoneForm = telefoneForm;
    }
	

	public Cliente toModel() {
		Endereco endereco = enderecoForm.toModel();
		Telefone telefone = telefoneForm.toModel();
		Cliente cliente = new Cliente(nome, Formatacoes.retirarPontosHifen(cpf), endereco, dataNascimento, email, telefone);
		endereco.setCliente(cliente);
		telefone.setCliente(cliente);
		return cliente;
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

	public EnderecoForm getEnderecoForm() {
		return enderecoForm;
	}

	public TelefoneForm getTelefoneForm() {
		return telefoneForm;
	}
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnderecoForm(EnderecoForm enderecoForm) {
		this.enderecoForm = enderecoForm;
	}

	public void setTelefoneForm(TelefoneForm telefoneForm) {
		this.telefoneForm = telefoneForm;
	}

	@Override
	public String toString() {
		return "ClienteForm [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email
				+ ", enderecoForm=" + enderecoForm + ", telefoneForm=" + telefoneForm + "]";
	}
	

}
