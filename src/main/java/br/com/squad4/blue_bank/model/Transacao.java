package br.com.squad4.blue_bank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.squad4.blue_bank.enums.TipoTransacao;

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
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @ManyToOne 
    private Conta conta;

    public Transacao(BigDecimal valor, TipoTransacao tipoTransacao, Conta conta) {
        this.data = LocalDate.now();
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
