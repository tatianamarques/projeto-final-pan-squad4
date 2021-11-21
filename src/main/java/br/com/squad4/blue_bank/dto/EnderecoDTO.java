package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.model.Endereco;

public class EnderecoDTO {


    private String logradouro;


    private String numero;


    private String complemento;


    private String cep;

    private String bairro;

    private String cidade;

    public EnderecoDTO(String logradouro, String numero, String complemento, String cep, String bairro, String cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
    }
    
    public EnderecoDTO() {
    	
    }


    public Endereco toModel() {
    	

        return new Endereco(this.logradouro, this.numero, this.cep, this.bairro, this.cidade);
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

	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
