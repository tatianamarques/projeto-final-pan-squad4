package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Endereco;
import br.com.squad4.blue_bank.model.Telefone;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import java.time.LocalDate;

public class NovoClienteRequest {


    private String nome;

    private String cpf;

    private LocalDate dataNascimento;

    private String email;

    private Long telefoneId;

    private Long conta;

    private Long enderecoId;


    public NovoClienteRequest(String nome, String cpf, LocalDate dataNascimento, String email, Long telefoneId, Long enderecoId) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefoneId = telefoneId;
        this.enderecoId = enderecoId;
    }

    public Cliente toModel(EntityManager entityManager) {

        Endereco endereco = entityManager.find(Endereco.class, enderecoId);
        Telefone telefone = entityManager.find(Telefone.class, telefoneId);

        return new Cliente(this.nome, this.cpf,endereco, this.dataNascimento, this.email, telefone);
    }
}
