package br.com.squad4.blue_bank.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.squad4.blue_bank.enums.TipoTelefone;

@Embeddable
public class TelefoneAgencia {

	private String numero;
	private String ddd;
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;
	
	public TelefoneAgencia(String numero, String ddd, TipoTelefone tipoTelefone) {
		this.numero = numero;
		this.ddd = ddd;
		this.tipoTelefone = tipoTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public String getDdd() {
		return ddd;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
		
}
