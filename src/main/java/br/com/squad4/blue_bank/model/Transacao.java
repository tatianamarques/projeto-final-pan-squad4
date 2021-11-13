package br.com.squad4.blue_bank.model;

import javax.persistence.*;

import br.com.squad4.blue_bank.enums.TipoTransacao;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private TipoTransacao tipoTransacao;

    @ManyToMany
    @Column(nullable = false)
    private Conta conta;

    public Transacao(LocalDate data, BigDecimal valor, TipoTransacao tipoTransacao, Conta conta) {
        this.data = data;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.conta = conta;
    }

    public Transacao(){}

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public Conta getConta() {
        return conta;
    }
}
