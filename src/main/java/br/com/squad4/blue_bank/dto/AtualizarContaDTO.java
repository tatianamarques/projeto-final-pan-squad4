package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.enums.TipoConta;
import br.com.squad4.blue_bank.model.Conta;
import br.com.squad4.blue_bank.repository.ContaRepository;

public class AtualizarContaDTO {

    private TipoConta tipoConta;

    private boolean estaBloqueada;

    public AtualizarContaDTO(TipoConta tipoConta, boolean estaBloqueada) {
        this.tipoConta = tipoConta;
        this.estaBloqueada = estaBloqueada;
    }


    public Conta toModelAtualizar(Long id, ContaRepository contaRepository) {
        Conta conta = contaRepository.getById(id);
        conta.setTipoConta(this.tipoConta);
        conta.setEstaBloqueada(this.estaBloqueada);

        return conta;
    }
}
