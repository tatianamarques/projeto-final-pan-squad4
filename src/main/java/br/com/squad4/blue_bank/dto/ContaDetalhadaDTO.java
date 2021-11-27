package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.enums.TipoConta;
import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Conta;
import java.math.BigDecimal;



public class ContaDetalhadaDTO {


        private Agencia agencia;


        private Cliente cliente;



        private String numero;


        private TipoConta tipoConta;


        private BigDecimal saldo;


        private BigDecimal saldoEspecial;


        private boolean estaBloqueada;


    public ContaDetalhadaDTO(Conta conta) {
        agencia = conta.getAgencia();
        cliente = conta.getCliente();
        numero = conta.getNumero();
        tipoConta = conta.getTipoConta();
        saldo = conta.getSaldo();
        saldoEspecial = conta.getSaldoEspecial();
        estaBloqueada = conta.isEstaBloqueada();
    }

    public Agencia getAgencia() {
        return agencia;
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
}
