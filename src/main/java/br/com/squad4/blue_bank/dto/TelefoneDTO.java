package br.com.squad4.blue_bank.dto;
import java.util.List;
import java.util.stream.Collectors;
import br.com.squad4.blue_bank.enums.TipoTelefone;
import br.com.squad4.blue_bank.model.Telefone;
import br.com.squad4.blue_bank.utils.Formatacoes;
public class TelefoneDTO {
	private String ddd;
	private String numero;
	private TipoTelefone tipoTelefone;
	
	
	public TelefoneDTO() {
	}
	
	public TelefoneDTO(Telefone telefone) {
		this.ddd = telefone.getDdd();
		if(telefone.getTipoTelefone() == TipoTelefone.CELULAR) {
			this.numero = Formatacoes.mascaraCelular(telefone.getNumero());			
		}else {
			this.numero = Formatacoes.mascaraTelefone(telefone.getNumero());	
		}
		this.tipoTelefone = telefone.getTipoTelefone();
	}
	
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	public static List<TelefoneDTO> listaTelefoneDTO(List<Telefone> telefones){
		return telefones.stream().map(TelefoneDTO::new).collect(Collectors.toList());
	}
	
}