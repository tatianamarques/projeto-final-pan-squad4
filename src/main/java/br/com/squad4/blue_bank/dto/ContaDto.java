package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.enums.TipoConta;
import br.com.squad4.blue_bank.model.Cliente;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaDto {

   private Long agenciaId;

    private Long clienteId;


    private String numero;


    private TipoConta tipoConta;


    private BigDecimal saldo;


    private BigDecimal saldoEspecial;


    private boolean estaBloqueada;


    private String senha;


    private LocalDate dataAbertura;


    public ContaDto(Long agenciaId,Long clienteId, String numero, TipoConta tipoConta, BigDecimal saldo, BigDecimal saldoEspecial, boolean estaBloqueada, String senha, LocalDate dataAbertura) {
        this.agenciaId= agenciaId;
        this.clienteId = clienteId;
        this.numero = numero;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.saldoEspecial = saldoEspecial;
        this.estaBloqueada = estaBloqueada;
        this.senha = senha;
        this.dataAbertura = dataAbertura;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldoEspecial() {
        return saldoEspecial;
    }

    public void setSaldoEspecial(BigDecimal saldoEspecial) {
        this.saldoEspecial = saldoEspecial;
    }

    public boolean isEstaBloqueada() {
        return estaBloqueada;
    }

    public void setEstaBloqueada(boolean estaBloqueada) {
        this.estaBloqueada = estaBloqueada;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public Long getAgenciaId() {
        return agenciaId;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
