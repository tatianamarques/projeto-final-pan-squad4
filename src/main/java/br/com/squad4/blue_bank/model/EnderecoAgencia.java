package br.com.squad4.blue_bank.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.squad4.blue_bank.enums.UF;

@Embeddable
public class EnderecoAgencia {

	private String logradouro;
	private String numeroEndereco;
	private String complemento;
	private String cidade;
	@Enumerated(EnumType.STRING)
	private UF uf;
	private String cep;
	private String bairro;
	
	public EnderecoAgencia(String logradouro, String numero, String complemento, String cidade, UF uf, String cep,
			String bairro) {
		this.logradouro = logradouro;
		this.numeroEndereco = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.bairro = bairro;
	}


	public EnderecoAgencia(String logradouro, String numero, String cidade, UF uf, String cep, String bairro) {
		this.logradouro = logradouro;
		this.numeroEndereco = numero;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.bairro = bairro;
	}

	public EnderecoAgencia() {

	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numeroEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public UF getUf() {
		return uf;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}
	
	
}
