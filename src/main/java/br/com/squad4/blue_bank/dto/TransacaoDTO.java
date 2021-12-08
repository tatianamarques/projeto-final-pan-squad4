package br.com.squad4.blue_bank.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.squad4.blue_bank.model.Transacao;

public class TransacaoDTO {
	
	private LocalDate data;
	private BigDecimal valor;
	private String conta;
	private String tipoTransacao;
	
	public TransacaoDTO() {
	}	

	public TransacaoDTO(Transacao transacao) {
		this.data = transacao.getData();
		this.valor = transacao.getValor();
		this.conta = transacao.getConta().getNumero();
		this.tipoTransacao = transacao.getTipoTransacao().getDescricao();
	}



	public LocalDate getData() {
		return data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getConta() {
		return conta;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public static Page<TransacaoDTO> converterLista(Page<Transacao> historico) {
		return historico.map(TransacaoDTO::new);
	}
	
	

}
