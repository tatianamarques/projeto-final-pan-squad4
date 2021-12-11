package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.enums.UF;
import br.com.squad4.blue_bank.model.EnderecoAgencia;

public class EnderecoAgenciaDTO {

    private String logradouro;
    private String numeroEndereco;
    private String complemento;
    private String cidade;
    private UF uf;
    private String cep;
    private String bairro;

    public EnderecoAgenciaDTO(EnderecoAgencia enderecoAgencia) {
        this.logradouro = enderecoAgencia.getLogradouro();
        this.numeroEndereco = enderecoAgencia.getNumero();
        this.complemento = enderecoAgencia.getComplemento();
        this.cidade = enderecoAgencia.getCidade();
        this.uf = enderecoAgencia.getUf();
        this.cep = enderecoAgencia.getCep();
        this.bairro = enderecoAgencia.getBairro();
    }
    public EnderecoAgenciaDTO(){}

    public EnderecoAgencia toModel(){
        return new EnderecoAgencia(this.logradouro, this.numeroEndereco, this.complemento, this.cidade, this.uf, this.cep, this.bairro);
    }


    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

}
