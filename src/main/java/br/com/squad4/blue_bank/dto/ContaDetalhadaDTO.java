package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.enums.TipoConta;
import br.com.squad4.blue_bank.model.Conta;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


public class ContaDetalhadaDTO {


        //private AgenciaDTO agenciaDTO;
        private String numeroAgencia;

        private ClienteDTO clienteDTO;



        private String numero;


        private TipoConta tipoConta;


        private BigDecimal saldo;


        private BigDecimal saldoEspecial;


        private boolean estaBloqueada;


    public ContaDetalhadaDTO(Conta conta) {

        numeroAgencia = conta.getAgencia().getNumeroAgencia();
        clienteDTO = new ClienteDTO(conta.getCliente()) ;
        numero = conta.getNumero();
        tipoConta = conta.getTipoConta();
        saldo = conta.getSaldo();
        saldoEspecial = conta.getSaldoEspecial();
        estaBloqueada = conta.isEstaBloqueada();


    }

    public static List<ContaDetalhadaDTO> toModel(List<Conta>contas){
        return contas.stream().map(ContaDetalhadaDTO::new).collect(Collectors.toList());
    }

    /*public AgenciaDTO getAgenciaDTO() {
        return agenciaDTO;
    }*/

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
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

    public String getNumeroAgencia() {
        return numeroAgencia;
    }
}
