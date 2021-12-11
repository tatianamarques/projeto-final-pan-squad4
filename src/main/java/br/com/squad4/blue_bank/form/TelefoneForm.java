package br.com.squad4.blue_bank.form;

import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.squad4.blue_bank.enums.TipoTelefone;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Telefone;
import br.com.squad4.blue_bank.utils.Formatacoes;

public class TelefoneForm {
	
	@NotNull
	@NotBlank
	@Size(min = 2,max = 3)
	private String ddd;
	@NotNull
	@NotBlank
	@Size(min = 8,max = 15)
	private String numero;
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;
	private Long idCliente;	
	
	public TelefoneForm() {
	}
		
	public TelefoneForm(String ddd, String numero, TipoTelefone tipoTelefone) {
		this.ddd = ddd;
		this.numero = Formatacoes.retirarPontosHifen(numero);
		this.tipoTelefone = tipoTelefone;
	}

	public TelefoneForm(String ddd, String numero, TipoTelefone tipoTelefone, Long idCliente) {
		this.ddd = ddd;
		this.numero = Formatacoes.retirarPontosHifen(numero);
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
			return Optional.of(new Telefone(this.ddd, Formatacoes.retirarPontosHifen(this.numero), this.tipoTelefone,cliente.get()));
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

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
}
