package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.enums.UF;
import br.com.squad4.blue_bank.model.Endereco;

public class EnderecoDTO {

    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;    
    private String bairro;
    private String cidade;
    private UF uf;
    
    public EnderecoDTO() {
	}
    
    public EnderecoDTO(Endereco endereco) {
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.cep = endereco.getCep();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.uf = endereco.getUf();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public UF getUf() {
		return uf;
	}	

}
