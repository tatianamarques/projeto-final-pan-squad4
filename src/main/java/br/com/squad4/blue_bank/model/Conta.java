package br.com.squad4.blue_bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Cliente cliente;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private TipoConta tipoConta;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Column
    private BigDecimal saldoEspecial;

    @Column(nullable = false)
    private boolean estaBloqueada;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDate dataAbertura;

    @ManyToMany
    @JoinTable(name = "conta_transacao", joinColumns = @JoinColumn(name = "conta_id", referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name="transacao_id", referencedColumnName = "id"))
    private List<Transacao> transacoes = new ArrayList<>();


    public Conta(Cliente cliente, String numero, TipoConta tipoConta, BigDecimal saldo, BigDecimal saldoEspecial, boolean estaBloqueada, String senha, LocalDate dataAbertura) {
        this.cliente = cliente;
        this.numero = numero;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.saldoEspecial = saldoEspecial;
        this.estaBloqueada = estaBloqueada;
        this.senha = senha;
        this.dataAbertura = dataAbertura;
    }

    @Deprecated
    public Conta(){}

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumero() {
        return numero;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getSaldoEspecial() {
        return saldoEspecial;
    }

    public boolean isEstaBloqueada() {
        return estaBloqueada;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
