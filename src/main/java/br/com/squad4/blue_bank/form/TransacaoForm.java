package br.com.squad4.blue_bank.form;

import java.math.BigDecimal;

public class TransacaoForm {
	
	private Long contaId;
	private BigDecimal valor;
	
	public TransacaoForm() {
	}
	
	public TransacaoForm(Long contaId, BigDecimal valor) {
		this.contaId = contaId;
		this.valor = valor;
	}
	
	public Long getContaId() {
		return contaId;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

}
