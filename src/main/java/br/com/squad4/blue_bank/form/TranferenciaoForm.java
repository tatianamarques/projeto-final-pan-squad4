package br.com.squad4.blue_bank.form;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TranferenciaoForm {
	
	@NotBlank
	@NotNull
	private Long idContaDeposito;
	@NotBlank
	@NotNull
	private Long idContaSaque;
	@Min(value = 0)
	@Positive
	private BigDecimal valor;
	
	public TranferenciaoForm() {
	}
	
	public TranferenciaoForm(Long idContaDeposito, Long idContaSaque, BigDecimal valor) {
		this.idContaDeposito = idContaDeposito;
		this.idContaSaque = idContaSaque;
		this.valor = valor;
	}

	public Long getIdContaDeposito() {
		return idContaDeposito;
	}

	public Long getIdContaSaque() {
		return idContaSaque;
	}

	public BigDecimal getValor() {
		return valor;
	}
	

}
