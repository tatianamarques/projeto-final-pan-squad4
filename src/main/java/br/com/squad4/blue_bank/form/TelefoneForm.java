package br.com.squad4.blue_bank.form;

import java.util.Optional;

import br.com.squad4.blue_bank.enums.TipoTelefone;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Telefone;

public class TelefoneForm {
	
	private String ddd;
	private String numero;
	private TipoTelefone tipoTelefone;
	private Long idCliente;	
	
	public TelefoneForm() {
	}
		
	public TelefoneForm(String ddd, String numero, TipoTelefone tipoTelefone) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipoTelefone = tipoTelefone;
	}

	public TelefoneForm(String ddd, String numero, TipoTelefone tipoTelefone, Long idCliente) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipoTelefone = tipoTelefone;
		this.idCliente = idCliente;
	}
	
	

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public Telefone toModel() {
		return new Telefone(this.ddd,this.numero,this.tipoTelefone);
	}
	
	public Optional<Telefone> toModel (Optional<Cliente> cliente) {

		if (cliente.isPresent()) {
			return Optional.of(new Telefone(this.ddd, this.numero, this.tipoTelefone,cliente.get()));
		}
		return Optional.empty();

	}
	
	public Long getIdCliente() {
		return idCliente;
	}

	@Override
	public String toString() {
		return "TelefoneForm [ddd=" + ddd + ", numero=" + numero + ", tipoTelefone=" + tipoTelefone +"]";
	}
	
	

}
