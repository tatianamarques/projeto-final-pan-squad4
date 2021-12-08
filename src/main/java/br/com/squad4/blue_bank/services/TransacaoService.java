package br.com.squad4.blue_bank.services;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.squad4.blue_bank.enums.TipoTransacao;
import br.com.squad4.blue_bank.model.Conta;
import br.com.squad4.blue_bank.model.Transacao;
import br.com.squad4.blue_bank.repository.ContaRepository;
import br.com.squad4.blue_bank.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Transactional
	public void depositar(Long contaId, BigDecimal valor) {
		Optional<Conta> conta = contaExiste(contaId);
		if (conta.isPresent()) {
			efetuarDeposito(conta.get(), valor);
		}
	}

	@Transactional
	public boolean sacar(Long contaId, BigDecimal valor) {
		Optional<Conta> conta = contaExiste(contaId);
		if (conta.isPresent()) {
			if (saquePermitido(conta.get(), valor)) {
				efetuarSaque(conta.get(), valor);
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	@Transactional
	public boolean transferencia(Long idContaDeposito, Long idContaSaque, BigDecimal valor) {
		Optional<Conta> contaDeposito = contaExiste(idContaDeposito);
		Optional<Conta> contaSaque = contaExiste(idContaSaque);
		if (contaDeposito.isPresent() && contaSaque.isPresent()) {
			if (saquePermitido(contaSaque.get(), valor)) {
				efetuarSaque(contaSaque.get(), valor);
				efetuarDeposito(contaDeposito.get(), valor);
				return true;
			}
		}
		return false;
	}

	private Optional<Conta> contaExiste(Long contaId) {
		Optional<Conta> conta = contaRepository.findById(contaId);
		if (conta.isPresent()) {
			return conta;
		} else {
			return Optional.empty();
		}
	}

	private void efetuarDeposito(Conta conta, BigDecimal valor) {
		if(valor.compareTo(BigDecimal.ZERO)>0) {
			Transacao transacao = new Transacao(valor, TipoTransacao.DEP, conta);
			transacaoRepository.save(transacao);
			conta.depositar(valor);
		}
	}

	private void efetuarSaque(Conta conta, BigDecimal valor) {
		Transacao transacao = new Transacao(valor, TipoTransacao.DEB, conta);
		transacaoRepository.save(transacao);
		conta.sacar(valor);
	}

	public Page<Transacao> historicoTransacoes(Long contaId, Pageable pageable) {
		return transacaoRepository.findByContaId(contaId, pageable);
	}

	private boolean saquePermitido(Conta conta, BigDecimal valor) {
		if (conta.getSaldo().compareTo(valor) >= 0) {
			return true;
		}
		return false;
	}

}
