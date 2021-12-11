package br.com.squad4.blue_bank.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.squad4.blue_bank.enums.UF;
import br.com.squad4.blue_bank.model.Endereco;
import br.com.squad4.blue_bank.utils.Formatacoes;

public class EnderecoForm {
	
	@NotNull
	@NotBlank
	private String logradouro;
	@NotNull
	@NotBlank
	private String numero;
	private String complemento;
	@NotNull
	@NotBlank
	private String cep;
	@NotNull
	@NotBlank
	private String bairro;
	@NotNull
	@NotBlank
	private String cidade;
	@NotNull
	@NotBlank
	@Size(min = 2,max = 2)
	private UF uf;

	public EnderecoForm() {
	}

	public EnderecoForm(String logradouro,String numero, String complemento, 
			            String cep,String bairro,String cidade, UF uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = Formatacoes.retirarPontosHifen(cep);
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
    }

	public Endereco toModel() {
		return new Endereco(logradouro, numero, Formatacoes.retirarPontosHifen(cep), complemento, bairro, cidade, uf);
	}
	
	

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "EnderecoForm [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", cep=" + cep + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + "]";
	}
	
	
	
}
