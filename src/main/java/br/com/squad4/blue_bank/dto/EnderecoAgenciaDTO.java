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

    public EnderecoAgenciaDTO(String logradouro, String numeroEndereco, String cidade, UF uf, String cep, String bairro) {
        this.logradouro = logradouro;
        this.numeroEndereco = numeroEndereco;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.bairro = bairro;
    }
    public EnderecoAgenciaDTO(){}

    public EnderecoAgencia toModel(){
        return new EnderecoAgencia(this.logradouro, this.numeroEndereco,  this.cidade, this.uf, this.cep, this.bairro);
    }

    @Override
    public String toString() {
        return "EnderecoAgenciaDTO{" +
                "logradouro='" + logradouro + '\'' +
                ", numeroEndereco='" + numeroEndereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf=" + uf +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
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
