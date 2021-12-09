package br.com.squad4.blue_bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Gerente {

    private int id;
    private String nome;
    private String numeroAgencia;
    private String cidadeAgencia;

    public Gerente() {
    }

    public Gerente(int id, String nome, String numeroAgencia, String cidadeAgencia) {
        this.id = id;
        this.nome = nome;
        this.numeroAgencia = numeroAgencia;
        this.cidadeAgencia = cidadeAgencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getCidadeAgencia() {
        return cidadeAgencia;
    }

    public void setCidadeAgencia(String cidadeAgencia) {
        this.cidadeAgencia = cidadeAgencia;
    }
}