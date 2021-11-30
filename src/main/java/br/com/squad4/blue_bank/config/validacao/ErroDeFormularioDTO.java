package br.com.squad4.blue_bank.config.validacao;

public class ErroDeFormularioDTO {
	
	private String campo;
	private String erro;
	
	public ErroDeFormularioDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	

}
