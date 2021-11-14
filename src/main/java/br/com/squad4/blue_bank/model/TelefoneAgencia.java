package br.com.squad4.blue_bank.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.squad4.blue_bank.enums.TipoTelefone;

@Embeddable
public class TelefoneAgencia {

	private String numeroTelefone;
	private String ddd;
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;
	
	public TelefoneAgencia(String numero, String ddd, TipoTelefone tipoTelefone) {
		this.numeroTelefone = numero;
		this.ddd = ddd;
		this.tipoTelefone = tipoTelefone;
	}

	public String getNumero() {
		return numeroTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
		
}
