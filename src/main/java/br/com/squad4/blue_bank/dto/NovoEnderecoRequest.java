package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.model.Endereco;

import javax.persistence.Column;

public class NovoEnderecoRequest {


    private String logradouro;


    private String numero;


    private String complemento;


    private String cep;

    private String bairro;

    private String cidade;

    public NovoEnderecoRequest(String logradouro, String numero, String complemento, String cep, String bairro, String cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
    }


    public Endereco toModel() {

        return new Endereco(this.logradouro, this.numero, this.cep, this.bairro, this.cidade);
    }
}
