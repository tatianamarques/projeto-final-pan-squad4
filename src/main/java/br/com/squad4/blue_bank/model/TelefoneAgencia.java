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
	
	public TelefoneAgencia(String ddd, String numero, TipoTelefone tipoTelefone) {
		this.ddd = ddd;
		this.numeroTelefone = numero;
		this.tipoTelefone = tipoTelefone;
	}

	public TelefoneAgencia(){}

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
